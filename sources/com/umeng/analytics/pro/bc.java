package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bc {
    private static String a;

    public static JSONObject a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            if (TextUtils.isEmpty(a)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("appkey", UMUtils.getAppkey(context));
                jSONObject3.put("channel", UMUtils.getChannel(context));
                jSONObject3.put("brand", Build.BRAND);
                jSONObject3.put("osVersion", Build.VERSION.RELEASE);
                jSONObject3.put(bt.g, UMUtils.getUMId(context));
                jSONObject3.put(bt.af, UMUtils.getZid(context));
                jSONObject3.put("deviceModel", Build.MODEL);
                jSONObject3.put("platform", AnalyticsConstants.SDK_TYPE);
                jSONObject3.put("appVersion", DeviceConfig.getAppVersionName(context));
                jSONObject3.put("sdkVersion", "9.8.8");
                a = jSONObject3.toString();
                jSONObject = new JSONObject(a);
            } else {
                try {
                    jSONObject = new JSONObject(a);
                } catch (Exception unused) {
                }
            }
            jSONObject2 = jSONObject;
            jSONObject2.put("sessionid", DeviceConfig.getSid(context));
            jSONObject2.put("ts", System.currentTimeMillis());
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                jSONObject.put("ekverr", jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }
}
