package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements HostnameVerifier {
    public final /* synthetic */ String a;

    public b(String str) {
        this.a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
    }
}
