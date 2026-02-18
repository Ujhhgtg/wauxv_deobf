package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyl {
    public static final dyk Companion = new dyk();
    public final String a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;

    public /* synthetic */ dyl(int i, String str, Integer num, Integer num2, Integer num3, Integer num4) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, dyj.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = num3;
        this.e = num4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyl)) {
            return false;
        }
        dyl dylVar = (dyl) obj;
        return nullSafeIsEqual(this.a, dylVar.a) && nullSafeIsEqual(this.b, dylVar.b)
                && nullSafeIsEqual(this.c, dylVar.c) && nullSafeIsEqual(this.d, dylVar.d)
                && nullSafeIsEqual(this.e, dylVar.e);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.d;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.e;
        return iHashCode4 + (num4 != null ? num4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("hs3Proto(feed_detail_url=" /* cnb.z(-207343841180458L) */);
        yg.u(sb, this.a, -207799107713834L);
        bjs.w(sb, this.b, -207769042942762L);
        bjs.w(sb, this.c, -207696028498730L);
        bjs.w(sb, this.d, -207627309021994L);
        return concat(sb, this.e, ')');
    }
}
