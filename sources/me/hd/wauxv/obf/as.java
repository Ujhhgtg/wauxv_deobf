package me.hd.wauxv.obf;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class as {
    public static /* bridge */ /* synthetic */ ImageDecoder.Source e(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* bridge */ /* synthetic */ AnimatedImageDrawable g(Drawable drawable) {
        return (AnimatedImageDrawable) drawable;
    }

    public static /* bridge */ /* synthetic */ void v(Object obj) {
    }

    public static /* bridge */ /* synthetic */ boolean w(Drawable drawable) {
        return drawable instanceof AnimatedImageDrawable;
    }
}
