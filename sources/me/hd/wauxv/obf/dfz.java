package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfz implements dfx, sr {
    public final String c;
    public final emc e;
    public final int n;
    public final HashSet o;
    public final String[] p;
    public final dfx[] q;
    public final List[] r;
    public final boolean[] s;
    public final Map t;
    public final dfx[] u;
    public final Kotlin$Lazy v;

    public dfz(String str, emc emcVar, int i, List list, zd zdVar) {
        throwIfVar1IsNull(str, "serialName");
        this.c = str;
        this.e = emcVar;
        this.n = i;
        ArrayList arrayList = zdVar.b;
        throwIfVar1IsNull(arrayList, "<this>");
        HashSet hashSet = new HashSet(KotlinHelpers.calcHashMapCapacity(StaticHelpers4.ak(arrayList, 12)));
        StaticHelpers5.x(arrayList, hashSet);
        this.o = hashSet;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.p = strArr;
        this.q = cnh.n(zdVar.d);
        this.r = (List[]) zdVar.e.toArray(new List[0]);
        this.s = StaticHelpers5.v(zdVar.f);
        throwIfVar1IsNull(strArr, "<this>");
        boz bozVar = new boz(new bp(strArr, 3), 0);
        ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(bozVar, 10));
        Iterator it = bozVar.iterator();
        while (true) {
            aqf aqfVar = (aqf) it;
            if (!aqfVar.b.hasNext()) {
                this.t = KotlinHelpers.as(arrayList2);
                this.u = cnh.n(list);
                this.v = new Kotlin$Lazy(new cfx(this, 14));
                return;
            }
            boy boyVar = (boy) aqfVar.next();
            arrayList2.add(new Pair(boyVar.b, Integer.valueOf(boyVar.a)));
        }
    }

    @Override // me.hd.wauxv.obf.sr
    public final Set a() {
        return this.o;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof dfz) {
            dfx dfxVar = (dfx) obj;
            if (nullSafeIsEqual(this.c, dfxVar.b()) && Arrays.equals(this.u, ((dfz) obj).u)) {
                int i = dfxVar.i();
                int i2 = this.n;
                if (i2 == i) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        dfx[] dfxVarArr = this.q;
                        if (nullSafeIsEqual(dfxVarArr[i3].b(), dfxVar.l(i3).b())
                                && nullSafeIsEqual(dfxVarArr[i3].h(), dfxVar.l(i3).h())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        throwIfVar1IsNull(str, "name");
        Integer num = (Integer) this.t.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return this.e;
    }

    public final int hashCode() {
        return ((Number) this.v.getValue()).intValue();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return this.n;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        return this.p[i];
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        return this.r[i];
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        return this.q[i];
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        return this.s[i];
    }

    public final String toString() {
        return FastKV.bf(this);
    }
}
