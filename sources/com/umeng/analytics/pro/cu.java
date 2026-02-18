package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cu implements Serializable {
    private final boolean a;
    public final byte b;
    private final String c;
    private final boolean d;

    public cu(byte b, boolean z) {
        this.b = b;
        this.a = false;
        this.c = null;
        this.d = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }

    public cu(byte b) {
        this(b, false);
    }

    public cu(byte b, String str) {
        this.b = b;
        this.a = true;
        this.c = str;
        this.d = false;
    }
}
