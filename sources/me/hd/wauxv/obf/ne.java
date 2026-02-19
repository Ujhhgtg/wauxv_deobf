package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ne extends ArrayList {
    public final Object a() {
        if (super.size() == 0) {
            throw new QueryDidNotReturnUniqueResultRuntimeException("No result found for query");
        }
        E e = get(0);
        int size = super.size();
        for (int i = 1; i < size; i++) {
            if (!nullSafeIsEqual(e, get(i))) {
                throw new QueryDidNotReturnUniqueResultRuntimeException(super.size());
            }
        }
        return e;
    }

    public final Object b(IInvokable bgfVar) {
        throwIfVar1IsNull(bgfVar, "predicate");
        if (super.size() == 0) {
            throw new QueryDidNotReturnUniqueResultRuntimeException("No result found for query");
        }
        Iterator<E> it = iterator();
        throwIfVar1IsNull(it, "iterator(...)");
        Object obj = null;
        while (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) bgfVar.invoke(next)).booleanValue()) {
                if (obj != null && !obj.equals(next)) {
                    throw new QueryDidNotReturnUniqueResultRuntimeException(super.size());
                }
                obj = next;
            }
        }
        if (obj != null) {
            return obj;
        }
        throw new QueryDidNotReturnUniqueResultRuntimeException("No result found for query");
    }
}
