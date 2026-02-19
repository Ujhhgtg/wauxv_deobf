package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blm extends SwitchHook implements IDexFind {
    public static final blm a = new blm("HideOnLineBannerHook" /* "HideOnLineBannerHook" /* "HideOnLineBannerHook" /* cnb.z(-487362823977770L)  */);
    public static final String b = "净化" /* "净化" /* "净化" /* cnb.z(-484626929810218L)  */;
    public static final String c = "隐藏在线顶栏" /* "隐藏在线顶栏" /* "隐藏在线顶栏" /* cnb.z(-484631224777514L)  */;
    public static final String i = "将主页顶部状态栏其他设备已登录隐藏" /* "将主页顶部状态栏其他设备已登录隐藏" /* "将主页顶部状态栏其他设备已登录隐藏" /* cnb.z(-484051404192554L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(emn.bb(bll.a));
        blm blmVar = a;
        aki akiVarAb = csb.ab(blmVar, listBf);
        blmVar.y(akiVarAb, new bep(18));
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
        emn.aj(bll.a, dexKitBridge, new bep(19));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
