package me.hd.wauxv.obf;

import net.bytebuddy.asm.Advice;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dtq {
    public static final dtp Companion = new dtp();
    public final Float a;
    public final Float b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final String h;
    public final Integer i;
    public final Integer j;
    public final Integer k;
    public final Float l;
    public final Integer m;
    public final String n;
    public final String o;

    public /* synthetic */ dtq(int i, Float f, Float f2, String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, Integer num3, Integer num4, Float f3, Integer num5, String str6, String str7) {
        if (32767 != (i & Advice.MethodSizeHandler.UNDEFINED_SIZE)) {
            bht.ah(i, Advice.MethodSizeHandler.UNDEFINED_SIZE, dto.b.getDescriptor());
            throw null;
        }
        this.a = f;
        this.b = f2;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = num;
        this.h = str5;
        this.i = num2;
        this.j = num3;
        this.k = num4;
        this.l = f3;
        this.m = num5;
        this.n = str6;
        this.o = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dtq)) {
            return false;
        }
        dtq dtqVar = (dtq) obj;
        return bzo.f(this.a, dtqVar.a) && bzo.f(this.b, dtqVar.b) && bzo.f(this.c, dtqVar.c) && bzo.f(this.d, dtqVar.d) && bzo.f(this.e, dtqVar.e) && bzo.f(this.f, dtqVar.f) && bzo.f(this.g, dtqVar.g) && bzo.f(this.h, dtqVar.h) && bzo.f(this.i, dtqVar.i) && bzo.f(this.j, dtqVar.j) && bzo.f(this.k, dtqVar.k) && bzo.f(this.l, dtqVar.l) && bzo.f(this.m, dtqVar.m) && bzo.f(this.n, dtqVar.n) && bzo.f(this.o, dtqVar.o);
    }

    public final int hashCode() {
        Float f = this.a;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Float f2 = this.b;
        int iHashCode2 = (iHashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.g;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.h;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.i;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.j;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.k;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Float f3 = this.l;
        int iHashCode12 = (iHashCode11 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Integer num5 = this.m;
        int iHashCode13 = (iHashCode12 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str6 = this.n;
        int iHashCode14 = (iHashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.o;
        return iHashCode14 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-227087805840170L));
        bjs.v(sb, this.a, -227547367340842L);
        bjs.v(sb, this.b, -227530187471658L);
        yg.u(sb, this.c, -227495827733290L);
        yg.u(sb, this.d, -227397043485482L);
        yg.u(sb, this.e, -227388453550890L);
        yg.u(sb, this.f, -226714143685418L);
        bjs.w(sb, this.g, -226649719175978L);
        yg.u(sb, this.h, -226611064470314L);
        bjs.w(sb, this.i, -226593884601130L);
        bjs.w(sb, this.j, -227031971265322L);
        bjs.w(sb, this.k, -226997611526954L);
        bjs.v(sb, this.l, -226980431657770L);
        bjs.w(sb, this.m, -226924597082922L);
        yg.u(sb, this.n, -226864467540778L);
        return bjs.q(sb, this.o, ')');
    }
}
