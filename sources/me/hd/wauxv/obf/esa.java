package me.hd.wauxv.obf;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esa implements IHandlesSwipeDismiss {
    public final /* synthetic */ int a;
    public final /* synthetic */ chm c;

    public /* synthetic */ esa(chm chmVar, int i) {
        this.a = i;
        this.c = chmVar;
    }

    @Override // me.hd.wauxv.obf.bm
    public final boolean handleSwipeDismiss(View view) {
        switch (this.a) {
            case 0:
                int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                ViewPager2 viewPager2 = (ViewPager2) this.c.f;
                if (viewPager2.r) {
                    viewPager2.v(currentItem);
                }
                break;
            default:
                int currentItem2 = ((ViewPager2) view).getCurrentItem() - 1;
                ViewPager2 viewPager22 = (ViewPager2) this.c.f;
                if (viewPager22.r) {
                    viewPager22.v(currentItem2);
                }
                break;
        }
        return true;
    }
}
