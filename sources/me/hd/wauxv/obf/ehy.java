package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ehy {
    public static final ehx Companion = new ehx();
    public final Long a;
    public final Integer b;
    public final String c;
    public final String d;

    public /* synthetic */ ehy(int i, Long l, Integer num, String str, String str2) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, ehw.b.getDescriptor());
            throw null;
        }
        this.a = l;
        this.b = num;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ehy)) {
            return false;
        }
        ehy ehyVar = (ehy) obj;
        return bzo.f(this.a, ehyVar.a) && bzo.f(this.b, ehyVar.b) && bzo.f(this.c, ehyVar.c) && bzo.f(this.d, ehyVar.d);
    }

    public final int hashCode() {
        Long l = this.a;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("wq0Proto(highest_reward=" /* cnb.z(-332731116419882L) */);
        dkz.ad(sb, this.a, -332623742237482L);
        bjs.w(sb, this.b, -333053238967082L);
        yg.u(sb, this.c, -332997404392234L);
        return bjs.q(sb, this.d, ')');
    }
}
