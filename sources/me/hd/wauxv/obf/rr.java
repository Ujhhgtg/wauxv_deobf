package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rr implements LeadingMarginSpan {
    public final bzr a;
    public final Paint b = cqf.c;
    public final RectF c = cqf.b;
    public final Rect d = cqf.a;
    public final int e;

    public rr(bzr bzrVar, int i) {
        this.a = bzrVar;
        this.e = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        RectF rectF = this.c;
        Rect rect = this.d;
        if (z && (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint paint2 = this.b;
            paint2.set(paint);
            bzr bzrVar = this.a;
            bzrVar.getClass();
            int i8 = bzrVar.b;
            paint2.setColor(paint2.getColor());
            int i9 = bzrVar.d;
            if (i9 != 0) {
                paint2.setStrokeWidth(i9);
            }
            int iSave = canvas.save();
            try {
                int iMin = Math.min(i8, (int) ((paint2.descent() - paint2.ascent()) + 0.5f)) / 2;
                int i10 = (i8 - iMin) / 2;
                if (i2 <= 0) {
                    i -= i8;
                }
                int i11 = i + i10;
                int i12 = i11 + iMin;
                int iDescent = (i4 + ((int) (((paint2.descent() + paint2.ascent()) / 2.0f) + 0.5f))) - (iMin / 2);
                int i13 = iMin + iDescent;
                int i14 = this.e;
                if (i14 == 0 || i14 == 1) {
                    rectF.set(i11, iDescent, i12, i13);
                    paint2.setStyle(i14 == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(rectF, paint2);
                } else {
                    rect.set(i11, iDescent, i12, i13);
                    paint2.setStyle(Paint.Style.FILL);
                    canvas.drawRect(rect, paint2);
                }
            } finally {
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z) {
        return this.a.b;
    }
}
