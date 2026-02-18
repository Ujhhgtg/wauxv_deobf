package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a = null;
    public static String b = "";
    private static final String c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static Map<String, String> j;
    private static boolean l;
    private int k = 0;

    static {
        HashMap map = new HashMap();
        j = map;
        map.put("header", "#h");
        j.put(bt.u, "#sdt");
        j.put(bt.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(bt.g, "#umid");
        j.put(bt.x, bt.x);
        j.put(bt.N, "#lang");
        j.put(bt.ac, "#dt");
        j.put(bt.z, "#rl");
        j.put(bt.H, "#dmf");
        j.put(bt.J, "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put(bt.y, "#ov");
        j.put(bt.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(bt.F, "#db");
        j.put("appkey", "#ak");
        j.put(bt.Y, "#itr");
        j.put("id_type", "#it");
        j.put("uuid", "#ud");
        j.put("device_id", "#dd");
        j.put(bt.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put(bt.o, "#pkg");
        j.put(bt.p, "#sig");
        j.put(bt.q, "#sis1");
        j.put(bt.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(bt.v, "#imd");
        j.put(bt.B, "#mnc");
        j.put(bt.E, "#boa");
        j.put(bt.G, "#mant");
        j.put(bt.M, "#tz");
        j.put(bt.O, "#ct");
        j.put(bt.P, "#car");
        j.put(bt.s, "#disn");
        j.put(bt.T, "#nt");
        j.put(bt.b, "#cv");
        j.put(bt.d, "#mv");
        j.put(bt.c, "#cot");
        j.put(bt.e, "#mod");
        j.put(bt.ad, "#al");
        j.put("session_id", "#sid");
        j.put(bt.S, "#ip");
        j.put(bt.U, "#sre");
        j.put(bt.V, "#fre");
        j.put(bt.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(bt.aT, "#tsv");
        j.put("rps_pr", "#rps");
        j.put(bt.aW, "#mov");
        j.put(f.i, "#vt");
        j.put("secret", "#sec");
        j.put(f.an, "#prv");
        j.put(f.l, "#$prv");
        j.put(f.m, "#uda");
        j.put(bt.a, "#tok");
        j.put(bt.aL, "#iv");
        j.put(bt.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(bt.aj, "#mt");
        j.put(bt.ag, "#zsv");
        j.put(bt.ai, "#oos");
    }

    public static String a(String str) {
        return j.containsKey(str) ? j.get(str) : str;
    }

    private static boolean b() {
        g = "";
        h = "";
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    public static void a() {
        if (i != null) {
            i = null;
            com.umeng.commonsdk.statistics.idtracking.f.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Context context2;
        Throwable th;
        Envelope envelopeA;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("#h", new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                try {
                    jSONObject3 = a(jSONObject3, jSONObject);
                } catch (Throwable th2) {
                    th = th2;
                    context2 = context;
                }
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelopeA = null;
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            context2 = context;
            try {
                int iA = a(context2, envelope, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
                if (iA != 0) {
                    return a(iA, jSONObject3);
                }
                if (ULog.DEBUG) {
                    Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
                }
                return jSONObject3;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            context2 = context;
        }
        th = th;
        UMCrashManager.reportCrash(context2, th);
        return a(110, new JSONObject());
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(c, "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String strSubstring;
        Envelope envelope;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                boolean z = jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(f.n);
                String str4 = str2;
                JSONObject jSONObjectA = a(context, str4, z);
                if (jSONObjectA != null && jSONObject != null) {
                    jSONObjectA = a(jSONObjectA, jSONObject);
                }
                JSONObject jSONObject5 = jSONObjectA;
                if (jSONObject5 != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null && (next instanceof String)) {
                            String str5 = next;
                            if (jSONObject2.opt(str5) != null) {
                                try {
                                    jSONObject5.put(a(str5), jSONObject2.opt(str5));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str4)) {
                    str4 = bt.aF;
                }
                String str6 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject5 != null) {
                    strSubstring = str4 + "==" + str6 + "&=";
                    if (TextUtils.isEmpty(strSubstring)) {
                        return a(101, jSONObject5);
                    }
                    if (strSubstring.endsWith("&=")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                    }
                } else {
                    strSubstring = null;
                }
                if (jSONObject5 != null) {
                    try {
                        com.umeng.commonsdk.statistics.idtracking.f fVarA = com.umeng.commonsdk.statistics.idtracking.f.a(context);
                        if (fVarA != null) {
                            fVarA.b();
                            String strEncodeToString = Base64.encodeToString(new cq().a(fVarA.c()), 0);
                            if (!TextUtils.isEmpty(strEncodeToString)) {
                                JSONObject jSONObject6 = jSONObject5.getJSONObject("#h");
                                jSONObject6.put("#itr", strEncodeToString);
                                jSONObject5.put("#h", jSONObject6);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject5 != null && DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject5);
                }
                if (jSONObject5 != null) {
                    Envelope envelopeA = a(context, jSONObject5.toString().getBytes());
                    if (envelopeA == null) {
                        return a(111, jSONObject5);
                    }
                    envelope = envelopeA;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject5);
                }
                int iA = a(context, envelope, strSubstring, jSONObject5 != null ? jSONObject5.optJSONObject("#h").optString("#av") : null, str);
                if (iA != 0) {
                    return a(iA, jSONObject5);
                }
                if (ULog.DEBUG) {
                    Log.i(c, "constructHeader size is " + jSONObject5.toString().getBytes().length);
                }
                if (!strSubstring.startsWith(bt.aB) && !strSubstring.startsWith(bt.aA) && !strSubstring.startsWith(bt.aG) && !strSubstring.startsWith(bt.at) && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject5;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        jSONObject4 = new JSONObject();
                        jSONObject3 = jSONObject4;
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = null;
                    }
                    try {
                        jSONObject4.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject3 = jSONObject4;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e4) {
                        e = e4;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                }
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (next2 != null && (next2 instanceof String)) {
                        String str7 = next2;
                        if (jSONObject2.opt(str7) != null) {
                            try {
                                jSONObject3.put(str7, jSONObject2.opt(str7));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Context context2;
        Throwable th;
        Envelope envelopeA;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("#h", new JSONObject());
            if (jSONObject != null) {
                try {
                    jSONObject3 = a(jSONObject3, jSONObject);
                } catch (Throwable th2) {
                    th = th2;
                    context2 = context;
                    UMCrashManager.reportCrash(context2, th);
                    return a(110, new JSONObject());
                }
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelopeA = null;
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            context2 = context;
            try {
                int iA = a(context2, envelope, "h==1.2.0", "", str);
                if (iA != 0) {
                    return a(iA, jSONObject3);
                }
                if (ULog.DEBUG) {
                    Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
                }
                return jSONObject3;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                UMCrashManager.reportCrash(context2, th);
                return a(110, new JSONObject());
            }
        } catch (Throwable th4) {
            th = th4;
            context2 = context;
        }
    }

    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String, org.json.JSONObject] */
    private static JSONObject a(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences;
        JSONObject jSONObject;
        ?? r14;
        char c2;
        try {
            SharedPreferences sharedPreferences2 = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(i)) {
                try {
                    jSONObject = new JSONObject(i);
                    sharedPreferences = sharedPreferences2;
                } catch (Exception unused) {
                    sharedPreferences = sharedPreferences2;
                    jSONObject = null;
                }
                r14 = 0;
                c2 = 1;
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("#sig", DeviceConfig.getAppMD5Signature(context));
                jSONObject2.put("#sis1", DeviceConfig.getAppSHA1Key(context));
                jSONObject2.put("#sis", DeviceConfig.getAppHashKey(context));
                jSONObject2.put("#av", DeviceConfig.getAppVersionName(context));
                jSONObject2.put("#vc", Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject2.put("#imd", DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject2.put(bt.w, DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put("#mnc", mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject2.put("#mnc", "");
                }
                if (FieldManager.allow(d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject2.put(bt.K, subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject2.put(bt.L, subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put("#dt", deviceType);
                }
                jSONObject2.put("#pkg", DeviceConfig.getPackageName(context));
                jSONObject2.put("#sdt", AnalyticsConstants.SDK_TYPE);
                jSONObject2.put("#dd", DeviceConfig.getDeviceId(context));
                jSONObject2.put("#dm", Build.MODEL);
                jSONObject2.put("#boa", Build.BOARD);
                jSONObject2.put("#db", Build.BRAND);
                sharedPreferences = sharedPreferences2;
                r14 = 0;
                jSONObject2.put("#mant", Build.TIME);
                jSONObject2.put("#dmf", Build.MANUFACTURER);
                jSONObject2.put("#did", Build.ID);
                jSONObject2.put("#dn", Build.DEVICE);
                jSONObject2.put("#ov", Build.VERSION.RELEASE);
                jSONObject2.put(bt.x, AnalyticsConstants.SDK_TYPE);
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    StringBuilder sb = new StringBuilder();
                    c2 = 1;
                    sb.append(resolutionArray[1]);
                    sb.append("*");
                    sb.append(resolutionArray[0]);
                    jSONObject2.put("#rl", sb.toString());
                } else {
                    c2 = 1;
                }
                jSONObject2.put(bt.A, DeviceConfig.getMac(context));
                jSONObject2.put("#tz", DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject2.put("#ct", localeInfo[0]);
                jSONObject2.put("#lang", localeInfo[c2]);
                jSONObject2.put("#car", DeviceConfig.getNetworkOperatorName(context));
                jSONObject2.put("#disn", DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put("#ac", "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put("#ac", "2G/3G");
                } else {
                    jSONObject2.put("#ac", "unknow");
                }
                if (!"".equals(networkAccessMode[c2])) {
                    jSONObject2.put("#ast", networkAccessMode[c2]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject2.put("#oos", "harmony");
                } else {
                    jSONObject2.put("#oos", AnalyticsConstants.SDK_TYPE);
                }
                jSONObject2.put("#nt", DeviceConfig.getNetworkType(context));
                jSONObject2.put("#cv", "9.8.8");
                jSONObject2.put("#cot", SdkVersion.SDK_TYPE);
                jSONObject2.put("#mv", SdkVersion.MINI_VERSION);
                if (!TextUtils.isEmpty(a)) {
                    jSONObject2.put("#mod", a);
                }
                jSONObject2.put("#al", Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(bt.Z, UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put("#sid", uUIDForZid);
                } catch (Throwable unused2) {
                }
                try {
                    if (DeviceConfig.isSystemApp(context)) {
                        jSONObject2.put(bt.ak, SdkVersion.MINI_VERSION);
                    }
                } catch (Throwable unused3) {
                }
                if (DeviceConfig.isHonorDevice()) {
                    try {
                        if (br.c()) {
                            jSONObject2.put(bt.al, 2);
                        }
                        if (br.b()) {
                            jSONObject2.put(bt.al, 3);
                        }
                    } catch (Throwable unused4) {
                    }
                }
                try {
                    jSONObject2.put(bt.am, DeviceConfig.getNotificationStatus(context));
                } catch (Throwable unused5) {
                }
                try {
                    jSONObject2.put(bt.an, DeviceConfig.getRingerMode(context));
                } catch (Throwable unused6) {
                }
                i = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return r14;
            }
            try {
                jSONObject.put(bt.ae, UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused7) {
            }
            try {
                SharedPreferences sharedPreferences3 = sharedPreferences;
                jSONObject.put("#sre", sharedPreferences3.getInt("successful_request", 0));
                jSONObject.put("#fre", sharedPreferences3.getInt(bt.V, 0));
                jSONObject.put("#ret", sharedPreferences3.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(bt.af, zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put("#zsv", UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused8) {
            }
            jSONObject.put("#chn", UMUtils.getChannel(context));
            jSONObject.put("#ak", UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put("#tok", deviceToken);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, bt.g, r14);
                if (!TextUtils.isEmpty(strImprintProperty)) {
                    jSONObject.put("#umid", strImprintProperty);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(context, e3);
            }
            try {
                jSONObject.put("#wt", a.a);
                jSONObject.put("#wv", a.b);
            } catch (Exception unused9) {
            }
            try {
                jSONObject.put("#tsv", UMUtils.getTargetSdkVersion(context));
            } catch (Throwable unused10) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused11) {
            }
            if ((bt.aG.equals(str) || bt.at.equals(str)) && z) {
                try {
                    int[] iArrB = b(context);
                    jSONObject.put(bt.bn, String.valueOf(iArrB[0]) + String.valueOf(iArrB[c2]) + String.valueOf(iArrB[2]));
                } catch (Throwable unused12) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject3.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("#mt", jSONObject3);
                }
            } catch (Throwable unused13) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(bt.bm, realTimeDebugKey);
                }
            } catch (Throwable unused14) {
            }
            try {
                JSONObject moduleVer = UMUtils.getModuleVer();
                if (moduleVer.length() > 0) {
                    jSONObject.put("#mov", moduleVer);
                }
            } catch (Throwable unused15) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(bt.bl, apmFlag);
                }
            } catch (Throwable unused16) {
            }
            try {
                jSONObject.put(bt.aU, "ColorOS");
                jSONObject.put(bt.aV, "V16.0.0");
            } catch (Throwable unused17) {
            }
            byte[] bArrA = ImprintHandler.getImprintService(context).a();
            if (bArrA != null && bArrA.length > 0) {
                try {
                    jSONObject.put("#imp", Base64.encodeToString(bArrA, 0));
                } catch (JSONException e4) {
                    UMCrashManager.reportCrash(context, e4);
                }
            }
            if (jSONObject.length() > 0) {
                return new JSONObject().put("#h", jSONObject);
            }
            return null;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt("#h") != null && (jSONObject.opt("#h") instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("#h");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals("#vt") && (jSONObject2.opt(str) instanceof Integer)) {
                                this.k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String strB = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append(JavaConstant.Dynamic.DEFAULT_NAME);
        sb.append(System.currentTimeMillis());
        sb.append(JavaConstant.Dynamic.DEFAULT_NAME);
        sb.append(strB);
        sb.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith(bt.aE)) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith(bt.aE)) {
            return 122;
        }
        if (!str.startsWith(bt.aB) && !str.startsWith(bt.aA) && !str.startsWith(bt.at) && !str.startsWith(bt.aG)) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z) {
        l = z;
    }
}
