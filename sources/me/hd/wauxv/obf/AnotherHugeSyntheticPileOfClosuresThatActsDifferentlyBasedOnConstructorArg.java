package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls;
        Class cls2;
        Class cls3;
        Object objX;
        Class cls4;
        boolean zF;
        Class cls5;
        Object objX2;
        int i = this.a;
        cls = Integer.class;
        int i2 = 7;
        cls2 = CharSequence.class;
        int i3 = 2;
        int i4 = 3;
        obj = null;
        Object obj2 = null;
        int i5 = 0;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        switch (i) {
            case 0:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_open_info, null, false);
                int i6 = R.id.moduleDialogEdtOpenInfoId;
                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.aq(viewK, R.id.moduleDialogEdtOpenInfoId);
                if (textInputEditText != null) {
                    i6 = R.id.moduleDialogInputOpenInfoId;
                    if (((TextInputLayout) KotlinHelpers2.aq(viewK, R.id.moduleDialogInputOpenInfoId)) != null) {
                        LinearLayout linearLayout = (LinearLayout) viewK;
                        cee ceeVar = new cee(linearLayout, textInputEditText, 6);
                        bzy bzyVar = new bzy(view.getContext());
                        eg egVar = (eg) bzyVar.d;
                        crm.a.getClass();
                        egVar.d = crm.c;
                        bzyVar.t("确定" /* "确定" /* "确定" /* "确定" /* cnb.z(-513016663636778L)   */, new amw(new ls(ceeVar, 6, view), 0));
                        bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                        if (linearLayout != null) {
                            egVar.r = linearLayout;
                        }
                        bzyVar.i().show();
                        return kotlinUnitVar;
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-664001943960362L)   */.concat(viewK.getResources().getResourceName(i6)));
            case 1:
                View view2 = (View) obj;
                View viewK2 = dkz.k(view2, R.layout.module_dialog_panel_emoji, null, false);
                int i7 = R.id.moduleDialogBtnPanelEmojiClearGroup;
                MaterialButton materialButton = (MaterialButton) KotlinHelpers2.aq(viewK2,
                        R.id.moduleDialogBtnPanelEmojiClearGroup);
                if (materialButton != null) {
                    i7 = R.id.moduleDialogBtnPanelEmojiCopyPath;
                    MaterialButton materialButton2 = (MaterialButton) KotlinHelpers2.aq(viewK2,
                            R.id.moduleDialogBtnPanelEmojiCopyPath);
                    if (materialButton2 != null) {
                        materialButton2.setOnClickListener(new d(i4));
                        materialButton.setOnClickListener(new d(4));
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
            case 2:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cls3 = ArrayList.class;
                Class<ArrayList> clsBf = cnf.bf(dal.b(cls3));
                cdjVar.r(clsBf != null ? clsBf : ArrayList.class);
                Class<Integer> clsBf2 = cnf.bf(dal.b(cls));
                cdjVar.q(clsBf2 != null ? clsBf2 : Integer.class);
                cdjVar.t("MicroMsg.emoji.EmojiGroupInfoStorage" /* "MicroMsg.emoji.EmojiGroupInfoStorage" /* "MicroMsg.emoji.EmojiGroupInfoStorage" /* "MicroMsg.emoji.EmojiGroupInfoStorage" /* cnb.z(-472287488768810L)   */,
                        "get Panel EmojiGroupInfo." /* "get Panel EmojiGroupInfo." /* "get Panel EmojiGroupInfo." /* "get Panel EmojiGroupInfo." /* cnb.z(-472661150923562L)   */);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 3:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t("data" /* "data" /* "data" /* "data" /* cnb.z(-472566661643050L)   */);
                fj fjVar = new fj();
                cdj cdjVar3 = new cdj();
                cdjVar3.t("checkScrollToPosition: " /* "checkScrollToPosition: " /* "checkScrollToPosition: " /* "checkScrollToPosition: " /* cnb.z(-472579546544938L)   */);
                fjVar.f(cdjVar3);
                fjVar.d = bzu.Contains;
                cdjVar2.i = fjVar;
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return kotlinUnitVar;
            case 4:
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
            case 5:
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
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(10);
                return kotlinUnitVar;
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i3);
                return kotlinUnitVar;
            case 8:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i4);
                return kotlinUnitVar;
            case 9:
                Class cls6 = (Class) obj;
                cls4 = Boolean.class;
                Class<Boolean> clsBf3 = cnf.bf(dal.b(cls4));
                zF = nullSafeIsEqual(cls6, clsBf3 != null ? clsBf3 : Boolean.class);
                break;
            case 10:
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
            case 11:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(12);
                return kotlinUnitVar;
            case 12:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k("MicroMsg.PatMsgExtension" /* "MicroMsg.PatMsgExtension" /* "MicroMsg.PatMsgExtension" /* "MicroMsg.PatMsgExtension" /* cnb.z(-368452359420714L)   */, "insert pat msg %d %s %s" /*
                                                                                                              * cnb.z(-
                                                                                                              * 368362165107498L)
                                                                                                              */);
                bagVar.getClass();
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 13:
                View view3 = (View) obj;
                View viewK3 = dkz.k(view3, R.layout.module_dialog_placed_sort_pro, null, false);
                int i10 = R.id.moduleDialogCbPlacedSortProShowBottom;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.aq(viewK3,
                        R.id.moduleDialogCbPlacedSortProShowBottom);
                if (materialCheckBox != null) {
                    i10 = R.id.moduleDialogCbPlacedSortProShowReset;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.aq(viewK3,
                            R.id.moduleDialogCbPlacedSortProShowReset);
                    if (materialCheckBox2 != null) {
                        i10 = R.id.moduleDialogCbPlacedSortProShowTop;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) KotlinHelpers2.aq(viewK3,
                                R.id.moduleDialogCbPlacedSortProShowTop);
                        if (materialCheckBox3 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) viewK3;
                            cef cefVar = new cef(linearLayout2, materialCheckBox, materialCheckBox2, materialCheckBox3,
                                    1);
                            materialCheckBox3.setChecked(cto.a.i());
                            materialCheckBox2.setChecked(ctn.a.i());
                            materialCheckBox.setChecked(ctm.a.i());
                            bzy bzyVar2 = new bzy(view3.getContext());
                            eg egVar2 = (eg) bzyVar2.d;
                            ctp.b.getClass();
                            egVar2.d = ctp.i;
                            bzyVar2.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-526013234674474L)   */, new amw(new cfx(cefVar, i2), 0));
                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                            if (linearLayout2 != null) {
                                egVar2.r = linearLayout2;
                            }
                            bzyVar2.i().show();
                            return kotlinUnitVar;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-663177310239530L)   */.concat(viewK3.getResources().getResourceName(i10)));
            case 14:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                Integer num = (Integer) objX2;
                int iIntValue = num != null ? num.intValue() : 0;
                int i11 = 0;
                cde cdeVarT4 = dqc.bi(hookParam2.getThisObject()).t();
                cdeVarT4.ab = "getItem" /* "getItem" /* "getItem" /* "getItem" /* cnb.z(-525858615851818L)   */;
                Object objE2 = ((MethodHookWrapper) dkz.m(cdeVarT4)).e(Integer.valueOf(iIntValue));
                throwIfVar1IsNull(objE2);
                ConversationBean conversationBean = new ConversationBean(objE2);
                Object objF2 = hookParam2.getResult();
                ViewGroup viewGroup = (ViewGroup) (objF2 instanceof ViewGroup ? objF2 : null);
                throwIfVar1IsNull(viewGroup);
                View childAt = viewGroup.getChildAt(0);
                long flag = conversationBean.getFlag();
                if (6917529027641081856L <= flag && flag < 8070450532247928833L) {
                    childAt.setBackgroundColor(Color
                            .parseColor(cnb.z(cnh.aa(childAt.getContext()) ? -527473523555114L : -527447753751338L)));
                } else if (-6917529027641081856L > flag || flag >= -5764607523034234879L) {
                    childAt.setBackgroundColor(0);
                } else {
                    childAt.setBackgroundColor(Color
                            .parseColor(cnb.z(cnh.aa(childAt.getContext()) ? -527421983947562L : -527327494667050L)));
                }
                return kotlinUnitVar;
            case 15:
                ConversationBean conversationBean2 = (ConversationBean) obj;
                agc agcVar = agc.a;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("flag" /* "flag" /* "flag" /* "flag" /* cnb.z(-525948810165034L)   */,
                        Long.valueOf(arj.z(conversationBean2.getFlag(), agd.f)));
                agp.c(agp.a, agcVar.b(contentValues2), conversationBean2.getUsername());
                return kotlinUnitVar;
            case 16:
                ConversationBean conversationBean3 = (ConversationBean) obj;
                agc agcVar2 = agc.a;
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("flag" /* "flag" /* "flag" /* "flag" /* cnb.z(-525978874936106L)   */,
                        Long.valueOf(arj.z(conversationBean3.getFlag(), agd.d)));
                agp.c(agp.a, agcVar2.b(contentValues3), conversationBean3.getUsername());
                return kotlinUnitVar;
            case 17:
                ConversationBean conversationBean4 = (ConversationBean) obj;
                agc agcVar3 = agc.a;
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("flag" /* "flag" /* "flag" /* "flag" /* cnb.z(-525923040361258L)   */,
                        Long.valueOf(conversationBean4.getConversationTime()));
                agp.c(agp.a, agcVar3.b(contentValues4), conversationBean4.getUsername());
                return kotlinUnitVar;
            case 18:
                ConversationBean conversationBean5 = (ConversationBean) obj;
                agc agcVar4 = agc.a;
                ContentValues contentValues5 = new ContentValues();
                contentValues5.put("flag" /* "flag" /* "flag" /* "flag" /* cnb.z(-525884385655594L)   */,
                        Long.valueOf(arj.z(conversationBean5.getFlag(), agd.e)));
                agp.c(agp.a, agcVar4.b(contentValues5), conversationBean5.getUsername());
                return kotlinUnitVar;
            case 19:
                ConversationBean conversationBean6 = (ConversationBean) obj;
                agc agcVar5 = agc.a;
                ContentValues contentValues6 = new ContentValues();
                contentValues6.put("flag" /* "flag" /* "flag" /* "flag" /* cnb.z(-525897270557482L)   */,
                        Long.valueOf(arj.z(conversationBean6.getFlag(), agd.c)));
                agp.c(agp.a, agcVar5.b(contentValues6), conversationBean6.getUsername());
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(21);
                return kotlinUnitVar;
            case 21:
                bah bahVar4 = (bah) obj;
                String[] strArr = { "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* cnb.z(-527301724863274L)   */ };
                bahVar4.getClass();
                bahVar4.a = SomeStaticHelpers.ab(strArr);
                cdj cdjVar5 = new cdj();
                cdjVar5.t("MicroMsg.ConversationWithCacheAdapter" /* "MicroMsg.ConversationWithCacheAdapter" /* "MicroMsg.ConversationWithCacheAdapter" /* "MicroMsg.ConversationWithCacheAdapter" /* cnb.z(-527701156821802L)   */,
                        "handle show tip count, but talker is null" /* "handle show tip count, but talker is null" /* "handle show tip count, but talker is null" /* "handle show tip count, but talker is null" /* cnb.z(-527589487672106L)   */);
                bahVar4.d = cdjVar5;
                return kotlinUnitVar;
            case 22:
                View view4 = (View) obj;
                View viewK4 = dkz.k(view4, R.layout.module_dialog_plugin, null, false);
                int i12 = R.id.moduleDialogBtnPluginCopyPath;
                MaterialButton materialButton3 = (MaterialButton) KotlinHelpers2.aq(viewK4, R.id.moduleDialogBtnPluginCopyPath);
                if (materialButton3 != null) {
                    i12 = R.id.moduleDialogBtnPluginOpenDemo;
                    MaterialButton materialButton4 = (MaterialButton) KotlinHelpers2.aq(viewK4,
                            R.id.moduleDialogBtnPluginOpenDemo);
                    if (materialButton4 != null) {
                        materialButton3.setOnClickListener(new d(5));
                        materialButton4.setOnClickListener(new bxa(view4, 1 == true ? 1 : 0));
                        DefaultConfig ioVar2 = new DefaultConfig(view4.getContext(), 13);
                        cud.a.getClass();
                        ioVar2.ay(cud.c);
                        ioVar2.d = (LinearLayout) viewK4;
                        DefaultConfig.g(ioVar2, null, 3);
                        DefaultConfig.f(ioVar2, null, 3);
                        ioVar2.az();
                        return kotlinUnitVar;
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-663039871286058L)   */.concat(viewK4.getResources().getResourceName(i12)));
            case 23:
                return Boolean.valueOf(((Method) obj).getAnnotation(cty.class) != null);
            case 24:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(i5);
                return kotlinUnitVar;
            case 25:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(27);
                return kotlinUnitVar;
            case 26:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onMethodCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(28);
                findDexClassMethodDslWrapperVar.onResultCallback = new AnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(29);
                return kotlinUnitVar;
            case 27:
                bah bahVar5 = (bah) obj;
                cdj cdjVar6 = new cdj();
                cdjVar6.o(cvh.a.b());
                Class<CharSequence> clsBf7 = cnf.bf(dal.b(cls2));
                cdjVar6.q(clsBf7 != null ? clsBf7 : CharSequence.class);
                cdjVar6.u(0);
                bahVar5.getClass();
                bahVar5.d = cdjVar6;
                return kotlinUnitVar;
            case 28:
                bah bahVar6 = (bah) obj;
                cdj cdjVar7 = new cdj();
                cdjVar7.o(cvh.a.b());
                Class<CharSequence> clsBf8 = cnf.bf(dal.b(cls2));
                cdjVar7.q(clsBf8 != null ? clsBf8 : CharSequence.class);
                bahVar6.getClass();
                bahVar6.d = cdjVar7;
                return kotlinUnitVar;
            default:
                zF = nullSafeIsEqual(((cdf) obj).f, cvf.a.d());
                break;
        }
        return Boolean.valueOf(!zF);
    }
}
