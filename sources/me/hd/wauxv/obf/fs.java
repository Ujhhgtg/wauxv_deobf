package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fs extends BaseHook implements bnt {
    public static final fs a = new fs("AntiNotificationHook" /* cnb.z(-491163870034730L) */);
    public static final String b = "实验" /* cnb.z(-490974891473706L) */;
    public static final String c = "静默通知" /* cnb.z(-490979186441002L) */;
    public static final String d = "屏蔽群聊里叼毛艾特所有人的全体通知" /* cnb.z(-490940531735338L) */;
    public static final bn h = new bn(8);

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
        return d;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final IHasInvokeMethod p() {
        return h;
    }
}
