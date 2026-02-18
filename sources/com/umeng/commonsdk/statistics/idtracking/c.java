package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public static final String a = bd.b().b(bd.l);
    public static final String b = "key_umeng_sp_honor_oaid";
    private static final String c = "honor_oaid";
    private Context d;

    public c(Context context) {
        super(c);
        this.d = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!UMConfigure.shouldCollectOaid()) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** HonorOaidTracker.getId(): oaid开关已关闭。");
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                SharedPreferences sharedPreferences = this.d.getSharedPreferences(a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(b, "");
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
