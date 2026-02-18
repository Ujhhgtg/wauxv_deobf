package me.hd.wauxv.obf;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqv implements Interpolator {
    public final /* synthetic */ int a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch (this.a) {
            case 0:
                return f * f * f * f * f;
            case 1:
            case 2:
            default:
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }
}
