package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.List;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eme {
    public final zc a;
    public final List b;
    public final int c;

    public eme(zc zcVar, boolean z) {
        List list = Collections.EMPTY_LIST;
        throwIfVar1IsNull(list, "arguments");
        this.a = zcVar;
        this.b = list;
        this.c = z ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof eme)) {
            return false;
        }
        eme emeVar = (eme) obj;
        if (!this.a.equals(emeVar.a)) {
            return false;
        }
        List list = Collections.EMPTY_LIST;
        return nullSafeIsEqual(list, list) && this.c == emeVar.c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.c) + bjs.g(Collections.EMPTY_LIST, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Class clsBd = cnf.getJavaClass(this.a);
        String name = clsBd.isArray()
                ? clsBd.equals(boolean[].class) ? "kotlin.BooleanArray"
                        : clsBd.equals(char[].class) ? "kotlin.CharArray"
                                : clsBd.equals(byte[].class) ? "kotlin.ByteArray"
                                        : clsBd.equals(short[].class) ? "kotlin.ShortArray"
                                                : clsBd.equals(int[].class) ? "kotlin.IntArray"
                                                        : clsBd.equals(float[].class) ? "kotlin.FloatArray"
                                                                : clsBd.equals(long[].class) ? "kotlin.LongArray"
                                                                        : clsBd.equals(double[].class)
                                                                                ? "kotlin.DoubleArray"
                                                                                : "kotlin.Array"
                : clsBd.getName();
        List list = Collections.EMPTY_LIST;
        sb.append(name + (list.isEmpty() ? "" : aaz.k(list, ", ", "<", ">", new dos(10), 24))
                + ((this.c & 1) != 0 ? TypeDescription.Generic.OfWildcardType.SYMBOL : ""));
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
