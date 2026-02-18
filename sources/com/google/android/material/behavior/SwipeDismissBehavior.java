package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.dol;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.era;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends agr {
    public era a;
    public boolean f;
    public boolean g;
    public int h = 2;
    public float q = 0.0f;
    public float r = 0.5f;
    public final dol s = new dol(this);

    @Override // me.hd.wauxv.obf.agr
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = eqz.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            eqz.p(view, 1048576);
            eqz.n(view, 0);
            if (v(view)) {
                eqz.q(view, ax.f, new bmu(this));
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.agr
    public boolean t(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zAo = this.f;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zAo = coordinatorLayout.ao(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f = zAo;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f = false;
        }
        if (zAo) {
            if (this.a == null) {
                this.a = new era(coordinatorLayout.getContext(), coordinatorLayout, this.s);
            }
            if (!this.g && this.a.al(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.agr
    public final boolean u(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        if (this.g && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.a.af(motionEvent);
        return true;
    }

    public boolean v(View view) {
        return true;
    }
}
