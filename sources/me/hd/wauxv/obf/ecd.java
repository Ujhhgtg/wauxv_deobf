package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecd {
    public static final ecc Companion = new ecc();
    public final dsy a;
    public final Integer b;
    public final String c;
    public final dxq d;
    public final eex e;

    public /* synthetic */ ecd(int i, dsy dsyVar, Integer num, String str, dxq dxqVar, eex eexVar) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, ecb.b.getDescriptor());
            throw null;
        }
        this.a = dsyVar;
        this.b = num;
        this.c = str;
        this.d = dxqVar;
        this.e = eexVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ecd)) {
            return false;
        }
        ecd ecdVar = (ecd) obj;
        return bzo.f(this.a, ecdVar.a) && bzo.f(this.b, ecdVar.b) && bzo.f(this.c, ecdVar.c) && bzo.f(this.d, ecdVar.d) && bzo.f(this.e, ecdVar.e);
    }

    public final int hashCode() {
        dsy dsyVar = this.a;
        int iHashCode = (dsyVar == null ? 0 : dsyVar.hashCode()) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        dxq dxqVar = this.d;
        int iHashCode4 = (iHashCode3 + (dxqVar == null ? 0 : dxqVar.hashCode())) * 31;
        eex eexVar = this.e;
        return iHashCode4 + (eexVar != null ? eexVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("o22Proto(contact=" /* cnb.z(-262134738975530L) */);
        sb.append(this.a);
        sb.append(", enable_click_author=" /* cnb.z(-262074609433386L) */);
        bjs.w(sb, this.b, -261975825185578L);
        yg.u(sb, this.c, -263599322823466L);
        sb.append(this.d);
        sb.append(", lite_app_param=" /* cnb.z(-263517718444842L) */);
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
