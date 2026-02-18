package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ai implements ac {
    private int a;

    public ai(int i) {
        this.a = i;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        long j = 0;
        try {
            SharedPreferences sharedPreferencesA = au.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                j = sharedPreferencesA.getLong(au.a, 0L);
                if (j >= this.a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j + " ; config: " + this.a);
        return false;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ac
    public long c() {
        return 0L;
    }
}
