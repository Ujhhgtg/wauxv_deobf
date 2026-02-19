package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PathUtils {
    public static final Kotlin$Lazy externalStorageRoot = new Kotlin$Lazy(() -> {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    });
    public static final Kotlin$Lazy mediaDataFolder = new Kotlin$Lazy(() -> {
        StringBuilder sb = new StringBuilder();
        concatVar3Var2ToVar1(sb, (String) PathUtils.externalStorageRoot.getValue(), "/Android/media/");
        sb.append(HostInfoRegistry.getPackageName());
        return sb.toString();
    });

    public static String getModuleSubDir(String... strArr) {
        String str = (String) mediaDataFolder.getValue();
        String str2 = File.separator;
        File file = new File(str, SomeStaticHelpers.joinToString(strArr, str2, "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-47111496268586L)  */ + str2, null, null, 60));
        file.mkdirs();
        return file.getPath();
    }
}
