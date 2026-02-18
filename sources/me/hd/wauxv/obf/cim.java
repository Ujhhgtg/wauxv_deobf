package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cim {
    public final int a;
    public cjo b = null;
    public Bundle c = null;

    public cim(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cim)) {
            return false;
        }
        cim cimVar = (cim) obj;
        if (this.a != cimVar.a || !nullSafeIsEqual(this.b, cimVar.b)) {
            return false;
        }
        Bundle bundle = this.c;
        Bundle bundle2 = cimVar.c;
        if (nullSafeIsEqual(bundle, bundle2)) {
            return true;
        }
        return (bundle == null || bundle2 == null || !cna.k(bundle, bundle2)) ? false : true;
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        cjo cjoVar = this.b;
        int iHashCode2 = iHashCode + (cjoVar != null ? cjoVar.hashCode() : 0);
        Bundle bundle = this.c;
        if (bundle != null) {
            return cna.l(bundle) + (iHashCode2 * 31);
        }
        return iHashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cim.class.getSimpleName());
        sb.append("(0x");
        sb.append(Integer.toHexString(this.a));
        sb.append(")");
        if (this.b != null) {
            sb.append(" navOptions=");
            sb.append(this.b);
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
