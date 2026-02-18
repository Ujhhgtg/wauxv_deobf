package me.hd.wauxv.obf;

import android.graphics.RenderNode;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class at {
    public static /* synthetic */ RenderNode f() {
        return new RenderNode("editorRenderNode");
    }

    public static /* bridge */ /* synthetic */ ColorStateListDrawable g(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    public static /* bridge */ /* synthetic */ boolean u(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
