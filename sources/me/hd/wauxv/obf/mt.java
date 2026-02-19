package me.hd.wauxv.obf;

import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mt {
    public final float a;
    public final float b;
    public final float c;
    public final int d;

    public mt(BackEvent backEvent) {
        gn gnVar = gn.a;
        float fE = gnVar.e(backEvent);
        float f = gnVar.f(backEvent);
        float fC = gnVar.c(backEvent);
        int iD = gnVar.d(backEvent);
        this.a = fE;
        this.b = f;
        this.c = fC;
        this.d = iD;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackEventCompat{touchX=");
        sb.append(this.a);
        sb.append(", touchY=");
        sb.append(this.b);
        sb.append(", progress=");
        sb.append(this.c);
        sb.append(", swipeEdge=");
        return StaticHelpers6.concatFromSb(sb, this.d, '}');
    }
}
