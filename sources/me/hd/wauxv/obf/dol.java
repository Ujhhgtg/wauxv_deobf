package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dol extends cnf {
    public int a;
    public int b = -1;
    public final /* synthetic */ SwipeDismissBehavior k;

    public dol(SwipeDismissBehavior swipeDismissBehavior) {
        this.k = swipeDismissBehavior;
    }

    @Override // me.hd.wauxv.obf.cnf
    public final void bp(View view, int i) {
        this.b = i;
        this.a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.k;
            swipeDismissBehavior.g = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.g = false;
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public final int c(View view, int i) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = eqz.a;
        boolean z = view.getLayoutDirection() == 1;
        int i2 = this.k.h;
        if (i2 == 0) {
            if (z) {
                width = this.a - view.getWidth();
                width2 = this.a;
            } else {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i2 != 1) {
            width = this.a - view.getWidth();
            width2 = view.getWidth() + this.a;
        } else if (z) {
            width = this.a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.a - view.getWidth();
            width2 = this.a;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // me.hd.wauxv.obf.cnf
    public final int d(View view, int i) {
        return view.getTop();
    }

    @Override // me.hd.wauxv.obf.cnf
    public final int e(View view) {
        return view.getWidth();
    }

    @Override // me.hd.wauxv.obf.cnf
    public final void g(int i) {
    }

    @Override // me.hd.wauxv.obf.cnf
    public final void h(View view, int i, int i2) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.k;
        float f = width * swipeDismissBehavior.q;
        float width2 = view.getWidth() * swipeDismissBehavior.r;
        float fAbs = Math.abs(i - this.a);
        if (fAbs <= f) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Found duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Found duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Found duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Found duplicated region for block: B:35:0x0067  */
    @Override // me.hd.wauxv.obf.cnf
    public final void i(View view, float f, float f2) {
        int i;
        this.b = -1;
        int width = view.getWidth();
        boolean z = false;
        SwipeDismissBehavior swipeDismissBehavior = this.k;
        if (f != 0.0f) {
            WeakHashMap weakHashMap = eqz.a;
            boolean z2 = view.getLayoutDirection() == 1;
            int i2 = swipeDismissBehavior.h;
            if (i2 != 2 && (i2 != 0 ? i2 != 1 || (!z2 ? f < 0.0f : f > 0.0f) : !z2 ? f > 0.0f : f < 0.0f)) {
                i = this.a;
            } else {
                if (f >= 0.0f) {
                    int left = view.getLeft();
                    int i3 = this.a;
                    i = left < i3 ? this.a - width : i3 + width;
                }
                z = true;
            }
        } else {
            if (Math.abs(view.getLeft() - this.a) >= Math.round(view.getWidth() * 0.5f)) {
                if (f >= 0.0f) {
                    int left2 = view.getLeft();
                    int i32 = this.a;
                    if (left2 < i32) {
                    }
                }
                z = true;
            } else {
                i = this.a;
            }
        }
        if (swipeDismissBehavior.a.ak(i, view.getTop())) {
            cs csVar = new cs(swipeDismissBehavior, view, z);
            WeakHashMap weakHashMap2 = eqz.a;
            view.postOnAnimation(csVar);
        }
    }

    @Override // me.hd.wauxv.obf.cnf
    public final boolean j(View view, int i) {
        int i2 = this.b;
        return (i2 == -1 || i2 == i) && this.k.v(view);
    }
}
