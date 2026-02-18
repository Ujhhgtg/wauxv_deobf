package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chw {
    public long[] a;
    public long[] b;
    public Object[] c;
    public int d;
    public int e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8, types: [int] */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [int] */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final boolean equals(Object obj) {
        boolean z;
        long[] jArr;
        boolean z2;
        Object[] objArr;
        ?? r23;
        boolean z3;
        Object[] objArr2;
        long j;
        int i;
        char c;
        long j2;
        long[] jArr2;
        int i2;
        boolean z4 = true;
        if (obj == this) {
            return true;
        }
        boolean z5 = false;
        if (!(obj instanceof chw)) {
            return false;
        }
        chw chwVar = (chw) obj;
        if (chwVar.e != this.e) {
            return false;
        }
        long[] jArr3 = this.b;
        Object[] objArr3 = this.c;
        long[] jArr4 = this.a;
        int length = jArr4.length - 2;
        if (length < 0) {
            return true;
        }
        int i3 = 0;
        loop0: while (true) {
            long j3 = jArr4[i3];
            char c2 = 7;
            long j4 = -9187201950435737472L;
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                z = z4;
                ?? r2 = z5;
                while (r2 < i5) {
                    if ((j3 & 255) < 128) {
                        int i6 = (i3 << 3) + (r2 == true ? 1 : 0);
                        z3 = z5;
                        objArr2 = objArr3;
                        long j5 = jArr3[i6];
                        c = c2;
                        Object obj2 = objArr2[i6];
                        if (obj2 == null) {
                            if (chwVar.g(j5) != null) {
                                break loop0;
                            }
                            int iHashCode = Long.hashCode(j5) * (-862048943);
                            int i7 = iHashCode ^ (iHashCode << 16);
                            j2 = j4;
                            int i8 = i7 & 127;
                            int i9 = chwVar.d;
                            int i10 = (i7 >>> 7) & i9;
                            i = i4;
                            ?? r17 = z3;
                            ?? r22 = r2;
                            while (true) {
                                long[] jArr5 = chwVar.a;
                                int i11 = i10 >> 3;
                                int i12 = (i10 & 7) << 3;
                                long j6 = jArr5[i11] >>> i12;
                                long j7 = jArr5[i11 + 1] << (64 - i12);
                                r23 = r22;
                                jArr2 = jArr3;
                                long j8 = j6 | (j7 & ((-i12) >> 63));
                                j = j3;
                                long j9 = (((long) i8) * 72340172838076673L) ^ j8;
                                for (long j10 = (j9 - 72340172838076673L) & (~j9) & j2; j10 != 0; j10 &= j10 - 1) {
                                    int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i10) & i9;
                                    if (chwVar.b[iNumberOfTrailingZeros] == j5) {
                                        i2 = iNumberOfTrailingZeros;
                                        break;
                                    }
                                }
                                if ((j8 & ((~j8) << 6) & j2) != 0) {
                                    i2 = -1;
                                    break;
                                }
                                int i13 = r17 + 8;
                                i10 = (i10 + i13) & i9;
                                jArr3 = jArr2;
                                r22 = r23 == true ? 1 : 0;
                                j3 = j;
                                r17 = i13;
                            }
                            if (!(i2 >= 0 ? z : z3)) {
                                break loop0;
                            }
                        } else {
                            r23 = r2 == true ? 1 : 0;
                            j = j3;
                            i = i4;
                            j2 = j4;
                            jArr2 = jArr3;
                            if (!obj2.equals(chwVar.g(j5))) {
                                return z3;
                            }
                        }
                    } else {
                        r23 = r2 == true ? 1 : 0;
                        z3 = z5;
                        objArr2 = objArr3;
                        j = j3;
                        i = i4;
                        c = c2;
                        j2 = j4;
                        jArr2 = jArr3;
                    }
                    j3 = j >> i;
                    c2 = c;
                    jArr3 = jArr2;
                    z5 = z3;
                    objArr3 = objArr2;
                    j4 = j2;
                    i4 = i;
                    r2 = r23 + 1;
                }
                z2 = z5;
                objArr = objArr3;
                int i14 = i4;
                jArr = jArr3;
                if (i5 != i14) {
                    return z;
                }
            } else {
                z = z4;
                jArr = jArr3;
                z2 = z5;
                objArr = objArr3;
            }
            if (i3 == length) {
                return z;
            }
            i3++;
            jArr3 = jArr;
            z4 = z;
            z5 = z2;
            objArr3 = objArr;
        }
        return z3;
    }

    public final void f() {
        this.e = 0;
        long[] jArr = this.a;
        if (jArr != dev.a) {
            la.n(jArr);
            long[] jArr2 = this.a;
            int i = this.d;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        la.l(this.c, 0, this.d);
        dev.b(this.d);
    }

    public final Object g(long j) {
        int iNumberOfTrailingZeros;
        int iHashCode = Long.hashCode(j) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i3 = this.d;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        loop0: while (true) {
            long[] jArr = this.a;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j2 = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j3 = (((long) i2) * 72340172838076673L) ^ j2;
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i4) & i3;
                if (this.b[iNumberOfTrailingZeros] == j) {
                    break loop0;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
        if (iNumberOfTrailingZeros >= 0) {
            return this.c[iNumberOfTrailingZeros];
        }
        return null;
    }

    public final int hashCode() {
        long[] jArr = this.b;
        Object[] objArr = this.c;
        long[] jArr2 = this.a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        long j2 = jArr[i4];
                        Object obj = objArr[i4];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Long.hashCode(j2);
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

    public final String toString() {
        int i;
        int i2;
        if (this.e == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.b;
        Object[] objArr = this.c;
        long[] jArr2 = this.a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((255 & j) < 128) {
                            int i7 = (i3 << 3) + i6;
                            i2 = i3;
                            long j2 = jArr[i7];
                            Object obj = objArr[i7];
                            sb.append(j2);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i4++;
                            if (i4 < this.e) {
                                sb.append(", ");
                            }
                        } else {
                            i2 = i3;
                        }
                        j >>= 8;
                        i6++;
                        i3 = i2;
                    }
                    int i8 = i3;
                    if (i5 != 8) {
                        break;
                    }
                    i = i8;
                } else {
                    i = i3;
                }
                if (i == length) {
                    break;
                }
                i3 = i + 1;
            }
        }
        sb.append('}');
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
