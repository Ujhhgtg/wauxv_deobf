package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class egl {
    public static final egk Companion = new egk();
    public final Integer a;

    public /* synthetic */ egl(Integer num, int i) {
        if (1 == (i & 1)) {
            this.a = num;
        } else {
            ResourcesCompat.ah(i, 1, egj.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof egl) && nullSafeIsEqual(this.a, ((egl) obj).a);
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
        sb.append("vc1Proto(number=" /* "vc1Proto(number=" /* "vc1Proto(number=" /* "vc1Proto(number=" /* cnb.z(-313184720255786L)   */);
        return concat(sb, this.a, ')');
    }
}
