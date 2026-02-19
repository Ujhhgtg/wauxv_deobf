package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import me.hd.wauxv.obf.aco;
import me.hd.wauxv.obf.akz;
import me.hd.wauxv.obf.LateinitProperty;
import me.hd.wauxv.obf.bdi;
import me.hd.wauxv.obf.SomeFragmentManager;
import me.hd.wauxv.obf.beg;
import me.hd.wauxv.obf.byc;
import me.hd.wauxv.obf.byu;
import me.hd.wauxv.obf.chm;
import me.hd.wauxv.obf.csg;
import me.hd.wauxv.obf.cxr;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.czc;
import me.hd.wauxv.obf.czg;
import me.hd.wauxv.obf.dc;
import me.hd.wauxv.obf.dfc;
import me.hd.wauxv.obf.dfd;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.erp;
import me.hd.wauxv.obf.erv;
import me.hd.wauxv.obf.erw;
import me.hd.wauxv.obf.erx;
import me.hd.wauxv.obf.ery;
import me.hd.wauxv.obf.esa;
import me.hd.wauxv.obf.esb;
import me.hd.wauxv.obf.esc;
import me.hd.wauxv.obf.esd;
import me.hd.wauxv.obf.ese;
import me.hd.wauxv.obf.np;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public final Rect a;
    public final Rect b;
    public final aco c;
    public int d;
    public boolean e;
    public final erv f;
    public final ery g;
    public int h;
    public Parcelable i;
    public final esd j;
    public final esc k;
    public final dfd l;
    public final aco m;
    public final erp n;
    public final csg o;
    public czc p;
    public boolean q;
    public boolean r;
    public int s;
    public final chm t;

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = new Rect();
        aco acoVar = new aco();
        this.c = acoVar;
        this.e = false;
        this.f = new erv(this, 0);
        this.h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        chm chmVar = new chm();
        chmVar.f = this;
        chmVar.c = new esa(chmVar, 0);
        chmVar.d = new esa(chmVar, 1);
        this.t = chmVar;
        esd esdVar = new esd(this, context);
        this.j = esdVar;
        esdVar.setId(View.generateViewId());
        this.j.setDescendantFocusability(131072);
        ery eryVar = new ery(this);
        this.g = eryVar;
        this.j.setLayoutManager(eryVar);
        this.j.setScrollingTouchSlop(1);
        int[] iArr = cxr.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.r(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            esd esdVar2 = this.j;
            erx erxVar = new erx();
            if (esdVar2.am == null) {
                esdVar2.am = new ArrayList();
            }
            esdVar2.am.add(erxVar);
            dfd dfdVar = new dfd(this);
            this.l = dfdVar;
            this.n = new erp(dfdVar, 23);
            esc escVar = new esc(this);
            this.k = escVar;
            escVar.g(this.j);
            this.j.cv(this.l);
            aco acoVar2 = new aco();
            this.m = acoVar2;
            this.l.a = acoVar2;
            erw erwVar = new erw(this, 0);
            erw erwVar2 = new erw(this, 1);
            ((ArrayList) acoVar2.b).add(erwVar);
            ((ArrayList) this.m.b).add(erwVar2);
            chm chmVar2 = this.t;
            esd esdVar3 = this.j;
            chmVar2.getClass();
            esdVar3.setImportantForAccessibility(2);
            chmVar2.e = new erv(chmVar2, 1);
            ViewPager2 viewPager2 = (ViewPager2) chmVar2.f;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
            ((ArrayList) this.m.b).add(acoVar);
            csg csgVar = new csg();
            this.o = csgVar;
            ((ArrayList) this.m.b).add(csgVar);
            esd esdVar4 = this.j;
            attachViewToParent(esdVar4, 0, esdVar4.getLayoutParams());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.j.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.j.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof ese) {
            int i = ((ese) parcelable).a;
            sparseArray.put(this.j.getId(), (Parcelable) sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.t.getClass();
        this.t.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public cyw getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.d;
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public int getOrientation() {
        return this.g.bd == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        int orientation = getOrientation();
        esd esdVar = this.j;
        if (orientation == 0) {
            height = esdVar.getWidth() - esdVar.getPaddingLeft();
            paddingBottom = esdVar.getPaddingRight();
        } else {
            height = esdVar.getHeight() - esdVar.getPaddingTop();
            paddingBottom = esdVar.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.l.h;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int iD;
        int iD2;
        int iD3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = (ViewPager2) this.t.f;
        if (viewPager2.getAdapter() == null) {
            iD = 0;
            iD2 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            iD = viewPager2.getAdapter().d();
            iD2 = 1;
        } else {
            iD2 = viewPager2.getAdapter().d();
            iD = 1;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) LateinitProperty.f(iD, iD2, 0).e);
        cyw adapter = viewPager2.getAdapter();
        if (adapter == null || (iD3 = adapter.d()) == 0 || !viewPager2.r) {
            return;
        }
        if (viewPager2.d > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        if (viewPager2.d < iD3 - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.a;
        rect.left = paddingLeft;
        rect.right = (i3 - i) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i4 - i2) - getPaddingBottom();
        Rect rect2 = this.b;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.j.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.e) {
            w();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        measureChild(this.j, i, i2);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ese)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ese eseVar = (ese) parcelable;
        super.onRestoreInstanceState(eseVar.getSuperState());
        this.h = eseVar.b;
        this.i = eseVar.c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ese eseVar = new ese(super.onSaveInstanceState());
        eseVar.a = this.j.getId();
        int i = this.h;
        if (i == -1) {
            i = this.d;
        }
        eseVar.b = i;
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            eseVar.c = parcelable;
            return eseVar;
        }
        cyw adapter = this.j.getAdapter();
        if (adapter instanceof byu) {
            byu byuVar = (byu) adapter;
            byuVar.getClass();
            byc bycVar = byuVar.c;
            int iK = bycVar.k();
            byc bycVar2 = byuVar.h;
            Bundle bundle = new Bundle(bycVar2.k() + iK);
            for (int i2 = 0; i2 < bycVar.k(); i2++) {
                long jH = bycVar.h(i2);
                SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) bycVar.f(jH);
                if (someFragmentManagerVar != null && someFragmentManagerVar.cv()) {
                    String strB = dts.b(jH, "f#");
                    beg begVar = byuVar.b;
                    begVar.getClass();
                    if (someFragmentManagerVar.bm != begVar) {
                        begVar.cy(new IllegalStateException(yg.l("Fragment ", someFragmentManagerVar, " is not currently in the FragmentManager")));
                        throw null;
                    }
                    bundle.putString(strB, someFragmentManagerVar.aw);
                }
            }
            for (int i3 = 0; i3 < bycVar2.k(); i3++) {
                long jH2 = bycVar2.h(i3);
                if (byuVar.x(jH2)) {
                    bundle.putParcelable(dts.b(jH2, "s#"), (Parcelable) bycVar2.f(jH2));
                }
            }
            eseVar.c = bundle;
        }
        return eseVar;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        this.t.getClass();
        if (i != 8192 && i != 4096) {
            return super.performAccessibilityAction(i, bundle);
        }
        chm chmVar = this.t;
        ViewPager2 viewPager2 = (ViewPager2) chmVar.f;
        if (i != 8192 && i != 4096) {
            throw new IllegalStateException();
        }
        int currentItem = i == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
        ViewPager2 viewPager22 = (ViewPager2) chmVar.f;
        if (viewPager22.r) {
            viewPager22.v(currentItem);
        }
        return true;
    }

    public void setAdapter(cyw cywVar) {
        cyw adapter = this.j.getAdapter();
        chm chmVar = this.t;
        if (adapter != null) {
            adapter.ac.unregisterObserver((erv) chmVar.e);
        } else {
            chmVar.getClass();
        }
        erv ervVar = this.f;
        if (adapter != null) {
            adapter.ac.unregisterObserver(ervVar);
        }
        this.j.setAdapter(cywVar);
        this.d = 0;
        u();
        chm chmVar2 = this.t;
        chmVar2.av();
        if (cywVar != null) {
            cywVar.ac.registerObserver((erv) chmVar2.e);
        }
        if (cywVar != null) {
            cywVar.ac.registerObserver(ervVar);
        }
    }

    public void setCurrentItem(int i) {
        Object obj = this.n.v;
        v(i);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.t.av();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.s = i;
        this.j.requestLayout();
    }

    public void setOrientation(int i) {
        this.g.dh(i);
        this.t.av();
    }

    public void setPageTransformer(esb esbVar) {
        if (esbVar != null) {
            if (!this.q) {
                this.p = this.j.getItemAnimator();
                this.q = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.q) {
            this.j.setItemAnimator(this.p);
            this.p = null;
            this.q = false;
        }
        this.o.getClass();
        if (esbVar == null) {
            return;
        }
        this.o.getClass();
        this.o.getClass();
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        this.t.av();
    }

    public final void u() {
        cyw adapter;
        SomeFragmentManager someFragmentManagerVarZ;
        if (this.h == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            if (adapter instanceof byu) {
                byu byuVar = (byu) adapter;
                byc bycVar = byuVar.c;
                byc bycVar2 = byuVar.h;
                if (bycVar2.k() != 0 || bycVar.k() != 0) {
                    throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
                }
                Bundle bundle = (Bundle) parcelable;
                if (bundle.getClassLoader() == null) {
                    bundle.setClassLoader(byu.class.getClassLoader());
                }
                for (String str : bundle.keySet()) {
                    if (str.startsWith("f#") && str.length() > 2) {
                        long j = Long.parseLong(str.substring(2));
                        beg begVar = byuVar.b;
                        begVar.getClass();
                        String string = bundle.getString(str);
                        if (string == null) {
                            someFragmentManagerVarZ = null;
                        } else {
                            someFragmentManagerVarZ = begVar.c.z(string);
                            if (someFragmentManagerVarZ == null) {
                                begVar.cy(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
                                throw null;
                            }
                        }
                        bycVar.i(someFragmentManagerVarZ, j);
                    } else {
                        if (!str.startsWith("s#") || str.length() <= 2) {
                            throw new IllegalArgumentException("Unexpected key in savedState: ".concat(str));
                        }
                        long j2 = Long.parseLong(str.substring(2));
                        bdi bdiVar = (bdi) bundle.getParcelable(str);
                        if (byuVar.x(j2)) {
                            bycVar2.i(bdiVar, j2);
                        }
                    }
                }
                if (bycVar.k() != 0) {
                    byuVar.s = true;
                    byuVar.r = true;
                    byuVar.y();
                    Handler handler = new Handler(Looper.getMainLooper());
                    dc dcVar = new dc(byuVar, 9);
                    byuVar.a.j(new akz(handler, 2, dcVar));
                    handler.postDelayed(dcVar, 10000L);
                }
            }
            this.i = null;
        }
        int iMax = Math.max(0, Math.min(this.h, adapter.d() - 1));
        this.d = iMax;
        this.h = -1;
        this.j.eq(iMax);
        this.t.av();
    }

    public final void v(int i) {
        cyw adapter = getAdapter();
        if (adapter == null) {
            if (this.h != -1) {
                this.h = Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.d() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i, 0), adapter.d() - 1);
        int i2 = this.d;
        if ((iMin == i2 && this.l.h == 0) || iMin == i2) {
            return;
        }
        double d = i2;
        this.d = iMin;
        this.t.av();
        dfd dfdVar = this.l;
        if (dfdVar.h != 0) {
            dfdVar.r();
            dfc dfcVar = dfdVar.i;
            d = ((double) dfcVar.a) + ((double) dfcVar.b);
        }
        dfd dfdVar2 = this.l;
        dfdVar2.getClass();
        dfdVar2.g = 2;
        boolean z = dfdVar2.k != iMin;
        dfdVar2.k = iMin;
        dfdVar2.p(2);
        if (z) {
            dfdVar2.o(iMin);
        }
        double d2 = iMin;
        if (Math.abs(d2 - d) <= 3.0d) {
            this.j.et(iMin);
            return;
        }
        this.j.eq(d2 > d ? iMin - 3 : iMin + 3);
        esd esdVar = this.j;
        esdVar.post(new np(iMin, esdVar));
    }

    public final void w() {
        esc escVar = this.k;
        if (escVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewI = escVar.i(this.g);
        if (viewI == null) {
            return;
        }
        this.g.getClass();
        int iEl = czg.el(viewI);
        if (iEl != this.d && getScrollState() == 0) {
            this.m.e(iEl);
        }
        this.e = false;
    }
}
