package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bix extends ReplacementSpan {
    public final int[] a;
    public final int b;
    public final float c;
    public final float d;

    public bix(int[] iArr, int i, int i2) {
        i = (i2 & 2) != 0 ? -1 : i;
        this.a = iArr;
        this.b = i;
        this.c = 8.0f;
        this.d = 8.0f;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float fMeasureText = paint.measureText(charSequence, i, i2);
        float f2 = i4;
        float f3 = paint.getFontMetrics().ascent + f2;
        float f4 = this.d;
        RectF rectF = new RectF(f, f3, (2 * f4) + fMeasureText + f, paint.getFontMetrics().descent + f2);
        int color = paint.getColor();
        Shader shader = paint.getShader();
        paint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.a, (float[]) null, Shader.TileMode.CLAMP));
        float f5 = this.c;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        paint.setColor(this.b);
        paint.setShader(null);
        canvas.drawText(charSequence, i, i2, f + f4, f2, paint);
        paint.setColor(color);
        paint.setShader(shader);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) ((2 * this.d) + paint.measureText(charSequence, i, i2));
    }
}
