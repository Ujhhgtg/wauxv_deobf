package me.hd.wauxv.obf;

import android.os.Bundle;
import java.io.Serializable;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjt extends cjv {
    public final Class a;

    public cjt(Class cls) {
        super(true);
        if (!Serializable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
        try {
            this.a = Class.forName("[L" + cls.getName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !cjt.class.equals(obj.getClass())) {
            return false;
        }
        return bzo.f(this.a, ((cjt) obj).a);
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object f(String str, Bundle bundle) {
        bzo.q(bundle, "bundle");
        return (Serializable[]) bundle.get(str);
    }

    @Override // me.hd.wauxv.obf.cjv
    public final String g() {
        return this.a.getName();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object i(String str) {
        bzo.q(str, "value");
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Serializable, java.io.Serializable[], java.lang.Object] */
    @Override // me.hd.wauxv.obf.cjv
    public final void j(Bundle bundle, String str, Object obj) {
        ?? r4 = (Serializable[]) obj;
        bzo.q(str, "key");
        this.a.cast(r4);
        bundle.putSerializable(str, r4);
    }
}
