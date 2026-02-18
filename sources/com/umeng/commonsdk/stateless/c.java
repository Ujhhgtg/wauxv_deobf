package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public c(Context context) {
        this.c = context;
    }

    public void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.h = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    public void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.g = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.j = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.h = a.j;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.h = a.g;
        }
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) throws Throwable {
        String str4 = str2 + "/" + str;
        if (SdkVersion.SDK_TYPE == 1) {
            return a(bArr, str4, str3);
        }
        if (by.a().b()) {
            String strReplace = str4.replace("ulogs", "cnlogs");
            String strC = cc.b().c();
            if (!TextUtils.isEmpty(strC)) {
                strReplace = by.a(strC, str);
            }
            boolean zA = a(bArr, strReplace, str3);
            if (!zA) {
                String strA = by.a().a(str);
                if (!TextUtils.isEmpty(strA) && !strReplace.equalsIgnoreCase(strA)) {
                    return a(bArr, strA, str3);
                }
            }
            return zA;
        }
        return a(bArr, str4, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0109, code lost:
    
        if (r8 != null) goto L93;
     */
    /* JADX WARN: Found duplicated region for block: B:136:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:143:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:148:? A[SYNTHETIC] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(byte[] r13, java.lang.String r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }
}
