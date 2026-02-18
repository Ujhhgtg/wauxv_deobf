package me.hd.wauxv.obf;

import okhttp3.MediaType;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cbb {
    public static final MediaType a;
    public static final MediaType b;

    static {
        MediaType.Companion companion = MediaType.Companion;
        companion.get("image/*");
        companion.get("image/gif");
        companion.get("image/jpeg");
        companion.get("image/png");
        companion.get("video/mpeg");
        companion.get("text/plain");
        a = companion.get("application/json; charset=utf-8");
        companion.get("application/xml");
        companion.get("text/html");
        b = companion.get("multipart/form-data");
        companion.get("application/octet-stream");
        companion.get("application/x-www-form-urlencoded");
    }
}
