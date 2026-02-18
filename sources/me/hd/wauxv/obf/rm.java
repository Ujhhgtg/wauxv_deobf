package me.hd.wauxv.obf;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface rm extends dlc, ReadableByteChannel {
    String aa();

    int ab(crv crvVar);

    void ah(long j);

    long aj();

    InputStream ak();

    rh c();

    sj e(long j);

    byte[] h();

    boolean i();

    long k();

    String m(long j);

    void p(rh rhVar, long j);

    cyl peek();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    String readString(Charset charset);

    boolean s(long j, sj sjVar);

    void skip(long j);

    sj w();

    boolean x(long j);
}
