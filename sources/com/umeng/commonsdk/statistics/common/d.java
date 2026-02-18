package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static d a;
    private static Context b;
    private static String c;
    private static final String d = bd.b().b(bd.m);

    public d(Context context) {
    }

    public static synchronized d a(Context context) {
        try {
            b = context.getApplicationContext();
            c = context.getPackageName();
            if (a == null) {
                a = new d(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    private SharedPreferences f() {
        return b.getSharedPreferences(d + c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences sharedPreferencesF = f();
            String string = sharedPreferencesF.getString("au_p", null);
            String string2 = sharedPreferencesF.getString("au_u", null);
            if (string == null || string2 == null) {
                return null;
            }
            return new String[]{string, string2};
        } catch (Exception unused) {
            return null;
        }
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = f().edit();
        editorEdit.putString("au_p", str);
        editorEdit.putString("au_u", str2);
        editorEdit.commit();
    }
}
