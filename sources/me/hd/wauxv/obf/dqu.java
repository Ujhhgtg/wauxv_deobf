package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqu implements drb {
    public float a = 0.0f;
    public final /* synthetic */ dqz b;
    public final /* synthetic */ drd c;

    public dqu(drd drdVar, dqz dqzVar) {
        this.c = drdVar;
        this.b = dqzVar;
    }

    @Override // me.hd.wauxv.obf.drb
    public final boolean e(ArrayList arrayList, boolean z, cjn cjnVar) {
        float f = this.a;
        drd drdVar = this.c;
        dqz dqzVar = this.b;
        this.a += drd.p(drdVar, arrayList, z, cjnVar, null, f, dqzVar);
        return dqzVar.c != 0.0f;
    }
}
