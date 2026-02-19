package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AnotherIllegalArgumentException extends SomeIllegalArgumentException {
    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public AnotherIllegalArgumentException(String str, AnotherIllegalArgumentException cwmVar) {
        super(str, cwmVar);
        throwIfVar1IsNull(str, "message");
    }
}
