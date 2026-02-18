package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dxw {
    public static final dxv Companion = new dxv();
    public final Integer a;
    public final String b;

    public /* synthetic */ dxw(int i, Integer num, String str) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, dxu.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dxw)) {
            return false;
        }
        dxw dxwVar = (dxw) obj;
        return bzo.f(this.a, dxwVar.a) && bzo.f(this.b, dxwVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gf1Proto(seat_id=" /* cnb.z(-181814555573034L) */);
        bjs.w(sb, this.a, -181754426030890L);
        return bjs.q(sb, this.b, ')');
    }
}
