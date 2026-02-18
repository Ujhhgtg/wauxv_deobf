package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class qd extends cnf {
    public final /* synthetic */ int a;
    public final /* synthetic */ agr b;

    public /* synthetic */ qd(agr agrVar, int i) {
        this.a = i;
        this.b = agrVar;
    }

    @Override // me.hd.wauxv.obf.cnf
    public final int c(View view, int i) {
        switch (this.a) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
                return cnf.as(i, sideSheetBehavior.f.h(), sideSheetBehavior.f.g());
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public final int d(View view, int i) {
        switch (this.a) {
            case 0:
                return cnf.as(i, ((BottomSheetBehavior) this.b).cb(), f());
            default:
                return view.getTop();
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public int e(View view) {
        switch (this.a) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
                return sideSheetBehavior.aa + sideSheetBehavior.ad;
            default:
                return super.e(view);
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public int f() {
        switch (this.a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                return bottomSheetBehavior.aw ? bottomSheetBehavior.bh : bottomSheetBehavior.au;
            default:
                return super.f();
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public final void g(int i) {
        switch (this.a) {
            case 0:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                    if (bottomSheetBehavior.ay) {
                        bottomSheetBehavior.cg(1);
                    }
                }
                break;
            default:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
                    if (sideSheetBehavior.v) {
                        sideSheetBehavior.al(1);
                    }
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public final void h(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.a) {
            case 0:
                ((BottomSheetBehavior) this.b).ca(i2);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
                WeakReference weakReference = sideSheetBehavior.af;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f.p(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.aj;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f.d(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw yg.d(it);
                }
                return;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Found duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Found duplicated region for block: B:57:0x00e9  */
    @Override // me.hd.wauxv.obf.cnf
    public final void i(View view, float f, float f2) {
        int i;
        switch (this.a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                int i2 = 6;
                if (f2 < 0.0f) {
                    if (!bottomSheetBehavior.f) {
                        int top = view.getTop();
                        System.currentTimeMillis();
                        bottomSheetBehavior.getClass();
                        if (top <= bottomSheetBehavior.as) {
                        }
                    }
                } else if (bottomSheetBehavior.aw && bottomSheetBehavior.ch(view, f2)) {
                    if (Math.abs(f) >= Math.abs(f2) || f2 <= bottomSheetBehavior.h) {
                        if (view.getTop() > (bottomSheetBehavior.cb() + bottomSheetBehavior.bh) / 2) {
                            i2 = 5;
                        } else if (bottomSheetBehavior.f || Math.abs(view.getTop() - bottomSheetBehavior.cb()) < Math.abs(view.getTop() - bottomSheetBehavior.as)) {
                        }
                    } else {
                        i2 = 5;
                    }
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top2 = view.getTop();
                    if (bottomSheetBehavior.f) {
                        i2 = Math.abs(top2 - bottomSheetBehavior.ar) < Math.abs(top2 - bottomSheetBehavior.au) ? 3 : 4;
                    } else {
                        int i3 = bottomSheetBehavior.as;
                        if (top2 < i3) {
                            if (top2 >= Math.abs(top2 - bottomSheetBehavior.au)) {
                                bottomSheetBehavior.getClass();
                            }
                        } else if (Math.abs(top2 - i3) < Math.abs(top2 - bottomSheetBehavior.au)) {
                            bottomSheetBehavior.getClass();
                        }
                    }
                } else if (!bottomSheetBehavior.f) {
                    int top3 = view.getTop();
                    if (Math.abs(top3 - bottomSheetBehavior.as) < Math.abs(top3 - bottomSheetBehavior.au)) {
                        bottomSheetBehavior.getClass();
                    }
                }
                bottomSheetBehavior.getClass();
                bottomSheetBehavior.ci(view, i2, true);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
                if (!sideSheetBehavior.f.l(f)) {
                    if (sideSheetBehavior.f.o(view, f)) {
                        i = (sideSheetBehavior.f.n(f, f2) || sideSheetBehavior.f.m(view)) ? 5 : 3;
                    } else {
                        if (f == 0.0f || Math.abs(f) <= Math.abs(f2)) {
                            int left = view.getLeft();
                            if (Math.abs(left - sideSheetBehavior.f.e()) < Math.abs(left - sideSheetBehavior.f.f())) {
                            }
                        }
                    }
                }
                sideSheetBehavior.an(view, i, true);
                break;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:31:0x0048  */
    @Override // me.hd.wauxv.obf.cnf
    public final boolean j(View view, int i) {
        WeakReference weakReference;
        WeakReference weakReference2;
        switch (this.a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                int i2 = bottomSheetBehavior.az;
                if (i2 != 1 && !bottomSheetBehavior.bo) {
                    if (i2 == 3 && bottomSheetBehavior.bm == i) {
                        WeakReference weakReference3 = bottomSheetBehavior.bj;
                        View view2 = weakReference3 != null ? (View) weakReference3.get() : null;
                        if (view2 == null || !view2.canScrollVertically(-1)) {
                            System.currentTimeMillis();
                            weakReference = bottomSheetBehavior.bi;
                            if (weakReference == null) {
                            }
                        }
                    } else {
                        System.currentTimeMillis();
                        weakReference = bottomSheetBehavior.bi;
                        if (weakReference == null && weakReference.get() == view) {
                            return true;
                        }
                    }
                }
                return false;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
                return (sideSheetBehavior.w == 1 || (weakReference2 = sideSheetBehavior.ae) == null || weakReference2.get() != view) ? false : true;
        }
    }
}
