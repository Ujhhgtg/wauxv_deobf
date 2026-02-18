package com.bumptech.glide.load;

import me.hd.wauxv.obf.bof;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    ANIMATED_WEBP(true),
    AVIF(true),
    ANIMATED_AVIF(true),
    UNKNOWN(false);

    public final boolean a;

    ImageHeaderParser$ImageType(boolean z) {
        this.a = z;
    }

    public boolean hasAlpha() {
        return this.a;
    }

    public boolean isWebp() {
        int i = bof.a[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
