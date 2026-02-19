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
        String strZ = "Cache" /* "Cache" /* "Cache" /* cnb.z(-11205569674026L)  */;
        StringBuilder sb = new StringBuilder();
        String str = a;
        String strN = yg.decryptVar3UsingCnbZAndConcatToVar1(sb, str, -11231339477802L);
        StringBuilder sb2 = new StringBuilder();
        String str2 = b;
        zn znVar = new zn(strZ, OtherStaticHelpers.argsToList(strN, yg.decryptVar3UsingCnbZAndConcatToVar1(sb2, str2, -11201274706730L)));
        zn znVar2 = new zn("Log" /* "Log" /* "Log" /* cnb.z(-11154030066474L)  */, OtherStaticHelpers.argsToList(yg.h(-11102490458922L, StaticHelpers6.toSb(str)), yg.h(-11033770982186L, StaticHelpers6.toSb(str)), yg.h(-11519102286634L, StaticHelpers6.toSb(str2)), yg.h(-11450382809898L, StaticHelpers6.toSb(str2)), yg.h(-11437497908010L, StaticHelpers6.toSb(str2)), yg.h(-11360188496682L, StaticHelpers6.toSb(str2)), yg.h(-11282879085354L, StaticHelpers6.toSb(str2)), yg.h(-12786117638954L, StaticHelpers6.toSb(str2))));
        zn znVar3 = new zn("AppBrand" /* "AppBrand" /* "AppBrand" /* cnb.z(-12700218293034L)  */, OtherStaticHelpers.argsToList(yg.h(-12678743456554L, StaticHelpers6.toSb(str)), yg.h(-13134009989930L, StaticHelpers6.toSb(str)), yg.h(-13065290513194L, StaticHelpers6.toSb(str))));
        zn znVar4 = new zn("LiteApp" /* "LiteApp" /* "LiteApp" /* cnb.z(-13000866003754L)  */, OtherStaticHelpers.argsToList(yg.h(-12966506265386L, StaticHelpers6.toSb(str)), yg.h(-12352325942058L, StaticHelpers6.toSb(str))));
        String strZ2 = "Tinker" /* "Tinker" /* "Tinker" /* cnb.z(-12270721563434L)  */;
        StringBuilder sbY = StaticHelpers6.toSb(str);
        sbY.append("/tinker" /* "/tinker" /* "/tinker" /* cnb.z(-12240656792362L)  */);
        return OtherStaticHelpers.argsToList(znVar, znVar2, znVar3, znVar4, new zn(strZ2, dqc.toSingletonList(sbY.toString())));
    }
}
