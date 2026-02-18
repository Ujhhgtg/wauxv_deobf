package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class doi extends afx implements bgq {
    public final int q;

    public doi(int i, afw afwVar) {
        super(afwVar);
        this.q = i;
    }

    @Override // me.hd.wauxv.obf.bgq
    public final int getArity() {
        return this.q;
    }

    @Override // me.hd.wauxv.obf.nc
    public final String toString() {
        if (this.j != null) {
            return super.toString();
        }
        dal.a.getClass();
        String strA = dam.a(this);
        bzo.p(strA, "renderLambdaToString(...)");
        return strA;
    }
}
