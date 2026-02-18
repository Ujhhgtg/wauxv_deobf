package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.bvf;
import me.hd.wauxv.obf.bvg;
import me.hd.wauxv.obf.cbv;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cbz;
import me.hd.wauxv.obf.cco;
import me.hd.wauxv.obf.cq;
import me.hd.wauxv.obf.ct;
import me.hd.wauxv.obf.cw;
import me.hd.wauxv.obf.cx;
import me.hd.wauxv.obf.cy;
import me.hd.wauxv.obf.cz;
import me.hd.wauxv.obf.ekm;
import me.hd.wauxv.obf.erp;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends bvg implements cbv, cco {
    public cbw a;
    public Context b;
    public int e;
    public boolean f;
    public cw g;
    public ekm h;
    public boolean i;
    public int j;
    public final int k;
    public final int l;
    public cz m;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.b = context;
        this.e = 0;
    }

    public static cy n() {
        cy cyVar = new cy(-2, -2);
        cyVar.a = false;
        ((LinearLayout.LayoutParams) cyVar).gravity = 16;
        return cyVar;
    }

    public static cy o(ViewGroup.LayoutParams layoutParams) {
        cy cyVar;
        if (layoutParams == null) {
            return n();
        }
        if (layoutParams instanceof cy) {
            cy cyVar2 = (cy) layoutParams;
            cyVar = new cy(cyVar2);
            cyVar.a = cyVar2.a;
        } else {
            cyVar = new cy(layoutParams);
        }
        if (((LinearLayout.LayoutParams) cyVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cyVar).gravity = 16;
        }
        return cyVar;
    }

    @Override // me.hd.wauxv.obf.cbv
    public final boolean c(cbz cbzVar) {
        return this.a.ap(cbzVar, null, 0);
    }

    @Override // me.hd.wauxv.obf.bvg, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof cy;
    }

    @Override // me.hd.wauxv.obf.cco
    public final void d(cbw cbwVar) {
        this.a = cbwVar;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // me.hd.wauxv.obf.bvg, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return n();
    }

    @Override // me.hd.wauxv.obf.bvg, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return o(layoutParams);
    }

    public Menu getMenu() {
        if (this.a == null) {
            Context context = getContext();
            cbw cbwVar = new cbw(context);
            this.a = cbwVar;
            cbwVar.f = new erp(this, 3);
            cw cwVar = new cw(context);
            this.g = cwVar;
            cwVar.m = true;
            cwVar.n = true;
            cwVar.e = new arj();
            this.a.aa(cwVar, this.b);
            cw cwVar2 = this.g;
            cwVar2.h = this;
            this.a = cwVar2.c;
        }
        return this.a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        cw cwVar = this.g;
        ct ctVar = cwVar.j;
        if (ctVar != null) {
            return ctVar.getDrawable();
        }
        if (cwVar.l) {
            return cwVar.k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cw cwVar = this.g;
        if (cwVar != null) {
            cwVar.ac(false);
            if (this.g.ai()) {
                this.g.ag();
                this.g.am();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.g;
        if (cwVar != null) {
            cwVar.ag();
            cq cqVar = cwVar.u;
            if (cqVar == null || !cqVar.p()) {
                return;
            }
            cqVar.l.dismiss();
        }
    }

    @Override // me.hd.wauxv.obf.bvg, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = getLayoutDirection() == 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                cy cyVar = (cy) childAt.getLayoutParams();
                if (cyVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (s(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z2) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cyVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cyVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cyVar).leftMargin) + ((LinearLayout.LayoutParams) cyVar).rightMargin;
                    s(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (z2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                cy cyVar2 = (cy) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cyVar2.a) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) cyVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cyVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            cy cyVar3 = (cy) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cyVar3.a) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) cyVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) cyVar3).rightMargin + iMax + i18;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // me.hd.wauxv.obf.bvg, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        ?? r11;
        int i5;
        int i6;
        cbw cbwVar;
        boolean z = this.i;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.i = z2;
        if (z != z2) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && (cbwVar = this.a) != null && size != this.j) {
            this.j = size;
            cbwVar.ao(true);
        }
        int childCount = getChildCount();
        if (!this.i || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                cy cyVar = (cy) getChildAt(i7).getLayoutParams();
                ((LinearLayout.LayoutParams) cyVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cyVar).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i8 = size2 - paddingRight;
        int i9 = this.k;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = (i11 / i10) + i9;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i13 = 0;
        int iMax2 = 0;
        int i14 = 0;
        boolean z3 = false;
        int i15 = 0;
        long j = 0;
        while (true) {
            i3 = this.l;
            if (i14 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i14);
            int i16 = size3;
            int i17 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i5 = i12;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                i13++;
                if (z4) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                cy cyVar2 = (cy) childAt.getLayoutParams();
                cyVar2.f = false;
                cyVar2.c = 0;
                cyVar2.b = 0;
                cyVar2.d = false;
                ((LinearLayout.LayoutParams) cyVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) cyVar2).rightMargin = 0;
                cyVar2.e = z4 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i18 = cyVar2.a ? 1 : i10;
                cy cyVar3 = (cy) childAt.getLayoutParams();
                int i19 = i10;
                i5 = i12;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i17, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z4 ? (ActionMenuItemView) childAt : null;
                boolean z5 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z6 = z5;
                if (i18 <= 0 || (z5 && i18 < 2)) {
                    i6 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5 * i18, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = measuredWidth / i5;
                    if (measuredWidth % i5 != 0) {
                        i6++;
                    }
                    if (z6 && i6 < 2) {
                        i6 = 2;
                    }
                }
                cyVar3.d = !cyVar3.a && z6;
                cyVar3.b = i6;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6 * i5, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i6);
                if (cyVar2.d) {
                    i15++;
                }
                if (cyVar2.a) {
                    z3 = true;
                }
                i10 = i19 - i6;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i6 == 1) {
                    j |= (long) (1 << i14);
                }
            }
            i14++;
            size3 = i16;
            paddingBottom = i17;
            i12 = i5;
        }
        int i20 = size3;
        int i21 = i10;
        int i22 = i12;
        boolean z7 = z3 && i13 == 2;
        int i23 = i21;
        boolean z8 = false;
        while (true) {
            if (i15 <= 0 || i23 <= 0) {
                i4 = iMax;
                break;
            }
            int i24 = Integer.MAX_VALUE;
            long j2 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i26 < childCount2) {
                int i27 = iMax;
                cy cyVar4 = (cy) getChildAt(i26).getLayoutParams();
                boolean z9 = z7;
                if (cyVar4.d) {
                    int i28 = cyVar4.b;
                    if (i28 < i24) {
                        j2 = 1 << i26;
                        i24 = i28;
                        i25 = 1;
                    } else if (i28 == i24) {
                        j2 |= 1 << i26;
                        i25++;
                    }
                }
                i26++;
                z7 = z9;
                iMax = i27;
            }
            i4 = iMax;
            boolean z10 = z7;
            j |= j2;
            if (i25 > i23) {
                break;
            }
            int i29 = i24 + 1;
            int i30 = 0;
            while (i30 < childCount2) {
                View childAt2 = getChildAt(i30);
                cy cyVar5 = (cy) childAt2.getLayoutParams();
                boolean z11 = z3;
                long j3 = 1 << i30;
                if ((j2 & j3) != 0) {
                    if (z10 && cyVar5.e) {
                        r11 = 1;
                        r11 = 1;
                        if (i23 == 1) {
                            childAt2.setPadding(i3 + i22, 0, i3, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    cyVar5.b += r11;
                    cyVar5.f = r11;
                    i23--;
                } else if (cyVar5.b == i29) {
                    j |= j3;
                }
                i30++;
                z3 = z11;
            }
            z7 = z10;
            iMax = i4;
            z8 = true;
        }
        boolean z12 = !z3 && i13 == 1;
        if (i23 > 0 && j != 0 && (i23 < i13 - 1 || z12 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j);
            if (!z12) {
                if ((j & 1) != 0 && !((cy) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i31 = childCount2 - 1;
                if ((j & ((long) (1 << i31))) != 0 && !((cy) getChildAt(i31).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i32 = fBitCount > 0.0f ? (int) ((i23 * i22) / fBitCount) : 0;
            boolean z13 = z8;
            for (int i33 = 0; i33 < childCount2; i33++) {
                if ((j & ((long) (1 << i33))) != 0) {
                    View childAt3 = getChildAt(i33);
                    cy cyVar6 = (cy) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cyVar6.c = i32;
                        cyVar6.f = true;
                        if (i33 == 0 && !cyVar6.e) {
                            ((LinearLayout.LayoutParams) cyVar6).leftMargin = (-i32) / 2;
                        }
                        z13 = true;
                    } else if (cyVar6.a) {
                        cyVar6.c = i32;
                        cyVar6.f = true;
                        ((LinearLayout.LayoutParams) cyVar6).rightMargin = (-i32) / 2;
                        z13 = true;
                    } else {
                        if (i33 != 0) {
                            ((LinearLayout.LayoutParams) cyVar6).leftMargin = i32 / 2;
                        }
                        if (i33 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) cyVar6).rightMargin = i32 / 2;
                        }
                    }
                }
            }
            z8 = z13;
        }
        if (z8) {
            for (int i34 = 0; i34 < childCount2; i34++) {
                View childAt4 = getChildAt(i34);
                cy cyVar7 = (cy) childAt4.getLayoutParams();
                if (cyVar7.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cyVar7.b * i22) + cyVar7.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i8, mode != 1073741824 ? i4 : i20);
    }

    @Override // me.hd.wauxv.obf.bvg
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ bvf generateDefaultLayoutParams() {
        return n();
    }

    @Override // me.hd.wauxv.obf.bvg
    /* JADX INFO: renamed from: q */
    public final bvf generateLayoutParams(AttributeSet attributeSet) {
        return new cy(getContext(), attributeSet);
    }

    @Override // me.hd.wauxv.obf.bvg
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ bvf generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return o(layoutParams);
    }

    public final boolean s(int i) {
        boolean zL = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof cx)) {
            zL = ((cx) childAt).l();
        }
        return (i <= 0 || !(childAt2 instanceof cx)) ? zL : ((cx) childAt2).m() | zL;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.r = z;
    }

    public void setOnMenuItemClickListener(cz czVar) {
        this.m = czVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        cw cwVar = this.g;
        ct ctVar = cwVar.j;
        if (ctVar != null) {
            ctVar.setImageDrawable(drawable);
        } else {
            cwVar.l = true;
            cwVar.k = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    public void setPopupTheme(int i) {
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                this.b = getContext();
            } else {
                this.b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(cw cwVar) {
        this.g = cwVar;
        cwVar.h = this;
        this.a = cwVar.c;
    }

    @Override // me.hd.wauxv.obf.bvg, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new cy(getContext(), attributeSet);
    }
}
