package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehs {
    public static final ehr Companion = new ehr();
    public final Integer a;
    public final String b;
    public final String c;

    public /* synthetic */ ehs(int i, Integer num, String str, String str2) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, ehq.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehs)) {
            return false;
        }
        ehs ehsVar = (ehs) obj;
        return bzo.f(this.a, ehsVar.a) && bzo.f(this.b, ehsVar.b) && bzo.f(this.c, ehsVar.c);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("wa3Proto(start_offset=" /* cnb.z(-305290570365738L) */);
        bjs.w(sb, this.a, -305191786117930L);
        yg.u(sb, this.b, -305148836444970L);
        return bjs.q(sb, this.c, ')');
    }
}
