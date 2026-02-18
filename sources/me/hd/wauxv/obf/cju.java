package me.hd.wauxv.obf;

import android.os.Bundle;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cju extends cjv {
    public final Class e;

    public cju(Class cls) {
        super(true);
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
        if (!cls.isEnum()) {
            this.e = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
    }

    @Override // me.hd.wauxv.obf.cjv
    /*
     * JADX INFO: renamed from: c, reason: merged with bridge method
     * [inline-methods]
     */
    public Serializable i(String str) {
        throwIfVar1IsNull(str, "value");
        throw new UnsupportedOperationException("Serializables don't support default values.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cju)) {
            return false;
        }
        return nullSafeIsEqual(this.e, ((cju) obj).e);
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object f(String str, Bundle bundle) {
        throwIfVar1IsNull(bundle, "bundle");
        return (Serializable) bundle.get(str);
    }

    @Override // me.hd.wauxv.obf.cjv
    public String g() {
        return this.e.getName();
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    @Override // me.hd.wauxv.obf.cjv
    public final void j(Bundle bundle, String str, Object obj) {
        Serializable serializable = (Serializable) obj;
        throwIfVar1IsNull(str, "key");
        throwIfVar1IsNull(serializable, "value");
        this.e.cast(serializable);
        bundle.putSerializable(str, serializable);
    }

    public cju(Class cls, int i) {
        super(false);
        if (Serializable.class.isAssignableFrom(cls)) {
            this.e = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
    }
}
