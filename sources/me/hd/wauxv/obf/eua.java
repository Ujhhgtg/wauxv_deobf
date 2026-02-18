package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eua extends Drawable {
    public final etz a;
    public final Paint b;
    public final List c;
    public final float d;
    public final float e;

    public eua(etz etzVar) {
        this.a = etzVar;
        Paint paint = new Paint(1);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(etzVar.b);
        paint.setTextSize(etzVar.c);
        paint.setStyle(Paint.Style.FILL);
        this.b = paint;
        this.c = dnj.ar(etzVar.a, new char[]{'\n'});
        float fDescent = paint.descent() - paint.ascent();
        this.d = fDescent;
        this.e = (fDescent * r1.size()) + etzVar.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float fWidth = getBounds().width();
        float fHeight = getBounds().height();
        float f = 2;
        float f2 = fWidth * f;
        float f3 = fHeight * f;
        List list = this.c;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        String str = (String) it.next();
        Paint paint = this.b;
        float fMeasureText = paint.measureText(str);
        while (it.hasNext()) {
            fMeasureText = Math.max(fMeasureText, paint.measureText((String) it.next()));
        }
        etz etzVar = this.a;
        float f4 = fMeasureText + etzVar.e;
        float f5 = 1;
        int i = (int) ((f2 / f4) + f5);
        float f6 = this.e;
        int i2 = (int) ((f3 / f6) + f5);
        int iSave = canvas.save();
        canvas.rotate(etzVar.d, fWidth / f, fHeight / f);
        float f7 = (fWidth - (i * f4)) / f;
        float f8 = (fHeight - (i2 * f6)) / f;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                float f9 = i3 % 2 == 0 ? 0.0f : f4 / f;
                int i4 = 0;
                while (i4 < i) {
                    float f10 = (i4 * f4) + f7 + f9;
                    float f11 = f7;
                    float f12 = (i3 * f6) + f8;
                    Iterator it2 = list.iterator();
                    int i5 = 0;
                    while (it2.hasNext()) {
                        int i6 = i5 + 1;
                        float f13 = f8;
                        canvas.drawText((String) it2.next(), f10, (this.d * i5) + f12, paint);
                        i5 = i6;
                        f8 = f13;
                    }
                    i4++;
                    f7 = f11;
                }
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
