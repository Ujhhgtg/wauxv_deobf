package me.hd.wauxv.obf;

import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DexDescData {
    public final String signatureId;
    public final Kotlin$Lazy cachedName = new Kotlin$Lazy(() -> {
        DexDescData amnVar = this;
        return HostInfoRegistry.getVersionString() +
                TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH +
                amnVar.signatureId;
    });

    public DexDescData(String str) {
        this.signatureId = str;
    }

    public final String getResolvedName() {
        String str = (String) this.cachedName.getValue();
        String strZ = "";
        DefaultConfig ioVar = emc.config;
        if (ioVar == null) {
            throw new IllegalArgumentException("DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* cnb.z(-6021544147754L)   */.toString());
        }
        String string = ioVar.aj().getString(str, strZ);
        throwIfVar1IsNull(string);
        return string;
    }
}
