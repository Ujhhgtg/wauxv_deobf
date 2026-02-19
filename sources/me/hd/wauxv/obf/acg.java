package me.hd.wauxv.obf;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acg {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final ArrayList d = new ArrayList();
    public final transient LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final Bundle g = new Bundle();
    public final /* synthetic */ hb h;

    public acg(hb hbVar) {
        this.h = hbVar;
    }

    public final boolean i(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        dv dvVar = (dv) this.e.get(str);
        if ((dvVar != null ? dvVar.a : null) != null) {
            ArrayList arrayList = this.d;
            if (arrayList.contains(str)) {
                dvVar.a.c(dvVar.b.d(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.g.putParcelable(str, new dp(intent, i2));
        return true;
    }

    public final void j(int i, bhs bhsVar, String str) {
        Bundle bundleExtra;
        int i2;
        hb hbVar = this.h;
        LateinitProperty lateinitPropertyVarC = bhsVar.c(hbVar, str);
        if (lateinitPropertyVarC != null) {
            new Handler(Looper.getMainLooper()).post(new acf(this, i, lateinitPropertyVarC, 0));
            return;
        }
        Intent intentB = bhsVar.b(hbVar, str);
        if (intentB.getExtras() != null) {
            Bundle extras = intentB.getExtras();
            throwIfVar1IsNull(extras);
            if (extras.getClassLoader() == null) {
                intentB.setExtrasClassLoader(hbVar.getClassLoader());
            }
        }
        if (intentB.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentB.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentB.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentB.getAction())) {
            String[] stringArrayExtra = intentB
                    .getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < stringArrayExtra.length; i3++) {
                if (TextUtils.isEmpty(stringArrayExtra[i3])) {
                    throw new IllegalArgumentException(yg.concatToVar1(new StringBuilder("Permission request for permissions "),
                            Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33
                        && TextUtils.equals(stringArrayExtra[i3], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i3));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i4 = 0;
                for (int i5 = 0; i5 < stringArrayExtra.length; i5++) {
                    if (!hashSet.contains(Integer.valueOf(i5))) {
                        strArr[i4] = stringArrayExtra[i5];
                        i4++;
                    }
                }
            }
            hbVar.requestPermissions(stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentB.getAction())) {
            hbVar.startActivityForResult(intentB, i, bundle);
            return;
        }
        bql bqlVar = (bql) intentB.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            throwIfVar1IsNull(bqlVar);
            i2 = i;
            try {
                hbVar.startIntentSenderForResult(bqlVar.a, i2, bqlVar.b, bqlVar.c, bqlVar.d, 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new acf(this, i2, e, 1));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }

    public final dy k(String str, bhs bhsVar, dq dqVar) {
        throwIfVar1IsNull(str, "key");
        l(str);
        this.e.put(str, new dv(dqVar, bhsVar));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            dqVar.c(obj);
        }
        Bundle bundle = this.g;
        dp dpVar = (dp) bhs.t(str, bundle);
        if (dpVar != null) {
            bundle.remove(str);
            dqVar.c(bhsVar.d(dpVar.b, dpVar.a));
        }
        return new dy(this, str, bhsVar, 1);
    }

    public final void l(String str) {
        LinkedHashMap linkedHashMap = this.b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        for (Number number : new ada(new alu(dx.a, new dbj(20)))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.a;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void m(String str) {
        Integer num;
        throwIfVar1IsNull(str, "key");
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            StringBuilder sbZ = StaticHelpers6.concatAndToSb("Dropping pending result for request ", str, ": ");
            sbZ.append(linkedHashMap.get(str));
            Log.w("ActivityResultRegistry", sbZ.toString());
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry",
                    "Dropping pending result for request " + str + ": " + ((dp) bhs.t(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.c;
        dw dwVar = (dw) linkedHashMap2.get(str);
        if (dwVar != null) {
            ArrayList arrayList = dwVar.b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                dwVar.a.o((bul) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
