package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class die extends SwitchHook implements IDexFind {
    public static final die a = new die("SkipWebSpamUrlHook" /* cnb.z(-465157843057450L) */);
    public static final String b = "聊天" /* cnb.z(-462675351960362L) */;
    public static final String c = "跳过网页风险" /* cnb.z(-462628107320106L) */;
    public static final String i = "无视网页存在的安全风险强制继续访问" /* cnb.z(-462649582156586L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(did.a));
        die dieVar = a;
        aki akiVarAb = csb.ab(dieVar, listBf);
        dieVar.y(akiVarAb, new dhg(5));
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
        emn.aj(did.a, dexKitBridge, new dhg(6));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
