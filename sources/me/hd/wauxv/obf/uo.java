package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class uo extends doo {
    public static final uo a = new uo("ChatFavVoiceForwardHook" /* cnb.z(-477248175995690L) */);
    public static final String b = "收藏" /* cnb.z(-479253925722922L) */;
    public static final String c = "聊天收藏语音转发" /* cnb.z(-479275400559402L) */;
    public static final String d = "在聊天窗口进我的收藏中选择语音发送" /* cnb.z(-479236745853738L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cde cdeVarT = yg.s(-477694852594474L).t();
        cdeVarT.ab = "onItemClick" /* cnb.z(-477518758935338L) */;
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        uo uoVar = a;
        aki akiVarAd = uoVar.ad(cdkVar, exgVar);
        uoVar.y(akiVarAd, new mj(23));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
