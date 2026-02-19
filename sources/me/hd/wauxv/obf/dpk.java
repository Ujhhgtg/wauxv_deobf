package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpk extends LinearLayout {
    public static final /* synthetic */ int a = 0;
    public ValueAnimator b;
    public final /* synthetic */ TabLayout c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dpk(TabLayout tabLayout, Context context) {
        super(context);
        this.c = tabLayout;
        setWillNotDraw(false);
    }

    public final void d(int i) {
        TabLayout tabLayout = this.c;
        if (tabLayout.ao == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i);
            dop dopVar = tabLayout.aj;
            Drawable drawable = tabLayout.p;
            dopVar.getClass();
            RectF rectFH = dop.h(tabLayout, childAt);
            drawable.setBounds((int) rectFH.left, drawable.getBounds().top, (int) rectFH.right, drawable.getBounds().bottom);
            tabLayout.b = i;
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.c;
        int iHeight = tabLayout.p.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.p.getIntrinsicHeight();
        }
        int i = tabLayout.ac;
        if (i == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i != 1) {
            height = 0;
            if (i != 2) {
                iHeight = i != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        }
        if (tabLayout.p.getBounds().width() > 0) {
            Rect bounds = tabLayout.p.getBounds();
            tabLayout.p.setBounds(bounds.left, height, bounds.right, iHeight);
            tabLayout.p.draw(canvas);
        }
        super.draw(canvas);
    }

    public final void e(int i) {
        TabLayout tabLayout = this.c;
        Rect bounds = tabLayout.p.getBounds();
        tabLayout.p.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void f(View view, View view2, float f) {
        TabLayout tabLayout = this.c;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.p;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.p.getBounds().bottom);
        } else {
            tabLayout.aj._bg(tabLayout, view, view2, f, tabLayout.p);
        }
        WeakHashMap weakHashMap = ViewCompat.a;
        postInvalidateOnAnimation();
    }

    public final void g(int i, int i2, boolean z) {
        TabLayout tabLayout = this.c;
        if (tabLayout.b == i) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            d(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.b = i;
        dpj dpjVar = new dpj(this, childAt, childAt2);
        if (!z) {
            this.b.removeAllUpdateListeners();
            this.b.addUpdateListener(dpjVar);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.b = valueAnimator;
        valueAnimator.setInterpolator(tabLayout.ak);
        valueAnimator.setDuration(i2);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(dpjVar);
        valueAnimator.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.b;
        TabLayout tabLayout = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            g(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        if (tabLayout.b == -1) {
            tabLayout.b = tabLayout.getSelectedTabPosition();
        }
        d(tabLayout.b);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.c;
        boolean z = true;
        if (tabLayout.aa == 1 || tabLayout.ad == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) ewz.ag(getContext(), 16)) * 2)) {
                boolean z2 = false;
                for (int i4 = 0; i4 < childCount; i4++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                tabLayout.aa = 0;
                tabLayout.ba(false);
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }
    }
}
