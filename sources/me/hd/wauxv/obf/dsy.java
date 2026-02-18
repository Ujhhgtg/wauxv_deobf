package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dsy {
    public static final dsx Companion = new dsx();
    public final String a;

    public /* synthetic */ dsy(int i, String str) {
        if (1 == (i & 1)) {
            this.a = str;
        } else {
            bht.ah(i, 1, dsw.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dsy) && bzo.f(this.a, ((dsy) obj).a);
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
        sb.append("FinderContactProto(username=" /* cnb.z(-190756677483306L) */);
        return bjs.q(sb, this.a, ')');
    }
}
