package me.hd.wauxv.obf;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final byte[] a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(uj.a);
        throwIfVar1IsNull(bytes, "this as java.lang.String).getBytes(charset)");
        a = bytes;
    }

    public static final boolean b(dfj dfjVar, int i, byte[] bArr, int i2) {
        int i3 = dfjVar.c;
        byte[] bArr2 = dfjVar.a;
        for (int i4 = 1; i4 < i2; i4++) {
            if (i == i3) {
                dfjVar = dfjVar.f;
                throwIfVar1IsNull(dfjVar);
                bArr2 = dfjVar.a;
                i = dfjVar.b;
                i3 = dfjVar.c;
            }
            if (bArr2[i] != bArr[i4]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static final String c(rh rhVar, long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (rhVar.n(j2) == 13) {
                String strZ = rhVar.z(j2, uj.a);
                rhVar.skip(2L);
                return strZ;
            }
        }
        String strZ2 = rhVar.z(j, uj.a);
        rhVar.skip(1L);
        return strZ2;
    }

    /*
     * JADX WARN: Found duplicated region for block: B:49:0x00a3 A[LOOP:0:
     * B:8:0x001e->B:49:0x00a3, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:55:0x00a2 A[SYNTHETIC] */
    public static final int d(rh rhVar, crv crvVar, boolean z) {
        int i;
        int i2;
        int i3;
        dfj dfjVar;
        int i4;
        throwIfVar1IsNull(crvVar, "options");
        dfj dfjVar2 = rhVar.a;
        if (dfjVar2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = dfjVar2.a;
        int i5 = dfjVar2.b;
        int i6 = dfjVar2.c;
        int[] iArr = crvVar.c;
        dfj dfjVar3 = dfjVar2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            int i11 = i8 + 2;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (dfjVar3 == null) {
                break;
            }
            if (i10 >= 0) {
                int i13 = i5 + 1;
                int i14 = bArr[i5] & 255;
                int i15 = i11 + i10;
                while (i11 != i15) {
                    if (i14 == iArr[i11]) {
                        i = iArr[i11 + i10];
                        if (i13 == i6) {
                            dfjVar3 = dfjVar3.f;
                            throwIfVar1IsNull(dfjVar3);
                            int i16 = dfjVar3.b;
                            byte[] bArr2 = dfjVar3.a;
                            i2 = dfjVar3.c;
                            if (dfjVar3 == dfjVar2) {
                                i3 = i16;
                                bArr = bArr2;
                                dfjVar3 = null;
                            } else {
                                i3 = i16;
                                bArr = bArr2;
                            }
                        } else {
                            i2 = i6;
                            i3 = i13;
                        }
                        if (i >= 0) {
                            return i;
                        }
                        int i17 = i2;
                        i8 = -i;
                        i5 = i3;
                        i6 = i17;
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i18 = (i10 * (-1)) + i11;
            while (true) {
                int i19 = i5 + 1;
                int i20 = i11 + 1;
                if ((bArr[i5] & 255) == iArr[i11]) {
                    boolean z2 = i20 == i18;
                    if (i19 == i6) {
                        throwIfVar1IsNull(dfjVar3);
                        dfj dfjVar4 = dfjVar3.f;
                        throwIfVar1IsNull(dfjVar4);
                        i3 = dfjVar4.b;
                        byte[] bArr3 = dfjVar4.a;
                        i4 = dfjVar4.c;
                        if (dfjVar4 != dfjVar2) {
                            dfjVar = dfjVar4;
                            bArr = bArr3;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr3;
                            dfjVar = null;
                        }
                    } else {
                        dfjVar = dfjVar3;
                        i4 = i6;
                        i3 = i19;
                    }
                    if (z2) {
                        i = iArr[i20];
                        int i21 = i4;
                        dfjVar3 = dfjVar;
                        i2 = i21;
                        break;
                    }
                    i5 = i3;
                    i6 = i4;
                    dfjVar3 = dfjVar;
                    i11 = i20;
                }
                return i7;
            }
            if (i >= 0) {
                return i;
            }
            int i172 = i2;
            i8 = -i;
            i5 = i3;
            i6 = i172;
        }
        if (z) {
            return -2;
        }
        return i7;
    }
}
