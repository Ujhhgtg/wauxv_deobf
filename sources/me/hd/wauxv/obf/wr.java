package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import android.view.View;
import me.hd.wauxv.data.bean.MsgInfoBean;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wr extends ApiHookItem implements IDexFind {
    public static final wr a = new wr();
    public static final LinkedHashSet HOOKS = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        HookManager hookManagerVarAb = PackageParam.createHook(a, dqc.toSingletonList(StaticHelpers7.toDexMethod(ChatItemViewNewApi$MethodOnBindView.INSTANCE)));
        hookManagerVarAb.hookAfter((obj -> {
            Object objX;
            Object objX2;
            int iIntValue;
            HookParam hookParam = (HookParam) obj;
            LinkedHashSet<bnc> linkedHashSet = wr.HOOKS;
            // version check
//        if (cnb.ab(ewk.d) || cnb.ac(ewh.d)) {
            objX = hookParam.getArgs()[0];
            objX2 = hookParam.getArgs()[2];
            Integer num = (Integer) objX2;
            iIntValue = num != null ? num : 0;
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objX).createFieldResolver();
            fieldResolverVarR.fieldType = dal.getKClassFromClass(View.class);
            Object objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
            View view = (View) objE;
            Object tag = view.getTag();
            FieldResolver fieldResolverVarAa = StaticHelpers6.createFieldResolverFromHookParamThisObject(hookParam);
            fieldResolverVarAa.fieldType = StaticHelpers7.toDexClass(ChattingContext$ClassChattingContext.INSTANCE);
            Object chattingContext = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue();
            FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(hookParam.getThisObject()).createFieldResolver();
            fieldResolverVarR2.fieldType = StaticHelpers7.toDexClass(ChattingDataAdapter$ClassChattingDataAdapter.INSTANCE);
            Object chattingDataAdapter = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue();
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(chattingDataAdapter).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "getItem";
            Object objE2 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(iIntValue);
            MsgInfoBean msgInfoBean = new MsgInfoBean(objE2);
            for (bnc bncVar : linkedHashSet) {
                try {
                    bncVar.i(view, tag, chattingContext, msgInfoBean);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onBindView ");
                    Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                            bncVar instanceof SwitchHook ? ((SwitchHook) bncVar).getResult() : "LoadHook", " Failed"), e, 12);
                }
            }
//        } else {
//            hookParam.getClass();
//            try {
//                objX3 = hookParam.getArgs()[0];
//                if (objX3 == null) {
//                    objX3 = null;
//                }
//            } catch (Throwable th3) {
//                objX3 = FastKV.getFailureFromException(th3);
//            }
//            if (objX3 instanceof Failure) {
//                objX3 = null;
//            }
//            throwIfVar1IsNull(objX3);
//            try {
//                objX4 = hookParam.getArgs()[1];
//                if (objX4 == null) {
//                    objX4 = null;
//                }
//            } catch (Throwable th4) {
//                objX4 = FastKV.getFailureFromException(th4);
//            }
//            Integer num2 = (Integer) (objX4 instanceof Failure ? null : objX4);
//            iIntValue = num2 != null ? num2.intValue() : 0;
//            int i2 = 0;
//            FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objX3).createFieldResolver();
//            fieldResolverVarR3.fieldType = dal.getKClassFromClass(View.class);
//            Object objE3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
//            throwIfVar1IsNull(objE3);
//            View view2 = (View) objE3;
//            Object tag2 = view2.getTag();
//            FieldResolver fieldResolverVarAa2 = StaticHelpers6.createFieldResolverFromHookParamThisObject(hookParam);
//            ClassChattingContextDexFindHook.a.getClass();
//            fieldResolverVarAa2.fieldType = StaticHelpers7.toDexClass(ChattingContext$ClassChattingContext.INSTANCE);
//            Object objD3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa2.resolve())).getValue();
//            throwIfVar1IsNull(objD3);
//            MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(hookParam.getThisObject()).getMethodResolverBasedOnPreviouslyProvidedConfig();
//            methodResolverVarT2.name = "getItem" /* "getItem" /* "getItem" /* "getItem" /* cnb.z(-49499498085162L)   */;
//            Object objE4 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invokeAndThrowIfFailed(Integer.valueOf(iIntValue));
//            throwIfVar1IsNull(objE4);
//            MsgInfoBean msgInfoBean2 = new MsgInfoBean(objE4);
//            for (bnc bncVar2 : linkedHashSet) {
//                try {
//                    bncVar2.i(view2, tag2, objD3, msgInfoBean2);
//                } catch (Exception e2) {
//                    ArrayList arrayList2 = Logger.a;
//                    StringBuilder sb2 = new StringBuilder();
//                    sb2.append("onBindView " /* "onBindView " /* "onBindView " /* "onBindView " /* cnb.z(-50014894160682L)   */);
//                    Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
//                            bncVar2 instanceof SwitchHook ? ((SwitchHook) bncVar2).getResult()
//                                    : "LoadHook" /* "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-49928994814762L)   */,
//                            -49907519978282L), e2, 12);
//                }
//            }
//        }
        }));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ChatItemViewNewApi$MethodOnBindView.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj1;
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings(
                        (/* version check: cnb.ab(ewk.d) || cnb.ac(ewh.d)) ?*/ "MicroMsg.MvvmChattingItem",
//                                 : "MicroMsg.ChattingDataAdapterV2",
                        "dealItemView");
                DexFinder.k(cdjVar, "[onBindView] ");
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
            })
        }));
    }
}
