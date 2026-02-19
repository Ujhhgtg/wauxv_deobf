package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class czg {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public yi f4do;
    public androidx.recyclerview.widget.RecyclerView dp;
    public final but dq;
    public final but dr;
    public bvl ds;
    public boolean dt;
    public boolean du;
    public final boolean dv;
    public final boolean dw;
    public int dx;
    public boolean dy;
    public int dz;
    public int ea;
    public int eb;
    public int ec;

    public czg() {
        cze czeVar = new cze(this, 0);
        cze czeVar2 = new cze(this, 1);
        this.dq = new but(czeVar);
        this.dr = new but(czeVar2);
        this.dt = false;
        this.du = false;
        this.dv = true;
        this.dw = true;
    }

    public static int ed(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
    }

    /* JADX WARN: Found duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Found duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Found duplicated region for block: B:5:0x0010  */
    public static int ee(int i, int i2, int i3, int i4, boolean z) {
        int iMax = Math.max(0, i - i3);
        if (z) {
            if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                i2 = 0;
                i4 = 0;
            } else {
                i4 = iMax;
            }
        } else if (i4 >= 0) {
            i2 = 1073741824;
        } else if (i4 == -1) {
            i4 = iMax;
        } else if (i4 != -2) {
            i2 = 0;
            i4 = 0;
        } else if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
            i4 = iMax;
            i2 = Integer.MIN_VALUE;
        } else {
            i4 = iMax;
            i2 = 0;
        }
        return View.MeasureSpec.makeMeasureSpec(i4, i2);
    }

    public static int ef(View view) {
        return view.getBottom() + ((czh) view.getLayoutParams()).d.bottom;
    }

    public static int eg(View view) {
        return view.getLeft() - ((czh) view.getLayoutParams()).d.left;
    }

    public static int eh(View view) {
        Rect rect = ((czh) view.getLayoutParams()).d;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int ei(View view) {
        Rect rect = ((czh) view.getLayoutParams()).d;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int ej(View view) {
        return view.getRight() + ((czh) view.getLayoutParams()).d.right;
    }

    public static int ek(View view) {
        return view.getTop() - ((czh) view.getLayoutParams()).d.top;
    }

    public static int el(View view) {
        return ((czh) view.getLayoutParams()).c.z();
    }

    public static czf em(Context context, AttributeSet attributeSet, int i, int i2) {
        czf czfVar = new czf();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxq.a, i, i2);
        czfVar.a = typedArrayObtainStyledAttributes.getInt(0, 1);
        czfVar.b = typedArrayObtainStyledAttributes.getInt(10, 1);
        czfVar.c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        czfVar.d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return czfVar;
    }

    public static boolean en(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    public static void eo(View view, int i, int i2, int i3, int i4) {
        czh czhVar = (czh) view.getLayoutParams();
        Rect rect = czhVar.d;
        view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) czhVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) czhVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) czhVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) czhVar).bottomMargin);
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Found duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Found duplicated region for block: B:35:0x00bc  */
    public boolean _g(androidx.recyclerview.widget.RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        int iEv = ev();
        int iEx = ex();
        int iEw = this.eb - ew();
        int iEu = this.ec - eu();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int iWidth = rect.width() + left;
        int iHeight = rect.height() + top;
        int i = left - iEv;
        int iMin = Math.min(0, i);
        int i2 = top - iEx;
        int iMin2 = Math.min(0, i2);
        int i3 = iWidth - iEw;
        int iMax = Math.max(0, i3);
        int iMax2 = Math.max(0, iHeight - iEu);
        if (this.dp.getLayoutDirection() != 1) {
            if (iMin == 0) {
                iMin = Math.min(i, iMax);
            }
            iMax = iMin;
        } else if (iMax == 0) {
            iMax = Math.max(iMin, i3);
        }
        if (iMin2 == 0) {
            iMin2 = Math.min(i2, iMax2);
        }
        int[] iArr = {iMax, iMin2};
        int i4 = iArr[0];
        int i5 = iArr[1];
        if (z2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild != null) {
                int iEv2 = ev();
                int iEx2 = ex();
                int iEw2 = this.eb - ew();
                int iEu2 = this.ec - eu();
                Rect rect2 = this.dp.t;
                _h(focusedChild, rect2);
                if (rect2.left - i4 < iEw2 && rect2.right - i4 > iEv2 && rect2.top - i5 < iEu2 && rect2.bottom - i5 > iEx2) {
                    if (i4 == 0) {
                    }
                    if (z) {
                        recyclerView.scrollBy(i4, i5);
                        return true;
                    }
                    recyclerView.es(i4, i5, false);
                    return true;
                }
            }
        } else if (i4 == 0 || i5 != 0) {
            if (z) {
                recyclerView.scrollBy(i4, i5);
                return true;
            }
            recyclerView.es(i4, i5, false);
            return true;
        }
        return false;
    }

    public void _h(View view, Rect rect) {
        boolean z = androidx.recyclerview.widget.RecyclerView.a;
        czh czhVar = (czh) view.getLayoutParams();
        Rect rect2 = czhVar.d;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) czhVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) czhVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) czhVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) czhVar).bottomMargin);
    }

    public void aa() {
    }

    public void ab(int i, int i2) {
    }

    public void ac(int i, int i2) {
    }

    public void ad(int i, int i2) {
    }

    public void ae(RecyclerView recyclerViewVar, czt cztVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void af(czt cztVar) {
    }

    public boolean ag(int i, Bundle bundle) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        return fa(recyclerView.m, recyclerView.bo, i, bundle);
    }

    public int ah(int i, RecyclerView recyclerViewVar, czt cztVar) {
        return 0;
    }

    public int ai(int i, RecyclerView recyclerViewVar, czt cztVar) {
        return 0;
    }

    public void aj(Rect rect, int i, int i2) {
        int iEw = ew() + ev() + rect.width();
        int iEu = eu() + ex() + rect.height();
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        WeakHashMap weakHashMap = ViewCompat.a;
        this.dp.setMeasuredDimension(ed(i, iEw, recyclerView.getMinimumWidth()), ed(i2, iEu, this.dp.getMinimumHeight()));
    }

    public boolean ak() {
        return false;
    }

    public void ay(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            int iY = recyclerView.p.y();
            for (int i2 = 0; i2 < iY; i2++) {
                recyclerView.p.x(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void az(int i) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            int iY = recyclerView.p.y();
            for (int i2 = 0; i2 < iY; i2++) {
                recyclerView.p.x(i2).offsetTopAndBottom(i);
            }
        }
    }

    public void ba(cyw cywVar) {
    }

    public void bb(int i) {
    }

    public void bt(String str) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            recyclerView.cw(str);
        }
    }

    public boolean bu() {
        return false;
    }

    public boolean bv() {
        return false;
    }

    public void bw(int i, int i2, czt cztVar, bpq bpqVar) {
    }

    public void bx(int i, bpq bpqVar) {
    }

    public int by(czt cztVar) {
        return 0;
    }

    public int bz(czt cztVar) {
        return 0;
    }

    public View ca(int i) {
        int iEs = es();
        for (int i2 = 0; i2 < iEs; i2++) {
            View viewEr = er(i2);
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(viewEr);
            if (someViewVarCs != null && someViewVarCs.z() == i && !someViewVarCs.am() && (this.dp.bo.g || !someViewVarCs.af())) {
                return viewEr;
            }
        }
        return null;
    }

    public boolean cb() {
        return false;
    }

    public boolean cc() {
        return false;
    }

    public abstract void cd(androidx.recyclerview.widget.RecyclerView recyclerView);

    public void ce(AccessibilityEvent accessibilityEvent) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        RecyclerView recyclerViewVar = recyclerView.m;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.dp.canScrollVertically(-1) && !this.dp.canScrollHorizontally(-1) && !this.dp.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        cyw cywVar = this.dp.w;
        if (cywVar != null) {
            accessibilityEvent.setItemCount(cywVar.d());
        }
    }

    public void cf(Parcelable parcelable) {
    }

    public Parcelable cg() {
        return null;
    }

    public void ch(int i) {
        if (androidx.recyclerview.widget.RecyclerView.b) {
            Log.e("RecyclerView", "You MUST implement scrollToPosition. It will soon become abstract");
        }
    }

    public boolean ci() {
        return false;
    }

    public void cj(androidx.recyclerview.widget.RecyclerView recyclerView, czt cztVar, int i) {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void dm(androidx.recyclerview.widget.RecyclerView recyclerView) {
    }

    public final void ep(View view, int i, boolean z) {
        SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(view);
        if (z || someViewVarCs.af()) {
            dhq dhqVar = (dhq) this.dp.q.b;
            erf erfVarE = (erf) dhqVar.get(someViewVarCs);
            if (erfVarE == null) {
                erfVarE = erf.e();
                dhqVar.put(someViewVarCs, erfVarE);
            }
            erfVarE.b |= 1;
        } else {
            this.dp.q.ae(someViewVarCs);
        }
        czh czhVar = (czh) view.getLayoutParams();
        if (someViewVarCs.an() || someViewVarCs.ag()) {
            if (someViewVarCs.ag()) {
                someViewVarCs.q.t(someViewVarCs);
            } else {
                someViewVarCs.m &= -33;
            }
            this.f4do.j(view, i, view.getLayoutParams(), false);
        } else {
            if (view.getParent() == this.dp) {
                yi yiVar = this.f4do;
                yh yhVar = (yh) yiVar.d;
                int iIndexOfChild = ((cyv) yiVar.c).a.indexOfChild(view);
                int iD = (iIndexOfChild == -1 || yhVar.f(iIndexOfChild)) ? -1 : iIndexOfChild - yhVar.d(iIndexOfChild);
                if (i == -1) {
                    i = this.f4do.y();
                }
                if (iD == -1) {
                    StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.dp.indexOfChild(view));
                    throw new IllegalStateException(yg.i(this.dp, sb));
                }
                if (iD != i) {
                    czg czgVar = this.dp.x;
                    View viewEr = czgVar.er(iD);
                    if (viewEr == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iD + czgVar.dp.toString());
                    }
                    czgVar.er(iD);
                    czgVar.f4do.u(iD);
                    czh czhVar2 = (czh) viewEr.getLayoutParams();
                    SomeView someViewVarCs2 = androidx.recyclerview.widget.RecyclerView.cs(viewEr);
                    if (someViewVarCs2.af()) {
                        dhq dhqVar2 = (dhq) czgVar.dp.q.b;
                        erf erfVarE2 = (erf) dhqVar2.get(someViewVarCs2);
                        if (erfVarE2 == null) {
                            erfVarE2 = erf.e();
                            dhqVar2.put(someViewVarCs2, erfVarE2);
                        }
                        erfVarE2.b = 1 | erfVarE2.b;
                    } else {
                        czgVar.dp.q.ae(someViewVarCs2);
                    }
                    czgVar.f4do.j(viewEr, i, czhVar2, someViewVarCs2.af());
                }
            } else {
                this.f4do.h(view, i, false);
                czhVar.e = true;
                bvl bvlVar = this.ds;
                if (bvlVar != null && bvlVar.j) {
                    bvlVar.g.getClass();
                    SomeView someViewVarCs3 = androidx.recyclerview.widget.RecyclerView.cs(view);
                    if ((someViewVarCs3 != null ? someViewVarCs3.z() : -1) == bvlVar.f) {
                        bvlVar.k = view;
                        if (androidx.recyclerview.widget.RecyclerView.b) {
                            Log.d("RecyclerView", "smooth scroll target view has been attached");
                        }
                    }
                }
            }
        }
        if (czhVar.f) {
            if (androidx.recyclerview.widget.RecyclerView.b) {
                Log.d("RecyclerView", "consuming pending invalidate on child " + czhVar.c);
            }
            someViewVarCs.d.invalidate();
            czhVar.f = false;
        }
    }

    public final void eq(RecyclerView recyclerViewVar) {
        for (int iEs = es() - 1; iEs >= 0; iEs--) {
            View viewEr = er(iEs);
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(viewEr);
            if (someViewVarCs.am()) {
                if (androidx.recyclerview.widget.RecyclerView.b) {
                    Log.d("RecyclerView", "ignoring view " + someViewVarCs);
                }
            } else if (!someViewVarCs.ad() || someViewVarCs.af() || this.dp.w.ad) {
                er(iEs);
                this.f4do.u(iEs);
                recyclerViewVar.r(viewEr);
                this.dp.q.ae(someViewVarCs);
            } else {
                fe(iEs);
                recyclerViewVar.q(someViewVarCs);
            }
        }
    }

    public final View er(int i) {
        yi yiVar = this.f4do;
        if (yiVar != null) {
            return yiVar.x(i);
        }
        return null;
    }

    public final int es() {
        yi yiVar = this.f4do;
        if (yiVar != null) {
            return yiVar.y();
        }
        return 0;
    }

    public final int et() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        cyw adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.d();
        }
        return 0;
    }

    public final int eu() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int ev() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int ew() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int ex() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public final void ey(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((czh) view.getLayoutParams()).d;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.dp != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.dp.v;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void ez(View view, bd bdVar) {
        SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(view);
        if (someViewVarCs == null || someViewVarCs.af()) {
            return;
        }
        yi yiVar = this.f4do;
        if (((ArrayList) yiVar.e).contains(someViewVarCs.d)) {
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        y(recyclerView.m, recyclerView.bo, view, bdVar);
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0062 A[PHI: r8
      0x0062: PHI (r8v8 int) = (r8v5 int), (r8v18 int) binds: [B:27:0x007e, B:19:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean fa(RecyclerView recyclerViewVar, czt cztVar, int i, Bundle bundle) {
        int iEx;
        int iEv;
        float f;
        if (this.dp != null) {
            int iHeight = this.ec;
            int iWidth = this.eb;
            Rect rect = new Rect();
            if (this.dp.getMatrix().isIdentity() && this.dp.getGlobalVisibleRect(rect)) {
                iHeight = rect.height();
                iWidth = rect.width();
            }
            if (i == 4096) {
                iEx = this.dp.canScrollVertically(1) ? (iHeight - ex()) - eu() : 0;
                if (this.dp.canScrollHorizontally(1)) {
                    iEv = (iWidth - ev()) - ew();
                }
            } else if (i != 8192) {
                iEx = 0;
                iEv = 0;
            } else {
                iEx = this.dp.canScrollVertically(-1) ? -((iHeight - ex()) - eu()) : 0;
                iEv = this.dp.canScrollHorizontally(-1) ? -((iWidth - ev()) - ew()) : 0;
            }
            if (iEx != 0 || iEv != 0) {
                if (bundle != null) {
                    f = bundle.getFloat("androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT", 1.0f);
                    if (f < 0.0f) {
                        if (androidx.recyclerview.widget.RecyclerView.a) {
                            throw new IllegalArgumentException("attempting to use ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT with a negative value (" + f + ")");
                        }
                    }
                } else {
                    f = 1.0f;
                }
                if (Float.compare(f, Float.POSITIVE_INFINITY) != 0) {
                    if (Float.compare(1.0f, f) != 0 && Float.compare(0.0f, f) != 0) {
                        iEv = (int) (iEv * f);
                        iEx = (int) (iEx * f);
                    }
                    this.dp.es(iEv, iEx, true);
                    return true;
                }
                androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
                cyw cywVar = recyclerView.w;
                if (cywVar != null) {
                    if (i == 4096) {
                        recyclerView.et(cywVar.d() - 1);
                        return true;
                    }
                    if (i != 8192) {
                        return true;
                    }
                    recyclerView.et(0);
                    return true;
                }
            }
        }
        return false;
    }

    public final void fb(RecyclerView recyclerViewVar) {
        for (int iEs = es() - 1; iEs >= 0; iEs--) {
            if (!androidx.recyclerview.widget.RecyclerView.cs(er(iEs)).am()) {
                View viewEr = er(iEs);
                fe(iEs);
                recyclerViewVar.p(viewEr);
            }
        }
    }

    public final void fc(RecyclerView recyclerViewVar) {
        ArrayList arrayList = recyclerViewVar.a;
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            View view = ((SomeView) arrayList.get(i)).d;
            SomeView someViewVarCs = androidx.recyclerview.widget.RecyclerView.cs(view);
            if (!someViewVarCs.am()) {
                someViewVarCs.al(false);
                if (someViewVarCs.ah()) {
                    this.dp.removeDetachedView(view, false);
                }
                czc czcVar = this.dp.aw;
                if (czcVar != null) {
                    czcVar.p(someViewVarCs);
                }
                someViewVarCs.al(true);
                SomeView someViewVarCs2 = androidx.recyclerview.widget.RecyclerView.cs(view);
                someViewVarCs2.q = null;
                someViewVarCs2.r = false;
                someViewVarCs2.m &= -33;
                recyclerViewVar.q(someViewVarCs2);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = recyclerViewVar.b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.dp.invalidate();
        }
    }

    public final void fd(View view, RecyclerView recyclerViewVar) {
        yi yiVar = this.f4do;
        cyv cyvVar = (cyv) yiVar.c;
        int i = yiVar.b;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            yiVar.b = 1;
            yiVar.f = view;
            int iIndexOfChild = cyvVar.a.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((yh) yiVar.d).h(iIndexOfChild)) {
                    yiVar.ak(view);
                }
                cyvVar.l(iIndexOfChild);
            }
            yiVar.b = 0;
            yiVar.f = null;
            recyclerViewVar.p(view);
        } catch (Throwable th) {
            yiVar.b = 0;
            yiVar.f = null;
            throw th;
        }
    }

    public final void fe(int i) {
        if (er(i) != null) {
            yi yiVar = this.f4do;
            cyv cyvVar = (cyv) yiVar.c;
            int i2 = yiVar.b;
            if (i2 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iZ = yiVar.z(i);
                View childAt = cyvVar.a.getChildAt(iZ);
                if (childAt != null) {
                    yiVar.b = 1;
                    yiVar.f = childAt;
                    if (((yh) yiVar.d).h(iZ)) {
                        yiVar.ak(childAt);
                    }
                    cyvVar.l(iZ);
                }
            } finally {
                yiVar.b = 0;
                yiVar.f = null;
            }
        }
    }

    public final void ff() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void fg(androidx.recyclerview.widget.RecyclerView recyclerView) {
        fh(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final void fh(int i, int i2) {
        this.eb = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.dz = mode;
        if (mode == 0 && !androidx.recyclerview.widget.RecyclerView.f) {
            this.eb = 0;
        }
        this.ec = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.ea = mode2;
        if (mode2 != 0 || androidx.recyclerview.widget.RecyclerView.f) {
            return;
        }
        this.ec = 0;
    }

    public final void fi(int i, int i2) {
        int iEs = es();
        if (iEs == 0) {
            this.dp.da(i, i2);
            return;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < iEs; i7++) {
            View viewEr = er(i7);
            Rect rect = this.dp.t;
            _h(viewEr, rect);
            int i8 = rect.left;
            if (i8 < i6) {
                i6 = i8;
            }
            int i9 = rect.right;
            if (i9 > i3) {
                i3 = i9;
            }
            int i10 = rect.top;
            if (i10 < i4) {
                i4 = i10;
            }
            int i11 = rect.bottom;
            if (i11 > i5) {
                i5 = i11;
            }
        }
        this.dp.t.set(i6, i4, i3, i5);
        aj(this.dp.t, i, i2);
    }

    public final void fj(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.dp = null;
            this.f4do = null;
            this.eb = 0;
            this.ec = 0;
        } else {
            this.dp = recyclerView;
            this.f4do = recyclerView.p;
            this.eb = recyclerView.getWidth();
            this.ec = recyclerView.getHeight();
        }
        this.dz = 1073741824;
        this.ea = 1073741824;
    }

    public final boolean fk(View view, int i, int i2, czh czhVar) {
        return (!view.isLayoutRequested() && this.dv && en(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) czhVar).width) && en(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) czhVar).height)) ? false : true;
    }

    public final boolean fl(View view, int i, int i2, czh czhVar) {
        return (this.dv && en(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) czhVar).width) && en(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) czhVar).height)) ? false : true;
    }

    public final void fm(bvl bvlVar) {
        bvl bvlVar2 = this.ds;
        if (bvlVar2 != null && bvlVar != bvlVar2 && bvlVar2.j) {
            bvlVar2.z();
        }
        this.ds = bvlVar;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        czw czwVar = recyclerView.bl;
        czwVar.g.removeCallbacks(czwVar);
        czwVar.c.abortAnimation();
        if (bvlVar.m) {
            Log.w("RecyclerView", "An instance of " + bvlVar.getClass().getSimpleName() + " was started more than once. Each instance of" + bvlVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        bvlVar.g = recyclerView;
        bvlVar.h = this;
        int i = bvlVar.f;
        if (i == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.bo.a = i;
        bvlVar.j = true;
        bvlVar.i = true;
        bvlVar.k = recyclerView.x.ca(i);
        bvlVar.g.bl.i();
        bvlVar.m = true;
    }

    public boolean m(czh czhVar) {
        return czhVar != null;
    }

    public int n(czt cztVar) {
        return 0;
    }

    public int o(czt cztVar) {
        return 0;
    }

    public int p(czt cztVar) {
        return 0;
    }

    public int q(czt cztVar) {
        return 0;
    }

    public abstract czh r();

    public czh s(Context context, AttributeSet attributeSet) {
        return new czh(context, attributeSet);
    }

    public czh t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof czh ? new czh((czh) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new czh((ViewGroup.MarginLayoutParams) layoutParams) : new czh(layoutParams);
    }

    public int u(RecyclerView recyclerViewVar, czt cztVar) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView == null || recyclerView.w == null || !bu()) {
            return 1;
        }
        return this.dp.w.d();
    }

    public int v(RecyclerView recyclerViewVar, czt cztVar) {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.dp;
        if (recyclerView == null || recyclerView.w == null || !bv()) {
            return 1;
        }
        return this.dp.w.d();
    }

    public View w(View view, int i, RecyclerView recyclerViewVar, czt cztVar) {
        return null;
    }

    public void x(RecyclerView recyclerViewVar, czt cztVar, bd bdVar) {
        if (this.dp.canScrollVertically(-1) || this.dp.canScrollHorizontally(-1)) {
            bdVar.d(8192);
            bdVar.m(true);
            bdVar.j(67108864, true);
        }
        if (this.dp.canScrollVertically(1) || this.dp.canScrollHorizontally(1)) {
            bdVar.d(4096);
            bdVar.m(true);
            bdVar.j(67108864, true);
        }
        bdVar.a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) LateinitProperty.f(v(recyclerViewVar, cztVar), u(recyclerViewVar, cztVar), 0).e);
    }

    public void y(RecyclerView recyclerViewVar, czt cztVar, View view, bd bdVar) {
        bdVar.l(LateinitProperty.g(bv() ? el(view) : 0, 1, bu() ? el(view) : 0, 1, false));
    }

    public void z(int i, int i2) {
    }
}
