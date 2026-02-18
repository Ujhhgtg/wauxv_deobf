package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.PathInterpolator;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crk extends Drawable {
    public Drawable a;
    public final Paint b;
    public final RectF c;
    public final Rect d;
    public final float e;
    public float f;
    public ValueAnimator g;
    public final PathInterpolator h;
    public final PathInterpolator i;
    public final PathInterpolator j;
    public float k;
    public float l;
    public float m;

    public crk(Drawable drawable, int i, Context context) {
        this.a = drawable;
        Paint paint = new Paint();
        this.b = paint;
        this.c = new RectF();
        this.d = new Rect();
        this.f = 45.0f;
        this.h = new PathInterpolator(0.66f, 0.01f, 1.0f, 0.7f);
        this.i = new PathInterpolator(0.0f, 0.53f, 0.4f, 1.0f);
        this.j = new PathInterpolator(0.0f, 0.67f, 0.17f, 1.0f);
        this.l = 1.0f;
        paint.setColor(i);
        this.e = context.getResources().getDimension(R.dimen.close_line_stroke);
        Drawable drawable2 = this.a;
        if (drawable2 != null) {
            drawable2.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        bzo.q(canvas, "canvas");
        o(canvas, this.f);
        o(canvas, -this.f);
        Drawable drawable = this.a;
        if (drawable != null) {
            float fWidth = getBounds().width() / 2.0f;
            float fWidth2 = getBounds().width() / 2.0f;
            float f = this.l;
            float f2 = fWidth * f;
            float f3 = f * fWidth2;
            int i = (int) (f3 + fWidth2);
            Rect rect = this.d;
            rect.set((int) (fWidth - f2), (int) (fWidth2 - f3), (int) (f2 + fWidth), i);
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.a;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void n(float f) {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator duration = ValueAnimator.ofFloat(this.m, f).setDuration(600L);
        bzo.p(duration, "setDuration(...)");
        this.g = duration;
        duration.addUpdateListener(new aqi(this, 3));
        ValueAnimator valueAnimator2 = this.g;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        } else {
            bzo.ar("openCloseAnim");
            throw null;
        }
    }

    public final void o(Canvas canvas, float f) {
        canvas.save();
        canvas.rotate(f, getBounds().width() / 2.0f, getBounds().width() / 2.0f);
        float fWidth = getBounds().width() / 2.0f;
        float fWidth2 = getBounds().width() / 2.0f;
        float f2 = this.k * fWidth;
        float f3 = this.e;
        float f4 = f3 / 2.0f;
        RectF rectF = this.c;
        rectF.set(fWidth - f2, fWidth2 - f4, f2 + fWidth, f4 + fWidth2);
        canvas.drawRoundRect(rectF, f3, f3, this.b);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.b.setAlpha(i);
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }
}
