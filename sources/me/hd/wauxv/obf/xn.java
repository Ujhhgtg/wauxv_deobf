package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xn extends ApiHookItem implements IDexFind {
    public static final xn a = new xn();

    public static Object b() throws IllegalAccessException, InvocationTargetException {
        MMKernelDexFind byrVar = MMKernelDexFind.INSTANCE;
        Class cls = (Class) SomeStaticHelpers.getFirstInArray(StaticHelpers7.toDexClass(ChatroomService$ClassChatroomService.INSTANCE).getInterfaces());
        byrVar.getClass();
        Object objInvoke = StaticHelpers7.toDexMethod(MMKernel$MethodGetServiceImpl.INSTANCE).invoke(null, cls);
        throwIfVar1IsNull(objInvoke);
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objInvoke).getMethodResolverBasedOnPreviouslyProvidedConfig();
        xp.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.toDexMethod(ChatroomStorage$MethodGetMemberCount.INSTANCE).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ChatroomService$ClassChatroomService.INSTANCE, dexKitBridge, new ws(10));
    }
}
