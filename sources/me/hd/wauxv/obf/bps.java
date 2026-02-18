package me.hd.wauxv.obf;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bps {
    public static final bps a = new bps(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public bps(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static bps f(bps bpsVar, bps bpsVar2) {
        return g(Math.max(bpsVar.b, bpsVar2.b), Math.max(bpsVar.c, bpsVar2.c), Math.max(bpsVar.d, bpsVar2.d), Math.max(bpsVar.e, bpsVar2.e));
    }

    public static bps g(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? a : new bps(i, i2, i3, i4);
    }

    public static bps h(Insets insets) {
        return g(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bps.class != obj.getClass()) {
            return false;
        }
        bps bpsVar = (bps) obj;
        return this.e == bpsVar.e && this.b == bpsVar.b && this.d == bpsVar.d && this.c == bpsVar.c;
    }

    public final int hashCode() {
        return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final Insets i() {
        return ke.c(this.b, this.c, this.d, this.e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.b);
        sb.append(", top=");
        sb.append(this.c);
        sb.append(", right=");
        sb.append(this.d);
        sb.append(", bottom=");
        return dkz.v(sb, this.e, '}');
    }
}
