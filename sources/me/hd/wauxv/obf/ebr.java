package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebr {
    public static final ebq Companion = new ebq();
    public final Integer a;

    public /* synthetic */ ebr(Integer num, int i) {
        if (1 == (i & 1)) {
            this.a = num;
        } else {
            ResourcesCompat.ah(i, 1, ebp.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ebr) && nullSafeIsEqual(this.a, ((ebr) obj).a);
    }

    public final int hashCode() {
        Integer num = this.a;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ni1Proto(audience_no_privilege=" /* "ni1Proto(audience_no_privilege=" /* "ni1Proto(audience_no_privilege=" /* cnb.z(-259235636050730L)  */);
        return concat(sb, this.a, ')');
    }
}
