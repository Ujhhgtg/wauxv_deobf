package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acl extends cxc {
    public final boolean a;

    public acl(ek ekVar, boolean z) {
        super(ekVar);
        this.a = z;
    }

    @Override // me.hd.wauxv.obf.cxc
    public final void c(byte b) {
        if (this.a) {
            b(String.valueOf(b & 255));
        } else {
            n(String.valueOf(b & 255));
        }
    }

    @Override // me.hd.wauxv.obf.cxc
    public final void d(int i) {
        boolean z = this.a;
        String unsignedString = Integer.toUnsignedString(i);
        if (z) {
            b(unsignedString);
        } else {
            n(unsignedString);
        }
    }

    @Override // me.hd.wauxv.obf.cxc
    public final void e(long j) {
        boolean z = this.a;
        String unsignedString = Long.toUnsignedString(j);
        if (z) {
            b(unsignedString);
        } else {
            n(unsignedString);
        }
    }

    @Override // me.hd.wauxv.obf.cxc
    public final void f(short s) {
        if (this.a) {
            b(String.valueOf(s & 65535));
        } else {
            n(String.valueOf(s & 65535));
        }
    }
}
