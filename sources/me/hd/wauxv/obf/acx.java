package me.hd.wauxv.obf;

import java.util.Map;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acx extends bws implements bng {
    public static final acx a = new acx();

    public static String b() {
        Object objInvoke = emn.bb(acw.a).invoke(null, null);
        bzo.o(objInvoke, cnb.z(-107949708016426L));
        Object obj = ((Map) objInvoke).get(cnb.z(-108233175857962L));
        bzo.o(obj, cnb.z(-108121506708266L));
        return (String) obj;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(acw.a, dexKitBridge, new act(2));
    }
}
