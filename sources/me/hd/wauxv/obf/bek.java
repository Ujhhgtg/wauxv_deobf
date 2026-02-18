package me.hd.wauxv.obf;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bek implements eqj {
    public final CoordinatorLayout a;
    public final TabLayout b;
    public final ViewPager2 c;
    public final MaterialToolbar d;

    public bek(CoordinatorLayout coordinatorLayout, TabLayout tabLayout, ViewPager2 viewPager2, MaterialToolbar materialToolbar) {
        this.a = coordinatorLayout;
        this.b = tabLayout;
        this.c = viewPager2;
        this.d = materialToolbar;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
