package me.hd.wauxv.obf;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface rl extends dhy, WritableByteChannel {
    rl ae(sj sjVar);

    rl af(int i, int i2, byte[] bArr);

    rl ai(long j);

    rh c();

    @Override // me.hd.wauxv.obf.dhy, java.io.Flushable
    void flush();

    rl g();

    rl j();

    rl q(String str);

    long r(dlc dlcVar);

    rl u(long j);

    rl write(byte[] bArr);

    rl writeByte(int i);

    rl writeInt(int i);

    rl writeShort(int i);
}
