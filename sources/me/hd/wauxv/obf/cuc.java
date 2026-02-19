package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cuc implements dfx, sr {
    public final String e;
    public final bgx n;
    public final int o;
    public int p = -1;
    public final String[] q;
    public final List[] r;
    public final boolean[] s;
    public Object t;
    public final Object u;
    public final Object v;
    public final Object w;

    public cuc(String str, bgx bgxVar, int i) {
        this.e = str;
        this.n = bgxVar;
        this.o = i;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.q = strArr;
        int i3 = this.o;
        this.r = new List[i3];
        this.s = new boolean[i3];
        this.t = EmptyReadonlyMap.INSTANCE;
        final int i4 = 0;
        bfu bfuVar = new bfu(this) { // from class: me.hd.wauxv.obf.cub
            public final /* synthetic */ cuc b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        bgx bgxVar2 = this.b.n;
                        return bgxVar2 != null ? bgxVar2.d() : dqc.au;
                    case 1:
                        return cnh.n(this.b.n != null ? new ArrayList(0) : null);
                    default:
                        cuc cucVar = this.b;
                        return Integer.valueOf(FastKV.af(cucVar, (dfx[]) cucVar.v.getValue()));
                }
            }
        };
        btx btxVar = btx.a;
        this.u = ewz.am(btxVar, bfuVar);
        final int i5 = 1;
        this.v = ewz.am(btxVar, new bfu(this) { // from class: me.hd.wauxv.obf.cub
            public final /* synthetic */ cuc b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i5) {
                    case 0:
                        bgx bgxVar2 = this.b.n;
                        return bgxVar2 != null ? bgxVar2.d() : dqc.au;
                    case 1:
                        return cnh.n(this.b.n != null ? new ArrayList(0) : null);
                    default:
                        cuc cucVar = this.b;
                        return Integer.valueOf(FastKV.af(cucVar, (dfx[]) cucVar.v.getValue()));
                }
            }
        });
        final int i6 = 2;
        this.w = ewz.am(btxVar, new bfu(this) { // from class: me.hd.wauxv.obf.cub
            public final /* synthetic */ cuc b;

            {
                this.b = this;
            }

            /*
             * JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object,
             * me.hd.wauxv.obf.btt]
             */
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        bgx bgxVar2 = this.b.n;
                        return bgxVar2 != null ? bgxVar2.d() : dqc.au;
                    case 1:
                        return cnh.n(this.b.n != null ? new ArrayList(0) : null);
                    default:
                        cuc cucVar = this.b;
                        return Integer.valueOf(FastKV.af(cucVar, (dfx[]) cucVar.v.getValue()));
                }
            }
        });
    }

    /*
     * JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object,
     * java.util.Map]
     */
    @Override // me.hd.wauxv.obf.sr
    public final Set a() {
        return this.t.keySet();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return this.e;
    }

    @Override // me.hd.wauxv.obf.dfx
    public boolean d() {
        return false;
    }

    /*
     * JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    /*
     * JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cuc) {
            dfx dfxVar = (dfx) obj;
            if (this.e.equals(dfxVar.b())
                    && Arrays.equals((dfx[]) this.v.getValue(), (dfx[]) ((cuc) obj).v.getValue())) {
                int i = dfxVar.i();
                int i2 = this.o;
                if (i2 == i) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (nullSafeIsEqual(l(i3).b(), dfxVar.l(i3).b())
                                && nullSafeIsEqual(l(i3).h(), dfxVar.l(i3).h())) {
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

    /*
     * JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object,
     * java.util.Map]
     */
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
    public emc h() {
        return dnt.a;
    }

    /*
     * JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    public int hashCode() {
        return ((Number) this.w.getValue()).intValue();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return this.o;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        return this.q[i];
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        List list = this.r[i];
        return list == null ? EmptyReadonlyList.INSTANCE : list;
    }

    /*
     * JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    @Override // me.hd.wauxv.obf.dfx
    public dfx l(int i) {
        return ((btd[]) this.u.getValue())[i].getDescriptor();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        return this.s[i];
    }

    public String toString() {
        return FastKV.bf(this);
    }

    public final void x(String str, boolean z) {
        throwIfVar1IsNull(str, "name");
        int i = this.p + 1;
        this.p = i;
        String[] strArr = this.q;
        strArr[i] = str;
        this.s[i] = z;
        this.r[i] = null;
        if (i == this.o - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                map.put(strArr[i2], Integer.valueOf(i2));
            }
            this.t = map;
        }
    }

    public final void y(cwg cwgVar) {
        int i = this.p;
        List[] listArr = this.r;
        List arrayList = listArr[i];
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            listArr[this.p] = arrayList;
        }
        arrayList.add(cwgVar);
    }
}
