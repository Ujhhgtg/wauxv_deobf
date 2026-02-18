package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxe {
    public static final dxd Companion = new dxd();
    public final String a;
    public final Integer b;

    public /* synthetic */ dxe(int i, Integer num, String str) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dxc.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxe)) {
            return false;
        }
        dxe dxeVar = (dxe) obj;
        return nullSafeIsEqual(this.a, dxeVar.a) && nullSafeIsEqual(this.b, dxeVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.b;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("f52Proto(template_id=" /* cnb.z(-191388037675818L) */);
        yg.u(sb, this.a, -191345088002858L);
        return concat(sb, this.b, ')');
    }
}
