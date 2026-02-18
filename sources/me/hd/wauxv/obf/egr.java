package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egr {
    public static final egq Companion = new egq();
    public final String a;
    public final String b;
    public final Integer c;

    public /* synthetic */ egr(int i, Integer num, String str, String str2) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, egp.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof egr)) {
            return false;
        }
        egr egrVar = (egr) obj;
        return bzo.f(this.a, egrVar.a) && bzo.f(this.b, egrVar.b) && bzo.f(this.c, egrVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.c;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-313446713260842L));
        yg.u(sb, this.a, -313901979794218L);
        yg.u(sb, this.b, -313820375415594L);
        return bjs.p(sb, this.c, ')');
    }
}
