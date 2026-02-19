package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.agu;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.buc;
import me.hd.wauxv.obf.bux;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dgl;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.dhp;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.era;
import me.hd.wauxv.obf.StaticAndroidHelpers;
import me.hd.wauxv.obf.o;
import me.hd.wauxv.obf.qd;
import me.hd.wauxv.obf.qf;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends agr {
    public int aa;
    public int ab;
    public int ac;
    public int ad;
    public WeakReference ae;
    public WeakReference af;
    public final int ag;
    public VelocityTracker ah;
    public int ai;
    public final LinkedHashSet aj;
    public final qd ak;
    public StaticAndroidHelpers f;
    public final cau g;
    public final ColorStateList h;
    public final dgm q;
    public final qf r;
    public final float s;
    public final boolean v;
    public int w;
    public era x;
    public boolean y;
    public final float z;

    public SideSheetBehavior() {
        this.r = new qf(this);
        this.v = true;
        this.w = 5;
        this.z = 0.1f;
        this.ag = -1;
        this.aj = new LinkedHashSet();
        this.ak = new qd(this, 1);
    }

    public final void al(int i) {
        View view;
        if (this.w == i) {
            return;
        }
        this.w = i;
        WeakReference weakReference = this.ae;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = this.w == 5 ? 4 : 0;
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        Iterator it = this.aj.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
        ao();
    }

    public final boolean am() {
        if (this.x != null) {
            return this.v || this.w == 1;
        }
        return false;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
     * 
     * if (r1.ak(r0, r3.getTop()) != false) goto L24;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
     * 
     * if (r3 != false) goto L24;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
     * 
     * al(2);
     * r2.r.f(r4);
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
     * 
     * return;
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final void an(android.view.View r3, int r4, boolean r5) {
        /*
         * r2 = this;
         * r0 = 3
         * if (r4 == r0) goto L19
         * r0 = 5
         * if (r4 != r0) goto Ld
         * me.hd.wauxv.obf.ewz r0 = r2.f
         * int r0 = r0.f()
         * goto L1f
         * Ld:
         * java.lang.IllegalArgumentException r3 = new
         * java.lang.IllegalArgumentException
         * java.lang.String r5 = "Invalid state to get outer edge offset: "
         * java.lang.String r4 = me.hd.wauxv.obf.concatVar2Var1(r4, r5)
         * r3.<init>(r4)
         * throw r3
         * L19:
         * me.hd.wauxv.obf.ewz r0 = r2.f
         * int r0 = r0.e()
         * L1f:
         * me.hd.wauxv.obf.era r1 = r2.x
         * if (r1 == 0) goto L57
         * if (r5 == 0) goto L30
         * int r3 = r3.getTop()
         * boolean r3 = r1.ak(r0, r3)
         * if (r3 == 0) goto L57
         * goto L4d
         * L30:
         * int r5 = r3.getTop()
         * r1.s = r3
         * r3 = -1
         * r1.d = r3
         * r3 = 0
         * boolean r3 = r1.ad(r0, r5, r3, r3)
         * if (r3 != 0) goto L4b
         * int r5 = r1.b
         * if (r5 != 0) goto L4b
         * android.view.View r5 = r1.s
         * if (r5 == 0) goto L4b
         * r5 = 0
         * r1.s = r5
         * L4b:
         * if (r3 == 0) goto L57
         * L4d:
         * r3 = 2
         * r2.al(r3)
         * me.hd.wauxv.obf.qf r3 = r2.r
         * r3.f(r4)
         * return
         * L57:
         * r2.al(r4)
         * return
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.an(android.view.View, int, boolean):void");
    }

    public final void ao() {
        View view;
        WeakReference weakReference = this.ae;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.p(view, 262144);
        ViewCompat.notifyAccessibilityChange(view, 0);
        ViewCompat.p(view, 1048576);
        ViewCompat.notifyAccessibilityChange(view, 0);
        int i = 5;
        if (this.w != 5) {
            ViewCompat.q(view, ax.f, new bux(this, i));
        }
        int i2 = 3;
        if (this.w != 3) {
            ViewCompat.q(view, ax.d, new bux(this, i2));
        }
    }

    @Override // me.hd.wauxv.obf.agr
    public final void bu(agu aguVar) {
        this.ae = null;
        this.x = null;
    }

    @Override // me.hd.wauxv.obf.agr
    public final void bv() {
        this.ae = null;
        this.x = null;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int i2;
        View viewFindViewById;
        WeakHashMap weakHashMap = ViewCompat.a;
        int i3 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.ae;
        cau cauVar = this.g;
        int i4 = 0;
        if (weakReference == null) {
            this.ae = new WeakReference(view);
            Context context = view.getContext();
            ajn.ae(context, R.attr.motionEasingStandardDecelerateInterpolator,
                    new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
            ajn.ad(context, R.attr.motionDurationMedium2, 300);
            ajn.ad(context, R.attr.motionDurationShort3, 150);
            ajn.ad(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (cauVar != null) {
                view.setBackground(cauVar);
                float fE = this.s;
                if (fE == -1.0f) {
                    fE = eqq.e(view);
                }
                cauVar.dy(fE);
            } else {
                ColorStateList colorStateList = this.h;
                if (colorStateList != null) {
                    eqq.i(view, colorStateList);
                }
            }
            int i5 = this.w == 5 ? 4 : 0;
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            ao();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (ViewCompat.k(view) == null) {
                ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i6 = Gravity.getAbsoluteGravity(((agu) view.getLayoutParams()).c, i) == 3 ? 1 : 0;
        StaticAndroidHelpers ewzVar = this.f;
        if (ewzVar == null || ewzVar.k() != i6) {
            agu aguVar = null;
            dgm dgmVar = this.q;
            if (i6 == 0) {
                this.f = new buc(this, i3);
                if (dgmVar != null) {
                    WeakReference weakReference2 = this.ae;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null
                            && (view3.getLayoutParams() instanceof agu)) {
                        aguVar = (agu) view3.getLayoutParams();
                    }
                    if (aguVar == null || ((ViewGroup.MarginLayoutParams) aguVar).rightMargin <= 0) {
                        dgl dglVarQ = dgmVar.q();
                        dglVarQ.f = new o(0.0f);
                        dglVarQ.g = new o(0.0f);
                        dgm dgmVarM = dglVarQ.m();
                        if (cauVar != null) {
                            cauVar.setShapeAppearanceModel(dgmVarM);
                        }
                    }
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalArgumentException(
                            yg.f(i6, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f = new buc(this, i4);
                if (dgmVar != null) {
                    WeakReference weakReference3 = this.ae;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null
                            && (view2.getLayoutParams() instanceof agu)) {
                        aguVar = (agu) view2.getLayoutParams();
                    }
                    if (aguVar == null || ((ViewGroup.MarginLayoutParams) aguVar).leftMargin <= 0) {
                        dgl dglVarQ2 = dgmVar.q();
                        dglVarQ2.e = new o(0.0f);
                        dglVarQ2.h = new o(0.0f);
                        dgm dgmVarM2 = dglVarQ2.m();
                        if (cauVar != null) {
                            cauVar.setShapeAppearanceModel(dgmVarM2);
                        }
                    }
                }
            }
        }
        if (this.x == null) {
            this.x = new era(coordinatorLayout.getContext(), coordinatorLayout, this.ak);
        }
        int i7 = this.f.i(view);
        coordinatorLayout.ar(view, i);
        this.ab = coordinatorLayout.getWidth();
        this.ac = this.f.j(coordinatorLayout);
        this.aa = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.ad = marginLayoutParams != null ? this.f.c(marginLayoutParams) : 0;
        int i8 = this.w;
        if (i8 == 1 || i8 == 2) {
            i4 = i7 - this.f.i(view);
        } else if (i8 != 3) {
            if (i8 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.w);
            }
            i4 = this.f.f();
        }
        view.offsetLeftAndRight(i4);
        if (this.af == null && (i2 = this.ag) != -1
                && (viewFindViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.af = new WeakReference(viewFindViewById);
        }
        Iterator it = this.aj.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean j(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(
                ViewGroup.getChildMeasureSpec(i,
                        coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft()
                                + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2,
                        marginLayoutParams.width),
                ViewGroup.getChildMeasureSpec(i3,
                        coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop()
                                + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin,
                        marginLayoutParams.height));
        return true;
    }

    @Override // me.hd.wauxv.obf.agr
    public final void m(View view, Parcelable parcelable) {
        int i = ((dhp) parcelable).a;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.w = i;
    }

    @Override // me.hd.wauxv.obf.agr
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new dhp(this);
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        era eraVar;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && ViewCompat.k(view) == null) || !this.v) {
            this.y = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.ah) != null) {
            velocityTracker.recycle();
            this.ah = null;
        }
        if (this.ah == null) {
            this.ah = VelocityTracker.obtain();
        }
        this.ah.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.ai = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.y) {
            this.y = false;
            return false;
        }
        return (this.y || (eraVar = this.x) == null || !eraVar.al(motionEvent)) ? false : true;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean u(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.w == 1 && actionMasked == 0) {
            return true;
        }
        if (am()) {
            this.x.af(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.ah) != null) {
            velocityTracker.recycle();
            this.ah = null;
        }
        if (this.ah == null) {
            this.ah = VelocityTracker.obtain();
        }
        this.ah.addMovement(motionEvent);
        if (am() && actionMasked == 2 && !this.y && am()) {
            float fAbs = Math.abs(this.ai - motionEvent.getX());
            era eraVar = this.x;
            if (fAbs > eraVar.c) {
                eraVar.x(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.y;
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.r = new qf(this);
        this.v = true;
        this.w = 5;
        this.z = 0.1f;
        this.ag = -1;
        this.aj = new LinkedHashSet();
        this.ak = new qd(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.ak);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.h = cnb.v(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.q = dgm.n(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).m();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.ag = resourceId;
            WeakReference weakReference = this.af;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.af = null;
            WeakReference weakReference2 = this.ae;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = ViewCompat.a;
                    if (view.isLaidOut()) {
                        view.requestLayout();
                    }
                }
            }
        }
        dgm dgmVar = this.q;
        if (dgmVar != null) {
            cau cauVar = new cau(dgmVar);
            this.g = cauVar;
            cauVar.dx(context);
            ColorStateList colorStateList = this.h;
            if (colorStateList != null) {
                this.g.dz(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.g.setTint(typedValue.data);
            }
        }
        this.s = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.v = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
