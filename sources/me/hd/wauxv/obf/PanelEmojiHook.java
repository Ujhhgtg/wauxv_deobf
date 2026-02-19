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
                        dnc.sendToast(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-474211634117418L)  */);
                    });
                    materialButton.setOnClickListener((view) -> {
                        String strZ = "EmojiGroupInfo" /* "EmojiGroupInfo" /* "EmojiGroupInfo" /* cnb.z(-474172979411754L)  */;
                        String strZ2 = "productID = ?" /* "productID = ?" /* "productID = ?" /* cnb.z(-471411315440426L)  */;
                        String[] strArr = { "wa.panel.emoji.group" /* "wa.panel.emoji.group" /* "wa.panel.emoji.group" /* cnb.z(-471334006029098L)  */ };
                        int i = 0;
                        dlx.a.getClass();
                        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dlx.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT.name = "delete" /* "delete" /* "delete" /* cnb.z(-103225243990826L)  */;
                        Object objJ = ((MethodHookWrapper) StaticHelpers6.n(
                                new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(String.class), dal.getKClassFromClass(String[].class) }, 3, methodResolverVarT))
                                .j(strZ, strZ2, strArr);
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
        KotlinHelpers2.bf(akq.f, new lw(2, null, 4));
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(PanelEmojiHook$MethodGetEmojiGroupInfo.INSTANCE));
        PanelEmojiHook panelEmojiHookVar = INSTANCE;
        HookManager hookManagerVarAb = PackageParam.createHook(panelEmojiHookVar, listBf);
        panelEmojiHookVar.x(hookManagerVarAb, () -> {
            Object obj2 = null;
            Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
            Object objF = ((HookParam) obj).getResult();
            if ((objF instanceof List) && (!(objF instanceof IEmpty) || (objF instanceof IEmpty3))) {
                obj2 = objF;
            }
            List list = (List) obj2;
            throwIfVar1IsNull(list);
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
            int i8 = 0;
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "convertFrom";
            methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(ContentValues.class), dal.getKClassFromClass(Boolean.TYPE) }, 2));
            methodResolverVarT.enableSuperclass();
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).e(contentValues, Boolean.TRUE);
            list.add(0, objC);
            return kotlinUnitVar;
        });
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(panelEmojiHookVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(PanelEmojiHookMethodAddAllGroupItems.INSTANCE)));
        panelEmojiHookVar.y(hookManagerVarAb2, () -> {
            Object objX;
            Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
            HookParam hookParam = (HookParam) obj;
            hookParam.getClass();
            try {
                objX = hookParam.getArgs()[0];
                if (objX == null) {
                    objX = null;
                }
            } catch (Throwable th) {
                objX = FastKV.getFailureFromException(th);
            }
            Object obj3 = objX instanceof Failure ? null : objX;
            throwIfVar1IsNull(obj3);
            SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(obj3);
            MethodResolver methodResolverVarT2 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.addAccessModifiers(AccessModifierEnum.FINAL);
            methodResolverVarT2.ai = (obj) -> {
                Class cls6 = (Class) obj;
                Class<Boolean> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Boolean.class));
                boolean zF = nullSafeIsEqual(cls6, clsBf3 != null ? clsBf3 : Boolean.class);
                return !zF;
            };
            Object objE = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).e(new Object[0]);
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
            Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).j(new Object[0]);
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
        StaticHelpers7.resolveDexAndCache(PanelEmojiHookConstructorGroupItemInfo.INSTANCE, dexKitBridge, () -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj) -> {
                Class cls;
                Class cls5;
                cls = Integer.class;
                obj = null;
                Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
                bah bahVar3 = (bah) obj;
                cdj cdjVar4 = new cdj();
                Class clsAg = ajn.tryGetClassByClassName("com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* cnb.z(-472497942166314L)   */);
                Class<Integer> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf4 == null) {
                    clsBf4 = cls;
                }
                cls5 = String.class;
                Class<String> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                cls5 = clsBf5 != null ? clsBf5 : String.class;
                Class<Integer> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar4.q(clsAg, clsBf4, cls5, clsBf6 != null ? clsBf6 : Integer.class);
                cdjVar4.t("emojiInfo" /* "emojiInfo" /* "emojiInfo" /* "emojiInfo" /* cnb.z(-472351913278250L)   */, "sosDocId" /* "sosDocId" /* "sosDocId" /* "sosDocId" /* cnb.z(-472326143474474L)   */);
                bahVar3.getClass();
                bahVar3.d = cdjVar4;
                return kotlinUnitVar;
            };
        });
        StaticHelpers7.resolveDexAndCache(PanelEmojiHook$MethodGetEmojiGroupInfo.INSTANCE, dexKitBridge, () -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = () -> {
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i3);
                return ensVar;
            };
            return ensVar;
        });
        StaticHelpers7.resolveDexAndCache(PanelEmojiHookMethodAddAllGroupItems.INSTANCE, dexKitBridge, new Function1$VarIsObj(8));
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
