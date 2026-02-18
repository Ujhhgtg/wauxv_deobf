package me.hd.wauxv.obf;

import java.util.List;
import java.util.Set;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ble extends SwitchHook implements IDexFind {
    public static final ble a = new ble("HideChatItemMenuHook" /* cnb.z(-463143503395626L) */);
    public static final Set b = dgg._cd("提醒" /* cnb.z(-463396906466090L) */, "搜一搜" /* cnb.z(-463349661825834L) */);
    public static final String c = "净化" /* cnb.z(-463366841695018L) */;
    public static final String i = "隐藏聊天菜单" /* cnb.z(-463371136662314L) */;
    public static final String j = "自定义隐藏聊天长按消息中的菜单项目" /* cnb.z(-463341071891242L) */;
    public static final bep l = new bep(8);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(blc.a));
        ble bleVar = a;
        aki akiVarAb = csb.ab(bleVar, listBf);
        bleVar.y(akiVarAb, new bep(10));
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
        emn.aj(blc.a, dexKitBridge, new bep(9));
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
