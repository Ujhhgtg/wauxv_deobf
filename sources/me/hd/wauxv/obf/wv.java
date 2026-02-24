package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wv extends ApiHookItem implements IDexFind {
    public static final wv a = new wv();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ChatRoomMember$ClassChatRoomMember.INSTANCE, dexKitBridge,
                (obj -> {
                    ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 -> {
                        DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj1;
                        String[] strArr4 = { "com.tencent.mm.storage" };
                        dexClassQueryBuilderVar.getClass();
                        dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr4);
                        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                        zbVar.usingEqStrings("MicroMsg.ChatRoomMember", "service is null");
                        dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                    })
                }));
        StaticHelpers7.resolveDexAndCache(ChatRoomMember$MethodGetChatRoomData.INSTANCE, dexKitBridge,
                (obj -> {
                    ((FindDexClassMethodDslWrapper) obj).onClassCallback = (obj1 ->  {
                        final HookParam bah5 = (HookParam)obj1;
                        final Object d8 = new Object();
                        ((cdj)d8).o(emn.az((amn)wt.a));
                        ((cdj)d8).t(new String[] { "MicroMsg.ChatRoomMember", "getChatroomData hashMap is null!" });
                        bah5.getClass();
                        bah5.d = (cdj)d8;
                    })
                }));
    }
}
