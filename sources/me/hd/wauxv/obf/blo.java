package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blo extends SwitchHook implements IDexFind {
    public static final blo a = new blo("HideSelfQRCodeTVHook" /* "HideSelfQRCodeTVHook" /* "HideSelfQRCodeTVHook" /* "HideSelfQRCodeTVHook" /* cnb.z(-483798001122090L)   */);
    public static final String b = "净化" /* "净化" /* "净化" /* "净化" /* cnb.z(-485795160914730L)   */;
    public static final String c = "隐藏名片文本" /* "隐藏名片文本" /* "隐藏名片文本" /* "隐藏名片文本" /* cnb.z(-485799455882026L)   */;
    public static final String i = "将微信中我的二维码名片相关文本隐藏" /* "将微信中我的二维码名片相关文本隐藏" /* "将微信中我的二维码名片相关文本隐藏" /* "将微信中我的二维码名片相关文本隐藏" /* cnb.z(-485769391110954L)   */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(emn.bb(bln.a));
        blo bloVar = a;
        aki akiVarAb = csb.ab(bloVar, listBf);
        bloVar.x(akiVarAb, new bep(21));
        akiVarAb.o();
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
        emn.aj(bln.a, dexKitBridge, new bep(22));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
