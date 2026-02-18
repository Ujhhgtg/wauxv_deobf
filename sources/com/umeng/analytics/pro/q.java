package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class q {
    private static Context a = null;
    private static final String l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";
    private static final String x = "com.umeng.umcrash.UMCrashUtils";
    private static Class<?> y;
    private static Method z;
    private c b;
    private SharedPreferences c;
    private String d;
    private String e;
    private int f;
    private JSONArray g;
    private final int h;
    private int i;
    private int j;
    private long k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;
        public static final int a = 4097;
        public static final int b = 4098;
        public static final int c = 4099;
        public static final int d = 4100;
        public static final int e = 4101;
        public static final int f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;
        public static final int l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 4356;
        public static final int p = 4357;
        public static final int q = 4358;
        public static final int r = 8193;
        public static final int s = 8194;
        public static final int t = 8195;
        public static final int u = 8196;
        public static final int v = 8197;
        public static final int w = 8199;
        public static final int x = 8200;
        public static final int y = 8201;
        public static final int z = 8208;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class b {
        private static final q a = new q();

        private b() {
        }
    }

    static {
        h();
    }

    public static q a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return b.a;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.i)) {
                    return;
                } else {
                    this.i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.j)) {
                    return;
                } else {
                    this.j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.g == null) {
                    this.g = new JSONArray();
                }
                this.g.put(jSONObject);
                k.a(a).a(this.g);
                this.g = new JSONArray();
                return;
            }
            if (this.g.length() >= this.f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                k.a(a).a(this.g);
                this.g = new JSONArray();
            }
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            if (!jSONObject.getJSONObject("#h").has(f.aH)) {
                jSONObject.has("content");
                String str = "#a";
                if ("#a" != 0) {
                    jSONObject = jSONObject.getJSONObject("content");
                    str = "#a";
                }
                if (jSONObject.has(str) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("#a")) != null
                        && jSONObjectOptJSONObject.length() > 0 && jSONObjectOptJSONObject.has(f.n)) {
                    k.a(a).a(true, false);
                }
                k.a(a).tryGetClassByName();
                return;
            }
            jSONObject.has("content");
            String str2 = "#a";
            if ("#a" != 0) {
                jSONObject = jSONObject.getJSONObject("content");
                str2 = "#a";
            }
            if (jSONObject.has(str2)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("#a");
                if (jSONObject2.has(f.n)
                        && (jSONObjectOptJSONObject2 = jSONObject2.getJSONArray(f.n).optJSONObject(0)) != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(strOptString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        k.a(a).tryGetClassByName(strOptString);
                    }
                }
            }
            k.a(a).tryGetClassByName();
            UMRTLog.i(UMRTLog.RTLOG_TAG,
                    "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            Context context = a;
            UMWorkDispatch.sendEvent(context, a.l, CoreProtocol.getInstance(context), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(x);
            y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject jSONObjectB = b(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectB == null || jSONObjectB.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectB.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectB.opt("content");
        if (a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject,
                jSONObject2);
        if (jSONObjectBuildEnvelopeWithExtHeader != null) {
            try {
                if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG,
                            "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(jSONObjectBuildEnvelopeWithExtHeader);
            }
            b((Object) jSONObjectBuildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONObject jSONObjectA = a(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectA == null || jSONObjectA.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectA.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectA.opt("content");
        Context context = a;
        if (context == null || jSONObject == null || jSONObject2 == null
                || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context,
                        jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG,
                        "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(jSONObjectBuildEnvelopeWithExtHeader);
        }
        a((Object) jSONObjectBuildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            try {
                jSONObjectL.put("st", SdkVersion.MINI_VERSION);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectL;
    }

    private JSONObject l() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put("#wv", AnalyticsConfig.mWrapperVersion);
                jSONObject.put("#wt", AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(a);
            jSONObject.put("#vt", verticalType);
            String str2 = "9.8.8";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(a);
                if (TextUtils.isEmpty(gameSdkVersion)) {
                    str = "#sv";
                } else {
                    str2 = gameSdkVersion;
                    str = "#sv";
                }
                jSONObject.put(str, str2);
            } else {
                jSONObject.put("#sv", "9.8.8");
            }
            String strMD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(a));
            if (!TextUtils.isEmpty(strMD5)) {
                jSONObject.put("#sec", strMD5);
            }
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(a, f.at, "");
            if (!TextUtils.isEmpty(strImprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(f.av, "");
                } else {
                    jSONObject.put(f.av, strImprintProperty2);
                }
            }
            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(a, f.au, "");
            if (!TextUtils.isEmpty(strImprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(f.aw, "");
                } else {
                    jSONObject.put(f.aw, strImprintProperty3);
                }
            }
            jSONObject.put("#prv", "1.0.0");
            s();
            String str3 = "#$prv";
            if ("#$prv" != 0) {
                jSONObject.put(f.ap, SdkVersion.MINI_VERSION);
                str3 = "#$prv";
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                    str3 = "#$prv";
                }
            }
            jSONObject.put(str3, m());
            jSONObject.put("#uda", n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String str4 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            .format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put("#$prv", sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put("#uda", sharedPreferences.getString("vers_date", str4));
                    }
                    sharedPreferences.edit().putString("pre_version", string)
                            .putString("cur_version", DeviceConfig.getAppVersionName(a)).putString("pre_date", str4)
                            .remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version")
                            .commit();
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    private String m() {
        String string = "0";
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strImprintProperty)) {
            string = strImprintProperty;
        } else {
            if (!TextUtils.isEmpty(this.d)) {
                return this.d;
            }
            if (this.c == null) {
                this.c = PreferenceWrapper.getDefault(a);
            }
            String string2 = this.c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(a);
            if (TextUtils.isEmpty(string2)) {
                this.c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
            } else {
                string = this.c.getString("cur_version", "");
                if (appVersionName.equals(string)) {
                    string = string2;
                } else {
                    this.c.edit().putString("pre_version", string).putString("cur_version", appVersionName).commit();
                }
            }
        }
        this.d = string;
        return string;
    }

    private String n() {
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "ud_da", null);
            if (TextUtils.isEmpty(strImprintProperty)) {
                if (!TextUtils.isEmpty(this.e)) {
                    return this.e;
                }
                if (this.c == null) {
                    this.c = PreferenceWrapper.getDefault(a);
                }
                String string = this.c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            .format(new Date(System.currentTimeMillis()));
                    this.c.edit().putString("pre_date", string).commit();
                } else {
                    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            .format(new Date(System.currentTimeMillis()));
                    if (!string.equals(str)) {
                        this.c.edit().putString("pre_date", str).commit();
                        strImprintProperty = str;
                    }
                }
                strImprintProperty = string;
            }
        } catch (Throwable unused) {
        }
        this.e = strImprintProperty;
        return strImprintProperty;
    }

    private void o() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(w.a().tryGetClassByName())) {
                b(a);
            }
            if (this.g.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.g.length(); i++) {
                JSONObject jSONObjectOptJSONObject = this.g.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("__i");
                    if (TextUtils.isEmpty(strOptString) || t.equals(strOptString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.g.length(); i++) {
                try {
                    JSONObject jSONObject = this.g.getJSONObject(i);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String strOptString = jSONObject.optString("__i");
                        boolean zIsEmpty = TextUtils.isEmpty(strOptString);
                        String str = t;
                        if (zIsEmpty || t.equals(strOptString)) {
                            String strB = w.a().tryGetClassByName();
                            if (!TextUtils.isEmpty(strB)) {
                                str = strB;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null
                    || sharedPreferences.getLong(l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = a;
            return (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null
                    || sharedPreferences.getLong(m, -1L) == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                k.a(a).a(this.g);
                this.g = new JSONArray();
            }
            PreferenceWrapper.getDefault(a).edit().putLong(n, this.k).putInt(q, this.i).putInt(r, this.j).commit();
        } catch (Throwable unused) {
        }
    }

    private q() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 10;
        this.g = new JSONArray();
        this.h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            this.k = sharedPreferences.getLong(n, 0L);
            this.i = sharedPreferences.getInt(q, 0);
            this.j = sharedPreferences.getInt(r, 0);
            this.b = new c();
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject jSONObjectF;
        if (k.a(UMGlobalContext.getAppContext(a)).createInstanceWithArgs()
                || (jSONObjectF = k.a(UMGlobalContext.getAppContext(a)).getResult()) == null) {
            return;
        }
        String strOptString = jSONObjectF.optString("__av");
        String strOptString2 = jSONObjectF.optString("__vc");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject.put("#av", UMUtils.getAppVersionName(a));
            } else {
                jSONObject.put("#av", strOptString);
            }
            if (TextUtils.isEmpty(strOptString2)) {
                jSONObject.put("#vc", UMUtils.getAppVersionCode(a));
            } else {
                jSONObject.put("#vc", strOptString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.getJSONObject("#h").has(f.aH)) {
                jSONObject.has("content");
                String str = "#a";
                if ("#a" != 0) {
                    jSONObject = jSONObject.getJSONObject("content");
                    str = "#a";
                }
                if (jSONObject.has(str)) {
                    if (!jSONObject.getJSONObject("#a").has(f.n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    k.a(a).i();
                    k.a(a).dexFind();
                    k.a(a).tryGetClassByName(true, false);
                    k.a(a).a();
                    return;
                }
                return;
            }
            jSONObject.has("content");
            String str2 = "#a";
            if ("#a" != 0) {
                jSONObject = jSONObject.getJSONObject("content");
                str2 = "#a";
            }
            if (jSONObject.has(str2) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("#a")) != null
                    && jSONObjectOptJSONObject.length() > 0) {
                if (jSONObjectOptJSONObject.has(f.n)) {
                    k.a(a).tryGetClassByName(true, false);
                }
                if (jSONObjectOptJSONObject.has("ekv") || jSONObjectOptJSONObject.has(f.Z)) {
                    k.a(a).dexFind();
                }
                if (jSONObjectOptJSONObject.has(f.U)) {
                    k.a(a).i();
                }
            }
            k.a(a).a();
        } catch (Exception unused) {
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class c {
        private ReportPolicy.ReportStrategy a = null;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private ABTest f;

        public c() {
            this.f = null;
            this.f = ABTest.getService(q.a);
        }

        public void a() {
            try {
                int[] iArrA = a(-1, -1);
                this.b = iArrA[0];
                this.c = iArrA[1];
            } catch (Throwable unused) {
            }
        }

        public void b() {
            Defcon service = Defcon.getService(q.a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                this.a = ((reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid()) ? this.a
                        : new ReportPolicy.DefconPolicy(StatTracer.getInstance(q.a), service);
            } else {
                int iA = 0;
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.a, "integrated_test", q.t))
                        .intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(l.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(q.a));
                } else if (this.f.isInTest() && "RPT".equals(this.f.getTestName())) {
                    if (this.f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.a, "test_report_interval", q.t))
                                .intValue() != -1) {
                            iA = a(90000);
                        } else {
                            iA = this.c;
                            if (iA <= 0) {
                                iA = this.e;
                            }
                        }
                    }
                    this.a = b(this.f.getTestPolicy(), iA);
                } else {
                    int i = this.d;
                    int i2 = this.e;
                    int i3 = this.b;
                    if (i3 != -1) {
                        i2 = this.c;
                        i = i3;
                    }
                    this.a = b(i, i2);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(l.I, 3, "", null, null);
                        return;
                    }
                    if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(l.J, 3, "", new String[] { "@" }, new String[] { String.valueOf(
                                ((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000) });
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(l.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        UMLog.mutlInfo(l.M, 3, "", new String[] { "@" }, new String[] { String.valueOf(
                                ((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000) });
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.a;
        }

        public int[] a(int i, int i2) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.a, "report_policy", q.t)).intValue();
            int iIntValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.a, "report_interval", q.t)).intValue();
            if (iIntValue == -1 || !ReportPolicy.isValid(iIntValue)) {
                return new int[] { i, i2 };
            }
            if (6 == iIntValue) {
                if (iIntValue2 == -1 || iIntValue2 < 90 || iIntValue2 > 86400) {
                    iIntValue2 = 90;
                }
                return new int[] { iIntValue, iIntValue2 * 1000 };
            }
            if (11 == iIntValue) {
                if (iIntValue2 == -1 || iIntValue2 < 15 || iIntValue2 > 3600) {
                    iIntValue2 = 15;
                }
                return new int[] { iIntValue, iIntValue2 * 1000 };
            }
            return new int[] { i, i2 };
        }

        public int a(int i) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.a, "test_report_interval", q.t))
                    .intValue();
            return (iIntValue == -1 || iIntValue < 90 || iIntValue > 86400) ? i : iIntValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy
                        : new ReportPolicy.ReportRealtime();
            }
            if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2
                        : new ReportPolicy.ReportAtLaunch();
            }
            if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3
                        : new ReportPolicy.ReportDaily(StatTracer.getInstance(q.a));
            }
            if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4
                        : new ReportPolicy.ReportWifiOnly(q.a);
            }
            if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(q.a), i2);
            }
            if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6
                        : new ReportPolicy.SmartPolicy(StatTracer.getInstance(q.a));
            }
            if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7
                        : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i2);
            return reportQuasiRealtime;
        }
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException
     */
    private void c(JSONObject jSONObject) {
        try {
            if (!k.a(a).getThisObject()) {
                JSONObject jSONObjectG = k.a(a).setResultTrue();
                if (jSONObjectG != null) {
                    String strOptString = jSONObjectG.optString("__av");
                    String strOptString2 = jSONObjectG.optString("__vc");
                    if (TextUtils.isEmpty(strOptString)) {
                        jSONObject.put("#av", UMUtils.getAppVersionName(a));
                    } else {
                        jSONObject.put("#av", strOptString);
                    }
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put("#vc", UMUtils.getAppVersionCode(a));
                        return;
                    } else {
                        jSONObject.put("#vc", strOptString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put("#av", UMUtils.getAppVersionName(a));
            jSONObject.put("#vc", UMUtils.getAppVersionCode(a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (a != null) {
            synchronized (this.w) {
                try {
                    if (this.u) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG,
                                "--->>> network is now available, rebuild instant session data packet.");
                        Context context = a;
                        UMWorkDispatch.sendEvent(context, a.l, CoreProtocol.getInstance(context), null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            synchronized (this.w) {
                try {
                    if (this.v) {
                        Context context2 = a;
                        UMWorkDispatch.sendEvent(context2, a.m, CoreProtocol.getInstance(context2), null);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class d {
        private Map<String, Object> a;
        private String b;
        private String c;
        private long d;

        private d() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0L;
        }

        public Map<String, Object> a() {
            return this.a;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.b;
        }

        public long d() {
            return this.d;
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.a = map;
            this.b = str;
            this.d = j;
            this.c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String strOptString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            k.a(a).a(strOptString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    /*
     * JADX WARN: Not initialized variable reg: 1, insn: 0x0010: MOVE (r16
     * I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 2, insn: 0x0014: MOVE (r17
     * I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 4, insn: 0x0018: MOVE (r18
     * I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 5, insn: 0x001c: MOVE (r19
     * I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 6, insn: 0x0020: MOVE (r20
     * I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 7, insn: 0x0024: MOVE (r21
     * I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 8, insn: 0x0028: MOVE (r22
     * I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:2:0x0000
     */
    /*
     * JADX WARN: Not initialized variable reg: 9, insn: 0x0036: MOVE (r23
     * I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:8:0x0036
     */
    private void d(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("#a")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a(str3));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.Z)) {
                    jSONObject3.put(f.Z, jSONObject4.getJSONArray(f.Z));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.U)) {
                    jSONObject3.put(f.U, jSONObject4.getJSONArray(f.U));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(f.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(f.u)) {
                                jSONObject5.remove(f.u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(f.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.I)) {
                    jSONObject3.put(f.I, jSONObject4.getJSONObject(f.I));
                }
                if (jSONObject4.has(f.L)) {
                    jSONObject3.put(f.L, jSONObject4.getJSONObject(f.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            String strA = "#h";
            if (jSONObject.has("dplus")) {
                jSONObject3.put("#h", jSONObject.getJSONObject("#h"));
                strA = com.umeng.commonsdk.statistics.b.a(str2);
            }
            if (jSONObject.has(strA)
                    && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a(str2))) != null
                    && jSONObject2.length() > 0) {
                jSONObject2.has("#sv");
                String strA2 = "#dd";
                if ("#dd" != 0) {
                    jSONObject3.put(str8, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str8)));
                    strA2 = com.umeng.commonsdk.statistics.b.a(str7);
                }
                jSONObject2.has(strA2);
                String strA3 = "#dm";
                if ("#dm" != 0) {
                    jSONObject3.put(str7, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str7)));
                    strA3 = com.umeng.commonsdk.statistics.b.a(str6);
                }
                jSONObject2.has(strA3);
                String strA4 = "#vc";
                if ("#vc" != 0) {
                    jSONObject3.put(str6, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str6)));
                    strA4 = com.umeng.commonsdk.statistics.b.a(str);
                }
                jSONObject2.has(strA4);
                String strA5 = "#ak";
                if ("#ak" != 0) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a(str)));
                    strA5 = com.umeng.commonsdk.statistics.b.a(str5);
                }
                jSONObject2.has(strA5);
                String strA6 = "#chn";
                if ("#chn" != 0) {
                    jSONObject3.put(str5, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str5)));
                    strA6 = com.umeng.commonsdk.statistics.b.a(str4);
                }
                if (jSONObject2.has(strA6)) {
                    jSONObject3.put(str4, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str4)));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException
     */
    public JSONObject b(long j) {
        if (TextUtils.isEmpty(aa.a().d(UMGlobalContext.getAppContext(a)))) {
            return null;
        }
        JSONObject jSONObjectB = k.a(UMGlobalContext.getAppContext(a)).tryGetClassByName(false);
        String[] strArrA = com.umeng.analytics.c.a(a);
        if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f.M, strArrA[0]);
                jSONObject.put(f.N, strArrA[1]);
                if (jSONObject.length() > 0) {
                    jSONObjectB.put(f.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int iA = t.a().a(a);
        if (jSONObjectB.length() == 1 && jSONObjectB.optJSONObject(f.L) != null && iA != 3) {
            return null;
        }
        t.a().tryGetClassByName(jSONObjectB, a);
        if (jSONObjectB.length() <= 0 && iA != 3) {
            return null;
        }
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            b(jSONObjectK);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (iA == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (jSONObjectB.length() > 0) {
                jSONObject3.put("analytics", jSONObjectB);
            }
            if (jSONObjectK != null && jSONObjectK.length() > 0) {
                jSONObject2.put("header", jSONObjectK);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return tryGetClassByName(jSONObject2, j);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z2) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a();
        ReportPolicy.ReportStrategy reportStrategyC = this.b.c();
        boolean zShouldSendMessage = reportStrategyC.shouldSendMessage(z2);
        if (zShouldSendMessage) {
            if (((reportStrategyC instanceof ReportPolicy.ReportByInterval)
                    || (reportStrategyC instanceof ReportPolicy.DebugPolicy)
                    || (reportStrategyC instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((reportStrategyC instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : ".concat(reportStrategyC.getClass().getSimpleName()));
            }
        }
        return zShouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = y;
        if (cls == null || (method = z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            String str = "#h";
            if (jSONObject.has("#a")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("#h");
                if (jSONObject4.has(f.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(f.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(f.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                boolean zHas = jSONObject4.has(f.L);
                str = "#h";
                if (zHas) {
                    jSONObject3.put(f.L, "#h".getJSONObject(f.L));
                    jSONObject3.length();
                    str = "#h";
                    if ("#h" > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                        str = "#h";
                    }
                }
            }
            if (jSONObject.has(str) && jSONObject.has("#h") && (jSONObject2 = jSONObject.getJSONObject("#h")) != null
                    && jSONObject2.length() > 0) {
                jSONObject2.has("#sv");
                String str2 = "#dd";
                if ("#dd" != 0) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("#sv"));
                    str2 = "#dd";
                }
                jSONObject2.has(str2);
                String str3 = "#dm";
                if ("#dm" != 0) {
                    jSONObject3.put("device_id", jSONObject2.getString("#dd"));
                    str3 = "#dm";
                }
                jSONObject2.has(str3);
                String str4 = "#vc";
                if ("#vc" != 0) {
                    jSONObject3.put("device_model", jSONObject2.getString("#dm"));
                    str4 = "#vc";
                }
                String str5 = "#ak";
                if (jSONObject2.has(str4)) {
                    jSONObject3.put("version", jSONObject2.getInt("#ak"));
                    str5 = "#ak";
                }
                jSONObject2.has(str5);
                String str6 = "#chn";
                if ("#chn" != 0) {
                    jSONObject3.put("appkey", jSONObject2.getString("#ak"));
                    str6 = "#chn";
                }
                if (jSONObject2.has(str6)) {
                    jSONObject3.put("channel", jSONObject2.getString("#chn"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException
     */
    public void a(Object obj, int i) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                j.a(a);
                com.umeng.commonsdk.utils.c.c(a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                if (i != 4358) {
                    switch (i) {
                        case a.cachedConstructors /* 4097 */:
                            if (UMUtils.isMainProgress(a)) {
                                if (obj != null) {
                                    e(obj);
                                }
                                if (t.equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a),
                                    new JSONArray().put(obj));
                            return;
                        case a.second /* 4098 */:
                            if (obj != null) {
                                e(obj);
                            }
                            if (t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        case a.c /* 4099 */:
                            x.a(a);
                            return;
                        case a.d /* 4100 */:
                            n.createInstanceWithArgs(a);
                            return;
                        case a.e /* 4101 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                            a((Object) null, true);
                            g(obj);
                            return;
                        case a.f /* 4102 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                            a((Object) null, true);
                            f(obj);
                            return;
                        case a.g /* 4103 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                            w.a().a(a, obj);
                            synchronized (this.w) {
                                try {
                                    this.v = true;
                                } catch (Throwable th) {
                                    throw th;
                                }
                                break;
                            }
                            return;
                        case a.h /* 4104 */:
                            w.a().createInstanceWithArgs(a, obj);
                            return;
                        case a.i /* 4105 */:
                            d();
                            return;
                        case a.j /* 4106 */:
                            h(obj);
                            return;
                        default:
                            switch (i) {
                                case a.k /* 4352 */:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                    w.a().tryGetClassByName(a, obj);
                                    synchronized (this.w) {
                                        try {
                                            this.u = true;
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                        break;
                                    }
                                    return;
                                case a.l /* 4353 */:
                                    a(obj, true);
                                    return;
                                case a.m /* 4354 */:
                                    c();
                                    return;
                                case a.n /* 4355 */:
                                    if (!UMUtils.isMainProgress(a)) {
                                        UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(
                                                UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                                        return;
                                    } else {
                                        if (obj != null) {
                                            e(obj);
                                            d();
                                            return;
                                        }
                                        return;
                                    }
                                case a.o /* 4356 */:
                                    if (obj == null || y == null || z == null) {
                                        return;
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String string = "";
                                    String string2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has(f.M)) {
                                            string = jSONObject.getString(f.M);
                                            string2 = jSONObject.getString("uid");
                                        }
                                        a(string2, string);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i) {
                                        case a.t /* 8195 */:
                                            com.umeng.analytics.b.a().a(obj);
                                            return;
                                        case a.u /* 8196 */:
                                            com.umeng.analytics.b.a().m();
                                            return;
                                        case a.v /* 8197 */:
                                            com.umeng.analytics.b.a().k();
                                            return;
                                        default:
                                            switch (i) {
                                                case a.w /* 8199 */:
                                                case a.x /* 8200 */:
                                                    com.umeng.analytics.b.a().b(obj);
                                                    return;
                                                case a.y /* 8201 */:
                                                    com.umeng.analytics.b.a().b((Object) null);
                                                    return;
                                                default:
                                                    switch (i) {
                                                        case a.z /* 8208 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG,
                                                                    "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = a;
                                                            UMWorkDispatch.sendEvent(context, a.A,
                                                                    CoreProtocol.getInstance(context), null);
                                                            Context context2 = a;
                                                            UMWorkDispatch.sendEvent(context2, a.m,
                                                                    CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case a.A /* 8209 */:
                                                            a(obj, false);
                                                            return;
                                                        case a.B /* 8210 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG,
                                                                    "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (UMUtils.isMainProgress(a) && !(this.b
                                                                    .c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                a(true);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            switch (i) {
                                                                case a.E /* 8213 */:
                                                                    if (FieldManager
                                                                            .allow(com.umeng.commonsdk.utils.d.E)) {
                                                                        if (DeviceConfig.getGlobleActivity(a) != null) {
                                                                            w.tryGetClassByName(a);
                                                                        }
                                                                        Context context3 = a;
                                                                        UMWorkDispatch.sendEventEx(context3, a.E,
                                                                                CoreProtocol.getInstance(context3),
                                                                                null, 5000L);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.F /* 8214 */:
                                                                    if (obj != null && (obj instanceof JSONObject)) {
                                                                        String strOptString = ((JSONObject) obj)
                                                                                .optString(
                                                                                        AnalyticsConfig.RTD_START_TIME);
                                                                        String strOptString2 = ((JSONObject) obj)
                                                                                .optString(AnalyticsConfig.RTD_PERIOD);
                                                                        String strOptString3 = ((JSONObject) obj)
                                                                                .optString(AnalyticsConfig.DEBUG_KEY);
                                                                        if (TextUtils.isEmpty(strOptString)
                                                                                || TextUtils.isEmpty(strOptString2)
                                                                                || TextUtils.isEmpty(strOptString3)) {
                                                                            return;
                                                                        }
                                                                        Context context4 = a;
                                                                        String str = AnalyticsConfig.RTD_SP_FILE;
                                                                        com.umeng.common.b.a(context4, str,
                                                                                AnalyticsConfig.RTD_START_TIME,
                                                                                strOptString);
                                                                        com.umeng.common.b.a(a, str,
                                                                                AnalyticsConfig.RTD_PERIOD,
                                                                                strOptString2);
                                                                        com.umeng.common.b.a(a, str,
                                                                                AnalyticsConfig.DEBUG_KEY,
                                                                                strOptString3);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.G /* 8215 */:
                                                                    com.umeng.common.b.a(a,
                                                                            AnalyticsConfig.RTD_SP_FILE);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                if (obj != null && (obj instanceof JSONObject)) {
                    String strOptString4 = ((JSONObject) obj).optString(f.S);
                    Object objOpt = ((JSONObject) obj).opt(f.T);
                    if (TextUtils.isEmpty(strOptString4)) {
                        return;
                    }
                    String[] strArrA = com.umeng.analytics.c.a(a);
                    if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                        if (f.O.equals(strOptString4)) {
                            com.umeng.analytics.c.a((String) objOpt);
                            return;
                        } else if (f.P.equals(strOptString4)) {
                            com.umeng.analytics.c.b((String) objOpt);
                            return;
                        } else {
                            com.umeng.analytics.c.a(strOptString4, objOpt);
                            return;
                        }
                    }
                    MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(f.M);
                String string2 = jSONObject.getString("uid");
                long j = jSONObject.getLong("ts");
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA != null && string.equals(strArrA[0]) && string2.equals(strArrA[1])) {
                    return;
                }
                w.a().a(a, j);
                String strC = aa.a().c(a);
                boolean zB = w.a().tryGetClassByName(a, j, false);
                com.umeng.analytics.c.a(a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG,
                        "--->>> onProfileSignIn: force generate new session: session id = " + strC);
                w.a().a(a, j, true);
                if (zB) {
                    w.a().tryGetClassByName(a, j);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long jCurrentTimeMillis = 0;
        try {
            Context context = a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j = sharedPreferences.getLong(l, 0L);
            if (j != 0) {
                return j;
            }
            try {
                jCurrentTimeMillis = System.currentTimeMillis();
                sharedPreferences.edit().putLong(l, jCurrentTimeMillis).commit();
                return jCurrentTimeMillis;
            } catch (Throwable unused) {
                return j;
            }
        } catch (Throwable unused2) {
            return jCurrentTimeMillis;
        }
    }

    public void c(Object obj) {
        b(a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                b(a);
                d();
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA == null || TextUtils.isEmpty(strArrA[0]) || TextUtils.isEmpty(strArrA[1])) {
                    return;
                }
                w.a().a(a, j);
                UMRTLog.i(UMRTLog.RTLOG_TAG,
                        "--->>> onProfileSignIn: force generate new session: session id = " + aa.a().c(a));
                boolean zB = w.a().tryGetClassByName(a, j, false);
                com.umeng.analytics.c.b(a);
                w.a().a(a, j, true);
                if (zB) {
                    w.a().tryGetClassByName(a, j);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j) {
        try {
            if (s.a(jSONObject) <= j) {
                return jSONObject;
            }
            jSONObject = null;
            k.a(a).a(true, false);
            k.a(a).tryGetClassByName();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObjectA = null;
        try {
            jSONObjectA = k.a(a).a(z2);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            } else {
                try {
                    boolean zHas = jSONObjectA.has(f.n);
                    jSONObjectA = jSONObjectA;
                    if (zHas) {
                        JSONArray jSONArray3 = jSONObjectA.getJSONArray(f.n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i = 0;
                        while (i < jSONArray3.length()) {
                            JSONObject jSONObject = (JSONObject) jSONArray3.get(i);
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(f.t);
                            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(f.u);
                            if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null) {
                                jSONObject.put(f.t, jSONArrayOptJSONArray2);
                                jSONObject.remove(f.u);
                            }
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray.get(i2));
                                }
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray2.get(i3));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(f.x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject.put(f.t, jSONArray5);
                                jSONObject.remove(f.u);
                            }
                            if (jSONObject.has(f.t)) {
                                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(f.t);
                                int i4 = 0;
                                while (i4 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i4);
                                    if (jSONObject2.has(f.x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject2.put("ts", jSONObject2.getLong(f.x));
                                        jSONObject2.remove(f.x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i4++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject.put(f.t, jSONArrayOptJSONArray3);
                                jSONObject.put(f.z, jSONArrayOptJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject.put(f.z, 0);
                            }
                            jSONArray4.put(jSONObject);
                            i++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObjectA.put(f.n, jSONArray4);
                        jSONObjectA = jSONObjectA;
                    }
                } catch (Exception e) {
                    MLog.e("merge pages error");
                    e.printStackTrace();
                    jSONObjectA = jSONObjectA;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObjectA.put("userlevel", string);
                }
            }
            String[] strArrA = com.umeng.analytics.c.a(a);
            if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(f.M, strArrA[0]);
                jSONObject3.put(f.N, strArrA[1]);
                if (jSONObject3.length() > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    String strA = com.umeng.analytics.c.a();
                    if (strA != null) {
                        jSONObject4.put(f.O, strA);
                    }
                    String strB = com.umeng.analytics.c.b();
                    if (strB != null) {
                        jSONObject4.put(f.P, strB);
                    }
                    Map<String, Object> mapC = com.umeng.analytics.c.c(a);
                    if (mapC != null && mapC.size() > 0) {
                        for (String str : mapC.keySet()) {
                            jSONObject4.put(str, mapC.get(str));
                        }
                    }
                    if (jSONObject4.length() > 0) {
                        jSONObject3.put(f.R, jSONObject4);
                    }
                    jSONObjectA.put(f.L, jSONObject3);
                }
            }
            if (ABTest.getService(a).isInTest()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(ABTest.getService(a).getTestName(), ABTest.getService(a).getGroupInfo());
                jSONObjectA.put(f.K, jSONObject5);
            }
            t.a().a(jSONObjectA, a);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z2) {
        if (this.b == null) {
            this.b = new c();
        }
        ReportPolicy.ReportStrategy reportStrategyC = this.b.c();
        if (!(reportStrategyC instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z2) {
            return ((ReportPolicy.DefconPolicy) reportStrategyC).shouldSendMessageByInstant();
        }
        return reportStrategyC.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 == jSONObject.getInt("exception")) {
                            return;
                        }
                        f(jSONObject);
                        return;
                    }
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            k.a(context).getArgs();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z2) {
        if (c(z2)) {
            if (!(this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z2) {
                if (UMEnvelopeBuild.isOnline(a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List listAsList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground",
                "$$_onUMengEnterForegroundInitError");
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && listAsList.contains(jSONObjectOptJSONObject.optString("id"))) {
                    i++;
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ekv");
        int length = jSONArrayOptJSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                    if (jSONArrayOptJSONArray2 != null && a(jSONArrayOptJSONArray2)) {
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    public JSONObject a(long j) {
        if (TextUtils.isEmpty(aa.a().d(a))) {
            return null;
        }
        JSONObject jSONObjectB = b(false);
        int iA = t.a().a(a);
        if (jSONObjectB.length() > 0) {
            if (jSONObjectB.length() == 1) {
                if (jSONObjectB.optJSONObject(f.L) != null && iA != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                    return null;
                }
            } else if (jSONObjectB.length() == 2 && jSONObjectB.optJSONObject(f.L) != null
                    && !TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                return null;
            }
            String strOptString = jSONObjectB.optString(f.n);
            String strOptString2 = jSONObjectB.optString(f.Z);
            String strOptString3 = jSONObjectB.optString("ekv");
            if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)
                    && a(jSONObjectB)) {
                return null;
            }
        } else if (iA != 3) {
            return null;
        }
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            c(jSONObjectL);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (iA == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (jSONObjectB.length() > 0) {
                jSONObject2.put("analytics", jSONObjectB);
            }
            if (jSONObjectL != null && jSONObjectL.length() > 0) {
                jSONObject.put("header", jSONObjectL);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j) {
        try {
            if (s.a(jSONObject) <= j) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(f.aH, s.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return s.a(a, j, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j, int i) {
        if (j == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j <= 28800000) {
            return i < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 == jSONObject.getInt("exception")) {
                            return;
                        }
                        g(jSONObject);
                        return;
                    }
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(a) && d(true)) {
            i();
        }
    }
}
