package me.hd.wauxv.obf;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Class cls;
        Object objX;
        Object objX2;
        Object obj2;
        Object objX3;
        Object objX4;
        boolean zIsAssignableFrom;
        Object objX5;
        int i = this.a;
        int i2 = 5;
        int i3 = 8;
        int i4 = 4;
        cls = View.OnClickListener.class;
        int i5 = 12;
        int i6 = 1;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                dnh dnhVar = dnh.b;
                bsb bsbVar = bsb.b;
                zd zdVar = (zd) obj;
                throwIfVar1IsNull(zdVar, "$this$buildSerialDescriptor");
                zd.g(zdVar, "key", dnh.d);
                zd.g(zdVar, "value", bsb.d);
                return kotlinUnitVar;
            case 1:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[2];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                if (objX instanceof Failure) {
                    objX = null;
                }
                Integer num = (Integer) objX;
                int iIntValue = num != null ? num.intValue() : 0;
                try {
                    objX2 = hookParam.getArgs()[3];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                if (objX2 instanceof Failure) {
                    objX2 = null;
                }
                Integer num2 = (Integer) objX2;
                int iIntValue2 = num2 != null ? num2.intValue() : 0;
                Iterator it = cdn.e.iterator();
                while (true) {
                    z zVar = (z) it;
                    if (zVar.hasNext()) {
                        Object next = zVar.next();
                        cdn cdnVar = (cdn) next;
                        if (cdnVar.f == iIntValue && cdnVar.g == iIntValue2) {
                            obj2 = next;
                        }
                    } else {
                        obj2 = null;
                    }
                }
                cdn cdnVar2 = (cdn) obj2;
                if (cdnVar2 == cdn.b || cdnVar2 == cdn.c) {
                    ek ekVar = new ek(hookParam, 2, 8);
                    cdn cdnVar3 = cdn.a;
                    ekVar.q(Integer.valueOf(cdnVar3.f));
                    new ek(hookParam, 3, 8).q(Integer.valueOf(cdnVar3.g));
                }
                return kotlinUnitVar;
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(3);
                return kotlinUnitVar;
            case 3:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings("MicroMsg.QBarStringHandler" /* "MicroMsg.QBarStringHandler" /* "MicroMsg.QBarStringHandler" /* cnb.z(-517732537727786L)  */, "key_offline_scan_show_tips" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 517015278189354L)
                                                                                                                    */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 4:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* cnb.z(-69539815488298L)  */ };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                azl azlVar = new azl();
                azi aziVar = new azi();
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                Class<View.OnClickListener> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                DexMethodGroupMatcher.h(zbVar2, (clsBf != null ? clsBf : View.OnClickListener.class).getName());
                aziVar.b = zbVar2;
                azlVar.e(aziVar);
                zbVar.e = azlVar;
                MethodMatcher fjVar = new MethodMatcher();
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.s("onCreateMMMenu" /* "onCreateMMMenu" /* "onCreateMMMenu" /* cnb.z(-69363721829162L)  */);
                fjVar.f(cdjVar2);
                zbVar.f = fjVar;
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 5:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.s("onCreateMMMenu" /* "onCreateMMMenu" /* "onCreateMMMenu" /* cnb.z(-69282117450538L)  */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 6:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX3 = hookParam2.getArgs()[0];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = FastKV.getFailureFromException(th3);
                }
                Object obj3 = objX3 instanceof Failure ? null : objX3;
                throwIfVar1IsNull(obj3);
                MenuItem menuItem = (MenuItem) obj3;
                int i7 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam2);
                fieldResolverVarAa.fieldType = dal.getKClassFromClass(View.class);
                Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue_();
                throwIfVar1IsNull(objE);
                View view = (View) objE;
                FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa(hookParam2);
                fieldResolverVarAa2.b = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(9);
                Object objE2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa2.resolve())).getValue_();
                throwIfVar1IsNull(objE2);
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration((View.OnClickListener) objE2).r();
                fieldResolverVarR.name = "d" /* "d" /* "d" /* cnb.z(-70201240451882L)  */;
                Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
                throwIfVar1IsNull(objD);
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.returnType = dal.getKClassFromClass(List.class);
                Object objJ = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invoke(new Object[0]);
                throwIfVar1IsNull(objJ);
                List list = (List) objJ;
                ArrayList arrayList = new ArrayList(StaticHelpers4.ak(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new MsgInfoBean(it2.next()));
                }
                for (bnq bnqVar : cey.b) {
                    try {
                        for (cev cevVar : bnqVar.a(arrayList)) {
                            if (menuItem.getItemId() == cevVar.a) {
                                cevVar.c.g(view.getContext(), arrayList);
                            }
                        }
                    } catch (Exception e) {
                        ArrayList arrayList2 = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-70209830386474L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bnqVar instanceof SwitchHook ? ((SwitchHook) bnqVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 70162585746218L)
                                                                                                               */,
                                -70123931040554L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 7:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    objX4 = hookParam3.getArgs()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = FastKV.getFailureFromException(th4);
                }
                Object obj4 = objX4 instanceof Failure ? null : objX4;
                throwIfVar1IsNull(obj4);
                ContextMenu contextMenu = (ContextMenu) obj4;
                Kotlin$Lazy kotlin$LazyVar = new Kotlin$Lazy(new ayu(contextMenu, i4));
                int i8 = 0;
                FieldResolver fieldResolverVarAa3 = StaticHelpers6.aa(hookParam3);
                fieldResolverVarAa3.b = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i3);
                Object objE3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa3.resolve())).getValue_();
                throwIfVar1IsNull(objE3);
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration((View.OnClickListener) objE3).r();
                fieldResolverVarR2.name = "d" /* "d" /* "d" /* cnb.z(-69831873264426L)  */;
                Object objD2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue();
                throwIfVar1IsNull(objD2);
                MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objD2).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.returnType = dal.getKClassFromClass(List.class);
                Object objJ2 = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT2)).invoke(new Object[0]);
                throwIfVar1IsNull(objJ2);
                List list2 = (List) objJ2;
                ArrayList arrayList3 = new ArrayList(StaticHelpers4.ak(list2, 10));
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new MsgInfoBean(it3.next()));
                }
                for (bnq bnqVar2 : cey.b) {
                    try {
                        for (cev cevVar2 : bnqVar2.a(arrayList3)) {
                            MethodHookWrapper methodHookWrapperVarD = ((MethodHookWrapper) kotlin$LazyVar.getValue()).d();
                            methodHookWrapperVarD.dexFind(contextMenu);
                            methodHookWrapperVarD.invokeAndThrowIfFailed(Integer.valueOf(cevVar2.a), cevVar2.b);
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList4 = Logger.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-69840463199018L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                bnqVar2 instanceof SwitchHook ? ((SwitchHook) bnqVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 70274254895914L)
                                                                                                                 */,
                                -70235600190250L), e2, 12);
                    }
                }
                return kotlinUnitVar;
            case 8:
                KClass zcVarB = dal.getKClassFromClass(cls);
                ConcurrentHashMap concurrentHashMap = ReflectionWrapper.cachedConstructors;
                zIsAssignableFrom = HugeSyntheticPileOfHelpers.getJavaClass(zcVarB).isAssignableFrom((Class) obj);
                break;
            case 9:
                KClass zcVarB2 = dal.getKClassFromClass(cls);
                ConcurrentHashMap concurrentHashMap2 = ReflectionWrapper.cachedConstructors;
                zIsAssignableFrom = HugeSyntheticPileOfHelpers.getJavaClass(zcVarB2).isAssignableFrom((Class) obj);
                break;
            case 10:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i4);
                findDexClassMethodDslWrapperVar.onMethodCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i2);
                return kotlinUnitVar;
            case 11:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar2 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar2.onClassCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i5);
                findDexClassMethodDslWrapperVar2.onMethodCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(13);
                return kotlinUnitVar;
            case 12:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* cnb.z(-69767448754986L)  */ };
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.strings = SomeStaticHelpers.arrayToList(strArr2);
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                azl azlVar2 = new azl();
                azi aziVar2 = new azi();
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                Class<View.OnClickListener> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                DexMethodGroupMatcher.h(zbVar4, (clsBf2 != null ? clsBf2 : View.OnClickListener.class).getName());
                aziVar2.b = zbVar4;
                azlVar2.e(aziVar2);
                zbVar3.e = azlVar2;
                MethodMatcher fjVar2 = new MethodMatcher();
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.s("onMMMenuItemSelected" /* "onMMMenuItemSelected" /* "onMMMenuItemSelected" /* cnb.z(-69642894703402L)  */);
                fjVar2.f(cdjVar4);
                zbVar3.f = fjVar2;
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 13:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.s("onMMMenuItemSelected" /* "onMMMenuItemSelected" /* "onMMMenuItemSelected" /* cnb.z(-66786741451562L)  */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar5;
                return kotlinUnitVar;
            case 14:
                int i9 = 3;
                View view2 = (View) obj;
                View viewK = StaticHelpers6.k(view2, R.layout.module_dialog_msg_bg_bubble, null, false);
                int i10 = R.id.moduleDialogEdtMsgBgBubbleLeftBubble;
                if (((TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogEdtMsgBgBubbleLeftBubble)) != null) {
                    i10 = R.id.moduleDialogEdtMsgBgBubbleLeftDarkBubbleColor;
                    TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtMsgBgBubbleLeftDarkBubbleColor);
                    if (textInputEditText != null) {
                        i10 = R.id.moduleDialogEdtMsgBgBubbleLeftLightBubbleColor;
                        TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogEdtMsgBgBubbleLeftLightBubbleColor);
                        if (textInputEditText2 != null) {
                            i10 = R.id.moduleDialogEdtMsgBgBubbleRightBubble;
                            if (((TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogEdtMsgBgBubbleRightBubble)) != null) {
                                i10 = R.id.moduleDialogEdtMsgBgBubbleRightDarkBubbleColor;
                                TextInputEditText textInputEditText3 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogEdtMsgBgBubbleRightDarkBubbleColor);
                                if (textInputEditText3 != null) {
                                    i10 = R.id.moduleDialogEdtMsgBgBubbleRightLightBubbleColor;
                                    TextInputEditText textInputEditText4 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogEdtMsgBgBubbleRightLightBubbleColor);
                                    if (textInputEditText4 != null) {
                                        i10 = R.id.moduleDialogInputMsgBgBubbleLeftBubble;
                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogInputMsgBgBubbleLeftBubble)) != null) {
                                            i10 = R.id.moduleDialogInputMsgBgBubbleLeftDarkBubbleColor;
                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                    R.id.moduleDialogInputMsgBgBubbleLeftDarkBubbleColor)) != null) {
                                                i10 = R.id.moduleDialogInputMsgBgBubbleLeftLightBubbleColor;
                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                        R.id.moduleDialogInputMsgBgBubbleLeftLightBubbleColor)) != null) {
                                                    i10 = R.id.moduleDialogInputMsgBgBubbleRightBubble;
                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                            R.id.moduleDialogInputMsgBgBubbleRightBubble)) != null) {
                                                        i10 = R.id.moduleDialogInputMsgBgBubbleRightDarkBubbleColor;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                R.id.moduleDialogInputMsgBgBubbleRightDarkBubbleColor)) != null) {
                                                            i10 = R.id.moduleDialogInputMsgBgBubbleRightLightBubbleColor;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                    R.id.moduleDialogInputMsgBgBubbleRightLightBubbleColor)) != null) {
                                                                LinearLayout linearLayout = (LinearLayout) viewK;
                                                                ceo ceoVar = new ceo(linearLayout, textInputEditText,
                                                                        textInputEditText2, textInputEditText3,
                                                                        textInputEditText4, 1);
                                                                textInputEditText2.setText(cfj.a.o());
                                                                textInputEditText4.setText(cfl.a.o());
                                                                textInputEditText.setText(cfi.a.o());
                                                                textInputEditText3.setText(cfk.a.o());
                                                                bzy bzyVar = new bzy(view2.getContext());
                                                                eg egVar = (eg) bzyVar.d;
                                                                cfm.a.getClass();
                                                                egVar.d = cfm.m;
                                                                bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-451409652742954L)  */,
                                                                        new amw(new bp(ceoVar, 28), 0));
                                                                bzyVar.s("重置" /* "重置" /* "重置" /* cnb.z(-451413947710250L)  */,
                                                                        new amw(new Function1$VarIsInt$2(i9), 2));
                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar,
                                                                        "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                                                                if (linearLayout != null) {
                                                                    egVar.r = linearLayout;
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
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-661940359658282L)  */.concat(viewK.getResources().getResourceName(i10)));
            case 15:
                View view3 = (View) obj;
                View viewK2 = StaticHelpers6.k(view3, R.layout.module_dialog_msg_bg_color, null, false);
                int i11 = R.id.moduleDialogEdtMsgBgColorLeftDarkBgColor;
                TextInputEditText textInputEditText5 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                        R.id.moduleDialogEdtMsgBgColorLeftDarkBgColor);
                if (textInputEditText5 != null) {
                    i11 = R.id.moduleDialogEdtMsgBgColorLeftDarkStrokeColor;
                    TextInputEditText textInputEditText6 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                            R.id.moduleDialogEdtMsgBgColorLeftDarkStrokeColor);
                    if (textInputEditText6 != null) {
                        i11 = R.id.moduleDialogEdtMsgBgColorLeftLightBgColor;
                        TextInputEditText textInputEditText7 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                R.id.moduleDialogEdtMsgBgColorLeftLightBgColor);
                        if (textInputEditText7 != null) {
                            i11 = R.id.moduleDialogEdtMsgBgColorLeftLightStrokeColor;
                            TextInputEditText textInputEditText8 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                    R.id.moduleDialogEdtMsgBgColorLeftLightStrokeColor);
                            if (textInputEditText8 != null) {
                                i11 = R.id.moduleDialogEdtMsgBgColorRightDarkBgColor;
                                TextInputEditText textInputEditText9 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                        R.id.moduleDialogEdtMsgBgColorRightDarkBgColor);
                                if (textInputEditText9 != null) {
                                    i11 = R.id.moduleDialogEdtMsgBgColorRightDarkStrokeColor;
                                    TextInputEditText textInputEditText10 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                            R.id.moduleDialogEdtMsgBgColorRightDarkStrokeColor);
                                    if (textInputEditText10 != null) {
                                        i11 = R.id.moduleDialogEdtMsgBgColorRightLightBgColor;
                                        TextInputEditText textInputEditText11 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                R.id.moduleDialogEdtMsgBgColorRightLightBgColor);
                                        if (textInputEditText11 != null) {
                                            i11 = R.id.moduleDialogEdtMsgBgColorRightLightStrokeColor;
                                            TextInputEditText textInputEditText12 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                    R.id.moduleDialogEdtMsgBgColorRightLightStrokeColor);
                                            if (textInputEditText12 != null) {
                                                i11 = R.id.moduleDialogInputMsgBgColorLeftDarkBgColor;
                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                        R.id.moduleDialogInputMsgBgColorLeftDarkBgColor)) != null) {
                                                    i11 = R.id.moduleDialogInputMsgBgColorLeftDarkStrokeColor;
                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                            R.id.moduleDialogInputMsgBgColorLeftDarkStrokeColor)) != null) {
                                                        i11 = R.id.moduleDialogInputMsgBgColorLeftLightBgColor;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                R.id.moduleDialogInputMsgBgColorLeftLightBgColor)) != null) {
                                                            i11 = R.id.moduleDialogInputMsgBgColorLeftLightStrokeColor;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                    R.id.moduleDialogInputMsgBgColorLeftLightStrokeColor)) != null) {
                                                                i11 = R.id.moduleDialogInputMsgBgColorRightDarkBgColor;
                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                        R.id.moduleDialogInputMsgBgColorRightDarkBgColor)) != null) {
                                                                    i11 = R.id.moduleDialogInputMsgBgColorRightDarkStrokeColor;
                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                            R.id.moduleDialogInputMsgBgColorRightDarkStrokeColor)) != null) {
                                                                        i11 = R.id.moduleDialogInputMsgBgColorRightLightBgColor;
                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                                R.id.moduleDialogInputMsgBgColorRightLightBgColor)) != null) {
                                                                            i11 = R.id.moduleDialogInputMsgBgColorRightLightStrokeColor;
                                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                                    R.id.moduleDialogInputMsgBgColorRightLightStrokeColor)) != null) {
                                                                                LinearLayout linearLayout2 = (LinearLayout) viewK2;
                                                                                ceg cegVar = new ceg(linearLayout2,
                                                                                        textInputEditText5,
                                                                                        textInputEditText6,
                                                                                        textInputEditText7,
                                                                                        textInputEditText8,
                                                                                        textInputEditText9,
                                                                                        textInputEditText10,
                                                                                        textInputEditText11,
                                                                                        textInputEditText12);
                                                                                textInputEditText7.setText(cfp.a.o());
                                                                                textInputEditText8.setText(cfq.a.o());
                                                                                textInputEditText11.setText(cft.a.o());
                                                                                textInputEditText12.setText(cfu.a.o());
                                                                                textInputEditText5.setText(cfn.a.o());
                                                                                textInputEditText6.setText(cfo.a.o());
                                                                                textInputEditText9.setText(cfr.a.o());
                                                                                textInputEditText10.setText(cfs.a.o());
                                                                                bzy bzyVar2 = new bzy(
                                                                                        view3.getContext());
                                                                                eg egVar2 = (eg) bzyVar2.d;
                                                                                cfv.a.getClass();
                                                                                egVar2.d = cfv.c;
                                                                                bzyVar2.t(
                                                                                        "保存" /*
                                                                                              * "保存" /* "保存" /* cnb.z(-449592881576746L)  */
                                                                                              */,
                                                                                        new amw(new bp(cegVar, 29), 0));
                                                                                bzyVar2.s(
                                                                                        "重置" /*
                                                                                              * "重置" /* "重置" /* cnb.z(-449545636936490L)  */
                                                                                              */,
                                                                                        new amw(new Function1$VarIsInt$2(i4), 2));
                                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null,
                                                                                        bzyVar2, "取消" /*
                                                                                                       * cnb.z(-
                                                                                                       * 47455093652266L)
                                                                                                       */);
                                                                                if (linearLayout2 != null) {
                                                                                    egVar2.r = linearLayout2;
                                                                                }
                                                                                bzyVar2.i().show();
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
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-662352676518698L)  */.concat(viewK2.getResources().getResourceName(i11)));
            case 16:
                View view4 = (View) obj;
                View viewK3 = StaticHelpers6.k(view4, R.layout.module_dialog_msg_format, null, false);
                int i12 = R.id.moduleDialogEdtMsgFormatTextFormat;
                TextInputEditText textInputEditText13 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                        R.id.moduleDialogEdtMsgFormatTextFormat);
                if (textInputEditText13 != null) {
                    i12 = R.id.moduleDialogEdtMsgFormatTextPlaceholders;
                    MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewK3,
                            R.id.moduleDialogEdtMsgFormatTextPlaceholders);
                    if (materialTextView != null) {
                        i12 = R.id.moduleDialogEdtMsgFormatTimeFormat;
                        TextInputEditText textInputEditText14 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                R.id.moduleDialogEdtMsgFormatTimeFormat);
                        if (textInputEditText14 != null) {
                            i12 = R.id.moduleDialogInputMsgFormatTextFormat;
                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3, R.id.moduleDialogInputMsgFormatTextFormat)) != null) {
                                i12 = R.id.moduleDialogInputMsgFormatTimeFormat;
                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                        R.id.moduleDialogInputMsgFormatTimeFormat)) != null) {
                                    cem cemVar = new cem((LinearLayout) viewK3, textInputEditText13, materialTextView,
                                            textInputEditText14, 3);
                                    textInputEditText13.setText(cfz.a.o());
                                    textInputEditText14.setText(cga.a.o());
                                    materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(
                                            "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* cnb.z(-469285306628906L)  */);
                                    for (String str : MsgFormatHook.b) {
                                        int length = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) (str + ' '));
                                        spannableStringBuilder.setSpan(new wf(cemVar, str, 1), length,
                                                spannableStringBuilder.length() - 1, 33);
                                    }
                                    materialTextView.setText(spannableStringBuilder);
                                    bzy bzyVar3 = new bzy(view4.getContext());
                                    eg egVar3 = (eg) bzyVar3.d;
                                    MsgFormatHook.a.getClass();
                                    egVar3.d = MsgFormatHook.i;
                                    bzyVar3.t("保存" /* "保存" /* "保存" /* cnb.z(-468666831338282L)  */, new amw(new cfx(cemVar, 0), 0));
                                    bzyVar3.s("重置" /* "重置" /* "重置" /* cnb.z(-468602406828842L)  */, new amw(new Function1$VarIsInt$2(i2), 2));
                                    bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3,
                                            "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                                    LinearLayout linearLayout3 = cemVar.b;
                                    if (linearLayout3 != null) {
                                        egVar3.r = linearLayout3;
                                    }
                                    bzyVar3.i().show();
                                    return kotlinUnitVar;
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-662215237565226L)  */.concat(viewK3.getResources().getResourceName(i12)));
            case 17:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar3 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar3.onClassCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(18);
                findDexClassMethodDslWrapperVar3.onMethodCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(19);
                return kotlinUnitVar;
            case 18:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* cnb.z(-468507917548330L)  */ };
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.strings = SomeStaticHelpers.arrayToList(strArr3);
                DexMethodGroupMatcher zbVar5 = new DexMethodGroupMatcher();
                zbVar5.usingEqStrings("MicroMsg.ChattingUI.SendTextComponent" /* "MicroMsg.ChattingUI.SendTextComponent" /* "MicroMsg.ChattingUI.SendTextComponent" /* cnb.z(-468881579703082L)  */,
                        "doSendMessage begin send txt msg" /* "doSendMessage begin send txt msg" /* "doSendMessage begin send txt msg" /* cnb.z(-468769910553386L)  */);
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar5;
                return kotlinUnitVar;
            case 19:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.p(new IntRange(12, 14, 1));
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.dexFinder = cdjVar6;
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(21);
                return kotlinUnitVar;
            case 21:
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-75037373627178L)  */ };
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr4);
                DexMethodGroupMatcher zbVar6 = new DexMethodGroupMatcher();
                zbVar6.usingEqStrings("MicroMsg.MsgInfo" /* "MicroMsg.MsgInfo" /* "MicroMsg.MsgInfo" /* cnb.z(-74938589379370L)  */, "[parseNewXmlSysMsg]" /*
                                                                                                  * cnb.z(-
                                                                                                  * 74865574935338L)
                                                                                                  */);
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar6;
                return kotlinUnitVar;
            case 22:
                HookParam hookParam4 = (HookParam) obj;
                for (bnr bnrVar : cgf.b) {
                    try {
                        bnrVar.h(hookParam4.getThisObject());
                    } catch (Exception e3) {
                        ArrayList arrayList5 = Logger.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onConvert " /* "onConvert " /* "onConvert " /* cnb.z(-66645007530794L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb3,
                                bnrVar instanceof SwitchHook ? ((SwitchHook) bnrVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 66563403152170L)
                                                                                                               */,
                                -66524748446506L), e3, 12);
                    }
                }
                return kotlinUnitVar;
            case 23:
                View view5 = (View) obj;
                View viewK4 = StaticHelpers6.k(view5, R.layout.module_dialog_msg_info, null, false);
                int i13 = R.id.moduleDialogCbMsgInfoTextClickInfo;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK4,
                        R.id.moduleDialogCbMsgInfoTextClickInfo);
                if (materialCheckBox != null) {
                    i13 = R.id.moduleDialogCbMsgInfoTextContentStyle;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK4,
                            R.id.moduleDialogCbMsgInfoTextContentStyle);
                    if (materialCheckBox2 != null) {
                        i13 = R.id.moduleDialogEdtMsgInfoDarkBgColor;
                        TextInputEditText textInputEditText15 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                R.id.moduleDialogEdtMsgInfoDarkBgColor);
                        if (textInputEditText15 != null) {
                            i13 = R.id.moduleDialogEdtMsgInfoDarkTextColor;
                            TextInputEditText textInputEditText16 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                    R.id.moduleDialogEdtMsgInfoDarkTextColor);
                            if (textInputEditText16 != null) {
                                i13 = R.id.moduleDialogEdtMsgInfoFont;
                                TextInputEditText textInputEditText17 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                        R.id.moduleDialogEdtMsgInfoFont);
                                if (textInputEditText17 != null) {
                                    i13 = R.id.moduleDialogEdtMsgInfoLeftMargin;
                                    TextInputEditText textInputEditText18 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                            R.id.moduleDialogEdtMsgInfoLeftMargin);
                                    if (textInputEditText18 != null) {
                                        i13 = R.id.moduleDialogEdtMsgInfoLightBgColor;
                                        TextInputEditText textInputEditText19 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                R.id.moduleDialogEdtMsgInfoLightBgColor);
                                        if (textInputEditText19 != null) {
                                            i13 = R.id.moduleDialogEdtMsgInfoLightTextColor;
                                            TextInputEditText textInputEditText20 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                    R.id.moduleDialogEdtMsgInfoLightTextColor);
                                            if (textInputEditText20 != null) {
                                                i13 = R.id.moduleDialogEdtMsgInfoRightMargin;
                                                TextInputEditText textInputEditText21 = (TextInputEditText) KotlinHelpers2
                                                        .recursivelyFindViewById(viewK4, R.id.moduleDialogEdtMsgInfoRightMargin);
                                                if (textInputEditText21 != null) {
                                                    i13 = R.id.moduleDialogEdtMsgInfoTextFormat;
                                                    TextInputEditText textInputEditText22 = (TextInputEditText) KotlinHelpers2
                                                            .recursivelyFindViewById(viewK4, R.id.moduleDialogEdtMsgInfoTextFormat);
                                                    if (textInputEditText22 != null) {
                                                        i13 = R.id.moduleDialogEdtMsgInfoTextPlaceholders;
                                                        MaterialTextView materialTextView2 = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(
                                                                viewK4, R.id.moduleDialogEdtMsgInfoTextPlaceholders);
                                                        if (materialTextView2 != null) {
                                                            i13 = R.id.moduleDialogEdtMsgInfoTimeFormat;
                                                            TextInputEditText textInputEditText23 = (TextInputEditText) KotlinHelpers2
                                                                    .recursivelyFindViewById(viewK4, R.id.moduleDialogEdtMsgInfoTimeFormat);
                                                            if (textInputEditText23 != null) {
                                                                i13 = R.id.moduleDialogInputMsgInfoDarkBgColor;
                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                                        R.id.moduleDialogInputMsgInfoDarkBgColor)) != null) {
                                                                    i13 = R.id.moduleDialogInputMsgInfoDarkTextColor;
                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                                            R.id.moduleDialogInputMsgInfoDarkTextColor)) != null) {
                                                                        i13 = R.id.moduleDialogInputMsgInfoFont;
                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                                                R.id.moduleDialogInputMsgInfoFont)) != null) {
                                                                            i13 = R.id.moduleDialogInputMsgInfoLeftMargin;
                                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                                                    R.id.moduleDialogInputMsgInfoLeftMargin)) != null) {
                                                                                i13 = R.id.moduleDialogInputMsgInfoLightBgColor;
                                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK4,
                                                                                        R.id.moduleDialogInputMsgInfoLightBgColor)) != null) {
                                                                                    i13 = R.id.moduleDialogInputMsgInfoLightTextColor;
                                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(
                                                                                            viewK4,
                                                                                            R.id.moduleDialogInputMsgInfoLightTextColor)) != null) {
                                                                                        i13 = R.id.moduleDialogInputMsgInfoRightMargin;
                                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(
                                                                                                viewK4,
                                                                                                R.id.moduleDialogInputMsgInfoRightMargin)) != null) {
                                                                                            i13 = R.id.moduleDialogInputMsgInfoTextFormat;
                                                                                            if (((TextInputLayout) KotlinHelpers2
                                                                                                    .recursivelyFindViewById(viewK4,
                                                                                                            R.id.moduleDialogInputMsgInfoTextFormat)) != null) {
                                                                                                i13 = R.id.moduleDialogInputMsgInfoTimeFormat;
                                                                                                if (((TextInputLayout) KotlinHelpers2
                                                                                                        .recursivelyFindViewById(viewK4,
                                                                                                                R.id.moduleDialogInputMsgInfoTimeFormat)) != null) {
                                                                                                    cen cenVar = new cen(
                                                                                                            (LinearLayout) viewK4,
                                                                                                            materialCheckBox,
                                                                                                            materialCheckBox2,
                                                                                                            textInputEditText15,
                                                                                                            textInputEditText16,
                                                                                                            textInputEditText17,
                                                                                                            textInputEditText18,
                                                                                                            textInputEditText19,
                                                                                                            textInputEditText20,
                                                                                                            textInputEditText21,
                                                                                                            textInputEditText22,
                                                                                                            materialTextView2,
                                                                                                            textInputEditText23);
                                                                                                    textInputEditText19
                                                                                                            .setText(
                                                                                                                    cgk.a.o());
                                                                                                    textInputEditText20
                                                                                                            .setText(
                                                                                                                    cgl.a.o());
                                                                                                    textInputEditText15
                                                                                                            .setText(
                                                                                                                    cgg.a.o());
                                                                                                    textInputEditText16
                                                                                                            .setText(
                                                                                                                    cgh.a.o());
                                                                                                    textInputEditText22
                                                                                                            .setText(
                                                                                                                    cgp.a.o());
                                                                                                    textInputEditText23
                                                                                                            .setText(
                                                                                                                    cgq.a.o());
                                                                                                    textInputEditText18
                                                                                                            .setText(
                                                                                                                    String.valueOf(
                                                                                                                            cgj.a.k()));
                                                                                                    textInputEditText21
                                                                                                            .setText(
                                                                                                                    String.valueOf(
                                                                                                                            cgm.a.k()));
                                                                                                    textInputEditText17
                                                                                                            .setText(
                                                                                                                    String.valueOf(
                                                                                                                            cgi.a.k()));
                                                                                                    materialCheckBox
                                                                                                            .setChecked(
                                                                                                                    cgn.a.i());
                                                                                                    materialCheckBox2
                                                                                                            .setChecked(
                                                                                                                    cgo.a.i());
                                                                                                    materialTextView2
                                                                                                            .setMovementMethod(
                                                                                                                    LinkMovementMethod
                                                                                                                            .getInstance());
                                                                                                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(
                                                                                                            "点击占位符自动添加以下字段:\n" /*
                                                                                                                                * cnb
                                                                                                                                * .
                                                                                                                                * z
                                                                                                                                * (
                                                                                                                                * -
                                                                                                                                * 467511485135658L)
                                                                                                                                */);
                                                                                                    for (String str2 : cgr.h) {
                                                                                                        int length2 = spannableStringBuilder2
                                                                                                                .length();
                                                                                                        spannableStringBuilder2
                                                                                                                .append((CharSequence) (str2
                                                                                                                        + ' '));
                                                                                                        spannableStringBuilder2
                                                                                                                .setSpan(
                                                                                                                        new wf(cenVar,
                                                                                                                                str2,
                                                                                                                                2),
                                                                                                                        length2,
                                                                                                                        spannableStringBuilder2
                                                                                                                                .length()
                                                                                                                                + (-1),
                                                                                                                        33);
                                                                                                    }
                                                                                                    materialTextView2
                                                                                                            .setText(
                                                                                                                    spannableStringBuilder2);
                                                                                                    bzy bzyVar4 = new bzy(
                                                                                                            view5.getContext());
                                                                                                    eg egVar4 = (eg) bzyVar4.d;
                                                                                                    cgr.c.getClass();
                                                                                                    egVar4.d = cgr.j;
                                                                                                    bzyVar4.t(
                                                                                                            "保存" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 467442765658922L)
                                                                                                                  */,
                                                                                                            new amw(new cfx(
                                                                                                                    cenVar,
                                                                                                                    i6),
                                                                                                                    0));
                                                                                                    bzyVar4.s(
                                                                                                            "重置" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 467464240495402L)
                                                                                                                  */,
                                                                                                            new amw(new Function1$VarIsInt$2(
                                                                                                                    6),
                                                                                                                    2));
                                                                                                    bjs.x((3 & 2) != 0
                                                                                                            ? new amd(1)
                                                                                                            : null,
                                                                                                            bzyVar4,
                                                                                                            "取消" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 47455093652266L)
                                                                                                                  */);
                                                                                                    LinearLayout linearLayout4 = cenVar.b;
                                                                                                    if (linearLayout4 != null) {
                                                                                                        egVar4.r = linearLayout4;
                                                                                                    }
                                                                                                    bzyVar4.i().show();
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
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-663727066053418L)  */.concat(viewK4.getResources().getResourceName(i13)));
            case 24:
                HookParam hookParam5 = (HookParam) obj;
                hookParam5.getClass();
                try {
                    objX5 = hookParam5.getArgs()[0];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = FastKV.getFailureFromException(th5);
                }
                Object obj5 = objX5 instanceof Failure ? null : objX5;
                throwIfVar1IsNull(obj5);
                MsgInfoBean msgInfoBean = new MsgInfoBean(obj5);
                for (bns bnsVar : cgt.b) {
                    try {
                        bnsVar.m(msgInfoBean);
                    } catch (Exception e4) {
                        ArrayList arrayList6 = Logger.a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onInsert " /* "onInsert " /* "onInsert " /* cnb.z(-66932770339626L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb4,
                                bnsVar instanceof SwitchHook ? ((SwitchHook) bnsVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 66838281059114L)
                                                                                                               */,
                                -66799626353450L), e4, 12);
                    }
                }
                return kotlinUnitVar;
            case 25:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(26);
                return kotlinUnitVar;
            case 26:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                String[] strArr5 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-66215510801194L)  */ };
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.a = SomeStaticHelpers.arrayToList(strArr5);
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.usingStrings("MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* cnb.z(-66116726553386L)  */,
                        "protect:c2c msg should not here" /* "protect:c2c msg should not here" /* "protect:c2c msg should not here" /* cnb.z(-66013647338282L)  */);
                dexMethodQueryBuilderVar5.dexFinder = cdjVar7;
                return kotlinUnitVar;
            case 27:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new cgu(1);
                return kotlinUnitVar;
            case 28:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cgu(2);
                return kotlinUnitVar;
            default:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cgu(0);
                return kotlinUnitVar;
        }
        return Boolean.valueOf(zIsAssignableFrom);
    }
}
