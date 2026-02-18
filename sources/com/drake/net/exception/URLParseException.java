package com.drake.net.exception;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class URLParseException extends Exception {
    private String occurred;

    /* JADX WARN: Multi-variable type inference failed */
    public URLParseException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return super.getLocalizedMessage() + this.occurred;
    }

    public final String getOccurred() {
        return this.occurred;
    }

    public final void setOccurred(String str) {
        bzo.q(str, "<set-?>");
        this.occurred = str;
    }

    public /* synthetic */ URLParseException(String str, Throwable th, int i, akd akdVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }

    public URLParseException(String str, Throwable th) {
        super(str, th);
        this.occurred = "";
    }
}
