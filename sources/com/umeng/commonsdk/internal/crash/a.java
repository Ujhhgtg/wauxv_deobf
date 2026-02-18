package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Throwable th) {
        String string = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            string = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return string;
        } catch (Exception unused) {
            return string;
        }
    }
}
