package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class die extends doo implements bng {
    public static final die a = new die(cnb.z(-465157843057450L));
    public static final String b = cnb.z(-462675351960362L);
    public static final String c = cnb.z(-462628107320106L);
    public static final String i = cnb.z(-462649582156586L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(did.a));
        die dieVar = a;
        aki akiVarAb = csb.ab(dieVar, listBf);
        dieVar.y(akiVarAb, new dhg(5));
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
        emn.aj(did.a, dexKitBridge, new dhg(6));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
