package me.hd.wauxv.obf;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cj implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ActionBarOverlayLayout b;

    public /* synthetic */ cj(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.a = i;
        this.b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.b;
                actionBarOverlayLayout.am();
                actionBarOverlayLayout.z = actionBarOverlayLayout.g.animate().translationY(0.0f).setListener(actionBarOverlayLayout.aa);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.b;
                actionBarOverlayLayout2.am();
                actionBarOverlayLayout2.z = actionBarOverlayLayout2.g.animate().translationY(-actionBarOverlayLayout2.g.getHeight()).setListener(actionBarOverlayLayout2.aa);
                break;
        }
    }
}
