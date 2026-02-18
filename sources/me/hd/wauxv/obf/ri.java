package me.hd.wauxv.obf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ri implements ajh, ako, crt {
    public final /* synthetic */ int a;
    public ByteBuffer b;

    public ri(int i, ByteBuffer byteBuffer) {
        this.a = i;
        switch (i) {
            case 2:
                this.b = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                break;
            default:
                this.b = byteBuffer;
                break;
        }
    }

    @Override // me.hd.wauxv.obf.ajh
    public void c() {
    }

    @Override // me.hd.wauxv.obf.ajh
    public Object d() {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // me.hd.wauxv.obf.crt
    public void e(byte[] bArr, Object obj, MessageDigest messageDigest) {
        switch (this.a) {
            case 3:
                Long l = (Long) obj;
                messageDigest.update(bArr);
                synchronized (this.b) {
                    this.b.position(0);
                    messageDigest.update(this.b.putLong(l.longValue()).array());
                    break;
                }
                return;
            default:
                Integer num = (Integer) obj;
                if (num == null) {
                    return;
                }
                messageDigest.update(bArr);
                synchronized (this.b) {
                    this.b.position(0);
                    messageDigest.update(this.b.putInt(num.intValue()).array());
                    break;
                }
                return;
        }
    }

    @Override // me.hd.wauxv.obf.ako
    public int f() {
        return (h() << 8) | h();
    }

    public boolean g() {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null) {
            throwLateinitPropNotInitYet("buffer" /* cnb.z(-22574348106538L) */);
            throw null;
        }
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.b;
        if (byteBuffer2 != null) {
            return iLimit - byteBuffer2.position() <= 1;
        }
        throwLateinitPropNotInitYet("buffer" /* cnb.z(-23076859280170L) */);
        throw null;
    }

    @Override // me.hd.wauxv.obf.ako
    public short h() throws akn {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new akn();
    }

    @Override // me.hd.wauxv.obf.ako
    public int i(int i, byte[] bArr) {
        ByteBuffer byteBuffer = this.b;
        int iMin = Math.min(i, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    @Override // me.hd.wauxv.obf.ako
    public long skip(long j) {
        ByteBuffer byteBuffer = this.b;
        int iMin = (int) Math.min(byteBuffer.remaining(), j);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    public ri(int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.b = ByteBuffer.allocate(8);
                break;
            case 4:
                this.b = ByteBuffer.allocate(4);
                break;
        }
    }
}
