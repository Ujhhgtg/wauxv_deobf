package me.hd.wauxv.obf;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ds extends bhs {
    public final /* synthetic */ int a;

    public /* synthetic */ ds(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bhs
    public final Intent b(hb hbVar, String str) {
        Bundle bundleExtra;
        switch (this.a) {
            case 0:
                Intent type = new Intent("android.intent.action.GET_CONTENT")
                        .addCategory("android.intent.category.OPENABLE").setType(str);
                throwIfVar1IsNull(type, "Intent(Intent.ACTION_GET…          .setType(input)");
                return type;
            case 1:
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS")
                        .putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) str);
                throwIfVar1IsNull(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            case 2:
                return (Intent) str;
            default:
                bql bqlVar = (bql) str;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = bqlVar.b;
                if (intent2 != null && (bundleExtra = intent2
                        .getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        bqlVar = new bql(bqlVar.a, null, bqlVar.c, bqlVar.d);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", bqlVar);
                if (beg.ar(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bhs
    public bc c(hb hbVar, String str) {
        switch (this.a) {
            case 0:
                return null;
            case 1:
                String[] strArr = (String[]) str;
                if (strArr.length == 0) {
                    return new bc(ave.a, 2);
                }
                for (String str2 : strArr) {
                    if (bht.s(hbVar, str2) != 0) {
                        return null;
                    }
                }
                int iAh = KotlinHelpers.ah(strArr.length);
                if (iAh < 16) {
                    iAh = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iAh);
                for (String str3 : strArr) {
                    linkedHashMap.put(str3, Boolean.TRUE);
                }
                return new bc(linkedHashMap, 2);
            default:
                return super.c(hbVar, str);
        }
    }

    @Override // me.hd.wauxv.obf.bhs
    public final Object d(Intent intent, int i) {
        switch (this.a) {
            case 0:
                if (i != -1) {
                    intent = null;
                }
                if (intent != null) {
                    return intent.getData();
                }
                return null;
            case 1:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent
                            .getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent
                            .getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i2 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i2 == 0));
                        }
                        return KotlinHelpers.as(aaz.ae(SomeStaticHelpers.o(stringArrayExtra), arrayList));
                    }
                }
                return ave.a;
            case 2:
                return new dp(intent, i);
            default:
                return new dp(intent, i);
        }
    }
}
