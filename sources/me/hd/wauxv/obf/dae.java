package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dae extends SwitchHook implements IStartActivity {
    public static final dae a = new dae("RedPacketPrivateReceiveHook");
    public static final String b = "红包";
    public static final String c = "红包私聊领取";
    public static final String i = "可在私聊发送自己可领取的拼手气红包";

    @Override // me.hd.wauxv.obf.IStartActivity
    public final void onStartActivityIntent(HookParam hookParam, Intent intent) {
        if (getIsEnabled()) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != -1765744774) {
                    if (iHashCode != 1306075868 || !className.equals(
                            "com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI")) {
                        return;
                    }
                } else if (!className.equals("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewPrepareUI")) {
                    return;
                }
                intent.putExtra("key_type", 1);
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
