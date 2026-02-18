package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhh extends doo {
    public static final dhh a;
    public static final String b;
    public static final String c;
    public static final String h;

    static {
        "WAuxiliary_chatroom_info_pref" /* cnb.z(-594247380106026L) */;
        a = new dhh("ShowChatroomInfoHook" /* cnb.z(-597331166624554L) */);
        b = "界面" /* cnb.z(-594101351217962L) */;
        c = "显示群聊详情" /* cnb.z(-594054106577706L) */;
        h = "在对应的群聊界面中显示 群聊详情ID" /* cnb.z(-594075581414186L) */;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        bmu bmuVarS = yg.s(-594475013372714L);
        cde cdeVarT = bmuVarS.t();
        cdeVarT.ab = "initView" /* cnb.z(-594311804615466L) */;
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        dhh dhhVar = a;
        exg exgVar = exg.a;
        aki akiVarAd = dhhVar.ad(cdkVar, exgVar);
        dhhVar.x(akiVarAd, new dhg(0));
        akiVarAd.o();
        cde cdeVarT2 = bmuVarS.t();
        cdeVarT2.ab = "onPreferenceTreeClick" /* cnb.z(-594822905723690L) */;
        aki akiVarAd2 = dhhVar.ad((cdk) dkz.n(new Object[]{eoz.a, cvh.a.b()}, 2, cdeVarT2), exgVar);
        dhhVar.y(akiVarAd2, new dhg(1));
        akiVarAd2.o();
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
        return h;
    }
}
