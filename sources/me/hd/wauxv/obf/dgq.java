package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgq extends dgv {
    public final dgs a;

    public dgq(dgs dgsVar) {
        this.a = dgsVar;
    }

    @Override // me.hd.wauxv.obf.dgv
    public final void c(Matrix matrix, dgk dgkVar, int i, Canvas canvas) {
        float f;
        dgs dgsVar = this.a;
        float f2 = dgsVar.f;
        float f3 = dgsVar.g;
        RectF rectF = new RectF(dgsVar.b, dgsVar.c, dgsVar.d, dgsVar.e);
        Paint paint = dgkVar.f;
        boolean z = f3 < 0.0f;
        Path path = dgkVar.k;
        int[] iArr = dgk.c;
        if (z) {
            iArr[0] = 0;
            iArr[1] = dgkVar.j;
            iArr[2] = dgkVar.i;
            iArr[3] = dgkVar.h;
            f = 0.0f;
        } else {
            path.rewind();
            f = 0.0f;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i;
            rectF.inset(f4, f4);
            iArr[0] = 0;
            iArr[1] = dgkVar.h;
            iArr[2] = dgkVar.i;
            iArr[3] = dgkVar.j;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= f) {
            return;
        }
        float f5 = 1.0f - (i / fWidth);
        float[] fArr = dgk.d;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, dgkVar.l);
        }
        canvas.drawArc(rectF, f2, f3, true, paint);
        canvas.restore();
    }
}
