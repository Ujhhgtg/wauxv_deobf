package me.hd.wauxv.plugin.api.method;

import me.hd.wauxv.obf.StaticHelpers5;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.FieldResolver;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.SyntheticPileOfMess;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.ReflectionWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginMediaMsgMethod {
    @cty
    public final void sendMediaMsg(String str, Object obj, String str2) {
        cnh.ae(str, obj, str2);
    }

    @cty
    public final void shareFile(String str, String str2, String str3, String str4) throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXFileObject" /* "com.tencent.mm.opensdk.modelmsg.WXFileObject" /* "com.tencent.mm.opensdk.modelmsg.WXFileObject" /* cnb.z(-92732638886698L)  */), new Object[0]);
        int i = 0;
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objC).r();
        fieldResolverVarR.name = "filePath" /* "filePath" /* "filePath" /* cnb.z(-94171452930858L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str3);
        cnh.ae(str, arj.y(str2, null, objC, 6), str4);
    }

    @cty
    public final void shareMiniProgram(String str, String str2, String str3, String str4, String str5, byte[] bArr,
            String str6) throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject" /* "com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject" /* "com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject" /* cnb.z(-94132798225194L)  */),
                new Object[0]);
        int i = 0;
        SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(objC);
        FieldResolver fieldResolverVarR = bmuVarBi.r();
        fieldResolverVarR.name = "userName" /* "userName" /* "userName" /* cnb.z(-94424856001322L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str4);
        FieldResolver fieldResolverVarR2 = bmuVarBi.r();
        fieldResolverVarR2.name = "path" /* "path" /* "path" /* cnb.z(-94403381164842L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).f(str5);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str6);
    }

    @cty
    public final void shareMusic(String str, String str2, String str3, String str4, String str5, byte[] bArr,
            String str6) throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXMusicObject" /* "com.tencent.mm.opensdk.modelmsg.WXMusicObject" /* "com.tencent.mm.opensdk.modelmsg.WXMusicObject" /* cnb.z(-94416266066730L)  */), new Object[0]);
        int i = 0;
        SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(objC);
        FieldResolver fieldResolverVarR = bmuVarBi.r();
        fieldResolverVarR.name = "musicUrl" /* "musicUrl" /* "musicUrl" /* cnb.z(-93651761888042L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str4);
        FieldResolver fieldResolverVarR2 = bmuVarBi.r();
        fieldResolverVarR2.name = "musicDataUrl" /* "musicDataUrl" /* "musicDataUrl" /* cnb.z(-93630287051562L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).f(str5);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str6);
    }

    @cty
    public final void shareMusicVideo(String str, String str2, String str3, String str4, String str5, String str6,
            int i, String str7, byte[] bArr, String str8) throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject" /* "com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject" /* "com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject" /* cnb.z(-93540092738346L)  */),
                new Object[0]);
        int i2 = 0;
        SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(objC);
        FieldResolver fieldResolverVarR = bmuVarBi.r();
        fieldResolverVarR.name = "musicUrl" /* "musicUrl" /* "musicUrl" /* cnb.z(-93905164958506L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str4);
        FieldResolver fieldResolverVarR2 = bmuVarBi.r();
        fieldResolverVarR2.name = "musicDataUrl" /* "musicDataUrl" /* "musicDataUrl" /* cnb.z(-93866510252842L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).f(str5);
        FieldResolver fieldResolverVarR3 = bmuVarBi.r();
        fieldResolverVarR3.name = "singerName" /* "singerName" /* "singerName" /* cnb.z(-93793495808810L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).f(str6);
        FieldResolver fieldResolverVarR4 = bmuVarBi.r();
        fieldResolverVarR4.name = "duration" /* "duration" /* "duration" /* cnb.z(-93763431037738L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).f(Integer.valueOf(i));
        FieldResolver fieldResolverVarR5 = bmuVarBi.r();
        fieldResolverVarR5.name = "songLyric" /* "songLyric" /* "songLyric" /* cnb.z(-117312736721706L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR5.resolve())).f(str7);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str8);
    }

    @cty
    public final void shareText(String str, String str2, String str3) throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXTextObject" /* "com.tencent.mm.opensdk.modelmsg.WXTextObject" /* "com.tencent.mm.opensdk.modelmsg.WXTextObject" /* cnb.z(-117286966917930L)  */), new Object[0]);
        int i = 0;
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objC).r();
        fieldResolverVarR.name = "text" /* "text" /* "text" /* cnb.z(-117128053127978L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str2);
        cnh.ae(str, arj.y(null, str2, objC, 5), str3);
    }

    @cty
    public final void shareVideo(String str, String str2, String str3, String str4, byte[] bArr, String str5)
            throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXVideoObject" /* "com.tencent.mm.opensdk.modelmsg.WXVideoObject" /* "com.tencent.mm.opensdk.modelmsg.WXVideoObject" /* cnb.z(-117639154236202L)  */), new Object[0]);
        int i = 0;
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objC).r();
        fieldResolverVarR.name = "videoUrl" /* "videoUrl" /* "videoUrl" /* cnb.z(-117424405871402L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str4);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str5);
    }

    @cty
    public final void shareWebpage(String str, String str2, String str3, String str4, byte[] bArr, String str5)
            throws IllegalAccessException {
        Object objC = ReflectionWrapper.createInstanceWithArgs(
                ajn.tryGetClassByClassName("com.tencent.mm.opensdk.modelmsg.WXWebpageObject" /* "com.tencent.mm.opensdk.modelmsg.WXWebpageObject" /* "com.tencent.mm.opensdk.modelmsg.WXWebpageObject" /* cnb.z(-117385751165738L)  */),
                new Object[0]);
        int i = 0;
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objC).r();
        fieldResolverVarR.name = "webpageUrl" /* "webpageUrl" /* "webpageUrl" /* cnb.z(-116629836921642L)  */;
        ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).f(str4);
        cnh.ae(str, arj.x(str2, str3, bArr, objC), str5);
    }
}
