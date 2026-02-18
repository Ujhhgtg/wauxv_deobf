#!/usr/bin/env python3
"""
Static deobfuscation script for WeChat Xposed module
Decrypts all cnb.z() calls and replaces them with string literals
"""

import re
import sys
from pathlib import Path

# Constants
PAYLOAD_SHORT_MAX = 65535


def to_signed_long(n):
    """Convert to Java signed long (64-bit)"""
    n = n & 0xFFFFFFFFFFFFFFFF
    if n >= 0x8000000000000000:
        n -= 0x10000000000000000
    return n


def to_signed_short(n):
    """Convert to Java signed short (16-bit)"""
    n = n & 0xFFFF
    if n >= 0x8000:
        n -= 0x10000
    return n


def unsigned_right_shift(n, shift):
    """Java unsigned right shift (>>>)"""
    if n < 0:
        n = (n + 0x10000000000000000) & 0xFFFFFFFFFFFFFFFF
    return (n >> shift) & 0xFFFFFFFFFFFFFFFF


def ab(j):
    """Port of cnh.ab() - bitwise mixing function"""
    j = to_signed_long(j)

    # Extract 16-bit parts
    s = to_signed_short(j & PAYLOAD_SHORT_MAX)
    s2 = to_signed_short(unsigned_right_shift(j, 16) & PAYLOAD_SHORT_MAX)

    # Mix operations
    s3 = to_signed_short(s + s2)
    s4 = to_signed_short(s2 ^ s)

    # Complex bit operations with rotations
    part1 = to_signed_short((unsigned_right_shift(s4, 22) | ((s4 << 10) & 0xFFFF)))

    temp_s3_rot = to_signed_short((unsigned_right_shift(s3, 23) | ((s3 << 9) & 0xFFFF)))
    part2 = to_signed_short(temp_s3_rot + s)

    temp_s_rot = to_signed_short(((s << 13) & 0xFFFF) | unsigned_right_shift(s, 19))
    part3 = to_signed_short(temp_s_rot ^ s4)
    part4 = to_signed_short(part3 ^ ((s4 << 5) & 0xFFFF))

    # Pack back into 64-bit long
    result = (((part2 & 0xFFFF) | ((part1 & 0xFFFF) << 16)) << 16) | (part4 & 0xFFFF)

    return to_signed_long(result)


