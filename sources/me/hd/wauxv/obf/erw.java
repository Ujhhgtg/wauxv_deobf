package me.hd.wauxv.obf;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class erw extends erz {
    public final /* synthetic */ int a;
    public final /* synthetic */ ViewPager2 b;

    public /* synthetic */ erw(ViewPager2 viewPager2, int i) {
        this.a = i;
        this.b = viewPager2;
    }

    @Override // me.hd.wauxv.obf.erz
    public void c(int i) {
        switch (this.a) {
            case 0:
                if (i == 0) {
                    this.b.w();
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.erz
    public final void e(int i) {
        switch (this.a) {
            case 0:
                ViewPager2 viewPager2 = this.b;
                if (viewPager2.d != i) {
                    viewPager2.d = i;
                    viewPager2.t.av();
                }
                break;
            default:
                ViewPager2 viewPager22 = this.b;
                viewPager22.clearFocus();
                if (viewPager22.hasFocus()) {
                    viewPager22.j.requestFocus(2);
                }
                break;
        }
    }
}
