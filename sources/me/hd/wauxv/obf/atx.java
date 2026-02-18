package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class atx extends BaseHook implements IDexFind {
    public static final atx a;
    public static final String b;
    public static final String c;
    public static final String i;
    public static final atn j;

    static {
        "9bd1281af3a31710a45b84d736363691" /* cnb.z(-495823909550890L) */;
        "08f223fa83f1ca34e143d1e580252c7c" /* cnb.z(-495699355499306L) */;
        a = new atx("EmojiGameHook" /* cnb.z(-507557760203562L) */);
        b = "辅助" /* cnb.z(-495007865764650L) */;
        c = "表情游戏" /* cnb.z(-494960621124394L) */;
        i = "预先自定义设置猜拳和骰子的随机结果" /* cnb.z(-494973506026282L) */;
        j = new atn(2);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(att.a));
        atx atxVar = a;
        aki akiVarAb = csb.ab(atxVar, listBf);
        atxVar.x(akiVarAb, new atn(8));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(atxVar, dqc.bf(emn.bb(ats.a)));
        atxVar.y(akiVarAb2, new atn(5));
        akiVarAb2.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        emn.aj(att.a, dexKitBridge, new atn(6));
        emn.aj(ats.a, dexKitBridge, new atn(7));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf p() {
        return j;
    }
}
