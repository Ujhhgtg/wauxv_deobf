package me.hd.wauxv.obf;

import android.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cca implements ActionProvider.VisibilityListener {
    public bmu a;
    public final ActionProvider b;

    public cca(ccd ccdVar, ActionProvider actionProvider) {
        this.b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        bmu bmuVar = this.a;
        if (bmuVar != null) {
            cbw cbwVar = ((cbz) bmuVar.h).n;
            cbwVar.i = true;
            cbwVar.ao(true);
        }
    }
}
