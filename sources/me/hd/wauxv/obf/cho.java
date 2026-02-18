package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cho extends doo implements bng {
    public static final cho a = new cho("MultiWebViewHook" /* cnb.z(-517238616488746L) */);
    public static final String b = "杂项" /* cnb.z(-518939423537962L) */;
    public static final String c = "文章多开窗口" /* cnb.z(-518960898374442L) */;
    public static final String i = "可同时阅读多篇公众号文章在多窗口中" /* cnb.z(-518913653734186L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(chn.a));
        cho choVar = a;
        aki akiVarAb = csb.ab(choVar, listBf);
        choVar.y(akiVarAb, new cgu(6));
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
        emn.aj(chn.a, dexKitBridge, new cgu(7));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
