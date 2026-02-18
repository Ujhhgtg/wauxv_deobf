package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.umeng.analytics.pro.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.aba;
import me.hd.wauxv.obf.akx;
import me.hd.wauxv.obf.ann;
import me.hd.wauxv.obf.atb;
import me.hd.wauxv.obf.ayj;
import me.hd.wauxv.obf.bez;
import me.hd.wauxv.obf.bgv;
import me.hd.wauxv.obf.bpq;
import me.hd.wauxv.obf.bqv;
import me.hd.wauxv.obf.but;
import me.hd.wauxv.obf.bvl;
import me.hd.wauxv.obf.byc;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cjn;
import me.hd.wauxv.obf.ckr;
import me.hd.wauxv.obf.cks;
import me.hd.wauxv.obf.cnd;
import me.hd.wauxv.obf.csi;
import me.hd.wauxv.obf.csj;
import me.hd.wauxv.obf.cuu;
import me.hd.wauxv.obf.cxq;
import me.hd.wauxv.obf.cyu;
import me.hd.wauxv.obf.cyv;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.cza;
import me.hd.wauxv.obf.czb;
import me.hd.wauxv.obf.czc;
import me.hd.wauxv.obf.czd;
import me.hd.wauxv.obf.czg;
import me.hd.wauxv.obf.czh;
import me.hd.wauxv.obf.czi;
import me.hd.wauxv.obf.czj;
import me.hd.wauxv.obf.czk;
import me.hd.wauxv.obf.czl;
import me.hd.wauxv.obf.czm;
import me.hd.wauxv.obf.czn;
import me.hd.wauxv.obf.czo;
import me.hd.wauxv.obf.czp;
import me.hd.wauxv.obf.czq;
import me.hd.wauxv.obf.czs;
import me.hd.wauxv.obf.czt;
import me.hd.wauxv.obf.czu;
import me.hd.wauxv.obf.czv;
import me.hd.wauxv.obf.czw;
import me.hd.wauxv.obf.czx;
import me.hd.wauxv.obf.czz;
import me.hd.wauxv.obf.dhq;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dz;
import me.hd.wauxv.obf.ea;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.eqt;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.erf;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.yg;
import me.hd.wauxv.obf.yh;
import me.hd.wauxv.obf.yi;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ckr {
    public static boolean a;
    public static boolean b;
    public static final int[] c = {R.attr.nestedScrollingEnabled};
    public static final float e = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean f = true;
    public static final boolean g = true;
    public static final Class[] h;
    public static final bqv i;
    public static final czu j;
    public final ArrayList aa;
    public czk ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public int af;
    public boolean ag;
    public boolean ah;
    public boolean ai;
    public int aj;
    public boolean ak;
    public final AccessibilityManager al;
    public ArrayList am;
    public boolean an;
    public boolean ao;
    public int ap;
    public int aq;
    public czb ar;
    public EdgeEffect as;
    public EdgeEffect at;
    public EdgeEffect au;
    public EdgeEffect av;
    public czc aw;
    public int ax;
    public int ay;
    public VelocityTracker az;
    public int ba;
    public int bb;
    public int bc;
    public int bd;
    public int be;
    public czj bf;
    public final int bg;
    public final int bh;
    public final float bi;
    public final float bj;
    public boolean bk;
    public final czw bl;
    public bgv bm;
    public final bpq bn;
    public final czt bo;
    public czl bp;
    public ArrayList bq;
    public boolean br;
    public boolean bs;
    public final cyv bt;
    public boolean bu;
    public czz bv;
    public final int[] bw;
    public cks bx;
    public final int[] by;
    public final int[] bz;
    public final int[] ca;
    public final ArrayList cb;
    public final cyu cc;
    public boolean cd;
    public int ce;
    public int cf;
    public final boolean cg;
    public final cyv ch;
    public final ann ci;
    public final float k;
    public final bez l;
    public final czo m;
    public czq n;
    public final ea o;
    public final yi p;
    public final but q;
    public boolean r;
    public final cyu s;
    public final Rect t;
    public final Rect u;
    public final RectF v;
    public cyw w;
    public czg x;
    public final ArrayList y;
    public final ArrayList z;

    static {
        Class cls = Integer.TYPE;
        h = new Class[]{Context.class, AttributeSet.class, cls, cls};
        i = new bqv(2);
        j = new czu();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, me.hd.wauxv.R.attr.recyclerViewStyle);
    }

    public static void cp(czx czxVar) {
        WeakReference weakReference = czxVar.e;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == czxVar.d) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            czxVar.e = null;
        }
    }

    public static int cq(int i2, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i3) {
        if (i2 > 0 && edgeEffect != null && cnd.at(edgeEffect) != 0.0f) {
            int iRound = Math.round(cnd.bb(edgeEffect, ((-i2) * 4.0f) / i3, 0.5f) * ((-i3) / 4.0f));
            if (iRound != i2) {
                edgeEffect.finish();
            }
            return i2 - iRound;
        }
        if (i2 >= 0 || edgeEffect2 == null || cnd.at(edgeEffect2) == 0.0f) {
            return i2;
        }
        float f2 = i3;
        int iRound2 = Math.round(cnd.bb(edgeEffect2, (i2 * 4.0f) / f2, 0.5f) * (f2 / 4.0f));
        if (iRound2 != i2) {
            edgeEffect2.finish();
        }
        return i2 - iRound2;
    }

    public static RecyclerView cr(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewCr = cr(viewGroup.getChildAt(i2));
            if (recyclerViewCr != null) {
                return recyclerViewCr;
            }
        }
        return null;
    }

    public static czx cs(View view) {
        if (view == null) {
            return null;
        }
        return ((czh) view.getLayoutParams()).c;
    }

    private cks getScrollingChildHelper() {
        if (this.bx == null) {
            this.bx = new cks(this);
        }
        return this.bx;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        a = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        b = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        czg czgVar = this.x;
        if (czgVar != null) {
            czgVar.getClass();
        }
        super.addFocusables(arrayList, i2, i3);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof czh) && this.x.m((czh) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        czg czgVar = this.x;
        if (czgVar != null && czgVar.bu()) {
            return this.x.by(this.bo);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        czg czgVar = this.x;
        if (czgVar != null && czgVar.bu()) {
            return this.x.n(this.bo);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        czg czgVar = this.x;
        if (czgVar != null && czgVar.bu()) {
            return this.x.o(this.bo);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        czg czgVar = this.x;
        if (czgVar != null && czgVar.bv()) {
            return this.x.bz(this.bo);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        czg czgVar = this.x;
        if (czgVar != null && czgVar.bv()) {
            return this.x.p(this.bo);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        czg czgVar = this.x;
        if (czgVar != null && czgVar.bv()) {
            return this.x.q(this.bo);
        }
        return 0;
    }

    public final void ct(czx czxVar) {
        View view = czxVar.d;
        boolean z = view.getParent() == this;
        this.m.t(dv(view));
        if (czxVar.ah()) {
            this.p.j(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.p.h(view, -1, true);
            return;
        }
        yi yiVar = this.p;
        int iIndexOfChild = ((cyv) yiVar.c).a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((yh) yiVar.d).j(iIndexOfChild);
            yiVar.ac(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void cu(czd czdVar) {
        czg czgVar = this.x;
        if (czgVar != null) {
            czgVar.bt("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.z;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(czdVar);
        ea();
        requestLayout();
    }

    public final void cv(czl czlVar) {
        if (this.bq == null) {
            this.bq = new ArrayList();
        }
        this.bq.add(czlVar);
    }

    public final void cw(String str) {
        if (dy()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(yg.i(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.aq > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(yg.i(this, new StringBuilder(""))));
        }
    }

    public final void cx() {
        int iAb = this.p.ab();
        for (int i2 = 0; i2 < iAb; i2++) {
            czx czxVarCs = cs(this.p.aa(i2));
            if (!czxVarCs.am()) {
                czxVarCs.g = -1;
                czxVarCs.j = -1;
            }
        }
        czo czoVar = this.m;
        ArrayList arrayList = czoVar.a;
        ArrayList arrayList2 = czoVar.c;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            czx czxVar = (czx) arrayList2.get(i3);
            czxVar.g = -1;
            czxVar.j = -1;
        }
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            czx czxVar2 = (czx) arrayList.get(i4);
            czxVar2.g = -1;
            czxVar2.j = -1;
        }
        ArrayList arrayList3 = czoVar.b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                czx czxVar3 = (czx) czoVar.b.get(i5);
                czxVar3.g = -1;
                czxVar3.j = -1;
            }
        }
    }

    public final void cy(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.as;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.as.onRelease();
            zIsFinished = this.as.isFinished();
        }
        EdgeEffect edgeEffect2 = this.au;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.au.onRelease();
            zIsFinished |= this.au.isFinished();
        }
        EdgeEffect edgeEffect3 = this.at;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.at.onRelease();
            zIsFinished |= this.at.isFinished();
        }
        EdgeEffect edgeEffect4 = this.av;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.av.onRelease();
            zIsFinished |= this.av.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public final void cz() {
        if (!this.ae || this.an) {
            Trace.beginSection("RV FullInvalidate");
            dc();
            Trace.endSection();
            return;
        }
        if (this.o.s()) {
            ea eaVar = this.o;
            int i2 = eaVar.a;
            if ((i2 & 4) == 0 || (i2 & 11) != 0) {
                if (eaVar.s()) {
                    Trace.beginSection("RV FullInvalidate");
                    dc();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            eu();
            ec();
            this.o.y();
            if (!this.ag) {
                int iY = this.p.y();
                for (int i3 = 0; i3 < iY; i3++) {
                    czx czxVarCs = cs(this.p.x(i3));
                    if (czxVarCs != null && !czxVarCs.am() && czxVarCs.ai()) {
                        dc();
                    }
                }
                this.o.j();
            }
            ew(true);
            ed(true);
            Trace.endSection();
        }
    }

    public final void da(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = eqz.a;
        setMeasuredDimension(czg.ed(i2, paddingRight, getMinimumWidth()), czg.ed(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public final void db(View view) {
        czx czxVarCs = cs(view);
        cyw cywVar = this.w;
        if (cywVar != null && czxVarCs != null) {
            cywVar.n(czxVarCs);
        }
        ArrayList arrayList = this.am;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((czi) this.am.get(size)).ae(view);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:166:0x034a  */
    /* JADX WARN: Found duplicated region for block: B:185:0x0390  */
    /* JADX WARN: Found duplicated region for block: B:187:0x0393  */
    /* JADX WARN: Found duplicated region for block: B:193:0x03aa  */
    /* JADX WARN: Found duplicated region for block: B:195:0x03b2  */
    /* JADX WARN: Found duplicated region for block: B:197:0x03b6  */
    /* JADX WARN: Found duplicated region for block: B:200:0x03be  */
    /* JADX WARN: Found duplicated region for block: B:203:0x03c5  */
    /* JADX WARN: Found duplicated region for block: B:206:0x03cf A[LOOP:4: B:199:0x03bc->B:206:0x03cf, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:209:0x03dc  */
    /* JADX WARN: Found duplicated region for block: B:212:0x03e3  */
    /* JADX WARN: Found duplicated region for block: B:215:0x03ed A[LOOP:5: B:208:0x03da->B:215:0x03ed, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:217:0x03f2  */
    /* JADX WARN: Found duplicated region for block: B:247:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:248:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:249:0x03cd A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:251:0x03f0 A[EDGE_INSN: B:251:0x03f0->B:216:0x03f0 BREAK  A[LOOP:5: B:208:0x03da->B:215:0x03ed], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:252:0x03eb A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    public final void dc() {
        boolean z;
        long j2;
        czx czxVar;
        int i2;
        int iP;
        int i3;
        int iMin;
        czx czxVarDr;
        View view;
        czx czxVarDr2;
        View view2;
        int i4;
        View viewFindViewById;
        View view3;
        boolean z2;
        cjn cjnVar;
        ?? r3;
        RecyclerView recyclerView;
        boolean zS;
        boolean z3;
        if (this.w == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.x == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        czt cztVar = this.bo;
        boolean z4 = false;
        cztVar.i = false;
        boolean z5 = true;
        boolean z6 = this.cd && !(this.ce == getWidth() && this.cf == getHeight());
        this.ce = 0;
        this.cf = 0;
        this.cd = false;
        if (cztVar.d == 1) {
            dd();
            this.x.fg(this);
            de();
        } else {
            ea eaVar = this.o;
            if ((((ArrayList) eaVar.d).isEmpty() || ((ArrayList) eaVar.c).isEmpty()) && !z6 && this.x.eb == getWidth() && this.x.ec == getHeight()) {
                this.x.fg(this);
            } else {
                this.x.fg(this);
                de();
            }
        }
        cztVar.o(4);
        eu();
        ec();
        cztVar.d = 1;
        boolean z7 = cztVar.j;
        czo czoVar = this.m;
        but butVar = this.q;
        if (z7) {
            int iY = this.p.y() - 1;
            while (iY >= 0) {
                czx czxVarCs = cs(this.p.x(iY));
                if (czxVarCs.am()) {
                    z3 = z5;
                } else {
                    long jDu = du(czxVarCs);
                    this.aw.getClass();
                    cjn cjnVar2 = new cjn();
                    cjnVar2.c(czxVarCs);
                    byc bycVar = (byc) butVar.c;
                    dhq dhqVar = (dhq) butVar.b;
                    czx czxVar2 = (czx) bycVar.f(jDu);
                    if (czxVar2 == null || czxVar2.am()) {
                        z3 = z5;
                        butVar.e(czxVarCs, cjnVar2);
                    } else {
                        z3 = z5;
                        erf erfVar = (erf) dhqVar.get(czxVar2);
                        boolean z8 = (erfVar == null || (erfVar.b & 1) == 0) ? false : z3;
                        erf erfVar2 = (erf) dhqVar.get(czxVarCs);
                        boolean z9 = (erfVar2 == null || (erfVar2.b & 1) == 0) ? false : z3;
                        if (z8 && czxVar2 == czxVarCs) {
                            butVar.e(czxVarCs, cjnVar2);
                        } else {
                            cjn cjnVarAc = butVar.ac(czxVar2, 4);
                            butVar.e(czxVarCs, cjnVar2);
                            cjn cjnVarAc2 = butVar.ac(czxVarCs, 8);
                            if (cjnVarAc == null) {
                                int iY2 = this.p.y();
                                for (int i5 = 0; i5 < iY2; i5++) {
                                    czx czxVarCs2 = cs(this.p.x(i5));
                                    if (czxVarCs2 != czxVarCs && du(czxVarCs2) == jDu) {
                                        cyw cywVar = this.w;
                                        if (cywVar == null || !cywVar.ad) {
                                            StringBuilder sb = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                            sb.append(czxVarCs2);
                                            sb.append(" \n View Holder 2:");
                                            sb.append(czxVarCs);
                                            throw new IllegalStateException(yg.i(this, sb));
                                        }
                                        StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                        sb2.append(czxVarCs2);
                                        sb2.append(" \n View Holder 2:");
                                        sb2.append(czxVarCs);
                                        throw new IllegalStateException(yg.i(this, sb2));
                                    }
                                }
                                Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + czxVar2 + " cannot be found but it is necessary for " + czxVarCs + dm());
                            } else {
                                czxVar2.al(false);
                                if (z8) {
                                    ct(czxVar2);
                                }
                                if (czxVar2 != czxVarCs) {
                                    if (z9) {
                                        ct(czxVarCs);
                                    }
                                    czxVar2.k = czxVarCs;
                                    ct(czxVar2);
                                    czoVar.t(czxVar2);
                                    czxVarCs.al(false);
                                    czxVarCs.l = czxVar2;
                                }
                                if (this.aw.o(czxVar2, czxVarCs, cjnVarAc, cjnVarAc2)) {
                                    ef();
                                }
                            }
                        }
                    }
                }
                iY--;
                z5 = z3;
            }
            z = z5;
            dhq dhqVar2 = (dhq) butVar.b;
            int i6 = dhqVar2.l - 1;
            while (i6 >= 0) {
                czx czxVar3 = (czx) dhqVar2.r(i6);
                erf erfVar3 = (erf) dhqVar2.h(i6);
                int i7 = erfVar3.b;
                int i8 = i7 & 3;
                cyv cyvVar = this.ch;
                if (i8 == 3) {
                    RecyclerView recyclerView2 = cyvVar.a;
                    recyclerView2.x.fd(czxVar3.d, recyclerView2.m);
                    r3 = z4;
                } else if ((i7 & 1) != 0) {
                    cjn cjnVar3 = erfVar3.c;
                    if (cjnVar3 == null) {
                        RecyclerView recyclerView3 = cyvVar.a;
                        recyclerView3.x.fd(czxVar3.d, recyclerView3.m);
                        r3 = z4;
                    } else {
                        cyvVar.k(czxVar3, cjnVar3, erfVar3.d);
                        r3 = z4;
                    }
                } else if ((i7 & 14) == 14) {
                    cyvVar.j(czxVar3, erfVar3.c, erfVar3.d);
                    r3 = z4;
                } else {
                    if ((i7 & 12) == 12) {
                        cjn cjnVar4 = erfVar3.c;
                        cjn cjnVar5 = erfVar3.d;
                        cyvVar.getClass();
                        czxVar3.al(z4);
                        RecyclerView recyclerView4 = cyvVar.a;
                        if (!recyclerView4.an) {
                            akx akxVar = (akx) recyclerView4.aw;
                            akxVar.getClass();
                            int i9 = cjnVar4.a;
                            int i10 = cjnVar5.a;
                            if (i9 == i10 && cjnVar4.b == cjnVar5.b) {
                                akxVar.ae(czxVar3);
                                recyclerView = recyclerView4;
                                zS = false;
                            } else {
                                recyclerView = recyclerView4;
                                zS = akxVar.s(czxVar3, i9, cjnVar4.b, i10, cjnVar5.b);
                            }
                            if (zS) {
                                recyclerView.ef();
                            }
                        } else if (recyclerView4.aw.o(czxVar3, czxVar3, cjnVar4, cjnVar5)) {
                            recyclerView4.ef();
                        }
                        r3 = 0;
                    } else {
                        if ((i7 & 4) != 0) {
                            cjnVar = null;
                            cyvVar.k(czxVar3, erfVar3.c, null);
                        } else {
                            cjnVar = null;
                            if ((i7 & 8) != 0) {
                                cyvVar.j(czxVar3, erfVar3.c, erfVar3.d);
                            }
                        }
                        r3 = 0;
                    }
                    erfVar3.b = r3;
                    erfVar3.c = cjnVar;
                    erfVar3.d = cjnVar;
                    erf.a.l(erfVar3);
                    i6--;
                    z4 = false;
                }
                cjnVar = null;
                erfVar3.b = r3;
                erfVar3.c = cjnVar;
                erfVar3.d = cjnVar;
                erf.a.l(erfVar3);
                i6--;
                z4 = false;
            }
        } else {
            z = true;
        }
        View view4 = null;
        this.x.fc(czoVar);
        cztVar.b = cztVar.e;
        this.an = false;
        this.ao = false;
        cztVar.j = false;
        cztVar.k = false;
        this.x.dt = false;
        ArrayList arrayList = czoVar.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        czg czgVar = this.x;
        if (czgVar.dy) {
            czgVar.dx = 0;
            czgVar.dy = false;
            czoVar.u();
        }
        this.x.af(cztVar);
        boolean z10 = z;
        ed(z10);
        ew(false);
        ((dhq) butVar.b).clear();
        ((byc) butVar.c).e();
        int[] iArr = this.bw;
        int i11 = iArr[0];
        int i12 = iArr[z10 ? 1 : 0];
        dq(iArr);
        if ((iArr[0] == i11 && iArr[z10 ? 1 : 0] == i12) ? false : true) {
            dh(0, 0);
        }
        if (this.bk && this.w != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (isFocused()) {
                j2 = cztVar.m;
                czxVar = j2 == -1 ? null : null;
                if (czxVar != null) {
                    view3 = czxVar.d;
                    if (!((ArrayList) this.p.e).contains(view3)) {
                        if (this.p.y() > 0) {
                            int i13 = cztVar.l;
                            if (i13 != -1) {
                            }
                            iP = cztVar.p();
                            i3 = i2;
                            while (true) {
                                if (i3 < iP) {
                                    czxVarDr2 = dr(i3);
                                    if (czxVarDr2 != null) {
                                        view2 = czxVarDr2.d;
                                        if (view2.hasFocusable()) {
                                            view4 = view2;
                                        } else {
                                            i3++;
                                        }
                                    }
                                }
                                for (iMin = Math.min(iP, i2) - 1; iMin >= 0; iMin--) {
                                    czxVarDr = dr(iMin);
                                    if (czxVarDr == null) {
                                        break;
                                        break;
                                    }
                                    view = czxVarDr.d;
                                    if (view.hasFocusable()) {
                                        view4 = view;
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (this.p.y() > 0) {
                        int i132 = cztVar.l;
                        if (i132 != -1) {
                        }
                        iP = cztVar.p();
                        i3 = i2;
                        while (true) {
                            if (i3 < iP) {
                                czxVarDr2 = dr(i3);
                                if (czxVarDr2 != null) {
                                    view2 = czxVarDr2.d;
                                    if (view2.hasFocusable()) {
                                        view4 = view2;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                czxVarDr = dr(iMin);
                                if (czxVarDr == null) {
                                    break;
                                    break;
                                }
                                view = czxVarDr.d;
                                if (view.hasFocusable()) {
                                    view4 = view;
                                    break;
                                }
                            }
                        }
                    }
                } else if (this.p.y() > 0) {
                    int i1322 = cztVar.l;
                    if (i1322 != -1) {
                    }
                    iP = cztVar.p();
                    i3 = i2;
                    while (true) {
                        if (i3 < iP) {
                            czxVarDr2 = dr(i3);
                            if (czxVarDr2 != null) {
                                view2 = czxVarDr2.d;
                                if (view2.hasFocusable()) {
                                    view4 = view2;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            czxVarDr = dr(iMin);
                            if (czxVarDr == null) {
                                break;
                                break;
                            }
                            view = czxVarDr.d;
                            if (view.hasFocusable()) {
                                view4 = view;
                                break;
                            }
                        }
                    }
                }
                if (view4 != null) {
                    i4 = cztVar.n;
                    if (i4 != -1) {
                        view4 = viewFindViewById;
                    }
                    view4.requestFocus();
                }
            } else if (((ArrayList) this.p.e).contains(getFocusedChild())) {
                j2 = cztVar.m;
                if (j2 == -1 && (z2 = this.w.ad) && z2) {
                    int iAb = this.p.ab();
                    czxVar = null;
                    for (int i14 = 0; i14 < iAb; i14++) {
                        czx czxVarCs3 = cs(this.p.aa(i14));
                        if (czxVarCs3 != null && !czxVarCs3.af() && czxVarCs3.h == j2) {
                            if (!((ArrayList) this.p.e).contains(czxVarCs3.d)) {
                                czxVar = czxVarCs3;
                                break;
                            }
                            czxVar = czxVarCs3;
                        }
                    }
                }
                if (czxVar != null) {
                    view3 = czxVar.d;
                    if (!((ArrayList) this.p.e).contains(view3) && view3.hasFocusable()) {
                        view4 = view3;
                    } else if (this.p.y() > 0) {
                        int i13222 = cztVar.l;
                        i2 = i13222 != -1 ? i13222 : 0;
                        iP = cztVar.p();
                        i3 = i2;
                        while (true) {
                            if (i3 < iP) {
                                czxVarDr2 = dr(i3);
                                if (czxVarDr2 != null) {
                                    view2 = czxVarDr2.d;
                                    if (view2.hasFocusable()) {
                                        view4 = view2;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            while (iMin >= 0) {
                                czxVarDr = dr(iMin);
                                if (czxVarDr == null) {
                                    break;
                                }
                                view = czxVarDr.d;
                                if (view.hasFocusable()) {
                                    view4 = view;
                                    break;
                                }
                            }
                        }
                    }
                } else if (this.p.y() > 0) {
                    int i132222 = cztVar.l;
                    if (i132222 != -1) {
                    }
                    iP = cztVar.p();
                    i3 = i2;
                    while (true) {
                        if (i3 < iP) {
                            czxVarDr2 = dr(i3);
                            if (czxVarDr2 != null) {
                                view2 = czxVarDr2.d;
                                if (view2.hasFocusable()) {
                                    view4 = view2;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        while (iMin >= 0) {
                            czxVarDr = dr(iMin);
                            if (czxVarDr == null) {
                                break;
                                break;
                            }
                            view = czxVarDr.d;
                            if (view.hasFocusable()) {
                                view4 = view;
                                break;
                            }
                        }
                    }
                }
                if (view4 != null) {
                    i4 = cztVar.n;
                    if (i4 != -1 && (viewFindViewById = view4.findViewById(i4)) != null && viewFindViewById.isFocusable()) {
                        view4 = viewFindViewById;
                    }
                    view4.requestFocus();
                }
            }
        }
        cztVar.m = -1L;
        cztVar.l = -1;
        cztVar.n = -1;
    }

    public final void dd() {
        erf erfVar;
        View viewM0do;
        czt cztVar = this.bo;
        cztVar.o(1);
        dn(cztVar);
        cztVar.i = false;
        eu();
        but butVar = this.q;
        dhq dhqVar = (dhq) butVar.b;
        dhq dhqVar2 = (dhq) butVar.b;
        dhqVar.clear();
        byc bycVar = (byc) butVar.c;
        bycVar.e();
        ec();
        eg();
        czx czxVarDv = null;
        View focusedChild = (this.bk && hasFocus() && this.w != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewM0do = m0do(focusedChild)) != null) {
            czxVarDv = dv(viewM0do);
        }
        if (czxVarDv == null) {
            cztVar.m = -1L;
            cztVar.l = -1;
            cztVar.n = -1;
        } else {
            cztVar.m = this.w.ad ? czxVarDv.h : -1L;
            cztVar.l = this.an ? -1 : czxVarDv.af() ? czxVarDv.g : czxVarDv.x();
            View focusedChild2 = czxVarDv.d;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            cztVar.n = id;
        }
        cztVar.h = cztVar.j && this.bs;
        this.bs = false;
        this.br = false;
        cztVar.g = cztVar.k;
        cztVar.e = this.w.d();
        dq(this.bw);
        if (cztVar.j) {
            int iY = this.p.y();
            for (int i2 = 0; i2 < iY; i2++) {
                czx czxVarCs = cs(this.p.x(i2));
                if (!czxVarCs.am() && (!czxVarCs.ad() || this.w.ad)) {
                    czc czcVar = this.aw;
                    czc.ad(czxVarCs);
                    czxVarCs.aa();
                    czcVar.getClass();
                    cjn cjnVar = new cjn();
                    cjnVar.c(czxVarCs);
                    erf erfVarE = (erf) dhqVar2.get(czxVarCs);
                    if (erfVarE == null) {
                        erfVarE = erf.e();
                        dhqVar2.put(czxVarCs, erfVarE);
                    }
                    erfVarE.c = cjnVar;
                    erfVarE.b |= 4;
                    if (cztVar.h && czxVarCs.ai() && !czxVarCs.af() && !czxVarCs.am() && !czxVarCs.ad()) {
                        bycVar.i(czxVarCs, du(czxVarCs));
                    }
                }
            }
        }
        if (cztVar.k) {
            int iAb = this.p.ab();
            for (int i3 = 0; i3 < iAb; i3++) {
                czx czxVarCs2 = cs(this.p.aa(i3));
                if (a && czxVarCs2.f == -1 && !czxVarCs2.af()) {
                    throw new IllegalStateException(yg.i(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
                }
                if (!czxVarCs2.am() && czxVarCs2.g == -1) {
                    czxVarCs2.g = czxVarCs2.f;
                }
            }
            boolean z = cztVar.f;
            cztVar.f = false;
            this.x.ae(this.m, cztVar);
            cztVar.f = z;
            for (int i4 = 0; i4 < this.p.y(); i4++) {
                czx czxVarCs3 = cs(this.p.x(i4));
                if (!czxVarCs3.am() && ((erfVar = (erf) dhqVar2.get(czxVarCs3)) == null || (erfVar.b & 4) == 0)) {
                    czc.ad(czxVarCs3);
                    boolean z2 = (czxVarCs3.m & 8192) != 0;
                    czc czcVar2 = this.aw;
                    czxVarCs3.aa();
                    czcVar2.getClass();
                    cjn cjnVar2 = new cjn();
                    cjnVar2.c(czxVarCs3);
                    if (z2) {
                        ei(czxVarCs3, cjnVar2);
                    } else {
                        erf erfVarE2 = (erf) dhqVar2.get(czxVarCs3);
                        if (erfVarE2 == null) {
                            erfVarE2 = erf.e();
                            dhqVar2.put(czxVarCs3, erfVarE2);
                        }
                        erfVarE2.b |= 2;
                        erfVarE2.c = cjnVar2;
                    }
                }
            }
            cx();
        } else {
            cx();
        }
        ed(true);
        ew(false);
        cztVar.d = 2;
    }

    public final void de() {
        eu();
        ec();
        czt cztVar = this.bo;
        cztVar.o(6);
        this.o.k();
        cztVar.e = this.w.d();
        cztVar.c = 0;
        if (this.n != null) {
            cyw cywVar = this.w;
            int iAe = dkz.ae(cywVar.ae);
            if (iAe == 1 ? cywVar.d() > 0 : iAe != 2) {
                Parcelable parcelable = this.n.a;
                if (parcelable != null) {
                    this.x.cf(parcelable);
                }
                this.n = null;
            }
        }
        cztVar.g = false;
        this.x.ae(this.m, cztVar);
        cztVar.f = false;
        cztVar.j = cztVar.j && this.aw != null;
        cztVar.d = 4;
        ed(true);
        ew(false);
    }

    public final boolean df(int[] iArr, int i2, int i3, int i4, int[] iArr2) {
        return getScrollingChildHelper().h(iArr, i2, i3, i4, iArr2);
    }

    public final void dg(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().i(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public final void dh(int i2, int i3) {
        this.aq++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        czl czlVar = this.bp;
        if (czlVar != null) {
            czlVar.b(this, i2, i3);
        }
        ArrayList arrayList = this.bq;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((czl) this.bq.get(size)).b(this, i2, i3);
            }
        }
        this.aq--;
    }

    public final void di() {
        if (this.av != null) {
            return;
        }
        ((czu) this.ar).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.av = edgeEffect;
        if (this.r) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        czg layoutManager = getLayoutManager();
        int iD = 0;
        if (layoutManager != null) {
            if (layoutManager.bv()) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 92 || keyCode == 93) {
                    int measuredHeight = getMeasuredHeight();
                    if (keyCode == 93) {
                        es(0, measuredHeight, false);
                        return true;
                    }
                    es(0, -measuredHeight, false);
                    return true;
                }
                if (keyCode == 122 || keyCode == 123) {
                    boolean zCc = layoutManager.cc();
                    if (keyCode == 122) {
                        if (zCc) {
                            iD = getAdapter().d();
                        }
                    } else if (!zCc) {
                        iD = getAdapter().d();
                    }
                    et(iD);
                    return true;
                }
            } else if (layoutManager.bu()) {
                int keyCode2 = keyEvent.getKeyCode();
                if (keyCode2 == 92 || keyCode2 == 93) {
                    int measuredWidth = getMeasuredWidth();
                    if (keyCode2 == 93) {
                        es(measuredWidth, 0, false);
                        return true;
                    }
                    es(-measuredWidth, 0, false);
                    return true;
                }
                if (keyCode2 == 122 || keyCode2 == 123) {
                    boolean zCc2 = layoutManager.cc();
                    if (keyCode2 == 122) {
                        if (zCc2) {
                            iD = getAdapter().d();
                        }
                    } else if (!zCc2) {
                        iD = getAdapter().d();
                    }
                    et(iD);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().f(f2, f3, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().g(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().h(iArr, i2, i3, 0, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().i(i2, i3, i4, i5, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public final void dj() {
        if (this.as != null) {
            return;
        }
        ((czu) this.ar).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.as = edgeEffect;
        if (this.r) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void dk() {
        if (this.au != null) {
            return;
        }
        ((czu) this.ar).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.au = edgeEffect;
        if (this.r) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void dl() {
        if (this.at != null) {
            return;
        }
        ((czu) this.ar).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.at = edgeEffect;
        if (this.r) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String dm() {
        return " " + super.toString() + ", adapter:" + this.w + ", layout:" + this.x + ", context:" + getContext();
    }

    public final void dn(czt cztVar) {
        if (getScrollState() != 2) {
            cztVar.getClass();
            return;
        }
        OverScroller overScroller = this.bl.c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        cztVar.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final View m0do(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean dp(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.aa;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            czk czkVar = (czk) arrayList.get(i2);
            if (czkVar.ah(motionEvent) && action != 3) {
                this.ab = czkVar;
                return true;
            }
        }
        return false;
    }

    public final void dq(int[] iArr) {
        int iY = this.p.y();
        if (iY == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iY; i4++) {
            czx czxVarCs = cs(this.p.x(i4));
            if (!czxVarCs.am()) {
                int iZ = czxVarCs.z();
                if (iZ < i2) {
                    i2 = iZ;
                }
                if (iZ > i3) {
                    i3 = iZ;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public final czx dr(int i2) {
        czx czxVar = null;
        if (this.an) {
            return null;
        }
        int iAb = this.p.ab();
        for (int i3 = 0; i3 < iAb; i3++) {
            czx czxVarCs = cs(this.p.aa(i3));
            if (czxVarCs != null && !czxVarCs.af() && dt(czxVarCs) == i2) {
                if (!((ArrayList) this.p.e).contains(czxVarCs.d)) {
                    return czxVarCs;
                }
                czxVar = czxVarCs;
            }
        }
        return czxVar;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.z;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((czd) arrayList.get(i2)).c(canvas, this);
        }
        EdgeEffect edgeEffect = this.as;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.r ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.as;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.at;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.r) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.at;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.au;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.r ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.au;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.av;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.r) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.av;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.aw == null || arrayList.size() <= 0 || !this.aw.r()) ? z : true) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Found duplicated region for block: B:165:0x021d  */
    /* JADX WARN: Found duplicated region for block: B:43:0x0087  */
    /* JADX WARN: Found duplicated region for block: B:61:0x00c9  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean ds(int i2, int i3, int i4, int i5) {
        int iMax;
        int i6;
        boolean z;
        boolean z2;
        boolean z3;
        int minFlingVelocity;
        boolean z4;
        int iEl;
        PointF pointFBs;
        int i7;
        czg czgVar = this.x;
        if (czgVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (!this.ah) {
            boolean zBu = czgVar.bu();
            boolean zBv = this.x.bv();
            int i8 = (!zBu || Math.abs(i2) < i4) ? 0 : i2;
            int iMax2 = (!zBv || Math.abs(i3) < i4) ? 0 : i3;
            if (i8 != 0 || iMax2 != 0) {
                if (i8 == 0) {
                    iMax = 0;
                } else {
                    EdgeEffect edgeEffect = this.as;
                    if (edgeEffect == null || cnd.at(edgeEffect) == 0.0f) {
                        EdgeEffect edgeEffect2 = this.au;
                        if (edgeEffect2 == null || cnd.at(edgeEffect2) == 0.0f) {
                            iMax = 0;
                        } else if (er(this.au, i8, getWidth())) {
                            this.au.onAbsorb(i8);
                            i8 = 0;
                        }
                    } else {
                        int i9 = -i8;
                        if (er(this.as, i9, getWidth())) {
                            this.as.onAbsorb(i9);
                            i8 = 0;
                        }
                    }
                    iMax = i8;
                    i8 = 0;
                }
                if (iMax2 == 0) {
                    i6 = iMax2;
                    iMax2 = 0;
                } else {
                    EdgeEffect edgeEffect3 = this.at;
                    if (edgeEffect3 == null || cnd.at(edgeEffect3) == 0.0f) {
                        EdgeEffect edgeEffect4 = this.av;
                        if (edgeEffect4 == null || cnd.at(edgeEffect4) == 0.0f) {
                            i6 = iMax2;
                            iMax2 = 0;
                        } else if (er(this.av, iMax2, getHeight())) {
                            this.av.onAbsorb(iMax2);
                            iMax2 = 0;
                        }
                    } else {
                        int i10 = -iMax2;
                        if (er(this.at, i10, getHeight())) {
                            this.at.onAbsorb(i10);
                            iMax2 = 0;
                        }
                    }
                    i6 = 0;
                }
                czw czwVar = this.bl;
                if (iMax != 0 || iMax2 != 0) {
                    int i11 = -i5;
                    iMax = Math.max(i11, Math.min(iMax, i5));
                    iMax2 = Math.max(i11, Math.min(iMax2, i5));
                    ev(1);
                    czwVar.h(iMax, iMax2);
                }
                if (i8 != 0 || i6 != 0) {
                    float f2 = i8;
                    float f3 = i6;
                    if (!dispatchNestedPreFling(f2, f3)) {
                        boolean z5 = zBu || zBv;
                        dispatchNestedFling(f2, f3, z5);
                        czj czjVar = this.bf;
                        if (czjVar != null) {
                            csj csjVar = (csj) czjVar;
                            czg layoutManager = csjVar.a.getLayoutManager();
                            if (layoutManager == 0 || csjVar.a.getAdapter() == null || ((Math.abs(i6) <= (minFlingVelocity = csjVar.a.getMinFlingVelocity()) && Math.abs(i8) <= minFlingVelocity) || !((z4 = layoutManager instanceof czs)))) {
                                z = z5;
                                z2 = false;
                                z3 = true;
                            } else {
                                View view = null;
                                csi csiVar = !z4 ? null : new csi(csjVar, csjVar.a.getContext());
                                if (csiVar == null) {
                                    z = z5;
                                    z2 = false;
                                    z3 = true;
                                } else {
                                    int iEt = layoutManager.et();
                                    if (iEt != 0) {
                                        atb atbVarK = layoutManager.bv() ? csjVar.k(layoutManager) : layoutManager.bu() ? csjVar.j(layoutManager) : null;
                                        if (atbVarK == null) {
                                            z = z5;
                                            z2 = false;
                                            z3 = true;
                                        } else {
                                            z2 = false;
                                            int iEs = layoutManager.es();
                                            z3 = true;
                                            int i12 = 0;
                                            int i13 = Integer.MIN_VALUE;
                                            int i14 = Integer.MAX_VALUE;
                                            View view2 = null;
                                            while (i12 < iEs) {
                                                boolean z6 = z5;
                                                View viewEr = layoutManager.er(i12);
                                                if (viewEr == null) {
                                                    i7 = iEs;
                                                } else {
                                                    i7 = iEs;
                                                    int iE = csj.e(viewEr, atbVarK);
                                                    if (iE <= 0 && iE > i13) {
                                                        view2 = viewEr;
                                                        i13 = iE;
                                                    }
                                                    if (iE >= 0 && iE < i14) {
                                                        view = viewEr;
                                                        i14 = iE;
                                                    }
                                                }
                                                i12++;
                                                z5 = z6;
                                                iEs = i7;
                                            }
                                            z = z5;
                                            Object[] objArr = !layoutManager.bu() ? i6 <= 0 : i8 <= 0;
                                            if (objArr == true && view != null) {
                                                iEl = czg.el(view);
                                            } else if (objArr == true || view2 == null) {
                                                if (objArr != false) {
                                                    view = view2;
                                                }
                                                if (view != null) {
                                                    iEl = ((z4 && (pointFBs = ((czs) layoutManager).bs(layoutManager.et() + (-1))) != null && ((pointFBs.x > 0.0f ? 1 : (pointFBs.x == 0.0f ? 0 : -1)) < 0 || (pointFBs.y > 0.0f ? 1 : (pointFBs.y == 0.0f ? 0 : -1)) < 0)) == objArr ? -1 : 1) + czg.el(view);
                                                    if (iEl < 0 || iEl >= iEt) {
                                                    }
                                                }
                                            } else {
                                                iEl = czg.el(view2);
                                            }
                                        }
                                        iEl = -1;
                                    } else {
                                        z = z5;
                                        z2 = false;
                                        z3 = true;
                                        iEl = -1;
                                    }
                                    if (iEl != -1) {
                                        csiVar.f = iEl;
                                        layoutManager.fm(csiVar);
                                        return z3;
                                    }
                                }
                            }
                        } else {
                            z = z5;
                            z2 = false;
                            z3 = true;
                        }
                        if (!z) {
                            return z2;
                        }
                        boolean z7 = z3;
                        ev(z7 ? 1 : 0);
                        int i15 = -i5;
                        czwVar.h(Math.max(i15, Math.min(i8, i5)), Math.max(i15, Math.min(i6, i5)));
                        return z7;
                    }
                } else if (iMax != 0 || iMax2 != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int dt(czx czxVar) {
        if ((czxVar.m & 524) == 0 && czxVar.ac()) {
            int i2 = czxVar.f;
            ArrayList arrayList = (ArrayList) this.o.c;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                dz dzVar = (dz) arrayList.get(i3);
                int i4 = dzVar.a;
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = dzVar.b;
                        if (i5 <= i2) {
                            int i6 = dzVar.c;
                            if (i5 + i6 <= i2) {
                                i2 -= i6;
                            }
                        } else {
                            continue;
                        }
                    } else if (i4 == 8) {
                        int i7 = dzVar.b;
                        if (i7 == i2) {
                            i2 = dzVar.c;
                        } else {
                            if (i7 < i2) {
                                i2--;
                            }
                            if (dzVar.c <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (dzVar.b <= i2) {
                    i2 += dzVar.c;
                }
            }
            return i2;
        }
        return -1;
    }

    public final long du(czx czxVar) {
        return this.w.ad ? czxVar.h : czxVar.f;
    }

    public final czx dv(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return cs(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect dw(View view) {
        czh czhVar = (czh) view.getLayoutParams();
        boolean z = czhVar.e;
        Rect rect = czhVar.d;
        if (z) {
            czt cztVar = this.bo;
            if (!cztVar.g || (!czhVar.c.ai() && !czhVar.c.ad())) {
                rect.set(0, 0, 0, 0);
                ArrayList arrayList = this.z;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Rect rect2 = this.t;
                    rect2.set(0, 0, 0, 0);
                    ((czd) arrayList.get(i2))._bj(rect2, view, this, cztVar);
                    rect.left += rect2.left;
                    rect.top += rect2.top;
                    rect.right += rect2.right;
                    rect.bottom += rect2.bottom;
                }
                czhVar.e = false;
                return rect;
            }
        }
        return rect;
    }

    public final boolean dx() {
        return !this.ae || this.an || this.o.s();
    }

    public final boolean dy() {
        return this.ap > 0;
    }

    public final void dz(int i2) {
        if (this.x == null) {
            return;
        }
        setScrollState(2);
        this.x.ch(i2);
        awakenScrollBars();
    }

    public final void ea() {
        int iAb = this.p.ab();
        for (int i2 = 0; i2 < iAb; i2++) {
            ((czh) this.p.aa(i2).getLayoutParams()).e = true;
        }
        ArrayList arrayList = this.m.c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            czh czhVar = (czh) ((czx) arrayList.get(i3)).d.getLayoutParams();
            if (czhVar != null) {
                czhVar.e = true;
            }
        }
    }

    public final void eb(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int iAb = this.p.ab();
        for (int i5 = 0; i5 < iAb; i5++) {
            czx czxVarCs = cs(this.p.aa(i5));
            if (czxVarCs != null && !czxVarCs.am()) {
                int i6 = czxVarCs.f;
                czt cztVar = this.bo;
                if (i6 >= i4) {
                    if (b) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + czxVarCs + " now at position " + (czxVarCs.f - i3));
                    }
                    czxVarCs.aj(-i3, z);
                    cztVar.f = true;
                } else if (i6 >= i2) {
                    if (b) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + czxVarCs + " now REMOVED");
                    }
                    czxVarCs.w(8);
                    czxVarCs.aj(-i3, z);
                    czxVarCs.f = i2 - 1;
                    cztVar.f = true;
                }
            }
        }
        czo czoVar = this.m;
        ArrayList arrayList = czoVar.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            czx czxVar = (czx) arrayList.get(size);
            if (czxVar != null) {
                int i7 = czxVar.f;
                if (i7 >= i4) {
                    if (b) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + czxVar + " now at position " + (czxVar.f - i3));
                    }
                    czxVar.aj(-i3, z);
                } else if (i7 >= i2) {
                    czxVar.w(8);
                    czoVar.o(size);
                }
            }
        }
        requestLayout();
    }

    public final void ec() {
        this.ap++;
    }

    public final void ed(boolean z) {
        int i2;
        AccessibilityManager accessibilityManager;
        int i3 = this.ap - 1;
        this.ap = i3;
        if (i3 < 1) {
            if (a && i3 < 0) {
                throw new IllegalStateException(yg.i(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.ap = 0;
            if (z) {
                int i4 = this.aj;
                this.aj = 0;
                if (i4 != 0 && (accessibilityManager = this.al) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i4);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.cb;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    czx czxVar = (czx) arrayList.get(size);
                    if (czxVar.d.getParent() == this && !czxVar.am() && (i2 = czxVar.t) != -1) {
                        czxVar.d.setImportantForAccessibility(i2);
                        czxVar.t = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void ee(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ay) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ay = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.bc = x;
            this.ba = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.bd = y;
            this.bb = y;
        }
    }

    public final void ef() {
        if (this.bu || !this.ac) {
            return;
        }
        WeakHashMap weakHashMap = eqz.a;
        postOnAnimation(this.cc);
        this.bu = true;
    }

    public final void eg() {
        boolean z;
        boolean z2 = false;
        if (this.an) {
            ea eaVar = this.o;
            eaVar.z((ArrayList) eaVar.c);
            eaVar.z((ArrayList) eaVar.d);
            eaVar.a = 0;
            if (this.ao) {
                this.x.aa();
            }
        }
        if (this.aw == null || !this.x.ak()) {
            this.o.k();
        } else {
            this.o.y();
        }
        boolean z3 = this.br || this.bs;
        boolean z4 = this.ae && this.aw != null && ((z = this.an) || z3 || this.x.dt) && (!z || this.w.ad);
        czt cztVar = this.bo;
        cztVar.j = z4;
        if (z4 && z3 && !this.an && this.aw != null && this.x.ak()) {
            z2 = true;
        }
        cztVar.k = z2;
    }

    public final void eh(boolean z) {
        this.ao = z | this.ao;
        this.an = true;
        int iAb = this.p.ab();
        for (int i2 = 0; i2 < iAb; i2++) {
            czx czxVarCs = cs(this.p.aa(i2));
            if (czxVarCs != null && !czxVarCs.am()) {
                czxVarCs.w(6);
            }
        }
        ea();
        czo czoVar = this.m;
        ArrayList arrayList = czoVar.c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            czx czxVar = (czx) arrayList.get(i3);
            if (czxVar != null) {
                czxVar.w(6);
                czxVar.w(1024);
            }
        }
        cyw cywVar = czoVar.h.w;
        if (cywVar == null || !cywVar.ad) {
            czoVar.n();
        }
    }

    public final void ei(czx czxVar, cjn cjnVar) {
        czxVar.m &= -8193;
        boolean z = this.bo.h;
        but butVar = this.q;
        if (z && czxVar.ai() && !czxVar.af() && !czxVar.am()) {
            ((byc) butVar.c).i(czxVar, du(czxVar));
        }
        dhq dhqVar = (dhq) butVar.b;
        erf erfVarE = (erf) dhqVar.get(czxVar);
        if (erfVarE == null) {
            erfVarE = erf.e();
            dhqVar.put(czxVar, erfVarE);
        }
        erfVarE.c = cjnVar;
        erfVarE.b |= 4;
    }

    public final void ej() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.as;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.as.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.at;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.at.isFinished();
        }
        EdgeEffect edgeEffect3 = this.au;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.au.isFinished();
        }
        EdgeEffect edgeEffect4 = this.av;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.av.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public final int ek(int i2, float f2) {
        float height = f2 / getHeight();
        float width = i2 / getWidth();
        EdgeEffect edgeEffect = this.as;
        float f3 = 0.0f;
        if (edgeEffect == null || cnd.at(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.au;
            if (edgeEffect2 != null && cnd.at(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.au.onRelease();
                } else {
                    float fBb = cnd.bb(this.au, width, height);
                    if (cnd.at(this.au) == 0.0f) {
                        this.au.onRelease();
                    }
                    f3 = fBb;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.as.onRelease();
            } else {
                float f4 = -cnd.bb(this.as, -width, 1.0f - height);
                if (cnd.at(this.as) == 0.0f) {
                    this.as.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getWidth());
    }

    public final int el(int i2, float f2) {
        float width = f2 / getWidth();
        float height = i2 / getHeight();
        EdgeEffect edgeEffect = this.at;
        float f3 = 0.0f;
        if (edgeEffect == null || cnd.at(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.av;
            if (edgeEffect2 != null && cnd.at(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.av.onRelease();
                } else {
                    float fBb = cnd.bb(this.av, height, 1.0f - width);
                    if (cnd.at(this.av) == 0.0f) {
                        this.av.onRelease();
                    }
                    f3 = fBb;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.at.onRelease();
            } else {
                float f4 = -cnd.bb(this.at, -height, width);
                if (cnd.at(this.at) == 0.0f) {
                    this.at.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getHeight());
    }

    public final void em(czd czdVar) {
        czg czgVar = this.x;
        if (czgVar != null) {
            czgVar.bt("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.z;
        arrayList.remove(czdVar);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        ea();
        requestLayout();
    }

    public final void en(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.t;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof czh) {
            czh czhVar = (czh) layoutParams;
            if (!czhVar.e) {
                Rect rect2 = czhVar.d;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.x._g(this, view, this.t, !this.ae, view2 == null);
    }

    /* JADX WARN: Found duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Found duplicated region for block: B:32:0x00e3  */
    /* JADX WARN: Found duplicated region for block: B:34:0x00e7  */
    /* JADX WARN: Found duplicated region for block: B:35:0x00fe A[DONT_INVERT, PHI: r7
      0x00fe: PHI (r7v9 boolean) = (r7v7 boolean), (r7v10 boolean) binds: [B:33:0x00e5, B:31:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:36:0x0100  */
    /* JADX WARN: Found duplicated region for block: B:40:0x0108  */
    /* JADX WARN: Found duplicated region for block: B:43:0x0111  */
    public final boolean eo(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        boolean z3;
        cz();
        cyw cywVar = this.w;
        int[] iArr = this.ca;
        if (cywVar != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            ep(iArr, i2, i3);
            i5 = iArr[0];
            i6 = iArr[1];
            i7 = i2 - i5;
            i8 = i3 - i6;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.z.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        dg(i5, i6, i7, i8, this.by, i4, iArr);
        int i9 = iArr[0];
        int i10 = i7 - i9;
        int i11 = iArr[1];
        int i12 = i8 - i11;
        boolean z4 = (i9 == 0 && i11 == 0) ? false : true;
        int i13 = this.bc;
        int[] iArr2 = this.by;
        int i14 = iArr2[0];
        this.bc = i13 - i14;
        int i15 = this.bd;
        int i16 = iArr2[1];
        this.bd = i15 - i16;
        int[] iArr3 = this.bz;
        iArr3[0] = iArr3[0] + i14;
        iArr3[1] = iArr3[1] + i16;
        if (getOverScrollMode() != 2) {
            if (motionEvent == null || ewz.ak(motionEvent, q.a.s)) {
                z = true;
                z2 = false;
            } else {
                float x = motionEvent.getX();
                float f2 = i10;
                float y = motionEvent.getY();
                float f3 = i12;
                if (f2 < 0.0f) {
                    dj();
                    z = true;
                    z2 = false;
                    cnd.bb(this.as, (-f2) / getWidth(), 1.0f - (y / getHeight()));
                } else {
                    z = true;
                    z2 = false;
                    if (f2 > 0.0f) {
                        dk();
                        cnd.bb(this.au, f2 / getWidth(), y / getHeight());
                    } else {
                        z3 = false;
                    }
                    if (f3 < 0.0f) {
                        dl();
                        cnd.bb(this.at, (-f3) / getHeight(), x / getWidth());
                    } else if (f3 > 0.0f) {
                        di();
                        cnd.bb(this.av, f3 / getHeight(), 1.0f - (x / getWidth()));
                    } else {
                        if (z3 || f2 != 0.0f || f3 != 0.0f) {
                            postInvalidateOnAnimation();
                        }
                        if (Build.VERSION.SDK_INT >= 31 && ewz.ak(motionEvent, 4194304)) {
                            ej();
                        }
                    }
                    z3 = z;
                    if (z3) {
                        postInvalidateOnAnimation();
                    } else {
                        postInvalidateOnAnimation();
                    }
                    if (Build.VERSION.SDK_INT >= 31) {
                        ej();
                    }
                }
                z3 = z;
                if (f3 < 0.0f) {
                    dl();
                    cnd.bb(this.at, (-f3) / getHeight(), x / getWidth());
                } else if (f3 > 0.0f) {
                    di();
                    cnd.bb(this.av, f3 / getHeight(), 1.0f - (x / getWidth()));
                } else {
                    if (z3) {
                        postInvalidateOnAnimation();
                    } else {
                        postInvalidateOnAnimation();
                    }
                    if (Build.VERSION.SDK_INT >= 31) {
                        ej();
                    }
                }
                z3 = z;
                if (z3) {
                    postInvalidateOnAnimation();
                } else {
                    postInvalidateOnAnimation();
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    ej();
                }
            }
            cy(i2, i3);
        } else {
            z = true;
            z2 = false;
        }
        if (i5 != 0 || i6 != 0) {
            dh(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z4 && i5 == 0 && i6 == 0) ? z2 : z;
    }

    public final void ep(int[] iArr, int i2, int i3) {
        czx czxVar;
        eu();
        ec();
        Trace.beginSection("RV Scroll");
        czt cztVar = this.bo;
        dn(cztVar);
        czo czoVar = this.m;
        int iAh = i2 != 0 ? this.x.ah(i2, czoVar, cztVar) : 0;
        int iAi = i3 != 0 ? this.x.ai(i3, czoVar, cztVar) : 0;
        Trace.endSection();
        int iY = this.p.y();
        for (int i4 = 0; i4 < iY; i4++) {
            View viewX = this.p.x(i4);
            czx czxVarDv = dv(viewX);
            if (czxVarDv != null && (czxVar = czxVarDv.l) != null) {
                View view = czxVar.d;
                int left = viewX.getLeft();
                int top = viewX.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        ed(true);
        ew(false);
        if (iArr != null) {
            iArr[0] = iAh;
            iArr[1] = iAi;
        }
    }

    public final void eq(int i2) {
        if (this.ah) {
            return;
        }
        ey();
        czg czgVar = this.x;
        if (czgVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            czgVar.ch(i2);
            awakenScrollBars();
        }
    }

    public final boolean er(EdgeEffect edgeEffect, int i2, int i3) {
        if (i2 > 0) {
            return true;
        }
        float fAt = cnd.at(edgeEffect) * i3;
        float fAbs = Math.abs(-i2) * 0.35f;
        float f2 = this.k * 0.015f;
        double dLog = Math.log(fAbs / f2);
        double d = e;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f2))) < fAt;
    }

    public final void es(int i2, int i3, boolean z) {
        czg czgVar = this.x;
        if (czgVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.ah) {
            return;
        }
        if (!czgVar.bu()) {
            i2 = 0;
        }
        if (!this.x.bv()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (z) {
            int i4 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i4 |= 2;
            }
            getScrollingChildHelper().l(i4, 1);
        }
        this.bl.j(i2, i3, Integer.MIN_VALUE, null);
    }

    public final void et(int i2) {
        if (this.ah) {
            return;
        }
        czg czgVar = this.x;
        if (czgVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            czgVar.cj(this, this.bo, i2);
        }
    }

    public final void eu() {
        int i2 = this.af + 1;
        this.af = i2;
        if (i2 != 1 || this.ah) {
            return;
        }
        this.ag = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ev(int i2) {
        boolean zBu = this.x.bu();
        int i3 = zBu;
        if (this.x.bv()) {
            i3 = (zBu ? 1 : 0) | 2;
        }
        getScrollingChildHelper().l(i3, i2);
    }

    public final void ew(boolean z) {
        if (this.af < 1) {
            if (a) {
                throw new IllegalStateException(yg.i(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.af = 1;
        }
        if (!z && !this.ah) {
            this.ag = false;
        }
        if (this.af == 1) {
            if (z && this.ag && !this.ah && this.x != null && this.w != null) {
                dc();
            }
            if (!this.ah) {
                this.ag = false;
            }
        }
        this.af--;
    }

    public final void ex(int i2) {
        getScrollingChildHelper().m(i2);
    }

    public final void ey() {
        bvl bvlVar;
        setScrollState(0);
        czw czwVar = this.bl;
        czwVar.g.removeCallbacks(czwVar);
        czwVar.c.abortAnimation();
        czg czgVar = this.x;
        if (czgVar == null || (bvlVar = czgVar.ds) == null) {
            return;
        }
        bvlVar.z();
    }

    /* JADX WARN: Found duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Found duplicated region for block: B:137:0x0197 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:138:0x0198  */
    /* JADX WARN: Found duplicated region for block: B:24:0x004c  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i2) {
        View viewW;
        int i3;
        byte b2;
        boolean z;
        this.x.getClass();
        boolean z2 = true;
        boolean z3 = (this.w == null || this.x == null || dy() || this.ah) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        czt cztVar = this.bo;
        czo czoVar = this.m;
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.x.bv()) {
                z = focusFinder.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null;
            }
            if (!z && this.x.bu()) {
                z = focusFinder.findNextFocus(this, view, (this.x.dp.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17) == null;
            }
            if (z) {
                cz();
                if (m0do(view) != null) {
                    eu();
                    this.x.w(view, i2, czoVar, cztVar);
                    ew(false);
                }
                return null;
            }
            viewW = focusFinder.findNextFocus(this, view, i2);
            if (viewW == null) {
            }
            z2 = viewW == null ? false : false;
            if (z2) {
            }
        }
        View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
        if (viewFindNextFocus == null && z3) {
            cz();
            if (m0do(view) != null) {
                eu();
                viewW = this.x.w(view, i2, czoVar, cztVar);
                ew(false);
            }
            return null;
        }
        viewW = viewFindNextFocus;
        if (viewW == null && !viewW.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i2);
            }
            en(viewW, null);
            return view;
        }
        if (viewW == null && viewW != this && viewW != view) {
            if (m0do(viewW) == null) {
                z2 = false;
            } else if (view != null && m0do(view) != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                Rect rect = this.t;
                rect.set(0, 0, width, height);
                int width2 = viewW.getWidth();
                int height2 = viewW.getHeight();
                Rect rect2 = this.u;
                rect2.set(0, 0, width2, height2);
                offsetDescendantRectToMyCoords(view, rect);
                offsetDescendantRectToMyCoords(viewW, rect2);
                int i4 = this.x.dp.getLayoutDirection() == 1 ? -1 : 1;
                int i5 = rect.left;
                int i6 = rect2.left;
                if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
                    i3 = 1;
                } else {
                    int i7 = rect.right;
                    int i8 = rect2.right;
                    i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                    b2 = 1;
                } else {
                    int i11 = rect.bottom;
                    int i12 = rect2.bottom;
                    b2 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? (byte) -1 : (byte) 0;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 17) {
                            if (i2 != 33) {
                                if (i2 != 66) {
                                    if (i2 != 130) {
                                        StringBuilder sb = new StringBuilder("Invalid direction: ");
                                        sb.append(i2);
                                        throw new IllegalArgumentException(yg.i(this, sb));
                                    }
                                    if (b2 <= 0) {
                                    }
                                } else if (i3 <= 0) {
                                }
                            } else if (b2 >= 0) {
                            }
                        } else if (i3 >= 0) {
                        }
                    } else if (b2 <= 0 && (b2 != 0 || i3 * i4 <= 0)) {
                    }
                } else if (b2 >= 0 && (b2 != 0 || i3 * i4 >= 0)) {
                }
            }
        }
        return z2 ? viewW : super.focusSearch(view, i2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        czg czgVar = this.x;
        if (czgVar != null) {
            return czgVar.r();
        }
        throw new IllegalStateException(yg.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        czg czgVar = this.x;
        if (czgVar != null) {
            return czgVar.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(yg.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public cyw getAdapter() {
        return this.w;
    }

    @Override // android.view.View
    public int getBaseline() {
        czg czgVar = this.x;
        if (czgVar == null) {
            return super.getBaseline();
        }
        czgVar.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.r;
    }

    public czz getCompatAccessibilityDelegate() {
        return this.bv;
    }

    public czb getEdgeEffectFactory() {
        return this.ar;
    }

    public czc getItemAnimator() {
        return this.aw;
    }

    public int getItemDecorationCount() {
        return this.z.size();
    }

    public czg getLayoutManager() {
        return this.x;
    }

    public int getMaxFlingVelocity() {
        return this.bh;
    }

    public int getMinFlingVelocity() {
        return this.bg;
    }

    public long getNanoTime() {
        if (g) {
            return System.nanoTime();
        }
        return 0L;
    }

    public czj getOnFlingListener() {
        return this.bf;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.bk;
    }

    public czn getRecycledViewPool() {
        return this.m.k();
    }

    public int getScrollState() {
        return this.ax;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k(0);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.ac;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.ah;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0058  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.ap = 0;
        this.ac = true;
        this.ae = this.ae && !isLayoutRequested();
        this.m.l();
        czg czgVar = this.x;
        if (czgVar != null) {
            czgVar.du = true;
            czgVar.dm(this);
        }
        this.bu = false;
        if (g) {
            ThreadLocal threadLocal = bgv.a;
            bgv bgvVar = (bgv) threadLocal.get();
            this.bm = bgvVar;
            if (bgvVar == null) {
                this.bm = new bgv();
                WeakHashMap weakHashMap = eqz.a;
                Display display = getDisplay();
                if (isInEditMode() || display == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = display.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                bgv bgvVar2 = this.bm;
                bgvVar2.e = (long) (1.0E9f / refreshRate);
                threadLocal.set(bgvVar2);
            }
            ArrayList arrayList = this.bm.c;
            if (a && arrayList.contains(this)) {
                throw new IllegalStateException("RecyclerView already present in worker list!");
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        bgv bgvVar;
        super.onDetachedFromWindow();
        czc czcVar = this.aw;
        if (czcVar != null) {
            czcVar.q();
        }
        ey();
        int i2 = 0;
        this.ac = false;
        czg czgVar = this.x;
        if (czgVar != null) {
            czgVar.du = false;
            czgVar.cd(this);
        }
        this.cb.clear();
        removeCallbacks(this.cc);
        this.q.getClass();
        while (erf.a.acquire() != null) {
        }
        czo czoVar = this.m;
        ArrayList arrayList = czoVar.c;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bzo.k(((czx) arrayList.get(i3)).d);
        }
        czoVar.m(czoVar.h.w, false);
        while (i2 < getChildCount()) {
            int i4 = i2 + 1;
            View childAt = getChildAt(i2);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            cuu cuuVar = (cuu) childAt.getTag(me.hd.wauxv.R.id.pooling_container_listener_holder_tag);
            if (cuuVar == null) {
                cuuVar = new cuu();
                childAt.setTag(me.hd.wauxv.R.id.pooling_container_listener_holder_tag, cuuVar);
            }
            ArrayList arrayList2 = cuuVar.a;
            int iAf = aba.af(arrayList2);
            if (-1 < iAf) {
                arrayList2.get(iAf).getClass();
                throw new ClassCastException();
            }
            i2 = i4;
        }
        if (!g || (bgvVar = this.bm) == null) {
            return;
        }
        boolean zRemove = bgvVar.c.remove(this);
        if (a && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.bm = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.z;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((czd) arrayList.get(i2))._bk(canvas, this);
        }
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i2;
        boolean z;
        if (this.x != null && !this.ah && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f2 = this.x.bv() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.x.bu() ? motionEvent.getAxisValue(10) : 0.0f;
                i2 = 0;
                z = false;
                f = f2;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.x.bv()) {
                    float f3 = -axisValue;
                    axisValue = 0.0f;
                    f = f3;
                } else if (!this.x.bu()) {
                    axisValue = 0.0f;
                }
                i2 = 26;
                z = this.cg;
            } else {
                axisValue = 0.0f;
                i2 = 0;
                z = false;
            }
            int i3 = (int) (f * this.bj);
            int i4 = (int) (axisValue * this.bi);
            if (z) {
                OverScroller overScroller = this.bl.c;
                es((overScroller.getFinalX() - overScroller.getCurrX()) + i4, (overScroller.getFinalY() - overScroller.getCurrY()) + i3, true);
            } else {
                czg czgVar = this.x;
                if (czgVar == null) {
                    Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.ah) {
                    int[] iArr = this.ca;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zBu = czgVar.bu();
                    boolean zBv = this.x.bv();
                    int i5 = zBv ? (zBu ? 1 : 0) | 2 : zBu ? 1 : 0;
                    float y = motionEvent.getY();
                    float x = motionEvent.getX();
                    int iEk = i4 - ek(i4, y);
                    int iEl = i3 - el(i3, x);
                    getScrollingChildHelper().l(i5, 1);
                    if (df(this.ca, zBu ? iEk : 0, zBv ? iEl : 0, 1, this.by)) {
                        iEk -= iArr[0];
                        iEl -= iArr[1];
                    }
                    eo(zBu ? iEk : 0, zBv ? iEl : 0, motionEvent, 1);
                    bgv bgvVar = this.bm;
                    if (bgvVar != null && (iEk != 0 || iEl != 0)) {
                        bgvVar.h(this, iEk, iEl);
                    }
                    ex(1);
                }
            }
            if (i2 != 0 && !z) {
                this.ci.i(motionEvent, i2);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.ah) {
            this.ab = null;
            if (dp(motionEvent)) {
                VelocityTracker velocityTracker = this.az;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                ex(0);
                ej();
                setScrollState(0);
                return true;
            }
            czg czgVar = this.x;
            if (czgVar != null) {
                boolean zBu = czgVar.bu();
                boolean zBv = this.x.bv();
                if (this.az == null) {
                    this.az = VelocityTracker.obtain();
                }
                this.az.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.ai) {
                        this.ai = false;
                    }
                    this.ay = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.bc = x;
                    this.ba = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.bd = y;
                    this.bb = y;
                    EdgeEffect edgeEffect = this.as;
                    if (edgeEffect == null || cnd.at(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z = false;
                    } else {
                        cnd.bb(this.as, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z = true;
                    }
                    EdgeEffect edgeEffect2 = this.au;
                    if (edgeEffect2 != null && cnd.at(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        cnd.bb(this.au, 0.0f, motionEvent.getY() / getHeight());
                        z = true;
                    }
                    EdgeEffect edgeEffect3 = this.at;
                    if (edgeEffect3 != null && cnd.at(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        cnd.bb(this.at, 0.0f, motionEvent.getX() / getWidth());
                        z = true;
                    }
                    EdgeEffect edgeEffect4 = this.av;
                    if (edgeEffect4 != null && cnd.at(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        cnd.bb(this.av, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z = true;
                    }
                    if (z || this.ax == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        ex(1);
                    }
                    int[] iArr = this.bz;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    ev(0);
                } else if (actionMasked == 1) {
                    this.az.clear();
                    ex(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.ay);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ay + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.ax != 1) {
                        int i2 = x2 - this.ba;
                        int i3 = y2 - this.bb;
                        if (!zBu || Math.abs(i2) <= this.be) {
                            z2 = false;
                        } else {
                            this.bc = x2;
                            z2 = true;
                        }
                        if (zBv && Math.abs(i3) > this.be) {
                            this.bd = y2;
                            z2 = true;
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    VelocityTracker velocityTracker2 = this.az;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                    ex(0);
                    ej();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.ay = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.bc = x3;
                    this.ba = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.bd = y3;
                    this.bb = y3;
                } else if (actionMasked == 6) {
                    ee(motionEvent);
                }
                if (this.ax == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Trace.beginSection("RV OnLayout");
        dc();
        Trace.endSection();
        this.ae = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        czg czgVar = this.x;
        if (czgVar == null) {
            da(i2, i3);
            return;
        }
        boolean zCb = czgVar.cb();
        boolean z = false;
        czt cztVar = this.bo;
        if (zCb) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.x.dp.da(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.cd = z;
            if (z || this.w == null) {
                return;
            }
            if (cztVar.d == 1) {
                dd();
            }
            this.x.fh(i2, i3);
            cztVar.i = true;
            de();
            this.x.fi(i2, i3);
            if (this.x.ci()) {
                this.x.fh(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                cztVar.i = true;
                de();
                this.x.fi(i2, i3);
            }
            this.ce = getMeasuredWidth();
            this.cf = getMeasuredHeight();
            return;
        }
        if (this.ad) {
            this.x.dp.da(i2, i3);
            return;
        }
        if (this.ak) {
            eu();
            ec();
            eg();
            ed(true);
            if (cztVar.k) {
                cztVar.g = true;
            } else {
                this.o.k();
                cztVar.g = false;
            }
            this.ak = false;
            ew(false);
        } else if (cztVar.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        cyw cywVar = this.w;
        if (cywVar != null) {
            cztVar.e = cywVar.d();
        } else {
            cztVar.e = 0;
        }
        eu();
        this.x.dp.da(i2, i3);
        ew(false);
        cztVar.g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (dy()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof czq)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        czq czqVar = (czq) parcelable;
        this.n = czqVar;
        super.onRestoreInstanceState(czqVar.g);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        czq czqVar = new czq(super.onSaveInstanceState());
        czq czqVar2 = this.n;
        if (czqVar2 != null) {
            czqVar.a = czqVar2.a;
            return czqVar;
        }
        czg czgVar = this.x;
        if (czgVar != null) {
            czqVar.a = czgVar.cg();
            return czqVar;
        }
        czqVar.a = null;
        return czqVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        this.av = null;
        this.at = null;
        this.au = null;
        this.as = null;
    }

    /* JADX WARN: Found duplicated region for block: B:62:0x0111 A[PHI: r1
      0x0111: PHI (r1v45 int) = (r1v31 int), (r1v49 int) binds: [B:56:0x00fa, B:60:0x010d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zDp;
        boolean z;
        if (!this.ah && !this.ai) {
            czk czkVar = this.ab;
            if (czkVar == null) {
                zDp = motionEvent.getAction() == 0 ? false : dp(motionEvent);
            } else {
                czkVar.ag(motionEvent);
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.ab = null;
                }
                zDp = true;
            }
            if (zDp) {
                VelocityTracker velocityTracker = this.az;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                ex(0);
                ej();
                setScrollState(0);
                return true;
            }
            czg czgVar = this.x;
            if (czgVar != null) {
                boolean zBu = czgVar.bu();
                boolean zBv = this.x.bv();
                if (this.az == null) {
                    this.az = VelocityTracker.obtain();
                }
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                int[] iArr = this.bz;
                if (actionMasked == 0) {
                    iArr[1] = 0;
                    iArr[0] = 0;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.offsetLocation(iArr[0], iArr[1]);
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        this.az.addMovement(motionEventObtain);
                        VelocityTracker velocityTracker2 = this.az;
                        int i2 = this.bh;
                        velocityTracker2.computeCurrentVelocity(1000, i2);
                        float f2 = zBu ? -this.az.getXVelocity(this.ay) : 0.0f;
                        float f3 = zBv ? -this.az.getYVelocity(this.ay) : 0.0f;
                        if ((f2 == 0.0f && f3 == 0.0f) || !ds((int) f2, (int) f3, this.bg, i2)) {
                            setScrollState(0);
                        }
                        VelocityTracker velocityTracker3 = this.az;
                        if (velocityTracker3 != null) {
                            velocityTracker3.clear();
                        }
                        ex(0);
                        ej();
                    } else if (actionMasked == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.ay);
                        if (iFindPointerIndex < 0) {
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ay + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        int x = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                        int y = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                        int iMax = this.bc - x;
                        int iMax2 = this.bd - y;
                        if (this.ax != 1) {
                            if (zBu) {
                                iMax = iMax > 0 ? Math.max(0, iMax - this.be) : Math.min(0, iMax + this.be);
                                z = iMax != 0;
                            }
                            if (zBv) {
                                iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.be) : Math.min(0, iMax2 + this.be);
                                if (iMax2 != 0) {
                                    z = true;
                                }
                            }
                            if (z) {
                                setScrollState(1);
                            }
                        }
                        if (this.ax == 1) {
                            int[] iArr2 = this.ca;
                            iArr2[0] = 0;
                            iArr2[1] = 0;
                            int iEk = iMax - ek(iMax, motionEvent.getY());
                            int iEl = iMax2 - el(iMax2, motionEvent.getX());
                            boolean zDf = df(this.ca, zBu ? iEk : 0, zBv ? iEl : 0, 0, this.by);
                            int[] iArr3 = this.by;
                            if (zDf) {
                                iEk -= iArr2[0];
                                iEl -= iArr2[1];
                                iArr[0] = iArr[0] + iArr3[0];
                                iArr[1] = iArr[1] + iArr3[1];
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            int i3 = iEk;
                            int i4 = iEl;
                            this.bc = x - iArr3[0];
                            this.bd = y - iArr3[1];
                            if (eo(zBu ? i3 : 0, zBv ? i4 : 0, motionEvent, 0)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            bgv bgvVar = this.bm;
                            if (bgvVar != null && (i3 != 0 || i4 != 0)) {
                                bgvVar.h(this, i3, i4);
                            }
                        }
                    } else if (actionMasked == 3) {
                        VelocityTracker velocityTracker4 = this.az;
                        if (velocityTracker4 != null) {
                            velocityTracker4.clear();
                        }
                        ex(0);
                        ej();
                        setScrollState(0);
                    } else if (actionMasked == 5) {
                        this.ay = motionEvent.getPointerId(actionIndex);
                        int x2 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                        this.bc = x2;
                        this.ba = x2;
                        int y2 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                        this.bd = y2;
                        this.bb = y2;
                    } else if (actionMasked == 6) {
                        ee(motionEvent);
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                this.ay = motionEvent.getPointerId(0);
                int x3 = (int) (motionEvent.getX() + 0.5f);
                this.bc = x3;
                this.ba = x3;
                int y3 = (int) (motionEvent.getY() + 0.5f);
                this.bd = y3;
                this.bb = y3;
                ev(0);
                this.az.addMovement(motionEventObtain);
                motionEventObtain.recycle();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        czx czxVarCs = cs(view);
        if (czxVarCs != null) {
            if (czxVarCs.ah()) {
                czxVarCs.m &= -257;
            } else if (!czxVarCs.am()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(czxVarCs);
                throw new IllegalArgumentException(yg.i(this, sb));
            }
        } else if (a) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(yg.i(this, sb2));
        }
        view.clearAnimation();
        db(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        bvl bvlVar = this.x.ds;
        if ((bvlVar == null || !bvlVar.j) && !dy() && view2 != null) {
            en(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.x._g(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.aa;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((czk) arrayList.get(i2)).ai(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.af != 0 || this.ah) {
            this.ag = true;
        } else {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i3) {
        czg czgVar = this.x;
        if (czgVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.ah) {
            return;
        }
        boolean zBu = czgVar.bu();
        boolean zBv = this.x.bv();
        if (zBu || zBv) {
            if (!zBu) {
                i2 = 0;
            }
            if (!zBv) {
                i3 = 0;
            }
            eo(i2, i3, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!dy()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.aj |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(czz czzVar) {
        this.bv = czzVar;
        eqz.s(this, czzVar);
    }

    public void setAdapter(cyw cywVar) {
        setLayoutFrozen(false);
        cyw cywVar2 = this.w;
        bez bezVar = this.l;
        if (cywVar2 != null) {
            cywVar2.ac.unregisterObserver(bezVar);
            this.w.l(this);
        }
        czc czcVar = this.aw;
        if (czcVar != null) {
            czcVar.q();
        }
        czg czgVar = this.x;
        czo czoVar = this.m;
        if (czgVar != null) {
            czgVar.fb(czoVar);
            this.x.fc(czoVar);
        }
        czoVar.a.clear();
        czoVar.n();
        ea eaVar = this.o;
        eaVar.z((ArrayList) eaVar.c);
        eaVar.z((ArrayList) eaVar.d);
        eaVar.a = 0;
        cyw cywVar3 = this.w;
        this.w = cywVar;
        if (cywVar != null) {
            cywVar.ac.registerObserver(bezVar);
            cywVar.j(this);
        }
        czg czgVar2 = this.x;
        if (czgVar2 != null) {
            czgVar2.ba(this.w);
        }
        cyw cywVar4 = this.w;
        czoVar.a.clear();
        czoVar.n();
        czoVar.m(cywVar3, true);
        czn cznVarK = czoVar.k();
        if (cywVar3 != null) {
            cznVarK.b--;
        }
        if (cznVarK.b == 0) {
            SparseArray sparseArray = cznVarK.a;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                czm czmVar = (czm) sparseArray.valueAt(i2);
                Iterator it = czmVar.a.iterator();
                while (it.hasNext()) {
                    bzo.k(((czx) it.next()).d);
                }
                czmVar.a.clear();
            }
        }
        if (cywVar4 != null) {
            cznVarK.b++;
        }
        czoVar.l();
        this.bo.f = true;
        eh(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(cza czaVar) {
        if (czaVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(czaVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.r) {
            this.av = null;
            this.at = null;
            this.au = null;
            this.as = null;
        }
        this.r = z;
        super.setClipToPadding(z);
        if (this.ae) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(czb czbVar) {
        czbVar.getClass();
        this.ar = czbVar;
        this.av = null;
        this.at = null;
        this.au = null;
        this.as = null;
    }

    public void setHasFixedSize(boolean z) {
        this.ad = z;
    }

    public void setItemAnimator(czc czcVar) {
        czc czcVar2 = this.aw;
        if (czcVar2 != null) {
            czcVar2.q();
            this.aw.x = null;
        }
        this.aw = czcVar;
        if (czcVar != null) {
            czcVar.x = this.bt;
        }
    }

    public void setItemViewCacheSize(int i2) {
        czo czoVar = this.m;
        czoVar.e = i2;
        czoVar.u();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(czg czgVar) {
        if (czgVar == this.x) {
            return;
        }
        ey();
        czg czgVar2 = this.x;
        czo czoVar = this.m;
        if (czgVar2 != null) {
            czc czcVar = this.aw;
            if (czcVar != null) {
                czcVar.q();
            }
            this.x.fb(czoVar);
            this.x.fc(czoVar);
            czoVar.a.clear();
            czoVar.n();
            if (this.ac) {
                czg czgVar3 = this.x;
                czgVar3.du = false;
                czgVar3.cd(this);
            }
            this.x.fj(null);
            this.x = null;
        } else {
            czoVar.a.clear();
            czoVar.n();
        }
        yi yiVar = this.p;
        RecyclerView recyclerView = ((cyv) yiVar.c).a;
        ((yh) yiVar.d).i();
        ArrayList arrayList = (ArrayList) yiVar.e;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            czx czxVarCs = cs((View) arrayList.get(size));
            if (czxVarCs != null) {
                int i2 = czxVarCs.s;
                if (recyclerView.dy()) {
                    czxVarCs.t = i2;
                    recyclerView.cb.add(czxVarCs);
                } else {
                    czxVarCs.d.setImportantForAccessibility(i2);
                }
                czxVarCs.s = 0;
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            recyclerView.db(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.x = czgVar;
        if (czgVar != null) {
            if (czgVar.dp != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(czgVar);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(yg.i(czgVar.dp, sb));
            }
            czgVar.fj(this);
            if (this.ac) {
                czg czgVar4 = this.x;
                czgVar4.du = true;
                czgVar4.dm(this);
            }
        }
        czoVar.u();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        cks scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            ViewGroup viewGroup = scrollingChildHelper.c;
            WeakHashMap weakHashMap = eqz.a;
            eqq.m(viewGroup);
        }
        scrollingChildHelper.d = z;
    }

    public void setOnFlingListener(czj czjVar) {
        this.bf = czjVar;
    }

    @Deprecated
    public void setOnScrollListener(czl czlVar) {
        this.bp = czlVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.bk = z;
    }

    public void setRecycledViewPool(czn cznVar) {
        czo czoVar = this.m;
        RecyclerView recyclerView = czoVar.h;
        czoVar.m(recyclerView.w, false);
        if (czoVar.g != null) {
            r2.b--;
        }
        czoVar.g = cznVar;
        if (cznVar != null && recyclerView.getAdapter() != null) {
            czoVar.g.b++;
        }
        czoVar.l();
    }

    @Deprecated
    public void setRecyclerListener(czp czpVar) {
    }

    public void setScrollState(int i2) {
        bvl bvlVar;
        if (i2 == this.ax) {
            return;
        }
        if (b) {
            StringBuilder sbR = yg.r(i2, "setting scroll state to ", " from ");
            sbR.append(this.ax);
            Log.d("RecyclerView", sbR.toString(), new Exception());
        }
        this.ax = i2;
        if (i2 != 2) {
            czw czwVar = this.bl;
            czwVar.g.removeCallbacks(czwVar);
            czwVar.c.abortAnimation();
            czg czgVar = this.x;
            if (czgVar != null && (bvlVar = czgVar.ds) != null) {
                bvlVar.z();
            }
        }
        czg czgVar2 = this.x;
        if (czgVar2 != null) {
            czgVar2.bb(i2);
        }
        czl czlVar = this.bp;
        if (czlVar != null) {
            czlVar.e(this, i2);
        }
        ArrayList arrayList = this.bq;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((czl) this.bq.get(size)).e(this, i2);
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.be = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.be = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(czv czvVar) {
        this.m.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().l(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().m(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.ah) {
            cw("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.ah = true;
                this.ai = true;
                ey();
                return;
            }
            this.ah = false;
            if (this.ag && this.x != null && this.w != null) {
                requestLayout();
            }
            this.ag = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        char c2;
        char c3;
        char c4;
        TypedArray typedArray;
        int i3;
        Constructor constructor;
        super(context, attributeSet, i2);
        int i4 = 1;
        this.l = new bez(this, i4);
        this.m = new czo(this);
        this.q = new but(19);
        this.s = new cyu(this, 0);
        this.t = new Rect();
        this.u = new Rect();
        this.v = new RectF();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.aa = new ArrayList();
        this.af = 0;
        this.an = false;
        this.ao = false;
        this.ap = 0;
        this.aq = 0;
        this.ar = j;
        akx akxVar = new akx();
        Object[] objArr = null;
        akxVar.x = null;
        akxVar.y = new ArrayList();
        akxVar.z = 120L;
        akxVar.aa = 120L;
        akxVar.ab = 250L;
        akxVar.ac = 250L;
        akxVar.b = true;
        akxVar.c = new ArrayList();
        akxVar.d = new ArrayList();
        akxVar.e = new ArrayList();
        akxVar.f = new ArrayList();
        akxVar.g = new ArrayList();
        akxVar.h = new ArrayList();
        akxVar.i = new ArrayList();
        akxVar.j = new ArrayList();
        akxVar.k = new ArrayList();
        akxVar.l = new ArrayList();
        akxVar.m = new ArrayList();
        this.aw = akxVar;
        this.ax = 0;
        this.ay = -1;
        this.bi = Float.MIN_VALUE;
        this.bj = Float.MIN_VALUE;
        this.bk = true;
        this.bl = new czw(this);
        this.bn = g ? new bpq() : null;
        czt cztVar = new czt();
        cztVar.a = -1;
        cztVar.b = 0;
        cztVar.c = 0;
        cztVar.d = 1;
        cztVar.e = 0;
        cztVar.f = false;
        cztVar.g = false;
        cztVar.h = false;
        cztVar.i = false;
        cztVar.j = false;
        cztVar.k = false;
        this.bo = cztVar;
        this.br = false;
        this.bs = false;
        cyv cyvVar = new cyv(this);
        this.bt = cyvVar;
        this.bu = false;
        this.bw = new int[2];
        this.by = new int[2];
        this.bz = new int[2];
        this.ca = new int[2];
        this.cb = new ArrayList();
        this.cc = new cyu(this, i4);
        this.ce = 0;
        this.cf = 0;
        this.ch = new cyv(this);
        this.ci = new ann(getContext(), new cyv(this));
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.be = viewConfiguration.getScaledTouchSlop();
        this.bi = viewConfiguration.getScaledHorizontalScrollFactor();
        this.bj = viewConfiguration.getScaledVerticalScrollFactor();
        this.bg = viewConfiguration.getScaledMinimumFlingVelocity();
        this.bh = viewConfiguration.getScaledMaximumFlingVelocity();
        this.k = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.aw.x = cyvVar;
        this.o = new ea(new cyv(this));
        this.p = new yi(new cyv(this));
        WeakHashMap weakHashMap = eqz.a;
        if (eqt.a(this) == 0) {
            eqt.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.al = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new czz(this));
        int[] iArr = cxq.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        eqz.r(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.r = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(yg.i(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c2 = 3;
            c4 = 2;
            c3 = 1;
            typedArray = typedArrayObtainStyledAttributes;
            i3 = 4;
            new ayj(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(me.hd.wauxv.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(me.hd.wauxv.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(me.hd.wauxv.R.dimen.fastscroll_margin));
        } else {
            c2 = 3;
            c3 = 1;
            c4 = 2;
            typedArray = typedArrayObtainStyledAttributes;
            i3 = 4;
        }
        typedArray.recycle();
        this.cg = context.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(czg.class);
                    try {
                        Constructor constructor2 = clsAsSubclass.getConstructor(h);
                        Object[] objArr2 = new Object[i3];
                        objArr2[0] = context;
                        objArr2[c3] = attributeSet;
                        objArr2[c4] = Integer.valueOf(i2);
                        objArr2[c2] = 0;
                        objArr = objArr2;
                        constructor = constructor2;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                        }
                    }
                    constructor.setAccessible(c3);
                    setLayoutManager((czg) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e8);
                }
            }
        }
        int[] iArr2 = c;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        eqz.r(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
        setTag(me.hd.wauxv.R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        czg czgVar = this.x;
        if (czgVar != null) {
            return czgVar.t(layoutParams);
        }
        throw new IllegalStateException(yg.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
