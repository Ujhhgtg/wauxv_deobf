package me.hd.wauxv.obf;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zo {
    public static final String a;
    public static final String b;

    static {
        File parentFile;
        HostInfoRegistry.INSTANCE.getClass();
        File parentFile2 = HostInfoRegistry.getContext().getFilesDir().getParentFile();
        String path = null;
        a = String.valueOf(parentFile2 != null ? parentFile2.getPath() : null);
        File externalCacheDir = HostInfoRegistry.getContext().getExternalCacheDir();
        if (externalCacheDir != null && (parentFile = externalCacheDir.getParentFile()) != null) {
            path = parentFile.getPath();
        }
        b = String.valueOf(path);
    }

    public static List c() {
        String strZ = "Cache";
        String dataDir = a;
        String dataDirCache = dataDir +
                "/cache";
        String cacheDir = b;
        String cacheDirCache = cacheDir +
                "/cache";
        zn znVar = new zn(strZ, OtherStaticHelpers.argsToList(dataDirCache, cacheDirCache));
        zn znVar2 = new zn("Log" , OtherStaticHelpers.argsToList(dataDir + "/MicroMsg/crash", dataDir+ "/MicroMsg/xlog", cacheDir + "/MicroMsg/crash", cacheDir + "/MicroMsg/xlog", cacheDir + "/files/onelog", cacheDir + "/files/tbslog", cacheDir + "/files/Tencent/tbs_common_log", cacheDir + "/files/Tencent/tbs_live_log"));
        zn znVar3 = new zn("AppBrand", OtherStaticHelpers.argsToList(dataDir + "/appbrand", dataDir + "/cache/appbrand", dataDir + "/MicroMsg/appbrand"));
        zn znVar4 = new zn("LiteApp", OtherStaticHelpers.argsToList(dataDir + "/cache/liteapp", dataDir + "/files/liteapp"));
        String strZ2 = "Tinker";
        StringBuilder sbY = StaticHelpers6.toSb(dataDir);
        sbY.append("/tinker");
        return OtherStaticHelpers.argsToList(znVar, znVar2, znVar3, znVar4, new zn(strZ2, dqc.toSingletonList(sbY.toString())));
    }
}
