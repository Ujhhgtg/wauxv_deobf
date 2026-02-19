package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class evx {
    public final int a;
    public final int b;
    public final List c;
    public int d;
    public final float e;
    public final boolean f;

    public evx(int i, int i2, int i3, List list, float f, boolean z) {
        this.d = i;
        this.a = i2;
        this.b = i3;
        this.c = list;
        this.e = f;
        this.f = z;
    }

    public final float g(float f) {
        if (!this.f) {
            return 0.0f;
        }
        float f2 = this.e;
        if (f > f2) {
            return f - f2;
        }
        return 0.0f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RowRegion{startColumn=");
        sb.append(this.a);
        sb.append(", endColumn=");
        sb.append(this.b);
        sb.append(", line=");
        return StaticHelpers6.concatFromSb(sb, this.d, '}');
    }
}
