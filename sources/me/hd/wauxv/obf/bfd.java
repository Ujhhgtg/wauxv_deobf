package me.hd.wauxv.obf;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bfd {
    public static final bfc a = bfc.a;

    public static bfc b(bdj bdjVar) {
        while (bdjVar != null) {
            if (bdjVar.cv()) {
                bdjVar.cs();
            }
            bdjVar = bdjVar.bp;
        }
        return a;
    }

    public static void c(bex bexVar) {
        if (beg.ar(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(bexVar.a.getClass().getName()), bexVar);
        }
    }

    public static final void d(bdj bdjVar, String str) {
        bzo.q(str, "previousFragmentId");
        c(new bex(bdjVar, "Attempting to reuse fragment " + bdjVar + " with previous ID " + str));
        b(bdjVar).getClass();
    }
}
