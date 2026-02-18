package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class a extends BroadcastReceiver {
    /* JADX WARN: Found duplicated region for block: B:9:0x002d  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean zContains = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        b.a("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            if (TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                zContains = true;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra != null) {
                zContains = stringArrayListExtra.contains(context.getPackageName());
            }
        } else if (intExtra == 0) {
            zContains = true;
        }
        if (zContains) {
            String stringExtra = intent.getStringExtra("openIdType");
            b bVarA = b.a();
            OpenId openId = "oaid".equals(stringExtra) ? bVarA.b : "vaid".equals(stringExtra) ? bVarA.d : "aaid".equals(stringExtra) ? bVarA.c : "udid".equals(stringExtra) ? bVarA.a : null;
            if (openId == null) {
                return;
            }
            openId.b();
        }
    }
}
