package me.hd.wauxv.obf;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class erv extends cyy {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ erv(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.cyy
    public final void c() {
        switch (this.a) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.b;
                viewPager2.e = true;
                viewPager2.l.n = true;
                break;
            default:
                ((chm) this.b).av();
                break;
        }
    }

    @Override // me.hd.wauxv.obf.cyy
    public final void d(int i, int i2) {
        c();
    }
}
