package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqh extends dqc {
    public int a;
    public int b;

    public bqh(int i) {
        this.a = i;
        this.b = i;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        bzo.q(bbbVar, "fbb");
        int i = this.a;
        int i2 = this.b;
        bbbVar.ab(2);
        if (i2 != 0) {
            bbbVar.y(4, 0);
            ByteBuffer byteBuffer = bbbVar.a;
            int i3 = bbbVar.b - 4;
            bbbVar.b = i3;
            byteBuffer.putInt(i3, i2);
            bbbVar.aa(1);
        }
        if (i != 0) {
            bbbVar.y(4, 0);
            ByteBuffer byteBuffer2 = bbbVar.a;
            int i4 = bbbVar.b - 4;
            bbbVar.b = i4;
            byteBuffer2.putInt(i4, i);
            bbbVar.aa(0);
        }
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
