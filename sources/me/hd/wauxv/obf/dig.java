package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class dig extends SwitchHook implements IDexFind {
    public static final dig a = new dig("SlideLeftNavHook" /* "SlideLeftNavHook" /* "SlideLeftNavHook" /* cnb.z(-636106131372842L)  */);
    public static final String b = "测试-仅限开发者使用" /* "测试-仅限开发者使用" /* "测试-仅限开发者使用" /* cnb.z(-635951512550186L)  */;
    public static final String c = "主页侧滑栏" /* "主页侧滑栏" /* "主页侧滑栏" /* cnb.z(-635869908171562L)  */;
    public static final String i = "为主页相关界面左上角添加侧滑栏入口" /* "为主页相关界面左上角添加侧滑栏入口" /* "为主页相关界面左上角添加侧滑栏入口" /* cnb.z(-635895677975338L)  */;
    public static final boolean j = true;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean _z() {
        return false;
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

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(dif.a, dexKitBridge, new dhg(8));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return j;
    }
}
