package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dsv {
    public static final dsu Companion = new dsu();
    public final String a;
    public final String b;

    public /* synthetic */ dsv(int i, String str, String str2) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dst.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dsv)) {
            return false;
        }
        dsv dsvVar = (dsv) obj;
        return nullSafeIsEqual(this.a, dsvVar.a) && nullSafeIsEqual(this.b, dsvVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmotionProto(md5=" /* cnb.z(-191980743162666L) */);
        yg.u(sb, this.a, -191920613620522L);
        return concat(sb, this.b, ')');
    }
}
