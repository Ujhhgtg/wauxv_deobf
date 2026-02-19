package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ejo {
    public static final ejn Companion = new ejn();
    public static final IHasGetValue[] a = { ewz.am(btx.a, new efq(12)), null, null, null };
    public final List b;
    public final eaq c;
    public final Integer d;
    public final String e;

    public /* synthetic */ ejo(int i, List list, eaq eaqVar, Integer num, String str) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, ejm.b.getDescriptor());
            throw null;
        }
        this.b = list;
        this.c = eaqVar;
        this.d = num;
        this.e = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ejo)) {
            return false;
        }
        ejo ejoVar = (ejo) obj;
        return nullSafeIsEqual(this.b, ejoVar.b) && nullSafeIsEqual(this.c, ejoVar.c)
                && nullSafeIsEqual(this.d, ejoVar.d) && nullSafeIsEqual(this.e, ejoVar.e);
    }

    public final int hashCode() {
        List list = this.b;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        eaq eaqVar = this.c;
        int iHashCode2 = (iHashCode + (eaqVar == null ? 0 : eaqVar.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.e;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ze1Proto(cdnTransInfo=" /* "ze1Proto(cdnTransInfo=" /* "ze1Proto(cdnTransInfo=" /* "ze1Proto(cdnTransInfo=" /* cnb.z(-344933118507818L)   */);
        yg.v(sb, this.b, -344834334260010L);
        sb.append(this.c);
        sb.append(", audience_cdn_quality_cfg=" /* ", audience_cdn_quality_cfg=" /* ", audience_cdn_quality_cfg=" /* ", audience_cdn_quality_cfg=" /* cnb.z(-344718370143018L)   */);
        bjs.w(sb, this.d, -345113507134250L);
        return concat(sb, this.e, ')');
    }
}
