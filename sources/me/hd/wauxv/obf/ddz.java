package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ddz {
    public static final ddy Companion = new ddy();
    public String a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ddz) && nullSafeIsEqual(this.a, ((ddz) obj).a);
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
        sb.append("SKBuiltinString_t(String=" /* "SKBuiltinString_t(String=" /* "SKBuiltinString_t(String=" /* cnb.z(-361447267760938L)  */);
        return concat(sb, this.a, ')');
    }
}
