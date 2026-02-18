package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static Context a;
    private String b;
    private String c;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class C0013a {
        private static final a a = new a();

        private C0013a() {
        }
    }

    public static a a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return C0013a.a;
    }

    private void f(String str) {
        try {
            this.b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(bt.aO);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith("=")) {
                        strSubstring = strSubstring.replace("=", "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.aG);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.aB);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.aE);
    }

    public void e(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        g(strSubstring);
        f(strSubstring);
    }

    private a() {
        this.b = null;
        this.c = null;
    }

    public String b() {
        return this.b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.at);
    }

    public String a() {
        return this.c;
    }
}
