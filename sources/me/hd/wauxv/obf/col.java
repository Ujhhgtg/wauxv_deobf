package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class col extends dbi {
    public final Paint a;
    public final BitmapShader b;
    public final Matrix e;
    public final float g;
    public long h;
    public final int i;

    static {
        new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        new PorterDuffXfermode(PorterDuff.Mode.SRC);
        new PorterDuffXfermode(PorterDuff.Mode.DST);
        new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
        new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        new PorterDuffXfermode(PorterDuff.Mode.XOR);
        new PorterDuffXfermode(PorterDuff.Mode.DARKEN);
        new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
        new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        new PorterDuffXfermode(PorterDuff.Mode.SCREEN);
    }

    public col(Bitmap bitmap) {
        super(bitmap, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.a = paint;
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.b = bitmapShader;
        Matrix matrix = new Matrix();
        this.e = matrix;
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        paint.setAlpha(144);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        this.h = System.currentTimeMillis();
        this.i = 100;
        this.g = 2.5f;
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void c(Canvas canvas) {
        canvas.drawPaint(this.a);
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void d(float f, float f2) {
        if (this.h + ((long) this.i) < System.currentTimeMillis()) {
            Matrix matrix = this.e;
            matrix.reset();
            float f3 = this.g;
            matrix.setScale(f3, f3);
            matrix.postTranslate(cay.tryGetClassByName((-this.s.getWidth()) * 10.0f, this.s.getWidth() * 10.0f),
                    cay.tryGetClassByName((-this.s.getHeight()) * 10.0f, this.s.getHeight() * 10.0f));
            this.b.setLocalMatrix(matrix);
            this.h = System.currentTimeMillis();
        }
    }
}
