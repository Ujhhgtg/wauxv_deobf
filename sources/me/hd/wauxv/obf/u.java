package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u implements ahf {
    public final ahg a;

    public u(ahg ahgVar) {
        this.a = ahgVar;
    }

    @Override // me.hd.wauxv.obf.ahh
    public /* bridge */ ahh _t(ahg ahgVar) {
        return bmy.x(this, ahgVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final Object _u(Object obj, bgj bgjVar) {
        return bgjVar.g(obj, this);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final /* bridge */ ahh _v(ahh ahhVar) {
        return bmy.aa(this, ahhVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public ahf _w(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        if (nullSafeIsEqual(getKey(), ahgVar)) {
            return this;
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.ahf
    public final ahg getKey() {
        return this.a;
    }
}
