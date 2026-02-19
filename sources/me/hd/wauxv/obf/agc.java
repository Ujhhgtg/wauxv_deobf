package me.hd.wauxv.obf;

import android.content.ContentValues;
import java.util.Arrays;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agc extends bws implements IDexFind {
    public static final agc a = new agc();

    public final Object b(ContentValues contentValues) {
        Object objC = ReflectionWrapper.createInstanceWithArgs(StaticHelpers7.toDexMethod(agb.a).getDeclaringClass(), new Object[0]);
        int i = 0;
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "convertFrom" /* "convertFrom" /* "convertFrom" /* cnb.z(-79005923408682L)  */;
        methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(ContentValues.class), dal.getKClassFromClass(Boolean.TYPE) }, 2));
        methodResolverVarT.enableSuperclass();
        ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).e(contentValues, Boolean.TRUE);
        return objC;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(agb.a, dexKitBridge, new act(28));
    }
}
