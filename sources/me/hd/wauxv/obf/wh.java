package me.hd.wauxv.obf;

import java.time.LocalDate;
import java.util.List;
import me.hd.wauxv.data.bean.MsgInfoBean;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wh extends SwitchHook implements IDexFind, bns {
    public static final wh a;
    public static final List b;
    public static final String c;
    public static final String d;
    public static final String i;
    public static final us j;

    static {
        "今日已发${totalMsg}条" /* "今日已发${totalMsg}条" /* "今日已发${totalMsg}条" /* cnb.z(-423170242771754L)  */;
        a = new wh("ChatInputHintHook" /* "ChatInputHintHook" /* "ChatInputHintHook" /* cnb.z(-425665618770730L)  */);
        b = OtherStaticHelpers.argsToList("${totalMsg}" /* "${totalMsg}" /* "${totalMsg}" /* cnb.z(-423045688720170L)  */, "${textMsg}" /* "${textMsg}" /* "${textMsg}" /* cnb.z(-422478753037098L)  */, "${textWord}" /* "${textWord}" /* "${textWord}" /* cnb.z(-422448688266026L)  */, "${emojiMsg}" /* "${emojiMsg}" /* "${emojiMsg}" /* cnb.z(-422362788920106L)  */, "${transferMsg}" /* "${transferMsg}" /* "${transferMsg}" /* cnb.z(-422345609050922L)  */, "${redBagMsg}" /* "${redBagMsg}" /* "${redBagMsg}" /* cnb.z(-422281184541482L)  */, "${fileMsg}" /* "${fileMsg}" /* "${fileMsg}" /* cnb.z(-422740746042154L)  */);
        c = "美化" /* "美化" /* "美化" /* cnb.z(-422727861140266L)  */;
        d = "输入框提示" /* "输入框提示" /* "输入框提示" /* cnb.z(-422663436630826L)  */;
        i = "自定义聊天输入框默认提示的文本内容" /* "自定义聊天输入框默认提示的文本内容" /* "自定义聊天输入框默认提示的文本内容" /* cnb.z(-422689206434602L)  */;
        j = new us(6);
    }

    public static String l(String str) {
        return dnr.bo(
                dnr.bo(dnr.bo(
                        dnr.bo(dnr.bo(
                                dnr.bo(dnr.bo(str, "${totalMsg}" /* "${totalMsg}" /* "${totalMsg}" /* cnb.z(-425605489228586L)  */,
                                        String.valueOf(wd.a.k())), "${textMsg}" /* "${textMsg}" /* "${textMsg}" /* cnb.z(-425519589882666L)  */,
                                        String.valueOf(wb.a.k())),
                                "${textWord}" /* "${textWord}" /* "${textWord}" /* cnb.z(-426039280925482L)  */, String.valueOf(wc.a.k())),
                                "${emojiMsg}" /* "${emojiMsg}" /* "${emojiMsg}" /* cnb.z(-426022101056298L)  */, String.valueOf(vw.a.k())),
                        "${transferMsg}" /* "${transferMsg}" /* "${transferMsg}" /* cnb.z(-425936201710378L)  */, String.valueOf(we.a.k())),
                        "${redBagMsg}" /* "${redBagMsg}" /* "${redBagMsg}" /* cnb.z(-425871777200938L)  */, String.valueOf(wa.a.k())),
                "${fileMsg}" /* "${fileMsg}" /* "${fileMsg}" /* cnb.z(-425850302364458L)  */, String.valueOf(vx.a.k()));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(vu.a));
        wh whVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(whVar, listBf);
        whVar.x(hookManagerVarAb, new us(8));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(vu.a, dexKitBridge, new us(7));
    }

    @Override // me.hd.wauxv.obf.bns
    public final void m(MsgInfoBean msgInfoBean) {
        if (getIsEnabled() && vy.a.i() && msgInfoBean.isSend()) {
            int i2 = drv.a;
            int dayOfMonth = LocalDate.now().getDayOfMonth();
            vv vvVar = vv.a;
            if (vvVar.k() != dayOfMonth) {
                vvVar.r(dayOfMonth);
                wd.a.r(0);
                wb.a.r(0);
                wc.a.r(0);
                vw.a.r(0);
                we.a.r(0);
                wa.a.r(0);
                vx.a.r(0);
            }
            wd wdVar = wd.a;
            wdVar.r(wdVar.k() + 1);
            if (msgInfoBean.isText()) {
                wb wbVar = wb.a;
                wbVar.r(wbVar.k() + 1);
                wc wcVar = wc.a;
                wcVar.r(msgInfoBean.getContent().length() + wcVar.k());
                return;
            }
            if (msgInfoBean.isEmoji()) {
                vw vwVar = vw.a;
                vwVar.r(vwVar.k() + 1);
                return;
            }
            if (msgInfoBean.isTransfer()) {
                we weVar = we.a;
                weVar.r(weVar.k() + 1);
            } else if (msgInfoBean.isRedBag()) {
                wa waVar = wa.a;
                waVar.r(waVar.k() + 1);
            } else if (msgInfoBean.isFile()) {
                vx vxVar = vx.a;
                vxVar.r(vxVar.k() + 1);
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return j;
    }
}
