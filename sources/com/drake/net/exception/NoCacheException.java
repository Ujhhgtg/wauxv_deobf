package com.drake.net.exception;

import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.sj;
import me.hd.wauxv.obf.yg;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class NoCacheException extends NetException {
    public /* synthetic */ NoCacheException(Request request, String str, Throwable th, int i, akd akdVar) {
        this(request, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    @Override // com.drake.net.exception.NetException, java.lang.Throwable
    public String getLocalizedMessage() {
        StringBuilder sb = new StringBuilder("cacheKey = ");
        Request request = getRequest();
        throwIfVar1IsNull(request, "request");
        yg.t(request.tag(cmz.class));
        String str = request.method() + request.url();
        sj sjVar = sj.a;
        sb.append(nu.g(str).f("SHA-1").h());
        sb.append(' ');
        sb.append(super.getLocalizedMessage());
        return sb.toString();
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public NoCacheException(Request request, String str, Throwable th) {
        super(request, str, th);
        throwIfVar1IsNull(request, "request");
    }
}
