package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cc implements cb {
    private static final String a = "cache_domain";
    private static volatile String b = "";

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a {
        public static final cc a = new cc();

        private a() {
        }
    }

    public static cc b() {
        return a.a;
    }

    private void d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            b = sharedPreferences.getString(a, "");
        }
    }

    private void e() {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(a, b).commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a() {
    }

    public String c() {
        return b;
    }

    private cc() {
        d();
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(Throwable th) {
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                String strOptString = jSONObject.optString("Answer");
                String strOptString2 = "";
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                if (jSONObject.has("ip")) {
                    strOptString2 = jSONObject.optString("ip");
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + strOptString2);
                }
                b = strOptString;
                e();
            }
        } catch (Throwable unused) {
        }
    }
}
