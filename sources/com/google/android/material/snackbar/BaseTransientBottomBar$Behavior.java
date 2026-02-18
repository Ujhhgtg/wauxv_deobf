package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import me.hd.wauxv.obf.bc;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.nw;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final nu w;

    public BaseTransientBottomBar$Behavior() {
        nu nuVar = new nu(0);
        this.q = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.r = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.h = 0;
        this.w = nuVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, me.hd.wauxv.obf.agr
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.w.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (bc.a == null) {
                    bc.a = new bc(5);
                }
                synchronized (bc.a.e) {
                }
            }
        } else if (coordinatorLayout.ao(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (bc.a == null) {
                bc.a = new bc(5);
            }
            synchronized (bc.a.e) {
            }
        }
        return super.t(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean v(View view) {
        this.w.getClass();
        return view instanceof nw;
    }
}
