package com.android.dx.command.findusages;

import java.io.File;
import java.io.PrintWriter;
import me.hd.wauxv.obf.amk;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Main {
    public static void main(String[] strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        amk amkVar = new amk(new File(str));
        PrintWriter printWriter = new PrintWriter(System.out);
        new FindUsages(amkVar, str2, str3, printWriter).findUsages();
        printWriter.flush();
    }
}
