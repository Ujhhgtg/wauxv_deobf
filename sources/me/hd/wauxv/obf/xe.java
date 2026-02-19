package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xe {
    public static final bqv a = new bqv(0);
    public static final bqv b = new bqv(1);
    public int c;
    public final Object d;
    public final Object e;
    public Object f;

    public xe(cio cioVar, int i) {
        this.d = cioVar.f;
        this.c = i;
        ciq ciqVar = cioVar.h;
        this.e = ciqVar.l();
        Bundle bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
        this.f = bundleR;
        ciqVar.h.ab(bundleR);
    }

    public static void g(SomeView someViewVar) {
        View view = someViewVar.d;
        Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            float fFloatValue = ((Float) tag).floatValue();
            WeakHashMap weakHashMap = ViewCompat.a;
            eqq.k(view, fFloatValue);
        }
        view.setTag(R.id.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public static int h(int i, int i2) {
        int i3;
        int i4 = i & 3158064;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 >> 2;
        } else {
            int i6 = i4 >> 1;
            i5 |= (-3158065) & i6;
            i3 = (i6 & 3158064) >> 2;
        }
        return i5 | i3;
    }

    public static int i(int i, int i2) {
        int i3;
        int i4 = i & 789516;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 << 2;
        } else {
            int i6 = i4 << 1;
            i5 |= (-789517) & i6;
            i3 = (i6 & 789516) << 2;
        }
        return i5 | i3;
    }

    public static void j(RecyclerView recyclerView, SomeView someViewVar, float f, float f2, boolean z) {
        View view = someViewVar.d;
        if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            Float fValueOf = Float.valueOf(eqq.e(view));
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    WeakHashMap weakHashMap2 = ViewCompat.a;
                    float fE = eqq.e(childAt);
                    if (fE > f3) {
                        f3 = fE;
                    }
                }
            }
            eqq.k(view, f3 + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    public cjg k(int i, cjg cjgVar, cjg cjgVar2, boolean z) {
        cji cjiVar = (cji) this.d;
        dlo dloVar = (dlo) this.e;
        cjg cjgVarK = (cjg) dloVar.f(i);
        if (cjgVar2 != null) {
            if (nullSafeIsEqual(cjgVarK, cjgVar2) && nullSafeIsEqual(cjgVarK.h, cjgVar2.h)) {
                return cjgVarK;
            }
            cjgVarK = null;
        } else if (cjgVarK != null) {
            return cjgVarK;
        }
        if (z) {
            Iterator it = ((ada) dfv.a(new z(dloVar, 3))).iterator();
            do {
                if (!it.hasNext()) {
                    cjgVarK = null;
                    break;
                }
                cjg cjgVar3 = (cjg) it.next();
                cjgVarK = (!(cjgVar3 instanceof cji) || cjgVar3.equals(cjgVar)) ? null
                        : ((cji) cjgVar3).b.k(i, cjiVar, cjgVar2, true);
            } while (cjgVarK == null);
        }
        if (cjgVarK != null) {
            return cjgVarK;
        }
        cji cjiVar2 = cjiVar.h;
        if (cjiVar2 == null || cjiVar2.equals(cjgVar)) {
            return null;
        }
        cji cjiVar3 = cjiVar.h;
        throwIfVar1IsNull(cjiVar3);
        return cjiVar3.b.k(i, cjiVar, cjgVar2, z);
    }

    public int l(RecyclerView recyclerView, int i, int i2, long j) {
        if (this.c == -1) {
            this.c = recyclerView.getResources()
                    .getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        }
        int interpolation = (int) (a.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f)
                * ((int) (b.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)) * ((int) Math.signum(i2))
                        * this.c)));
        return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
    }

    public cjf m(cjf cjfVar, FactoryPools factoryPoolsVar, boolean z, cjg cjgVar) {
        cjf cjfVarQ;
        cji cjiVar = (cji) this.d;
        ArrayList arrayList = new ArrayList();
        Iterator it = cjiVar.iterator();
        while (true) {
            cjj cjjVar = (cjj) it;
            if (!cjjVar.hasNext()) {
                break;
            }
            cjg cjgVar2 = (cjg) cjjVar.next();
            cjfVarQ = nullSafeIsEqual(cjgVar2, cjgVar) ? null : cjgVar2.o(factoryPoolsVar);
            if (cjfVarQ != null) {
                arrayList.add(cjfVarQ);
            }
        }
        cjf cjfVar2 = (cjf) StaticHelpers5.n(arrayList);
        cji cjiVar2 = cjiVar.h;
        if (cjiVar2 != null && z && !cjiVar2.equals(cjgVar)) {
            cjfVarQ = cjiVar2.q(factoryPoolsVar, cjiVar);
        }
        return (cjf) StaticHelpers5.n(SomeStaticHelpers.o(new cjf[] { cjfVar, cjfVar2, cjfVarQ }));
    }

    public xe(cji cjiVar) {
        this.d = cjiVar;
        this.e = new dlo(0);
    }

    public xe(Bundle bundle) {
        throwIfVar1IsNull(bundle, "state");
        String string = bundle.getString("nav-entry-state:id");
        if (string != null) {
            this.d = string;
            this.c = KotlinHelpers.v("nav-entry-state:destination-id", bundle);
            Bundle bundle2 = bundle.getBundle("nav-entry-state:args");
            if (bundle2 != null) {
                this.e = bundle2;
                Bundle bundle3 = bundle.getBundle("nav-entry-state:saved-state");
                if (bundle3 != null) {
                    this.f = bundle3;
                    return;
                } else {
                    cmz.ad("nav-entry-state:saved-state");
                    throw null;
                }
            }
            cmz.ad("nav-entry-state:args");
            throw null;
        }
        cmz.ad("nav-entry-state:id");
        throw null;
    }

    public xe(RecyclerView recyclerView, List list, cyw cywVar) {
        this.f = recyclerView;
        this.c = -1;
        this.d = list;
        this.e = cywVar;
    }
}
