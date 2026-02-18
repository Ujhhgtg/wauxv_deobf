package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dl extends cjg {
    public Intent a;
    public String b;

    public static String c(Context context, String str) {
        if (str == null) {
            return null;
        }
        String packageName = context.getPackageName();
        throwIfVar1IsNull(packageName, "getPackageName(...)");
        return dnr.bo(str, "${applicationId}", packageName);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final void d(Context context, AttributeSet attributeSet) {
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, cyb.a);
        throwIfVar1IsNull(typedArrayObtainAttributes, "obtainAttributes(...)");
        String strC = createInstanceWithArgs(context, typedArrayObtainAttributes.getString(4));
        if (this.a == null) {
            this.a = new Intent();
        }
        Intent intent = this.a;
        throwIfVar1IsNull(intent);
        intent.setPackage(strC);
        String string = typedArrayObtainAttributes.getString(0);
        if (string != null) {
            if (string.charAt(0) == '.') {
                string = context.getPackageName() + string;
            }
            ComponentName componentName = new ComponentName(context, string);
            if (this.a == null) {
                this.a = new Intent();
            }
            Intent intent2 = this.a;
            throwIfVar1IsNull(intent2);
            intent2.setComponent(componentName);
        }
        String string2 = typedArrayObtainAttributes.getString(1);
        if (this.a == null) {
            this.a = new Intent();
        }
        Intent intent3 = this.a;
        throwIfVar1IsNull(intent3);
        intent3.setAction(string2);
        String strC2 = createInstanceWithArgs(context, typedArrayObtainAttributes.getString(2));
        if (strC2 != null) {
            Uri uri = Uri.parse(strC2);
            if (this.a == null) {
                this.a = new Intent();
            }
            Intent intent4 = this.a;
            throwIfVar1IsNull(intent4);
            intent4.setData(uri);
        }
        this.b = createInstanceWithArgs(context, typedArrayObtainAttributes.getString(3));
        typedArrayObtainAttributes.recycle();
    }

    @Override // me.hd.wauxv.obf.cjg
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof dl) && super.equals(obj)) {
            Intent intent = this.a;
            if ((intent != null ? intent.filterEquals(((dl) obj).a) : ((dl) obj).a == null)
                    && nullSafeIsEqual(this.b, ((dl) obj).b)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.cjg
    public final int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Intent intent = this.a;
        int iFilterHashCode = (iHashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
        String str = this.b;
        return iFilterHashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final String toString() {
        Intent intent = this.a;
        ComponentName component = intent != null ? intent.getComponent() : null;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (component != null) {
            sb.append(" class=");
            sb.append(component.getClassName());
        } else {
            Intent intent2 = this.a;
            String action = intent2 != null ? intent2.getAction() : null;
            if (action != null) {
                sb.append(" action=");
                sb.append(action);
            }
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
