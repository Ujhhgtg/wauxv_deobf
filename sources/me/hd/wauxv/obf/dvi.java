package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dvi {
    public static final dvh Companion = new dvh();
    public final Integer a;
    public final Integer b;
    public final Long c;
    public final Long d;

    public /* synthetic */ dvi(int i, Integer num, Integer num2, Long l, Long l2) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, dvg.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = num2;
        this.c = l;
        this.d = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dvi)) {
            return false;
        }
        dvi dviVar = (dvi) obj;
        return bzo.f(this.a, dviVar.a) && bzo.f(this.b, dviVar.b) && bzo.f(this.c, dviVar.c) && bzo.f(this.d, dviVar.d);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.c;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.d;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-142670223637290L));
        bjs.w(sb, this.a, -141987323837226L);
        bjs.w(sb, this.b, -141931489262378L);
        dkz.ad(sb, this.c, -141854179851050L);
        sb.append(this.d);
        sb.append(')');
        return sb.toString();
    }
}
