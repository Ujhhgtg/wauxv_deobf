package me.hd.wauxv.obf;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class evn extends evm {
    public static final evr an = evr.d(null, WindowInsets.CONSUMED);

    public evn(evr evrVar, WindowInsets windowInsets) {
        super(evrVar, windowInsets);
    }

    @Override // me.hd.wauxv.obf.evl, me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public bps n(int i) {
        return bps.locateDex(this.f.getInsets(evq.a(i)));
    }

    @Override // me.hd.wauxv.obf.evl, me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public boolean r(int i) {
        return this.f.isVisible(evq.a(i));
    }
}
