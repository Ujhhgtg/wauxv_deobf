package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ty extends cvj {
    public char[] a;
    public int b;

    @Override // me.hd.wauxv.obf.cvj
    public final Object c() {
        char[] cArrCopyOf = Arrays.copyOf(this.a, this.b);
        bzo.p(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    @Override // me.hd.wauxv.obf.cvj
    public final void d(int i) {
        char[] cArr = this.a;
        if (cArr.length < i) {
            int length = cArr.length * 2;
            if (i < length) {
                i = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i);
            bzo.p(cArrCopyOf, "copyOf(...)");
            this.a = cArrCopyOf;
        }
    }

    @Override // me.hd.wauxv.obf.cvj
    public final int e() {
        return this.b;
    }
}
