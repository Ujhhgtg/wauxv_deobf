package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apo {
    public static final apo a = new apo(2);
    public static final apo b = new apo(0);
    public static final apo c;
    public static final apo d;
    public static final apo e;
    public static final cru f;
    public static final boolean g;
    public final /* synthetic */ int h;

    static {
        apo apoVar = new apo(1);
        c = apoVar;
        d = new apo(3);
        e = apoVar;
        f = cru.f(apoVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        g = true;
    }

    public /* synthetic */ apo(int i) {
        this.h = i;
    }

    public final int i(int i, int i2, int i3, int i4) {
        switch (this.h) {
            case 0:
                if (j(i, i2, i3, i4) == 1.0f) {
                    return 2;
                }
                return a.i(i, i2, i3, i4);
            case 1:
                return 2;
            case 2:
                return g ? 2 : 1;
            default:
                return 2;
        }
    }

    public final float j(int i, int i2, int i3, int i4) {
        switch (this.h) {
            case 0:
                return Math.min(1.0f, a.j(i, i2, i3, i4));
            case 1:
                return Math.max(i3 / i, i4 / i2);
            case 2:
                if (g) {
                    return Math.min(i3 / i, i4 / i2);
                }
                if (Math.max(i2 / i4, i / i3) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
