package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.icu.text.BreakIterator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.alibaba.fastjson2.JSONB;
import com.android.dx.io.Opcodes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.WeakHashMap;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bht implements ckp {
    public static final int[] g = { R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha,
            R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight };
    public static final int[] h = { R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY,
            R.attr.rotation, R.attr.translateX, R.attr.translateY };
    public static final int[] i = { R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor,
            R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap,
            R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType };
    public static final int[] j = { R.attr.name, R.attr.pathData, R.attr.fillType };
    public static final int[] k = { R.attr.drawable };
    public static final int[] l = { R.attr.name, R.attr.animation };
    public static final cwa m = new cwa("image-destination");
    public static final cwa n = new cwa("image-replacement-text-is-link");
    public static final cwa o = new cwa("image-size");
    public static final Object p = new Object();

    public static int aa(int i2, CharSequence charSequence) {
        while (i2 < charSequence.length()) {
            switch (charSequence.charAt(i2)) {
                case '[':
                    return -1;
                case '\\':
                    int i3 = i2 + 1;
                    if (ewz.aj(i3, charSequence)) {
                        i2 = i3;
                    }
                    break;
                case ']':
                    return i2;
            }
            i2++;
        }
        return charSequence.length();
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x001b */
    /* JADX WARN: Found duplicated region for block: B:21:0x001a A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:9:0x0018 A[DONT_INVERT] */
    public static int ab(CharSequence charSequence, int i2, char c) {
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt == '\\') {
                int i3 = i2 + 1;
                if (ewz.aj(i3, charSequence)) {
                    i2 = i3;
                } else {
                    if (cCharAt == c) {
                        return i2;
                    }
                    if (c == ')' && cCharAt == '(') {
                        return -1;
                    }
                }
            } else {
                if (cCharAt == c) {
                    return i2;
                }
                if (c == ')') {
                    continue;
                }
            }
            i2++;
        }
        return charSequence.length();
    }

    public static void ac(Window window, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            ay.d(window, z);
        } else {
            if (i2 >= 30) {
                ay.createInstanceWithArgs(window, z);
                return;
            }
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    public static final Object ad(dex dexVar, dex dexVar2, bgj bgjVar) throws Throwable {
        Object abrVar;
        Object objAo;
        Object objAi;
        auj aujVar = bhv.k;
        try {
            emc.af(2, bgjVar);
            abrVar = bgjVar.g(dexVar2, dexVar);
        } catch (aoq e) {
            Throwable th = e.a;
            abr abrVar2 = new abr(th, false);
            do {
                objAo = dexVar.ao(brm.r.get(dexVar), abrVar2);
                if (objAo == bhv.j || objAo == aujVar) {
                }
                throw th;
            } while (objAo == bhv.l);
            dexVar.j(objAo);
            throw th;
        } catch (Throwable th2) {
            abrVar = new abr(th2, false);
        }
        ahq ahqVar = ahq.a;
        if (abrVar == ahqVar || (objAi = dexVar.ai(abrVar)) == aujVar) {
            return ahqVar;
        }
        dexVar.ar();
        if (objAi instanceof abr) {
            throw ((abr) objAi).c;
        }
        return bhv.ak(objAi);
    }

    public static final long ae(String str, long j2, long j3, long j4) {
        String property;
        int i2 = dpg.a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lBg = dnq.bg(property);
        if (lBg == null) {
            throw new IllegalStateException(
                    ("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lBg.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4
                + ", but is '" + jLongValue + '\'').toString());
    }

    public static int af(String str, int i2, int i3) {
        return (int) ae(str, i2, 1, (i3 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final void ag(int[] iArr, int[] iArr2, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        ArrayList arrayList = new ArrayList();
        int length = iArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr2[i2] & (~iArr[i2]);
            if (i3 != 0) {
                for (int i4 = 0; i4 < 32; i4++) {
                    if ((i3 & 1) != 0) {
                        arrayList.add(dfxVar.j((i2 * 32) + i4));
                    }
                    i3 >>>= 1;
                }
            }
        }
        throw new cdl(dfxVar.b(), arrayList);
    }

    public static final void ah(int i2, int i3, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i4 = (~i2) & i3;
        for (int i5 = 0; i5 < 32; i5++) {
            if ((i4 & 1) != 0) {
                arrayList.add(dfxVar.j(i5));
            }
            i4 >>>= 1;
        }
        throw new cdl(dfxVar.b(), arrayList);
    }

    public static final void q(dlo dloVar) {
        int i2 = dloVar.d;
        int[] iArr = dloVar.b;
        Object[] objArr = dloVar.c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != p) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        dloVar.a = false;
        dloVar.d = i3;
    }

    public static final Bundle r(Pair... pairVarArr) {
        Bundle bundle = new Bundle(pairVarArr.length);
        for (Pair pairVar : pairVarArr) {
            String str = (String) pairVar.first;
            Object obj = pairVar.second;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class<?> componentType = obj.getClass().getComponentType();
                throwIfVar1IsNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type "
                                + componentType.getCanonicalName() + " for key \"" + str + '\"');
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IBinder) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (obj instanceof Size) {
                bundle.putSize(str, (Size) obj);
            } else {
                if (!(obj instanceof SizeF)) {
                    throw new IllegalArgumentException(
                            "Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                bundle.putSizeF(str, (SizeF) obj);
            }
        }
        return bundle;
    }

    public static int s(Context context, String str) {
        if (str != null) {
            return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str))
                    ? context.checkPermission(str, Process.myPid(), Process.myUid())
                    : new cpc(context).g.areNotificationsEnabled() ? 0 : -1;
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static String t(amj amjVar, char[] cArr) throws UTFDataFormatException {
        int i2;
        ByteBuffer byteBuffer = amjVar.b;
        int i3 = 0;
        while (true) {
            char c = (char) (byteBuffer.get() & 255);
            if (c == 0) {
                return new String(cArr, 0, i3);
            }
            cArr[i3] = c;
            if (c < 128) {
                i3++;
            } else {
                if ((c & 224) == 192) {
                    byte b = byteBuffer.get();
                    if ((b & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i2 = i3 + 1;
                    cArr[i3] = (char) (((c & 31) << 6) | (b & JSONB.Constants.BC_INT32_BYTE_MAX));
                } else {
                    if ((c & 240) != 224) {
                        throw new UTFDataFormatException("bad byte");
                    }
                    byte b2 = byteBuffer.get();
                    byte b3 = byteBuffer.get();
                    if ((b2 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128
                            || (b3 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                        throw new UTFDataFormatException("bad second or third byte");
                    }
                    i2 = i3 + 1;
                    cArr[i3] = (char) (((c & 15) << 12) | ((b2 & JSONB.Constants.BC_INT32_BYTE_MAX) << 6)
                            | (b3 & JSONB.Constants.BC_INT32_BYTE_MAX));
                }
                i3 = i2;
            }
        }
    }

    public static byte[] u(String str) throws UTFDataFormatException {
        int length = str.length();
        long j2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            j2 += (cCharAt == 0 || cCharAt > 127) ? cCharAt <= 2047 ? 2L : 3L : 1L;
            if (j2 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        byte[] bArr = new byte[(int) j2];
        int length2 = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4++) {
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 != 0 && cCharAt2 <= 127) {
                bArr[i3] = (byte) cCharAt2;
                i3++;
            } else if (cCharAt2 <= 2047) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (((cCharAt2 >> 6) & 31) | 192);
                i3 += 2;
                bArr[i5] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                bArr[i3] = (byte) (((cCharAt2 >> '\f') & 15) | Opcodes.SHL_INT_LIT8);
                int i6 = i3 + 2;
                bArr[i3 + 1] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                i3 += 3;
                bArr[i6] = (byte) ((cCharAt2 & '?') | 128);
            }
        }
        return bArr;
    }

    public static ColorStateList v(Context context, int i2) {
        ColorStateList colorStateListB;
        ColorStateList colorStateList;
        dcr dcrVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        dcs dcsVar = new dcs(resources, theme);
        synchronized (dcu.c) {
            try {
                SparseArray sparseArray = (SparseArray) dcu.b.get(dcsVar);
                colorStateListB = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (dcrVar = (dcr) sparseArray.get(i2)) == null) {
                    colorStateList = null;
                } else {
                    if (dcrVar.b.equals(resources.getConfiguration())) {
                        if (theme != null || dcrVar.c != 0) {
                            if (theme == null || dcrVar.c != theme.hashCode()) {
                            }
                        }
                        colorStateList = dcrVar.a;
                    }
                    sparseArray.remove(i2);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = dcu.a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.type;
        if (i3 < 28 || i3 > 31) {
            try {
                colorStateListB = abh.b(resources, resources.getXml(i2), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateListB == null) {
            return resources.getColorStateList(i2, theme);
        }
        synchronized (dcu.c) {
            try {
                WeakHashMap weakHashMap = dcu.b;
                SparseArray sparseArray2 = (SparseArray) weakHashMap.get(dcsVar);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    weakHashMap.put(dcsVar, sparseArray2);
                }
                sparseArray2.append(i2, new dcr(colorStateListB, dcsVar.a.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return colorStateListB;
    }

    public static final String w(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5" /* "MD5" /* "MD5" /* "MD5" /* cnb.z(-47163035876138L)   */);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = fileInputStream.read(bArr, 0, 1024);
            if (i2 == -1) {
                break;
            }
            messageDigest.update(bArr, 0, i2);
        }
        fileInputStream.close();
        byte[] bArrDigest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArrDigest) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.getDefault());
            throwIfVar1IsNull(upperCase, "toUpperCase(...)" /* "toUpperCase(...)" /* "toUpperCase(...)" /* "toUpperCase(...)" /* cnb.z(-47218870450986L)   */);
            if (upperCase.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(upperCase);
        }
        return stringBuffer.toString();
    }

    public static long x(afo afoVar, int i2, boolean z) {
        if (!z) {
            return y(i2, afoVar);
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(new uh(afoVar));
        int iFollowing = wordInstance.following(i2);
        int iPrevious = wordInstance.previous();
        return (i2 < iPrevious || i2 > iFollowing) ? y(i2, afoVar) : KotlinHelpers.al(iPrevious, iFollowing);
    }

    public static long y(int i2, CharSequence charSequence) {
        int i3 = i2;
        while (i3 < charSequence.length()) {
            if (!cib.c(cib.b, charSequence.charAt(i3))) {
                break;
            }
            i3++;
        }
        if (i3 > i2) {
            while (i2 > 0) {
                if (!cib.c(cib.b, charSequence.charAt(i2 - 1))) {
                    break;
                }
                i2--;
            }
        }
        return KotlinHelpers.al(i2, i3);
    }

    /* JADX WARN: Found duplicated region for block: B:49:0x0077 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:50:0x0078 A[RETURN] */
    public static int z(int i2, CharSequence charSequence) {
        char cCharAt;
        if (i2 >= charSequence.length()) {
            return -1;
        }
        if (charSequence.charAt(i2) == '<') {
            while (true) {
                i2++;
                if (i2 >= charSequence.length() || (cCharAt = charSequence.charAt(i2)) == '\n' || cCharAt == '<') {
                    break;
                }
                if (cCharAt == '>') {
                    return i2 + 1;
                }
                if (cCharAt == '\\') {
                    int i3 = i2 + 1;
                    if (ewz.aj(i3, charSequence)) {
                        i2 = i3;
                    }
                }
            }
            return -1;
        }
        int i4 = 0;
        int i5 = i2;
        while (i5 < charSequence.length()) {
            char cCharAt2 = charSequence.charAt(i5);
            if (cCharAt2 == 0 || cCharAt2 == ' ') {
                if (i5 != i2) {
                    return i5;
                }
                return -1;
            }
            if (cCharAt2 == '\\') {
                int i6 = i5 + 1;
                if (ewz.aj(i6, charSequence)) {
                    i5 = i6;
                }
            } else if (cCharAt2 == '(') {
                i4++;
                if (i4 > 32) {
                    return -1;
                }
            } else if (cCharAt2 != ')') {
                if (Character.isISOControl(cCharAt2)) {
                    if (i5 != i2) {
                        return i5;
                    }
                    return -1;
                }
            } else {
                if (i4 == 0) {
                    return i5;
                }
                i4--;
            }
            i5++;
        }
        return charSequence.length();
    }

    public void ai(int i2) {
        new Handler(Looper.getMainLooper()).post(new dct(this, i2, 0));
    }

    public abstract int[] aj();

    public abstract int ak(boolean z);

    public abstract bhs al();

    public abstract void e(int i2);

    public abstract void f(Typeface typeface);
}
