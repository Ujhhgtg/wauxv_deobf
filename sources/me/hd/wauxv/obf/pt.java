package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pt extends cvj {
    public boolean[] a;
    public int b;

    @Override // me.hd.wauxv.obf.cvj
    public final Object c() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.a, this.b);
        throwIfVar1IsNull(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @Override // me.hd.wauxv.obf.cvj
    public final void d(int i) {
        boolean[] zArr = this.a;
        if (zArr.length < i) {
            int length = zArr.length * 2;
            if (i < length) {
                i = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i);
            throwIfVar1IsNull(zArrCopyOf, "copyOf(...)");
            this.a = zArrCopyOf;
        }
    }

    @Override // me.hd.wauxv.obf.cvj
    public final int e() {
        return this.b;
    }
}
