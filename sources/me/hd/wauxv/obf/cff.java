package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cff {
    public long a;
    public long b;
    public TimeInterpolator c;
    public int d;
    public int e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cff)) {
            return false;
        }
        cff cffVar = (cff) obj;
        if (this.a == cffVar.a && this.b == cffVar.b && this.d == cffVar.d && this.e == cffVar.e) {
            return f().getClass().equals(cffVar.f().getClass());
        }
        return false;
    }

    public final TimeInterpolator f() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : ff.b;
    }

    public final int hashCode() {
        long j = this.a;
        long j2 = this.b;
        return ((((f().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(cff.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.a);
        sb.append(" duration: ");
        sb.append(this.b);
        sb.append(" interpolator: ");
        sb.append(f().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.d);
        sb.append(" repeatMode: ");
        return yg.m(sb, "}\n", this.e);
    }
}
