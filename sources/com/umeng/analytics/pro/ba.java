package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.analytics.pro.az;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ba implements az.a {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a {
        private static final ba a = new ba();

        private a() {
        }
    }

    public static ba a() {
        return a.a;
    }

    @Override // com.umeng.analytics.pro.az.a
    public void a(Object obj, int i) {
        JSONObject jSONObjectA;
        if (i != 101) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]: unknown event type!");
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]:recv CkDispatch.CHECK event!");
        Context appContext = UMGlobalContext.getAppContext();
        if (!UMConfigure.getInitStatus() || appContext == null || UMConfigure.needSendZcfgEnv(appContext) || com.umeng.commonsdk.utils.c.a() || FieldManager.allow(com.umeng.commonsdk.utils.d.aw) || SdkVersion.SDK_TYPE == 1 || !(obj instanceof bb)) {
            return;
        }
        try {
            JSONObject jSONObjectG = ((bb) obj).g();
            if (!jSONObjectG.has("eID") || (jSONObjectA = bc.a(appContext)) == null) {
                return;
            }
            bc.a(jSONObjectA, jSONObjectG);
            av.a(new aq(aq.c, jSONObjectA, "appkey"), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }
}
