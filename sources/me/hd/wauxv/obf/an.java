package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class an extends dqc {
    public int a;
    public bzu b;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        bzo.q(bbbVar, "fbb");
        int i = this.a;
        if (i == 0) {
            throw new IllegalArgumentException("modifiers must not be 0");
        }
        byte b = this.b.d;
        bbbVar.ab(2);
        if (i != 0) {
            bbbVar.y(4, 0);
            ByteBuffer byteBuffer = bbbVar.a;
            int i2 = bbbVar.b - 4;
            bbbVar.b = i2;
            byteBuffer.putInt(i2, i);
            bbbVar.aa(0);
        }
        bbbVar.o(b, 1);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
