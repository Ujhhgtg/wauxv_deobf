package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdr {
    public static final cdq Companion = new cdq();
    public Integer a;
    public String aa;
    public String ab;
    public Integer ac;
    public Integer ad;
    public Long ae;
    public String af;
    public Integer ag;
    public Integer ah;
    public String ai;
    public Integer aj;
    public String ak;
    public String al;
    public ddz b;
    public ddz c;
    public Integer d;
    public ddz e;
    public ddz f;
    public Integer g;
    public Integer h;
    public byte[] i;
    public Integer j;
    public String k;
    public String l;
    public String m;
    public Integer n;
    public apc o;
    public Integer p;
    public Integer q;
    public String r;
    public Integer s;
    public Integer t;
    public Integer u;
    public Integer v;
    public Integer w;
    public String x;
    public Integer y;
    public bip z;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!cdr.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        throwIfVar1IsNull(obj,
                "null cannot be cast to non-null type me.hd.wauxv.hook.micromsg.core.protobuf.proto.ModUserInfo" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 339323891219242L)
                                                                                                                  */);
        cdr cdrVar = (cdr) obj;
        return nullSafeIsEqual(this.a, cdrVar.a) && nullSafeIsEqual(this.d, cdrVar.d)
                && nullSafeIsEqual(this.g, cdrVar.g) && nullSafeIsEqual(this.h, cdrVar.h)
                && nullSafeIsEqual(this.j, cdrVar.j) && nullSafeIsEqual(this.n, cdrVar.n)
                && nullSafeIsEqual(this.p, cdrVar.p)
                && nullSafeIsEqual(this.q, cdrVar.q) && nullSafeIsEqual(this.s, cdrVar.s)
                && nullSafeIsEqual(this.t, cdrVar.t)
                && nullSafeIsEqual(this.u, cdrVar.u) && nullSafeIsEqual(this.v, cdrVar.v)
                && nullSafeIsEqual(this.w, cdrVar.w)
                && nullSafeIsEqual(this.y, cdrVar.y) && nullSafeIsEqual(this.ac, cdrVar.ac)
                && nullSafeIsEqual(this.ad, cdrVar.ad)
                && nullSafeIsEqual(this.ae, cdrVar.ae) && nullSafeIsEqual(this.ag, cdrVar.ag)
                && nullSafeIsEqual(this.ah, cdrVar.ah)
                && nullSafeIsEqual(this.aj, cdrVar.aj) && nullSafeIsEqual(this.b, cdrVar.b)
                && nullSafeIsEqual(this.c, cdrVar.c)
                && nullSafeIsEqual(this.e, cdrVar.e) && nullSafeIsEqual(this.f, cdrVar.f)
                && Arrays.equals(this.i, cdrVar.i)
                && nullSafeIsEqual(this.k, cdrVar.k) && nullSafeIsEqual(this.l, cdrVar.l)
                && nullSafeIsEqual(this.m, cdrVar.m)
                && nullSafeIsEqual(this.o, cdrVar.o) && nullSafeIsEqual(this.r, cdrVar.r)
                && nullSafeIsEqual(this.x, cdrVar.x)
                && nullSafeIsEqual(this.z, cdrVar.z) && nullSafeIsEqual(this.aa, cdrVar.aa)
                && nullSafeIsEqual(this.ab, cdrVar.ab)
                && nullSafeIsEqual(this.af, cdrVar.af) && nullSafeIsEqual(this.ai, cdrVar.ai)
                && nullSafeIsEqual(this.ak, cdrVar.ak)
                && nullSafeIsEqual(this.al, cdrVar.al);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iIntValue = (num != null ? num.intValue() : 0) * 31;
        Integer num2 = this.d;
        int iIntValue2 = (iIntValue + (num2 != null ? num2.intValue() : 0)) * 31;
        Integer num3 = this.g;
        int iIntValue3 = (iIntValue2 + (num3 != null ? num3.intValue() : 0)) * 31;
        Integer num4 = this.h;
        int iIntValue4 = (iIntValue3 + (num4 != null ? num4.intValue() : 0)) * 31;
        Integer num5 = this.j;
        int iIntValue5 = (iIntValue4 + (num5 != null ? num5.intValue() : 0)) * 31;
        Integer num6 = this.n;
        int iIntValue6 = (iIntValue5 + (num6 != null ? num6.intValue() : 0)) * 31;
        Integer num7 = this.p;
        int iIntValue7 = (iIntValue6 + (num7 != null ? num7.intValue() : 0)) * 31;
        Integer num8 = this.q;
        int iIntValue8 = (iIntValue7 + (num8 != null ? num8.intValue() : 0)) * 31;
        Integer num9 = this.s;
        int iIntValue9 = (iIntValue8 + (num9 != null ? num9.intValue() : 0)) * 31;
        Integer num10 = this.t;
        int iIntValue10 = (iIntValue9 + (num10 != null ? num10.intValue() : 0)) * 31;
        Integer num11 = this.u;
        int iIntValue11 = (iIntValue10 + (num11 != null ? num11.intValue() : 0)) * 31;
        Integer num12 = this.v;
        int iIntValue12 = (iIntValue11 + (num12 != null ? num12.intValue() : 0)) * 31;
        Integer num13 = this.w;
        int iIntValue13 = (iIntValue12 + (num13 != null ? num13.intValue() : 0)) * 31;
        Integer num14 = this.y;
        int iIntValue14 = (iIntValue13 + (num14 != null ? num14.intValue() : 0)) * 31;
        Integer num15 = this.ac;
        int iIntValue15 = (iIntValue14 + (num15 != null ? num15.intValue() : 0)) * 31;
        Integer num16 = this.ad;
        int iIntValue16 = (iIntValue15 + (num16 != null ? num16.intValue() : 0)) * 31;
        Long l = this.ae;
        int iHashCode = (iIntValue16 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        Integer num17 = this.ag;
        int iIntValue17 = (iHashCode + (num17 != null ? num17.intValue() : 0)) * 31;
        Integer num18 = this.ah;
        int iIntValue18 = (iIntValue17 + (num18 != null ? num18.intValue() : 0)) * 31;
        Integer num19 = this.aj;
        int iIntValue19 = (iIntValue18 + (num19 != null ? num19.intValue() : 0)) * 31;
        ddz ddzVar = this.b;
        int iHashCode2 = (iIntValue19 + (ddzVar != null ? ddzVar.hashCode() : 0)) * 31;
        ddz ddzVar2 = this.c;
        int iHashCode3 = (iHashCode2 + (ddzVar2 != null ? ddzVar2.hashCode() : 0)) * 31;
        ddz ddzVar3 = this.e;
        int iHashCode4 = (iHashCode3 + (ddzVar3 != null ? ddzVar3.hashCode() : 0)) * 31;
        ddz ddzVar4 = this.f;
        int iHashCode5 = (iHashCode4 + (ddzVar4 != null ? ddzVar4.hashCode() : 0)) * 31;
        byte[] bArr = this.i;
        int iHashCode6 = (iHashCode5 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        String str = this.k;
        int iHashCode7 = (iHashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.l;
        int iHashCode8 = (iHashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.m;
        int iHashCode9 = (iHashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        apc apcVar = this.o;
        int iHashCode10 = (iHashCode9 + (apcVar != null ? apcVar.hashCode() : 0)) * 31;
        String str4 = this.r;
        int iHashCode11 = (iHashCode10 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.x;
        int iHashCode12 = (iHashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        bip bipVar = this.z;
        int iHashCode13 = (iHashCode12 + (bipVar != null ? bipVar.hashCode() : 0)) * 31;
        String str6 = this.aa;
        int iHashCode14 = (iHashCode13 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.ab;
        int iHashCode15 = (iHashCode14 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.af;
        int iHashCode16 = (iHashCode15 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ai;
        int iHashCode17 = (iHashCode16 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.ak;
        int iHashCode18 = (iHashCode17 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.al;
        return iHashCode18 + (str11 != null ? str11.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ModUserInfo(BitFlag=" /* cnb.z(-338915869326122L) */);
        bjs.w(sb, this.a, -338791315274538L);
        sb.append(this.b);
        sb.append(", NickName=" /* cnb.z(-338774135405354L) */);
        sb.append(this.c);
        sb.append(", BindUin=" /* cnb.z(-338688236059434L) */);
        bjs.w(sb, this.d, -338675351157546L);
        sb.append(this.e);
        sb.append(", BindMobile=" /* cnb.z(-339134912658218L) */);
        sb.append(this.f);
        sb.append(", Status=" /* cnb.z(-339126322723626L) */);
        bjs.w(sb, this.g, -339031833443114L);
        bjs.w(sb, this.h, -339006063639338L);
        sb.append(Arrays.toString(this.i));
        sb.append(", Sex=" /* cnb.z(-338980293835562L) */);
        bjs.w(sb, this.j, -338950229064490L);
        yg.u(sb, this.k, -340513597160234L);
        yg.u(sb, this.l, -340479237421866L);
        yg.u(sb, this.m, -340457762585386L);
        bjs.w(sb, this.n, -340389043108650L);
        sb.append(this.o);
        sb.append(", PluginFlag=" /* cnb.z(-340328913566506L) */);
        bjs.w(sb, this.p, -340801359969066L);
        bjs.w(sb, this.q, -340724050557738L);
        yg.u(sb, this.r, -340646741146410L);
        bjs.w(sb, this.s, -340625266309930L);
        bjs.w(sb, this.t, -339998201084714L);
        bjs.w(sb, this.u, -339959546379050L);
        bjs.w(sb, this.v, -339895121869610L);
        bjs.w(sb, this.w, -339826402392874L);
        yg.u(sb, this.x, -339787747687210L);
        bjs.w(sb, this.y, -340268784024362L);
        sb.append(this.z);
        sb.append(", Alias=" /* cnb.z(-340264489057066L) */);
        yg.u(sb, this.aa, -340225834351402L);
        yg.u(sb, this.ab, -340101280299818L);
        bjs.w(sb, this.ac, -340079805463338L);
        bjs.w(sb, this.ad, -363650585983786L);
        dkz.ad(sb, this.ae, -363564686637866L);
        yg.u(sb, this.af, -363556096703274L);
        bjs.w(sb, this.ag, -363478787291946L);
        bjs.w(sb, this.ah, -363405772847914L);
        yg.u(sb, this.ai, -363886809185066L);
        bjs.w(sb, this.aj, -363826679642922L);
        yg.u(sb, this.ak, -363796614871850L);
        return concat(sb, this.al, ')');
    }
}
