package me.hd.wauxv.obf;

import android.app.Activity;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class act implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ act(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls;
        Class cls2;
        Class cls3;
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Class cls4;
        Class cls5;
        Class cls6;
        int i = this.a;
        int i2 = 8;
        cls = Activity.class;
        int i3 = 4;
        int i4 = 3;
        cls2 = Boolean.class;
        cls3 = String.class;
        int i5 = 1;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new act(i5);
                return kotlinUnitVar;
            case 1:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-385584983964458L)  */ };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.ConfigStorage" /* "MicroMsg.ConfigStorage" /* "MicroMsg.ConfigStorage" /* cnb.z(-385469019847466L)  */,
                        "shouldProcessEvent db is close :%s" /* "shouldProcessEvent db is close :%s" /* "shouldProcessEvent db is close :%s" /* cnb.z(-385919991413546L)  */);
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(i4);
                return kotlinUnitVar;
            case 3:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings("login_weixin_username" /* "login_weixin_username" /* "login_weixin_username" /* cnb.z(-109113644153642L)  */,
                        "login_user_name" /* "login_user_name" /* "login_user_name" /* cnb.z(-109001975003946L)  */,
                        "last_login_nick_name" /* "last_login_nick_name" /* "last_login_nick_name" /* cnb.z(-108933255527210L)  */,
                        "last_login_bind_mobile" /* "last_login_bind_mobile" /* "last_login_bind_mobile" /* cnb.z(-109375637158698L)  */, "last_login_bind_email" /*
                                                                                                          * cnb.z(-
                                                                                                          * 109328392518442L)
                                                                                                          */,
                        "last_login_bind_qq" /* "last_login_bind_qq" /* "last_login_bind_qq" /* cnb.z(-109216723368746L)  */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 4:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new act(5);
                return kotlinUnitVar;
            case 5:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                azl azlVar = new azl();
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                if (clsBf == null) {
                    clsBf = cls3;
                }
                azlVar.f(clsBf);
                Class<String> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                azlVar.f(clsBf2 != null ? clsBf2 : String.class);
                azlVar.d = new bqh(2);
                zbVar2.e = azlVar;
                MethodMatcher fjVar = new MethodMatcher();
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.s("compareContent" /* "compareContent" /* "compareContent" /* cnb.z(-103521596734250L)  */);
                fjVar.f(cdjVar2);
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.s("op" /* "op" /* "op" /* cnb.z(-103457172224810L)  */);
                fjVar.f(cdjVar3);
                DexFinder cdjVar4 = new DexFinder();
                MethodMatcher fjVar2 = new MethodMatcher();
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.usingStrings("MicroMsg.Label.ContactLabelUI" /* "MicroMsg.Label.ContactLabelUI" /* "MicroMsg.Label.ContactLabelUI" /* cnb.z(-103392747715370L)  */, "cpan[saveContact]" /*
                                                                                                               * cnb.z(-
                                                                                                               * 103865194117930L)
                                                                                                               */);
                fjVar2.f(cdjVar5);
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("MicroMsg.Label.ContactLabelManagerImpl" /* "MicroMsg.Label.ContactLabelManagerImpl" /* "MicroMsg.Label.ContactLabelManagerImpl" /* cnb.z(-103736345099050L)  */,
                        "add contact label faild." /* "add contact label faild." /* "add contact label faild." /* cnb.z(-105218108816170L)  */);
                fjVar2.f(cdjVar6);
                cdjVar4.j = fjVar2;
                fjVar.f(cdjVar4);
                zbVar2.f = fjVar;
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(i2);
                return kotlinUnitVar;
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new act(9);
                return kotlinUnitVar;
            case 8:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-360983411292970L)  */ };
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.usingStrings("MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* cnb.z(-362516714617642L)  */,
                        "cpan[getLabelIdByStr] label id is %s" /* "cpan[getLabelIdByStr] label id is %s" /* "cpan[getLabelIdByStr] label id is %s" /* cnb.z(-362332031023914L)  */);
                dexMethodQueryBuilderVar2.dexFinder = cdjVar7;
                return kotlinUnitVar;
            case 9:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                azl azlVar2 = new azl();
                aeg.a.getClass();
                aee aeeVar = aee.a;
                azlVar2.f(StaticHelpers7.toDexMethod(aeeVar).getDeclaringClass());
                zbVar3.e = azlVar2;
                MethodMatcher fjVar3 = new MethodMatcher();
                DexFinder cdjVar8 = new DexFinder();
                DexFinder.m(cdjVar8, 8);
                cdjVar8.r(StaticHelpers7.toDexMethod(aeeVar).getDeclaringClass());
                MethodMatcher fjVar4 = new MethodMatcher(i3);
                fjVar4.b = StaticHelpers5.ab(EmptyReadonlyList.INSTANCE);
                cdjVar8.f = fjVar4;
                fjVar3.f(cdjVar8);
                zbVar3.f = fjVar3;
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 10:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(14);
                return kotlinUnitVar;
            case 11:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(13);
                return kotlinUnitVar;
            case 12:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(15);
                return kotlinUnitVar;
            case 13:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar9 = new DexFinder();
                aeg.a.getClass();
                cdjVar9.setDeclaredClassName(StaticHelpers7.toDexMethod(aee.a).getDeclaringClass());
                cdjVar9.usingStrings("MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* cnb.z(-386474042194730L)  */,
                        "getAllContactLable time:%s count:%s stack:%s" /* "getAllContactLable time:%s count:%s stack:%s" /* "getAllContactLable time:%s count:%s stack:%s" /* cnb.z(-386289358601002L)  */,
                        "select * from ContactLabel where isTemporary = 0  order by createTime ASC " /*
                                                                                                      * cnb.z(-
                                                                                                      * 383381665741610L)
                                                                                                      */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar9;
                return kotlinUnitVar;
            case 14:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-386830524480298L)  */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar10 = new DexFinder();
                cdjVar10.usingStrings("MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* cnb.z(-386783279840042L)  */,
                        "cpan[getLabelIdByStr] label id is %s" /* "cpan[getLabelIdByStr] label id is %s" /* "cpan[getLabelIdByStr] label id is %s" /* cnb.z(-386048840432426L)  */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar10;
                return kotlinUnitVar;
            case 15:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar11 = new DexFinder();
                aeg.a.getClass();
                cdjVar11.setDeclaredClassName(StaticHelpers7.toDexMethod(aee.a).getDeclaringClass());
                cdjVar11.usingStrings("MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* "MicroMsg.Label.ContactLabelStorage" /* cnb.z(-383574939269930L)  */,
                        "getUserNameListById time:%s id:%s count:%s stack:%s" /* "getUserNameListById time:%s id:%s count:%s stack:%s" /* "getUserNameListById time:%s id:%s count:%s stack:%s" /* cnb.z(-382892039469866L)  */);
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.dexFinder = cdjVar11;
                return kotlinUnitVar;
            case 16:
                return Boolean.FALSE;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new act(20);
                return kotlinUnitVar;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(19);
                return kotlinUnitVar;
            case 19:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar12 = new DexFinder();
                aeo.a.getClass();
                cdjVar12.setDeclaredClassName(StaticHelpers7.toDexClass(aem.a));
                Class<String> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cls3 = clsBf3 != null ? clsBf3 : String.class;
                Class<Boolean> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar12.q(cls3, clsBf4 != null ? clsBf4 : Boolean.class);
                cdjVar12.usingStrings("[get]username = %s" /* "[get]username = %s" /* "[get]username = %s" /* cnb.z(-384309378677546L)  */);
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.dexFinder = cdjVar12;
                return kotlinUnitVar;
            case 20:
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-384549896846122L)  */ };
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr4);
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* cnb.z(-384451112598314L)  */);
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
                return kotlinUnitVar;
            case 21:
                Object objE = ((HookParam) obj).getThisObject();
                Activity activity = (Activity) (objE instanceof Activity ? objE : null);
                if (activity == null) {
                    Class<Activity> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf5 != null ? clsBf5 : Activity.class).getName()).toString());
                }
                int i6 = 0;
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(activity).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "getPreferenceScreen" /* "getPreferenceScreen" /* "getPreferenceScreen" /* cnb.z(-37649683315498L)  */;
                Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT)).invoke(new Object[0]);
                throwIfVar1IsNull(objJ);
                BaseAdapter baseAdapter = (BaseAdapter) objJ;
                for (bnd bndVar : aeq.b) {
                    try {
                        for (aep aepVar : bndVar.a(activity)) {
                            cnb.m(baseAdapter, aepVar.b, aepVar.c);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onAddItems " /* "onAddItems " /* "onAddItems " /* cnb.z(-37529424231210L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bndVar instanceof SwitchHook ? ((SwitchHook) bndVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 37512244362026L)
                                                                                                               */,
                                -37473589656362L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 22:
                HookParam hookParam = (HookParam) obj;
                Object objE2 = hookParam.getThisObject();
                if (!(objE2 instanceof Activity)) {
                    objE2 = null;
                }
                Activity activity2 = (Activity) objE2;
                if (activity2 == null) {
                    Class<Activity> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf6 != null ? clsBf6 : Activity.class).getName()).toString());
                }
                try {
                    objX = hookParam.getArgs()[1];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                Object obj2 = objX instanceof Failure ? null : objX;
                throwIfVar1IsNull(obj2);
                int i7 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj2).r();
                fieldResolverVarR.fieldType = dal.getKClassFromClass(cls3);
                fieldResolverVarR.enableSuperclass();
                Iterator it = fieldResolverVarR.resolve().iterator();
                while (it.hasNext()) {
                    String str = (String) ((BoundField) it.next()).getValue_();
                    if (str != null) {
                        for (bnd bndVar2 : aeq.b) {
                            try {
                                for (aep aepVar2 : bndVar2.a(activity2)) {
                                    if (str.equals(aepVar2.a)) {
                                        aepVar2.d.invoke(activity2);
                                        hookParam.setResultTrue();
                                    }
                                }
                            } catch (Exception e2) {
                                ArrayList arrayList2 = Logger.a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("onAddItems " /* "onAddItems " /* "onAddItems " /* cnb.z(-37439229917994L)  */);
                                Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2, bndVar2 instanceof SwitchHook ? ((SwitchHook) bndVar2).getResult()
                                        : "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-37903086385962L)  */, -37881611549482L), e2, 12);
                            }
                        }
                    }
                }
                return kotlinUnitVar;
            case 23:
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
                CharSequence charSequence = (CharSequence) objX3;
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
                try {
                    objX5 = hookParam2.getArgs()[3];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = FastKV.getFailureFromException(th5);
                }
                if (objX5 instanceof Failure) {
                    objX5 = null;
                }
                try {
                    objX6 = hookParam2.getArgs()[4];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = FastKV.getFailureFromException(th6);
                }
                Boolean bool = (Boolean) (objX6 instanceof Failure ? null : objX6);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                for (Object obj3 : afu.b) {
                    try {
                        ((AppBrandForceShareHook) obj3).i(hookParam2, charSequence, zBooleanValue);
                    } catch (Exception e3) {
                        ArrayList arrayList3 = Logger.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onCreateBottomSheetDialogMenu " /* "onCreateBottomSheetDialogMenu " /* "onCreateBottomSheetDialogMenu " /* cnb.z(-39286065855274L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb3,
                                obj3 instanceof SwitchHook ? ((SwitchHook) obj3).getResult() : "LoadHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 39152921869098L)
                                                                                                           */,
                                -39114267163434L), e3, 12);
                    }
                }
                return kotlinUnitVar;
            case 24:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(25);
                return kotlinUnitVar;
            case 25:
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar13 = new DexFinder();
                cls4 = MenuItem.class;
                Class<MenuItem> clsBf7 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                cdjVar13.r(clsBf7 != null ? clsBf7 : MenuItem.class);
                cls5 = Integer.class;
                Class<Integer> clsBf8 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                if (clsBf8 == null) {
                    clsBf8 = cls5;
                }
                cls6 = CharSequence.class;
                Class<CharSequence> clsBf9 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                cls6 = clsBf9 != null ? clsBf9 : CharSequence.class;
                Class<Integer> clsBf10 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                if (clsBf10 == null) {
                    clsBf10 = cls5;
                }
                Class<Integer> clsBf11 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                cls5 = clsBf11 != null ? clsBf11 : Integer.class;
                Class<Boolean> clsBf12 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar13.q(clsBf8, cls6, clsBf10, cls5, clsBf12 != null ? clsBf12 : Boolean.class);
                dexMethodQueryBuilderVar7.getClass();
                dexMethodQueryBuilderVar7.dexFinder = cdjVar13;
                return kotlinUnitVar;
            case 26:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(27);
                return kotlinUnitVar;
            case 27:
                DexMethodQueryBuilder dexMethodQueryBuilderVar8 = (DexMethodQueryBuilder) obj;
                String[] strArr5 = { "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* cnb.z(-106210246261546L)  */ };
                dexMethodQueryBuilderVar8.getClass();
                dexMethodQueryBuilderVar8.a = SomeStaticHelpers.arrayToList(strArr5);
                DexFinder cdjVar14 = new DexFinder();
                cdjVar14.usingStrings("MicroMsg.ConvDelLogic" /* "MicroMsg.ConvDelLogic" /* "MicroMsg.ConvDelLogic" /* cnb.z(-106626858089258L)  */, "del all notify message" /*
                                                                                                             * cnb.z(-
                                                                                                             * 106583908416298L)
                                                                                                             */);
                dexMethodQueryBuilderVar8.dexFinder = cdjVar14;
                return kotlinUnitVar;
            case 28:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new act(29);
                return kotlinUnitVar;
            default:
                DexMethodQueryBuilder dexMethodQueryBuilderVar9 = (DexMethodQueryBuilder) obj;
                String[] strArr6 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-78988743539498L)  */ };
                dexMethodQueryBuilderVar9.getClass();
                dexMethodQueryBuilderVar9.a = SomeStaticHelpers.arrayToList(strArr6);
                DexFinder cdjVar15 = new DexFinder();
                cdjVar15.usingStrings("hidden_conv_parent" /* "hidden_conv_parent" /* "hidden_conv_parent" /* cnb.z(-78340203477802L)  */, "message_fold" /*
                                                                                               * "message_fold" /* "message_fold" /* cnb.z(-78207059491626L)  */
                                                                                               */,
                        "appbrandcustomerservicemsg" /* "appbrandcustomerservicemsg" /* "appbrandcustomerservicemsg" /* cnb.z(-78202764524330L)  */);
                dexMethodQueryBuilderVar9.dexFinder = cdjVar15;
                return kotlinUnitVar;
        }
    }
}
