package me.hd.wauxv.obf;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.hd.wauxv.R;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class gi implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ gi(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v148 */
    /* JADX WARN: Type inference failed for: r0v168 */
    /* JADX WARN: Type inference failed for: r0v169 */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, JSONException, NoSuchMethodException, InvocationTargetException {
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        ?? r0;
        Class cls;
        int i = this.a;
        int i2 = 8;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        switch (i) {
            case 0:
                ((bmm) obj).h(null);
                return kotlinUnitVar;
            case 1:
                HookParam hookParam = (bmm) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.d()[0];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                if (objX != null) {
                    int i3 = 0;
                    cde cdeVarT = dqc.bi(objX).t();
                    cdeVarT.a = dal.b(Integer.TYPE);
                    Object objJ = ((MethodHookWrapper) dkz.m(cdeVarT)).j(new Object[0]);
                    throwIfVar1IsNull(objJ);
                    switch (((Number) objJ).intValue()) {
                        case 61:
                        case 62:
                        case 63:
                            new ek(hookParam, 0, 8).q(null);
                        default:
                            return kotlinUnitVar;
                    }
                }
                return kotlinUnitVar;
            case 2:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new gi(5);
                findDexClassMethodDslWrapperVar.onMethodCallback = new gi(6);
                return kotlinUnitVar;
            case 3:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(i2);
                return kotlinUnitVar;
            case 4:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(7);
                return kotlinUnitVar;
            case 5:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k("MicroMsg.OplogService" /* "MicroMsg.OplogService" /* "MicroMsg.OplogService" /* "MicroMsg.OplogService" /* cnb.z(-636810506009386L)   */, "openim op success, type:%d id %d" /* "openim op success, type:%d id %d" /* "openim op success, type:%d id %d" /* "openim op success, type:%d id %d" /* cnb.z(-636698836859690L)   */);
                bagVar.getClass();
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 6:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t("inserTime" /* "inserTime" /* "inserTime" /* "inserTime" /* cnb.z(-637124038621994L)   */, "cmdId" /* "cmdId" /* "cmdId" /* "cmdId" /* cnb.z(-637098268818218L)   */, "buffer" /* "buffer" /* "buffer" /* "buffer" /* cnb.z(-637055319145258L)   */);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 7:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t("MicroMsg.SecInfoReporterImpl" /* "MicroMsg.SecInfoReporterImpl" /* "MicroMsg.SecInfoReporterImpl" /* "MicroMsg.SecInfoReporterImpl" /* cnb.z(-634108971580202L)   */, "data is null." /* "data is null." /* "data is null." /* "data is null." /* cnb.z(-633950057790250L)   */);
                cdjVar2.u(8108);
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return kotlinUnitVar;
            case 8:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdjVar3.t("MicroMsg.SecInfoReporterImpl" /* "MicroMsg.SecInfoReporterImpl" /* "MicroMsg.SecInfoReporterImpl" /* "MicroMsg.SecInfoReporterImpl" /* cnb.z(-637008074505002L)   */, "data is null." /* "data is null." /* "data is null." /* "data is null." /* cnb.z(-634117561514794L)   */);
                cdjVar3.u(771);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return kotlinUnitVar;
            case 9:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(10);
                return kotlinUnitVar;
            case 10:
                bah bahVar4 = (bah) obj;
                String[] strArr = {"com.tencent.mm.ui.chatting.manager" /* "com.tencent.mm.ui.chatting.manager" /* "com.tencent.mm.ui.chatting.manager" /* "com.tencent.mm.ui.chatting.manager" /* cnb.z(-100351910869802L)   */};
                bahVar4.getClass();
                bahVar4.a = SomeStaticHelpers.ab(strArr);
                cdj cdjVar4 = new cdj();
                cdjVar4.t("[get] " /* "[get] " /* "[get] " /* "[get] " /* cnb.z(-97418448206634L)   */, " is not a interface!" /* " is not a interface!" /* " is not a interface!" /* " is not a interface!" /* cnb.z(-97439923043114L)   */);
                bahVar4.d = cdjVar4;
                return kotlinUnitVar;
            case 11:
                HookParam hookParam2 = (bmm) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.d()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                try {
                    objX3 = hookParam2.d()[1];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                String str = (String) (objX3 instanceof dcx ? null : objX3);
                JSONObject jSONObject = new JSONObject(str != null ? str : "");
                if (nullSafeIsEqual(jSONObject.get("api_name" /* "api_name" /* "api_name" /* "api_name" /* cnb.z(-412488659106602L)   */), "webapi_getadvert" /* "webapi_getadvert" /* "webapi_getadvert" /* "webapi_getadvert" /* cnb.z(-412450004400938L)   */)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data" /* "data" /* "data" /* "data" /* cnb.z(-412325450349354L)   */);
                    jSONObject2.put("ad_unit_id" /* "ad_unit_id" /* "ad_unit_id" /* "ad_unit_id" /* cnb.z(-412338335251242L)   */, "" /* "" /* "" /* "" /* cnb.z(-412806486686506L)   */);
                    jSONObject.put("data" /* "data" /* "data" /* "data" /* cnb.z(-412802191719210L)   */, jSONObject2);
                    new ek(hookParam2, 1, 8).q(jSONObject.toString());
                }
                return kotlinUnitVar;
            case 12:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(13);
                return kotlinUnitVar;
            case 13:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cdjVar5.v("NetSceneJSOperateWxData" /* "NetSceneJSOperateWxData" /* "NetSceneJSOperateWxData" /* "NetSceneJSOperateWxData" /* cnb.z(-412832256490282L)   */, "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]  sessionId [%s]  avatarOpt [%d]" /* "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]  sessionId [%s]  avatarOpt [%d]" /* "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]  sessionId [%s]  avatarOpt [%d]" /* "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]  sessionId [%s]  avatarOpt [%d]" /* cnb.z(-412729177275178L)   */);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return kotlinUnitVar;
            case 14:
                ((bmm) obj).h(null);
                return kotlinUnitVar;
            case 15:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(16);
                return kotlinUnitVar;
            case 16:
                bah bahVar6 = (bah) obj;
                String[] strArr2 = {"com.tencent.mm.plugin.appbrand.jsapi.auth" /* "com.tencent.mm.plugin.appbrand.jsapi.auth" /* "com.tencent.mm.plugin.appbrand.jsapi.auth" /* "com.tencent.mm.plugin.appbrand.jsapi.auth" /* cnb.z(-409525131672362L)   */};
                bahVar6.getClass();
                bahVar6.a = SomeStaticHelpers.ab(strArr2);
                cdj cdjVar6 = new cdj();
                cdjVar6.t("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]" /* "MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]" /* "MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]" /* "MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]" /* cnb.z(-409361922915114L)   */, "cgi callback, callbackId:%s, service not running or preloaded" /* "cgi callback, callbackId:%s, service not running or preloaded" /* "cgi callback, callbackId:%s, service not running or preloaded" /* "cgi callback, callbackId:%s, service not running or preloaded" /* cnb.z(-410766377220906L)   */);
                bahVar6.d = cdjVar6;
                return kotlinUnitVar;
            case 17:
                HookParam hookParam3 = (bmm) obj;
                hookParam3.getClass();
                try {
                    objX4 = hookParam3.d()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                if (objX4 instanceof dcx) {
                    objX4 = null;
                }
                String str2 = (String) objX4;
                String str3 = str2 == null ? "" : str2;
                try {
                    objX5 = hookParam3.d()[1];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                String str4 = (String) (objX5 instanceof dcx ? null : objX5);
                String str5 = str4 != null ? str4 : "";
                if (str3.equals("onVideoTimeUpdate" /* "onVideoTimeUpdate" /* "onVideoTimeUpdate" /* "onVideoTimeUpdate" /* cnb.z(-434173948984106L)   */)) {
                    ek ekVar = new ek(hookParam3, 1, 8);
                    JSONObject jSONObject3 = new JSONObject(str5);
                    jSONObject3.put("position" /* "position" /* "position" /* "position" /* cnb.z(-434113819441962L)   */, 60);
                    jSONObject3.put("duration" /* "duration" /* "duration" /* "duration" /* cnb.z(-434092344605482L)   */, 1);
                    ekVar.q(jSONObject3.toString());
                }
                return kotlinUnitVar;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new gi(19);
                return kotlinUnitVar;
            case 19:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                zbVar2.k("MicroMsg.AppMessage" /* "MicroMsg.AppMessage" /* "MicroMsg.AppMessage" /* "MicroMsg.AppMessage" /* cnb.z(-107103599459114L)   */, "parse msg failed" /* "parse msg failed" /* "parse msg failed" /* "parse msg failed" /* cnb.z(-107052059851562L)   */);
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(21);
                return kotlinUnitVar;
            case 21:
                bah bahVar7 = (bah) obj;
                String[] strArr3 = {"com.tencent.mm.pluginsdk.model.app" /* "com.tencent.mm.pluginsdk.model.app" /* "com.tencent.mm.pluginsdk.model.app" /* "com.tencent.mm.pluginsdk.model.app" /* cnb.z(-120147415137066L)   */};
                bahVar7.getClass();
                bahVar7.a = SomeStaticHelpers.ab(strArr3);
                cdj cdjVar7 = new cdj();
                cdjVar7.t("MicroMsg.AppMsgLogic" /* "MicroMsg.AppMsgLogic" /* "MicroMsg.AppMsgLogic" /* "MicroMsg.AppMsgLogic" /* cnb.z(-108469399059242L)   */, "summerbig sendAppMsg attachFilePath[%s], content[%s]" /* "summerbig sendAppMsg attachFilePath[%s], content[%s]" /* "summerbig sendAppMsg attachFilePath[%s], content[%s]" /* "summerbig sendAppMsg attachFilePath[%s], content[%s]" /* cnb.z(-108362024876842L)   */);
                bahVar7.d = cdjVar7;
                return kotlinUnitVar;
            case 22:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_auto_clean, null, false);
                int i4 = R.id.moduleDialogEdtAutoCleanCycle;
                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.aq(viewK, R.id.moduleDialogEdtAutoCleanCycle);
                if (textInputEditText != null) {
                    i4 = R.id.moduleDialogInputAutoCleanCycle;
                    if (((TextInputLayout) KotlinHelpers2.aq(viewK, R.id.moduleDialogInputAutoCleanCycle)) != null) {
                        i4 = R.id.moduleDialogRvAutoCleanConfig;
                        RecyclerView recyclerView = (RecyclerView) KotlinHelpers2.aq(viewK, R.id.moduleDialogRvAutoCleanConfig);
                        if (recyclerView != null) {
                            LinearLayout linearLayout = (LinearLayout) viewK;
                            cee ceeVar = new cee(linearLayout, textInputEditText, recyclerView);
                            textInputEditText.setText(String.valueOf(lu.a.l()));
                            view.getContext();
                            recyclerView.setLayoutManager(new GridLayoutManager());
                            zm zmVar = new zm(zo.c(), lt.a.n());
                            recyclerView.setAdapter(zmVar);
                            bzy bzyVar = new bzy(view.getContext());
                            eg egVar = (eg) bzyVar.d;
                            lx.a.getClass();
                            egVar.d = lx.c;
                            bzyVar.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-511139762928426L)   */, new amw(new ls(ceeVar, 0, zmVar), 0));
                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                            if (linearLayout != null) {
                                egVar.r = linearLayout;
                            }
                            bzyVar.i().show();
                            return kotlinUnitVar;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-641461955590954L)   */.concat(viewK.getResources().getResourceName(i4)));
            case 23:
                return Boolean.valueOf(lt.a.n().contains(((zn) obj).a));
            case 24:
                HookParam hookParam4 = (bmm) obj;
                hookParam4.getClass();
                try {
                    objX6 = hookParam4.d()[1];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                if (objX6 instanceof dcx) {
                    objX6 = null;
                }
                Boolean bool = (Boolean) objX6;
                if (!(bool != null ? bool.booleanValue() : false)) {
                    try {
                        objX7 = hookParam4.d()[0];
                        if (objX7 == null) {
                            objX7 = null;
                        }
                    } catch (Throwable th7) {
                        objX7 = bhu.x(th7);
                    }
                    Object obj2 = objX7 instanceof dcx ? null : objX7;
                    throwIfVar1IsNull(obj2);
                    int i5 = 0;
                    azg azgVarR = dqc.bi(obj2).r();
                    azgVarR.ab = "field_UserName" /* "field_UserName" /* "field_UserName" /* "field_UserName" /* cnb.z(-443841920367402L)   */;
                    Object objE = ((azk) yg.e(azgVarR)).e();
                    throwIfVar1IsNull(objE);
                    bcp.a.getClass();
                    Method methodBb = emn.bb(bco.a);
                    dgf.a.getClass();
                    methodBb.invoke(dgf.b(emn.bb(bcn.a).getDeclaringClass()), (String) objE);
                }
                return kotlinUnitVar;
            case 25:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new gi(26);
                return kotlinUnitVar;
            case 26:
                bah bahVar8 = (bah) obj;
                cdj cdjVar8 = new cdj();
                cdjVar8.t("MicroMsg.ForceNotifyStorage" /* "MicroMsg.ForceNotifyStorage" /* "MicroMsg.ForceNotifyStorage" /* "MicroMsg.ForceNotifyStorage" /* cnb.z(-443760315988778L)   */, "[onNewXmlReceived] ret:%s isAdd:%s info:%s" /* "[onNewXmlReceived] ret:%s isAdd:%s info:%s" /* "[onNewXmlReceived] ret:%s isAdd:%s info:%s" /* "[onNewXmlReceived] ret:%s isAdd:%s info:%s" /* cnb.z(-443674416642858L)   */);
                bahVar8.getClass();
                bahVar8.d = cdjVar8;
                return kotlinUnitVar;
            case 27:
                View view2 = (View) obj;
                View viewK2 = dkz.k(view2, R.layout.module_dialog_auto_login_win, null, false);
                int i6 = R.id.moduleDialogCbAutoLoginWinAutoLoginDevice;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.aq(viewK2, R.id.moduleDialogCbAutoLoginWinAutoLoginDevice);
                if (materialCheckBox != null) {
                    i6 = R.id.moduleDialogCbAutoLoginWinAutoSyncMsg;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.aq(viewK2, R.id.moduleDialogCbAutoLoginWinAutoSyncMsg);
                    if (materialCheckBox2 != null) {
                        i6 = R.id.moduleDialogCbAutoLoginWinShowLoginDevice;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) KotlinHelpers2.aq(viewK2, R.id.moduleDialogCbAutoLoginWinShowLoginDevice);
                        if (materialCheckBox3 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) viewK2;
                            cef cefVar = new cef(linearLayout2, materialCheckBox, materialCheckBox2, materialCheckBox3, 0);
                            materialCheckBox2.setChecked(mb.a.i());
                            materialCheckBox3.setChecked(mc.a.i());
                            materialCheckBox.setChecked(ma.a.i());
                            bzy bzyVar2 = new bzy(view2.getContext());
                            eg egVar2 = (eg) bzyVar2.d;
                            md.a.getClass();
                            egVar2.d = md.c;
                            bzyVar2.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-512346648738602L)   */, new amw(new bp(cefVar, 4), 0));
                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                            if (linearLayout2 != null) {
                                egVar2.r = linearLayout2;
                            }
                            bzyVar2.i().show();
                            return kotlinUnitVar;
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-641324516637482L)   */.concat(viewK2.getResources().getResourceName(i6)));
            case 28:
                Object objE2 = ((bmm) obj).e();
                Activity activity = (Activity) (objE2 instanceof Activity ? objE2 : null);
                if (activity == null) {
                    cls = Activity.class;
                    Class<Activity> clsBf = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf != null ? clsBf : Activity.class).getName()).toString());
                }
                boolean zI = mb.a.i();
                if (mc.a.i()) {
                    r0 = zI;
                    r0 = (zI ? 1 : 0) | 2;
                }
                r0 = zI;
                int i7 = r0;
                if (ma.a.i()) {
                    i7 = (r0 == true ? 1 : 0) | 4;
                }
                activity.getIntent().putExtra("intent.key.function.control" /* "intent.key.function.control" /* "intent.key.function.control" /* "intent.key.function.control" /* cnb.z(-512350943705898L)   */, i7);
                return kotlinUnitVar;
            default:
                int i8 = 0;
                azg azgVarAa = dkz.aa((bmm) obj);
                azgVarAa.a = dal.b(Button.class);
                Object objE3 = ((azk) aaz.e(azgVarAa.c())).e();
                throwIfVar1IsNull(objE3);
                ((Button) objE3).callOnClick();
                return kotlinUnitVar;
        }
    }
}
