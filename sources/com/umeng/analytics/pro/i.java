package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class i {
    private static SQLiteOpenHelper b;
    private static Context d;
    private AtomicInteger a;
    private SQLiteDatabase c;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a {
        private static final i a = new i();

        private a() {
        }
    }

    public static i a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = h.a(applicationContext);
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private i() {
        this.a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        try {
            if (this.a.incrementAndGet() == 1) {
                this.c = b.getWritableDatabase();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }
}
