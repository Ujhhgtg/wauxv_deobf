package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzm {
    public static final dzl Companion = new dzl();
    public static final IHasGetValue[] a = { StaticAndroidHelpers.am(btx.a, new dtr(10)) };
    public final List b;

    public /* synthetic */ dzm(int i, List list) {
        if (1 == (i & 1)) {
            this.b = list;
        } else {
            ResourcesCompat.ah(i, 1, dzk.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dzm) && nullSafeIsEqual(this.b, ((dzm) obj).b);
    }

    public final int hashCode() {
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return "kl1Proto(infos=" /* "kl1Proto(infos=" /* "kl1Proto(infos=" /* cnb.z(-198998719724330L)  */ + this.b + ')';
    }
}
