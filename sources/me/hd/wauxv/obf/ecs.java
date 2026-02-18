package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecs {
    public static final ecr Companion = new ecr();
    public final Integer a;

    public /* synthetic */ ecs(Integer num, int i) {
        if (1 == (i & 1)) {
            this.a = num;
        } else {
            bht.ah(i, 1, ecq.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ecs) && nullSafeIsEqual(this.a, ((ecs) obj).a);
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
        sb.append("ol1Proto(audienceMode=" /* cnb.z(-249086628330282L) */);
        return concat(sb, this.a, ')');
    }
}
