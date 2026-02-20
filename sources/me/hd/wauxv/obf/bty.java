package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bty implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ bty(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Class cls;
        Class cls2;
        int i = this.a;
        int i2 = 5;
        int i3 = 6;
        int i4 = 17;
        int i5 = 29;
        int i6 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-355859515308842L)  */ };
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.a = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings("getSnsDirectPath" /* "getSnsDirectPath" /* "getSnsDirectPath" /* cnb.z(-355722076355370L)  */,
                        "com.tencent.mm.plugin.sns.model.LazyerImageLoader2" /* "com.tencent.mm.plugin.sns.model.LazyerImageLoader2" /* "com.tencent.mm.plugin.sns.model.LazyerImageLoader2" /* cnb.z(-356147278117674L)  */);
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 1:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_location, null, false);
                int i7 = R.id.moduleDialogBtnLocationSelect;
                MaterialButton materialButton = (MaterialButton) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogBtnLocationSelect);
                if (materialButton != null) {
                    i7 = R.id.moduleDialogEdtLocationLatitude;
                    TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtLocationLatitude);
                    if (textInputEditText != null) {
                        i7 = R.id.moduleDialogEdtLocationLongitude;
                        TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogEdtLocationLongitude);
                        if (textInputEditText2 != null) {
                            i7 = R.id.moduleDialogInputLocationLatitude;
                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogInputLocationLatitude)) != null) {
                                i7 = R.id.moduleDialogInputLocationLongitude;
                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogInputLocationLongitude)) != null) {
                                    bxj.c = new cem((LinearLayout) viewK, materialButton, textInputEditText,
                                            textInputEditText2);
                                    materialButton.setOnClickListener(new bxa(view, i6));
                                    cem cemVar = bxj.c;
                                    if (cemVar == null) {
                                        throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-496154622032682L)  */);
                                        throw null;
                                    }
                                    cemVar.c.setText(String.valueOf(bxf.a.j()));
                                    cem cemVar2 = bxj.c;
                                    if (cemVar2 == null) {
                                        throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-496120262294314L)  */);
                                        throw null;
                                    }
                                    cemVar2.d.setText(String.valueOf(bxg.a.j()));
                                    bzy bzyVar = new bzy(view.getContext());
                                    eg egVar = (eg) bzyVar.d;
                                    bxj.a.getClass();
                                    egVar.d = bxj.l;
                                    cem cemVar3 = bxj.c;
                                    if (cemVar3 == null) {
                                        throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-496085902555946L)  */);
                                        throw null;
                                    }
                                    LinearLayout linearLayout = cemVar3.b;
                                    bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-496051542817578L)  */, new amw(new amd(28), 0));
                                    bzyVar.s("重置" /* "重置" /* "重置" /* cnb.z(-495987118308138L)  */, new amw(new amd(29), 2));
                                    bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
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
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-662764993379114L)  */.concat(viewK.getResources().getResourceName(i7)));
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(i2);
                return kotlinUnitVar;
            case 3:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(9);
                return kotlinUnitVar;
            case 4:
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
                if (objX instanceof Failure) {
                    objX = null;
                }
                throwIfVar1IsNull(objX);
                AlertDialog.Builder builder = new AlertDialog.Builder(((View) objX).getContext());
                builder.setTitle("修改经纬度" /* "修改经纬度" /* "修改经纬度" /* cnb.z(-492761597868842L)  */);
                LinearLayout linearLayout2 = new LinearLayout(builder.getContext());
                linearLayout2.setGravity(17);
                linearLayout2.setOrientation(0);
                EditText editText = new EditText(linearLayout2.getContext());
                editText.setInputType(12290);
                editText.setText(String.valueOf(bxf.a.j()));
                editText.addTextChangedListener(new bxh(editText, 0));
                linearLayout2.addView(editText);
                EditText editText2 = new EditText(linearLayout2.getContext());
                editText2.setInputType(12290);
                editText2.setText(String.valueOf(bxg.a.j()));
                editText2.addTextChangedListener(new bxh(editText2, 1));
                linearLayout2.addView(editText2);
                builder.setView(linearLayout2);
                builder.setPositiveButton("确定" /* "确定" /* "确定" /* cnb.z(-492787367672618L)  */, (DialogInterface.OnClickListener) null);
                builder.setNegativeButton("取消" /* "取消" /* "取消" /* cnb.z(-492722943163178L)  */, (DialogInterface.OnClickListener) null);
                builder.show();
                return kotlinUnitVar;
            case 5:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.s("onLocationChanged" /* "onLocationChanged" /* "onLocationChanged" /* cnb.z(-492868972051242L)  */);
                cdjVar2.usingStrings("MicroMsg.DefaultTencentLocationManager" /* "MicroMsg.DefaultTencentLocationManager" /* "MicroMsg.DefaultTencentLocationManager" /* cnb.z(-494458109950762L)  */,
                        "[mlocationListener]error:%d, reason:%s" /* "[mlocationListener]error:%d, reason:%s" /* "[mlocationListener]error:%d, reason:%s" /* cnb.z(-494290606226218L)  */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 6:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.s("onLocationChanged" /* "onLocationChanged" /* "onLocationChanged" /* cnb.z(-492744417999658L)  */);
                cdjVar3.usingStrings("MicroMsg.SLocationListener" /* "MicroMsg.SLocationListener" /* "MicroMsg.SLocationListener" /* cnb.z(-492684288457514L)  */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 7:
                ((HookParam) obj).setResult(Double.valueOf(bxf.a.j()));
                return kotlinUnitVar;
            case 8:
                ((HookParam) obj).setResult(Double.valueOf(bxg.a.j()));
                return kotlinUnitVar;
            case 9:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.plugin.location.ui.impl" /* "com.tencent.mm.plugin.location.ui.impl" /* "com.tencent.mm.plugin.location.ui.impl" /* cnb.z(-494655678446378L)  */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("MicroMsg.MMPoiMapUI" /* "MicroMsg.MMPoiMapUI" /* "MicroMsg.MMPoiMapUI" /* cnb.z(-493938418907946L)  */, "invalid lat lng" /*
                                                                                                   * cnb.z(-
                                                                                                   * 493886879300394L)
                                                                                                   */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return kotlinUnitVar;
            case 10:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.s("onLocationChanged" /* "onLocationChanged" /* "onLocationChanged" /* cnb.z(-493066540546858L)  */);
                cdjVar5.usingStrings("MicroMsg.SLocationListenerWgs84" /* "MicroMsg.SLocationListenerWgs84" /* "MicroMsg.SLocationListenerWgs84" /* cnb.z(-493006411004714L)  */);
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return kotlinUnitVar;
            case 11:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                if (objX2 instanceof Failure) {
                    objX2 = null;
                }
                throwIfVar1IsNull(objX2);
                int iIntValue = ((Number) objX2).intValue();
                try {
                    objX3 = hookParam2.getArgs()[1];
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
                int iIntValue2 = ((Number) objX3).intValue();
                if (iIntValue == 6 && iIntValue2 == -1) {
                    try {
                        objX4 = hookParam2.getArgs()[2];
                        if (objX4 == null) {
                            objX4 = null;
                        }
                    } catch (Throwable th4) {
                        objX4 = FastKV.getFailureFromException(th4);
                    }
                    if (objX4 instanceof Failure) {
                        objX4 = null;
                    }
                    throwIfVar1IsNull(objX4);
                    Parcelable parcelableExtra = ((Intent) objX4).getParcelableExtra("KLocationIntent" /*
                                                                                                        * cnb.z(-
                                                                                                        * 496180391836458L)
                                                                                                        */);
                    throwIfVar1IsNull(parcelableExtra);
                    int i8 = 0;
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(parcelableExtra).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.returnType = dal.getKClassFromClass(String.class);
                    Object objJ = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invoke(new Object[0]);
                    throwIfVar1IsNull(objJ);
                    String str = (String) objJ;
                    Pattern patternCompile = Pattern.compile(
                            "lat ([-+]?[0-9]*\\.?[0-9]+);lng ([-+]?[0-9]*\\.?[0-9]+);" /* "lat ([-+]?[0-9]*\\.?[0-9]+);lng ([-+]?[0-9]*\\.?[0-9]+);" /* "lat ([-+]?[0-9]*\\.?[0-9]+);lng ([-+]?[0-9]*\\.?[0-9]+);" /* cnb.z(-493362893290282L)  */);
                    throwIfVar1IsNull(patternCompile, "compile(...)");
                    Matcher matcher = patternCompile.matcher(str);
                    throwIfVar1IsNull(matcher, "matcher(...)");
                    bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, str);
                    if (bzxVarY == null || ((AbstractReadOnlyCollection) bzxVarY.e()).a() != 3) {
                        cem cemVar4 = bxj.c;
                        if (cemVar4 == null) {
                            throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-493590526556970L)  */);
                            throw null;
                        }
                        cemVar4.c.setText("31.135633" /* "31.135633" /* "31.135633" /* cnb.z(-493556166818602L)  */);
                        cem cemVar5 = bxj.c;
                        if (cemVar5 == null) {
                            throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-493530397014826L)  */);
                            throw null;
                        }
                        cemVar5.d.setText("121.66625" /* "121.66625" /* "121.66625" /* cnb.z(-493496037276458L)  */);
                    } else {
                        cem cemVar6 = bxj.c;
                        if (cemVar6 == null) {
                            throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-493659246033706L)  */);
                            throw null;
                        }
                        TextInputEditText textInputEditText3 = cemVar6.c;
                        Float fBd = dnp.bd((String) ((bzv) bzxVarY.e()).get(1));
                        textInputEditText3.setText(String.valueOf(fBd != null ? fBd.floatValue() : 31.135633f));
                        cem cemVar7 = bxj.c;
                        if (cemVar7 == null) {
                            throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-493624886295338L)  */);
                            throw null;
                        }
                        TextInputEditText textInputEditText4 = cemVar7.d;
                        Float fBd2 = dnp.bd((String) ((bzv) bzxVarY.e()).get(2));
                        textInputEditText4.setText(String.valueOf(fBd2 != null ? fBd2.floatValue() : 121.66625f));
                    }
                }
                return kotlinUnitVar;
            case 12:
                bxj bxjVar = bxj.a;
                HookManager hookManagerVarAb = PackageParam.createHook(bxjVar, dqc.toSingletonList((Method) obj));
                bxjVar.hookBefore(hookManagerVarAb, new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(hookManagerVarAb, i2));
                hookManagerVarAb.initInstantCollectionAndApplyHooks();
                return kotlinUnitVar;
            case 13:
                bxj bxjVar2 = bxj.a;
                HookManager hookManagerVarAb2 = PackageParam.createHook(bxjVar2, dqc.toSingletonList((Method) obj));
                bxjVar2.hookBefore(hookManagerVarAb2, new bty(4));
                hookManagerVarAb2.initInstantCollectionAndApplyHooks();
                return kotlinUnitVar;
            case 14:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(i3);
                return kotlinUnitVar;
            case 15:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(10);
                return kotlinUnitVar;
            case 16:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(i4);
                return kotlinUnitVar;
            case 17:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* cnb.z(-374130306186026L)  */ };
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("MicroMsg.LuckyMoneyUtil" /* "MicroMsg.LuckyMoneyUtil" /* "MicroMsg.LuckyMoneyUtil" /* cnb.z(-375612069903146L)  */, "exception:%s" /*
                                                                                                    * cnb.z(-
                                                                                                    * 375508990688042L)
                                                                                                    */);
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
                return kotlinUnitVar;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new bty(19);
                return kotlinUnitVar;
            case 19:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.MMAlert" /* "MicroMsg.MMAlert" /* "MicroMsg.MMAlert" /* cnb.z(-105072079928106L)  */);
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new bty(22);
                return kotlinUnitVar;
            case 21:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(23);
                return kotlinUnitVar;
            case 22:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.MMKernel" /* "MicroMsg.MMKernel" /* "MicroMsg.MMKernel" /* cnb.z(-105304008162090L)  */, "Kernel not null, has initialized." /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 104694122806058L)
                                                                                                                  */);
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 23:
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar7 = new DexFinder();
                byr.a.getClass();
                cdjVar7.o(StaticHelpers7.toDexClass(byp.a));
                cls = Class.class;
                Class<Class> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar7.q(clsBf != null ? clsBf : Class.class);
                dexMethodQueryBuilderVar7.getClass();
                dexMethodQueryBuilderVar7.dexFinder = cdjVar7;
                return kotlinUnitVar;
            case 24:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new bty(25);
                findDexClassMethodDslWrapperVar.onMethodCallback = new bty(26);
                return kotlinUnitVar;
            case 25:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.MMPreferenceAdapter" /* "MicroMsg.MMPreferenceAdapter" /* "MicroMsg.MMPreferenceAdapter" /* cnb.z(-104908871170858L)  */,
                        "ignore notifyDataSetChanged(%s %s), had:%s" /* "ignore notifyDataSetChanged(%s %s), had:%s" /* "ignore notifyDataSetChanged(%s %s), had:%s" /* cnb.z(-104818676857642L)  */);
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 26:
                DexMethodQueryBuilder dexMethodQueryBuilderVar8 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar8 = new DexFinder();
                Class clsB = cvh.a.b();
                cls2 = Integer.class;
                Class<Integer> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar8.q(clsB, clsBf2 != null ? clsBf2 : Integer.class);
                MethodMatcher fjVar = new MethodMatcher();
                DexFinder cdjVar9 = new DexFinder();
                cdjVar9.s("notifyDataSetChanged" /* "notifyDataSetChanged" /* "notifyDataSetChanged" /* cnb.z(-101850854456106L)  */);
                fjVar.f(cdjVar9);
                fjVar.usingStringsType = UsingStringsTypeEnum.Contains;
                cdjVar8.i = fjVar;
                dexMethodQueryBuilderVar8.getClass();
                dexMethodQueryBuilderVar8.dexFinder = cdjVar8;
                return kotlinUnitVar;
            case 27:
                HookParam hookParam3 = (HookParam) obj;
                int i9 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam3);
                fieldResolverVarAa.fieldType = "com.tencent.mm.ui.MMFragmentActivity" /* "com.tencent.mm.ui.MMFragmentActivity" /* "com.tencent.mm.ui.MMFragmentActivity" /* cnb.z(-69200513071914L)  */;
                Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue_();
                throwIfVar1IsNull(objE);
                Activity activity = (Activity) objE;
                FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa(hookParam3);
                fieldResolverVarAa2.name = "mViewPager" /* "mViewPager" /* "mViewPager" /* cnb.z(-69007239543594L)  */;
                Object objE2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa2.resolve())).getValue_();
                throwIfVar1IsNull(objE2);
                ViewGroup viewGroup = (ViewGroup) objE2;
                FieldResolver fieldResolverVarAa3 = StaticHelpers6.aa(hookParam3);
                fieldResolverVarAa3.name = "mTabsAdapter" /* "mTabsAdapter" /* "mTabsAdapter" /* cnb.z(-68444598827818L)  */;
                Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa3.resolve())).getValue();
                throwIfVar1IsNull(objD);
                for (bnp bnpVar : bzc.b) {
                    try {
                        bnpVar.t(activity, viewGroup, objD);
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("doOnCreate " /* "doOnCreate " /* "doOnCreate " /* cnb.z(-68354404514602L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bnpVar instanceof SwitchHook ? ((SwitchHook) bnpVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 68337224645418L)
                                                                                                               */,
                                -68247030332202L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 28:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bty(i5);
                return kotlinUnitVar;
            default:
                DexMethodQueryBuilder dexMethodQueryBuilderVar9 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar10 = new DexFinder();
                DexFinder.setClassEquals(cdjVar10, "com.tencent.mm.ui.MainTabUI" /* "com.tencent.mm.ui.MainTabUI" /* "com.tencent.mm.ui.MainTabUI" /* cnb.z(-68212670593834L)  */);
                cdjVar10.usingStrings("MicroMsg.LauncherUI.MainTabUI" /* "MicroMsg.LauncherUI.MainTabUI" /* "MicroMsg.LauncherUI.MainTabUI" /* cnb.z(-68676527061802L)  */, "doOnCreate" /*
                                                                                                        * cnb.z(-
                                                                                                        * 68530498173738L)
                                                                                                        */);
                dexMethodQueryBuilderVar9.getClass();
                dexMethodQueryBuilderVar9.dexFinder = cdjVar10;
                return kotlinUnitVar;
        }
    }
}
