package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgb extends doo implements bng {
    public static final cgb a;
    public static final List b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final bzk l;

    static {
        cnb.z(-470277444074282L);
        cnb.z(-470200134662954L);
        a = new cgb(cnb.z(-469491465059114L));
        b = aba.ag(cnb.z(-470178659826474L), cnb.z(-470092760480554L), cnb.z(-470058400742186L));
        c = cnb.z(-470590976686890L);
        i = cnb.z(-470526552177450L);
        j = cnb.z(-470496487406378L);
        l = new bzk(16);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() throws NoSuchMethodException {
        Constructor constructorBa = emn.ba(cfy.a);
        List listBf = dqc.bf(constructorBa);
        cgb cgbVar = a;
        aki akiVarAb = csb.ab(cgbVar, listBf);
        cgbVar.y(akiVarAb, new q(constructorBa, 7));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(cfy.a, dexKitBridge, new bzk(17));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return j;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return l;
    }
}
