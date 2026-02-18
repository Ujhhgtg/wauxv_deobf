package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aat;
import me.hd.wauxv.obf.aau;
import me.hd.wauxv.obf.aav;
import me.hd.wauxv.obf.aaw;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.ama;
import me.hd.wauxv.obf.asy;
import me.hd.wauxv.obf.bht;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.eqo;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.erp;
import me.hd.wauxv.obf.ert;
import me.hd.wauxv.obf.evr;
import me.hd.wauxv.obf.ff;
import me.hd.wauxv.obf.no;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public boolean a;
    public evr aa;
    public int ab;
    public boolean ac;
    public int ad;
    public boolean ae;
    public final int b;
    public ViewGroup c;
    public View d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final Rect j;
    public final aat k;
    public final asy l;
    public boolean m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public int q;
    public boolean r;
    public ValueAnimator s;
    public long t;
    public final TimeInterpolator u;
    public final TimeInterpolator v;
    public int w;
    public aav x;
    public int y;
    public int z;

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        int i;
        ColorStateList colorStateListV;
        ColorStateList colorStateListV2;
        super(cmz.aq(context, attributeSet, R.attr.collapsingToolbarLayoutStyle, R.style.Widget_Design_CollapsingToolbar), attributeSet, R.attr.collapsingToolbarLayoutStyle);
        this.a = true;
        this.j = new Rect();
        this.w = -1;
        this.ab = 0;
        this.ad = 0;
        Context context2 = getContext();
        aat aatVar = new aat(this);
        this.k = aatVar;
        aatVar.aw = ff.e;
        aatVar.bz(false);
        aatVar.aj = false;
        this.l = new asy(context2);
        bhu.p(context2, attributeSet, R.attr.collapsingToolbarLayoutStyle, R.style.Widget_Design_CollapsingToolbar);
        int[] iArr = cxs.k;
        bhu.q(context2, attributeSet, iArr, R.attr.collapsingToolbarLayoutStyle, R.style.Widget_Design_CollapsingToolbar, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.collapsingToolbarLayoutStyle, R.style.Widget_Design_CollapsingToolbar);
        int i2 = typedArrayObtainStyledAttributes.getInt(4, 8388691);
        if (aatVar.j != i2) {
            aatVar.j = i2;
            aatVar.bz(false);
        }
        aatVar.cc(typedArrayObtainStyledAttributes.getInt(0, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        int i3 = 8;
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(9)) {
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        this.m = typedArrayObtainStyledAttributes.getBoolean(20, true);
        setTitle(typedArrayObtainStyledAttributes.getText(18));
        aatVar.ce(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        aatVar.cb(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes.hasValue(10)) {
            aatVar.ce(typedArrayObtainStyledAttributes.getResourceId(10, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            aatVar.cb(typedArrayObtainStyledAttributes.getResourceId(1, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            int i4 = typedArrayObtainStyledAttributes.getInt(22, -1);
            setTitleEllipsize(i4 != 0 ? i4 != 1 ? i4 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START);
        }
        if (typedArrayObtainStyledAttributes.hasValue(11) && aatVar.n != (colorStateListV2 = cnb.v(context2, typedArrayObtainStyledAttributes, 11))) {
            aatVar.n = colorStateListV2;
            aatVar.bz(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2) && aatVar.o != (colorStateListV = cnb.v(context2, typedArrayObtainStyledAttributes, 2))) {
            aatVar.o = colorStateListV;
            aatVar.bz(false);
        }
        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, -1);
        if (typedArrayObtainStyledAttributes.hasValue(14) && (i = typedArrayObtainStyledAttributes.getInt(14, 1)) != aatVar.bn) {
            aatVar.bn = i;
            Bitmap bitmap = aatVar.ak;
            if (bitmap != null) {
                bitmap.recycle();
                aatVar.ak = null;
            }
            aatVar.bz(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            aatVar.av = AnimationUtils.loadInterpolator(context2, typedArrayObtainStyledAttributes.getResourceId(21, 0));
            aatVar.bz(false);
        }
        this.t = typedArrayObtainStyledAttributes.getInt(15, 600);
        this.u = ajn.ae(context2, R.attr.motionEasingStandardInterpolator, ff.c);
        this.v = ajn.ae(context2, R.attr.motionEasingStandardInterpolator, ff.d);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(3));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(17));
        setTitleCollapseMode(typedArrayObtainStyledAttributes.getInt(19, 0));
        this.b = typedArrayObtainStyledAttributes.getResourceId(23, -1);
        this.ac = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.ae = typedArrayObtainStyledAttributes.getBoolean(12, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        erp erpVar = new erp(this, i3);
        WeakHashMap weakHashMap = eqz.a;
        eqq.l(this, erpVar);
    }

    public static ert af(View view) {
        ert ertVar = (ert) view.getTag(R.id.view_offset_helper);
        if (ertVar != null) {
            return ertVar;
        }
        ert ertVar2 = new ert(view);
        view.setTag(R.id.view_offset_helper, ertVar2);
        return ertVar2;
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x0020  */
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListValueOf;
        Context context = getContext();
        TypedValue typedValueAl = cmz.al(context, R.attr.colorSurfaceContainer);
        if (typedValueAl != null) {
            int i = typedValueAl.resourceId;
            if (i != 0) {
                colorStateListValueOf = bht.v(context, i);
            } else {
                int i2 = typedValueAl.data;
                colorStateListValueOf = i2 != 0 ? ColorStateList.valueOf(i2) : null;
            }
        }
        if (colorStateListValueOf != null) {
            return colorStateListValueOf.getDefaultColor();
        }
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        asy asyVar = this.l;
        return asyVar.g(asyVar.e, dimension);
    }

    public final void ag() {
        View view;
        if (this.a) {
            ViewGroup viewGroup = null;
            this.c = null;
            this.d = null;
            int i = this.b;
            if (i != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
                this.c = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    while (true) {
                        if (parent == this) {
                            view = viewGroup2;
                            break;
                        } else {
                            if (parent == null) {
                                break;
                            }
                            if (parent instanceof View) {
                                view = (View) parent;
                            }
                            parent = parent.getParent();
                            view = view;
                        }
                    }
                    this.d = view;
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.c = viewGroup;
            }
            ah();
            this.a = false;
        }
    }

    public final void ah() {
        View view;
        if (!this.m && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (!this.m || this.c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new View(getContext());
        }
        if (this.e.getParent() == null) {
            this.c.addView(this.e, -1, -1);
        }
    }

    public final void ai() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.y < getScrimVisibleHeightTrigger());
    }

    public final void aj(int i, int i2, int i3, int i4, boolean z) {
        View view;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        if (!this.m || (view = this.e) == null) {
            return;
        }
        WeakHashMap weakHashMap = eqz.a;
        int titleMarginStart = 0;
        boolean z2 = view.isAttachedToWindow() && this.e.getVisibility() == 0;
        this.n = z2;
        if (z2 || z) {
            boolean z3 = getLayoutDirection() == 1;
            View view2 = this.d;
            if (view2 == null) {
                view2 = this.c;
            }
            int height = ((getHeight() - af(view2).b) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((aau) view2.getLayoutParams())).bottomMargin;
            View view3 = this.e;
            ThreadLocal threadLocal = ama.a;
            int width = view3.getWidth();
            int height2 = view3.getHeight();
            Rect rect = this.j;
            rect.set(0, 0, width, height2);
            ama.d(this, view3, rect);
            ViewGroup viewGroup = this.c;
            if (viewGroup instanceof Toolbar) {
                Toolbar toolbar = (Toolbar) viewGroup;
                titleMarginStart = toolbar.getTitleMarginStart();
                titleMarginEnd = toolbar.getTitleMarginEnd();
                titleMarginTop = toolbar.getTitleMarginTop();
                titleMarginBottom = toolbar.getTitleMarginBottom();
            } else if (viewGroup instanceof android.widget.Toolbar) {
                android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                titleMarginStart = toolbar2.getTitleMarginStart();
                titleMarginEnd = toolbar2.getTitleMarginEnd();
                titleMarginTop = toolbar2.getTitleMarginTop();
                titleMarginBottom = toolbar2.getTitleMarginBottom();
            } else {
                titleMarginBottom = 0;
                titleMarginEnd = 0;
                titleMarginTop = 0;
            }
            int i5 = rect.left + (z3 ? titleMarginEnd : titleMarginStart);
            int i6 = rect.top + height + titleMarginTop;
            int i7 = rect.right;
            if (!z3) {
                titleMarginStart = titleMarginEnd;
            }
            int i8 = i7 - titleMarginStart;
            int i9 = (rect.bottom + height) - titleMarginBottom;
            aat aatVar = this.k;
            Rect rect2 = aatVar.h;
            if (rect2.left != i5 || rect2.top != i6 || rect2.right != i8 || rect2.bottom != i9) {
                rect2.set(i5, i6, i8, i9);
                aatVar.as = true;
            }
            int i10 = z3 ? this.h : this.f;
            int i11 = rect.top + this.g;
            int i12 = (i3 - i) - (z3 ? this.f : this.h);
            int i13 = (i4 - i2) - this.i;
            Rect rect3 = aatVar.g;
            if (rect3.left != i10 || rect3.top != i11 || rect3.right != i12 || rect3.bottom != i13) {
                rect3.set(i10, i11, i12, i13);
                aatVar.as = true;
            }
            aatVar.bz(z);
        }
    }

    public final void ak() {
        if (this.c != null && this.m && TextUtils.isEmpty(this.k.ag)) {
            ViewGroup viewGroup = this.c;
            setTitle(viewGroup instanceof Toolbar ? ((Toolbar) viewGroup).getTitle() : viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof aau;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        ag();
        if (this.c == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            ViewGroup viewGroup = this.c;
            aat aatVar = this.k;
            if (viewGroup == null || this.o == null || this.q <= 0 || this.z != 1 || aatVar.b >= aatVar.e) {
                aatVar.bv(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                aatVar.bv(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.p == null || this.q <= 0) {
            return;
        }
        evr evrVar = this.aa;
        int iH = evrVar != null ? evrVar.h() : 0;
        if (iH > 0) {
            this.p.setBounds(0, -this.y, getWidth(), iH - this.y);
            this.p.mutate().setAlpha(this.q);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        View view2;
        Drawable drawable = this.o;
        if (drawable == null || this.q <= 0 || ((view2 = this.d) == null || view2 == this ? view != this.c : view != view2)) {
            z = false;
        } else {
            int width = getWidth();
            int height = getHeight();
            if (this.z == 1 && view != null && this.m) {
                height = view.getBottom();
            }
            drawable.setBounds(0, 0, width, height);
            this.o.mutate().setAlpha(this.q);
            this.o.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        aat aatVar = this.k;
        if (aatVar != null) {
            aatVar.ar = drawableState;
            ColorStateList colorStateList2 = aatVar.o;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = aatVar.n) != null && colorStateList.isStateful())) {
                aatVar.bz(false);
                z = true;
            }
            state |= z;
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        aau aauVar = new aau(-1, -1);
        aauVar.a = 0;
        aauVar.b = 0.5f;
        return aauVar;
    }

    public int getCollapsedTitleGravity() {
        return this.k.k;
    }

    public float getCollapsedTitleTextSize() {
        return this.k.m;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.k.w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.k.j;
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public float getExpandedTitleTextSize() {
        return this.k.l;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.k.z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getHyphenationFrequency() {
        return this.k.bq;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.k.bi;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.k.bi.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.k.bi.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.k.bn;
    }

    public int getScrimAlpha() {
        return this.q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.w;
        if (i >= 0) {
            return i + this.ab + this.ad;
        }
        evr evrVar = this.aa;
        int iH = evrVar != null ? evrVar.h() : 0;
        WeakHashMap weakHashMap = eqz.a;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iH, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.p;
    }

    public CharSequence getTitle() {
        if (this.m) {
            return this.k.ag;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.z;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.k.av;
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.k.af;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.z == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
            WeakHashMap weakHashMap = eqz.a;
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.x == null) {
                this.x = new aav(this);
            }
            aav aavVar = this.x;
            if (appBarLayout.i == null) {
                appBarLayout.i = new ArrayList();
            }
            if (aavVar != null && !appBarLayout.i.contains(aavVar)) {
                appBarLayout.i.add(aavVar);
            }
            eqo.c(this);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k.by(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        aav aavVar = this.x;
        if (aavVar != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).i) != null) {
            arrayList.remove(aavVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        evr evrVar = this.aa;
        if (evrVar != null) {
            int iH = evrVar.h();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                WeakHashMap weakHashMap = eqz.a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < iH) {
                    childAt.offsetTopAndBottom(iH);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            ert ertVarAf = af(getChildAt(i6));
            View view = ertVarAf.a;
            ertVarAf.b = view.getTop();
            ertVarAf.c = view.getLeft();
        }
        aj(i, i2, i3, i4, false);
        ak();
        ai();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            af(getChildAt(i7)).e();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x007f  */
    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        int measuredHeight;
        int measuredHeight2;
        ag();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        evr evrVar = this.aa;
        int iH = evrVar != null ? evrVar.h() : 0;
        if ((mode == 0 || this.ac) && iH > 0) {
            this.ab = iH;
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iH, 1073741824));
        }
        if (this.ae) {
            aat aatVar = this.k;
            if (aatVar.bn > 1) {
                ak();
                collapsingToolbarLayout = this;
                collapsingToolbarLayout.aj(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
                int i3 = aatVar.p;
                if (i3 > 1) {
                    TextPaint textPaint = aatVar.au;
                    textPaint.setTextSize(aatVar.l);
                    textPaint.setTypeface(aatVar.z);
                    textPaint.setLetterSpacing(aatVar.bg);
                    collapsingToolbarLayout.ad = (i3 - 1) * Math.round(textPaint.descent() + (-textPaint.ascent()));
                    super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + collapsingToolbarLayout.ad, 1073741824));
                }
            } else {
                collapsingToolbarLayout = this;
            }
        } else {
            collapsingToolbarLayout = this;
        }
        ViewGroup viewGroup = collapsingToolbarLayout.c;
        if (viewGroup != null) {
            View view = collapsingToolbarLayout.d;
            if (view == null || view == collapsingToolbarLayout) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    measuredHeight = viewGroup.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    measuredHeight = viewGroup.getMeasuredHeight();
                }
                setMinimumHeight(measuredHeight);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                measuredHeight2 = view.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
            } else {
                measuredHeight2 = view.getMeasuredHeight();
            }
            setMinimumHeight(measuredHeight2);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.o;
        if (drawable != null) {
            ViewGroup viewGroup = this.c;
            if (this.z == 1 && viewGroup != null && this.m) {
                i2 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.k.cc(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.k.cb(i);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        aat aatVar = this.k;
        if (aatVar.o != colorStateList) {
            aatVar.o = colorStateList;
            aatVar.bz(false);
        }
    }

    public void setCollapsedTitleTextSize(float f) {
        aat aatVar = this.k;
        if (aatVar.m != f) {
            aatVar.m = f;
            aatVar.bz(false);
        }
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        aat aatVar = this.k;
        if (aatVar.cd(typeface)) {
            aatVar.bz(false);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.c;
                if (this.z == 1 && viewGroup != null && this.m) {
                    height = viewGroup.getBottom();
                }
                drawableMutate.setBounds(0, 0, width, height);
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            WeakHashMap weakHashMap = eqz.a;
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(getContext().getDrawable(i));
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        aat aatVar = this.k;
        if (aatVar.j != i) {
            aatVar.j = i;
            aatVar.bz(false);
        }
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.k.ce(i);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        aat aatVar = this.k;
        if (aatVar.n != colorStateList) {
            aatVar.n = colorStateList;
            aatVar.bz(false);
        }
    }

    public void setExpandedTitleTextSize(float f) {
        aat aatVar = this.k;
        if (aatVar.l != f) {
            aatVar.l = f;
            aatVar.bz(false);
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        aat aatVar = this.k;
        if (aatVar.cf(typeface)) {
            aatVar.bz(false);
        }
    }

    public void setExtraMultilineHeightEnabled(boolean z) {
        this.ae = z;
    }

    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.ac = z;
    }

    public void setHyphenationFrequency(int i) {
        this.k.bq = i;
    }

    public void setLineSpacingAdd(float f) {
        this.k.bo = f;
    }

    public void setLineSpacingMultiplier(float f) {
        this.k.bp = f;
    }

    public void setMaxLines(int i) {
        aat aatVar = this.k;
        if (i != aatVar.bn) {
            aatVar.bn = i;
            Bitmap bitmap = aatVar.ak;
            if (bitmap != null) {
                bitmap.recycle();
                aatVar.ak = null;
            }
            aatVar.bz(false);
        }
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.k.aj = z;
    }

    public void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.q) {
            if (this.o != null && (viewGroup = this.c) != null) {
                WeakHashMap weakHashMap = eqz.a;
                viewGroup.postInvalidateOnAnimation();
            }
            this.q = i;
            WeakHashMap weakHashMap2 = eqz.a;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(long j) {
        this.t = j;
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.w != i) {
            this.w = i;
            ai();
        }
    }

    public void setScrimsShown(boolean z) {
        WeakHashMap weakHashMap = eqz.a;
        boolean z2 = isLaidOut() && !isInEditMode();
        if (this.r != z) {
            if (z2) {
                int i = z ? 255 : 0;
                ag();
                ValueAnimator valueAnimator = this.s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.s = valueAnimator2;
                    valueAnimator2.setInterpolator(i > this.q ? this.u : this.v);
                    this.s.addUpdateListener(new no(this, 2));
                } else if (valueAnimator.isRunning()) {
                    this.s.cancel();
                }
                this.s.setDuration(this.t);
                this.s.setIntValues(this.q, i);
                this.s.start();
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    public void setStaticLayoutBuilderConfigurer(aaw aawVar) {
        aat aatVar = this.k;
        if (aawVar != null) {
            aatVar.bz(true);
        } else {
            aatVar.getClass();
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                Drawable drawable3 = this.p;
                WeakHashMap weakHashMap = eqz.a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            WeakHashMap weakHashMap2 = eqz.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(getContext().getDrawable(i));
    }

    public void setTitle(CharSequence charSequence) {
        aat aatVar = this.k;
        if (charSequence == null || !TextUtils.equals(aatVar.ag, charSequence)) {
            aatVar.ag = charSequence;
            aatVar.ah = null;
            Bitmap bitmap = aatVar.ak;
            if (bitmap != null) {
                bitmap.recycle();
                aatVar.ak = null;
            }
            aatVar.bz(false);
        }
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i) {
        this.z = i;
        boolean z = i == 1;
        this.k.c = z;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.z == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z && this.o == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        aat aatVar = this.k;
        aatVar.af = truncateAt;
        aatVar.bz(false);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            setContentDescription(getTitle());
            ah();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        aat aatVar = this.k;
        aatVar.av = timeInterpolator;
        aatVar.bz(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        aau aauVar = new aau(context, attributeSet);
        aauVar.a = 0;
        aauVar.b = 0.5f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.l);
        aauVar.a = typedArrayObtainStyledAttributes.getInt(0, 0);
        aauVar.b = typedArrayObtainStyledAttributes.getFloat(1, 0.5f);
        typedArrayObtainStyledAttributes.recycle();
        return aauVar;
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        aau aauVar = new aau(-1, -1);
        aauVar.a = 0;
        aauVar.b = 0.5f;
        return aauVar;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        aau aauVar = new aau(layoutParams);
        aauVar.a = 0;
        aauVar.b = 0.5f;
        return aauVar;
    }
}
