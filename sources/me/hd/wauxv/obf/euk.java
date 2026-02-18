package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euk {
    public final String a;
    public final String b;
    public final epy c;

    public euk(String str, String str2, epy epyVar) {
        this.a = str;
        this.b = str2;
        this.c = epyVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof euk)) {
            return false;
        }
        euk eukVar = (euk) obj;
        return this.a.equals(eukVar.a) && this.b.equals(eukVar.b) && this.c.equals(eukVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + dts.a(0, bjs.e(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrefItemBean(key=" /* cnb.z(-57260503989034L) */);
        yg.u(sb, this.a, -57200374446890L);
        sb.append(this.b);
        sb.append(", index=" /* cnb.z(-57711475555114L) */);
        sb.append(0);
        sb.append(", onClick=" /* cnb.z(-57690000718634L) */);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
