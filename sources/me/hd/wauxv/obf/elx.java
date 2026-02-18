package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elx extends SwitchHook implements IDexFind {
    public static final elx a = new elx("TransparentAvatarHook" /* cnb.z(-491528942254890L) */);
    public static final String b = "实验" /* cnb.z(-489080810896170L) */;
    public static final String c = "上传透明头像" /* cnb.z(-489102285732650L) */;
    public static final String i = "选择透明头像时需要先缩放一下再上传" /* cnb.z(-489055041092394L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.bf(emn.bb(elw.a));
        elx elxVar = a;
        aki akiVarAb = csb.ab(elxVar, listBf);
        elxVar.y(akiVarAb, new dos(7));
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
        emn.aj(elw.a, dexKitBridge, new dos(8));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
