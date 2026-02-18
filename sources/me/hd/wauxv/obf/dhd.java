package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhd extends cvj {
    public short[] a;
    public int b;

    @Override // me.hd.wauxv.obf.cvj
    public final Object c() {
        short[] sArrCopyOf = Arrays.copyOf(this.a, this.b);
        throwIfVar1IsNull(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    @Override // me.hd.wauxv.obf.cvj
    public final void d(int i) {
        short[] sArr = this.a;
        if (sArr.length < i) {
            int length = sArr.length * 2;
            if (i < length) {
                i = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i);
            throwIfVar1IsNull(sArrCopyOf, "copyOf(...)");
            this.a = sArrCopyOf;
        }
    }

    @Override // me.hd.wauxv.obf.cvj
    public final int e() {
        return this.b;
    }
}
