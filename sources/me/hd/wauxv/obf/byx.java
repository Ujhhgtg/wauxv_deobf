package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class byx implements bgk {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object c;

    public /* synthetic */ byx(Object obj, int i) {
        this.a = i;
        this.c = obj;
    }

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) throws Throwable {
        Object objX;
        Object objX2;
        int i = this.a;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj4;
                int i2 = MainActivity.as;
                eqj eqjVar = mainActivity._ac;
                throwIfVar1IsNull(eqjVar);
                ((dj) eqjVar).b.setVisibility(8);
                eqj eqjVar2 = mainActivity._ac;
                throwIfVar1IsNull(eqjVar2);
                ((dj) eqjVar2).g.setVisibility(0);
                eqj eqjVar3 = mainActivity._ac;
                throwIfVar1IsNull(eqjVar3);
                ((dj) eqjVar3).k.setText((String) obj);
                eqj eqjVar4 = mainActivity._ac;
                throwIfVar1IsNull(eqjVar4);
                ((dj) eqjVar4).j.setText((String) obj2);
                eqj eqjVar5 = mainActivity._ac;
                throwIfVar1IsNull(eqjVar5);
                ((dj) eqjVar5).c.setOnClickListener(new bq((bfu) obj3, 8));
                return kotlinUnitVar;
            case 1:
                wx wxVar = (wx) obj4;
                eb ebVar = (eb) obj3;
                if (obj2 == null) {
                    throw new IllegalStateException("An existing binding object cannot be passed into a null entity.");
                }
                wxVar.b(obj, obj2, ebVar);
                return kotlinUnitVar;
            case 2:
                byx byxVar = (byx) obj4;
                eb ebVar2 = (eb) obj3;
                try {
                    throwIfVar1IsNull(obj,
                            "null cannot be cast to non-null type VD of com.highcapable.betterandroid.ui.component.adapter.RecyclerAdapterBuilder.onBindNullableItemView");
                    byxVar.b(obj, obj2, ebVar2);
                    objX = kotlinUnitVar;
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Throwable thB = dcy.b(objX);
                if (thB == null) {
                    return kotlinUnitVar;
                }
                if (thB instanceof ClassCastException) {
                    throw new IllegalStateException(
                            "The correct entity type is not provided with onBindData. Please remove the generic declaration or use onBindData to pass in the corresponding entity type collection.");
                }
                throw thB;
            default:
                exf exfVar = (exf) obj4;
                Intent intent = (Intent) obj3;
                String action = intent.getAction();
                if (action != null) {
                    try {
                        ConcurrentHashMap concurrentHashMap = exfVar.g;
                        objX2 = null;
                        if (concurrentHashMap.isEmpty()) {
                            concurrentHashMap = null;
                        }
                        if (concurrentHashMap != null) {
                            ArrayList arrayList = new ArrayList();
                            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                                String str = (String) entry.getKey();
                                Pair pairVar = (Pair) entry.getValue();
                                Object obj5 = pairVar.first;
                                Activity activity = obj5 instanceof Activity ? (Activity) obj5 : null;
                                if (activity != null && activity.isDestroyed()) {
                                    arrayList.add(str);
                                } else if (exfVar.l((Context) pairVar.first)) {
                                    ((bgj) pairVar.second).g(action, intent);
                                }
                            }
                            ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
                            if (arrayList2 != null) {
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    concurrentHashMap.remove((String) it.next());
                                }
                            }
                            objX2 = concurrentHashMap;
                        }
                    } catch (Throwable th2) {
                        objX2 = bhu.x(th2);
                    }
                    Throwable thB2 = dcy.b(objX2);
                    if (thB2 != null) {
                        ArrayList arrayList3 = ewq.a;
                        ewq.g(4, "Received action \"" + action + "\" failed", thB2);
                    }
                    break;
                }
                return kotlinUnitVar;
        }
    }

    public /* synthetic */ byx(ea eaVar, byx byxVar) {
        this.a = 2;
        this.c = byxVar;
    }
}
