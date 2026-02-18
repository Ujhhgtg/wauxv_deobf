package com.drake.net.exception;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RequestParamsException extends HttpResponseException {
    private Object tag;

    public /* synthetic */ RequestParamsException(Response response, String str, Throwable th, Object obj, int i,
            akd akdVar) {
        this(response, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th, (i & 8) != 0 ? null : obj);
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public RequestParamsException(Response response, String str, Throwable th, Object obj) {
        super(response, str, th);
        throwIfVar1IsNull(response, "response");
        this.tag = obj;
    }
}
