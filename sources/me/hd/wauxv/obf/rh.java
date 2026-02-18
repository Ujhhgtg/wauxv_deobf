package me.hd.wauxv.obf;

import com.alibaba.fastjson2.JSONB;
import com.android.dx.io.Opcodes;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rh implements rm, rl, Cloneable, ByteChannel {
    public dfj a;
    public long b;

    @Override // me.hd.wauxv.obf.rm
    public final String aa() {
        return m(Long.MAX_VALUE);
    }

    @Override // me.hd.wauxv.obf.rm
    public final int ab(crv crvVar) throws EOFException {
        throwIfVar1IsNull(crvVar, "options");
        int iD = b.d(this, crvVar, false);
        if (iD == -1) {
            return -1;
        }
        skip(crvVar.b[iD].g());
        return iD;
    }

    public final String ac() {
        return z(this.b, uj.a);
    }

    public final sj ad(int i) {
        if (i == 0) {
            return sj.a;
        }
        aye.n(this.b, 0L, i);
        dfj dfjVar = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            throwIfVar1IsNull(dfjVar);
            int i5 = dfjVar.c;
            int i6 = dfjVar.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            dfjVar = dfjVar.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        dfj dfjVar2 = this.a;
        int i7 = 0;
        while (i2 < i) {
            throwIfVar1IsNull(dfjVar2);
            bArr[i7] = dfjVar2.a;
            i2 += dfjVar2.c - dfjVar2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = dfjVar2.b;
            dfjVar2.d = true;
            i7++;
            dfjVar2 = dfjVar2.f;
        }
        return new dfm(bArr, iArr);
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl ae(sj sjVar) {
        al(sjVar);
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl af(int i, int i2, byte[] bArr) {
        write(bArr, i, i2);
        return this;
    }

    public final dfj ag(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        dfj dfjVar = this.a;
        if (dfjVar == null) {
            dfj dfjVarE = dfl.e();
            this.a = dfjVarE;
            dfjVarE.g = dfjVarE;
            dfjVarE.f = dfjVarE;
            return dfjVarE;
        }
        dfj dfjVar2 = dfjVar.g;
        throwIfVar1IsNull(dfjVar2);
        if (dfjVar2.c + i <= 8192 && dfjVar2.e) {
            return dfjVar2;
        }
        dfj dfjVarE2 = dfl.e();
        dfjVar2.i(dfjVarE2);
        return dfjVarE2;
    }

    @Override // me.hd.wauxv.obf.rm
    public final void ah(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl ai(long j) {
        an(j);
        return this;
    }

    @Override // me.hd.wauxv.obf.rm
    public final long aj() throws EOFException {
        int i;
        if (this.b == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            dfj dfjVar = this.a;
            throwIfVar1IsNull(dfjVar);
            byte[] bArr = dfjVar.a;
            int i3 = dfjVar.b;
            int i4 = dfjVar.c;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b + JSONB.Constants.BC_INT64_BYTE_ZERO;
                } else if (b >= 97 && b <= 102) {
                    i = b + JSONB.Constants.BC_LOCAL_DATE;
                } else {
                    if (b < 65 || b > 70) {
                        z = true;
                        if (i2 != 0) {
                            break;
                        }
                        char[] cArr = ajn.a;
                        throw new NumberFormatException(
                                "Expected leading [0-9a-fA-F] character but was 0x".concat(new String(
                                        new char[] { cArr[(b >> 4) & 15], cArr[b & com.umeng.analytics.pro.dn.m] })));
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    rh rhVar = new rh();
                    rhVar.ao(j);
                    rhVar.am(b);
                    throw new NumberFormatException("Number too large: ".concat(rhVar.ac()));
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.a = dfjVar.h();
                dfl.d(dfjVar);
            } else {
                dfjVar.b = i3;
            }
            if (z) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i2;
        return j;
    }

    @Override // me.hd.wauxv.obf.rm
    public final InputStream ak() {
        return new rg(this, 0);
    }

    public final void al(sj sjVar) {
        throwIfVar1IsNull(sjVar, "byteString");
        sjVar.o(sjVar.g(), this);
    }

    public final void am(int i) {
        dfj dfjVarAg = ag(1);
        byte[] bArr = dfjVarAg.a;
        int i2 = dfjVarAg.c;
        dfjVarAg.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
    }

    public final void an(long j) {
        boolean z;
        if (j == 0) {
            am(48);
            return;
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                at("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L
                    ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10
                            : j < 100000000000L ? 11 : 12
                    : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15
                            : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17
                                    : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        dfj dfjVarAg = ag(i);
        byte[] bArr = dfjVarAg.a;
        int i2 = dfjVarAg.c + i;
        while (j != 0) {
            long j2 = 10;
            i2--;
            bArr[i2] = b.cachedConstructors[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        dfjVarAg.c += i;
        this.b += (long) i;
    }

    public final void ao(long j) {
        if (j == 0) {
            am(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        dfj dfjVarAg = ag(i);
        byte[] bArr = dfjVarAg.a;
        int i2 = dfjVarAg.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = b.cachedConstructors[(int) (15 & j)];
            j >>>= 4;
        }
        dfjVarAg.c += i;
        this.b += (long) i;
    }

    public final void ap(int i) {
        dfj dfjVarAg = ag(4);
        byte[] bArr = dfjVarAg.a;
        int i2 = dfjVarAg.c;
        bArr[i2] = (byte) ((i >>> 24) & Opcodes.CONST_METHOD_TYPE);
        bArr[i2 + 1] = (byte) ((i >>> 16) & Opcodes.CONST_METHOD_TYPE);
        bArr[i2 + 2] = (byte) ((i >>> 8) & Opcodes.CONST_METHOD_TYPE);
        bArr[i2 + 3] = (byte) (i & Opcodes.CONST_METHOD_TYPE);
        dfjVarAg.c = i2 + 4;
        this.b += 4;
    }

    public final void aq(long j) {
        dfj dfjVarAg = ag(8);
        byte[] bArr = dfjVarAg.a;
        int i = dfjVarAg.c;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        dfjVarAg.c = i + 8;
        this.b += 8;
    }

    public final void ar(int i) {
        dfj dfjVarAg = ag(2);
        byte[] bArr = dfjVarAg.a;
        int i2 = dfjVarAg.c;
        bArr[i2] = (byte) ((i >>> 8) & Opcodes.CONST_METHOD_TYPE);
        bArr[i2 + 1] = (byte) (i & Opcodes.CONST_METHOD_TYPE);
        dfjVarAg.c = i2 + 2;
        this.b += 2;
    }

    public final void as(String str, int i, int i2, Charset charset) {
        if (i < 0) {
            throw new IllegalArgumentException(concatVar2Var1(i, "beginIndex < 0: ").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(dkz.p(i2, "endIndex < beginIndex: ", " < ", i).toString());
        }
        if (i2 > str.length()) {
            StringBuilder sbR = yg.r(i2, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        if (charset.equals(uj.a)) {
            au(str, i, i2);
            return;
        }
        String strSubstring = str.substring(i, i2);
        throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        throwIfVar1IsNull(bytes, "this as java.lang.String).getBytes(charset)");
        write(bytes, 0, bytes.length);
    }

    public final void at(String str) {
        throwIfVar1IsNull(str, "string");
        au(str, 0, str.length());
    }

    public final void au(String str, int i, int i2) {
        char cCharAt;
        throwIfVar1IsNull(str, "string");
        if (i < 0) {
            throw new IllegalArgumentException(concatVar2Var1(i, "beginIndex < 0: ").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(dkz.p(i2, "endIndex < beginIndex: ", " < ", i).toString());
        }
        if (i2 > str.length()) {
            StringBuilder sbR = yg.r(i2, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                dfj dfjVarAg = ag(1);
                byte[] bArr = dfjVarAg.a;
                int i3 = dfjVarAg.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = dfjVarAg.c;
                int i6 = (i3 + i) - i5;
                dfjVarAg.c = i5 + i6;
                this.b += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    dfj dfjVarAg2 = ag(2);
                    byte[] bArr2 = dfjVarAg2.a;
                    int i7 = dfjVarAg2.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    dfjVarAg2.c = i7 + 2;
                    this.b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    dfj dfjVarAg3 = ag(3);
                    byte[] bArr3 = dfjVarAg3.a;
                    int i8 = dfjVarAg3.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | Opcodes.SHL_INT_LIT8);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    dfjVarAg3.c = i8 + 3;
                    this.b += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        am(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        dfj dfjVarAg4 = ag(4);
                        byte[] bArr4 = dfjVarAg4.a;
                        int i11 = dfjVarAg4.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        dfjVarAg4.c = i11 + 4;
                        this.b += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void av(int i) {
        String str;
        if (i < 128) {
            am(i);
            return;
        }
        if (i < 2048) {
            dfj dfjVarAg = ag(2);
            byte[] bArr = dfjVarAg.a;
            int i2 = dfjVarAg.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            dfjVarAg.c = i2 + 2;
            this.b += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            am(63);
            return;
        }
        if (i < 65536) {
            dfj dfjVarAg2 = ag(3);
            byte[] bArr2 = dfjVarAg2.a;
            int i3 = dfjVarAg2.c;
            bArr2[i3] = (byte) ((i >> 12) | Opcodes.SHL_INT_LIT8);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            dfjVarAg2.c = i3 + 3;
            this.b += 3;
            return;
        }
        if (i <= 1114111) {
            dfj dfjVarAg3 = ag(4);
            byte[] bArr3 = dfjVarAg3.a;
            int i4 = dfjVarAg3.c;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            dfjVarAg3.c = i4 + 4;
            this.b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i != 0) {
            char[] cArr = ajn.a;
            char[] cArr2 = { cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15],
                    cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15] };
            int i5 = 0;
            while (i5 < 8 && cArr2[i5] == '0') {
                i5++;
            }
            cnh.j(i5, 8, 8);
            str = new String(cArr2, i5, 8 - i5);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // me.hd.wauxv.obf.rm
    public final rh c() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel,
              // me.hd.wauxv.obf.dhy
    public final void close() {
    }

    public final void d() throws EOFException {
        skip(this.b);
    }

    @Override // me.hd.wauxv.obf.rm
    public final sj e(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(dts.b(j, "byteCount: ").toString());
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new sj(y(j));
        }
        sj sjVarAd = ad((int) j);
        skip(j);
        return sjVarAd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rh)) {
            return false;
        }
        long j = this.b;
        rh rhVar = (rh) obj;
        if (j != rhVar.b) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        dfj dfjVar2 = rhVar.a;
        throwIfVar1IsNull(dfjVar2);
        int i = dfjVar.b;
        int i2 = dfjVar2.b;
        long j2 = 0;
        while (j2 < this.b) {
            long jMin = Math.min(dfjVar.c - i, dfjVar2.c - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (dfjVar.a[i] != dfjVar2.a[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == dfjVar.c) {
                dfjVar = dfjVar.f;
                throwIfVar1IsNull(dfjVar);
                i = dfjVar.b;
            }
            if (i2 == dfjVar2.c) {
                dfjVar2 = dfjVar2.f;
                throwIfVar1IsNull(dfjVar2);
                i2 = dfjVar2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    /*
     * JADX INFO: renamed from: f, reason: merged with bridge method
     * [inline-methods]
     */
    public final rh clone() {
        rh rhVar = new rh();
        if (this.b == 0) {
            return rhVar;
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        dfj dfjVarJ = dfjVar.j();
        rhVar.a = dfjVarJ;
        dfjVarJ.g = dfjVarJ;
        dfjVarJ.f = dfjVarJ;
        for (dfj dfjVar2 = dfjVar.f; dfjVar2 != dfjVar; dfjVar2 = dfjVar2.f) {
            dfj dfjVar3 = dfjVarJ.g;
            throwIfVar1IsNull(dfjVar3);
            throwIfVar1IsNull(dfjVar2);
            dfjVar3.i(dfjVar2.j());
        }
        rhVar.b = this.b;
        return rhVar;
    }

    @Override // me.hd.wauxv.obf.rl, me.hd.wauxv.obf.dhy, java.io.Flushable
    public final void flush() {
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl g() {
        return this;
    }

    @Override // me.hd.wauxv.obf.rm
    public final byte[] h() {
        return y(this.b);
    }

    public final int hashCode() {
        dfj dfjVar = this.a;
        if (dfjVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = dfjVar.c;
            for (int i3 = dfjVar.b; i3 < i2; i3++) {
                i = (i * 31) + dfjVar.a[i3];
            }
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
        } while (dfjVar != this.a);
        return i;
    }

    @Override // me.hd.wauxv.obf.rm
    public final boolean i() {
        return this.b == 0;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // me.hd.wauxv.obf.rl
    public final rl j() {
        return this;
    }

    @Override // me.hd.wauxv.obf.rm
    public final long k() throws EOFException {
        long j;
        char c;
        int i;
        byte b;
        long j2 = 0;
        if (this.b == 0) {
            throw new EOFException();
        }
        long j3 = -7;
        long j4 = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        loop0: while (true) {
            dfj dfjVar = this.a;
            throwIfVar1IsNull(dfjVar);
            byte[] bArr = dfjVar.a;
            int i3 = dfjVar.b;
            int i4 = dfjVar.c;
            while (true) {
                if (i3 >= i4) {
                    j = j2;
                    c = 0;
                    i = 1;
                    break;
                }
                c = 0;
                b = bArr[i3];
                i = 1;
                if (b >= 48 && b <= 57) {
                    int i5 = 48 - b;
                    if (j4 < -922337203685477580L) {
                        break loop0;
                    }
                    j = j2;
                    if (j4 == -922337203685477580L && i5 < j3) {
                        break loop0;
                    }
                    j4 = (j4 * 10) + ((long) i5);
                } else {
                    j = j2;
                    if (b != 45 || i2 != 0) {
                        z2 = true;
                        break;
                    }
                    j3--;
                    z = true;
                }
                i3++;
                i2++;
                j2 = j;
            }
            if (i3 == i4) {
                this.a = dfjVar.h();
                dfl.d(dfjVar);
            } else {
                dfjVar.b = i3;
            }
            if (z2 || this.a == null) {
                long j5 = this.b - ((long) i2);
                this.b = j5;
                if (i2 >= (z ? 2 : i)) {
                    return z ? j4 : -j4;
                }
                if (j5 == j) {
                    throw new EOFException();
                }
                StringBuilder sbR = concat(z ? "Expected a digit" : "Expected a digit or '-'", " but was 0x");
                byte bN = n(j);
                char[] cArr = ajn.a;
                char c2 = cArr[(bN >> 4) & 15];
                char c3 = cArr[bN & com.umeng.analytics.pro.dn.m];
                char[] cArr2 = new char[2];
                cArr2[c] = c2;
                cArr2[i] = c3;
                sbR.append(new String(cArr2));
                throw new NumberFormatException(sbR.toString());
            }
            j2 = j;
        }
        rh rhVar = new rh();
        rhVar.an(j4);
        rhVar.am(b);
        if (!z) {
            rhVar.readByte();
        }
        throw new NumberFormatException("Number too large: ".concat(rhVar.ac()));
    }

    public final void l(long j, rh rhVar, long j2) {
        throwIfVar1IsNull(rhVar, "out");
        long j3 = j;
        aye.n(this.b, j3, j2);
        if (j2 == 0) {
            return;
        }
        rhVar.b += j2;
        dfj dfjVar = this.a;
        while (true) {
            throwIfVar1IsNull(dfjVar);
            long j4 = dfjVar.c - dfjVar.b;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            dfjVar = dfjVar.f;
        }
        dfj dfjVar2 = dfjVar;
        long j5 = j2;
        while (j5 > 0) {
            throwIfVar1IsNull(dfjVar2);
            dfj dfjVarJ = dfjVar2.j();
            int i = dfjVarJ.b + ((int) j3);
            dfjVarJ.b = i;
            dfjVarJ.c = Math.min(i + ((int) j5), dfjVarJ.c);
            dfj dfjVar3 = rhVar.a;
            if (dfjVar3 == null) {
                dfjVarJ.g = dfjVarJ;
                dfjVarJ.f = dfjVarJ;
                rhVar.a = dfjVarJ;
            } else {
                dfj dfjVar4 = dfjVar3.g;
                throwIfVar1IsNull(dfjVar4);
                dfjVar4.i(dfjVarJ);
            }
            j5 -= (long) (dfjVarJ.c - dfjVarJ.b);
            dfjVar2 = dfjVar2.f;
            j3 = 0;
        }
    }

    @Override // me.hd.wauxv.obf.rm
    public final String m(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "limit < 0: ").toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jO = o(0L, j2, (byte) 10);
        if (jO != -1) {
            return b.createInstanceWithArgs(this, jO);
        }
        if (j2 < this.b && n(j2 - 1) == 13 && n(j2) == 10) {
            return b.createInstanceWithArgs(this, j2);
        }
        rh rhVar = new rh();
        l(0L, rhVar, Math.min(32, this.b));
        throw new EOFException(
                "\\n not found: limit=" + Math.min(this.b, j) + " content=" + rhVar.e(rhVar.b).h() + (char) 8230);
    }

    public final byte n(long j) {
        aye.n(this.b, j, 1L);
        dfj dfjVar = this.a;
        if (dfjVar == null) {
            throwIfVar1IsNull(null);
            throw null;
        }
        long j2 = this.b;
        if (j2 - j < j) {
            while (j2 > j) {
                dfjVar = dfjVar.g;
                throwIfVar1IsNull(dfjVar);
                j2 -= (long) (dfjVar.c - dfjVar.b);
            }
            return dfjVar.a[(int) ((((long) dfjVar.b) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = dfjVar.c;
            int i2 = dfjVar.b;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return dfjVar.a[(int) ((((long) i2) + j) - j3)];
            }
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
            j3 = j4;
        }
    }

    public final long o(long j, long j2, byte b) {
        dfj dfjVar;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + this.b + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        long j4 = this.b;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (dfjVar = this.a) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                dfjVar = dfjVar.g;
                throwIfVar1IsNull(dfjVar);
                j4 -= (long) (dfjVar.c - dfjVar.b);
            }
            while (j4 < j2) {
                byte[] bArr = dfjVar.a;
                int iMin = (int) Math.min(dfjVar.c, (((long) dfjVar.b) + j2) - j4);
                for (int i = (int) ((((long) dfjVar.b) + j) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - dfjVar.b)) + j4;
                    }
                }
                j4 += (long) (dfjVar.c - dfjVar.b);
                dfjVar = dfjVar.f;
                throwIfVar1IsNull(dfjVar);
                j = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = ((long) (dfjVar.c - dfjVar.b)) + j3;
            if (j5 > j) {
                break;
            }
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
            j3 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = dfjVar.a;
            int iMin2 = (int) Math.min(dfjVar.c, (((long) dfjVar.b) + j2) - j3);
            for (int i2 = (int) ((((long) dfjVar.b) + j) - j3); i2 < iMin2; i2++) {
                if (bArr2[i2] == b) {
                    return ((long) (i2 - dfjVar.b)) + j3;
                }
            }
            j3 += (long) (dfjVar.c - dfjVar.b);
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
            j = j3;
        }
        return -1L;
    }

    @Override // me.hd.wauxv.obf.rm
    public final void p(rh rhVar, long j) throws EOFException {
        throwIfVar1IsNull(rhVar, "sink");
        long j2 = this.b;
        if (j2 >= j) {
            rhVar.write(this, j);
        } else {
            rhVar.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // me.hd.wauxv.obf.rm
    public final cyl peek() {
        return emc.ah(new ctg(this));
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl q(String str) {
        at(str);
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final long r(dlc dlcVar) {
        throwIfVar1IsNull(dlcVar, "source");
        long j = 0;
        while (true) {
            long j2 = dlcVar.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Override // me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) {
        throwIfVar1IsNull(rhVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
        }
        long j2 = this.b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        rhVar.write(this, j);
        return j;
    }

    @Override // me.hd.wauxv.obf.rm
    public final byte readByte() throws EOFException {
        if (this.b == 0) {
            throw new EOFException();
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        int i = dfjVar.b;
        int i2 = dfjVar.c;
        int i3 = i + 1;
        byte b = dfjVar.a[i];
        this.b--;
        if (i3 != i2) {
            dfjVar.b = i3;
            return b;
        }
        this.a = dfjVar.h();
        dfl.d(dfjVar);
        return b;
    }

    @Override // me.hd.wauxv.obf.rm
    public final void readFully(byte[] bArr) throws EOFException {
        throwIfVar1IsNull(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // me.hd.wauxv.obf.rm
    public final int readInt() throws EOFException {
        if (this.b < 4) {
            throw new EOFException();
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        int i = dfjVar.b;
        int i2 = dfjVar.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8)
                    | (readByte() & 255);
        }
        byte[] bArr = dfjVar.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.b -= 4;
        if (i5 != i2) {
            dfjVar.b = i5;
            return i6;
        }
        this.a = dfjVar.h();
        dfl.d(dfjVar);
        return i6;
    }

    @Override // me.hd.wauxv.obf.rm
    public final long readLong() throws EOFException {
        if (this.b < 8) {
            throw new EOFException();
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        int i = dfjVar.b;
        int i2 = dfjVar.c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = dfjVar.a;
        int i3 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48)
                | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32)
                | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16)
                | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (((long) bArr[i3]) & 255);
        this.b -= 8;
        if (i4 != i2) {
            dfjVar.b = i4;
            return j2;
        }
        this.a = dfjVar.h();
        dfl.d(dfjVar);
        return j2;
    }

    @Override // me.hd.wauxv.obf.rm
    public final short readShort() throws EOFException {
        if (this.b < 2) {
            throw new EOFException();
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        int i = dfjVar.b;
        int i2 = dfjVar.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = dfjVar.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.b -= 2;
        if (i5 == i2) {
            this.a = dfjVar.h();
            dfl.d(dfjVar);
        } else {
            dfjVar.b = i5;
        }
        return (short) i6;
    }

    @Override // me.hd.wauxv.obf.rm
    public final String readString(Charset charset) {
        throwIfVar1IsNull(charset, "charset");
        return z(this.b, charset);
    }

    @Override // me.hd.wauxv.obf.rm
    public final boolean s(long j, sj sjVar) {
        throwIfVar1IsNull(sjVar, "bytes");
        int iG = sjVar.g();
        if (j >= 0 && iG >= 0 && this.b - j >= iG && sjVar.g() >= iG) {
            for (int i = 0; i < iG; i++) {
                if (n(((long) i) + j) == sjVar.j(i)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.rm
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            dfj dfjVar = this.a;
            if (dfjVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, dfjVar.c - dfjVar.b);
            long j2 = iMin;
            this.b -= j2;
            j -= j2;
            int i = dfjVar.b + iMin;
            dfjVar.b = i;
            if (i == dfjVar.c) {
                this.a = dfjVar.h();
                dfl.d(dfjVar);
            }
        }
    }

    public final long t(sj sjVar) {
        int i;
        int i2;
        throwIfVar1IsNull(sjVar, "targetBytes");
        dfj dfjVar = this.a;
        if (dfjVar == null) {
            return -1L;
        }
        long j = this.b;
        long j2 = 0;
        if (j < 0) {
            while (j > 0) {
                dfjVar = dfjVar.g;
                throwIfVar1IsNull(dfjVar);
                j -= (long) (dfjVar.c - dfjVar.b);
            }
            if (sjVar.g() == 2) {
                byte bJ = sjVar.j(0);
                byte bJ2 = sjVar.j(1);
                while (j < this.b) {
                    byte[] bArr = dfjVar.a;
                    i = (int) ((((long) dfjVar.b) + j2) - j);
                    int i3 = dfjVar.c;
                    while (true) {
                        if (i >= i3) {
                            j2 = ((long) (dfjVar.c - dfjVar.b)) + j;
                            dfjVar = dfjVar.f;
                            throwIfVar1IsNull(dfjVar);
                            j = j2;
                        } else {
                            byte b = bArr[i];
                            if (b == bJ || b == bJ2) {
                                i2 = dfjVar.b;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrI = sjVar.i();
            while (j < this.b) {
                byte[] bArr2 = dfjVar.a;
                i = (int) ((((long) dfjVar.b) + j2) - j);
                int i4 = dfjVar.c;
                while (true) {
                    if (i < i4) {
                        byte b2 = bArr2[i];
                        int length = bArrI.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                i++;
                            } else if (b2 == bArrI[i5]) {
                                i2 = dfjVar.b;
                            } else {
                                i5++;
                            }
                        }
                    } else {
                        j2 = ((long) (dfjVar.c - dfjVar.b)) + j;
                        dfjVar = dfjVar.f;
                        throwIfVar1IsNull(dfjVar);
                        j = j2;
                    }
                }
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j3 = ((long) (dfjVar.c - dfjVar.b)) + j;
            if (j3 > 0) {
                break;
            }
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
            j = j3;
        }
        if (sjVar.g() == 2) {
            byte bJ3 = sjVar.j(0);
            byte bJ4 = sjVar.j(1);
            while (j < this.b) {
                byte[] bArr3 = dfjVar.a;
                i = (int) ((((long) dfjVar.b) + j2) - j);
                int i6 = dfjVar.c;
                while (true) {
                    if (i >= i6) {
                        j2 = ((long) (dfjVar.c - dfjVar.b)) + j;
                        dfjVar = dfjVar.f;
                        throwIfVar1IsNull(dfjVar);
                        j = j2;
                    } else {
                        byte b3 = bArr3[i];
                        if (b3 == bJ3 || b3 == bJ4) {
                            i2 = dfjVar.b;
                        } else {
                            i++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrI2 = sjVar.i();
        while (j < this.b) {
            byte[] bArr4 = dfjVar.a;
            i = (int) ((((long) dfjVar.b) + j2) - j);
            int i7 = dfjVar.c;
            while (true) {
                if (i < i7) {
                    byte b4 = bArr4[i];
                    int length2 = bArrI2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            i++;
                        } else if (b4 == bArrI2[i8]) {
                            i2 = dfjVar.b;
                        } else {
                            i8++;
                        }
                    }
                } else {
                    j2 = ((long) (dfjVar.c - dfjVar.b)) + j;
                    dfjVar = dfjVar.f;
                    throwIfVar1IsNull(dfjVar);
                    j = j2;
                }
            }
        }
        return -1L;
        return ((long) (i - i2)) + j;
    }

    @Override // me.hd.wauxv.obf.dlc
    public final ekc timeout() {
        return ekc.NONE;
    }

    public final String toString() {
        long j = this.b;
        if (j <= 2147483647L) {
            return ad((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.b).toString());
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl u(long j) {
        ao(j);
        return this;
    }

    public final rf v(rf rfVar) {
        throwIfVar1IsNull(rfVar, "unsafeCursor");
        byte[] bArr = b.cachedConstructors;
        if (rfVar == aye.b) {
            rfVar = new rf();
        }
        if (rfVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        rfVar.a = this;
        rfVar.b = true;
        return rfVar;
    }

    @Override // me.hd.wauxv.obf.rm
    public final sj w() {
        return e(this.b);
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl write(byte[] bArr) {
        m12write(bArr);
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl writeByte(int i) {
        am(i);
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl writeInt(int i) {
        ap(i);
        return this;
    }

    @Override // me.hd.wauxv.obf.rl
    public final /* bridge */ /* synthetic */ rl writeShort(int i) {
        ar(i);
        return this;
    }

    @Override // me.hd.wauxv.obf.rm
    public final boolean x(long j) {
        return this.b >= j;
    }

    public final byte[] y(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(dts.b(j, "byteCount: ").toString());
        }
        if (this.b < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final String z(long j, Charset charset) throws EOFException {
        throwIfVar1IsNull(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(dts.b(j, "byteCount: ").toString());
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        dfj dfjVar = this.a;
        throwIfVar1IsNull(dfjVar);
        int i = dfjVar.b;
        if (((long) i) + j > dfjVar.c) {
            return new String(y(j), charset);
        }
        int i2 = (int) j;
        String str = new String(dfjVar.a, i, i2, charset);
        int i3 = dfjVar.b + i2;
        dfjVar.b = i3;
        this.b -= j;
        if (i3 == dfjVar.c) {
            this.a = dfjVar.h();
            dfl.d(dfjVar);
        }
        return str;
    }

    @Override // me.hd.wauxv.obf.dhy
    public final void write(rh rhVar, long j) {
        dfj dfjVarE;
        throwIfVar1IsNull(rhVar, "source");
        if (rhVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        aye.n(rhVar.b, 0L, j);
        while (j > 0) {
            dfj dfjVar = rhVar.a;
            throwIfVar1IsNull(dfjVar);
            int i = dfjVar.c;
            dfj dfjVar2 = rhVar.a;
            throwIfVar1IsNull(dfjVar2);
            long j2 = i - dfjVar2.b;
            int i2 = 0;
            if (j < j2) {
                dfj dfjVar3 = this.a;
                dfj dfjVar4 = dfjVar3 != null ? dfjVar3.g : null;
                if (dfjVar4 != null && dfjVar4.e) {
                    if ((((long) dfjVar4.c) + j) - ((long) (dfjVar4.d ? 0 : dfjVar4.b)) <= 8192) {
                        dfj dfjVar5 = rhVar.a;
                        throwIfVar1IsNull(dfjVar5);
                        dfjVar5.k(dfjVar4, (int) j);
                        rhVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                dfj dfjVar6 = rhVar.a;
                throwIfVar1IsNull(dfjVar6);
                int i3 = (int) j;
                if (i3 <= 0 || i3 > dfjVar6.c - dfjVar6.b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i3 >= 1024) {
                    dfjVarE = dfjVar6.j();
                } else {
                    dfjVarE = dfl.e();
                    byte[] bArr = dfjVar6.a;
                    byte[] bArr2 = dfjVarE.a;
                    int i4 = dfjVar6.b;
                    la._an(bArr, i4, i4 + i3, bArr2, 2);
                }
                dfjVarE.c = dfjVarE.b + i3;
                dfjVar6.b += i3;
                dfj dfjVar7 = dfjVar6.g;
                throwIfVar1IsNull(dfjVar7);
                dfjVar7.i(dfjVarE);
                rhVar.a = dfjVarE;
            }
            dfj dfjVar8 = rhVar.a;
            throwIfVar1IsNull(dfjVar8);
            long j3 = dfjVar8.c - dfjVar8.b;
            rhVar.a = dfjVar8.h();
            dfj dfjVar9 = this.a;
            if (dfjVar9 == null) {
                this.a = dfjVar8;
                dfjVar8.g = dfjVar8;
                dfjVar8.f = dfjVar8;
            } else {
                dfj dfjVar10 = dfjVar9.g;
                throwIfVar1IsNull(dfjVar10);
                dfjVar10.i(dfjVar8);
                dfj dfjVar11 = dfjVar8.g;
                if (dfjVar11 == dfjVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                throwIfVar1IsNull(dfjVar11);
                if (dfjVar11.e) {
                    int i5 = dfjVar8.c - dfjVar8.b;
                    dfj dfjVar12 = dfjVar8.g;
                    throwIfVar1IsNull(dfjVar12);
                    int i6 = 8192 - dfjVar12.c;
                    dfj dfjVar13 = dfjVar8.g;
                    throwIfVar1IsNull(dfjVar13);
                    if (!dfjVar13.d) {
                        dfj dfjVar14 = dfjVar8.g;
                        throwIfVar1IsNull(dfjVar14);
                        i2 = dfjVar14.b;
                    }
                    if (i5 <= i6 + i2) {
                        dfj dfjVar15 = dfjVar8.g;
                        throwIfVar1IsNull(dfjVar15);
                        dfjVar8.k(dfjVar15, i5);
                        dfjVar8.h();
                        dfl.d(dfjVar8);
                    }
                }
            }
            rhVar.b -= j3;
            this.b += j3;
            j -= j3;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        throwIfVar1IsNull(byteBuffer, "sink");
        dfj dfjVar = this.a;
        if (dfjVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), dfjVar.c - dfjVar.b);
        byteBuffer.put(dfjVar.a, dfjVar.b, iMin);
        int i = dfjVar.b + iMin;
        dfjVar.b = i;
        this.b -= (long) iMin;
        if (i == dfjVar.c) {
            this.a = dfjVar.h();
            dfl.d(dfjVar);
        }
        return iMin;
    }

    public final int read(byte[] bArr, int i, int i2) {
        throwIfVar1IsNull(bArr, "sink");
        aye.n(bArr.length, i, i2);
        dfj dfjVar = this.a;
        if (dfjVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, dfjVar.c - dfjVar.b);
        byte[] bArr2 = dfjVar.a;
        int i3 = dfjVar.b;
        la._ak(bArr2, i, i3, bArr, i3 + iMin);
        int i4 = dfjVar.b + iMin;
        dfjVar.b = i4;
        this.b -= (long) iMin;
        if (i4 == dfjVar.c) {
            this.a = dfjVar.h();
            dfl.d(dfjVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        throwIfVar1IsNull(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            dfj dfjVarAg = ag(1);
            int iMin = Math.min(i, 8192 - dfjVarAg.c);
            byteBuffer.get(dfjVarAg.a, dfjVarAg.c, iMin);
            i -= iMin;
            dfjVarAg.c += iMin;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    /*
     * JADX INFO: renamed from: write, reason: collision with other method in class
     */
    public final void m12write(byte[] bArr) {
        throwIfVar1IsNull(bArr, "source");
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) {
        throwIfVar1IsNull(bArr, "source");
        long j = i2;
        aye.n(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            dfj dfjVarAg = ag(1);
            int iMin = Math.min(i3 - i, 8192 - dfjVarAg.c);
            int i4 = i + iMin;
            la._ak(bArr, dfjVarAg.c, i, dfjVarAg.a, i4);
            dfjVarAg.c += iMin;
            i = i4;
        }
        this.b += j;
    }
}
