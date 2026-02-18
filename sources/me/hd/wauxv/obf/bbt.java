package me.hd.wauxv.obf;

import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbt {
    public final String a;
    public final String b;
    public final String c;
    public final List d;
    public final String e;
    public final String f;
    public final String g;

    public bbt(String str, String str2, String str3, String str4, String str5, List list) {
        str.getClass();
        this.a = str;
        str2.getClass();
        this.b = str2;
        this.c = str3;
        list.getClass();
        this.d = list;
        this.e = str4;
        this.f = str5;
        this.g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mSystemFont: " + this.e + ", mVariationSettings: " + this.f + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.d;
            if (i >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List list2 = (List) list.get(i);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list2.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i++;
        }
    }
}
