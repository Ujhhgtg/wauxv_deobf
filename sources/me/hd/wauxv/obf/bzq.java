package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzq extends arj {
    public final float aq;

    public bzq(float f) {
        this.aq = f - 0.001f;
    }

    @Override // me.hd.wauxv.obf.arj
    public final void ap(float f, float f2, float f3, dgw dgwVar) {
        double d = this.aq;
        float fSqrt = (float) ((Math.sqrt(2.0d) * d) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(d, 2.0d) - Math.pow(fSqrt, 2.0d));
        dgwVar.l(f2 - fSqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + fSqrt2, 270.0f, 0.0f);
        dgwVar.k(f2, (float) (-((Math.sqrt(2.0d) * d) - d)));
        dgwVar.k(f2 + fSqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + fSqrt2);
    }
}
