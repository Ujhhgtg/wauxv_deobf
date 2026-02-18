package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class edt {
    public static final eds Companion = new eds();
    public final String a;
    public final String b;
    public final Long c;

    public /* synthetic */ edt(int i, String str, String str2, Long l) {
        if (7 != (i & 7)) {
            bht.ah(i, 7, edr.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof edt)) {
            return false;
        }
        edt edtVar = (edt) obj;
        return bzo.f(this.a, edtVar.a) && bzo.f(this.b, edtVar.b) && bzo.f(this.c, edtVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.c;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-276617368697642L));
        yg.u(sb, this.a, -277059750329130L);
        yg.u(sb, this.b, -277042570459946L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
