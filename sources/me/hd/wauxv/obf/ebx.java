package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebx {
    public static final ebw Companion = new ebw();
    public final Integer a;

    public /* synthetic */ ebx(Integer num, int i) {
        if (1 == (i & 1)) {
            this.a = num;
        } else {
            bht.ah(i, 1, ebv.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ebx) && bzo.f(this.a, ((ebx) obj).a);
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
        sb.append(cnb.z(-257079562468138L));
        return bjs.p(sb, this.a, ')');
    }
}
