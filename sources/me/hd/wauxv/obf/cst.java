package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cst extends dqc {
    public DexMethodGroupMatcher a;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        DexMethodGroupMatcher zbVar = this.a;
        int iC = zbVar != null ? zbVar.c(bbbVar) : 0;
        bbbVar.ab(2);
        bbbVar.q(1, iC);
        bbbVar.q(0, 0);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
