package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rg extends InputStream {
    public final /* synthetic */ int a;
    public final /* synthetic */ rm b;

    public /* synthetic */ rg(rm rmVar, int i) {
        this.a = i;
        this.b = rmVar;
    }

    private final void c() {
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jMin;
        switch (this.a) {
            case 0:
                jMin = Math.min(((rh) this.b).b, Integer.MAX_VALUE);
                break;
            default:
                cyl cylVar = (cyl) this.b;
                if (cylVar.d) {
                    throw new IOException("closed");
                }
                jMin = Math.min(cylVar.b.b, Integer.MAX_VALUE);
                break;
        }
        return (int) jMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.a) {
            case 0:
                break;
            default:
                ((cyl) this.b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.a) {
            case 0:
                rh rhVar = (rh) this.b;
                if (rhVar.b > 0) {
                    return rhVar.readByte() & 255;
                }
                return -1;
            default:
                cyl cylVar = (cyl) this.b;
                rh rhVar2 = cylVar.b;
                if (cylVar.d) {
                    throw new IOException("closed");
                }
                if (rhVar2.b == 0 && cylVar.a.read(rhVar2, 8192L) == -1) {
                    return -1;
                }
                return rhVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return ((rh) this.b) + ".inputStream()";
            default:
                return ((cyl) this.b) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        switch (this.a) {
            case 0:
                bzo.q(bArr, "sink");
                return ((rh) this.b).read(bArr, i, i2);
            default:
                bzo.q(bArr, "data");
                cyl cylVar = (cyl) this.b;
                rh rhVar = cylVar.b;
                if (!cylVar.d) {
                    aye.n(bArr.length, i, i2);
                    if (rhVar.b == 0 && cylVar.a.read(rhVar, 8192L) == -1) {
                        return -1;
                    }
                    return rhVar.read(bArr, i, i2);
                }
                throw new IOException("closed");
        }
    }
}
