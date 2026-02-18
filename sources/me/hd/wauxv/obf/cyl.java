package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyl implements rm {
    public final dlc a;
    public final rh b;
    public boolean d;

    public cyl(dlc dlcVar) {
        throwIfVar1IsNull(dlcVar, "source");
        this.a = dlcVar;
        this.b = new rh();
    }

    @Override // me.hd.wauxv.obf.rm
    public final String aa() {
        return m(Long.MAX_VALUE);
    }

    @Override // me.hd.wauxv.obf.rm
    public final int ab(crv crvVar) throws EOFException {
        rh rhVar;
        throwIfVar1IsNull(crvVar, "options");
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        do {
            rhVar = this.b;
            int iD = b.d(rhVar, crvVar, true);
            if (iD != -2) {
                if (iD == -1) {
                    break;
                }
                rhVar.skip(crvVar.b[iD].g());
                return iD;
            }
        } while (this.a.read(rhVar, 8192L) != -1);
        return -1;
    }

    @Override // me.hd.wauxv.obf.rm
    public final void ah(long j) throws EOFException {
        if (!x(j)) {
            throw new EOFException();
        }
    }

    @Override // me.hd.wauxv.obf.rm
    public final long aj() throws EOFException {
        rh rhVar;
        ah(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            boolean zX = x(i2);
            rhVar = this.b;
            if (!zX) {
                break;
            }
            byte bN = rhVar.n(i);
            if ((bN < 48 || bN > 57) && ((bN < 97 || bN > 102) && (bN < 65 || bN > 70))) {
                if (i != 0) {
                    break;
                }
                cmz.o(16);
                cmz.o(16);
                String string = Integer.toString(bN, 16);
                throwIfVar1IsNull(string, "toString(this, checkRadix(radix))");
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
            }
            i = i2;
        }
        return rhVar.aj();
    }

    @Override // me.hd.wauxv.obf.rm
    public final InputStream ak() {
        return new rg(this, 1);
    }

    @Override // me.hd.wauxv.obf.rm
    public final rh c() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.close();
        this.b.d();
    }

    @Override // me.hd.wauxv.obf.rm
    public final sj e(long j) throws EOFException {
        ah(j);
        return this.b.e(j);
    }

    public final long f(long j, long j2, byte b) {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (0 > j2) {
            throw new IllegalArgumentException(dts.b(j2, "fromIndex=0 toIndex=").toString());
        }
        long jMax = 0;
        while (jMax < j2) {
            rh rhVar = this.b;
            long j3 = j2;
            byte b2 = b;
            long jO = rhVar.o(jMax, j3, b2);
            if (jO != -1) {
                return jO;
            }
            long j4 = rhVar.b;
            if (j4 >= j3 || this.a.read(rhVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j4);
            j2 = j3;
            b = b2;
        }
        return -1L;
    }

    public final int g() throws EOFException {
        ah(4L);
        int i = this.b.readInt();
        return ((i & Opcodes.CONST_METHOD_TYPE) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8)
                | ((65280 & i) << 8);
    }

    @Override // me.hd.wauxv.obf.rm
    public final byte[] h() {
        dlc dlcVar = this.a;
        rh rhVar = this.b;
        rhVar.r(dlcVar);
        return rhVar.y(rhVar.b);
    }

    @Override // me.hd.wauxv.obf.rm
    public final boolean i() {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        rh rhVar = this.b;
        return rhVar.i() && this.a.read(rhVar, 8192L) == -1;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.d;
    }

    @Override // me.hd.wauxv.obf.rm
    public final long k() throws EOFException {
        rh rhVar;
        ah(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            boolean zX = x(j2);
            rhVar = this.b;
            if (!zX) {
                break;
            }
            byte bN = rhVar.n(j);
            if ((bN < 48 || bN > 57) && !(j == 0 && bN == 45)) {
                if (j != 0) {
                    break;
                }
                cmz.o(16);
                cmz.o(16);
                String string = Integer.toString(bN, 16);
                throwIfVar1IsNull(string, "toString(this, checkRadix(radix))");
                throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
            }
            j = j2;
        }
        return rhVar.k();
    }

    @Override // me.hd.wauxv.obf.rm
    public final String m(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "limit < 0: ").toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jF = f(0L, j2, (byte) 10);
        rh rhVar = this.b;
        if (jF != -1) {
            return b.createInstanceWithArgs(rhVar, jF);
        }
        if (j2 < Long.MAX_VALUE && x(j2) && rhVar.n(j2 - 1) == 13 && x(j2 + 1) && rhVar.n(j2) == 10) {
            return b.createInstanceWithArgs(rhVar, j2);
        }
        rh rhVar2 = new rh();
        rhVar.l(0L, rhVar2, Math.min(32, rhVar.b));
        throw new EOFException(
                "\\n not found: limit=" + Math.min(rhVar.b, j) + " content=" + rhVar2.e(rhVar2.b).h() + (char) 8230);
    }

    @Override // me.hd.wauxv.obf.rm
    public final void p(rh rhVar, long j) throws EOFException {
        rh rhVar2 = this.b;
        throwIfVar1IsNull(rhVar, "sink");
        try {
            ah(j);
            rhVar2.p(rhVar, j);
        } catch (EOFException e) {
            rhVar.r(rhVar2);
            throw e;
        }
    }

    @Override // me.hd.wauxv.obf.rm
    public final cyl peek() {
        return emc.ah(new ctg(this));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        throwIfVar1IsNull(byteBuffer, "sink");
        rh rhVar = this.b;
        if (rhVar.b == 0 && this.a.read(rhVar, 8192L) == -1) {
            return -1;
        }
        return rhVar.read(byteBuffer);
    }

    @Override // me.hd.wauxv.obf.rm
    public final byte readByte() throws EOFException {
        ah(1L);
        return this.b.readByte();
    }

    @Override // me.hd.wauxv.obf.rm
    public final void readFully(byte[] bArr) throws EOFException {
        rh rhVar = this.b;
        throwIfVar1IsNull(bArr, "sink");
        try {
            ah(bArr.length);
            rhVar.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                long j = rhVar.b;
                if (j <= 0) {
                    throw e;
                }
                int i2 = rhVar.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // me.hd.wauxv.obf.rm
    public final int readInt() throws EOFException {
        ah(4L);
        return this.b.readInt();
    }

    @Override // me.hd.wauxv.obf.rm
    public final long readLong() throws EOFException {
        ah(8L);
        return this.b.readLong();
    }

    @Override // me.hd.wauxv.obf.rm
    public final short readShort() throws EOFException {
        ah(2L);
        return this.b.readShort();
    }

    @Override // me.hd.wauxv.obf.rm
    public final String readString(Charset charset) {
        throwIfVar1IsNull(charset, "charset");
        dlc dlcVar = this.a;
        rh rhVar = this.b;
        rhVar.r(dlcVar);
        return rhVar.readString(charset);
    }

    @Override // me.hd.wauxv.obf.rm
    public final boolean s(long j, sj sjVar) {
        throwIfVar1IsNull(sjVar, "bytes");
        int iG = sjVar.g();
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (iG >= 0 && sjVar.g() >= iG) {
            for (int i = 0; i < iG; i++) {
                long j2 = i;
                if (x(1 + j2) && this.b.n(j2) == sjVar.j(i)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.rm
    public final void skip(long j) throws EOFException {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            rh rhVar = this.b;
            if (rhVar.b == 0 && this.a.read(rhVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, rhVar.b);
            rhVar.skip(jMin);
            j -= jMin;
        }
    }

    @Override // me.hd.wauxv.obf.dlc
    public final ekc timeout() {
        return this.a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // me.hd.wauxv.obf.rm
    public final sj w() {
        dlc dlcVar = this.a;
        rh rhVar = this.b;
        rhVar.r(dlcVar);
        return rhVar.e(rhVar.b);
    }

    @Override // me.hd.wauxv.obf.rm
    public final boolean x(long j) {
        rh rhVar;
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        do {
            rhVar = this.b;
            if (rhVar.b >= j) {
                return true;
            }
        } while (this.a.read(rhVar, 8192L) != -1);
        return false;
    }

    @Override // me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) {
        throwIfVar1IsNull(rhVar, "sink");
        if (j >= 0) {
            if (!this.d) {
                rh rhVar2 = this.b;
                if (rhVar2.b == 0 && this.a.read(rhVar2, 8192L) == -1) {
                    return -1L;
                }
                return rhVar2.read(rhVar, Math.min(j, rhVar2.b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
    }
}
