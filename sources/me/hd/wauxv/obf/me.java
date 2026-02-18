package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class me {
    public int a;
    public int b;
    public float c;
    public float d;
    public long e;
    public long f;
    public long g;
    public float h;
    public int i;

    public final float j(long j) {
        if (j < this.e) {
            return 0.0f;
        }
        long j2 = this.g;
        if (j2 < 0 || j < j2) {
            return bwo.s((j - r0) / this.a, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.h;
        return (bwo.s((j - j2) / this.i, 0.0f, 1.0f) * f) + (1.0f - f);
    }
}
