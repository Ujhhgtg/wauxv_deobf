package me.hd.wauxv.obf;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import com.alibaba.fastjson2.JSONB;
import com.android.dx.io.Opcodes;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import net.bytebuddy.description.modifier.ModifierContributor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axl {
    public static final HashSet aa;
    public static final HashMap ab;
    public static final Charset ac;
    public static final byte[] ad;
    public static final byte[] ae;
    public static final String[] s;
    public static final int[] t;
    public static final byte[] u;
    public static final axi v;
    public static final axi[][] w;
    public static final axi[] x;
    public static final HashMap[] y;
    public static final HashMap[] z;
    public final FileDescriptor af;
    public final AssetManager.AssetInputStream ag;
    public int ah;
    public final HashMap[] ai;
    public final HashSet aj;
    public ByteOrder ak;
    public boolean al;
    public int am;
    public int an;
    public int ao;
    public int ap;
    public static final boolean a = Log.isLoggable("ExifInterface", 3);
    public static final List b = Arrays.asList(1, 6, 3, 8);
    public static final List c = Arrays.asList(2, 7, 4, 5);
    public static final int[] d = { 8, 8, 8 };
    public static final int[] e = { 8 };
    public static final byte[] f = { -1, JSONB.Constants.BC_INT64_NUM_MIN, -1 };
    public static final byte[] g = { 102, 116, JSONB.Constants.BC_STR_ASCII, 112 };
    public static final byte[] h = { JSONB.Constants.BC_STR_ASCII_FIX_36, JSONB.Constants.BC_STR_ASCII_FIX_32, 102,
            49 };
    public static final byte[] i = { 104, 101, JSONB.Constants.BC_STR_ASCII_FIX_32, 99 };
    public static final byte[] j = { 79, 76, 89, JSONB.Constants.BC_STR_ASCII_FIX_4, 80, 0 };
    public static final byte[] k = { 79, 76, 89, JSONB.Constants.BC_STR_ASCII_FIX_4, 80, 85, 83, 0, 73, 73 };
    public static final byte[] l = { -119, 80, JSONB.Constants.BC_STR_ASCII_FIX_5, JSONB.Constants.BC_INT32_SHORT_MAX,
            com.umeng.analytics.pro.dn.k, 10, 26, 10 };
    public static final byte[] m = { 101, 88, 73, 102 };
    public static final byte[] n = { 73, JSONB.Constants.BC_INT32, JSONB.Constants.BC_INT32_SHORT_ZERO, 82 };
    public static final byte[] o = { 73, 69, JSONB.Constants.BC_STR_ASCII_FIX_5, JSONB.Constants.BC_INT32_SHORT_ZERO };
    public static final byte[] p = { 82, 73, 70, 70 };
    public static final byte[] q = { 87, 69, 66, 80 };
    public static final byte[] r = { 69, 88, 73, 70 };

    static {
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        s = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT",
                "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
        t = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
        u = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
        axi[] axiVarArr = { new axi("NewSubfileType", Opcodes.CONST_METHOD_HANDLE, 4),
                new axi("SubfileType", Opcodes.CONST_METHOD_TYPE, 4), new axi("ImageWidth", 256, 3, 4),
                new axi("ImageLength", 257, 3, 4), new axi("BitsPerSample", 258, 3), new axi("Compression", 259, 3),
                new axi("PhotometricInterpretation", 262, 3), new axi("ImageDescription", 270, 2),
                new axi("Make", 271, 2), new axi("Model", 272, 2),
                new axi("StripOffsets", com.umeng.commonsdk.stateless.b.a, 3, 4), new axi("Orientation", 274, 3),
                new axi("SamplesPerPixel", 277, 3), new axi("RowsPerStrip", 278, 3, 4),
                new axi("StripByteCounts", 279, 3, 4), new axi("XResolution", 282, 5), new axi("YResolution", 283, 5),
                new axi("PlanarConfiguration", 284, 3), new axi("ResolutionUnit", 296, 3),
                new axi("TransferFunction", com.umeng.ccg.c.p, 3), new axi("Software", com.umeng.ccg.c.t, 2),
                new axi("DateTime", 306, 2), new axi("Artist", 315, 2), new axi("WhitePoint", 318, 5),
                new axi("PrimaryChromaticities", 319, 5), new axi("SubIFDPointer", 330, 4),
                new axi("JPEGInterchangeFormat", 513, 4), new axi("JPEGInterchangeFormatLength", 514, 4),
                new axi("YCbCrCoefficients", 529, 5), new axi("YCbCrSubSampling", 530, 3),
                new axi("YCbCrPositioning", 531, 3), new axi("ReferenceBlackWhite", 532, 5),
                new axi("Copyright", 33432, 2), new axi("ExifIFDPointer", 34665, 4),
                new axi("GPSInfoIFDPointer", 34853, 4), new axi("SensorTopBorder", 4, 4),
                new axi("SensorLeftBorder", 5, 4), new axi("SensorBottomBorder", 6, 4),
                new axi("SensorRightBorder", 7, 4), new axi("ISO", 23, 3), new axi("JpgFromRaw", 46, 7),
                new axi("Xmp", 700, 1) };
        axi[] axiVarArr2 = { new axi("ExposureTime", 33434, 5), new axi("FNumber", 33437, 5),
                new axi("ExposureProgram", 34850, 3), new axi("SpectralSensitivity", 34852, 2),
                new axi("PhotographicSensitivity", 34855, 3), new axi("OECF", 34856, 7),
                new axi("SensitivityType", 34864, 3), new axi("StandardOutputSensitivity", 34865, 4),
                new axi("RecommendedExposureIndex", 34866, 4), new axi("ISOSpeed", 34867, 4),
                new axi("ISOSpeedLatitudeyyy", 34868, 4), new axi("ISOSpeedLatitudezzz", 34869, 4),
                new axi("ExifVersion", 36864, 2), new axi("DateTimeOriginal", 36867, 2),
                new axi("DateTimeDigitized", 36868, 2), new axi("OffsetTime", ModifierContributor.ForParameter.MASK, 2),
                new axi("OffsetTimeOriginal", 36881, 2), new axi("OffsetTimeDigitized", 36882, 2),
                new axi("ComponentsConfiguration", 37121, 7), new axi("CompressedBitsPerPixel", 37122, 5),
                new axi("ShutterSpeedValue", 37377, 10), new axi("ApertureValue", 37378, 5),
                new axi("BrightnessValue", 37379, 10), new axi("ExposureBiasValue", 37380, 10),
                new axi("MaxApertureValue", 37381, 5), new axi("SubjectDistance", 37382, 5),
                new axi("MeteringMode", 37383, 3), new axi("LightSource", 37384, 3), new axi("Flash", 37385, 3),
                new axi("FocalLength", 37386, 5), new axi("SubjectArea", 37396, 3), new axi("MakerNote", 37500, 7),
                new axi("UserComment", 37510, 7), new axi("SubSecTime", 37520, 2),
                new axi("SubSecTimeOriginal", 37521, 2), new axi("SubSecTimeDigitized", 37522, 2),
                new axi("FlashpixVersion", 40960, 7), new axi("ColorSpace", 40961, 3),
                new axi("PixelXDimension", 40962, 3, 4), new axi("PixelYDimension", 40963, 3, 4),
                new axi("RelatedSoundFile", 40964, 2), new axi("InteroperabilityIFDPointer", 40965, 4),
                new axi("FlashEnergy", 41483, 5), new axi("SpatialFrequencyResponse", 41484, 7),
                new axi("FocalPlaneXResolution", 41486, 5), new axi("FocalPlaneYResolution", 41487, 5),
                new axi("FocalPlaneResolutionUnit", 41488, 3), new axi("SubjectLocation", 41492, 3),
                new axi("ExposureIndex", 41493, 5), new axi("SensingMethod", 41495, 3), new axi("FileSource", 41728, 7),
                new axi("SceneType", 41729, 7), new axi("CFAPattern", 41730, 7), new axi("CustomRendered", 41985, 3),
                new axi("ExposureMode", 41986, 3), new axi("WhiteBalance", 41987, 3),
                new axi("DigitalZoomRatio", 41988, 5), new axi("FocalLengthIn35mmFilm", 41989, 3),
                new axi("SceneCaptureType", 41990, 3), new axi("GainControl", 41991, 3), new axi("Contrast", 41992, 3),
                new axi("Saturation", 41993, 3), new axi("Sharpness", 41994, 3),
                new axi("DeviceSettingDescription", 41995, 7), new axi("SubjectDistanceRange", 41996, 3),
                new axi("ImageUniqueID", 42016, 2), new axi("CameraOwnerName", 42032, 2),
                new axi("BodySerialNumber", 42033, 2), new axi("LensSpecification", 42034, 5),
                new axi("LensMake", 42035, 2), new axi("LensModel", 42036, 2), new axi("Gamma", 42240, 5),
                new axi("DNGVersion", 50706, 1), new axi("DefaultCropSize", 50720, 3, 4) };
        axi[] axiVarArr3 = { new axi("GPSVersionID", 0, 1), new axi("GPSLatitudeRef", 1, 2),
                new axi("GPSLatitude", 2, 5, 10), new axi("GPSLongitudeRef", 3, 2), new axi("GPSLongitude", 4, 5, 10),
                new axi("GPSAltitudeRef", 5, 1), new axi("GPSAltitude", 6, 5), new axi("GPSTimeStamp", 7, 5),
                new axi("GPSSatellites", 8, 2), new axi("GPSStatus", 9, 2), new axi("GPSMeasureMode", 10, 2),
                new axi("GPSDOP", 11, 5), new axi("GPSSpeedRef", 12, 2), new axi("GPSSpeed", 13, 5),
                new axi("GPSTrackRef", 14, 2), new axi("GPSTrack", 15, 5), new axi("GPSImgDirectionRef", 16, 2),
                new axi("GPSImgDirection", 17, 5), new axi("GPSMapDatum", 18, 2), new axi("GPSDestLatitudeRef", 19, 2),
                new axi("GPSDestLatitude", 20, 5), new axi("GPSDestLongitudeRef", 21, 2),
                new axi("GPSDestLongitude", 22, 5), new axi("GPSDestBearingRef", 23, 2),
                new axi("GPSDestBearing", 24, 5), new axi("GPSDestDistanceRef", 25, 2),
                new axi("GPSDestDistance", 26, 5), new axi("GPSProcessingMethod", 27, 7),
                new axi("GPSAreaInformation", 28, 7), new axi("GPSDateStamp", 29, 2), new axi("GPSDifferential", 30, 3),
                new axi("GPSHPositioningError", 31, 5) };
        axi[] axiVarArr4 = { new axi("InteroperabilityIndex", 1, 2) };
        axi[] axiVarArr5 = { new axi("NewSubfileType", Opcodes.CONST_METHOD_HANDLE, 4),
                new axi("SubfileType", Opcodes.CONST_METHOD_TYPE, 4), new axi("ThumbnailImageWidth", 256, 3, 4),
                new axi("ThumbnailImageLength", 257, 3, 4), new axi("BitsPerSample", 258, 3),
                new axi("Compression", 259, 3), new axi("PhotometricInterpretation", 262, 3),
                new axi("ImageDescription", 270, 2), new axi("Make", 271, 2), new axi("Model", 272, 2),
                new axi("StripOffsets", com.umeng.commonsdk.stateless.b.a, 3, 4),
                new axi("ThumbnailOrientation", 274, 3), new axi("SamplesPerPixel", 277, 3),
                new axi("RowsPerStrip", 278, 3, 4), new axi("StripByteCounts", 279, 3, 4),
                new axi("XResolution", 282, 5), new axi("YResolution", 283, 5), new axi("PlanarConfiguration", 284, 3),
                new axi("ResolutionUnit", 296, 3), new axi("TransferFunction", com.umeng.ccg.c.p, 3),
                new axi("Software", com.umeng.ccg.c.t, 2), new axi("DateTime", 306, 2), new axi("Artist", 315, 2),
                new axi("WhitePoint", 318, 5), new axi("PrimaryChromaticities", 319, 5),
                new axi("SubIFDPointer", 330, 4), new axi("JPEGInterchangeFormat", 513, 4),
                new axi("JPEGInterchangeFormatLength", 514, 4), new axi("YCbCrCoefficients", 529, 5),
                new axi("YCbCrSubSampling", 530, 3), new axi("YCbCrPositioning", 531, 3),
                new axi("ReferenceBlackWhite", 532, 5), new axi("Copyright", 33432, 2),
                new axi("ExifIFDPointer", 34665, 4), new axi("GPSInfoIFDPointer", 34853, 4),
                new axi("DNGVersion", 50706, 1), new axi("DefaultCropSize", 50720, 3, 4) };
        v = new axi("StripOffsets", com.umeng.commonsdk.stateless.b.a, 3);
        w = new axi[][] { axiVarArr, axiVarArr2, axiVarArr3, axiVarArr4, axiVarArr5, axiVarArr,
                new axi[] { new axi("ThumbnailImage", 256, 7), new axi("CameraSettingsIFDPointer", 8224, 4),
                        new axi("ImageProcessingIFDPointer", 8256, 4) },
                new axi[] { new axi("PreviewImageStart", 257, 4), new axi("PreviewImageLength", 258, 4) },
                new axi[] { new axi("AspectFrame", 4371, 3) }, new axi[] { new axi("ColorSpace", 55, 3) } };
        x = new axi[] { new axi("SubIFDPointer", 330, 4), new axi("ExifIFDPointer", 34665, 4),
                new axi("GPSInfoIFDPointer", 34853, 4), new axi("InteroperabilityIFDPointer", 40965, 4),
                new axi("CameraSettingsIFDPointer", 8224, 1), new axi("ImageProcessingIFDPointer", 8256, 1) };
        y = new HashMap[10];
        z = new HashMap[10];
        aa = new HashSet(
                Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        ab = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        ac = charsetForName;
        ad = "Exif\u0000\u0000".getBytes(charsetForName);
        ae = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            axi[][] axiVarArr6 = w;
            if (i2 >= axiVarArr6.length) {
                HashMap map = ab;
                axi[] axiVarArr7 = x;
                map.put(Integer.valueOf(axiVarArr7[0].a), 5);
                map.put(Integer.valueOf(axiVarArr7[1].a), 1);
                map.put(Integer.valueOf(axiVarArr7[2].a), 2);
                map.put(Integer.valueOf(axiVarArr7[3].a), 3);
                map.put(Integer.valueOf(axiVarArr7[4].a), 7);
                map.put(Integer.valueOf(axiVarArr7[5].a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            y[i2] = new HashMap();
            z[i2] = new HashMap();
            for (axi axiVar : axiVarArr6[i2]) {
                y[i2].put(Integer.valueOf(axiVar.a), axiVar);
                z[i2].put(axiVar.b, axiVar);
            }
            i2++;
        }
    }

    /*
     * JADX WARN: Found duplicated region for block: B:53:0x00d8 A[Catch: all ->
     * 0x005e, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x005e, blocks:
     * (B:14:0x004f, B:16:0x0052, B:23:0x0067, B:29:0x0084, B:31:0x008f,
     * B:39:0x00a5, B:34:0x0096, B:37:0x009e, B:38:0x00a2, B:40:0x00af, B:42:0x00b8,
     * B:44:0x00be, B:46:0x00c4, B:48:0x00ca, B:53:0x00d8), top: B:65:0x004f }]
     */
    /* JADX WARN: Found duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    public axl(InputStream inputStream) throws IOException {
        axi[][] axiVarArr = w;
        this.ai = new HashMap[axiVarArr.length];
        this.aj = new HashSet(axiVarArr.length);
        this.ak = ByteOrder.BIG_ENDIAN;
        boolean z2 = inputStream instanceof AssetManager.AssetInputStream;
        boolean z3 = a;
        if (z2) {
            this.ag = (AssetManager.AssetInputStream) inputStream;
            this.af = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            try {
                axn.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                this.ag = null;
                this.af = fileInputStream.getFD();
            } catch (Exception unused) {
                if (z3) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                this.ag = null;
                this.af = null;
            }
        } else {
            this.ag = null;
            this.af = null;
        }
        for (int i2 = 0; i2 < axiVarArr.length; i2++) {
            try {
                try {
                    this.ai[i2] = new HashMap();
                } catch (Throwable th) {
                    ar();
                    if (z3) {
                        bg();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                if (z3) {
                    Log.w("ExifInterface",
                            "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.",
                            e);
                }
                ar();
                if (!z3) {
                    return;
                }
            } catch (UnsupportedOperationException e3) {
                e = e3;
                if (z3) {
                    Log.w("ExifInterface",
                            "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.",
                            e);
                }
                ar();
                if (!z3) {
                    return;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        int iAw = aw(bufferedInputStream);
        this.ah = iAw;
        if (iAw == 4 || iAw == 9 || iAw == 13 || iAw == 14) {
            axg axgVar = new axg(bufferedInputStream);
            int i3 = this.ah;
            if (i3 == 4) {
                av(axgVar, 0, 0);
            } else if (i3 == 13) {
                ay(axgVar);
            } else if (i3 == 9) {
                az(axgVar);
            } else if (i3 == 14) {
                bc(axgVar);
            }
        } else {
            axk axkVar = new axk(bufferedInputStream);
            int i4 = this.ah;
            if (i4 == 12) {
                au(axkVar);
            } else if (i4 == 7) {
                ax(axkVar);
            } else if (i4 == 10) {
                bb(axkVar);
            } else {
                ba(axkVar);
            }
            axkVar.h(this.am);
            bk(axkVar);
        }
        ar();
        if (!z3) {
            return;
        }
        bg();
    }

    public static ByteOrder aq(axg axgVar) throws IOException {
        short s2 = axgVar.readShort();
        boolean z2 = a;
        if (s2 == 18761) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    public final void ar() {
        String strAs = as("DateTimeOriginal");
        HashMap[] mapArr = this.ai;
        if (strAs != null && as("DateTime") == null) {
            HashMap map = mapArr[0];
            byte[] bytes = strAs.concat("\u0000").getBytes(ac);
            map.put("DateTime", new axh(2, bytes.length, bytes));
        }
        if (as("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", axh.e(0L, this.ak));
        }
        if (as("ImageLength") == null) {
            mapArr[0].put("ImageLength", axh.e(0L, this.ak));
        }
        if (as("Orientation") == null) {
            mapArr[0].put("Orientation", axh.e(0L, this.ak));
        }
        if (as("LightSource") == null) {
            mapArr[1].put("LightSource", axh.e(0L, this.ak));
        }
    }

    public final String as(String str) {
        axh axhVarAt = at(str);
        if (axhVarAt != null) {
            int i2 = axhVarAt.a;
            if (!aa.contains(str)) {
                return axhVarAt.j(this.ak);
            }
            if (str.equals("GPSTimeStamp")) {
                if (i2 != 5 && i2 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i2);
                    return null;
                }
                axj[] axjVarArr = (axj[]) axhVarAt.k(this.ak);
                if (axjVarArr == null || axjVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(axjVarArr));
                    return null;
                }
                axj axjVar = axjVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (axjVar.a / axjVar.b));
                axj axjVar2 = axjVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (axjVar2.a / axjVar2.b));
                axj axjVar3 = axjVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2,
                        Integer.valueOf((int) (axjVar3.a / axjVar3.b)));
            }
            try {
                return Double.toString(axhVarAt.h(this.ak));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final axh at(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            if (a) {
                Log.d("ExifInterface",
                        "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < w.length; i2++) {
            axh axhVar = (axh) this.ai[i2].get(str);
            if (axhVar != null) {
                return axhVar;
            }
        }
        return null;
    }

    public final void au(axk axkVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                axo.a(mediaMetadataRetriever, new axf(axkVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.ai;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", axh.g(Integer.parseInt(strExtractMetadata), this.ak));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", axh.g(Integer.parseInt(strExtractMetadata2), this.ak));
                }
                if (strExtractMetadata3 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata3);
                    mapArr[0].put("Orientation", axh.g(i2 != 90 ? i2 != 180 ? i2 != 270 ? 1 : 8 : 3 : 6, this.ak));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata4);
                    int i4 = Integer.parseInt(strExtractMetadata5);
                    if (i4 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    axkVar.h(i3);
                    byte[] bArr = new byte[6];
                    if (axkVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i5 = i3 + 6;
                    int i6 = i4 - 6;
                    if (!Arrays.equals(bArr, ad)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    if (axkVar.read(bArr2) != i6) {
                        throw new IOException("Can't read exif");
                    }
                    this.am = i5;
                    bh(0, bArr2);
                }
                if (a) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2
                            + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException(
                        "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:103:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:104:0x018a A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:34:0x00ac A[FALL_THROUGH] */
    /* JADX WARN: Found duplicated region for block: B:36:0x00b3 */
    /* JADX WARN: Found duplicated region for block: B:37:0x00b6 */
    /* JADX WARN: Found duplicated region for block: B:40:0x00ca */
    /* JADX WARN: Found duplicated region for block: B:41:0x00cd */
    /* JADX WARN: Found duplicated region for block: B:71:0x013f */
    /*
     * JADX WARN: Found duplicated region for block: B:74:0x0146 A[LOOP:2:
     * B:69:0x013c->B:74:0x0146, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:77:0x0158 A[MOVE_INLINED] */
    /*
     * JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
     * java.lang.UnsupportedOperationException
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:
     * 1068)
     * at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(
     * SwitchRegionMaker.java:419)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:70)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(
     * DepthRegionTraversal.java:23)
     * at
     * jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(
     * SwitchRegionMaker.java:399)
     * at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(
     * SwitchRegionMaker.java:89)
     * at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(
     * PostProcessRegions.java:33)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:70)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(
     * DepthRegionTraversal.java:19)
     * at
     * jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.
     * java:23)
     * at
     * jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.
     * java:31)
     */
    public final void av(me.hd.wauxv.obf.axg r23, int r24, int r25) throws java.lang.Throwable {
        /*
         * Method dump skipped, instruction units count: 540
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.axl.av(me.hd.wauxv.obf.axg, int, int):void");
    }

    /* JADX WARN: Found duplicated region for block: B:110:0x0143 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:112:0x0146 */
    /* JADX WARN: Found duplicated region for block: B:115:0x014d */
    /*
     * JADX WARN: Found duplicated region for block: B:118:0x0156 A[LOOP:2:
     * B:113:0x0148->B:118:0x0156, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:121:0x015c A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:123:0x015f */
    /* JADX WARN: Found duplicated region for block: B:126:0x0166 */
    /*
     * JADX WARN: Found duplicated region for block: B:129:0x016f A[LOOP:3:
     * B:124:0x0161->B:129:0x016f, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:133:0x0179 */
    /*
     * JADX WARN: Found duplicated region for block: B:136:0x0183 A[LOOP:4:
     * B:131:0x0174->B:136:0x0183, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:138:0x0188 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:140:0x018b A[RETURN] */
    /*
     * JADX WARN: Found duplicated region for block: B:156:0x010d
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:168:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:169:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:170:0x0172 A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:171:0x016c A[EDGE_INSN:
     * B:171:0x016c->B:128:0x016c BREAK A[LOOP:3: B:124:0x0161->B:129:0x016f],
     * SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:172:0x0186 A[EDGE_INSN:
     * B:172:0x0186->B:137:0x0186 BREAK A[LOOP:4: B:131:0x0174->B:136:0x0183],
     * SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:173:0x016c A[EDGE_INSN:
     * B:173:0x016c->B:128:0x016c BREAK A[LOOP:3: B:124:0x0161->B:129:0x016f],
     * SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:70:0x00e7 */
    /* JADX WARN: Found duplicated region for block: B:74:0x00ef */
    /* JADX WARN: Found duplicated region for block: B:88:0x010b A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:94:0x0122 */
    /* JADX WARN: Found duplicated region for block: B:95:0x0124 */
    public final int aw(BufferedInputStream bufferedInputStream) throws Throwable {
        axg axgVar;
        int i2;
        axg axgVar2;
        axg axgVar3;
        axg axgVar4;
        int i3;
        axg axgVar5;
        axg axgVar6;
        int i4;
        int i5;
        byte[] bArr;
        int i6;
        int i7;
        byte[] bArr2;
        int i8;
        byte[] bArr3;
        axg axgVar7;
        long j2;
        byte[] bArr4;
        long j3;
        bufferedInputStream.mark(5000);
        byte[] bArr5 = new byte[5000];
        bufferedInputStream.read(bArr5);
        bufferedInputStream.reset();
        int i9 = 0;
        while (true) {
            byte[] bArr6 = f;
            if (i9 >= bArr6.length) {
                return 4;
            }
            if (bArr5[i9] != bArr6[i9]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i10 = 0; i10 < bytes.length; i10++) {
                    if (bArr5[i10] != bytes[i10]) {
                        int i11 = 1;
                        try {
                            axgVar2 = new axg(bArr5);
                            try {
                                try {
                                    j2 = axgVar2.readInt();
                                    bArr4 = new byte[4];
                                    axgVar2.read(bArr4);
                                    axgVar2.close();
                                    i2 = 0;
                                } catch (Exception e2) {
                                    e = e2;
                                    i2 = 0;
                                }
                            } catch (Throwable th) {
                                th = th;
                                axgVar = axgVar2;
                                if (axgVar != null) {
                                    axgVar.close();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            i2 = 0;
                            axgVar2 = null;
                        } catch (Throwable th2) {
                            th = th2;
                            axgVar = null;
                        }
                        if (Arrays.equals(bArr4, g)) {
                            if (j2 == 1) {
                                j2 = axgVar2.readLong();
                                j3 = 16;
                                if (j2 < 16) {
                                }
                                axgVar4 = new axg(bArr5);
                                ByteOrder byteOrderAq = aq(axgVar4);
                                this.ak = byteOrderAq;
                                axgVar4.d = byteOrderAq;
                                short s2 = axgVar4.readShort();
                                i3 = (s2 != 20306 || s2 == 21330) ? 1 : i2;
                                axgVar4.close();
                                if (i3 != 0) {
                                    return 7;
                                }
                                try {
                                    axgVar7 = new axg(bArr5);
                                    try {
                                        ByteOrder byteOrderAq2 = aq(axgVar7);
                                        this.ak = byteOrderAq2;
                                        axgVar7.d = byteOrderAq2;
                                        i4 = axgVar7.readShort() == 85 ? 1 : i2;
                                        axgVar7.close();
                                    } catch (Exception unused) {
                                        axgVar6 = axgVar7;
                                        if (axgVar6 != null) {
                                            axgVar6.close();
                                        }
                                        i4 = i2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        axgVar5 = axgVar7;
                                        if (axgVar5 != null) {
                                            axgVar5.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception unused2) {
                                    axgVar6 = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    axgVar5 = null;
                                }
                                if (i4 != 0) {
                                    return 10;
                                }
                                i5 = i2;
                                while (true) {
                                    bArr = l;
                                    if (i5 < bArr.length) {
                                        i6 = 1;
                                        break;
                                    }
                                    if (bArr5[i5] != bArr[i5]) {
                                        i6 = i2;
                                        break;
                                    }
                                    i5++;
                                }
                                if (i6 != 0) {
                                    return 13;
                                }
                                i7 = i2;
                                while (true) {
                                    bArr2 = p;
                                    if (i7 < bArr2.length) {
                                        i8 = i2;
                                        while (true) {
                                            bArr3 = q;
                                            if (i8 >= bArr3.length) {
                                                break;
                                            }
                                            if (bArr5[bArr2.length + i8 + 4] != bArr3[i8]) {
                                                break;
                                            }
                                            i8++;
                                        }
                                        if (i11 != 0) {
                                            return 14;
                                        }
                                        return i2;
                                    }
                                    if (bArr5[i7] != bArr2[i7]) {
                                        break;
                                    }
                                    i7++;
                                }
                                i11 = i2;
                                if (i11 != 0) {
                                    return 14;
                                }
                                return i2;
                            }
                            j3 = 8;
                            i2 = 0;
                            long j4 = 5000;
                            if (j2 > j4) {
                                j2 = j4;
                            }
                            long j5 = j2 - j3;
                            if (j5 >= 8) {
                                try {
                                    byte[] bArr7 = new byte[4];
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    for (long j6 = 0; j6 < j5 / 4 && axgVar2.read(bArr7) == 4; j6++) {
                                        if (j6 != 1) {
                                            if (Arrays.equals(bArr7, h)) {
                                                z2 = true;
                                            } else if (Arrays.equals(bArr7, i)) {
                                                z3 = true;
                                            }
                                            if (z2 && z3) {
                                                axgVar2.close();
                                                return 12;
                                            }
                                        }
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    if (a) {
                                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                                    }
                                    if (axgVar2 != null) {
                                    }
                                    axgVar4 = new axg(bArr5);
                                    ByteOrder byteOrderAq3 = aq(axgVar4);
                                    this.ak = byteOrderAq3;
                                    axgVar4.d = byteOrderAq3;
                                    short s22 = axgVar4.readShort();
                                    if (s22 != 20306) {
                                    }
                                    axgVar4.close();
                                    if (i3 != 0) {
                                        return 7;
                                    }
                                    axgVar7 = new axg(bArr5);
                                    ByteOrder byteOrderAq22 = aq(axgVar7);
                                    this.ak = byteOrderAq22;
                                    axgVar7.d = byteOrderAq22;
                                    if (axgVar7.readShort() == 85) {
                                    }
                                    axgVar7.close();
                                    if (i4 != 0) {
                                        return 10;
                                    }
                                    i5 = i2;
                                    while (true) {
                                        bArr = l;
                                        if (i5 < bArr.length) {
                                            i6 = 1;
                                            break;
                                        }
                                        if (bArr5[i5] != bArr[i5]) {
                                            i6 = i2;
                                            break;
                                        }
                                        i5++;
                                    }
                                    if (i6 != 0) {
                                        return 13;
                                    }
                                    i7 = i2;
                                    while (true) {
                                        bArr2 = p;
                                        if (i7 < bArr2.length) {
                                            i8 = i2;
                                            while (true) {
                                                bArr3 = q;
                                                if (i8 >= bArr3.length) {
                                                    break;
                                                    break;
                                                }
                                                if (bArr5[bArr2.length + i8 + 4] != bArr3[i8]) {
                                                    break;
                                                    break;
                                                }
                                                i8++;
                                            }
                                            if (i11 != 0) {
                                                return 14;
                                            }
                                            return i2;
                                        }
                                        if (bArr5[i7] != bArr2[i7]) {
                                            break;
                                            break;
                                        }
                                        i7++;
                                    }
                                    i11 = i2;
                                    if (i11 != 0) {
                                        return 14;
                                    }
                                    return i2;
                                }
                            }
                            axgVar2.close();
                            axgVar4 = new axg(bArr5);
                            try {
                                ByteOrder byteOrderAq32 = aq(axgVar4);
                                this.ak = byteOrderAq32;
                                axgVar4.d = byteOrderAq32;
                                short s222 = axgVar4.readShort();
                                if (s222 != 20306) {
                                }
                                axgVar4.close();
                            } catch (Exception unused3) {
                                if (axgVar4 != null) {
                                    axgVar4.close();
                                }
                                i3 = i2;
                            } catch (Throwable th5) {
                                th = th5;
                                axgVar3 = axgVar4;
                                if (axgVar3 != null) {
                                    axgVar3.close();
                                }
                                throw th;
                            }
                            if (i3 != 0) {
                                return 7;
                            }
                            axgVar7 = new axg(bArr5);
                            ByteOrder byteOrderAq222 = aq(axgVar7);
                            this.ak = byteOrderAq222;
                            axgVar7.d = byteOrderAq222;
                            if (axgVar7.readShort() == 85) {
                            }
                            axgVar7.close();
                            if (i4 != 0) {
                                return 10;
                            }
                            i5 = i2;
                            while (true) {
                                bArr = l;
                                if (i5 < bArr.length) {
                                    i6 = 1;
                                    break;
                                }
                                if (bArr5[i5] != bArr[i5]) {
                                    i6 = i2;
                                    break;
                                }
                                i5++;
                            }
                            if (i6 != 0) {
                                return 13;
                            }
                            i7 = i2;
                            while (true) {
                                bArr2 = p;
                                if (i7 < bArr2.length) {
                                    i8 = i2;
                                    while (true) {
                                        bArr3 = q;
                                        if (i8 >= bArr3.length) {
                                            break;
                                            break;
                                        }
                                        if (bArr5[bArr2.length + i8 + 4] != bArr3[i8]) {
                                            break;
                                            break;
                                        }
                                        i8++;
                                    }
                                    if (i11 != 0) {
                                        return 14;
                                    }
                                    return i2;
                                }
                                if (bArr5[i7] != bArr2[i7]) {
                                    break;
                                    break;
                                }
                                i7++;
                            }
                            i11 = i2;
                            if (i11 != 0) {
                                return 14;
                            }
                            return i2;
                        }
                        try {
                            axgVar4 = new axg(bArr5);
                            ByteOrder byteOrderAq322 = aq(axgVar4);
                            this.ak = byteOrderAq322;
                            axgVar4.d = byteOrderAq322;
                            short s2222 = axgVar4.readShort();
                            if (s2222 != 20306) {
                            }
                            axgVar4.close();
                        } catch (Exception unused4) {
                            axgVar4 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            axgVar3 = null;
                        }
                        if (i3 != 0) {
                            return 7;
                        }
                        axgVar7 = new axg(bArr5);
                        ByteOrder byteOrderAq2222 = aq(axgVar7);
                        this.ak = byteOrderAq2222;
                        axgVar7.d = byteOrderAq2222;
                        if (axgVar7.readShort() == 85) {
                        }
                        axgVar7.close();
                        if (i4 != 0) {
                            return 10;
                        }
                        i5 = i2;
                        while (true) {
                            bArr = l;
                            if (i5 < bArr.length) {
                                i6 = 1;
                                break;
                            }
                            if (bArr5[i5] != bArr[i5]) {
                                i6 = i2;
                                break;
                            }
                            i5++;
                        }
                        if (i6 != 0) {
                            return 13;
                        }
                        i7 = i2;
                        while (true) {
                            bArr2 = p;
                            if (i7 < bArr2.length) {
                                i8 = i2;
                                while (true) {
                                    bArr3 = q;
                                    if (i8 >= bArr3.length) {
                                        break;
                                        break;
                                    }
                                    if (bArr5[bArr2.length + i8 + 4] != bArr3[i8]) {
                                        break;
                                        break;
                                    }
                                    i8++;
                                }
                                if (i11 != 0) {
                                    return 14;
                                }
                                return i2;
                            }
                            if (bArr5[i7] != bArr2[i7]) {
                                break;
                                break;
                            }
                            i7++;
                        }
                        i11 = i2;
                        if (i11 != 0) {
                            return 14;
                        }
                        return i2;
                    }
                }
                return 9;
            }
            i9++;
        }
    }

    public final void ax(axk axkVar) throws Throwable {
        int i2;
        int i3;
        ba(axkVar);
        HashMap[] mapArr = this.ai;
        axh axhVar = (axh) mapArr[1].get("MakerNote");
        if (axhVar != null) {
            axk axkVar2 = new axk(axhVar.d);
            axkVar2.d = this.ak;
            byte[] bArr = j;
            byte[] bArr2 = new byte[bArr.length];
            axkVar2.readFully(bArr2);
            axkVar2.h(0L);
            byte[] bArr3 = k;
            byte[] bArr4 = new byte[bArr3.length];
            axkVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                axkVar2.h(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                axkVar2.h(12L);
            }
            bi(axkVar2, 6);
            axh axhVar2 = (axh) mapArr[7].get("PreviewImageStart");
            axh axhVar3 = (axh) mapArr[7].get("PreviewImageLength");
            if (axhVar2 != null && axhVar3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", axhVar2);
                mapArr[5].put("JPEGInterchangeFormatLength", axhVar3);
            }
            axh axhVar4 = (axh) mapArr[8].get("AspectFrame");
            if (axhVar4 != null) {
                int[] iArr = (int[]) axhVar4.k(this.ak);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i4 = iArr[2];
                int i5 = iArr[0];
                if (i4 <= i5 || (i2 = iArr[3]) <= (i3 = iArr[1])) {
                    return;
                }
                int i6 = (i4 - i5) + 1;
                int i7 = (i2 - i3) + 1;
                if (i6 < i7) {
                    int i8 = i6 + i7;
                    i7 = i8 - i7;
                    i6 = i8 - i7;
                }
                axh axhVarG = axh.g(i6, this.ak);
                axh axhVarG2 = axh.g(i7, this.ak);
                mapArr[0].put("ImageWidth", axhVarG);
                mapArr[0].put("ImageLength", axhVarG2);
            }
        }
    }

    public final void ay(axg axgVar) throws Throwable {
        if (a) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + axgVar);
        }
        axgVar.d = ByteOrder.BIG_ENDIAN;
        byte[] bArr = l;
        axgVar.g(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i2 = axgVar.readInt();
                byte[] bArr2 = new byte[4];
                if (axgVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i3 = length + 8;
                if (i3 == 16 && !Arrays.equals(bArr2, n)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, o)) {
                    return;
                }
                if (Arrays.equals(bArr2, m)) {
                    byte[] bArr3 = new byte[i2];
                    if (axgVar.read(bArr3) != i2) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + bhs.l(bArr2));
                    }
                    int i4 = axgVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i4) {
                        this.am = i3;
                        bh(0, bArr3);
                        bn();
                        bk(new axg(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: "
                            + i4 + ", calculated CRC value: " + crc32.getValue());
                }
                int i5 = i2 + 4;
                axgVar.g(i5);
                length = i3 + i5;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void az(axg axgVar) throws Throwable {
        boolean z2 = a;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + axgVar);
        }
        axgVar.g(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        axgVar.read(bArr);
        axgVar.read(bArr2);
        axgVar.read(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        axgVar.g(i2 - axgVar.e);
        axgVar.read(bArr4);
        av(new axg(bArr4), i2, 5);
        axgVar.g(i4 - axgVar.e);
        axgVar.d = ByteOrder.BIG_ENDIAN;
        int i5 = axgVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i5);
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int unsignedShort = axgVar.readUnsignedShort();
            int unsignedShort2 = axgVar.readUnsignedShort();
            if (unsignedShort == v.a) {
                short s2 = axgVar.readShort();
                short s3 = axgVar.readShort();
                axh axhVarG = axh.g(s2, this.ak);
                axh axhVarG2 = axh.g(s3, this.ak);
                HashMap[] mapArr = this.ai;
                mapArr[0].put("ImageLength", axhVarG);
                mapArr[0].put("ImageWidth", axhVarG2);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s2) + ", width: " + ((int) s3));
                    return;
                }
                return;
            }
            axgVar.g(unsignedShort2);
        }
    }

    public final void ba(axk axkVar) throws Throwable {
        bf(axkVar);
        bi(axkVar, 0);
        bm(axkVar, 0);
        bm(axkVar, 5);
        bm(axkVar, 4);
        bn();
        if (this.ah == 8) {
            HashMap[] mapArr = this.ai;
            axh axhVar = (axh) mapArr[1].get("MakerNote");
            if (axhVar != null) {
                axk axkVar2 = new axk(axhVar.d);
                axkVar2.d = this.ak;
                axkVar2.g(6);
                bi(axkVar2, 9);
                axh axhVar2 = (axh) mapArr[9].get("ColorSpace");
                if (axhVar2 != null) {
                    mapArr[1].put("ColorSpace", axhVar2);
                }
            }
        }
    }

    public final void bb(axk axkVar) throws Throwable {
        if (a) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + axkVar);
        }
        ba(axkVar);
        HashMap[] mapArr = this.ai;
        axh axhVar = (axh) mapArr[0].get("JpgFromRaw");
        if (axhVar != null) {
            av(new axg(axhVar.d), (int) axhVar.c, 5);
        }
        axh axhVar2 = (axh) mapArr[0].get("ISO");
        axh axhVar3 = (axh) mapArr[1].get("PhotographicSensitivity");
        if (axhVar2 == null || axhVar3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", axhVar2);
    }

    public final void bc(axg axgVar) throws Throwable {
        if (a) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + axgVar);
        }
        axgVar.d = ByteOrder.LITTLE_ENDIAN;
        axgVar.g(p.length);
        int i2 = axgVar.readInt() + 8;
        byte[] bArr = q;
        axgVar.g(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (axgVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i3 = axgVar.readInt();
                int i4 = length + 8;
                if (Arrays.equals(r, bArr2)) {
                    byte[] bArr3 = new byte[i3];
                    if (axgVar.read(bArr3) == i3) {
                        this.am = i4;
                        bh(0, bArr3);
                        bk(new axg(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + bhs.l(bArr2));
                    }
                }
                if (i3 % 2 == 1) {
                    i3++;
                }
                length = i4 + i3;
                if (length == i2) {
                    return;
                }
                if (length > i2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                axgVar.g(i3);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void bd(axg axgVar, HashMap map) throws Throwable {
        axh axhVar = (axh) map.get("JPEGInterchangeFormat");
        axh axhVar2 = (axh) map.get("JPEGInterchangeFormatLength");
        if (axhVar == null || axhVar2 == null) {
            return;
        }
        int i2 = axhVar.i(this.ak);
        int i3 = axhVar2.i(this.ak);
        if (this.ah == 7) {
            i2 += this.an;
        }
        if (i2 > 0 && i3 > 0 && this.ag == null && this.af == null) {
            axgVar.skip(i2);
            axgVar.read(new byte[i3]);
        }
        if (a) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i2 + ", length: " + i3);
        }
    }

    public final boolean be(HashMap map) {
        axh axhVar = (axh) map.get("ImageLength");
        axh axhVar2 = (axh) map.get("ImageWidth");
        if (axhVar == null || axhVar2 == null) {
            return false;
        }
        return axhVar.i(this.ak) <= 512 && axhVar2.i(this.ak) <= 512;
    }

    public final void bf(axk axkVar) throws IOException {
        ByteOrder byteOrderAq = aq(axkVar);
        this.ak = byteOrderAq;
        axkVar.d = byteOrderAq;
        int unsignedShort = axkVar.readUnsignedShort();
        int i2 = this.ah;
        if (i2 != 7 && i2 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i3 = axkVar.readInt();
        if (i3 < 8) {
            throw new IOException(concatVar2Var1(i3, "Invalid first Ifd offset: "));
        }
        int i4 = i3 - 8;
        if (i4 > 0) {
            axkVar.g(i4);
        }
    }

    public final void bg() {
        int i2 = 0;
        while (true) {
            HashMap[] mapArr = this.ai;
            if (i2 >= mapArr.length) {
                return;
            }
            StringBuilder sbR = yg.concatVar213(i2, "The size of tag group[", "]: ");
            sbR.append(mapArr[i2].size());
            Log.d("ExifInterface", sbR.toString());
            for (Map.Entry entry : mapArr[i2].entrySet()) {
                axh axhVar = (axh) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + axhVar.toString()
                        + ", tagValue: '" + axhVar.j(this.ak) + "'");
            }
            i2++;
        }
    }

    public final void bh(int i2, byte[] bArr) throws IOException {
        axk axkVar = new axk(bArr);
        bf(axkVar);
        bi(axkVar, i2);
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x020f */
    /* JADX WARN: Found duplicated region for block: B:103:0x0213 */
    /* JADX WARN: Found duplicated region for block: B:108:0x0220 */
    /* JADX WARN: Found duplicated region for block: B:109:0x0225 */
    /* JADX WARN: Found duplicated region for block: B:110:0x0231 */
    /* JADX WARN: Found duplicated region for block: B:112:0x0238 */
    /* JADX WARN: Found duplicated region for block: B:115:0x024f */
    /* JADX WARN: Found duplicated region for block: B:117:0x025a */
    /* JADX WARN: Found duplicated region for block: B:119:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:120:0x0269 */
    /* JADX WARN: Found duplicated region for block: B:121:0x0288 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:122:0x028a */
    /* JADX WARN: Found duplicated region for block: B:124:0x02a0 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:126:0x02cc */
    /* JADX WARN: Found duplicated region for block: B:129:0x02d7 */
    /* JADX WARN: Found duplicated region for block: B:131:0x02df */
    /* JADX WARN: Found duplicated region for block: B:140:0x0309 */
    /* JADX WARN: Found duplicated region for block: B:167:0x030c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:71:0x014b */
    /* JADX WARN: Found duplicated region for block: B:72:0x0152 */
    /* JADX WARN: Found duplicated region for block: B:74:0x015a */
    /* JADX WARN: Found duplicated region for block: B:76:0x0160 */
    /* JADX WARN: Found duplicated region for block: B:77:0x0174 */
    /* JADX WARN: Found duplicated region for block: B:80:0x017b */
    /* JADX WARN: Found duplicated region for block: B:82:0x0185 */
    /* JADX WARN: Found duplicated region for block: B:83:0x0187 */
    /* JADX WARN: Found duplicated region for block: B:84:0x018c */
    /* JADX WARN: Found duplicated region for block: B:86:0x018f */
    /* JADX WARN: Found duplicated region for block: B:90:0x01d4 */
    /* JADX WARN: Found duplicated region for block: B:93:0x01e8 */
    /* JADX WARN: Found duplicated region for block: B:95:0x0203 */
    /* JADX WARN: Found duplicated region for block: B:97:0x0208 */
    /* JADX WARN: Found duplicated region for block: B:99:0x020b */
    public final void bi(axk axkVar, int i2) throws IOException {
        HashMap[] mapArr;
        short s2;
        boolean z2;
        short s3;
        HashMap[] mapArr2;
        long j2;
        long j3;
        boolean z3;
        int i3;
        long j4;
        long j5;
        int i4;
        int i5;
        Integer num;
        long j6;
        String str;
        int i6;
        int unsignedShort;
        long j7;
        int i7;
        Integer numValueOf = Integer.valueOf(axkVar.e);
        HashSet hashSet = this.aj;
        hashSet.add(numValueOf);
        short s4 = axkVar.readShort();
        boolean z4 = a;
        if (z4) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s4));
        }
        if (s4 <= 0) {
            return;
        }
        short s5 = 0;
        while (true) {
            mapArr = this.ai;
            if (s5 >= s4) {
                break;
            }
            int unsignedShort2 = axkVar.readUnsignedShort();
            int unsignedShort3 = axkVar.readUnsignedShort();
            int i8 = axkVar.readInt();
            long j8 = ((long) axkVar.e) + 4;
            axi axiVar = (axi) y[i2].get(Integer.valueOf(unsignedShort2));
            if (z4) {
                s2 = s4;
                z2 = z4;
                s3 = s5;
                mapArr2 = mapArr;
                Log.d("ExifInterface",
                        String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d",
                                Integer.valueOf(i2), Integer.valueOf(unsignedShort2), axiVar != null ? axiVar.b : null,
                                Integer.valueOf(unsignedShort3), Integer.valueOf(i8)));
            } else {
                s2 = s4;
                z2 = z4;
                s3 = s5;
                mapArr2 = mapArr;
            }
            if (axiVar != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = t;
                    if (unsignedShort3 < iArr.length) {
                        int i9 = axiVar.c;
                        if (i9 == 7 || unsignedShort3 == 7 || i9 == unsignedShort3 || (i3 = axiVar.d) == unsignedShort3
                                || (((i9 == 4 || i3 == 4) && unsignedShort3 == 3)
                                        || (((i9 == 9 || i3 == 9) && unsignedShort3 == 8)
                                                || ((i9 == 12 || i3 == 12) && unsignedShort3 == 11)))) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = i9;
                            }
                            j2 = j8;
                            j3 = ((long) i8) * ((long) iArr[unsignedShort3]);
                            if (j3 < 0 || j3 > 2147483647L) {
                                if (z2) {
                                    Log.d("ExifInterface",
                                            "Skip the tag entry since the number of components is invalid: " + i8);
                                }
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                        } else if (z2) {
                            Log.d("ExifInterface", "Skip the tag entry since data format (" + s[unsignedShort3]
                                    + ") is unexpected for tag: " + axiVar.b);
                        }
                    }
                    if (z3) {
                        j4 = j2;
                        if (j3 > 4) {
                            i7 = axkVar.readInt();
                            if (z2) {
                                i4 = unsignedShort2;
                                Log.d("ExifInterface", "seek to data offset: " + i7);
                            } else {
                                i4 = unsignedShort2;
                            }
                            if (this.ah != 7) {
                                j5 = j4;
                                i5 = unsignedShort3;
                            } else {
                                if ("MakerNote".equals(axiVar.b)) {
                                    this.an = i7;
                                } else if (i2 != 6 && "ThumbnailImage".equals(axiVar.b)) {
                                    this.ao = i7;
                                    this.ap = i8;
                                    axh axhVarG = axh.g(6, this.ak);
                                    j5 = j4;
                                    axh axhVarE = axh.e(this.ao, this.ak);
                                    i5 = unsignedShort3;
                                    axh axhVarE2 = axh.e(this.ap, this.ak);
                                    mapArr2[4].put("Compression", axhVarG);
                                    mapArr2[4].put("JPEGInterchangeFormat", axhVarE);
                                    mapArr2[4].put("JPEGInterchangeFormatLength", axhVarE2);
                                }
                                j5 = j4;
                                i5 = unsignedShort3;
                            }
                            axkVar.h(i7);
                        } else {
                            j5 = j4;
                            i4 = unsignedShort2;
                            i5 = unsignedShort3;
                        }
                        num = (Integer) ab.get(Integer.valueOf(i4));
                        if (z2) {
                            Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j3);
                        }
                        if (num != null) {
                            i6 = i5;
                            if (i6 != 3) {
                                if (i6 == 4) {
                                    j7 = ((long) axkVar.readInt()) & 4294967295L;
                                } else if (i6 == 8) {
                                    unsignedShort = axkVar.readShort();
                                } else if (i6 != 9 || i6 == 13) {
                                    unsignedShort = axkVar.readInt();
                                } else {
                                    j7 = -1;
                                }
                                if (z2) {
                                    Log.d("ExifInterface",
                                            String.format("Offset: %d, tagName: %s", Long.valueOf(j7), axiVar.b));
                                }
                                if (j7 > 0) {
                                    if (!hashSet.contains(Integer.valueOf((int) j7))) {
                                        axkVar.h(j7);
                                        bi(axkVar, num.intValue());
                                    } else if (z2) {
                                        Log.d("ExifInterface",
                                                "Skip jump into the IFD since it has already been read: IfdType " + num
                                                        + " (at " + j7 + ")");
                                    }
                                } else if (z2) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + j7);
                                }
                                axkVar.h(j5);
                            } else {
                                unsignedShort = axkVar.readUnsignedShort();
                            }
                            j7 = unsignedShort;
                            if (z2) {
                                Log.d("ExifInterface",
                                        String.format("Offset: %d, tagName: %s", Long.valueOf(j7), axiVar.b));
                            }
                            if (j7 > 0) {
                                if (!hashSet.contains(Integer.valueOf((int) j7))) {
                                    axkVar.h(j7);
                                    bi(axkVar, num.intValue());
                                } else if (z2) {
                                    Log.d("ExifInterface",
                                            "Skip jump into the IFD since it has already been read: IfdType " + num
                                                    + " (at " + j7 + ")");
                                }
                            } else if (z2) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + j7);
                            }
                            axkVar.h(j5);
                        } else {
                            j6 = j5;
                            int i10 = axkVar.e + this.am;
                            byte[] bArr = new byte[(int) j3];
                            axkVar.readFully(bArr);
                            axh axhVar = new axh(i10, bArr, i5, i8);
                            HashMap map = mapArr2[i2];
                            str = axiVar.b;
                            map.put(str, axhVar);
                            if ("DNGVersion".equals(str)) {
                                this.ah = 3;
                            }
                            if (((!"Make".equals(str) || "Model".equals(str)) && axhVar.j(this.ak).contains("PENTAX"))
                                    || ("Compression".equals(str) && axhVar.i(this.ak) == 65535)) {
                                this.ah = 8;
                            }
                            if (axkVar.e != j6) {
                                axkVar.h(j6);
                            }
                        }
                    } else {
                        axkVar.h(j2);
                    }
                    s5 = (short) (s3 + 1);
                    s4 = s2;
                    z4 = z2;
                }
                j2 = j8;
                if (z2) {
                    Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                j3 = 0;
                z3 = false;
                if (z3) {
                    axkVar.h(j2);
                } else {
                    j4 = j2;
                    if (j3 > 4) {
                        i7 = axkVar.readInt();
                        if (z2) {
                            i4 = unsignedShort2;
                            Log.d("ExifInterface", "seek to data offset: " + i7);
                        } else {
                            i4 = unsignedShort2;
                        }
                        if (this.ah != 7) {
                            j5 = j4;
                            i5 = unsignedShort3;
                        } else {
                            if ("MakerNote".equals(axiVar.b)) {
                                this.an = i7;
                            } else if (i2 != 6) {
                            }
                            j5 = j4;
                            i5 = unsignedShort3;
                        }
                        axkVar.h(i7);
                    } else {
                        j5 = j4;
                        i4 = unsignedShort2;
                        i5 = unsignedShort3;
                    }
                    num = (Integer) ab.get(Integer.valueOf(i4));
                    if (z2) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j3);
                    }
                    if (num != null) {
                        i6 = i5;
                        if (i6 != 3) {
                            if (i6 == 4) {
                                j7 = ((long) axkVar.readInt()) & 4294967295L;
                            } else if (i6 == 8) {
                                if (i6 != 9) {
                                }
                                unsignedShort = axkVar.readInt();
                            } else {
                                unsignedShort = axkVar.readShort();
                            }
                            if (z2) {
                                Log.d("ExifInterface",
                                        String.format("Offset: %d, tagName: %s", Long.valueOf(j7), axiVar.b));
                            }
                            if (j7 > 0) {
                                if (!hashSet.contains(Integer.valueOf((int) j7))) {
                                    axkVar.h(j7);
                                    bi(axkVar, num.intValue());
                                } else if (z2) {
                                    Log.d("ExifInterface",
                                            "Skip jump into the IFD since it has already been read: IfdType " + num
                                                    + " (at " + j7 + ")");
                                }
                            } else if (z2) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + j7);
                            }
                            axkVar.h(j5);
                        } else {
                            unsignedShort = axkVar.readUnsignedShort();
                        }
                        j7 = unsignedShort;
                        if (z2) {
                            Log.d("ExifInterface",
                                    String.format("Offset: %d, tagName: %s", Long.valueOf(j7), axiVar.b));
                        }
                        if (j7 > 0) {
                            if (!hashSet.contains(Integer.valueOf((int) j7))) {
                                axkVar.h(j7);
                                bi(axkVar, num.intValue());
                            } else if (z2) {
                                Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType "
                                        + num + " (at " + j7 + ")");
                            }
                        } else if (z2) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + j7);
                        }
                        axkVar.h(j5);
                    } else {
                        j6 = j5;
                        int i102 = axkVar.e + this.am;
                        byte[] bArr2 = new byte[(int) j3];
                        axkVar.readFully(bArr2);
                        axh axhVar2 = new axh(i102, bArr2, i5, i8);
                        HashMap map2 = mapArr2[i2];
                        str = axiVar.b;
                        map2.put(str, axhVar2);
                        if ("DNGVersion".equals(str)) {
                            this.ah = 3;
                        }
                        if (!"Make".equals(str)) {
                        }
                        this.ah = 8;
                        if (axkVar.e != j6) {
                            axkVar.h(j6);
                        }
                    }
                }
                s5 = (short) (s3 + 1);
                s4 = s2;
                z4 = z2;
            } else if (z2) {
                Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            }
            j2 = j8;
            j3 = 0;
            z3 = false;
            if (z3) {
                axkVar.h(j2);
            } else {
                j4 = j2;
                if (j3 > 4) {
                    i7 = axkVar.readInt();
                    if (z2) {
                        i4 = unsignedShort2;
                        Log.d("ExifInterface", "seek to data offset: " + i7);
                    } else {
                        i4 = unsignedShort2;
                    }
                    if (this.ah != 7) {
                        j5 = j4;
                        i5 = unsignedShort3;
                    } else {
                        if ("MakerNote".equals(axiVar.b)) {
                            this.an = i7;
                        } else if (i2 != 6) {
                        }
                        j5 = j4;
                        i5 = unsignedShort3;
                    }
                    axkVar.h(i7);
                } else {
                    j5 = j4;
                    i4 = unsignedShort2;
                    i5 = unsignedShort3;
                }
                num = (Integer) ab.get(Integer.valueOf(i4));
                if (z2) {
                    Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j3);
                }
                if (num != null) {
                    i6 = i5;
                    if (i6 != 3) {
                        if (i6 == 4) {
                            j7 = ((long) axkVar.readInt()) & 4294967295L;
                        } else if (i6 == 8) {
                            if (i6 != 9) {
                            }
                            unsignedShort = axkVar.readInt();
                        } else {
                            unsignedShort = axkVar.readShort();
                        }
                        if (z2) {
                            Log.d("ExifInterface",
                                    String.format("Offset: %d, tagName: %s", Long.valueOf(j7), axiVar.b));
                        }
                        if (j7 > 0) {
                            if (!hashSet.contains(Integer.valueOf((int) j7))) {
                                axkVar.h(j7);
                                bi(axkVar, num.intValue());
                            } else if (z2) {
                                Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType "
                                        + num + " (at " + j7 + ")");
                            }
                        } else if (z2) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + j7);
                        }
                        axkVar.h(j5);
                    } else {
                        unsignedShort = axkVar.readUnsignedShort();
                    }
                    j7 = unsignedShort;
                    if (z2) {
                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j7), axiVar.b));
                    }
                    if (j7 > 0) {
                        if (!hashSet.contains(Integer.valueOf((int) j7))) {
                            axkVar.h(j7);
                            bi(axkVar, num.intValue());
                        } else if (z2) {
                            Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType "
                                    + num + " (at " + j7 + ")");
                        }
                    } else if (z2) {
                        Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + j7);
                    }
                    axkVar.h(j5);
                } else {
                    j6 = j5;
                    int i1022 = axkVar.e + this.am;
                    byte[] bArr22 = new byte[(int) j3];
                    axkVar.readFully(bArr22);
                    axh axhVar22 = new axh(i1022, bArr22, i5, i8);
                    HashMap map22 = mapArr2[i2];
                    str = axiVar.b;
                    map22.put(str, axhVar22);
                    if ("DNGVersion".equals(str)) {
                        this.ah = 3;
                    }
                    if (!"Make".equals(str)) {
                    }
                    this.ah = 8;
                    if (axkVar.e != j6) {
                        axkVar.h(j6);
                    }
                }
            }
            s5 = (short) (s3 + 1);
            s4 = s2;
            z4 = z2;
        }
        boolean z5 = z4;
        int i11 = axkVar.readInt();
        if (z5) {
            Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i11)));
        }
        long j9 = i11;
        if (j9 <= 0) {
            if (z5) {
                Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i11);
                return;
            }
            return;
        }
        if (hashSet.contains(Integer.valueOf(i11))) {
            if (z5) {
                Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i11);
                return;
            }
            return;
        }
        axkVar.h(j9);
        if (mapArr[4].isEmpty()) {
            bi(axkVar, 4);
        } else if (mapArr[5].isEmpty()) {
            bi(axkVar, 5);
        }
    }

    public final void bj(int i2, String str, String str2) {
        HashMap[] mapArr = this.ai;
        if (mapArr[i2].isEmpty() || mapArr[i2].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i2];
        map.put(str2, map.get(str));
        mapArr[i2].remove(str);
    }

    public final void bk(axg axgVar) throws Throwable {
        axh axhVar;
        int i2;
        HashMap map = this.ai[4];
        axh axhVar2 = (axh) map.get("Compression");
        if (axhVar2 == null) {
            bd(axgVar, map);
            return;
        }
        int i3 = axhVar2.i(this.ak);
        if (i3 != 1) {
            if (i3 == 6) {
                bd(axgVar, map);
                return;
            } else if (i3 != 7) {
                return;
            }
        }
        axh axhVar3 = (axh) map.get("BitsPerSample");
        if (axhVar3 != null) {
            int[] iArr = (int[]) axhVar3.k(this.ak);
            int[] iArr2 = d;
            if (Arrays.equals(iArr2, iArr)
                    || (this.ah == 3 && (axhVar = (axh) map.get("PhotometricInterpretation")) != null
                            && (((i2 = axhVar.i(this.ak)) == 1 && Arrays.equals(iArr, e))
                                    || (i2 == 6 && Arrays.equals(iArr, iArr2))))) {
                axh axhVar4 = (axh) map.get("StripOffsets");
                axh axhVar5 = (axh) map.get("StripByteCounts");
                if (axhVar4 == null || axhVar5 == null) {
                    return;
                }
                long[] jArrO = bhs.o(axhVar4.k(this.ak));
                long[] jArrO2 = bhs.o(axhVar5.k(this.ak));
                if (jArrO == null || jArrO.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrO2 == null || jArrO2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrO.length != jArrO2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j2 = 0;
                for (long j3 : jArrO2) {
                    j2 += j3;
                }
                byte[] bArr = new byte[(int) j2];
                this.al = true;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < jArrO.length; i6++) {
                    int i7 = (int) jArrO[i6];
                    int i8 = (int) jArrO2[i6];
                    if (i6 < jArrO.length - 1 && i7 + i8 != jArrO[i6 + 1]) {
                        this.al = false;
                    }
                    int i9 = i7 - i4;
                    if (i9 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    long j4 = i9;
                    if (axgVar.skip(j4) != j4) {
                        Log.d("ExifInterface", "Failed to skip " + i9 + " bytes.");
                        return;
                    }
                    int i10 = i4 + i9;
                    byte[] bArr2 = new byte[i8];
                    if (axgVar.read(bArr2) != i8) {
                        Log.d("ExifInterface", "Failed to read " + i8 + " bytes.");
                        return;
                    }
                    i4 = i10 + i8;
                    System.arraycopy(bArr2, 0, bArr, i5, i8);
                    i5 += i8;
                }
                if (this.al) {
                    long j5 = jArrO[0];
                    return;
                }
                return;
            }
        }
        if (a) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void bl(int i2, int i3) throws Throwable {
        HashMap[] mapArr = this.ai;
        boolean zIsEmpty = mapArr[i2].isEmpty();
        boolean z2 = a;
        if (zIsEmpty || mapArr[i3].isEmpty()) {
            if (z2) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        axh axhVar = (axh) mapArr[i2].get("ImageLength");
        axh axhVar2 = (axh) mapArr[i2].get("ImageWidth");
        axh axhVar3 = (axh) mapArr[i3].get("ImageLength");
        axh axhVar4 = (axh) mapArr[i3].get("ImageWidth");
        if (axhVar == null || axhVar2 == null) {
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (axhVar3 == null || axhVar4 == null) {
            if (z2) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int i4 = axhVar.i(this.ak);
        int i5 = axhVar2.i(this.ak);
        int i6 = axhVar3.i(this.ak);
        int i7 = axhVar4.i(this.ak);
        if (i4 >= i6 || i5 >= i7) {
            return;
        }
        HashMap map = mapArr[i2];
        mapArr[i2] = mapArr[i3];
        mapArr[i3] = map;
    }

    public final void bm(axk axkVar, int i2) throws Throwable {
        axh axhVarG;
        axh axhVarG2;
        HashMap[] mapArr = this.ai;
        axh axhVar = (axh) mapArr[i2].get("DefaultCropSize");
        axh axhVar2 = (axh) mapArr[i2].get("SensorTopBorder");
        axh axhVar3 = (axh) mapArr[i2].get("SensorLeftBorder");
        axh axhVar4 = (axh) mapArr[i2].get("SensorBottomBorder");
        axh axhVar5 = (axh) mapArr[i2].get("SensorRightBorder");
        if (axhVar != null) {
            if (axhVar.a == 5) {
                axj[] axjVarArr = (axj[]) axhVar.k(this.ak);
                if (axjVarArr == null || axjVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(axjVarArr));
                    return;
                }
                axhVarG = axh.f(axjVarArr[0], this.ak);
                axhVarG2 = axh.f(axjVarArr[1], this.ak);
            } else {
                int[] iArr = (int[]) axhVar.k(this.ak);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                axhVarG = axh.g(iArr[0], this.ak);
                axhVarG2 = axh.g(iArr[1], this.ak);
            }
            mapArr[i2].put("ImageWidth", axhVarG);
            mapArr[i2].put("ImageLength", axhVarG2);
            return;
        }
        if (axhVar2 != null && axhVar3 != null && axhVar4 != null && axhVar5 != null) {
            int i3 = axhVar2.i(this.ak);
            int i4 = axhVar4.i(this.ak);
            int i5 = axhVar5.i(this.ak);
            int i6 = axhVar3.i(this.ak);
            if (i4 <= i3 || i5 <= i6) {
                return;
            }
            axh axhVarG3 = axh.g(i4 - i3, this.ak);
            axh axhVarG4 = axh.g(i5 - i6, this.ak);
            mapArr[i2].put("ImageLength", axhVarG3);
            mapArr[i2].put("ImageWidth", axhVarG4);
            return;
        }
        axh axhVar6 = (axh) mapArr[i2].get("ImageLength");
        axh axhVar7 = (axh) mapArr[i2].get("ImageWidth");
        if (axhVar6 == null || axhVar7 == null) {
            axh axhVar8 = (axh) mapArr[i2].get("JPEGInterchangeFormat");
            axh axhVar9 = (axh) mapArr[i2].get("JPEGInterchangeFormatLength");
            if (axhVar8 == null || axhVar9 == null) {
                return;
            }
            int i7 = axhVar8.i(this.ak);
            int i8 = axhVar8.i(this.ak);
            axkVar.h(i7);
            byte[] bArr = new byte[i8];
            axkVar.read(bArr);
            av(new axg(bArr), i7, i2);
        }
    }

    public final void bn() throws Throwable {
        bl(0, 5);
        bl(0, 4);
        bl(5, 4);
        HashMap[] mapArr = this.ai;
        axh axhVar = (axh) mapArr[1].get("PixelXDimension");
        axh axhVar2 = (axh) mapArr[1].get("PixelYDimension");
        if (axhVar != null && axhVar2 != null) {
            mapArr[0].put("ImageWidth", axhVar);
            mapArr[0].put("ImageLength", axhVar2);
        }
        if (mapArr[4].isEmpty() && be(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!be(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        bj(0, "ThumbnailOrientation", "Orientation");
        bj(0, "ThumbnailImageLength", "ImageLength");
        bj(0, "ThumbnailImageWidth", "ImageWidth");
        bj(5, "ThumbnailOrientation", "Orientation");
        bj(5, "ThumbnailImageLength", "ImageLength");
        bj(5, "ThumbnailImageWidth", "ImageWidth");
        bj(4, "Orientation", "ThumbnailOrientation");
        bj(4, "ImageLength", "ThumbnailImageLength");
        bj(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
