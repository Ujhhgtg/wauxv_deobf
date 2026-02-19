package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adg {
    public final ConstraintLayout a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final /* synthetic */ ConstraintLayout h;

    public adg(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.h = constraintLayout;
        this.a = constraintLayout2;
    }

    public static boolean i(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
        }
        return false;
    }

    public final void j(adq adqVar, of ofVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        boolean z;
        int measuredWidth;
        int baseline;
        int i;
        if (adqVar == null) {
            return;
        }
        adb adbVar = adqVar.au;
        adb adbVar2 = adqVar.as;
        if (adqVar.bq == 8) {
            ofVar.e = 0;
            ofVar.f = 0;
            ofVar.g = 0;
            return;
        }
        if (adqVar.bd == null) {
            return;
        }
        dhc dhcVar = ConstraintLayout.a;
        int i2 = ofVar.a;
        int i3 = ofVar.b;
        int i4 = ofVar.c;
        int i5 = ofVar.d;
        int i6 = this.b + this.c;
        int i7 = this.d;
        View view = adqVar.bp;
        int iAe = StaticHelpers6.ae(i2);
        if (iAe == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else if (iAe == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i7, -2);
        } else if (iAe == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i7, -2);
            boolean z2 = adqVar.ab == 1;
            int i8 = ofVar.j;
            if (i8 == 1 || i8 == 2) {
                boolean z3 = view.getMeasuredHeight() == adqVar.cm();
                if (ofVar.j == 2 || !z2 || ((z2 && z3) || adqVar.g())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(adqVar.cq(), 1073741824);
                }
            }
        } else if (iAe != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i9 = this.f;
            int i10 = adbVar2 != null ? adbVar2.g : 0;
            if (adbVar != null) {
                i10 += adbVar.g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i9, i7 + i10, -1);
        }
        int iAe2 = StaticHelpers6.ae(i3);
        if (iAe2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else if (iAe2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i6, -2);
        } else if (iAe2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i6, -2);
            boolean z4 = adqVar.ac == 1;
            int i11 = ofVar.j;
            if (i11 == 1 || i11 == 2) {
                boolean z5 = view.getMeasuredWidth() == adqVar.cq();
                if (ofVar.j == 2 || !z4 || ((z4 && z5) || adqVar.h())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(adqVar.cm(), 1073741824);
                }
            }
        } else if (iAe2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i12 = this.g;
            int i13 = adbVar2 != null ? adqVar.at.g : 0;
            if (adbVar != null) {
                i13 += adqVar.av.g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, i6 + i13, -1);
        }
        adr adrVar = (adr) adqVar.bd;
        ConstraintLayout constraintLayout = this.h;
        if (adrVar != null && HugeSyntheticPileOfHelpers.az(constraintLayout.j, 256) && view.getMeasuredWidth() == adqVar.cq() && view.getMeasuredWidth() < adrVar.cq() && view.getMeasuredHeight() == adqVar.cm() && view.getMeasuredHeight() < adrVar.cm() && view.getBaseline() == adqVar.bk && !adqVar.cz() && i(adqVar.aq, iMakeMeasureSpec, adqVar.cq()) && i(adqVar.ar, iMakeMeasureSpec2, adqVar.cm())) {
            ofVar.e = adqVar.cq();
            ofVar.f = adqVar.cm();
            ofVar.g = adqVar.bk;
            return;
        }
        boolean z6 = i2 == 3;
        boolean z7 = i3 == 3;
        boolean z8 = i3 == 4 || i3 == 1;
        boolean z9 = i2 == 4 || i2 == 1;
        boolean z10 = z6 && adqVar.bg > 0.0f;
        boolean z11 = z7 && adqVar.bg > 0.0f;
        if (view == null) {
            return;
        }
        adf adfVar = (adf) view.getLayoutParams();
        int i14 = ofVar.j;
        if (i14 != 1 && i14 != 2 && z6 && adqVar.ab == 0 && z7 && adqVar.ac == 0) {
            z = false;
            measuredWidth = 0;
            baseline = 0;
            i = -1;
            iMax = 0;
        } else {
            if ((view instanceof esw) && (adqVar instanceof bbp)) {
                ((esw) view).c((bbp) adqVar, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            adqVar.aq = iMakeMeasureSpec;
            adqVar.ar = iMakeMeasureSpec2;
            adqVar.q = false;
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i15 = adqVar.ae;
            int iMax2 = i15 > 0 ? Math.max(i15, measuredWidth2) : measuredWidth2;
            int i16 = adqVar.af;
            if (i16 > 0) {
                iMax2 = Math.min(i16, iMax2);
            }
            int i17 = adqVar.ah;
            iMax = i17 > 0 ? Math.max(i17, measuredHeight) : measuredHeight;
            int i18 = iMakeMeasureSpec2;
            int i19 = adqVar.ai;
            if (i19 > 0) {
                iMax = Math.min(i19, iMax);
            }
            if (!HugeSyntheticPileOfHelpers.az(constraintLayout.j, 1)) {
                if (z10 && z8) {
                    iMax2 = (int) ((iMax * adqVar.bg) + 0.5f);
                } else if (z11 && z9) {
                    iMax = (int) ((iMax2 / adqVar.bg) + 0.5f);
                }
            }
            if (measuredWidth2 == iMax2 && measuredHeight == iMax) {
                baseline = baseline2;
                measuredWidth = iMax2;
                z = false;
            } else {
                if (measuredWidth2 != iMax2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i18;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                adqVar.aq = iMakeMeasureSpec;
                adqVar.ar = iMakeMeasureSpec3;
                z = false;
                adqVar.q = false;
                measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredHeight2;
            }
            i = -1;
        }
        boolean z12 = baseline != i ? true : z;
        ofVar.i = (measuredWidth == ofVar.c && iMax == ofVar.d) ? z : true;
        boolean z13 = adfVar.bc ? true : z12;
        if (z13 && baseline != -1 && adqVar.bk != baseline) {
            ofVar.i = true;
        }
        ofVar.e = measuredWidth;
        ofVar.f = iMax;
        ofVar.h = z13;
        ofVar.g = baseline;
    }
}
