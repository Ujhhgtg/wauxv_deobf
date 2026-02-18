package me.hd.wauxv.obf;

import android.graphics.Canvas;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqv implements drb {
    public float a = 0.0f;
    public boolean b = true;
    public final /* synthetic */ Canvas c;
    public final /* synthetic */ dqz d;
    public final /* synthetic */ float f;
    public final /* synthetic */ drd g;

    public dqv(drd drdVar, Canvas canvas, dqz dqzVar, float f) {
        this.g = drdVar;
        this.c = canvas;
        this.d = dqzVar;
        this.f = f;
    }

    @Override // me.hd.wauxv.obf.drb
    public final boolean e(ArrayList arrayList, boolean z, cjn cjnVar) {
        float fP = this.a + drd.p(this.g, arrayList, z, cjnVar, this.c, this.a, this.d);
        this.a = fP;
        boolean z2 = fP < this.f;
        this.b = z2;
        return z2;
    }
}
