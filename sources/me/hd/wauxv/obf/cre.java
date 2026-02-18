package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cre extends cwl {
    public boolean ac;

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.acm
    public final int f(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        if (this.ac) {
            return -1;
        }
        this.ac = true;
        return 0;
    }

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.ajt
    public final acm p(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        emc emcVarH = dfxVar.h();
        if (!nullSafeIsEqual(emcVarH, dnt.a) && !nullSafeIsEqual(emcVarH, dnt.n) && !(emcVarH instanceof cur)) {
            throw new dgb("Type " + dfxVar.h() + " cannot be directly child of oneof element");
        }
        long j_br = _br();
        if (j_br == 19500 && nullSafeIsEqual(this.aj, dfxVar)) {
            return this;
        }
        if (ajn.w(j_br)) {
            throw new dgb("An oneof element cannot be directly child of another oneof element");
        }
        return new cwl(this.ah, cnf.al(this.ai, j_br), dfxVar);
    }
}
