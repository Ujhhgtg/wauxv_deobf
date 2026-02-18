package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gf extends BaseHook {
    public static final gf a = new gf("AntiSnsAutoPlayHook" /* cnb.z(-544120816794410L) */);
    public static final String b = "朋友圈" /* cnb.z(-543618305620778L) */;
    public static final String c = "拦截朋友圈播放" /* cnb.z(-543635485489962L) */;
    public static final String d = "拦截朋友圈上下滑动时会自动播放视频" /* cnb.z(-543601125751594L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cde cdeVarT = yg.s(-544000557710122L).t();
        cdeVarT.ab = "onScrollStateChangedInMain" /* cnb.z(-543167334054698L) */;
        cdeVarT.g = 3;
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        gf gfVar = a;
        aki akiVarAd = gfVar.ad(cdkVar, exgVar);
        gfVar.y(akiVarAd, new bn(27));
        akiVarAd.o();
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
}
