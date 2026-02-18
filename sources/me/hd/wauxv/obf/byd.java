package me.hd.wauxv.obf;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class byd implements Interpolator {
    public final float[] d;
    public final float e;

    public byd(float[] fArr) {
        this.d = fArr;
        this.e = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.d;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.e;
        float f3 = (f - (iMin * f2)) / f2;
        float f4 = fArr[iMin];
        return yg.a(fArr[iMin + 1], f4, f3, f4);
    }
}
