package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rt extends cvj {
    public byte[] a;
    public int b;

    @Override // me.hd.wauxv.obf.cvj
    public final Object c() {
        byte[] bArrCopyOf = Arrays.copyOf(this.a, this.b);
        bzo.p(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @Override // me.hd.wauxv.obf.cvj
    public final void d(int i) {
        byte[] bArr = this.a;
        if (bArr.length < i) {
            int length = bArr.length * 2;
            if (i < length) {
                i = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
            bzo.p(bArrCopyOf, "copyOf(...)");
            this.a = bArrCopyOf;
        }
    }

    @Override // me.hd.wauxv.obf.cvj
    public final int e() {
        return this.b;
    }
}
