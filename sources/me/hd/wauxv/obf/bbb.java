package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbb {
    public ByteBuffer a;
    public int b;
    public int c;
    public int[] d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int[] i;
    public int j;
    public int k;
    public final arj l;
    public final dop m;

    public bbb() {
        arj arjVar = arj.f;
        dop dopVarI = dop.i();
        this.c = 1;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.i = new int[16];
        this.j = 0;
        this.k = 0;
        this.l = arjVar;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
        this.a = byteBufferOrder;
        this.m = dopVarI;
        this.b = byteBufferOrder.capacity();
    }

    public final void aa(int i) {
        this.d[i] = x();
    }

    public final void ab(int i) {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
        int[] iArr = this.d;
        if (iArr == null || iArr.length < i) {
            this.d = new int[i];
        }
        this.e = i;
        Arrays.fill(this.d, 0, i, 0);
        this.f = true;
        this.h = x();
    }

    public final void ac(int i, int i2, int i3) {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
        this.k = i2;
        int i4 = i * i2;
        y(4, i4);
        y(i3, i4);
        this.f = true;
    }

    public final void n(byte b) {
        y(1, 0);
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, b);
    }

    public final void o(byte b, int i) {
        if (b != 0) {
            n(b);
            aa(i);
        }
    }

    public final void p(int i) {
        y(4, 0);
        int iX = (x() - i) + 4;
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, iX);
    }

    public final void q(int i, int i2) {
        if (i2 != 0) {
            p(i2);
            aa(i);
        }
    }

    public final void r(short s) {
        y(2, 0);
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s);
    }

    public final int s(CharSequence charSequence) {
        char c;
        char c2;
        boolean z;
        int i;
        int i2;
        int i3;
        char cCharAt;
        dop dopVar = this.m;
        dopVar.getClass();
        int length = charSequence.length();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            c = 55296;
            c2 = 2048;
            z = true;
            if (i5 < length) {
                char cCharAt2 = charSequence.charAt(i5);
                if (cCharAt2 >= 2048) {
                    int length2 = charSequence.length();
                    int i7 = 0;
                    while (i5 < length2) {
                        char cCharAt3 = charSequence.charAt(i5);
                        if (cCharAt3 < 2048) {
                            i7 += (127 - cCharAt3) >>> 31;
                        } else {
                            i7 += 2;
                            if (55296 <= cCharAt3 && cCharAt3 <= 57343) {
                                if (Character.codePointAt(charSequence, i5) < 65536) {
                                    throw new bpx(i5, length2);
                                }
                                i5++;
                            }
                        }
                        i5++;
                    }
                    i6 += i7;
                    break;
                }
                i6 += (127 - cCharAt2) >>> 31;
                i5++;
            } else {
                break;
            }
        }
        if (i6 < length) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i6) + 4294967296L));
        }
        n((byte) 0);
        ac(1, i6, 1);
        ByteBuffer byteBuffer = this.a;
        int i8 = this.b - i6;
        this.b = i8;
        byteBuffer.position(i8);
        ByteBuffer byteBuffer2 = this.a;
        dopVar.getClass();
        if (byteBuffer2.hasArray()) {
            int iArrayOffset = byteBuffer2.arrayOffset();
            byte[] bArrArray = byteBuffer2.array();
            int iPosition = byteBuffer2.position() + iArrayOffset;
            int iRemaining = byteBuffer2.remaining();
            int length3 = charSequence.length();
            int i9 = iRemaining + iPosition;
            while (true) {
                boolean z2 = z;
                if (i4 >= length3 || (i3 = i4 + iPosition) >= i9 || (cCharAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                bArrArray[i3] = (byte) cCharAt;
                i4++;
                z = z2;
            }
            if (i4 == length3) {
                i = iPosition + length3;
            } else {
                i = iPosition + i4;
                while (i4 < length3) {
                    char cCharAt4 = charSequence.charAt(i4);
                    if (cCharAt4 < 128 && i < i9) {
                        bArrArray[i] = (byte) cCharAt4;
                        i++;
                    } else if (cCharAt4 < c2 && i <= i9 - 2) {
                        int i10 = i + 1;
                        bArrArray[i] = (byte) ((cCharAt4 >>> 6) | 960);
                        i += 2;
                        bArrArray[i10] = (byte) ((cCharAt4 & '?') | 128);
                    } else {
                        if ((cCharAt4 >= c && 57343 >= cCharAt4) || i > i9 - 3) {
                            if (i > i9 - 4) {
                                if (55296 <= cCharAt4 && cCharAt4 <= 57343 && ((i2 = i4 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt4, charSequence.charAt(i2)))) {
                                    throw new bpx(i4, length3);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt4 + " at index " + i);
                            }
                            int i11 = i4 + 1;
                            if (i11 != charSequence.length()) {
                                char cCharAt5 = charSequence.charAt(i11);
                                if (Character.isSurrogatePair(cCharAt4, cCharAt5)) {
                                    int codePoint = Character.toCodePoint(cCharAt4, cCharAt5);
                                    bArrArray[i] = (byte) ((codePoint >>> 18) | 240);
                                    bArrArray[i + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i12 = i + 3;
                                    bArrArray[i + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i += 4;
                                    bArrArray[i12] = (byte) ((codePoint & 63) | 128);
                                    i4 = i11;
                                } else {
                                    i4 = i11;
                                }
                            }
                            throw new bpx(i4 - 1, length3);
                        }
                        bArrArray[i] = (byte) ((cCharAt4 >>> '\f') | 480);
                        int i13 = i + 2;
                        bArrArray[i + 1] = (byte) (((cCharAt4 >>> 6) & 63) | 128);
                        i += 3;
                        bArrArray[i13] = (byte) ((cCharAt4 & '?') | 128);
                    }
                    i4++;
                    c = 55296;
                    c2 = 2048;
                }
            }
            byteBuffer2.position(i - iArrayOffset);
        } else {
            int length4 = charSequence.length();
            int iPosition2 = byteBuffer2.position();
            while (i4 < length4) {
                try {
                    char cCharAt6 = charSequence.charAt(i4);
                    if (cCharAt6 >= 128) {
                        break;
                    }
                    byteBuffer2.put(iPosition2 + i4, (byte) cCharAt6);
                    i4++;
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            if (i4 == length4) {
                byteBuffer2.position(iPosition2 + i4);
            } else {
                iPosition2 += i4;
                while (i4 < length4) {
                    char cCharAt7 = charSequence.charAt(i4);
                    if (cCharAt7 >= 128) {
                        if (cCharAt7 < 2048) {
                            int i14 = iPosition2 + 1;
                            try {
                                byteBuffer2.put(iPosition2, (byte) ((cCharAt7 >>> 6) | 192));
                                byteBuffer2.put(i14, (byte) ((cCharAt7 & '?') | 128));
                                iPosition2 = i14;
                            } catch (IndexOutOfBoundsException unused2) {
                                iPosition2 = i14;
                            }
                        } else {
                            if (cCharAt7 >= 55296 && 57343 >= cCharAt7) {
                                int i15 = i4 + 1;
                                if (i15 != length4) {
                                    try {
                                        char cCharAt8 = charSequence.charAt(i15);
                                        if (Character.isSurrogatePair(cCharAt7, cCharAt8)) {
                                            int codePoint2 = Character.toCodePoint(cCharAt7, cCharAt8);
                                            int i16 = iPosition2 + 1;
                                            try {
                                                byteBuffer2.put(iPosition2, (byte) ((codePoint2 >>> 18) | 240));
                                                int i17 = iPosition2 + 2;
                                                try {
                                                    byteBuffer2.put(i16, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                                    iPosition2 += 3;
                                                    byteBuffer2.put(i17, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                                    byteBuffer2.put(iPosition2, (byte) ((codePoint2 & 63) | 128));
                                                    i4 = i15;
                                                    i4++;
                                                    iPosition2++;
                                                } catch (IndexOutOfBoundsException unused3) {
                                                    i4 = i15;
                                                    iPosition2 = i17;
                                                }
                                            } catch (IndexOutOfBoundsException unused4) {
                                                iPosition2 = i16;
                                                i4 = i15;
                                            }
                                        } else {
                                            i4 = i15;
                                        }
                                    } catch (IndexOutOfBoundsException unused5) {
                                    }
                                    i4 = i15;
                                }
                                throw new bpx(i4, length4);
                            }
                            int i18 = iPosition2 + 1;
                            try {
                                byteBuffer2.put(iPosition2, (byte) ((cCharAt7 >>> '\f') | Opcodes.SHL_INT_LIT8));
                                iPosition2 += 2;
                                byteBuffer2.put(i18, (byte) (((cCharAt7 >>> 6) & 63) | 128));
                                byteBuffer2.put(iPosition2, (byte) ((cCharAt7 & '?') | 128));
                                i4++;
                                iPosition2++;
                            } catch (IndexOutOfBoundsException unused6) {
                                iPosition2 = i18;
                            }
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i4) + " at index " + (Math.max(i4, (iPosition2 - byteBuffer2.position()) + 1) + byteBuffer2.position()));
                    }
                    byteBuffer2.put(iPosition2, (byte) cCharAt7);
                    i4++;
                    iPosition2++;
                }
                byteBuffer2.position(iPosition2);
            }
        }
        return v();
    }

    public final int t(int[] iArr) {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
        ac(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            p(iArr[length]);
        }
        return v();
    }

    public final int u() {
        int i;
        if (this.d == null || !this.f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        y(4, 0);
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, 0);
        int iX = x();
        int i3 = this.e - 1;
        while (i3 >= 0 && this.d[i3] == 0) {
            i3--;
        }
        for (int i4 = i3; i4 >= 0; i4--) {
            int i5 = this.d[i4];
            r((short) (i5 != 0 ? iX - i5 : 0));
        }
        r((short) (iX - this.h));
        r((short) ((i3 + 3) * 2));
        int i6 = 0;
        loop2: while (true) {
            if (i6 >= this.j) {
                i = 0;
                break;
            }
            int iCapacity = this.a.capacity() - this.i[i6];
            int i7 = this.b;
            short s = this.a.getShort(iCapacity);
            if (s == this.a.getShort(i7)) {
                int i8 = 2;
                while (true) {
                    if (i8 >= s) {
                        i = this.i[i6];
                        break loop2;
                    }
                    if (this.a.getShort(iCapacity + i8) != this.a.getShort(i7 + i8)) {
                        break;
                    }
                    i8 += 2;
                }
            }
            i6++;
        }
        if (i != 0) {
            int iCapacity2 = this.a.capacity() - iX;
            this.b = iCapacity2;
            this.a.putInt(iCapacity2, i - iX);
        } else {
            int i9 = this.j;
            int[] iArr = this.i;
            if (i9 == iArr.length) {
                this.i = Arrays.copyOf(iArr, i9 * 2);
            }
            int[] iArr2 = this.i;
            int i10 = this.j;
            this.j = i10 + 1;
            iArr2[i10] = x();
            ByteBuffer byteBuffer2 = this.a;
            byteBuffer2.putInt(byteBuffer2.capacity() - iX, x() - iX);
        }
        this.f = false;
        return iX;
    }

    public final int v() {
        if (!this.f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f = false;
        int i = this.k;
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
        return x();
    }

    public final void w(int i) {
        y(this.c, 4);
        p(i);
        this.a.position(this.b);
        this.g = true;
    }

    public final int x() {
        return this.a.capacity() - this.b;
    }

    public final void y(int i, int i2) {
        int i3;
        if (i > this.c) {
            this.c = i;
        }
        int i4 = ((~((this.a.capacity() - this.b) + i2)) + 1) & (i - 1);
        while (this.b < i4 + i + i2) {
            int iCapacity = this.a.capacity();
            ByteBuffer byteBuffer = this.a;
            int iCapacity2 = byteBuffer.capacity();
            if (iCapacity2 == 0) {
                i3 = 1024;
            } else {
                i3 = 2147483639;
                if (iCapacity2 == 2147483639) {
                    throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
                }
                if (((-1073741824) & iCapacity2) == 0) {
                    i3 = iCapacity2 << 1;
                }
            }
            byteBuffer.position(0);
            this.l.getClass();
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.position(byteBufferOrder.clear().capacity() - iCapacity2);
            byteBufferOrder.put(byteBuffer);
            this.a = byteBufferOrder;
            this.b = (byteBufferOrder.capacity() - iCapacity) + this.b;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            ByteBuffer byteBuffer2 = this.a;
            int i6 = this.b - 1;
            this.b = i6;
            byteBuffer2.put(i6, (byte) 0);
        }
    }

    public final byte[] z() {
        int i = this.b;
        int iCapacity = this.a.capacity() - this.b;
        if (!this.g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
        byte[] bArr = new byte[iCapacity];
        this.a.position(i);
        this.a.get(bArr);
        return bArr;
    }
}
