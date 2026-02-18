package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class br {
    private static final String a = "ro.build.version.emui";
    private static final String b = "hw_sc.build.platform.version";

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return d() && !g();
    }

    public static boolean c() {
        return d() && g();
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean e() {
        String str = Build.BRAND;
        return str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为") || !TextUtils.isEmpty("") || !TextUtils.isEmpty("");
    }

    public static boolean f() {
        if (!TextUtils.isEmpty("")) {
            return true;
        }
        return false;
    }

    private static boolean g() {
        if (!TextUtils.isEmpty("")) {
            return true;
        }
        return false;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
