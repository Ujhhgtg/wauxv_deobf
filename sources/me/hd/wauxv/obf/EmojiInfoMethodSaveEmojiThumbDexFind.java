package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiInfoMethodSaveEmojiThumbDexFind extends bws implements IDexFind {
    public static final EmojiInfoMethodSaveEmojiThumbDexFind INSTANCE = new EmojiInfoMethodSaveEmojiThumbDexFind();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(EmojiInfo$MethodSaveEmojiThumb.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2) -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj2;
                DexFinder cdjVar5 = new DexFinder();
                DexFinder.setClassEquals(cdjVar5, "com.tencent.mm.storage.emotion.EmojiInfo");
                cdjVar5.usingStrings("save emoji thumb error");
                dexMethodQueryBuilderVar3.dexFinder = cdjVar5;
            }
        });
    }
}
