package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ajf {
    public static final dov a = new dov(new h(29));

    public static List b(Boolean bool) {
        try {
            bae baeVar = new bae(la.b(bmy.q()), true, aje.a);
            cnb.z(-25430501358378L);
            bae baeVar2 = new bae(new bae(baeVar, true, new age(27)), true, new q(bool, 3));
            abo aboVar = new abo(new bgf[]{new age(28), new age(29)}, 0);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            baa baaVar = new baa(baeVar2);
            while (baaVar.hasNext()) {
                arrayList.add(baaVar.next());
            }
            abe.am(arrayList, aboVar);
            for (Object obj : arrayList) {
                String strG = ((doo) obj).g();
                Object arrayList2 = linkedHashMap.get(strG);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(strG, arrayList2);
                }
                ((List) arrayList2).add(obj);
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List<doo> list = (List) entry.getValue();
                List listBf = dqc.bf(new nz(str));
                ArrayList arrayList4 = new ArrayList(abb.ak(list, 10));
                for (doo dooVar : list) {
                    String strF = dooVar.f();
                    String strO = dooVar.o();
                    bgf bgfVarP = dooVar.p();
                    arrayList4.add(new ob(strF, strO, dooVar, bgfVarP != null ? new bq(bgfVarP, 4) : null));
                }
                abf.an(arrayList3, aaz.o(listBf, arrayList4));
            }
            return aaz.z(arrayList3);
        } catch (Exception unused) {
            return avd.a;
        }
    }
}
