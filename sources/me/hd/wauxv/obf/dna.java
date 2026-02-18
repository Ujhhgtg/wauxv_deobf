package me.hd.wauxv.obf;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dna extends ByteArrayOutputStream {
    public final /* synthetic */ dnb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dna(dnb dnbVar, int i) {
        super(i);
        this.a = dnbVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i = ((ByteArrayOutputStream) this).count;
        if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
            i--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i, this.a.b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
