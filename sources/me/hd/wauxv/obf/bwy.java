package me.hd.wauxv.obf;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwy {
    public static final bwy a = new bwy(new bwz(new LocaleList(new Locale[0])));
    public final bwz b;

    public bwy(bwz bwzVar) {
        this.b = bwzVar;
    }

    public static bwy c(String str) {
        if (str == null || str.isEmpty()) {
            return a;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            int i2 = bwx.a;
            localeArr[i] = Locale.forLanguageTag(str2);
        }
        return new bwy(new bwz(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bwy) {
            return this.b.equals(((bwy) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.a.hashCode();
    }

    public final String toString() {
        return this.b.a.toString();
    }
}
