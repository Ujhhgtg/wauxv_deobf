package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class gm extends SwitchHook implements IDexFind {
    public static final gm a = new gm("AntiUploadCheckHook" /* "AntiUploadCheckHook" /* "AntiUploadCheckHook" /* "AntiUploadCheckHook" /* cnb.z(-636862045616938L)   */);
    public static final String b = "测试-杂项" /* "测试-杂项" /* "测试-杂项" /* "测试-杂项" /* cnb.z(-633872748378922L)   */;
    public static final String c = "拦截检测包上报" /* "拦截检测包上报" /* "拦截检测包上报" /* "拦截检测包上报" /* cnb.z(-633898518182698L)   */;
    public static final String d = "拦截客户端中可能上报的部分检测包体" /* "拦截客户端中可能上报的部分检测包体" /* "拦截客户端中可能上报的部分检测包体" /* "拦截客户端中可能上报的部分检测包体" /* cnb.z(-634413914258218L)   */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(gj.a));
        gm gmVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(gmVar, listBf);
        gmVar.y(hookManagerVarAb, new gi(1));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb2 = PackageParam.createHook(gmVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(gk.a)));
        gmVar.y(hookManagerVarAb2, new gi(0));
        hookManagerVarAb2.initInstantCollectionAndApplyHooks();
        HookManager hookManagerVarAb3 = PackageParam.createHook(gmVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(gl.a)));
        gmVar.y(hookManagerVarAb3, new bn(29));
        hookManagerVarAb3.initInstantCollectionAndApplyHooks();
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
        StaticHelpers7.resolveDexAndCache(gj.a, dexKitBridge, new gi(2));
        StaticHelpers7.resolveDexAndCache(gk.a, dexKitBridge, new gi(3));
        StaticHelpers7.resolveDexAndCache(gl.a, dexKitBridge, new gi(4));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
