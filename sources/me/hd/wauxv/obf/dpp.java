package me.hd.wauxv.obf;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpp implements dpi {
    public final ViewPager2 a;

    public dpp(ViewPager2 viewPager2) {
        this.a = viewPager2;
    }

    @Override // me.hd.wauxv.obf.dph
    public final void c(dpl dplVar) {
        int i = dplVar.c;
        ViewPager2 viewPager2 = this.a;
        Object obj = viewPager2.n.v;
        viewPager2.v(i);
    }
}
