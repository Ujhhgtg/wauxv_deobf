package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.dgn;
import me.hd.wauxv.obf.dgo;
import me.hd.wauxv.obf.dgx;
import me.hd.wauxv.obf.dgy;
import me.hd.wauxv.obf.il;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends il implements dgx {
    public final dgo a;
    public final RectF b;
    public final RectF c;
    public final Paint d;
    public final Paint e;
    public final Path f;
    public ColorStateList g;
    public cau h;
    public dgm i;
    public float j;
    public final Path k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public boolean r;

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, 0, R.style.Widget_MaterialComponents_ShapeableImageView), attributeSet, 0);
        this.a = dgn.a;
        this.f = new Path();
        this.r = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.b = new RectF();
        this.c = new RectF();
        this.k = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, cxs.aj, 0, R.style.Widget_MaterialComponents_ShapeableImageView);
        setLayerType(2, null);
        this.g = cnb.v(context2, typedArrayObtainStyledAttributes, 9);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.l = dimensionPixelSize;
        this.m = dimensionPixelSize;
        this.n = dimensionPixelSize;
        this.o = dimensionPixelSize;
        this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, Integer.MIN_VALUE);
        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.i = dgm.n(context2, attributeSet, 0, R.style.Widget_MaterialComponents_ShapeableImageView).m();
        setOutlineProvider(new dgy(this));
    }

    public int getContentPaddingBottom() {
        return this.o;
    }

    public final int getContentPaddingEnd() {
        int i = this.q;
        return i != Integer.MIN_VALUE ? i : s() ? this.l : this.n;
    }

    public int getContentPaddingLeft() {
        int i = this.q;
        int i2 = this.p;
        if (i2 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (s() && i != Integer.MIN_VALUE) {
                return i;
            }
            if (!s() && i2 != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.l;
    }

    public int getContentPaddingRight() {
        int i = this.q;
        int i2 = this.p;
        if (i2 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (s() && i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (!s() && i != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.n;
    }

    public final int getContentPaddingStart() {
        int i = this.p;
        return i != Integer.MIN_VALUE ? i : s() ? this.n : this.l;
    }

    public int getContentPaddingTop() {
        return this.m;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public dgm getShapeAppearanceModel() {
        return this.i;
    }

    public ColorStateList getStrokeColor() {
        return this.g;
    }

    public float getStrokeWidth() {
        return this.j;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.k, this.e);
        if (this.g == null) {
            return;
        }
        float f = this.j;
        Paint paint = this.d;
        paint.setStrokeWidth(f);
        int colorForState = this.g.getColorForState(getDrawableState(), this.g.getDefaultColor());
        if (this.j <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.f, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.r && isLayoutDirectionResolved()) {
            this.r = true;
            if (!isPaddingRelative() && this.p == Integer.MIN_VALUE && this.q == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        t(i, i2);
    }

    public final boolean s() {
        return getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(getContentPaddingLeft() + i, getContentPaddingTop() + i2, getContentPaddingRight() + i3, getContentPaddingBottom() + i4);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(getContentPaddingStart() + i, getContentPaddingTop() + i2, getContentPaddingEnd() + i3, getContentPaddingBottom() + i4);
    }

    @Override // me.hd.wauxv.obf.dgx
    public void setShapeAppearanceModel(dgm dgmVar) {
        this.i = dgmVar;
        cau cauVar = this.h;
        if (cauVar != null) {
            cauVar.setShapeAppearanceModel(dgmVar);
        }
        t(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(ResourcesCompat.v(getContext(), i));
    }

    public void setStrokeWidth(float f) {
        if (this.j != f) {
            this.j = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public final void t(int i, int i2) {
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingRight = i - getPaddingRight();
        float paddingBottom = i2 - getPaddingBottom();
        RectF rectF = this.b;
        rectF.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
        dgm dgmVar = this.i;
        dgo dgoVar = this.a;
        Path path = this.f;
        dgoVar.m(dgmVar, 1.0f, rectF, null, path);
        Path path2 = this.k;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.c;
        rectF2.set(0.0f, 0.0f, i, i2);
        path2.addRect(rectF2, Path.Direction.CCW);
    }
}
