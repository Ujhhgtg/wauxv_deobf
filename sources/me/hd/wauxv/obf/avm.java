package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avm extends avk {
    public final double a;

    public avm(double d) {
        this.a = d;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        bzo.q(bbbVar, "fbb");
        bbbVar.ab(1);
        double d = this.a;
        if (d != 0.0d) {
            bbbVar.y(8, 0);
            ByteBuffer byteBuffer = bbbVar.a;
            int i = bbbVar.b - 8;
            bbbVar.b = i;
            byteBuffer.putDouble(i, d);
            bbbVar.aa(0);
        }
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
