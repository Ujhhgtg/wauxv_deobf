package me.hd.wauxv.obf;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface btj {
    public static final Charset k = Charset.forName("UTF-8");

    void d(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
