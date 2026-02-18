package me.hd.wauxv.obf;

import android.text.TextUtils;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpq {
    public final TabLayout a;
    public final ViewPager2 b;
    public final qp c;
    public cyw d;
    public boolean e;

    public dpq(TabLayout tabLayout, ViewPager2 viewPager2, qp qpVar) {
        this.a = tabLayout;
        this.b = viewPager2;
        this.c = qpVar;
    }

    public final void f() {
        dpl dplVar;
        TabLayout tabLayout = this.a;
        tabLayout.ax();
        cyw cywVar = this.d;
        if (cywVar != null) {
            int iD = cywVar.d();
            int i = 0;
            while (true) {
                dplVar = null;
                if (i >= iD) {
                    break;
                }
                dpl dplVarAw = tabLayout.aw();
                CharSequence charSequence = (CharSequence) ((Pair) ((List) this.c.c).get(i)).second;
                if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(charSequence)) {
                    dplVarAw.f.setContentDescription(charSequence);
                }
                dplVarAw.b = charSequence;
                dpn dpnVar = dplVarAw.f;
                if (dpnVar != null) {
                    dpnVar.p();
                }
                tabLayout.ar(dplVarAw, false);
                i++;
            }
            if (iD > 0) {
                int iMin = Math.min(this.b.getCurrentItem(), tabLayout.getTabCount() - 1);
                if (iMin != tabLayout.getSelectedTabPosition()) {
                    if (iMin >= 0 && iMin < tabLayout.getTabCount()) {
                        dplVar = (dpl) tabLayout.c.get(iMin);
                    }
                    tabLayout.ay(dplVar, true);
                }
            }
        }
    }
}
