package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fp extends SwitchHook implements IDexFind {
    public static final fp a = new fp("AntiBizPageAdHook" /* "AntiBizPageAdHook" /* "AntiBizPageAdHook" /* cnb.z(-477089262205738L)  */);
    public static final String b = "订阅号" /* "订阅号" /* "订阅号" /* cnb.z(-476543801359146L)  */;
    public static final String c = "屏蔽文章广告" /* "屏蔽文章广告" /* "屏蔽文章广告" /* cnb.z(-476560981228330L)  */;
    public static final String d = "屏蔽公众号文章中的信息流与底部广告" /* "屏蔽公众号文章中的信息流与底部广告" /* "屏蔽公众号文章中的信息流与底部广告" /* cnb.z(-476513736588074L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(fo.a));
        fp fpVar = a;
        aki akiVarAb = PackageParam.ab(fpVar, listBf);
        fpVar.y(akiVarAb, new bn(5));
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
        StaticHelpers7.resolveDexAndCache(fo.a, dexKitBridge, new bn(6));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
