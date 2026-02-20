package me.hd.wauxv.obf;

import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dnr extends dnq {
    public static byte[] bh(String str) {
        throwIfVar1IsNull(str, "<this>");
        byte[] bytes = str.getBytes(uj.a);
        throwIfVar1IsNull(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean ifVar1EndsWithVar2(String str, String str2) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str2, "suffix");
        return str.endsWith(str2);
    }

    public static boolean bj(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static void bk() {
        throwIfVar1IsNull(String.CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
    }

    public static boolean bl(int i, int i2, int i3, String str, String str2, boolean z) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static String bm(int i, String str) {
        throwIfVar1IsNull(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i
                    + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = str.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(str.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append((CharSequence) str);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        throwIfVar1IsNull(string);
        return string;
    }

    public static String bn(String str, char c, char c2) {
        throwIfVar1IsNull(str, "<this>");
        String strReplace = str.replace(c, c2);
        throwIfVar1IsNull(strReplace, "replace(...)");
        return strReplace;
    }

    public static String bo(String str, String str2, String str3) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str3, "newValue");
        int iAf = StringsKt.af(str, str2, 0, false);
        if (iAf < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i2 = 0;
        do {
            sb.append((CharSequence) str, i2, iAf);
            sb.append(str3);
            i2 = iAf + length;
            if (iAf >= str.length()) {
                break;
            }
            iAf = StringsKt.af(str, str2, iAf + i, false);
        } while (iAf > 0);
        sb.append((CharSequence) str, i2, str.length());
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }

    public static boolean bp(String str, String str2, boolean z) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str2, "prefix");
        return !z ? str.startsWith(str2) : bl(0, 0, str2.length(), str, str2, z);
    }

    public static boolean bq(String str, boolean z, int i, String str2) {
        throwIfVar1IsNull(str, "<this>");
        return !z ? str.startsWith(str2, i) : bl(i, 0, str2.length(), str, str2, z);
    }
}
