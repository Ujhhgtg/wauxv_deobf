package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class te extends FrameLayout {
    public static final int[] i = {R.attr.colorBackground};
    public static final nu j = new nu(14);
    public boolean k;
    public boolean l;
    public final Rect m;
    public final Rect n;
    public final io o;

    public te(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, me.hd.wauxv.R.attr.materialCardViewStyle);
        Rect rect = new Rect();
        this.m = rect;
        this.n = new Rect();
        io ioVar = new io(this, 11);
        this.o = ioVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxw.a, me.hd.wauxv.R.attr.materialCardViewStyle, me.hd.wauxv.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(i);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(me.hd.wauxv.R.color.cardview_light_background) : getResources().getColor(me.hd.wauxv.R.color.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.k = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.l = typedArrayObtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        ddi ddiVar = new ddi(colorStateListValueOf, dimension);
        ioVar.c = ddiVar;
        setBackgroundDrawable(ddiVar);
        setClipToOutline(true);
        setElevation(dimension2);
        j.ac(ioVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((ddi) ((Drawable) this.o.c)).h;
    }

    public float getCardElevation() {
        return ((te) this.o.d).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.m.bottom;
    }

    public int getContentPaddingLeft() {
        return this.m.left;
    }

    public int getContentPaddingRight() {
        return this.m.right;
    }

    public int getContentPaddingTop() {
        return this.m.top;
    }

    public float getMaxCardElevation() {
        return ((ddi) ((Drawable) this.o.c)).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.l;
    }

    public float getRadius() {
        return ((ddi) ((Drawable) this.o.c)).a;
    }

    public boolean getUseCompatPadding() {
        return this.k;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        ddi ddiVar = (ddi) ((Drawable) this.o.c);
        if (colorStateListValueOf == null) {
            ddiVar.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        ddiVar.h = colorStateListValueOf;
        ddiVar.b.setColor(colorStateListValueOf.getColorForState(ddiVar.getState(), ddiVar.h.getDefaultColor()));
        ddiVar.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((te) this.o.d).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        j.ac(this.o, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.l) {
            this.l = z;
            io ioVar = this.o;
            j.ac(ioVar, ((ddi) ((Drawable) ioVar.c)).e);
        }
    }

    public void setRadius(float f) {
        ddi ddiVar = (ddi) ((Drawable) this.o.c);
        if (f == ddiVar.a) {
            return;
        }
        ddiVar.a = f;
        ddiVar.m(null);
        ddiVar.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.k != z) {
            this.k = z;
            io ioVar = this.o;
            j.ac(ioVar, ((ddi) ((Drawable) ioVar.c)).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        ddi ddiVar = (ddi) ((Drawable) this.o.c);
        if (colorStateList == null) {
            ddiVar.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        ddiVar.h = colorStateList;
        ddiVar.b.setColor(colorStateList.getColorForState(ddiVar.getState(), ddiVar.h.getDefaultColor()));
        ddiVar.invalidateSelf();
    }
}
