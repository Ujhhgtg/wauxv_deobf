package com.alibaba.fastjson2.util;

import com.alibaba.fastjson2.JSONException;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class MutableBigInteger {
    private static final int[][] BIG_TEN_POWERS_MAGIC_TABLE = {new int[]{1}, new int[]{10}, new int[]{100}, new int[]{1000}, new int[]{10000}, new int[]{100000}, new int[]{1000000}, new int[]{10000000}, new int[]{100000000}, new int[]{Http2Connection.DEGRADED_PONG_TIMEOUT_NS}, new int[]{2, 1410065408}, new int[]{23, 1215752192}, new int[]{232, -727379968}, new int[]{2328, 1316134912}, new int[]{23283, 276447232}, new int[]{232830, -1530494976}, new int[]{2328306, 1874919424}, new int[]{23283064, 1569325056}, new int[]{232830643, -1486618624}, new int[]{-1966660860, -1981284352}, new int[]{5, 1808227885, 1661992960}, new int[]{54, 902409669, -559939584}, new int[]{542, 434162106, -1304428544}, new int[]{5421, 46653770, -159383552}, new int[]{54210, 466537709, -1593835520}, new int[]{542101, 370409800, 1241513984}, new int[]{5421010, -590869294, -469762048}, new int[]{54210108, -1613725636, -402653184}, new int[]{542101086, 1042612833, 268435456}, new int[]{1, 1126043566, 1836193738, -1610612736}, new int[]{12, -1624466224, 1182068202, 1073741824}, new int[]{126, 935206946, -1064219866, Integer.MIN_VALUE}, new int[]{1262, 762134875, -2052264063, 0}, new int[]{12621, -968585837, 952195850, 0}, new int[]{126217, -1095923776, 932023908, 0}, new int[]{1262177, 1925664130, 730304488, 0}, new int[]{12621774, 2076772117, -1286889712, 0}, new int[]{126217744, -707115303, 16004768, 0}, new int[]{1262177448, 1518781562, 160047680, 0}, new int[]{2, -263127405, -1992053564, 1600476800, 0}, new int[]{29, 1663693251, 1554300843, -1175101184, 0}, new int[]{293, -542936671, -1636860747, 1133890048, 0}, new int[]{2938, -1134399408, 811261716, -1546001408, 0}, new int[]{29387, 1540907809, -477317426, 1719855104, 0}, new int[]{293873, -1770791086, -478206960, 18681856, 0}, new int[]{2938735, -528041668, -487102304, 186818560, 0}, new int[]{29387358, -985449376, -576055744, 1868185600, 0}, new int[]{293873587, -1264559160, -1465590140, 1501986816, 0}, new int[]{-1356231419, 239310294, -1770999509, 2134966272, 0}, new int[]{6, -677412302, -1901864351, -530125902, -125173760, 0}, new int[]{68, 1815811577, -1838774318, -1006291715, -1251737600, 0}, new int[]{684, 978246591, -1207873989, -1472982551, 367525888, 0}, new int[]{6842, 1192531325, 806162004, -1844923622, -619708416, 0}, new int[]{68422, -959588637, -528314547, -1269367028, -1902116864, 0}, new int[]{684227, -1005951770, -988178167, 191231613, -1841299456, 0}, new int[]{6842277, -1469583101, -1291847078, 1912316135, -1233125376, 0}, new int[]{68422776, -1810929116, -33568888, 1943292173, 553648128, 0}, new int[]{684227765, -929421967, -335688876, -2041914749, 1241513984, 0}, new int[]{1, -1747656935, -704285069, 938078541, 1055688992, -469762048, 0}, new int[]{15, -296700158, 1547083904, 790850820, 1966955336, -402653184, 0}, new int[]{159, 1327965719, -1709030143, -681426388, -1805283111, 268435456, 0}, new int[]{1593, 394755308, 89567762, 1775670717, -872961926, -1610612736, 0}, new int[]{15930, -347414216, 895677624, 576837993, -139684662, 1073741824, 0}, new int[]{159309, 820825138, 366841649, 1473412643, -1396846618, Integer.MIN_VALUE, 0}};
    static final int KNUTH_POW2_THRESH_LEN = 6;
    static final int KNUTH_POW2_THRESH_ZEROS = 3;
    static final long LONG_MASK = 4294967295L;

    private static int divadd(int[] iArr, int[] iArr2, int i) {
        long j = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i2 = length + i;
            long j2 = (((long) iArr[length]) & LONG_MASK) + (LONG_MASK & ((long) iArr2[i2])) + j;
            iArr2[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    /* JADX WARN: Found duplicated region for block: B:72:0x019d  */
    /* JADX WARN: Found duplicated region for block: B:74:0x01c1  */
    /* JADX WARN: Found duplicated region for block: B:75:0x01c4  */
    /* JADX WARN: Found duplicated region for block: B:79:0x01da  */
    /* JADX WARN: Found duplicated region for block: B:80:0x01e0  */
    public static long divideKnuthLong(long j, int i, int i2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int i3;
        int i4;
        int i5;
        int[] iArr4;
        int i6;
        int i7;
        int i8;
        int iRemainderUnsigned;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        long j2;
        int i14;
        int i15;
        long j3;
        int[] iArr5;
        int i16;
        int i17;
        int i18;
        int[] iArrShiftLeft = BIG_TEN_POWERS_MAGIC_TABLE[i2];
        int i19 = (int) (j >>> 32);
        int i20 = (int) j;
        int i21 = 0;
        if (i <= 0) {
            int i22 = -i;
            int i23 = i22 >>> 5;
            int i24 = i22 & 31;
            if (i24 == 0) {
                iArr = new int[i23 + 2];
                iArr[0] = i19;
                iArr[1] = i20;
            } else {
                int i25 = 32 - i24;
                int i26 = i19 >>> i25;
                if (i26 != 0) {
                    iArr = new int[i23 + 3];
                    iArr[0] = i26;
                    i18 = 1;
                } else {
                    iArr = new int[i23 + 2];
                    i18 = 0;
                }
                iArr[i18] = (i19 << i24) | (i20 >>> i25);
                iArr[i18 + 1] = i20 << i24;
            }
        } else {
            iArr = new int[]{i19, i20};
            iArrShiftLeft = shiftLeft(iArrShiftLeft, i);
        }
        long j4 = 0;
        if (iArr.length < iArrShiftLeft.length) {
            return 0L;
        }
        if (iArr.length == iArrShiftLeft.length && equals(iArr, iArrShiftLeft)) {
            return 1L;
        }
        if (iArrShiftLeft.length == 1) {
            return divideOneWordLong(iArr, iArrShiftLeft[0]);
        }
        if (iArr.length >= 6 && Math.min(getLowestSetBit(iArr), getLowestSetBit(iArrShiftLeft)) >= 96) {
            throw new JSONException("assert error");
        }
        int length = iArr.length;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iArrShiftLeft[0]);
        int length2 = iArrShiftLeft.length;
        if (iNumberOfLeadingZeros > 0) {
            iArr2 = new int[length2];
            primitiveLeftShift(iArrShiftLeft, iNumberOfLeadingZeros, iArr2, 0);
            if (Integer.numberOfLeadingZeros(iArr[0]) >= iNumberOfLeadingZeros) {
                iArr3 = new int[length + 1];
                primitiveLeftShift(iArr, iNumberOfLeadingZeros, iArr3, 1);
            } else {
                iArr3 = new int[length + 2];
                length++;
                int i27 = 32 - iNumberOfLeadingZeros;
                int i28 = 1;
                int i29 = 0;
                int i30 = 0;
                while (i28 < length) {
                    int i31 = iArr[i30];
                    iArr3[i28] = (i29 << iNumberOfLeadingZeros) | (i31 >>> i27);
                    i28++;
                    i30++;
                    i29 = i31;
                }
                iArr3[length] = i29 << iNumberOfLeadingZeros;
            }
        } else {
            iArr2 = (int[]) iArrShiftLeft.clone();
            iArr3 = new int[length + 1];
            System.arraycopy(iArr, 0, iArr3, 1, length);
        }
        int i32 = length - length2;
        int i33 = i32 + 1;
        int[] iArr6 = new int[i33];
        iArr3[0] = 0;
        int i34 = iArr2[0];
        long j5 = LONG_MASK;
        long j6 = ((long) i34) & LONG_MASK;
        int i35 = iArr2[1];
        int i36 = 0;
        while (i36 < i32) {
            int i37 = i21;
            int i38 = iArr3[i36];
            long j7 = j4;
            int i39 = i38 - Integer.MIN_VALUE;
            int i40 = i36 + 1;
            long j8 = j5;
            int i41 = iArr3[i40];
            if (i38 == i34) {
                int i42 = i38 + i41;
                i10 = i42 + Integer.MIN_VALUE < i39 ? 1 : i37;
                i8 = length2;
                iRemainderUnsigned = i42;
                i7 = i36;
                i9 = -1;
            } else {
                int i43 = length2;
                i7 = i36;
                long j9 = (((long) i38) << 32) | (((long) i41) & j8);
                i8 = i43;
                int iDivideUnsigned = (int) Long.divideUnsigned(j9, j6);
                iRemainderUnsigned = (int) Long.remainderUnsigned(j9, j6);
                i9 = iDivideUnsigned;
                i10 = i37;
            }
            if (i9 == 0) {
                i11 = i32;
                i12 = i33;
                iArr5 = iArr6;
            } else {
                if (i10 == 0) {
                    long j10 = ((long) iArr3[i7 + 2]) & j8;
                    long j11 = ((long) iRemainderUnsigned) & j8;
                    int i44 = i32;
                    i12 = i33;
                    long j12 = ((long) i35) & j8;
                    long j13 = (((long) i9) & j8) * j12;
                    if (unsignedLongCompare(j13, (j11 << 32) | j10)) {
                        int i45 = i9 - 1;
                        long j14 = ((long) ((int) (j11 + j6))) & j8;
                        if (j14 >= j6) {
                            i11 = i44;
                            int i46 = i9;
                            if (unsignedLongCompare(j13 - j12, (j14 << 32) | j10)) {
                                i13 = i46 - 2;
                            }
                        } else {
                            i11 = i44;
                        }
                        i13 = i45;
                    } else {
                        i11 = i44;
                    }
                    iArr3[i7] = i37;
                    j2 = ((long) i13) & j8;
                    i14 = i7 + i8;
                    i15 = i8 - 1;
                    j3 = j7;
                    while (i15 >= 0) {
                        int i47 = i14;
                        int i48 = i13;
                        long j15 = ((((long) iArr2[i15]) & j8) * j2) + j3;
                        long j16 = ((long) iArr3[i47]) - j15;
                        int i49 = i47 - 1;
                        int[] iArr7 = iArr6;
                        iArr3[i47] = (int) j16;
                        j3 = (j15 >>> 32) + ((long) ((j16 & j8) > (((long) (~((int) j15))) & j8) ? 1 : i37));
                        i15--;
                        i14 = i49;
                        i13 = i48;
                        iArr6 = iArr7;
                    }
                    iArr5 = iArr6;
                    i16 = i13;
                    if (((int) j3) - Integer.MIN_VALUE > i39) {
                        divadd(iArr2, iArr3, i40);
                        i17 = i16 - 1;
                    } else {
                        i17 = i16;
                    }
                    iArr5[i7] = i17;
                } else {
                    i11 = i32;
                    i12 = i33;
                }
                i13 = i9;
                iArr3[i7] = i37;
                j2 = ((long) i13) & j8;
                i14 = i7 + i8;
                i15 = i8 - 1;
                j3 = j7;
                while (i15 >= 0) {
                    int i472 = i14;
                    int i482 = i13;
                    long j152 = ((((long) iArr2[i15]) & j8) * j2) + j3;
                    long j162 = ((long) iArr3[i472]) - j152;
                    int i492 = i472 - 1;
                    int[] iArr72 = iArr6;
                    iArr3[i472] = (int) j162;
                    j3 = (j152 >>> 32) + ((long) ((j162 & j8) > (((long) (~((int) j152))) & j8) ? 1 : i37));
                    i15--;
                    i14 = i492;
                    i13 = i482;
                    iArr6 = iArr72;
                }
                iArr5 = iArr6;
                i16 = i13;
                if (((int) j3) - Integer.MIN_VALUE > i39) {
                    divadd(iArr2, iArr3, i40);
                    i17 = i16 - 1;
                } else {
                    i17 = i16;
                }
                iArr5[i7] = i17;
            }
            length2 = i8;
            i36 = i40;
            j4 = j7;
            j5 = j8;
            i33 = i12;
            iArr6 = iArr5;
            i32 = i11;
            i21 = i37;
        }
        int i50 = i32;
        int i51 = i33;
        int[] iArr8 = iArr6;
        int i52 = i21;
        long j17 = j4;
        long j18 = j5;
        int i53 = length2;
        int i54 = iArr3[i50];
        int i55 = i54 - Integer.MIN_VALUE;
        int i56 = iArr3[i51];
        if (i54 == i34) {
            i4 = i54 + i56;
            i5 = i4 + Integer.MIN_VALUE < i55 ? 1 : i52;
            i3 = -1;
        } else {
            long j19 = (((long) i54) << 32) | (((long) i56) & j18);
            int iDivideUnsigned2 = (int) Long.divideUnsigned(j19, j6);
            int iRemainderUnsigned2 = (int) Long.remainderUnsigned(j19, j6);
            i3 = iDivideUnsigned2;
            i4 = iRemainderUnsigned2;
            i5 = i52;
        }
        if (i3 != 0) {
            if (i5 == 0) {
                long j20 = ((long) iArr3[i50 + 2]) & j18;
                long j21 = ((long) i4) & j18;
                iArr4 = iArr3;
                i6 = i53;
                long j22 = ((long) i35) & j18;
                long j23 = (((long) i3) & j18) * j22;
                if (unsignedLongCompare(j23, (j21 << 32) | j20)) {
                    long j24 = ((long) ((int) (j21 + j6))) & j18;
                    i3 = (j24 < j6 || !unsignedLongCompare(j23 - j22, (j24 << 32) | j20)) ? i3 - 1 : i3 - 2;
                }
            } else {
                iArr4 = iArr3;
                i6 = i53;
            }
            iArr4[i50] = i52;
            int i57 = i50 + i6;
            long j25 = ((long) i3) & j18;
            int i58 = i6 - 1;
            long j26 = j17;
            while (i58 >= 0) {
                long j27 = ((((long) iArr2[i58]) & j18) * j25) + j26;
                int i59 = i57 - 1;
                long j28 = ((long) (((((long) iArr4[i57]) - j27) & j18) > (((long) (~((int) j27))) & j18) ? 1 : i52)) + (j27 >>> 32);
                i58--;
                i57 = i59;
                j26 = j28;
            }
            if (((int) j26) - Integer.MIN_VALUE > i55) {
                i3--;
            }
            iArr8[i50] = i3;
        }
        int i60 = i52;
        while (i60 < i51 && iArr8[i60] == 0) {
            i60++;
        }
        return i51 == i60 ? j17 : ((((long) iArr8[i50 - 1]) & j18) << 32) + (((long) iArr8[i50]) & j18);
    }

    private static long divideOneWordLong(int[] iArr, int i) {
        long j = ((long) i) & LONG_MASK;
        int length = iArr.length;
        if (iArr.length == 1) {
            return Integer.divideUnsigned(iArr[0], i);
        }
        int[] iArr2 = new int[length];
        long jRemainderUnsigned = 0;
        for (int i2 = length; i2 > 0; i2--) {
            int i3 = length - i2;
            long j2 = (jRemainderUnsigned << 32) | (((long) iArr[i3]) & LONG_MASK);
            int iDivideUnsigned = (int) Long.divideUnsigned(j2, j);
            jRemainderUnsigned = Long.remainderUnsigned(j2, j);
            iArr2[i3] = iDivideUnsigned;
        }
        return longValue(iArr2, length);
    }

    private static boolean equals(int[] iArr, int[] iArr2) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            if (iArr[i] - Integer.MIN_VALUE != iArr2[i2] - Integer.MIN_VALUE) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    private static int getLowestSetBit(int[] iArr) {
        if (iArr.length == 0) {
            return -1;
        }
        int length = iArr.length - 1;
        while (length > 0 && iArr[length] == 0) {
            length--;
        }
        int i = iArr[length];
        if (i == 0) {
            return -1;
        }
        return Integer.numberOfTrailingZeros(i) + (((iArr.length - 1) - length) << 5);
    }

    private static long longValue(int[] iArr, int i) {
        if (i == 0) {
            return 0L;
        }
        int i2 = 0;
        while (i2 < i && iArr[i2] == 0) {
            i2++;
        }
        if (i == i2) {
            return 0L;
        }
        return ((((long) iArr[i - 2]) & LONG_MASK) << 32) + (((long) iArr[i - 1]) & LONG_MASK);
    }

    private static void primitiveLeftShift(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = 32 - i;
        int length = iArr.length - 1;
        int i4 = 0;
        int i5 = iArr[0];
        while (i4 < length) {
            int i6 = i4 + 1;
            int i7 = iArr[i6];
            iArr2[i4 + i2] = (i5 << i) | (i7 >>> i3);
            i4 = i6;
            i5 = i7;
        }
        iArr2[i2 + length] = i5 << i;
    }

    private static int[] shiftLeft(int[] iArr, int i) {
        int[] iArr2;
        int i2;
        int i3 = i >>> 5;
        int i4 = i & 31;
        int length = iArr.length;
        int i5 = 0;
        if (i4 == 0) {
            int[] iArr3 = new int[i3 + length];
            System.arraycopy(iArr, 0, iArr3, 0, length);
            return iArr3;
        }
        int i6 = 32 - i4;
        int i7 = iArr[0] >>> i6;
        if (i7 != 0) {
            iArr2 = new int[i3 + length + 1];
            iArr2[0] = i7;
            i2 = 1;
        } else {
            iArr2 = new int[i3 + length];
            i2 = 0;
        }
        while (i5 < length - 1) {
            int i8 = i5 + 1;
            iArr2[i2] = (iArr[i5] << i4) | (iArr[i8] >>> i6);
            i2++;
            i5 = i8;
        }
        iArr2[i2] = iArr[i5] << i4;
        return iArr2;
    }

    private static boolean unsignedLongCompare(long j, long j2) {
        return j + Long.MIN_VALUE > j2 + Long.MIN_VALUE;
    }
}
