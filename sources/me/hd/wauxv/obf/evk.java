package me.hd.wauxv.obf;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evk extends evj {
    public bps ag;
    public bps ah;
    public bps ai;

    public evk(evr evrVar, WindowInsets windowInsets) {
        super(evrVar, windowInsets);
        this.ag = null;
        this.ah = null;
        this.ai = null;
    }

    @Override // me.hd.wauxv.obf.evi, me.hd.wauxv.obf.evo
    public void ad(bps bpsVar) {
    }

    @Override // me.hd.wauxv.obf.evo
    public bps aj() {
        if (this.ah == null) {
            this.ah = bps.h(this.f.getMandatorySystemGestureInsets());
        }
        return this.ah;
    }

    @Override // me.hd.wauxv.obf.evo
    public bps ak() {
        if (this.ag == null) {
            this.ag = bps.h(this.f.getSystemGestureInsets());
        }
        return this.ag;
    }

    @Override // me.hd.wauxv.obf.evo
    public bps al() {
        if (this.ai == null) {
            this.ai = bps.h(this.f.getTappableElementInsets());
        }
        return this.ai;
    }

    @Override // me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public evr p(int i, int i2, int i3, int i4) {
        return evr.d(null, this.f.inset(i, i2, i3, i4));
    }
}
