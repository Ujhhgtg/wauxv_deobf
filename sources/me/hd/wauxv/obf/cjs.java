package me.hd.wauxv.obf;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjs extends cjv {
    public final Class a;

    public cjs(Class cls) {
        super(true);
        if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
            this.a = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !cjs.class.equals(obj.getClass())) {
            return false;
        }
        return nullSafeIsEqual(this.a, ((cjs) obj).a);
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object f(String str, Bundle bundle) {
        throwIfVar1IsNull(bundle, "bundle");
        return bundle.get(str);
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
        throw new UnsupportedOperationException("Parcelables don't support default values.");
    }

    @Override // me.hd.wauxv.obf.cjv
    public final void j(Bundle bundle, String str, Object obj) {
        throwIfVar1IsNull(str, "key");
        this.a.cast(obj);
        if (obj == null || (obj instanceof Parcelable)) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        }
    }
}
