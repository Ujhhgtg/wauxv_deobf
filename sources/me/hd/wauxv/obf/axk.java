package me.hd.wauxv.obf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axk extends axg {
    public axk(byte[] bArr) {
        super(bArr);
        this.c.mark(Integer.MAX_VALUE);
    }

    public final void h(long j) throws IOException {
        int i = this.e;
        if (i > j) {
            this.e = 0;
            this.c.reset();
        } else {
            j -= (long) i;
        }
        g((int) j);
    }

    public axk(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.c.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
