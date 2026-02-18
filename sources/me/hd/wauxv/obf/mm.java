package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mm extends doo implements bng {
    public static final mm a = new mm(cnb.z(-440247032740650L));
    public static final String b = cnb.z(-441325069531946L);
    public static final String c = cnb.z(-441329364499242L);
    public static final String d = cnb.z(-441299299728170L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        Iterator it = aba.ag(ml.a, mk.a).iterator();
        while (it.hasNext()) {
            List listBf = dqc.bf(emn.bb((amn) it.next()));
            mm mmVar = a;
            aki akiVarAb = csb.ab(mmVar, listBf);
            mmVar.x(akiVarAb, new mj(0));
            akiVarAb.o();
        }
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
        emn.aj(ml.a, dexKitBridge, new mj(1));
        emn.aj(mk.a, dexKitBridge, new mj(2));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
