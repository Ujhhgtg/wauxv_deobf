package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eab {
    public static final eaa Companion = new eaa();
    public final Integer a;
    public final String b;

    public /* synthetic */ eab(int i, Integer num, String str) {
        if (3 != (i & 3)) {
            ResourcesCompat.ah(i, 3, dzz.b.getDescriptor());
            throw null;
        }
        this.a = num;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eab)) {
            return false;
        }
        eab eabVar = (eab) obj;
        return nullSafeIsEqual(this.a, eabVar.a) && nullSafeIsEqual(this.b, eabVar.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ll1Proto(module_type=" /* "ll1Proto(module_type=" /* "ll1Proto(module_type=" /* "ll1Proto(module_type=" /* cnb.z(-220233038035754L)   */);
        bjs.w(sb, this.a, -221770636327722L);
        return concat(sb, this.b, ')');
    }
}
