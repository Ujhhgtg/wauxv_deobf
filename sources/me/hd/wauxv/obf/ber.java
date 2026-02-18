package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ber extends cjg {
    public String a;

    @Override // me.hd.wauxv.obf.cjg
    public final void d(Context context, AttributeSet attributeSet) {
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, cyd.b);
        throwIfVar1IsNull(typedArrayObtainAttributes, "obtainAttributes(...)");
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
        return obj != null && (obj instanceof ber) && super.equals(obj) && nullSafeIsEqual(this.a, ((ber) obj).a);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" class=");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
