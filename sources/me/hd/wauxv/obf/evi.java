package me.hd.wauxv.obf;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evi extends evh {
    public bps y;

    public evi(evr evrVar, WindowInsets windowInsets) {
        super(evrVar, windowInsets);
        this.y = null;
    }

    @Override // me.hd.wauxv.obf.evo
    public evr aa() {
        return evr.d(null, this.f.consumeSystemWindowInsets());
    }

    @Override // me.hd.wauxv.obf.evo
    public final bps ab() {
        if (this.y == null) {
            WindowInsets windowInsets = this.f;
            this.y = bps.g(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.y;
    }

    @Override // me.hd.wauxv.obf.evo
    public boolean ac() {
        return this.f.isConsumed();
    }

    @Override // me.hd.wauxv.obf.evo
    public void ad(bps bpsVar) {
        this.y = bpsVar;
    }

    @Override // me.hd.wauxv.obf.evo
    public evr z() {
        return evr.d(null, this.f.consumeStableInsets());
    }
}
