package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aca implements cqw {
    public final /* synthetic */ int a;
    public final /* synthetic */ hb c;

    public /* synthetic */ aca(hb hbVar, int i) {
        this.a = i;
        this.c = hbVar;
    }

    @Override // me.hd.wauxv.obf.cqw
    public final void b(aci aciVar) {
        switch (this.a) {
            case 0:
                throwIfVar1IsNull(aciVar, "it");
                hb hbVar = this.c;
                Bundle bundleG = ((but) hbVar.t.c).g("android:support:activity-result");
                if (bundleG != null) {
                    acg acgVar = hbVar.x;
                    LinkedHashMap linkedHashMap = acgVar.b;
                    LinkedHashMap linkedHashMap2 = acgVar.a;
                    Bundle bundle = acgVar.g;
                    ArrayList<Integer> integerArrayList = bundleG
                            .getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleG
                            .getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList != null && integerArrayList != null) {
                        ArrayList<String> stringArrayList2 = bundleG
                                .getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                        if (stringArrayList2 != null) {
                            acgVar.d.addAll(stringArrayList2);
                        }
                        Bundle bundle2 = bundleG.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                        if (bundle2 != null) {
                            bundle.putAll(bundle2);
                        }
                        int size = stringArrayList.size();
                        for (int i = 0; i < size; i++) {
                            String str = stringArrayList.get(i);
                            if (linkedHashMap.containsKey(str)) {
                                Integer num = (Integer) linkedHashMap.remove(str);
                                if (!bundle.containsKey(str)) {
                                    emc.ae(linkedHashMap2);
                                    linkedHashMap2.remove(num);
                                }
                            }
                            Integer num2 = integerArrayList.get(i);
                            throwIfVar1IsNull(num2, "rcs[i]");
                            int iIntValue = num2.intValue();
                            String str2 = stringArrayList.get(i);
                            throwIfVar1IsNull(str2, "keys[i]");
                            String str3 = str2;
                            linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                            acgVar.b.put(str3, Integer.valueOf(iIntValue));
                        }
                        break;
                    }
                }
                break;
            default:
                bdm bdmVar = (bdm) this.c.c.v;
                bdmVar.g.ax(bdmVar, bdmVar, null);
                break;
        }
    }
}
