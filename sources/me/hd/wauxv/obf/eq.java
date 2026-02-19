package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eq extends doi implements bgj {
    public final /* synthetic */ int a = 2;
    public int d;
    public /* synthetic */ Object e;
    public Object f;

    public /* synthetic */ eq(int i, afw afwVar) {
        super(i, afwVar);
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((eq) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [me.hd.wauxv.obf.bgj, me.hd.wauxv.obf.doi] */
    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                eq eqVar = new eq((bgj) this.f, afwVar);
                eqVar.e = obj;
                return eqVar;
            case 1:
                return new eq((bqq) this.e, (zn) this.f, afwVar);
            default:
                eq eqVar2 = new eq(2, afwVar);
                eqVar2.e = obj;
                return eqVar2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d8, code lost:
    
        if (r12 == r4) goto L21;
     */
    /* JADX WARN: Type inference failed for: r0v3, types: [me.hd.wauxv.obf.bgj, me.hd.wauxv.obf.doi] */
    @Override // me.hd.wauxv.obf.nc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.Object r12) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.eq.i(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public eq(bgj bgjVar, afw afwVar) {
        super(2, afwVar);
        this.f = (doi) bgjVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq(bqq bqqVar, zn znVar, afw afwVar) {
        super(2, afwVar);
        this.e = bqqVar;
        this.f = znVar;
    }
}
