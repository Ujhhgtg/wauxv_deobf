package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbe {
    public static final bbd Companion = new bbd();
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public /* synthetic */ bbe(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        if (63 != (i & 63)) {
            bht.ah(i, 63, bbc.b.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = i2;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = z;
    }

    public bbe(String str, String str2, String str3, int i, String str4) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = true;
    }
}
