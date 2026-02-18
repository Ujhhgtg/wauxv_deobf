package me.hd.wauxv.obf;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class azv extends IOException {
    public azv(File file, File file2, String str) {
        throwIfVar1IsNull(file, "file");
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        sb.append(": ".concat(str));
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        super(string);
    }

    public azv(String str, int i, IOException iOException) {
        super(str + ", status code: " + i, iOException);
    }
}
