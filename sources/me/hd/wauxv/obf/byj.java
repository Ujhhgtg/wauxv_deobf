package me.hd.wauxv.obf;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class byj {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final Object f;
    public final Object g;

    public byj(int i) {
        this.a = 0;
        this.b = i;
        if (i <= 0) {
            bhv.ai("maxSize <= 0");
            throw null;
        }
        this.f = new bpg(1);
        this.g = new GifEncoder(25);
    }

    public void h(View view) {
        dmb dmbVar = (dmb) view.getLayoutParams();
        dmbVar.a = this;
        ArrayList arrayList = (ArrayList) this.f;
        arrayList.add(view);
        this.c = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.b = Integer.MIN_VALUE;
        }
        if (dmbVar.c.af() || dmbVar.c.ai()) {
            this.d = ((StaggeredGridLayoutManager) this.g).c.f(view) + this.d;
        }
    }

    public void i() {
        dmc dmcVarP;
        View view = (View) StaticHelpers6.getLastNElem(1, (ArrayList) this.f);
        dmb dmbVar = (dmb) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        this.c = staggeredGridLayoutManager.c.e(view);
        if (dmbVar.b && (dmcVarP = staggeredGridLayoutManager.al.p(dmbVar.c.z())) != null && dmcVarP.b == 1) {
            int i = this.c;
            int i2 = this.e;
            int[] iArr = dmcVarP.c;
            this.c = (iArr == null ? 0 : iArr[i2]) + i;
        }
    }

    public void j() {
        dmc dmcVarP;
        View view = (View) ((ArrayList) this.f).get(0);
        dmb dmbVar = (dmb) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        this.b = staggeredGridLayoutManager.c.dexFind(view);
        if (dmbVar.b && (dmcVarP = staggeredGridLayoutManager.al.p(dmbVar.c.z())) != null && dmcVarP.b == -1) {
            int i = this.b;
            int i2 = this.e;
            int[] iArr = dmcVarP.c;
            this.b = i - (iArr != null ? iArr[i2] : 0);
        }
    }

    public void k() {
        ((ArrayList) this.f).clear();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
    }

    public int l() {
        return ((StaggeredGridLayoutManager) this.g).h ? n(r0.size() - 1, -1) : n(0, ((ArrayList) this.f).size());
    }

    public int m() {
        return ((StaggeredGridLayoutManager) this.g).h ? n(0, ((ArrayList) this.f).size()) : n(r0.size() - 1, -1);
    }

    public int n(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        int iN = staggeredGridLayoutManager.c.n();
        int iJ = staggeredGridLayoutManager.c.j();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) ((ArrayList) this.f).get(i);
            int iH = staggeredGridLayoutManager.c.dexFind(view);
            int iE = staggeredGridLayoutManager.c.e(view);
            boolean z = iH <= iJ;
            boolean z2 = iE >= iN;
            if (z && z2 && (iH < iN || iE > iJ)) {
                return czg.el(view);
            }
            i += i3;
        }
        return -1;
    }

    public Object o(Object obj) {
        throwIfVar1IsNull(obj, "key");
        synchronized (((GifEncoder) this.g)) {
            bpg bpgVar = (bpg) this.f;
            bpgVar.getClass();
            Object obj2 = bpgVar.a.get(obj);
            if (obj2 != null) {
                this.d++;
                return obj2;
            }
            this.e++;
            return null;
        }
    }

    public int p(int i) {
        int i2 = this.c;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.f).size() == 0) {
            return i;
        }
        i();
        return this.c;
    }

    public View q(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.g;
        ArrayList arrayList = (ArrayList) this.f;
        View view = null;
        if (i2 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.h && czg.el(view2) >= i)
                        || ((!staggeredGridLayoutManager.h && czg.el(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            View view3 = (View) arrayList.get(i3);
            if ((staggeredGridLayoutManager.h && czg.el(view3) <= i)
                    || ((!staggeredGridLayoutManager.h && czg.el(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i3++;
            view = view3;
        }
        return view;
    }

    public int r(int i) {
        int i2 = this.b;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.f).size() == 0) {
            return i;
        }
        j();
        return this.b;
    }

    public void s() {
        ArrayList arrayList = (ArrayList) this.f;
        int size = arrayList.size();
        View view = (View) arrayList.remove(size - 1);
        dmb dmbVar = (dmb) view.getLayoutParams();
        dmbVar.a = null;
        if (dmbVar.c.af() || dmbVar.c.ai()) {
            this.d -= ((StaggeredGridLayoutManager) this.g).c.f(view);
        }
        if (size == 1) {
            this.b = Integer.MIN_VALUE;
        }
        this.c = Integer.MIN_VALUE;
    }

    public void t() {
        ArrayList arrayList = (ArrayList) this.f;
        View view = (View) arrayList.remove(0);
        dmb dmbVar = (dmb) view.getLayoutParams();
        dmbVar.a = null;
        if (arrayList.size() == 0) {
            this.c = Integer.MIN_VALUE;
        }
        if (dmbVar.c.af() || dmbVar.c.ai()) {
            this.d -= ((StaggeredGridLayoutManager) this.g).c.f(view);
        }
        this.b = Integer.MIN_VALUE;
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 0:
                synchronized (((GifEncoder) this.g)) {
                    try {
                        int i = this.d;
                        int i2 = this.e + i;
                        str = "LruCache[maxSize=" + this.b + ",hits=" + this.d + ",misses=" + this.e + ",hitRate="
                                + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public void u(View view) {
        dmb dmbVar = (dmb) view.getLayoutParams();
        dmbVar.a = this;
        ArrayList arrayList = (ArrayList) this.f;
        arrayList.add(0, view);
        this.b = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.c = Integer.MIN_VALUE;
        }
        if (dmbVar.c.af() || dmbVar.c.ai()) {
            this.d = ((StaggeredGridLayoutManager) this.g).c.f(view) + this.d;
        }
    }

    public Object v(Object obj, Object obj2) {
        Object objPut;
        throwIfVar1IsNull(obj, "key");
        synchronized (((GifEncoder) this.g)) {
            this.c++;
            bpg bpgVar = (bpg) this.f;
            bpgVar.getClass();
            objPut = bpgVar.a.put(obj, obj2);
            if (objPut != null) {
                this.c--;
            }
        }
        int i = this.b;
        while (true) {
            synchronized (((GifEncoder) this.g)) {
                try {
                    if (this.c < 0 || (((bpg) this.f).a.isEmpty() && this.c != 0)) {
                        break;
                    }
                    if (this.c > i && !((bpg) this.f).a.isEmpty()) {
                        Set setEntrySet = ((bpg) this.f).a.entrySet();
                        throwIfVar1IsNull(setEntrySet, "<get-entries>(...)");
                        Map.Entry entry = (Map.Entry) StaticHelpers5.f(setEntrySet);
                        if (entry == null) {
                            return objPut;
                        }
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        bpg bpgVar2 = (bpg) this.f;
                        bpgVar2.getClass();
                        throwIfVar1IsNull(key, "key");
                        bpgVar2.a.remove(key);
                        int i2 = this.c;
                        throwIfVar1IsNull(value, "value");
                        this.c = i2 - 1;
                    }
                    return objPut;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public byj(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.a = 1;
        this.g = staggeredGridLayoutManager;
        this.f = new ArrayList();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
        this.e = i;
    }
}
