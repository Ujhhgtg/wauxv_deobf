package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dth {
    public static final dtg Companion = new dtg();
    public final String a;

    public /* synthetic */ dth(int i, String str) {
        if (1 == (i & 1)) {
            this.a = str;
        } else {
            bht.ah(i, 1, dtf.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dth) && bzo.f(this.a, ((dth) obj).a);
    }

    public final int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FinderMediaProto(url=" /* cnb.z(-183098750794538L) */);
        return bjs.q(sb, this.a, ')');
    }
}
