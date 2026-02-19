package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.asw;
import me.hd.wauxv.obf.bc;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.csh;
import me.hd.wauxv.obf.cuw;
import me.hd.wauxv.obf.cux;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.cyf;
import me.hd.wauxv.obf.dop;
import me.hd.wauxv.obf.dph;
import me.hd.wauxv.obf.dpi;
import me.hd.wauxv.obf.dpk;
import me.hd.wauxv.obf.dpl;
import me.hd.wauxv.obf.dpn;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.esf;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.ff;
import me.hd.wauxv.obf.no;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final cux a = new cux(16);
    public int aa;
    public final int ab;
    public int ac;
    public int ad;
    public boolean ae;
    public boolean af;
    public int ag;
    public int ah;
    public boolean ai;
    public dop aj;
    public final TimeInterpolator ak;
    public dph al;
    public final ArrayList am;
    public ValueAnimator an;
    public int ao;
    public final cuw ap;
    public int b;
    public final ArrayList c;
    public dpl d;
    public final dpk e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public ColorStateList m;
    public ColorStateList n;
    public ColorStateList o;
    public Drawable p;
    public int q;
    public final PorterDuff.Mode r;
    public final float s;
    public final float t;
    public final int u;
    public int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.tabStyle, R.style.Widget_Design_TabLayout), attributeSet, R.attr.tabStyle);
        this.b = -1;
        this.c = new ArrayList();
        this.l = -1;
        this.q = 0;
        this.v = Integer.MAX_VALUE;
        this.ag = -1;
        this.am = new ArrayList();
        this.ap = new cuw(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        dpk dpkVar = new dpk(this, context2);
        this.e = dpkVar;
        super.addView(dpkVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayAn = FastKV.an(context2, attributeSet, cxs.an, R.attr.tabStyle, R.style.Widget_Design_TabLayout, 24);
        ColorStateList colorStateListX = cmz.x(getBackground());
        if (colorStateListX != null) {
            cau cauVar = new cau();
            cauVar.dz(colorStateListX);
            cauVar.dx(context2);
            WeakHashMap weakHashMap = ViewCompat.a;
            cauVar.dy(eqq.e(this));
            setBackground(cauVar);
        }
        setSelectedTabIndicator(cnb.x(context2, typedArrayAn, 5));
        setSelectedTabIndicatorColor(typedArrayAn.getColor(8, 0));
        dpkVar.e(typedArrayAn.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(typedArrayAn.getInt(10, 0));
        setTabIndicatorAnimationMode(typedArrayAn.getInt(7, 0));
        setTabIndicatorFullWidth(typedArrayAn.getBoolean(9, true));
        int dimensionPixelSize = typedArrayAn.getDimensionPixelSize(16, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.f = typedArrayAn.getDimensionPixelSize(19, dimensionPixelSize);
        this.g = typedArrayAn.getDimensionPixelSize(20, dimensionPixelSize);
        this.h = typedArrayAn.getDimensionPixelSize(18, dimensionPixelSize);
        this.i = typedArrayAn.getDimensionPixelSize(17, dimensionPixelSize);
        if (cmz.am(context2, R.attr.isMaterial3Theme, false)) {
            this.j = R.attr.textAppearanceTitleSmall;
        } else {
            this.j = R.attr.textAppearanceButton;
        }
        int resourceId = typedArrayAn.getResourceId(24, R.style.TextAppearance_Design_Tab);
        this.k = resourceId;
        int[] iArr = cyf.w;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr);
        try {
            float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.s = dimensionPixelSize2;
            this.m = cnb.v(context2, typedArrayObtainStyledAttributes, 3);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayAn.hasValue(22)) {
                this.l = typedArrayAn.getResourceId(22, resourceId);
            }
            int i = this.l;
            if (i != -1) {
                TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(i, iArr);
                try {
                    typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, (int) dimensionPixelSize2);
                    ColorStateList colorStateListV = cnb.v(context2, typedArrayObtainStyledAttributes2, 3);
                    if (colorStateListV != null) {
                        this.m = aq(this.m.getDefaultColor(), colorStateListV.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListV.getDefaultColor()));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes2.recycle();
                    throw th;
                }
            }
            if (typedArrayAn.hasValue(25)) {
                this.m = cnb.v(context2, typedArrayAn, 25);
            }
            if (typedArrayAn.hasValue(23)) {
                this.m = aq(this.m.getDefaultColor(), typedArrayAn.getColor(23, 0));
            }
            this.n = cnb.v(context2, typedArrayAn, 3);
            this.r = ewz.ap(typedArrayAn.getInt(4, -1), null);
            this.o = cnb.v(context2, typedArrayAn, 21);
            this.ab = typedArrayAn.getInt(6, 300);
            this.ak = ajn.ae(context2, R.attr.motionEasingEmphasizedInterpolator, ff.b);
            this.w = typedArrayAn.getDimensionPixelSize(14, -1);
            this.x = typedArrayAn.getDimensionPixelSize(13, -1);
            this.u = typedArrayAn.getResourceId(0, 0);
            this.z = typedArrayAn.getDimensionPixelSize(1, 0);
            this.ad = typedArrayAn.getInt(15, 1);
            this.aa = typedArrayAn.getInt(2, 0);
            this.ae = typedArrayAn.getBoolean(12, false);
            this.ai = typedArrayAn.getBoolean(26, false);
            typedArrayAn.recycle();
            Resources resources = getResources();
            this.t = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.y = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            at();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public static ColorStateList aq(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            dpl dplVar = (dpl) arrayList.get(i);
            if (dplVar != null && dplVar.a != null && !TextUtils.isEmpty(dplVar.b)) {
                return !this.ae ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.w;
        if (i != -1) {
            return i;
        }
        int i2 = this.ad;
        if (i2 == 0 || i2 == 2) {
            return this.y;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        dpk dpkVar = this.e;
        int childCount = dpkVar.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = dpkVar.getChildAt(i2);
                if ((i2 != i || childAt.isSelected()) && (i2 == i || !childAt.isSelected())) {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                } else {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                    if (childAt instanceof dpn) {
                        ((dpn) childAt).r();
                    }
                }
                i2++;
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void ar(dpl dplVar, boolean z) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        if (dplVar.e != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        dplVar.c = size;
        arrayList.add(size, dplVar);
        int size2 = arrayList.size();
        int i = -1;
        for (int i2 = size + 1; i2 < size2; i2++) {
            if (((dpl) arrayList.get(i2)).c == this.b) {
                i = i2;
            }
            ((dpl) arrayList.get(i2)).c = i2;
        }
        this.b = i;
        dpn dpnVar = dplVar.f;
        dpnVar.setSelected(false);
        dpnVar.setActivated(false);
        int i3 = dplVar.c;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.ad == 1 && this.aa == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.e.addView(dpnVar, i3, layoutParams);
        if (z) {
            TabLayout tabLayout = dplVar.e;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.ay(dplVar, true);
        }
    }

    public final void as(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            if (isLaidOut()) {
                dpk dpkVar = this.e;
                int childCount = dpkVar.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (dpkVar.getChildAt(i2).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iAu = au(i, 0.0f);
                if (scrollX != iAu) {
                    av();
                    this.an.setIntValues(scrollX, iAu);
                    this.an.start();
                }
                ValueAnimator valueAnimator = dpkVar.b;
                if (valueAnimator != null && valueAnimator.isRunning() && dpkVar.c.b != i) {
                    dpkVar.b.cancel();
                }
                dpkVar.g(i, this.ab, true);
                return;
            }
        }
        az(i, 0.0f, true, true, true);
    }

    public final void at() {
        int i = this.ad;
        int iMax = (i == 0 || i == 2) ? Math.max(0, this.z - this.f) : 0;
        WeakHashMap weakHashMap = ViewCompat.a;
        dpk dpkVar = this.e;
        dpkVar.setPaddingRelative(iMax, 0, 0, 0);
        int i2 = this.ad;
        if (i2 == 0) {
            int i3 = this.aa;
            if (i3 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i3 == 1) {
                dpkVar.setGravity(1);
            } else if (i3 == 2) {
            }
            dpkVar.setGravity(8388611);
        } else if (i2 == 1 || i2 == 2) {
            if (this.aa == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            dpkVar.setGravity(1);
        }
        ba(true);
    }

    public final int au(int i, float f) {
        dpk dpkVar;
        View childAt;
        int i2 = this.ad;
        if ((i2 != 0 && i2 != 2) || (childAt = (dpkVar = this.e).getChildAt(i)) == null) {
            return 0;
        }
        int i3 = i + 1;
        View childAt2 = i3 < dpkVar.getChildCount() ? dpkVar.getChildAt(i3) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        WeakHashMap weakHashMap = ViewCompat.a;
        return getLayoutDirection() == 0 ? left + i4 : left - i4;
    }

    public final void av() {
        if (this.an == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.an = valueAnimator;
            valueAnimator.setInterpolator(this.ak);
            this.an.setDuration(this.ab);
            this.an.addUpdateListener(new no(this, 9));
        }
    }

    public final dpl aw() {
        dpl dplVar = (dpl) a.acquire();
        if (dplVar == null) {
            dplVar = new dpl();
            dplVar.c = -1;
        }
        dplVar.e = this;
        cuw cuwVar = this.ap;
        dpn dpnVar = cuwVar != null ? (dpn) cuwVar.acquire() : null;
        if (dpnVar == null) {
            dpnVar = new dpn(this, getContext());
        }
        dpnVar.setTab(dplVar);
        dpnVar.setFocusable(true);
        dpnVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(null)) {
            dpnVar.setContentDescription(dplVar.b);
        } else {
            dpnVar.setContentDescription(null);
        }
        dplVar.f = dpnVar;
        return dplVar;
    }

    public final void ax() {
        dpk dpkVar = this.e;
        int childCount = dpkVar.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            dpn dpnVar = (dpn) dpkVar.getChildAt(childCount);
            dpkVar.removeViewAt(childCount);
            if (dpnVar != null) {
                dpnVar.setTab(null);
                dpnVar.setSelected(false);
                this.ap.l(dpnVar);
            }
            requestLayout();
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            dpl dplVar = (dpl) it.next();
            it.remove();
            dplVar.e = null;
            dplVar.f = null;
            dplVar.a = null;
            dplVar.b = null;
            dplVar.c = -1;
            dplVar.d = null;
            a.l(dplVar);
        }
        this.d = null;
    }

    public final void ay(dpl dplVar, boolean z) {
        TabLayout tabLayout;
        dpl dplVar2 = this.d;
        ArrayList arrayList = this.am;
        if (dplVar2 == dplVar) {
            if (dplVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((dph) arrayList.get(size)).getClass();
                }
                as(dplVar.c);
                return;
            }
            return;
        }
        int i = dplVar != null ? dplVar.c : -1;
        if (z) {
            if ((dplVar2 == null || dplVar2.c == -1) && i != -1) {
                tabLayout = this;
                tabLayout.az(i, 0.0f, true, true, true);
            } else {
                tabLayout = this;
                as(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.d = dplVar;
        if (dplVar2 != null && dplVar2.e != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((dph) arrayList.get(size2)).getClass();
            }
        }
        if (dplVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((dph) arrayList.get(size3)).c(dplVar);
            }
        }
    }

    public final void az(int i, float f, boolean z, boolean z2, boolean z3) {
        float f2 = i + f;
        int iRound = Math.round(f2);
        if (iRound >= 0) {
            dpk dpkVar = this.e;
            if (iRound >= dpkVar.getChildCount()) {
                return;
            }
            if (z2) {
                dpkVar.c.b = Math.round(f2);
                ValueAnimator valueAnimator = dpkVar.b;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    dpkVar.b.cancel();
                }
                dpkVar.f(dpkVar.getChildAt(i), dpkVar.getChildAt(i + 1), f);
            }
            ValueAnimator valueAnimator2 = this.an;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.an.cancel();
            }
            int iAu = au(i, f);
            int scrollX = getScrollX();
            boolean z4 = (i < getSelectedTabPosition() && iAu >= scrollX) || (i > getSelectedTabPosition() && iAu <= scrollX) || i == getSelectedTabPosition();
            WeakHashMap weakHashMap = ViewCompat.a;
            if (getLayoutDirection() == 1) {
                z4 = (i < getSelectedTabPosition() && iAu <= scrollX) || (i > getSelectedTabPosition() && iAu >= scrollX) || i == getSelectedTabPosition();
            }
            if (z4 || this.ao == 1 || z3) {
                if (i < 0) {
                    iAu = 0;
                }
                scrollTo(iAu, 0);
            }
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void ba(boolean z) {
        int i = 0;
        while (true) {
            dpk dpkVar = this.e;
            if (i >= dpkVar.getChildCount()) {
                return;
            }
            View childAt = dpkVar.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.ad == 1 && this.aa == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        dpl dplVar = this.d;
        if (dplVar != null) {
            return dplVar.c;
        }
        return -1;
    }

    public int getTabCount() {
        return this.c.size();
    }

    public int getTabGravity() {
        return this.aa;
    }

    public ColorStateList getTabIconTint() {
        return this.n;
    }

    public int getTabIndicatorAnimationMode() {
        return this.ah;
    }

    public int getTabIndicatorGravity() {
        return this.ac;
    }

    public int getTabMaxWidth() {
        return this.v;
    }

    public int getTabMode() {
        return this.ad;
    }

    public ColorStateList getTabRippleColor() {
        return this.o;
    }

    public Drawable getTabSelectedIndicator() {
        return this.p;
    }

    public ColorStateList getTabTextColors() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        KotlinHelpers2.bj(this);
        getParent();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        dpn dpnVar;
        Drawable drawable;
        int i = 0;
        while (true) {
            dpk dpkVar = this.e;
            if (i >= dpkVar.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = dpkVar.getChildAt(i);
            if ((childAt instanceof dpn) && (drawable = (dpnVar = (dpn) childAt).j) != null) {
                drawable.setBounds(dpnVar.getLeft(), dpnVar.getTop(), dpnVar.getRight(), dpnVar.getBottom());
                dpnVar.j.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) bc.f(1, getTabCount(), 1).e);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Found duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iRound = Math.round(ewz.ag(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int iAg = this.x;
            if (iAg <= 0) {
                iAg = (int) (size - ewz.ag(getContext(), 56));
            }
            this.v = iAg;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i3 = this.ad;
            if (i3 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        KotlinHelpers2.bh(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.ae == z) {
            return;
        }
        this.ae = z;
        int i = 0;
        while (true) {
            dpk dpkVar = this.e;
            if (i >= dpkVar.getChildCount()) {
                at();
                return;
            }
            View childAt = dpkVar.getChildAt(i);
            if (childAt instanceof dpn) {
                dpn dpnVar = (dpn) childAt;
                dpnVar.setOrientation(!dpnVar.l.ae ? 1 : 0);
                TextView textView = dpnVar.h;
                if (textView == null && dpnVar.i == null) {
                    dpnVar.s(dpnVar.c, dpnVar.d, true);
                } else {
                    dpnVar.s(textView, dpnVar.i, false);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(dpi dpiVar) {
        setOnTabSelectedListener((dph) dpiVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        av();
        this.an.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.p = drawableMutate;
        int i = this.q;
        if (i != 0) {
            drawableMutate.setTint(i);
        } else {
            drawableMutate.setTintList(null);
        }
        int intrinsicHeight = this.ag;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.p.getIntrinsicHeight();
        }
        this.e.e(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.q = i;
        Drawable drawable = this.p;
        if (i != 0) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
        ba(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.ac != i) {
            this.ac = i;
            WeakHashMap weakHashMap = ViewCompat.a;
            this.e.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.ag = i;
        this.e.e(i);
    }

    public void setTabGravity(int i) {
        if (this.aa != i) {
            this.aa = i;
            at();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                dpn dpnVar = ((dpl) arrayList.get(i)).f;
                if (dpnVar != null) {
                    dpnVar.p();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(ResourcesCompat.v(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.ah = i;
        if (i == 0) {
            this.aj = new dop(7);
            return;
        }
        if (i == 1) {
            this.aj = new asw(0);
        } else {
            if (i == 2) {
                this.aj = new asw(1);
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.af = z;
        int i = dpk.a;
        dpk dpkVar = this.e;
        dpkVar.d(dpkVar.c.getSelectedTabPosition());
        WeakHashMap weakHashMap = ViewCompat.a;
        dpkVar.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.ad) {
            this.ad = i;
            at();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.o == colorStateList) {
            return;
        }
        this.o = colorStateList;
        int i = 0;
        while (true) {
            dpk dpkVar = this.e;
            if (i >= dpkVar.getChildCount()) {
                return;
            }
            View childAt = dpkVar.getChildAt(i);
            if (childAt instanceof dpn) {
                Context context = getContext();
                int i2 = dpn.a;
                ((dpn) childAt).q(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(ResourcesCompat.v(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                dpn dpnVar = ((dpl) arrayList.get(i)).f;
                if (dpnVar != null) {
                    dpnVar.p();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(csh cshVar) {
        ax();
    }

    public void setUnboundedRipple(boolean z) {
        if (this.ai == z) {
            return;
        }
        this.ai = z;
        int i = 0;
        while (true) {
            dpk dpkVar = this.e;
            if (i >= dpkVar.getChildCount()) {
                return;
            }
            View childAt = dpkVar.getChildAt(i);
            if (childAt instanceof dpn) {
                Context context = getContext();
                int i2 = dpn.a;
                ((dpn) childAt).q(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(esf esfVar) {
        ax();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(dph dphVar) {
        dph dphVar2 = this.al;
        ArrayList arrayList = this.am;
        if (dphVar2 != null) {
            arrayList.remove(dphVar2);
        }
        this.al = dphVar;
        if (dphVar == null || arrayList.contains(dphVar)) {
            return;
        }
        arrayList.add(dphVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(cmz.y(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
