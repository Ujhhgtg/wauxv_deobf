package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enk extends dex {
    public final ThreadLocal i;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public enk(ahh ahhVar, doi doiVar) {
        enl enlVar = enl.a;
        super(ahhVar._w(enlVar) == null ? ahhVar._v(enlVar) : ahhVar, doiVar);
        this.i = new ThreadLocal();
        ahh ahhVar2 = doiVar.m;
        throwIfVar1IsNull(ahhVar2);
        if (ahhVar2._w(arj.a) instanceof Dispatcher) {
            return;
        }
        Object objAl = bhv.al(ahhVar, null);
        bhv.ag(ahhVar, objAl);
        au(ahhVar, objAl);
    }

    @Override // me.hd.wauxv.obf.dex
    public final void ar() {
        at();
    }

    public final boolean as() {
        boolean z = this.threadLocalIsSet && this.i.get() == null;
        this.i.remove();
        return !z;
    }

    public final void at() {
        if (this.threadLocalIsSet) {
            Pair pairVar = (Pair) this.i.get();
            if (pairVar != null) {
                bhv.ag((ahh) pairVar.first, pairVar.second);
            }
            this.i.remove();
        }
    }

    public final void au(ahh ahhVar, Object obj) {
        this.threadLocalIsSet = true;
        this.i.set(new Pair(ahhVar, obj));
    }

    @Override // me.hd.wauxv.obf.dex, me.hd.wauxv.obf.brm
    public final void l(Object obj) {
        at();
        Object objX = aye.x(obj);
        doi doiVar = this.aq;
        ahh ahhVar = doiVar.m;
        throwIfVar1IsNull(ahhVar);
        Object objAl = bhv.al(ahhVar, null);
        enk enkVarAu = objAl != bhv.q ? KotlinHelpers.au(doiVar, ahhVar, objAl) : null;
        try {
            doiVar._bn(objX);
        } finally {
            if (enkVarAu == null || enkVarAu.as()) {
                bhv.ag(ahhVar, objAl);
            }
        }
    }
}
