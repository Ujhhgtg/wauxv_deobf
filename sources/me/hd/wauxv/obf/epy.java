package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.google.android.material.slider.Slider;
import com.umeng.commonsdk.UMConfigure;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.R;
import me.hd.wauxv.hook.core.p000native.LoaderNative;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpUtils;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class epy implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ epy(int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:167:0x06be */
    /* JADX WARN: Found duplicated region for block: B:173:0x06ca */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        Class cls;
        Class cls2;
        Object objX;
        Class cls3;
        Object objX2;
        bcm bcmVar;
        String strI;
        Class cls4;
        Object objX3;
        int i = this.a;
        int i2 = 7;
        Class cls5 = Integer.TYPE;
        cls = Context.class;
        int i3 = 5;
        cls2 = String.class;
        char c = 0;
        z = false;
        z = false;
        boolean z = false;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t((cnb.ab(ewk.l) || cnb.ac(ewh.m)) ? "MicroMsg.C2CVideoPathFeatureService"
                        /* "MicroMsg.C2CVideoPathFeatureService" /* "MicroMsg.C2CVideoPathFeatureService" /* cnb.z(-374581277752106L)  */ : "MicroMsg.VideoInfoStorage" /* "MicroMsg.VideoInfoStorage" /* "MicroMsg.VideoInfoStorage" /* cnb.z(-374392299191082L)  */,
                        ".mp4" /* ".mp4" /* ".mp4" /* cnb.z(-374847565724458L)  */, "success restore file, from " /*
                                                                                              * "success restore file, from " /* "success restore file, from " /* cnb.z(-374860450626346L)  */
                                                                                              */);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 1:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t((cnb.ab(ewk.l) || cnb.ac(ewh.m)) ? "MicroMsg.C2CVideoPathFeatureService"
                        /* "MicroMsg.C2CVideoPathFeatureService" /* "MicroMsg.C2CVideoPathFeatureService" /* cnb.z(-374705831803690L)  */ : "MicroMsg.VideoInfoStorage" /* "MicroMsg.VideoInfoStorage" /* "MicroMsg.VideoInfoStorage" /* cnb.z(-374035816905514L)  */,
                        ".jpg" /* ".jpg" /* ".jpg" /* cnb.z(-373872608148266L)  */, "success restore file, from " /*
                                                                                              * "success restore file, from " /* "success restore file, from " /* cnb.z(-373902672919338L)  */
                                                                                              */);
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return kotlinUnitVar;
            case 2:
                View view = (View) obj;
                cee ceeVarE = cee.e(LayoutInflater.from(view.getContext()));
                ceeVarE.c.setText(eta.a.o());
                bzy bzyVar = new bzy(view.getContext());
                VnHomeShareMenuCopyOrDownHook.a.getClass();
                String str = VnHomeShareMenuCopyOrDownHook.h;
                eg egVar = (eg) bzyVar.d;
                egVar.d = str;
                LinearLayout linearLayout = ceeVarE.b;
                bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-588457764191018L)  */, new amw(new aul(ceeVarE, 3), 0));
                bzyVar.s("重置" /* "重置" /* "重置" /* cnb.z(-588479239027498L)  */, new amw(new efq(15), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return kotlinUnitVar;
            case 3:
                View view2 = (View) obj;
                cee ceeVarE2 = cee.e(LayoutInflater.from(view2.getContext()));
                ceeVarE2.c.setText(etf.a.o());
                bzy bzyVar2 = new bzy(view2.getContext());
                VnPreviewShareMenuCopyOrDownHook.a.getClass();
                String str2 = VnPreviewShareMenuCopyOrDownHook.h;
                eg egVar2 = (eg) bzyVar2.d;
                egVar2.d = str2;
                LinearLayout linearLayout2 = ceeVarE2.b;
                bzyVar2.t("保存" /* "保存" /* "保存" /* cnb.z(-610237543349034L)  */, new amw(new aul(ceeVarE2, 4), 0));
                bzyVar2.s("重置" /* "重置" /* "重置" /* cnb.z(-610241838316330L)  */, new amw(new efq(16), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout2 != null) {
                    egVar2.r = linearLayout2;
                }
                bzyVar2.i().show();
                return kotlinUnitVar;
            case 4:
                View view3 = (View) obj;
                View viewK = StaticHelpers6.k(view3, R.layout.module_dialog_voice_length, null, false);
                Slider slider = (Slider) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogSliderVoiceLength);
                if (slider == null) {
                    throw new NullPointerException(
                            "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-660016214309674L)  */.concat(
                                    viewK.getResources().getResourceName(R.id.moduleDialogSliderVoiceLength)));
                }
                LinearLayout linearLayout3 = (LinearLayout) viewK;
                ceq ceqVar = new ceq(linearLayout3, slider, 1);
                slider.setValue(etq.a.k());
                bzy bzyVar3 = new bzy(view3.getContext());
                eg egVar3 = (eg) bzyVar3.d;
                etr.a.getClass();
                egVar3.d = etr.c;
                bzyVar3.t("保存" /* "保存" /* "保存" /* cnb.z(-500054452337450L)  */, new amw(new cfx(ceqVar, 20), 0));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout3 != null) {
                    egVar3.r = linearLayout3;
                }
                bzyVar3.i().show();
                return kotlinUnitVar;
            case 5:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new epy(i2);
                return kotlinUnitVar;
            case 6:
                HookParam hookParam = (HookParam) obj;
                if (hookParam.getArgs().length == 1) {
                    objX = hookParam.getArgs()[c];
                    if (objX == null) {
                        objX = null;
                    }
                    if (objX instanceof Failure) {
                    }
                    throwIfVar1IsNull(obj);
                    int i4 = 0;
                    FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).r();
                    fieldResolverVarR.name = "l" /* "l" /* "l" /* cnb.z(-500058747304746L)  */;
                    fieldResolverVarR.fieldType = dal.getKClassFromClass(cls5);
                    ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).setValue(Integer.valueOf(etq.a.k() * 1000));
                } else if (hookParam.getArgs().length == 2 && (hookParam.getArgs()[0] instanceof String)) {
                    c = 1;
                    try {
                        objX = hookParam.getArgs()[c];
                        if (objX == null) {
                            objX = null;
                        }
                    } catch (Throwable th) {
                        objX = FastKV.getFailureFromException(th);
                    }
                    Object obj2 = objX instanceof Failure ? null : objX;
                    throwIfVar1IsNull(obj2);
                    int i42 = 0;
                    FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(obj2).r();
                    fieldResolverVarR2.name = "l" /* "l" /* "l" /* cnb.z(-500058747304746L)  */;
                    fieldResolverVarR2.fieldType = dal.getKClassFromClass(cls5);
                    ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).setValue(Integer.valueOf(etq.a.k() * 1000));
                }
                return kotlinUnitVar;
            case 7:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdjVar3.t("MicroMsg.VoiceStorage" /* "MicroMsg.VoiceStorage" /* "MicroMsg.VoiceStorage" /* cnb.z(-500067337239338L)  */, "update failed, no values set" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 499405912275754L)
                                                                                                                  */);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return kotlinUnitVar;
            case 8:
                List list = (List) obj;
                Object obj3 = list.get(0);
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                if (nullSafeIsEqual(obj3, clsBf != null ? clsBf : String.class)) {
                    Object obj4 = list.get(1);
                    cls3 = Integer.class;
                    Class<Integer> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                    if (clsBf2 == null) {
                        clsBf2 = cls3;
                    }
                    if (nullSafeIsEqual(obj4, clsBf2)) {
                        Object obj5 = list.get(2);
                        Class<Integer> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                        if (nullSafeIsEqual(obj5, clsBf3 != null ? clsBf3 : Integer.class)) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 9:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new epy(12);
                return kotlinUnitVar;
            case 10:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new epy(11);
                return kotlinUnitVar;
            case 11:
                bah bahVar4 = (bah) obj;
                cdj cdjVar4 = new cdj();
                cdjVar4.t("getAmrFullPath cost: " /* "getAmrFullPath cost: " /* "getAmrFullPath cost: " /* cnb.z(-107348412594986L)  */);
                bahVar4.getClass();
                bahVar4.d = cdjVar4;
                return kotlinUnitVar;
            case 12:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k("MicroMsg.VoiceLogic" /* "MicroMsg.VoiceLogic" /* "MicroMsg.VoiceLogic" /* cnb.z(-105939663321898L)  */,
                        "startRecord insert voicestg success" /* "startRecord insert voicestg success" /* "startRecord insert voicestg success" /* cnb.z(-105888123714346L)  */);
                bagVar.getClass();
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 13:
                View view4 = (View) obj;
                cee ceeVarE3 = cee.e(LayoutInflater.from(view4.getContext()));
                ceeVarE3.c.setText(etv.a.o());
                bzy bzyVar4 = new bzy(view4.getContext());
                etw.a.getClass();
                String str3 = etw.h;
                eg egVar4 = (eg) bzyVar4.d;
                egVar4.d = str3;
                LinearLayout linearLayout4 = ceeVarE3.b;
                bzyVar4.t("保存" /* "保存" /* "保存" /* cnb.z(-520404007385898L)  */, new amw(new aul(ceeVarE3, 5), 0));
                bzyVar4.s("重置" /* "重置" /* "重置" /* cnb.z(-520408302353194L)  */, new amw(new efq(17), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar4, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout4 != null) {
                    egVar4.r = linearLayout4;
                }
                bzyVar4.i().show();
                return kotlinUnitVar;
            case 14:
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
                Context baseContext = ((Application) objX2).getBaseContext();
                eui euiVar = eui.a;
                euiVar.getClass();
                HugeSyntheticPileOfHelpers.bh(baseContext);
                HostInfoRegistry hostInfoRegistryVar = HostInfoRegistry.INSTANCE;
                String str4 = exm.i;
                hostInfoRegistryVar.getClass();
                LateinitProperty lateinitPropertyVar = HostInfoRegistry.modulePath;
                IEmpty7[] btcVarArr = HostInfoRegistry.b;
                lateinitPropertyVar.i(btcVarArr[0], str4);
                HostInfoRegistry.appContext.i(btcVarArr[1], baseContext);
                HostInfoRegistry.appPackageName.i(btcVarArr[2], baseContext.getPackageName());
                HostInfoRegistry.appClassLoader.i(btcVarArr[3], baseContext.getClassLoader());
                HostInfoRegistry.appFilePath.i(btcVarArr[4], baseContext.getApplicationInfo().sourceDir);
                HostInfoRegistry.appName.i(btcVarArr[5], baseContext.getPackageManager()
                        .getApplicationLabel(baseContext.getApplicationInfo()).toString());
                int i5 = 0;
                SyntheticPileOfMess bmuVarS = yg.s(-28930899704618L);
                FieldResolver fieldResolverVarR3 = bmuVarS.r();
                fieldResolverVarR3.name = "VERSION_NAME" /* "VERSION_NAME" /* "VERSION_NAME" /* cnb.z(-30442728192810L)  */;
                Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).getValue_();
                throwIfVar1IsNull(objE);
                LateinitProperty lateinitPropertyVar2 = HostInfoRegistry.verName;
                lateinitPropertyVar2.i(btcVarArr[6], (String) objE);
                FieldResolver fieldResolverVarR4 = bmuVarS.r();
                fieldResolverVarR4.name = "VERSION_CODE" /* "VERSION_CODE" /* "VERSION_CODE" /* cnb.z(-30352533879594L)  */;
                Object objE2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).getValue_();
                throwIfVar1IsNull(objE2);
                HostInfoRegistry.verCode.i(btcVarArr[7], Integer.valueOf(((Number) objE2).intValue()));
                FieldResolver fieldResolverVarR5 = bmuVarS.r();
                fieldResolverVarR5.name = "CLIENT_VERSION_ARM64" /* "CLIENT_VERSION_ARM64" /* "CLIENT_VERSION_ARM64" /* cnb.z(-30279519435562L)  */;
                Object objE3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR5.resolve())).getValue_();
                throwIfVar1IsNull(objE3);
                LateinitProperty lateinitPropertyVar3 = HostInfoRegistry.verClient;
                lateinitPropertyVar3.i(btcVarArr[8], (String) objE3);
                FieldResolver fieldResolverVarR6 = bmuVarS.r();
                fieldResolverVarR6.name = "BUILD_TAG" /* "BUILD_TAG" /* "BUILD_TAG" /* cnb.z(-30773440674602L)  */;
                Object objE4 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR6.resolve())).getValue_();
                throwIfVar1IsNull(objE4);
                HostInfoRegistry.isPlay.i(btcVarArr[9],
                        Boolean.valueOf(dnj.ab((CharSequence) objE4, "_GP_" /* "_GP_" /* "_GP_" /* cnb.z(-30747670870826L)  */, false)));
                ResourcesCompat resourcesCompatVar = anj.a;
                ng.af(baseContext);
                anj.g = 3;
                anj.a = new caw(1);
                anj.h = 2;
                ckv.b = "";
                ckv.a = baseContext;
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.connectTimeout(30L, timeUnit);
                builder.readTimeout(30L, timeUnit);
                builder.writeTimeout(30L, timeUnit);
                cqi.a(builder);
                OkHttpClient okHttpClientBuild = builder.build();
                throwIfVar1IsNull(okHttpClientBuild, "value");
                List<Interceptor> listInterceptors = okHttpClientBuild.interceptors();
                cld cldVar = cld.a;
                if (!listInterceptors.contains(cldVar)) {
                    okHttpClientBuild = okHttpClientBuild.newBuilder().addInterceptor(cldVar).build();
                }
                ckv.c = okHttpClientBuild;
                Cache cache = okHttpClientBuild.cache();
                if (cache != null) {
                    DiskLruCache diskLruCache = OkHttpUtils.diskLruCache(cache);
                    throwIfVar1IsNull(diskLruCache, "diskLruCache(it)");
                    bcmVar = new bcm(diskLruCache);
                } else {
                    bcmVar = null;
                }
                ckv.d = bcmVar;
                HugeSyntheticPileOfHelpers.ah = new DefaultConfig(baseContext, "WAuxiliary_config_default" /* "WAuxiliary_config_default" /* "WAuxiliary_config_default" /* cnb.z(-5665061862186L)  */);
                emc.config = new DefaultConfig(baseContext, "WAuxiliary_config_dex_desc" /* "WAuxiliary_config_dex_desc" /* "WAuxiliary_config_dex_desc" /* cnb.z(-5922759899946L)  */);
                bhs.config = new DefaultConfig(baseContext, "WAuxiliary_config_plugin" /* "WAuxiliary_config_plugin" /* "WAuxiliary_config_plugin" /* cnb.z(-29274497088298L)  */);
                csc cscVar = euiVar.processInfo;
                if (cscVar != null) {
                    strI = cscVar.packageName;
                } else {
                    ki.a.getClass();
                    strI = ki.i();
                }
                if (euiVar.getCurrentProcessName().equals(dnj.ba(strI).toString())) {
                    UMConfigure.preInit(baseContext, "68393b1dbc47b67d83776862" /* "68393b1dbc47b67d83776862" /* "68393b1dbc47b67d83776862" /* cnb.z(-72438918413098L)  */, HostInfoRegistry.getAppName());
                    ArrayList arrayList = Logger.a;
                    Logger.logD(14, "running on: Android" /* "running on: Android" /* "running on: Android" /* cnb.z(-81728932674346L)  */ + Build.VERSION.RELEASE
                            + SignatureVisitor.SUPER + HostInfoRegistry.getVersionString());
                    Logger.logD(14, "loading module: WAuxiliary1.2.6.r1238.198c77c" /* "loading module: WAuxiliary1.2.6.r1238.198c77c" /* "loading module: WAuxiliary1.2.6.r1238.198c77c" /* cnb.z(-83257941031722L)  */);
                    StringBuilder sb = new StringBuilder();
                    sb.append("compile timestamp: " /* "compile timestamp: " /* "compile timestamp: " /* cnb.z(-83111912143658L)  */);
                    sb.append(exl.c);
                    Logger.logD(14, sb.toString());
                    System.loadLibrary("wauxv-core" /* "wauxv-core" /* "wauxv-core" /* cnb.z(-83541408873258L)  */);
                    LoaderNative.a.loaderInit((String) lateinitPropertyVar.h(btcVarArr[0]),
                            baseContext.getDataDir().getAbsolutePath(), HostInfoRegistry.getIsPlay(), (String) lateinitPropertyVar2.h(btcVarArr[6]),
                            HostInfoRegistry.getVerCode(), (String) lateinitPropertyVar3.h(btcVarArr[8]));
                    Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
                    cnh.g = PathUtils.getModuleSubDir("Cache" /* "Cache" /* "Cache" /* cnb.z(-47098611366698L)  */);
                    String str5 = cnh.g;
                    if (str5 == null) {
                        throw new IllegalArgumentException(
                                "AudioUtil must be init" /* "AudioUtil must be init" /* "AudioUtil must be init" /* cnb.z(-375221227879210L)  */.toString());
                    }
                    File file = new File(str5);
                    if (!file.exists() && !file.mkdirs()) {
                        throw new IOException("init: 缓存目录创建失败" /* "init: 缓存目录创建失败" /* "init: 缓存目录创建失败" /* cnb.z(-398761943628586L)  */);
                    }
                    if (!file.canWrite()) {
                        throw new IOException("init: 缓存目录无写入权限" /* "init: 缓存目录无写入权限" /* "init: 缓存目录无写入权限" /* cnb.z(-398680339249962L)  */);
                    }
                    if (!eui.c()) {
                        euh euhVar = new euh(3, null);
                        MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.ui.LauncherUI" /* "com.tencent.mm.ui.LauncherUI" /* "com.tencent.mm.ui.LauncherUI" /* cnb.z(-83528523971370L)  */)).getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT.name = "onCreate" /* "onCreate" /* "onCreate" /* cnb.z(-83369610181418L)  */;
                        HookManager hookManagerVarAd = euiVar.createImmediateHook((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods()), HookPriorityEnum.ENUM_DEFAULT);
                        hookManagerVarAd.m(new bka(hookManagerVarAd, i3, euhVar));
                        hookManagerVarAd.initInstantCollectionAndApplyHooks();
                    }
                }
                if (eui.c()) {
                    eui.d();
                }
                return kotlinUnitVar;
            case 15:
                HookParam hookParam3 = (HookParam) obj;
                Object obj6 = ((bmh) hookParam3.b.b).b.thisObject;
                if (nullSafeIsEqual(obj6 != null ? obj6.getClass() : null, ajn.tryGetClassByClassName(
                        "com.tencent.mm.plugin.setting.ui.setting_new.MainSettingsUI" /* "com.tencent.mm.plugin.setting.ui.setting_new.MainSettingsUI" /* "com.tencent.mm.plugin.setting.ui.setting_new.MainSettingsUI" /* cnb.z(-58080842742570L)  */))) {
                    Object objE5 = hookParam3.getThisObject();
                    Activity activity = (Activity) (objE5 instanceof Activity ? objE5 : null);
                    if (activity == null) {
                        cls4 = Activity.class;
                        Class<Activity> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                        throw new IllegalStateException("HookParam instance cannot cast to "
                                .concat((clsBf4 != null ? clsBf4 : Activity.class).getName()).toString());
                    }
                    euj eujVar = euj.a;
                    String strZ = "WA" /* "WA" /* "WA" /* cnb.z(-57307748629290L)  */;
                    ars arsVar = new ars(activity, 2);
                    eujVar.getClass();
                    int i6 = 0;
                    MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(activity).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT2.name = "addTextOptionMenu" /* "addTextOptionMenu" /* "addTextOptionMenu" /* cnb.z(-57956288690986L)  */;
                    methodResolverVarT2.setParams(Arrays.copyOf(
                            new Object[] { dal.getKClassFromClass(cls5), dal.getKClassFromClass(cls2), dal.getKClassFromClass(MenuItem.OnMenuItemClickListener.class) },
                            3));
                    methodResolverVarT2.enableSuperclass();
                    ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).e(Integer.valueOf(R.id.Wauxv_Entry_Item), strZ, arsVar);
                }
                return kotlinUnitVar;
            case 16:
                StaticHelpers7.ax((Context) obj);
                return kotlinUnitVar;
            case 17:
                Object objE6 = ((HookParam) obj).getThisObject();
                Context context = (Context) (objE6 instanceof Context ? objE6 : null);
                if (context == null) {
                    Class<Context> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf5 != null ? clsBf5 : Context.class).getName()).toString());
                }
                int i7 = 0;
                FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(context).r();
                fieldResolverVarR7.name = "adapter" /* "adapter" /* "adapter" /* cnb.z(-58918361365290L)  */;
                Object objE7 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR7)).getValue_();
                throwIfVar1IsNull(objE7);
                BaseAdapter baseAdapter = (BaseAdapter) objE7;
                for (euk eukVar : eul.b) {
                    cnb.m(baseAdapter, cnb.y(context, eukVar.a, eukVar.b), 0);
                }
                return kotlinUnitVar;
            default:
                HookParam hookParam4 = (HookParam) obj;
                Object objE8 = hookParam4.getThisObject();
                if (!(objE8 instanceof Context)) {
                    objE8 = null;
                }
                Context context2 = (Context) objE8;
                if (context2 == null) {
                    Class<Context> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf6 != null ? clsBf6 : Context.class).getName()).toString());
                }
                try {
                    objX3 = hookParam4.getArgs()[1];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = FastKV.getFailureFromException(th3);
                }
                Object obj7 = objX3 instanceof Failure ? null : objX3;
                throwIfVar1IsNull(obj7);
                int i8 = 0;
                FieldResolver fieldResolverVarR8 = dqc.getWrapperConfiguration(obj7).r();
                fieldResolverVarR8.fieldType = dal.getKClassFromClass(cls2);
                fieldResolverVarR8.enableSuperclass();
                Iterator it = fieldResolverVarR8.resolve().iterator();
                while (it.hasNext()) {
                    String str6 = (String) ((BoundField) it.next()).getValue_();
                    if (str6 != null) {
                        for (euk eukVar2 : eul.b) {
                            if (str6.equals(eukVar2.a)) {
                                eukVar2.c.invoke(context2);
                                hookParam4.setResultTrue();
                            }
                        }
                    }
                }
                return kotlinUnitVar;
        }
    }
}
