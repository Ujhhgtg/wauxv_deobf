package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aix extends cau {
    public static final /* synthetic */ int a = 0;
    public aiw b;

    @Override // me.hd.wauxv.obf.cau
    public final void c(Canvas canvas) {
        if (this.b.a.isEmpty()) {
            super.c(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.b.a);
        super.c(canvas);
        canvas.restore();
    }

    public final void d(float f, float f2, float f3, float f4) {
        RectF rectF = this.b.a;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }

    @Override // me.hd.wauxv.obf.cau, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.b = new aiw(this.b);
        return this;
    }
}
