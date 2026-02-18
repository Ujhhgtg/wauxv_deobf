package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ejr {
    public static final ejq Companion = new ejq();
    public final Integer a;
    public final Long b;
    public final Long c;
    public final String d;

    public /* synthetic */ ejr(int i, Integer num, Long l, Long l2, String str) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, ejp.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = l;
        this.c = l2;
        this.d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ejr)) {
            return false;
        }
        ejr ejrVar = (ejr) obj;
        return bzo.f(this.a, ejrVar.a) && bzo.f(this.b, ejrVar.b) && bzo.f(this.c, ejrVar.c) && bzo.f(this.d, ejrVar.d);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.b;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.c;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.d;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-344520801647402L));
        bjs.w(sb, this.a, -350456446450474L);
        dkz.ad(sb, this.b, -350379137039146L);
        dkz.ad(sb, this.c, -350314712529706L);
        return bjs.q(sb, this.d, ')');
    }
}
