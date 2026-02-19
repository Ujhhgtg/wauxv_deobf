package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cnl extends SwitchHook implements IStartActivity {
    public static final cnl a = new cnl("NewBizListHook" /* "NewBizListHook" /* "NewBizListHook" /* cnb.z(-476453607045930L)  */);
    public static final String b = "订阅号" /* "订阅号" /* "订阅号" /* cnb.z(-481598977866538L)  */;
    public static final String c = "订阅消息列表" /* "订阅消息列表" /* "订阅消息列表" /* cnb.z(-481616157735722L)  */;
    public static final String i = "订阅号消息从瀑布流模式改为列表模式" /* "订阅号消息从瀑布流模式改为列表模式" /* "订阅号消息从瀑布流模式改为列表模式" /* cnb.z(-482135848778538L)  */;
    public static final boolean j;

    /* JADX WARN: Found duplicated region for block: B:11:0x005a */
    static {
        boolean z;
        ewk ewkVar = ewk.m;
        bmo bmoVar = bmo.a;
        bmoVar.getClass();
        if (bmo.q() > ewkVar.r || bmo.r()) {
            ewh ewhVar = ewh.p;
            bmoVar.getClass();
            z = bmo.q() <= ewhVar.u && bmo.r();
        }
        j = z;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean _ab() {
        return j;
    }

    @Override // me.hd.wauxv.obf.IStartActivity
    public final void onStartActivityIntent(HookParam hookParam, Intent intent) {
        if (getIsEnabled() && j) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != -1870020680) {
                    if (iHashCode != 510348960 || !className.equals(
                            "com.tencent.mm.plugin.brandservice.ui.flutter.BizFlutterTLFlutterViewActivity" /*
                                                                                                             * cnb.z(-
                                                                                                             * 482140143745834L)
                                                                                                             */)) {
                        return;
                    }
                } else if (!className.equals("com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI" /*
                                                                                                             * cnb.z(-
                                                                                                             * 476389182536490L)
                                                                                                             */)) {
                    return;
                }
                bmo.a.getClass();
                intent.setComponent(new ComponentName(bmo.p(),
                        "com.tencent.mm.ui.conversation.NewBizConversationUI" /* "com.tencent.mm.ui.conversation.NewBizConversationUI" /* "com.tencent.mm.ui.conversation.NewBizConversationUI" /* cnb.z(-481856675904298L)  */));
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
