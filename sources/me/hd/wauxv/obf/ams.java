package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import net.bytebuddy.pool.TypePool;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ams {
    public static final LinkedHashMap a;
    public static final LinkedHashMap b;

    static {
        Pair[] pairVarArr = { new Pair("boolean", "Z"), new Pair("byte", "B"), new Pair("char", "C"),
                new Pair("short", "S"),
                new Pair("int", "I"), new Pair("float", "F"), new Pair("long", "J"), new Pair("double", "D"),
                new Pair("void", "V") };
        int iAh = KotlinHelpers.ah(9);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iAh);
        KotlinHelpers.am(linkedHashMap, pairVarArr);
        a = linkedHashMap;
        Pair[] pairVarArr2 = { new Pair("Z", "boolean"), new Pair("B", "byte"), new Pair("C", "char"),
                new Pair("S", "short"),
                new Pair("I", "int"), new Pair("F", "float"), new Pair("J", "long"), new Pair("D", "double"),
                new Pair("V", "void") };
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iAh);
        KotlinHelpers.am(linkedHashMap2, pairVarArr2);
        b = linkedHashMap2;
    }

    public static final String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        throwIfVar1IsNull(parameterTypes, "getParameterTypes(...)");
        return yg.concatToVar1(sb, SomeStaticHelpers.u(parameterTypes, "", null, null, new amb(3), 30), ")V");
    }

    public static final String d(Method method) {
        StringBuilder sb = new StringBuilder("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        throwIfVar1IsNull(parameterTypes, "getParameterTypes(...)");
        sb.append(SomeStaticHelpers.u(parameterTypes, "", null, null, new amb(2), 30));
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        throwIfVar1IsNull(returnType, "getReturnType(...)");
        sb.append(g(returnType));
        return sb.toString();
    }

    public static final String e(Class cls) {
        throwIfVar1IsNull(cls, "clazz");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            throwIfVar1IsNull(componentType);
            return dkz.s(e(componentType), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        if (!cls.isPrimitive()) {
            return cls.getName();
        }
        if (cls.equals(Boolean.TYPE)) {
            return "boolean";
        }
        if (cls.equals(Byte.TYPE)) {
            return "byte";
        }
        if (cls.equals(Character.TYPE)) {
            return "char";
        }
        if (cls.equals(Short.TYPE)) {
            return "short";
        }
        if (cls.equals(Integer.TYPE)) {
            return "int";
        }
        if (cls.equals(Float.TYPE)) {
            return "float";
        }
        if (cls.equals(Long.TYPE)) {
            return "long";
        }
        if (cls.equals(Double.TYPE)) {
            return "double";
        }
        if (cls.equals(Void.TYPE)) {
            return "void";
        }
        throw new IllegalStateException(concatVar2Var1(cls, "Unknown primitive type: "));
    }

    public static final String f(String str) {
        throwIfVar1IsNull(str, "typeSign");
        if (str.charAt(0) == '[') {
            String strSubstring = str.substring(1);
            throwIfVar1IsNull(strSubstring, "substring(...)");
            return dkz.s(f(strSubstring), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        if (str.length() == 1) {
            String str2 = (String) b.get(str);
            if (str2 != null) {
                return str2;
            }
            throw new IllegalArgumentException("Unknown primitive typeSign: ".concat(str));
        }
        if (str.charAt(0) != 'L' || str.charAt(str.length() - 1) != ';') {
            throw new IllegalStateException("Unknown class sign: ".concat(str));
        }
        String strSubstring2 = str.substring(1, str.length() - 1);
        throwIfVar1IsNull(strSubstring2, "substring(...)");
        return dnr.bn(strSubstring2, '/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
    }

    public static final String g(Class cls) {
        throwIfVar1IsNull(cls, "type");
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                return concat("L", dnr.bn(cls.getName(),
                        TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), ";");
            }
            Class<?> componentType = cls.getComponentType();
            throwIfVar1IsNull(componentType);
            return yg.k("[", g(componentType));
        }
        if (cls.equals(Boolean.TYPE)) {
            return "Z";
        }
        if (cls.equals(Byte.TYPE)) {
            return "B";
        }
        if (cls.equals(Character.TYPE)) {
            return "C";
        }
        if (cls.equals(Short.TYPE)) {
            return "S";
        }
        if (cls.equals(Integer.TYPE)) {
            return "I";
        }
        if (cls.equals(Float.TYPE)) {
            return "F";
        }
        if (cls.equals(Long.TYPE)) {
            return "J";
        }
        if (cls.equals(Double.TYPE)) {
            return "D";
        }
        if (cls.equals(Void.TYPE)) {
            return "V";
        }
        throw new IllegalStateException(concatVar2Var1(cls, "Unknown primitive type: "));
    }

    public static final String h(String str) {
        throwIfVar1IsNull(str, "typeName");
        if (!dnr.bi(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            String str2 = (String) a.get(str);
            return str2 == null ? concat("L",
                    dnr.bn(str, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), ";")
                    : str2;
        }
        String strSubstring = str.substring(0, str.length() - 2);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return yg.k("[", h(strSubstring));
    }
}
