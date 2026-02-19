package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dkl extends SwitchHook implements IDexFind {
    public static final dkl a = new dkl("SnsUploadOriginalPhoto" /* "SnsUploadOriginalPhoto" /* "SnsUploadOriginalPhoto" /* cnb.z(-548527453240106L)  */);
    public static final String b = "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-547835963505450L)  */;
    public static final String c = "朋友圈上传原图" /* "朋友圈上传原图" /* "朋友圈上传原图" /* cnb.z(-547853143374634L)  */;
    public static final String i = "上传时不压缩图片，过大可能上传失败" /* "上传时不压缩图片，过大可能上传失败" /* "上传时不压缩图片，过大可能上传失败" /* cnb.z(-549468051077930L)  */;
    public static final djk j = new djk(17);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(dki.a));
        dkl dklVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(dklVar, listBf);
        dklVar.hookBefore(hookManagerVarAb, new djk(18));
        dklVar.hookAfter(hookManagerVarAb, new djk(19));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
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
        StaticHelpers7.resolveDexAndCache(dki.a, dexKitBridge, new djk(20));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }
}
