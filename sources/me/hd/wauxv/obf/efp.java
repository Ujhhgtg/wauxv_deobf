package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efp {
    public static final efo Companion = new efo();
    public final String a;
    public final dwj b;
    public final dwj c;
    public final dwj d;
    public final dwj e;
    public final dwj f;
    public final dwj g;

    public /* synthetic */ efp(int i, String str, dwj dwjVar, dwj dwjVar2, dwj dwjVar3, dwj dwjVar4, dwj dwjVar5, dwj dwjVar6) {
        if (127 != (i & 127)) {
            bht.ah(i, 127, efn.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = dwjVar;
        this.c = dwjVar2;
        this.d = dwjVar3;
        this.e = dwjVar4;
        this.f = dwjVar5;
        this.g = dwjVar6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efp)) {
            return false;
        }
        efp efpVar = (efp) obj;
        return bzo.f(this.a, efpVar.a) && bzo.f(this.b, efpVar.b) && bzo.f(this.c, efpVar.c) && bzo.f(this.d, efpVar.d) && bzo.f(this.e, efpVar.e) && bzo.f(this.f, efpVar.f) && bzo.f(this.g, efpVar.g);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        dwj dwjVar = this.b;
        int iHashCode2 = (iHashCode + (dwjVar == null ? 0 : dwjVar.hashCode())) * 31;
        dwj dwjVar2 = this.c;
        int iHashCode3 = (iHashCode2 + (dwjVar2 == null ? 0 : dwjVar2.hashCode())) * 31;
        dwj dwjVar3 = this.d;
        int iHashCode4 = (iHashCode3 + (dwjVar3 == null ? 0 : dwjVar3.hashCode())) * 31;
        dwj dwjVar4 = this.e;
        int iHashCode5 = (iHashCode4 + (dwjVar4 == null ? 0 : dwjVar4.hashCode())) * 31;
        dwj dwjVar5 = this.f;
        int iHashCode6 = (iHashCode5 + (dwjVar5 == null ? 0 : dwjVar5.hashCode())) * 31;
        dwj dwjVar6 = this.g;
        return iHashCode6 + (dwjVar6 != null ? dwjVar6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("u40Proto(key=" /* cnb.z(-288973989608234L) */);
        yg.u(sb, this.a, -288965399673642L);
        dts.h(sb, this.b, -288325449546538L);
        dts.h(sb, this.c, -288312564644650L);
        dts.h(sb, this.d, -288222370331434L);
        dts.h(sb, this.e, -288123586083626L);
        dts.h(sb, this.f, -288604622420778L);
        sb.append(this.g);
        sb.append(')');
        return sb.toString();
    }
}
