package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkn extends MetricAffectingSpan implements LeadingMarginSpan {
    public final bzr a;
    public final Rect b = cqf.a;
    public final Paint c = cqf.c;
    public final int d;

    public bkn(bzr bzrVar, int i) {
        this.a = bzrVar;
        this.d = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int width;
        int i8 = this.d;
        if ((i8 == 1 || i8 == 2) && (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(this) == i7) {
            Paint paint2 = this.c;
            paint2.set(paint);
            bzr bzrVar = this.a;
            bzrVar.getClass();
            paint2.setColor(emn.ae(paint2.getColor(), 75));
            paint2.setStyle(Paint.Style.FILL);
            int i9 = bzrVar.f;
            if (i9 >= 0) {
                paint2.setStrokeWidth(i9);
            }
            float strokeWidth = paint2.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i10 = (int) ((i5 - strokeWidth) + 0.5f);
                if (i2 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i;
                    i -= canvas.getWidth();
                }
                Rect rect = this.b;
                rect.set(i, i10, width, i5);
                canvas.drawRect(rect, paint2);
            }
        }
    }

    public final void e(TextPaint textPaint) {
        this.a.getClass();
        textPaint.setFakeBoldText(true);
        int i = this.d;
        float[] fArr = bzr.a;
        if (6 >= i) {
            textPaint.setTextSize(textPaint.getTextSize() * fArr[i - 1]);
            return;
        }
        Locale locale = Locale.US;
        throw new IllegalStateException("Supplied heading level: " + i + " is invalid, where configured heading sizes are: `" + Arrays.toString(fArr) + "`");
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        e(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        e(textPaint);
    }
}
