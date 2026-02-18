package me.hd.wauxv.obf;

import android.text.PrecomputedText;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class cuz {
    public static /* synthetic */ PrecomputedText.Params.Builder k(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ boolean v(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
