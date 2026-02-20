package me.hd.wauxv.obf;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class amb implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ amb(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Class cls;
        int i = this.a;
        int i2 = 18;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[1];
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
                    objX2 = hookParam.getArgs()[2];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                if (objX2 instanceof Failure) {
                    objX2 = null;
                }
                String str = (String) objX2;
                if (str == null) {
                    str = "";
                }
                try {
                    objX3 = hookParam.getArgs()[9];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = FastKV.getFailureFromException(th3);
                }
                String str2 = (String) (objX3 instanceof Failure ? null : objX3);
                String str3 = str2 != null ? str2 : "";
                if (iIntValue == 0) {
                    String strZ = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-647689658170154L)  */;
                    StringBuilder sbY = StaticHelpers6.toSb(str);
                    sbY.append(": " /* ": " /* ": " /* cnb.z(-647659593399082L)  */);
                    sbY.append(str3);
                    Log.v(strZ, sbY.toString());
                } else if (iIntValue == 1) {
                    String strZ2 = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-647681068235562L)  */;
                    StringBuilder sbY2 = StaticHelpers6.toSb(str);
                    sbY2.append(": " /* ": " /* ": " /* cnb.z(-648132039801642L)  */);
                    sbY2.append(str3);
                    Log.d(strZ2, sbY2.toString());
                } else if (iIntValue == 2) {
                    String strZ3 = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-648153514638122L)  */;
                    StringBuilder sbY3 = StaticHelpers6.toSb(str);
                    sbY3.append(": " /* ": " /* ": " /* cnb.z(-648123449867050L)  */);
                    sbY3.append(str3);
                    Log.i(strZ3, sbY3.toString());
                } else if (iIntValue == 3) {
                    String strZ4 = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-648076205226794L)  */;
                    StringBuilder sbY4 = StaticHelpers6.toSb(str);
                    sbY4.append(": " /* ": " /* ": " /* cnb.z(-648046140455722L)  */);
                    sbY4.append(str3);
                    Log.w(strZ4, sbY4.toString());
                } else if (iIntValue == 4) {
                    String strZ5 = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-647998895815466L)  */;
                    StringBuilder sbY5 = StaticHelpers6.toSb(str);
                    sbY5.append(": " /* ": " /* ": " /* cnb.z(-647968831044394L)  */);
                    sbY5.append(str3);
                    Log.e(strZ5, sbY5.toString());
                } else if (iIntValue == 5) {
                    String strZ6 = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-647990305880874L)  */;
                    StringBuilder sbY6 = StaticHelpers6.toSb(str);
                    sbY6.append(": " /* ": " /* ": " /* cnb.z(-647891521633066L)  */);
                    sbY6.append(str3);
                    Log.wtf(strZ6, sbY6.toString());
                }
                return kotlinUnitVar;
            case 1:
                String str4 = (String) obj;
                throwIfVar1IsNull(str4, "it");
                return ams.h(str4);
            case 2:
                Class cls2 = (Class) obj;
                throwIfVar1IsNull(cls2);
                return ams.g(cls2);
            case 3:
                Class cls3 = (Class) obj;
                throwIfVar1IsNull(cls3);
                return ams.g(cls3);
            case 4:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX4 = hookParam2.getArgs()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = FastKV.getFailureFromException(th4);
                }
                Object obj2 = objX4 instanceof Failure ? null : objX4;
                throwIfVar1IsNull(obj2);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) obj2;
                if (layoutParams.screenBrightness >= 0.5f) {
                    layoutParams.screenBrightness = -1.0f;
                }
                return kotlinUnitVar;
            case 5:
                ((HookParam) obj).setResult(null);
                return kotlinUnitVar;
            case 6:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new amb(7);
                findDexClassMethodDslWrapperVar.onMethodCallback = new amb(8);
                return kotlinUnitVar;
            case 7:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-446706663553834L)  */ };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings(".msgsource.sec_msg_node.clip-len" /* ".msgsource.sec_msg_node.clip-len" /* ".msgsource.sec_msg_node.clip-len" /* cnb.z(-448179837336362L)  */);
                dnf dnfVar = new dnf("MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* "MicroMsg.ChattingItem" /* cnb.z(-448587859229482L)  */, MatchTypeEnum.Contains, false);
                List arrayList = zbVar.g;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                zbVar.g = arrayList;
                arrayList.add(dnfVar);
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 8:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings(".msgsource.sec_msg_node.clip-len" /* ".msgsource.sec_msg_node.clip-len" /* ".msgsource.sec_msg_node.clip-len" /* cnb.z(-448476190079786L)  */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 9:
                ((HookParam) obj).setResult(Boolean.FALSE);
                return kotlinUnitVar;
            case 10:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new amb(11);
                return kotlinUnitVar;
            case 11:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.usingStrings("MicroMsg.PluginPatMsg" /* "MicroMsg.PluginPatMsg" /* "MicroMsg.PluginPatMsg" /* cnb.z(-447995153742634L)  */, "DisableSendPat" /*
                                                                                                    * cnb.z(-
                                                                                                    * 447883484592938L)
                                                                                                    */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 12:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_disable_ringtone_play, null, false);
                int i3 = R.id.moduleDialogCbDisableRingtoneInCall;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogCbDisableRingtoneInCall);
                if (materialCheckBox != null) {
                    i3 = R.id.moduleDialogCbDisableRingtoneOutCall;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogCbDisableRingtoneOutCall);
                    if (materialCheckBox2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewK;
                        cek cekVar = new cek(linearLayout, materialCheckBox, materialCheckBox2, 1);
                        materialCheckBox2.setChecked(aod.a.i());
                        materialCheckBox.setChecked(aoc.a.i());
                        bzy bzyVar = new bzy(view.getContext());
                        eg egVar = (eg) bzyVar.d;
                        DisablePlayRingtoneHook.a.getClass();
                        egVar.d = DisablePlayRingtoneHook.c;
                        bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-444404561083178L)  */, new amw(new bp(cekVar, i2), 0));
                        bjs.x((3 & 2) != 0 ? new amd(i) : null, bzyVar, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                        if (linearLayout != null) {
                            egVar.r = linearLayout;
                        }
                        bzyVar.i().show();
                        return kotlinUnitVar;
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-639675249195818L)  */.concat(viewK.getResources().getResourceName(i3)));
            case 13:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    objX5 = hookParam3.getArgs()[1];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = FastKV.getFailureFromException(th5);
                }
                Object obj3 = objX5 instanceof Failure ? null : objX5;
                throwIfVar1IsNull(obj3);
                Bundle bundle = (Bundle) obj3;
                if (nullSafeIsEqual(bundle.getString("scene" /* "scene" /* "scene" /* cnb.z(-444357316442922L)  */), "start" /*
                                                                                                       * cnb.z(-
                                                                                                       * 444314366769962L)
                                                                                                       */)) {
                    boolean z = bundle.getBoolean("isOutCall" /* "isOutCall" /* "isOutCall" /* cnb.z(-444340136573738L)  */);
                    Object[] objArr = z && aod.a.i();
                    i = (z || !aoc.a.i()) ? 0 : 1;
                    if (objArr != false || i != 0) {
                        hookParam3.setResult(Boolean.FALSE);
                    }
                }
                return kotlinUnitVar;
            case 14:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new amb(15);
                return kotlinUnitVar;
            case 15:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.usingStrings("MicroMsg.BaseSceneSetting" /* "MicroMsg.BaseSceneSetting" /* "MicroMsg.BaseSceneSetting" /* cnb.z(-444245647293226L)  */,
                        "playSound Failed Throwable t = " /* "playSound Failed Throwable t = " /* "playSound Failed Throwable t = " /* cnb.z(-444700913826602L)  */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 16:
                ((HookParam) obj).setResult(null);
                return kotlinUnitVar;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new amb(i2);
                return kotlinUnitVar;
            case 18:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* cnb.z(-446388835973930L)  */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("MicroMsg.SignallingComponent" /* "MicroMsg.SignallingComponent" /* "MicroMsg.SignallingComponent" /* cnb.z(-446212742314794L)  */,
                        "[doDirectSend] mChattingContext is null!" /* "[doDirectSend] mChattingContext is null!" /* "[doDirectSend] mChattingContext is null!" /* cnb.z(-445572792187690L)  */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return kotlinUnitVar;
            case 19:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new amb(20);
                return kotlinUnitVar;
            case 20:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("ModelImage.DownloadImgService" /* "ModelImage.DownloadImgService" /* "ModelImage.DownloadImgService" /* cnb.z(-119138097822506L)  */,
                        "cancelNetScene reset curTaskInfo (%s %s %s)" /* "cancelNetScene reset curTaskInfo (%s %s %s)" /* "cancelNetScene reset curTaskInfo (%s %s %s)" /* cnb.z(-120641336376106L)  */);
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 21:
                HookParam hookParam4 = (HookParam) obj;
                hookParam4.getClass();
                try {
                    objX6 = hookParam4.getArgs()[0];
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
                Iterator it = aqw.b.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    try {
                        throw null;
                    } catch (Exception e) {
                        ArrayList arrayList2 = Logger.a;
                        Logger.logE("onGetDynamicConfig "
                                /* "onGetDynamicConfig " /* "onGetDynamicConfig " /* cnb.z(-36880884169514L)  */ + "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-37379100375850L)  */
                                + " Failed" /* " Failed" /* " Failed" /* cnb.z(-37288906062634L)  */, e, 12);
                    }
                }
                return kotlinUnitVar;
            case 22:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar2 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar2.onClassCallback = new amb(23);
                findDexClassMethodDslWrapperVar2.onMethodCallback = new amb(24);
                return kotlinUnitVar;
            case 23:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.DynamicConfig" /* "MicroMsg.DynamicConfig" /* "MicroMsg.DynamicConfig" /* cnb.z(-37254546324266L)  */,
                        "update dynacfg. increment:%b, md5:%s" /* "update dynacfg. increment:%b, md5:%s" /* "update dynacfg. increment:%b, md5:%s" /* cnb.z(-37207301684010L)  */);
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 24:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar5 = new DexFinder();
                cls = String.class;
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf == null) {
                    clsBf = cls;
                }
                cdjVar5.r(clsBf);
                Class<String> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar5.q(clsBf2 != null ? clsBf2 : String.class);
                cdjVar5.usingStrings("MicroMsg.DynamicConfig" /* "MicroMsg.DynamicConfig" /* "MicroMsg.DynamicConfig" /* cnb.z(-36481452210986L)  */, "DynamicConfig hadnot load" /*
                                                                                                               * cnb.z(-
                                                                                                               * 36365488093994L)
                                                                                                               */);
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return kotlinUnitVar;
            case 25:
                obj.getClass();
                throw new ClassCastException();
            case 26:
                return Boolean.valueOf(!((arx) obj).a);
            case 27:
                return Boolean.valueOf(((dim) obj).a == 2);
            case 28:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new amb(29);
                return kotlinUnitVar;
            default:
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.feature.emoji" /* "com.tencent.mm.feature.emoji" /* "com.tencent.mm.feature.emoji" /* cnb.z(-361997023574826L)  */ };
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.strings = SomeStaticHelpers.arrayToList(strArr3);
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.EmojiFeatureService" /* "MicroMsg.EmojiFeatureService" /* "MicroMsg.EmojiFeatureService" /* cnb.z(-361906829261610L)  */,
                        "[onAccountInitialized]" /* "[onAccountInitialized]" /* "[onAccountInitialized]" /* cnb.z(-361765095340842L)  */, "onAccountRelease: " /*
                                                                                                       * cnb.z(-
                                                                                                       * 362198887037738L)
                                                                                                       */);
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
                return kotlinUnitVar;
        }
    }
}
