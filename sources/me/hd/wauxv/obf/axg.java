package me.hd.wauxv.obf;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class axg extends InputStream implements DataInput {
    public static final ByteOrder a = ByteOrder.LITTLE_ENDIAN;
    public static final ByteOrder b = ByteOrder.BIG_ENDIAN;
    public final DataInputStream c;
    public ByteOrder d;
    public int e;
    public byte[] f;

    public axg(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this(byteArrayInputStream, 0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.c.available();
    }

    public final void g(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            DataInputStream dataInputStream = this.c;
            int iSkip = (int) dataInputStream.skip(i3);
            if (iSkip <= 0) {
                if (this.f == null) {
                    this.f = new byte[8192];
                }
                iSkip = dataInputStream.read(this.f, 0, Math.min(8192, i3));
                if (iSkip == -1) {
                    throw new EOFException(yg.f(i, "Reached EOF while skipping ", " bytes."));
                }
            }
            i2 += iSkip;
        }
        this.e += i2;
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.e++;
        return this.c.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.e++;
        return this.c.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.e++;
        int i = this.c.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.e += 2;
        return this.c.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.e += i2;
        this.c.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.e += 4;
        DataInputStream dataInputStream = this.c;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        if ((i | i2 | i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == a) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        if (byteOrder == b) {
            return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        long j;
        long j2;
        this.e += 8;
        DataInputStream dataInputStream = this.c;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == a) {
            j = (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8);
            j2 = i;
        } else {
            if (byteOrder != b) {
                throw new IOException("Invalid byte order: " + this.d);
            }
            j = (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8);
            j2 = i8;
        }
        return j + j2;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.e += 2;
        DataInputStream dataInputStream = this.c;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == a) {
            return (short) ((i2 << 8) + i);
        }
        if (byteOrder == b) {
            return (short) ((i << 8) + i2);
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.e += 2;
        return this.c.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.e++;
        return this.c.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.e += 2;
        DataInputStream dataInputStream = this.c;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.d;
        if (byteOrder == a) {
            return (i2 << 8) + i;
        }
        if (byteOrder == b) {
            return (i << 8) + i2;
        }
        throw new IOException("Invalid byte order: " + this.d);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public axg(InputStream inputStream) {
        this(inputStream, 0);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    }

    public axg(InputStream inputStream, int i) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.d = byteOrder;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.c = dataInputStream;
        dataInputStream.mark(0);
        this.e = 0;
        this.d = byteOrder;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.c.read(bArr, i, i2);
        this.e += i3;
        return i3;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.e += bArr.length;
        this.c.readFully(bArr);
    }
}
