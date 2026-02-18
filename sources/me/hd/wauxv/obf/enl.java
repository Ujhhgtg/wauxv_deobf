package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enl implements ahf, ahg {
    public static final enl a = new enl();

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _t(ahg ahgVar) {
        return bmy.x(this, ahgVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final Object _u(Object obj, bgj bgjVar) {
        return bgjVar.g(obj, this);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _v(ahh ahhVar) {
        return bmy.aa(this, ahhVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahf _w(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        if (nullSafeIsEqual(this, ahgVar)) {
            return this;
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.ahf
    public final ahg getKey() {
        return this;
    }
}
