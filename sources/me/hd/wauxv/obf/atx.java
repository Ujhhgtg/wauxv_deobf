package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class atx extends doo implements bng {
    public static final atx a;
    public static final String b;
    public static final String c;
    public static final String i;
    public static final atn j;

    static {
        cnb.z(-495823909550890L);
        cnb.z(-495699355499306L);
        a = new atx(cnb.z(-507557760203562L));
        b = cnb.z(-495007865764650L);
        c = cnb.z(-494960621124394L);
        i = cnb.z(-494973506026282L);
        j = new atn(2);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(att.a));
        atx atxVar = a;
        aki akiVarAb = csb.ab(atxVar, listBf);
        atxVar.x(akiVarAb, new atn(8));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(atxVar, dqc.bf(emn.bb(ats.a)));
        atxVar.y(akiVarAb2, new atn(5));
        akiVarAb2.o();
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
        emn.aj(att.a, dexKitBridge, new atn(6));
        emn.aj(ats.a, dexKitBridge, new atn(7));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
