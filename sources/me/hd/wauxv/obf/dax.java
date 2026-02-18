package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dax extends SwitchHook implements IDexFind {
    public static final dax a = new dax("RemoveRemarkInputLimitHook" /* cnb.z(-497516126665514L) */);
    public static final String b = "限制" /* cnb.z(-498830386658090L) */;
    public static final String c = "移除备注限制" /* cnb.z(-498783142017834L) */;
    public static final String i = "移除好友备注时最多输入32长度的限制" /* cnb.z(-498735897377578L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(daw.a));
        dax daxVar = a;
        aki akiVarAb = csb.ab(daxVar, listBf);
        daxVar.y(akiVarAb, new cvc(23));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(daw.a, dexKitBridge, new cvc(24));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
