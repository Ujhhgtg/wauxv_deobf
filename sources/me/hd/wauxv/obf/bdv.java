package me.hd.wauxv.obf;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.fragment.NavHostFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bdv implements den {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bdv(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.den
    public final Bundle c() {
        Bundle bundleR;
        LinkedHashMap linkedHashMap;
        Pair[] pairVarArr;
        switch (this.a) {
            case 0:
                return ((beg) this.b).cr();
            case 1:
                cjl cjlVar = (cjl) this.b;
                cix cixVar = cjlVar.b;
                LinkedHashMap linkedHashMap2 = cixVar.l;
                km<cio> kmVar = cixVar.f;
                LinkedHashMap linkedHashMap3 = cixVar.k;
                ArrayList arrayList = new ArrayList();
                Bundle bundleR2 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                for (Map.Entry entry : KotlinHelpers.at(cixVar.r.b).entrySet()) {
                    String str = (String) entry.getKey();
                    Bundle bundleR3 = ((ckl) entry.getValue()).r();
                    if (bundleR3 != null) {
                        arrayList.add(str);
                        cnb.ag(bundleR2, str, bundleR3);
                    }
                }
                if (arrayList.isEmpty()) {
                    bundleR = null;
                } else {
                    bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    cnb.ai(bundleR2, "android-support-nav:controller:navigatorState:names", arrayList);
                    cnb.ag(bundleR, "android-support-nav:controller:navigatorState", bundleR2);
                }
                if (kmVar.isEmpty()) {
                    linkedHashMap = linkedHashMap2;
                } else {
                    if (bundleR == null) {
                        bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                    for (cio cioVar : kmVar) {
                        throwIfVar1IsNull(cioVar, "entry");
                        int i = cioVar.b.g.a;
                        String str2 = cioVar.f;
                        ciq ciqVar = cioVar.h;
                        Bundle bundleL = ciqVar.l();
                        LinkedHashMap linkedHashMap4 = linkedHashMap2;
                        Bundle bundleR4 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        ciqVar.h.ab(bundleR4);
                        Bundle bundleR5 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        cnb.ah("nav-entry-state:id", str2, bundleR5);
                        bundleR5.putInt("nav-entry-state:destination-id", i);
                        if (bundleL == null) {
                            bundleL = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        }
                        cnb.ag(bundleR5, "nav-entry-state:args", bundleL);
                        cnb.ag(bundleR5, "nav-entry-state:saved-state", bundleR4);
                        arrayList2.add(bundleR5);
                        linkedHashMap2 = linkedHashMap4;
                    }
                    linkedHashMap = linkedHashMap2;
                    bundleR.putParcelableArrayList("android-support-nav:controller:backStack", arrayList2);
                }
                if (!linkedHashMap3.isEmpty()) {
                    if (bundleR == null) {
                        bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    int[] iArr = new int[linkedHashMap3.size()];
                    ArrayList arrayList3 = new ArrayList();
                    int i2 = 0;
                    for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                        int iIntValue = ((Number) entry2.getKey()).intValue();
                        String str3 = (String) entry2.getValue();
                        int i3 = i2 + 1;
                        iArr[i2] = iIntValue;
                        if (str3 == null) {
                            str3 = "";
                        }
                        arrayList3.add(str3);
                        i2 = i3;
                    }
                    bundleR.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
                    cnb.ai(bundleR, "android-support-nav:controller:backStackIds", arrayList3);
                }
                if (!linkedHashMap.isEmpty()) {
                    if (bundleR == null) {
                        bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                        String str4 = (String) entry3.getKey();
                        km kmVar2 = (km) entry3.getValue();
                        arrayList4.add(str4);
                        ArrayList<? extends Parcelable> arrayList5 = new ArrayList<>();
                        Iterator it = kmVar2.iterator();
                        while (it.hasNext()) {
                            xe xeVar = ((cir) it.next()).a;
                            xeVar.getClass();
                            Bundle bundleR6 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            cnb.ah("nav-entry-state:id", (String) xeVar.d, bundleR6);
                            bundleR6.putInt("nav-entry-state:destination-id", xeVar.c);
                            Bundle bundleR7 = (Bundle) xeVar.e;
                            if (bundleR7 == null) {
                                bundleR7 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            }
                            cnb.ag(bundleR6, "nav-entry-state:args", bundleR7);
                            cnb.ag(bundleR6, "nav-entry-state:saved-state", (Bundle) xeVar.f);
                            arrayList5.add(bundleR6);
                        }
                        String str5 = "android-support-nav:controller:backStackStates:" + str4;
                        throwIfVar1IsNull(str5, "key");
                        bundleR.putParcelableArrayList(str5, arrayList5);
                    }
                    cnb.ai(bundleR, "android-support-nav:controller:backStackStates", arrayList4);
                }
                if (cjlVar.e) {
                    if (bundleR == null) {
                        bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    bundleR.putBoolean("android-support-nav:controller:deepLinkHandled", cjlVar.e);
                }
                if (bundleR != null) {
                    return bundleR;
                }
                Bundle bundle = Bundle.EMPTY;
                throwIfVar1IsNull(bundle, "EMPTY");
                return bundle;
            case 2:
                int i4 = ((NavHostFragment) this.b).c;
                if (i4 != 0) {
                    return bht.r(new Pair("android-support-nav:fragment:graphId", Integer.valueOf(i4)));
                }
                Bundle bundle2 = Bundle.EMPTY;
                throwIfVar1IsNull(bundle2);
                return bundle2;
            default:
                blq blqVar = (blq) this.b;
                for (Map.Entry entry4 : KotlinHelpers.at((LinkedHashMap) blqVar.d).entrySet()) {
                    blqVar.j((String) entry4.getKey(), ((dml) ((chy) entry4.getValue())).c());
                }
                for (Map.Entry entry5 : KotlinHelpers.at((LinkedHashMap) blqVar.b).entrySet()) {
                    blqVar.j((String) entry5.getKey(), ((den) entry5.getValue()).c());
                }
                LinkedHashMap linkedHashMap5 = (LinkedHashMap) blqVar.a;
                if (linkedHashMap5.isEmpty()) {
                    pairVarArr = new Pair[0];
                } else {
                    ArrayList arrayList6 = new ArrayList(linkedHashMap5.size());
                    for (Map.Entry entry6 : linkedHashMap5.entrySet()) {
                        arrayList6.add(new Pair((String) entry6.getKey(), entry6.getValue()));
                    }
                    pairVarArr = (Pair[]) arrayList6.toArray(new Pair[0]);
                }
                return bht.r((Pair[]) Arrays.copyOf(pairVarArr, pairVarArr.length));
        }
    }
}
