package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ddk extends bhv {
    @Override // me.hd.wauxv.obf.bhv
    public final void a(dgw dgwVar, float f, float f2) {
        dgwVar.l(0.0f, f2 * f, 180.0f, 90.0f);
        float f3 = f2 * 2.0f * f;
        dgs dgsVar = new dgs(0.0f, 0.0f, f3, f3);
        dgsVar.f = 180.0f;
        dgsVar.g = 90.0f;
        dgwVar.g.add(dgsVar);
        dgq dgqVar = new dgq(dgsVar);
        dgwVar.i(180.0f);
        dgwVar.h.add(dgqVar);
        dgwVar.e = 270.0f;
        float f4 = (0.0f + f3) * 0.5f;
        float f5 = (f3 - 0.0f) / 2.0f;
        double d = 270.0f;
        dgwVar.c = (((float) Math.cos(Math.toRadians(d))) * f5) + f4;
        dgwVar.d = (f5 * ((float) Math.sin(Math.toRadians(d)))) + f4;
    }
}
