package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.TextureView;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class abn extends FrameLayout {
    public boolean a;
    public boolean b;
    public TextureView c;

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        bzo.q(canvas, "canvas");
        if (!this.a) {
            super.dispatchDraw(canvas);
            return;
        }
        TextureView textureView = this.c;
        if (textureView != null) {
            drawChild(canvas, textureView, getDrawingTime());
        } else {
            bzo.ar("textureView");
            throw null;
        }
    }

    public float getCutoffFactor() {
        return 0.65f;
    }

    public final boolean getUseTextureViewOnPrePie() {
        return this.b;
    }

    public final void setPreAndroidPie(boolean z) {
        this.a = z;
    }

    public final void setUseTextureViewOnPrePie(boolean z) {
        this.b = z;
    }

    public void setupBaseViews(Context context) {
        bzo.q(context, com.umeng.analytics.pro.f.X);
        if (this.b) {
            this.a = Build.VERSION.SDK_INT < 28;
        } else {
            this.a = false;
        }
    }
}
