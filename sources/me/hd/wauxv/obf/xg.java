package me.hd.wauxv.obf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xg extends SwitchHook implements bnr {
    public static final xg a = new xg("ChatUrlFormatShowHook" /* "ChatUrlFormatShowHook" /* "ChatUrlFormatShowHook" /* "ChatUrlFormatShowHook" /* cnb.z(-441239170186026L)   */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* "聊天" /* cnb.z(-446500505123626L)   */;
    public static final String c = "链接格式显示" /* "链接格式显示" /* "链接格式显示" /* "链接格式显示" /* cnb.z(-446453260483370L)   */;
    public static final String d = "将其他应用分享的口令进行格式化显示" /* "将其他应用分享的口令进行格式化显示" /* "将其他应用分享的口令进行格式化显示" /* "将其他应用分享的口令进行格式化显示" /* cnb.z(-446406015843114L)   */;

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

    @Override // me.hd.wauxv.obf.bnr
    public final void h(Object obj) throws IllegalAccessException {
        String strZ;
        String strZ2;
        if (getIsEnabled()) {
            int i = 0;
            bmu bmuVarBi = dqc.bi(obj);
            azg azgVarR = bmuVarBi.r();
            azgVarR.ab = "field_isSend" /* "field_isSend" /* "field_isSend" /* "field_isSend" /* cnb.z(-446672303815466L)   */;
            Integer num = (Integer) ((azk) yg.e(azgVarR)).e();
            if (num != null && num.intValue() == 1) {
                return;
            }
            azg azgVarR2 = bmuVarBi.r();
            azgVarR2.ab = "field_type" /* "field_type" /* "field_type" /* "field_type" /* cnb.z(-446599289371434L)   */;
            Object objE = ((azk) yg.e(azgVarR2)).e();
            throwIfVar1IsNull(objE);
            if (((Number) objE).intValue() == ewg.a.w) {
                azg azgVarR3 = bmuVarBi.r();
                azgVarR3.ab = "field_content" /* "field_content" /* "field_content" /* "field_content" /* cnb.z(-446569224600362L)   */;
                Object objE2 = ((azk) yg.e(azgVarR3)).e();
                throwIfVar1IsNull(objE2);
                String str = (String) objE2;
                String strAx = dnj.ax(str, ":" /* ":" /* ":" /* ":" /* cnb.z(-446491915189034L)   */);
                a.getClass();
                if (dnj.ab(str, "点击链接直接打开 或者 淘宝搜索直接打开" /* "点击链接直接打开 或者 淘宝搜索直接打开" /* "点击链接直接打开 或者 淘宝搜索直接打开" /* "点击链接直接打开 或者 淘宝搜索直接打开" /* cnb.z(-447101800545066L)   */, false)) {
                    String strZ3 = "【淘宝】" /* "【淘宝】" /* "【淘宝】" /* "【淘宝】" /* cnb.z(-446994426362666L)   */;
                    Pattern patternCompile = Pattern.compile("https?://[\\w./?=&%-]+" /* "https?://[\\w./?=&%-]+" /* "https?://[\\w./?=&%-]+" /* "https?://[\\w./?=&%-]+" /* cnb.z(-447007311264554L)   */);
                    throwIfVar1IsNull(patternCompile, "compile(...)");
                    Matcher matcher = patternCompile.matcher(str);
                    throwIfVar1IsNull(matcher, "matcher(...)");
                    bzx bzxVarY = ewz.y(matcher, 0, str);
                    if (bzxVarY != null) {
                        strZ = bzxVarY.a.group();
                        throwIfVar1IsNull(strZ, "group(...)");
                    } else {
                        strZ = "https://github.com/HdShare/WAuxiliary_Public" /* "https://github.com/HdShare/WAuxiliary_Public" /* "https://github.com/HdShare/WAuxiliary_Public" /* "https://github.com/HdShare/WAuxiliary_Public" /* cnb.z(-447445397928746L)   */;
                    }
                    Pattern patternCompile2 = Pattern.compile("「([^」]+)」" /* "「([^」]+)」" /* "「([^」]+)」" /* "「([^」]+)」" /* cnb.z(-447234944531242L)   */);
                    throwIfVar1IsNull(patternCompile2, "compile(...)");
                    Matcher matcher2 = patternCompile2.matcher(str);
                    throwIfVar1IsNull(matcher2, "matcher(...)");
                    bzx bzxVarY2 = ewz.y(matcher2, 0, str);
                    if (bzxVarY2 == null || (strZ2 = (String) ((bzv) bzxVarY2.e()).get(1)) == null) {
                        strZ2 = "解析异常" /* "解析异常" /* "解析异常" /* "解析异常" /* cnb.z(-446659418913578L)   */;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(strZ3);
                    sb.append('\n');
                    sb.append("<a href=\"" /* "<a href=\"" /* "<a href=\"" /* "<a href=\"" /* cnb.z(-116616952019754L)   */ + strZ + "\">" /* "\">" /* "\">" /* "\">" /* cnb.z(-117072218553130L)   */
                            + strZ2 + "</a>" /* "</a>" /* "</a>" /* "</a>" /* cnb.z(-117076513520426L)   */);
                    String string = sb.toString();
                    azg azgVarR4 = bmuVarBi.r();
                    azgVarR4.ab = "field_content" /* "field_content" /* "field_content" /* "field_content" /* cnb.z(-447174814989098L)   */;
                    azk azkVar = (azk) yg.e(azgVarR4);
                    StringBuilder sbY = dkz.y(strAx);
                    sbY.append(":\n" /* ":\n" /* ":\n" /* ":\n" /* cnb.z(-447097505577770L)   */);
                    sbY.append(string);
                    azkVar.f(sbY.toString());
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
