package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fm extends dqc {
    public zb a;
    public fi b;

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        bzo.q(bbbVar, "fbb");
        zb zbVar = this.a;
        int iC = zbVar != null ? zbVar.c(bbbVar) : 0;
        fi fiVar = this.b;
        int iC2 = fiVar != null ? fiVar.c(bbbVar) : 0;
        bbbVar.ab(5);
        bbbVar.q(4, 0);
        bbbVar.q(3, iC2);
        bbbVar.q(1, 0);
        bbbVar.q(0, iC);
        bbbVar.o((byte) 0, 2);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
