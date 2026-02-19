package me.hd.wauxv.obf;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eur extends StaticHelpers7 {
    public final /* synthetic */ int a;
    public final /* synthetic */ eut b;

    public /* synthetic */ eur(eut eutVar, int i) {
        this.a = i;
        this.b = eutVar;
    }

    @Override // me.hd.wauxv.obf.esi
    public final void f() {
        View view;
        int i = this.a;
        eut eutVar = this.b;
        switch (i) {
            case 0:
                if (eutVar.bd && (view = eutVar.av) != null) {
                    view.setTranslationY(0.0f);
                    eutVar.as.setTranslationY(0.0f);
                }
                eutVar.as.setVisibility(8);
                eutVar.as.setTransitioning(false);
                eutVar.bh = null;
                DefaultConfig ioVar = eutVar.az;
                if (ioVar != null) {
                    ioVar.ao(eutVar.ay);
                    eutVar.ay = null;
                    eutVar.az = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = eutVar.ar;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    eqo.c(actionBarOverlayLayout);
                }
                break;
            default:
                eutVar.bh = null;
                eutVar.as.requestLayout();
                break;
        }
    }
}
