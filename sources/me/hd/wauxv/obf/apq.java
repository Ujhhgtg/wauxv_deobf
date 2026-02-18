package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apq {
    public static final cru a = cru.f(ajo.c, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");
    public static final cru b = new cru("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null,
            cru.a);
    public static final cru c;
    public static final cru d;
    public static final nu e;
    public static final ArrayDeque f;
    public final oz g;
    public final DisplayMetrics h;
    public final bva i;
    public final ArrayList j;
    public final bkf k = bkf.i();

    static {
        apo apoVar = apo.a;
        Boolean bool = Boolean.FALSE;
        c = cru.f(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        d = cru.f(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        e = new nu(21);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A,
                ImageHeaderParser$ImageType.PNG));
        char[] cArr = eot.a;
        f = new ArrayDeque(0);
    }

    public apq(ArrayList arrayList, DisplayMetrics displayMetrics, oz ozVar, bva bvaVar) {
        this.j = arrayList;
        cmz.n(displayMetrics, "Argument must not be null");
        this.h = displayMetrics;
        cmz.n(ozVar, "Argument must not be null");
        this.g = ozVar;
        cmz.n(bvaVar, "Argument must not be null");
        this.i = bvaVar;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
     * 
     * throw r5;
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public static android.graphics.Bitmap l(me.hd.wauxv.obf.jx r9, android.graphics.BitmapFactory.Options r10,
            me.hd.wauxv.obf.app r11, me.hd.wauxv.obf.oz r12) {
        /*
         * java.lang.String r0 = "Downsampler"
         * boolean r1 = r10.inJustDecodeBounds
         * if (r1 != 0) goto L22
         * r11.v()
         * int r1 = r9.d
         * switch(r1) {
         * case 11: goto L22;
         * case 12: goto Lf;
         * default: goto Le;
         * }
         * Le:
         * goto L22
         * Lf:
         * java.lang.Object r1 = r9.e
         * me.hd.wauxv.obf.bmu r1 = (me.hd.wauxv.obf.bmu) r1
         * java.lang.Object r1 = r1.h
         * me.hd.wauxv.obf.cyp r1 = (me.hd.wauxv.obf.cyp) r1
         * monitor-enter(r1)
         * byte[] r2 = r1.a // Catch: java.lang.Throwable -> L1f
         * int r2 = r2.length // Catch: java.lang.Throwable -> L1f
         * r1.c = r2 // Catch: java.lang.Throwable -> L1f
         * monitor-exit(r1)
         * goto L22
         * L1f:
         * r9 = move-exception
         * monitor-exit(r1) // Catch: java.lang.Throwable -> L1f
         * throw r9
         * L22:
         * int r1 = r10.outWidth
         * int r2 = r10.outHeight
         * java.lang.String r3 = r10.outMimeType
         * java.util.concurrent.locks.Lock r4 = me.hd.wauxv.obf.ele.b
         * r4.lock()
         * android.graphics.Bitmap r9 = r9.o(r10) // Catch:
         * java.lang.IllegalArgumentException -> L35 java.lang.Throwable -> L7c
         * r4.unlock()
         * return r9
         * L35:
         * r4 = move-exception
         * java.io.IOException r5 = new java.io.IOException // Catch:
         * java.lang.Throwable -> L7c
         * java.lang.String r6 = "Exception decoding bitmap, outWidth: "
         * java.lang.String r7 = ", outHeight: "
         * java.lang.String r8 = ", outMimeType: "
         * java.lang.StringBuilder r1 = me.hd.wauxv.obf.yg.q(r1, r2, r6, r7, r8) //
         * Catch: java.lang.Throwable -> L7c
         * r1.append(r3) // Catch: java.lang.Throwable -> L7c
         * java.lang.String r2 = ", inBitmap: "
         * r1.append(r2) // Catch: java.lang.Throwable -> L7c
         * android.graphics.Bitmap r2 = r10.inBitmap // Catch: java.lang.Throwable ->
         * L7c
         * java.lang.String r2 = m(r2) // Catch: java.lang.Throwable -> L7c
         * r1.append(r2) // Catch: java.lang.Throwable -> L7c
         * java.lang.String r1 = r1.toString() // Catch: java.lang.Throwable -> L7c
         * r5.<init>(r1, r4) // Catch: java.lang.Throwable -> L7c
         * r1 = 3
         * boolean r1 = android.util.Log.isLoggable(r0, r1) // Catch:
         * java.lang.Throwable -> L7c
         * if (r1 == 0) goto L66
         * java.lang.String r1 =
         * "Failed to decode with inBitmap, trying again without Bitmap re-use"
         * android.util.Log.d(r0, r1, r5) // Catch: java.lang.Throwable -> L7c
         * L66:
         * android.graphics.Bitmap r0 = r10.inBitmap // Catch: java.lang.Throwable ->
         * L7c
         * if (r0 == 0) goto L7b
         * r12.p(r0) // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
         * r0 = 0
         * r10.inBitmap = r0 // Catch: java.io.IOException -> L7a java.lang.Throwable ->
         * L7c
         * android.graphics.Bitmap r9 = l(r9, r10, r11, r12) // Catch:
         * java.io.IOException -> L7a java.lang.Throwable -> L7c
         * java.util.concurrent.locks.Lock r10 = me.hd.wauxv.obf.ele.b
         * r10.unlock()
         * return r9
         * L7a:
         * throw r5 // Catch: java.lang.Throwable -> L7c
         * L7b:
         * throw r5 // Catch: java.lang.Throwable -> L7c
         * L7c:
         * r9 = move-exception
         * java.util.concurrent.locks.Lock r10 = me.hd.wauxv.obf.ele.b
         * r10.unlock()
         * throw r9
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.apq.l(me.hd.wauxv.obf.jx, android.graphics.BitmapFactory$Options, me.hd.wauxv.obf.app, me.hd.wauxv.obf.oz):android.graphics.Bitmap");
    }

    public static String m(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig()
                + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void n(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final pa o(jx jxVar, int i, int i2, crw crwVar, app appVar) {
        ArrayDeque arrayDeque;
        BitmapFactory.Options options;
        byte[] bArr = (byte[]) this.i.i(65536, byte[].class);
        synchronized (apq.class) {
            arrayDeque = f;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                n(options);
            }
        }
        options.inTempStorage = bArr;
        ajo ajoVar = (ajo) crwVar.b(a);
        cvi cviVar = (cvi) crwVar.b(b);
        apo apoVar = (apo) crwVar.b(apo.f);
        boolean zBooleanValue = ((Boolean) crwVar.b(c)).booleanValue();
        cru cruVar = d;
        try {
            pa paVarG = pa.g(p(jxVar, options, apoVar, ajoVar, cviVar,
                    crwVar.b(cruVar) != null && ((Boolean) crwVar.b(cruVar)).booleanValue(), i, i2, zBooleanValue,
                    appVar), this.g);
            n(options);
            synchronized (arrayDeque) {
                arrayDeque.offer(options);
            }
            return paVarG;
        } finally {
            n(options);
            ArrayDeque arrayDeque2 = f;
            synchronized (arrayDeque2) {
                arrayDeque2.offer(options);
                this.i.m(bArr);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:143:0x035c */
    /* JADX WARN: Found duplicated region for block: B:146:0x038b */
    /* JADX WARN: Found duplicated region for block: B:147:0x0393 */
    /* JADX WARN: Found duplicated region for block: B:149:0x0396 */
    /* JADX WARN: Found duplicated region for block: B:150:0x0398 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:160:0x03c3 */
    /* JADX WARN: Found duplicated region for block: B:161:0x03c6 */
    /* JADX WARN: Found duplicated region for block: B:164:0x03ce */
    /* JADX WARN: Found duplicated region for block: B:165:0x03d2 */
    /*
     * JADX WARN: Found duplicated region for block: B:168:0x03db A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:171:0x03e2 */
    /* JADX WARN: Found duplicated region for block: B:173:0x03e6 */
    /* JADX WARN: Found duplicated region for block: B:177:0x03ee */
    /* JADX WARN: Found duplicated region for block: B:179:0x03f1 */
    /* JADX WARN: Found duplicated region for block: B:180:0x03f7 */
    /* JADX WARN: Found duplicated region for block: B:183:0x041f */
    /*
     * JADX WARN: Found duplicated region for block: B:186:0x045c A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:195:0x0475 */
    /* JADX WARN: Found duplicated region for block: B:197:0x0479 */
    /* JADX WARN: Found duplicated region for block: B:199:0x047d A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:201:0x0483 */
    /* JADX WARN: Found duplicated region for block: B:206:0x048f */
    /* JADX WARN: Found duplicated region for block: B:208:0x0492 */
    /* JADX WARN: Found duplicated region for block: B:209:0x0495 */
    /* JADX WARN: Found duplicated region for block: B:212:0x04a0 */
    /* JADX WARN: Found duplicated region for block: B:215:0x04b7 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:217:0x053c */
    /* JADX WARN: Found duplicated region for block: B:219:0x0546 */
    /* JADX WARN: Found duplicated region for block: B:220:0x0548 */
    /* JADX WARN: Found duplicated region for block: B:223:0x0559 */
    /* JADX WARN: Found duplicated region for block: B:224:0x055d A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:225:0x0566 */
    /* JADX WARN: Found duplicated region for block: B:226:0x056a A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:227:0x0573 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:228:0x057c */
    /* JADX WARN: Found duplicated region for block: B:229:0x0580 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:233:0x05aa */
    /*
     * JADX WARN: Found duplicated region for block: B:236:0x039e
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:248:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:45:0x010b */
    /* JADX WARN: Found duplicated region for block: B:46:0x010d */
    /* JADX WARN: Found duplicated region for block: B:47:0x0110 */
    /* JADX WARN: Found duplicated region for block: B:48:0x0112 */
    /* JADX WARN: Found duplicated region for block: B:50:0x0117 */
    /* JADX WARN: Found duplicated region for block: B:51:0x0119 */
    /* JADX WARN: Found duplicated region for block: B:54:0x011e A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:55:0x0120 */
    /* JADX WARN: Found duplicated region for block: B:58:0x0125 */
    /* JADX WARN: Found duplicated region for block: B:59:0x0128 */
    /* JADX WARN: Found duplicated region for block: B:61:0x012d */
    /* JADX WARN: Found duplicated region for block: B:63:0x0133 */
    /*
     * JADX WARN: Found duplicated region for block: B:65:0x0137 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:68:0x013c */
    /* JADX WARN: Found duplicated region for block: B:69:0x013e */
    /*
     * JADX WARN: Found duplicated region for block: B:72:0x0155 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:73:0x0157 A[MOVE_INLINED] */
    public final Bitmap p(jx jxVar, BitmapFactory.Options options, apo apoVar, ajo ajoVar, cvi cviVar, boolean z, int i,
            int i2, boolean z2, app appVar) throws Throwable {
        long j;
        String str;
        int iM;
        int iY;
        int i3;
        boolean z3;
        int i4;
        int i5;
        int i6;
        ImageHeaderParser$ImageType imageHeaderParser$ImageTypeV;
        int i7;
        String str2;
        oz ozVar;
        String str3;
        int i8;
        boolean zK;
        boolean z4;
        boolean zHasAlpha;
        Bitmap.Config config;
        boolean z5;
        int i9;
        float f2;
        int i10;
        int iRound;
        int iRound2;
        int i11;
        oz ozVar2;
        Bitmap bitmapL;
        Matrix matrix;
        Bitmap bitmap;
        ColorSpace colorSpace;
        Bitmap.Config config2;
        String str4;
        String str5;
        int i12;
        int i13;
        int iFloor;
        int iFloor2;
        int iRound3;
        cyp cypVar;
        List list;
        int i14 = bxq.b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        options.inJustDecodeBounds = true;
        oz ozVar3 = this.g;
        l(jxVar, options, appVar, ozVar3);
        options.inJustDecodeBounds = false;
        int[] iArr = { options.outWidth, options.outHeight };
        int i15 = iArr[0];
        int i16 = iArr[1];
        String str6 = options.outMimeType;
        boolean z6 = (i15 == -1 || i16 == -1) ? false : z;
        cyp cypVar2 = null;
        switch (jxVar.d) {
            case 11:
                j = jElapsedRealtimeNanos;
                str = str6;
                List list2 = (List) jxVar.f;
                ByteBuffer byteBufferD = sf.d((ByteBuffer) jxVar.e);
                bva bvaVar = (bva) jxVar.h;
                if (byteBufferD != null) {
                    int size = list2.size();
                    int i17 = 0;
                    while (true) {
                        if (i17 < size) {
                            List list3 = list2;
                            try {
                                iM = ((bog) list2.get(i17)).m(byteBufferD, bvaVar);
                                bva bvaVar2 = bvaVar;
                                if (iM != -1) {
                                    iY = iM;
                                    switch (iY) {
                                        case 3:
                                        case 4:
                                            i3 = 180;
                                            break;
                                        case 5:
                                        case 6:
                                            i3 = 90;
                                            break;
                                        case 7:
                                        case 8:
                                            i3 = 270;
                                            break;
                                        default:
                                            i3 = 0;
                                            break;
                                    }
                                    switch (iY) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                            z3 = true;
                                            break;
                                        default:
                                            z3 = false;
                                            break;
                                    }
                                    if (i == Integer.MIN_VALUE) {
                                        if (i3 != 90) {
                                            i4 = 270;
                                            if (i3 == 270) {
                                                i5 = i15;
                                            }
                                        } else {
                                            i4 = 270;
                                        }
                                        i5 = i16;
                                    } else {
                                        i4 = 270;
                                        i5 = i;
                                    }
                                    i6 = i2 == Integer.MIN_VALUE ? (i3 != 90 || i3 == i4) ? i15 : i16 : i2;
                                    imageHeaderParser$ImageTypeV = jxVar.v();
                                    i7 = iY;
                                    boolean z7 = z3;
                                    if (i15 > 0 || i16 <= 0) {
                                        str2 = ", density: ";
                                        ozVar = ozVar3;
                                        str3 = ", target density: ";
                                        i8 = i5;
                                        if (Log.isLoggable("Downsampler", 3)) {
                                            Log.d("Downsampler",
                                                    "Unable to determine dimensions for: "
                                                            + imageHeaderParser$ImageTypeV + " with target [" + i8 + "x"
                                                            + i6 + "]");
                                        }
                                    } else {
                                        if (i3 == 90 || i3 == 270) {
                                            str4 = ", density: ";
                                            str5 = "]";
                                            i12 = i16;
                                            i13 = i15;
                                        } else {
                                            str4 = ", density: ";
                                            str5 = "]";
                                            i13 = i16;
                                            i12 = i15;
                                        }
                                        i8 = i5;
                                        float fJ = apoVar.j(i12, i13, i8, i6);
                                        if (fJ <= 0.0f) {
                                            throw new IllegalArgumentException("Cannot scale with factor: " + fJ
                                                    + " from: " + apoVar + ", source: [" + i15 + "x" + i16
                                                    + "], target: [" + i8 + "x" + i6 + str5);
                                        }
                                        int i18 = apoVar.i(i12, i13, i8, i6);
                                        if (i18 == 0) {
                                            throw new IllegalArgumentException("Cannot round with null rounding");
                                        }
                                        int i19 = i3;
                                        float f3 = i12;
                                        int i20 = i12;
                                        float f4 = i13;
                                        int i21 = i13;
                                        int i22 = (int) (((double) (fJ * f4)) + 0.5d);
                                        int i23 = i20 / ((int) (((double) (fJ * f3)) + 0.5d));
                                        int i24 = i21 / i22;
                                        int iMax = Math.max(1, Integer
                                                .highestOneBit(i18 == 1 ? Math.max(i23, i24) : Math.min(i23, i24)));
                                        if (i18 == 1 && iMax < 1.0f / fJ) {
                                            iMax <<= 1;
                                        }
                                        options.inSampleSize = iMax;
                                        if (imageHeaderParser$ImageTypeV == ImageHeaderParser$ImageType.JPEG) {
                                            float fMin = Math.min(iMax, 8);
                                            iFloor = (int) Math.ceil(f3 / fMin);
                                            iFloor2 = (int) Math.ceil(f4 / fMin);
                                            int i25 = iMax / 8;
                                            if (i25 > 0) {
                                                iFloor2 /= i25;
                                                iRound3 = iFloor / i25;
                                            } else {
                                                iRound3 = iFloor;
                                            }
                                        } else {
                                            if (imageHeaderParser$ImageTypeV == ImageHeaderParser$ImageType.PNG
                                                    || imageHeaderParser$ImageTypeV == ImageHeaderParser$ImageType.PNG_A) {
                                                float f5 = iMax;
                                                iFloor = (int) Math.floor(f3 / f5);
                                                iFloor2 = (int) Math.floor(f4 / f5);
                                            } else if (imageHeaderParser$ImageTypeV.isWebp()) {
                                                float f6 = iMax;
                                                iRound3 = Math.round(f3 / f6);
                                                iFloor2 = Math.round(f4 / f6);
                                            } else if (i20 % iMax == 0 && i21 % iMax == 0) {
                                                iRound3 = i20 / iMax;
                                                iFloor2 = i21 / iMax;
                                            } else {
                                                options.inJustDecodeBounds = true;
                                                l(jxVar, options, appVar, ozVar3);
                                                options.inJustDecodeBounds = false;
                                                int[] iArr2 = { options.outWidth, options.outHeight };
                                                iFloor = iArr2[0];
                                                iFloor2 = iArr2[1];
                                            }
                                            iRound3 = iFloor;
                                        }
                                        double dJ = apoVar.j(iRound3, iFloor2, i8, i6);
                                        int iRound4 = (int) Math.round((dJ <= 1.0d ? dJ : 1.0d / dJ) * 2.147483647E9d);
                                        ozVar = ozVar3;
                                        int i26 = (int) ((((double) iRound4) * dJ) + 0.5d);
                                        float f7 = i26 / iRound4;
                                        int i27 = iMax;
                                        options.inTargetDensity = (int) (((dJ / ((double) f7)) * ((double) i26))
                                                + 0.5d);
                                        int iRound5 = (int) Math.round((dJ <= 1.0d ? dJ : 1.0d / dJ) * 2.147483647E9d);
                                        options.inDensity = iRound5;
                                        int i28 = options.inTargetDensity;
                                        if (i28 <= 0 || iRound5 <= 0 || i28 == iRound5) {
                                            options.inTargetDensity = 0;
                                            options.inDensity = 0;
                                        } else {
                                            options.inScaled = true;
                                        }
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            StringBuilder sbQ = yg.q(i15, i16, "Calculate scaling, source: [", "x",
                                                    "], degreesToRotate: ");
                                            sbQ.append(i19);
                                            sbQ.append(", target: [");
                                            sbQ.append(i8);
                                            sbQ.append("x");
                                            sbQ.append(i6);
                                            sbQ.append("], power of two scaled: [");
                                            sbQ.append(iRound3);
                                            sbQ.append("x");
                                            sbQ.append(iFloor2);
                                            sbQ.append("], exact scale factor: ");
                                            sbQ.append(fJ);
                                            sbQ.append(", power of 2 sample size: ");
                                            sbQ.append(i27);
                                            sbQ.append(", adjusted scale factor: ");
                                            sbQ.append(dJ);
                                            str3 = ", target density: ";
                                            sbQ.append(str3);
                                            sbQ.append(options.inTargetDensity);
                                            str2 = str4;
                                            sbQ.append(str2);
                                            sbQ.append(options.inDensity);
                                            Log.v("Downsampler", sbQ.toString());
                                        } else {
                                            str2 = str4;
                                            str3 = ", target density: ";
                                        }
                                    }
                                    zK = this.k.k(i8, i6, z6, z7);
                                    if (zK) {
                                        options.inPreferredConfig = Bitmap.Config.HARDWARE;
                                        z4 = false;
                                        options.inMutable = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (zK) {
                                        if (ajoVar != ajo.a) {
                                            try {
                                                zHasAlpha = jxVar.v().hasAlpha();
                                            } catch (IOException e2) {
                                                if (Log.isLoggable("Downsampler", 3)) {
                                                    Log.d("Downsampler",
                                                            "Cannot determine whether the image has alpha or not from header, format "
                                                                    + ajoVar,
                                                            e2);
                                                }
                                                zHasAlpha = z4;
                                            }
                                            config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                                            options.inPreferredConfig = config;
                                            if (config == Bitmap.Config.RGB_565) {
                                                z5 = true;
                                                options.inDither = true;
                                            } else {
                                                z5 = true;
                                            }
                                        } else {
                                            z5 = true;
                                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                                        }
                                        break;
                                    } else {
                                        z5 = true;
                                    }
                                    i9 = Build.VERSION.SDK_INT;
                                    if (i15 >= 0 || i16 < 0 || !z2) {
                                        int i29 = options.inTargetDensity;
                                        f2 = (i29 > 0 || (i11 = options.inDensity) <= 0 || i29 == i11) ? z4
                                                : z5 ? i29 / options.inDensity : 1.0f;
                                        i10 = options.inSampleSize;
                                        float f8 = i10;
                                        int iCeil = (int) Math.ceil(i15 / f8);
                                        int iCeil2 = (int) Math.ceil(i16 / f8);
                                        iRound = Math.round(iCeil * f2);
                                        iRound2 = Math.round(iCeil2 * f2);
                                        if (Log.isLoggable("Downsampler", 2)) {
                                            StringBuilder sbQ2 = yg.q(iRound, iRound2, "Calculated target [", "x",
                                                    "] for source [");
                                            sbQ2.append(i15);
                                            sbQ2.append("x");
                                            sbQ2.append(i16);
                                            sbQ2.append("], sampleSize: ");
                                            sbQ2.append(i10);
                                            sbQ2.append(", targetDensity: ");
                                            sbQ2.append(options.inTargetDensity);
                                            sbQ2.append(str2);
                                            sbQ2.append(options.inDensity);
                                            sbQ2.append(", density multiplier: ");
                                            sbQ2.append(f2);
                                            Log.v("Downsampler", sbQ2.toString());
                                        }
                                        i6 = iRound2;
                                    } else {
                                        iRound = i8;
                                    }
                                    if (iRound <= 0 && i6 > 0
                                            && (config2 = options.inPreferredConfig) != Bitmap.Config.HARDWARE) {
                                        Bitmap.Config config3 = options.outConfig;
                                        if (config3 != null) {
                                            config2 = config3;
                                        }
                                        ozVar2 = ozVar;
                                        options.inBitmap = ozVar2.n(iRound, i6, config2);
                                    }
                                    if (cviVar != null) {
                                        if (i9 >= 28) {
                                            options.inPreferredColorSpace = ColorSpace
                                                    .get(cviVar != cvi.a && (colorSpace = options.outColorSpace) != null
                                                            && colorSpace.isWideGamut() ? ColorSpace.Named.DISPLAY_P3
                                                                    : ColorSpace.Named.SRGB);
                                        } else {
                                            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                                        }
                                    }
                                    bitmapL = l(jxVar, options, appVar, ozVar2);
                                    appVar.l(bitmapL, ozVar2);
                                    if (Log.isLoggable("Downsampler", 2)) {
                                        Log.v("Downsampler", "Decoded " + m(bitmapL) + " from [" + i15 + "x" + i16
                                                + "] " + str + " with inBitmap " + m(options.inBitmap) + " for [" + i
                                                + "x" + i2 + "], sample size: " + options.inSampleSize + str2
                                                + options.inDensity + str3 + options.inTargetDensity + ", thread: "
                                                + Thread.currentThread().getName() + ", duration: " + bxq.c(j));
                                    }
                                    if (bitmapL != null) {
                                        return null;
                                    }
                                    bitmapL.setDensity(this.h.densityDpi);
                                    switch (i7) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                            matrix = new Matrix();
                                            switch (i7) {
                                                case 2:
                                                    matrix.setScale(-1.0f, 1.0f);
                                                    break;
                                                case 3:
                                                    matrix.setRotate(180.0f);
                                                    break;
                                                case 4:
                                                    matrix.setRotate(180.0f);
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                case 5:
                                                    matrix.setRotate(90.0f);
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                case 6:
                                                    matrix.setRotate(90.0f);
                                                    break;
                                                case 7:
                                                    matrix.setRotate(-90.0f);
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                case 8:
                                                    matrix.setRotate(-90.0f);
                                                    break;
                                            }
                                            bitmapL = Bitmap.createBitmap(bitmapL, 0, 0, bitmapL.getWidth(),
                                                    bitmapL.getHeight(), matrix, true);
                                            bitmap = bitmapL;
                                            break;
                                        default:
                                            bitmap = bitmapL;
                                            break;
                                    }
                                    if (!bitmap.equals(bitmapL)) {
                                        ozVar2.p(bitmap);
                                    }
                                    return bitmapL;
                                }
                                i17++;
                                list2 = list3;
                                bvaVar = bvaVar2;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
                iY = -1;
                switch (iY) {
                    case 3:
                    case 4:
                        i3 = 180;
                        break;
                    case 5:
                    case 6:
                        i3 = 90;
                        break;
                    case 7:
                    case 8:
                        i3 = 270;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                switch (iY) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        z3 = true;
                        break;
                    default:
                        z3 = false;
                        break;
                }
                if (i == Integer.MIN_VALUE) {
                    if (i3 != 90) {
                        i4 = 270;
                        if (i3 == 270) {
                            i5 = i15;
                        }
                    } else {
                        i4 = 270;
                    }
                    i5 = i16;
                } else {
                    i4 = 270;
                    i5 = i;
                }
                if (i2 == Integer.MIN_VALUE) {
                }
                imageHeaderParser$ImageTypeV = jxVar.v();
                i7 = iY;
                boolean z72 = z3;
                if (i15 > 0) {
                    str2 = ", density: ";
                    ozVar = ozVar3;
                    str3 = ", target density: ";
                    i8 = i5;
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeV
                                + " with target [" + i8 + "x" + i6 + "]");
                    }
                } else {
                    str2 = ", density: ";
                    ozVar = ozVar3;
                    str3 = ", target density: ";
                    i8 = i5;
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeV
                                + " with target [" + i8 + "x" + i6 + "]");
                    }
                }
                zK = this.k.k(i8, i6, z6, z72);
                if (zK) {
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    z4 = false;
                    options.inMutable = false;
                } else {
                    z4 = false;
                }
                if (zK) {
                    z5 = true;
                } else if (ajoVar != ajo.a) {
                    zHasAlpha = jxVar.v().hasAlpha();
                    if (zHasAlpha) {
                    }
                    options.inPreferredConfig = config;
                    if (config == Bitmap.Config.RGB_565) {
                        z5 = true;
                        options.inDither = true;
                    } else {
                        z5 = true;
                    }
                } else {
                    z5 = true;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
                i9 = Build.VERSION.SDK_INT;
                if (i15 >= 0) {
                    int i292 = options.inTargetDensity;
                    if ((i292 > 0 || (i11 = options.inDensity) <= 0 || i292 == i11) ? z4 : z5) {
                    }
                    i10 = options.inSampleSize;
                    float f82 = i10;
                    int iCeil3 = (int) Math.ceil(i15 / f82);
                    int iCeil22 = (int) Math.ceil(i16 / f82);
                    iRound = Math.round(iCeil3 * f2);
                    iRound2 = Math.round(iCeil22 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sbQ22 = yg.q(iRound, iRound2, "Calculated target [", "x", "] for source [");
                        sbQ22.append(i15);
                        sbQ22.append("x");
                        sbQ22.append(i16);
                        sbQ22.append("], sampleSize: ");
                        sbQ22.append(i10);
                        sbQ22.append(", targetDensity: ");
                        sbQ22.append(options.inTargetDensity);
                        sbQ22.append(str2);
                        sbQ22.append(options.inDensity);
                        sbQ22.append(", density multiplier: ");
                        sbQ22.append(f2);
                        Log.v("Downsampler", sbQ22.toString());
                    }
                    i6 = iRound2;
                } else {
                    int i2922 = options.inTargetDensity;
                    if ((i2922 > 0 || (i11 = options.inDensity) <= 0 || i2922 == i11) ? z4 : z5) {
                    }
                    i10 = options.inSampleSize;
                    float f822 = i10;
                    int iCeil32 = (int) Math.ceil(i15 / f822);
                    int iCeil222 = (int) Math.ceil(i16 / f822);
                    iRound = Math.round(iCeil32 * f2);
                    iRound2 = Math.round(iCeil222 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sbQ222 = yg.q(iRound, iRound2, "Calculated target [", "x", "] for source [");
                        sbQ222.append(i15);
                        sbQ222.append("x");
                        sbQ222.append(i16);
                        sbQ222.append("], sampleSize: ");
                        sbQ222.append(i10);
                        sbQ222.append(", targetDensity: ");
                        sbQ222.append(options.inTargetDensity);
                        sbQ222.append(str2);
                        sbQ222.append(options.inDensity);
                        sbQ222.append(", density multiplier: ");
                        sbQ222.append(f2);
                        Log.v("Downsampler", sbQ222.toString());
                    }
                    i6 = iRound2;
                }
                ozVar2 = iRound <= 0 ? ozVar : ozVar;
                if (cviVar != null) {
                    if (i9 >= 28) {
                        options.inPreferredColorSpace = ColorSpace
                                .get(cviVar != cvi.a && (colorSpace = options.outColorSpace) != null
                                        && colorSpace.isWideGamut() ? ColorSpace.Named.DISPLAY_P3
                                                : ColorSpace.Named.SRGB);
                    } else {
                        options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    }
                }
                bitmapL = l(jxVar, options, appVar, ozVar2);
                appVar.l(bitmapL, ozVar2);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler",
                            "Decoded " + m(bitmapL) + " from [" + i15 + "x" + i16 + "] " + str + " with inBitmap "
                                    + m(options.inBitmap) + " for [" + i + "x" + i2 + "], sample size: "
                                    + options.inSampleSize + str2 + options.inDensity + str3 + options.inTargetDensity
                                    + ", thread: " + Thread.currentThread().getName() + ", duration: " + bxq.c(j));
                }
                if (bitmapL != null) {
                    return null;
                }
                bitmapL.setDensity(this.h.densityDpi);
                switch (i7) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        matrix = new Matrix();
                        switch (i7) {
                            case 2:
                                matrix.setScale(-1.0f, 1.0f);
                                break;
                            case 3:
                                matrix.setRotate(180.0f);
                                break;
                            case 4:
                                matrix.setRotate(180.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 5:
                                matrix.setRotate(90.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 6:
                                matrix.setRotate(90.0f);
                                break;
                            case 7:
                                matrix.setRotate(-90.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 8:
                                matrix.setRotate(-90.0f);
                                break;
                        }
                        bitmapL = Bitmap.createBitmap(bitmapL, 0, 0, bitmapL.getWidth(), bitmapL.getHeight(), matrix,
                                true);
                        bitmap = bitmapL;
                        break;
                    default:
                        bitmap = bitmapL;
                        break;
                }
                if (!bitmap.equals(bitmapL)) {
                    ozVar2.p(bitmap);
                }
                return bitmapL;
            case 12:
                j = jElapsedRealtimeNanos;
                str = str6;
                List list4 = (List) jxVar.h;
                cyp cypVar3 = (cyp) ((bmu) jxVar.e).h;
                cypVar3.reset();
                iY = bhv.y(list4, cypVar3, (bva) jxVar.f);
                switch (iY) {
                    case 3:
                    case 4:
                        i3 = 180;
                        break;
                    case 5:
                    case 6:
                        i3 = 90;
                        break;
                    case 7:
                    case 8:
                        i3 = 270;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                switch (iY) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        z3 = true;
                        break;
                    default:
                        z3 = false;
                        break;
                }
                if (i == Integer.MIN_VALUE) {
                    if (i3 != 90) {
                        i4 = 270;
                        if (i3 == 270) {
                            i5 = i15;
                        }
                    } else {
                        i4 = 270;
                    }
                    i5 = i16;
                } else {
                    i4 = 270;
                    i5 = i;
                }
                if (i2 == Integer.MIN_VALUE) {
                }
                imageHeaderParser$ImageTypeV = jxVar.v();
                i7 = iY;
                boolean z722 = z3;
                if (i15 > 0) {
                    str2 = ", density: ";
                    ozVar = ozVar3;
                    str3 = ", target density: ";
                    i8 = i5;
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeV
                                + " with target [" + i8 + "x" + i6 + "]");
                    }
                } else {
                    str2 = ", density: ";
                    ozVar = ozVar3;
                    str3 = ", target density: ";
                    i8 = i5;
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeV
                                + " with target [" + i8 + "x" + i6 + "]");
                    }
                }
                zK = this.k.k(i8, i6, z6, z722);
                if (zK) {
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    z4 = false;
                    options.inMutable = false;
                } else {
                    z4 = false;
                }
                if (zK) {
                    z5 = true;
                } else if (ajoVar != ajo.a) {
                    zHasAlpha = jxVar.v().hasAlpha();
                    if (zHasAlpha) {
                    }
                    options.inPreferredConfig = config;
                    if (config == Bitmap.Config.RGB_565) {
                        z5 = true;
                        options.inDither = true;
                    } else {
                        z5 = true;
                    }
                } else {
                    z5 = true;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
                i9 = Build.VERSION.SDK_INT;
                if (i15 >= 0) {
                    int i29222 = options.inTargetDensity;
                    if ((i29222 > 0 || (i11 = options.inDensity) <= 0 || i29222 == i11) ? z4 : z5) {
                    }
                    i10 = options.inSampleSize;
                    float f8222 = i10;
                    int iCeil322 = (int) Math.ceil(i15 / f8222);
                    int iCeil2222 = (int) Math.ceil(i16 / f8222);
                    iRound = Math.round(iCeil322 * f2);
                    iRound2 = Math.round(iCeil2222 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sbQ2222 = yg.q(iRound, iRound2, "Calculated target [", "x", "] for source [");
                        sbQ2222.append(i15);
                        sbQ2222.append("x");
                        sbQ2222.append(i16);
                        sbQ2222.append("], sampleSize: ");
                        sbQ2222.append(i10);
                        sbQ2222.append(", targetDensity: ");
                        sbQ2222.append(options.inTargetDensity);
                        sbQ2222.append(str2);
                        sbQ2222.append(options.inDensity);
                        sbQ2222.append(", density multiplier: ");
                        sbQ2222.append(f2);
                        Log.v("Downsampler", sbQ2222.toString());
                    }
                    i6 = iRound2;
                } else {
                    int i292222 = options.inTargetDensity;
                    if ((i292222 > 0 || (i11 = options.inDensity) <= 0 || i292222 == i11) ? z4 : z5) {
                    }
                    i10 = options.inSampleSize;
                    float f82222 = i10;
                    int iCeil3222 = (int) Math.ceil(i15 / f82222);
                    int iCeil22222 = (int) Math.ceil(i16 / f82222);
                    iRound = Math.round(iCeil3222 * f2);
                    iRound2 = Math.round(iCeil22222 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sbQ22222 = yg.q(iRound, iRound2, "Calculated target [", "x", "] for source [");
                        sbQ22222.append(i15);
                        sbQ22222.append("x");
                        sbQ22222.append(i16);
                        sbQ22222.append("], sampleSize: ");
                        sbQ22222.append(i10);
                        sbQ22222.append(", targetDensity: ");
                        sbQ22222.append(options.inTargetDensity);
                        sbQ22222.append(str2);
                        sbQ22222.append(options.inDensity);
                        sbQ22222.append(", density multiplier: ");
                        sbQ22222.append(f2);
                        Log.v("Downsampler", sbQ22222.toString());
                    }
                    i6 = iRound2;
                }
                if (iRound <= 0) {
                }
                if (cviVar != null) {
                    if (i9 >= 28) {
                        options.inPreferredColorSpace = ColorSpace
                                .get(cviVar != cvi.a && (colorSpace = options.outColorSpace) != null
                                        && colorSpace.isWideGamut() ? ColorSpace.Named.DISPLAY_P3
                                                : ColorSpace.Named.SRGB);
                    } else {
                        options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    }
                }
                bitmapL = l(jxVar, options, appVar, ozVar2);
                appVar.l(bitmapL, ozVar2);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler",
                            "Decoded " + m(bitmapL) + " from [" + i15 + "x" + i16 + "] " + str + " with inBitmap "
                                    + m(options.inBitmap) + " for [" + i + "x" + i2 + "], sample size: "
                                    + options.inSampleSize + str2 + options.inDensity + str3 + options.inTargetDensity
                                    + ", thread: " + Thread.currentThread().getName() + ", duration: " + bxq.c(j));
                }
                if (bitmapL != null) {
                    return null;
                }
                bitmapL.setDensity(this.h.densityDpi);
                switch (i7) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        matrix = new Matrix();
                        switch (i7) {
                            case 2:
                                matrix.setScale(-1.0f, 1.0f);
                                break;
                            case 3:
                                matrix.setRotate(180.0f);
                                break;
                            case 4:
                                matrix.setRotate(180.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 5:
                                matrix.setRotate(90.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 6:
                                matrix.setRotate(90.0f);
                                break;
                            case 7:
                                matrix.setRotate(-90.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 8:
                                matrix.setRotate(-90.0f);
                                break;
                        }
                        bitmapL = Bitmap.createBitmap(bitmapL, 0, 0, bitmapL.getWidth(), bitmapL.getHeight(), matrix,
                                true);
                        bitmap = bitmapL;
                        break;
                    default:
                        bitmap = bitmapL;
                        break;
                }
                if (!bitmap.equals(bitmapL)) {
                    ozVar2.p(bitmap);
                }
                return bitmapL;
            default:
                List list5 = (List) jxVar.f;
                j = jElapsedRealtimeNanos;
                com.bumptech.glide.load.data.a aVar = (com.bumptech.glide.load.data.a) jxVar.h;
                bva bvaVar3 = (bva) jxVar.e;
                int size2 = list5.size();
                str = str6;
                int i30 = 0;
                while (true) {
                    if (i30 < size2) {
                        int i31 = size2;
                        bog bogVar = (bog) list5.get(i30);
                        int i32 = i30;
                        try {
                            list = list5;
                            cypVar = new cyp(new FileInputStream(aVar.tryGetClassByName().getFileDescriptor()),
                                    bvaVar3);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            iM = bogVar.k(cypVar, bvaVar3);
                            cypVar.i();
                            aVar.tryGetClassByName();
                            if (iM != -1) {
                                iY = iM;
                            } else {
                                i30 = i32 + 1;
                                size2 = i31;
                                list5 = list;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cypVar2 = cypVar;
                            if (cypVar2 != null) {
                                cypVar2.i();
                            }
                            aVar.tryGetClassByName();
                            throw th;
                        }
                    } else {
                        iY = -1;
                    }
                    break;
                }
                switch (iY) {
                    case 3:
                    case 4:
                        i3 = 180;
                        break;
                    case 5:
                    case 6:
                        i3 = 90;
                        break;
                    case 7:
                    case 8:
                        i3 = 270;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                switch (iY) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        z3 = true;
                        break;
                    default:
                        z3 = false;
                        break;
                }
                if (i == Integer.MIN_VALUE) {
                    if (i3 != 90) {
                        i4 = 270;
                        if (i3 == 270) {
                            i5 = i15;
                        }
                    } else {
                        i4 = 270;
                    }
                    i5 = i16;
                } else {
                    i4 = 270;
                    i5 = i;
                }
                if (i2 == Integer.MIN_VALUE) {
                }
                imageHeaderParser$ImageTypeV = jxVar.v();
                i7 = iY;
                boolean z7222 = z3;
                if (i15 > 0) {
                    str2 = ", density: ";
                    ozVar = ozVar3;
                    str3 = ", target density: ";
                    i8 = i5;
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeV
                                + " with target [" + i8 + "x" + i6 + "]");
                    }
                } else {
                    str2 = ", density: ";
                    ozVar = ozVar3;
                    str3 = ", target density: ";
                    i8 = i5;
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageTypeV
                                + " with target [" + i8 + "x" + i6 + "]");
                    }
                }
                zK = this.k.k(i8, i6, z6, z7222);
                if (zK) {
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    z4 = false;
                    options.inMutable = false;
                } else {
                    z4 = false;
                }
                if (zK) {
                    z5 = true;
                } else if (ajoVar != ajo.a) {
                    zHasAlpha = jxVar.v().hasAlpha();
                    if (zHasAlpha) {
                    }
                    options.inPreferredConfig = config;
                    if (config == Bitmap.Config.RGB_565) {
                        z5 = true;
                        options.inDither = true;
                    } else {
                        z5 = true;
                    }
                } else {
                    z5 = true;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
                i9 = Build.VERSION.SDK_INT;
                if (i15 >= 0) {
                    int i2922222 = options.inTargetDensity;
                    if ((i2922222 > 0 || (i11 = options.inDensity) <= 0 || i2922222 == i11) ? z4 : z5) {
                    }
                    i10 = options.inSampleSize;
                    float f822222 = i10;
                    int iCeil32222 = (int) Math.ceil(i15 / f822222);
                    int iCeil222222 = (int) Math.ceil(i16 / f822222);
                    iRound = Math.round(iCeil32222 * f2);
                    iRound2 = Math.round(iCeil222222 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sbQ222222 = yg.q(iRound, iRound2, "Calculated target [", "x", "] for source [");
                        sbQ222222.append(i15);
                        sbQ222222.append("x");
                        sbQ222222.append(i16);
                        sbQ222222.append("], sampleSize: ");
                        sbQ222222.append(i10);
                        sbQ222222.append(", targetDensity: ");
                        sbQ222222.append(options.inTargetDensity);
                        sbQ222222.append(str2);
                        sbQ222222.append(options.inDensity);
                        sbQ222222.append(", density multiplier: ");
                        sbQ222222.append(f2);
                        Log.v("Downsampler", sbQ222222.toString());
                    }
                    i6 = iRound2;
                } else {
                    int i29222222 = options.inTargetDensity;
                    if ((i29222222 > 0 || (i11 = options.inDensity) <= 0 || i29222222 == i11) ? z4 : z5) {
                    }
                    i10 = options.inSampleSize;
                    float f8222222 = i10;
                    int iCeil322222 = (int) Math.ceil(i15 / f8222222);
                    int iCeil2222222 = (int) Math.ceil(i16 / f8222222);
                    iRound = Math.round(iCeil322222 * f2);
                    iRound2 = Math.round(iCeil2222222 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sbQ2222222 = yg.q(iRound, iRound2, "Calculated target [", "x", "] for source [");
                        sbQ2222222.append(i15);
                        sbQ2222222.append("x");
                        sbQ2222222.append(i16);
                        sbQ2222222.append("], sampleSize: ");
                        sbQ2222222.append(i10);
                        sbQ2222222.append(", targetDensity: ");
                        sbQ2222222.append(options.inTargetDensity);
                        sbQ2222222.append(str2);
                        sbQ2222222.append(options.inDensity);
                        sbQ2222222.append(", density multiplier: ");
                        sbQ2222222.append(f2);
                        Log.v("Downsampler", sbQ2222222.toString());
                    }
                    i6 = iRound2;
                }
                if (iRound <= 0) {
                }
                if (cviVar != null) {
                    if (i9 >= 28) {
                        options.inPreferredColorSpace = ColorSpace
                                .get(cviVar != cvi.a && (colorSpace = options.outColorSpace) != null
                                        && colorSpace.isWideGamut() ? ColorSpace.Named.DISPLAY_P3
                                                : ColorSpace.Named.SRGB);
                    } else {
                        options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    }
                }
                bitmapL = l(jxVar, options, appVar, ozVar2);
                appVar.l(bitmapL, ozVar2);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler",
                            "Decoded " + m(bitmapL) + " from [" + i15 + "x" + i16 + "] " + str + " with inBitmap "
                                    + m(options.inBitmap) + " for [" + i + "x" + i2 + "], sample size: "
                                    + options.inSampleSize + str2 + options.inDensity + str3 + options.inTargetDensity
                                    + ", thread: " + Thread.currentThread().getName() + ", duration: " + bxq.c(j));
                }
                if (bitmapL != null) {
                    return null;
                }
                bitmapL.setDensity(this.h.densityDpi);
                switch (i7) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        matrix = new Matrix();
                        switch (i7) {
                            case 2:
                                matrix.setScale(-1.0f, 1.0f);
                                break;
                            case 3:
                                matrix.setRotate(180.0f);
                                break;
                            case 4:
                                matrix.setRotate(180.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 5:
                                matrix.setRotate(90.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 6:
                                matrix.setRotate(90.0f);
                                break;
                            case 7:
                                matrix.setRotate(-90.0f);
                                matrix.postScale(-1.0f, 1.0f);
                                break;
                            case 8:
                                matrix.setRotate(-90.0f);
                                break;
                        }
                        bitmapL = Bitmap.createBitmap(bitmapL, 0, 0, bitmapL.getWidth(), bitmapL.getHeight(), matrix,
                                true);
                        bitmap = bitmapL;
                        break;
                    default:
                        bitmap = bitmapL;
                        break;
                }
                if (!bitmap.equals(bitmapL)) {
                    ozVar2.p(bitmap);
                }
                return bitmapL;
        }
    }
}
