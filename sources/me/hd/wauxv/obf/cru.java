package me.hd.wauxv.obf;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cru {
    public static final cbm a = new cbm(8);
    public final Object b;
    public final crt c;
    public final String d;
    public volatile byte[] e;

    public cru(String str, Object obj, crt crtVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.d = str;
        this.b = obj;
        this.c = crtVar;
    }

    public static cru f(Object obj, String str) {
        return new cru(str, obj, a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof cru) {
            return this.d.equals(((cru) obj).d);
        }
        return false;
    }

    public final int hashCode() {
        return this.d.hashCode();
    }

    public final String toString() {
        return yg.o(new StringBuilder("Option{key='"), this.d, "'}");
    }
}
