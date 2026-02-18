package com.android.dx.io.instructions;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface CodeOutput extends CodeCursor {
    void write(short s);

    void write(short s, short s2);

    void write(short s, short s2, short s3);

    void write(short s, short s2, short s3, short s4);

    void write(short s, short s2, short s3, short s4, short s5);

    void write(byte[] bArr);

    void write(int[] iArr);

    void write(long[] jArr);

    void write(short[] sArr);

    void writeInt(int i);

    void writeLong(long j);
}
