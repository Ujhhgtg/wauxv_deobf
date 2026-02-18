package me.hd.wauxv.obf;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ers extends agr {
    public ert ae;
    public int af = 0;

    public ers() {
    }

    public final int ag() {
        ert ertVar = this.ae;
        if (ertVar != null) {
            return ertVar.d;
        }
        return 0;
    }

    @Override // me.hd.wauxv.obf.agr
    public boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        s(coordinatorLayout, view, i);
        if (this.ae == null) {
            this.ae = new ert(view);
        }
        ert ertVar = this.ae;
        View view2 = ertVar.a;
        ertVar.b = view2.getTop();
        ertVar.c = view2.getLeft();
        this.ae.e();
        int i2 = this.af;
        if (i2 == 0) {
            return true;
        }
        this.ae.f(i2);
        this.af = 0;
        return true;
    }

    public void s(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.ar(view, i);
    }

    public ers(int i) {
    }
}
