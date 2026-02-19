package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ajf {
    public static final Kotlin$Lazy a = new Kotlin$Lazy(new h(29));

    public static List b(Boolean bool) {
        try {
            bae baeVar = new bae(SomeStaticHelpers.b(bmy.q()), true, aje.a);
            "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>" /* "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>" /* "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>" /* "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>" /* cnb.z(-25430501358378L)   */;
            bae baeVar2 = new bae(new bae(baeVar, true, new age(27)), true, new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(bool, 3));
            abo aboVar = new abo(new bgf[]{new age(28), new age(29)}, 0);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            baa baaVar = new baa(baeVar2);
            while (baaVar.hasNext()) {
                arrayList.add(baaVar.next());
            }
            StaticHelpers3.am(arrayList, aboVar);
            for (Object obj : arrayList) {
                String strG = ((BaseHook) obj).g();
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
                List<BaseHook> list = (List) entry.getValue();
                List listBf = dqc.toSingletonList(new nz(str));
                ArrayList arrayList4 = new ArrayList(StaticHelpers4.ak(list, 10));
                for (doo dooVar : list) {
                    String strF = dooVar.f();
                    String strO = dooVar.o();
                    bgf bgfVarP = dooVar.p();
                    arrayList4.add(new ob(strF, strO, dooVar, bgfVarP != null ? new bq(bgfVarP, 4) : null));
                }
                StaticHelpers2.an(arrayList3, StaticHelpers5.o(listBf, arrayList4));
            }
            return StaticHelpers5.z(arrayList3);
        } catch (Exception unused) {
            return EmptyReadonlyList.INSTANCE;
        }
    }
}
