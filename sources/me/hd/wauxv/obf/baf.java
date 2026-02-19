package me.hd.wauxv.obf;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class baf {
    public static final axz a = new axz(1);

    /* JADX WARN: Found duplicated region for block: B:101:0x017c */
    /* JADX WARN: Found duplicated region for block: B:102:0x017e A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:103:0x0180 */
    /* JADX WARN: Found duplicated region for block: B:104:0x0183 */
    /* JADX WARN: Found duplicated region for block: B:106:0x0187 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:107:0x0189 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:108:0x018b */
    /* JADX WARN: Found duplicated region for block: B:109:0x018e */
    /* JADX WARN: Found duplicated region for block: B:111:0x0192 */
    /* JADX WARN: Found duplicated region for block: B:114:0x0199 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:115:0x019b */
    /* JADX WARN: Found duplicated region for block: B:121:0x01a9 */
    /* JADX WARN: Found duplicated region for block: B:122:0x01b4 */
    /* JADX WARN: Found duplicated region for block: B:124:0x01b9 */
    /* JADX WARN: Found duplicated region for block: B:125:0x01bb */
    /* JADX WARN: Found duplicated region for block: B:128:0x01c1 */
    /* JADX WARN: Found duplicated region for block: B:130:0x01cd */
    /* JADX WARN: Found duplicated region for block: B:131:0x01d0 */
    /* JADX WARN: Found duplicated region for block: B:133:0x01db */
    /* JADX WARN: Found duplicated region for block: B:139:0x01ed */
    /* JADX WARN: Found duplicated region for block: B:141:0x01f1 */
    /* JADX WARN: Found duplicated region for block: B:144:0x01fe */
    /* JADX WARN: Found duplicated region for block: B:146:0x0207 */
    /* JADX WARN: Found duplicated region for block: B:153:0x0222 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:154:0x0224 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:157:0x0235 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:158:0x0237 */
    /* JADX WARN: Found duplicated region for block: B:214:0x025d A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:87:0x015a A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:90:0x0160 */
    /* JADX WARN: Found duplicated region for block: B:92:0x0166 */
    /* JADX WARN: Found duplicated region for block: B:94:0x016e */
    /* JADX WARN: Found duplicated region for block: B:98:0x0178 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v51 */
    public static final bgs b(String str, String str2, int i, String str3, String str4, bgt bgtVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        boolean z2;
        boolean z3;
        int i9;
        boolean z4;
        boolean z5;
        int i10;
        int i11;
        boolean z6;
        int i12;
        String str5 = str;
        int i13 = i;
        throwIfVar1IsNull(str2, "patternLow");
        throwIfVar1IsNull(str4, "wordLow");
        int length = str5.length() > 32 ? 32 : str5.length();
        int length2 = str3.length() <= 31 ? str3.length() : 31;
        if (i13 >= length || length2 <= 0 || length - i13 > length2) {
            return null;
        }
        dey deyVar = (dey) a.get();
        if (deyVar == null) {
            throw new IllegalStateException("Not Found Scratch");
        }
        int[] iArr = deyVar.b;
        int[] iArr2 = deyVar.a;
        int[][] iArr3 = deyVar.e;
        int[][] iArr4 = deyVar.d;
        int[][] iArr5 = deyVar.c;
        SomeStaticHelpers.m(iArr2);
        SomeStaticHelpers.m(iArr);
        for (int i14 = 0; i14 < 32; i14++) {
            SomeStaticHelpers.m(iArr5[i14]);
            SomeStaticHelpers.m(iArr4[i14]);
            SomeStaticHelpers.m(iArr3[i14]);
        }
        int i15 = i13;
        for (int i16 = 0; i15 < length && i16 < length2; i16++) {
            if (str2.charAt(i15) == str4.charAt(i16)) {
                iArr2[i15] = i16;
                i15++;
            }
        }
        if (i15 != length) {
            return null;
        }
        int i17 = length - 1;
        for (int i18 = length2 - 1; i17 >= i13 && i18 >= 0; i18--) {
            if (str2.charAt(i17) == str4.charAt(i18)) {
                iArr[i17] = i18;
                i17--;
            }
        }
        boolean[] zArr = { false };
        int i19 = i13;
        int i20 = 1;
        int i21 = 1;
        while (true) {
            int i22 = 3;
            if (i19 >= length) {
                int[][] iArr6 = iArr5;
                int i23 = 2;
                if (!zArr[0] && !bgtVar.b) {
                    return null;
                }
                int i24 = i20 - 1;
                int i25 = i21 - 1;
                bgs bgsVar = new bgs(iArr4[i24][i25]);
                int i26 = 0;
                int i27 = 0;
                int i28 = i25;
                int i29 = 1;
                while (i24 >= i29) {
                    int i30 = i28;
                    while (true) {
                        int i31 = iArr3[i24][i30];
                        i2 = i22;
                        if (i31 != i2) {
                            if (i31 != i23) {
                                i3 = 1;
                                break;
                            }
                            i30--;
                        } else {
                            i30 -= 2;
                        }
                        i3 = 1;
                        if (i30 < 1) {
                            break;
                        }
                        i22 = i2;
                        i23 = 2;
                    }
                    if (i26 > i3 && str2.charAt((i + i24) - i3) == str4.charAt(i28 - 1) && !e(i30 - 1, str3, str4)
                            && i26 + 1 > iArr6[i24][i30]) {
                        i30 = i28;
                    }
                    i26 = i30 == i28 ? i26 + 1 : i3;
                    if (i27 == 0) {
                        i27 = i30;
                    }
                    i24--;
                    i28 = i30 - 1;
                    bgsVar.c.add(Integer.valueOf(i28));
                    i29 = i3;
                    i22 = i2;
                    i23 = 2;
                }
                if (length2 == length) {
                    bgsVar.b += 2;
                }
                bgsVar.b -= i27 - length;
                return bgsVar;
            }
            int i32 = iArr2[i19];
            int[][] iArr7 = iArr5;
            int i33 = iArr[i19];
            int[] iArr8 = iArr;
            int i34 = i19 + 1;
            if (i34 < length) {
                i4 = i34;
                i5 = iArr8[i34];
            } else {
                i4 = i34;
                i5 = length2;
            }
            int i35 = i32 + 1;
            int[] iArr9 = iArr2;
            int i36 = i32;
            while (i36 < i5) {
                int i37 = i5;
                if (i36 <= i33) {
                    boolean z7 = iArr7[i20 + (-1)][i35 + (-1)] == 0;
                    i6 = i33;
                    if (str2.charAt(i19) == str4.charAt(i36)) {
                        if (i36 == i19 - i13) {
                            i11 = 0;
                            i7 = str5.charAt(i19) == str3.charAt(i36) ? 7 : 5;
                        } else {
                            if (!e(i36, str3, str4) || (i36 != 0 && e(i36 - 1, str3, str4))) {
                                if (!d(i36, str4) || (i36 != 0 && d(i36 - 1, str4))) {
                                    int i38 = i36 - 1;
                                    if (d(i38, str4) || f(i38, str4)) {
                                        i7 = 5;
                                    } else {
                                        i11 = 0;
                                        z6 = 1;
                                        i7 = 1;
                                    }
                                } else {
                                    i11 = 0;
                                    i7 = 5;
                                }
                                if (i7 > z6 && i19 == i13) {
                                    zArr[0] = z6;
                                }
                                if (i11 == 0) {
                                    if (!e(i36, str3, str4)) {
                                        int i39 = i36 - 1;
                                        i12 = (!d(i39, str4) || f(i39, str4)) ? 1 : 0;
                                    }
                                    i11 = i12;
                                }
                                if (i19 != i13) {
                                    i7 += z7 ? i11 != 0 ? 2 : 0 : i11 ^ 1;
                                } else if (i36 > 0) {
                                    i7 -= i11 != 0 ? 3 : 5;
                                }
                                if (i36 + 1 == length2) {
                                    i7 -= i11 != 0 ? 3 : 5;
                                }
                            } else {
                                i7 = str5.charAt(i19) == str3.charAt(i36) ? 7 : 5;
                            }
                            z6 = 1;
                            i11 = 1;
                            if (i7 > z6) {
                                zArr[0] = z6;
                            }
                            if (i11 == 0) {
                                if (!e(i36, str3, str4)) {
                                    int i392 = i36 - 1;
                                    if (d(i392, str4)) {
                                    }
                                }
                                i11 = i12;
                            }
                            if (i19 != i13) {
                                i7 += z7 ? i11 != 0 ? 2 : 0 : i11 ^ 1;
                            } else if (i36 > 0) {
                                i7 -= i11 != 0 ? 3 : 5;
                            }
                            if (i36 + 1 == length2) {
                                i7 -= i11 != 0 ? 3 : 5;
                            }
                        }
                        z6 = 1;
                        if (i7 > z6) {
                            zArr[0] = z6;
                        }
                        if (i11 == 0) {
                            if (!e(i36, str3, str4)) {
                                int i3922 = i36 - 1;
                                if (d(i3922, str4)) {
                                }
                            }
                            i11 = i12;
                        }
                        if (i19 != i13) {
                            i7 += z7 ? i11 != 0 ? 2 : 0 : i11 ^ 1;
                        } else if (i36 > 0) {
                            i7 -= i11 != 0 ? 3 : 5;
                        }
                        if (i36 + 1 == length2) {
                            i7 -= i11 != 0 ? 3 : 5;
                        }
                    }
                    if (i7 != Integer.MIN_VALUE) {
                        i8 = i7 + iArr4[i20 - 1][i35 - 1];
                        z = true;
                    } else {
                        z = false;
                        i8 = 0;
                    }
                    z2 = i36 > i32;
                    if (z2) {
                        int i40 = i35 - 1;
                        z3 = z;
                        i9 = iArr4[i20][i40] + (iArr7[i20][i40] > 0 ? -5 : 0);
                    } else {
                        z3 = z;
                        i9 = 0;
                    }
                    z4 = i36 <= i32 + 1 && iArr7[i20][i35 + (-1)] > 0;
                    if (z4) {
                        int i41 = i35 - 2;
                        z5 = z4;
                        i10 = iArr4[i20][i41] + (iArr7[i20][i41] <= 0 ? 0 : -5);
                    } else {
                        z5 = z4;
                        i10 = 0;
                    }
                    if (!z5 && ((!z2 || i10 >= i9) && (!z3 || i10 >= i8))) {
                        iArr4[i20][i35] = i10;
                        iArr3[i20][i35] = 3;
                        iArr7[i20][i35] = 0;
                    } else if (!z2 && (!z3 || i9 >= i8)) {
                        iArr4[i20][i35] = i9;
                        iArr3[i20][i35] = 2;
                        iArr7[i20][i35] = 0;
                    } else {
                        if (!z3) {
                            throw new IllegalStateException("not possible");
                        }
                        iArr4[i20][i35] = i8;
                        iArr3[i20][i35] = 1;
                        iArr7[i20][i35] = iArr7[i20 - 1][i35 - 1] + 1;
                    }
                    i35++;
                    i36++;
                    str5 = str;
                    i13 = i;
                    i5 = i37;
                    i33 = i6;
                } else {
                    i6 = i33;
                }
                i7 = Integer.MIN_VALUE;
                if (i7 != Integer.MIN_VALUE) {
                    i8 = i7 + iArr4[i20 - 1][i35 - 1];
                    z = true;
                } else {
                    z = false;
                    i8 = 0;
                }
                if (i36 > i32) {
                }
                if (z2) {
                    int i402 = i35 - 1;
                    z3 = z;
                    i9 = iArr4[i20][i402] + (iArr7[i20][i402] > 0 ? -5 : 0);
                } else {
                    z3 = z;
                    i9 = 0;
                }
                if (i36 <= i32 + 1) {
                }
                if (z4) {
                    int i412 = i35 - 2;
                    z5 = z4;
                    i10 = iArr4[i20][i412] + (iArr7[i20][i412] <= 0 ? 0 : -5);
                } else {
                    z5 = z4;
                    i10 = 0;
                }
                if (!z5) {
                    if (!z2) {
                        if (!z3) {
                            throw new IllegalStateException("not possible");
                        }
                        iArr4[i20][i35] = i8;
                        iArr3[i20][i35] = 1;
                        iArr7[i20][i35] = iArr7[i20 - 1][i35 - 1] + 1;
                    } else {
                        if (!z3) {
                            throw new IllegalStateException("not possible");
                        }
                        iArr4[i20][i35] = i8;
                        iArr3[i20][i35] = 1;
                        iArr7[i20][i35] = iArr7[i20 - 1][i35 - 1] + 1;
                    }
                } else if (!z2) {
                    if (!z3) {
                        throw new IllegalStateException("not possible");
                    }
                    iArr4[i20][i35] = i8;
                    iArr3[i20][i35] = 1;
                    iArr7[i20][i35] = iArr7[i20 - 1][i35 - 1] + 1;
                } else {
                    if (!z3) {
                        throw new IllegalStateException("not possible");
                    }
                    iArr4[i20][i35] = i8;
                    iArr3[i20][i35] = 1;
                    iArr7[i20][i35] = iArr7[i20 - 1][i35 - 1] + 1;
                }
                i35++;
                i36++;
                str5 = str;
                i13 = i;
                i5 = i37;
                i33 = i6;
            }
            i20++;
            str5 = str;
            i13 = i;
            i19 = i4;
            iArr5 = iArr7;
            iArr = iArr8;
            i21 = i35;
            iArr2 = iArr9;
        }
    }

    public static final bgs c(String str, String str2, String str3, int i, String str4) {
        char cCharAt;
        char cCharAt2;
        throwIfVar1IsNull(str2, "lowPattern");
        throwIfVar1IsNull(str4, "lowWord");
        bgt bgtVar = bgt.a;
        bgs bgsVarB = b(str, str2, i, str3, str4, bgtVar);
        if (str.length() >= 3) {
            int length = str.length() - 1;
            if (7 <= length) {
                length = 7;
            }
            int i2 = i + 1;
            while (i2 < length) {
                int i3 = i2 + 1;
                String str5 = null;
                if (i3 < str.length() && (cCharAt = str.charAt(i2)) != (cCharAt2 = str.charAt(i3))) {
                    String strAz = dnj.az(i2, str);
                    String strSubstring = str.substring(i2 + 2);
                    throwIfVar1IsNull(strSubstring, "substring(...)");
                    str5 = strAz + cCharAt2 + cCharAt + strSubstring;
                }
                String str6 = str5;
                if (str6 != null) {
                    String lowerCase = str6.toLowerCase(Locale.ROOT);
                    throwIfVar1IsNull(lowerCase, "toLowerCase(...)");
                    bgs bgsVarB2 = b(str6, lowerCase, i, str3, str4, bgtVar);
                    if (bgsVarB2 != null) {
                        int i4 = bgsVarB2.b - 3;
                        bgsVarB2.b = i4;
                        if (bgsVarB == null || i4 > bgsVarB.b) {
                            bgsVarB = bgsVarB2;
                        }
                    }
                }
                i2 = i3;
            }
        }
        return bgsVarB;
    }

    /*
     * JADX WARN: Found duplicated region for block: B:34:0x004f A[FALL_THROUGH,
     * RETURN]
     */
    public static final boolean d(int i, String str) {
        throwIfVar1IsNull(str, "value");
        if (i < 0 || i >= str.length()) {
            return false;
        }
        int iCodePointAt = str.codePointAt(i);
        if (iCodePointAt != 32 && iCodePointAt != 34 && iCodePointAt != 36 && iCodePointAt != 58 && iCodePointAt != 60
                && iCodePointAt != 62 && iCodePointAt != 95 && iCodePointAt != 123 && iCodePointAt != 125) {
            switch (iCodePointAt) {
                default:
                    switch (iCodePointAt) {
                        default:
                            switch (iCodePointAt) {
                                case 91:
                                case 92:
                                case 93:
                                    break;
                                default:
                                    int[] iArr = cib.a;
                                    return iCodePointAt >= 126976 && iCodePointAt <= 129791;
                            }
                        case 45:
                        case 46:
                        case 47:
                            return true;
                    }
                case 39:
                case 40:
                case 41:
                    return true;
            }
        }
        return true;
    }

    public static final boolean e(int i, String str, String str2) {
        throwIfVar1IsNull(str2, "wordLow");
        return str.charAt(i) != str2.charAt(i);
    }

    public static final boolean f(int i, String str) {
        throwIfVar1IsNull(str, "value");
        if (i < 0 || i >= str.length()) {
            return false;
        }
        char cCharAt = str.charAt(i);
        return cCharAt == '\t' || cCharAt == ' ';
    }
}
