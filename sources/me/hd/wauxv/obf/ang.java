package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ang extends cjg implements bbn {
    public String a;

    @Override // me.hd.wauxv.obf.cjg
    public final void d(Context context, AttributeSet attributeSet) {
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, cyd.a);
        bzo.p(typedArrayObtainAttributes, "obtainAttributes(...)");
        String string = typedArrayObtainAttributes.getString(0);
        if (string != null) {
            this.a = string;
        }
        typedArrayObtainAttributes.recycle();
    }

    @Override // me.hd.wauxv.obf.cjg
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof ang) && super.equals(obj) && bzo.f(this.a, ((ang) obj).a);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
