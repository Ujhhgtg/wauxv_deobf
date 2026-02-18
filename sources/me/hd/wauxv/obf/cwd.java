package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwd {
    public static final cwd a = new cwd();
    public final cbm b = bhs.g;

    public final Object c(btd btdVar, byte[] bArr) {
        bzo.q(btdVar, "deserializer");
        return new cwl(this, new cwo(new ru(bArr, bArr.length)), btdVar.getDescriptor()).ap(btdVar, null);
    }
}
