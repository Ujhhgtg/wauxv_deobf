package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.g;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class h extends SQLiteOpenHelper {
    private static Context b;
    private String a;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class a {
        private static final h a = new h(h.b, j.b(h.b), g.b, null, 2);

        private a() {
        }
    }

    public static h a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(
                    "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(
                    "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!j.a(sQLiteDatabase, g.d.a, "__av")) {
            j.a(sQLiteDatabase, g.d.a, "__sp", "TEXT");
            j.a(sQLiteDatabase, g.d.a, "__pp", "TEXT");
            j.a(sQLiteDatabase, g.d.a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.d.a, "__vc", "TEXT");
        }
        if (!j.a(sQLiteDatabase, g.b.a, "__av")) {
            j.a(sQLiteDatabase, g.b.a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.b.a, "__vc", "TEXT");
        }
        if (j.a(sQLiteDatabase, g.a.a, "__av")) {
            return;
        }
        j.a(sQLiteDatabase, g.a.a, "__av", "TEXT");
        j.a(sQLiteDatabase, g.a.a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, g.d.a);
        a(sQLiteDatabase, g.b.a);
        a(sQLiteDatabase, g.a.a);
        a();
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
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    c(sQLiteDatabase);
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                    a(sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused3) {
            j.a(b);
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused4) {
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                f(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            e(sQLiteDatabase);
        }
    }

    private h(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new e(context, str), str2, cursorFactory, i);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(
                    "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private h(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? g.b : str, cursorFactory, i);
        this.a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!j.a(g.d.a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!j.a(g.c.cachedConstructors, writableDatabase)) {
                d(writableDatabase);
            }
            if (!j.a(g.b.a, writableDatabase)) {
                b(writableDatabase);
            }
            if (j.a(g.a.a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(
                    "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
