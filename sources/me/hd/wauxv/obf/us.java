package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class us implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ us(int i) {
        this.a = i;
    }

    private final Object b(Object obj) {
        DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
        String[] strArr = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-48872432859946L)   */ };
        dexClassQueryBuilderVar.getClass();
        dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
        azl azlVar = new azl();
        azi aziVar = new azi();
        String strZ = "convertView" /* "convertView" /* "convertView" /* "convertView" /* cnb.z(-48696339200810L)   */;
        dne dneVar = dne.Equals;
        aziVar.a = new dnf(strZ, dneVar, false);
        azlVar.e(aziVar);
        azi aziVar2 = new azi();
        aziVar2.a = new dnf("avatarIV" /* "avatarIV" /* "avatarIV" /* "avatarIV" /* cnb.z(-48679159331626L)   */, dneVar, false);
        azlVar.e(aziVar2);
        zbVar.e = azlVar;
        dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
        return Kotlin$Unit.INSTANCE;
    }

    private final Object c(Object obj) {
        Class cls;
        DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
        DexFinder cdjVar = new DexFinder();
        cdjVar.s("create" /* "create" /* "create" /* "create" /* cnb.z(-50289772067626L)   */);
        cls = View.class;
        Class<View> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
        cdjVar.q(clsBf != null ? clsBf : View.class);
        dexMethodQueryBuilderVar.getClass();
        dexMethodQueryBuilderVar.dexFinder = cdjVar;
        return Kotlin$Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object d(Object obj) throws IllegalAccessException {
        Object objX;
        Object objX2;
        int iIntValue;
        Object objX3;
        Object objX4;
        HookParam hookParam = (HookParam) obj;
        LinkedHashSet<bnc> linkedHashSet = wr.b;
        if (cnb.ab(ewk.d) || cnb.ac(ewh.d)) {
            hookParam.getClass();
            try {
                objX = hookParam.getArgs()[0];
                if (objX == null) {
                    objX = null;
                }
            } catch (Throwable th) {
                objX = FastKV.getFailureFromException(th);
            }
            if (objX instanceof Failure) {
                objX = null;
            }
            throwIfVar1IsNull(objX);
            try {
                objX2 = hookParam.getArgs()[2];
                if (objX2 == null) {
                    objX2 = null;
                }
            } catch (Throwable th2) {
                objX2 = FastKV.getFailureFromException(th2);
            }
            Integer num = (Integer) (objX2 instanceof Failure ? null : objX2);
            iIntValue = num != null ? num.intValue() : 0;
            int i = 0;
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objX).r();
            fieldResolverVarR.fieldType = dal.getKClassFromClass(View.class);
            Object objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
            throwIfVar1IsNull(objE);
            View view = (View) objE;
            Object tag = view.getTag();
            FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam);
            xr.a.getClass();
            fieldResolverVarAa.fieldType = StaticHelpers7.toDexClass(xq.a);
            Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue();
            throwIfVar1IsNull(objD);
            FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(hookParam.getThisObject()).r();
            xv.a.getClass();
            fieldResolverVarR2.fieldType = StaticHelpers7.toDexClass(xu.a);
            Object objD2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue();
            throwIfVar1IsNull(objD2);
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD2).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "getItem" /* "getItem" /* "getItem" /* "getItem" /* cnb.z(-49624052136746L)   */;
            Object objE2 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(Integer.valueOf(iIntValue));
            throwIfVar1IsNull(objE2);
            MsgInfoBean msgInfoBean = new MsgInfoBean(objE2);
            for (bnc bncVar : linkedHashSet) {
                try {
                    bncVar.i(view, tag, objD, msgInfoBean);
                } catch (Exception e) {
                    ArrayList arrayList = Logger.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onBindView " /* "onBindView " /* "onBindView " /* "onBindView " /* cnb.z(-49589692398378L)   */);
                    Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                            bncVar instanceof SwitchHook ? ((SwitchHook) bncVar).getResult() : "LoadHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 49572512529194L)
                                                                                                           */,
                            -49533857823530L), e, 12);
                }
            }
        } else {
            hookParam.getClass();
            try {
                objX3 = hookParam.getArgs()[0];
                if (objX3 == null) {
                    objX3 = null;
                }
            } catch (Throwable th3) {
                objX3 = FastKV.getFailureFromException(th3);
            }
            if (objX3 instanceof Failure) {
                objX3 = null;
            }
            throwIfVar1IsNull(objX3);
            try {
                objX4 = hookParam.getArgs()[1];
                if (objX4 == null) {
                    objX4 = null;
                }
            } catch (Throwable th4) {
                objX4 = FastKV.getFailureFromException(th4);
            }
            Integer num2 = (Integer) (objX4 instanceof Failure ? null : objX4);
            iIntValue = num2 != null ? num2.intValue() : 0;
            int i2 = 0;
            FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objX3).r();
            fieldResolverVarR3.fieldType = dal.getKClassFromClass(View.class);
            Object objE3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
            throwIfVar1IsNull(objE3);
            View view2 = (View) objE3;
            Object tag2 = view2.getTag();
            FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa(hookParam);
            xr.a.getClass();
            fieldResolverVarAa2.fieldType = StaticHelpers7.toDexClass(xq.a);
            Object objD3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa2.resolve())).getValue();
            throwIfVar1IsNull(objD3);
            MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(hookParam.getThisObject()).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.name = "getItem" /* "getItem" /* "getItem" /* "getItem" /* cnb.z(-49499498085162L)   */;
            Object objE4 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invokeAndThrowIfFailed(Integer.valueOf(iIntValue));
            throwIfVar1IsNull(objE4);
            MsgInfoBean msgInfoBean2 = new MsgInfoBean(objE4);
            for (bnc bncVar2 : linkedHashSet) {
                try {
                    bncVar2.i(view2, tag2, objD3, msgInfoBean2);
                } catch (Exception e2) {
                    ArrayList arrayList2 = Logger.a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onBindView " /* "onBindView " /* "onBindView " /* "onBindView " /* cnb.z(-50014894160682L)   */);
                    Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                            bncVar2 instanceof SwitchHook ? ((SwitchHook) bncVar2).getResult()
                                    : "LoadHook" /* "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-49928994814762L)   */,
                            -49907519978282L), e2, 12);
                }
            }
        }
        return Kotlin$Unit.INSTANCE;
    }

    private final Object e(Object obj) {
        ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(26);
        return Kotlin$Unit.INSTANCE;
    }

    private final Object f(Object obj) {
        DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
        DexFinder cdjVar = new DexFinder();
        cdjVar.usingStrings(
                (cnb.ab(ewk.d) || cnb.ac(ewh.d)) ? "MicroMsg.MvvmChattingItem"
                        /* "MicroMsg.MvvmChattingItem" /* "MicroMsg.MvvmChattingItem" /* "MicroMsg.MvvmChattingItem" /* cnb.z(-49873160239914L)   */ : "MicroMsg.ChattingDataAdapterV2" /* "MicroMsg.ChattingDataAdapterV2" /* "MicroMsg.ChattingDataAdapterV2" /* "MicroMsg.ChattingDataAdapterV2" /* cnb.z(-49778670959402L)   */,
                "dealItemView" /* "dealItemView" /* "dealItemView" /* "dealItemView" /* cnb.z(-38083475012394L)   */);
        DexFinder.k(cdjVar, "[onBindView] " /* "[onBindView] " /* "[onBindView] " /* "[onBindView] " /* cnb.z(-38010460568362L)   */);
        dexMethodQueryBuilderVar.getClass();
        dexMethodQueryBuilderVar.dexFinder = cdjVar;
        return Kotlin$Unit.INSTANCE;
    }

    private final Object g(Object obj) {
        ((FindDexClassMethodDslWrapper) obj).onClassCallback = new us(29);
        return Kotlin$Unit.INSTANCE;
    }

    private final Object h(Object obj) {
        ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new ws(0);
        return Kotlin$Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Object obj2;
        Drawable drawable;
        boolean zIsAssignableFrom;
        Drawable drawable2;
        boolean zIsAssignableFrom2;
        Object objX;
        Object objX2;
        Object objX3;
        Object obj3;
        Object objE;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        Object objX8;
        int i = this.a;
        AccessModifierEnum accessModifierEnumVar = AccessModifierEnum.FINAL;
        int i2 = 9;
        int i3 = 22;
        int i4 = 21;
        char c = 3;
        int i5 = 1;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                HookParam hookParam = (HookParam) obj;
                int i6 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam);
                fieldResolverVarAa.fieldType = "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* cnb.z(-576625129290538L)   */;
                Object objE2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue_();
                throwIfVar1IsNull(objE2);
                View view = (ListView) objE2;
                FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa(hookParam);
                StaticHelpers2.addAllFromVar2ToVar1(fieldResolverVarAa2.modifiersNot, (AccessModifierEnum[]) Arrays.copyOf(new AccessModifierEnum[] {accessModifierEnumVar}, 1));
                boolean z = false;
                Object obj4 = null;
                for (Object obj5 : fieldResolverVarAa2.resolve()) {
                    Object objD = ((BoundField) obj5).getValue();
                    if (objD == null) {
                        zIsAssignableFrom = false;
                    } else {
                        KClass zcVarB = dal.getKClassFromClass(objD.getClass());
                        KClass zcVarB2 = dal.getKClassFromClass(BaseAdapter.class);
                        ConcurrentHashMap concurrentHashMap = ReflectionWrapper.cachedConstructors;
                        zIsAssignableFrom = HugeSyntheticPileOfHelpers.getJavaClass(zcVarB2).isAssignableFrom(HugeSyntheticPileOfHelpers.getJavaClass(zcVarB));
                    }
                    if (zIsAssignableFrom) {
                        if (z) {
                            throw new IllegalArgumentException(
                                    "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* cnb.z(-578016698694442L)   */);
                        }
                        obj4 = obj5;
                        z = true;
                    }
                }
                if (!z) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate." /*
                                                                                                               * cnb.z(-
                                                                                                               * 577827720133418L)
                                                                                                               */);
                }
                Object objE3 = ((BoundField) obj4).getValue_();
                throwIfVar1IsNull(objE3);
                BaseAdapter baseAdapter = (BaseAdapter) objE3;
                ViewParent parent = view.getParent();
                throwIfVar1IsNull(parent, "null cannot be cast to non-null type android.widget.RelativeLayout" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 578124072876842L)
                                                                                                                */);
                RelativeLayout relativeLayout = (RelativeLayout) parent;
                relativeLayout.removeView(view);
                LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
                linearLayout.setLayoutParams(view.getLayoutParams());
                linearLayout.setOrientation(0);
                ScrollView scrollView = new ScrollView(linearLayout.getContext());
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                        (int) cnh.r(Integer.valueOf(vc.a.k()), scrollView.getContext()), -1);
                scrollView.setPadding(0, (int) cnh.r(Integer.valueOf(vf.a.k()), scrollView.getContext()), 0,
                        (int) cnh.r(56, scrollView.getContext()));
                if (cnh.aa(scrollView.getContext())) {
                    scrollView.setBackgroundColor(Color.parseColor(va.a.o()));
                } else {
                    scrollView.setBackgroundColor(Color.parseColor(vb.a.o()));
                }
                scrollView.setLayoutParams(layoutParams);
                ckj ckjVar = new ckj(aqu.e(HugeSyntheticPileOfHelpers.wrapModuleContext(scrollView.getContext())));
                ckjVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ckjVar.setLabelVisibilityMode(1);
                if (cnh.aa(ckjVar.getContext())) {
                    ckjVar.setBackgroundColor(Color.parseColor(va.a.o()));
                    ckjVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(uv.a.o())));
                    ckjVar.setItemIconTintList(emc.ai(Color.parseColor(uy.a.o())));
                    ckjVar.setItemTextColor(emc.ai(Color.parseColor(vd.a.o())));
                } else {
                    ckjVar.setBackgroundColor(Color.parseColor(vb.a.o()));
                    ckjVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(uw.a.o())));
                    ckjVar.setItemIconTintList(emc.ai(Color.parseColor(uz.a.o())));
                    ckjVar.setItemTextColor(emc.ai(Color.parseColor(ve.a.o())));
                }
                ckjVar.setOnItemSelectedListener(new ut(baseAdapter, view));
                ckjVar.getMenu().clear();
                biw.a.getClass();
                for (biv bivVar : StaticHelpers5.u(7, biw.f())) {
                    biw.a.getClass();
                    File file = new File(biw.c, bivVar.d);
                    if (file.exists()) {
                        drawable = new BitmapDrawable(ckjVar.getContext().getResources(),
                                BitmapFactory.decodeFile(file.getAbsolutePath()));
                    } else {
                        drawable = ckjVar.getContext().getDrawable(R.drawable.ic_chat_group_24dp);
                        throwIfVar1IsNull(drawable);
                    }
                    Menu menu = ckjVar.getMenu();
                    int i7 = bivVar.c;
                    menu.add(0, i7, i7, bivVar.b).setIcon(drawable);
                }
                biw.a.getClass();
                Iterator it = biw.f().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (nullSafeIsEqual(((biv) next).b, ux.a.o())) {
                            obj2 = next;
                        }
                    } else {
                        obj2 = null;
                    }
                }
                biv bivVar2 = (biv) obj2;
                ckjVar.setSelectedItemId(bivVar2 != null ? bivVar2.c : 0);
                scrollView.addView(ckjVar);
                linearLayout.addView(scrollView);
                linearLayout.addView(view);
                relativeLayout.addView(linearLayout);
                return kotlinUnitVar;
            case 1:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                DexFinder.setClassEquals(cdjVar, "com.tencent.mm.ui.conversation.MainUI" /* "com.tencent.mm.ui.conversation.MainUI" /* "com.tencent.mm.ui.conversation.MainUI" /* "com.tencent.mm.ui.conversation.MainUI" /* cnb.z(-577252194515754L)   */);
                cdjVar.usingStrings("MicroMsg.MainUI" /* "MicroMsg.MainUI" /* "MicroMsg.MainUI" /* "MicroMsg.MainUI" /* cnb.z(-577690281179946L)   */, "onTabCreate, %d" /*
                                                                                              * "onTabCreate, %d" /* "onTabCreate, %d" /* "onTabCreate, %d" /* cnb.z(-577621561703210L)  */
                                                                                              */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 2:
                View view2 = (View) obj;
                View viewK = StaticHelpers6.k(view2, R.layout.module_dialog_chat_group_tab, null, false);
                int i8 = R.id.moduleDialogCbChatGroupTabShowIcon;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogCbChatGroupTabShowIcon);
                if (materialCheckBox != null) {
                    i8 = R.id.moduleDialogEdtChatGroupTabIndicatorDarkColor;
                    TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtChatGroupTabIndicatorDarkColor);
                    if (textInputEditText != null) {
                        i8 = R.id.moduleDialogEdtChatGroupTabIndicatorLightColor;
                        TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogEdtChatGroupTabIndicatorLightColor);
                        if (textInputEditText2 != null) {
                            i8 = R.id.moduleDialogEdtChatGroupTabNormalDarkColor;
                            TextInputEditText textInputEditText3 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogEdtChatGroupTabNormalDarkColor);
                            if (textInputEditText3 != null) {
                                i8 = R.id.moduleDialogEdtChatGroupTabNormalLightColor;
                                TextInputEditText textInputEditText4 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogEdtChatGroupTabNormalLightColor);
                                if (textInputEditText4 != null) {
                                    i8 = R.id.moduleDialogEdtChatGroupTabSelectedDarkColor;
                                    TextInputEditText textInputEditText5 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogEdtChatGroupTabSelectedDarkColor);
                                    if (textInputEditText5 != null) {
                                        i8 = R.id.moduleDialogEdtChatGroupTabSelectedLightColor;
                                        TextInputEditText textInputEditText6 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogEdtChatGroupTabSelectedLightColor);
                                        if (textInputEditText6 != null) {
                                            i8 = R.id.moduleDialogEdtChatGroupTabTabDarkColor;
                                            TextInputEditText textInputEditText7 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                    R.id.moduleDialogEdtChatGroupTabTabDarkColor);
                                            if (textInputEditText7 != null) {
                                                i8 = R.id.moduleDialogEdtChatGroupTabTabLightColor;
                                                TextInputEditText textInputEditText8 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                        R.id.moduleDialogEdtChatGroupTabTabLightColor);
                                                if (textInputEditText8 != null) {
                                                    i8 = R.id.moduleDialogInputChatGroupTabIndicatorDarkColor;
                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                            R.id.moduleDialogInputChatGroupTabIndicatorDarkColor)) != null) {
                                                        i8 = R.id.moduleDialogInputChatGroupTabIndicatorLightColor;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                R.id.moduleDialogInputChatGroupTabIndicatorLightColor)) != null) {
                                                            i8 = R.id.moduleDialogInputChatGroupTabNormalDarkColor;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                    R.id.moduleDialogInputChatGroupTabNormalDarkColor)) != null) {
                                                                i8 = R.id.moduleDialogInputChatGroupTabNormalLightColor;
                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                        R.id.moduleDialogInputChatGroupTabNormalLightColor)) != null) {
                                                                    i8 = R.id.moduleDialogInputChatGroupTabSelectedDarkColor;
                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                            R.id.moduleDialogInputChatGroupTabSelectedDarkColor)) != null) {
                                                                        i8 = R.id.moduleDialogInputChatGroupTabSelectedLightColor;
                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                R.id.moduleDialogInputChatGroupTabSelectedLightColor)) != null) {
                                                                            i8 = R.id.moduleDialogInputChatGroupTabTabDarkColor;
                                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                    R.id.moduleDialogInputChatGroupTabTabDarkColor)) != null) {
                                                                                i8 = R.id.moduleDialogInputChatGroupTabTabLightColor;
                                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                        R.id.moduleDialogInputChatGroupTabTabLightColor)) != null) {
                                                                                    LinearLayout linearLayout2 = (LinearLayout) viewK;
                                                                                    cej cejVar = new cej(linearLayout2,
                                                                                            materialCheckBox,
                                                                                            textInputEditText,
                                                                                            textInputEditText2,
                                                                                            textInputEditText3,
                                                                                            textInputEditText4,
                                                                                            textInputEditText5,
                                                                                            textInputEditText6,
                                                                                            textInputEditText7,
                                                                                            textInputEditText8);
                                                                                    textInputEditText8
                                                                                            .setText(vr.a.o());
                                                                                    textInputEditText2
                                                                                            .setText(vk.a.o());
                                                                                    textInputEditText4
                                                                                            .setText(vm.a.o());
                                                                                    textInputEditText6
                                                                                            .setText(vo.a.o());
                                                                                    textInputEditText7
                                                                                            .setText(vq.a.o());
                                                                                    textInputEditText.setText(vj.a.o());
                                                                                    textInputEditText3
                                                                                            .setText(vl.a.o());
                                                                                    textInputEditText5
                                                                                            .setText(vn.a.o());
                                                                                    materialCheckBox
                                                                                            .setChecked(vp.a.i());
                                                                                    bzy bzyVar = new bzy(
                                                                                            view2.getContext());
                                                                                    eg egVar = (eg) bzyVar.d;
                                                                                    vt.a.getClass();
                                                                                    egVar.d = vt.c;
                                                                                    bzyVar.t("保存" /*
                                                                                                   * cnb.z(-
                                                                                                   * 568383087049514L)
                                                                                                   */, new amw(
                                                                                            new bp(cejVar, 8), 0));
                                                                                    bzyVar.s("重置" /*
                                                                                                   * cnb.z(-
                                                                                                   * 568404561885994L)
                                                                                                   */,
                                                                                            new amw(new h(i4), 2));
                                                                                    bjs.x((3 & 2) != 0 ? new amd(
                                                                                            1) : null, bzyVar,
                                                                                            "取消" /*
                                                                                                  * cnb.z(-
                                                                                                  * 47455093652266L)
                                                                                                  */);
                                                                                    if (linearLayout2 != null) {
                                                                                        egVar.r = linearLayout2;
                                                                                    }
                                                                                    bzyVar.i().show();
                                                                                    return kotlinUnitVar;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-638575737568042L)   */.concat(viewK.getResources().getResourceName(i8)));
            case 3:
                HookParam hookParam2 = (HookParam) obj;
                int i9 = 0;
                FieldResolver fieldResolverVarAa3 = StaticHelpers6.aa(hookParam2);
                fieldResolverVarAa3.fieldType = "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* cnb.z(-567515503655722L)   */;
                Object objE4 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa3.resolve())).getValue_();
                throwIfVar1IsNull(objE4);
                ListView listView = (ListView) objE4;
                FieldResolver fieldResolverVarAa4 = StaticHelpers6.aa(hookParam2);
                StaticHelpers2.addAllFromVar2ToVar1(fieldResolverVarAa4.modifiersNot, (AccessModifierEnum[]) Arrays.copyOf(new AccessModifierEnum[] {accessModifierEnumVar}, 1));
                Object[] objArr = false;
                Object obj6 = null;
                for (Object obj7 : fieldResolverVarAa4.resolve()) {
                    Object objD2 = ((BoundField) obj7).getValue();
                    if (objD2 == null) {
                        zIsAssignableFrom2 = false;
                    } else {
                        KClass zcVarB3 = dal.getKClassFromClass(objD2.getClass());
                        KClass zcVarB4 = dal.getKClassFromClass(BaseAdapter.class);
                        ConcurrentHashMap concurrentHashMap2 = ReflectionWrapper.cachedConstructors;
                        zIsAssignableFrom2 = HugeSyntheticPileOfHelpers.getJavaClass(zcVarB4).isAssignableFrom(HugeSyntheticPileOfHelpers.getJavaClass(zcVarB3));
                    }
                    if (zIsAssignableFrom2) {
                        if (objArr == true) {
                            throw new IllegalArgumentException(
                                    "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* cnb.z(-567807561431850L)   */);
                        }
                        obj6 = obj7;
                        objArr = true;
                    }
                }
                if (objArr != true) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate." /*
                                                                                                               * cnb.z(-
                                                                                                               * 569267850312490L)
                                                                                                               */);
                }
                Object objE5 = ((BoundField) obj6).getValue_();
                throwIfVar1IsNull(objE5);
                BaseAdapter baseAdapter2 = (BaseAdapter) objE5;
                TabLayout tabLayout = new TabLayout(aqu.e(HugeSyntheticPileOfHelpers.wrapModuleContext(listView.getContext())), null);
                tabLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                tabLayout.setTabMode(2);
                tabLayout.setTabGravity(1);
                tabLayout.setTabRippleColor(emc.ai(0));
                tabLayout.setInlineLabel(true);
                if (cnh.aa(tabLayout.getContext())) {
                    tabLayout.setBackgroundColor(Color.parseColor(vq.a.o()));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor(vj.a.o()));
                    vl vlVar = vl.a;
                    tabLayout.setTabTextColors(TabLayout.aq(Color.parseColor(vlVar.o()), Color.parseColor(vn.a.o())));
                    tabLayout.setTabIconTint(emc.ai(Color.parseColor(vlVar.o())));
                } else {
                    tabLayout.setBackgroundColor(Color.parseColor(vr.a.o()));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor(vk.a.o()));
                    vm vmVar = vm.a;
                    tabLayout.setTabTextColors(TabLayout.aq(Color.parseColor(vmVar.o()), Color.parseColor(vo.a.o())));
                    tabLayout.setTabIconTint(emc.ai(Color.parseColor(vmVar.o())));
                }
                vs vsVar = new vs(baseAdapter2, listView);
                ArrayList arrayList = tabLayout.am;
                if (!arrayList.contains(vsVar)) {
                    arrayList.add(vsVar);
                }
                biw.a.getClass();
                for (biv bivVar3 : biw.f()) {
                    if (vp.a.i()) {
                        biw.a.getClass();
                        File file2 = new File(biw.c, bivVar3.d);
                        if (file2.exists()) {
                            drawable2 = new BitmapDrawable(tabLayout.getContext().getResources(),
                                    BitmapFactory.decodeFile(file2.getAbsolutePath()));
                        } else {
                            drawable2 = tabLayout.getContext().getDrawable(R.drawable.ic_chat_group_24dp);
                            throwIfVar1IsNull(drawable2);
                        }
                    } else {
                        drawable2 = null;
                    }
                    dpl dplVarAw = tabLayout.aw();
                    dplVarAw.a = drawable2;
                    TabLayout tabLayout2 = dplVarAw.e;
                    if (tabLayout2.aa == 1 || tabLayout2.ad == 2) {
                        tabLayout2.ba(true);
                    }
                    dpn dpnVar = dplVarAw.f;
                    if (dpnVar != null) {
                        dpnVar.p();
                    }
                    String str = bivVar3.b;
                    if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(str)) {
                        dplVarAw.f.setContentDescription(str);
                    }
                    dplVarAw.b = str;
                    dpn dpnVar2 = dplVarAw.f;
                    if (dpnVar2 != null) {
                        dpnVar2.p();
                    }
                    tabLayout.ar(dplVarAw, tabLayout.c.isEmpty());
                }
                listView.addHeaderView(tabLayout);
                return kotlinUnitVar;
            case 4:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(5);
                return kotlinUnitVar;
            case 5:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                DexFinder.setClassEquals(cdjVar2, "com.tencent.mm.ui.conversation.MainUI" /* "com.tencent.mm.ui.conversation.MainUI" /* "com.tencent.mm.ui.conversation.MainUI" /* "com.tencent.mm.ui.conversation.MainUI" /* cnb.z(-569031627111210L)   */);
                cdjVar2.usingStrings("MicroMsg.MainUI" /* "MicroMsg.MainUI" /* "MicroMsg.MainUI" /* "MicroMsg.MainUI" /* cnb.z(-569400994298666L)   */, "onTabCreate, %d" /*
                                                                                               * cnb.z(-
                                                                                               * 569332274821930L)
                                                                                               */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 6:
                View view3 = (View) obj;
                wh whVar = wh.a;
                View viewK2 = StaticHelpers6.k(view3, R.layout.module_dialog_chat_input_hint, null, false);
                int i10 = R.id.moduleDialogCbChatInputHintHandleSendCount;
                MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK2,
                        R.id.moduleDialogCbChatInputHintHandleSendCount);
                if (materialCheckBox2 != null) {
                    i10 = R.id.moduleDialogEdtChatInputHintTip;
                    TextInputEditText textInputEditText9 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                            R.id.moduleDialogEdtChatInputHintTip);
                    if (textInputEditText9 != null) {
                        i10 = R.id.moduleDialogInputChatInputHintTip;
                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2, R.id.moduleDialogInputChatInputHintTip)) != null) {
                            i10 = R.id.moduleDialogTvChatInputHintPreview;
                            MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                    R.id.moduleDialogTvChatInputHintPreview);
                            if (materialTextView != null) {
                                i10 = R.id.moduleDialogTvChatInputHintTextPlaceholders;
                                MaterialTextView materialTextView2 = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                        R.id.moduleDialogTvChatInputHintTextPlaceholders);
                                if (materialTextView2 != null) {
                                    bqr bqrVar = new bqr((LinearLayout) viewK2, materialCheckBox2, textInputEditText9,
                                            materialTextView, materialTextView2);
                                    vz vzVar = vz.a;
                                    String strO = vzVar.o();
                                    whVar.getClass();
                                    materialTextView.setText(wh.l(strO));
                                    textInputEditText9.setText(vzVar.o());
                                    textInputEditText9.addTextChangedListener(new wg(bqrVar, i));
                                    materialCheckBox2.setChecked(vy.a.i());
                                    materialTextView2.setMovementMethod(LinkMovementMethod.getInstance());
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(
                                            "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* cnb.z(-423019918916394L)   */);
                                    for (String str2 : wh.b) {
                                        int length = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) (str2 + ' '));
                                        spannableStringBuilder.setSpan(new wf(bqrVar, str2, 0), length,
                                                spannableStringBuilder.length() - 1, 33);
                                        c = c;
                                    }
                                    materialTextView2.setText(spannableStringBuilder);
                                    bzy bzyVar2 = new bzy(view3.getContext());
                                    eg egVar2 = (eg) bzyVar2.d;
                                    egVar2.d = wh.d;
                                    bzyVar2.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-422951199439658L)   */, new amw(new bp(bqrVar, i2), 0));
                                    bzyVar2.s("重置" /* "重置" /* "重置" /* "重置" /* cnb.z(-422955494406954L)   */, new amw(new h(i3), 2));
                                    bjs.x((c & 2) != 0 ? new amd(i5) : null, bzyVar2,
                                            "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                                    LinearLayout linearLayout3 = bqrVar.b;
                                    if (linearLayout3 != null) {
                                        egVar2.r = linearLayout3;
                                    }
                                    bzyVar2.i().show();
                                    return kotlinUnitVar;
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-637888542800682L)   */.concat(viewK2.getResources().getResourceName(i10)));
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(i2);
                return kotlinUnitVar;
            case 8:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    objX = hookParam3.getArgs()[0];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                Boolean bool = (Boolean) (objX instanceof Failure ? null : objX);
                if (!(bool != null ? bool.booleanValue() : false)) {
                    int i11 = 0;
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(hookParam3.getThisObject()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.name = "setHint" /* "setHint" /* "setHint" /* "setHint" /* cnb.z(-422835235322666L)   */;
                    MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
                    wh whVar2 = wh.a;
                    String strO2 = vz.a.o();
                    whVar2.getClass();
                    methodHookWrapperVar.invokeAndThrowIfFailed(wh.l(strO2));
                }
                return kotlinUnitVar;
            case 9:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                uq.a.getClass();
                cdjVar3.o(ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-75127567940394L)   */));
                cdjVar3.usingStrings("MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* cnb.z(-422800875584298L)   */,
                        "canSend true ! sendBtn is visible" /* "canSend true ! sendBtn is visible" /* "canSend true ! sendBtn is visible" /* "canSend true ! sendBtn is visible" /* cnb.z(-423299091790634L)   */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 10:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-52514565126954L)   */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* cnb.z(-51788715653930L)   */, "msg is null!" /*
                                                                                                 * cnb.z(-
                                                                                                 * 51745765980970L)
                                                                                                 */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return kotlinUnitVar;
            case 11:
                HookParam hookParam4 = (HookParam) obj;
                hookParam4.getClass();
                try {
                    objX2 = hookParam4.getArgs()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                Object obj8 = objX2 instanceof Failure ? null : objX2;
                throwIfVar1IsNull(obj8);
                int i12 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj8).r();
                fieldResolverVarR.fieldType = dal.getKClassFromClass(Context.class);
                Object objE6 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue_();
                throwIfVar1IsNull(objE6);
                Resources resources = ((Context) objE6).getResources();
                if (resources != null) {
                    HugeSyntheticPileOfHelpers.injectModuleAssets(resources);
                }
                Kotlin$Lazy kotlin$LazyVar = new Kotlin$Lazy(new wi(obj8, i));
                try {
                    objX3 = hookParam4.getArgs()[1];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = FastKV.getFailureFromException(th3);
                }
                obj3 = objX3 instanceof Failure ? null : objX3;
                throwIfVar1IsNull(obj3);
                Object tag = ((View) obj3).getTag();
                MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(tag).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.returnType = dal.getKClassFromClass(Integer.TYPE);
                methodResolverVarT2.setParamCountTo0();
                methodResolverVarT2.enableSuperclass();
                Integer num = (Integer) ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invoke(new Object[0]);
                if (cnb.ab(ewk.p) || cnb.ac(ewh.s)) {
                    MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(tag).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
                    methodResolverVarT3.returnType = StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE);
                    methodResolverVarT3.parameterCount = 0;
                    objE = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).invokeAndThrowIfFailed(new Object[0]);
                    throwIfVar1IsNull(objE);
                } else {
                    FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(tag).r();
                    MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
                    fieldResolverVarR2.fieldType = StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE);
                    objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue();
                    throwIfVar1IsNull(objE);
                }
                MsgInfoBean msgInfoBean = new MsgInfoBean(objE);
                for (bna bnaVar : wm.b) {
                    try {
                        for (wj wjVar : bnaVar.l(msgInfoBean)) {
                            MethodHookWrapper methodHookWrapperVarD = ((MethodHookWrapper) kotlin$LazyVar.getValue()).d();
                            methodHookWrapperVarD.bindInstance(obj8);
                            methodHookWrapperVarD.invokeAndThrowIfFailed(num, Integer.valueOf(wjVar.a), 0, wjVar.b, Integer.valueOf(wjVar.c));
                        }
                    } catch (Exception e) {
                        ArrayList arrayList2 = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-52308406696746L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bnaVar instanceof SwitchHook ? ((SwitchHook) bnaVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 52261162056490L)
                                                                                                               */,
                                -52772263164714L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 12:
                HookParam hookParam5 = (HookParam) obj;
                int i13 = 0;
                FieldResolver fieldResolverVarAa5 = StaticHelpers6.aa(hookParam5);
                fieldResolverVarAa5.b = new us(13);
                Object objE7 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa5.resolve())).getValue_();
                throwIfVar1IsNull(objE7);
                FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration((View.OnLongClickListener) objE7).r();
                xr.a.getClass();
                xq xqVar = xq.a;
                fieldResolverVarR3.fieldType = StaticHelpers7.toDexClass(xqVar);
                Object objD3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue();
                throwIfVar1IsNull(objD3);
                FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(objD3).r();
                gp.a.getClass();
                go goVar = go.a;
                fieldResolverVarR4.fieldType = StaticHelpers7.toDexMethod(goVar).getDeclaringClass();
                Object objD4 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).getValue();
                throwIfVar1IsNull(objD4);
                xz.a.getClass();
                FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(gp.b((Class) SomeStaticHelpers.p(StaticHelpers7.toDexClass(xy.a).getInterfaces()), objD4)).r();
                fieldResolverVarR5.fieldType = StaticHelpers7.toDexClass(xqVar);
                Object objD5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).getValue();
                throwIfVar1IsNull(objD5);
                FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(objD5).r();
                fieldResolverVarR6.fieldType = StaticHelpers7.toDexMethod(goVar).getDeclaringClass();
                Object objD6 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR6.resolve())).getValue();
                throwIfVar1IsNull(objD6);
                xv.a.getClass();
                Object objB = gp.b((Class) SomeStaticHelpers.p(StaticHelpers7.toDexClass(xu.a).getInterfaces()), objD6);
                try {
                    objX4 = hookParam5.getArgs()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = FastKV.getFailureFromException(th4);
                }
                obj3 = objX4 instanceof Failure ? null : objX4;
                throwIfVar1IsNull(obj3);
                MenuItem menuItem = (MenuItem) obj3;
                MethodResolver methodResolverVarT4 = dqc.getWrapperConfiguration(objB).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT4.name = "getItem" /* "getItem" /* "getItem" /* "getItem" /* cnb.z(-52737903426346L)   */;
                Object objE8 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT4.findMethods())).invokeAndThrowIfFailed(Integer.valueOf(menuItem.getGroupId()));
                throwIfVar1IsNull(objE8);
                MsgInfoBean msgInfoBean2 = new MsgInfoBean(objE8);
                for (bna bnaVar2 : wm.b) {
                    try {
                        for (wj wjVar2 : bnaVar2.l(msgInfoBean2)) {
                            if (menuItem.getItemId() == wjVar2.a) {
                                wjVar2.d.g(objD3, msgInfoBean2);
                            }
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList3 = Logger.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-52703543687978L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                bnaVar2 instanceof SwitchHook ? ((SwitchHook) bnaVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 52587579570986L)
                                                                                                                 */,
                                -52548924865322L), e2, 12);
                    }
                }
                return kotlinUnitVar;
            case 13:
                KClass zcVarB5 = dal.getKClassFromClass(View.OnLongClickListener.class);
                ConcurrentHashMap concurrentHashMap3 = ReflectionWrapper.cachedConstructors;
                return Boolean.valueOf(HugeSyntheticPileOfHelpers.getJavaClass(zcVarB5).isAssignableFrom((Class) obj));
            case 14:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(10);
                return kotlinUnitVar;
            case 15:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(16);
                return kotlinUnitVar;
            case 16:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-52205327481642L)   */ };
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.usingStrings("MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* cnb.z(-52029233822506L)   */,
                        "context item select failed, null dataTag" /* "context item select failed, null dataTag" /* "context item select failed, null dataTag" /* "context item select failed, null dataTag" /* cnb.z(-51986284149546L)   */);
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return kotlinUnitVar;
            case 17:
                HookParam hookParam6 = (HookParam) obj;
                hookParam6.getClass();
                try {
                    objX5 = hookParam6.getArgs()[0];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = FastKV.getFailureFromException(th5);
                }
                obj3 = objX5 instanceof Failure ? null : objX5;
                throwIfVar1IsNull(obj3);
                ViewGroup viewGroup = (ViewGroup) obj3;
                for (bnb bnbVar : wp.b) {
                    try {
                        bnbVar.a(viewGroup);
                    } catch (Exception e3) {
                        ArrayList arrayList4 = Logger.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onCreateViewHolder " /* "onCreateViewHolder " /* "onCreateViewHolder " /* "onCreateViewHolder " /* cnb.z(-49267569851178L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb3,
                                bnbVar instanceof SwitchHook ? ((SwitchHook) bnbVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 48597554953002L)
                                                                                                               */,
                                -48576080116522L), e3, 12);
                    }
                }
                return kotlinUnitVar;
            case 18:
                HookParam hookParam7 = (HookParam) obj;
                hookParam7.getClass();
                try {
                    objX6 = hookParam7.getArgs()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = FastKV.getFailureFromException(th6);
                }
                Object obj9 = objX6 instanceof Failure ? null : objX6;
                throwIfVar1IsNull(obj9);
                int i14 = 0;
                FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(obj9).r();
                fieldResolverVarR7.name = "convertView" /* "convertView" /* "convertView" /* "convertView" /* cnb.z(-48541720378154L)   */;
                Object objE9 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR7)).getValue_();
                throwIfVar1IsNull(objE9);
                ViewGroup viewGroup2 = (ViewGroup) objE9;
                try {
                    objX7 = hookParam7.getArgs()[1];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = FastKV.getFailureFromException(th7);
                }
                Object obj10 = objX7 instanceof Failure ? null : objX7;
                throwIfVar1IsNull(obj10);
                try {
                    objX8 = hookParam7.getArgs()[3];
                    if (objX8 == null) {
                        objX8 = null;
                    }
                } catch (Throwable th8) {
                    objX8 = FastKV.getFailureFromException(th8);
                }
                obj3 = objX8 instanceof Failure ? null : objX8;
                throwIfVar1IsNull(obj3);
                MsgInfoBean msgInfoBean3 = new MsgInfoBean(obj3);
                for (bnb bnbVar2 : wp.b) {
                    try {
                        bnbVar2.b(obj9, viewGroup2, obj10, msgInfoBean3);
                    } catch (Exception e4) {
                        ArrayList arrayList5 = Logger.a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onBindViewHolder " /* "onBindViewHolder " /* "onBindViewHolder " /* "onBindViewHolder " /* cnb.z(-48455821032234L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb4,
                                bnbVar2 instanceof SwitchHook ? ((SwitchHook) bnbVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 48395691490090L)
                                                                                                                 */,
                                -48906792598314L), e4, 12);
                    }
                }
                return kotlinUnitVar;
            case 19:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new us(i3);
                findDexClassMethodDslWrapperVar.onMethodCallback = new us(23);
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(i4);
                return kotlinUnitVar;
            case 21:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-50259707296554L)   */ };
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* cnb.z(-50066433768234L)   */,
                        "attachAvatarClickListener: getBizKfWorker:%s" /* "attachAvatarClickListener: getBizKfWorker:%s" /* "attachAvatarClickListener: getBizKfWorker:%s" /* "attachAvatarClickListener: getBizKfWorker:%s" /* cnb.z(-50573239909162L)   */);
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
                return kotlinUnitVar;
            case 22:
                return b(obj);
            case 23:
                return c(obj);
            case 24:
                return d(obj);
            case 25:
                return e(obj);
            case 26:
                return f(obj);
            case 27:
                return g(obj);
            case 28:
                return h(obj);
            default:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-99626061396778L)   */ };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr4);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.ChatRoomMember" /* "MicroMsg.ChatRoomMember" /* "MicroMsg.ChatRoomMember" /* "MicroMsg.ChatRoomMember" /* cnb.z(-99510097279786L)   */, "service is null" /*
                                                                                                    * cnb.z(-
                                                                                                    * 99956773878570L)
                                                                                                    */);
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
        }
    }
}
