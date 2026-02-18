package me.hd.wauxv.obf;

import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amj implements sg, sh {
    public final String a;
    public final ByteBuffer b;
    public final int c;
    public final /* synthetic */ amk d;

    public amj(amk amkVar, String str, ByteBuffer byteBuffer) {
        this.d = amkVar;
        this.a = str;
        this.b = byteBuffer;
        this.c = byteBuffer.position();
    }

    public final void e() {
        if ((this.b.position() & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
    }

    public final yt[] f(int i) {
        yt[] ytVarArr = new yt[i];
        int iAc = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iAc += ajn.ac(this);
            ytVarArr[i2] = new yt(iAc, ajn.ac(this), ajn.ac(this));
        }
        return ytVarArr;
    }

    public final String g() {
        ByteBuffer byteBuffer = this.b;
        int i = byteBuffer.getInt();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        byteBuffer.position(i);
        byteBuffer.limit(byteBuffer.capacity());
        try {
            try {
                int iAc = ajn.ac(this);
                String strT = bht.t(this, new char[iAc]);
                if (strT.length() == iAc) {
                    byteBuffer.position(iPosition);
                    byteBuffer.limit(iLimit);
                    return strT;
                }
                throw new amo("Declared length " + iAc + " doesn't match decoded length of " + strT.length(), null);
            } catch (UTFDataFormatException e) {
                throw new amo(null, e);
            }
        } catch (Throwable th) {
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            throw th;
        }
    }

    public final emd h() {
        short[] sArr;
        ByteBuffer byteBuffer = this.b;
        int i = byteBuffer.getInt();
        if (i == 0) {
            sArr = amk.a;
        } else {
            short[] sArr2 = new short[i];
            for (int i2 = 0; i2 < i; i2++) {
                sArr2[i2] = byteBuffer.getShort();
            }
            sArr = sArr2;
        }
        byteBuffer.position((byteBuffer.position() + 3) & (-4));
        return new emd(this.d, sArr);
    }

    public final int i() {
        return this.b.getShort() & 65535;
    }

    public final int j() {
        return this.b.position() - this.c;
    }

    public final void k(short s) {
        this.b.putShort(s);
    }

    public final void l(int i) {
        try {
            ajn.al(this, i);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new amo("Section limit " + this.b.limit() + " exceeded by " + this.a, null);
        }
    }

    public final void m(int i) {
        try {
            ajn.am(this, i);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new amo("Section limit " + this.b.limit() + " exceeded by " + this.a, null);
        }
    }

    public final void n(int i) {
        short s = (short) i;
        if (i != (65535 & s)) {
            throw new IllegalArgumentException(bjs.i(i, "Expected an unsigned short: "));
        }
        k(s);
    }

    @Override // me.hd.wauxv.obf.sg
    public final byte readByte() {
        return this.b.get();
    }

    public final void write(byte[] bArr) {
        this.b.put(bArr);
    }

    @Override // me.hd.wauxv.obf.sh
    public final void writeByte(int i) {
        this.b.put((byte) i);
    }

    public final void writeInt(int i) {
        this.b.putInt(i);
    }
}
