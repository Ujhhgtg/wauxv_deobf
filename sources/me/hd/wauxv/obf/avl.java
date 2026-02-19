package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avl extends DexBaseQuery {
    public final byte a;

    public avl(byte b) {
        this.a = b;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        bbbVar.ab(1);
        bbbVar.o(this.a, 0);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
