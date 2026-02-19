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
        emn.bc(ddf.a, new dbj(8));
        aki akiVarAb = csb.ab(this, dqc.toSingletonList(emn.ba(ddd.a)));
        dbj dbjVar = new dbj(9);
        ddh ddhVar = a;
        ddhVar.y(akiVarAb, dbjVar);
        akiVarAb.o();
        if (cnb.ab(ewk.i) || cnb.ac(ewh.h)) {
            aki akiVarAb2 = csb.ab(this, dqc.toSingletonList(emn.bb(dde.a)));
            ddhVar.y(akiVarAb2, new dbj(10));
            akiVarAb2.o();
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
        emn.aj(ddf.a, dexKitBridge, new dbj(11));
        emn.aj(ddd.a, dexKitBridge, new dbj(12));
        if (cnb.ab(ewk.i) || cnb.ac(ewh.h)) {
            emn.aj(dde.a, dexKitBridge, new dbj(13));
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
