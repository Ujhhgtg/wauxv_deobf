package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bvl {
    public int f = -1;
    public RecyclerView g;
    public czg h;
    public boolean i;
    public boolean j;
    public View k;
    public final czr l;
    public boolean m;
    public final LinearInterpolator n;
    public final DecelerateInterpolator o;
    public PointF p;
    public final DisplayMetrics q;
    public boolean r;
    public float s;
    public int t;
    public int u;

    public bvl(Context context) {
        czr czrVar = new czr();
        czrVar.d = -1;
        czrVar.f = false;
        czrVar.g = 0;
        czrVar.a = 0;
        czrVar.b = 0;
        czrVar.c = Integer.MIN_VALUE;
        czrVar.e = null;
        this.l = czrVar;
        this.n = new LinearInterpolator();
        this.o = new DecelerateInterpolator();
        this.r = false;
        this.t = 0;
        this.u = 0;
        this.q = context.getResources().getDisplayMetrics();
    }

    public static int v(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int b(View view, int i) {
        czg czgVar = this.h;
        if (czgVar == null || !czgVar.bu()) {
            return 0;
        }
        czh czhVar = (czh) view.getLayoutParams();
        return v(czg.eg(view) - ((ViewGroup.MarginLayoutParams) czhVar).leftMargin, czg.ej(view) + ((ViewGroup.MarginLayoutParams) czhVar).rightMargin, czgVar.ev(), czgVar.eb - czgVar.ew(), i);
    }

    public int c(View view, int i) {
        czg czgVar = this.h;
        if (czgVar == null || !czgVar.bv()) {
            return 0;
        }
        czh czhVar = (czh) view.getLayoutParams();
        return v(czg.ek(view) - ((ViewGroup.MarginLayoutParams) czhVar).topMargin, czg.ef(view) + ((ViewGroup.MarginLayoutParams) czhVar).bottomMargin, czgVar.ex(), czgVar.ec - czgVar.eu(), i);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public PointF e(int i) {
        Object obj = this.h;
        if (obj instanceof czs) {
            return ((czs) obj).bs(i);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + czs.class.getCanonicalName());
        return null;
    }

    public int w(int i) {
        float fAbs = Math.abs(i);
        if (!this.r) {
            this.s = d(this.q);
            this.r = true;
        }
        return (int) Math.ceil(fAbs * this.s);
    }

    /* JADX WARN: Found duplicated region for block: B:50:0x00f8  */
    public final void x(int i, int i2) {
        PointF pointFE;
        RecyclerView recyclerView = this.g;
        if (this.f == -1 || recyclerView == null) {
            z();
        }
        if (this.i && this.k == null && this.h != null && (pointFE = e(this.f)) != null) {
            float f = pointFE.x;
            if (f != 0.0f || pointFE.y != 0.0f) {
                recyclerView.ep(null, (int) Math.signum(f), (int) Math.signum(pointFE.y));
            }
        }
        this.i = false;
        View view = this.k;
        czr czrVar = this.l;
        if (view != null) {
            this.g.getClass();
            czx czxVarCs = RecyclerView.cs(view);
            if ((czxVarCs != null ? czxVarCs.z() : -1) == this.f) {
                View view2 = this.k;
                czt cztVar = recyclerView.bo;
                y(view2, czrVar);
                czrVar.h(recyclerView);
                z();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.k = null;
            }
        }
        if (this.j) {
            czt cztVar2 = recyclerView.bo;
            if (this.g.x.es() == 0) {
                z();
            } else {
                int i3 = this.t;
                int i4 = i3 - i;
                if (i3 * i4 <= 0) {
                    i4 = 0;
                }
                this.t = i4;
                int i5 = this.u;
                int i6 = i5 - i2;
                if (i5 * i6 <= 0) {
                    i6 = 0;
                }
                this.u = i6;
                if (i4 == 0 && i6 == 0) {
                    PointF pointFE2 = e(this.f);
                    if (pointFE2 != null) {
                        if (pointFE2.x == 0.0f && pointFE2.y == 0.0f) {
                            czrVar.d = this.f;
                            z();
                        } else {
                            float f2 = pointFE2.y;
                            float fSqrt = (float) Math.sqrt((f2 * f2) + (r10 * r10));
                            float f3 = pointFE2.x / fSqrt;
                            pointFE2.x = f3;
                            float f4 = pointFE2.y / fSqrt;
                            pointFE2.y = f4;
                            this.p = pointFE2;
                            this.t = (int) (f3 * 10000.0f);
                            this.u = (int) (f4 * 10000.0f);
                            int iW = w(10000);
                            czrVar.a = (int) (this.t * 1.2f);
                            czrVar.b = (int) (this.u * 1.2f);
                            czrVar.c = (int) (iW * 1.2f);
                            czrVar.e = this.n;
                            czrVar.f = true;
                        }
                    } else {
                        czrVar.d = this.f;
                        z();
                    }
                }
            }
            boolean z = czrVar.d >= 0;
            czrVar.h(recyclerView);
            if (z && this.j) {
                this.i = true;
                recyclerView.bl.i();
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:10:0x0015  */
    public void y(View view, czr czrVar) {
        int i;
        PointF pointF = this.p;
        int i2 = 0;
        if (pointF != null) {
            float f = pointF.x;
            i = f == 0.0f ? 0 : f > 0.0f ? 1 : -1;
        }
        int iB = b(view, i);
        PointF pointF2 = this.p;
        if (pointF2 != null) {
            float f2 = pointF2.y;
            if (f2 != 0.0f) {
                i2 = f2 > 0.0f ? 1 : -1;
            }
        }
        int iC = c(view, i2);
        int iCeil = (int) Math.ceil(((double) w((int) Math.sqrt((iC * iC) + (iB * iB)))) / 0.3356d);
        if (iCeil > 0) {
            czrVar.a = -iB;
            czrVar.b = -iC;
            czrVar.c = iCeil;
            czrVar.e = this.o;
            czrVar.f = true;
        }
    }

    public final void z() {
        if (this.j) {
            this.j = false;
            this.u = 0;
            this.t = 0;
            this.p = null;
            this.g.bo.a = -1;
            this.k = null;
            this.f = -1;
            this.i = false;
            czg czgVar = this.h;
            if (czgVar.ds == this) {
                czgVar.ds = null;
            }
            this.h = null;
            this.g = null;
        }
    }
}
