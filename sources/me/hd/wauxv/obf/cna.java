package me.hd.wauxv.obf;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.ws.WebSocketProtocol;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cna {
    public static final jx b;
    public static jx c = null;
    public static String d = "YukiHookAPI";
    public static final ahq a = ahq.a;
    public static final Integer[] e = {1000, Integer.valueOf(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY), 1002, 1003};

    static {
        Object obj = null;
        b = new jx(obj, obj, obj, 16);
    }

    public static final aox aa(brf brfVar, boolean z, bri briVar) {
        return brfVar instanceof brm ? ((brm) brfVar).ag(z, briVar) : brfVar.p(briVar._ba(), z, new brh(1, briVar, bri.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0));
    }

    public static boolean ab(int i) {
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = abi.a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d2 = ((double) iRed) / 255.0d;
        double dPow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = ((double) iGreen) / 255.0d;
        double dPow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = ((double) iBlue) / 255.0d;
        double dPow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        double d5 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[1] = d5;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
        return d5 / 100.0d > 0.5d;
    }

    public static boolean ac(byte[] bArr) {
        byte[] bytes = "wxgf" /* cnb.z(-119301306579754L) */.getBytes(uj.a);
        bzo.p(bytes, "getBytes(...)" /* cnb.z(-119331371350826L) */);
        if (bArr.length >= bytes.length) {
            Iterable bqiVar = new bqi(0, bytes.length - 1, 1);
            if (!(bqiVar instanceof Collection) || !((Collection) bqiVar).isEmpty()) {
                Iterator it = bqiVar.iterator();
                while (((bqg) it).c) {
                    int iNextInt = ((bqe) it).nextInt();
                    if (bArr[iNextInt] == bytes[iNextInt]) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static int ad(int i, float f, int i2) {
        return abi.d(abi.f(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static String ae(String str) {
        if (str.length() >= 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder(2);
        for (int i = 0; i < 2 - str.length(); i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static final long af(String str) {
        char cCharAt;
        int length = str.length();
        int i = (length <= 0 || !dnj.ac("+-", str.charAt(0))) ? 0 : 1;
        if (length - i > 16) {
            int i2 = i;
            while (true) {
                if (i >= length) {
                    if (length - i2 <= 16) {
                        break;
                    }
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '0') {
                    if (i2 == i) {
                        i2++;
                    }
                } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                    break;
                }
                i++;
            }
        }
        return (!dnr.bp(str, "+", false) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(dnj.ad(1, str));
    }

    public static boolean ag(String str, String str2, boolean z) {
        if (str.length() >= str2.length()) {
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt == cCharAt2 || (z && Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2))) {
                }
            }
            return true;
        }
        return false;
    }

    public static int ah(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static final long ai(long j, aqp aqpVar) {
        bzo.q(aqpVar, "unit");
        aqp aqpVar2 = aqp.NANOSECONDS;
        bzo.q(aqpVar2, "sourceUnit");
        TimeUnit timeUnit = aqpVar.h;
        TimeUnit timeUnit2 = aqpVar2.h;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        if ((-jConvert) > j || j > jConvert) {
            aqp aqpVar3 = aqp.MILLISECONDS;
            bzo.q(aqpVar3, "targetUnit");
            return o(dqc.az(aqpVar3.h.convert(j, timeUnit)));
        }
        long jConvert2 = timeUnit2.convert(j, timeUnit) << 1;
        int i = aqm.c;
        int i2 = aqn.a;
        return jConvert2;
    }

    public static final long f(String str) {
        aqp aqpVar;
        long jP;
        char cCharAt;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int i = aqm.c;
        char cCharAt2 = str.charAt(0);
        int i2 = (cCharAt2 == '+' || cCharAt2 == '-') ? 1 : 0;
        boolean z = i2 > 0 && str.length() > 0 && cmz.u(str.charAt(0), SignatureVisitor.SUPER, false);
        if (length <= i2) {
            throw new IllegalArgumentException("No components");
        }
        if (str.charAt(i2) != 'P') {
            throw new IllegalArgumentException();
        }
        int i3 = i2 + 1;
        if (i3 == length) {
            throw new IllegalArgumentException();
        }
        aqp aqpVar2 = null;
        long jI = 0;
        boolean z2 = false;
        while (i3 < length) {
            if (str.charAt(i3) != 'T') {
                int i4 = i3;
                while (i4 < str.length() && (('0' <= (cCharAt = str.charAt(i4)) && cCharAt < ':') || dnj.ac("+-.", cCharAt))) {
                    i4++;
                }
                String strSubstring = str.substring(i3, i4);
                bzo.p(strSubstring, "substring(...)");
                if (strSubstring.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length2 = strSubstring.length() + i3;
                if (length2 < 0 || length2 >= str.length()) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                }
                char cCharAt3 = str.charAt(length2);
                int i5 = length2 + 1;
                if (z2) {
                    if (cCharAt3 == 'H') {
                        aqpVar = aqp.HOURS;
                    } else if (cCharAt3 == 'M') {
                        aqpVar = aqp.MINUTES;
                    } else {
                        if (cCharAt3 != 'S') {
                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                        }
                        aqpVar = aqp.SECONDS;
                    }
                } else {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    aqpVar = aqp.DAYS;
                }
                if (aqpVar2 != null && aqpVar2.compareTo(aqpVar) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iAh = dnj.ah(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, 0, 6, strSubstring);
                if (aqpVar != aqp.SECONDS || iAh <= 0) {
                    jI = aqm.i(jI, ai(af(strSubstring), aqpVar));
                } else {
                    String strSubstring2 = strSubstring.substring(0, iAh);
                    bzo.p(strSubstring2, "substring(...)");
                    long jI2 = aqm.i(jI, ai(af(strSubstring2), aqpVar));
                    String strSubstring3 = strSubstring.substring(iAh);
                    bzo.p(strSubstring3, "substring(...)");
                    double d2 = Double.parseDouble(strSubstring3);
                    double dP = cnb.p(d2, aqpVar, aqp.NANOSECONDS);
                    if (Double.isNaN(dP)) {
                        throw new IllegalArgumentException("Duration value cannot be NaN.");
                    }
                    if (Double.isNaN(dP)) {
                        throw new IllegalArgumentException("Cannot round NaN value.");
                    }
                    long jRound = Math.round(dP);
                    if (-4611686018426999999L > jRound || jRound >= 4611686018427000000L) {
                        double dP2 = cnb.p(d2, aqpVar, aqp.MILLISECONDS);
                        if (Double.isNaN(dP2)) {
                            throw new IllegalArgumentException("Cannot round NaN value.");
                        }
                        jP = p(Math.round(dP2));
                    } else {
                        jP = jRound << 1;
                        int i6 = aqm.c;
                        int i7 = aqn.a;
                    }
                    jI = aqm.i(jI2, jP);
                }
                aqpVar2 = aqpVar;
                i3 = i5;
            } else {
                if (z2 || (i3 = i3 + 1) == length) {
                    throw new IllegalArgumentException();
                }
                z2 = true;
            }
        }
        if (!z) {
            return jI;
        }
        long j = ((-(jI >> 1)) << 1) + ((long) (((int) jI) & 1));
        int i8 = aqn.a;
        return j;
    }

    public static void g(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static final void i(int i, String str) {
        if (str.charAt(i) == '-') {
            return;
        }
        StringBuilder sbR = yg.r(i, "Expected '-' (hyphen) at index ", ", but was '");
        sbR.append(str.charAt(i));
        sbR.append('\'');
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static final boolean k(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj != obj2 && !bzo.f(obj, obj2)) {
                if (obj != null && obj2 != null) {
                    if ((obj instanceof Bundle) && (obj2 instanceof Bundle)) {
                        if (!k((Bundle) obj, (Bundle) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                        if (!la._ai((Object[]) obj, (Object[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                        if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                        if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                        if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                        if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                        if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                        if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                        if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                        if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            return false;
                        }
                    } else if (!obj.equals(obj2)) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static final int l(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        int iL = 1;
        while (it.hasNext()) {
            Object obj = bundle.get(it.next());
            iL = (iL * 31) + (obj instanceof Bundle ? l((Bundle) obj) : obj instanceof Object[] ? Arrays.deepHashCode((Object[]) obj) : obj instanceof byte[] ? Arrays.hashCode((byte[]) obj) : obj instanceof short[] ? Arrays.hashCode((short[]) obj) : obj instanceof int[] ? Arrays.hashCode((int[]) obj) : obj instanceof long[] ? Arrays.hashCode((long[]) obj) : obj instanceof float[] ? Arrays.hashCode((float[]) obj) : obj instanceof double[] ? Arrays.hashCode((double[]) obj) : obj instanceof char[] ? Arrays.hashCode((char[]) obj) : obj instanceof boolean[] ? Arrays.hashCode((boolean[]) obj) : obj != null ? obj.hashCode() : 0);
        }
        return iL;
    }

    public static long m(CharSequence charSequence) {
        char cCharAt;
        Objects.requireNonNull(charSequence);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length() && ((cCharAt = charSequence.charAt(i3)) == '\t' || cCharAt == ' '); i3++) {
            if (cCharAt == '\t') {
                i2++;
            } else {
                i++;
            }
        }
        return bzo.al(i, i2);
    }

    public static String n(int i, int i2, boolean z) {
        int i3;
        int iMax = Math.max(0, i);
        if (z) {
            i3 = iMax / i2;
            iMax %= i2;
        } else {
            i3 = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append('\t');
        }
        for (int i5 = 0; i5 < iMax; i5++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static final long o(long j) {
        long j2 = (j << 1) + 1;
        int i = aqm.c;
        int i2 = aqn.a;
        return j2;
    }

    public static final long p(long j) {
        if (-4611686018426L > j || j >= 4611686018427L) {
            return o(dqc.az(j));
        }
        long j2 = (j * ((long) 1000000)) << 1;
        int i = aqm.c;
        int i2 = aqn.a;
        return j2;
    }

    public static final void q(ahh ahhVar) {
        brf brfVar = (brf) ahhVar._w(arj.i);
        if (brfVar != null && !brfVar.m()) {
            throw brfVar.n();
        }
    }

    public static long r(afo afoVar, int i, int i2) {
        char c2;
        char[] cArr = afoVar.a;
        while (i < i2 && ((c2 = cArr[i]) == '\t' || c2 == ' ')) {
            i++;
        }
        if (i != i2) {
            while (i2 > 0) {
                char c3 = cArr[i2 - 1];
                if (c3 != '\t' && c3 != ' ') {
                    break;
                }
                i2--;
            }
        }
        return bzo.al(i, i2);
    }

    public static final void s(long j, int i, int i2, byte[] bArr, int i3) {
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = bkx.a[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            bArr[i] = (byte) (i6 >> 8);
            i += 2;
            bArr[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    public static yu t(DexKitBridge dexKitBridge, c cVar) {
        bzo.q(dexKitBridge, "bridge");
        int iG = cVar.g(4);
        int i = iG != 0 ? cVar.b.getInt(iG + cVar.a) : 0;
        int iG2 = cVar.g(6);
        int i2 = iG2 != 0 ? cVar.b.getInt(iG2 + cVar.a) : 0;
        int iG3 = cVar.g(8);
        if (iG3 != 0) {
            cVar.i(iG3 + cVar.a);
        }
        int iG4 = cVar.g(10);
        int i3 = iG4 != 0 ? cVar.b.getInt(iG4 + cVar.a) : 0;
        int iG5 = cVar.g(12);
        String strI = iG5 != 0 ? cVar.i(iG5 + cVar.a) : null;
        if (strI == null) {
            strI = "";
        }
        int iG6 = cVar.g(14);
        int i4 = iG6 != 0 ? cVar.b.getInt(iG6 + cVar.a) : 0;
        Integer numValueOf = i4 != -1 ? Integer.valueOf(i4) : null;
        ArrayList arrayList = new ArrayList();
        int iG7 = cVar.g(16);
        int iK = iG7 != 0 ? cVar.k(iG7) : 0;
        for (int i5 = 0; i5 < iK; i5++) {
            int iG8 = cVar.g(16);
            arrayList.add(Integer.valueOf(iG8 != 0 ? cVar.b.getInt((i5 * 4) + cVar.j(iG8)) : 0));
        }
        ArrayList arrayList2 = new ArrayList();
        int iG9 = cVar.g(18);
        int iK2 = iG9 != 0 ? cVar.k(iG9) : 0;
        for (int i6 = 0; i6 < iK2; i6++) {
            int iG10 = cVar.g(18);
            arrayList2.add(Integer.valueOf(iG10 != 0 ? cVar.b.getInt((i6 * 4) + cVar.j(iG10)) : 0));
        }
        ArrayList arrayList3 = new ArrayList();
        int iG11 = cVar.g(20);
        int iK3 = iG11 != 0 ? cVar.k(iG11) : 0;
        for (int i7 = 0; i7 < iK3; i7++) {
            int iG12 = cVar.g(20);
            arrayList3.add(Integer.valueOf(iG12 != 0 ? cVar.b.getInt((i7 * 4) + cVar.j(iG12)) : 0));
        }
        return new yu(dexKitBridge, i, i2, i3, strI, numValueOf, arrayList, arrayList2, arrayList3);
    }

    public static int u(Context context, int i, String str) {
        TypedValue typedValueAn = cmz.an(context, i, str);
        int i2 = typedValueAn.resourceId;
        return i2 != 0 ? context.getColor(i2) : typedValueAn.data;
    }

    public static int v(View view, int i) {
        Context context = view.getContext();
        TypedValue typedValueAn = cmz.an(view.getContext(), i, view.getClass().getCanonicalName());
        int i2 = typedValueAn.resourceId;
        return i2 != 0 ? context.getColor(i2) : typedValueAn.data;
    }

    public static Intent w(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strY = y(context, componentName);
        if (strY == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strY);
        return y(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static Intent x(hb hbVar) {
        Intent parentActivityIntent = hbVar.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strY = y(hbVar, hbVar.getComponentName());
            if (strY == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(hbVar, strY);
            try {
                return y(hbVar, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strY + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String y(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static final void z(ahh ahhVar, Throwable th) {
        if (th instanceof aoq) {
            th = ((aoq) th).a;
        }
        try {
            ahk ahkVar = (ahk) ahhVar._w(arj.b);
            if (ahkVar != null) {
                ahkVar.f(th);
            } else {
                cmz.aa(ahhVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                aye.j(runtimeException, th);
                th = runtimeException;
            }
            cmz.aa(ahhVar, th);
        }
    }
}
