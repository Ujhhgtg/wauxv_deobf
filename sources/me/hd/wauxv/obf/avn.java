package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avn extends avk {
    public final float a;

    public avn(float f) {
        this.a = f;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        bbbVar.ab(1);
        float f = this.a;
        if (f != 0.0d) {
            bbbVar.y(4, 0);
            ByteBuffer byteBuffer = bbbVar.a;
            int i = bbbVar.b - 4;
            bbbVar.b = i;
            byteBuffer.putFloat(i, f);
            bbbVar.aa(0);
        }
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
