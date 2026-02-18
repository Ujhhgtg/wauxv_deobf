package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yp extends Drawable {
    public final Paint a;
    public final Paint b;
    public final abu c;
    public final boolean d;

    public yp(abu abuVar) {
        throwIfVar1IsNull(abuVar, "kind");
        this.c = abuVar;
        this.d = true;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor((int) abuVar.f);
        this.a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setTextSize(Resources.getSystem().getDisplayMetrics().density * 14);
        paint2.setTextAlign(Paint.Align.CENTER);
        this.b = paint2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        throwIfVar1IsNull(canvas, "canvas");
        float f = getBounds().right;
        float f2 = getBounds().bottom;
        boolean z = this.d;
        Paint paint = this.a;
        if (z) {
            float f3 = 2;
            float f4 = f / f3;
            canvas.drawCircle(f4, f2 / f3, f4, paint);
            canvas2 = canvas;
        } else {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, f, f2, paint);
        }
        canvas2.save();
        canvas2.translate(f / 2.0f, f2 / 2.0f);
        Paint paint2 = this.b;
        canvas2.drawText(this.c.g, 0.0f, (-(paint2.ascent() + paint2.descent())) / 2.0f, paint2);
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
