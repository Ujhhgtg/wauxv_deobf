package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.List;

import me.hd.wauxv.data.bean.MsgInfoBean;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ChatItemMenuNewApiHook extends ApiHookItem implements IDexFind {
    public static final ChatItemMenuNewApiHook INSTANCE = new ChatItemMenuNewApiHook();
    public static final LinkedHashSet ALL_HOOKS = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(ChatItemMenuNewApi$MethodCreateMenu.INSTANCE));
        ChatItemMenuNewApiHook chatItemMenuNewApiHookVar = INSTANCE;
        HookManager hookManagerVarAb = PackageParam.createHook(chatItemMenuNewApiHookVar, listBf);
        hookManagerVarAb.hookBefore((obj -> {
            HookParam hookParam4 = (HookParam) obj;
            Object obj8 = hookParam4.getArgs()[0];
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj8).createFieldResolver();
            fieldResolverVarR.fieldType = dal.getKClassFromClass(Context.class);
            Object objE6 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue_();
            Resources resources = ((Context) objE6).getResources();
            if (resources != null) {
                HugeSyntheticPileOfHelpers.injectModuleAssets(resources);
            }
            IInvokable kotlin$LazyVar = (arg -> {
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(arg).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.returnType = dal.getKClassFromClass(MenuItem.class);
                Class cls = Integer.TYPE;
                return (MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(
                        new Object[] { dal.getKClassFromClass(cls), dal.getKClassFromClass(cls), dal.getKClassFromClass(cls), dal.getKClassFromClass(CharSequence.class), dal.getKClassFromClass(cls) }, 5,
                        methodResolverVarT);
            });
            Object obj3 = hookParam4.getArgs()[1];
            Object tag = ((View) obj3).getTag();
            MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(tag).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.returnType = dal.getKClassFromClass(Integer.TYPE);
            methodResolverVarT2.setParamCountTo0();
            methodResolverVarT2.enableSuperclass();
            Integer num = (Integer) ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invoke(new Object[0]);
            // host version check
//            if (cnb.ab(ewk.p) || cnb.ac(ewh.s)) {
                MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(tag).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT3.returnType = StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE);
                methodResolverVarT3.parameterCount = 0;
                Object objE = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).invokeAndThrowIfFailed(new Object[0]);
                throwIfVar1IsNull(objE);
//            } else {
//                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(tag).createFieldResolver();
//                MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
//                fieldResolverVarR2.fieldType = StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE);
//                objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue();
//                throwIfVar1IsNull(objE);
//            }
            MsgInfoBean msgInfoBean = new MsgInfoBean(objE);
            for (IMessageLongPressHook bnaVar : ChatItemMenuNewApiHook.ALL_HOOKS) {
//                try {
                    for (wj wjVar : bnaVar.getUiElements(msgInfoBean)) {
                        MethodHookWrapper methodHookWrapperVarD = ((MethodHookWrapper) kotlin$LazyVar.invoke(obj8)).d();
                        methodHookWrapperVarD.bindInstance(obj8);
                        methodHookWrapperVarD.invokeAndThrowIfFailed(num, Integer.valueOf(wjVar.someInt), 0, wjVar.someStr, Integer.valueOf(wjVar.anotherInt));
                    }
//                } catch (Exception e) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("onCreateMenuItems ");
//                    Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
//                            bnaVar instanceof SwitchHook ? ((SwitchHook) bnaVar).getResult() : "LoadHook",
//                            "Failed"), e, 12);
//                }
            }
        }));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(chatItemMenuNewApiHookVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(ChatItemMenuNewApi$MethodSelectMenu.INSTANCE)));
        hookManagerVarAb2.hookBefore((obj -> {
            HookParam hookParam5 = (HookParam) obj;
            FieldResolver fieldResolverVarAa5 = StaticHelpers6.createFieldResolverFromHookParamThisObject(hookParam5);
            fieldResolverVarAa5.fieldMatcher = (obj1 -> Boolean.valueOf(View.OnLongClickListener.class.isAssignableFrom((Class) obj1)));
            Object viewOnLongClickListener = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa5.resolve())).getValue_();
            FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration((View.OnLongClickListener) viewOnLongClickListener).createFieldResolver();
            fieldResolverVarR3.fieldType = StaticHelpers7.toDexClass(ChattingContext$ClassChattingContext.INSTANCE);
            Object chattingContext = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue();
            FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(chattingContext).createFieldResolver();
            fieldResolverVarR4.fieldType = StaticHelpers7.toDexMethod(ApiManager$MethodGetApi.INSTANCE).getDeclaringClass();
            Object apiManager = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).getValue();
            FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(ApiManagerGetApiDexFindHook.getApi((Class) SomeStaticHelpers.getFirstInArray(StaticHelpers7.toDexClass(ChattingMessBox$ClassChattingMessBox.INSTANCE).getInterfaces()), apiManager)).createFieldResolver();
            fieldResolverVarR5.fieldType = StaticHelpers7.toDexClass(ChattingContext$ClassChattingContext.INSTANCE);
            Object objD5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).getValue();
            FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(objD5).createFieldResolver();
            fieldResolverVarR6.fieldType = StaticHelpers7.toDexMethod(ApiManager$MethodGetApi.INSTANCE).getDeclaringClass();
            Object objD6 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR6.resolve())).getValue();
            Object api2 = ApiManagerGetApiDexFindHook.getApi((Class) SomeStaticHelpers.getFirstInArray(StaticHelpers7.toDexClass(ChattingDataAdapter$ClassChattingDataAdapter.INSTANCE).getInterfaces()), objD6);
            Object arg0 = hookParam5.getArgs()[0];
            MenuItem menuItem = (MenuItem) arg0;
            MethodResolver methodResolverVarT4 = dqc.getWrapperConfiguration(api2).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT4.name = "getItem";
            Object objE8 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT4.findMethods())).invokeAndThrowIfFailed(Integer.valueOf(menuItem.getGroupId()));
            MsgInfoBean msgInfoBean2 = new MsgInfoBean(objE8);
            for (IMessageLongPressHook bnaVar2 : ChatItemMenuNewApiHook.ALL_HOOKS) {
//                try {
                    for (wj wjVar2 : bnaVar2.getUiElements(msgInfoBean2)) {
                        if (menuItem.getItemId() == wjVar2.someInt) {
                            wjVar2.function2.g(chattingContext, msgInfoBean2);
                        }
                    }
//                } catch (Exception e2) {
//                    ArrayList arrayList3 = Logger.a;
//                    StringBuilder sb2 = new StringBuilder();
//                    sb2.append("onCreateMenuItems ");
//                    Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
//                            bnaVar2 instanceof SwitchHook ? ((SwitchHook) bnaVar2).getResult() : "LoadHook",
//                            "Failed"), e2, 12);
//                }
            }
        }));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ChatItemMenuNewApi$MethodCreateMenu.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj1;
                String[] strArr = { "com.tencent.mm.ui.chatting.viewitems" };
                dexMethodQueryBuilderVar4.searchedPackages = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("MicroMsg.ChattingItem", "msg is null!");
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
            });
        }));
        StaticHelpers7.resolveDexAndCache(ChatItemMenuNewApi$MethodSelectMenu.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj1;
                String[] strArr2 = { "com.tencent.mm.ui.chatting.viewitems" };
                dexMethodQueryBuilderVar5.searchedPackages = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.usingStrings("MicroMsg.ChattingItem", "context item select failed, null dataTag");
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
            });
        }));
    }
}
