package com.android.dx.util;

import me.hd.wauxv.obf.axc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MutabilityException extends axc {
    public MutabilityException(String str, Throwable th) {
        super(str, th);
    }

    public MutabilityException(String str) {
        super(str, null);
    }

    public MutabilityException(Throwable th) {
        super(null, th);
    }
}
