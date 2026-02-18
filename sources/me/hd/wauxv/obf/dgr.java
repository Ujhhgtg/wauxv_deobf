package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgr extends dgv {
    public final dgt a;
    public final float b;
    public final float d;

    public dgr(dgt dgtVar, float f, float f2) {
        this.a = dgtVar;
        this.b = f;
        this.d = f2;
    }

    @Override // me.hd.wauxv.obf.dgv
    public final void c(Matrix matrix, dgk dgkVar, int i, Canvas canvas) {
        dgt dgtVar = this.a;
        float f = dgtVar.b;
        float f2 = this.d;
        float f3 = dgtVar.a;
        float f4 = this.b;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
        Matrix matrix2 = this.g;
        matrix2.set(matrix);
        matrix2.preTranslate(f4, f2);
        matrix2.preRotate(e());
        dgkVar.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i2 = dgkVar.j;
        int[] iArr = dgk.a;
        iArr[0] = i2;
        iArr[1] = dgkVar.i;
        iArr[2] = dgkVar.h;
        Paint paint = dgkVar.g;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, dgk.b, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float e() {
        dgt dgtVar = this.a;
        return (float) Math.toDegrees(Math.atan((dgtVar.b - this.d) / (dgtVar.a - this.b)));
    }
}
