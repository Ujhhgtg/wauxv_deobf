package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ClassCoreStorageDexFind extends bws implements IDexFind {
    public static final ClassCoreStorageDexFind INSTANCE = new ClassCoreStorageDexFind();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(CoreStorage$ClassCoreStorage.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj2;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MMKernel.CoreStorage",
                        "CheckData path[%s] blocksize:%s blockcount:%s availcount:%s");
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
            }
        });
    }
}
