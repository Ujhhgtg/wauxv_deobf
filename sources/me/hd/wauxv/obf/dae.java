package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dae extends BaseHook implements boc {
    public static final dae a = new dae("RedPacketPrivateReceiveHook" /* cnb.z(-536638983764778L) */);
    public static final String b = "红包" /* cnb.z(-538734927805226L) */;
    public static final String c = "红包私聊领取" /* cnb.z(-538739222772522L) */;
    public static final String i = "可在私聊发送自己可领取的拼手气红包" /* cnb.z(-538709158001450L) */;

    @Override // me.hd.wauxv.obf.boc
    public final void _cc(HookParamWrapper hookParam, Intent intent) {
        if (z()) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != -1765744774) {
                    if (iHashCode != 1306075868 || !className.equals(
                            "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI" /* cnb.z(-537102840232746L) */)) {
                        return;
                    }
                } else if (!className.equals("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewPrepareUI" /*
                                                                                                           * cnb.z(-
                                                                                                           * 536862322064170L)
                                                                                                           */)) {
                    return;
                }
                intent.putExtra("key_type" /* cnb.z(-538275366304554L) */, 1);
            }
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return i;
    }
}
