package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PanelEmojiHook extends SwitchHook implements IDexFind {
    public static final PanelEmojiHook a = new PanelEmojiHook("PanelEmojiHook" /* "PanelEmojiHook" /* "PanelEmojiHook" /* cnb.z(-474439267384106L)  */);
    public static final String b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg m;
    public static final boolean n;
    public static final ArrayList someArrayList;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Resource" /* "Resource" /* "Resource" /* cnb.z(-47987669596970L)  */, "Panel" /* "Panel" /* "Panel" /* cnb.z(-47966194760490L)  */);
        c = "聊天" /* "聊天" /* "聊天" /* cnb.z(-471926711515946L)  */;
        i = "面板本地表情" /* "面板本地表情" /* "面板本地表情" /* cnb.z(-471879466875690L)  */;
        j = "为聊天面板的表情分组添加相关表情包" /* "为聊天面板的表情分组添加相关表情包" /* "为聊天面板的表情分组添加相关表情包" /* cnb.z(-471832222235434L)  */;
        m = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(1);
        n = true;
        someArrayList = new ArrayList();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        alc alcVar = aou.a;
        KotlinHelpers2.bf(akq.f, new lw(2, null, 4));
        List listBf = dqc.toSingletonList(emn.bb(PanelEmojiHookMethodGetEmojiGroupInfo.INSTANCE));
        PanelEmojiHook panelEmojiHookVar = a;
        aki akiVarAb = csb.ab(panelEmojiHookVar, listBf);
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
            cde cdeVarT = dqc.bi(objC).t();
            cdeVarT.ab = "convertFrom" /* "convertFrom" /* "convertFrom" /* "convertFrom" /* cnb.z(-78438987725610L)   */;
            cdeVarT.z(Arrays.copyOf(new Object[] { dal.b(ContentValues.class), dal.b(Boolean.TYPE) }, 2));
            cdeVarT.ah();
            ((MethodHookWrapper) aaz.e(cdeVarT.aj())).e(contentValues, Boolean.TRUE);
            list.add(0, objC);
            return kotlinUnitVar;
        });
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(panelEmojiHookVar, dqc.toSingletonList(emn.bb(PanelEmojiHookMethodAddAllGroupItems.INSTANCE)));
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
                objX = bhu.x(th);
            }
            Object obj3 = objX instanceof dcx ? null : objX;
            throwIfVar1IsNull(obj3);
            int i9 = 0;
            bmu bmuVarBi = dqc.bi(obj3);
            cde cdeVarT2 = bmuVarBi.t();
            cdeVarT2.ak(cdy.d);
            cdeVarT2.ai = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(9);
            Object objE = ((MethodHookWrapper) dkz.m(cdeVarT2)).e(new Object[0]);
            throwIfVar1IsNull(objE);
            azg azgVarR = dqc.bi(objE).r();
            azgVarR.a = ajn.tryGetClassByClassName("com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* "com.tencent.mm.storage.emotion.EmojiGroupInfo" /* cnb.z(-78585016613674L)   */);
            Object objD = ((azk) aaz.e(azgVarR.c())).d();
            throwIfVar1IsNull(objD);
            azg azgVarR2 = dqc.bi(objD).r();
            azgVarR2.ab = "field_packName" /* "field_packName" /* "field_packName" /* "field_packName" /* cnb.z(-470968933808938L)   */;
            String str = (String) ((azk) yg.e(azgVarR2)).e();
            cde cdeVarT3 = bmuVarBi.t();
            cdeVarT3.a = dal.b(List.class);
            Object objJ = ((MethodHookWrapper) dkz.m(cdeVarT3)).j(new Object[0]);
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
        emn.aj(PanelEmojiHookConstructorGroupItemInfo.INSTANCE, dexKitBridge, () -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj) -> {
                Class cls;
                Class cls5;
                cls = Integer.class;
                obj = null;
                KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
                bah bahVar3 = (bah) obj;
                cdj cdjVar4 = new cdj();
                Class clsAg = ajn.tryGetClassByClassName("com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* cnb.z(-472497942166314L)   */);
                Class<Integer> clsBf4 = cnf.bf(dal.b(cls));
                if (clsBf4 == null) {
                    clsBf4 = cls;
                }
                cls5 = String.class;
                Class<String> clsBf5 = cnf.bf(dal.b(cls5));
                cls5 = clsBf5 != null ? clsBf5 : String.class;
                Class<Integer> clsBf6 = cnf.bf(dal.b(cls));
                cdjVar4.q(clsAg, clsBf4, cls5, clsBf6 != null ? clsBf6 : Integer.class);
                cdjVar4.t("emojiInfo" /* "emojiInfo" /* "emojiInfo" /* "emojiInfo" /* cnb.z(-472351913278250L)   */, "sosDocId" /* "sosDocId" /* "sosDocId" /* "sosDocId" /* cnb.z(-472326143474474L)   */);
                bahVar3.getClass();
                bahVar3.d = cdjVar4;
                return kotlinUnitVar;
            };
        });
        emn.aj(PanelEmojiHookMethodGetEmojiGroupInfo.INSTANCE, dexKitBridge, () -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = () -> {
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i3);
                return ensVar;
            };
            return ensVar;
        });
        emn.aj(PanelEmojiHookMethodAddAllGroupItems.INSTANCE, dexKitBridge, new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(8));
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
