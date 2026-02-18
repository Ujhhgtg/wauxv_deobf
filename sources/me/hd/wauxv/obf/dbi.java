package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dbi {
    public float q;
    public float r;
    public Bitmap s;
    public float t = 1.0f;
    public float u = 1.0f;

    public dbi(Bitmap bitmap, float f, float f2) {
        this.q = f;
        this.r = f2;
        this.s = bitmap;
    }

    public void c(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.s, this.q + 0.0f, this.r + 0.0f, (Paint) null);
        canvas.restore();
    }

    public void d(float f, float f2) {
    }

    public void f() {
        Bitmap bitmap = this.s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.s.recycle();
        this.s = null;
    }

    public void v() {
    }

    public void w() {
    }

    public void x(float f, float f2) {
    }
}
