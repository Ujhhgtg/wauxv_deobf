package me.hd.wauxv.obf;

import android.os.Bundle;
import android.os.Parcelable;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjr extends cjv {
    public final Class a;

    public cjr(Class cls) {
        super(true);
        if (!Parcelable.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
        }
        try {
            this.a = Class.forName("[L" + cls.getName()
                    + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !cjr.class.equals(obj.getClass())) {
            return false;
        }
        return nullSafeIsEqual(this.a, ((cjr) obj).a);
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object f(String str, Bundle bundle) {
        throwIfVar1IsNull(bundle, "bundle");
        return (Parcelable[]) bundle.get(str);
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
        throwIfVar1IsNull(str, "value");
        throw new UnsupportedOperationException("Arrays don't support default values.");
    }

    @Override // me.hd.wauxv.obf.cjv
    public final void j(Bundle bundle, String str, Object obj) {
        Parcelable[] parcelableArr = (Parcelable[]) obj;
        throwIfVar1IsNull(str, "key");
        this.a.cast(parcelableArr);
        bundle.putParcelableArray(str, parcelableArr);
    }
}
