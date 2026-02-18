package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class vt extends doo implements bng, bob {
    public static final vt a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final us i;
    public static final boolean m;

    static {
        cnb.z(-568713799531306L);
        cnb.z(-568688029727530L);
        cnb.z(-568593540447018L);
        cnb.z(-568567770643242L);
        cnb.z(-568542000839466L);
        cnb.z(-568516231035690L);
        cnb.z(-568971497569066L);
        cnb.z(-568945727765290L);
        a = new vt(cnb.z(-563525479037738L));
        b = cnb.z(-568919957961514L);
        c = cnb.z(-568924252928810L);
        d = cnb.z(-568894188157738L);
        i = new us(2);
        m = true;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(vh.a));
        vt vtVar = a;
        aki akiVarAb = csb.ab(vtVar, listBf);
        vtVar.x(akiVarAb, new us(3));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(vh.a, dexKitBridge, new us(4));
    }

    @Override // me.hd.wauxv.obf.bob
    public final void n(bmm bmmVar, String str) {
        Object next;
        if (z()) {
            Object obj = null;
            if (dnr.bp(str, cnb.z(-564002220407594L), false)) {
                if (vi.a.o().equals(bis.a.d)) {
                    return;
                }
                biw.a.getClass();
                Iterator it = biw.f().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!bzo.f(((biv) next).b, vi.a.o()));
                biv bivVar = (biv) next;
                if (bivVar != null) {
                    bmmVar.getClass();
                    new ek(bmmVar, 1, 8).q(cnb.z(-564620695698218L) + bivVar.g(vi.a.o()));
                }
            }
            if (!dnr.bp(str, cnb.z(-570229922986794L), false) || vi.a.o().equals(bis.a.d)) {
                return;
            }
            biw.a.getClass();
            for (Object obj2 : biw.f()) {
                if (bzo.f(((biv) obj2).b, vi.a.o())) {
                    obj = obj2;
                    break;
                }
            }
            biv bivVar2 = (biv) obj;
            if (bivVar2 != null) {
                bmmVar.getClass();
                new ek(bmmVar, 1, 8).q(cnb.z(-571209175530282L) + bivVar2.g(vi.a.o()));
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return m;
    }
}
