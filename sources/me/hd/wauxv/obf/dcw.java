package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dcw extends nc implements bgq {
    public final int f;

    public dcw(int i, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        super(afwVar);
        if (afwVar != null && afwVar.c() != EmptyCoroutineContext.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
        this.f = i;
    }

    @Override // me.hd.wauxv.obf.afw
    public final ahh c() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.bgq
    public final int getArity() {
        return this.f;
    }

    @Override // me.hd.wauxv.obf.nc
    public final String toString() {
        if (this.j != null) {
            return super.toString();
        }
        dal.a.getClass();
        String strA = dam.a(this);
        throwIfVar1IsNull(strA, "renderLambdaToString(...)");
        return strA;
    }
}
