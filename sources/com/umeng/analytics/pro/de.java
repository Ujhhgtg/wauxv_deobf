package com.umeng.analytics.pro;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class de {
    public final String a;
    public final byte b;
    public final int c;

    public de() {
        this("", (byte) 0, 0);
    }

    public boolean a(de deVar) {
        return this.a.equals(deVar.a) && this.b == deVar.b && this.c == deVar.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof de) {
            return a((de) obj);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<TMessage name:'");
        sb.append(this.a);
        sb.append("' type: ");
        sb.append((int) this.b);
        sb.append(" seqid:");
        return yg.m(sb, ">", this.c);
    }

    public de(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }
}
