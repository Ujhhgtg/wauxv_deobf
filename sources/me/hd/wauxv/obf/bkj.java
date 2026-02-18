package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar$ScrollingViewBehavior;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bkj extends ers {
    public final Rect g;
    public final Rect h;
    public int q;
    public int r;

    public bkj() {
        this.g = new Rect();
        this.h = new Rect();
        this.q = 0;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        AppBarLayout appBarLayout_q;
        evr lastWindowInsets;
        int i4 = view.getLayoutParams().height;
        if ((i4 != -1 && i4 != -2) || (appBarLayout_q = AppBarLayout.ScrollingViewBehavior._q(coordinatorLayout.af(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size > 0) {
            WeakHashMap weakHashMap = eqz.a;
            if (appBarLayout_q.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.e() + lastWindowInsets.h();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int totalScrollRange = appBarLayout_q.getTotalScrollRange() + size;
        int measuredHeight = appBarLayout_q.getMeasuredHeight();
        if (this instanceof SearchBar$ScrollingViewBehavior) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            totalScrollRange -= measuredHeight;
        }
        coordinatorLayout.as(i, i2, View.MeasureSpec.makeMeasureSpec(totalScrollRange, i4 == -1 ? 1073741824 : Integer.MIN_VALUE), view);
        return true;
    }

    @Override // me.hd.wauxv.obf.ers
    public final void s(CoordinatorLayout coordinatorLayout, View view, int i) {
        AppBarLayout appBarLayout_q = AppBarLayout.ScrollingViewBehavior._q(coordinatorLayout.af(view));
        if (appBarLayout_q == null) {
            coordinatorLayout.ar(view, i);
            this.q = 0;
            return;
        }
        agu aguVar = (agu) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin;
        int bottom = appBarLayout_q.getBottom() + ((ViewGroup.MarginLayoutParams) aguVar).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) aguVar).rightMargin;
        int bottom2 = ((appBarLayout_q.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin;
        Rect rect = this.g;
        rect.set(paddingLeft, bottom, width, bottom2);
        evr lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null) {
            WeakHashMap weakHashMap = eqz.a;
            if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                rect.left = lastWindowInsets.f() + rect.left;
                rect.right -= lastWindowInsets.g();
            }
        }
        int i2 = aguVar.c;
        if (i2 == 0) {
            i2 = 8388659;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.h;
        Gravity.apply(i2, measuredWidth, measuredHeight, rect, rect2, i);
        int iV = v(appBarLayout_q);
        view.layout(rect2.left, rect2.top - iV, rect2.right, rect2.bottom - iV);
        this.q = rect2.top - appBarLayout_q.getBottom();
    }

    public final int v(View view) {
        int i;
        if (this.r == 0) {
            return 0;
        }
        float f = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            agr agrVar = ((agu) appBarLayout.getLayoutParams()).a;
            int iQ = agrVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) agrVar).q() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + iQ > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f = (iQ / i) + 1.0f;
            }
        }
        int i2 = this.r;
        return cnf.as((int) (f * i2), 0, i2);
    }

    public bkj(int i) {
        super(0);
        this.g = new Rect();
        this.h = new Rect();
        this.q = 0;
    }
}
