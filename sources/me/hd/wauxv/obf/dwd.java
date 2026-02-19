package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dwd {
    public static final dwc Companion = new dwc();
    public static final IHasGetValue[] a = { ewz.am(btx.a, new dtr(2)) };
    public final List b;

    public /* synthetic */ dwd(int i, List list) {
        if (1 == (i & 1)) {
            this.b = list;
        } else {
            bht.ah(i, 1, dwb.b.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dwd) && nullSafeIsEqual(this.b, ((dwd) obj).b);
    }

    public final int hashCode() {
        List list = this.b;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return "cf1Proto(mode_config_list=" /* "cf1Proto(mode_config_list=" /* "cf1Proto(mode_config_list=" /* cnb.z(-175131586460458L)  */ + this.b + ')';
    }
}
