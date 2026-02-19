package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ContextWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmi extends bws {
    public static final dmi a = new dmi();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        for (IEmpty5 bsvVar : OtherStaticHelpers.argsToList(dal.b(ContextWrapper.class), dal.b(Activity.class))) {
            int i = 0;
            cde cdeVarT = dqc.bg(bsvVar).t();
            cdeVarT.ac = new dko(15);
            List<cbq> listAj = cdeVarT.aj();
            dmi dmiVar = a;
            dmiVar.getClass();
            for (cbq cbqVar : listAj) {
                if (!(cbqVar instanceof ConstructorHookWrapper) && !(cbqVar instanceof MethodHookWrapper)) {
                    throw new IllegalStateException(
                            ("This type [" + cbqVar + "] not support to hook, supported are Constructors and Methods")
                                    .toString());
                }
            }
            ArrayList arrayList = new ArrayList(abb.ak(listAj, 10));
            Iterator it = listAj.iterator();
            while (it.hasNext()) {
                arrayList.add(((cbq) it.next()).b());
            }
            Throwable th = new Throwable("There is no hook class instance");
            erp erpVar = new erp(29, false);
            erpVar.v = th;
            aki akiVar = new aki(new but(dmiVar, erpVar), exg.a, exi.c);
            if (!arrayList.isEmpty()) {
                LinkedHashSet linkedHashSet = (LinkedHashSet) akiVar.i;
                linkedHashSet.clear();
                linkedHashSet.addAll(arrayList);
            }
            akiVar.n(new dko(16));
            akiVar.o();
        }
    }
}
