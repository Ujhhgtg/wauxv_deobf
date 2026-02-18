package com.google.android.material.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    public boolean f;

    public SearchBar$ScrollingViewBehavior() {
        this.f = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, me.hd.wauxv.obf.agr
    public final boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        super.c(coordinatorLayout, view, view2);
        if (!this.f && (view2 instanceof AppBarLayout)) {
            this.f = true;
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }
        return false;
    }

    public SearchBar$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
    }
}
