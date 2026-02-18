package com.umeng.analytics.pro;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class db {
    public final String a;
    public final byte b;
    public final short c;

    public db() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(db dbVar) {
        return this.b == dbVar.b && this.c == dbVar.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<TField name:'");
        sb.append(this.a);
        sb.append("' type:");
        sb.append((int) this.b);
        sb.append(" field-id:");
        return yg.m(sb, ">", this.c);
    }

    public db(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }
}
