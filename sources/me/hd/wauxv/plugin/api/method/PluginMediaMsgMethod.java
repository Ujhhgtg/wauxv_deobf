package me.hd.wauxv.plugin.api.method;

import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.azg;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.zf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginMediaMsgMethod {
    @cty
    public final void sendMediaMsg(String str, Object obj, String str2) {
        cnh.ae(str, obj, str2);
    }

    @cty
    public final void shareFile(String str, String str2, String str3, String str4) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXFileObject" /* cnb.z(-92732638886698L) */), new Object[0]);
        int i = bte.a;
        azg azgVarR = dqc.bi(objC).r();
        azgVarR.ab = "filePath" /* cnb.z(-94171452930858L) */;
        ((azk) aaz.e(azgVarR.c())).f(str3);
        cnh.ae(str, arj.y(str2, null, objC, 6), str4);
    }

    @cty
    public final void shareMiniProgram(String str, String str2, String str3, String str4, String str5, byte[] bArr, String str6) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject" /* cnb.z(-94132798225194L) */), new Object[0]);
        int i = bte.a;
        bmu bmuVarBi = dqc.bi(objC);
        azg azgVarR = bmuVarBi.r();
        azgVarR.ab = "userName" /* cnb.z(-94424856001322L) */;
        ((azk) aaz.e(azgVarR.c())).f(str4);
        azg azgVarR2 = bmuVarBi.r();
        azgVarR2.ab = "path" /* cnb.z(-94403381164842L) */;
        ((azk) aaz.e(azgVarR2.c())).f(str5);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str6);
    }

    @cty
    public final void shareMusic(String str, String str2, String str3, String str4, String str5, byte[] bArr, String str6) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXMusicObject" /* cnb.z(-94416266066730L) */), new Object[0]);
        int i = bte.a;
        bmu bmuVarBi = dqc.bi(objC);
        azg azgVarR = bmuVarBi.r();
        azgVarR.ab = "musicUrl" /* cnb.z(-93651761888042L) */;
        ((azk) aaz.e(azgVarR.c())).f(str4);
        azg azgVarR2 = bmuVarBi.r();
        azgVarR2.ab = "musicDataUrl" /* cnb.z(-93630287051562L) */;
        ((azk) aaz.e(azgVarR2.c())).f(str5);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str6);
    }

    @cty
    public final void shareMusicVideo(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, byte[] bArr, String str8) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject" /* cnb.z(-93540092738346L) */), new Object[0]);
        int i2 = bte.a;
        bmu bmuVarBi = dqc.bi(objC);
        azg azgVarR = bmuVarBi.r();
        azgVarR.ab = "musicUrl" /* cnb.z(-93905164958506L) */;
        ((azk) aaz.e(azgVarR.c())).f(str4);
        azg azgVarR2 = bmuVarBi.r();
        azgVarR2.ab = "musicDataUrl" /* cnb.z(-93866510252842L) */;
        ((azk) aaz.e(azgVarR2.c())).f(str5);
        azg azgVarR3 = bmuVarBi.r();
        azgVarR3.ab = "singerName" /* cnb.z(-93793495808810L) */;
        ((azk) aaz.e(azgVarR3.c())).f(str6);
        azg azgVarR4 = bmuVarBi.r();
        azgVarR4.ab = "duration" /* cnb.z(-93763431037738L) */;
        ((azk) aaz.e(azgVarR4.c())).f(Integer.valueOf(i));
        azg azgVarR5 = bmuVarBi.r();
        azgVarR5.ab = "songLyric" /* cnb.z(-117312736721706L) */;
        ((azk) aaz.e(azgVarR5.c())).f(str7);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str8);
    }

    @cty
    public final void shareText(String str, String str2, String str3) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXTextObject" /* cnb.z(-117286966917930L) */), new Object[0]);
        int i = bte.a;
        azg azgVarR = dqc.bi(objC).r();
        azgVarR.ab = "text" /* cnb.z(-117128053127978L) */;
        ((azk) aaz.e(azgVarR.c())).f(str2);
        cnh.ae(str, arj.y(null, str2, objC, 5), str3);
    }

    @cty
    public final void shareVideo(String str, String str2, String str3, String str4, byte[] bArr, String str5) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXVideoObject" /* cnb.z(-117639154236202L) */), new Object[0]);
        int i = bte.a;
        azg azgVarR = dqc.bi(objC).r();
        azgVarR.ab = "videoUrl" /* cnb.z(-117424405871402L) */;
        ((azk) aaz.e(azgVarR.c())).f(str4);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str5);
    }

    @cty
    public final void shareWebpage(String str, String str2, String str3, String str4, byte[] bArr, String str5) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag("com.tencent.mm.opensdk.modelmsg.WXWebpageObject" /* cnb.z(-117385751165738L) */), new Object[0]);
        int i = bte.a;
        azg azgVarR = dqc.bi(objC).r();
        azgVarR.ab = "webpageUrl" /* cnb.z(-116629836921642L) */;
        ((azk) aaz.e(azgVarR.c())).f(str4);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str5);
    }
}
