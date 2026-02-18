package me.hd.wauxv.obf;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axf extends MediaDataSource {
    public long a;
    public final /* synthetic */ axk b;

    public axf(axk axkVar) {
        this.b = axkVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (j < 0) {
            return -1;
        }
        try {
            long j2 = this.a;
            axk axkVar = this.b;
            if (j2 != j) {
                if (j2 >= 0 && j >= j2 + ((long) axkVar.c.available())) {
                    return -1;
                }
                axkVar.h(j);
                this.a = j;
            }
            if (i2 > axkVar.c.available()) {
                i2 = axkVar.c.available();
            }
            int i3 = axkVar.read(bArr, i, i2);
            if (i3 >= 0) {
                this.a += (long) i3;
                return i3;
            }
        } catch (IOException unused) {
        }
        this.a = -1L;
        return -1;
    }
}
