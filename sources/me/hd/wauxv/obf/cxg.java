package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxg extends SwitchHook implements IDexFind {
    public static final cxg a = new cxg("QuoteClickToPosHook" /* cnb.z(-460076896746282L) */);
    public static final String b = "聊天" /* cnb.z(-461099098962730L) */;
    public static final String c = "引用消息直达" /* cnb.z(-461103393930026L) */;
    public static final String i = "点击引用消息内容直接定位到原文位置" /* cnb.z(-461073329158954L) */;
    public static final boolean j;

    /* JADX WARN: Found duplicated region for block: B:11:0x005a */
    static {
        boolean z;
        ewk ewkVar = ewk.k;
        bmo bmoVar = bmo.a;
        bmoVar.getClass();
        if (bmo.q() > ewkVar.r || bmo.r()) {
            ewh ewhVar = ewh.k;
            bmoVar.getClass();
            z = bmo.q() <= ewhVar.u && bmo.r();
        }
        j = z;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean _ab() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        if (j) {
            List listBf = dqc.bf(emn.bb(cxe.a));
            cxg cxgVar = a;
            aki akiVarAb = csb.ab(cxgVar, listBf);
            cxgVar.y(akiVarAb, new cvc(6));
            akiVarAb.o();
        }
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
        if (j) {
            emn.aj(cxe.a, dexKitBridge, new cvc(7));
            emn.aj(cxf.a, dexKitBridge, new cvc(8));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
