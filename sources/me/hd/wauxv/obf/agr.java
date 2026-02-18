package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class agr {
    public boolean a(View view) {
        return false;
    }

    public boolean b(View view, View view2) {
        return false;
    }

    public void bu(agu aguVar) {
    }

    public void bv() {
    }

    public boolean bw(View view) {
        return false;
    }

    public boolean c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public void d(CoordinatorLayout coordinatorLayout, View view) {
    }

    public boolean e(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
        return false;
    }

    public boolean i(CoordinatorLayout coordinatorLayout, View view, int i) {
        return false;
    }

    public boolean j(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return false;
    }

    public void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
    }

    public void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        iArr[0] = iArr[0] + i2;
        iArr[1] = iArr[1] + i3;
    }

    public void m(View view, Parcelable parcelable) {
    }

    public Parcelable n(View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return false;
    }

    public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
    }

    public boolean t(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean u(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }
}
