package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ao {
    private static JSONObject a;

    public static JSONObject a(Context context, JSONArray jSONArray, String str) {
        JSONObject jSONObject = a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return a;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(bt.x, AnalyticsConstants.SDK_TYPE);
            jSONObject2.put("dm", Build.MODEL);
            jSONObject2.put("av", DeviceConfig.getAppVersionName(context));
            jSONObject2.put(bt.g, UMUtils.getUMId(context));
            jSONObject2.put("ov", Build.VERSION.RELEASE);
            jSONObject2.put("chn", UMUtils.getChannel(context));
            jSONObject2.put(bt.af, UMUtils.getZid(context));
            jSONObject2.put("sv", "9.8.8");
            jSONObject2.put("ak", UMUtils.getAppkey(context));
            String idfa = DeviceConfig.getIdfa(context);
            if (!TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", Build.BRAND);
            jSONObject2.put("tk_aid", DeviceConfig.getAndroidId(context));
            String oaid = DeviceConfig.getOaid(context);
            if (!TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            String imeiNew = DeviceConfig.getImeiNew(context);
            if (!TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", Build.BOARD);
            jSONObject2.put("mant", Build.TIME);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            jSONObject2.put("ct", localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put("tz", DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", DeviceConfig.getAppName(context));
            String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put("ac", "2G/3G");
            } else {
                jSONObject2.put("ac", "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put("ast", networkAccessMode[1]);
            }
            jSONObject2.put("nt", DeviceConfig.getNetworkType(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(bt.a, deviceToken);
            }
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + "*" + resolutionArray[0]);
            }
            jSONObject2.put("car", DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(bt.b, "9.8.8");
            if (DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", AnalyticsConstants.SDK_TYPE);
            }
            jSONObject2.put(com.umeng.ccg.a.u, str);
            jSONObject2.put(com.umeng.ccg.a.x, jSONArray);
            a = jSONObject2;
        } catch (Throwable unused) {
        }
        return a;
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ekv", jSONArray);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject3;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            an anVar = new an();
            String uMId = UMUtils.getUMId(context);
            if (!TextUtils.isEmpty(uMId)) {
                anVar.a(uMId);
                String appkey = UMUtils.getAppkey(context);
                if (!TextUtils.isEmpty(appkey)) {
                    anVar.b(appkey);
                    anVar.c(UMUtils.getAppVersionName(context));
                    anVar.d("9.8.8");
                    anVar.e(UMUtils.getChannel(context));
                    anVar.f(Build.VERSION.SDK_INT + "");
                    anVar.g(Build.BRAND);
                    anVar.h(Build.MODEL);
                    String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                    anVar.i(localeInfo[1]);
                    anVar.j(localeInfo[0]);
                    int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                    anVar.b(Integer.valueOf(resolutionArray[1]));
                    anVar.a(Integer.valueOf(resolutionArray[0]));
                    anVar.k(as.a(context, "install_datetime", ""));
                    try {
                        jSONObject = new JSONObject();
                    } catch (JSONException e) {
                        e = e;
                    }
                    try {
                        jSONObject.put(an.a, anVar.a());
                        jSONObject.put(an.c, anVar.c());
                        jSONObject.put(an.b, anVar.b());
                        jSONObject.put(an.d, anVar.d());
                        jSONObject.put(an.e, anVar.e());
                        jSONObject.put(an.f, anVar.f());
                        jSONObject.put(an.g, anVar.g());
                        jSONObject.put(an.h, anVar.h());
                        jSONObject.put(an.k, anVar.k());
                        jSONObject.put(an.j, anVar.j());
                        jSONObject.put(an.l, anVar.l());
                        jSONObject.put(an.i, anVar.i());
                        jSONObject.put(an.m, anVar.m());
                        jSONObject.put(bt.af, UMUtils.getZid(context));
                        jSONObject.put("platform", "android");
                        jSONObject.put("optional", new JSONObject(as.a()));
                        String[] strArrSplit = str.split("@");
                        if (strArrSplit.length == 4) {
                            try {
                                long j = Long.parseLong(strArrSplit[0]);
                                String str2 = strArrSplit[1];
                                jSONObject.put("s1", j);
                                jSONObject.put("s2", str2);
                            } catch (Throwable unused) {
                            }
                        }
                        try {
                            if (!TextUtils.isEmpty("ColorOS") && !TextUtils.isEmpty("V16.0.0")) {
                                jSONObject.put(an.n, "ColorOS");
                                jSONObject.put(an.o, "V16.0.0");
                            } else {
                                jSONObject.put(an.n, AnalyticsConstants.SDK_TYPE);
                                jSONObject.put(an.o, Build.VERSION.RELEASE);
                            }
                        } catch (Throwable unused2) {
                        }
                        return jSONObject;
                    } catch (JSONException e2) {
                        e = e2;
                        jSONObject2 = jSONObject;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                        return jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject2 = jSONObject;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                        return jSONObject2;
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject a(Context context, int i, JSONArray jSONArray, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put("atoken", zid);
                    jSONObject.put("oaid", DeviceConfig.getOaid(context));
                    jSONObject.put(bt.g, UMEnvelopeBuild.imprintProperty(context, bt.g, ""));
                    jSONObject.put(bt.F, Build.BRAND);
                    String deviceToken = UMUtils.getDeviceToken(context);
                    if (!TextUtils.isEmpty(deviceToken)) {
                        jSONObject.put("device_token", deviceToken);
                    }
                    jSONObject.put("model", Build.MODEL);
                    jSONObject.put(bt.x, "android");
                    jSONObject.put(bt.y, Build.VERSION.RELEASE);
                    jSONObject.put("appkey", UMConfigure.sAppkey);
                    jSONObject.put("app_version", DeviceConfig.getAppVersionName(context));
                    jSONObject.put("packagename", DeviceConfig.getPackageName(context));
                    jSONObject.put("app_display_name", DeviceConfig.getAppName(context));
                    String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                    if (!"Wi-Fi".equals(networkAccessMode[0])) {
                        if ("2G/3G".equals(networkAccessMode[0])) {
                            jSONObject.put(bt.Q, "2G/3G");
                        } else {
                            jSONObject.put(bt.Q, "unknow");
                        }
                    } else {
                        jSONObject.put(bt.Q, "wifi");
                    }
                    if (!"".equals(networkAccessMode[1])) {
                        jSONObject.put("sub_access", networkAccessMode[1]);
                    }
                    jSONObject.put("sdkType", AnalyticsConstants.SDK_TYPE);
                    jSONObject.put("sdk_version", "9.8.8");
                    jSONObject.put("session_id", aa.a().d(context));
                    jSONObject.put(bt.an, DeviceConfig.getRingerMode(context));
                    jSONObject.put(com.umeng.ccg.a.u, str);
                    jSONObject.put(com.umeng.ccg.a.x, jSONArray);
                    if (z) {
                        jSONObject.put("am", DeviceConfig.isAirplaneModeOn(context));
                    }
                    jSONObject.put("e", i);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
