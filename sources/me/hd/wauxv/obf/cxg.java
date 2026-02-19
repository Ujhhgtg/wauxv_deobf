package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxg extends SwitchHook implements IDexFind {
    public static final cxg a = new cxg("QuoteClickToPosHook" /* "QuoteClickToPosHook" /* "QuoteClickToPosHook" /* cnb.z(-460076896746282L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-461099098962730L)  */;
    public static final String c = "引用消息直达" /* "引用消息直达" /* "引用消息直达" /* cnb.z(-461103393930026L)  */;
    public static final String i = "点击引用消息内容直接定位到原文位置" /* "点击引用消息内容直接定位到原文位置" /* "点击引用消息内容直接定位到原文位置" /* cnb.z(-461073329158954L)  */;
    public static final boolean j;

    /* JADX WARN: Found duplicated region for block: B:11:0x005a */
    static {
        boolean z;
        ewk ewkVar = ewk.k;
        HostInfoRegistry hostInfoRegistryVar = HostInfoRegistry.INSTANCE;
        hostInfoRegistryVar.getClass();
        if (HostInfoRegistry.getVerCode() > ewkVar.r || HostInfoRegistry.getIsPlay()) {
            ewh ewhVar = ewh.k;
            hostInfoRegistryVar.getClass();
            z = HostInfoRegistry.getVerCode() <= ewhVar.u && HostInfoRegistry.getIsPlay();
        }
        j = z;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean _ab() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        if (j) {
            List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(cxe.a));
            cxg cxgVar = a;
            HookManager hookManagerVarAb = PackageParam.createHook(cxgVar, listBf);
            cxgVar.hookBefore(hookManagerVarAb, new cvc(6));
            hookManagerVarAb.initInstantCollectionAndApplyHooks();
        }
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
        if (j) {
            StaticHelpers7.resolveDexAndCache(cxe.a, dexKitBridge, new cvc(7));
            StaticHelpers7.resolveDexAndCache(cxf.a, dexKitBridge, new cvc(8));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
