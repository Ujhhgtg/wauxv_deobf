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
    public static final PanelEmojiHook a = new PanelEmojiHook("PanelEmojiHook" /* "PanelEmojiHook" /* "PanelEmojiHook" /* cnb.z(-474439267384106L)  */);
    public static final String b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final Function1$VarIsInt m;
    public static final boolean n;
    public static final ArrayList someArrayList;

    static {
        Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
        b = PathUtils.getModuleSubDir("Resource" /* "Resource" /* "Resource" /* cnb.z(-47987669596970L)  */, "Panel" /* "Panel" /* "Panel" /* cnb.z(-47966194760490L)  */);
        c = "聊天" /* "聊天" /* "聊天" /* cnb.z(-471926711515946L)  */;
        i = "面板本地表情" /* "面板本地表情" /* "面板本地表情" /* cnb.z(-471879466875690L)  */;
        j = "为聊天面板的表情分组添加相关表情包" /* "为聊天面板的表情分组添加相关表情包" /* "为聊天面板的表情分组添加相关表情包" /* cnb.z(-471832222235434L)  */;
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
                        dnc.c(PanelEmojiHook.b);
                        dnc.g(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-474211634117418L)  */);
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
                                new Object[] { dal.b(String.class), dal.b(String.class), dal.b(String[].class) }, 3, methodResolverVarT))
                                .j(strZ, strZ2, strArr);
                        throwIfVar1IsNull(objJ);
                        ((Number) objJ).intValue();
                        dnc.g(null, 3, "清除成功" /* "清除成功" /* "清除成功" /* cnb.z(-471226631846698L)  */);
                    });
                    DefaultConfig ioVar = new DefaultConfig(view2.getContext(), 13);
                    PanelEmojiHook.a.getClass();
                    ioVar.ay(PanelEmojiHook.i);
                    ioVar.d = (LinearLayout) viewK2;
                    DefaultConfig.g(ioVar, null, 3);
                    DefaultConfig.f(ioVar, null, 3);
                    ioVar.az();
                    return kotlinUnitVar;
                }
            }
            throw new NullPointerException("Missing required view with ID: "
                    /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-663864505006890L)   */.concat(viewK2.getResources().getResourceName(i7)));
        };
        n = true;
        someArrayList = new ArrayList();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        alc alcVar = aou.a;
        KotlinHelpers2.bf(akq.f, new lw(2, null, 4));
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(PanelEmojiHook$MethodGetEmojiGroupInfo.INSTANCE));
        PanelEmojiHook panelEmojiHookVar = a;
        aki akiVarAb = PackageParam.ab(panelEmojiHookVar, listBf);
        panelEmojiHookVar.x(akiVarAb, () -> {
            Object obj2 = null;
            KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
            Object objF = ((HookParam) obj).getResult();
            if ((objF instanceof List) && (!(objF instanceof IEmpty) || (objF instanceof IEmpty3))) {
                obj2 = objF;
            }
            List list = (List) obj2;
            throwIfVar1IsNull(list);
            ContentValues contentValues = new ContentValues();
            contentValues.put("packGrayIconUrl" /* "packGrayIconUrl" /* "packGrayIconUrl" /* "packGrayIconUrl" /* cnb.z(-471239516748586L)   */,
                    "https://avatars.githubusercontent.com/u/49312623" /* "https://avatars.githubusercontent.com/u/49312623" /* "https://avatars.githubusercontent.com/u/49312623" /* "https://avatars.githubusercontent.com/u/49312623" /* cnb.z(-471170797271850L)   */);
            contentValues.put("packIconUrl" /* "packIconUrl" /* "packIconUrl" /* "packIconUrl" /* cnb.z(-471458560080682L)   */,
                    "https://avatars.githubusercontent.com/u/49312623" /* "https://avatars.githubusercontent.com/u/49312623" /* "https://avatars.githubusercontent.com/u/49312623" /* "https://avatars.githubusercontent.com/u/49312623" /* cnb.z(-471441380211498L)   */);
            contentValues.put("packName" /* "packName" /* "packName" /* "packName" /* cnb.z(-470681171000106L)   */, "面板表情" /* "面板表情" /* "面板表情" /* "面板表情" /* cnb.z(-470659696163626L)   */);
            contentValues.put("packStatus" /* "packStatus" /* "packStatus" /* "packStatus" /* cnb.z(-470603861588778L)   */, (Integer) 1);
            contentValues.put("productID" /* "productID" /* "productID" /* "productID" /* cnb.z(-471140732500778L)   */, "wauxv.panel.emoji" /*
             * cnb.z(-
             * 471046243220266L)
             */);
            contentValues.put("status" /* "status" /* "status" /* "status" /* cnb.z(-470986113678122L)   */, (Integer) 7);
            contentValues.put("sync" /* "sync" /* "sync" /* "sync" /* cnb.z(-470938869037866L)   */, (Integer) 2);
            Object objC = ReflectionWrapper.createInstanceWithArgs(
                    ajn.tryGetClassByClassName("com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* cnb.z(-78585016613674L)   */),
                    new Object[0]);
            int i8 = 0;
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "convertFrom" /* "convertFrom" /* "convertFrom" /* "convertFrom" /* cnb.z(-78438987725610L)   */;
            methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.b(ContentValues.class), dal.b(Boolean.TYPE) }, 2));
            methodResolverVarT.enableSuperclass();
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).e(contentValues, Boolean.TRUE);
            list.add(0, objC);
            return kotlinUnitVar;
        });
        akiVarAb.o();
        aki akiVarAb2 = PackageParam.ab(panelEmojiHookVar, dqc.toSingletonList(StaticHelpers7.bb(PanelEmojiHookMethodAddAllGroupItems.INSTANCE)));
        panelEmojiHookVar.y(akiVarAb2, () -> {
            Object objX;
            KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
            HookParam hookParam = (HookParam) obj;
            hookParam.getClass();
            try {
                objX = hookParam.getArgs()[0];
                if (objX == null) {
                    objX = null;
                }
            } catch (Throwable th) {
                objX = FastKV.x(th);
            }
            Object obj3 = objX instanceof dcx ? null : objX;
            throwIfVar1IsNull(obj3);
            int i9 = 0;
            SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(obj3);
            MethodResolver methodResolverVarT2 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.ak(cdy.d);
            methodResolverVarT2.ai = new Function1$VarIsInt(9);
            Object objE = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).e(new Object[0]);
            throwIfVar1IsNull(objE);
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objE).r();
            fieldResolverVarR.fieldType = ajn.tryGetClassByClassName("com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* cnb.z(-78585016613674L)   */);
            Object objD = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).d();
            throwIfVar1IsNull(objD);
            FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objD).r();
            fieldResolverVarR2.name = "field_packName" /* "field_packName" /* "field_packName" /* "field_packName" /* cnb.z(-470968933808938L)   */;
            String str = (String) ((azk) yg.e(fieldResolverVarR2)).e();
            MethodResolver methodResolverVarT3 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT3.returnType = dal.b(List.class);
            Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).j(new Object[0]);
            throwIfVar1IsNull(objJ);
            List list2 = (List) objJ;
            if (nullSafeIsEqual(str, "面板表情" /* "面板表情" /* "面板表情" /* "面板表情" /* cnb.z(-470887329430314L)   */)) {
                list2.addAll(PanelEmojiHook.someArrayList);
            }
            return kotlinUnitVar;
        });
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(PanelEmojiHookConstructorGroupItemInfo.INSTANCE, dexKitBridge, () -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj) -> {
                Class cls;
                Class cls5;
                cls = Integer.class;
                obj = null;
                KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
                bah bahVar3 = (bah) obj;
                cdj cdjVar4 = new cdj();
                Class clsAg = ajn.tryGetClassByClassName("com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* cnb.z(-472497942166314L)   */);
                Class<Integer> clsBf4 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                if (clsBf4 == null) {
                    clsBf4 = cls;
                }
                cls5 = String.class;
                Class<String> clsBf5 = HugeSyntheticPileOfHelpers.bf(dal.b(cls5));
                cls5 = clsBf5 != null ? clsBf5 : String.class;
                Class<Integer> clsBf6 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
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
        StaticHelpers7.resolveDexAndCache(PanelEmojiHookMethodAddAllGroupItems.INSTANCE, dexKitBridge, new Function1$VarIsInt(8));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return j;
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
