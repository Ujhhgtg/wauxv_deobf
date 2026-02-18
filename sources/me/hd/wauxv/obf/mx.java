package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mx extends Drawable implements dqj {
    public final WeakReference a;
    public final cau b;
    public final dqk c;
    public final Rect d;
    public final mz e;
    public float f;
    public float g;
    public final int h;
    public float i;
    public float j;
    public float k;
    public WeakReference l;
    public WeakReference m;

    public mx(Context context, my myVar) {
        dqh dqhVar;
        WeakReference weakReference = new WeakReference(context);
        this.a = weakReference;
        bhu.r(context, bhu.m, "Theme.MaterialComponents");
        this.d = new Rect();
        dqk dqkVar = new dqk(this);
        this.c = dqkVar;
        Paint.Align align = Paint.Align.CENTER;
        TextPaint textPaint = dqkVar.a;
        textPaint.setTextAlign(align);
        mz mzVar = new mz(context, myVar);
        this.e = mzVar;
        boolean zS = s();
        my myVar2 = mzVar.b;
        cau cauVar = new cau(dgm.m(context, zS ? myVar2.g.intValue() : myVar2.e.intValue(), s() ? myVar2.h.intValue() : myVar2.f.intValue(), new o(0)).m());
        this.b = cauVar;
        u();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && dqkVar.g != (dqhVar = new dqh(context2, myVar2.d.intValue()))) {
            dqkVar.j(dqhVar, context2);
            textPaint.setColor(myVar2.c.intValue());
            invalidateSelf();
            w();
            invalidateSelf();
        }
        int i = myVar2.l;
        if (i != -2) {
            this.h = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
        } else {
            this.h = myVar2.m;
        }
        dqkVar.e = true;
        w();
        invalidateSelf();
        dqkVar.e = true;
        u();
        w();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(myVar2.b.intValue());
        if (cauVar.ct.d != colorStateListValueOf) {
            cauVar.dz(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(myVar2.c.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.l;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.l.get();
            WeakReference weakReference3 = this.m;
            v(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        w();
        setVisible(myVar2.t.booleanValue(), false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strO;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.b.draw(canvas);
        if (!s() || (strO = o()) == null) {
            return;
        }
        Rect rect = new Rect();
        dqk dqkVar = this.c;
        dqkVar.a.getTextBounds(strO, 0, strO.length(), rect);
        float fExactCenterY = this.g - rect.exactCenterY();
        canvas.drawText(strO, this.f, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), dqkVar.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.e.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dqj
    public final void n() {
        invalidateSelf();
    }

    public final String o() {
        mz mzVar = this.e;
        my myVar = mzVar.b;
        my myVar2 = mzVar.b;
        String str = myVar.j;
        WeakReference weakReference = this.a;
        if (str == null) {
            if (!t()) {
                return null;
            }
            if (this.h == -2 || r() <= this.h) {
                return NumberFormat.getInstance(myVar2.n).format(r());
            }
            Context context = (Context) weakReference.get();
            return context == null ? "" : String.format(myVar2.n, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.h), "+");
        }
        int i = myVar.l;
        if (i == -2 || str == null || str.length() <= i) {
            return str;
        }
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            return "";
        }
        return String.format(context2.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i - 1), "…");
    }

    @Override // android.graphics.drawable.Drawable, me.hd.wauxv.obf.dqj
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final CharSequence p() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        mz mzVar = this.e;
        my myVar = mzVar.b;
        my myVar2 = mzVar.b;
        if (myVar.j != null) {
            CharSequence charSequence = myVar.o;
            return charSequence != null ? charSequence : mzVar.b.j;
        }
        if (!t()) {
            return myVar2.p;
        }
        if (myVar2.q == 0 || (context = (Context) this.a.get()) == null) {
            return null;
        }
        if (this.h != -2) {
            int iR = r();
            int i = this.h;
            if (iR > i) {
                return context.getString(myVar2.r, Integer.valueOf(i));
            }
        }
        return context.getResources().getQuantityString(myVar2.q, r(), Integer.valueOf(r()));
    }

    public final FrameLayout q() {
        WeakReference weakReference = this.m;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public final int r() {
        int i = this.e.b.k;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public final boolean s() {
        return this.e.b.j != null || t();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        mz mzVar = this.e;
        mzVar.a.i = i;
        mzVar.b.i = i;
        this.c.a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final boolean t() {
        my myVar = this.e.b;
        return myVar.j == null && myVar.k != -1;
    }

    public final void u() {
        Context context = (Context) this.a.get();
        if (context == null) {
            return;
        }
        boolean zS = s();
        mz mzVar = this.e;
        this.b.setShapeAppearanceModel(dgm.m(context, zS ? mzVar.b.g.intValue() : mzVar.b.e.intValue(), s() ? mzVar.b.h.intValue() : mzVar.b.f.intValue(), new o(0)).m());
        invalidateSelf();
    }

    public final void v(View view, FrameLayout frameLayout) {
        this.l = new WeakReference(view);
        this.m = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        w();
        invalidateSelf();
    }

    /* JADX WARN: Found duplicated region for block: B:100:0x0239  */
    /* JADX WARN: Found duplicated region for block: B:101:0x0251  */
    /* JADX WARN: Found duplicated region for block: B:104:0x0256  */
    /* JADX WARN: Found duplicated region for block: B:107:0x0263  */
    /* JADX WARN: Found duplicated region for block: B:110:0x0270  */
    /* JADX WARN: Found duplicated region for block: B:113:0x027d  */
    /* JADX WARN: Found duplicated region for block: B:96:0x0218  */
    /* JADX WARN: Found duplicated region for block: B:97:0x0230  */
    public final void w() {
        float y;
        float x;
        float y2;
        float x2;
        float height;
        float width;
        float f;
        WeakReference weakReference = this.a;
        Context context = (Context) weakReference.get();
        WeakReference weakReference2 = this.l;
        View view = weakReference2 != null ? (View) weakReference2.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        Rect rect2 = this.d;
        rect.set(rect2);
        Rect rect3 = new Rect();
        view.getDrawingRect(rect3);
        WeakReference weakReference3 = this.m;
        ViewGroup viewGroup = weakReference3 != null ? (ViewGroup) weakReference3.get() : null;
        if (viewGroup != null) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect3);
        }
        boolean zS = s();
        mz mzVar = this.e;
        float f2 = zS ? mzVar.d : mzVar.c;
        this.i = f2;
        if (f2 != -1.0f) {
            this.j = f2;
            this.k = f2;
        } else {
            this.j = Math.round((s() ? mzVar.g : mzVar.e) / 2.0f);
            this.k = Math.round((s() ? mzVar.h : mzVar.f) / 2.0f);
        }
        if (s()) {
            String strO = o();
            float f3 = this.j;
            dqk dqkVar = this.c;
            this.j = Math.max(f3, (dqkVar.h(strO) / 2.0f) + mzVar.b.u.intValue());
            float f4 = this.k;
            if (dqkVar.e) {
                dqkVar.i(strO);
                f = dqkVar.d;
            } else {
                f = dqkVar.d;
            }
            float fMax = Math.max(f4, (f / 2.0f) + mzVar.b.v.intValue());
            this.k = fMax;
            this.j = Math.max(this.j, fMax);
        }
        my myVar = mzVar.b;
        my myVar2 = mzVar.b;
        int i = mzVar.k;
        int iIntValue = myVar.x.intValue();
        if (s()) {
            iIntValue = myVar.z.intValue();
            Context context2 = (Context) weakReference.get();
            if (context2 != null) {
                iIntValue = ff.h(iIntValue, ff.g(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f), iIntValue - myVar.ac.intValue());
            }
        }
        if (i == 0) {
            iIntValue -= Math.round(this.k);
        }
        int iIntValue2 = myVar.ab.intValue() + iIntValue;
        int iIntValue3 = myVar2.s.intValue();
        if (iIntValue3 == 8388691 || iIntValue3 == 8388693) {
            this.g = rect3.bottom - iIntValue2;
        } else {
            this.g = rect3.top + iIntValue2;
        }
        int iIntValue4 = s() ? myVar.y.intValue() : myVar2.w.intValue();
        if (i == 1) {
            iIntValue4 += s() ? mzVar.j : mzVar.i;
        }
        int iIntValue5 = myVar.aa.intValue() + iIntValue4;
        int iIntValue6 = myVar2.s.intValue();
        if (iIntValue6 == 8388659 || iIntValue6 == 8388691) {
            WeakHashMap weakHashMap = eqz.a;
            this.f = view.getLayoutDirection() == 0 ? (rect3.left - this.j) + iIntValue5 : (rect3.right + this.j) - iIntValue5;
        } else {
            WeakHashMap weakHashMap2 = eqz.a;
            this.f = view.getLayoutDirection() == 0 ? (rect3.right + this.j) - iIntValue5 : (rect3.left - this.j) + iIntValue5;
        }
        if (myVar.ad.booleanValue()) {
            View viewQ = q();
            if (viewQ != null) {
                FrameLayout frameLayoutQ = q();
                if (frameLayoutQ == null || frameLayoutQ.getId() != R.id.mtrl_anchor_parent) {
                    y = 0.0f;
                    x = 0.0f;
                } else if (viewQ.getParent() instanceof View) {
                    y = viewQ.getY();
                    x = viewQ.getX();
                    viewQ = (View) viewQ.getParent();
                }
                y2 = viewQ.getY() + (this.g - this.k) + y;
                x2 = viewQ.getX() + (this.f - this.j) + x;
                if (viewQ.getParent() instanceof View) {
                }
                if (viewQ.getParent() instanceof View) {
                }
                if (y2 < 0.0f) {
                    this.g = Math.abs(y2) + this.g;
                }
                if (x2 < 0.0f) {
                    this.f = Math.abs(x2) + this.f;
                }
                if (height > 0.0f) {
                    this.g -= Math.abs(height);
                }
                if (width > 0.0f) {
                    this.f -= Math.abs(width);
                }
            } else if (view.getParent() instanceof View) {
                float y3 = view.getY();
                x = view.getX();
                View view2 = (View) view.getParent();
                y = y3;
                viewQ = view2;
                y2 = viewQ.getY() + (this.g - this.k) + y;
                x2 = viewQ.getX() + (this.f - this.j) + x;
                height = viewQ.getParent() instanceof View ? ((this.g + this.k) - (((View) viewQ.getParent()).getHeight() - viewQ.getY())) + y : 0.0f;
                width = viewQ.getParent() instanceof View ? ((this.f + this.j) - (((View) viewQ.getParent()).getWidth() - viewQ.getX())) + x : 0.0f;
                if (y2 < 0.0f) {
                    this.g = Math.abs(y2) + this.g;
                }
                if (x2 < 0.0f) {
                    this.f = Math.abs(x2) + this.f;
                }
                if (height > 0.0f) {
                    this.g -= Math.abs(height);
                }
                if (width > 0.0f) {
                    this.f -= Math.abs(width);
                }
            }
        }
        float f5 = this.f;
        float f6 = this.g;
        float f7 = this.j;
        float f8 = this.k;
        rect2.set((int) (f5 - f7), (int) (f6 - f8), (int) (f5 + f7), (int) (f6 + f8));
        float f9 = this.i;
        cau cauVar = this.b;
        if (f9 != -1.0f) {
            dgl dglVarQ = cauVar.ct.b.q();
            dglVarQ.n(f9);
            cauVar.setShapeAppearanceModel(dglVarQ.m());
        }
        if (rect.equals(rect2)) {
            return;
        }
        cauVar.setBounds(rect2);
    }
}
