package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dih extends dbi {
    public final float a;
    public final float b;
    public final int e;
    public final float g;
    public final float[] h;
    public final float[] i;
    public final ValueAnimator j;
    public final Path k;
    public final Paint l;
    public float m;
    public final float[] n;
    public final float[] o;
    public final DecelerateInterpolator p;

    public dih(Bitmap bitmap, float f, float f2, float f3, float f4, float f5) {
        super(bitmap, f, f2);
        this.h = new float[324];
        this.i = new float[324];
        this.k = new Path();
        Paint paint = new Paint();
        this.l = paint;
        this.m = 1.0f;
        this.n = new float[2];
        this.o = new float[2];
        this.p = new DecelerateInterpolator(1.0f);
        this.a = f3;
        this.b = f4;
        this.e = 8;
        paint.setStyle(Paint.Style.STROKE);
        this.g = f5;
        float width = this.s.getWidth();
        float height = this.s.getHeight();
        int i = 0;
        for (int i2 = 0; i2 <= 80; i2++) {
            float f6 = (i2 * height) / 80.0f;
            for (int i3 = 0; i3 <= 1; i3++) {
                float f7 = (i3 * width) / 1.0f;
                float[] fArr = this.h;
                int i4 = i * 2;
                fArr[i4] = f7;
                int i5 = i4 + 1;
                fArr[i5] = f6;
                float[] fArr2 = this.i;
                fArr2[i4] = f7;
                fArr2[i5] = f6;
                i++;
            }
        }
        y();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, ((bitmap.getHeight() / 8) * 2.0f) / bitmap.getHeight()).setDuration(1500L);
        this.j = duration;
        duration.setRepeatCount(-1);
        duration.setRepeatMode(1);
        duration.addUpdateListener(new no(this, 8));
        duration.setInterpolator(new LinearInterpolator());
        duration.start();
        y();
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void c(Canvas canvas) {
        canvas.drawBitmapMesh(this.s, 1, 80, this.h, 0, null, 0, this.l);
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void d(float f, float f2) {
        PathMeasure pathMeasure = new PathMeasure(this.k, false);
        int i = 0;
        while (true) {
            float[] fArr = this.i;
            if (i >= fArr.length / 2) {
                return;
            }
            int i2 = i * 2;
            int i3 = i2 + 1;
            float f3 = fArr[i3];
            float f4 = fArr[i2];
            float f5 = f3 + 1.0E-6f;
            float height = f5 / this.s.getHeight();
            float height2 = (f5 / (((this.s.getHeight() / this.e) * 4.0f) + this.s.getHeight())) + this.m;
            float length = (1.0f - height) * pathMeasure.getLength();
            float[] fArr2 = this.n;
            pathMeasure.getPosTan(length, fArr2, null);
            float length2 = (1.0f - height2) * pathMeasure.getLength();
            float[] fArr3 = this.o;
            pathMeasure.getPosTan(length2, fArr3, null);
            float[] fArr4 = this.h;
            DecelerateInterpolator decelerateInterpolator = this.p;
            float f6 = this.g;
            if (f4 == 0.0f) {
                float width = fArr3[0] - (this.s.getWidth() / 2);
                float interpolation = ((1.0f - decelerateInterpolator.getInterpolation(height)) * 7.0f * f2) + ((f2 / 3.0f) * f6) + (width - ((width - this.q) * height));
                float f7 = fArr2[1];
                fArr4[i2] = interpolation;
                fArr4[i3] = f7;
            } else {
                float width2 = fArr3[0] + (this.s.getWidth() / 2);
                float interpolation2 = ((1.0f - decelerateInterpolator.getInterpolation(height)) * 7.0f * f2) + ((f2 / 3.0f) * f6) + (width2 - ((width2 - this.q) * height));
                float f8 = fArr2[1];
                fArr4[i2] = interpolation2;
                fArr4[i3] = f8;
            }
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void f() {
        super.f();
        this.j.cancel();
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void v() {
        this.j.pause();
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void w() {
        this.j.resume();
    }

    public final void y() {
        Path path = this.k;
        path.reset();
        path.moveTo(this.q, this.r);
        int i = this.e;
        int i2 = (int) (this.a / i);
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            float f = this.b;
            if (z) {
                float f2 = this.q;
                float f3 = this.r - (i2 * i3);
                path.cubicTo(f2, f3, f + f2, f3 - (i2 / 2), f2, f3 - i2);
            } else {
                float f4 = this.q;
                float f5 = this.r - (i2 * i3);
                path.cubicTo(f4, f5, f4 - f, f5 - (i2 / 2), f4, f5 - i2);
            }
            z = !z;
        }
    }
}
