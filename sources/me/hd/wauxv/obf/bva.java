package me.hd.wauxv.obf;

import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bva implements ddo {
    public final int a;
    public int b;
    public final Object c;
    public final Object d;
    public final Cloneable e;
    public final Object f;

    public bva(int i) {
        this.c = new DefaultConfig(24);
        this.d = new byf(0);
        this.e = new HashMap();
        this.f = new HashMap();
        this.a = i;
    }

    public void g(int i, Class cls) {
        NavigableMap navigableMapL = l(cls);
        Integer num = (Integer) navigableMapL.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public void h(int i) {
        while (this.b > i) {
            Object objAv = ((DefaultConfig) this.c).av();
            cmz.m(objAv);
            rs rsVarJ = j(objAv.getClass());
            this.b -= rsVarJ.c() * rsVarJ.b(objAv);
            g(rsVarJ.b(objAv), objAv.getClass());
            if (Log.isLoggable(rsVarJ.d(), 2)) {
                Log.v(rsVarJ.d(), "evicted: " + rsVarJ.b(objAv));
            }
        }
    }

    @Override // me.hd.wauxv.obf.ddo
    public boolean hasNext() {
        int i = this.b;
        return i >= 0 && i < ((aff) this.c).a.size();
    }

    public synchronized Object i(int i, Class cls) {
        bye byeVar;
        int i2;
        try {
            Integer num = (Integer) l(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i2 = this.b) != 0 && this.a / i2 < 2 && num.intValue() > i * 8)) {
                byf byfVar = (byf) this.d;
                cut cutVarB = (cut) ((ArrayDeque) byfVar.g).poll();
                if (cutVarB == null) {
                    cutVarB = byfVar.b();
                }
                byeVar = (bye) cutVarB;
                byeVar.b = i;
                byeVar.c = cls;
            } else {
                byf byfVar2 = (byf) this.d;
                int iIntValue = num.intValue();
                cut cutVarB2 = (cut) ((ArrayDeque) byfVar2.g).poll();
                if (cutVarB2 == null) {
                    cutVarB2 = byfVar2.b();
                }
                byeVar = (bye) cutVarB2;
                byeVar.b = iIntValue;
                byeVar.c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return k(byeVar, cls);
    }

    public rs j(Class cls) {
        rs rsVar;
        HashMap map = (HashMap) this.f;
        rs rsVar2 = (rs) map.get(cls);
        if (rsVar2 != null) {
            return rsVar2;
        }
        if (cls.equals(int[].class)) {
            rsVar = new rs(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            rsVar = new rs(0);
        }
        map.put(cls, rsVar);
        return rsVar;
    }

    public Object k(bye byeVar, Class cls) {
        rs rsVarJ = j(cls);
        Object objAg = ((DefaultConfig) this.c).ag(byeVar);
        if (objAg != null) {
            this.b -= rsVarJ.c() * rsVarJ.b(objAg);
            g(rsVarJ.b(objAg), cls);
        }
        if (objAg != null) {
            return objAg;
        }
        if (Log.isLoggable(rsVarJ.d(), 2)) {
            Log.v(rsVarJ.d(), "Allocated " + byeVar.b + " bytes");
        }
        int i = byeVar.b;
        switch (rsVarJ.a) {
            case 0:
                return new byte[i];
            default:
                return new int[i];
        }
    }

    public NavigableMap l(Class cls) {
        HashMap map = (HashMap) this.e;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public synchronized void m(Object obj) {
        Class<?> cls = obj.getClass();
        rs rsVarJ = j(cls);
        int iB = rsVarJ.b(obj);
        int iC = rsVarJ.c() * iB;
        if (iC <= this.a / 2) {
            byf byfVar = (byf) this.d;
            cut cutVarB = (cut) ((ArrayDeque) byfVar.g).poll();
            if (cutVarB == null) {
                cutVarB = byfVar.b();
            }
            bye byeVar = (bye) cutVarB;
            byeVar.b = iB;
            byeVar.c = cls;
            ((DefaultConfig) this.c).as(byeVar, obj);
            NavigableMap navigableMapL = l(cls);
            Integer num = (Integer) navigableMapL.get(Integer.valueOf(byeVar.b));
            Integer numValueOf = Integer.valueOf(byeVar.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.b += iC;
            h(this.a);
        }
    }

    @Override // me.hd.wauxv.obf.ddo
    public ddm next() {
        ddm ddmVar = (ddm) this.d;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        ddmVar.a = i;
        SparseArray sparseArray = (SparseArray) this.e;
        afo afoVarY = sparseArray != null ? (afo) sparseArray.get(i) : null;
        if (afoVarY == null) {
            afoVarY = ((aff) this.c).y(this.b);
        }
        ddmVar.e = afoVarY.b;
        ((y) this.f).d();
        ddmVar.f = Collections.EMPTY_LIST;
        this.b++;
        return ddmVar;
    }

    @Override // me.hd.wauxv.obf.ddo
    public void reset() {
        this.b = this.a;
    }

    public bva(y yVar, aff affVar, int i, SparseArray sparseArray) {
        this.b = i;
        this.a = i;
        ddm ddmVar = new ddm();
        this.d = ddmVar;
        this.c = affVar;
        this.f = yVar;
        ddmVar.b = true;
        ddmVar.c = true;
        ddmVar.d = 0;
        this.e = sparseArray;
    }
}
