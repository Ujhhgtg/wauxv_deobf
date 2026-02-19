package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqb implements btd {
    public static final bqb b = new bqb();
    public static final cvo d = new cvo("kotlin.time.Instant", cvm.s);

    /* JADX WARN: Found duplicated region for block: B:196:0x048c */
    /* JADX WARN: Found duplicated region for block: B:197:0x04a2 */
    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        int i;
        bpy bpyVarAp;
        bpy bpyVarAp2;
        bpy bpyVarAp3;
        bpy bpyVarAp4;
        int i2;
        int iC;
        int i3;
        int i4;
        int i5;
        long j;
        char cCharAt;
        IConvertableToInstant bqaVarAq;
        char cCharAt2;
        Instant instantVar = Instant.a;
        String strV = ajtVar.v();
        throwIfVar1IsNull(strV, "input");
        if (strV.length() == 0) {
            bqaVarAq = new bpy("An empty string is not a valid Instant", strV);
        } else {
            char cCharAt3 = strV.charAt(0);
            if (cCharAt3 == '+' || cCharAt3 == '-') {
                i = 1;
            } else {
                i = 0;
                cCharAt3 = ' ';
            }
            int iCharAt = 0;
            int i6 = i;
            while (i6 < strV.length() && '0' <= (cCharAt2 = strV.charAt(i6)) && cCharAt2 < ':') {
                iCharAt = (iCharAt * 10) + (strV.charAt(i6) - '0');
                i6++;
            }
            int i7 = i6 - i;
            if (i7 > 10) {
                bqaVarAq = FastKV.aq(strV, "Expected at most 10 digits for the year number, got " + i7 + " digits");
            } else if (i7 == 10 && KotlinHelpers.r(strV.charAt(i), 50) >= 0) {
                bqaVarAq = FastKV.aq(strV,
                        "Expected at most 9 digits for the year number or year 1000000000, got " + i7 + " digits");
            } else if (i7 < 4) {
                bqaVarAq = FastKV.aq(strV, "The year number must be padded to 4 digits, got " + i7 + " digits");
            } else if (cCharAt3 == '+' && i7 == 4) {
                bqaVarAq = FastKV.aq(strV,
                        "The '+' sign at the start is only valid for year numbers longer than 4 digits");
            } else if (cCharAt3 != ' ' || i7 == 4) {
                if (cCharAt3 == '-') {
                    iCharAt = -iCharAt;
                }
                int i8 = i6 + 16;
                if (strV.length() < i8) {
                    bqaVarAq = FastKV.aq(strV, "The input string is too short");
                } else {
                    bpy bpyVarAp5 = FastKV.ap(strV, "'-'", i6, new blx(18));
                    if (bpyVarAp5 != null) {
                        bqaVarAq = bpyVarAp5;
                    } else {
                        bpyVarAp = FastKV.ap(strV, "'-'", i6 + 3, new blx(19));
                        if (bpyVarAp == null && (bpyVarAp2 = FastKV.ap(strV, "'T' or 't'", i6 + 6, new blx(20))) == null
                                && (bpyVarAp3 = FastKV.ap(strV, "':'", i6 + 9, new blx(21))) == null
                                && (bpyVarAp4 = FastKV.ap(strV, "':'", i6 + 12, new blx(22))) == null) {
                            bqaVarAq = bpyVarAp;
                            bqaVarAq = bpyVarAp2;
                            bqaVarAq = bpyVarAp3;
                            bqaVarAq = bpyVarAp4;
                            int[] iArr = FastKV.i;
                            for (int i9 = 0; i9 < 10; i9++) {
                                bpy bpyVarAp6 = FastKV.ap(strV, "an ASCII digit", iArr[i9] + i6, new blx(23));
                                if (bpyVarAp6 != null) {
                                    bqaVarAq = bpyVarAp6;
                                }
                            }
                            int iAr = FastKV.ar(i6 + 1, strV);
                            int iAr2 = FastKV.ar(i6 + 4, strV);
                            int iAr3 = FastKV.ar(i6 + 7, strV);
                            int iAr4 = FastKV.ar(i6 + 10, strV);
                            int iAr5 = FastKV.ar(i6 + 13, strV);
                            int i10 = i6 + 15;
                            if (strV.charAt(i10) == '.') {
                                i10 = i8;
                                int iCharAt2 = 0;
                                while (i10 < strV.length() && '0' <= (cCharAt = strV.charAt(i10)) && cCharAt < ':') {
                                    iCharAt2 = (iCharAt2 * 10) + (strV.charAt(i10) - '0');
                                    i10++;
                                }
                                int i11 = i10 - i8;
                                if (1 > i11 || i11 >= 10) {
                                    bqaVarAq = FastKV.aq(strV,
                                            "1..9 digits are supported for the fraction of the second, got " + i11
                                                    + " digits");
                                } else {
                                    i2 = iCharAt2 * FastKV.h[9 - i11];
                                }
                            } else {
                                i2 = 0;
                            }
                            if (i10 >= strV.length()) {
                                bqaVarAq = FastKV.aq(strV, "The UTC offset at the end of the string is missing");
                            } else {
                                char cCharAt4 = strV.charAt(i10);
                                if (cCharAt4 == '+' || cCharAt4 == '-') {
                                    int length = strV.length() - i10;
                                    if (length > 9) {
                                        bqaVarAq = FastKV.aq(strV,
                                                "The UTC offset string \""
                                                        + FastKV.bg(16, strV.subSequence(i10, strV.length()).toString())
                                                        + "\" is too long");
                                    } else if (length % 3 != 0) {
                                        bqaVarAq = FastKV.aq(strV, "Invalid UTC offset string \""
                                                + strV.subSequence(i10, strV.length()).toString() + '\"');
                                    } else {
                                        int[] iArr2 = FastKV.j;
                                        int i12 = 0;
                                        for (int i13 = 2; i12 < i13; i13 = 2) {
                                            int i14 = i10 + iArr2[i12];
                                            if (i14 >= strV.length()) {
                                                break;
                                            }
                                            if (strV.charAt(i14) != ':') {
                                                StringBuilder sbR = yg.concatVar213(i14, "Expected ':' at index ", ", got '");
                                                sbR.append(strV.charAt(i14));
                                                sbR.append('\'');
                                                bqaVarAq = FastKV.aq(strV, sbR.toString());
                                            } else {
                                                i12++;
                                            }
                                        }
                                        int[] iArr3 = FastKV.k;
                                        int i15 = 0;
                                        while (i15 < 6 && (i3 = iArr3[i15] + i10) < strV.length()) {
                                            char cCharAt5 = strV.charAt(i3);
                                            int[] iArr4 = iArr3;
                                            if ('0' > cCharAt5 || cCharAt5 >= ':') {
                                                StringBuilder sbR2 = yg.concatVar213(i3, "Expected an ASCII digit at index ",
                                                        ", got '");
                                                sbR2.append(strV.charAt(i3));
                                                sbR2.append('\'');
                                                bqaVarAq = FastKV.aq(strV, sbR2.toString());
                                            } else {
                                                i15++;
                                                iArr3 = iArr4;
                                            }
                                        }
                                        int iAr6 = FastKV.ar(i10 + 1, strV);
                                        int iAr7 = length > 3 ? FastKV.ar(i10 + 4, strV) : 0;
                                        int iAr8 = length > 6 ? FastKV.ar(i10 + 7, strV) : 0;
                                        if (iAr7 > 59) {
                                            bqaVarAq = FastKV.aq(strV,
                                                    "Expected offset-minute-of-hour in 0..59, got " + iAr7);
                                        } else if (iAr8 > 59) {
                                            bqaVarAq = FastKV.aq(strV,
                                                    "Expected offset-second-of-minute in 0..59, got " + iAr8);
                                        } else if (iAr6 <= 17 || (iAr6 == 18 && iAr7 == 0 && iAr8 == 0)) {
                                            iC = bjs.c(iAr7, 60, iAr6 * 3600, iAr8) * (cCharAt4 == '-' ? -1 : 1);
                                            if (1 > iAr && iAr < 13) {
                                                if (1 > iAr2) {
                                                    StringBuilder sbQ = yg.concatVar31425(iAr, iCharAt,
                                                            "Expected a valid day-of-month for month ", " of year ",
                                                            ", got ");
                                                    sbQ.append(iAr2);
                                                    bqaVarAq = FastKV.aq(strV, sbQ.toString());
                                                } else {
                                                    int i16 = iCharAt & 3;
                                                    if (iAr2 > (iAr != 2
                                                            ? (iAr == 4 || iAr == 6 || iAr == 9 || iAr == 11) ? 30 : 31
                                                            : i16 == 0 && (iCharAt % 100 != 0 || iCharAt % 400 == 0)
                                                                    ? 29
                                                                    : 28)) {
                                                        StringBuilder sbQ2 = yg.concatVar31425(iAr, iCharAt,
                                                                "Expected a valid day-of-month for month ", " of year ",
                                                                ", got ");
                                                        sbQ2.append(iAr2);
                                                        bqaVarAq = FastKV.aq(strV, sbQ2.toString());
                                                    } else if (iAr3 > 23) {
                                                        bqaVarAq = FastKV.aq(strV, "Expected hour in 0..23, got " + iAr3);
                                                    } else if (iAr4 > 59) {
                                                        bqaVarAq = FastKV.aq(strV,
                                                                "Expected minute-of-hour in 0..59, got " + iAr4);
                                                    } else if (iAr5 > 59) {
                                                        bqaVarAq = FastKV.aq(strV,
                                                                "Expected second-of-minute in 0..59, got " + iAr5);
                                                    } else {
                                                        long j2 = iCharAt;
                                                        long j3 = ((long) 365) * j2;
                                                        if (j2 >= 0) {
                                                            i5 = iAr5;
                                                            i4 = iAr;
                                                            j = ((j2 + ((long) 399)) / ((long) 400))
                                                                    + (((((long) 3) + j2) / ((long) 4))
                                                                            - ((((long) 99) + j2) / ((long) 100)))
                                                                    + j3;
                                                        } else {
                                                            i4 = iAr;
                                                            i5 = iAr5;
                                                            j = StaticHelpers6.j(j2, -400,
                                                                    (j2 / ((long) (-4))) - (j2 / ((long) (-100))), j3);
                                                        }
                                                        long j4 = j + ((long) (((r1 * 367) - 362) / 12))
                                                                + ((long) (iAr2 - 1));
                                                        if (i4 > 2) {
                                                            j4 = (i16 != 0
                                                                    || (iCharAt % 100 == 0 && iCharAt % 400 != 0))
                                                                            ? j4 - 2
                                                                            : (-1) + j4;
                                                        }
                                                        long jC = (((j4 - ((long) 719528)) * ((long) 86400))
                                                                + ((long) bjs.c(iAr4, 60, iAr3 * 3600, i5)))
                                                                - ((long) iC);
                                                        InstantBuilder bpzVar = new InstantBuilder();
                                                        bpzVar.seconds = jC;
                                                        bpzVar.nanoAdjustment = i2;
                                                        bqaVarAq = bpzVar;
                                                    }
                                                }
                                            }
                                        } else {
                                            bqaVarAq = FastKV.aq(strV, "Expected an offset in -18:00..+18:00, got "
                                                    + strV.subSequence(i10, strV.length()).toString());
                                        }
                                    }
                                } else if (cCharAt4 == 'Z' || cCharAt4 == 'z') {
                                    int i17 = i10 + 1;
                                    if (strV.length() == i17) {
                                        iC = 0;
                                        bqaVarAq = 1 > iAr
                                                ? FastKV.aq(strV, "Expected a month number in 1..12, got " + iAr)
                                                : FastKV.aq(strV, "Expected a month number in 1..12, got " + iAr);
                                    } else {
                                        bqaVarAq = FastKV.aq(strV, "Extra text after the instant at position " + i17);
                                    }
                                } else {
                                    bqaVarAq = FastKV.aq(strV,
                                            "Expected the UTC offset at position " + i10 + ", got '" + cCharAt4 + '\'');
                                }
                            }
                        }
                    }
                }
            } else {
                bqaVarAq = FastKV.aq(strV, "A '+' or '-' sign is required for year numbers longer than 4 digits");
            }
        }
        bqaVarAq = bpyVarAp;
        bqaVarAq = bpyVarAp2;
        bqaVarAq = bpyVarAp3;
        bqaVarAq = bpyVarAp4;
        bqaVarAq = bpyVarAp;
        bqaVarAq = bpyVarAp2;
        bqaVarAq = bpyVarAp3;
        bqaVarAq = bpyVarAp;
        bqaVarAq = bpyVarAp2;
        bqaVarAq = bpyVarAp;
        return bqaVarAq.toInstant();
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        Instant instantVar = (Instant) obj;
        throwIfVar1IsNull(instantVar, "value");
        avtVar.ad(instantVar.toString());
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
