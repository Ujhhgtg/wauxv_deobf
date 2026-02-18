package com.drake.net.exception;

import java.io.IOException;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class NetException extends IOException {
    private String occurred;
    private final Request request;

    public /* synthetic */ NetException(Request request, String str, Throwable th, int i, akd akdVar) {
        this(request, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (getMessage() == null) {
            str = "";
        } else {
            str = getMessage() + ' ';
        }
        sb.append(str);
        sb.append(getRequest().url());
        sb.append(this.occurred);
        return sb.toString();
    }

    public final String getOccurred() {
        return this.occurred;
    }

    public Request getRequest() {
        return this.request;
    }

    public final void setOccurred(String str) {
        throwIfVar1IsNull(str, "<set-?>");
        this.occurred = str;
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public NetException(Request request, String str, Throwable th) {
        super(str, th);
        throwIfVar1IsNull(request, "request");
        this.request = request;
        this.occurred = "";
    }
}
