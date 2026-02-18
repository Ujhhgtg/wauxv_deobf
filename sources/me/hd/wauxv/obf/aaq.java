package me.hd.wauxv.obf;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aaq extends MetricAffectingSpan {
    public final bzr a;

    public aaq(bzr bzrVar) {
        this.a = bzrVar;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        bzr bzrVar = this.a;
        bzrVar.getClass();
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
        bzrVar.getClass();
        textPaint.bgColor = emn.ae(textPaint.getColor(), 25);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        this.a.getClass();
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
    }
}
