package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ays {
    public static final ayr Companion = new ayr();
    public final int a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;

    public /* synthetic */ ays(int i, int i2, String str, String str2, int i3, String str3, String str4) {
        if (31 != (i & 31)) {
            bht.ah(i, 31, ayq.b.getDescriptor());
            throw null;
        }
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = i3;
        this.e = str3;
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str4;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ays)) {
            return false;
        }
        ays aysVar = (ays) obj;
        return this.a == aysVar.a && bzo.f(this.b, aysVar.b) && bzo.f(this.c, aysVar.c) && this.d == aysVar.d && bzo.f(this.e, aysVar.e) && bzo.f(this.f, aysVar.f);
    }

    public final int hashCode() {
        int iE = bjs.e(this.e, dts.a(this.d, bjs.e(this.c, bjs.e(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31);
        String str = this.f;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-124652835830570L));
        dkz.ac(sb, this.a, -130541235993386L);
        yg.u(sb, this.b, -130468221549354L);
        yg.u(sb, this.c, -130403797039914L);
        dkz.ac(sb, this.d, -130386617170730L);
        yg.u(sb, this.e, -130313602726698L);
        return bjs.q(sb, this.f, ')');
    }
}
