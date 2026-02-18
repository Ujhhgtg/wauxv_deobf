package me.hd.wauxv.obf;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class evs extends bhv {
    public final Window b;

    public evs(Window window, cbm cbmVar) {
        this.b = window;
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void an(boolean z) {
        if (!z) {
            c(16);
            return;
        }
        Window window = this.b;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void ao(boolean z) {
        if (!z) {
            c(8192);
            return;
        }
        Window window = this.b;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
    }

    public final void c(int i) {
        View decorView = this.b.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
