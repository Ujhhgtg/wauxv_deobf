package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceManagerDexFinder extends bws implements IDexFind {
    public static final ServiceManagerDexFinder INSTANCE = new ServiceManagerDexFinder();

    public static Object getServiceByClass(Class cls) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = StaticHelpers7.toDexMethod(ServiceManager$MethodGetService.INSTANCE).invoke(null, cls);
        throwIfVar1IsNull(objInvoke);
        return objInvoke;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ServiceManager$MethodGetService.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2) -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj2;
                DexFinder cdjVar8 = new DexFinder();
                cdjVar8.usingStrings("calling getService(...)");
                dexMethodQueryBuilderVar7.dexFinder = cdjVar8;
            };
        });
    }
}
