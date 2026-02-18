package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bim {
    public static final bil Companion = new bil();
    public String a;
    public Integer b;
    public Integer c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bim)) {
            return false;
        }
        bim bimVar = (bim) obj;
        return bzo.f(this.a, bimVar.a) && bzo.f(this.b, bimVar.b) && bzo.f(this.c, bimVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GmailInfo(GmailAcct=" /* cnb.z(-336222924831530L) */);
        yg.u(sb, this.a, -335565794835242L);
        bjs.w(sb, this.b, -335552909933354L);
        return bjs.p(sb, this.c, ')');
    }
}
