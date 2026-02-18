package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqc extends cvj {
    public int[] a;
    public int b;

    @Override // me.hd.wauxv.obf.cvj
    public final Object c() {
        int[] iArrCopyOf = Arrays.copyOf(this.a, this.b);
        bzo.p(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    @Override // me.hd.wauxv.obf.cvj
    public final void d(int i) {
        int[] iArr = this.a;
        if (iArr.length < i) {
            int length = iArr.length * 2;
            if (i < length) {
                i = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            bzo.p(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
    }

    @Override // me.hd.wauxv.obf.cvj
    public final int e() {
        return this.b;
    }
}
