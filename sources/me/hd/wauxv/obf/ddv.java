package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ddv {
    public static final ddu Companion = new ddu();
    public final String a;

    public /* synthetic */ ddv(int i, String str) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ddv) && nullSafeIsEqual(this.a, ((ddv) obj).a);
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
        sb.append("SKBuiltinString(string=" /* "SKBuiltinString(string=" /* "SKBuiltinString(string=" /* "SKBuiltinString(string=" /* cnb.z(-151273043131178L)   */);
        return concat(sb, this.a, ')');
    }
}
