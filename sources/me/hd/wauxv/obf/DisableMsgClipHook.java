package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DisableMsgClipHook extends SwitchHook implements IDexFind {
    public static final DisableMsgClipHook a = new DisableMsgClipHook("DisableMsgClipHook" /*
                                                                                            * cnb.z(-446771088063274L)
                                                                                            */);
    public static final String b = "聊天" /* cnb.z(-448351636028202L) */;
    public static final String c = "禁止消息折叠" /* cnb.z(-448355930995498L) */;
    public static final String i = "阻止某些包含链接的消息会被官方折叠" /* cnb.z(-447776110410538L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(anx.a));
        DisableMsgClipHook anyVar = a;
        aki akiVarAb = csb.ab(anyVar, listBf);
        anyVar.y(akiVarAb, new amb(5));
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
        emn.aj(anx.a, dexKitBridge, new amb(6));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
