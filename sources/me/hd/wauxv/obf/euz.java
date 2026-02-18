package me.hd.wauxv.obf;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class euz {
    public final int k;
    public float l;
    public final Interpolator m;
    public final long n;

    public euz(int i, Interpolator interpolator, long j) {
        this.k = i;
        this.m = interpolator;
        this.n = j;
    }

    public long b() {
        return this.n;
    }

    public float c() {
        Interpolator interpolator = this.m;
        return interpolator != null ? interpolator.getInterpolation(this.l) : this.l;
    }

    public int d() {
        return this.k;
    }

    public void e(float f) {
        this.l = f;
    }
}
