package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoViewOriginalPhotoHook extends SwitchHook implements IDexFind {
    public static final AutoViewOriginalPhotoHook a = new AutoViewOriginalPhotoHook("AutoViewOriginalPhotoHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 440247032740650L)
                                                                                                                 */);
    public static final String b = "聊天" /* cnb.z(-441325069531946L) */;
    public static final String c = "自动查看原图" /* cnb.z(-441329364499242L) */;
    public static final String d = "在打开图片和视频时自动点击查看原图" /* cnb.z(-441299299728170L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        Iterator it = aba.ag(MethodSetImageHdImgBtnVisibility.a, MethodCheckNeedShowOriginVideoBtn.a).iterator();
        while (it.hasNext()) {
            List listBf = dqc.bf(emn.bb((DexDescData) it.next()));
            AutoViewOriginalPhotoHook mmVar = a;
            aki akiVarAb = csb.ab(mmVar, listBf);
            mmVar.x(akiVarAb, new mj(0));
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
        emn.aj(MethodSetImageHdImgBtnVisibility.a, dexKitBridge, new mj(1));
        emn.aj(MethodCheckNeedShowOriginVideoBtn.a, dexKitBridge, new mj(2));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
