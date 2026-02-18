package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class dfv extends dfw {
    public static dft a(Iterator it) {
        throwIfVar1IsNull(it, "<this>");
        return new ada(new lb(it, 2));
    }

    public static Object ah(bae baeVar) {
        baa baaVar = new baa(baeVar);
        if (baaVar.hasNext()) {
            return baaVar.next();
        }
        return null;
    }

    public static dft ai(Object obj, IHasInvokeMethod bgfVar) {
        return obj == null ? avg.a : new alu(new wi(obj, 2), bgfVar);
    }

    public static Object aj(dft dftVar) {
        Iterator it = dftVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static List ak(dft dftVar) {
        Iterator it = dftVar.iterator();
        if (!it.hasNext()) {
            return avd.a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return dqc.bf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static int d(dft dftVar) {
        Iterator it = dftVar.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }
}
