package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avp extends DexBaseQuery {
    public final long a;

    public avp(long j) {
        this.a = j;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        bbbVar.ab(1);
        long j = this.a;
        if (j != 0) {
            bbbVar.y(8, 0);
            ByteBuffer byteBuffer = bbbVar.a;
            int i = bbbVar.b - 8;
            bbbVar.b = i;
            byteBuffer.putLong(i, j);
            bbbVar.aa(0);
        }
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
