package com.android.dx.util;

import java.io.PrintWriter;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Writers {
    private Writers() {
    }

    public static PrintWriter printWriterFor(Writer writer) {
        return writer instanceof PrintWriter ? (PrintWriter) writer : new PrintWriter(writer);
    }
}
