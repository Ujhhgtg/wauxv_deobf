package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ctf {
    public static final dov a = new dov(new cfh(15));
    public static final dov b = new dov(new cfh(16));

    public static String c(String... strArr) {
        String str = (String) b.getValue();
        String str2 = File.separator;
        File file = new File(str, la.u(strArr, str2, "WAuxiliary" /* cnb.z(-47111496268586L) */ + str2, null, null, 60));
        file.mkdirs();
        return file.getPath();
    }
}
