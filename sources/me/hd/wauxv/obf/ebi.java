package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ebi {
    public static final ebh Companion = new ebh();
    public static final btt[] a = { ewz.am(btx.a, new dtr(21)) };
    public final List b;

    public /* synthetic */ ebi(int i, List list) {
        if (1 == (i & 1)) {
            this.b = list;
        } else {
            bht.ah(i, 1, ebg.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ebi) && nullSafeIsEqual(this.b, ((ebi) obj).b);
    }

    public final int hashCode() {
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return "mt1Proto(list=" /* cnb.z(-234823041940266L) */ + this.b + ')';
    }
}
