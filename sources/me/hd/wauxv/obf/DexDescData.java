package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DexDescData {
    public final String b;
    public final Kotlin$Lazy c = new Kotlin$Lazy(new bp(this, 16));

    public DexDescData(String str) {
        this.b = str;
    }

    public final String d() {
        String str = (String) this.c.getValue();
        String strZ = "" /* "" /* "" /* "" /* cnb.z(-5841155521322L)   */;
        DefaultConfig ioVar = emc.w;
        if (ioVar == null) {
            throw new IllegalArgumentException("DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* cnb.z(-6021544147754L)   */.toString());
        }
        String string = ioVar.aj().getString(str, strZ);
        throwIfVar1IsNull(string);
        return string;
    }
}
