package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lz extends SwitchHook implements IDexFind {
    public static final lz a = new lz("AutoEnableForceNotifyHook" /* "AutoEnableForceNotifyHook" /* "AutoEnableForceNotifyHook" /* cnb.z(-442287142206250L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-444005129124650L)  */;
    public static final String c = "自动启用提醒" /* "自动启用提醒" /* "自动启用提醒" /* cnb.z(-444009424091946L)  */;
    public static final String d = "始终启用好友聊天设置页中的消息提醒" /* "始终启用好友聊天设置页中的消息提醒" /* "始终启用好友聊天设置页中的消息提醒" /* cnb.z(-443979359320874L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(ly.a));
        lz lzVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(lzVar, listBf);
        lzVar.hookAfter(hookManagerVarAb, new gi(24));
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
        StaticHelpers7.resolveDexAndCache(ly.a, dexKitBridge, new gi(25));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
