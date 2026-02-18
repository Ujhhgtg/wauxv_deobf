package me.hd.wauxv.obf;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcg extends ResponseBody {
    public final DiskLruCache.Snapshot a;
    public final String b;
    public final String c;
    public final cyl d;

    public bcg(DiskLruCache.Snapshot snapshot, String str, String str2) {
        this.a = snapshot;
        this.b = str;
        this.c = str2;
        this.d = emc.ah(new bcf(snapshot.getSource(1), this));
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        String str = this.c;
        if (str != null) {
            return Util.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        String str = this.b;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public final rm source() {
        return this.d;
    }
}
