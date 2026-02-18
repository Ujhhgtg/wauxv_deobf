package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lr extends dbi {
    public final Drawable a;
    public long b;

    public lr(Drawable drawable, Rect rect) {
        super(null, 0.0f, 0.0f);
        drawable.setBounds(rect);
        this.a = drawable;
        this.b = System.currentTimeMillis();
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void c(Canvas canvas) {
        this.a.draw(canvas);
    }

    @Override // me.hd.wauxv.obf.dbi
    public final void d(float f, float f2) {
        if (this.b + 50 < System.currentTimeMillis()) {
            this.a.setAlpha((int) (((cay.a.nextInt(25) + 30.0f) * 255.0f) / 100.0f));
            this.b = System.currentTimeMillis();
        }
    }
}
