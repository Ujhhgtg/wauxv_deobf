package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eef {
    public static final eee Companion = new eee();
    public static final btt[] a = { null, ewz.am(btx.a, new dtr(26)), null, null, null };
    public final String b;
    public final List c;
    public final String d;
    public final Integer e;
    public final String f;

    public /* synthetic */ eef(int i, String str, List list, String str2, Integer num, String str3) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, eed.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = list;
        this.d = str2;
        this.e = num;
        this.f = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eef)) {
            return false;
        }
        eef eefVar = (eef) obj;
        return nullSafeIsEqual(this.b, eefVar.b) && nullSafeIsEqual(this.c, eefVar.c)
                && nullSafeIsEqual(this.d, eefVar.d) && nullSafeIsEqual(this.e, eefVar.e)
                && nullSafeIsEqual(this.f, eefVar.f);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List list = this.c;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.f;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("s40Proto(component_name=" /* cnb.z(-280766307105578L) */);
        yg.u(sb, this.b, -280676112792362L);
        yg.v(sb, this.c, -277824254507818L);
        yg.u(sb, this.d, -277721175292714L);
        bjs.w(sb, this.e, -277673930652458L);
        return concat(sb, this.f, ')');
    }
}
