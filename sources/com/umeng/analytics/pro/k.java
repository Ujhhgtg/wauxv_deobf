package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static final int a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class b {
        private static final k a = new k();

        private b() {
        }
    }

    public static k a(Context context) {
        k kVar = b.cachedConstructors;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            kVar.k();
        }
        return kVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (!Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    e = sb.toString();
                }
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                e += new StringBuilder(e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(d, h, c(f));
                } else {
                    if (f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    public void d() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                String strC = w.a().c();
                if (TextUtils.isEmpty(strC)) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                    i.a(d).tryGetClassByName();
                    return;
                }
                String[] strArr = { "", "-1" };
                for (int i = 0; i < 2; i++) {
                    sQLiteDatabaseA.execSQL("update __et set __i=\"" + strC + "\" where __i=\"" + strArr[i] + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused2) {
                    }
                }
                i.a(d).tryGetClassByName();
            }
        } catch (SQLiteDatabaseCorruptException unused3) {
            j.a(d);
        } catch (Throwable unused4) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /*
     * JADX WARN: Found duplicated region for block: B:53:0x0089 A[DONT_GENERATE,
     * EXC_TOP_SPLITTER, PHI: r4 r6
     * 0x0089: PHI (r4v3 org.json.JSONObject) = (r4v2 org.json.JSONObject), (r4v5
     * org.json.JSONObject) binds: [B:28:0x0087, B:34:0x00a1] A[DONT_GENERATE,
     * DONT_INLINE]
     * 0x0089: PHI (r6v3 android.database.sqlite.SQLiteDatabase) = (r6v2
     * android.database.sqlite.SQLiteDatabase), (r6v4
     * android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0087, B:34:0x00a1]
     * A[DONT_GENERATE, DONT_INLINE], SYNTHETIC]
     */
    public JSONObject f() {
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = i.a(d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(g.c.cachedConstructors, sQLiteDatabaseA, null, "__ii=? ",
                        new String[] { this.l.get(0) }, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    j.a(d);
                                    return jSONObject;
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i.a(d).tryGetClassByName();
                                }
                            } catch (Throwable unused3) {
                                cursor = cursorA;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused6) {
                }
                i.a(d).tryGetClassByName();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            jSONObject = null;
            sQLiteDatabaseA = null;
        } catch (Throwable unused10) {
            jSONObject = null;
            sQLiteDatabaseA = null;
        }
    }

    /*
     * JADX WARN: Found duplicated region for block: B:53:0x0089 A[DONT_GENERATE,
     * EXC_TOP_SPLITTER, PHI: r4 r6
     * 0x0089: PHI (r4v3 org.json.JSONObject) = (r4v2 org.json.JSONObject), (r4v5
     * org.json.JSONObject) binds: [B:28:0x0087, B:34:0x00a1] A[DONT_GENERATE,
     * DONT_INLINE]
     * 0x0089: PHI (r6v3 android.database.sqlite.SQLiteDatabase) = (r6v2
     * android.database.sqlite.SQLiteDatabase), (r6v4
     * android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0087, B:34:0x00a1]
     * A[DONT_GENERATE, DONT_INLINE], SYNTHETIC]
     */
    public JSONObject g() {
        JSONObject jSONObject;
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor = null;
        jSONObject = null;
        jSONObject = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabaseA = i.a(d).a();
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorA = a(g.d.cachedConstructors, sQLiteDatabaseA, null, "__ii=? ",
                        new String[] { this.i.get(0) }, null, null, null, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = cursorA.getString(cursorA.getColumnIndex("__av"));
                                String string2 = cursorA.getString(cursorA.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = cursorA;
                                try {
                                    j.a(d);
                                    return jSONObject;
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseA != null) {
                                        try {
                                            sQLiteDatabaseA.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    i.a(d).tryGetClassByName();
                                }
                            } catch (Throwable unused3) {
                                cursor = cursorA;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseA != null) {
                                }
                                return jSONObject;
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused6) {
                }
                i.a(d).tryGetClassByName();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            jSONObject = null;
            sQLiteDatabaseA = null;
        } catch (Throwable unused10) {
            jSONObject = null;
            sQLiteDatabaseA = null;
        }
    }

    public void h() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (this.j.size() > 0) {
                    for (int i = 0; i < this.j.size(); i++) {
                        sQLiteDatabaseA.delete(g.b.cachedConstructors, "rowid=?",
                                new String[] { String.valueOf(this.j.get(i).intValue()) });
                    }
                }
                this.j.clear();
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).tryGetClassByName();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    public void i() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("delete from __er");
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).tryGetClassByName();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    public void j() {
        SQLiteDatabase sQLiteDatabaseA;
        if (!TextUtils.isEmpty(this.k)) {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.delete(g.a.cachedConstructors, "__i=?", new String[] { this.k });
                    sQLiteDatabaseA.delete(g.b.cachedConstructors, "__i=?", new String[] { this.k });
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        j.a(d);
                        if (sQLiteDatabaseA != null) {
                        }
                        i.a(d).tryGetClassByName();
                        this.k = null;
                    } catch (Throwable th) {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        i.a(d).tryGetClassByName();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    if (sQLiteDatabaseA != null) {
                    }
                    i.a(d).tryGetClassByName();
                    this.k = null;
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused5) {
                sQLiteDatabaseA = null;
            }
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Throwable unused6) {
            }
            i.a(d).tryGetClassByName();
        }
        this.k = null;
    }

    private k() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? ""
                    : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(g.c.cachedConstructors, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursorA;
        Cursor cursor = null;
        strD = null;
        strD = null;
        String strD = null;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(g.d.cachedConstructors.e);
            if (jSONObjectOptJSONObject != null) {
                sQLiteDatabase2 = sQLiteDatabase;
                cursorA = a(g.d.cachedConstructors, sQLiteDatabase2, new String[] { g.d.cachedConstructors.e },
                        "__ii=? ", new String[] { str }, null, null, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(g.d.cachedConstructors.e)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                cursorA = null;
            }
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray = new JSONArray(strD);
                }
                jSONArray.put(jSONObjectOptJSONObject);
                String strC = c(jSONArray.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase2.execSQL("update  __sd set __d=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(g.d.cachedConstructors.d);
            if (jSONObjectOptJSONObject2 != null) {
                String strC2 = c(jSONObjectOptJSONObject2.toString());
                if (!TextUtils.isEmpty(strC2)) {
                    sQLiteDatabase2.execSQL("update  __sd set __c=\"" + strC2 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase2.execSQL("update  __sd set __f=\""
                    + String.valueOf(jSONObject.optLong(g.d.cachedConstructors.g)) + "\" where __ii=\"" + str + "\"");
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (Throwable unused2) {
        }
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2,
            String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.i.clear();
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:77:0x00a2, code lost:
     * 
     * if (r2 != null) goto L78;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:78:0x00a4, code lost:
     * 
     * r2.endTransaction();
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:81:0x00ad, code lost:
     * 
     * if (r2 != null) goto L78;
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public void a(org.json.JSONArray r11) {
        /*
         * r10 = this;
         * java.lang.String r0 = "__t"
         * java.lang.String r1 = "__i"
         * r2 = 0
         * android.content.Context r3 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> La2
         * android.database.sqlite.SQLiteDatabaseCorruptException -> La8
         * com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3) // Catch:
         * java.lang.Throwable -> La2
         * android.database.sqlite.SQLiteDatabaseCorruptException -> La8
         * android.database.sqlite.SQLiteDatabase r3 = r3.a() // Catch:
         * java.lang.Throwable -> La2
         * android.database.sqlite.SQLiteDatabaseCorruptException -> La8
         * r3.beginTransaction() // Catch: java.lang.Throwable -> L35
         * android.database.sqlite.SQLiteDatabaseCorruptException -> La0
         * r4 = 0
         * L13:
         * int r5 = r11.length() // Catch: java.lang.Throwable -> L35
         * android.database.sqlite.SQLiteDatabaseCorruptException -> La0
         * if (r4 >= r5) goto L90
         * org.json.JSONObject r5 = r11.getJSONObject(r4) // Catch: java.lang.Throwable
         * -> L35 java.lang.Exception -> L8d
         * android.content.ContentValues r6 = new android.content.ContentValues //
         * Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * r6.<init>() // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * java.lang.String r7 = r5.optString(r1) // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * boolean r8 = android.text.TextUtils.isEmpty(r7) // Catch: java.lang.Throwable
         * -> L35 java.lang.Exception -> L8d
         * java.lang.String r9 = "-1"
         * if (r8 != 0) goto L37
         * boolean r8 = r9.equals(r7) // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * if (r8 == 0) goto L46
         * goto L37
         * L35:
         * r2 = r3
         * goto La2
         * L37:
         * com.umeng.analytics.pro.w r7 = com.umeng.analytics.pro.w.a() // Catch:
         * java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * java.lang.String r7 = r7.b() // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * boolean r8 = android.text.TextUtils.isEmpty(r7) // Catch: java.lang.Throwable
         * -> L35 java.lang.Exception -> L8d
         * if (r8 == 0) goto L46
         * r7 = r9
         * L46:
         * r6.put(r1, r7) // Catch: java.lang.Throwable -> L35 java.lang.Exception ->
         * L8d
         * java.lang.String r7 = "__e"
         * java.lang.String r8 = "id"
         * java.lang.String r8 = r5.optString(r8) // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * r6.put(r7, r8) // Catch: java.lang.Throwable -> L35 java.lang.Exception ->
         * L8d
         * int r7 = r5.optInt(r0) // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * java.lang.Integer r7 = java.lang.Integer.valueOf(r7) // Catch:
         * java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * r6.put(r0, r7) // Catch: java.lang.Throwable -> L35 java.lang.Exception ->
         * L8d
         * java.lang.String r7 = "__av"
         * android.content.Context r8 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)
         * // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * r6.put(r7, r8) // Catch: java.lang.Throwable -> L35 java.lang.Exception ->
         * L8d
         * java.lang.String r7 = "__vc"
         * android.content.Context r8 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)
         * // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * r6.put(r7, r8) // Catch: java.lang.Throwable -> L35 java.lang.Exception ->
         * L8d
         * r5.remove(r1) // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * r5.remove(r0) // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
         * java.lang.String r7 = "__s"
         * java.lang.String r5 = r5.toString() // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * java.lang.String r5 = r10.c(r5) // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * r6.put(r7, r5) // Catch: java.lang.Throwable -> L35 java.lang.Exception ->
         * L8d
         * java.lang.String r5 = "__et"
         * r3.insert(r5, r2, r6) // Catch: java.lang.Throwable -> L35
         * java.lang.Exception -> L8d
         * L8d:
         * int r4 = r4 + 1
         * goto L13
         * L90:
         * r3.setTransactionSuccessful() // Catch: java.lang.Throwable -> L35
         * android.database.sqlite.SQLiteDatabaseCorruptException -> La0
         * r3.endTransaction() // Catch: java.lang.Throwable -> L96
         * L96:
         * android.content.Context r11 = com.umeng.analytics.pro.k.d
         * com.umeng.analytics.pro.i r11 = com.umeng.analytics.pro.i.a(r11)
         * r11.b()
         * goto Lb0
         * La0:
         * r2 = r3
         * goto La8
         * La2:
         * if (r2 == 0) goto L96
         * La4:
         * r2.endTransaction() // Catch: java.lang.Throwable -> L96
         * goto L96
         * La8:
         * android.content.Context r11 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> Lb1
         * com.umeng.analytics.pro.j.a(r11) // Catch: java.lang.Throwable -> Lb1
         * if (r2 == 0) goto L96
         * goto La4
         * Lb0:
         * return
         * Lb1:
         * r11 = move-exception
         * if (r2 == 0) goto Lb7
         * r2.endTransaction() // Catch: java.lang.Throwable -> Lb7
         * Lb7:
         * android.content.Context r0 = com.umeng.analytics.pro.k.d
         * com.umeng.analytics.pro.i r0 = com.umeng.analytics.pro.i.a(r0)
         * r0.b()
         * throw r11
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.umeng.analytics.pro.k.a(org.json.JSONArray):void");
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        tryGetClassByName(jSONObject, z);
        return jSONObject;
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str
                    : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
     * JADX WARN: Type inference failed for: r13v3, types: [android.database.Cursor]
     */
    /*
     * JADX WARN: Type inference failed for: r13v6, types: [android.database.Cursor]
     */
    /*
     * JADX WARN: Type inference failed for: r13v7, types: [android.database.Cursor]
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    if (!TextUtils.isEmpty(str)) {
                        cursorA = a(g.a.cachedConstructors, sQLiteDatabaseA, null, "__i=? ", new String[] { str }, null,
                                null, null, null);
                    } else {
                        try {
                            cursorA = a(g.a.cachedConstructors, sQLiteDatabaseA, null, null, null, null, null, null,
                                    null);
                        } catch (SQLiteDatabaseCorruptException unused) {
                            jSONObject = cursor;
                            j.a(d);
                            if (jSONObject != 0) {
                                jSONObject.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            i.a(d).tryGetClassByName();
                        } catch (Throwable unused2) {
                            jSONObject = cursor;
                            j.a(d);
                            if (jSONObject != 0) {
                                jSONObject.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            i.a(d).tryGetClassByName();
                        }
                    }
                    cursor = cursorA;
                    if (cursor != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put(f.U, jSONArray);
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused3) {
                } catch (Throwable unused4) {
                }
            } catch (Throwable th) {
                if (jSONObject != 0) {
                    jSONObject.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                i.a(d).tryGetClassByName();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused6) {
            jSONObject = 0;
            sQLiteDatabaseA = null;
        } catch (Throwable unused7) {
            jSONObject = 0;
            sQLiteDatabaseA = null;
        }
        try {
            sQLiteDatabaseA.endTransaction();
        } catch (Throwable unused8) {
        }
        i.a(d).tryGetClassByName();
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str
                    : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:51:0x0060, code lost:
     * 
     * if (r0 != null) goto L52;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:52:0x0062, code lost:
     * 
     * r0.endTransaction();
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:55:0x006b, code lost:
     * 
     * if (r0 != null) goto L52;
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
         * r4 = this;
         * r0 = 0
         * android.content.Context r1 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L60
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L66
         * com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a(r1) // Catch:
         * java.lang.Throwable -> L60
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L66
         * android.database.sqlite.SQLiteDatabase r1 = r1.a() // Catch:
         * java.lang.Throwable -> L60
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L66
         * r1.beginTransaction() // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * android.content.ContentValues r2 = new android.content.ContentValues //
         * Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * r2.<init>() // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r3 = "__i"
         * r2.put(r3, r5) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r5 = r4.c(r6) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * boolean r6 = android.text.TextUtils.isEmpty(r5) // Catch: java.lang.Throwable
         * -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * if (r6 != 0) goto L50
         * java.lang.String r6 = "__a"
         * r2.put(r6, r5) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r5 = "__t"
         * java.lang.Integer r6 = java.lang.Integer.valueOf(r7) // Catch:
         * java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * r2.put(r5, r6) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r5 = "__av"
         * android.content.Context r6 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)
         * // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * r2.put(r5, r6) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r5 = "__vc"
         * android.content.Context r6 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)
         * // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * r2.put(r5, r6) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * java.lang.String r5 = "__er"
         * r1.insert(r5, r0, r2) // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * goto L50
         * L4c:
         * r0 = r1
         * goto L60
         * L4e:
         * r0 = r1
         * goto L66
         * L50:
         * r1.setTransactionSuccessful() // Catch: java.lang.Throwable -> L4c
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
         * r1.endTransaction() // Catch: java.lang.Throwable -> L56
         * L56:
         * android.content.Context r5 = com.umeng.analytics.pro.k.d
         * com.umeng.analytics.pro.i r5 = com.umeng.analytics.pro.i.a(r5)
         * r5.b()
         * goto L6e
         * L60:
         * if (r0 == 0) goto L56
         * L62:
         * r0.endTransaction() // Catch: java.lang.Throwable -> L56
         * goto L56
         * L66:
         * android.content.Context r5 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L70
         * com.umeng.analytics.pro.j.a(r5) // Catch: java.lang.Throwable -> L70
         * if (r0 == 0) goto L56
         * goto L62
         * L6e:
         * r5 = 0
         * return r5
         * L70:
         * r5 = move-exception
         * if (r0 == 0) goto L76
         * r0.endTransaction() // Catch: java.lang.Throwable -> L76
         * L76:
         * android.content.Context r6 = com.umeng.analytics.pro.k.d
         * com.umeng.analytics.pro.i r6 = com.umeng.analytics.pro.i.a(r6)
         * r6.b()
         * throw r5
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Found duplicated region for block: B:110:0x00ae */
    /* JADX WARN: Found duplicated region for block: B:121:0x00d5 */
    /* JADX WARN: Found duplicated region for block: B:128:0x00e5 */
    /*
     * JADX WARN: Found duplicated region for block: B:144:0x00b1
     * A[EXC_TOP_SPLITTER, PHI: r0 r1 r4
     * 0x00b1: PHI (r0v6 java.lang.String) = (r0v2 java.lang.String), (r0v3
     * java.lang.String), (r0v12 java.lang.String), (r0v12 java.lang.String) binds:
     * [B:122:0x00d8, B:129:0x00e8, B:109:0x00ac, B:110:0x00ae] A[DONT_GENERATE,
     * DONT_INLINE]
     * 0x00b1: PHI (r1v6 android.database.Cursor) =
     * (r1v3 android.database.Cursor)
     * (r1v4 android.database.Cursor)
     * (r1v11 android.database.Cursor)
     * (r1v11 android.database.Cursor)
     * binds: [B:122:0x00d8, B:129:0x00e8, B:109:0x00ac, B:110:0x00ae]
     * A[DONT_GENERATE, DONT_INLINE]
     * 0x00b1: PHI (r4v6 android.database.sqlite.SQLiteDatabase) =
     * (r4v3 android.database.sqlite.SQLiteDatabase)
     * (r4v4 android.database.sqlite.SQLiteDatabase)
     * (r4v7 android.database.sqlite.SQLiteDatabase)
     * (r4v7 android.database.sqlite.SQLiteDatabase)
     * binds: [B:122:0x00d8, B:129:0x00e8, B:109:0x00ac, B:110:0x00ae]
     * A[DONT_GENERATE, DONT_INLINE], SYNTHETIC]
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    private String b(JSONObject jSONObject, boolean z) {
        Cursor cursorA;
        SQLiteDatabase sQLiteDatabaseA;
        String string = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                } catch (Throwable unused2) {
                }
            } catch (Throwable th) {
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                i.a(d).tryGetClassByName();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            cursorA = null;
            sQLiteDatabaseA = null;
        } catch (Throwable unused5) {
            cursorA = null;
            sQLiteDatabaseA = null;
        }
        try {
            cursorA = a(g.c.cachedConstructors, sQLiteDatabaseA, null, null, null, null, null, null, null);
            if (cursorA != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    while (cursorA.moveToNext()) {
                        JSONObject jSONObject2 = new JSONObject();
                        String string2 = cursorA.getString(cursorA.getColumnIndex("__e"));
                        string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                        this.l.add(string);
                        String string3 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                        String string4 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                        if (!TextUtils.isEmpty(string3)) {
                            jSONObject2.put(f.aA, new JSONObject(d(string3)));
                        }
                        if (!TextUtils.isEmpty(string4)) {
                            jSONObject2.put(f.aB, new JSONObject(d(string4)));
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            jSONObject2.put("id", string);
                            jSONObject2.put(f.p, string2);
                            if (jSONObject2.length() > 0) {
                                jSONArray.put(jSONObject2);
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put(f.n, jSONArray);
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursorA != null) {
                        cursorA.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused6) {
                    j.a(d);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    i.a(d).tryGetClassByName();
                    return string;
                } catch (Throwable unused7) {
                    j.a(d);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    if (sQLiteDatabaseA != null) {
                    }
                    i.a(d).tryGetClassByName();
                    return string;
                }
            } else {
                sQLiteDatabaseA.setTransactionSuccessful();
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        } catch (SQLiteDatabaseCorruptException unused8) {
            cursorA = null;
            j.a(d);
            if (cursorA != null) {
                cursorA.close();
            }
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            i.a(d).tryGetClassByName();
            return string;
        } catch (Throwable unused9) {
            cursorA = null;
            j.a(d);
            if (cursorA != null) {
                cursorA.close();
            }
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            i.a(d).tryGetClassByName();
            return string;
        }
        try {
            sQLiteDatabaseA.endTransaction();
        } catch (Throwable unused10) {
        }
        i.a(d).tryGetClassByName();
        return string;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:86:0x008e, code lost:
     * 
     * if (r2 != null) goto L87;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:87:0x0090, code lost:
     * 
     * r2.endTransaction();
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:90:0x0099, code lost:
     * 
     * if (r2 != null) goto L87;
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.k.a r9) {
        /*
         * r6 = this;
         * java.lang.String r0 = "__e"
         * r1 = 0
         * if (r8 != 0) goto L6
         * return r1
         * L6:
         * r2 = 0
         * android.content.Context r3 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L8e
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L94
         * com.umeng.analytics.pro.i r3 = com.umeng.analytics.pro.i.a(r3) // Catch:
         * java.lang.Throwable -> L8e
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L94
         * android.database.sqlite.SQLiteDatabase r3 = r3.a() // Catch:
         * java.lang.Throwable -> L8e
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L94
         * r3.beginTransaction() // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * com.umeng.analytics.pro.k$a r4 = com.umeng.analytics.pro.k.a.BEGIN // Catch:
         * java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * if (r9 != r4) goto L53
         * java.lang.Object r8 = r8.opt(r0) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.Long r8 = (java.lang.Long) r8 // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * long r8 = r8.longValue() // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * android.content.ContentValues r4 = new android.content.ContentValues //
         * Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * r4.<init>() // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r5 = "__ii"
         * r4.put(r5, r7) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r7 = java.lang.String.valueOf(r8) // Catch:
         * java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * r4.put(r0, r7) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r7 = "__av"
         * android.content.Context r8 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)
         * // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * r4.put(r7, r8) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r7 = "__vc"
         * android.content.Context r8 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)
         * // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * r4.put(r7, r8) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * java.lang.String r7 = "__sd"
         * r3.insert(r7, r2, r4) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * goto L7e
         * L4f:
         * r2 = r3
         * goto L8e
         * L51:
         * r2 = r3
         * goto L94
         * L53:
         * com.umeng.analytics.pro.k$a r0 =
         * com.umeng.analytics.pro.k.a.INSTANTSESSIONBEGIN // Catch: java.lang.Throwable
         * -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * if (r9 != r0) goto L5b
         * r6.b(r7, r8, r3) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * goto L7e
         * L5b:
         * com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.END // Catch:
         * java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * if (r9 != r0) goto L63
         * r6.a(r7, r8, r3) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * goto L7e
         * L63:
         * com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.PAGE // Catch:
         * java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * if (r9 != r0) goto L6d
         * java.lang.String r9 = "__a"
         * r6.a(r7, r8, r3, r9) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * goto L7e
         * L6d:
         * com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.AUTOPAGE //
         * Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * if (r9 != r0) goto L77
         * java.lang.String r9 = "__b"
         * r6.a(r7, r8, r3, r9) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * goto L7e
         * L77:
         * com.umeng.analytics.pro.k$a r0 = com.umeng.analytics.pro.k.a.NEWSESSION //
         * Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * if (r9 != r0) goto L7e
         * r6.c(r7, r8, r3) // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * L7e:
         * r3.setTransactionSuccessful() // Catch: java.lang.Throwable -> L4f
         * android.database.sqlite.SQLiteDatabaseCorruptException -> L51
         * r3.endTransaction() // Catch: java.lang.Throwable -> L84
         * L84:
         * android.content.Context r7 = com.umeng.analytics.pro.k.d
         * com.umeng.analytics.pro.i r7 = com.umeng.analytics.pro.i.a(r7)
         * r7.b()
         * goto L9c
         * L8e:
         * if (r2 == 0) goto L84
         * L90:
         * r2.endTransaction() // Catch: java.lang.Throwable -> L84
         * goto L84
         * L94:
         * android.content.Context r7 = com.umeng.analytics.pro.k.d // Catch:
         * java.lang.Throwable -> L9d
         * com.umeng.analytics.pro.j.a(r7) // Catch: java.lang.Throwable -> L9d
         * if (r2 == 0) goto L84
         * goto L90
         * L9c:
         * return r1
         * L9d:
         * r7 = move-exception
         * if (r2 == 0) goto La3
         * r2.endTransaction() // Catch: java.lang.Throwable -> La3
         * La3:
         * android.content.Context r8 = com.umeng.analytics.pro.k.d
         * com.umeng.analytics.pro.i r8 = com.umeng.analytics.pro.i.a(r8)
         * r8.b()
         * throw r7
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.umeng.analytics.pro.k.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.k$a):boolean");
    }

    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabaseA.execSQL("delete from __sd");
                    }
                } else if (this.i.size() > 0) {
                    for (int i = 0; i < this.i.size(); i++) {
                        sQLiteDatabaseA.delete(g.d.cachedConstructors, "__ii=?", new String[] { this.i.get(i) });
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).tryGetClassByName();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        String strC;
        try {
            long jLongValue = ((Long) jSONObject.opt(g.d.cachedConstructors.g)).longValue();
            Object objOpt = jSONObject.opt(g.d.cachedConstructors.h);
            long jLongValue2 = (objOpt == null || !(objOpt instanceof Long)) ? 0L : ((Long) objOpt).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC2 = "";
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
                strC = "";
            } else {
                strC = c(jSONObjectOptJSONObject.toString());
            }
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC2 = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", __g=\"" + jLongValue2 + "\", __sp=\""
                    + strC + "\", __pp=\"" + strC2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /*
     * JADX WARN: Found duplicated region for block: B:20:0x0055 A[Catch: Exception
     * -> 0x0058, TRY_LEAVE, TryCatch #3 {Exception -> 0x0058, blocks: (B:18:0x0050,
     * B:20:0x0055), top: B:33:0x0050 }]
     */
    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        long j = 0;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            sQLiteDatabaseA = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabaseA = null;
        }
        try {
            sQLiteDatabaseA.beginTransaction();
            cursorA = a(g.d.cachedConstructors, sQLiteDatabaseA, new String[] { g.d.cachedConstructors.g }, "__ii=? ",
                    new String[] { str }, null, null, null, null);
            if (cursorA != null) {
                cursorA.moveToFirst();
                j = cursorA.getLong(cursorA.getColumnIndex(g.d.cachedConstructors.g));
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (Exception unused3) {
            if (cursorA != null) {
                cursorA.close();
            }
            if (sQLiteDatabaseA != null) {
            }
            i.a(d).tryGetClassByName();
            return j;
        } catch (Throwable th2) {
            th = th2;
            if (cursorA != null) {
                try {
                    cursorA.close();
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                } catch (Exception unused4) {
                    i.a(d).tryGetClassByName();
                    throw th;
                }
            } else if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            i.a(d).tryGetClassByName();
            throw th;
        }
        sQLiteDatabaseA.endTransaction();
        i.a(d).tryGetClassByName();
        return j;
    }

    public void b(String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.delete(g.c.cachedConstructors, "__ii=?", new String[] { str });
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).tryGetClassByName();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }

    /*
     * JADX WARN: Found duplicated region for block: B:23:0x0055 A[Catch: all ->
     * 0x0062, LOOP:1: B:53:0x004f->B:23:0x0055, LOOP_END, TryCatch #1 {all ->
     * 0x0062, blocks: (B:21:0x004f, B:23:0x0055, B:25:0x0065, B:27:0x0070,
     * B:28:0x0075, B:35:0x0084, B:37:0x008a, B:39:0x0090, B:41:0x0096, B:43:0x00a4,
     * B:40:0x0093), top: B:53:0x004f }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:27:0x0070 A[Catch: all ->
     * 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:21:0x004f, B:23:0x0055,
     * B:25:0x0065, B:27:0x0070, B:28:0x0075, B:35:0x0084, B:37:0x008a, B:39:0x0090,
     * B:41:0x0096, B:43:0x00a4, B:40:0x0093), top: B:53:0x004f }]
     */
    /* JADX WARN: Found duplicated region for block: B:31:0x007d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:32:0x007f */
    /* JADX WARN: Found duplicated region for block: B:34:0x0083 */
    /*
     * JADX WARN: Found duplicated region for block: B:39:0x0090 A[Catch: all ->
     * 0x0062, TRY_ENTER, TryCatch #1 {all -> 0x0062, blocks: (B:21:0x004f,
     * B:23:0x0055, B:25:0x0065, B:27:0x0070, B:28:0x0075, B:35:0x0084, B:37:0x008a,
     * B:39:0x0090, B:41:0x0096, B:43:0x00a4, B:40:0x0093), top: B:53:0x004f }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:43:0x00a4 A[Catch: all ->
     * 0x0062, MOVE_INLINED, TRY_LEAVE, TryCatch #1 {all -> 0x0062, blocks:
     * (B:21:0x004f, B:23:0x0055, B:25:0x0065, B:27:0x0070, B:28:0x0075,
     * B:35:0x0084, B:37:0x008a, B:39:0x0090, B:41:0x0096, B:43:0x00a4,
     * B:40:0x0093), top: B:53:0x004f }]
     */
    /* JADX WARN: Found duplicated region for block: B:45:0x00d7 */
    /*
     * JADX WARN: Found duplicated region for block: B:51:0x008a A[EXC_TOP_SPLITTER,
     * SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:53:0x004f A[EXC_TOP_SPLITTER,
     * LOOP:1: B:53:0x004f->B:23:0x0055, LOOP_START, PHI: r12
     * 0x004f: PHI (r12v2 java.lang.String) = (r12v7 java.lang.String), (r12v3
     * java.lang.String) binds: [B:20:0x004d, B:23:0x0055] A[DONT_GENERATE,
     * DONT_INLINE], SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:59:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) {
        JSONArray jSONArray;
        JSONArray jSONArrayOptJSONArray;
        Cursor cursorA;
        JSONArray jSONArray2;
        int i;
        String strC;
        JSONObject jSONObject2;
        Cursor cursor = null;
        strD = null;
        String strD = null;
        try {
            if ("__a".equals(str2)) {
                jSONArrayOptJSONArray = jSONObject.optJSONArray("__a");
                if (jSONArrayOptJSONArray == null) {
                    return;
                }
                if (jSONArrayOptJSONArray.length() <= 0) {
                    return;
                }
            } else {
                if (g.d.cachedConstructors.c.equals(str2)) {
                    jSONArrayOptJSONArray = jSONObject.optJSONArray(g.d.cachedConstructors.c);
                    if (jSONArrayOptJSONArray == null) {
                        return;
                    }
                    if (jSONArrayOptJSONArray.length() <= 0) {
                        return;
                    }
                } else {
                    jSONArray = null;
                }
                cursorA = a(g.d.cachedConstructors, sQLiteDatabase, new String[] { str2 }, "__ii=? ",
                        new String[] { str }, null, null, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        try {
                            strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                        } catch (Throwable unused) {
                            cursor = cursorA;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(strD)) {
                    jSONArray2 = new JSONArray(strD);
                }
                if (jSONArray2.length() > c) {
                    if (cursorA != null) {
                        cursorA.close();
                        return;
                    }
                    return;
                }
                for (i = 0; i < jSONArray.length(); i++) {
                    try {
                        jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                strC = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(strC)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            }
            jSONArray = jSONArrayOptJSONArray;
            cursorA = a(g.d.cachedConstructors, sQLiteDatabase, new String[] { str2 }, "__ii=? ", new String[] { str },
                    null, null, null, null);
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    strD = d(cursorA.getString(cursorA.getColumnIndex(str2)));
                }
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(strD)) {
                jSONArray2 = new JSONArray(strD);
            }
            if (jSONArray2.length() > c) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            while (i < jSONArray.length()) {
                jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    jSONArray2.put(jSONObject2);
                }
            }
            strC = c(jSONArray2.toString());
            if (!TextUtils.isEmpty(strC)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strC + "\" where __ii=\"" + str + "\"");
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (Throwable unused3) {
        }
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            tryGetClassByName(jSONObject, (String) null);
            a(jSONObject, (String) null);
            return jSONObject;
        }
        String strA = a(jSONObject, z);
        if (!TextUtils.isEmpty(strA)) {
            tryGetClassByName(jSONObject, strA);
            a(jSONObject, strA);
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
     * JADX WARN: Type inference failed for: r13v3, types: [android.database.Cursor]
     */
    /*
     * JADX WARN: Type inference failed for: r13v6, types: [android.database.Cursor]
     */
    /*
     * JADX WARN: Type inference failed for: r13v7, types: [android.database.Cursor]
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        k kVar;
        Cursor cursorA;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    if (!TextUtils.isEmpty(str)) {
                        cursorA = a(g.b.cachedConstructors, sQLiteDatabaseA, null, "__i=? ", new String[] { str }, null,
                                null, null, null);
                        kVar = this;
                    } else {
                        kVar = this;
                        try {
                            cursorA = kVar.a(g.b.cachedConstructors, sQLiteDatabaseA, null, null, null, null, null,
                                    null, null);
                        } catch (SQLiteDatabaseCorruptException unused) {
                            jSONObject = cursor;
                            j.a(d);
                            if (jSONObject != 0) {
                                jSONObject.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            i.a(d).tryGetClassByName();
                        } catch (Throwable unused2) {
                            jSONObject = cursor;
                            j.a(d);
                            if (jSONObject != 0) {
                                jSONObject.close();
                            }
                            if (sQLiteDatabaseA != null) {
                            }
                            i.a(d).tryGetClassByName();
                        }
                    }
                    cursor = cursorA;
                    if (cursor != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        String strB = w.a().b();
                        while (cursor.moveToNext()) {
                            int i = cursor.getInt(cursor.getColumnIndex("__t"));
                            String string = cursor.getString(cursor.getColumnIndex("__i"));
                            String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                            if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                                if (!TextUtils.isEmpty(strB)) {
                                    string = strB;
                                }
                            }
                            kVar.j.add(Integer.valueOf(cursor.getInt(0)));
                            if (i != 2049) {
                                if (i == 2050 && !TextUtils.isEmpty(string2)) {
                                    JSONObject jSONObject4 = new JSONObject(d(string2));
                                    if (jSONObject3.has(string)) {
                                        jSONArray = jSONObject3.optJSONArray(string);
                                    } else {
                                        jSONArray = new JSONArray();
                                    }
                                    jSONArray.put(jSONObject4);
                                    jSONObject3.put(string, jSONArray);
                                }
                            } else if (!TextUtils.isEmpty(string2)) {
                                JSONObject jSONObject5 = new JSONObject(d(string2));
                                if (jSONObject2.has(string)) {
                                    jSONArray2 = jSONObject2.optJSONArray(string);
                                } else {
                                    jSONArray2 = new JSONArray();
                                }
                                jSONArray2.put(jSONObject5);
                                jSONObject2.put(string, jSONArray2);
                            }
                        }
                        if (jSONObject2.length() > 0) {
                            JSONArray jSONArray3 = new JSONArray();
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                JSONObject jSONObject6 = new JSONObject();
                                String next = itKeys.next();
                                jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                                if (jSONObject6.length() > 0) {
                                    jSONArray3.put(jSONObject6);
                                }
                            }
                            if (jSONArray3.length() > 0) {
                                jSONObject.put("ekv", jSONArray3);
                            }
                        }
                        if (jSONObject3.length() > 0) {
                            JSONArray jSONArray4 = new JSONArray();
                            Iterator<String> itKeys2 = jSONObject3.keys();
                            while (itKeys2.hasNext()) {
                                JSONObject jSONObject7 = new JSONObject();
                                String next2 = itKeys2.next();
                                jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                                if (jSONObject7.length() > 0) {
                                    jSONArray4.put(jSONObject7);
                                }
                            }
                            if (jSONArray4.length() > 0) {
                                jSONObject.put(f.Z, jSONArray4);
                            }
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused3) {
                } catch (Throwable unused4) {
                }
            } catch (Throwable th) {
                if (jSONObject != 0) {
                    jSONObject.close();
                }
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                i.a(d).tryGetClassByName();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused6) {
            jSONObject = 0;
            sQLiteDatabaseA = null;
        } catch (Throwable unused7) {
            jSONObject = 0;
            sQLiteDatabaseA = null;
        }
        try {
            sQLiteDatabaseA.endTransaction();
        } catch (Throwable unused8) {
        }
        i.a(d).tryGetClassByName();
    }

    /* JADX WARN: Found duplicated region for block: B:248:0x0241 */
    /* JADX WARN: Found duplicated region for block: B:255:0x0250 */
    /*
     * JADX WARN: Found duplicated region for block: B:283:0x0213
     * A[EXC_TOP_SPLITTER, PHI: r0 r6 r16
     * 0x0213: PHI (r0v6 java.lang.String) = (r0v2 java.lang.String), (r0v3
     * java.lang.String), (r0v39 java.lang.String), (r0v39 java.lang.String) binds:
     * [B:249:0x0244, B:256:0x0253, B:236:0x020e, B:237:0x0210] A[DONT_GENERATE,
     * DONT_INLINE]
     * 0x0213: PHI (r6v6 android.database.Cursor) =
     * (r6v3 android.database.Cursor)
     * (r6v4 android.database.Cursor)
     * (r6v36 android.database.Cursor)
     * (r6v36 android.database.Cursor)
     * binds: [B:249:0x0244, B:256:0x0253, B:236:0x020e, B:237:0x0210]
     * A[DONT_GENERATE, DONT_INLINE]
     * 0x0213: PHI (r16v6 android.database.sqlite.SQLiteDatabase) =
     * (r16v3 android.database.sqlite.SQLiteDatabase)
     * (r16v4 android.database.sqlite.SQLiteDatabase)
     * (r16v28 android.database.sqlite.SQLiteDatabase)
     * (r16v28 android.database.sqlite.SQLiteDatabase)
     * binds: [B:249:0x0244, B:256:0x0253, B:236:0x020e, B:237:0x0210]
     * A[DONT_GENERATE, DONT_INLINE], SYNTHETIC]
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    private String a(JSONObject jSONObject, boolean z) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        JSONArray jSONArray;
        String str;
        String string = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = i.a(d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    try {
                        Cursor cursorA = a(g.d.cachedConstructors, sQLiteDatabaseA, null, null, null, null, null, null,
                                null);
                        if (cursorA != null) {
                            try {
                                jSONArray = new JSONArray();
                                while (true) {
                                    if (!cursorA.moveToNext()) {
                                        cursor = cursorA;
                                        sQLiteDatabase = sQLiteDatabaseA;
                                        break;
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    String string2 = cursorA
                                            .getString(cursorA.getColumnIndex(g.d.cachedConstructors.g));
                                    String string3 = cursorA.getString(cursorA.getColumnIndex("__e"));
                                    String string4 = cursorA
                                            .getString(cursorA.getColumnIndex(g.d.cachedConstructors.h));
                                    string = cursorA.getString(cursorA.getColumnIndex("__ii"));
                                    try {
                                        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                                            str = string;
                                            cursor = cursorA;
                                            sQLiteDatabase = sQLiteDatabaseA;
                                        } else {
                                            if (Long.parseLong(string2) - Long.parseLong(string3) > 0) {
                                                String string5 = cursorA.getString(cursorA.getColumnIndex("__a"));
                                                String string6 = cursorA
                                                        .getString(cursorA.getColumnIndex(g.d.cachedConstructors.c));
                                                String string7 = cursorA
                                                        .getString(cursorA.getColumnIndex(g.d.cachedConstructors.d));
                                                String string8 = cursorA
                                                        .getString(cursorA.getColumnIndex(g.d.cachedConstructors.e));
                                                this.i.add(string);
                                                String string9 = cursorA.getString(cursorA.getColumnIndex("__sp"));
                                                String string10 = cursorA.getString(cursorA.getColumnIndex("__pp"));
                                                jSONObject2.put("id", string);
                                                jSONObject2.put(f.p, string3);
                                                jSONObject2.put(f.q, string2);
                                                str = string;
                                                if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                    cursor = cursorA;
                                                    sQLiteDatabase = sQLiteDatabaseA;
                                                    jSONObject2.put("duration",
                                                            Long.parseLong(string2) - Long.parseLong(string3));
                                                } else {
                                                    try {
                                                        if (Long.parseLong(string4) <= 0) {
                                                            jSONObject2.put("duration",
                                                                    Long.parseLong(string2) - Long.parseLong(string3));
                                                            cursor = cursorA;
                                                            sQLiteDatabase = sQLiteDatabaseA;
                                                        } else {
                                                            cursor = cursorA;
                                                            sQLiteDatabase = sQLiteDatabaseA;
                                                            jSONObject2.put("duration", Long.parseLong(string4));
                                                            jSONObject2.put(f.s,
                                                                    Long.parseLong(string2) - Long.parseLong(string3));
                                                        }
                                                    } catch (SQLiteDatabaseCorruptException unused) {
                                                        cursor = cursorA;
                                                        sQLiteDatabase = sQLiteDatabaseA;
                                                        string = str;
                                                        j.a(d);
                                                        if (cursor != null) {
                                                            cursor.close();
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                            sQLiteDatabase.endTransaction();
                                                        }
                                                        i.a(d).tryGetClassByName();
                                                        return string;
                                                    } catch (Throwable unused2) {
                                                        cursor = cursorA;
                                                        sQLiteDatabase = sQLiteDatabaseA;
                                                        string = str;
                                                        j.a(d);
                                                        if (cursor != null) {
                                                            cursor.close();
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                            sQLiteDatabase.endTransaction();
                                                        }
                                                        i.a(d).tryGetClassByName();
                                                        return string;
                                                    }
                                                }
                                                try {
                                                    if (!TextUtils.isEmpty(string5)) {
                                                        jSONObject2.put(f.t, new JSONArray(d(string5)));
                                                    }
                                                    boolean z2 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                                    if (!TextUtils.isEmpty(string6) && z2) {
                                                        JSONArray jSONArray2 = new JSONArray(d(string6));
                                                        JSONArray jSONArray3 = new JSONArray();
                                                        if (jSONArray2.length() > 0) {
                                                            jSONArray3 = b(jSONArray2);
                                                        }
                                                        jSONObject2.put(f.u, jSONArray3);
                                                    }
                                                    if (!TextUtils.isEmpty(string7)) {
                                                        jSONObject2.put(f.F, new JSONObject(d(string7)));
                                                    }
                                                    if (!TextUtils.isEmpty(string8)) {
                                                        jSONObject2.put("locations", new JSONArray(d(string8)));
                                                    }
                                                    if (!TextUtils.isEmpty(string9)) {
                                                        jSONObject2.put(f.aA, new JSONObject(d(string9)));
                                                    }
                                                    if (!TextUtils.isEmpty(string10)) {
                                                        jSONObject2.put(f.aB, new JSONObject(d(string10)));
                                                    }
                                                    if (jSONObject2.length() > 0) {
                                                        jSONArray.put(jSONObject2);
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused3) {
                                                    string = str;
                                                    j.a(d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    i.a(d).tryGetClassByName();
                                                    return string;
                                                } catch (Throwable unused4) {
                                                    string = str;
                                                    j.a(d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    i.a(d).tryGetClassByName();
                                                    return string;
                                                }
                                            } else {
                                                str = string;
                                                cursor = cursorA;
                                                sQLiteDatabase = sQLiteDatabaseA;
                                            }
                                            if (z) {
                                                string = str;
                                                break;
                                            }
                                        }
                                        cursorA = cursor;
                                        sQLiteDatabaseA = sQLiteDatabase;
                                        string = str;
                                    } catch (SQLiteDatabaseCorruptException unused5) {
                                        cursor = cursorA;
                                        sQLiteDatabase = sQLiteDatabaseA;
                                        j.a(d);
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        i.a(d).tryGetClassByName();
                                        return string;
                                    } catch (Throwable unused6) {
                                        cursor = cursorA;
                                        sQLiteDatabase = sQLiteDatabaseA;
                                        j.a(d);
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        i.a(d).tryGetClassByName();
                                        return string;
                                    }
                                }
                            } catch (SQLiteDatabaseCorruptException unused7) {
                            } catch (Throwable unused8) {
                            }
                            try {
                                if (this.i.size() < 1) {
                                    cursor.close();
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Throwable unused9) {
                                    }
                                    i.a(d).tryGetClassByName();
                                    return string;
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put(f.n, jSONArray);
                                }
                            } catch (SQLiteDatabaseCorruptException unused10) {
                                j.a(d);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                }
                                i.a(d).tryGetClassByName();
                                return string;
                            } catch (Throwable unused11) {
                                j.a(d);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                }
                                i.a(d).tryGetClassByName();
                                return string;
                            }
                        } else {
                            cursor = cursorA;
                            sQLiteDatabase = sQLiteDatabaseA;
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (SQLiteDatabaseCorruptException unused12) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        cursor = null;
                        j.a(d);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        i.a(d).tryGetClassByName();
                        return string;
                    } catch (Throwable unused13) {
                        sQLiteDatabase = sQLiteDatabaseA;
                        cursor = null;
                        j.a(d);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        i.a(d).tryGetClassByName();
                        return string;
                    }
                } catch (SQLiteDatabaseCorruptException unused14) {
                } catch (Throwable unused15) {
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused16) {
                    }
                }
                i.a(d).tryGetClassByName();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused17) {
            cursor = null;
            sQLiteDatabase = null;
        } catch (Throwable unused18) {
            cursor = null;
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused19) {
        }
        i.a(d).tryGetClassByName();
        return string;
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!z2) {
                    int size = this.l.size();
                    int i = 0;
                    if (size > 0) {
                        int i2 = 0;
                        while (i < size) {
                            String str = this.l.get(i);
                            if (str == null) {
                                i2 = 1;
                            }
                            sQLiteDatabaseA.delete(g.c.cachedConstructors, "__ii=?", new String[] { str });
                            i++;
                        }
                        i = i2;
                    }
                    if (i != 0) {
                        sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                    }
                } else if (z) {
                    sQLiteDatabaseA.execSQL("delete from __is");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Throwable th) {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).tryGetClassByName();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
            i.a(d).tryGetClassByName();
        } catch (Throwable unused3) {
            j.a(d);
            if (sQLiteDatabaseA != null) {
            }
            i.a(d).tryGetClassByName();
        }
        try {
            sQLiteDatabaseA.endTransaction();
        } catch (Throwable unused4) {
        }
        i.a(d).tryGetClassByName();
    }

    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = i.a(d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.delete(g.a.cachedConstructors, "__i=?", new String[] { str });
                    sQLiteDatabaseA.delete(g.b.cachedConstructors, "__i=?", new String[] { str });
                    this.j.clear();
                    sQLiteDatabaseA.delete(g.d.cachedConstructors, "__ii=?", new String[] { str });
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                i.a(d).tryGetClassByName();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            j.a(d);
        } catch (Throwable unused3) {
            if (sQLiteDatabaseA != null) {
            }
        }
    }
}
