package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b b;
    private Context a;
    private c c;

    private b(Context context) {
        this.a = context;
        this.c = new c(context);
    }

    public static synchronized b a(Context context) {
        try {
            if (b == null) {
                b = new b(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public c a() {
        return this.c;
    }
}
