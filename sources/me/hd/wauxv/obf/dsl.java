package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dsl {
    public static final dsk Companion = new dsk();
    public final String a;
    public final String b;
    public final String c;

    public /* synthetic */ dsl(int i, String str, String str2, String str3) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, dsj.b.getDescriptor());
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
        if (!(obj instanceof dsl)) {
            return false;
        }
        dsl dslVar = (dsl) obj;
        return bzo.f(this.a, dslVar.a) && bzo.f(this.b, dslVar.b) && bzo.f(this.c, dslVar.c);
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
        sb.append("AppJumpWordingProto(en=" /* cnb.z(-145221434211114L) */);
        yg.u(sb, this.a, -145668110809898L);
        yg.u(sb, this.b, -145629456104234L);
        return bjs.q(sb, this.c, ')');
    }
}
