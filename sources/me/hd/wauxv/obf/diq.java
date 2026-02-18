package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class diq extends SwitchHook {
    public static final diq a = new diq("SnsBackPreviewSaveHook" /* cnb.z(-541410692430634L) */);
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final dhg j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Download" /* cnb.z(-46304042416938L) */, "Sns" /* cnb.z(-46282567580458L) */);
        c = "朋友圈" /* cnb.z(-530548720139050L) */;
        h = "朋友圈封面保存" /* cnb.z(-531046936345386L) */;
        i = "支持长按朋友圈封面保存到本地存储中" /* cnb.z(-531012576607018L) */;
        j = new dhg(10);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        for (String str : aba.ag(
                "com.tencent.mm.plugin.sns.cover.preview.SnsImageBackPreview" /* cnb.z(-541311908182826L) */,
                "com.tencent.mm.plugin.sns.cover.preview.SnsVideoBackPreview" /* cnb.z(-542737837325098L) */,
                "com.tencent.mm.plugin.finder.view.snscover.SnsFinderVideoBackPreview" /* cnb.z(-542995535362858L) */)) {
            int i2 = bte.a;
            cde cdeVarT = dqc.bh(ajn.ag(str)).t();
            cdeVarT.ab = "loadCover" /* cnb.z(-542183786543914L) */;
            cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
            exg exgVar = exg.a;
            diq diqVar = a;
            aki akiVarAd = diqVar.ad(cdkVar, exgVar);
            diqVar.x(akiVarAd, new dhg(11));
            akiVarAd.o();
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IHasInvokeMethod p() {
        return j;
    }
}
