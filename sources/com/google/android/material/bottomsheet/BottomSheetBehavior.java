package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.agu;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.ap;
import me.hd.wauxv.obf.aq;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bpt;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxc;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.ek;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.era;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.jh;
import me.hd.wauxv.obf.no;
import me.hd.wauxv.obf.qd;
import me.hd.wauxv.obf.qe;
import me.hd.wauxv.obf.qf;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends agr {
    public final int a;
    public int aa;
    public final boolean ab;
    public final boolean ac;
    public final boolean ad;
    public final boolean ae;
    public final boolean af;
    public final boolean ag;
    public final boolean ah;
    public final boolean ai;
    public int aj;
    public int ak;
    public final boolean al;
    public final dgm am;
    public boolean an;
    public final qf ao;
    public final ValueAnimator ap;
    public final int aq;
    public int ar;
    public int as;
    public final float at;
    public int au;
    public final float av;
    public boolean aw;
    public boolean ax;
    public final boolean ay;
    public int az;
    public era ba;
    public boolean bb;
    public int bc;
    public boolean bd;
    public final float be;
    public int bf;
    public int bg;
    public int bh;
    public WeakReference bi;
    public WeakReference bj;
    public final ArrayList bk;
    public VelocityTracker bl;
    public int bm;
    public int bn;
    public boolean bo;
    public HashMap bp;
    public final SparseIntArray bq;
    public final qd br;
    public boolean f;
    public final float g;
    public final int h;
    public int q;
    public boolean r;
    public int s;
    public final int v;
    public final cau w;
    public final ColorStateList x;
    public final int y;
    public final int z;

    public BottomSheetBehavior() {
        this.a = 0;
        this.f = true;
        this.y = -1;
        this.z = -1;
        this.ao = new qf(this);
        this.at = 0.5f;
        this.av = -1.0f;
        this.ay = true;
        this.az = 4;
        this.be = 0.1f;
        this.bk = new ArrayList();
        this.bn = -1;
        this.bq = new SparseIntArray();
        this.br = new qd(this, 0);
    }

    public static View bs(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = eqz.a;
        if (eqq.locateDex(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewBs = bs(viewGroup.getChildAt(i));
            if (viewBs != null) {
                return viewBs;
            }
        }
        return null;
    }

    public static int bt(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    @Override // me.hd.wauxv.obf.agr
    public final void bu(agu aguVar) {
        this.bi = null;
        this.ba = null;
    }

    @Override // me.hd.wauxv.obf.agr
    public final void bv() {
        this.bi = null;
        this.ba = null;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean bw(View view) {
        WeakReference weakReference = this.bj;
        return (weakReference == null || view != weakReference.get() || this.az == 3) ? false : true;
    }

    public final void bx() {
        int iBz = bz();
        if (this.f) {
            this.au = Math.max(this.bh - iBz, this.ar);
        } else {
            this.au = this.bh - iBz;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0044 */
    public final float by() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        float f;
        float f2 = 0.0f;
        if (this.w != null && (weakReference = this.bi) != null && weakReference.get() != null
                && Build.VERSION.SDK_INT >= 31) {
            View view = (View) this.bi.get();
            if (cd() && (rootWindowInsets = view.getRootWindowInsets()) != null) {
                float fDv = this.w.dv();
                RoundedCorner roundedCorner = rootWindowInsets.getRoundedCorner(0);
                if (roundedCorner != null) {
                    float radius = roundedCorner.getRadius();
                    f = (radius <= 0.0f || fDv <= 0.0f) ? 0.0f : radius / fDv;
                }
                cau cauVar = this.w;
                float fB = cauVar.ct.b.f.b(cauVar.du());
                RoundedCorner roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                if (roundedCorner2 != null) {
                    float radius2 = roundedCorner2.getRadius();
                    if (radius2 > 0.0f && fB > 0.0f) {
                        f2 = radius2 / fB;
                    }
                }
                return Math.max(f, f2);
            }
        }
        return 0.0f;
    }

    public final int bz() {
        int i;
        return this.r ? Math.min(Math.max(this.s, this.bh - ((this.bg * 9) / 16)), this.bf) + this.aj
                : (this.ab || this.ac || (i = this.aa) <= 0) ? this.q + this.aj : Math.max(this.q, i + this.v);
    }

    public final void ca(int i) {
        if (((View) this.bi.get()) != null) {
            ArrayList arrayList = this.bk;
            if (arrayList.isEmpty()) {
                return;
            }
            int i2 = this.au;
            if (i <= i2 && i2 != cb()) {
                cb();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final int cb() {
        if (this.f) {
            return this.ar;
        }
        return Math.max(this.aq, this.af ? 0 : this.ak);
    }

    public final int cc(int i) {
        if (i == 3) {
            return cb();
        }
        if (i == 4) {
            return this.au;
        }
        if (i == 5) {
            return this.bh;
        }
        if (i == 6) {
            return this.as;
        }
        throw new IllegalArgumentException(concatVar2Var1(i, "Invalid state to get top offset: "));
    }

    public final boolean cd() {
        WeakReference weakReference = this.bi;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.bi.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void ce(int i) {
        if (i == -1) {
            if (this.r) {
                return;
            } else {
                this.r = true;
            }
        } else {
            if (!this.r && this.q == i) {
                return;
            }
            this.r = false;
            this.q = Math.max(0, i);
        }
        cm();
    }

    public final void cf(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(yg.o(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING",
                    " should not be set externally."));
        }
        if (!this.aw && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.f && cc(i) <= this.ar) ? 3 : i;
        WeakReference weakReference = this.bi;
        if (weakReference == null || weakReference.get() == null) {
            cg(i);
            return;
        }
        View view = (View) this.bi.get();
        jh jhVar = new jh(this, view, i2);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = eqz.a;
            if (view.isAttachedToWindow()) {
                view.post(jhVar);
                return;
            }
        }
        jhVar.run();
    }

    public final void cg(int i) {
        if (this.az == i) {
            return;
        }
        this.az = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z = this.aw;
        }
        WeakReference weakReference = this.bi;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            cl(true);
        } else if (i == 6 || i == 5 || i == 4) {
            cl(false);
        }
        ck(i, true);
        ArrayList arrayList = this.bk;
        if (arrayList.size() <= 0) {
            cj();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean ch(View view, float f) {
        if (this.ax) {
            return true;
        }
        if (view.getTop() < this.au) {
            return false;
        }
        return Math.abs(((f * this.be) + ((float) view.getTop())) - ((float) this.au)) / ((float) bz()) > 0.5f;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
     * 
     * if (r3 != false) goto L16;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
     * 
     * cg(2);
     * ck(r4, true);
     * r2.ao.f(r4);
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
     * 
     * return;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
     * 
     * if (r1.ak(r3.getLeft(), r0) != false) goto L16;
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final void ci(android.view.View r3, int r4, boolean r5) {
        /*
         * r2 = this;
         * int r0 = r2.cc(r4)
         * me.hd.wauxv.obf.era r1 = r2.ba
         * if (r1 == 0) goto L40
         * if (r5 == 0) goto L15
         * int r3 = r3.getLeft()
         * boolean r3 = r1.ak(r3, r0)
         * if (r3 == 0) goto L40
         * goto L32
         * L15:
         * int r5 = r3.getLeft()
         * r1.s = r3
         * r3 = -1
         * r1.d = r3
         * r3 = 0
         * boolean r3 = r1.ad(r5, r0, r3, r3)
         * if (r3 != 0) goto L30
         * int r5 = r1.b
         * if (r5 != 0) goto L30
         * android.view.View r5 = r1.s
         * if (r5 == 0) goto L30
         * r5 = 0
         * r1.s = r5
         * L30:
         * if (r3 == 0) goto L40
         * L32:
         * r3 = 2
         * r2.cg(r3)
         * r3 = 1
         * r2.ck(r4, r3)
         * me.hd.wauxv.obf.qf r3 = r2.ao
         * r3.f(r4)
         * return
         * L40:
         * r2.cg(r4)
         * return
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.ci(android.view.View, int, boolean):void");
    }

    public final void cj() {
        View view;
        int iP;
        WeakReference weakReference = this.bi;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        eqz.p(view, Opcodes.ASM8);
        eqz.n(view, 0);
        eqz.p(view, 262144);
        eqz.n(view, 0);
        eqz.p(view, 1048576);
        eqz.n(view, 0);
        SparseIntArray sparseIntArray = this.bq;
        int i = sparseIntArray.get(0, -1);
        if (i != -1) {
            eqz.p(view, i);
            eqz.n(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f && this.az != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            ek ekVar = new ek(this, i, 2);
            ArrayList arrayListL = eqz.l(view);
            int i2 = 0;
            while (true) {
                if (i2 >= arrayListL.size()) {
                    int i3 = 0;
                    int i4 = -1;
                    while (true) {
                        int[] iArr = eqz.d;
                        if (i3 >= 32 || i4 != -1) {
                            break;
                        }
                        int i5 = iArr[i3];
                        boolean z = true;
                        for (int i6 = 0; i6 < arrayListL.size(); i6++) {
                            z &= ((ax) arrayListL.get(i6)).p() != i5;
                        }
                        if (z) {
                            i4 = i5;
                        }
                        i3++;
                    }
                    iP = i4;
                    break;
                }
                if (TextUtils.equals(string,
                        ((AccessibilityNodeInfo.AccessibilityAction) ((ax) arrayListL.get(i2)).l).getLabel())) {
                    iP = ((ax) arrayListL.get(i2)).p();
                    break;
                }
                i2++;
            }
            if (iP != -1) {
                ax axVar = new ax(null, iP, string, ekVar, null);
                View.AccessibilityDelegate accessibilityDelegateJ = eqz.j(view);
                aq aqVar = accessibilityDelegateJ == null ? null
                        : accessibilityDelegateJ instanceof ap ? ((ap) accessibilityDelegateJ).a
                                : new aq(accessibilityDelegateJ);
                if (aqVar == null) {
                    aqVar = new aq();
                }
                eqz.s(view, aqVar);
                eqz.p(view, axVar.p());
                eqz.l(view).add(axVar);
                eqz.n(view, 0);
            }
            sparseIntArray.put(0, iP);
        }
        if (this.aw) {
            int i7 = 5;
            if (this.az != 5) {
                eqz.q(view, ax.f, new ek(this, i7, 2));
            }
        }
        int i8 = this.az;
        int i9 = 4;
        int i10 = 3;
        if (i8 == 3) {
            eqz.q(view, ax.e, new ek(this, this.f ? 4 : 6, 2));
            return;
        }
        if (i8 == 4) {
            eqz.q(view, ax.d, new ek(this, this.f ? 3 : 6, 2));
        } else {
            if (i8 != 6) {
                return;
            }
            eqz.q(view, ax.e, new ek(this, i9, 2));
            eqz.q(view, ax.d, new ek(this, i10, 2));
        }
    }

    public final void ck(int i, boolean z) {
        cau cauVar;
        if (i == 2) {
            return;
        }
        boolean z2 = this.az == 3 && (this.al || cd());
        if (this.an == z2 || (cauVar = this.w) == null) {
            return;
        }
        this.an = z2;
        ValueAnimator valueAnimator = this.ap;
        if (!z || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            cauVar.ea(this.an ? by() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(cauVar.ct.j, z2 ? by() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void cl(boolean z) {
        WeakReference weakReference = this.bi;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.bp != null) {
                    return;
                } else {
                    this.bp = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.bi.get() && z) {
                    this.bp.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.bp = null;
        }
    }

    public final void cm() {
        View view;
        if (this.bi != null) {
            bx();
            if (this.az != 4 || (view = (View) this.bi.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = eqz.a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.bi == null) {
            this.s = coordinatorLayout.getResources()
                    .getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z = (Build.VERSION.SDK_INT < 29 || this.ab || this.r) ? false : true;
            if (this.ac || this.ad || this.ae || this.ag || this.ah || this.ai || z) {
                ewz.af(view, new cxc(this, z));
            }
            eqz.u(view, new bpt(view));
            this.bi = new WeakReference(view);
            Context context = view.getContext();
            ajn.ae(context, R.attr.motionEasingStandardDecelerateInterpolator,
                    new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
            ajn.ad(context, R.attr.motionDurationMedium2, 300);
            ajn.ad(context, R.attr.motionDurationShort3, 150);
            ajn.ad(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            cau cauVar = this.w;
            if (cauVar != null) {
                view.setBackground(cauVar);
                float fE = this.av;
                if (fE == -1.0f) {
                    fE = eqq.e(view);
                }
                cauVar.dy(fE);
            } else {
                ColorStateList colorStateList = this.x;
                if (colorStateList != null) {
                    eqq.i(view, colorStateList);
                }
            }
            cj();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.ba == null) {
            this.ba = new era(coordinatorLayout.getContext(), coordinatorLayout, this.br);
        }
        int top = view.getTop();
        coordinatorLayout.ar(view, i);
        this.bg = coordinatorLayout.getWidth();
        this.bh = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.bf = height;
        int iMin = this.bh;
        int i2 = iMin - height;
        int i3 = this.ak;
        if (i2 < i3) {
            boolean z2 = this.af;
            int i4 = this.z;
            if (z2) {
                if (i4 != -1) {
                    iMin = Math.min(iMin, i4);
                }
                this.bf = iMin;
            } else {
                int iMin2 = iMin - i3;
                if (i4 != -1) {
                    iMin2 = Math.min(iMin2, i4);
                }
                this.bf = iMin2;
            }
        }
        this.ar = Math.max(0, this.bh - this.bf);
        this.as = (int) ((1.0f - this.at) * this.bh);
        bx();
        int i5 = this.az;
        if (i5 == 3) {
            view.offsetTopAndBottom(cb());
        } else if (i5 == 6) {
            view.offsetTopAndBottom(this.as);
        } else if (this.aw && i5 == 5) {
            view.offsetTopAndBottom(this.bh);
        } else if (i5 == 4) {
            view.offsetTopAndBottom(this.au);
        } else if (i5 == 1 || i5 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        ck(this.az, false);
        this.bj = new WeakReference(bs(view));
        ArrayList arrayList = this.bk;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(bt(i,
                coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin
                        + marginLayoutParams.rightMargin + i2,
                this.y, marginLayoutParams.width),
                bt(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop()
                        + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.z,
                        marginLayoutParams.height));
        return true;
    }

    @Override // me.hd.wauxv.obf.agr
    public final void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.bj;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i4 = top - i2;
        boolean z = this.ay;
        if (i2 > 0) {
            if (i4 < cb()) {
                int iCb = top - cb();
                iArr[1] = iCb;
                int i5 = -iCb;
                WeakHashMap weakHashMap = eqz.a;
                view.offsetTopAndBottom(i5);
                cg(3);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i2;
                WeakHashMap weakHashMap2 = eqz.a;
                view.offsetTopAndBottom(-i2);
                cg(1);
            }
        } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
            int i6 = this.au;
            if (i4 > i6 && !this.aw) {
                int i7 = top - i6;
                iArr[1] = i7;
                int i8 = -i7;
                WeakHashMap weakHashMap3 = eqz.a;
                view.offsetTopAndBottom(i8);
                cg(4);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i2;
                WeakHashMap weakHashMap4 = eqz.a;
                view.offsetTopAndBottom(-i2);
                cg(1);
            }
        }
        ca(view.getTop());
        this.bc = i2;
        this.bd = true;
    }

    @Override // me.hd.wauxv.obf.agr
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
    }

    @Override // me.hd.wauxv.obf.agr
    public final void m(View view, Parcelable parcelable) {
        qe qeVar = (qe) parcelable;
        int i = this.a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.q = qeVar.b;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f = qeVar.c;
            }
            if (i == -1 || (i & 4) == 4) {
                this.aw = qeVar.d;
            }
            if (i == -1 || (i & 8) == 8) {
                this.ax = qeVar.e;
            }
        }
        int i2 = qeVar.a;
        if (i2 == 1 || i2 == 2) {
            this.az = 4;
        } else {
            this.az = i2;
        }
    }

    @Override // me.hd.wauxv.obf.agr
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new qe(this);
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        this.bc = 0;
        this.bd = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Found duplicated region for block: B:30:0x0055 */
    /* JADX WARN: Found duplicated region for block: B:32:0x005a */
    /* JADX WARN: Found duplicated region for block: B:34:0x0062 */
    /* JADX WARN: Found duplicated region for block: B:37:0x0074 */
    /* JADX WARN: Found duplicated region for block: B:39:0x0078 */
    /* JADX WARN: Found duplicated region for block: B:42:0x0083 */
    /* JADX WARN: Found duplicated region for block: B:45:0x0093 */
    /* JADX WARN: Found duplicated region for block: B:47:0x0097 */
    /* JADX WARN: Found duplicated region for block: B:48:0x0099 */
    /* JADX WARN: Found duplicated region for block: B:50:0x00ae */
    @Override // me.hd.wauxv.obf.agr
    public final void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        int top;
        int top2;
        int i2;
        float yVelocity;
        int i3 = 3;
        if (view.getTop() == cb()) {
            cg(3);
            return;
        }
        WeakReference weakReference = this.bj;
        if (weakReference != null && view2 == weakReference.get() && this.bd) {
            if (this.bc > 0) {
                if (!this.f && view.getTop() > this.as) {
                    i3 = 6;
                }
            } else if (this.aw) {
                VelocityTracker velocityTracker = this.bl;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.g);
                    yVelocity = this.bl.getYVelocity(this.bm);
                }
                if (ch(view, yVelocity)) {
                    i3 = 5;
                } else if (this.bc == 0) {
                    top2 = view.getTop();
                    if (this.f) {
                        i2 = this.as;
                        if (top2 < i2) {
                            if (top2 >= Math.abs(top2 - this.au)) {
                            }
                        } else if (Math.abs(top2 - i2) < Math.abs(top2 - this.au)) {
                            i3 = 4;
                        }
                        i3 = 6;
                    } else if (Math.abs(top2 - this.ar) >= Math.abs(top2 - this.au)) {
                        i3 = 4;
                    }
                } else {
                    if (!this.f) {
                        top = view.getTop();
                        if (Math.abs(top - this.as) < Math.abs(top - this.au)) {
                            i3 = 6;
                        }
                    }
                    i3 = 4;
                }
            } else if (this.bc == 0) {
                top2 = view.getTop();
                if (this.f) {
                    i2 = this.as;
                    if (top2 < i2) {
                        if (top2 >= Math.abs(top2 - this.au)) {
                        }
                    } else if (Math.abs(top2 - i2) < Math.abs(top2 - this.au)) {
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (Math.abs(top2 - this.ar) >= Math.abs(top2 - this.au)) {
                    i3 = 4;
                }
            } else {
                if (!this.f) {
                    top = view.getTop();
                    if (Math.abs(top - this.as) < Math.abs(top - this.au)) {
                        i3 = 6;
                    }
                }
                i3 = 4;
            }
            ci(view, i3, false);
            this.bd = false;
        }
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        era eraVar;
        if (!view.isShown() || !this.ay) {
            this.bb = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.bm = -1;
            this.bn = -1;
            VelocityTracker velocityTracker = this.bl;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.bl = null;
            }
        }
        if (this.bl == null) {
            this.bl = VelocityTracker.obtain();
        }
        this.bl.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.bn = (int) motionEvent.getY();
            if (this.az != 2) {
                WeakReference weakReference = this.bj;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.ao(view2, x, this.bn)) {
                    this.bm = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.bo = true;
                }
            }
            this.bb = this.bm == -1 && !coordinatorLayout.ao(view, x, this.bn);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.bo = false;
            this.bm = -1;
            if (this.bb) {
                this.bb = false;
                return false;
            }
        }
        if (this.bb || (eraVar = this.ba) == null || !eraVar.al(motionEvent)) {
            WeakReference weakReference2 = this.bj;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.bb || this.az == 1
                    || coordinatorLayout.ao(view3, (int) motionEvent.getX(), (int) motionEvent.getY())
                    || this.ba == null || (i = this.bn) == -1 || Math.abs(i - motionEvent.getY()) <= this.ba.c) {
                return false;
            }
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean u(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.az;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        era eraVar = this.ba;
        if (eraVar != null && (this.ay || i == 1)) {
            eraVar.af(motionEvent);
        }
        if (actionMasked == 0) {
            this.bm = -1;
            this.bn = -1;
            VelocityTracker velocityTracker = this.bl;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.bl = null;
            }
        }
        if (this.bl == null) {
            this.bl = VelocityTracker.obtain();
        }
        this.bl.addMovement(motionEvent);
        if (this.ba != null && ((this.ay || this.az == 1) && actionMasked == 2 && !this.bb)) {
            float fAbs = Math.abs(this.bn - motionEvent.getY());
            era eraVar2 = this.ba;
            if (fAbs > eraVar2.c) {
                eraVar2.x(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.bb;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        this.a = 0;
        this.f = true;
        this.y = -1;
        this.z = -1;
        this.ao = new qf(this);
        this.at = 0.5f;
        this.av = -1.0f;
        this.ay = true;
        this.az = 4;
        this.be = 0.1f;
        this.bk = new ArrayList();
        this.bn = -1;
        this.bq = new SparseIntArray();
        this.br = new qd(this, 0);
        this.v = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.e);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.x = cnb.v(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            this.am = dgm.n(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal)
                    .m();
        }
        dgm dgmVar = this.am;
        if (dgmVar != null) {
            cau cauVar = new cau(dgmVar);
            this.w = cauVar;
            cauVar.dx(context);
            ColorStateList colorStateList = this.x;
            if (colorStateList != null) {
                this.w.dz(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.w.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(by(), 1.0f);
        this.ap = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.ap.addUpdateListener(new no(this, 1));
        this.av = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            ce(i);
        } else {
            ce(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(8, false);
        if (this.aw != z) {
            this.aw = z;
            if (!z && this.az == 5) {
                cf(4);
            }
            cj();
        }
        this.ab = typedArrayObtainStyledAttributes.getBoolean(13, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.f != z2) {
            this.f = z2;
            if (this.bi != null) {
                bx();
            }
            cg((this.f && this.az == 6) ? 3 : this.az);
            ck(this.az, true);
            cj();
        }
        this.ax = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.ay = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.a = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.at = f;
            if (this.bi != null) {
                this.as = (int) ((1.0f - f) * this.bh);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i2 = typedValuePeekValue2.data;
                if (i2 >= 0) {
                    this.aq = i2;
                    ck(this.az, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.aq = dimensionPixelOffset;
                    ck(this.az, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.h = typedArrayObtainStyledAttributes.getInt(11, 500);
            this.ac = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.ad = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.ae = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.af = typedArrayObtainStyledAttributes.getBoolean(20, true);
            this.ag = typedArrayObtainStyledAttributes.getBoolean(14, false);
            this.ah = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.ai = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.al = typedArrayObtainStyledAttributes.getBoolean(23, true);
            typedArrayObtainStyledAttributes.recycle();
            this.g = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
