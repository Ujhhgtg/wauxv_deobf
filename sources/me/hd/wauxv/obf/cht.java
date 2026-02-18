package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cht {
    public long[] a;
    public int[] b;
    public Object[] c;
    public int d;
    public int e;
    public int f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8, types: [int] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [int] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final boolean equals(Object obj) {
        boolean z;
        int[] iArr;
        boolean z2;
        Object[] objArr;
        long[] jArr;
        ?? r22;
        boolean z3;
        Object[] objArr2;
        long[] jArr2;
        int i;
        char c;
        long j;
        int[] iArr2;
        int iNumberOfTrailingZeros;
        boolean z4 = true;
        if (obj == this) {
            return true;
        }
        boolean z5 = false;
        if (!(obj instanceof cht)) {
            return false;
        }
        cht chtVar = (cht) obj;
        if (chtVar.e != this.e) {
            return false;
        }
        int[] iArr3 = this.b;
        Object[] objArr3 = this.c;
        long[] jArr3 = this.a;
        int length = jArr3.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        loop0: while (true) {
            long j2 = jArr3[i2];
            char c2 = 7;
            long j3 = -9187201950435737472L;
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8;
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                z = z4;
                ?? r2 = z5;
                while (r2 < i4) {
                    if ((j2 & 255) < 128) {
                        int i5 = (i2 << 3) + (r2 == true ? 1 : 0);
                        z3 = z5;
                        int i6 = iArr3[i5];
                        c = c2;
                        Object obj2 = objArr3[i5];
                        if (obj2 != null) {
                            r22 = r2 == true ? 1 : 0;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i = i3;
                            j = j3;
                            iArr2 = iArr3;
                            if (!obj2.equals(chtVar.h(i6))) {
                                return z3;
                            }
                        } else {
                            if (chtVar.h(i6) != null) {
                                break loop0;
                            }
                            int iHashCode = Integer.hashCode(i6) * (-862048943);
                            int i7 = iHashCode ^ (iHashCode << 16);
                            j = j3;
                            int i8 = i7 & 127;
                            int i9 = chtVar.d;
                            int i10 = (i7 >>> 7) & i9;
                            i = i3;
                            ?? r17 = z3;
                            ?? r23 = r2;
                            while (true) {
                                long[] jArr4 = chtVar.a;
                                int i11 = i10 >> 3;
                                int i12 = (i10 & 7) << 3;
                                long j4 = jArr4[i11] >>> i12;
                                long j5 = jArr4[i11 + 1] << (64 - i12);
                                r22 = r23;
                                iArr2 = iArr3;
                                long j6 = j4 | (j5 & ((-i12) >> 63));
                                Object[] objArr4 = objArr3;
                                jArr2 = jArr3;
                                long j7 = (((long) i8) * 72340172838076673L) ^ j6;
                                long j8 = (j7 - 72340172838076673L) & (~j7) & j;
                                while (j8 != 0) {
                                    iNumberOfTrailingZeros = (i10 + (Long.numberOfTrailingZeros(j8) >> 3)) & i9;
                                    objArr2 = objArr4;
                                    if (chtVar.b[iNumberOfTrailingZeros] == i6) {
                                        break;
                                    }
                                    j8 &= j8 - 1;
                                    objArr4 = objArr2;
                                }
                                objArr2 = objArr4;
                                if ((j6 & ((~j6) << 6) & j) != 0) {
                                    iNumberOfTrailingZeros = -1;
                                    break;
                                }
                                int i13 = r17 + 8;
                                i10 = (i10 + i13) & i9;
                                iArr3 = iArr2;
                                r23 = r22 == true ? 1 : 0;
                                jArr3 = jArr2;
                                objArr3 = objArr2;
                                r17 = i13;
                            }
                            if (!(iNumberOfTrailingZeros >= 0 ? z : z3)) {
                                break loop0;
                            }
                        }
                    } else {
                        r22 = r2 == true ? 1 : 0;
                        z3 = z5;
                        objArr2 = objArr3;
                        jArr2 = jArr3;
                        i = i3;
                        c = c2;
                        j = j3;
                        iArr2 = iArr3;
                    }
                    j2 >>= i;
                    c2 = c;
                    iArr3 = iArr2;
                    z5 = z3;
                    j3 = j;
                    i3 = i;
                    jArr3 = jArr2;
                    objArr3 = objArr2;
                    r2 = r22 + 1;
                }
                z2 = z5;
                objArr = objArr3;
                jArr = jArr3;
                int i14 = i3;
                iArr = iArr3;
                if (i4 != i14) {
                    return z;
                }
            } else {
                z = z4;
                iArr = iArr3;
                z2 = z5;
                objArr = objArr3;
                jArr = jArr3;
            }
            if (i2 == length) {
                return z;
            }
            i2++;
            iArr3 = iArr;
            z4 = z;
            z5 = z2;
            jArr3 = jArr;
            objArr3 = objArr;
        }
        return z3;
    }

    public final int g(int i) {
        int i2 = this.d;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.a;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    public final Object h(int i) {
        int iNumberOfTrailingZeros;
        int iHashCode = Integer.hashCode(i) * (-862048943);
        int i2 = iHashCode ^ (iHashCode << 16);
        int i3 = i2 & 127;
        int i4 = this.d;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = this.a;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i3) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (this.b[iNumberOfTrailingZeros] == i) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (iNumberOfTrailingZeros >= 0) {
            return this.c[iNumberOfTrailingZeros];
        }
        return null;
    }

    public final int hashCode() {
        int[] iArr = this.b;
        Object[] objArr = this.c;
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
                        int i4 = (i << 3) + i3;
                        int i5 = iArr[i4];
                        Object obj = objArr[i4];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Integer.hashCode(i5);
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

    public final void i(int i) {
        long[] jArr;
        int iMax = i > 0 ? Math.max(7, dev.c(i)) : 0;
        this.d = iMax;
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
        this.f = dev.b(this.d) - this.e;
        this.b = new int[iMax];
        this.c = new Object[iMax];
    }

    /* JADX WARN: Found duplicated region for block: B:23:0x006a A[DONT_INVERT, PHI: r8
      0x006a: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x002c, B:22:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:24:0x006c A[LOOP:0: B:9:0x001e->B:24:0x006c, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:28:0x006f A[EDGE_INSN: B:28:0x006f->B:25:0x006f BREAK  A[LOOP:0: B:9:0x001e->B:24:0x006c], SYNTHETIC] */
    public final String toString() {
        if (this.e == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        int[] iArr = this.b;
        Object[] objArr = this.c;
        long[] jArr = this.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr[i5];
                            Object obj = objArr[i5];
                            sb.append(i6);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i2++;
                            if (i2 < this.e) {
                                sb.append(", ");
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        sb.append('}');
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }
}
