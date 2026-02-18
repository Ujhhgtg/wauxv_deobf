package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqh {
    public final ColorStateList a;
    public final String b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final boolean h;
    public final float i;
    public ColorStateList j;
    public float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    public dqh(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cxs.ao);
        this.k = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.j = cnb.v(context, typedArrayObtainStyledAttributes, 3);
        cnb.v(context, typedArrayObtainStyledAttributes, 4);
        cnb.v(context, typedArrayObtainStyledAttributes, 5);
        this.c = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i2 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.l = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        this.b = typedArrayObtainStyledAttributes.getString(i2);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.a = cnb.v(context, typedArrayObtainStyledAttributes, 6);
        this.e = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, cxs.aa);
        this.h = typedArrayObtainStyledAttributes2.hasValue(0);
        this.i = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void o() {
        String str;
        Typeface typeface = this.n;
        int i = this.c;
        if (typeface == null && (str = this.b) != null) {
            this.n = Typeface.create(str, i);
        }
        if (this.n == null) {
            int i2 = this.d;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, i);
        }
    }

    public final Typeface p(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceD = dcu.d(context, this.l);
                this.n = typefaceD;
                if (typefaceD != null) {
                    this.n = Typeface.create(typefaceD, this.c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.b, e);
            }
        }
        o();
        this.m = true;
        return this.n;
    }

    public final void q(Context context, bhv bhvVar) {
        if (r(context)) {
            p(context);
        } else {
            o();
        }
        int i = this.l;
        if (i == 0) {
            this.m = true;
        }
        if (this.m) {
            bhvVar.e(this.n, true);
            return;
        }
        try {
            dqf dqfVar = new dqf(this, bhvVar);
            ThreadLocal threadLocal = dcu.a;
            if (context.isRestricted()) {
                dqfVar.ai(-4);
            } else {
                dcu.e(context, i, new TypedValue(), 0, dqfVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            bhvVar.d(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.b, e);
            this.m = true;
            bhvVar.d(-3);
        }
    }

    public final boolean r(Context context) throws Exception {
        Typeface typefaceE = null;
        int i = this.l;
        if (i != 0) {
            ThreadLocal threadLocal = dcu.a;
            if (!context.isRestricted()) {
                typefaceE = dcu.e(context, i, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceE != null;
    }

    public final void s(Context context, TextPaint textPaint, bhv bhvVar) {
        t(context, textPaint, bhvVar);
        ColorStateList colorStateList = this.j;
        textPaint.setColor(colorStateList != null
                ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor())
                : -16777216);
        ColorStateList colorStateList2 = this.a;
        textPaint.setShadowLayer(this.g, this.e, this.f,
                colorStateList2 != null
                        ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor())
                        : 0);
    }

    public final void t(Context context, TextPaint textPaint, bhv bhvVar) {
        if (r(context)) {
            u(context, textPaint, p(context));
            return;
        }
        o();
        u(context, textPaint, this.n);
        ensureParameterNotNull(context, new dqg(this, context, textPaint, bhvVar));
    }

    public final void u(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceZ = ajn.z(context.getResources().getConfiguration(), typeface);
        if (typefaceZ != null) {
            typeface = typefaceZ;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.c;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.k);
        if (this.h) {
            textPaint.setLetterSpacing(this.i);
        }
    }
}
