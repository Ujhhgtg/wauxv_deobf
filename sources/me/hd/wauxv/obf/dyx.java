package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dyx {
    public static final dyw Companion = new dyw();
    public final dsy a;
    public final eca b;
    public final String c;
    public final String d;

    public /* synthetic */ dyx(int i, dsy dsyVar, eca ecaVar, String str, String str2) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, dyv.b.getDescriptor());
            throw null;
        }
        this.a = dsyVar;
        this.b = ecaVar;
        this.c = str;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dyx)) {
            return false;
        }
        dyx dyxVar = (dyx) obj;
        return bzo.f(this.a, dyxVar.a) && bzo.f(this.b, dyxVar.b) && bzo.f(this.c, dyxVar.c) && bzo.f(this.d, dyxVar.d);
    }

    public final int hashCode() {
        dsy dsyVar = this.a;
        int iHashCode = (dsyVar == null ? 0 : dsyVar.hashCode()) * 31;
        eca ecaVar = this.b;
        int iHashCode2 = (iHashCode + (ecaVar == null ? 0 : ecaVar.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-195274983078698L));
        sb.append(this.a);
        sb.append(cnb.z(-195214853536554L));
        sb.append(this.b);
        sb.append(cnb.z(-195704479808298L));
        yg.u(sb, this.c, -195605695560490L);
        return bjs.q(sb, this.d, ')');
    }
}
