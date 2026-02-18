package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctq {
    public final int a;
    public List b;
    public final List c;
    public dhx d;
    public String e;

    public ctq(int i, List list, List list2, dhx dhxVar) {
        throwIfVar1IsNull(list2, "elements");
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = dhxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ctq)) {
            return false;
        }
        ctq ctqVar = (ctq) obj;
        return this.a == ctqVar.a && nullSafeIsEqual(this.b, ctqVar.b) && nullSafeIsEqual(this.c, ctqVar.c)
                && nullSafeIsEqual(this.d, ctqVar.d);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        List list = this.b;
        int iG = bjs.g(this.c, (iHashCode + (list == null ? 0 : list.hashCode())) * 31, 31);
        dhx dhxVar = this.d;
        return iG + (dhxVar != null ? dhxVar.hashCode() : 0);
    }

    public final String toString() {
        return "PlaceholderDefinition(id=" + this.a + ", choices=" + this.b + ", elements=" + this.c + ", transform="
                + this.d + ")";
    }

    public /* synthetic */ ctq(int i) {
        this(i, null, new ArrayList(), null);
    }
}
