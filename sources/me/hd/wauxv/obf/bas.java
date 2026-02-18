package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bas extends pb {
    public static final byte[] c = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(btj.k);

    @Override // me.hd.wauxv.obf.pb
    public final Bitmap b(oz ozVar, Bitmap bitmap, int i, int i2) {
        return ele.d(ozVar, bitmap, i, i2);
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        messageDigest.update(c);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        return obj instanceof bas;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return 1572326941;
    }
}
