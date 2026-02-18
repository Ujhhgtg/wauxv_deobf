package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chu {
    public long[] a;
    public int[] b;
    public int c;

    public chu(int i) {
        long[] jArr;
        this.a = dev.a;
        this.b = bqk.a;
        if (i < 0) {
            bhv.ai("Capacity must be a positive value.");
            throw null;
        }
        int iD = dev.d(i);
        int iMax = iD > 0 ? Math.max(7, dev.c(iD)) : 0;
        this.c = iMax;
        if (iMax == 0) {
            jArr = dev.a;
        } else {
            jArr = new long[((iMax + 15) & (-8)) >> 3];
            la.n(jArr);
        }
        this.a = jArr;
        int i2 = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i2] = (jArr[i2] & (~j)) | j;
        dev.b(this.c);
        this.b = new int[iMax];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    public final boolean equals(Object obj) {
        boolean z;
        int[] iArr;
        boolean z2;
        long[] jArr;
        boolean z3;
        int[] iArr2;
        boolean z4;
        int i;
        long[] jArr2;
        int iNumberOfTrailingZeros;
        boolean z5 = true;
        if (obj == this) {
            return true;
        }
        boolean z6 = false;
        if (!(obj instanceof chu)) {
            return false;
        }
        chu chuVar = (chu) obj;
        int[] iArr3 = this.b;
        long[] jArr3 = this.a;
        int length = jArr3.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j = jArr3[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                for (?? r12 = z6; r12 < i4; r12++) {
                    if ((255 & j) < 128) {
                        int i5 = iArr3[(i2 << 3) + r12];
                        chuVar.getClass();
                        int iHashCode = Integer.hashCode(i5) * (-862048943);
                        int i6 = iHashCode ^ (iHashCode << 16);
                        int i7 = i6 & 127;
                        z3 = z5;
                        int i8 = chuVar.c;
                        int i9 = (i6 >>> 7) & i8;
                        z4 = z6;
                        int i10 = 0;
                        while (true) {
                            long[] jArr4 = chuVar.a;
                            int i11 = i9 >> 3;
                            i = i3;
                            int i12 = (i9 & 7) << 3;
                            long j2 = jArr4[i11] >>> i12;
                            long j3 = jArr4[i11 + 1] << (64 - i12);
                            int i13 = i8;
                            long j4 = j2 | (j3 & ((-i12) >> 63));
                            iArr2 = iArr3;
                            jArr2 = jArr3;
                            long j5 = (((long) i7) * 72340172838076673L) ^ j4;
                            for (long j6 = (j5 - 72340172838076673L) & (~j5) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                                iNumberOfTrailingZeros = (i9 + (Long.numberOfTrailingZeros(j6) >> 3)) & i13;
                                if (chuVar.b[iNumberOfTrailingZeros] == i5) {
                                    break;
                                }
                            }
                            if ((j4 & ((~j4) << 6) & (-9187201950435737472L)) != 0) {
                                iNumberOfTrailingZeros = -1;
                                break;
                            }
                            i10 += 8;
                            i9 = (i9 + i10) & i13;
                            jArr3 = jArr2;
                            i8 = i13;
                            iArr3 = iArr2;
                            i3 = i;
                        }
                        if (!(iNumberOfTrailingZeros >= 0)) {
                            return z4;
                        }
                    } else {
                        z3 = z5;
                        iArr2 = iArr3;
                        z4 = z6;
                        i = i3;
                        jArr2 = jArr3;
                    }
                    j >>= i;
                    jArr3 = jArr2;
                    z5 = z3;
                    z6 = z4;
                    iArr3 = iArr2;
                    i3 = i;
                }
                z = z5;
                iArr = iArr3;
                z2 = z6;
                int i14 = i3;
                jArr = jArr3;
                if (i4 != i14) {
                    return z;
                }
            } else {
                z = z5;
                iArr = iArr3;
                z2 = z6;
                jArr = jArr3;
            }
            if (i2 == length) {
                return z;
            }
            i2++;
            jArr3 = jArr;
            z5 = z;
            z6 = z2;
            iArr3 = iArr;
        }
    }

    public final int hashCode() {
        int[] iArr = this.b;
        long[] jArr = this.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        iHashCode = Integer.hashCode(iArr[(i << 3) + i3]) + iHashCode;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    /*
     * JADX WARN: Found duplicated region for block: B:19:0x005d A[DONT_INVERT, PHI:
     * r7
     * 0x005d: PHI (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:6:0x0026,
     * B:18:0x005b] A[DONT_GENERATE, DONT_INLINE]]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:20:0x005f A[LOOP:0:
     * B:5:0x0018->B:20:0x005f, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:26:0x0062 A[SYNTHETIC] */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "[");
        int[] iArr = this.b;
        long[] jArr = this.a;
        int length = jArr.length - 2;
        if (length < 0) {
            sb.append((CharSequence) "]");
            break;
        }
        int i = 0;
        int i2 = 0;
        loop0: while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = iArr[(i << 3) + i4];
                        if (i2 == -1) {
                            sb.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i2 != 0) {
                            sb.append((CharSequence) ", ");
                        }
                        sb.append(i5);
                        i2++;
                    }
                    j >>= 8;
                }
                if (i3 == 8) {
                    if (i == length) {
                        i++;
                    }
                }
                sb.append((CharSequence) "]");
                break;
            }
            if (i == length) {
                sb.append((CharSequence) "]");
                break;
            }
            i++;
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }

    public chu() {
        this(6);
    }
}
