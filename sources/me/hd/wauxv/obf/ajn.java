package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.alibaba.fastjson2.JSONB;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import net.bytebuddy.asm.Advice;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ajn {
    public static final char[] a = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
            Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f' };
    public static final String[] b = { "NUL", "SOH", "STX", "ETX", "EOT", "ENQ", "ACK", "BEL", "BS", "HT", "LF", "VT",
            "FF", "CR", "SO", "SI", "DLE", "DC1", "DC2", "DC3", "DC4", "NAK", "SYN", "ETB", "CAN", "EM", "SUB", "ESC",
            "FS", "GS", "RS", "US", "SP" };
    public static final Object c = new Object();
    public static Method d;
    public static boolean e;

    public static coe aa(int i, long j) {
        return (coe) coe.a.x(i, j);
    }

    public static int ab(sg sgVar) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        do {
            byte b2 = sgVar.readByte();
            i2 |= (b2 & JSONB.Constants.BC_SYMBOL) << (i4 * 7);
            i3 <<= 7;
            i4++;
            i = b2 & 128;
            if (i != 128) {
                break;
            }
        } while (i4 < 5);
        if (i != 128) {
            return ((i3 >> 1) & i2) != 0 ? i2 | i3 : i2;
        }
        throw new amo("invalid LEB128 sequence", null);
    }

    public static int ac(sg sgVar) {
        int i;
        int i2 = 0;
        int i3 = 0;
        do {
            byte b2 = sgVar.readByte();
            i2 |= (b2 & JSONB.Constants.BC_SYMBOL) << (i3 * 7);
            i3++;
            i = b2 & 128;
            if (i != 128) {
                break;
            }
        } while (i3 < 5);
        if (i != 128) {
            return i2;
        }
        throw new amo("invalid LEB128 sequence", null);
    }

    public static int ad(Context context, int i, int i2) {
        TypedValue typedValueAl = cmz.al(context, i);
        return (typedValueAl == null || typedValueAl.type != 16) ? i2 : typedValueAl.data;
    }

    public static TimeInterpolator ae(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException(
                    "Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!v(strValueOf, "cubic-bezier") && !v(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (v(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return new PathInterpolator(s(strArrSplit, 0), s(strArrSplit, 1), s(strArrSplit, 2), s(strArrSplit, 3));
            }
            throw new IllegalArgumentException(
                    "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: "
                            + strArrSplit.length);
        }
        if (!v(strValueOf, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String strJ = yg.j(strValueOf, 1, 5);
        Path path = new Path();
        try {
            cte.d(l(strJ), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(strJ), e2);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x003f */
    /* JADX WARN: Found duplicated region for block: B:32:0x008b */
    /* JADX WARN: Found duplicated region for block: B:43:0x00bb */
    public static final long af(CodeEditor codeEditor, MotionEvent motionEvent, int i) {
        int i2;
        throwIfVar1IsNull(motionEvent, "event");
        float x = (i == -1 ? motionEvent.getX() : motionEvent.getX(i)) + codeEditor.getOffsetX();
        float y = (i == -1 ? motionEvent.getY() : motionEvent.getY(i)) + codeEditor.getOffsetY();
        float fEa = codeEditor.ea();
        codeEditor.getRenderer().bi();
        float fEb = codeEditor.eb();
        int i3 = 1;
        if (x < 0.0f) {
            i2 = 0;
        } else if (0.0f <= x && x <= fEa) {
            i2 = 1;
        } else if (fEa > x || x > 0 + fEa) {
            float f = fEa + 0;
            if (x > codeEditor.getDividerMarginLeft() + f || f > x) {
                float dividerWidth = codeEditor.getDividerWidth() + codeEditor.getDividerMarginLeft() + f;
                if (x > codeEditor.getDividerWidth() + codeEditor.getDividerMarginRight()
                        + codeEditor.getDividerMarginLeft() + f || dividerWidth > x) {
                    float dividerMarginLeft = codeEditor.getDividerMarginLeft() + f;
                    if (x <= codeEditor.getDividerWidth() + codeEditor.getDividerMarginLeft() + f
                            && dividerMarginLeft <= x) {
                        i2 = 4;
                    } else if (fEb <= x) {
                        if (x > codeEditor.getWidth() + codeEditor.getScrollMaxX()) {
                            if (codeEditor.af || 0.0f > x || x > codeEditor.getWidth()) {
                                i2 = 0;
                            }
                        }
                        i2 = 5;
                    } else {
                        if (codeEditor.af) {
                        }
                        i2 = 0;
                    }
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 3;
            }
        } else {
            i2 = 2;
        }
        if (y >= 0.0f) {
            if (y <= (codeEditor.getHeight() / 2) + codeEditor.getScrollMaxY()) {
                i3 = 0;
            }
        }
        return KotlinHelpers.al(i2, i3);
    }

    public static final Class tryGetClassByClassName(String str) {
        HostInfoRegistry.INSTANCE.getClass();
        return ReflectionWrapper.tryGetClassByName(HostInfoRegistry.getClassLoader(), str);
    }

    public static final String ah(afw afwVar) {
        Object objX;
        if (afwVar instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) afwVar).toString();
        }
        try {
            objX = afwVar + '@' + toHexHashCode(afwVar);
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        if (Success.exceptionOrNull(objX) != null) {
            objX = afwVar.getClass().getName() + '@' + toHexHashCode(afwVar);
        }
        return (String) objX;
    }

    public static int ai(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>= 7;
            i3++;
        }
        return i3 + 1;
    }

    public static void aj(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if ((i4 & 1) != 0) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams
                    ? (ViewGroup.MarginLayoutParams) layoutParams
                    : null;
            i = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
        }
        if ((i4 & 2) != 0) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams
                    ? (ViewGroup.MarginLayoutParams) layoutParams2
                    : null;
            i2 = marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0;
        }
        if ((i4 & 4) != 0) {
            ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams
                    ? (ViewGroup.MarginLayoutParams) layoutParams3
                    : null;
            i3 = marginLayoutParams3 != null ? marginLayoutParams3.rightMargin : 0;
        }
        if ((i4 & 8) != 0) {
            ViewGroup.LayoutParams layoutParams4 = viewGroup.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams4 instanceof ViewGroup.MarginLayoutParams
                    ? (ViewGroup.MarginLayoutParams) layoutParams4
                    : null;
            if (marginLayoutParams4 != null) {
                i5 = marginLayoutParams4.bottomMargin;
            }
        }
        if (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams5 = viewGroup.getLayoutParams();
            if (layoutParams5 == null) {
                throw new NullPointerException(
                        "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
            marginLayoutParams5.setMargins(i, i2, i3, i5);
            viewGroup.setLayoutParams(marginLayoutParams5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object ak(ahh ahhVar, bgj bgjVar, doi doiVar) throws Throwable {
        ahh ahhVar2 = doiVar.m;
        throwIfVar1IsNull(ahhVar2);
        ahh ahhVar_v = !((Boolean) ahhVar._u(Boolean.FALSE, new fq(6))).booleanValue() ? ahhVar2._v(ahhVar)
                : KotlinHelpers.t(ahhVar2, ahhVar, false);
        cna.q(ahhVar_v);
        if (ahhVar_v == ahhVar2) {
            dex dexVar = new dex(ahhVar_v, doiVar);
            return ResourcesCompat.ad(dexVar, dexVar, bgjVar);
        }
        arj arjVar = arj.a;
        if (nullSafeIsEqual(ahhVar_v._w(arjVar), ahhVar2._w(arjVar))) {
            enk enkVar = new enk(ahhVar_v, doiVar);
            ahh ahhVar3 = enkVar.a;
            Object objAl = bhv.al(ahhVar3, null);
            try {
                return ResourcesCompat.ad(enkVar, enkVar, bgjVar);
            } finally {
                bhv.ag(ahhVar3, objAl);
            }
        }
        aos aosVar = new aos(ahhVar_v, doiVar);
        try {
            HugeSyntheticPileOfHelpers.resumeCoroutine(Kotlin$Unit.INSTANCE, cmz.ab(((nc) bgjVar).h(aosVar, aosVar)));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = aos.i;
            do {
                int i = atomicIntegerFieldUpdater.get(aosVar);
                if (i != 0) {
                    if (i != 2) {
                        throw new IllegalStateException("Already suspended");
                    }
                    Object objAk = bhv.ak(brm.r.get(aosVar));
                    if (objAk instanceof abr) {
                        throw ((abr) objAk).c;
                    }
                    return objAk;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(aosVar, 0, 1));
            return ahq.a;
        } catch (Throwable th) {
            th = th;
            if (th instanceof aoq) {
                th = ((aoq) th).a;
            }
            aosVar._bn(FastKV.getFailureFromException(th));
            throw th;
        }
    }

    public static void al(sh shVar, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i4 = i;
        int i5 = i2;
        boolean z = true;
        while (z) {
            z = (i5 == i3 && (i5 & 1) == ((i4 >> 6) & 1)) ? false : true;
            shVar.writeByte((byte) ((i4 & 127) | (z ? 128 : 0)));
            i4 = i5;
            i5 >>= 7;
        }
    }

    public static void am(sh shVar, int i) {
        while (true) {
            int i2 = i;
            i >>>= 7;
            if (i == 0) {
                shVar.writeByte((byte) (i2 & 127));
                return;
            }
            shVar.writeByte((byte) ((i2 & 127) | 128));
        }
    }

    public static final int f(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' <= c2 && c2 < 'G') {
            return c2 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c2);
    }

    public static alq g(ahp ahpVar, ahh ahhVar, bgj bgjVar) {
        ahh ahhVarT = KotlinHelpers.t(ahpVar.e(), ahhVar, true);
        Dispatchers$Default alcVar = aou.a;
        if (ahhVarT != alcVar && ahhVarT._w(arj.a) == null) {
            ahhVarT = ahhVarT._v(alcVar);
        }
        alq alqVar = new alq(ahhVarT, true);
        alqVar.h(ahs.a, alqVar, bgjVar);
        return alqVar;
    }

    public static boolean h(cte[] cteVarArr, cte[] cteVarArr2) {
        if (cteVarArr == null || cteVarArr2 == null || cteVarArr.length != cteVarArr2.length) {
            return false;
        }
        for (int i = 0; i < cteVarArr.length; i++) {
            cte cteVar = cteVarArr[i];
            char c2 = cteVar.a;
            cte cteVar2 = cteVarArr2[i];
            if (c2 != cteVar2.a || cteVar.b.length != cteVar2.b.length) {
                return false;
            }
        }
        return true;
    }

    public static final void i(int i, int i2, dfx dfxVar) {
        if (i > 0) {
            return;
        }
        throw new SomeIllegalArgumentException(i + " is not allowed in ProtoNumber for property '" + dfxVar.j(i2) + "' of '" + dfxVar.b()
                + "', because protobuf supports field numbers in range 1..2147483647");
    }

    public static int j(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static float[] k(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x002c */
    /* JADX WARN: Found duplicated region for block: B:17:0x0042 */
    /* JADX WARN: Found duplicated region for block: B:41:0x0091 */
    /*
     * JADX WARN: Found duplicated region for block: B:46:0x009c A[Catch:
     * NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException ->
     * 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a,
     * B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }]
     */
    /* JADX WARN: Found duplicated region for block: B:50:0x00ae */
    /*
     * JADX WARN: Found duplicated region for block: B:52:0x00b1 A[Catch:
     * NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException ->
     * 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a,
     * B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }]
     */
    /* JADX WARN: Found duplicated region for block: B:57:0x00c9 */
    /* JADX WARN: Found duplicated region for block: B:72:0x00d7 A[SYNTHETIC] */
    public static cte[] l(String str) {
        int i;
        String strTrim;
        float[] fArrK;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i4 < str.length()) {
            while (i4 < str.length()) {
                char cCharAt = str.charAt(i4);
                if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                    if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                        continue;
                    } else if (cCharAt != 'e' && cCharAt != 'E') {
                        strTrim = str.substring(i3, i4).trim();
                        if (strTrim.isEmpty()) {
                            if (strTrim.charAt(i2) == 'z' && strTrim.charAt(i2) != 'Z') {
                                try {
                                    float[] fArr = new float[strTrim.length()];
                                    int length = strTrim.length();
                                    int i5 = i2;
                                    int i6 = 1;
                                    while (i6 < length) {
                                        int i7 = i2;
                                        int i8 = i7;
                                        int i9 = i8;
                                        int i10 = i9;
                                        for (int i11 = i6; i11 < strTrim.length(); i11++) {
                                            char cCharAt2 = strTrim.charAt(i11);
                                            if (cCharAt2 == ' ') {
                                                i7 = 0;
                                                i9 = 1;
                                            } else if (cCharAt2 != 'E' && cCharAt2 != 'e') {
                                                switch (cCharAt2) {
                                                    case ',':
                                                        i7 = 0;
                                                        i9 = 1;
                                                        break;
                                                    case '-':
                                                        if (i11 == i6 || i7 != 0) {
                                                            i7 = 0;
                                                        } else {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                        }
                                                        break;
                                                    case '.':
                                                        if (i8 == 0) {
                                                            i7 = 0;
                                                            i8 = 1;
                                                        } else {
                                                            i7 = 0;
                                                            i9 = 1;
                                                            i10 = 1;
                                                        }
                                                        break;
                                                    default:
                                                        i7 = 0;
                                                        break;
                                                }
                                            } else {
                                                i7 = 1;
                                            }
                                            if (i9 != 0) {
                                                if (i6 < i11) {
                                                    fArr[i5] = Float.parseFloat(strTrim.substring(i6, i11));
                                                    i5++;
                                                }
                                                i6 = i10 != 0 ? i11 : i11 + 1;
                                                i2 = 0;
                                            }
                                        }
                                        if (i6 < i11) {
                                            fArr[i5] = Float.parseFloat(strTrim.substring(i6, i11));
                                            i5++;
                                        }
                                        if (i10 != 0) {
                                        }
                                        i2 = 0;
                                    }
                                    fArrK = k(fArr, i5);
                                    i2 = 0;
                                } catch (NumberFormatException e2) {
                                    throw new RuntimeException(concat("error in parsing \"", strTrim, "\""), e2);
                                }
                            }
                            arrayList.add(new cte(strTrim.charAt(i2), fArrK));
                        }
                        i3 = i4;
                        i4++;
                        i2 = 0;
                    }
                } else if (cCharAt != 'e') {
                    continue;
                }
                i4++;
            }
            strTrim = str.substring(i3, i4).trim();
            if (strTrim.isEmpty()) {
                fArrK = strTrim.charAt(i2) == 'z' ? new float[i2] : new float[i2];
                arrayList.add(new cte(strTrim.charAt(i2), fArrK));
            }
            i3 = i4;
            i4++;
            i2 = 0;
        }
        if (i4 - i3 != 1 || i3 >= str.length()) {
            i = 0;
        } else {
            i = 0;
            arrayList.add(new cte(str.charAt(i3), new float[0]));
        }
        return (cte[]) arrayList.toArray(new cte[i]);
    }

    public static cte[] m(cte[] cteVarArr) {
        cte[] cteVarArr2 = new cte[cteVarArr.length];
        for (int i = 0; i < cteVarArr.length; i++) {
            cteVarArr2[i] = new cte(cteVarArr[i]);
        }
        return cteVarArr2;
    }

    public static final long n(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        List listK = dfxVar.k(i);
        int i2 = i + 1;
        int size = listK.size();
        IntEncodingEnum intEncodingVarType = IntEncodingEnum.DEFAULT;
        int iNumber = i2;
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            Annotation annotation = (Annotation) listK.get(i3);
            if (annotation instanceof cwg) {
                iNumber = ((cwg) annotation).number();
                i(iNumber, i3, dfxVar);
            } else if (annotation instanceof cwj) {
                intEncodingVarType = ((cwj) annotation).type();
            } else if (annotation instanceof cwi) {
                z2 = true;
            } else if (annotation instanceof cwh) {
                z = true;
            }
        }
        if (!z) {
            i2 = iNumber;
        }
        return ((long) i2) | (z ? 68719476736L : 0L) | (z2 ? 4294967296L : 0L) | intEncodingVarType.value;
    }

    public static final int o(dfx dfxVar, int i, boolean z) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        List listK = dfxVar.k(i);
        if (!z) {
            i++;
        }
        int size = listK.size();
        for (int i2 = 0; i2 < size; i2++) {
            Annotation annotation = (Annotation) listK.get(i2);
            if (annotation instanceof cwh) {
                return -2;
            }
            if (annotation instanceof cwg) {
                i = ((cwg) annotation).number();
                if (!z) {
                    i(i, i2, dfxVar);
                }
            }
        }
        return i;
    }

    public static final List p(dfx dfxVar, cbm cbmVar) {
        List<dfx> listZ;
        throwIfVar1IsNull(dfxVar, "<this>");
        throwIfVar1IsNull(cbmVar, "serializersModule");
        emc emcVarH = dfxVar.h();
        if (nullSafeIsEqual(emcVarH, cuq.a)) {
            IEmpty5 bsvVarQ = bhs.q(dfxVar);
            listZ = EmptyReadonlyList.INSTANCE;
            if (bsvVarQ != null) {
                listZ = new ArrayList(StaticHelpers4.ak(listZ, 10));
            }
        } else {
            if (!nullSafeIsEqual(emcVarH, cuq.b)) {
                throw new IllegalArgumentException("Class " + dfxVar.b()
                        + " should be abstract or sealed or interface to be used as @ProtoOneOf property.");
            }
            dfx dfxVarL = dfxVar.l(1);
            throwIfVar1IsNull(dfxVarL, "<this>");
            listZ = StaticHelpers5.z(new boz(dfxVarL, 2));
        }
        for (dfx dfxVar2 : listZ) {
            List listK = dfxVar2.k(0);
            if (listK == null || !listK.isEmpty()) {
                Iterator it = listK.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!(((Annotation) it.next()) instanceof cwg));
            }
            throw new IllegalArgumentException(dfxVar2.b() + " implementing oneOf type " + dfxVar.b()
                    + " should have @ProtoNumber annotation in its single property.");
        }
        return listZ;
    }

    public static final String toHexHashCode(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final IntEncodingEnum r(long j) {
        long j2 = j & 25769803776L;
        return j2 == 0 ? IntEncodingEnum.DEFAULT : j2 == 8589934592L ? IntEncodingEnum.SIGNED : IntEncodingEnum.FIXED;
    }

    public static float s(String[] strArr, int i) {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException(
                "Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    public static String t(char c2) {
        return c2 < ' ' ? b[c2] : c2 == 127 ? "DEL" : "UNK";
    }

    public static boolean u(char c2) {
        if (c2 != '\t') {
            return c2 < ' ' || c2 == 127;
        }
        return false;
    }

    public static boolean v(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static final boolean w(long j) {
        return (j & 68719476736L) != 0;
    }

    public static final boolean x(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "<this>");
        emc emcVarH = dfxVar.h();
        return !nullSafeIsEqual(emcVarH, cvm.s) && (emcVarH instanceof cvn);
    }

    public static dmf y(ahp ahpVar, ahh ahhVar, bgj bgjVar) {
        ahh ahhVarT = KotlinHelpers.t(ahpVar.e(), ahhVar, true);
        Dispatchers$Default alcVar = aou.a;
        if (ahhVarT != alcVar && ahhVarT._w(arj.a) == null) {
            ahhVarT = ahhVarT._v(alcVar);
        }
        dmf dmfVar = new dmf(ahhVarT, true);
        dmfVar.h(ahs.a, dmfVar, bgjVar);
        return dmfVar;
    }

    public static Typeface z(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE
                || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, HugeSyntheticPileOfHelpers.as(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000),
                typeface.isItalic());
    }
}
