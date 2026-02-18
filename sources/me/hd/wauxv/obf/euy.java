package me.hd.wauxv.obf;

import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euy extends euz {
    public final WindowInsetsAnimation a;

    public euy(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.a = windowInsetsAnimation;
    }

    @Override // me.hd.wauxv.obf.euz
    public final long b() {
        return this.a.getDurationMillis();
    }

    @Override // me.hd.wauxv.obf.euz
    public final float c() {
        return this.a.getInterpolatedFraction();
    }

    @Override // me.hd.wauxv.obf.euz
    public final int d() {
        return this.a.getTypeMask();
    }

    @Override // me.hd.wauxv.obf.euz
    public final void e(float f) {
        this.a.setFraction(f);
    }
}
