package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.android.material.button.MaterialButton;
import me.hd.wauxv.R;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PanelEmojiHook extends SwitchHook implements IDexFind {
    public static final PanelEmojiHook INSTANCE = new PanelEmojiHook("PanelEmojiHook" /* "PanelEmojiHook" /* "PanelEmojiHook" /* cnb.z(-474439267384106L)  */);
    public static final String RESOURCE_DIR;
    public static final String CATEGORY;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final Function1$VarIsObj m;
    public static final boolean n;
    public static final ArrayList someArrayList;

    static {
        Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
        RESOURCE_DIR = PathUtils.getModuleSubDir("Resource" /* "Resource" /* "Resource" /* cnb.z(-47987669596970L)  */, "Panel" /* "Panel" /* "Panel" /* cnb.z(-47966194760490L)  */);
        CATEGORY = "聊天" /* "聊天" /* "聊天" /* cnb.z(-471926711515946L)  */;
        NAME = "面板本地表情" /* "面板本地表情" /* "面板本地表情" /* cnb.z(-471879466875690L)  */;
        DESCRIPTION = "为聊天面板的表情分组添加相关表情包" /* "为聊天面板的表情分组添加相关表情包" /* "为聊天面板的表情分组添加相关表情包" /* cnb.z(-471832222235434L)  */;
        m = (obj) -> {
            View view2 = (View) obj;
            View viewK2 = StaticHelpers6.k(view2, R.layout.module_dialog_panel_emoji, null, false);
            int i7 = R.id.moduleDialogBtnPanelEmojiClearGroup;
            MaterialButton materialButton = (MaterialButton) KotlinHelpers2.recursivelyFindViewById(viewK2,
                    R.id.moduleDialogBtnPanelEmojiClearGroup);
            if (materialButton != null) {
                i7 = R.id.moduleDialogBtnPanelEmojiCopyPath;
                MaterialButton materialButton2 = (MaterialButton) KotlinHelpers2.recursivelyFindViewById(viewK2,
                        R.id.moduleDialogBtnPanelEmojiCopyPath);
                if (materialButton2 != null) {
                    materialButton2.setOnClickListener((view) -> {
                        dnc.c(PanelEmojiHook.RESOURCE_DIR);
                        dnc.sendToast(null, 3, "复制成功");
                    });
                    materialButton.setOnClickListener((view) -> {
                        String strZ = "EmojiGroupInfo";
                        String strZ2 = "productID = ?";
                        String[] strArr = { "wa.panel.emoji.group" };
                        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dlx.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT.name = "delete";
                        Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(
                                new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(String.class), dal.getKClassFromClass(String[].class) }, 3, methodResolverVarT))
                                .invoke(strZ, strZ2, strArr);
                        throwIfVar1IsNull(objJ);
                        ((Number) objJ).intValue();
                        dnc.sendToast(null, 3, "清除成功");
                    });
                    DefaultConfig ioVar = new DefaultConfig(view2.getContext(), 13);
                    PanelEmojiHook.INSTANCE.getClass();
                    ioVar.ay(PanelEmojiHook.NAME);
                    ioVar.d = (LinearLayout) viewK2;
                    DefaultConfig.g(ioVar, null, 3);
                    DefaultConfig.f(ioVar, null, 3);
                    ioVar.az();
                    return kotlinUnitVar;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewK2.getResources().getResourceName(i7)));
        };
        n = true;
        someArrayList = new ArrayList();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        Dispatchers$Default alcVar = aou.a;
        KotlinHelpers2.bf(Dispatchers$IO.INSTANCE, new lw(2, null, 4));
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(PanelEmojiHook$MethodGetEmojiGroupInfo.INSTANCE));
        PanelEmojiHook panelEmojiHookVar = INSTANCE;
        HookManager hookManagerVarAb = PackageParam.createHook(panelEmojiHookVar, listBf);
        panelEmojiHookVar.hookAfter(hookManagerVarAb, (hookParam) -> {
            Object result2 = null;
            Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
            Object result = ((HookParam) hookParam).getResult();
            if ((result instanceof List) && (!(result instanceof IEmpty) || (result instanceof IEmpty3))) {
                result2 = result;
            }
            List resultList = (List) result2;
            throwIfVar1IsNull(resultList);
            ContentValues contentValues = new ContentValues();
            contentValues.put("packGrayIconUrl",
                    "https://avatars.githubusercontent.com/u/49312623");
            contentValues.put("packIconUrl",
                    "https://avatars.githubusercontent.com/u/49312623");
            contentValues.put("packName", "面板表情");
            contentValues.put("packStatus", (Integer) 1);
            contentValues.put("productID", "wauxv.panel.emoji" /*
             * cnb.z(-
             * 471046243220266L)
             */);
            contentValues.put("status", (Integer) 7);
            contentValues.put("sync", (Integer) 2);
            Object objC = ReflectionWrapper.createInstanceWithArgs(
                    ajn.tryGetClassByClassName("com.tencent.mm.storage.emotion.EmojiGroupInfo"),
                    new Object[0]);
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "convertFrom";
            methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(ContentValues.class), dal.getKClassFromClass(Boolean.TYPE) }, 2));
            methodResolverVarT.enableSuperclass();
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(contentValues, Boolean.TRUE);
            resultList.add(0, objC);
            return kotlinUnitVar;
        });
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(panelEmojiHookVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(PanelEmojiHook$MethodAddAllGroupItems.INSTANCE)));
        panelEmojiHookVar.hookBefore(hookManagerVarAb2, (obj) -> {
            Object objX;
            Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
            HookParam hookParam = (HookParam) obj;
            try {
                objX = hookParam.getArgs()[0];
            } catch (Throwable th) {
                objX = FastKV.getFailureFromException(th);
            }
            Object obj3 = objX instanceof Failure ? null : objX;
            throwIfVar1IsNull(obj3);
            SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(obj3);
            MethodResolver methodResolverVarT2 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.addAccessModifiers(AccessModifierEnum.FINAL);
            methodResolverVarT2.returnTypeCondition = (obj2) -> {
                Class cls6 = (Class) obj2;
                Class<Boolean> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Boolean.class));
                boolean zF = nullSafeIsEqual(cls6, clsBf3 != null ? clsBf3 : Boolean.class);
                return !zF;
            };
            Object objE = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).invokeAndThrowIfFailed(new Object[0]);
            throwIfVar1IsNull(objE);
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objE).r();
            fieldResolverVarR.fieldType = ajn.tryGetClassByClassName("com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* cnb.z(-78585016613674L)   */);
            Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
            throwIfVar1IsNull(objD);
            FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objD).r();
            fieldResolverVarR2.name = "field_packName" /* "field_packName" /* "field_packName" /* "field_packName" /* cnb.z(-470968933808938L)   */;
            String str = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue_();
            MethodResolver methodResolverVarT3 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT3.returnType = dal.getKClassFromClass(List.class);
            Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).invoke(new Object[0]);
            throwIfVar1IsNull(objJ);
            List list2 = (List) objJ;
            if (nullSafeIsEqual(str, "面板表情" /* "面板表情" /* "面板表情" /* "面板表情" /* cnb.z(-470887329430314L)   */)) {
                list2.addAll(PanelEmojiHook.someArrayList);
            }
            return kotlinUnitVar;
        });
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return NAME;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return CATEGORY;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(PanelEmojiHook$ConstructorGroupItemInfo.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2) -> {
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.q(ajn.tryGetClassByClassName("com.tencent.mm.api.IEmojiInfo"), Integer.class, String.class, Integer.class);
                cdjVar4.usingStrings("emojiInfo", "sosDocId");
            };
        });
        StaticHelpers7.resolveDexAndCache(PanelEmojiHook$MethodGetEmojiGroupInfo.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2) -> {
                ((FindDexClassMethodDslWrapper) obj2).onMethodCallback = (obj3) -> {
                    DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj3;
                    DexFinder cdjVar2 = new DexFinder();
                    cdjVar2.usingStrings("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo.");
                    dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                };
            };
        });
        StaticHelpers7.resolveDexAndCache(PanelEmojiHook$MethodAddAllGroupItems.INSTANCE, dexKitBridge, (obj) -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj2) -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj2;
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.usingStrings("data");
                MethodMatcher fjVar = new MethodMatcher();
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.usingStrings("checkScrollToPosition: ");
                fjVar.f(cdjVar3);
                fjVar.usingStringsType = UsingStringsTypeEnum.Contains;
                cdjVar2.i = fjVar;
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
            };
        });
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return DESCRIPTION;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return m;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return n;
    }
}
