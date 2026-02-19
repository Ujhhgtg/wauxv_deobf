package me.hd.wauxv.obf;

import android.util.Log;
import com.android.dx.io.Opcodes;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akp implements bog {
    public static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final byte[] b = "MPF".getBytes(Charset.forName("UTF-8"));
    public static final int[] c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int d(ako akoVar, bva bvaVar) {
        try {
            int iF = akoVar.f();
            if ((iF & 65496) == 65496 || iF == 19789 || iF == 18761) {
                int iH = h(akoVar, Opcodes.SHR_INT_LIT8);
                if (iH != -1) {
                    byte[] bArr = (byte[]) bvaVar.i(iH, byte[].class);
                    try {
                        return i(akoVar, bArr, iH);
                    } finally {
                        bvaVar.m(bArr);
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iF);
                return -1;
            }
        } catch (akn unused) {
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType e(ako akoVar) {
        try {
            int iF = akoVar.f();
            if (iF == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int iH = (iF << 8) | akoVar.h();
            if (iH == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int iH2 = (iH << 8) | akoVar.h();
            if (iH2 == -1991225785) {
                akoVar.skip(21L);
                try {
                    return akoVar.h() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (akn unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (iH2 == 1380533830) {
                akoVar.skip(4L);
                if (((akoVar.f() << 16) | akoVar.f()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int iF2 = (akoVar.f() << 16) | akoVar.f();
                if ((iF2 & (-256)) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i = iF2 & Opcodes.CONST_METHOD_TYPE;
                if (i == 88) {
                    akoVar.skip(4L);
                    short sH = akoVar.h();
                    return (sH & 2) != 0 ? ImageHeaderParser$ImageType.ANIMATED_WEBP : (sH & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                if (i != 76) {
                    return ImageHeaderParser$ImageType.WEBP;
                }
                akoVar.skip(4L);
                return (akoVar.h() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((akoVar.f() << 16) | akoVar.f()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int iF3 = (akoVar.f() << 16) | akoVar.f();
            if (iF3 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i2 = 0;
            boolean z = iF3 == 1635150182;
            akoVar.skip(4L);
            int i3 = iH2 - 16;
            if (i3 % 4 == 0) {
                while (i2 < 5 && i3 > 0) {
                    int iF4 = (akoVar.f() << 16) | akoVar.f();
                    if (iF4 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (iF4 == 1635150182) {
                        z = true;
                    }
                    i2++;
                    i3 -= 4;
                }
            }
            return z ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (akn unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public static boolean f(ako akoVar, bva bvaVar) {
        boolean zG;
        if (e(akoVar) == ImageHeaderParser$ImageType.JPEG) {
            int iH = h(akoVar, Opcodes.USHR_INT_LIT8);
            while (iH > 0) {
                byte[] bArr = (byte[]) bvaVar.i(iH, byte[].class);
                try {
                    int i = akoVar.i(iH, bArr);
                    if (i != iH) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Unable to read APP2 segment data, length: " + iH + ", actually read: " + i);
                        }
                        zG = false;
                    } else {
                        zG = g(bArr, iH, b);
                    }
                    if (zG) {
                        bvaVar.m(bArr);
                        return true;
                    }
                    bvaVar.m(bArr);
                    iH = h(akoVar, Opcodes.USHR_INT_LIT8);
                } catch (Throwable th) {
                    bvaVar.m(bArr);
                    throw th;
                }
            }
            if (Log.isLoggable("DfltImageHeaderParser", 2)) {
                Log.v("DfltImageHeaderParser", "hasMpf: Failed to parse APP2 segment length, or no APP2 segment with MPF metadata not found");
            }
        }
        return false;
    }

    public static boolean g(byte[] bArr, int i, byte[] bArr2) {
        boolean z = (bArr == null || bArr2 == null || i <= bArr2.length) ? false : true;
        if (z) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    public static int h(ako akoVar, int i) {
        short sH;
        int iF;
        long j;
        long jSkip;
        do {
            short sH2 = akoVar.h();
            if (sH2 == 255) {
                sH = akoVar.h();
                if (sH != 218) {
                    if (sH != 217) {
                        iF = akoVar.f() - 2;
                        if (sH == i) {
                            return iF;
                        }
                        j = iF;
                        jSkip = akoVar.skip(j);
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Found MARKER_EOI in " + i + " segment");
                        return -1;
                    }
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sH2));
                return -1;
            }
            return -1;
        } while (jSkip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder sbQ = yg.concatVar31425(sH, iF, "Unable to skip enough data, type: ", ", wanted to skip: ", ", but actually skipped: ");
            sbQ.append(jSkip);
            Log.d("DfltImageHeaderParser", sbQ.toString());
        }
        return -1;
    }

    public static int i(ako akoVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        int i2 = akoVar.i(i, bArr);
        if (i2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + i2);
                return -1;
            }
        } else if (g(bArr, i, a)) {
            ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
            short s = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
            if (s != 18761) {
                if (s != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) s));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            byteBuffer.order(byteOrder);
            int i3 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
            int i4 = i3 + 6;
            short s2 = byteBuffer.remaining() - i4 >= 2 ? byteBuffer.getShort(i4) : (short) -1;
            for (int i5 = 0; i5 < s2; i5++) {
                int i6 = (i5 * 12) + i3 + 8;
                short s3 = byteBuffer.remaining() - i6 >= 2 ? byteBuffer.getShort(i6) : (short) -1;
                if (s3 == 274) {
                    int i7 = i6 + 2;
                    short s4 = byteBuffer.remaining() - i7 >= 2 ? byteBuffer.getShort(i7) : (short) -1;
                    if (s4 >= 1 && s4 <= 12) {
                        int i8 = i6 + 4;
                        int i9 = byteBuffer.remaining() - i8 >= 4 ? byteBuffer.getInt(i8) : -1;
                        if (i9 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder sbQ = yg.concatVar31425(i5, s3, "Got tagIndex=", " tagType=", " formatCode=");
                                sbQ.append((int) s4);
                                sbQ.append(" componentCount=");
                                sbQ.append(i9);
                                Log.d("DfltImageHeaderParser", sbQ.toString());
                            }
                            int i10 = i9 + c[s4];
                            if (i10 <= 4) {
                                int i11 = i6 + 8;
                                if (i11 >= 0 && i11 <= byteBuffer.remaining()) {
                                    if (i10 >= 0 && i10 + i11 <= byteBuffer.remaining()) {
                                        if (byteBuffer.remaining() - i11 >= 2) {
                                            return byteBuffer.getShort(i11);
                                        }
                                        return -1;
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) s3));
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i11 + " tagType=" + ((int) s3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) s4));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) s4));
                    }
                }
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // me.hd.wauxv.obf.bog
    public final ImageHeaderParser$ImageType j(ByteBuffer byteBuffer) {
        cmz.n(byteBuffer, "Argument must not be null");
        return e(new ri(2, byteBuffer));
    }

    @Override // me.hd.wauxv.obf.bog
    public final int k(InputStream inputStream, bva bvaVar) {
        erp erpVar = new erp(inputStream, 13);
        cmz.n(bvaVar, "Argument must not be null");
        return d(erpVar, bvaVar);
    }

    @Override // me.hd.wauxv.obf.bog
    public final ImageHeaderParser$ImageType l(InputStream inputStream) {
        return e(new erp(inputStream, 13));
    }

    @Override // me.hd.wauxv.obf.bog
    public final int m(ByteBuffer byteBuffer, bva bvaVar) {
        ri riVar = new ri(2, byteBuffer);
        cmz.n(bvaVar, "Argument must not be null");
        return d(riVar, bvaVar);
    }

    @Override // me.hd.wauxv.obf.bog
    public final boolean n(ByteBuffer byteBuffer, bva bvaVar) {
        ri riVar = new ri(2, byteBuffer);
        cmz.n(bvaVar, "Argument must not be null");
        return f(riVar, bvaVar);
    }

    @Override // me.hd.wauxv.obf.bog
    public final boolean o(InputStream inputStream, bva bvaVar) {
        cmz.n(inputStream, "Argument must not be null");
        erp erpVar = new erp(inputStream, 13);
        cmz.n(bvaVar, "Argument must not be null");
        return f(erpVar, bvaVar);
    }
}
