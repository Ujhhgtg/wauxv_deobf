package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dws {
    public static final dwr Companion = new dwr();
    public static final btt[] a = {ewz.am(btx.a, new dtr(5)), null, null, null, null, null};
    public final List b;
    public final String c;
    public final String d;
    public final String e;
    public final Boolean f;
    public final String g;

    public /* synthetic */ dws(int i, List list, String str, String str2, String str3, Boolean bool, String str4) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, dwq.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = bool;
        this.g = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dws)) {
            return false;
        }
        dws dwsVar = (dws) obj;
        return bzo.f(this.b, dwsVar.b) && bzo.f(this.c, dwsVar.c) && bzo.f(this.d, dwsVar.d) && bzo.f(this.e, dwsVar.e) && bzo.f(this.f, dwsVar.f) && bzo.f(this.g, dwsVar.g);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.f;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.g;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-167061342911274L));
        yg.v(sb, this.b, -166923903957802L);
        yg.u(sb, this.c, -166876659317546L);
        yg.u(sb, this.d, -166206644419370L);
        yg.u(sb, this.e, -166193759517482L);
        dts.g(sb, this.f, -166090680302378L);
        return bjs.q(sb, this.g, ')');
    }
}
