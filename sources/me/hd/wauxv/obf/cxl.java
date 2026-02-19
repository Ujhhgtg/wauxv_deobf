package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxl extends SwitchHook implements IDexFind {
    public static final cxl a;
    public static final String b;
    public static final String c;
    public static final String i;
    public static final cvc j;

    static {
        "[有人回我]" /* "[有人回我]" /* "[有人回我]" /* cnb.z(-459209313352490L)  */;
        "#FFE14949" /* "#FFE14949" /* "#FFE14949" /* cnb.z(-459162068712234L)  */;
        a = new cxl("QuoteRemindMsgHook" /* "QuoteRemindMsgHook" /* "QuoteRemindMsgHook" /* cnb.z(-458324550089514L)  */);
        b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-459136298908458L)  */;
        c = "引用消息提醒" /* "引用消息提醒" /* "引用消息提醒" /* cnb.z(-459089054268202L)  */;
        i = "主页列表添加有人回我消息的红字提醒" /* "主页列表添加有人回我消息的红字提醒" /* "主页列表添加有人回我消息的红字提醒" /* cnb.z(-459110529104682L)  */;
        j = new cvc(11);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(cxi.a));
        cxl cxlVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(cxlVar, listBf);
        cxlVar.hookBefore(hookManagerVarAb, new cvc(12));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
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
        StaticHelpers7.resolveDexAndCache(cxi.a, dexKitBridge, new cvc(13));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return j;
    }
}
