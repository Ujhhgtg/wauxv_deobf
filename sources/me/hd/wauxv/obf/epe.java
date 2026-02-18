package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epe extends eph {
    public ik a;
    public float b;
    public ik c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public Paint.Cap i;
    public Paint.Join j;
    public float k;

    public float getFillAlpha() {
        return this.e;
    }

    public int getFillColor() {
        return this.c.b;
    }

    public float getStrokeAlpha() {
        return this.d;
    }

    public int getStrokeColor() {
        return this.a.b;
    }

    public float getStrokeWidth() {
        return this.b;
    }

    public float getTrimPathEnd() {
        return this.g;
    }

    public float getTrimPathOffset() {
        return this.h;
    }

    public float getTrimPathStart() {
        return this.f;
    }

    @Override // me.hd.wauxv.obf.epg
    public final boolean l() {
        return this.c.u() || this.a.u();
    }

    /* JADX WARN: Found duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Found duplicated region for block: B:7:0x001e  */
    @Override // me.hd.wauxv.obf.epg
    public final boolean m(int[] iArr) {
        boolean z;
        ik ikVar = this.c;
        boolean z2 = true;
        if (ikVar.u()) {
            ColorStateList colorStateList = (ColorStateList) ikVar.d;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != ikVar.b) {
                ikVar.b = colorForState;
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        ik ikVar2 = this.a;
        if (ikVar2.u()) {
            ColorStateList colorStateList2 = (ColorStateList) ikVar2.d;
            int colorForState2 = colorStateList2.getColorForState(iArr, colorStateList2.getDefaultColor());
            if (colorForState2 != ikVar2.b) {
                ikVar2.b = colorForState2;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return z | z2;
    }

    public void setFillAlpha(float f) {
        this.e = f;
    }

    public void setFillColor(int i) {
        this.c.b = i;
    }

    public void setStrokeAlpha(float f) {
        this.d = f;
    }

    public void setStrokeColor(int i) {
        this.a.b = i;
    }

    public void setStrokeWidth(float f) {
        this.b = f;
    }

    public void setTrimPathEnd(float f) {
        this.g = f;
    }

    public void setTrimPathOffset(float f) {
        this.h = f;
    }

    public void setTrimPathStart(float f) {
        this.f = f;
    }
}
