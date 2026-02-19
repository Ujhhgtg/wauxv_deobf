package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t extends brm implements afw, ahp {
    public final ahh a;

    public t(ahh ahhVar, boolean z) {
        super(z);
        ae((brf) ahhVar._w(arj.i));
        this.a = ahhVar._v(this);
    }

    @Override // me.hd.wauxv.obf.afw
    public final void _bn(Object obj) {
        Throwable thB = dcy.b(obj);
        if (thB != null) {
            obj = new abr(thB, false);
        }
        Object objAi = ai(obj);
        if (objAi == bhv.k) {
            return;
        }
        l(objAi);
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.brm
    public final String d() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // me.hd.wauxv.obf.ahp
    public final ahh e() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.brm
    public final void f(QueryDidNotReturnUniqueResultRuntimeException abtVar) {
        cna.z(this.a, abtVar);
    }

    @Override // me.hd.wauxv.obf.brm
    public final void g(Object obj) {
        if (obj instanceof abr) {
            abr.b.get((abr) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(ahs ahsVar, t tVar, bgj bgjVar) {
        int iOrdinal = ahsVar.ordinal();
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        if (iOrdinal == 0) {
            try {
                HugeSyntheticPileOfHelpers.resumeCoroutine(kotlinUnitVar, cmz.ab(((nc) bgjVar).h(tVar, this)));
                return;
            } catch (Throwable th) {
                th = th;
                if (th instanceof aoq) {
                    th = ((aoq) th).a;
                }
                _bn(FastKV.x(th));
                throw th;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                cmz.ab(((nc) bgjVar).h(tVar, this))._bn(kotlinUnitVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new QueryDidNotReturnUniqueResultRuntimeException();
            }
            try {
                ahh ahhVar = this.a;
                Object objAl = bhv.al(ahhVar, null);
                try {
                    emc.af(2, bgjVar);
                    Object objG = bgjVar.g(tVar, this);
                    bhv.ag(ahhVar, objAl);
                    if (objG != ahq.a) {
                        _bn(objG);
                    }
                } catch (Throwable th2) {
                    bhv.ag(ahhVar, objAl);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                if (th instanceof aoq) {
                    th = ((aoq) th).a;
                }
                _bn(FastKV.x(th));
            }
        }
    }
}
