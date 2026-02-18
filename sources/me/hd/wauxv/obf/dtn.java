package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dtn {
    public static final dtm Companion = new dtm();
    public final String a;
    public final String b;
    public final String c;

    public /* synthetic */ dtn(int i, String str, String str2, String str3) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, dtl.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dtn)) {
            return false;
        }
        dtn dtnVar = (dtn) obj;
        return bzo.f(this.a, dtnVar.a) && bzo.f(this.b, dtnVar.b) && bzo.f(this.c, dtnVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-224227357621034L));
        yg.u(sb, this.a, -224124278405930L);
        yg.u(sb, this.b, -224089918667562L);
        return bjs.q(sb, this.c, ')');
    }
}
