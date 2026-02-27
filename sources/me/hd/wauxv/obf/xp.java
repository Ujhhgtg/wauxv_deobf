package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xp extends ApiHookItem implements IDexFind {
    public static final xp a = new xp();

    public static Object getChatroomMember(String str) {
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(xn.getChatroomStorage()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(ChatRoomMember$ClassChatRoomMember.INSTANCE);
        return ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class) }, 1, methodResolverVarT)).invokeAndThrowIfFailed(str);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ChatroomStorage$MethodGetMemberCount.INSTANCE, dexKitBridge, new ws(12));
    }
}
