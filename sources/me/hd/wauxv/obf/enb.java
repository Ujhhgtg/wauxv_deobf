package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enb extends cvj {
    public long[] a;
    public int b;

    @Override // me.hd.wauxv.obf.cvj
    public final Object c() {
        long[] jArrCopyOf = Arrays.copyOf(this.a, this.b);
        bzo.p(jArrCopyOf, "copyOf(...)");
        return new ena(jArrCopyOf);
    }

    @Override // me.hd.wauxv.obf.cvj
    public final void d(int i) {
        long[] jArr = this.a;
        if (jArr.length < i) {
            int length = jArr.length * 2;
            if (i < length) {
                i = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i);
            bzo.p(jArrCopyOf, "copyOf(...)");
            this.a = jArrCopyOf;
        }
    }

    @Override // me.hd.wauxv.obf.cvj
    public final int e() {
        return this.b;
    }
}
