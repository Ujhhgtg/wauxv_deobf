package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fh extends dqc {
    public dnf a;
    public fk b;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        fl flVar;
        bzo.q(bbbVar, "fbb");
        dnf dnfVar = this.a;
        int iC = dnfVar != null ? dnfVar.c(bbbVar) : 0;
        fk fkVar = this.b;
        byte b = (fkVar == null || (flVar = fkVar.b) == null) ? (byte) 0 : flVar.d;
        dqc dqcVar = fkVar != null ? fkVar.a : null;
        int iC2 = dqcVar != null ? dqcVar.c(bbbVar) : 0;
        bbbVar.ab(3);
        bbbVar.q(2, iC2);
        bbbVar.q(0, iC);
        bbbVar.o(b, 1);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
