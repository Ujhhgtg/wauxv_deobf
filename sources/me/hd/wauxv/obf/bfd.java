package me.hd.wauxv.obf;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bfd {
    public static final bfc a = bfc.a;

    public static bfc b(SomeFragmentManager someFragmentManagerVar) {
        while (someFragmentManagerVar != null) {
            if (someFragmentManagerVar.cv()) {
                someFragmentManagerVar.cs();
            }
            someFragmentManagerVar = someFragmentManagerVar.bp;
        }
        return a;
    }

    public static void c(bex bexVar) {
        if (beg.ar(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(bexVar.a.getClass().getName()), bexVar);
        }
    }

    public static final void d(SomeFragmentManager someFragmentManagerVar, String str) {
        throwIfVar1IsNull(str, "previousFragmentId");
        c(new bex(someFragmentManagerVar, "Attempting to reuse fragment " + someFragmentManagerVar + " with previous ID " + str));
        b(someFragmentManagerVar).getClass();
    }
}
