package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zb extends dqc {
    public dnf a;
    public fj b;
    public fj d;
    public azl e;
    public fj f;
    public List g;

    public static void h(zb zbVar, String str) {
        fj fjVar = zbVar.b;
        if (fjVar == null) {
            fjVar = new fj(2);
            fjVar.d = bzu.Contains;
        }
        zbVar.b = fjVar;
        zb zbVar2 = new zb();
        zbVar2.j(str, dne.Equals);
        List arrayList = fjVar.b;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        fjVar.b = arrayList;
        arrayList.add(zbVar2);
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iT;
        bzo.q(bbbVar, "fbb");
        dnf dnfVar = this.a;
        int iC = dnfVar != null ? dnfVar.c(bbbVar) : 0;
        fj fjVar = this.b;
        int iC2 = fjVar != null ? fjVar.c(bbbVar) : 0;
        fj fjVar2 = this.d;
        int iC3 = fjVar2 != null ? fjVar2.c(bbbVar) : 0;
        azl azlVar = this.e;
        int iC4 = azlVar != null ? azlVar.c(bbbVar) : 0;
        fj fjVar3 = this.f;
        int iC5 = fjVar3 != null ? fjVar3.c(bbbVar) : 0;
        List list = this.g;
        if (list != null) {
            ArrayList arrayList = new ArrayList(abb.ak(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((dnf) it.next()).c(bbbVar)));
            }
            iT = bbbVar.t(aaz.y(arrayList));
        } else {
            iT = 0;
        }
        bbbVar.ab(9);
        bbbVar.q(8, iT);
        bbbVar.q(7, iC5);
        bbbVar.q(6, iC4);
        bbbVar.q(5, iC3);
        bbbVar.q(4, iC2);
        bbbVar.q(3, 0);
        bbbVar.q(2, 0);
        bbbVar.q(1, iC);
        bbbVar.q(0, 0);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }

    public final void j(String str, dne dneVar) {
        bzo.q(str, "className");
        this.a = new dnf(str, dneVar, false);
    }

    public final void k(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new dnf(str, dne.Equals, false));
        }
        this.g = aaz.ab(arrayList);
    }
}
