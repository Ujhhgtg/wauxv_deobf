package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aao implements Cloneable {
    public final List a;
    public final List b;

    public aao(ArrayList arrayList, ArrayList arrayList2) {
        this.a = arrayList;
        this.b = arrayList2;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final aao clone() {
        List<ctq> list = this.b;
        ArrayList arrayList = new ArrayList(list.size());
        HashMap map = new HashMap();
        for (ctq ctqVar : list) {
            ctq ctqVar2 = new ctq(ctqVar.a, ctqVar.b, ctqVar.c, ctqVar.d);
            arrayList.add(ctqVar2);
            map.put(ctqVar, ctqVar2);
        }
        List list2 = this.a;
        ArrayList arrayList2 = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            din dinVarB = ((din) it.next()).b();
            arrayList2.add(dinVarB);
            if (dinVarB instanceof ctr) {
                ctr ctrVar = (ctr) dinVarB;
                if (map.get(ctrVar.a) != null) {
                    ctrVar.a = (ctq) map.get(ctrVar.a);
                }
            }
        }
        return new aao(arrayList2, arrayList);
    }
}