def z(j2, string_array):
    """
    Port of cnb.z() - string deobfuscation function

    Args:
        j2: encrypted long value
        string_array: array of encrypted strings

    Returns:
        Decrypted string
    """
    j2 = to_signed_long(j2)

    # Initial mixing
    j3 = j2 & 0xFFFFFFFF
    j4 = to_signed_long((j3 ^ unsigned_right_shift(j3, 33)) * 7109453100751455733)

    # More mixing with negative multiplier
    temp = to_signed_long(
        (j4 ^ unsigned_right_shift(j4, 28)) * to_signed_long(-3808689974395783757)
    )
    jAb = ab(unsigned_right_shift(temp, 32))

    # Calculate index
    j5 = unsigned_right_shift(jAb, 32) & PAYLOAD_SHORT_MAX
    jAb2 = ab(jAb)

    i2 = int(
        (unsigned_right_shift(j2, 32) ^ j5)
        ^ (unsigned_right_shift(jAb2, 16) & 0xFFFFFFFFFFFF0000)
    )
    i2 = i2 & 0xFFFFFFFF  # Keep as 32-bit int

    # Get character from string array
    jAb3 = ab(jAb2)

    try:
        char_val = ord(string_array[i2 // 8191][i2 % 8191])
    except (IndexError, KeyError):
        return f"[DECRYPT_ERROR: index {i2} out of bounds]"

    jCharAt = to_signed_long(jAb3 ^ (char_val << 32))

    # Extract length
    i3 = int(unsigned_right_shift(jCharAt, 32) & PAYLOAD_SHORT_MAX)

    if i3 > 10000:  # Sanity check
        return f"[DECRYPT_ERROR: invalid length {i3}]"

    # Decrypt characters
    result = []
    for i4 in range(i3):
        i5 = i2 + i4 + 1

        try:
            char_val = ord(string_array[i5 // 8191][i5 % 8191])
        except (IndexError, KeyError):
            return f"[DECRYPT_ERROR: char index {i5} out of bounds]"

        jCharAt = to_signed_long(ab(jCharAt) ^ (char_val << 32))
        decrypted_char = int(unsigned_right_shift(jCharAt, 32) & PAYLOAD_SHORT_MAX)

        if decrypted_char > 0xFFFF:
            result.append("?")
        else:
            result.append(chr(decrypted_char))

    return "".join(result)


def parse_string_array(cnb_path):
    """
    Parse the string array from cnb.java line 37

    Args:
        cnb_path: Path to cnb.java file

    Returns:
        List of strings from the array
    """
    with open(cnb_path, "r", encoding="utf-8") as f:
        content = f.read()

    # Find the string array declaration: public static final String[] i = {...}
    pattern = r"public\s+static\s+final\s+String\[\]\s+i\s*=\s*\{([^}]+)\}"
    match = re.search(pattern, content, re.DOTALL)

    if not match:
        raise ValueError("Could not find string array 'i' in cnb.java")

    array_content = match.group(1)

    # Extract individual strings
    # They are in format: "string1", "string2", ...
    strings = []
    string_pattern = r'"([^"\\]*(?:\\.[^"\\]*)*)"'

    for match in re.finditer(string_pattern, array_content):
        string_val = match.group(1)
        # Unescape Java string escapes
        string_val = string_val.encode("utf-8").decode("unicode_escape")
        strings.append(string_val)

    return strings


def find_cnb_z_calls(java_content):
    """
    Find all cnb.z() calls in Java content, supporting decimal and hex
    """
    # Updated pattern: matches optional minus, then either 0x... or standard digits
    # It also handles the 'L' or 'l' suffix flexibly
    pattern = r"cnb\.z\((-?(?:0x[0-9a-fA-F]+|\d+))[Ll]?\)"

    matches = []
    for match in re.finditer(pattern, java_content):
        long_str = match.group(1)

        try:
            # Using base 0 tells Python to automatically detect the base:
            # '0x...' becomes hex, '123' becomes decimal.
            long_val = int(long_str, 0)
            matches.append((match, long_val))
        except ValueError:
            print(f"  Warning: Could not parse integer value: {long_str}")

    return matches


def deobfuscate_file(java_path, string_array):
    """
    Deobfuscate a single Java file by replacing cnb.z() calls

    Args:
        java_path: Path to Java file
        string_array: Decryption string array

    Returns:
        Number of replacements made
    """
    with open(java_path, "r", encoding="utf-8") as f:
        content = f.read()

    # original_content = content
    matches = find_cnb_z_calls(content)

    if not matches:
        return 0

    # Replace in reverse order to maintain positions
    matches.reverse()

    replacements = 0
    for match, long_val in matches:
        try:
            decrypted = z(long_val, string_array)

            # Escape special characters for Java string
            decrypted_escaped = (
                decrypted.replace("\\", "\\\\")
                .replace('"', '\\"')
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t")
            )

            # Create replacement with comment
            original_call = match.group(0)
            replacement = f'"{decrypted_escaped}" /* {original_call} */'

            # Replace in content
            start, end = match.span()
            content = content[:start] + replacement + content[end:]

            replacements += 1
            print(f'  {original_call} -> "{decrypted}"')

        except Exception as e:
            print(f"  ERROR decrypting {match.group(0)}: {e}")

    # Write back if changes were made
    if replacements > 0:
        with open(java_path, "w", encoding="utf-8") as f:
            f.write(content)

    return replacements


def main():
    if len(sys.argv) < 2:
        print("Usage: python deobfuscate.py <directory>")
        print("\nExpects:")
        print("  - <directory>/cnb.java with string array on line 37")
        print("  - Other .java files in the directory with cnb.z() calls")
        sys.exit(1)

    directory = Path(sys.argv[1])
    cnb_path = Path(sys.argv[2])

    if not directory.is_dir():
        print(f"Error: {directory} is not a directory")
        sys.exit(1)

    cnb_candidates = list(directory.rglob("cnb.java"))
    if not cnb_candidates:
        print(f"Error: cnb.java not found in {directory} or subdirectories")
        sys.exit(1)

    cnb_path = cnb_candidates[0]
    if len(cnb_candidates) > 1:
        print(f"Warning: Multiple cnb.java files found, using {cnb_path}")

    print(f"Using string array from: {cnb_path}")
    print("Parsing string array from cnb.java...")
    try:
        string_array = parse_string_array(cnb_path)
        print(f"Loaded {len(string_array)} encrypted strings")
    except Exception as e:
        print(f"Error parsing string array: {e}")
        sys.exit(1)

    # CHANGED: Find all Java files recursively
    java_files = list(directory.rglob("*.java"))
    print(f"\nFound {len(java_files)} Java files (recursive)")

    total_replacements = 0
    files_modified = 0

    for java_file in java_files:
        if java_file.name == "cnb.java":
            continue  # Skip the string array file itself

        # Show relative path for better readability
        rel_path = java_file.relative_to(directory)
        print(f"\nProcessing {rel_path}...")
        replacements = deobfuscate_file(java_file, string_array)

        if replacements > 0:
            total_replacements += replacements
            files_modified += 1

    print(f"\n{'=' * 60}")
    print("Deobfuscation complete!")
    print(f"Files modified: {files_modified}")
    print(f"Total replacements: {total_replacements}")
    print(f"{'=' * 60}")


if __name__ == "__main__":
    main()
