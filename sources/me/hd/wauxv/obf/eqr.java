package me.hd.wauxv.obf;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eqr {
    public static evr a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        evr evrVarD = evr.d(null, rootWindowInsets);
        evo evoVar = evrVarD.b;
        evoVar.t(evrVarD);
        evoVar.m(view.getRootView());
        return evrVarD;
    }

    public static void b(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
