package me.hd.wauxv.obf;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class dql {
    public static /* synthetic */ Typeface.CustomFallbackBuilder c(FontFamily fontFamily) {
        return new Typeface.CustomFallbackBuilder(fontFamily);
    }

    public static /* synthetic */ FontFamily.Builder h(Font font) {
        return new FontFamily.Builder(font);
    }

    public static /* synthetic */ WindowInsets.Builder j() {
        return new WindowInsets.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder k(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void w() {
    }
}
