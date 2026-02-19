package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dzs {
    public static final dzr Companion = new dzr();
    public static final IHasGetValue[] a = { StaticAndroidHelpers.am(btx.a, new dtr(12)) };
    public final List b;

    public /* synthetic */ dzs(int i, List list) {
        if (1 == (i & 1)) {
            this.b = list;
        } else {
            ResourcesCompat.ah(i, 1, dzq.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dzs) && nullSafeIsEqual(this.b, ((dzs) obj).b);
    }

    public final int hashCode() {
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return "l23Proto(mic_contacts=" /* "l23Proto(mic_contacts=" /* "l23Proto(mic_contacts=" /* "l23Proto(mic_contacts=" /* cnb.z(-222694054296362L)   */ + this.b + ')';
    }
}
