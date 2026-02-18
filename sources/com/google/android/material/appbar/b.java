package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import me.hd.wauxv.obf.aq;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.bd;
import me.hd.wauxv.obf.gs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends aq {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ CoordinatorLayout b;
    public final /* synthetic */ AppBarLayout.BaseBehavior c;

    public b(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.a = appBarLayout;
        this.b = coordinatorLayout;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void d(View view, bd bdVar) {
        this.g.onInitializeAccessibilityNodeInfo(view, bdVar.a);
        bdVar.k(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.a;
        if (appBarLayout.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.b;
        AppBarLayout.BaseBehavior baseBehavior = this.c;
        View viewF = AppBarLayout.BaseBehavior.f(baseBehavior, coordinatorLayout);
        if (viewF == null) {
            return;
        }
        int childCount = appBarLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((gs) appBarLayout.getChildAt(i).getLayoutParams()).a != 0) {
                if (baseBehavior.q() != (-appBarLayout.getTotalScrollRange())) {
                    bdVar.e(ax.b);
                    bdVar.m(true);
                }
                if (baseBehavior.q() != 0) {
                    if (!viewF.canScrollVertically(-1)) {
                        bdVar.e(ax.c);
                        bdVar.m(true);
                        return;
                    } else {
                        if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            bdVar.e(ax.c);
                            bdVar.m(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public final boolean e(View view, int i, Bundle bundle) {
        AppBarLayout appBarLayout = this.a;
        if (i == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i != 8192) {
            return super.e(view, i, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.c;
        if (baseBehavior.q() != 0) {
            CoordinatorLayout coordinatorLayout = this.b;
            View viewF = AppBarLayout.BaseBehavior.f(baseBehavior, coordinatorLayout);
            if (!viewF.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i2 = -appBarLayout.getDownNestedPreScrollRange();
            if (i2 != 0) {
                baseBehavior._o(coordinatorLayout, this.a, viewF, i2, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
