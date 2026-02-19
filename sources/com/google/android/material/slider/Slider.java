package com.google.android.material.slider;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import java.util.Iterator;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.bht;
import me.hd.wauxv.obf.bhv;
import me.hd.wauxv.obf.bto;
import me.hd.wauxv.obf.cau;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.ns;
import me.hd.wauxv.obf.o;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Slider extends ns {
    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.value});
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setValue(typedArrayObtainStyledAttributes.getFloat(0, 0.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.at;
    }

    public int getFocusedThumbIndex() {
        return this.au;
    }

    public int getHaloRadius() {
        return this.ag;
    }

    public ColorStateList getHaloTintList() {
        return this.bd;
    }

    public int getLabelBehavior() {
        return this.ab;
    }

    public float getStepSize() {
        return this.av;
    }

    public float getThumbElevation() {
        return this.bl.ct.n;
    }

    public int getThumbHeight() {
        return this.af;
    }

    @Override // me.hd.wauxv.obf.ns
    public int getThumbRadius() {
        return this.ae / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.bl.ct.e;
    }

    public float getThumbStrokeWidth() {
        return this.bl.ct.k;
    }

    public ColorStateList getThumbTintList() {
        return this.bl.ct.d;
    }

    public int getThumbTrackGapSize() {
        return this.ah;
    }

    public int getThumbWidth() {
        return this.ae;
    }

    public int getTickActiveRadius() {
        return this.ay;
    }

    public ColorStateList getTickActiveTintList() {
        return this.be;
    }

    public int getTickInactiveRadius() {
        return this.az;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.bf;
    }

    public ColorStateList getTickTintList() {
        if (this.bf.equals(this.be)) {
            return this.be;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.bg;
    }

    public int getTrackHeight() {
        return this.ac;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.bh;
    }

    public int getTrackInsideCornerSize() {
        return this.al;
    }

    public int getTrackSidePadding() {
        return this.ad;
    }

    public int getTrackStopIndicatorSize() {
        return this.ak;
    }

    public ColorStateList getTrackTintList() {
        if (this.bh.equals(this.bg)) {
            return this.bg;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.ba;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    public float getValueFrom() {
        return this.aq;
    }

    public float getValueTo() {
        return this.ar;
    }

    public void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    @Override // me.hd.wauxv.obf.ns, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.as.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.au = i;
        this.h.an(i);
        postInvalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setHaloRadius(int i) {
        if (i == this.ag) {
            return;
        }
        this.ag = i;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setRadius(this.ag);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // me.hd.wauxv.obf.ns
    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.bd)) {
            return;
        }
        this.bd = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        int iBy = by(colorStateList);
        Paint paint = this.d;
        paint.setColor(iBy);
        paint.setAlpha(63);
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setLabelBehavior(int i) {
        if (this.ab != i) {
            this.ab = i;
            requestLayout();
        }
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(bto btoVar) {
    }

    public void setStepSize(float f) {
        if (f >= 0.0f) {
            if (this.av != f) {
                this.av = f;
                this.bc = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The stepSize(" + f + ") must be 0, or a factor of the valueFrom(" + this.aq + ")-valueTo(" + this.ar + ") range");
    }

    @Override // me.hd.wauxv.obf.ns
    public void setThumbElevation(float f) {
        this.bl.dy(f);
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    @Override // me.hd.wauxv.obf.ns
    public void setThumbHeight(int i) {
        if (i == this.af) {
            return;
        }
        this.af = i;
        this.bl.setBounds(0, 0, this.ae, i);
        Drawable drawable = this.bm;
        if (drawable != null) {
            br(drawable);
        }
        Iterator it = this.bn.iterator();
        while (it.hasNext()) {
            br((Drawable) it.next());
        }
        cp();
    }

    public void setThumbHeightResource(int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(int i) {
        int i2 = i * 2;
        setThumbWidth(i2);
        setThumbHeight(i2);
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // me.hd.wauxv.obf.ns
    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.bl.ed(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(bht.v(getContext(), i));
        }
    }

    @Override // me.hd.wauxv.obf.ns
    public void setThumbStrokeWidth(float f) {
        cau cauVar = this.bl;
        cauVar.ct.k = f;
        cauVar.invalidateSelf();
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        cau cauVar = this.bl;
        if (colorStateList.equals(cauVar.ct.d)) {
            return;
        }
        cauVar.dz(colorStateList);
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setThumbTrackGapSize(int i) {
        if (this.ah == i) {
            return;
        }
        this.ah = i;
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setThumbWidth(int i) {
        if (i == this.ae) {
            return;
        }
        this.ae = i;
        arj arjVar = new arj();
        arj arjVar2 = new arj();
        arj arjVar3 = new arj();
        arj arjVar4 = new arj();
        float f = this.ae / 2.0f;
        bhv bhvVarAo = KotlinHelpers2.ao(0);
        o oVar = new o(f);
        o oVar2 = new o(f);
        o oVar3 = new o(f);
        o oVar4 = new o(f);
        dgm dgmVar = new dgm();
        dgmVar.a = bhvVarAo;
        dgmVar.b = bhvVarAo;
        dgmVar.c = bhvVarAo;
        dgmVar.d = bhvVarAo;
        dgmVar.e = oVar;
        dgmVar.f = oVar2;
        dgmVar.g = oVar3;
        dgmVar.h = oVar4;
        dgmVar.i = arjVar;
        dgmVar.j = arjVar2;
        dgmVar.k = arjVar3;
        dgmVar.l = arjVar4;
        cau cauVar = this.bl;
        cauVar.setShapeAppearanceModel(dgmVar);
        cauVar.setBounds(0, 0, this.ae, this.af);
        Drawable drawable = this.bm;
        if (drawable != null) {
            br(drawable);
        }
        Iterator it = this.bn.iterator();
        while (it.hasNext()) {
            br((Drawable) it.next());
        }
        cp();
    }

    public void setThumbWidthResource(int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTickActiveRadius(int i) {
        if (this.ay != i) {
            this.ay = i;
            this.f.setStrokeWidth(i * 2);
            cp();
        }
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.be)) {
            return;
        }
        this.be = colorStateList;
        this.f.setColor(by(colorStateList));
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTickInactiveRadius(int i) {
        if (this.az != i) {
            this.az = i;
            this.e.setStrokeWidth(i * 2);
            cp();
        }
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.bf)) {
            return;
        }
        this.bf = colorStateList;
        this.e.setColor(by(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z) {
        if (this.ax != z) {
            this.ax = z;
            postInvalidate();
        }
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.bg)) {
            return;
        }
        this.bg = colorStateList;
        this.b.setColor(by(colorStateList));
        this.g.setColor(by(this.bg));
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTrackHeight(int i) {
        if (this.ac != i) {
            this.ac = i;
            this.a.setStrokeWidth(i);
            this.b.setStrokeWidth(this.ac);
            cp();
        }
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.bh)) {
            return;
        }
        this.bh = colorStateList;
        this.a.setColor(by(colorStateList));
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTrackInsideCornerSize(int i) {
        if (this.al == i) {
            return;
        }
        this.al = i;
        invalidate();
    }

    @Override // me.hd.wauxv.obf.ns
    public void setTrackStopIndicatorSize(int i) {
        if (this.ak == i) {
            return;
        }
        this.ak = i;
        this.g.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f) {
        setValues(Float.valueOf(f));
    }

    public void setValueFrom(float f) {
        this.aq = f;
        this.bc = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.ar = f;
        this.bc = true;
        postInvalidate();
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        br(drawableNewDrawable);
        this.bm = drawableNewDrawable;
        this.bn.clear();
        postInvalidate();
    }
}
