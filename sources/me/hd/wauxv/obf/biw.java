package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class biw {
    public static final biw a;
    public static final String b;
    public static final String c;
    public static final List d;
    public static final dov e;

    static {
        "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation" /* cnb.z(-590003952417578L) */;
        "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation" /* cnb.z(-591219428162346L) */;
        a = new biw();
        b = la.u(new String[]{"qqmail" /* cnb.z(-596626791988010L) */, "fmessage" /* cnb.z(-596596727216938L) */, "tmessage" /* cnb.z(-596558072511274L) */, "qmessage" /* cnb.z(-596536597674794L) */, "qqsync" /* cnb.z(-596497942969130L) */, "floatbottle" /* cnb.z(-597017634011946L) */, "lbsapp" /* cnb.z(-597000454142762L) */, "shakeapp" /* cnb.z(-596953209502506L) */, "medianote" /* cnb.z(-596931734666026L) */, "qqfriend" /* cnb.z(-596837245385514L) */, "newsapp" /* cnb.z(-596798590679850L) */, "blogapp" /* cnb.z(-596764230941482L) */, "facebookapp" /* cnb.z(-596180115389226L) */, "topstoryapp" /* cnb.z(-596162935520042L) */, "masssendapp" /* cnb.z(-596077036174122L) */, "feedsapp" /* cnb.z(-596059856304938L) */, "voipapp" /* cnb.z(-596038381468458L) */, "cardpackage" /* cnb.z(-596004021730090L) */, "voicevoipapp" /* cnb.z(-596467878198058L) */, "voiceinputapp" /* cnb.z(-596446403361578L) */, "officialaccounts" /* cnb.z(-596369093950250L) */, "linkedinplugin" /* cnb.z(-596313259375402L) */, "notifymessage" /* cnb.z(-596231654996778L) */, "appbrandcustomerservicemsg" /* cnb.z(-597803613027114L) */, "appbrand_notify_message" /* cnb.z(-597722008648490L) */, "opencustomerservicemsg" /* cnb.z(-597618929433386L) */, "conversationboxservice" /* cnb.z(-598052721130282L) */, "service_officialaccounts" /* cnb.z(-597953936882474L) */, "BrandEcsTemplateMsg@fakeuser" /* cnb.z(-597296806886186L) */}, null, "(" /* cnb.z(-597155072965418L) */, ")" /* cnb.z(-597163662900010L) */, new bep(1), 25);
        dov dovVar = ctf.a;
        c = ctf.c("Resource" /* cnb.z(-47923245087530L) */, "Group" /* cnb.z(-47884590381866L) */);
        d = aba.ag(new biv("全部" /* cnb.z(-597172252834602L) */, 0, "ic_group.png" /* cnb.z(-597107828325162L) */, new String[0]), new biv("群聊" /* cnb.z(-597103533357866L) */, 1, "ic_group.png" /* cnb.z(-597039108848426L) */, new String[0]), new biv("好友" /* cnb.z(-597584569695018L) */, 2, "ic_group.png" /* cnb.z(-597520145185578L) */, new String[0]), new biv("官方" /* cnb.z(-597515850218282L) */, 3, "ic_group.png" /* cnb.z(-597451425708842L) */, new String[0]), new biv("示例" /* cnb.z(-597447130741546L) */, 4, "ic_group.png" /* cnb.z(-597382706232106L) */, new String[]{"weixin" /* cnb.z(-597378411264810L) */}));
        e = new dov(new amd(9));
    }

    public static List f() {
        return (List) e.getValue();
    }
}
