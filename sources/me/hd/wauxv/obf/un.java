package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class un extends SwitchHook implements IDexFind {
    public static final un a = new un("ChatFavVoiceFilterForwardHook" /* "ChatFavVoiceFilterForwardHook" /* "ChatFavVoiceFilterForwardHook" /* cnb.z(-488586889657130L)  */);
    public static final String b = "收藏" /* "收藏" /* "收藏" /* cnb.z(-477385614949162L)  */;
    public static final String c = "聊天收藏语音过滤转发" /* "聊天收藏语音过滤转发" /* "聊天收藏语音过滤转发" /* cnb.z(-477389909916458L)  */;
    public static final String d = "在我的收藏搜索列表中不过滤语音消息" /* "在我的收藏搜索列表中不过滤语音消息" /* "在我的收藏搜索列表中不过滤语音消息" /* cnb.z(-477308305537834L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        cde cdeVarT = yg.s(-490090128210730L).t();
        cdeVarT.ab = "onCreate" /* "onCreate" /* "onCreate" /* cnb.z(-489914034551594L)  */;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        un unVar = a;
        aki akiVarAd = unVar.ad(methodHookWrapperVar, exgVar);
        unVar.y(akiVarAd, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(14));
        akiVarAd.o();
        emn.bc(um.a, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(15));
        emn.bc(ul.a, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(16));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(um.a, dexKitBridge, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(19));
        emn.aj(ul.a, dexKitBridge, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(20));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
