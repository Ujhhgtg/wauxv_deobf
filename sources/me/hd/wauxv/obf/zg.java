package me.hd.wauxv.obf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zg {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public zg(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            LifeEventEnum lifeEventEnumVar = (LifeEventEnum) entry.getValue();
            List arrayList = (List) this.a.get(lifeEventEnumVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(lifeEventEnumVar, arrayList);
            }
            arrayList.add((zh) entry.getKey());
        }
    }

    public static void c(List list, bup bupVar, LifeEventEnum lifeEventEnumVar, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                zh zhVar = (zh) list.get(size);
                Method method = zhVar.b;
                try {
                    int i = zhVar.a;
                    if (i == 0) {
                        method.invoke(obj, null);
                    } else if (i == 1) {
                        method.invoke(obj, bupVar);
                    } else if (i == 2) {
                        method.invoke(obj, bupVar, lifeEventEnumVar);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
