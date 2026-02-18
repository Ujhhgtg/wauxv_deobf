package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dax extends doo implements bng {
    public static final dax a = new dax(cnb.z(-497516126665514L));
    public static final String b = cnb.z(-498830386658090L);
    public static final String c = cnb.z(-498783142017834L);
    public static final String i = cnb.z(-498735897377578L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(daw.a));
        dax daxVar = a;
        aki akiVarAb = csb.ab(daxVar, listBf);
        daxVar.y(akiVarAb, new cvc(23));
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
        emn.aj(daw.a, dexKitBridge, new cvc(24));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
