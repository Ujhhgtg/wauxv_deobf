package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class alq extends t implements alp {
    @Override // me.hd.wauxv.obf.alp
    public final Object _be(afw afwVar) throws Throwable {
        Object obj;
        do {
            obj = brm.r.get(this);
            if (!(obj instanceof bou)) {
                if (obj instanceof abr) {
                    throw ((abr) obj).c;
                }
                return bhv.ak(obj);
            }
        } while (an(obj) < 0);
        brj brjVar = new brj(cmz.ab(afwVar), this);
        aox aoxVarU = brjVar.u();
        if (aoxVarU != null && !(CancellableContinuation.d.get(brjVar) instanceof coo)) {
            aoxVarU.e();
            CancellableContinuation.e.set(brjVar, con.b);
        }
        bhv.ad(brjVar, new sz(cna.aa(this, true, new yd(brjVar, 2)), 1));
        return brjVar.t();
    }
}
