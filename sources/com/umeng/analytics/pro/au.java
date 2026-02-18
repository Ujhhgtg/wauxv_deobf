package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class au {
    public static final String a = "cl_count";
    public static final String b = "interval_";
    public static final String c = "config_ts";
    public static final String d = "iucc_s1";
    public static final String e = "iucc_s2";
    public static final String f = "sdk_type_ver";
    public static final String g = "should_fetch";
    public static final String h = "last_type_index";
    public static final String i = "last_ap_mode";
    public static final String j = "last_ap_time";
    private static final String k = "ccg_sp_config_file";

    private au() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(k, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
