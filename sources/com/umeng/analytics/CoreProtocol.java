package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {
    private static Context a;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a {
        private static final CoreProtocol a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return a.a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        q.a(a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        q.a(a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        q.a(a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return q.a(a).a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        q.a(a).a(obj, i);
    }

    private CoreProtocol() {
    }
}
