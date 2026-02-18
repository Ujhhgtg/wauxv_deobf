package com.drake.net.exception;

import me.hd.wauxv.obf.ahp;
import me.hd.wauxv.obf.KotlinHelpers;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class NetCancellationExceptionKt {
    public static final NetCancellationException NetCancellationException(ahp ahpVar, String str) {
        throwIfVar1IsNull(ahpVar, "<this>");
        return new NetCancellationException(ahpVar, str);
    }

    public static /* synthetic */ NetCancellationException NetCancellationException$default(ahp ahpVar, String str,
            int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return NetCancellationException(ahpVar, str);
    }
}
