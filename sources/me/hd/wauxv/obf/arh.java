package me.hd.wauxv.obf;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class arh extends arg {
    @Override // me.hd.wauxv.obf.arf
    public void b(dox doxVar, dox doxVar2, Window window, View view, boolean z, boolean z2) {
        throwIfVar1IsNull(doxVar, "statusBarStyle");
        throwIfVar1IsNull(doxVar2, "navigationBarStyle");
        throwIfVar1IsNull(window, "window");
        throwIfVar1IsNull(view, "view");
        bht.ac(window, false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(true);
        cbm cbmVar = new cbm(view, 24);
        int i = Build.VERSION.SDK_INT;
        bhv evvVar = i >= 35 ? new evv(window, cbmVar) : i >= 30 ? new evu(window, cbmVar) : new evs(window, cbmVar);
        evvVar.ao(!z);
        evvVar.an(!z2);
    }
}
