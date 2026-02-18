package me.hd.wauxv.obf;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlh implements dle {
    public static final but a = new but(new dfq(9));
    public int b;
    public long c;
    public cht j;

    @Override // me.hd.wauxv.obf.dle
    public final long d() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.dle
    public final Object e(int i) {
        cht chtVar = this.j;
        if (chtVar == null) {
            return null;
        }
        return chtVar.h(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dlh.class == obj.getClass()) {
            dlh dlhVar = (dlh) obj;
            if (this.b == dlhVar.b && this.c == dlhVar.c && Objects.equals(this.j, dlhVar.j)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.dle
    public final void f(long j) {
        this.c = j;
    }

    @Override // me.hd.wauxv.obf.dle
    public final arp g() {
        return (arp) e(3);
    }

    @Override // me.hd.wauxv.obf.dle
    public final void h(int i) {
        this.b = i;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Long.valueOf(this.c), this.j);
    }

    @Override // me.hd.wauxv.obf.dle
    public final int i() {
        return this.b;
    }

    public final void k(int i, dlg dlgVar) {
        cht chtVar;
        long j;
        long j2;
        int iG;
        int i2;
        long[] jArr;
        int[] iArr;
        int i3;
        int[] iArr2;
        char c = 2;
        char c2 = 3;
        int i4 = 1;
        if (!((i == 0 || i == 1) ? false : i != 2 ? i != 3 ? true : dlgVar instanceof arp : dlgVar instanceof dlf)) {
            throw new IllegalArgumentException("type mismatch: extType " + i + " and extObj " + dlgVar);
        }
        int i5 = 6;
        if (this.j == null) {
            cht chtVar2 = new cht();
            chtVar2.a = dev.a;
            chtVar2.b = bqk.a;
            chtVar2.c = KotlinHelpers.b;
            chtVar2.i(dev.d(6));
            this.j = chtVar2;
        }
        cht chtVar3 = this.j;
        chtVar3.getClass();
        int i6 = -862048943;
        int iHashCode = Integer.hashCode(i) * (-862048943);
        int i7 = iHashCode ^ (iHashCode << 16);
        int i8 = i7 >>> 7;
        int i9 = i7 & 127;
        int i10 = chtVar3.d;
        int i11 = i8 & i10;
        int i12 = 0;
        loop0: while (true) {
            long[] jArr2 = chtVar3.a;
            int i13 = i11 >> 3;
            char c3 = c;
            int i14 = (i11 & 7) << 3;
            char c4 = c2;
            long j3 = (jArr2[i13] >>> i14) | (((-i14) >> 63) & (jArr2[i13 + 1] << (64 - i14)));
            int i15 = i6;
            int i16 = i8;
            long j4 = i9;
            int i17 = i4;
            long j5 = j3 ^ (j4 * 72340172838076673L);
            long j6 = (j5 - 72340172838076673L) & (~j5) & (-9187201950435737472L);
            while (j6 != 0) {
                iG = (i11 + (Long.numberOfTrailingZeros(j6) >> 3)) & i10;
                int i18 = i5;
                if (chtVar3.b[iG] == i) {
                    chtVar = chtVar3;
                    break loop0;
                } else {
                    j6 &= j6 - 1;
                    i5 = i18;
                }
            }
            int i19 = i5;
            if ((j3 & ((~j3) << i19) & (-9187201950435737472L)) != 0) {
                int iG2 = chtVar3.g(i16);
                if (chtVar3.f != 0 || ((chtVar3.a[iG2 >> 3] >> ((iG2 & 7) << 3)) & 255) == 254) {
                    chtVar = chtVar3;
                    j = 255;
                    j2 = 128;
                    iG = iG2;
                } else {
                    int i20 = chtVar3.d;
                    if (i20 > 8) {
                        j = 255;
                        if (Long.compareUnsigned(((long) chtVar3.e) * 32, ((long) i20) * 25) <= 0) {
                            long[] jArr3 = chtVar3.a;
                            int i21 = chtVar3.d;
                            int[] iArr3 = chtVar3.b;
                            Object[] objArr = chtVar3.c;
                            int i22 = (i21 + 7) >> 3;
                            int i23 = 0;
                            while (i23 < i22) {
                                long j7 = jArr3[i23] & (-9187201950435737472L);
                                jArr3[i23] = ((~j7) + (j7 >>> 7)) & (-72340172838076674L);
                                i23++;
                                chtVar3 = chtVar3;
                            }
                            cht chtVar4 = chtVar3;
                            j2 = 128;
                            throwIfVar1IsNull(jArr3, "<this>");
                            int length = jArr3.length;
                            int i24 = length - 1;
                            int i25 = length - 2;
                            jArr3[i25] = (jArr3[i25] & 72057594037927935L) | (-72057594037927936L);
                            jArr3[i24] = jArr3[0];
                            int i26 = 0;
                            while (i26 != i21) {
                                int i27 = i26 >> 3;
                                int i28 = (i26 & 7) << 3;
                                long j8 = (jArr3[i27] >> i28) & 255;
                                if (j8 != 128 && j8 == 254) {
                                    int iHashCode2 = Integer.hashCode(iArr3[i26]) * i15;
                                    int i29 = iHashCode2 ^ (iHashCode2 << 16);
                                    int i30 = i29 >>> 7;
                                    cht chtVar5 = chtVar4;
                                    int iG3 = chtVar5.g(i30);
                                    int i31 = i30 & i21;
                                    if (((iG3 - i31) & i21) / 8 == ((i26 - i31) & i21) / 8) {
                                        i3 = i21;
                                        iArr2 = iArr3;
                                        jArr3[i27] = (jArr3[i27] & (~(255 << i28))) | (((long) (i29 & 127)) << i28);
                                        jArr3[jArr3.length - 1] = (jArr3[0] & 72057594037927935L) | Long.MIN_VALUE;
                                    } else {
                                        i3 = i21;
                                        iArr2 = iArr3;
                                        int i32 = iG3 >> 3;
                                        long j9 = jArr3[i32];
                                        int i33 = (iG3 & 7) << 3;
                                        if (((j9 >> i33) & 255) == 128) {
                                            jArr3[i32] = (j9 & (~(255 << i33))) | (((long) (i29 & 127)) << i33);
                                            jArr3[i27] = (jArr3[i27] & (~(255 << i28))) | (128 << i28);
                                            iArr2[iG3] = iArr2[i26];
                                            iArr2[i26] = 0;
                                            objArr[iG3] = objArr[i26];
                                            objArr[i26] = null;
                                        } else {
                                            jArr3[i32] = (((long) (i29 & 127)) << i33) | (j9 & (~(255 << i33)));
                                            int i34 = iArr2[iG3];
                                            iArr2[iG3] = iArr2[i26];
                                            iArr2[i26] = i34;
                                            Object obj = objArr[iG3];
                                            objArr[iG3] = objArr[i26];
                                            objArr[i26] = obj;
                                            i26--;
                                        }
                                        jArr3[jArr3.length - 1] = (jArr3[0] & 72057594037927935L) | Long.MIN_VALUE;
                                    }
                                    i26++;
                                    i21 = i3;
                                    iArr3 = iArr2;
                                    chtVar4 = chtVar5;
                                } else {
                                    i26++;
                                }
                            }
                            chtVar = chtVar4;
                            chtVar.f = dev.b(chtVar.d) - chtVar.e;
                        }
                        iG = chtVar.g(i16);
                    } else {
                        j = 255;
                    }
                    chtVar = chtVar3;
                    j2 = 128;
                    int i35 = chtVar.d;
                    long[] jArr4 = dev.a;
                    int i36 = i35 == 0 ? i19 : (i35 * 2) + 1;
                    long[] jArr5 = chtVar.a;
                    int[] iArr4 = chtVar.b;
                    Object[] objArr2 = chtVar.c;
                    chtVar.i(i36);
                    long[] jArr6 = chtVar.a;
                    int[] iArr5 = chtVar.b;
                    Object[] objArr3 = chtVar.c;
                    int i37 = chtVar.d;
                    int i38 = 0;
                    while (i38 < i35) {
                        if (((jArr5[i38 >> 3] >> ((i38 & 7) << 3)) & j) < 128) {
                            int i39 = iArr4[i38];
                            int iHashCode3 = Integer.hashCode(i39) * i15;
                            int i40 = iHashCode3 ^ (iHashCode3 << 16);
                            i2 = i35;
                            int iG4 = chtVar.g(i40 >>> 7);
                            int i41 = i40 & 127;
                            jArr = jArr5;
                            iArr = iArr4;
                            long j10 = i41;
                            int i42 = iG4 >> 3;
                            int i43 = (iG4 & 7) << 3;
                            long j11 = (jArr6[i42] & (~(j << i43))) | (j10 << i43);
                            jArr6[i42] = j11;
                            jArr6[(((iG4 - 7) & i37) + (i37 & 7)) >> 3] = j11;
                            iArr5[iG4] = i39;
                            objArr3[iG4] = objArr2[i38];
                        } else {
                            i2 = i35;
                            jArr = jArr5;
                            iArr = iArr4;
                        }
                        i38++;
                        jArr5 = jArr;
                        i35 = i2;
                        iArr4 = iArr;
                    }
                    iG = chtVar.g(i16);
                }
                chtVar.e++;
                int i44 = chtVar.f;
                long[] jArr7 = chtVar.a;
                int i45 = iG >> 3;
                long j12 = jArr7[i45];
                int i46 = (iG & 7) << 3;
                if (((j12 >> i46) & j) != j2) {
                    i17 = 0;
                }
                chtVar.f = i44 - i17;
                int i47 = chtVar.d;
                long j13 = (j12 & (~(j << i46))) | (j4 << i46);
                jArr7[i45] = j13;
                jArr7[(((iG - 7) & i47) + (i47 & 7)) >> 3] = j13;
                break;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
            i8 = i16;
            i4 = i17;
            c2 = c4;
            c = c3;
            i6 = i15;
            i5 = i19;
        }
        chtVar.b[iG] = i;
        chtVar.c[iG] = dlgVar;
    }

    public final String toString() {
        return "SpanImpl{column=" + this.b + ", style=" + this.c + ", extra=null, extMap=" + this.j + '}';
    }
}
