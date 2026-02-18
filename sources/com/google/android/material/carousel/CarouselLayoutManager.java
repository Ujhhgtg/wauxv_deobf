package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.chi;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.czg;
import me.hd.wauxv.obf.czh;
import me.hd.wauxv.obf.czo;
import me.hd.wauxv.obf.czs;
import me.hd.wauxv.obf.czt;
import me.hd.wauxv.obf.tf;
import me.hd.wauxv.obf.tg;
import me.hd.wauxv.obf.th;
import me.hd.wauxv.obf.ti;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends czg implements czs {
    public final chi a;
    public ti b;
    public final View.OnLayoutChangeListener c;

    public CarouselLayoutManager() {
        chi chiVar = new chi();
        new th();
        this.c = new tf(this, 0);
        this.a = chiVar;
        ff();
        h(0);
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean _g(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void _h(View view, Rect rect) {
        super._h(view, rect);
        rect.centerY();
        if (f()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ac(int i, int i2) {
        et();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ae(czo czoVar, czt cztVar) {
        if (cztVar.p() > 0) {
            if ((f() ? this.eb : this.ec) > 0.0f) {
                g();
                View view = czoVar.s(0, Long.MAX_VALUE).d;
                throw new IllegalStateException(
                        "All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
            }
        }
        fb(czoVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void af(czt cztVar) {
        if (es() == 0) {
            return;
        }
        czg.el(er(0));
    }

    @Override // me.hd.wauxv.obf.czg
    public final int ah(int i, czo czoVar, czt cztVar) {
        if (!f() || es() == 0 || i == 0) {
            return 0;
        }
        View view = czoVar.s(0, Long.MAX_VALUE).d;
        throw new IllegalStateException(
                "All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // me.hd.wauxv.obf.czg
    public final int ai(int i, czo czoVar, czt cztVar) {
        if (!bv() || es() == 0 || i == 0) {
            return 0;
        }
        View view = czoVar.s(0, Long.MAX_VALUE).d;
        throw new IllegalStateException(
                "All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // me.hd.wauxv.obf.czs
    public final PointF bs(int i) {
        return null;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean bu() {
        return f();
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean bv() {
        return !f();
    }

    @Override // me.hd.wauxv.obf.czg
    public final int by(czt cztVar) {
        es();
        return 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int bz(czt cztVar) {
        es();
        return 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean cb() {
        return true;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void cd(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.c);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ce(AccessibilityEvent accessibilityEvent) {
        super.ce(accessibilityEvent);
        if (es() > 0) {
            accessibilityEvent.setFromIndex(czg.el(er(0)));
            accessibilityEvent.setToIndex(czg.el(er(es() - 1)));
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ch(int i) {
    }

    @Override // me.hd.wauxv.obf.czg
    public final void cj(RecyclerView recyclerView, czt cztVar, int i) {
        tg tgVar = new tg(this, recyclerView.getContext());
        tgVar.f = i;
        fm(tgVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void dm(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        chi chiVar = this.a;
        float dimension = chiVar.a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        chiVar.a = dimension;
        float dimension2 = chiVar.b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        chiVar.b = dimension2;
        ff();
        recyclerView.addOnLayoutChangeListener(this.c);
    }

    public final boolean f() {
        return this.b.a == 0;
    }

    public final boolean g() {
        return f() && this.dp.getLayoutDirection() == 1;
    }

    public final void h(int i) {
        ti tiVar;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(concatVar2Var1(i, "invalid orientation:"));
        }
        bt(null);
        ti tiVar2 = this.b;
        if (tiVar2 == null || i != tiVar2.a) {
            if (i == 0) {
                tiVar = new ti(this, 1);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                tiVar = new ti(this, 0);
            }
            this.b = tiVar;
            ff();
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final int n(czt cztVar) {
        return 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int o(czt cztVar) {
        return 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int p(czt cztVar) {
        return 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int q(czt cztVar) {
        return 0;
    }

    @Override // me.hd.wauxv.obf.czg
    public final czh r() {
        return new czh(-2, -2);
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x0038 */
    /* JADX WARN: Found duplicated region for block: B:20:0x003c */
    /* JADX WARN: Found duplicated region for block: B:24:0x0046 */
    @Override // me.hd.wauxv.obf.czg
    public final View w(View view, int i, czo czoVar, czt cztVar) {
        byte b;
        if (es() == 0) {
            return null;
        }
        int i2 = this.b.a;
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                Log.d("CarouselLayoutManager", "Unknown focus request:" + i);
                            } else if (i2 == 1) {
                            }
                        } else {
                            b = i2 == 0 ? g() ? (byte) -1 : (byte) 1 : (byte) -2147483648;
                        }
                    } else if (i2 == 1) {
                    }
                } else if (i2 == 0) {
                    if (g()) {
                    }
                }
            }
        }
        if (b == -2147483648) {
            return null;
        }
        if (b == -1) {
            if (czg.el(view) == 0) {
                return null;
            }
            int iEl = czg.el(er(0)) - 1;
            if (iEl < 0 || iEl >= et()) {
                return er(g() ? es() - 1 : 0);
            }
            this.b.d();
            throw null;
        }
        if (czg.el(view) == et() - 1) {
            return null;
        }
        int iEl2 = czg.el(er(es() - 1)) + 1;
        if (iEl2 < 0 || iEl2 >= et()) {
            return er(g() ? 0 : es() - 1);
        }
        this.b.d();
        throw null;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void z(int i, int i2) {
        et();
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        new th();
        this.c = new tf(this, 0);
        this.a = new chi();
        ff();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.g);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            ff();
            locateDex(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
