package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RepairerConfigHook extends ApiHookItem implements IDexFind {
    public static final RepairerConfigHook a = new RepairerConfigHook();
    public static final LinkedHashSet HOOKS = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        HookManager hookManagerVarAb = PackageParam.createHook(a, dqc.toSingletonList(StaticHelpers7.toDexMethod(RepairerConfigApi$MethodGet.INSTANCE)));
        hookManagerVarAb.hookAfter((obj -> {
            HookParam hookParam6 = (HookParam) obj;
            hookParam6.getClass();
            Object objX26 = hookParam6.getArgs()[0];
            throwIfVar1IsNull(objX26);
            String str7 = (String) objX26;
            Object objX27 = hookParam6.getArgs()[1];
            for (IHandlesRepairerConfig bnyVar : RepairerConfigHook.HOOKS) {
                bnyVar.handleRepairerConfig(hookParam6, str7);
            }
        }));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(RepairerConfigApi$MethodGet.INSTANCE, dexKitBridge, (obj -> {
            FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
            findDexClassMethodDslWrapperVar.onClassCallback = (obj1 -> {
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj1;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("RepairerConfigThread", "ValueStrategy_");
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
            });
            findDexClassMethodDslWrapperVar.onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj1;
                DexFinder cdjVar = new DexFinder();
                cdjVar.setReturnType(Object.class);
                cdjVar.setParamTypes(String.class, Object.class);
                cdjVar.usingStrings("String", "Int", "Long", "Float");
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
            });
        }));
    }
}
