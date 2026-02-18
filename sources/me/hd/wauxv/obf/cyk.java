package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyk implements rl {
    public final dhy a;
    public final rh b;
    public boolean d;

    public cyk(dhy dhyVar) {
        bzo.q(dhyVar, "sink");
        this.a = dhyVar;
        this.b = new rh();
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl ae(sj sjVar) {
        bzo.q(sjVar, "byteString");
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.al(sjVar);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl af(int i, int i2, byte[] bArr) {
        bzo.q(bArr, "source");
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.write(bArr, i, i2);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl ai(long j) {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.an(j);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rh c() {
        return this.b;
    }

    @Override // me.hd.wauxv.obf.dhy, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        dhy dhyVar = this.a;
        if (this.d) {
            return;
        }
        rh rhVar = this.b;
        long j = rhVar.b;
        if (j > 0) {
            dhyVar.write(rhVar, j);
        }
        th = null;
        try {
            dhyVar.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // me.hd.wauxv.obf.rl, me.hd.wauxv.obf.dhy, java.io.Flushable
    public final void flush() {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        rh rhVar = this.b;
        long j = rhVar.b;
        dhy dhyVar = this.a;
        if (j > 0) {
            dhyVar.write(rhVar, j);
        }
        dhyVar.flush();
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl g() {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        rh rhVar = this.b;
        long j = rhVar.b;
        if (j > 0) {
            this.a.write(rhVar, j);
        }
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.d;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl j() {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        rh rhVar = this.b;
        long j = rhVar.b;
        if (j == 0) {
            j = 0;
        } else {
            dfj dfjVar = rhVar.a;
            bzo.n(dfjVar);
            dfj dfjVar2 = dfjVar.g;
            bzo.n(dfjVar2);
            int i = dfjVar2.c;
            if (i < 8192 && dfjVar2.e) {
                j -= (long) (i - dfjVar2.b);
            }
        }
        if (j > 0) {
            this.a.write(rhVar, j);
        }
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl q(String str) {
        bzo.q(str, "string");
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.at(str);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final long r(dlc dlcVar) {
        long j = 0;
        while (true) {
            long j2 = dlcVar.read(this.b, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            j();
        }
    }

    @Override // me.hd.wauxv.obf.dhy
    public final ekc timeout() {
        return this.a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl u(long j) {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.ao(j);
        j();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        bzo.q(byteBuffer, "source");
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.b.write(byteBuffer);
        j();
        return iWrite;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl writeByte(int i) {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.am(i);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl writeInt(int i) {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.ap(i);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl writeShort(int i) {
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        this.b.ar(i);
        j();
        return this;
    }

    @Override // me.hd.wauxv.obf.dhy
    public final void write(rh rhVar, long j) {
        bzo.q(rhVar, "source");
        if (!this.d) {
            this.b.write(rhVar, j);
            j();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl write(byte[] bArr) {
        bzo.q(bArr, "source");
        if (!this.d) {
            this.b.m12write(bArr);
            j();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
