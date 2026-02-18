package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dkh extends doo implements bng {
    public static final dkh a;
    public static final Object b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final djk m;

    static {
        "wx8dd6ecd81906fd84" /* cnb.z(-560802469772074L) */;
        "网抑云音乐" /* cnb.z(-561287801076522L) */;
        a = new dkh("SnsUploadAppInfoHook" /* cnb.z(-561408060160810L) */);
        b = bzo.ai(new csm("仇家多不方便透漏名字" /* cnb.z(-561244851403562L) */, new csm("wx528bc3d4b664d037" /* cnb.z(-561231966501674L) */, "仇家多不方便透漏名字" /* cnb.z(-561098822515498L) */)), new csm("来自一位陌生的透明人" /* cnb.z(-561085937613610L) */, new csm("wxaf048e83e0ab3f08" /* cnb.z(-561055872842538L) */, "来自一位陌生的透明人" /* cnb.z(-562589176167210L) */)), new csm("好友已设置小可爱可见" /* cnb.z(-562559111396138L) */, new csm("wx281a70a3d390bdf2" /* cnb.z(-562477507017514L) */, "好友已设置小可爱可见" /* cnb.z(-562413082508074L) */)), new csm("仅限长比我丑的人可见" /* cnb.z(-562949953420074L) */, new csm("wxe6f1e2780ae2a481" /* cnb.z(-562851169172266L) */, "仅限长比我丑的人可见" /* cnb.z(-562803924532010L) */)), new csm("一杯敬明天一杯敬过往" /* cnb.z(-562773859760938L) */, new csm("wx77909ff94ab8b236" /* cnb.z(-562692255382314L) */, "一杯敬明天一杯敬过往" /* cnb.z(-562078075058986L) */)), new csm("上瘾的东西不会是甜的" /* cnb.z(-561996470680362L) */, new csm("wx6d9823e75d12ae61" /* cnb.z(-561966405909290L) */, "上瘾的东西不会是甜的" /* cnb.z(-561919161269034L) */)), new csm("我能对你笑便能对你哭" /* cnb.z(-562370132835114L) */, new csm("wx9ad15554b19159ee" /* cnb.z(-562357247933226L) */, "我能对你笑便能对你哭" /* cnb.z(-562292823423786L) */)), new csm("主动久了便会累了" /* cnb.z(-562211219045162L) */, new csm("wx7395b7ea7ae1cab7" /* cnb.z(-562172564339498L) */, "主动久了便会累了" /* cnb.z(-559376540629802L) */)), new csm("先放手的人最心痛" /* cnb.z(-559337885924138L) */, new csm("wxff725ddb21b2e1f7" /* cnb.z(-559247691610922L) */, "先放手的人最心痛" /* cnb.z(-559183267101482L) */)), new csm("你若安好我便不扰" /* cnb.z(-559161792265002L) */, new csm("wxcd3130c3a4ae2177" /* cnb.z(-559123137559338L) */, "你若安好我便不扰" /* cnb.z(-559556929256234L) */)), new csm("像我这样的一个人" /* cnb.z(-559518274550570L) */, new csm("wxb09d381947fc1678" /* cnb.z(-559496799714090L) */, "像我这样的一个人" /* cnb.z(-559432375204650L) */)), new csm("已关闭评论功能" /* cnb.z(-559410900368170L) */, new csm("wxe0d515767e6c3e1e" /* cnb.z(-558826784815914L) */, "已关闭评论功能" /* cnb.z(-558693640829738L) */)), new csm("祝自己生日快乐" /* cnb.z(-558659281091370L) */, new csm("wxe299f0e6b1f956e2" /* cnb.z(-558624921353002L) */, "祝自己生日快乐" /* cnb.z(-558577676712746L) */)), new csm("今日还钱打99折" /* cnb.z(-559093072788266L) */, new csm("wx367b267970d4cff8" /* cnb.z(-559054418082602L) */, "今日还钱打99折" /* cnb.z(-558938453965610L) */)), new csm("同时提到了你" /* cnb.z(-558899799259946L) */, new csm("wx5ce6035a51a71c8d" /* cnb.z(-558869734488874L) */, "同时提到了你" /* cnb.z(-560454577421098L) */)), new csm("仅限渣女可见" /* cnb.z(-560424512650026L) */, new csm("wx115bcff956fd0905" /* cnb.z(-560377268009770L) */, "仅限渣女可见" /* cnb.z(-560330023369514L) */)), new csm("仅限渣男可见" /* cnb.z(-560282778729258L) */, new csm("wx3f4266934f0e29fb" /* cnb.z(-560252713958186L) */, "仅限渣男可见" /* cnb.z(-560738045262634L) */)), new csm("叙利亚打工中" /* cnb.z(-560707980491562L) */, new csm("wx934ec697e72a2fe1" /* cnb.z(-560660735851306L) */, "叙利亚打工中" /* cnb.z(-560613491211050L) */)), new csm("国家反诈中心" /* cnb.z(-560566246570794L) */, new csm("wxb0eef1f67b7a2949" /* cnb.z(-560536181799722L) */, "国家反诈中心" /* cnb.z(-559922001476394L) */)), new csm("看到请还钱" /* cnb.z(-559891936705322L) */, new csm("wxd5a171b821e04a1e" /* cnb.z(-559848987032362L) */, "看到请还钱" /* cnb.z(-559784562522922L) */)), new csm("Moon月球" /* cnb.z(-559741612849962L) */, new csm("wx288c5706af4794ee" /* cnb.z(-559711548078890L) */, "Moon月球" /* cnb.z(-560196879383338L) */)), new csm("原神" /* cnb.z(-560166814612266L) */, new csm("wx1c37343fc2a86bc4" /* cnb.z(-560102390102826L) */, "原神" /* cnb.z(-560055145462570L) */)));
        c = "朋友圈" /* cnb.z(-560059440429866L) */;
        i = "朋友圈上传尾巴" /* cnb.z(-560007900822314L) */;
        j = "自定义发表朋友圈显示的应用渠道来源" /* cnb.z(-559973541083946L) */;
        m = new djk(13);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(dke.a));
        dkh dkhVar = a;
        aki akiVarAb = csb.ab(dkhVar, listBf);
        dkhVar.y(akiVarAb, new djk(14));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(dke.a, dexKitBridge, new djk(15));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return j;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return m;
    }
}
