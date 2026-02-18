package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjm {
    public static final ThreadLocal a = new ThreadLocal();
    public final Context b;
    public final ckm c;

    public cjm(Context context, ckm ckmVar) {
        throwIfVar1IsNull(ckmVar, "navigatorProvider");
        this.b = context;
        this.c = ckmVar;
    }

    /* JADX WARN: Found duplicated region for block: B:207:0x0379 */
    /* JADX WARN: Found duplicated region for block: B:209:0x0383 */
    /* JADX WARN: Found duplicated region for block: B:211:0x0396 */
    /* JADX WARN: Found duplicated region for block: B:212:0x03a9 */
    /* JADX WARN: Found duplicated region for block: B:214:0x03ad */
    /* JADX WARN: Found duplicated region for block: B:215:0x03b7 */
    /* JADX WARN: Found duplicated region for block: B:217:0x03bb */
    /* JADX WARN: Found duplicated region for block: B:218:0x03c5 */
    /* JADX WARN: Found duplicated region for block: B:220:0x03c9 */
    /* JADX WARN: Found duplicated region for block: B:221:0x03d3 */
    public static cin d(TypedArray typedArray, Resources resources, int i) throws XmlPullParserException {
        boolean z;
        ps psVar;
        pr prVar;
        cjv cjvVar;
        Class cls;
        ps psVar2;
        boolean z2;
        Object objI;
        cjv cjuVar;
        Class<?> componentType;
        boolean z3;
        boolean z4 = typedArray.getBoolean(3, false);
        ThreadLocal threadLocal = a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(2);
        cjv cjvVarM = cjv.l;
        pr prVar2 = cjv.s;
        pr prVar3 = cjv.y;
        pr prVar4 = cjv.v;
        pr prVar5 = cjv.p;
        pr prVar6 = cjv.m;
        ps psVar3 = cjv.o;
        ps psVar4 = cjv.u;
        ps psVar5 = cjv.x;
        cjv cjvVar2 = cjv.r;
        ps psVar6 = cjv.k;
        if (string != null) {
            prVar = prVar4;
            String resourcePackageName = resources.getResourcePackageName(i);
            if ("integer".equals(string)) {
                z = z4;
                cjvVar = psVar6;
            } else {
                z = z4;
                cjvVar = "integer[]".equals(string) ? prVar6
                        : "List<Int>".equals(string) ? cjv.n
                                : "long".equals(string) ? psVar3
                                        : "long[]".equals(string) ? prVar5
                                                : "List<Long>".equals(string) ? cjv.q
                                                        : "boolean".equals(string) ? psVar4
                                                                : "boolean[]".equals(string) ? prVar
                                                                        : "List<Boolean>".equals(string) ? cjv.w
                                                                                : "string".equals(string) ? psVar5
                                                                                        : "string[]".equals(string)
                                                                                                ? prVar3
                                                                                                : "List<String>"
                                                                                                        .equals(string)
                                                                                                                ? cjv.z
                                                                                                                : "float"
                                                                                                                        .equals(string)
                                                                                                                                ? cjvVar2
                                                                                                                                : "float[]"
                                                                                                                                        .equals(string)
                                                                                                                                                ? prVar2
                                                                                                                                                : "List<Float>"
                                                                                                                                                        .equals(string)
                                                                                                                                                                ? cjv.t
                                                                                                                                                                : null;
            }
            if (cjvVar != null) {
                psVar = psVar3;
            } else if ("reference".equals(string)) {
                psVar = psVar3;
                cjvVar = cjvVarM;
            } else if (string.length() == 0) {
                cjvVar = psVar5;
                psVar = psVar3;
            } else {
                try {
                    psVar = psVar3;
                    String strConcat = (!dnr.bp(string, ".", false) || resourcePackageName == null) ? string
                            : resourcePackageName.concat(string);
                    boolean zBi = dnr.bi(string, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    if (zBi) {
                        z3 = zBi;
                        strConcat = strConcat.substring(0, strConcat.length() - 2);
                        throwIfVar1IsNull(strConcat, "substring(...)");
                    } else {
                        z3 = zBi;
                    }
                    Class<?> cls2 = Class.forName(strConcat);
                    cjv cjrVar = Parcelable.class.isAssignableFrom(cls2) ? z3 ? new cjr(cls2) : new cjs(cls2)
                            : (!Enum.class.isAssignableFrom(cls2) || z3)
                                    ? Serializable.class.isAssignableFrom(cls2) ? z3 ? new cjt(cls2) : new cju(cls2)
                                            : null
                                    : new cjq(cls2);
                    if (cjrVar == null) {
                        throw new IllegalArgumentException(
                                (strConcat + " is not Serializable or Parcelable.").toString());
                    }
                    cjvVar = cjrVar;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            z = z4;
            psVar = psVar3;
            prVar = prVar4;
            cjvVar = null;
        }
        boolean z5 = true;
        if (typedArray.getValue(1, typedValue)) {
            cls = Serializable.class;
            if (cjvVar == cjvVarM) {
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    objI = Integer.valueOf(i2);
                    z2 = false;
                } else {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for "
                                + cjvVar.g() + ". Must be a reference to a resource.");
                    }
                    z2 = false;
                    objI = 0;
                }
                cjvVarM = cjvVar;
            } else {
                z2 = false;
                int i3 = typedValue.resourceId;
                if (i3 == 0) {
                    if (cjvVar == psVar5) {
                        z5 = true;
                        objI = typedArray.getString(1);
                        cjvVarM = cjvVar;
                    } else {
                        z5 = true;
                        int i4 = typedValue.type;
                        if (i4 == 3) {
                            String string2 = typedValue.string.toString();
                            if (cjvVar == null) {
                                throwIfVar1IsNull(string2, "value");
                                try {
                                    psVar6.i(string2);
                                    cjvVar = psVar6;
                                    psVar2 = psVar;
                                } catch (IllegalArgumentException unused) {
                                    psVar2 = psVar;
                                    try {
                                        try {
                                            try {
                                                psVar2.i(string2);
                                                cjvVar = psVar2;
                                            } catch (IllegalArgumentException unused2) {
                                                psVar4.i(string2);
                                                cjvVar = psVar4;
                                            }
                                        } catch (IllegalArgumentException unused3) {
                                            cjvVar2.i(string2);
                                            cjvVar = cjvVar2;
                                        }
                                    } catch (IllegalArgumentException unused4) {
                                        cjvVar = psVar5;
                                    }
                                }
                            } else {
                                psVar2 = psVar;
                            }
                            cjvVarM = cjvVar;
                            objI = cjvVarM.i(string2);
                        } else if (i4 == 4) {
                            cjvVarM = KotlinHelpers.m(typedValue, cjvVar, cjvVar2, string, "float");
                            objI = Float.valueOf(typedValue.getFloat());
                        } else if (i4 == 5) {
                            cjvVarM = KotlinHelpers.m(typedValue, cjvVar, psVar6, string, "dimension");
                            objI = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                        } else if (i4 == 18) {
                            cjvVarM = KotlinHelpers.m(typedValue, cjvVar, psVar4, string, "boolean");
                            objI = Boolean.valueOf(typedValue.data != 0);
                        } else {
                            if (i4 < 16 || i4 > 31) {
                                throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                            }
                            if (cjvVar == cjvVar2) {
                                cjvVarM = KotlinHelpers.m(typedValue, cjvVar, cjvVar2, string, "float");
                                objI = Float.valueOf(typedValue.data);
                            } else {
                                cjvVarM = KotlinHelpers.m(typedValue, cjvVar, psVar6, string, "integer");
                                objI = Integer.valueOf(typedValue.data);
                            }
                        }
                    }
                    psVar2 = psVar;
                } else {
                    if (cjvVar != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for "
                                + cjvVar.g() + ". You must use a \"reference\" type to reference other resources.");
                    }
                    objI = Integer.valueOf(i3);
                }
            }
            psVar2 = psVar;
            z5 = true;
        } else {
            cls = Serializable.class;
            psVar2 = psVar;
            z2 = false;
            cjvVarM = cjvVar;
            objI = null;
        }
        if (objI == null) {
            z5 = z2;
            objI = null;
        }
        if (cjvVarM == null) {
            cjvVarM = null;
        }
        if (cjvVarM == null) {
            if (objI instanceof Integer) {
                cjvVar2 = psVar6;
            } else if (objI instanceof int[]) {
                cjvVar2 = prVar6;
            } else if (objI instanceof Long) {
                cjvVar2 = psVar2;
            } else if (objI instanceof long[]) {
                cjvVar2 = prVar5;
            } else if (!(objI instanceof Float) && !(objI instanceof float[])) {
                cjvVar2 = objI instanceof Boolean ? psVar4
                        : objI instanceof boolean[] ? prVar
                                : ((objI instanceof String) || objI == null) ? psVar5 : null;
            }
            if (cjvVar2 == null) {
                cjvVar2 = prVar2;
                if ((objI instanceof Object[]) && (((Object[]) objI) instanceof String[])) {
                    cjuVar = prVar3;
                } else {
                    throwIfVar1IsNull(objI);
                    if (objI.getClass().isArray()) {
                        Class<?> componentType2 = objI.getClass().getComponentType();
                        throwIfVar1IsNull(componentType2);
                        if (Parcelable.class.isAssignableFrom(componentType2)) {
                            Class<?> componentType3 = objI.getClass().getComponentType();
                            throwIfVar1IsNull(componentType3,
                                    "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                            cjuVar = new cjr(componentType3);
                        } else if (objI.getClass().isArray()) {
                            componentType = objI.getClass().getComponentType();
                            throwIfVar1IsNull(componentType);
                            if (cls.isAssignableFrom(componentType)) {
                                Class<?> componentType4 = objI.getClass().getComponentType();
                                throwIfVar1IsNull(componentType4,
                                        "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                                cjuVar = new cjt(componentType4);
                            } else if (objI instanceof Parcelable) {
                                cjuVar = new cjs(objI.getClass());
                            } else if (objI instanceof Enum) {
                                cjuVar = new cjq(objI.getClass());
                            } else {
                                if (objI instanceof Serializable) {
                                    throw new IllegalArgumentException("Object of type " + objI.getClass().getName()
                                            + " is not supported for navigation arguments.");
                                }
                                cjuVar = new cju(objI.getClass());
                            }
                        } else if (objI instanceof Parcelable) {
                            cjuVar = new cjs(objI.getClass());
                        } else if (objI instanceof Enum) {
                            cjuVar = new cjq(objI.getClass());
                        } else {
                            if (objI instanceof Serializable) {
                                throw new IllegalArgumentException("Object of type " + objI.getClass().getName()
                                        + " is not supported for navigation arguments.");
                            }
                            cjuVar = new cju(objI.getClass());
                        }
                    } else if (objI.getClass().isArray()) {
                        componentType = objI.getClass().getComponentType();
                        throwIfVar1IsNull(componentType);
                        if (cls.isAssignableFrom(componentType)) {
                            Class<?> componentType42 = objI.getClass().getComponentType();
                            throwIfVar1IsNull(componentType42,
                                    "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                            cjuVar = new cjt(componentType42);
                        } else if (objI instanceof Parcelable) {
                            cjuVar = new cjs(objI.getClass());
                        } else if (objI instanceof Enum) {
                            cjuVar = new cjq(objI.getClass());
                        } else {
                            if (objI instanceof Serializable) {
                                throw new IllegalArgumentException("Object of type " + objI.getClass().getName()
                                        + " is not supported for navigation arguments.");
                            }
                            cjuVar = new cju(objI.getClass());
                        }
                    } else if (objI instanceof Parcelable) {
                        cjuVar = new cjs(objI.getClass());
                    } else if (objI instanceof Enum) {
                        cjuVar = new cjq(objI.getClass());
                    } else {
                        if (objI instanceof Serializable) {
                            throw new IllegalArgumentException("Object of type " + objI.getClass().getName()
                                    + " is not supported for navigation arguments.");
                        }
                        cjuVar = new cju(objI.getClass());
                    }
                }
            } else {
                cjvVar2 = prVar2;
                cjuVar = cjvVar2;
            }
            cjvVarM = cjuVar;
        }
        return new cin(cjvVarM, z, objI, z5);
    }

    public final cjg e(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i)
            throws XmlPullParserException, IOException {
        int depth;
        Context context;
        ea eaVar;
        int i2;
        TypedArray typedArray;
        Object obj;
        String strBo;
        String strBo2;
        int i3 = i;
        String name = xmlResourceParser.getName();
        throwIfVar1IsNull(name, "getName(...)");
        cjg cjgVarC = this.c.d(name).c();
        Context context2 = this.b;
        cjgVarC.d(context2, attributeSet);
        ea eaVar2 = cjgVarC.g;
        int i4 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i4 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                boolean zEquals = "argument".equals(name2);
                int[] iArr = cyc.b;
                if (zEquals) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArr);
                    throwIfVar1IsNull(typedArrayObtainAttributes, "obtainAttributes(...)");
                    String string = typedArrayObtainAttributes.getString(0);
                    if (string == null) {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                    cin cinVarD = d(typedArrayObtainAttributes, resources, i3);
                    eaVar2.getClass();
                    ((LinkedHashMap) eaVar2.e).put(string, cinVarD);
                    typedArrayObtainAttributes.recycle();
                } else if ("deepLink".equals(name2)) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(attributeSet, cyc.c);
                    throwIfVar1IsNull(typedArrayObtainAttributes2, "obtainAttributes(...)");
                    String string2 = typedArrayObtainAttributes2.getString(3);
                    String string3 = typedArrayObtainAttributes2.getString(1);
                    String string4 = typedArrayObtainAttributes2.getString(2);
                    if ((string2 == null || string2.length() == 0) && ((string3 == null || string3.length() == 0)
                            && (string4 == null || string4.length() == 0))) {
                        throw new XmlPullParserException(
                                "Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                    }
                    String strBo3 = null;
                    if (string2 != null) {
                        String packageName = context2.getPackageName();
                        throwIfVar1IsNull(packageName, "getPackageName(...)");
                        strBo = dnr.bo(string2, "${applicationId}", packageName);
                    } else {
                        strBo = null;
                    }
                    if (string3 == null || string3.length() == 0) {
                        strBo2 = null;
                    } else {
                        String packageName2 = context2.getPackageName();
                        throwIfVar1IsNull(packageName2, "getPackageName(...)");
                        strBo2 = dnr.bo(string3, "${applicationId}", packageName2);
                        if (strBo2.length() <= 0) {
                            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                        }
                    }
                    if (string4 != null) {
                        String packageName3 = context2.getPackageName();
                        throwIfVar1IsNull(packageName3, "getPackageName(...)");
                        strBo3 = dnr.bo(string4, "${applicationId}", packageName3);
                    }
                    cjd cjdVar = new cjd(strBo, strBo2, strBo3);
                    eaVar2.getClass();
                    ArrayList arrayListAk = bhu.ak((LinkedHashMap) eaVar2.e, new cjh(cjdVar, 0));
                    if (!arrayListAk.isEmpty()) {
                        StringBuilder sbZ = dkz.z("Deep link ", strBo, " can't be used to open destination ");
                        sbZ.append((cjg) eaVar2.b);
                        sbZ.append(".\nFollowing required arguments are missing: ");
                        sbZ.append(arrayListAk);
                        throw new IllegalArgumentException(sbZ.toString().toString());
                    }
                    ((ArrayList) eaVar2.c).add(cjdVar);
                    typedArrayObtainAttributes2.recycle();
                } else {
                    if (com.umeng.ccg.a.z.equals(name2)) {
                        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet,
                                cyc.a, 0, 0);
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                        context = context2;
                        cim cimVar = new cim(typedArrayObtainStyledAttributes.getResourceId(1, 0));
                        cimVar.b = new cjo(typedArrayObtainStyledAttributes.getBoolean(4, false),
                                typedArrayObtainStyledAttributes.getBoolean(10, false),
                                typedArrayObtainStyledAttributes.getResourceId(7, -1),
                                typedArrayObtainStyledAttributes.getBoolean(8, false),
                                typedArrayObtainStyledAttributes.getBoolean(9, false),
                                typedArrayObtainStyledAttributes.getResourceId(2, -1),
                                typedArrayObtainStyledAttributes.getResourceId(3, -1),
                                typedArrayObtainStyledAttributes.getResourceId(5, -1),
                                typedArrayObtainStyledAttributes.getResourceId(6, -1));
                        Bundle bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        eaVar = eaVar2;
                        int i5 = 1;
                        int depth3 = xmlResourceParser.getDepth() + 1;
                        i2 = depth2;
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == i5) {
                                typedArray = typedArrayObtainStyledAttributes;
                                break;
                            }
                            int depth4 = xmlResourceParser.getDepth();
                            typedArray = typedArrayObtainStyledAttributes;
                            if (depth4 < depth3 && next2 == 3) {
                                break;
                            }
                            if (next2 == 2 && depth4 <= depth3) {
                                if ("argument".equals(xmlResourceParser.getName())) {
                                    TypedArray typedArrayObtainAttributes3 = resources.obtainAttributes(attributeSet,
                                            iArr);
                                    throwIfVar1IsNull(typedArrayObtainAttributes3, "obtainAttributes(...)");
                                    String string5 = typedArrayObtainAttributes3.getString(0);
                                    if (string5 == null) {
                                        throw new XmlPullParserException("Arguments must have a name");
                                    }
                                    cin cinVarD2 = d(typedArrayObtainAttributes3, resources, i3);
                                    boolean z = cinVarD2.c;
                                    if (z && z && (obj = cinVarD2.d) != null) {
                                        cinVarD2.a.j(bundleR, string5, obj);
                                    }
                                    typedArrayObtainAttributes3.recycle();
                                }
                                i3 = i;
                            }
                            typedArrayObtainStyledAttributes = typedArray;
                            i5 = 1;
                        }
                        if (!bundleR.isEmpty()) {
                            cimVar.c = bundleR;
                        }
                        if (cjgVarC instanceof dl) {
                            throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + cjgVarC
                                    + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
                        }
                        if (resourceId == 0) {
                            throw new IllegalArgumentException("Cannot have an action with actionId 0");
                        }
                        cjgVarC.j.h(resourceId, cimVar);
                        typedArray.recycle();
                    } else {
                        context = context2;
                        eaVar = eaVar2;
                        i2 = depth2;
                        if ("include".equals(name2) && (cjgVarC instanceof cji)) {
                            TypedArray typedArrayObtainAttributes4 = resources.obtainAttributes(attributeSet, cyb.c);
                            throwIfVar1IsNull(typedArrayObtainAttributes4, "obtainAttributes(...)");
                            ((cji) cjgVarC).c(f(typedArrayObtainAttributes4.getResourceId(0, 0)));
                            typedArrayObtainAttributes4.recycle();
                        } else if (cjgVarC instanceof cji) {
                            ((cji) cjgVarC).c(e(resources, xmlResourceParser, attributeSet, i));
                        }
                    }
                    i3 = i;
                    depth2 = i2;
                    context2 = context;
                    eaVar2 = eaVar;
                }
                i4 = 1;
            }
        }
        return cjgVarC;
    }

    public final cji f(int i) {
        int next;
        Resources resources = this.b.getResources();
        XmlResourceParser xml = resources.getXml(i);
        throwIfVar1IsNull(xml, "getXml(...)");
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(
                            "Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } catch (Throwable th) {
                xml.close();
                throw th;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        throwIfVar1IsNull(attributeSetAsAttributeSet);
        cjg cjgVarE = e(resources, xml, attributeSetAsAttributeSet, i);
        if (cjgVarE instanceof cji) {
            cji cjiVar = (cji) cjgVarE;
            xml.close();
            return cjiVar;
        }
        throw new IllegalArgumentException(("Root element <" + name + "> did not inflate into a NavGraph").toString());
    }
}
