package com.drake.net.exception;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class HttpFailureException extends NetException {
    public /* synthetic */ HttpFailureException(Request request, String str, Throwable th, int i, akd akdVar) {
        this(request, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpFailureException(Request request, String str, Throwable th) {
        super(request, str, th);
        bzo.q(request, "request");
    }
}
