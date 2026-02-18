package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import okhttp3.internal.http2.Http2Connection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bhu {
    public static final Object g = new Object();
    public static final int[] h = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
    public static final int[] i = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    public static final int[] j = {3, 6};
    public static final int[] k = {1, 2, 4, 5, 7, 8};
    public static final int[] l = {R.attr.colorPrimary};
    public static final int[] m = {R.attr.colorPrimaryVariant};

    public static ep aa() {
        return (ep) ep.a.getValue();
    }

    public static byte[] ab(ayd aydVar, aes aesVar, ewo ewoVar) {
        String str = aydVar.e;
        try {
            byte[] bArrV = cmz.v(new File(aydVar.d + str, (String) aesVar.i));
            if (bArrV != null) {
                return ewoVar != null ? ewoVar.b(bArrV) : bArrV;
            }
            return null;
        } catch (Exception e) {
            Log.e("FastKV", str, e);
            return null;
        }
    }

    public static int ac(int i2, int i3) {
        if (i3 >= 268435456) {
            throw new IllegalStateException("data size out of limit");
        }
        int i4 = ayd.c;
        if (i3 <= i4) {
            return i4;
        }
        while (i2 < i3) {
            i2 <<= 1;
        }
        return i2;
    }

    public static LinkedHashSet ad(ayd aydVar, aez aezVar, ewo ewoVar) {
        String str = aydVar.e;
        try {
            byte[] bArrV = cmz.v(new File(aydVar.d + str, (String) aezVar.i));
            if (bArrV == null) {
                Log.w("FastKV", str, new Exception("Read object data failed"));
                return null;
            }
            if (ewoVar != null) {
                bArrV = ewoVar.b(bArrV);
            }
            int i2 = bArrV[0] & 255;
            String strK = aydVar.l.k(1, i2, bArrV);
            dni dniVar = (dni) aydVar.f.get(strK);
            if (dniVar == null) {
                Log.w("FastKV", str, new Exception("No encoder for tag:".concat(strK)));
                return null;
            }
            aezVar.h = dniVar;
            int i3 = i2 + 1;
            return dniVar.b(i3, bArrV.length - i3, bArrV);
        } catch (Exception e) {
            Log.e("FastKV", str, e);
            return null;
        }
    }

    public static String ae(ayd aydVar, afa afaVar, ewo ewoVar) {
        String str = aydVar.e;
        try {
            byte[] bArrV = cmz.v(new File(aydVar.d + str, (String) afaVar.i));
            if (bArrV == null) {
                return null;
            }
            if (ewoVar != null) {
                bArrV = ewoVar.b(bArrV);
            }
            return new String(bArrV, StandardCharsets.UTF_8);
        } catch (Exception e) {
            Log.e("FastKV", str, e);
            return null;
        }
    }

    public static final int af(dfx dfxVar, dfx[] dfxVarArr) {
        bzo.q(dfxVarArr, "typeParams");
        int iHashCode = (dfxVar.b().hashCode() * 31) + Arrays.hashCode(dfxVarArr);
        z zVar = new z(dfxVar);
        int iHashCode2 = 1;
        int i2 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!zVar.hasNext()) {
                break;
            }
            int i3 = i2 * 31;
            String strB = ((dfx) zVar.next()).b();
            if (strB != null) {
                iHashCode3 = strB.hashCode();
            }
            i2 = i3 + iHashCode3;
        }
        z zVar2 = new z(dfxVar);
        while (zVar2.hasNext()) {
            int i4 = iHashCode2 * 31;
            emc emcVarH = ((dfx) zVar2.next()).h();
            iHashCode2 = i4 + (emcVarH != null ? emcVarH.hashCode() : 0);
        }
        return (((iHashCode * 31) + i2) * 31) + iHashCode2;
    }

    public static int ag(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 32) {
            return 5;
        }
        if (i2 == 64) {
            return 6;
        }
        if (i2 == 128) {
            return 7;
        }
        if (i2 == 256) {
            return 8;
        }
        if (i2 == 512) {
            return 9;
        }
        throw new IllegalArgumentException(bjs.i(i2, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static void ah(ayd aydVar) {
        long j2;
        String str = aydVar.d;
        StringBuilder sb = new StringBuilder();
        String str2 = aydVar.e;
        File file = new File(str, yg.o(sb, str2, ".kva"));
        File file2 = new File(str, dkz.s(str2, ".kvb"));
        try {
            if (cmz.ae(file) && cmz.ae(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                aydVar.v = randomAccessFile.getChannel();
                aydVar.w = randomAccessFile2.getChannel();
                try {
                    FileChannel fileChannel = aydVar.v;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, length > 0 ? length : ayd.c);
                    aydVar.x = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    FileChannel fileChannel2 = aydVar.w;
                    if (length2 > 0) {
                        j2 = length2;
                    } else {
                        j2 = ayd.c;
                        fileChannel2 = fileChannel2;
                    }
                    MappedByteBuffer map2 = fileChannel2.map(mapMode, 0L, j2);
                    aydVar.y = map2;
                    map2.order(byteOrder);
                    aydVar.l = new ik(aydVar.x.capacity());
                    if (length == 0 && length2 == 0) {
                        aydVar.h = 12;
                        return;
                    } else {
                        at(aydVar, length, length2);
                        return;
                    }
                } catch (IOException e) {
                    Log.e("FastKV", str2, e);
                    be(aydVar);
                    bh(aydVar, file, file2);
                    return;
                }
            }
            Log.e("FastKV", str2, new Exception("open file failed"));
            be(aydVar);
        } catch (Exception e2) {
            Log.e("FastKV", str2, e2);
            ay(aydVar);
            be(aydVar);
        }
    }

    public static boolean ai(ayd aydVar) {
        String str = aydVar.d;
        StringBuilder sb = new StringBuilder();
        String str2 = aydVar.e;
        File file = new File(str, yg.o(sb, str2, ".kvc"));
        File file2 = new File(str, dkz.s(str2, ".tmp"));
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!aj(aydVar, file)) {
                    ay(aydVar);
                    y(aydVar);
                    return false;
                }
                if (aydVar.aa == 0) {
                    if (!bi(aydVar, aydVar.l)) {
                        aydVar.aa = 1;
                        return false;
                    }
                    bhv.ab(aydVar, "recover from c file");
                    try {
                        y(aydVar);
                        return true;
                    } catch (Exception e) {
                        e = e;
                        z = true;
                        Log.e("FastKV", str2, e);
                        return z;
                    }
                }
            } else if (aydVar.aa != 0) {
                File file3 = new File(str, str2 + ".kva");
                File file4 = new File(str, str2 + ".kvb");
                if (file3.exists() && file4.exists()) {
                    bh(aydVar, file3, file4);
                }
            }
            return false;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static boolean aj(ayd aydVar, File file) {
        long length = file.length();
        if (length != 0 && length < 268435456) {
            int i2 = (int) length;
            int iAc = ac(ayd.c, i2);
            ik ikVar = aydVar.l;
            if (ikVar == null || ((byte[]) ikVar.d).length != iAc) {
                ikVar = new ik(new byte[iAc], 0);
                aydVar.l = ikVar;
            } else {
                ikVar.b = 0;
            }
            cmz.aj(file, (byte[]) ikVar.d, i2);
            int iM = ikVar.m();
            if (iM >= 0) {
                int i3 = (-1073741825) & iM;
                boolean z = (iM & 1073741824) != 0;
                long jO = ikVar.o(ikVar.b);
                ikVar.b += 8;
                aydVar.h = i3 + 12;
                if (i3 >= 0 && i3 <= i2 - 12 && jO == ikVar.l(12, i3) && cnd.be(aydVar, z)) {
                    aydVar.i = jO;
                    return true;
                }
            }
        }
        return false;
    }

    public static final ArrayList ak(Map map, bgf bgfVar) {
        bzo.q(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            cin cinVar = (cin) entry.getValue();
            Boolean boolValueOf = cinVar != null ? Boolean.valueOf(cinVar.b) : null;
            bzo.n(boolValueOf);
            if (!boolValueOf.booleanValue() && !cinVar.c) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (((Boolean) bgfVar.invoke((String) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Number al(Integer num, Context context) {
        Resources resources = context.getResources();
        float fIntValue = num.intValue();
        if (fIntValue >= 0.0f) {
            fIntValue = (fIntValue / resources.getDisplayMetrics().density) + 0.5f;
        }
        return Integer.valueOf((int) fIntValue);
    }

    public static final Number am(Integer num, Context context) {
        Resources resources = context.getResources();
        float fIntValue = num.intValue();
        if (fIntValue >= 0.0f) {
            fIntValue *= resources.getDisplayMetrics().density;
        }
        return Integer.valueOf((int) fIntValue);
    }

    public static TypedArray an(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        p(context, attributeSet, i2, i3);
        q(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static jx ao(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        p(context, attributeSet, i2, i3);
        q(context, attributeSet, iArr, i2, i3, iArr2);
        return new jx(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public static final bpy ap(String str, String str2, int i2, bgf bgfVar) {
        char cCharAt = str.charAt(i2);
        if (((Boolean) bgfVar.invoke(Character.valueOf(cCharAt))).booleanValue()) {
            return null;
        }
        return aq(str, "Expected " + str2 + ", but got '" + cCharAt + "' at position " + i2);
    }

    public static final bpy aq(String str, String str2) {
        StringBuilder sbR = bjs.r(str2, " when parsing an Instant from \"");
        sbR.append(bg(64, str));
        sbR.append('\"');
        return new bpy(sbR.toString(), str);
    }

    public static final int ar(int i2, String str) {
        return (str.charAt(i2 + 1) - '0') + ((str.charAt(i2) - '0') * 10);
    }

    /* JADX WARN: Found duplicated region for block: B:42:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void as(Context context, String str) {
        synchronized (g) {
            if (str.equals("")) {
                context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                return;
            }
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                        xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                        xmlSerializerNewSerializer.startTag(null, "locales");
                        xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                        xmlSerializerNewSerializer.endTag(null, "locales");
                        xmlSerializerNewSerializer.endDocument();
                    } catch (Throwable th) {
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales in storage ", e);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (FileNotFoundException unused3) {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
            }
        }
    }

    public static void at(ayd aydVar, long j2, long j3) {
        long j4;
        MappedByteBuffer mappedByteBuffer = aydVar.x;
        String str = aydVar.e;
        int i2 = mappedByteBuffer.getInt();
        int i3 = i2 & (-1073741825);
        boolean z = (i2 & 1073741824) != 0;
        long j5 = aydVar.x.getLong();
        int i4 = aydVar.y.getInt();
        int i5 = (-1073741825) & i4;
        boolean z2 = (1073741824 & i4) != 0;
        long j6 = aydVar.y.getLong();
        if (i3 < 0) {
            j4 = 12;
        } else if (i3 <= j2 - 12) {
            aydVar.h = i3 + 12;
            aydVar.x.rewind();
            j4 = 12;
            aydVar.x.get((byte[]) aydVar.l.d, 0, aydVar.h);
            if (j5 == aydVar.l.l(12, i3) && cnd.be(aydVar, z)) {
                aydVar.i = j5;
                if (j2 == j3) {
                    byte[] bArr = new byte[aydVar.h];
                    aydVar.y.rewind();
                    aydVar.y.get(bArr, 0, aydVar.h);
                    byte[] bArr2 = (byte[]) aydVar.l.d;
                    for (int i6 = 0; i6 < aydVar.h; i6++) {
                        if (bArr2[i6] == bArr[i6]) {
                        }
                    }
                    return;
                }
                Log.w("FastKV", str, new Exception("B file error"));
                v(aydVar, aydVar.x, aydVar.y, aydVar.h);
                return;
            }
        } else {
            j4 = 12;
        }
        if (i5 >= 0 && i5 <= j3 - j4) {
            aydVar.j.clear();
            aydVar.r = 0;
            aydVar.s.clear();
            aydVar.h = i5 + 12;
            if (((byte[]) aydVar.l.d).length != aydVar.y.capacity()) {
                aydVar.l = new ik(aydVar.y.capacity());
            }
            aydVar.y.rewind();
            aydVar.y.get((byte[]) aydVar.l.d, 0, aydVar.h);
            if (j6 == aydVar.l.l(12, i5) && cnd.be(aydVar, z2)) {
                Log.w("FastKV", str, new Exception("A file error"));
                v(aydVar, aydVar.y, aydVar.x, aydVar.h);
                aydVar.i = j6;
                return;
            }
        }
        bhv.v(aydVar, "both files error");
        s(aydVar);
    }

    /* JADX WARN: Found duplicated region for block: B:48:0x0046 A[EXC_TOP_SPLITTER, PHI: r1
      0x0046: PHI (r1v2 java.lang.String) = (r1v0 java.lang.String), (r1v4 java.lang.String) binds: [B:29:0x0053, B:23:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static String au(Context context) {
        String attributeValue;
        synchronized (g) {
            attributeValue = "";
            try {
                FileInputStream fileInputStreamOpenFileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        int depth = xmlPullParserNewPullParser.getDepth();
                        while (true) {
                            int next = xmlPullParserNewPullParser.next();
                            if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                                if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "application_locales");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    } catch (IOException | XmlPullParserException unused) {
                        Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (attributeValue.isEmpty()) {
                        context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    }
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                return "";
            }
        }
        return attributeValue;
    }

    public static void av(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static MappedByteBuffer aw(FileChannel fileChannel, int i2) {
        try {
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i2);
            map.order(ByteOrder.LITTLE_ENDIAN);
            return map;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void ax(ayd aydVar, MappedByteBuffer mappedByteBuffer) throws IOException {
        MappedByteBuffer mappedByteBufferAw;
        int iCapacity = mappedByteBuffer.capacity();
        int i2 = ayd.c;
        if (iCapacity != i2) {
            FileChannel fileChannel = mappedByteBuffer == aydVar.x ? aydVar.v : aydVar.w;
            try {
                fileChannel.truncate(i2);
                mappedByteBufferAw = aw(fileChannel, i2);
            } catch (IOException unused) {
                mappedByteBufferAw = null;
            }
            if (mappedByteBufferAw == null) {
                throw new IOException("Failed to truncate and remap buffer");
            }
            if (mappedByteBuffer == aydVar.x) {
                aydVar.x = mappedByteBufferAw;
            } else {
                aydVar.y = mappedByteBufferAw;
            }
            mappedByteBuffer = mappedByteBufferAw;
        }
        mappedByteBuffer.putInt(0, aydVar.g != null ? 1073741824 : 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    public static void ay(ayd aydVar) {
        aydVar.h = 12;
        aydVar.i = 0L;
        aydVar.j.clear();
        aydVar.r = 0;
        aydVar.s.clear();
        ik ikVar = aydVar.l;
        if (ikVar == null || ((byte[]) ikVar.d).length != ayd.c) {
            aydVar.l = new ik(ayd.c);
        } else {
            ikVar.aa(4, 0L);
        }
        aydVar.l.z(0, aydVar.g != null ? 1073741824 : 0);
    }

    public static final void az(Object[] objArr, int i2, int i3) {
        bzo.q(objArr, "<this>");
        while (i2 < i3) {
            objArr[i2] = null;
            i2++;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "start" is null
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1223)
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1217)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.cutHandlerBlocks(MarkFinallyVisitor.java:249)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:123)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:220:0x00cf
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static void ba(me.hd.wauxv.obf.ayd r14) {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.bhu.ba(me.hd.wauxv.obf.ayd):void");
    }

    public static void bb(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = eqz.a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static long bc(int i2, long j2) {
        int i3 = (i2 & 7) << 3;
        return (j2 >>> (64 - i3)) | (j2 << i3);
    }

    public static final void bd(Object obj) throws Throwable {
        if (obj instanceof dcx) {
            throw ((dcx) obj).a;
        }
    }

    public static void be(ayd aydVar) {
        aydVar.aa = 1;
        cmz.p(aydVar.v);
        cmz.p(aydVar.w);
        aydVar.v = null;
        aydVar.w = null;
        aydVar.x = null;
        aydVar.y = null;
    }

    public static final String bf(dfx dfxVar) {
        return aaz.k(dqc.bm(0, dfxVar.i()), ", ", dfxVar.b() + '(', ")", new q(dfxVar, 8), 24);
    }

    public static final String bg(int i2, String str) {
        if (str.length() <= i2) {
            return str.toString();
        }
        return str.subSequence(0, i2).toString() + "...";
    }

    public static void bh(ayd aydVar, File file, File file2) {
        String str = aydVar.e;
        try {
            if (aj(aydVar, file)) {
                return;
            }
        } catch (IOException e) {
            Log.w("FastKV", str, e);
        }
        ay(aydVar);
        try {
            if (aj(aydVar, file2)) {
                return;
            }
        } catch (IOException e2) {
            Log.w("FastKV", str, e2);
        }
        ay(aydVar);
    }

    public static boolean bi(ayd aydVar, ik ikVar) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileChannel.MapMode mapMode;
        ByteOrder byteOrder;
        String str = aydVar.e;
        String str2 = aydVar.d;
        try {
            int length = ((byte[]) ikVar.d).length;
            File file = new File(str2, str + ".kva");
            File file2 = new File(str2, str + ".kvb");
            if (!cmz.ae(file) || !cmz.ae(file2)) {
                throw new Exception("open file failed");
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            long j2 = length;
            try {
                randomAccessFile.setLength(j2);
                FileChannel channel = randomAccessFile.getChannel();
                aydVar.v = channel;
                mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = channel.map(mapMode, 0L, j2);
                aydVar.x = map;
                byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                aydVar.x.put((byte[]) ikVar.d, 0, aydVar.h);
                randomAccessFile2 = new RandomAccessFile(file2, "rw");
            } catch (Exception e) {
                e = e;
                randomAccessFile2 = null;
            }
            try {
                randomAccessFile2.setLength(j2);
                FileChannel channel2 = randomAccessFile2.getChannel();
                aydVar.w = channel2;
                MappedByteBuffer map2 = channel2.map(mapMode, 0L, j2);
                aydVar.y = map2;
                map2.order(byteOrder);
                aydVar.y.put((byte[]) ikVar.d, 0, aydVar.h);
                return true;
            } catch (Exception e2) {
                e = e2;
                cmz.p(randomAccessFile);
                cmz.p(randomAccessFile2);
                aydVar.v = null;
                aydVar.w = null;
                aydVar.x = null;
                aydVar.y = null;
                Log.e("FastKV", str, e);
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
            randomAccessFile2 = null;
        }
    }

    public static boolean bj(ayd aydVar) {
        String str = aydVar.e;
        String str2 = aydVar.d;
        try {
            File file = new File(str2, str + ".tmp");
            if (!cmz.ae(file)) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.setLength(aydVar.h);
                randomAccessFile.write((byte[]) aydVar.l.d, 0, aydVar.h);
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
                File file2 = new File(str2, str + ".kvc");
                if (!(file.renameTo(file2) || ((!file2.exists() || file2.delete()) && file.renameTo(file2)))) {
                    Log.w("FastKV", str, new Exception("rename failed"));
                    return false;
                }
                ArrayList arrayList = aydVar.o;
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        aye.s().execute(new hl(aydVar, 4, (String) it.next()));
                    }
                    arrayList.clear();
                }
                return true;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Log.e("FastKV", str, e);
            return false;
        }
    }

    public static final String n(Object[] objArr, int i2, int i3, ad adVar) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2 + i4];
            if (obj == adVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }

    public static void o(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void p(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.ar, i2, i3);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                r(context, m, "Theme.MaterialComponents");
            }
        }
        r(context, l, "Theme.AppCompat");
    }

    public static void q(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.ar, i2, i3);
        boolean z = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            int length = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    typedArrayObtainStyledAttributes2.recycle();
                    z = true;
                    break;
                } else {
                    if (typedArrayObtainStyledAttributes2.getResourceId(iArr2[i4], -1) == -1) {
                        typedArrayObtainStyledAttributes2.recycle();
                        break;
                    }
                    i4++;
                }
            }
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z = true;
            break;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void r(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
                typedArrayObtainStyledAttributes.recycle();
                throw new IllegalArgumentException(bjs.o("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void s(ayd aydVar) {
        if (aydVar.aa == 0) {
            try {
                ax(aydVar, aydVar.x);
                ax(aydVar, aydVar.y);
            } catch (Exception unused) {
                be(aydVar);
            }
        }
        ay(aydVar);
        cmz.s(new File(aydVar.d + aydVar.e));
    }

    public static int t(int i2, int i3) {
        if (i2 == i3) {
            return 0;
        }
        return (((long) i2) & 4294967295L) < (((long) i3) & 4294967295L) ? -1 : 1;
    }

    public static ImageView.ScaleType u(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static void v(ayd aydVar, MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i2) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            MappedByteBuffer mappedByteBufferAw = aw(mappedByteBuffer2 == aydVar.y ? aydVar.w : aydVar.v, mappedByteBuffer.capacity());
            if (mappedByteBufferAw == null) {
                Log.e("FastKV", aydVar.e, new Exception("map failed"));
                be(aydVar);
                return;
            } else {
                if (mappedByteBuffer2 == aydVar.y) {
                    aydVar.y = mappedByteBufferAw;
                } else {
                    aydVar.x = mappedByteBufferAw;
                }
                mappedByteBuffer2 = mappedByteBufferAw;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i2);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    public static final long w(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i2 = inputStream.read(bArr);
        long j2 = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j2 += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j2;
    }

    public static final dcx x(Throwable th) {
        bzo.q(th, "exception");
        return new dcx(th);
    }

    public static void y(ayd aydVar) {
        String str = aydVar.e;
        String str2 = aydVar.d;
        try {
            cmz.s(new File(str2, str + ".kvc"));
            cmz.s(new File(str2, str + ".tmp"));
        } catch (Exception e) {
            Log.e("FastKV", str, e);
        }
    }

    public static final void z(StringBuilder sb, StringBuilder sb2, int i2) {
        if (i2 < 10) {
            sb.append('0');
        }
        sb2.append(i2);
    }
}
