package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ecj {
    public static final eci Companion = new eci();
    public static final IHasGetValue[] a = { null, StaticAndroidHelpers.am(btx.a, new dtr(22)) };
    public final dwa b;
    public final List c;

    public /* synthetic */ ecj(int i, dwa dwaVar, List list) {
        if (3 != (i & 3)) {
            ResourcesCompat.ah(i, 3, ech.b.getDescriptor());
            throw null;
        }
        this.b = dwaVar;
        this.c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ecj)) {
            return false;
        }
        ecj ecjVar = (ecj) obj;
        return nullSafeIsEqual(this.b, ecjVar.b) && nullSafeIsEqual(this.c, ecjVar.c);
    }

    public final int hashCode() {
        dwa dwaVar = this.b;
        int iHashCode = (dwaVar == null ? 0 : dwaVar.hashCode()) * 31;
        List list = this.c;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "o5Proto(music=" /* "o5Proto(music=" /* "o5Proto(music=" /* "o5Proto(music=" /* cnb.z(-259678017682218L)   */ + this.b
                + ", vibratio_meta_info_list=" /* ", vibratio_meta_info_list=" /* ", vibratio_meta_info_list=" /* ", vibratio_meta_info_list=" /* cnb.z(-259613593172778L)   */ + this.c + ')';
    }
}
