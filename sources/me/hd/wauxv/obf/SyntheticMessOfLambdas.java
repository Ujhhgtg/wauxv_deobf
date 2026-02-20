package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SyntheticMessOfLambdas implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ SyntheticMessOfLambdas(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Object objX;
        String str;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        Object objX8;
        Object objX9;
        Object objX10;
        Object objX11;
        Object objX12;
        Object objX13;
        Object objX14;
        Object objX15;
        Object objX16;
        Object objX17;
        Object objX18;
        Object objX19;
        Object objX20;
        Intent intent;
        Object objX21;
        Object objX22;
        int i = this.a;
        int i2 = 7;
        int i3 = 3;
        boolean z = true;
        z = true;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-359729280842538L)   */ };
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.a = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings("getSnsVideoPath" /* "getSnsVideoPath" /* "getSnsVideoPath" /* "getSnsVideoPath" /* cnb.z(-359591841889066L)   */,
                        "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* cnb.z(-360072878226218L)   */);
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 1:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-356297601973034L)   */ };
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.usingStrings("getSnsVideoThumbImagePath" /* "getSnsVideoThumbImagePath" /* "getSnsVideoThumbImagePath" /* "getSnsVideoThumbImagePath" /* cnb.z(-356709918833450L)   */,
                        "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* "com.tencent.mm.plugin.sns.model.SnsVideoLogic" /* cnb.z(-356615429552938L)   */);
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SyntheticMessOfLambdas(i3);
                return kotlinUnitVar;
            case 3:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-358230337256234L)   */ };
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.usingStrings("MicroMsg.SnsVideoService" /* "MicroMsg.SnsVideoService" /* "MicroMsg.SnsVideoService" /* "MicroMsg.SnsVideoService" /* cnb.z(-357543142488874L)   */,
                        "add video task, but url is weixin, do nothing" /* "add video task, but url is weixin, do nothing" /* "add video task, but url is weixin, do nothing" /* "add video task, but url is weixin, do nothing" /* cnb.z(-357384228698922L)   */);
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 4:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_sport_step, null, false);
                int i4 = R.id.moduleDialogEdtSportModifyStep;
                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogEdtSportModifyStep);
                if (textInputEditText != null) {
                    i4 = R.id.moduleDialogInputSportModifyStep;
                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogInputSportModifyStep)) != null) {
                        LinearLayout linearLayout = (LinearLayout) viewK;
                        cee ceeVar = new cee(linearLayout, textInputEditText, i2);
                        textInputEditText.setText(String.valueOf(dlu.a.l()));
                        bzy bzyVar = new bzy(view.getContext());
                        eg egVar = (eg) bzyVar.d;
                        dlv.a.getClass();
                        egVar.d = dlv.c;
                        bzyVar.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-501025114946346L)   */, new amw(new cfx(ceeVar, 18), 0));
                        bjs.x((3 & 2) != 0 ? new amd(z ? 1 : 0) : null, bzyVar, "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                        if (linearLayout != null) {
                            egVar.r = linearLayout;
                        }
                        bzyVar.i().show();
                        return kotlinUnitVar;
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-659741336402730L)   */.concat(viewK.getResources().getResourceName(i4)));
            case 5:
                ((HookParam) obj).setResult(Long.valueOf(Math.min(dlu.a.l(), 98800L)));
                return kotlinUnitVar;
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SyntheticMessOfLambdas(i2);
                return kotlinUnitVar;
            case 7:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.plugin.sport.model" /* "com.tencent.mm.plugin.sport.model" /* "com.tencent.mm.plugin.sport.model" /* "com.tencent.mm.plugin.sport.model" /* cnb.z(-501029409913642L)   */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr4);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("MicroMsg.Sport.DeviceStepManager" /* "MicroMsg.Sport.DeviceStepManager" /* "MicroMsg.Sport.DeviceStepManager" /* "MicroMsg.Sport.DeviceStepManager" /* cnb.z(-500831841418026L)   */,
                        "get today step from %s todayStep %d" /* "get today step from %s todayStep %d" /* "get today step from %s todayStep %d" /* "get today step from %s todayStep %d" /* cnb.z(-501257043180330L)   */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return kotlinUnitVar;
            case 8:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SyntheticMessOfLambdas(9);
                return kotlinUnitVar;
            case 9:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.DBInit" /* "MicroMsg.DBInit" /* "MicroMsg.DBInit" /* "MicroMsg.DBInit" /* cnb.z(-90838558309162L)   */, "initSysDB checkini:%b exist:%b db:%s " /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 90769838832426L)
                                                                                                                  */);
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 10:
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
                String str2 = (String) objX;
                str = str2 != null ? str2 : "";
                try {
                    objX2 = hookParam.getArgs()[1];
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
                    objX3 = hookParam.getArgs()[2];
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
                ContentValues contentValues = (ContentValues) objX3;
                try {
                    objX4 = hookParam.getArgs()[3];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = FastKV.getFailureFromException(th4);
                }
                for (IDatabaseOperationsListener bobVar : dly.b) {
                    try {
                        bobVar.s(str, contentValues);
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onDatabaseInsertBefore " /* "onDatabaseInsertBefore " /* "onDatabaseInsertBefore " /* "onDatabaseInsertBefore " /* cnb.z(-54709293415210L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bobVar instanceof SwitchHook ? ((SwitchHook) bobVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 54056458386218L)
                                                                                                               */,
                                -54017803680554L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 11:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX5 = hookParam2.getArgs()[0];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = FastKV.getFailureFromException(th5);
                }
                if (objX5 instanceof Failure) {
                    objX5 = null;
                }
                String str3 = (String) objX5;
                String str4 = str3 == null ? "" : str3;
                try {
                    objX6 = hookParam2.getArgs()[1];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = FastKV.getFailureFromException(th6);
                }
                if (objX6 instanceof Failure) {
                    objX6 = null;
                }
                throwIfVar1IsNull(objX6);
                ContentValues contentValues2 = (ContentValues) objX6;
                try {
                    objX7 = hookParam2.getArgs()[2];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = FastKV.getFailureFromException(th7);
                }
                if (objX7 instanceof Failure) {
                    objX7 = null;
                }
                String str5 = (String) objX7;
                String str6 = str5 == null ? "" : str5;
                try {
                    objX8 = hookParam2.getArgs()[3];
                    if (objX8 == null) {
                        objX8 = null;
                    }
                } catch (Throwable th8) {
                    objX8 = FastKV.getFailureFromException(th8);
                }
                if (objX8 instanceof Failure) {
                    objX8 = null;
                }
                String[] strArr5 = (String[]) objX8;
                try {
                    objX9 = hookParam2.getArgs()[4];
                    if (objX9 == null) {
                        objX9 = null;
                    }
                } catch (Throwable th9) {
                    objX9 = FastKV.getFailureFromException(th9);
                }
                Integer num = (Integer) (objX9 instanceof Failure ? null : objX9);
                int iIntValue = num != null ? num.intValue() : 0;
                for (IDatabaseOperationsListener bobVar2 : dly.b) {
                    try {
                        bobVar2.j(hookParam2, str4, contentValues2, str6, strArr5, iIntValue);
                    } catch (Exception e2) {
                        ArrayList arrayList2 = Logger.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onDatabaseUpdateBefore " /* "onDatabaseUpdateBefore " /* "onDatabaseUpdateBefore " /* "onDatabaseUpdateBefore " /* cnb.z(-53983443942186L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                bobVar2 instanceof SwitchHook ? ((SwitchHook) bobVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 53880364727082L)
                                                                                                                 */,
                                -54408645704490L), e2, 12);
                    }
                }
                return kotlinUnitVar;
            case 12:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    Object obj2 = hookParam3.getArgs()[0];
                    break;
                } catch (Throwable th10) {
                    FastKV.getFailureFromException(th10);
                }
                try {
                    objX10 = hookParam3.getArgs()[1];
                    if (objX10 == null) {
                        objX10 = null;
                    }
                } catch (Throwable th11) {
                    objX10 = FastKV.getFailureFromException(th11);
                }
                if (objX10 instanceof Failure) {
                    objX10 = null;
                }
                String str7 = (String) objX10;
                str = str7 != null ? str7 : "";
                try {
                    objX11 = hookParam3.getArgs()[2];
                    if (objX11 == null) {
                        objX11 = null;
                    }
                } catch (Throwable th12) {
                    objX11 = FastKV.getFailureFromException(th12);
                }
                if (objX11 instanceof Failure) {
                    objX11 = null;
                }
                try {
                    objX12 = hookParam3.getArgs()[3];
                    if (objX12 == null) {
                        objX12 = null;
                    }
                } catch (Throwable th13) {
                    objX12 = FastKV.getFailureFromException(th13);
                }
                try {
                    Object obj3 = hookParam3.getArgs()[4];
                    break;
                } catch (Throwable th14) {
                    FastKV.getFailureFromException(th14);
                }
                for (IDatabaseOperationsListener bobVar3 : dly.b) {
                    try {
                        bobVar3.n(hookParam3, str);
                    } catch (Exception e3) {
                        ArrayList arrayList3 = Logger.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onDatabaseQueryBefore " /* "onDatabaseQueryBefore " /* "onDatabaseQueryBefore " /* "onDatabaseQueryBefore " /* cnb.z(-54374285966122L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb3,
                                bobVar3 instanceof SwitchHook ? ((SwitchHook) bobVar3).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 54258321849130L)
                                                                                                                 */,
                                -54236847012650L), e3, 12);
                    }
                }
                return kotlinUnitVar;
            case 13:
                HookParam hookParam4 = (HookParam) obj;
                hookParam4.getClass();
                try {
                    objX13 = hookParam4.getArgs()[0];
                    if (objX13 == null) {
                        objX13 = null;
                    }
                } catch (Throwable th15) {
                    objX13 = FastKV.getFailureFromException(th15);
                }
                if (objX13 instanceof Failure) {
                    objX13 = null;
                }
                String str8 = (String) objX13;
                String str9 = str8 == null ? "" : str8;
                try {
                    objX14 = hookParam4.getArgs()[1];
                    if (objX14 == null) {
                        objX14 = null;
                    }
                } catch (Throwable th16) {
                    objX14 = FastKV.getFailureFromException(th16);
                }
                if (objX14 instanceof Failure) {
                    objX14 = null;
                }
                throwIfVar1IsNull(objX14);
                ContentValues contentValues3 = (ContentValues) objX14;
                try {
                    objX15 = hookParam4.getArgs()[2];
                    if (objX15 == null) {
                        objX15 = null;
                    }
                } catch (Throwable th17) {
                    objX15 = FastKV.getFailureFromException(th17);
                }
                if (objX15 instanceof Failure) {
                    objX15 = null;
                }
                String str10 = (String) objX15;
                String str11 = str10 == null ? "" : str10;
                try {
                    objX16 = hookParam4.getArgs()[3];
                    if (objX16 == null) {
                        objX16 = null;
                    }
                } catch (Throwable th18) {
                    objX16 = FastKV.getFailureFromException(th18);
                }
                if (objX16 instanceof Failure) {
                    objX16 = null;
                }
                String[] strArr6 = (String[]) objX16;
                try {
                    objX17 = hookParam4.getArgs()[4];
                    if (objX17 == null) {
                        objX17 = null;
                    }
                } catch (Throwable th19) {
                    objX17 = FastKV.getFailureFromException(th19);
                }
                Integer num2 = (Integer) (objX17 instanceof Failure ? null : objX17);
                int iIntValue2 = num2 != null ? num2.intValue() : 0;
                for (IDatabaseOperationsListener bobVar4 : dly.b) {
                    try {
                        bobVar4.l(hookParam4, str9, contentValues3, str11, strArr6, iIntValue2);
                    } catch (Exception e4) {
                        ArrayList arrayList4 = Logger.a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onCompatUpdateBefore " /* "onCompatUpdateBefore " /* "onCompatUpdateBefore " /* "onCompatUpdateBefore " /* cnb.z(-54202487274282L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb4,
                                bobVar4 instanceof SwitchHook ? ((SwitchHook) bobVar4).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 60138132077354L)
                                                                                                                 */,
                                -60099477371690L), e4, 12);
                    }
                }
                return kotlinUnitVar;
            case 14:
                HookParam hookParam5 = (HookParam) obj;
                hookParam5.getClass();
                try {
                    objX18 = hookParam5.getArgs()[0];
                    if (objX18 == null) {
                        objX18 = null;
                    }
                } catch (Throwable th20) {
                    objX18 = FastKV.getFailureFromException(th20);
                }
                if (objX18 instanceof Failure) {
                    objX18 = null;
                }
                String str12 = (String) objX18;
                str = str12 != null ? str12 : "";
                try {
                    objX19 = hookParam5.getArgs()[1];
                    if (objX19 == null) {
                        objX19 = null;
                    }
                } catch (Throwable th21) {
                    objX19 = FastKV.getFailureFromException(th21);
                }
                try {
                    Object obj4 = hookParam5.getArgs()[2];
                    break;
                } catch (Throwable th22) {
                    FastKV.getFailureFromException(th22);
                }
                for (IDatabaseOperationsListener bobVar5 : dly.b) {
                    try {
                        bobVar5.t(hookParam5, str);
                    } catch (Exception e5) {
                        ArrayList arrayList5 = Logger.a;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onCompatQueryBefore " /* "onCompatQueryBefore " /* "onCompatQueryBefore " /* "onCompatQueryBefore " /* cnb.z(-60065117633322L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb5,
                                bobVar5 instanceof SwitchHook ? ((SwitchHook) bobVar5).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 60026462927658L)
                                                                                                                 */,
                                -59987808221994L), e5, 12);
                    }
                }
                return kotlinUnitVar;
            case 15:
                String str13 = (String) obj;
                if (!nullSafeIsEqual(str13, "startActivity" /* "startActivity" /* "startActivity" /* "startActivity" /* cnb.z(-59953448483626L)   */)
                        && !nullSafeIsEqual(str13, "startActivityForResult" /* "startActivityForResult" /* "startActivityForResult" /* "startActivityForResult" /* cnb.z(-60425894886186L)   */)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 16:
                HookParam hookParam6 = (HookParam) obj;
                if (hookParam6.getArgs()[0] instanceof Intent) {
                    try {
                        objX21 = hookParam6.getArgs()[0];
                        if (objX21 == null) {
                            objX21 = null;
                        }
                    } catch (Throwable th23) {
                        objX21 = FastKV.getFailureFromException(th23);
                    }
                    intent = (Intent) (objX21 instanceof Failure ? null : objX21);
                } else {
                    try {
                        objX20 = hookParam6.getArgs()[1];
                        if (objX20 == null) {
                            objX20 = null;
                        }
                    } catch (Throwable th24) {
                        objX20 = FastKV.getFailureFromException(th24);
                    }
                    intent = (Intent) (objX20 instanceof Failure ? null : objX20);
                }
                throwIfVar1IsNull(intent);
                for (IStartActivity bocVar : dmi.b) {
                    try {
                        bocVar.onStartActivityIntent(hookParam6, intent);
                    } catch (Exception e6) {
                        ArrayList arrayList6 = Logger.a;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("onStartActivityIntent " /* "onStartActivityIntent " /* "onStartActivityIntent " /* "onStartActivityIntent " /* cnb.z(-60327110638378L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb6,
                                bocVar instanceof SwitchHook ? ((SwitchHook) bocVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 60211146521386L)
                                                                                                               */,
                                -59639915871018L), e6, 12);
                    }
                }
                return kotlinUnitVar;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SyntheticMessOfLambdas(21);
                return kotlinUnitVar;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SyntheticMessOfLambdas(23);
                return kotlinUnitVar;
            case 19:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SyntheticMessOfLambdas(22);
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SyntheticMessOfLambdas(24);
                return kotlinUnitVar;
            case 21:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                String[] strArr7 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-366897581259562L)   */ };
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.strings = SomeStaticHelpers.arrayToList(strArr7);
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* "PRAGMA table_info( contact_ext )" /* cnb.z(-366798797011754L)   */);
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 22:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                String[] strArr8 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-366373595249450L)   */ };
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.strings = SomeStaticHelpers.arrayToList(strArr8);
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* cnb.z(-366274811001642L)   */);
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 23:
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                String[] strArr9 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-367206818904874L)   */ };
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr9);
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* cnb.z(-367108034657066L)   */,
                        "deleted dirty msg ,count is %d" /* "deleted dirty msg ,count is %d" /* "deleted dirty msg ,count is %d" /* "deleted dirty msg ,count is %d" /* cnb.z(-367004955441962L)   */);
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
                return kotlinUnitVar;
            case 24:
                DexClassQueryBuilder dexClassQueryBuilderVar5 = (DexClassQueryBuilder) obj;
                String[] strArr10 = { "com.tencent.mm.plugin.messenger.foundation" /* "com.tencent.mm.plugin.messenger.foundation" /* "com.tencent.mm.plugin.messenger.foundation" /* "com.tencent.mm.plugin.messenger.foundation" /* cnb.z(-366626998319914L)   */ };
                dexClassQueryBuilderVar5.getClass();
                dexClassQueryBuilderVar5.strings = SomeStaticHelpers.arrayToList(strArr10);
                DexMethodGroupMatcher zbVar5 = new DexMethodGroupMatcher();
                azl azlVar = new azl();
                azlVar.f(StaticHelpers7.toDexClass(dmq.a));
                azlVar.f(StaticHelpers7.toDexClass(dms.a));
                azlVar.f(StaticHelpers7.toDexClass(dmr.a));
                zbVar5.e = azlVar;
                dexClassQueryBuilderVar5.methodGroupMatcher = zbVar5;
                return kotlinUnitVar;
            case 25:
                return Boolean.valueOf(((View) obj).getVisibility() == 0);
            case 26:
                return Boolean.valueOf(((View) obj).getVisibility() == 0);
            case 27:
                return Boolean.valueOf(((View) obj).getVisibility() == 0);
            case 28:
                HookParam hookParam7 = (HookParam) obj;
                hookParam7.getClass();
                try {
                    objX22 = hookParam7.getArgs()[0];
                    if (objX22 == null) {
                        objX22 = null;
                    }
                } catch (Throwable th25) {
                    objX22 = FastKV.getFailureFromException(th25);
                }
                Object obj5 = objX22 instanceof Failure ? null : objX22;
                throwIfVar1IsNull(obj5);
                String str14 = (String) obj5;
                try {
                    Object obj6 = hookParam7.getArgs()[1];
                    break;
                } catch (Throwable th26) {
                    FastKV.getFailureFromException(th26);
                }
                for (bod bodVar : dou.b) {
                    try {
                        bodVar.d(hookParam7, str14);
                    } catch (Exception e7) {
                        ArrayList arrayList7 = Logger.a;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("onGetSyncConfig " /* "onGetSyncConfig " /* "onGetSyncConfig " /* "onGetSyncConfig " /* cnb.z(-59502476917546L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb7,
                                bodVar instanceof SwitchHook ? ((SwitchHook) bodVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 59429462473514L)
                                                                                                               */,
                                -59407987637034L), e7, 12);
                    }
                }
                return kotlinUnitVar;
            default:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new dos(i);
                findDexClassMethodDslWrapperVar.onMethodCallback = new dos(z ? 1 : 0);
                return kotlinUnitVar;
        }
    }
}
