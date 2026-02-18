package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ahl {
    public static final List a;

    static {
        try {
            a = dfv.ak(dfv.a(Arrays.asList(new eo()).iterator()));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
