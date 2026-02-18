package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class atb {
    public int a;
    public final Object b;
    public final Object c;

    public atb(czg czgVar) {
        this.a = Integer.MIN_VALUE;
        this.c = new Rect();
        this.b = czgVar;
    }

    public static atb d(czg czgVar, int i) {
        if (i == 0) {
            return new crz(czgVar, 0);
        }
        if (i == 1) {
            return new crz(czgVar, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h(View view);

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public atb(ate ateVar) {
        this.a = 0;
        this.c = new akm();
        this.b = ateVar;
    }
}
