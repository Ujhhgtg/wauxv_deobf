package me.hd.wauxv.obf;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Canvas;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbr implements drb {
    public float a;
    public final Object b;
    public Object c;
    public final Object d;

    public cbr(Context context) {
        this.a = 1;
        this.b = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.c = activityManager;
        this.d = new bmu(context.getResources().getDisplayMetrics());
        if (activityManager.isLowRamDevice()) {
            this.a = 0.0f;
        }
    }

    @Override // me.hd.wauxv.obf.drb
    public boolean e(ArrayList arrayList, boolean z, cjn cjnVar) {
        float f = this.a;
        float fP = f + drd.p((drd) this.d, arrayList, z, cjnVar, (Canvas) this.c, f, (dqz) this.b);
        this.a = fP;
        return fP < ((dqz) this.b).c;
    }

    public cbr(drd drdVar, dqz dqzVar) {
        this.d = drdVar;
        this.a = 0.0f;
        this.b = dqzVar;
    }
}
