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
        bmo.a.getClass();
        File parentFile2 = bmo.n().getFilesDir().getParentFile();
        String path = null;
        a = String.valueOf(parentFile2 != null ? parentFile2.getPath() : null);
        File externalCacheDir = bmo.n().getExternalCacheDir();
        if (externalCacheDir != null && (parentFile = externalCacheDir.getParentFile()) != null) {
            path = parentFile.getPath();
        }
        b = String.valueOf(path);
    }

    public static List c() {
        String strZ = cnb.z(-11205569674026L);
        StringBuilder sb = new StringBuilder();
        String str = a;
        String strN = yg.n(sb, str, -11231339477802L);
        StringBuilder sb2 = new StringBuilder();
        String str2 = b;
        zn znVar = new zn(strZ, aba.ag(strN, yg.n(sb2, str2, -11201274706730L)));
        zn znVar2 = new zn(cnb.z(-11154030066474L), aba.ag(yg.h(-11102490458922L, dkz.y(str)), yg.h(-11033770982186L, dkz.y(str)), yg.h(-11519102286634L, dkz.y(str2)), yg.h(-11450382809898L, dkz.y(str2)), yg.h(-11437497908010L, dkz.y(str2)), yg.h(-11360188496682L, dkz.y(str2)), yg.h(-11282879085354L, dkz.y(str2)), yg.h(-12786117638954L, dkz.y(str2))));
        zn znVar3 = new zn(cnb.z(-12700218293034L), aba.ag(yg.h(-12678743456554L, dkz.y(str)), yg.h(-13134009989930L, dkz.y(str)), yg.h(-13065290513194L, dkz.y(str))));
        zn znVar4 = new zn(cnb.z(-13000866003754L), aba.ag(yg.h(-12966506265386L, dkz.y(str)), yg.h(-12352325942058L, dkz.y(str))));
        String strZ2 = cnb.z(-12270721563434L);
        StringBuilder sbY = dkz.y(str);
        sbY.append(cnb.z(-12240656792362L));
        return aba.ag(znVar, znVar2, znVar3, znVar4, new zn(strZ2, dqc.bf(sbY.toString())));
    }
}
