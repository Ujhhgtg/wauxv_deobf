package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elx extends SwitchHook implements IDexFind {
    public static final elx a = new elx("TransparentAvatarHook");
    public static final String b = "实验";
    public static final String c = "上传透明头像";
    public static final String i = "选择透明头像时需要先缩放一下再上传";

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(elw.a));
        elx elxVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(elxVar, listBf);
        elxVar.hookBefore(hookManagerVarAb, (obj -> {
            HookParam hookParam2 = (HookParam) obj;
            Object objX2 = hookParam2.getArgs()[2];
            if (objX2 == Bitmap.CompressFormat.JPEG) {
                Object objX3 = hookParam2.getArgs()[3];
                String str2 = (String) objX3;
                if (str2 == null) {
                    str2 = "";
                }
                if (StringsKt.contains(str2, "avatar", false)
                        || StringsKt.contains(str2, "user_hd_", false)) {
                    new ek(hookParam2, 2, 8).q(Bitmap.CompressFormat.PNG);
                    HookParam hookParam = hookParam2;
                    int i = 2;
                    Object[] objArrI = hookParam.b.getArgs();
                    if (objArrI != null) {
                        objArrI[i] = Bitmap.CompressFormat.PNG;
                    }
                }
            }

        }));
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
        StaticHelpers7.resolveDexAndCache(elw.a, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj1;
                String[] strArr2 = { "com.tencent.mm.sdk.platformtools" };
                dexMethodQueryBuilderVar2.searchedPackages = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar2 = new DexFinder();
                // version check
//                if (cnb.ab(ewk.e) || cnb.ac(ewh.d)) {
                    cdjVar2.usingStrings("MicroMsg.BitmapUtil", "saveBitmapToImage failed: %s");
//                } else {
//                    DexFinder.setClassEquals(cdjVar2, "com.tencent.mm.sdk.platformtools.BitmapUtil");
//                    cdjVar2.s("saveBitmapToImage");
//                }
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
            });
        }));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
