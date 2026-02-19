package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xn extends bws implements IDexFind {
    public static final xn a = new xn();

    public static Object b() throws IllegalAccessException, InvocationTargetException {
        int i = 0;
        byr byrVar = byr.a;
        Class cls = (Class) SomeStaticHelpers.p(StaticHelpers7.az(xm.a).getInterfaces());
        byrVar.getClass();
        Object objInvoke = StaticHelpers7.bb(byq.a).invoke(null, cls);
        throwIfVar1IsNull(objInvoke);
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objInvoke).getMethodResolverBasedOnPreviouslyProvidedConfig();
        xp.a.getClass();
        methodResolverVarT.returnType = StaticHelpers7.bb(xo.a).getDeclaringClass();
        Object objE = ((MethodHookWrapper) bjs.h(methodResolverVarT)).e(new Object[0]);
        throwIfVar1IsNull(objE);
        return objE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(xm.a, dexKitBridge, new ws(10));
    }
}
