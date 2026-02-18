package me.hd.wauxv.obf;

import android.content.ClipData;
import android.graphics.fonts.Font;
import android.os.VibratorManager;
import android.view.ContentInfo;
import android.view.inputmethod.SurroundingText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class qc {
    public static /* synthetic */ Font.Builder i(Font font) {
        return new Font.Builder(font);
    }

    public static /* bridge */ /* synthetic */ VibratorManager m(Object obj) {
        return (VibratorManager) obj;
    }

    public static /* synthetic */ ContentInfo.Builder n(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    public static /* bridge */ /* synthetic */ ContentInfo p(Object obj) {
        return (ContentInfo) obj;
    }

    public static /* synthetic */ SurroundingText r(int i, int i2, int i3, CharSequence charSequence) {
        return new SurroundingText(charSequence, i, i2, i3);
    }

    public static /* synthetic */ void s() {
    }
}
