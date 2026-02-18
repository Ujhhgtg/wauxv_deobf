package me.hd.wauxv.obf;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evu extends bhv {
    public final WindowInsetsController b;
    public final Window c;

    public evu(Window window, cbm cbmVar) {
        this.b = window.getInsetsController();
        this.c = window;
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void an(boolean z) {
        Window window = this.c;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.b.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.b.setSystemBarsAppearance(0, 16);
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void ao(boolean z) {
        Window window = this.c;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.b.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.b.setSystemBarsAppearance(0, 8);
    }
}
