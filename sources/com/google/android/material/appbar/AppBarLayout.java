package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aat;
import me.hd.wauxv.obf.aau;
import me.hd.wauxv.obf.aav;
import me.hd.wauxv.obf.agq;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.agu;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.bki;
import me.hd.wauxv.obf.bkj;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.ckr;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.HugeSyntheticPileOfHelpers;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dhq;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.erp;
import me.hd.wauxv.obf.ert;
import me.hd.wauxv.obf.evr;
import me.hd.wauxv.obf.ff;
import me.hd.wauxv.obf.gs;
import me.hd.wauxv.obf.DefaultConfig;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements agq {
    public static final /* synthetic */ int a = 0;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public evr h;
    public ArrayList i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public WeakReference o;
    public final boolean p;
    public ValueAnimator q;
    public final ValueAnimator.AnimatorUpdateListener r;
    public final ArrayList s;
    public final long t;
    public final TimeInterpolator u;
    public int[] v;
    public Drawable w;
    public Integer x;
    public final float y;
    public Behavior z;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class ScrollingViewBehavior extends bkj {
        public ScrollingViewBehavior() {
        }

        public static AppBarLayout _q(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // me.hd.wauxv.obf.agr
        public final boolean b(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // me.hd.wauxv.obf.agr
        public boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            agr agrVar = ((agu) view2.getLayoutParams()).a;
            if (agrVar instanceof BaseBehavior) {
                int bottom = (((view2.getBottom() - view.getTop()) + ((BaseBehavior) agrVar)._i) + this.q) - v(view2);
                WeakHashMap weakHashMap = ViewCompat.a;
                view.offsetTopAndBottom(bottom);
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.m) {
                return false;
            }
            appBarLayout.af(appBarLayout.ag(view));
            return false;
        }

        @Override // me.hd.wauxv.obf.agr
        public final void d(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // me.hd.wauxv.obf.agr
        public final boolean e(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayout_q = _q(coordinatorLayout.af(view));
            if (appBarLayout_q != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.g;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayout_q.ae(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.ah);
            this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        Integer numValueOf;
        super(cmz.aq(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet,
                R.attr.appBarLayoutStyle);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.g = 0;
        this.s = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayAn = FastKV.an(context3, attributeSet, cmz.j, R.attr.appBarLayoutStyle,
                R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayAn.hasValue(0)) {
                setStateListAnimator(
                        AnimatorInflater.loadStateListAnimator(context3, typedArrayAn.getResourceId(0, 0)));
            }
            typedArrayAn.recycle();
            TypedArray typedArrayAn2 = FastKV.an(context2, attributeSet, cxs.a, R.attr.appBarLayoutStyle,
                    R.style.Widget_Design_AppBarLayout, new int[0]);
            Drawable drawable = typedArrayAn2.getDrawable(0);
            WeakHashMap weakHashMap = ViewCompat.a;
            setBackground(drawable);
            final ColorStateList colorStateListV = cnb.v(context2, typedArrayAn2, 6);
            this.p = colorStateListV != null;
            final ColorStateList colorStateListX = cmz.x(getBackground());
            if (colorStateListX != null) {
                final cau cauVar = new cau();
                cauVar.dz(colorStateListX);
                if (colorStateListV != null) {
                    Context context4 = getContext();
                    TypedValue typedValueAl = cmz.al(context4, R.attr.colorSurface);
                    if (typedValueAl != null) {
                        int i = typedValueAl.resourceId;
                        numValueOf = Integer.valueOf(i != 0 ? context4.getColor(i) : typedValueAl.data);
                    } else {
                        numValueOf = null;
                    }
                    final Integer num = numValueOf;
                    this.r = new ValueAnimator.AnimatorUpdateListener() { // from class: me.hd.wauxv.obf.gq
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Integer num2;
                            AppBarLayout appBarLayout = this.a;
                            ArrayList arrayList = appBarLayout.s;
                            int iAd = cna.ad(colorStateListX.getDefaultColor(),
                                    ((Float) valueAnimator.getAnimatedValue()).floatValue(),
                                    colorStateListV.getDefaultColor());
                            ColorStateList colorStateListValueOf = ColorStateList.valueOf(iAd);
                            cau cauVar2 = cauVar;
                            cauVar2.dz(colorStateListValueOf);
                            if (appBarLayout.w != null && (num2 = appBarLayout.x) != null && num2.equals(num)) {
                                appBarLayout.w.setTint(iAd);
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (it.next() != null) {
                                    throw new ClassCastException();
                                }
                                if (cauVar2.ct.d != null) {
                                    throw null;
                                }
                            }
                        }
                    };
                    setBackground(cauVar);
                } else {
                    cauVar.dx(context2);
                    this.r = new ValueAnimator.AnimatorUpdateListener() { // from class: me.hd.wauxv.obf.gr
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int i2 = AppBarLayout.a;
                            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            cauVar.dy(fFloatValue);
                            AppBarLayout appBarLayout = this.a;
                            Drawable drawable2 = appBarLayout.w;
                            if (drawable2 instanceof cau) {
                                ((cau) drawable2).dy(fFloatValue);
                            }
                            Iterator it = appBarLayout.s.iterator();
                            if (it.hasNext()) {
                                throw yg.d(it);
                            }
                        }
                    };
                    setBackground(cauVar);
                }
            }
            this.t = ajn.ad(context2, R.attr.motionDurationMedium2,
                    getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.u = ajn.ae(context2, R.attr.motionEasingStandardInterpolator, ff.a);
            int i2 = 4;
            if (typedArrayAn2.hasValue(4)) {
                ae(typedArrayAn2.getBoolean(4, false), false, false);
            }
            if (typedArrayAn2.hasValue(3)) {
                cmz.trimStackTraceToClass(this, typedArrayAn2.getDimensionPixelSize(3, 0));
            }
            if (typedArrayAn2.hasValue(2)) {
                setKeyboardNavigationCluster(typedArrayAn2.getBoolean(2, false));
            }
            if (typedArrayAn2.hasValue(1)) {
                setTouchscreenBlocksFocus(typedArrayAn2.getBoolean(1, false));
            }
            this.y = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.m = typedArrayAn2.getBoolean(5, false);
            this.n = typedArrayAn2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayAn2.getDrawable(8));
            typedArrayAn2.recycle();
            eqq.l(this, new erp(this, i2));
        } catch (Throwable th) {
            typedArrayAn.recycle();
            throw th;
        }
    }

    public static gs aa(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            gs gsVar = new gs((LinearLayout.LayoutParams) layoutParams);
            gsVar.a = 1;
            return gsVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            gs gsVar2 = new gs((ViewGroup.MarginLayoutParams) layoutParams);
            gsVar2.a = 1;
            return gsVar2;
        }
        gs gsVar3 = new gs(layoutParams);
        gsVar3.a = 1;
        return gsVar3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /*
     * JADX INFO: renamed from: ab, reason: merged with bridge method
     * [inline-methods]
     */
    public final gs generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        gs gsVar = new gs(context, attributeSet);
        gsVar.a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.b);
        gsVar.a = typedArrayObtainStyledAttributes.getInt(1, 0);
        gsVar.b = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new DefaultConfig(2);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            gsVar.c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return gsVar;
    }

    public final void ac() {
        Behavior behavior = this.z;
        d dVar_p = (behavior == null || this.c == -1 || this.g != 0) ? null : behavior._p(n.f, this);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        if (dVar_p != null) {
            Behavior behavior2 = this.z;
            if (behavior2._l != null) {
                return;
            }
            behavior2._l = dVar_p;
        }
    }

    public final void ad(int i) {
        this.b = i;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = ViewCompat.a;
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.i;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                aav aavVar = (aav) this.i.get(i2);
                if (aavVar != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout = aavVar.a;
                    collapsingToolbarLayout.y = i;
                    aat aatVar = collapsingToolbarLayout.k;
                    evr evrVar = collapsingToolbarLayout.aa;
                    int iH = evrVar != null ? evrVar.h() : 0;
                    int childCount = collapsingToolbarLayout.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = collapsingToolbarLayout.getChildAt(i3);
                        aau aauVar = (aau) childAt.getLayoutParams();
                        ert ertVarAf = CollapsingToolbarLayout.af(childAt);
                        int i4 = aauVar.a;
                        if (i4 == 1) {
                            ertVarAf.f(HugeSyntheticPileOfHelpers.as(-i, 0, ((collapsingToolbarLayout.getHeight()
                                    - CollapsingToolbarLayout.af(childAt).second) - childAt.getHeight())
                                    - ((FrameLayout.LayoutParams) ((aau) childAt.getLayoutParams())).bottomMargin));
                        } else if (i4 == 2) {
                            ertVarAf.f(Math.round((-i) * aauVar.b));
                        }
                    }
                    collapsingToolbarLayout.ai();
                    if (collapsingToolbarLayout.p != null && iH > 0) {
                        WeakHashMap weakHashMap2 = ViewCompat.a;
                        collapsingToolbarLayout.postInvalidateOnAnimation();
                    }
                    int height = collapsingToolbarLayout.getHeight();
                    WeakHashMap weakHashMap3 = ViewCompat.a;
                    int minimumHeight = (height - collapsingToolbarLayout.getMinimumHeight()) - iH;
                    float scrimVisibleHeightTrigger = height - collapsingToolbarLayout.getScrimVisibleHeightTrigger();
                    float f = minimumHeight;
                    float fMin = Math.min(1.0f, scrimVisibleHeightTrigger / f);
                    aatVar.d = fMin;
                    aatVar.e = yg.a(1.0f, fMin, 0.5f, fMin);
                    aatVar.f = collapsingToolbarLayout.y + minimumHeight;
                    aatVar.cg(Math.abs(i) / f);
                }
            }
        }
    }

    public final void ae(boolean z, boolean z2, boolean z3) {
        this.g = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    public final boolean af(boolean z) {
        if (this.j || this.l == z) {
            return false;
        }
        this.l = z;
        refreshDrawableState();
        if (!(getBackground() instanceof cau)) {
            return true;
        }
        if (this.p) {
            ah(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            return true;
        }
        if (!this.m) {
            return true;
        }
        float f = this.y;
        ah(z ? 0.0f : f, z ? f : 0.0f);
        return true;
    }

    public final boolean ag(View view) {
        int i;
        if (this.o == null && (i = this.n) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.n);
            }
            if (viewFindViewById != null) {
                this.o = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.o;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void ah(float f, float f2) {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.q = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.t);
        this.q.setInterpolator(this.u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.r;
        if (animatorUpdateListener != null) {
            this.q.addUpdateListener(animatorUpdateListener);
        }
        this.q.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof gs;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.w == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.b);
        this.w.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.w;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        gs gsVar = new gs(-1, -2);
        gsVar.a = 1;
        return gsVar;
    }

    @Override // me.hd.wauxv.obf.agq
    public agr getBehavior() {
        Behavior behavior = new Behavior();
        this.z = behavior;
        return behavior;
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0050 */
    /* JADX WARN: Found duplicated region for block: B:23:0x0058 */
    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                gs gsVar = (gs) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = gsVar.a;
                if ((i3 & 5) != 5) {
                    if (i2 > 0) {
                        break;
                    }
                } else {
                    int i4 = ((LinearLayout.LayoutParams) gsVar).topMargin
                            + ((LinearLayout.LayoutParams) gsVar).bottomMargin;
                    if ((i3 & 8) != 0) {
                        WeakHashMap weakHashMap = ViewCompat.a;
                        minimumHeight = childAt.getMinimumHeight();
                    } else {
                        if ((i3 & 2) != 0) {
                            WeakHashMap weakHashMap2 = ViewCompat.a;
                            minimumHeight = measuredHeight - childAt.getMinimumHeight();
                        } else {
                            iMin = i4 + measuredHeight;
                        }
                        if (childCount == 0) {
                            WeakHashMap weakHashMap3 = ViewCompat.a;
                            if (childAt.getFitsSystemWindows()) {
                                iMin = Math.min(iMin, measuredHeight - getTopInset());
                            }
                        }
                        i2 += iMin;
                    }
                    iMin = minimumHeight + i4;
                    if (childCount == 0) {
                        WeakHashMap weakHashMap32 = ViewCompat.a;
                        if (childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                    }
                    i2 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i2);
        this.d = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                gs gsVar = (gs) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) gsVar).topMargin
                        + ((LinearLayout.LayoutParams) gsVar).bottomMargin + childAt.getMeasuredHeight();
                int i3 = gsVar.a;
                if ((i3 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i3 & 2) != 0) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.e = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.n;
    }

    public cau getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof cau) {
            return (cau) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = ViewCompat.a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.g;
    }

    public Drawable getStatusBarForeground() {
        return this.w;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        evr evrVar = this.h;
        if (evrVar != null) {
            return evrVar.h();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                gs gsVar = (gs) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = gsVar.a;
                if ((i3 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) gsVar).topMargin
                        + ((LinearLayout.LayoutParams) gsVar).bottomMargin + minimumHeight;
                if (i2 == 0) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    if (childAt.getFitsSystemWindows()) {
                        topInset -= getTopInset();
                    }
                }
                minimumHeight = topInset;
                if ((i3 & 2) != 0) {
                    WeakHashMap weakHashMap2 = ViewCompat.a;
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.c = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        KotlinHelpers2.bj(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.v == null) {
            this.v = new int[4];
        }
        int[] iArr = this.v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.k;
        iArr[0] = z ? R.attr.state_liftable : -1610876046;
        iArr[1] = (z && this.l) ? R.attr.state_lifted : -1610876047;
        iArr[2] = z ? R.attr.state_collapsible : -1610876042;
        iArr[3] = (z && this.l) ? R.attr.state_collapsed : -1610876041;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        WeakHashMap weakHashMap = ViewCompat.a;
        boolean z2 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    getChildAt(childCount).offsetTopAndBottom(topInset);
                }
            }
        }
        ac();
        this.f = false;
        int childCount2 = getChildCount();
        for (int i5 = 0; i5 < childCount2; i5++) {
            if (((gs) getChildAt(i5).getLayoutParams()).c != null) {
                this.f = true;
                break;
            }
        }
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.j) {
            return;
        }
        if (!this.m) {
            int childCount3 = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i7 = ((gs) getChildAt(i6).getLayoutParams()).a;
                if ((i7 & 1) == 1 && (i7 & 10) != 0) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        if (this.k != z2) {
            this.k = z2;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = ViewCompat.a;
            if (getFitsSystemWindows() && getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                    int measuredHeight = getMeasuredHeight();
                    if (mode == Integer.MIN_VALUE) {
                        measuredHeight = HugeSyntheticPileOfHelpers.as(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
                    } else if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        ac();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        KotlinHelpers2.bh(this, f);
    }

    public void setExpanded(boolean z) {
        WeakHashMap weakHashMap = ViewCompat.a;
        ae(z, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.m = z;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.n = -1;
        if (view != null) {
            this.o = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.n = i;
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.o = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.j = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException(
                    "AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.w;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.w = drawableMutate;
            if (drawableMutate instanceof cau) {
                numValueOf = Integer.valueOf(((cau) drawableMutate).dn);
            } else {
                ColorStateList colorStateListX = cmz.x(drawableMutate);
                if (colorStateListX != null) {
                    numValueOf = Integer.valueOf(colorStateListX.getDefaultColor());
                }
            }
            this.x = numValueOf;
            Drawable drawable3 = this.w;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.w.setState(getDrawableState());
                }
                Drawable drawable4 = this.w;
                WeakHashMap weakHashMap = ViewCompat.a;
                drawable4.setLayoutDirection(getLayoutDirection());
                this.w.setVisible(getVisibility() == 0, false);
                this.w.setCallback(this);
            }
            if (this.w != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            WeakHashMap weakHashMap2 = ViewCompat.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(cmz.y(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        cmz.ao(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(
            ViewGroup.LayoutParams layoutParams) {
        return aa(layoutParams);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class BaseBehavior<T extends AppBarLayout> extends bki {
        public int _i;
        public int _j;
        public ValueAnimator _k;
        public d _l;
        public WeakReference _m;

        public BaseBehavior() {
            this.z = -1;
            this.ab = -1;
        }

        public static View f(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((agu) childAt.getLayoutParams()).a instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View g(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof ckr) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Found duplicated region for block: B:27:0x005d */
        public static void h(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View childAt;
            boolean zAg;
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    childAt = null;
                    break;
                }
                childAt = appBarLayout.getChildAt(i3);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    break;
                } else {
                    i3++;
                }
            }
            if (childAt != null) {
                int i4 = ((gs) childAt.getLayoutParams()).a;
                if ((i4 & 1) != 0) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    int minimumHeight = childAt.getMinimumHeight();
                    zAg = true;
                    if (i2 <= 0 || (i4 & 12) == 0
                            ? (i4 & 2) == 0 || (-i) < (childAt.getBottom() - minimumHeight) - appBarLayout.getTopInset()
                            : (-i) < (childAt.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                        zAg = false;
                    }
                } else {
                    zAg = false;
                }
            } else {
                zAg = false;
            }
            if (appBarLayout.m) {
                zAg = appBarLayout.ag(g(coordinatorLayout));
            }
            boolean zAf = appBarLayout.af(zAg);
            if (!z) {
                if (zAf) {
                    ArrayList arrayList = (ArrayList) ((dhq) coordinatorLayout.g.f).get(appBarLayout);
                    List arrayList2 = arrayList != null ? new ArrayList(arrayList) : null;
                    if (arrayList2 == null) {
                        arrayList2 = Collections.EMPTY_LIST;
                    }
                    int size = arrayList2.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        agr agrVar = ((agu) ((View) arrayList2.get(i5)).getLayoutParams()).a;
                        if (agrVar instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) agrVar).r == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (appBarLayout.getBackground() != null) {
                appBarLayout.getBackground().jumpToCurrentState();
            }
            if (appBarLayout.getForeground() != null) {
                appBarLayout.getForeground().jumpToCurrentState();
            }
            if (appBarLayout.getStateListAnimator() != null) {
                appBarLayout.getStateListAnimator().jumpToCurrentState();
            }
        }

        public final void _n(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(q() - i);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3
                    : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iQ = q();
            if (iQ == i) {
                ValueAnimator valueAnimator = this._k;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this._k.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this._k;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this._k = valueAnimator3;
                valueAnimator3.setInterpolator(ff.e);
                this._k.addUpdateListener(new a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this._k.setDuration(Math.min(iRound, 600));
            this._k.setIntValues(iQ, i);
            this._k.start();
        }

        /* JADX WARN: Found duplicated region for block: B:9:0x002b */
        public final void _o(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i,
                int[] iArr) {
            AppBarLayout appBarLayout2;
            int i2;
            int downNestedPreScrollRange;
            if (i == 0) {
                appBarLayout2 = appBarLayout;
            } else {
                if (i < 0) {
                    i2 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + i2;
                } else {
                    i2 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i3 = i2;
                int i4 = downNestedPreScrollRange;
                if (i3 != i4) {
                    appBarLayout2 = appBarLayout;
                    iArr[1] = r(coordinatorLayout, appBarLayout2, q() - i, i3, i4);
                } else {
                    appBarLayout2 = appBarLayout;
                }
            }
            if (appBarLayout2.m) {
                appBarLayout2.af(appBarLayout2.ag(view));
            }
        }

        public final d _p(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iAg = ag();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + iAg;
                if (childAt.getTop() + iAg <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = n.f;
                    }
                    d dVar = new d(parcelable);
                    boolean z = iAg == 0;
                    dVar.b = z;
                    dVar.a = !z && (-iAg) >= appBarLayout.getTotalScrollRange();
                    dVar.c = i;
                    WeakHashMap weakHashMap = ViewCompat.a;
                    dVar.e = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    dVar.d = bottom / childAt.getHeight();
                    return dVar;
                }
            }
            return null;
        }

        @Override // me.hd.wauxv.obf.ers, me.hd.wauxv.obf.agr
        public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
            int iRound;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.i(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            d dVar = this._l;
            if (dVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i2 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            _n(coordinatorLayout, appBarLayout, i2);
                        } else {
                            ad(coordinatorLayout, appBarLayout, i2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            _n(coordinatorLayout, appBarLayout, 0);
                        } else {
                            ad(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (dVar.a) {
                ad(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (dVar.b) {
                ad(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(dVar.c);
                int i3 = -childAt.getBottom();
                if (this._l.e) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    iRound = appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3;
                } else {
                    iRound = Math.round(childAt.getHeight() * this._l.d) + i3;
                }
                ad(coordinatorLayout, appBarLayout, iRound);
            }
            appBarLayout.g = 0;
            this._l = null;
            int iAs = HugeSyntheticPileOfHelpers.as(ag(), -appBarLayout.getTotalScrollRange(), 0);
            ert ertVar = this.ae;
            if (ertVar != null) {
                ertVar.f(iAs);
            } else {
                this.af = iAs;
            }
            h(coordinatorLayout, appBarLayout, ag(), 0, true);
            appBarLayout.ad(ag());
            if (ViewCompat.getAccessibilityDelegate(coordinatorLayout) != null) {
                return true;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // me.hd.wauxv.obf.agr
        public final boolean j(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((agu) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.as(i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), appBarLayout);
            return true;
        }

        @Override // me.hd.wauxv.obf.agr
        public final /* bridge */ /* synthetic */ void k(CoordinatorLayout coordinatorLayout, View view, View view2,
                int i, int i2, int[] iArr, int i3) {
            _o(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // me.hd.wauxv.obf.agr
        public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i3 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = r(coordinatorLayout2, appBarLayout, q() - i3, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i3 == 0 && ViewCompat.getAccessibilityDelegate(coordinatorLayout2) == null) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout2, new b(coordinatorLayout2, this, appBarLayout));
            }
        }

        @Override // me.hd.wauxv.obf.agr
        public final void m(View view, Parcelable parcelable) {
            if (parcelable instanceof d) {
                this._l = (d) parcelable;
            } else {
                this._l = null;
            }
        }

        @Override // me.hd.wauxv.obf.agr
        public final Parcelable n(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            d dVar_p = _p(absSavedState, (AppBarLayout) view);
            return dVar_p == null ? absSavedState : dVar_p;
        }

        @Override // me.hd.wauxv.obf.agr
        public final boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && (appBarLayout.m || (appBarLayout.getTotalScrollRange() != 0
                    && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z && (valueAnimator = this._k) != null) {
                valueAnimator.cancel();
            }
            this._m = null;
            this._j = i2;
            return z;
        }

        @Override // me.hd.wauxv.obf.agr
        public final void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this._j == 0 || i == 1) {
                v(coordinatorLayout, appBarLayout);
                if (appBarLayout.m) {
                    appBarLayout.af(appBarLayout.ag(view2));
                }
            }
            this._m = new WeakReference(view2);
        }

        @Override // me.hd.wauxv.obf.bki
        public final int q() {
            return ag() + this._i;
        }

        @Override // me.hd.wauxv.obf.bki
        public final int r(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            int top;
            boolean zF;
            ArrayList arrayList;
            int topInset;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int iQ = q();
            int i4 = 0;
            if (i2 == 0 || iQ < i2 || iQ > i3) {
                this._i = 0;
            } else {
                int iAs = HugeSyntheticPileOfHelpers.as(i, i2, i3);
                if (iQ != iAs) {
                    if (!appBarLayout.f) {
                        top = iAs;
                        break;
                    }
                    int iAbs = Math.abs(iAs);
                    int childCount = appBarLayout.getChildCount();
                    int i5 = 0;
                    while (true) {
                        if (i5 < childCount) {
                            View childAt = appBarLayout.getChildAt(i5);
                            gs gsVar = (gs) childAt.getLayoutParams();
                            Interpolator interpolator = gsVar.c;
                            if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                                i5++;
                            } else if (interpolator != null) {
                                int i6 = gsVar.a;
                                if ((i6 & 1) != 0) {
                                    topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) gsVar).topMargin
                                            + ((LinearLayout.LayoutParams) gsVar).bottomMargin;
                                    if ((i6 & 2) != 0) {
                                        WeakHashMap weakHashMap = ViewCompat.a;
                                        topInset -= childAt.getMinimumHeight();
                                    }
                                } else {
                                    topInset = 0;
                                }
                                WeakHashMap weakHashMap2 = ViewCompat.a;
                                if (childAt.getFitsSystemWindows()) {
                                    topInset -= appBarLayout.getTopInset();
                                }
                                if (topInset > 0) {
                                    float f = topInset;
                                    top = (childAt.getTop() + Math
                                            .round(interpolator.getInterpolation((iAbs - childAt.getTop()) / f) * f))
                                            * Integer.signum(iAs);
                                    break;
                                }
                            }
                        }
                        top = iAs;
                        break;
                    }
                    ert ertVar = this.ae;
                    if (ertVar != null) {
                        zF = ertVar.f(top);
                    } else {
                        this.af = top;
                        zF = false;
                    }
                    int i7 = iQ - iAs;
                    this._i = iAs - top;
                    int i8 = 1;
                    if (zF) {
                        int i9 = 0;
                        while (i9 < appBarLayout.getChildCount()) {
                            gs gsVar2 = (gs) appBarLayout.getChildAt(i9).getLayoutParams();
                            DefaultConfig ioVar = gsVar2.b;
                            if (ioVar != null && (gsVar2.a & i8) != 0) {
                                View childAt2 = appBarLayout.getChildAt(i9);
                                float fAg = ag();
                                Rect rect = (Rect) ioVar.d;
                                Rect rect2 = (Rect) ioVar.c;
                                childAt2.getDrawingRect(rect2);
                                appBarLayout.offsetDescendantRectToMyCoords(childAt2, rect2);
                                rect2.offset(0, -appBarLayout.getTopInset());
                                float fAbs = rect2.top - Math.abs(fAg);
                                if (fAbs <= 0.0f) {
                                    float fAr = 1.0f - HugeSyntheticPileOfHelpers.ar(Math.abs(fAbs / rect2.height()), 0.0f, 1.0f);
                                    float fHeight = (-fAbs) - ((rect2.height() * 0.3f) * (1.0f - (fAr * fAr)));
                                    childAt2.setTranslationY(fHeight);
                                    childAt2.getDrawingRect(rect);
                                    rect.offset(0, (int) (-fHeight));
                                    if (fHeight >= rect.height()) {
                                        childAt2.setVisibility(4);
                                    } else {
                                        childAt2.setVisibility(0);
                                    }
                                    WeakHashMap weakHashMap3 = ViewCompat.a;
                                    childAt2.setClipBounds(rect);
                                } else {
                                    WeakHashMap weakHashMap4 = ViewCompat.a;
                                    childAt2.setClipBounds(null);
                                    childAt2.setTranslationY(0.0f);
                                    childAt2.setVisibility(0);
                                }
                            }
                            i9++;
                            i8 = 1;
                        }
                    }
                    if (!zF && appBarLayout.f
                            && (arrayList = (ArrayList) ((dhq) coordinatorLayout.g.f).get(appBarLayout)) != null
                            && !arrayList.isEmpty()) {
                        for (int i10 = 0; i10 < arrayList.size(); i10++) {
                            View view2 = (View) arrayList.get(i10);
                            agr agrVar = ((agu) view2.getLayoutParams()).a;
                            if (agrVar != null) {
                                agrVar.c(coordinatorLayout, view2, appBarLayout);
                            }
                        }
                    }
                    appBarLayout.ad(ag());
                    h(coordinatorLayout, appBarLayout, iAs, iAs < iQ ? -1 : 1, false);
                    i4 = i7;
                }
            }
            if (ViewCompat.getAccessibilityDelegate(coordinatorLayout) != null) {
                return i4;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return i4;
        }

        public final void v(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iQ = q() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                gs gsVar = (gs) childAt.getLayoutParams();
                if ((gsVar.a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) gsVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) gsVar).bottomMargin;
                }
                int i2 = -iQ;
                if (top <= i2 && bottom >= i2) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                gs gsVar2 = (gs) childAt2.getLayoutParams();
                int i3 = gsVar2.a;
                if ((i3 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i == 0) {
                        WeakHashMap weakHashMap = ViewCompat.a;
                        if (appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                            topInset -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i3 & 2) == 2) {
                        WeakHashMap weakHashMap2 = ViewCompat.a;
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i3 & 5) == 5) {
                        WeakHashMap weakHashMap3 = ViewCompat.a;
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iQ < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i3 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) gsVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) gsVar2).bottomMargin;
                    }
                    if (iQ < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    _n(coordinatorLayout, appBarLayout,
                            HugeSyntheticPileOfHelpers.as(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.z = -1;
            this.ab = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        gs gsVar = new gs(-1, -2);
        gsVar.a = 1;
        return gsVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(
            ViewGroup.LayoutParams layoutParams) {
        return aa(layoutParams);
    }
}
