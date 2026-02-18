package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhm extends doo implements bng {
    public static final dhm a = new dhm("ShowHideEmojiHook" /* cnb.z(-458715392113450L) */);
    public static final String b = "聊天" /* cnb.z(-464745526197034L) */;
    public static final String c = "显示隐藏表情" /* cnb.z(-464698281556778L) */;
    public static final String i = "显示微信所有表情中被隐藏掉的旧表情" /* cnb.z(-464651036916522L) */;
    public static final List j = aba.ag(new dhk("[酷]" /* cnb.z(-464590907374378L) */, "/::+" /* cnb.z(-464608087243562L) */), new dhk("[饥饿]" /* cnb.z(-464569432537898L) */, "/::g" /* cnb.z(-465063353776938L) */), new dhk("[流汗]" /* cnb.z(-465093418548010L) */, "/::L" /* cnb.z(-465037583973162L) */), new dhk("[奋斗]" /* cnb.z(-464998929267498L) */, "/:,@f" /* cnb.z(-465011814169386L) */), new dhk("[疯了]" /* cnb.z(-464968864496426L) */, "/::8" /* cnb.z(-464930209790762L) */), new dhk("[糗大了]" /* cnb.z(-464943094692650L) */, "/:&-(" /* cnb.z(-464900145019690L) */), new dhk("[哈欠]" /* cnb.z(-464857195346730L) */, "/::-O" /* cnb.z(-464887260117802L) */), new dhk("[吓]" /* cnb.z(-464844310444842L) */, "/:@x" /* cnb.z(-464243015023402L) */), new dhk("[西瓜]" /* cnb.z(-464255899925290L) */, "/:<W>" /* cnb.z(-464217245219626L) */), new dhk("[篮球]" /* cnb.z(-464174295546666L) */, "/:basketb" /* cnb.z(-464187180448554L) */), new dhk("[乒乓]" /* cnb.z(-464161410644778L) */, "/:oo" /* cnb.z(-464122755939114L) */), new dhk("[饭]" /* cnb.z(-464066921364266L) */, "/:eat" /* cnb.z(-464084101233450L) */), new dhk("[闪电]" /* cnb.z(-464041151560490L) */, "/:li" /* cnb.z(-464002496854826L) */), new dhk("[刀]" /* cnb.z(-464015381756714L) */, "/:kn" /* cnb.z(-464513597963050L) */), new dhk("[足球]" /* cnb.z(-464543662734122L) */, "/:footb" /* cnb.z(-464487828159274L) */), new dhk("[瓢虫]" /* cnb.z(-464453468420906L) */, "/:ladybug" /* cnb.z(-464414813715242L) */), new dhk("[差劲]" /* cnb.z(-464389043911466L) */, "/:bad" /* cnb.z(-464401928813354L) */), new dhk("[爱你]" /* cnb.z(-464358979140394L) */, "/:lvu" /* cnb.z(-464320324434730L) */), new dhk("[NO]" /* cnb.z(-464277374761770L) */, "/:no" /* cnb.z(-464290259663658L) */), new dhk("[爱情]" /* cnb.z(-465900872399658L) */, "/:love" /* cnb.z(-465913757301546L) */), new dhk("[飞吻]" /* cnb.z(-465883692530474L) */, "/:<L>" /* cnb.z(-465827857955626L) */), new dhk("[怄火]" /* cnb.z(-465784908282666L) */, "/:<O>" /* cnb.z(-465814973053738L) */), new dhk("[磕头]" /* cnb.z(-465772023380778L) */, "/:kotow" /* cnb.z(-465716188805930L) */), new dhk("[回头]" /* cnb.z(-465681829067562L) */, "/:turn" /* cnb.z(-465711893838634L) */), new dhk("[跳绳]" /* cnb.z(-465664649198378L) */, "/:skip" /* cnb.z(-466175750306602L) */), new dhk("[投降]" /* cnb.z(-466128505666346L) */, "/:oY" /* cnb.z(-466158570437418L) */), new dhk("[激动]" /* cnb.z(-466102735862570L) */, "/:#-0" /* cnb.z(-466064081156906L) */), new dhk("[乱舞]" /* cnb.z(-466089850960682L) */, "/:hiphot" /* cnb.z(-466034016385834L) */), new dhk("[献吻]" /* cnb.z(-466012541549354L) */, "/:kiss" /* cnb.z(-465956706974506L) */), new dhk("[左太极]" /* cnb.z(-465926642203434L) */, "/:<&" /* cnb.z(-465952412007210L) */), new dhk("[右太极]" /* cnb.z(-465346821618474L) */, "/:&>" /* cnb.z(-465303871945514L) */));

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(dhl.a));
        dhm dhmVar = a;
        aki akiVarAb = csb.ab(dhmVar, listBf);
        dhmVar.x(akiVarAb, new dhg(2));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(dhl.a, dexKitBridge, new dhg(3));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
