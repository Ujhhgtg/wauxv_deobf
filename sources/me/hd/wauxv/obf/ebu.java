package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebu {
    public static final ebt Companion = new ebt();
    public final eie a;
    public final Integer b;
    public final Integer c;
    public final Long d;
    public final String e;
    public final Integer f;

    public /* synthetic */ ebu(int i, eie eieVar, Integer num, Integer num2, Long l, String str, Integer num3) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, ebs.b.getDescriptor());
            throw null;
        }
        this.a = eieVar;
        this.b = num;
        this.c = num2;
        this.d = l;
        this.e = str;
        this.f = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ebu)) {
            return false;
        }
        ebu ebuVar = (ebu) obj;
        return bzo.f(this.a, ebuVar.a) && bzo.f(this.b, ebuVar.b) && bzo.f(this.c, ebuVar.c) && bzo.f(this.d, ebuVar.d) && bzo.f(this.e, ebuVar.e) && bzo.f(this.f, ebuVar.f);
    }

    public final int hashCode() {
        eie eieVar = this.a;
        int iHashCode = (eieVar == null ? 0 : eieVar.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.d;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.e;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.f;
        return iHashCode5 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nk1Proto(cdn_trans_info=" /* cnb.z(-255958576003882L) */);
        sb.append(this.a);
        sb.append(", recommend_video_quality_level=" /* cnb.z(-255318625876778L) */);
        bjs.w(sb, this.b, -255176891956010L);
        bjs.w(sb, this.c, -255610683652906L);
        dkz.ad(sb, this.d, -255533374241578L);
        yg.u(sb, this.e, -255426000059178L);
        return bjs.p(sb, this.f, ')');
    }
}
