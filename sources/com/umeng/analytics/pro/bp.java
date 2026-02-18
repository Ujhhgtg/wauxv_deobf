package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.vivo.identifier.IdentifierManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bp implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = IdentifierManager.a(context);
        bs.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return IdentifierManager.b(context);
        }
        return null;
    }
}
