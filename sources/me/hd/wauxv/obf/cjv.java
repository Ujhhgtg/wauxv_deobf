package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cjv {
    public static final ps k = new ps(2, false);
    public static final ps l = new ps(4, false);
    public static final pr m = new pr(4, true);
    public static final pr n = new pr(5, true);
    public static final ps o = new ps(3, false);
    public static final pr p = new pr(6, true);
    public static final pr q = new pr(7, true);
    public static final ps r = new ps(1, false);
    public static final pr s = new pr(2, true);
    public static final pr t = new pr(3, true);
    public static final ps u = new ps(0, false);
    public static final pr v = new pr(0, true);
    public static final pr w = new pr(1, true);
    public static final ps x = new ps(5, true);
    public static final pr y = new pr(8, true);
    public static final pr z = new pr(9, true);
    public final boolean aa;

    public cjv(boolean z2) {
        this.aa = z2;
    }

    public String b(Object obj) {
        return String.valueOf(obj);
    }

    public abstract Object f(String str, Bundle bundle);

    public abstract String g();

    public Object h(Object obj, String str) {
        return i(str);
    }

    public abstract Object i(String str);

    public abstract void j(Bundle bundle, String str, Object obj);

    public final String toString() {
        return g();
    }
}
