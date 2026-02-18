package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpx extends IllegalArgumentException {
    public bpx(int i, int i2) {
        super(dkz.p(i, "Unpaired surrogate at index ", " of ", i2));
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bpx(String str) {
        super(str);
        throwIfVar1IsNull(str, "message");
    }
}
