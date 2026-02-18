package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fj extends dqc {
    public final /* synthetic */ int a;
    public List b;
    public Object d;

    public /* synthetic */ fj(int i) {
        this.a = i;
    }

    public static void e(fj fjVar, String str) {
        fk fkVar = new fk();
        fkVar.a = new dnf(str, dne.Equals, false);
        fkVar.b = fl.StringValue;
        List arrayList = fjVar.b;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        fjVar.b = arrayList;
        arrayList.add(fkVar);
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iV;
        int iV2;
        int iT;
        int iT2;
        int iT3;
        int iT4;
        switch (this.a) {
            case 0:
                bzo.q(bbbVar, "fbb");
                List list = this.b;
                if (list != null) {
                    ArrayList arrayList = new ArrayList(abb.ak(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        fl flVar = ((fk) it.next()).b;
                        bzo.n(flVar);
                        arrayList.add(new emp(flVar.d));
                    }
                    byte[] bArrY = aye.y(arrayList);
                    bbbVar.ac(1, bArrY.length, 1);
                    for (int length = bArrY.length - 1; -1 < length; length--) {
                        bbbVar.n(bArrY[length]);
                    }
                    iV = bbbVar.v();
                } else {
                    iV = 0;
                }
                List list2 = this.b;
                if (list2 != null) {
                    ArrayList arrayList2 = new ArrayList(abb.ak(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        dqc dqcVar = ((fk) it2.next()).a;
                        bzo.o(dqcVar, "null cannot be cast to non-null type org.luckypray.dexkit.query.base.BaseQuery");
                        arrayList2.add(Integer.valueOf(dqcVar.c(bbbVar)));
                    }
                    int[] iArrY = aaz.y(arrayList2);
                    bbbVar.ac(4, iArrY.length, 4);
                    for (int length2 = iArrY.length - 1; -1 < length2; length2--) {
                        bbbVar.p(iArrY[length2]);
                    }
                    iV2 = bbbVar.v();
                } else {
                    iV2 = 0;
                }
                byte b = ((bzu) this.d).d;
                bbbVar.ab(4);
                bbbVar.q(3, 0);
                bbbVar.q(1, iV2);
                bbbVar.q(0, iV);
                bbbVar.o(b, 2);
                int iU = bbbVar.u();
                bbbVar.w(iU);
                return iU;
            case 1:
                bzo.q(bbbVar, "fbb");
                List list3 = this.b;
                if (list3 != null) {
                    ArrayList arrayList3 = new ArrayList(abb.ak(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(Integer.valueOf(((fm) it3.next()).c(bbbVar)));
                    }
                    iT = bbbVar.t(aaz.y(arrayList3));
                } else {
                    iT = 0;
                }
                byte b2 = ((bzu) this.d).d;
                bbbVar.ab(3);
                bbbVar.q(2, 0);
                bbbVar.q(0, iT);
                bbbVar.o(b2, 1);
                int iU2 = bbbVar.u();
                bbbVar.w(iU2);
                return iU2;
            case 2:
                bzo.q(bbbVar, "fbb");
                List list4 = this.b;
                if (list4 != null) {
                    ArrayList arrayList4 = new ArrayList(abb.ak(list4, 10));
                    Iterator it4 = list4.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(Integer.valueOf(((zb) it4.next()).c(bbbVar)));
                    }
                    iT2 = bbbVar.t(aaz.y(arrayList4));
                } else {
                    iT2 = 0;
                }
                byte b3 = ((bzu) this.d).d;
                bbbVar.ab(3);
                bbbVar.q(2, 0);
                bbbVar.q(0, iT2);
                bbbVar.o(b3, 1);
                int iU3 = bbbVar.u();
                bbbVar.w(iU3);
                return iU3;
            case 3:
                bzo.q(bbbVar, "fbb");
                List list5 = this.b;
                if (list5 != null) {
                    ArrayList arrayList5 = new ArrayList(abb.ak(list5, 10));
                    Iterator it5 = list5.iterator();
                    while (it5.hasNext()) {
                        arrayList5.add(Integer.valueOf(((cdj) it5.next()).c(bbbVar)));
                    }
                    iT3 = bbbVar.t(aaz.y(arrayList5));
                } else {
                    iT3 = 0;
                }
                byte b4 = ((bzu) this.d).d;
                bbbVar.ab(3);
                bbbVar.q(2, 0);
                bbbVar.q(0, iT3);
                bbbVar.o(b4, 1);
                int iU4 = bbbVar.u();
                bbbVar.w(iU4);
                return iU4;
            default:
                bzo.q(bbbVar, "fbb");
                List<cst> list6 = this.b;
                if (list6 != null) {
                    ArrayList arrayList6 = new ArrayList(abb.ak(list6, 10));
                    for (cst cstVar : list6) {
                        if (cstVar == null) {
                            cstVar = new cst();
                        }
                        arrayList6.add(Integer.valueOf(cstVar.c(bbbVar)));
                    }
                    iT4 = bbbVar.t(aaz.y(arrayList6));
                } else {
                    iT4 = 0;
                }
                bqh bqhVar = (bqh) this.d;
                int iC = bqhVar != null ? bqhVar.c(bbbVar) : 0;
                bbbVar.ab(2);
                bbbVar.q(1, iC);
                bbbVar.q(0, iT4);
                int iU5 = bbbVar.u();
                bbbVar.w(iU5);
                return iU5;
        }
    }

    public void f(cdj cdjVar) {
        List arrayList = this.b;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.b = arrayList;
        arrayList.add(cdjVar);
    }

    public fj() {
        this.a = 3;
        this.d = bzu.Contains;
    }
}
