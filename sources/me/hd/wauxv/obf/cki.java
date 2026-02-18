package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cki extends cka {
    public int a;
    public final FrameLayout.LayoutParams b;

    public cki(Context context) {
        super(context);
        this.a = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.b = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    public final int c(int i, int i2, int i3, View view) {
        int iMakeMeasureSpec;
        int measuredHeight;
        if (view == null) {
            int iMax = i2 / Math.max(1, i3);
            int size = this.a;
            if (size == -1) {
                size = View.MeasureSpec.getSize(i);
            }
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i, iMakeMeasureSpec);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                i4 += measuredHeight;
            }
        }
        return i4;
    }

    public int getItemMinimumHeight() {
        return this.a;
    }

    public int getMenuGravity() {
        return this.b.gravity;
    }

    @Override // me.hd.wauxv.obf.cka
    public final cjy h(Context context) {
        return new ckh(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                childAt.layout(0, i6, i5, measuredHeight);
                i6 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int iC;
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = getMenu().ak().size();
        if (size2 <= 1 || !cka.ap(getLabelVisibilityMode(), size2)) {
            iC = c(i, size, size2, null);
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            if (childAt != null) {
                int iMax = size / Math.max(1, size2);
                int size3 = this.a;
                if (size3 == -1) {
                    size3 = View.MeasureSpec.getSize(i);
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(size3, iMax), 0);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i, iMakeMeasureSpec);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                size -= measuredHeight;
                size2--;
            } else {
                measuredHeight = 0;
            }
            iC = c(i, size, size2, childAt) + measuredHeight;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.resolveSizeAndState(iC, i2, 0));
    }

    public void setItemMinimumHeight(int i) {
        if (this.a != i) {
            this.a = i;
            requestLayout();
        }
    }

    public void setMenuGravity(int i) {
        FrameLayout.LayoutParams layoutParams = this.b;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            setLayoutParams(layoutParams);
        }
    }
}
