package com.android.dx.command.grep;

import java.io.File;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import me.hd.wauxv.obf.amk;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Main {
    public static void main(String[] strArr) {
        System.exit(new Grep(new amk(new File(strArr[0])), Pattern.compile(strArr[1]), new PrintWriter(System.out)).grep() <= 0 ? 1 : 0);
    }
}
