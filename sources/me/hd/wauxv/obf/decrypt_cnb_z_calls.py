#!/usr/bin/env python3
"""
Static deobfuscation script for WeChat Xposed module
Decrypts all cnb.z() calls and replaces them with string literals
"""

import re
import sys
from pathlib import Path

# --- Precision Helpers ---


def to_int64(n):
    n &= 0xFFFFFFFFFFFFFFFF
    return n - 0x10000000000000000 if n >= 0x8000000000000000 else n


def to_int32(n):
    n &= 0xFFFFFFFF
    return n - 0x100000000 if n >= 0x80000000 else n


def to_int16(n):
    n &= 0xFFFF
    return n - 0x10000 if n >= 0x8000 else n


def l_ushr(n, shift):
    """Java >>> for 64-bit longs"""
    return (n & 0xFFFFFFFFFFFFFFFF) >> (shift & 63)


def i_ushr(n, shift):
    """Java >>> for 32-bit ints (used when shorts are promoted)"""
    return (n & 0xFFFFFFFF) >> (shift & 31)


def l_mul(a, b):
    """Java long multiplication overflow"""
    return to_int64(a * b)


# --- Fixed Logic ---


def ab(j):
    # Java extracts shorts (signed 16-bit)
    s = to_int16(j & 0xFFFF)
    s2 = to_int16(l_ushr(j, 16) & 0xFFFF)

    s3 = to_int16(s + s2)
    s4 = to_int16(s2 ^ s)

    # Part A (Bits 16-31): (short) ((s4 >>> 22) | (s4 << 10))
    part_a = to_int16(i_ushr(s4, 22) | (s4 << 10))

    # Part B (Bits 32-47): (short) (((short) ((s3 >>> 23) | (s3 << 9))) + s)
    part_b = to_int16(to_int16(i_ushr(s3, 23) | (s3 << 9)) + s)

    # Part C (Bits 0-15): (short) (((short) (((short) ((s << 13) | (s >>> 19))) ^ s4)) ^ (s4 << 5))
    term_c = to_int16(i_ushr(s, 19) | (s << 13))
    part_c = to_int16(to_int16(term_c ^ s4) ^ (s4 << 5))

    # CRITICAL: Java Assembly with Sign Extension
    # Java: ((((long) A) | (((long) B) << 16)) << 16) | ((long) C)
    # We use to_int64() on the shorts to mimic Java's sign extension
    val = to_int64(to_int64(part_a) | (to_int64(part_b) << 16))
    res = to_int64((val << 16) | to_int64(part_c))

    return res


def z(j2, string_array):
    j2 = to_int64(j2)
    j3 = j2 & 0xFFFFFFFF

    # j3 is unsigned 32-bit, so j3 >>> 33 is always 0 in Java
    j4 = l_mul(j3, 7109453100751455733)

    # Second mix
    j_mix = l_mul((j4 ^ l_ushr(j4, 28)), -3808689974395783757)
    jAb = ab(l_ushr(j_mix, 32))

    j5 = l_ushr(jAb, 32) & 0xFFFF
    jAb2 = ab(jAb)

    # Calculate index i2
    # The mask -65536 in Java (int) promoted to long is 0xFFFFFFFFFFFF0000
    i2 = to_int32((l_ushr(j2, 32) ^ j5) ^ (l_ushr(jAb2, 16) & 0xFFFFFFFFFFFF0000))

    jAb3 = ab(jAb2)

    # Java-style truncated division
    def get_char(idx):
        row = int(idx / 8191)
        col = int(idx % 8191)
        return ord(string_array[row][col])

    try:
        jCharAt = jAb3 ^ (get_char(i2) << 32)
        length = int(l_ushr(jCharAt, 32) & 0xFFFF)

        result = []
        for i in range(length):
            idx = i2 + i + 1
            jCharAt = to_int64(ab(jCharAt) ^ (get_char(idx) << 32))
            decrypted_char = int(l_ushr(jCharAt, 32) & 0xFFFF)
            result.append(chr(decrypted_char))

        return "".join(result)
    except Exception as e:
        return f"[DECRYPT_ERROR: {e}]"


def parse_string_array(cnb_path):
    """
    Parse the string array from cnb.java line 37

    Args:
        cnb_path: Path to cnb.java file

    Returns:
        List of strings from the array
    """
    with open(cnb_path, "r", encoding="utf-8", errors="surrogateescape") as f:
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
    with open(java_path, "r", encoding="utf-8", errors="surrogateescape") as f:
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
        with open(java_path, "w", encoding="utf-8", errors="surrogateescape") as f:
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
