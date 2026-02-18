package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxt {
    public static final dxs Companion = new dxs();
    public final Integer a;
    public final dvl b;
    public final ejx c;
    public final eer d;
    public final Integer e;
    public final Integer f;

    public /* synthetic */ dxt(int i, Integer num, dvl dvlVar, ejx ejxVar, eer eerVar, Integer num2, Integer num3) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, dxr.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = dvlVar;
        this.c = ejxVar;
        this.d = eerVar;
        this.e = num2;
        this.f = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxt)) {
            return false;
        }
        dxt dxtVar = (dxt) obj;
        return bzo.f(this.a, dxtVar.a) && bzo.f(this.b, dxtVar.b) && bzo.f(this.c, dxtVar.c) && bzo.f(this.d, dxtVar.d) && bzo.f(this.e, dxtVar.e) && bzo.f(this.f, dxtVar.f);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        dvl dvlVar = this.b;
        int iHashCode2 = (iHashCode + (dvlVar == null ? 0 : dvlVar.hashCode())) * 31;
        ejx ejxVar = this.c;
        int iHashCode3 = (iHashCode2 + (ejxVar == null ? 0 : ejxVar.hashCode())) * 31;
        eer eerVar = this.d;
        int iHashCode4 = (iHashCode3 + (eerVar == null ? 0 : eerVar.hashCode())) * 31;
        Integer num2 = this.e;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f;
        return iHashCode5 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-181058641328938L));
        bjs.w(sb, this.a, -181002806754090L);
        sb.append(this.b);
        sb.append(cnb.z(-180938382244650L));
        sb.append(this.c);
        sb.append(cnb.z(-180904022506282L));
        sb.append(this.d);
        sb.append(cnb.z(-181367878974250L));
        bjs.w(sb, this.e, -181303454464810L);
        return bjs.p(sb, this.f, ')');
    }
}
