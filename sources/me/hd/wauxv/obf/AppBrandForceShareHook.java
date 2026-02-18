package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppBrandForceShareHook extends SwitchHook implements bne {
    public static final AppBrandForceShareHook a = new AppBrandForceShareHook("AppBrandForceShareHook" /*
                                                                                                        * cnb.z(-
                                                                                                        * 410341175458602L)
                                                                                                        */);
    public static final String b = "小程序" /* cnb.z(-410534448986922L) */;
    public static final String c = "程序强制分享" /* cnb.z(-410551628856106L) */;
    public static final String d = "程序强制可转发给朋友或分享到朋友圈" /* cnb.z(-410521564085034L) */;
    public static final boolean h = true;

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

    public final void i(HookParam hookParam, CharSequence charSequence, boolean z) {
        if (getIsEnabled() && z) {
            boolean z2 = true;
            boolean z3 = charSequence.equals("转发给朋友" /* cnb.z(-410225211341610L) */)
                    || charSequence.equals("分享到朋友圈" /* cnb.z(-410250981145386L) */);
            boolean z4 = charSequence.equals("轉發給朋友" /* cnb.z(-410220916374314L) */)
                    || charSequence.equals("分享到朋友圈" /* cnb.z(-410177966701354L) */);
            if (!charSequence.equals("Send to Chat" /* cnb.z(-410130722061098L) */)
                    && !charSequence.equals("Share on Moments" /* cnb.z(-410607463430954L) */)) {
                z2 = false;
            }
            if (z3 || z4 || z2) {
                hookParam.getClass();
                new ek(hookParam, 4, 8).q(Boolean.FALSE);
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return h;
    }
}
