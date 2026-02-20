package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azi extends dqc {
    public dnf a;
    public DexMethodGroupMatcher b;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        dnf dnfVar = this.a;
        int iC = dnfVar != null ? dnfVar.c(bbbVar) : 0;
        DexMethodGroupMatcher zbVar = this.b;
        int iC2 = zbVar != null ? zbVar.c(bbbVar) : 0;
        bbbVar.ab(7);
        bbbVar.q(6, 0);
        bbbVar.q(5, 0);
        bbbVar.q(4, 0);
        bbbVar.q(3, iC2);
        bbbVar.q(2, 0);
        bbbVar.q(1, 0);
        bbbVar.q(0, iC);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
