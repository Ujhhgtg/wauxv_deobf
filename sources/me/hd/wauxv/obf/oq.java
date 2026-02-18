package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class oq extends dbi {
    public long a;
    public Bitmap[] b;
    public int e;

    @Override // me.hd.wauxv.obf.dbi
    public final void c(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.b[this.e], this.q + 0.0f, this.r + 0.0f, (Paint) null);
        canvas.restore();
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void d(float f, float f2) {
        if (this.a + 2500 < System.currentTimeMillis()) {
            this.a = System.currentTimeMillis();
            int i = this.e + 1;
            this.e = i;
            if (i == this.b.length) {
                this.e = 0;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void f() {
        for (Bitmap bitmap : this.b) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
