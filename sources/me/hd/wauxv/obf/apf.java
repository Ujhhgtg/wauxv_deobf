package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apf {
    public static final ape Companion = new ape();
    public Integer a;
    public Integer b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof apf)) {
            return false;
        }
        apf apfVar = (apf) obj;
        return nullSafeIsEqual(this.a, apfVar.a) && nullSafeIsEqual(this.b, apfVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisturbTimeSpan(BeginTime=" /* "DisturbTimeSpan(BeginTime=" /* "DisturbTimeSpan(BeginTime=" /* "DisturbTimeSpan(BeginTime=" /* cnb.z(-334315959352106L)   */);
        bjs.w(sb, this.a, -334715391310634L);
        return concat(sb, this.b, ')');
    }
}
