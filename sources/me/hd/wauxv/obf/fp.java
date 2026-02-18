package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fp extends doo implements bng {
    public static final fp a = new fp(cnb.z(-477089262205738L));
    public static final String b = cnb.z(-476543801359146L);
    public static final String c = cnb.z(-476560981228330L);
    public static final String d = cnb.z(-476513736588074L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(fo.a));
        fp fpVar = a;
        aki akiVarAb = csb.ab(fpVar, listBf);
        fpVar.y(akiVarAb, new bn(5));
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
        emn.aj(fo.a, dexKitBridge, new bn(6));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
