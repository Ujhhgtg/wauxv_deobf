package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class buc extends StaticAndroidHelpers {
    public final /* synthetic */ int a;
    public final SideSheetBehavior b;

    public /* synthetic */ buc(SideSheetBehavior sideSheetBehavior, int i) {
        this.a = i;
        this.b = sideSheetBehavior;
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.a) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final float d(int i) {
        switch (this.a) {
            case 0:
                float f = f();
                return (i - f) / (e() - f);
            default:
                float f2 = this.b.ab;
                return (f2 - i) / (f2 - e());
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int e() {
        switch (this.a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.b;
                return Math.max(0, sideSheetBehavior.ac + sideSheetBehavior.ad);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.b;
                return Math.max(0, (sideSheetBehavior2.ab - sideSheetBehavior2.aa) - sideSheetBehavior2.ad);
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int f() {
        switch (this.a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.b;
                return (-sideSheetBehavior.aa) - sideSheetBehavior.ad;
            default:
                return this.b.ab;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int g() {
        switch (this.a) {
            case 0:
                return this.b.ad;
            default:
                return this.b.ab;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int h() {
        switch (this.a) {
            case 0:
                return -this.b.aa;
            default:
                return e();
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int i(View view) {
        switch (this.a) {
            case 0:
                return view.getRight() + this.b.ad;
            default:
                return view.getLeft() - this.b.ad;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int j(CoordinatorLayout coordinatorLayout) {
        switch (this.a) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final int k() {
        switch (this.a) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final boolean l(float f) {
        switch (this.a) {
            case 0:
                return f > 0.0f;
            default:
                return f < 0.0f;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final boolean m(View view) {
        switch (this.a) {
            case 0:
                return view.getRight() < (e() - f()) / 2;
            default:
                return view.getLeft() > (e() + this.b.ab) / 2;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final boolean n(float f, float f2) {
        switch (this.a) {
            case 0:
                return Math.abs(f) > Math.abs(f2) && Math.abs(f) > ((float) 500);
            default:
                return Math.abs(f) > Math.abs(f2) && Math.abs(f) > ((float) 500);
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final boolean o(View view, float f) {
        switch (this.a) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.b;
                float fAbs = Math.abs((f * sideSheetBehavior.z) + left);
                sideSheetBehavior.getClass();
                return fAbs > 0.5f;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.b;
                float fAbs2 = Math.abs((f * sideSheetBehavior2.z) + right);
                sideSheetBehavior2.getClass();
                return fAbs2 > 0.5f;
        }
    }

    @Override // me.hd.wauxv.obf.ewz
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        switch (this.a) {
            case 0:
                if (i <= this.b.ab) {
                    marginLayoutParams.leftMargin = i2;
                }
                break;
            default:
                int i3 = this.b.ab;
                if (i <= i3) {
                    marginLayoutParams.rightMargin = i3 - i;
                }
                break;
        }
    }
}
