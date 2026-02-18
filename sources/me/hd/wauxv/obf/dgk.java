package me.hd.wauxv.obf;

import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgk {
    public static final int[] a = new int[3];
    public static final float[] b = {0.0f, 0.5f, 1.0f};
    public static final int[] c = new int[4];
    public static final float[] d = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public int h;
    public int i;
    public int j;
    public final Path k = new Path();
    public final Paint l;

    public dgk() {
        Paint paint = new Paint();
        this.l = paint;
        this.e = new Paint();
        m(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.g = new Paint(paint2);
    }

    public final void m(int i) {
        this.h = abi.f(i, 68);
        this.i = abi.f(i, 20);
        this.j = abi.f(i, 0);
        this.e.setColor(this.h);
    }
}
