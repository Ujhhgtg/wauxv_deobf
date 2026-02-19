package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ein {
    public static final eim Companion = new eim();
    public final String a;
    public final dwj b;
    public final dwj c;

    public /* synthetic */ ein(int i, String str, dwj dwjVar, dwj dwjVar2) {
        if (7 != (i & 7)) {
            ResourcesCompat.ah(i, 7, eil.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = dwjVar;
        this.c = dwjVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ein)) {
            return false;
        }
        ein einVar = (ein) obj;
        return nullSafeIsEqual(this.a, einVar.a) && nullSafeIsEqual(this.b, einVar.b)
                && nullSafeIsEqual(this.c, einVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        dwj dwjVar = this.b;
        int iHashCode2 = (iHashCode + (dwjVar == null ? 0 : dwjVar.hashCode())) * 31;
        dwj dwjVar2 = this.c;
        return iHashCode2 + (dwjVar2 != null ? dwjVar2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("xo3Proto(animation_id=" /* "xo3Proto(animation_id=" /* "xo3Proto(animation_id=" /* cnb.z(-320786812369706L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -320138272308010L);
        dts.h(sb, this.b, -320116797471530L);
        sb.append(this.c);
        sb.append(')');
        return sb.toString();
    }
}
