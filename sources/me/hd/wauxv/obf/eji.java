package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eji {
    public static final ejh Companion = new ejh();
    public final String a;
    public final Long b;
    public final Integer c;
    public final String d;
    public final Integer e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final dyi k;
    public final Integer l;
    public final ehm m;
    public final Integer n;
    public final dxe o;
    public final Integer p;
    public final efz q;
    public final Integer r;
    public final String s;
    public final eah t;
    public final eiz u;
    public final dyo v;
    public final ede w;
    public final dyx x;

    public /* synthetic */ eji(int i, String str, Long l, Integer num, String str2, Integer num2, Integer num3, String str3, Integer num4, Integer num5, Integer num6, dyi dyiVar, Integer num7, ehm ehmVar, Integer num8, dxe dxeVar, Integer num9, efz efzVar, Integer num10, String str4, eah eahVar, eiz eizVar, dyo dyoVar, ede edeVar, dyx dyxVar) {
        if (16777215 != (i & 16777215)) {
            bht.ah(i, 16777215, ejg.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = l;
        this.c = num;
        this.d = str2;
        this.e = num2;
        this.f = num3;
        this.g = str3;
        this.h = num4;
        this.i = num5;
        this.j = num6;
        this.k = dyiVar;
        this.l = num7;
        this.m = ehmVar;
        this.n = num8;
        this.o = dxeVar;
        this.p = num9;
        this.q = efzVar;
        this.r = num10;
        this.s = str4;
        this.t = eahVar;
        this.u = eizVar;
        this.v = dyoVar;
        this.w = edeVar;
        this.x = dyxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eji)) {
            return false;
        }
        eji ejiVar = (eji) obj;
        return bzo.f(this.a, ejiVar.a) && bzo.f(this.b, ejiVar.b) && bzo.f(this.c, ejiVar.c) && bzo.f(this.d, ejiVar.d) && bzo.f(this.e, ejiVar.e) && bzo.f(this.f, ejiVar.f) && bzo.f(this.g, ejiVar.g) && bzo.f(this.h, ejiVar.h) && bzo.f(this.i, ejiVar.i) && bzo.f(this.j, ejiVar.j) && bzo.f(this.k, ejiVar.k) && bzo.f(this.l, ejiVar.l) && bzo.f(this.m, ejiVar.m) && bzo.f(this.n, ejiVar.n) && bzo.f(this.o, ejiVar.o) && bzo.f(this.p, ejiVar.p) && bzo.f(this.q, ejiVar.q) && bzo.f(this.r, ejiVar.r) && bzo.f(this.s, ejiVar.s) && bzo.f(this.t, ejiVar.t) && bzo.f(this.u, ejiVar.u) && bzo.f(this.v, ejiVar.v) && bzo.f(this.w, ejiVar.w) && bzo.f(this.x, ejiVar.x);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.e;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num4 = this.h;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.i;
        int iHashCode9 = (iHashCode8 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.j;
        int iHashCode10 = (iHashCode9 + (num6 == null ? 0 : num6.hashCode())) * 31;
        dyi dyiVar = this.k;
        int iHashCode11 = (iHashCode10 + (dyiVar == null ? 0 : dyiVar.hashCode())) * 31;
        Integer num7 = this.l;
        int iHashCode12 = (iHashCode11 + (num7 == null ? 0 : num7.hashCode())) * 31;
        ehm ehmVar = this.m;
        int iHashCode13 = (iHashCode12 + (ehmVar == null ? 0 : ehmVar.hashCode())) * 31;
        Integer num8 = this.n;
        int iHashCode14 = (iHashCode13 + (num8 == null ? 0 : num8.hashCode())) * 31;
        dxe dxeVar = this.o;
        int iHashCode15 = (iHashCode14 + (dxeVar == null ? 0 : dxeVar.hashCode())) * 31;
        Integer num9 = this.p;
        int iHashCode16 = (iHashCode15 + (num9 == null ? 0 : num9.hashCode())) * 31;
        efz efzVar = this.q;
        int iHashCode17 = (iHashCode16 + (efzVar == null ? 0 : efzVar.hashCode())) * 31;
        Integer num10 = this.r;
        int iHashCode18 = (iHashCode17 + (num10 == null ? 0 : num10.hashCode())) * 31;
        String str4 = this.s;
        int iHashCode19 = (iHashCode18 + (str4 == null ? 0 : str4.hashCode())) * 31;
        eah eahVar = this.t;
        int iHashCode20 = (iHashCode19 + (eahVar == null ? 0 : eahVar.hashCode())) * 31;
        eiz eizVar = this.u;
        int iHashCode21 = (iHashCode20 + (eizVar == null ? 0 : eizVar.hashCode())) * 31;
        dyo dyoVar = this.v;
        int iHashCode22 = (iHashCode21 + (dyoVar == null ? 0 : dyoVar.hashCode())) * 31;
        ede edeVar = this.w;
        int iHashCode23 = (iHashCode22 + (edeVar == null ? 0 : edeVar.hashCode())) * 31;
        dyx dyxVar = this.x;
        return iHashCode23 + (dyxVar != null ? dyxVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-345392680008490L));
        yg.u(sb, this.a, -345323960531754L);
        dkz.ad(sb, this.b, -345293895760682L);
        bjs.w(sb, this.c, -345770637130538L);
        yg.u(sb, this.d, -345701917653802L);
        bjs.w(sb, this.e, -345680442817322L);
        bjs.w(sb, this.f, -345603133405994L);
        yg.u(sb, this.g, -345585953536810L);
        bjs.w(sb, this.h, -347127846796074L);
        bjs.w(sb, this.i, -347037652482858L);
        bjs.w(sb, this.j, -347033357515562L);
        sb.append(this.k);
        sb.append(cnb.z(-346956048104234L));
        bjs.w(sb, this.l, -347437084441386L);
        sb.append(this.m);
        sb.append(cnb.z(-347376954899242L));
        bjs.w(sb, this.n, -347226631043882L);
        sb.append(this.o);
        sb.append(cnb.z(-346603860785962L));
        bjs.w(sb, this.p, -346535141309226L);
        sb.append(this.q);
        sb.append(cnb.z(-346496486603562L));
        bjs.w(sb, this.r, -346419177192234L);
        yg.u(sb, this.s, -346401997323050L);
        sb.append(this.t);
        sb.append(cnb.z(-346887328627498L));
        sb.append(this.u);
        sb.append(cnb.z(-346814314183466L));
        sb.append(this.v);
        sb.append(cnb.z(-346754184641322L));
        sb.append(this.w);
        sb.append(cnb.z(-346638220524330L));
        sb.append(this.x);
        sb.append(')');
        return sb.toString();
    }
}
