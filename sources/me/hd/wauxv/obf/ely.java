package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ely extends dbi {
    public final float[] a;
    public final float[] b;
    public float e;
    public final Path g;
    public final Path h;
    public final Paint i;

    public ely(Bitmap bitmap, float f, float f2, float f3) {
        super(bitmap, f, f2);
        this.a = new float[384];
        this.b = new float[384];
        Paint paint = new Paint();
        this.g = new Path();
        this.h = new Path();
        this.i = new Paint();
        paint.setColor(-16777216);
        paint.setStrokeWidth(6.0f);
        paint.setStyle(Paint.Style.STROKE);
        float width = this.s.getWidth();
        float height = this.s.getHeight();
        int i = 0;
        for (int i2 = 0; i2 <= 95; i2++) {
            float f4 = (i2 * height) / 95.0f;
            for (int i3 = 0; i3 <= 1; i3++) {
                float f5 = (i3 * width) / 1.0f;
                float[] fArr = this.a;
                int i4 = i * 2;
                fArr[i4] = f5;
                int i5 = i4 + 1;
                fArr[i5] = f4;
                float[] fArr2 = this.b;
                fArr2[i4] = f5;
                fArr2[i5] = f4;
                i++;
            }
        }
        this.i.setAlpha((int) (f3 * 255.0f));
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void c(Canvas canvas) {
        float[] fArr;
        Canvas canvas2;
        Path path = this.g;
        path.reset();
        path.moveTo(this.q, this.r + this.s.getHeight());
        float f = this.q;
        float height = this.r + this.s.getHeight();
        float f2 = this.q;
        path.cubicTo(f, height, f2, this.r, (this.s.getWidth() * 1.5f * this.e) + f2, this.r);
        Path path2 = this.h;
        path2.reset();
        path2.moveTo(this.q + this.s.getWidth(), this.r + this.s.getHeight());
        path2.cubicTo(this.q + this.s.getWidth(), this.r + this.s.getHeight(), this.q + this.s.getWidth(), this.r + (this.s.getWidth() * 0.3f * this.e), this.q + this.s.getWidth() + ((this.s.getWidth() / 2) * this.e), this.r + (this.s.getWidth() * 0.8f * this.e));
        PathMeasure pathMeasure = new PathMeasure(path, false);
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        float[] fArr2 = new float[2];
        int i = 0;
        while (true) {
            float[] fArr3 = this.b;
            int length = fArr3.length / 2;
            fArr = this.a;
            if (i >= length) {
                break;
            }
            int i2 = i * 2;
            int i3 = i2 + 1;
            float f3 = fArr3[i3];
            if (fArr3[i2] == 0.0f) {
                pathMeasure.getPosTan((1.0f - ((f3 + 1.0E-6f) / this.s.getHeight())) * pathMeasure.getLength(), fArr2, null);
                float f4 = fArr2[0];
                float f5 = fArr2[1];
                fArr[i2] = f4;
                fArr[i3] = f5;
            } else {
                pathMeasure2.getPosTan((1.0f - ((f3 + 1.0E-6f) / this.s.getHeight())) * pathMeasure2.getLength(), fArr2, null);
                float f6 = fArr2[0];
                float f7 = fArr2[1];
                fArr[i2] = f6;
                fArr[i3] = f7;
            }
            i++;
        }
        canvas.save();
        float f8 = this.t;
        if (f8 == 1.0f && this.u == 1.0f) {
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            canvas2.scale(f8, this.u, this.q + (this.s.getWidth() / 2), this.r + this.s.getHeight());
        }
        canvas2.drawBitmapMesh(this.s, 1, 95, fArr, 0, null, 0, this.i);
        canvas.restore();
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void d(float f, float f2) {
        this.e = f2 / 100.0f;
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void x(float f, float f2) {
        this.t = f;
        this.u = f2;
    }
}
