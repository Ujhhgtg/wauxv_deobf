package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsetsController;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bax {
    public boolean a;
    public DialogXBaseRelativeLayout b;
    public erp c;
    public ng d;
    public pw e;
    public baw f;
    public int g;
    public boolean h;
    public bav i;

    public final void j(baw bawVar) {
        erp erpVar = this.c;
        if (erpVar == null) {
            return;
        }
        bawVar.a = erpVar.y(1) + bawVar.a;
        bawVar.b = this.c.y(2) + bawVar.b;
        bawVar.c = this.c.y(3) + bawVar.c;
        int iY = this.c.y(4) + bawVar.d;
        bawVar.d = iY;
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = this.b;
        if (dialogXBaseRelativeLayout == null) {
            int i = bawVar.a;
            int i2 = bawVar.b;
            int i3 = bawVar.c;
            WeakHashMap weakHashMap = ViewCompat.a;
            dialogXBaseRelativeLayout.setPaddingRelative(i, i2, i3, iY);
        }
        int i4 = bawVar.a;
        int i5 = bawVar.b;
        int i6 = bawVar.c;
        int i7 = bawVar.d;
        boolean z = this.h;
        int i8 = this.g;
        int i9 = DialogXBaseRelativeLayout.a;
        erp erpVar2 = this.c;
        if (!z) {
            i8 = 0;
        }
        int i10 = i7 + i8;
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout2 = (DialogXBaseRelativeLayout) erpVar2.v;
        if (dialogXBaseRelativeLayout2.o == null) {
            dialogXBaseRelativeLayout2.o = new Rect();
        }
        bps bpsVar = null;
        if (dialogXBaseRelativeLayout2.getRootWindowInsets() != null) {
            evo evoVar = evr.d(null, dialogXBaseRelativeLayout2.getRootWindowInsets()).second;
            boolean zR = evoVar.r(2);
            if (!evoVar.r(8) && zR) {
                bps bpsVarN = evoVar.n(519);
                if (bpsVarN.e != i10 || bpsVarN.c != i5 || bpsVarN.b != i4 || bpsVarN.d != i6) {
                    bpsVar = bpsVarN;
                }
            }
        }
        if (bpsVar != null) {
            dialogXBaseRelativeLayout2.o.left = Math.max(bpsVar.b, i4);
            dialogXBaseRelativeLayout2.o.top = Math.max(bpsVar.c, i5);
            dialogXBaseRelativeLayout2.o.right = Math.max(bpsVar.d, i6);
            dialogXBaseRelativeLayout2.o.bottom = Math.max(bpsVar.e, i10);
        } else {
            Rect rect = dialogXBaseRelativeLayout2.o;
            rect.left = i4;
            rect.top = i5;
            rect.right = i6;
            rect.bottom = i10;
        }
        bfm bfmVar = dialogXBaseRelativeLayout2.b;
        if (bfmVar != null) {
            Rect rect2 = dialogXBaseRelativeLayout2.o;
            bfo bfoVar = bfmVar.b;
            bfoVar.j.set(rect2);
            bfoVar.p();
            if (!bfoVar.k && bfoVar.o() != 0.0f) {
                bfoVar.e.setY(bfoVar.o());
            }
        }
        Rect rect3 = dialogXBaseRelativeLayout2.o;
        dialogXBaseRelativeLayout2.u(rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    public final void k(evr evrVar, baw bawVar) {
        int iE;
        int iF;
        int iD;
        int iE2;
        int rotation;
        if (this.b == null || evrVar == null) {
            return;
        }
        evo evoVar = evrVar.b;
        this.f = bawVar;
        aow aowVarAf = evoVar.af();
        if (aowVarAf != null) {
            int i = Build.VERSION.SDK_INT;
            iF = i >= 28 ? aov.f(aowVarAf.a) : 0;
            iD = i >= 28 ? aov.d(aowVarAf.a) : 0;
            iE2 = i >= 28 ? aov.e(aowVarAf.a) : 0;
            iE = i >= 28 ? aov.e(aowVarAf.a) : 0;
        } else {
            iE = 0;
            iF = 0;
            iD = 0;
            iE2 = 0;
        }
        bps bpsVarN = evoVar.n(527);
        int i2 = bpsVarN.b;
        int i3 = bpsVarN.c;
        int i4 = bpsVarN.e;
        int i5 = bpsVarN.d;
        int windowSystemUiVisibility = this.b.getRootView().getWindowSystemUiVisibility();
        int i6 = Build.VERSION.SDK_INT;
        boolean z = i6 >= 30 || (windowSystemUiVisibility & 4) == 0;
        int i7 = ((i6 >= 30 || (windowSystemUiVisibility & 2) == 0) && (evoVar.r(8) || evoVar.r(2))) ? i4 : 0;
        int i8 = (z && evoVar.r(1)) ? i3 : 0;
        if (i3 == 0 && i4 == 0 && bpsVarN.b == 0 && i5 == 0) {
            int i9 = DialogXBaseRelativeLayout.a;
            ng ngVar = this.d;
            Activity activityAe = ngVar == null ? ng.ae() : ngVar.as();
            if (activityAe != null && activityAe.getResources().getConfiguration().orientation == 2
                    && (rotation = activityAe.getWindowManager().getDefaultDisplay().getRotation()) != 1
                    && rotation == 3) {
                bawVar.c = n();
                bawVar.a = m();
            } else {
                bawVar.b = n();
                bawVar.d = m();
            }
            this.h = true;
            View viewL = l();
            if (viewL != null) {
                if (this.i != null) {
                    viewL.getViewTreeObserver().removeOnGlobalLayoutListener(this.i);
                }
                ViewTreeObserver viewTreeObserver = viewL.getViewTreeObserver();
                bav bavVar = new bav(this, viewL);
                this.i = bavVar;
                viewTreeObserver.addOnGlobalLayoutListener(bavVar);
            }
        } else {
            this.h = false;
            this.c.getClass();
            bawVar.b = Math.max(i8, iF) + bawVar.b;
            this.c.getClass();
            bawVar.d = Math.max(i7, iE) + bawVar.d;
            DialogXBaseRelativeLayout dialogXBaseRelativeLayout = this.b;
            WeakHashMap weakHashMap = ViewCompat.a;
            boolean z2 = dialogXBaseRelativeLayout.getLayoutDirection() == 1;
            this.c.getClass();
            if (z2) {
                bawVar.a = Math.max(i5, iE2) + bawVar.a;
            } else {
                bawVar.a = Math.max(i2, iD) + bawVar.a;
            }
            this.c.getClass();
            if (z2) {
                bawVar.c = Math.max(i2, iD) + bawVar.c;
            } else {
                bawVar.c = Math.max(i5, iE2) + bawVar.c;
            }
        }
        j(bawVar);
    }

    public final View l() {
        ng ngVar = this.d;
        Activity activityAe = ngVar == null ? ng.ae() : ngVar.as();
        if (activityAe == null) {
            return null;
        }
        return activityAe.getWindow().getDecorView();
    }

    public final int m() {
        if (!o() && l() != null) {
            int i = Build.VERSION.SDK_INT;
            WindowInsetsController windowInsetsController = i >= 30 ? l().getWindowInsetsController() : null;
            if (i >= 30 && windowInsetsController != null
                    && (windowInsetsController.getSystemBarsBehavior() & 16) == 0) {
                int i2 = DialogXBaseRelativeLayout.a;
                return 0;
            }
            DialogXBaseRelativeLayout dialogXBaseRelativeLayout = this.b;
            Resources system = (dialogXBaseRelativeLayout == null || dialogXBaseRelativeLayout.getContext() == null)
                    ? Resources.getSystem()
                    : this.b.getContext().getResources();
            int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return system.getDimensionPixelSize(identifier);
            }
        }
        return 0;
    }

    public final int n() {
        if (o() || l() == null) {
            return 0;
        }
        int i = Build.VERSION.SDK_INT;
        WindowInsetsController windowInsetsController = i >= 30 ? l().getWindowInsetsController() : null;
        if (i >= 30 && windowInsetsController != null && (windowInsetsController.getSystemBarsBehavior() & 8192) == 0) {
            return 0;
        }
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = this.b;
        Resources system = (dialogXBaseRelativeLayout == null || dialogXBaseRelativeLayout.getContext() == null)
                ? Resources.getSystem()
                : this.b.getContext().getResources();
        int identifier = system.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean o() {
        ng ngVar = this.d;
        Activity activityAe = ngVar == null ? ng.ae() : ngVar.as();
        if (activityAe == null) {
            return false;
        }
        return ((activityAe.getWindow().getAttributes().flags & 1024) == 0
                && (activityAe.getWindow().getDecorView().getSystemUiVisibility() & 4) == 0) ? false : true;
    }
}
