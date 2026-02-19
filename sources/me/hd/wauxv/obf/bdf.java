package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdf extends bdh {
    public final /* synthetic */ erp a;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ bhs d;
    public final /* synthetic */ dq e;
    public final /* synthetic */ j f;

    public bdf(j jVar, erp erpVar, AtomicReference atomicReference, bhs bhsVar, dq dqVar) {
        this.f = jVar;
        this.a = erpVar;
        this.c = atomicReference;
        this.d = bhsVar;
        this.e = dqVar;
    }

    @Override // me.hd.wauxv.obf.bdh
    public final void b() {
        StringBuilder sb = new StringBuilder("fragment_");
        j jVar = this.f;
        sb.append(jVar.aw);
        sb.append("_rq#");
        sb.append(jVar.cl.getAndIncrement());
        final String string = sb.toString();
        j jVar2 = (j) this.a.v;
        bdm bdmVar = jVar2.bn;
        final acg acgVar = bdmVar != null ? bdmVar.h.x : jVar2.db().x;
        LinkedHashMap linkedHashMap = acgVar.c;
        throwIfVar1IsNull(string, "key");
        bur burVar = jVar.ch;
        if (burVar.c.compareTo(buh.d) >= 0) {
            throw new IllegalStateException(
                    ("LifecycleOwner " + jVar + " is attempting to register while current state is " + burVar.c
                            + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        acgVar.l(string);
        dw dwVar = (dw) linkedHashMap.get(string);
        if (dwVar == null) {
            dwVar = new dw(burVar);
        }
        final dq dqVar = this.e;
        final bhs bhsVar = this.d;
        bul bulVar = new bul() { // from class: me.hd.wauxv.obf.du
            @Override // me.hd.wauxv.obf.bul
            public final void e(bup bupVar, LifeEventEnum bugVar) {
                acg acgVar2 = acgVar;
                Bundle bundle = acgVar2.g;
                LinkedHashMap linkedHashMap2 = acgVar2.e;
                LinkedHashMap linkedHashMap3 = acgVar2.f;
                LifeEventEnum lifeEventEnumVar2 = LifeEventEnum.ON_START;
                String str = string;
                if (lifeEventEnumVar2 != bugVar) {
                    if (LifeEventEnum.ON_STOP == bugVar) {
                        linkedHashMap2.remove(str);
                        return;
                    } else {
                        if (LifeEventEnum.ON_DESTROY == bugVar) {
                            acgVar2.m(str);
                            return;
                        }
                        return;
                    }
                }
                dq dqVar2 = dqVar;
                bhs bhsVar2 = bhsVar;
                linkedHashMap2.put(str, new dv(dqVar2, bhsVar2));
                if (linkedHashMap3.containsKey(str)) {
                    Object obj = linkedHashMap3.get(str);
                    linkedHashMap3.remove(str);
                    dqVar2.c(obj);
                }
                dp dpVar = (dp) bhs.t(str, bundle);
                if (dpVar != null) {
                    bundle.remove(str);
                    dqVar2.c(bhsVar2.d(dpVar.b, dpVar.a));
                }
            }
        };
        dwVar.a.j(bulVar);
        dwVar.b.add(bulVar);
        linkedHashMap.put(string, dwVar);
        this.c.set(new dy(acgVar, string, bhsVar, 0));
    }
}
