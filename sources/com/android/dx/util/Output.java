package com.android.dx.util;

import me.hd.wauxv.obf.sh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Output extends sh {
    void alignTo(int i);

    void assertCursor(int i);

    int getCursor();

    void write(ByteArray byteArray);

    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);

    @Override // me.hd.wauxv.obf.sh
    void writeByte(int i);

    void writeInt(int i);

    void writeLong(long j);

    void writeShort(int i);

    int writeSleb128(int i);

    int writeUleb128(int i);

    void writeZeroes(int i);
}
