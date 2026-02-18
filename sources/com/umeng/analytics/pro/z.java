package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class z implements y {
    private long a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.y
    public void a(long j) {
        this.a = j;
    }

    @Override // com.umeng.analytics.pro.y
    public long a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(jCurrentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.y
    public boolean a(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (j == 0 || jCurrentTimeMillis - j >= this.a) && j2 > 0 && jCurrentTimeMillis - j2 > this.a;
    }

    @Override // com.umeng.analytics.pro.y
    public void a(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString("session_id", str);
            editorEdit.putLong(w.b, 0L);
            editorEdit.putLong(w.e, jCurrentTimeMillis);
            editorEdit.putLong(w.f, 0L);
            editorEdit.commit();
        } catch (Exception unused) {
        }
    }
}
