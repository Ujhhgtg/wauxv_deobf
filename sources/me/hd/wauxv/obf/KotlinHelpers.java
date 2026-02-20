package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.alibaba.fastjson2.JSONB;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import me.hd.wauxv.R;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class KotlinHelpers {
    public static final int[] a = new int[0];
    public static final Object[] b = new Object[0];
    public static final Object c = new Object();
    public static final Object d = new Object();
    public static volatile boolean e = true;

    public static void aa(byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (ad(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || ad(b4)))) {
            throw new IllegalArgumentException("Invalid UTF-8");
        }
        cArr[i] = (char) (((b2 & com.umeng.analytics.pro.dn.m) << 12) | ((b3 & JSONB.Constants.BC_INT32_BYTE_MAX) << 6)
                | (b4 & JSONB.Constants.BC_INT32_BYTE_MAX));
    }

    public static void ab(byte b2, byte b3, char[] cArr, int i) {
        if (b2 < -62) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }
        if (ad(b3)) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & JSONB.Constants.BC_INT32_BYTE_MAX));
    }

    public static boolean ac(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException(
                    "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
    }

    // public static final boolean ae(String str, Bundle bundle) {
    // throwIfVar1IsNull(str, "key");
    // return bundle.containsKey(str) && bundle.get(str) == null;
    // }

    public static Drawable af(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            afv afvVar = new afv(context);
            afvVar.c = theme;
            afvVar.g(theme.getResources().getConfiguration());
            context = afvVar;
        }
        return cmz.y(context, i);
    }

    public static int ag(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException(
                        "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i2 = rect2.top;
            i3 = rect.bottom;
        }
        return Math.max(0, i2 - i3);
    }

    public static int calcHashMapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map mapOf(Pair... pairVarArr) {
        if (pairVarArr.length <= 0) {
            return EmptyReadonlyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(calcHashMapCapacity(pairVarArr.length));
        addVar2PairArrayToVar1Map(linkedHashMap, pairVarArr);
        return linkedHashMap;
    }

    public static int aj(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException(
                                "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void ak(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static long al(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    public static final void addVar2PairArrayToVar1Map(HashMap map, Pair[] pairVarArr) {
        for (Pair pairVar : pairVarArr) {
            map.put(pairVar.first, pairVar.second);
        }
    }

    public static final String an(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i = reader.read(cArr);
        while (i >= 0) {
            stringWriter.write(cArr, 0, i);
            i = reader.read(cArr);
        }
        String string = stringWriter.toString();
        p(string, "toString(...)");
        return string;
    }

    public static void trimStackTraceToClass(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static final ewf ap(brn brnVar, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "desc");
        emc emcVarH = dfxVar.h();
        if (emcVarH instanceof cur) {
            return ewf.d;
        }
        if (f(emcVarH, dnt.b)) {
            return ewf.b;
        }
        if (!f(emcVarH, dnt.c)) {
            return ewf.a;
        }
        dfx dfxVarL = l(dfxVar.l(0), brnVar.c);
        emc emcVarH2 = dfxVarL.h();
        if ((emcVarH2 instanceof cvn) || f(emcVarH2, dga.b)) {
            return ewf.c;
        }
        brnVar.b.getClass();
        throw KotlinHelpers2.aj(dfxVarL);
    }

    // public static void aq() {
    // throw new UnsupportedOperationException(
    // "This function has a reified type parameter and thus can only be inlined at
    // compilation time, not called directly.");
    // }

    // public static void ar(String str) {
    // QueryDidNotReturnUniqueResultRuntimeException abtVar = new
    // QueryDidNotReturnUniqueResultRuntimeException(
    // concat("lateinit property ", str, " has not been initialized"));
    // trimStackTraceToClass(abtVar, KotlinHelpers.class.getName());
    // throw abtVar;
    // }

    public static Map as(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return EmptyReadonlyMap.INSTANCE;
        }
        if (size == 1) {
            Pair pairVar = (Pair) arrayList.get(0);
            throwIfVar1IsNull(pairVar, "pair");
            Map mapSingletonMap = Collections.singletonMap(pairVar.first, pairVar.second);
            p(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(calcHashMapCapacity(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pairVar2 = (Pair) it.next();
            linkedHashMap.put(pairVar2.first, pairVar2.second);
        }
        return linkedHashMap;
    }

    public static Map at(Map map) {
        throwIfVar1IsNull(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return EmptyReadonlyMap.INSTANCE;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        throwIfVar1IsNull(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        p(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [me.hd.wauxv.obf.afx] */
    /* JADX WARN: Type inference failed for: r2v1, types: [me.hd.wauxv.obf.ahr] */
    /* JADX WARN: Type inference failed for: r2v2, types: [me.hd.wauxv.obf.ahr] */
    public static final enk au(afx afxVar, ahh ahhVar, Object obj) {
        enk enkVar = null;
        if (afxVar != 0 && ahhVar._w(enl.a) != null) {
            while (!(afxVar instanceof aos) && (afxVar = afxVar.k()) != 0) {
                if (afxVar instanceof enk) {
                    enkVar = (enk) afxVar;
                    break;
                }
            }
            if (enkVar != null) {
                enkVar.au(ahhVar, obj);
            }
        }
        return enkVar;
    }

    public static boolean f(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX WARN: Found duplicated region for block: B:24:0x0042 */
    /* JADX WARN: Found duplicated region for block: B:24:0x0042 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:25:0x0044 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:29:0x004d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:30:0x004f A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:31:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:32:0x0053 */
    /* JADX WARN: Found duplicated region for block: B:34:0x0059 */
    /* JADX WARN: Found duplicated region for block: B:36:0x005f */
    /* JADX WARN: Found duplicated region for block: B:37:0x0064 */
    /* JADX WARN: Found duplicated region for block: B:38:0x0069 */
    /* JADX WARN: Found duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    public static boolean g(int i, Rect rect, Rect rect2, Rect rect3) {
        int iAg;
        int i2;
        int i3;
        boolean zH = h(i, rect, rect2);
        if (h(i, rect, rect3) || !zH) {
            return false;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException(
                                "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    if (rect.bottom <= rect3.top) {
                        if (i != 17 && i != 66) {
                            iAg = ag(i, rect, rect2);
                            if (i != 17) {
                                i2 = rect.left;
                                i3 = rect3.left;
                            } else if (i != 33) {
                                i2 = rect.top;
                                i3 = rect3.top;
                            } else if (i != 66) {
                                i2 = rect3.right;
                                i3 = rect.right;
                            } else {
                                if (i == 130) {
                                    throw new IllegalArgumentException(
                                            "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                                }
                                i2 = rect3.bottom;
                                i3 = rect.bottom;
                            }
                            if (iAg < Math.max(1, i2 - i3)) {
                                return false;
                            }
                        }
                    }
                } else if (rect.right <= rect3.left) {
                    if (i != 17) {
                        iAg = ag(i, rect, rect2);
                        if (i != 17) {
                            i2 = rect.left;
                            i3 = rect3.left;
                        } else if (i != 33) {
                            i2 = rect.top;
                            i3 = rect3.top;
                        } else if (i != 66) {
                            i2 = rect3.right;
                            i3 = rect.right;
                        } else {
                            if (i == 130) {
                                throw new IllegalArgumentException(
                                        "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                            }
                            i2 = rect3.bottom;
                            i3 = rect.bottom;
                        }
                        if (iAg < Math.max(1, i2 - i3)) {
                            return false;
                        }
                    }
                }
            } else if (rect.top >= rect3.bottom) {
                if (i != 17) {
                    iAg = ag(i, rect, rect2);
                    if (i != 17) {
                        i2 = rect.left;
                        i3 = rect3.left;
                    } else if (i != 33) {
                        i2 = rect.top;
                        i3 = rect3.top;
                    } else if (i != 66) {
                        i2 = rect3.right;
                        i3 = rect.right;
                    } else {
                        if (i == 130) {
                            throw new IllegalArgumentException(
                                    "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                        i2 = rect3.bottom;
                        i3 = rect.bottom;
                    }
                    if (iAg < Math.max(1, i2 - i3)) {
                        return false;
                    }
                }
            }
        } else if (rect.left >= rect3.right) {
            if (i != 17) {
                iAg = ag(i, rect, rect2);
                if (i != 17) {
                    i2 = rect.left;
                    i3 = rect3.left;
                } else if (i != 33) {
                    i2 = rect.top;
                    i3 = rect3.top;
                } else if (i != 66) {
                    i2 = rect3.right;
                    i3 = rect.right;
                } else {
                    if (i == 130) {
                        throw new IllegalArgumentException(
                                "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i2 = rect3.bottom;
                    i3 = rect.bottom;
                }
                if (iAg < Math.max(1, i2 - i3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean h(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException(
                                "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static final int i(int[] iArr, int i, int i2) {
        throwIfVar1IsNull(iArr, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final int j(long[] jArr, int i, long j) {
        q(jArr, "array");
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static final void k(View view) {
        q(view, "<this>");
        dfu dfuVar = new dfu();
        erg ergVar = new erg(view, dfuVar);
        ergVar.d = dfuVar;
        dfuVar.f = ergVar;
        while (dfuVar.hasNext()) {
            View view2 = (View) dfuVar.next();
            cuu cuuVar = (cuu) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (cuuVar == null) {
                cuuVar = new cuu();
                view2.setTag(R.id.pooling_container_listener_holder_tag, cuuVar);
            }
            ArrayList arrayList = cuuVar.a;
            int iAf = OtherStaticHelpers.af(arrayList);
            if (-1 < iAf) {
                arrayList.get(iAf).getClass();
                throw new ClassCastException();
            }
        }
    }

    public static final dfx l(dfx dfxVar, cbm cbmVar) {
        q(dfxVar, "<this>");
        q(cbmVar, com.umeng.analytics.pro.bt.e);
        if (!f(dfxVar.h(), dga.a)) {
            return dfxVar.d() ? l(dfxVar.l(0), cbmVar) : dfxVar;
        }
        bhs.q(dfxVar);
        return dfxVar;
    }

    public static cjv m(TypedValue typedValue, cjv cjvVar, cjv cjvVar2, String str, String str2)
            throws XmlPullParserException {
        if (cjvVar == null || cjvVar == cjvVar2) {
            return cjvVar == null ? cjvVar2 : cjvVar;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    // public static void n(Object obj) {
    // if (obj != null) {
    // return;
    // }
    // NullPointerException nullPointerException = new NullPointerException();
    // trimStackTraceToClass(nullPointerException, KotlinHelpers.class.getName());
    // throw nullPointerException;
    // }

    // public static void o(Object obj, String str) {
    // if (obj != null) {
    // return;
    // }
    // NullPointerException nullPointerException = new NullPointerException(str);
    // trimStackTraceToClass(nullPointerException, KotlinHelpers.class.getName());
    // throw nullPointerException;
    // }

    // public static void p(Object obj, String str) {
    // if (obj != null) {
    // return;
    // }
    // NullPointerException nullPointerException = new
    // NullPointerException(str.concat(" must not be null"));
    // trimStackTraceToClass(nullPointerException, KotlinHelpers.class.getName());
    // throw nullPointerException;
    // }

    // public static void q(Object obj, String str) {
    // if (obj == null) {
    // StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    // String name = KotlinHelpers.class.getName();
    // int i = 0;
    // while (!stackTrace[i].getClassName().equals(name)) {
    // i++;
    // }
    // while (stackTrace[i].getClassName().equals(name)) {
    // i++;
    // }
    // StackTraceElement stackTraceElement = stackTrace[i];
    // NullPointerException nullPointerException = new NullPointerException(
    // "Parameter specified as non-null is null: method " +
    // stackTraceElement.getClassName() + "."
    // + stackTraceElement.getMethodName() + ", parameter " + str);
    // trimStackTraceToClass(nullPointerException, KotlinHelpers.class.getName());
    // throw nullPointerException;
    // }
    // }

    public static int r(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static final dqs s(ud udVar, aff affVar, boolean z) {
        q(udVar, "position");
        if (z) {
            udVar.c--;
        }
        if (udVar.c <= 0 && z) {
            int i = udVar.b;
            if (i <= 0) {
                ud udVar2 = new ud(0, 0, -1);
                return new dqs(udVar2, udVar2);
            }
            int i2 = i - 1;
            ud udVar3 = new ud(i2, affVar.y(i2).b, -1);
            return new dqs(udVar3, udVar3);
        }
        if (affVar.y(udVar.b).b == udVar.c && udVar.b < affVar.a.size() - 1 && !z) {
            ud udVar4 = new ud(udVar.b + 1, 0, -1);
            return new dqs(udVar4, udVar4);
        }
        afo afoVarY = affVar.y(udVar.b);
        p(afoVarY, "getLine(...)");
        int i3 = udVar.c;
        while (true) {
            if ((z && i3 < 0) || ((!z && i3 == afoVarY.b) || !cmz.ac(afoVarY.charAt(i3)) || (i3 == 0 && z))) {
                break;
            }
            i3 += z ? -1 : 1;
        }
        return y(affVar, udVar.b, i3, false);
    }

    public static final ahh t(ahh ahhVar, ahh ahhVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) ahhVar._u(bool, new fq(6))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) ahhVar2._u(bool, new fq(6))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return ahhVar._v(ahhVar2);
        }
        fq fqVar = new fq(4);
        EmptyCoroutineContext emptyCoroutineContextVar = EmptyCoroutineContext.INSTANCE;
        ahh ahhVar3 = (ahh) ahhVar._u(emptyCoroutineContextVar, fqVar);
        Object obj_u = ahhVar2;
        if (zBooleanValue2) {
            obj_u = ahhVar2._u(emptyCoroutineContextVar, new fq(5));
        }
        return ahhVar3._v((ahh) obj_u);
    }

    public static Drawable u(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (e) {
                return af(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return context2.getDrawable(i);
        } catch (NoClassDefFoundError unused2) {
            e = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = dcu.a;
        return resources.getDrawable(i, theme);
    }

    public static final int v(String str, Bundle bundle) {
        int i = bundle.getInt(str, Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE || bundle.getInt(str, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i;
        }
        cmz.ad(str);
        throw null;
    }

    public static final ArrayList w(String str, Bundle bundle) {
        throwIfVar1IsNull(str, "key");
        ArrayList arrayListC = Build.VERSION.SDK_INT >= 34 ? az.c(bundle, str, HugeSyntheticPileOfHelpers.getJavaClass(dal.getKClassFromClass(Bundle.class)))
                : bundle.getParcelableArrayList(str);
        if (arrayListC != null) {
            return arrayListC;
        }
        cmz.ad(str);
        throw null;
    }

    public static Object x(Map map, Object obj) {
        throwIfVar1IsNull(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    /* JADX WARN: Found duplicated region for block: B:16:0x0048 */
    public static final dqs y(aff affVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        throwIfVar1IsNull(affVar, "text");
        afo afoVarY = affVar.y(i);
        long jX = ResourcesCompat.x(afoVarY, i2, z);
        int i6 = (int) (jX >> 32);
        int i7 = (int) (jX & 4294967295L);
        if (i6 != i7) {
            i3 = i;
            i4 = i7;
            i5 = i6;
        } else {
            if (i7 < afoVarY.b) {
                i4 = i7 + 1;
                i3 = i;
            } else {
                if (i6 > 0) {
                    i5 = i6 - 1;
                    i3 = i;
                } else if (i > 0) {
                    int i8 = i - 1;
                    i5 = affVar.y(i8).b;
                    i3 = i;
                    i = i8;
                } else if (i < affVar.a.size() - 1) {
                    i4 = 0;
                    i3 = i + 1;
                } else {
                    i3 = i;
                    i4 = i7;
                }
                i4 = i7;
            }
            i5 = i6;
        }
        return new dqs(new ud(i, i5, i6), new ud(i3, i4, i7));
    }

    public static void z(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) {
        if (!ad(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !ad(b4) && !ad(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & JSONB.Constants.BC_INT32_BYTE_MAX) << 12)
                        | ((b4 & JSONB.Constants.BC_INT32_BYTE_MAX) << 6) | (b5 & JSONB.Constants.BC_INT32_BYTE_MAX);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid UTF-8");
    }
}
