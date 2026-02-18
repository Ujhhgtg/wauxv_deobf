package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cme extends bws implements bng {
    public static final cme a = new cme();

    public static void b(cme cmeVar, Object obj) {
        cmeVar.getClass();
        Method methodBb = emn.bb(cmc.a);
        byr.a.getClass();
        methodBb.invoke(byr.c(), obj, 0);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(cmc.a, dexKitBridge, new clo(17));
        emn.aj(cmd.a, dexKitBridge, new clo(18));
    }
}
