package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aju;
import me.hd.wauxv.obf.ajv;
import me.hd.wauxv.obf.bps;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.ccl;
import me.hd.wauxv.obf.ci;
import me.hd.wauxv.obf.cj;
import me.hd.wauxv.obf.cjn;
import me.hd.wauxv.obf.ck;
import me.hd.wauxv.obf.ckt;
import me.hd.wauxv.obf.cku;
import me.hd.wauxv.obf.cl;
import me.hd.wauxv.obf.cm;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cw;
import me.hd.wauxv.obf.eko;
import me.hd.wauxv.obf.ekt;
import me.hd.wauxv.obf.eqo;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.esh;
import me.hd.wauxv.obf.eut;
import me.hd.wauxv.obf.evb;
import me.hd.wauxv.obf.evc;
import me.hd.wauxv.obf.evd;
import me.hd.wauxv.obf.eve;
import me.hd.wauxv.obf.evf;
import me.hd.wauxv.obf.evg;
import me.hd.wauxv.obf.evo;
import me.hd.wauxv.obf.evr;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements aju, ckt, cku {
    public static final int[] a = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final evr b;
    public static final Rect c;
    public final ci aa;
    public final cj ab;
    public final cj ac;
    public final cjn ad;
    public final cm ae;
    public int d;
    public int e;
    public ContentFrameLayout f;
    public ActionBarContainer g;
    public ajv h;
    public Drawable i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect s;
    public evr t;
    public evr u;
    public evr v;
    public evr w;
    public ck x;
    public OverScroller y;
    public ViewPropertyAnimator z;

    static {
        int i = Build.VERSION.SDK_INT;
        evg evfVar = i >= 34 ? new evf() : i >= 31 ? new eve() : i >= 30 ? new evd() : i >= 29 ? new evc() : new evb();
        evfVar.i(bps.g(0, 1, 0, 1));
        b = evfVar.g();
        c = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        evr evrVar = evr.a;
        this.t = evrVar;
        this.u = evrVar;
        this.v = evrVar;
        this.w = evrVar;
        this.aa = new ci(this, 0);
        this.ab = new cj(this, 0);
        this.ac = new cj(this, 1);
        an(context);
        this.ad = new cjn();
        cm cmVar = new cm(context);
        cmVar.setWillNotDraw(true);
        this.ae = cmVar;
        addView(cmVar);
    }

    public static boolean af(View view, Rect rect, boolean z) {
        boolean z2;
        cl clVar = (cl) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) clVar).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) clVar).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) clVar).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) clVar).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) clVar).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) clVar).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) clVar).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) clVar).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    @Override // me.hd.wauxv.obf.cku
    public final void ag(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        ah(view, i, i2, i3, i4, i5);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void ah(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // me.hd.wauxv.obf.ckt
    public final boolean ai(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void aj(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void ak(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void al(View view, int i, int i2, int[] iArr, int i3) {
    }

    public final void am() {
        removeCallbacks(this.ab);
        removeCallbacks(this.ac);
        ViewPropertyAnimator viewPropertyAnimator = this.z;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void an(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(a);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.i = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.y = new OverScroller(context);
    }

    public final void ao(int i) {
        ap();
        if (i == 2) {
            ((ekt) this.h).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((ekt) this.h).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void ap() {
        ajv wrapper;
        if (this.f == null) {
            this.f = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.g = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof ajv) {
                wrapper = (ajv) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.h = wrapper;
        }
    }

    public final void aq(Menu menu, ccl cclVar) {
        ap();
        ekt ektVar = (ekt) this.h;
        Toolbar toolbar = ektVar.a;
        if (ektVar.m == null) {
            cw cwVar = new cw(toolbar.getContext());
            ektVar.m = cwVar;
            cwVar.i = R.id.action_menu_presenter;
        }
        cw cwVar2 = ektVar.m;
        cwVar2.e = cclVar;
        cbw cbwVar = (cbw) menu;
        if (cbwVar == null && toolbar.a == null) {
            return;
        }
        toolbar.ba();
        cbw cbwVar2 = toolbar.a.a;
        if (cbwVar2 == cbwVar) {
            return;
        }
        if (cbwVar2 != null) {
            cbwVar2.aq(toolbar.ak);
            cbwVar2.aq(toolbar.al);
        }
        if (toolbar.al == null) {
            toolbar.al = new eko(toolbar);
        }
        cwVar2.r = true;
        if (cbwVar != null) {
            cbwVar.aa(cwVar2, toolbar.j);
            cbwVar.aa(toolbar.al, toolbar.j);
        } else {
            cwVar2.af(toolbar.j, null);
            toolbar.al.af(toolbar.j, null);
            cwVar2.ac(true);
            toolbar.al.ac(true);
        }
        toolbar.a.setPopupTheme(toolbar.k);
        toolbar.a.setPresenter(cwVar2);
        toolbar.ak = cwVar2;
        toolbar.bl();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof cl;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.i != null) {
            if (this.g.getVisibility() == 0) {
                translationY = (int) (this.g.getTranslationY() + this.g.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.i.setBounds(0, translationY, getWidth(), this.i.getIntrinsicHeight() + translationY);
            this.i.draw(canvas);
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new cl(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new cl(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.g;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        cjn cjnVar = this.ad;
        return cjnVar.b | cjnVar.a;
    }

    public CharSequence getTitle() {
        ap();
        return ((ekt) this.h).a.getTitle();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        ap();
        evr evrVarD = evr.d(this, windowInsets);
        boolean zAf = af(this.g, new Rect(evrVarD.f(), evrVarD.h(), evrVarD.g(), evrVarD.e()), false);
        WeakHashMap weakHashMap = eqz.a;
        Rect rect = this.p;
        eqq.b(this, evrVarD, rect);
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        evo evoVar = evrVarD.b;
        evr evrVarP = evoVar.p(i, i2, i3, i4);
        this.t = evrVarP;
        boolean z = true;
        if (!this.u.equals(evrVarP)) {
            this.u = this.t;
            zAf = true;
        }
        Rect rect2 = this.q;
        if (rect2.equals(rect)) {
            z = zAf;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return evoVar.ae().b.aa().b.z().i();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        an(getContext());
        WeakHashMap weakHashMap = eqz.a;
        eqo.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        am();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                cl clVar = (cl) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) clVar).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) clVar).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Found duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Found duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Found duplicated region for block: B:27:0x00d9  */
    /* JADX WARN: Found duplicated region for block: B:28:0x00df  */
    /* JADX WARN: Found duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Found duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Found duplicated region for block: B:33:0x00ed  */
    /* JADX WARN: Found duplicated region for block: B:34:0x00f3  */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        ap();
        measureChildWithMargins(this.g, i, 0, i2, 0);
        cl clVar = (cl) this.g.getLayoutParams();
        int iMax = Math.max(0, this.g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) clVar).leftMargin + ((ViewGroup.MarginLayoutParams) clVar).rightMargin);
        int iMax2 = Math.max(0, this.g.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) clVar).topMargin + ((ViewGroup.MarginLayoutParams) clVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.g.getMeasuredState());
        WeakHashMap weakHashMap = eqz.a;
        boolean z = (getWindowSystemUiVisibility() & 256) != 0;
        if (z) {
            measuredHeight = this.d;
            if (this.k && this.g.getTabContainer() != null) {
                measuredHeight += this.d;
            }
        } else {
            measuredHeight = this.g.getVisibility() != 8 ? this.g.getMeasuredHeight() : 0;
        }
        Rect rect = this.p;
        Rect rect2 = this.r;
        rect2.set(rect);
        this.v = this.t;
        if (this.j || z) {
            bps bpsVarG = bps.g(this.v.f(), this.v.h() + measuredHeight, this.v.g(), this.v.e());
            evr evrVar = this.v;
            int i3 = Build.VERSION.SDK_INT;
            evg evfVar = i3 >= 34 ? new evf(evrVar) : i3 >= 31 ? new eve(evrVar) : i3 >= 30 ? new evd(evrVar) : i3 >= 29 ? new evc(evrVar) : new evb(evrVar);
            evfVar.i(bpsVarG);
            this.v = evfVar.g();
        } else {
            cm cmVar = this.ae;
            evr evrVar2 = b;
            Rect rect3 = this.s;
            eqq.b(cmVar, evrVar2, rect3);
            if (rect3.equals(c)) {
                bps bpsVarG2 = bps.g(this.v.f(), this.v.h() + measuredHeight, this.v.g(), this.v.e());
                evr evrVar3 = this.v;
                int i32 = Build.VERSION.SDK_INT;
                if (i32 >= 34) {
                }
                evfVar.i(bpsVarG2);
                this.v = evfVar.g();
            } else {
                rect2.top += measuredHeight;
                rect2.bottom = rect2.bottom;
                this.v = this.v.b.p(0, measuredHeight, 0, 0);
            }
        }
        af(this.f, rect2, true);
        if (!this.w.equals(this.v)) {
            evr evrVar4 = this.v;
            this.w = evrVar4;
            eqz.h(this.f, evrVar4);
        }
        measureChildWithMargins(this.f, i, 0, i2, 0);
        cl clVar2 = (cl) this.f.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) clVar2).leftMargin + ((ViewGroup.MarginLayoutParams) clVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) clVar2).topMargin + ((ViewGroup.MarginLayoutParams) clVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.l || !z) {
            return false;
        }
        this.y.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.y.getFinalY() > this.g.getHeight()) {
            am();
            this.ac.run();
        } else {
            am();
            this.ab.run();
        }
        this.m = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.n + i2;
        this.n = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        eut eutVar;
        esh eshVar;
        this.ad.a = i;
        this.n = getActionBarHideOffset();
        am();
        ck ckVar = this.x;
        if (ckVar == null || (eshVar = (eutVar = (eut) ckVar).bh) == null) {
            return;
        }
        eshVar.g();
        eutVar.bh = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.g.getVisibility() != 0) {
            return false;
        }
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.l || this.m) {
            return;
        }
        if (this.n <= this.g.getHeight()) {
            am();
            postDelayed(this.ab, 600L);
        } else {
            am();
            postDelayed(this.ac, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        ap();
        int i2 = this.o ^ i;
        this.o = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        ck ckVar = this.x;
        if (ckVar != null) {
            eut eutVar = (eut) ckVar;
            eutVar.bd = !z2;
            if (z || !z2) {
                if (eutVar.be) {
                    eutVar.be = false;
                    eutVar.bs(true);
                }
            } else if (!eutVar.be) {
                eutVar.be = true;
                eutVar.bs(true);
            }
        }
        if ((i2 & 256) == 0 || this.x == null) {
            return;
        }
        WeakHashMap weakHashMap = eqz.a;
        eqo.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.e = i;
        ck ckVar = this.x;
        if (ckVar != null) {
            ((eut) ckVar).bc = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        am();
        this.g.setTranslationY(-Math.max(0, Math.min(i, this.g.getHeight())));
    }

    public void setActionBarVisibilityCallback(ck ckVar) {
        this.x = ckVar;
        if (getWindowToken() != null) {
            ((eut) this.x).bc = this.e;
            int i = this.o;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = eqz.a;
                eqo.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.k = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (z) {
                return;
            }
            am();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        ap();
        ekt ektVar = (ekt) this.h;
        ektVar.d = i != 0 ? cmz.y(ektVar.a.getContext(), i) : null;
        ektVar.r();
    }

    public void setLogo(int i) {
        ap();
        ekt ektVar = (ekt) this.h;
        ektVar.e = i != 0 ? cmz.y(ektVar.a.getContext(), i) : null;
        ektVar.r();
    }

    public void setOverlayMode(boolean z) {
        this.j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // me.hd.wauxv.obf.aju
    public void setWindowCallback(Window.Callback callback) {
        ap();
        ((ekt) this.h).k = callback;
    }

    @Override // me.hd.wauxv.obf.aju
    public void setWindowTitle(CharSequence charSequence) {
        ap();
        ekt ektVar = (ekt) this.h;
        if (ektVar.g) {
            return;
        }
        Toolbar toolbar = ektVar.a;
        ektVar.h = charSequence;
        if ((ektVar.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (ektVar.g) {
                eqz.t(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new cl(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        ap();
        ekt ektVar = (ekt) this.h;
        ektVar.d = drawable;
        ektVar.r();
    }
}
