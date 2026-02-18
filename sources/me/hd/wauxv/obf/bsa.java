package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsa {
    public final asx a;
    public boolean b;

    public bsa(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.a = new asx(dfxVar, new brz(2, this, bsa.class, "readIfAbsent",
                "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0, 0, 0));
    }
}
