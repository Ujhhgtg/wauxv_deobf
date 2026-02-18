package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class auz implements ahh, Serializable {
    public static final auz a = new auz();

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _t(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        return this;
    }

    @Override // me.hd.wauxv.obf.ahh
    public final Object _u(Object obj, bgj bgjVar) {
        return obj;
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _v(ahh ahhVar) {
        throwIfVar1IsNull(ahhVar, "context");
        return ahhVar;
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahf _w(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
