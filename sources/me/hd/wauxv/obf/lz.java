package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lz extends BaseHook implements IRequiresDexLocate {
    public static final lz a = new lz("AutoEnableForceNotifyHook" /* cnb.z(-442287142206250L) */);
    public static final String b = "聊天" /* cnb.z(-444005129124650L) */;
    public static final String c = "自动启用提醒" /* cnb.z(-444009424091946L) */;
    public static final String d = "始终启用好友聊天设置页中的消息提醒" /* cnb.z(-443979359320874L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(ly.a));
        lz lzVar = a;
        aki akiVarAb = csb.ab(lzVar, listBf);
        lzVar.x(akiVarAb, new gi(24));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(ly.a, dexKitBridge, new gi(25));
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return d;
    }
}
