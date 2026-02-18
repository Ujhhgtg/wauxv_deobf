package com.uyumao;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final int f;

    public p(Object obj, Object obj2) {
        String strValueOf;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.a = packageInfo.packageName;
        this.c = packageInfo.versionName;
        this.d = packageInfo.firstInstallTime;
        this.e = packageInfo.lastUpdateTime;
        this.f = a(packageInfo);
        try {
            strValueOf = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            strValueOf = "";
        }
        this.b = strValueOf;
    }

    public final int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i = applicationInfo.flags;
        return ((i & 1) == 0 && (i & 128) == 0) ? 1 : 0;
    }
}
