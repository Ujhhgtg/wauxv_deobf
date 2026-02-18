package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ckj extends ckg {
    public final int g;
    public final View h;
    public final Boolean i;
    public final Boolean j;
    public final Boolean k;

    public ckj(Context context) {
        super(context, R.attr.navigationRailStyle, R.style.Widget_MaterialComponents_NavigationRailView);
        this.i = null;
        this.j = null;
        this.k = null;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        this.g = dimensionPixelSize;
        Context context2 = getContext();
        jx jxVarAo = bhu.ao(context2, null, cxs.af, R.attr.navigationRailStyle, R.style.Widget_MaterialComponents_NavigationRailView, new int[0]);
        TypedArray typedArray = (TypedArray) jxVarAo.e;
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId != 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view = this.h;
            if (view != null) {
                removeView(view);
                this.h = null;
            }
            this.h = viewInflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = dimensionPixelSize;
            addView(viewInflate, 0, layoutParams);
        }
        setMenuGravity(typedArray.getInt(2, 49));
        if (typedArray.hasValue(1)) {
            setItemMinimumHeight(typedArray.getDimensionPixelSize(1, -1));
        }
        if (typedArray.hasValue(5)) {
            this.i = Boolean.valueOf(typedArray.getBoolean(5, false));
        }
        if (typedArray.hasValue(3)) {
            this.j = Boolean.valueOf(typedArray.getBoolean(3, false));
        }
        if (typedArray.hasValue(4)) {
            this.k = Boolean.valueOf(typedArray.getBoolean(4, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float fG = ff.g(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f);
        float fH = ff.h(getItemPaddingTop(), fG, dimensionPixelOffset);
        float fH2 = ff.h(getItemPaddingBottom(), fG, dimensionPixelOffset2);
        setItemPaddingTop(Math.round(fH));
        setItemPaddingBottom(Math.round(fH2));
        jxVarAo.ae();
        ewz.af(this, new bmu(this));
    }

    private cki getNavigationRailMenuView() {
        return (cki) getMenuView();
    }

    @Override // me.hd.wauxv.obf.ckg
    public final cka a(Context context) {
        return new cki(context);
    }

    public View getHeaderView() {
        return this.h;
    }

    public int getItemMinimumHeight() {
        return ((cki) getMenuView()).getItemMinimumHeight();
    }

    @Override // me.hd.wauxv.obf.ckg
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x0032  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        cki navigationRailMenuView = getNavigationRailMenuView();
        int i5 = this.g;
        View view = this.h;
        if (view != null && view.getVisibility() != 8) {
            int bottom = this.h.getBottom() + i5;
            int top = navigationRailMenuView.getTop();
            i5 = top < bottom ? bottom - top : 0;
        } else if ((navigationRailMenuView.b.gravity & 112) != 48) {
        }
        if (i5 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i5, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i5);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i) != 1073741824 && suggestedMinimumWidth > 0) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i, i2);
        View view = this.h;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        measureChild(getNavigationRailMenuView(), i, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.h.getMeasuredHeight()) - this.g, Integer.MIN_VALUE));
    }

    public void setItemMinimumHeight(int i) {
        ((cki) getMenuView()).setItemMinimumHeight(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }
}
