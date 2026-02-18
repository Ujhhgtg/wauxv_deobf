package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class efm {
    public static final efl Companion = new efl();
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public /* synthetic */ efm(String str, String str2, String str3, int i, String str4) {
        if (15 != (i & 15)) {
            bht.ah(i, 15, efk.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efm)) {
            return false;
        }
        efm efmVar = (efm) obj;
        return bzo.f(this.a, efmVar.a) && bzo.f(this.b, efmVar.b) && bzo.f(this.c, efmVar.c) && bzo.f(this.d, efmVar.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tuProto(wholly_push_wording=" /* cnb.z(-283562330815274L) */);
        yg.u(sb, this.a, -283403417025322L);
        yg.u(sb, this.b, -282767761865514L);
        yg.u(sb, this.c, -282664682650410L);
        return bjs.q(sb, this.d, ')');
    }
}
