package me.hd.wauxv.obf;

import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rf implements Closeable {
    public rh a;
    public boolean b;
    public dfj c;
    public byte[] e;
    public long d = -1;
    public int f = -1;
    public int g = -1;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.a == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.a = null;
        this.c = null;
        this.d = -1L;
        this.e = null;
        this.f = -1;
        this.g = -1;
    }

    public final void h(long j) {
        rh rhVar = this.a;
        if (rhVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j2 = rhVar.b;
        if (j <= j2) {
            if (j < 0) {
                throw new IllegalArgumentException(dts.b(j, "newSize < 0: ").toString());
            }
            long j3 = j2 - j;
            while (j3 > 0) {
                dfj dfjVar = rhVar.a;
                bzo.n(dfjVar);
                dfj dfjVar2 = dfjVar.g;
                bzo.n(dfjVar2);
                int i = dfjVar2.c;
                long j4 = i - dfjVar2.b;
                if (j4 > j3) {
                    dfjVar2.c = i - ((int) j3);
                    break;
                } else {
                    rhVar.a = dfjVar2.h();
                    dfl.d(dfjVar2);
                    j3 -= j4;
                }
            }
            this.c = null;
            this.d = j;
            this.e = null;
            this.f = -1;
            this.g = -1;
        } else if (j > j2) {
            long j5 = j - j2;
            int i2 = 1;
            boolean z = true;
            for (long j6 = 0; j5 > j6; j6 = 0) {
                dfj dfjVarAg = rhVar.ag(i2);
                int iMin = (int) Math.min(j5, 8192 - dfjVarAg.c);
                int i3 = dfjVarAg.c + iMin;
                dfjVarAg.c = i3;
                j5 -= (long) iMin;
                if (z) {
                    this.c = dfjVarAg;
                    this.d = j2;
                    this.e = dfjVarAg.a;
                    this.f = i3 - iMin;
                    this.g = i3;
                    z = false;
                }
                i2 = 1;
            }
        }
        rhVar.b = j;
    }

    public final int i(long j) {
        rh rhVar = this.a;
        if (rhVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j >= -1) {
            long j2 = rhVar.b;
            if (j <= j2) {
                if (j == -1 || j == j2) {
                    this.c = null;
                    this.d = j;
                    this.e = null;
                    this.f = -1;
                    this.g = -1;
                    return -1;
                }
                dfj dfjVar = rhVar.a;
                dfj dfjVar2 = this.c;
                long j3 = 0;
                if (dfjVar2 != null) {
                    long j4 = this.d - ((long) (this.f - dfjVar2.b));
                    if (j4 > j) {
                        dfjVar2 = dfjVar;
                        dfjVar = dfjVar2;
                        j2 = j4;
                    } else {
                        j3 = j4;
                    }
                } else {
                    dfjVar2 = dfjVar;
                }
                if (j2 - j > j - j3) {
                    while (true) {
                        bzo.n(dfjVar2);
                        long j5 = ((long) (dfjVar2.c - dfjVar2.b)) + j3;
                        if (j < j5) {
                            break;
                        }
                        dfjVar2 = dfjVar2.f;
                        j3 = j5;
                    }
                } else {
                    while (j2 > j) {
                        bzo.n(dfjVar);
                        dfjVar = dfjVar.g;
                        bzo.n(dfjVar);
                        j2 -= (long) (dfjVar.c - dfjVar.b);
                    }
                    dfjVar2 = dfjVar;
                    j3 = j2;
                }
                if (this.b) {
                    bzo.n(dfjVar2);
                    if (dfjVar2.d) {
                        byte[] bArr = dfjVar2.a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        bzo.p(bArrCopyOf, "copyOf(this, size)");
                        dfj dfjVar3 = new dfj(bArrCopyOf, dfjVar2.b, dfjVar2.c, false, true);
                        if (rhVar.a == dfjVar2) {
                            rhVar.a = dfjVar3;
                        }
                        dfjVar2.i(dfjVar3);
                        dfj dfjVar4 = dfjVar3.g;
                        bzo.n(dfjVar4);
                        dfjVar4.h();
                        dfjVar2 = dfjVar3;
                    }
                }
                this.c = dfjVar2;
                this.d = j;
                bzo.n(dfjVar2);
                this.e = dfjVar2.a;
                int i = dfjVar2.b + ((int) (j - j3));
                this.f = i;
                int i2 = dfjVar2.c;
                this.g = i2;
                return i2 - i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + rhVar.b);
    }
}
