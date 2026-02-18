package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import me.hd.wauxv.obf.afi;
import me.hd.wauxv.obf.aju;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cq;
import me.hd.wauxv.obf.cw;
import me.hd.wauxv.obf.ekt;
import me.hd.wauxv.obf.esg;
import me.hd.wauxv.obf.hq;
import me.hd.wauxv.obf.ic;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public TypedValue a;
    public TypedValue b;
    public TypedValue c;
    public TypedValue d;
    public TypedValue e;
    public TypedValue f;
    public final Rect g;
    public afi h;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        afi afiVar = this.h;
        if (afiVar != null) {
            afiVar.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        cw cwVar;
        super.onDetachedFromWindow();
        afi afiVar = this.h;
        if (afiVar != null) {
            ic icVar = ((hq) afiVar).b;
            aju ajuVar = icVar.ae;
            if (ajuVar != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ajuVar;
                actionBarOverlayLayout.ap();
                ActionMenuView actionMenuView = ((ekt) actionBarOverlayLayout.h).a.a;
                if (actionMenuView != null && (cwVar = actionMenuView.g) != null) {
                    cwVar.ag();
                    cq cqVar = cwVar.u;
                    if (cqVar != null && cqVar.p()) {
                        cqVar.l.dismiss();
                    }
                }
            }
            if (icVar.aj != null) {
                icVar.y.getDecorView().removeCallbacks(icVar.ak);
                if (icVar.aj.isShowing()) {
                    try {
                        icVar.aj.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                icVar.aj = null;
            }
            esg esgVar = icVar.al;
            if (esgVar != null) {
                esgVar.c();
            }
            cbw cbwVar = icVar.ci(0).h;
            if (cbwVar != null) {
                cbwVar.ab(true);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Found duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Found duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Found duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Found duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Found duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Found duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int iMakeMeasureSpec2;
        int i3;
        int i4;
        float fraction;
        int i5;
        int i6;
        float fraction2;
        int i7;
        int i8;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        Rect rect = this.g;
        if (mode != Integer.MIN_VALUE) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            TypedValue typedValue = z3 ? this.d : this.c;
            if (typedValue == null || (i7 = typedValue.type) == 0) {
                iMakeMeasureSpec = i;
                z = false;
            } else {
                if (i7 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i7 == 6) {
                        int i9 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i9, i9);
                    } else {
                        i8 = 0;
                    }
                    if (i8 > 0) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect.left + rect.right), View.MeasureSpec.getSize(i)), 1073741824);
                        z = true;
                    } else {
                        iMakeMeasureSpec = i;
                        z = false;
                    }
                }
                i8 = (int) fraction3;
                if (i8 > 0) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect.left + rect.right), View.MeasureSpec.getSize(i)), 1073741824);
                    z = true;
                } else {
                    iMakeMeasureSpec = i;
                    z = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.e : this.f;
            if (typedValue2 != null && (i5 = typedValue2.type) != 0) {
                if (i5 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i5 == 6) {
                        int i10 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i10, i10);
                    } else {
                        i6 = 0;
                    }
                    iMakeMeasureSpec2 = i6 > 0 ? View.MeasureSpec.makeMeasureSpec(Math.min(i6 - (rect.top + rect.bottom), View.MeasureSpec.getSize(i2)), 1073741824) : i2;
                }
                i6 = (int) fraction2;
                if (i6 > 0) {
                }
            }
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z || mode != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            TypedValue typedValue3 = z3 ? this.b : this.a;
            if (typedValue3 == null || (i3 = typedValue3.type) == 0) {
                z2 = false;
            } else {
                if (i3 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i3 == 6) {
                        int i11 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i11, i11);
                    } else {
                        i4 = 0;
                    }
                    if (i4 > 0) {
                        i4 -= rect.left + rect.right;
                    }
                    if (measuredWidth < i4) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    } else {
                        z2 = false;
                    }
                }
                i4 = (int) fraction;
                if (i4 > 0) {
                    i4 -= rect.left + rect.right;
                }
                if (measuredWidth < i4) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else {
                    z2 = false;
                }
            }
        }
        if (z2) {
            super.onMeasure(iMakeMeasureSpec3, iMakeMeasureSpec2);
        }
    }

    public void setAttachListener(afi afiVar) {
        this.h = afiVar;
    }
}
