package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efz {
    public static final efy Companion = new efy();
    public static final btt[] a = { null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, ewz.am(btx.a, new efq(1)), null, null, null, null, null,
            null, null };
    public final egx aa;
    public final ecv ab;
    public final Integer ac;
    public final String ad;
    public final ehy ae;
    public final Long b;
    public final dsy c;
    public final String d;
    public final String e;
    public final Integer f;
    public final String g;
    public final Long h;
    public final Integer i;
    public final Integer j;
    public final String k;
    public final String l;
    public final String m;
    public final Integer n;
    public final Long o;
    public final Integer p;
    public final dte q;
    public final eiz r;
    public final Long s;
    public final eju t;
    public final dte u;
    public final efj v;
    public final Integer w;
    public final List x;
    public final String y;
    public final dvu z;

    public /* synthetic */ efz(int i, Long l, dsy dsyVar, String str, String str2, Integer num, String str3, Long l2,
            Integer num2, Integer num3, String str4, String str5, String str6, Integer num4, Long l3, Integer num5,
            dte dteVar, eiz eizVar, Long l4, eju ejuVar, dte dteVar2, efj efjVar, Integer num6, List list, String str7,
            dvu dvuVar, egx egxVar, ecv ecvVar, Integer num7, String str8, ehy ehyVar) {
        if (1073741823 != (i & 1073741823)) {
            bht.ah(i, 1073741823, efx.b.getDescriptor());
            throw null;
        }
        this.b = l;
        this.c = dsyVar;
        this.d = str;
        this.e = str2;
        this.f = num;
        this.g = str3;
        this.h = l2;
        this.i = num2;
        this.j = num3;
        this.k = str4;
        this.l = str5;
        this.m = str6;
        this.n = num4;
        this.o = l3;
        this.p = num5;
        this.q = dteVar;
        this.r = eizVar;
        this.s = l4;
        this.t = ejuVar;
        this.u = dteVar2;
        this.v = efjVar;
        this.w = num6;
        this.x = list;
        this.y = str7;
        this.z = dvuVar;
        this.aa = egxVar;
        this.ab = ecvVar;
        this.ac = num7;
        this.ad = str8;
        this.ae = ehyVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efz)) {
            return false;
        }
        efz efzVar = (efz) obj;
        return nullSafeIsEqual(this.b, efzVar.b) && nullSafeIsEqual(this.c, efzVar.c)
                && nullSafeIsEqual(this.d, efzVar.d) && nullSafeIsEqual(this.e, efzVar.e)
                && nullSafeIsEqual(this.f, efzVar.f) && nullSafeIsEqual(this.g, efzVar.g)
                && nullSafeIsEqual(this.h, efzVar.h) && nullSafeIsEqual(this.i, efzVar.i)
                && nullSafeIsEqual(this.j, efzVar.j) && nullSafeIsEqual(this.k, efzVar.k)
                && nullSafeIsEqual(this.l, efzVar.l) && nullSafeIsEqual(this.m, efzVar.m)
                && nullSafeIsEqual(this.n, efzVar.n) && nullSafeIsEqual(this.o, efzVar.o)
                && nullSafeIsEqual(this.p, efzVar.p) && nullSafeIsEqual(this.q, efzVar.q)
                && nullSafeIsEqual(this.r, efzVar.r) && nullSafeIsEqual(this.s, efzVar.s)
                && nullSafeIsEqual(this.t, efzVar.t) && nullSafeIsEqual(this.u, efzVar.u)
                && nullSafeIsEqual(this.v, efzVar.v) && nullSafeIsEqual(this.w, efzVar.w)
                && nullSafeIsEqual(this.x, efzVar.x) && nullSafeIsEqual(this.y, efzVar.y)
                && nullSafeIsEqual(this.z, efzVar.z) && nullSafeIsEqual(this.aa, efzVar.aa)
                && nullSafeIsEqual(this.ab, efzVar.ab) && nullSafeIsEqual(this.ac, efzVar.ac)
                && nullSafeIsEqual(this.ad, efzVar.ad) && nullSafeIsEqual(this.ae, efzVar.ae);
    }

    public final int hashCode() {
        Long l = this.b;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        dsy dsyVar = this.c;
        int iHashCode2 = (iHashCode + (dsyVar == null ? 0 : dsyVar.hashCode())) * 31;
        String str = this.d;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.f;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l2 = this.h;
        int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num2 = this.i;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.j;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.k;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.l;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.m;
        int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num4 = this.n;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l3 = this.o;
        int iHashCode14 = (iHashCode13 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num5 = this.p;
        int iHashCode15 = (iHashCode14 + (num5 == null ? 0 : num5.hashCode())) * 31;
        dte dteVar = this.q;
        int iHashCode16 = (iHashCode15 + (dteVar == null ? 0 : dteVar.hashCode())) * 31;
        eiz eizVar = this.r;
        int iHashCode17 = (iHashCode16 + (eizVar == null ? 0 : eizVar.hashCode())) * 31;
        Long l4 = this.s;
        int iHashCode18 = (iHashCode17 + (l4 == null ? 0 : l4.hashCode())) * 31;
        eju ejuVar = this.t;
        int iHashCode19 = (iHashCode18 + (ejuVar == null ? 0 : ejuVar.hashCode())) * 31;
        dte dteVar2 = this.u;
        int iHashCode20 = (iHashCode19 + (dteVar2 == null ? 0 : dteVar2.hashCode())) * 31;
        efj efjVar = this.v;
        int iHashCode21 = (iHashCode20 + (efjVar == null ? 0 : efjVar.hashCode())) * 31;
        Integer num6 = this.w;
        int iHashCode22 = (iHashCode21 + (num6 == null ? 0 : num6.hashCode())) * 31;
        List list = this.x;
        int iHashCode23 = (iHashCode22 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.y;
        int iHashCode24 = (iHashCode23 + (str7 == null ? 0 : str7.hashCode())) * 31;
        dvu dvuVar = this.z;
        int iHashCode25 = (iHashCode24 + (dvuVar == null ? 0 : dvuVar.hashCode())) * 31;
        egx egxVar = this.aa;
        int iHashCode26 = (iHashCode25 + (egxVar == null ? 0 : egxVar.hashCode())) * 31;
        ecv ecvVar = this.ab;
        int iHashCode27 = (iHashCode26 + (ecvVar == null ? 0 : ecvVar.hashCode())) * 31;
        Integer num7 = this.ac;
        int iHashCode28 = (iHashCode27 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str8 = this.ad;
        int iHashCode29 = (iHashCode28 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ehy ehyVar = this.ae;
        return iHashCode29 + (ehyVar != null ? ehyVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("uq0Proto(eventTopicId=" /* cnb.z(-311080186280746L) */);
        dkz.ad(sb, this.b, -310981402032938L);
        sb.append(this.c);
        sb.append(", eventName=" /* cnb.z(-310951337261866L) */);
        yg.u(sb, this.d, -310328567003946L);
        yg.u(sb, this.e, -310246962625322L);
        bjs.w(sb, this.f, -310195423017770L);
        yg.u(sb, this.g, -310130998508330L);
        dkz.ad(sb, this.h, -310551905303338L);
        bjs.w(sb, this.i, -310530430466858L);
        bjs.w(sb, this.j, -310466005957418L);
        yg.u(sb, this.k, -310435941186346L);
        yg.u(sb, this.l, -310350041840426L);
        yg.u(sb, this.m, -311926294838058L);
        bjs.w(sb, this.n, -311904820001578L);
        dkz.ad(sb, this.o, -311823215622954L);
        bjs.w(sb, this.p, -311763086080810L);
        sb.append(this.q);
        sb.append(", hashTagInfo=" /* cnb.z(-311745906211626L) */);
        sb.append(this.r);
        sb.append(", displayMask=" /* cnb.z(-312214057646890L) */);
        dkz.ad(sb, this.s, -312149633137450L);
        sb.append(this.t);
        sb.append(", descJumpInfo=" /* cnb.z(-312068028758826L) */);
        sb.append(this.u);
        sb.append(", descriptionContactInfo=" /* cnb.z(-311999309282090L) */);
        sb.append(this.v);
        sb.append(", available_template=" /* cnb.z(-311355064187690L) */);
        bjs.w(sb, this.w, -311243395037994L);
        yg.v(sb, this.x, -311174675561258L);
        yg.u(sb, this.y, -311660006865706L);
        sb.append(this.z);
        sb.append(", music_info=" /* cnb.z(-311604172290858L) */);
        sb.append(this.aa);
        sb.append(", video_tmpl_info=" /* cnb.z(-311526862879530L) */);
        sb.append(this.ab);
        sb.append(", whitelist_block_flag=" /* cnb.z(-308662119693098L) */);
        bjs.w(sb, this.ac, -308559040477994L);
        yg.u(sb, this.ad, -308464551197482L);
        sb.append(this.ae);
        sb.append(')');
        return sb.toString();
    }
}
