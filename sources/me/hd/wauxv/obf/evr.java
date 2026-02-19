package me.hd.wauxv.obf;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class evr {
    public static final evr a;
    public final evo b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            a = evn.an;
        } else if (i >= 30) {
            a = evl.am;
        } else {
            a = evo.ao;
        }
    }

    public evr(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.b = new evn(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.b = new evm(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.b = new evl(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.b = new evk(this, windowInsets);
        } else if (i >= 28) {
            this.b = new evj(this, windowInsets);
        } else {
            this.b = new evi(this, windowInsets);
        }
    }

    public static bps c(bps bpsVar, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, bpsVar.b - i);
        int iMax2 = Math.max(0, bpsVar.c - i2);
        int iMax3 = Math.max(0, bpsVar.d - i3);
        int iMax4 = Math.max(0, bpsVar.e - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? bpsVar : bps.g(iMax, iMax2, iMax3, iMax4);
    }

    public static evr d(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        evr evrVar = new evr(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = ViewCompat.a;
            evr evrVarA = eqr.a(view);
            evo evoVar = evrVar.b;
            evoVar.t(evrVarA);
            evoVar.m(view.getRootView());
            evoVar.u(view.getWindowSystemUiVisibility());
        }
        return evrVar;
    }

    public final int e() {
        return this.b.o().e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof evr) {
            return Objects.equals(this.b, ((evr) obj).b);
        }
        return false;
    }

    public final int f() {
        return this.b.o().b;
    }

    public final int g() {
        return this.b.o().d;
    }

    public final int h() {
        return this.b.o().c;
    }

    public final int hashCode() {
        evo evoVar = this.b;
        if (evoVar == null) {
            return 0;
        }
        return evoVar.hashCode();
    }

    public final WindowInsets i() {
        evo evoVar = this.b;
        if (evoVar instanceof evh) {
            return ((evh) evoVar).f;
        }
        return null;
    }

    public evr() {
        this.b = new evo(this);
    }
}
