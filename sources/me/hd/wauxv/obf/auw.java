package me.hd.wauxv.obf;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class auw extends MetricAffectingSpan {
    public final /* synthetic */ int a;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.a) {
            case 0:
                textPaint.setTextSkewX(-0.25f);
                break;
            default:
                textPaint.setFakeBoldText(true);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.a) {
            case 0:
                textPaint.setTextSkewX(-0.25f);
                break;
            default:
                textPaint.setFakeBoldText(true);
                break;
        }
    }
}
