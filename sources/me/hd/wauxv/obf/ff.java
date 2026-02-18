package me.hd.wauxv.obf;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ff {
    public static final LinearInterpolator a = new LinearInterpolator();
    public static final ayf b = new ayf(ayf.b);
    public static final ayf c = new ayf();
    public static final ayf d = new ayf(ayf.c);
    public static final DecelerateInterpolator e = new DecelerateInterpolator();

    public static float f(float f, float f2, float f3) {
        return yg.a(f2, f, f3, f);
    }

    public static float g(float f, float f2, float f3, float f4, float f5) {
        return f5 <= f3 ? f : f5 >= f4 ? f2 : f(f, f2, (f5 - f3) / (f4 - f3));
    }

    public static int h(int i, float f, int i2) {
        return Math.round(f * (i2 - i)) + i;
    }
}
