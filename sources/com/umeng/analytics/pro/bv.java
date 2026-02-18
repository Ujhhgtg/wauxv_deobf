package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.SdkVersion;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bv extends SQLiteOpenHelper {
    private static final Object b = new Object();
    private static bv c = null;
    private static final String d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";
    private static final String e = "DROP TABLE IF EXISTS stf";
    private static final String f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";
    private final Context a;

    private bv(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.a = context;
    }

    public static final int a() {
        return 1;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f);
            } catch (Throwable unused) {
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public boolean c() {
        return !b(bx.c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static bv a(Context context) {
        bv bvVar;
        synchronized (b) {
            try {
                if (c == null) {
                    c = new bv(context, bx.b, null, 1);
                }
                bvVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bvVar;
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        cursorQuery = writableDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase == null) {
                        return false;
                    }
                }
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (writableDatabase == null) {
            return false;
        }
        writableDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public bw a(String str) {
        Cursor cursorA;
        bw bwVar = null;
        try {
            cursorA = a(str, new String[]{bx.i, bx.e, bx.f, bx.g, bx.j, bx.k}, null, null, null, null, null, SdkVersion.MINI_VERSION);
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        bw bwVar2 = new bw();
                        try {
                            bwVar2.a = cursorA.getString(0);
                            bwVar2.b = cursorA.getString(1);
                            String string = cursorA.getString(2);
                            String string2 = cursorA.getString(3);
                            bwVar2.c = k.a(this.a).d(string);
                            bwVar2.d = k.a(this.a).d(string2);
                            bwVar2.e = cursorA.getString(4);
                            bwVar2.f = cursorA.getString(5);
                            bwVar = bwVar2;
                        } catch (Throwable unused) {
                            bwVar = bwVar2;
                            try {
                                d();
                                return bwVar;
                            } finally {
                                if (cursorA != null) {
                                    cursorA.close();
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return bwVar;
        } catch (Throwable unused3) {
            cursorA = null;
        }
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
