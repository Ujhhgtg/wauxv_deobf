package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecg {
    public static final ecf Companion = new ecf();
    public final Integer a;
    public final String b;
    public final Integer c;
    public final String d;
    public final String e;
    public final Integer f;

    public /* synthetic */ ecg(int i, Integer num, Integer num2, Integer num3, String str, String str2, String str3) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, ece.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = num2;
        this.d = str2;
        this.e = str3;
        this.f = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ecg)) {
            return false;
        }
        ecg ecgVar = (ecg) obj;
        return bzo.f(this.a, ecgVar.a) && bzo.f(this.b, ecgVar.b) && bzo.f(this.c, ecgVar.c) && bzo.f(this.d, ecgVar.d) && bzo.f(this.e, ecgVar.e) && bzo.f(this.f, ecgVar.f);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.f;
        return iHashCode5 + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-263315854981930L));
        bjs.w(sb, this.a, -263260020407082L);
        yg.u(sb, this.b, -263135466355498L);
        bjs.w(sb, this.c, -263122581453610L);
        yg.u(sb, this.d, -260253543299882L);
        yg.u(sb, this.e, -260176233888554L);
        return bjs.p(sb, this.f, ')');
    }
}
