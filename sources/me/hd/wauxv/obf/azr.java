package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azr extends SwitchHook implements IDexFind {
    public static final azr a = new azr("FileDownRedirectHook" /* cnb.z(-492177482316586L) */);
    public static final String b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final ayz l;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Download" /* cnb.z(-46437186403114L) */, "Attachment" /* cnb.z(-46398531697450L) */);
        c = "实验" /* cnb.z(-492383640746794L) */;
        i = "文件下载重定向" /* cnb.z(-492387935714090L) */;
        j = "支持将文件重定向下载到自定义目录中" /* cnb.z(-492353575975722L) */;
        l = new ayz(6);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(azp.a));
        azr azrVar = a;
        aki akiVarAb = csb.ab(azrVar, listBf);
        azrVar.x(akiVarAb, new ayz(8));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(azp.a, dexKitBridge, new ayz(7));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IHasInvokeMethod p() {
        return l;
    }
}
