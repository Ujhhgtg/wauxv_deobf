package me.hd.wauxv.obf;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evl extends evk {
    public static final evr am = evr.d(null, WindowInsets.CONSUMED);

    public evl(evr evrVar, WindowInsets windowInsets) {
        super(evrVar, windowInsets);
    }

    @Override // me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public final void m(View view) {
    }

    @Override // me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public bps n(int i) {
        return bps.h(this.f.getInsets(evp.a(i)));
    }

    @Override // me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public boolean r(int i) {
        return this.f.isVisible(evp.a(i));
    }
}
