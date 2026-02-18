package me.hd.wauxv.obf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amk {
    public static final short[] a = new short[0];
    public ByteBuffer b;
    public final dps c;
    public int d;
    public final ami e;
    public final ami f;
    public final ami g;
    public final ami h;
    public final ami i;
    public final ami j;

    public amk(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        dps dpsVar = new dps();
        this.c = dpsVar;
        this.d = 0;
        this.e = new ami(this, 3);
        this.f = new ami(this, 4);
        this.g = new ami(this, 5);
        this.h = new ami(this, 2);
        this.i = new ami(this, 0);
        this.j = new ami(this, 1);
        this.b = byteBufferWrap;
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        dpsVar.ae(this);
    }

    public static void k(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(dkz.p(i, "index:", ", length=", i2));
        }
    }

    public final amj l(int i, String str) {
        if ((i & 3) != 0) {
            throw new IllegalStateException("Not four byte aligned!");
        }
        int i2 = this.d + i;
        ByteBuffer byteBufferDuplicate = this.b.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferDuplicate.position(this.d);
        byteBufferDuplicate.limit(i2);
        amj amjVar = new amj(this, str, byteBufferDuplicate);
        this.d = i2;
        return amjVar;
    }

    public final void m(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                this.b = byteBufferWrap;
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                this.c.ae(this);
                return;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public final amj n(int i) {
        if (i < 0 || i >= this.b.capacity()) {
            StringBuilder sbR = yg.r(i, "position=", " length=");
            sbR.append(this.b.capacity());
            throw new IllegalArgumentException(sbR.toString());
        }
        ByteBuffer byteBufferDuplicate = this.b.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(this.b.capacity());
        return new amj(this, "section", byteBufferDuplicate);
    }

    public final yv o(yx yxVar) {
        int i = yxVar.i;
        if (i == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        amj amjVarN = n(i);
        int iAc = ajn.ac(amjVarN);
        int iAc2 = ajn.ac(amjVarN);
        int iAc3 = ajn.ac(amjVarN);
        int iAc4 = ajn.ac(amjVarN);
        ys[] ysVarArr = new ys[iAc];
        int iAc5 = 0;
        for (int i2 = 0; i2 < iAc; i2++) {
            iAc5 += ajn.ac(amjVarN);
            ysVarArr[i2] = new ys(iAc5, ajn.ac(amjVarN));
        }
        ys[] ysVarArr2 = new ys[iAc2];
        int iAc6 = 0;
        for (int i3 = 0; i3 < iAc2; i3++) {
            iAc6 += ajn.ac(amjVarN);
            ysVarArr2[i3] = new ys(iAc6, ajn.ac(amjVarN));
        }
        return new yv(ysVarArr, ysVarArr2, amjVarN.f(iAc3), amjVarN.f(iAc4));
    }

    public final aag p(yt ytVar) {
        short[] sArr;
        aad[] aadVarArr;
        aae[] aaeVarArr;
        int i = ytVar.c;
        if (i == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        amj amjVarN = n(i);
        ByteBuffer byteBuffer = amjVarN.b;
        int i2 = amjVarN.i();
        int i3 = amjVarN.i();
        int i4 = amjVarN.i();
        int i5 = amjVarN.i();
        int i6 = byteBuffer.getInt();
        int i7 = byteBuffer.getInt();
        if (i7 == 0) {
            sArr = a;
        } else {
            short[] sArr2 = new short[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                sArr2[i8] = byteBuffer.getShort();
            }
            sArr = sArr2;
        }
        if (i5 > 0) {
            if (sArr.length % 2 == 1) {
                byteBuffer.getShort();
            }
            amj amjVarN2 = amjVarN.d.n(byteBuffer.position());
            int i9 = i5 * 8;
            if (i9 < 0) {
                throw new IllegalArgumentException();
            }
            byteBuffer.position(byteBuffer.position() + i9);
            int iPosition = byteBuffer.position();
            int iAc = ajn.ac(amjVarN);
            aadVarArr = new aad[iAc];
            int i10 = 0;
            while (i10 < iAc) {
                int iPosition2 = byteBuffer.position() - iPosition;
                int iAb = ajn.ab(amjVarN);
                int iAbs = Math.abs(iAb);
                amj amjVar = amjVarN;
                int[] iArr = new int[iAbs];
                int[] iArr2 = new int[iAbs];
                ByteBuffer byteBuffer2 = byteBuffer;
                for (int i11 = 0; i11 < iAbs; i11++) {
                    iArr[i11] = ajn.ac(amjVar);
                    iArr2[i11] = ajn.ac(amjVar);
                }
                aadVarArr[i10] = new aad(iAb <= 0 ? ajn.ac(amjVar) : -1, iPosition2, iArr, iArr2);
                i10++;
                amjVarN = amjVar;
                byteBuffer = byteBuffer2;
            }
            aae[] aaeVarArr2 = new aae[i5];
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = amjVarN2.b.getInt();
                int i14 = amjVarN2.i();
                int i15 = amjVarN2.i();
                int i16 = 0;
                while (true) {
                    if (i16 >= iAc) {
                        throw new IllegalArgumentException();
                    }
                    if (aadVarArr[i16].d == i15) {
                        break;
                    }
                    i16++;
                }
                aaeVarArr2[i12] = new aae(i13, i14, i16);
            }
            aaeVarArr = aaeVarArr2;
        } else {
            aadVarArr = new aad[0];
            aaeVarArr = new aae[0];
        }
        return new aag(i2, i3, i4, i6, sArr, aaeVarArr, aadVarArr);
    }

    public final void q(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteBuffer byteBufferDuplicate = this.b.duplicate();
        byteBufferDuplicate.clear();
        while (byteBufferDuplicate.hasRemaining()) {
            int iMin = Math.min(8192, byteBufferDuplicate.remaining());
            byteBufferDuplicate.get(bArr, 0, iMin);
            outputStream.write(bArr, 0, iMin);
        }
    }

    public amk(int i) {
        this.c = new dps();
        this.d = 0;
        this.e = new ami(this, 3);
        this.f = new ami(this, 4);
        this.g = new ami(this, 5);
        this.h = new ami(this, 2);
        this.i = new ami(this, 0);
        this.j = new ami(this, 1);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[i]);
        this.b = byteBufferWrap;
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
    }

    public amk(File file) throws IOException {
        this.c = new dps();
        this.d = 0;
        this.e = new ami(this, 3);
        this.f = new ami(this, 4);
        this.g = new ami(this, 5);
        this.h = new ami(this, 2);
        this.i = new ami(this, 0);
        this.j = new ami(this, 1);
        String name = file.getName();
        if (!name.endsWith(".zip") && !name.endsWith(".jar") && !name.endsWith(".apk")) {
            if (file.getName().endsWith(".dex")) {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    m(fileInputStream);
                    fileInputStream.close();
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
            throw new amo("unknown output extension: " + file, null);
        }
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry("classes.dex");
        if (entry != null) {
            InputStream inputStream = zipFile.getInputStream(entry);
            try {
                m(inputStream);
                inputStream.close();
                zipFile.close();
                return;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        }
        throw new amo("Expected classes.dex in " + file, null);
    }
}
