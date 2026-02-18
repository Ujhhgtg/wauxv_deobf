package com.umeng.analytics.pro;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class at {
    private static String a = "";
    private static String b = "";
    private static final String c = "hw_sc.build.platform.version";
    private static final String d = "ro.build.version.emui";
    private static final String e = "ro.build.version.magic";
    private static final String f = "ro.miui.ui.version.name";
    private static final String g = "ro.build.version.opporom";
    private static final String h = "ro.vivo.os.name";
    private static final String i = "ro.vivo.os.version";
    private static final String j = "ro.build.version.oplusrom";
    private static final String k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
    
        if (r5.equals("XIAOMI") != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a0, code lost:
    
        if (r5.equals("REALME") != false) goto L45;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.at.e(java.lang.String):void");
    }
}
