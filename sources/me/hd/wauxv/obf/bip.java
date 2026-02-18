package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bip {
    public static final bio Companion = new bio();
    public Integer a;
    public bim b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bip)) {
            return false;
        }
        bip bipVar = (bip) obj;
        return nullSafeIsEqual(this.a, bipVar.a) && nullSafeIsEqual(this.b, bipVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        bim bimVar = this.b;
        return iHashCode + (bimVar != null ? bimVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GmailList(Count=" /* cnb.z(-341522914474794L) */);
        bjs.w(sb, this.a, -341467079899946L);
        sb.append(this.b);
        sb.append(')');
        return sb.toString();
    }
}
