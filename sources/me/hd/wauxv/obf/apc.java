package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apc {
    public static final apb Companion = new apb();
    public Integer a;
    public apf b;
    public String c;
    public apf d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof apc)) {
            return false;
        }
        apc apcVar = (apc) obj;
        return bzo.f(this.a, apcVar.a) && bzo.f(this.b, apcVar.b) && bzo.f(this.c, apcVar.c) && bzo.f(this.d, apcVar.d);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        apf apfVar = this.b;
        int iHashCode2 = (iHashCode + (apfVar == null ? 0 : apfVar.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        apf apfVar2 = this.d;
        return iHashCode3 + (apfVar2 != null ? apfVar2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisturbSetting(NightSetting=" /* cnb.z(-337940911749930L) */);
        bjs.w(sb, this.a, -335050398759722L);
        sb.append(this.b);
        sb.append(", AllDaySetting=" /* cnb.z(-335028923923242L) */);
        yg.u(sb, this.c, -334973089348394L);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
