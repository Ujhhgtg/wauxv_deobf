package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwv {
    public static final dwu Companion = new dwu();
    public static final btt[] a;
    public final String b;
    public final Integer c;
    public final dyu d;
    public final dyu e;
    public final Integer f;
    public final dyr g;
    public final List h;
    public final dxk i;
    public final egi j;
    public final Boolean k;
    public final dzs l;
    public final edh m;
    public final dxb n;
    public final List o;
    public final edt p;
    public final ehj q;
    public final dwd r;

    static {
        dtr dtrVar = new dtr(6);
        btx btxVar = btx.a;
        a = new btt[]{null, null, null, null, null, null, ewz.am(btxVar, dtrVar), null, null, null, null, null, null, ewz.am(btxVar, new dtr(7)), null, null, null};
    }

    public /* synthetic */ dwv(int i, String str, Integer num, dyu dyuVar, dyu dyuVar2, Integer num2, dyr dyrVar, List list, dxk dxkVar, egi egiVar, Boolean bool, dzs dzsVar, edh edhVar, dxb dxbVar, List list2, edt edtVar, ehj ehjVar, dwd dwdVar) {
        if (131071 != (i & 131071)) {
            bht.ah(i, 131071, dwt.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = num;
        this.d = dyuVar;
        this.e = dyuVar2;
        this.f = num2;
        this.g = dyrVar;
        this.h = list;
        this.i = dxkVar;
        this.j = egiVar;
        this.k = bool;
        this.l = dzsVar;
        this.m = edhVar;
        this.n = dxbVar;
        this.o = list2;
        this.p = edtVar;
        this.q = ehjVar;
        this.r = dwdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dwv)) {
            return false;
        }
        dwv dwvVar = (dwv) obj;
        return bzo.f(this.b, dwvVar.b) && bzo.f(this.c, dwvVar.c) && bzo.f(this.d, dwvVar.d) && bzo.f(this.e, dwvVar.e) && bzo.f(this.f, dwvVar.f) && bzo.f(this.g, dwvVar.g) && bzo.f(this.h, dwvVar.h) && bzo.f(this.i, dwvVar.i) && bzo.f(this.j, dwvVar.j) && bzo.f(this.k, dwvVar.k) && bzo.f(this.l, dwvVar.l) && bzo.f(this.m, dwvVar.m) && bzo.f(this.n, dwvVar.n) && bzo.f(this.o, dwvVar.o) && bzo.f(this.p, dwvVar.p) && bzo.f(this.q, dwvVar.q) && bzo.f(this.r, dwvVar.r);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        dyu dyuVar = this.d;
        int iHashCode3 = (iHashCode2 + (dyuVar == null ? 0 : dyuVar.hashCode())) * 31;
        dyu dyuVar2 = this.e;
        int iHashCode4 = (iHashCode3 + (dyuVar2 == null ? 0 : dyuVar2.hashCode())) * 31;
        Integer num2 = this.f;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        dyr dyrVar = this.g;
        int iHashCode6 = (iHashCode5 + (dyrVar == null ? 0 : dyrVar.hashCode())) * 31;
        List list = this.h;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        dxk dxkVar = this.i;
        int iHashCode8 = (iHashCode7 + (dxkVar == null ? 0 : dxkVar.hashCode())) * 31;
        egi egiVar = this.j;
        int iHashCode9 = (iHashCode8 + (egiVar == null ? 0 : egiVar.hashCode())) * 31;
        Boolean bool = this.k;
        int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        dzs dzsVar = this.l;
        int iHashCode11 = (iHashCode10 + (dzsVar == null ? 0 : dzsVar.hashCode())) * 31;
        edh edhVar = this.m;
        int iHashCode12 = (iHashCode11 + (edhVar == null ? 0 : edhVar.hashCode())) * 31;
        dxb dxbVar = this.n;
        int iHashCode13 = (iHashCode12 + (dxbVar == null ? 0 : dxbVar.hashCode())) * 31;
        List list2 = this.o;
        int iHashCode14 = (iHashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        edt edtVar = this.p;
        int iHashCode15 = (iHashCode14 + (edtVar == null ? 0 : edtVar.hashCode())) * 31;
        ehj ehjVar = this.q;
        int iHashCode16 = (iHashCode15 + (ehjVar == null ? 0 : ehjVar.hashCode())) * 31;
        dwd dwdVar = this.r;
        return iHashCode16 + (dwdVar != null ? dwdVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("df1Proto(live_mic_id=" /* cnb.z(-164544492075818L) */);
        yg.u(sb, this.b, -164432822926122L);
        bjs.w(sb, this.c, -164896679394090L);
        sb.append(this.d);
        sb.append(", accept_live_contact=" /* cnb.z(-164840844819242L) */);
        sb.append(this.e);
        sb.append(", status=" /* cnb.z(-164724880702250L) */);
        bjs.w(sb, this.f, -164699110898474L);
        sb.append(this.g);
        sb.append(", mic_audience_list=" /* cnb.z(-164037685934890L) */);
        yg.v(sb, this.h, -163999031229226L);
        sb.append(this.i);
        sb.append(", battle_info=" /* cnb.z(-163917426850602L) */);
        sb.append(this.j);
        sb.append(", enable_cross_live_room_mic=" /* cnb.z(-163853002341162L) */);
        dts.g(sb, this.k, -164256729266986L);
        sb.append(this.l);
        sb.append(", wording=" /* cnb.z(-164149355084586L) */);
        sb.append(this.m);
        sb.append(", meet_info=" /* cnb.z(-164136470182698L) */);
        sb.append(this.n);
        sb.append(", new_pk_mic_infos=" /* cnb.z(-187685775866666L) */);
        yg.v(sb, this.o, -187634236259114L);
        sb.append(this.p);
        sb.append(", battle_setting_info=" /* cnb.z(-187522567109418L) */);
        sb.append(this.q);
        sb.append(", mic_config=" /* cnb.z(-187973538675498L) */);
        sb.append(this.r);
        sb.append(')');
        return sb.toString();
    }
}
