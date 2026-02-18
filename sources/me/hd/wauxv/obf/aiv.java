package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aiv extends bhv {
    @Override // me.hd.wauxv.obf.bhv
    public final void a(dgw dgwVar, float f, float f2) {
        dgwVar.l(0.0f, f2 * f, 180.0f, 90.0f);
        double d = f2;
        double d2 = f;
        dgwVar.k((float) (Math.sin(Math.toRadians(90.0f)) * d * d2), (float) (Math.sin(Math.toRadians(0.0f)) * d * d2));
    }
}
