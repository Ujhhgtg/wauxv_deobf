package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class vg extends doo implements bng, bob {
    public static final vg a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final mj i;
    public static final boolean m;

    static {
        cnb.z(-577552842226474L);
        cnb.z(-565913480854314L);
        cnb.z(-565887711050538L);
        cnb.z(-565861941246762L);
        cnb.z(-565836171442986L);
        cnb.z(-565741682162474L);
        cnb.z(-565715912358698L);
        cnb.z(-566239898368810L);
        a = new vg(cnb.z(-572617924803370L));
        b = cnb.z(-566214128565034L);
        c = cnb.z(-566149704055594L);
        d = cnb.z(-566119639284522L);
        i = new mj(28);
        m = true;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(uu.a));
        vg vgVar = a;
        aki akiVarAb = csb.ab(vgVar, listBf);
        vgVar.x(akiVarAb, new us(0));
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
        emn.aj(uu.a, dexKitBridge, new mj(29));
    }

    @Override // me.hd.wauxv.obf.bob
    public final void n(bmm bmmVar, String str) {
        Object next;
        if (z()) {
            Object obj = null;
            if (dnr.bp(str, cnb.z(-572012334414634L), false)) {
                if (ux.a.o().equals(bis.a.d)) {
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
                } while (!bzo.f(((biv) next).b, ux.a.o()));
                biv bivVar = (biv) next;
                if (bivVar != null) {
                    bmmVar.getClass();
                    new ek(bmmVar, 1, 8).q(cnb.z(-573730321333034L) + bivVar.g(ux.a.o()));
                }
            }
            if (!dnr.bp(str, cnb.z(-579339548621610L), false) || ux.a.o().equals(bis.a.d)) {
                return;
            }
            biw.a.getClass();
            for (Object obj2 : biw.f()) {
                if (bzo.f(((biv) obj2).b, ux.a.o())) {
                    obj = obj2;
                    break;
                }
            }
            biv bivVar2 = (biv) obj;
            if (bivVar2 != null) {
                bmmVar.getClass();
                new ek(bmmVar, 1, 8).q(cnb.z(-580318801165098L) + bivVar2.g(ux.a.o()));
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
