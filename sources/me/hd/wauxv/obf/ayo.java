package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayo {
    public static final ayn Companion = new ayn();
    public final String a;

    public /* synthetic */ ayo(int i, String str) {
        if (1 == (i & 1)) {
            this.a = str;
        } else {
            bht.ah(i, 1, aym.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ayo) && bzo.f(this.a, ((ayo) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-124828929489706L));
        return bjs.q(sb, this.a, ')');
    }
}
