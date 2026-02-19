package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ddh extends SwitchHook implements IDexFind {
    public static final ddh a = new ddh("RoundAvatarHook" /* "RoundAvatarHook" /* "RoundAvatarHook" /* "RoundAvatarHook" /* cnb.z(-455721799908138L)   */);
    public static final String b = "美化" /* "美化" /* "美化" /* "美化" /* cnb.z(-457040354868010L)   */;
    public static final String c = "圆形头像" /* "圆形头像" /* "圆形头像" /* "圆形头像" /* cnb.z(-456993110227754L)   */;
    public static final String i = "可自定义微信全局头像渲染的圆形弧度" /* "可自定义微信全局头像渲染的圆形弧度" /* "可自定义微信全局头像渲染的圆形弧度" /* "可自定义微信全局头像渲染的圆形弧度" /* cnb.z(-457005995129642L)   */;
    public static final dbj j = new dbj(3);
    public static final boolean m = true;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        StaticHelpers7.bc(ddf.a, new dbj(8));
        HookManager hookManagerVarAb = PackageParam.createHook(this, dqc.toSingletonList(StaticHelpers7.ba(ddd.a)));
        dbj dbjVar = new dbj(9);
        ddh ddhVar = a;
        ddhVar.y(hookManagerVarAb, dbjVar);
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
        if (cnb.ab(ewk.i) || cnb.ac(ewh.h)) {
            HookManager hookManagerVarAb2 = PackageParam.createHook(this, dqc.toSingletonList(StaticHelpers7.toDexMethod(dde.a)));
            ddhVar.y(hookManagerVarAb2, new dbj(10));
            hookManagerVarAb2.initInstantCollectionAndApplyHooks();
        }
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
        StaticHelpers7.resolveDexAndCache(ddf.a, dexKitBridge, new dbj(11));
        StaticHelpers7.resolveDexAndCache(ddd.a, dexKitBridge, new dbj(12));
        if (cnb.ab(ewk.i) || cnb.ac(ewh.h)) {
            StaticHelpers7.resolveDexAndCache(dde.a, dexKitBridge, new dbj(13));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return m;
    }
}
