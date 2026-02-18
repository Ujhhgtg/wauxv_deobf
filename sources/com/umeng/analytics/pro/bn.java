package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bn implements be {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.a) {
            OpenIDSDK.a(context);
            this.a = true;
        }
        boolean zA = OpenIDSDK.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return OpenIDSDK.c(context);
        }
        return null;
    }
}
