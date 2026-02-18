package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppBrandAntiGlobalAdHook extends SwitchHook implements IDexFind {
    public static final AppBrandAntiGlobalAdHook a = new AppBrandAntiGlobalAdHook("AppBrandAntiGlobalAdHook" /*
                                                                                                              * cnb.z(-
                                                                                                              * 412578853419818L)
                                                                                                              */);
    public static final String b = "小程序" /* cnb.z(-409920268663594L) */;
    public static final String c = "禁止全局广告" /* cnb.z(-409937448532778L) */;
    public static final String d = "可能导致部分需要广告的功能无法运行" /* cnb.z(-409890203892522L) */;
    public static final boolean i = true;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.ba(gt.a));
        AppBrandAntiGlobalAdHook guVar = a;
        aki akiVarAb = csb.ab(guVar, listBf);
        guVar.y(akiVarAb, new gi(11));
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
        emn.aj(gt.a, dexKitBridge, new gi(12));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return i;
    }
}
