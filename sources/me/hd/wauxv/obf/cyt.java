package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyt extends cyw {
    public final bmu a;
    public final /* synthetic */ ea b;

    public cyt(ea eaVar) {
        this.b = eaVar;
        if (eaVar.a > 0) {
            ArrayList arrayList = ((h) eaVar.f) != null ? xf.l : null;
            if (arrayList != null && !arrayList.isEmpty()) {
                throw new IllegalArgumentException("You can only use once dataSetCount or entities on RecyclerView.Adapter.");
            }
        }
        this.a = new bmu(eaVar);
    }

    public final boolean c(int i) {
        this.b.o();
        return false;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        int iIntValue;
        ArrayList arrayList;
        ea eaVar = this.b;
        int i = eaVar.a;
        Integer numValueOf = Integer.valueOf(i);
        Integer numValueOf2 = null;
        if (i < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            if (((h) eaVar.f) != null && (arrayList = xf.l) != null) {
                numValueOf2 = Integer.valueOf(arrayList.size());
            }
            iIntValue = numValueOf2 != null ? numValueOf2.intValue() : 0;
        }
        eaVar.p();
        eaVar.o();
        return iIntValue;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final long e(int i) {
        ea eaVar = this.b;
        eaVar.p();
        c(i);
        eaVar.p();
        ea.g(eaVar, i);
        return i;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(czx czxVar, int i) throws Throwable {
        dab dabVar = (dab) czxVar;
        int i2 = dabVar.ao;
        final ea eaVar = this.b;
        eaVar.p();
        c(i);
        eaVar.p();
        cyq cyqVar = new cyq(eaVar, dabVar, 0);
        cyq cyqVar2 = new cyq(eaVar, dabVar, 1);
        cyq cyqVar3 = new cyq(eaVar, dabVar, 2);
        final eb ebVar = new eb();
        ebVar.a = cyqVar;
        ebVar.b = cyqVar2;
        ebVar.c = cyqVar3;
        LinkedHashSet linkedHashSet = (LinkedHashSet) eaVar.c;
        ArrayList<daa> arrayList = new ArrayList();
        for (Object obj : linkedHashSet) {
            ((daa) obj).getClass();
            if (i2 == 0) {
                arrayList.add(obj);
            }
        }
        for (daa daaVar : arrayList) {
            Object objG = ea.g(eaVar, i);
            if (objG == null) {
                return;
            } else {
                daaVar.b.b(dabVar.b, objG, ebVar);
            }
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) eaVar.d;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Number number = (Number) entry.getKey();
            if (number instanceof Long) {
                if (number.equals(-1L) || number.equals(Long.valueOf(e(i)))) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            } else if ((number instanceof Integer) && (number.equals(0) || number.equals(Integer.valueOf(i2)))) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap2.isEmpty()) {
            linkedHashMap2 = null;
        }
        if (linkedHashMap2 != null) {
            dabVar.d.setOnClickListener(new cyr(linkedHashMap2, ebVar, eaVar, 0));
        }
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) eaVar.e;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
            Number number2 = (Number) entry2.getKey();
            if (number2 instanceof Long) {
                if (number2.equals(-1L) || number2.equals(Long.valueOf(e(i)))) {
                    linkedHashMap4.put(entry2.getKey(), entry2.getValue());
                }
            } else if ((number2 instanceof Integer) && (number2.equals(0) || number2.equals(Integer.valueOf(i2)))) {
                linkedHashMap4.put(entry2.getKey(), entry2.getValue());
            }
        }
        final LinkedHashMap linkedHashMap5 = linkedHashMap4.isEmpty() ? null : linkedHashMap4;
        if (linkedHashMap5 != null) {
            dabVar.ap.setOnLongClickListener(new View.OnLongClickListener() { // from class: me.hd.wauxv.obf.cys
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    Iterator it = linkedHashMap5.entrySet().iterator();
                    while (true) {
                        boolean z = false;
                        while (it.hasNext()) {
                            bgk bgkVar = (bgk) ((Map.Entry) it.next()).getValue();
                            int iIntValue = ((Number) ebVar.b.invoke()).intValue();
                            if (!z) {
                                Object objG2 = ea.g(eaVar, iIntValue);
                                if (objG2 != null) {
                                    Boolean bool = (Boolean) bgkVar.b(view, objG2, Integer.valueOf(iIntValue));
                                    bool.getClass();
                                    if (bool.booleanValue()) {
                                    }
                                }
                            }
                            z = true;
                        }
                        return z;
                    }
                }
            });
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final czx g(ViewGroup viewGroup, int i) throws IllegalAccessException, cth {
        Object next;
        ea eaVar = this.b;
        LinkedHashSet linkedHashSet = (LinkedHashSet) eaVar.c;
        Iterator it = linkedHashSet.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ((daa) next).getClass();
        } while (i != 0);
        daa daaVar = (daa) next;
        if (daaVar == null) {
            throw new IllegalStateException(((linkedHashSet.isEmpty() || i != 0) ? !linkedHashSet.isEmpty() ? yg.m(yg.q(i, i, "No ViewHolder with type ", " found, are you sure you used onBindViewType to create a processor that uses type ", " or created one using onBindItemView by type "), TypeDescription.Generic.OfWildcardType.SYMBOL, i) : "No ViewHolder found, are you sure you have created one using onBindItemView?" : "No default view type 0 found, you need to declare a default view type 0 or used onBindViewType to create a processor.").toString());
        }
        erp erpVar = daaVar.a;
        int i2 = dab.a;
        Context context = (Context) eaVar.b;
        DefaultConfig ioVar = (DefaultConfig) erpVar.v;
        LinkedHashMap linkedHashMap = blu.a;
        Class cls = (Class) ioVar.c;
        ws wsVar = (ws) ioVar.d;
        ArrayList arrayList = new ArrayList();
        if (blu.c) {
            arrayList.add(new blv(emn.an(context), 0));
        }
        blu bluVar = new blu(aaz.z(arrayList));
        wsVar.invoke(blu.i(bluVar, cls, viewGroup, false, context));
        return new dab(bluVar, i, bluVar.k());
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int i(int i) {
        ea eaVar = this.b;
        eaVar.p();
        c(i);
        eaVar.p();
        ea.g(eaVar, i);
        return 0;
    }
}
