package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import me.hd.wauxv.obf.nw;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Snackbar$SnackbarLayout extends nw {
    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.nw, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getLayoutParams().width == -1) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
            }
        }
    }

    @Override // me.hd.wauxv.obf.nw, android.view.View
    public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // me.hd.wauxv.obf.nw, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // me.hd.wauxv.obf.nw, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
        super.setBackgroundTintList(colorStateList);
    }

    @Override // me.hd.wauxv.obf.nw, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
        super.setBackgroundTintMode(mode);
    }

    @Override // me.hd.wauxv.obf.nw, android.view.View
    public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // me.hd.wauxv.obf.nw, android.view.View
    public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }
}
