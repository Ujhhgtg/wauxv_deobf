package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiStorageMgrDexFinder extends bws implements IDexFind {
    public static final EmojiStorageMgrDexFinder INSTANCE = new EmojiStorageMgrDexFinder();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(EmojiStorageMgr$ClassEmojiStorageMgr.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj2) -> {
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj2;
                String[] strArr2 = { "com.tencent.mm.storage" };
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr2);
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s");
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
            }
        });
    }
}
