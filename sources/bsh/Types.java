package bsh;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import me.hd.wauxv.obf.yg;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Types {
    static final int ASSIGNMENT = 1;
    static final int BSH_ASSIGNABLE = 4;
    static final int CAST = 0;
    static final int FIRST_ROUND_ASSIGNABLE = 1;
    static final int JAVA_BASE_ASSIGNABLE = 1;
    static final int JAVA_BOX_TYPES_ASSIGABLE = 2;
    static final int JAVA_VARARGS_ASSIGNABLE = 3;
    static final int LAST_ROUND_ASSIGNABLE = 4;
    private static final Map<Class<?>, Integer> NUMBER_ORDER = Collections.unmodifiableMap(new HashMap<Class<?>, Integer>() { // from class: bsh.Types.1
        private static final long serialVersionUID = 1;

        {
            put(Byte.TYPE, 0);
            put(Byte.class, 1);
            put(Short.TYPE, 2);
            put(Short.class, 3);
            put(Character.TYPE, 4);
            put(Character.class, 5);
            put(Integer.TYPE, 6);
            put(Integer.class, 7);
            put(Long.TYPE, 8);
            put(Long.class, 9);
            put(Float.TYPE, 10);
            put(Float.class, 11);
            put(Double.TYPE, 12);
            put(Double.class, 13);
            put(BigInteger.class, 14);
            put(BigDecimal.class, 15);
        }
    });
    static Primitive VALID_CAST = new Primitive(1);
    static Primitive INVALID_CAST = new Primitive(-1);

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class MapEntry extends AbstractMap.SimpleEntry<Object, Object> {
        private static final long serialVersionUID = 1;

        public MapEntry(Object obj, Object obj2) {
            super(obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Suffix {
        private static final Map<String, Class<?>> m = Collections.unmodifiableMap(new HashMap<String, Class<?>>() { // from class: bsh.Types.Suffix.1
            private static final long serialVersionUID = 1;

            {
                put("O", Byte.TYPE);
                put("S", Short.TYPE);
                put("I", Integer.TYPE);
                put("L", Long.TYPE);
                put("W", BigInteger.class);
                put("w", BigDecimal.class);
                put("d", Double.TYPE);
                put("f", Float.TYPE);
            }
        });

        public static Class<?> getFloatingPointType(Character ch) {
            return m.get(toLowerKey(ch));
        }

        public static Class<?> getIntegralType(Character ch) {
            return m.get(toUpperKey(ch));
        }

        public static boolean isFloatingPoint(Character ch) {
            return m.containsKey(toLowerKey(ch));
        }

        public static boolean isIntegral(Character ch) {
            return m.containsKey(toUpperKey(ch));
        }

        private static String toLowerKey(Character ch) {
            return ch.toString().toLowerCase();
        }

        private static String toUpperKey(Character ch) {
            return ch.toString().toUpperCase();
        }
    }

    public static boolean areSignaturesEqual(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i] != clsArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int arrayDimensions(Class<?> cls) {
        if (cls == null || !cls.isArray()) {
            return 0;
        }
        return cls.getName().lastIndexOf(91) + 1;
    }

    public static Class<?> arrayElementType(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls;
    }

    public static UtilEvalError castError(Class<?> cls, Class<?> cls2, Object obj, int i) {
        return castError(StringUtil.typeString(cls), StringUtil.typeString(cls2), obj, i);
    }

    public static Object castObject(Object obj, Class<?> cls, int i) {
        if (obj != null) {
            return castObject(cls, getType(obj), obj, i, false);
        }
        if (i == 0) {
            return (isPrimitive(cls) || Primitive.isWrapperType(cls)) ? Primitive.getDefaultValue(cls) : Primitive.NULL;
        }
        throw new InterpreterError("Cast error: null fromValue for toType: ".concat(cls.getSimpleName()));
    }

    public static String getBaseName(String str) {
        int iLastIndexOf = str.lastIndexOf("$");
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public static Class<?> getCommonType(Class<?> cls, Class<?> cls2) {
        if (cls != null) {
            if (cls2 == null || cls.isAssignableFrom(cls2)) {
                return cls;
            }
            Map<Class<?>, Integer> map = NUMBER_ORDER;
            if (!map.containsKey(cls) || !map.containsKey(cls2)) {
                do {
                    cls = cls.getSuperclass();
                    if (cls == null || Object.class == cls) {
                        return Object.class;
                    }
                } while (!cls.isAssignableFrom(cls2));
                return cls;
            }
            if (map.get(cls).intValue() >= map.get(cls2).intValue()) {
                return cls;
            }
        }
        return cls2;
    }

    public static Class<?> getType(Object obj) {
        return getType(obj, false);
    }

    public static Class<?>[] getTypes(Object[] objArr) {
        if (objArr == null) {
            return Reflect.ZERO_TYPES;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = getType(objArr[i]);
        }
        return clsArr;
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, int i) {
        if (isFunctionalInterface(cls2) && BshLambda.isAssignable(cls, cls2, i)) {
            return true;
        }
        if (i == 1) {
            return isJavaBaseAssignable(cls2, cls);
        }
        if (i == 2) {
            return isJavaBoxTypesAssignable(cls2, cls);
        }
        if (i == 3) {
            return false;
        }
        if (i == 4) {
            return isBshAssignable(cls2, cls);
        }
        throw new InterpreterError("bad case");
    }

    public static boolean isBshAssignable(Class<?> cls, Class<?> cls2) {
        try {
            return castObject(cls, cls2, null, 1, true) == VALID_CAST;
        } catch (UtilEvalError e) {
            throw new InterpreterError("err in cast check: " + e, e);
        }
    }

    public static boolean isCollectionType(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls);
    }

    public static boolean isFloatingpoint(Object obj) {
        return (obj instanceof Float) || (obj instanceof Double) || (obj instanceof BigDecimal);
    }

    public static boolean isFunctionalInterface(Class<?> cls) {
        return (cls == null || !cls.isInterface() || cls.getAnnotation(FunctionalInterface.class) == null) ? false : true;
    }

    public static boolean isJavaAssignable(Class<?> cls, Class<?> cls2) {
        return isJavaBaseAssignable(cls, cls2) || isJavaBoxTypesAssignable(cls, cls2);
    }

    public static boolean isJavaBaseAssignable(Class<?> cls, Class<?> cls2) {
        if (cls == null) {
            return false;
        }
        if (cls2 == null) {
            return cls == String.class;
        }
        if (cls.isPrimitive() && cls2.isPrimitive()) {
            if (cls == cls2) {
                return true;
            }
            Map<Class<?>, Integer> map = NUMBER_ORDER;
            return map.containsKey(cls2) && map.containsKey(cls) && map.get(cls2).intValue() < map.get(cls).intValue();
        }
        if (((cls == BigInteger.class || cls == BigDecimal.class) && isNumeric(cls2)) || cls.isAssignableFrom(cls2)) {
            return true;
        }
        return false;
    }

    public static boolean isJavaBoxTypesAssignable(Class<?> cls, Class<?> cls2) {
        if (cls == null) {
            return false;
        }
        if (cls == Object.class) {
            return true;
        }
        if (cls2 == null) {
            return (cls.isPrimitive() || cls.isArray()) ? false : true;
        }
        if ((cls != Number.class || cls2 == Character.TYPE || cls2 == Boolean.TYPE) && Primitive.wrapperMap.get(cls) != cls2) {
            return isJavaBaseAssignable(cls, cls2);
        }
        return true;
    }

    public static boolean isNumeric(Object obj) {
        return (obj instanceof Number) || (obj instanceof Character);
    }

    public static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == BigInteger.class || cls == BigDecimal.class;
    }

    public static boolean isPropertyType(Class<?> cls) {
        return isPropertyTypeMap(cls) || isPropertyTypeEntry(cls) || isPropertyTypeEntryList(cls);
    }

    public static boolean isPropertyTypeEntry(Object obj) {
        return obj instanceof Map.Entry;
    }

    public static boolean isPropertyTypeEntryList(Class<?> cls) {
        return cls.isArray() && isPropertyTypeEntry(cls.getComponentType());
    }

    public static boolean isPropertyTypeMap(Object obj) {
        return obj instanceof Map;
    }

    public static boolean isSignatureAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, int i) {
        if (i != 3 && clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!isAssignable(clsArr[i2], clsArr2[i2], i)) {
                return false;
            }
        }
        return true;
    }

    public static String prettyName(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        return yg.concatToVar1(new StringBuilder(), prettyName(cls.getComponentType()), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public static Class<?> getType(boolean z) {
        return Boolean.TYPE;
    }

    public static boolean isNumeric(Class<?> cls) {
        if (Number.class.isAssignableFrom(cls.isPrimitive() ? Primitive.boxType(cls) : cls)) {
            return true;
        }
        if (cls.isPrimitive()) {
            cls = Primitive.boxType(cls);
        }
        return Character.class.isAssignableFrom(cls);
    }

    public static boolean isPropertyTypeEntry(Class<?> cls) {
        return Map.Entry.class.isAssignableFrom(cls);
    }

    public static boolean isPropertyTypeMap(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }

    public static Class<?> getType(byte b) {
        return Byte.TYPE;
    }

    public static UtilEvalError castError(String str, String str2, int i) {
        return castError(str, str2, (Object) null, i);
    }

    public static Class<?> getType(char c) {
        return Character.TYPE;
    }

    public static UtilEvalError castError(String str, String str2, Object obj, int i) {
        String str3 = "";
        if (i == 1) {
            StringBuilder sb = new StringBuilder("Cannot assign ");
            sb.append(str2);
            if (obj != null) {
                str3 = " with value \"" + obj + "\"";
            }
            sb.append(str3);
            sb.append(" to ");
            sb.append(str);
            return new UtilEvalError(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder("Cannot cast ");
        sb2.append(str2);
        if (obj != null) {
            str3 = " with value \"" + obj + "\"";
        }
        sb2.append(str3);
        sb2.append(" to ");
        sb2.append(str);
        return new UtilTargetError(new ClassCastException(sb2.toString()));
    }

    public static Class<?> getType(int i) {
        return Integer.TYPE;
    }

    public static Class<?> getType(long j) {
        return Long.TYPE;
    }

    public static Class<?> getType(short s) {
        return Short.TYPE;
    }

    public static Object castObject(Class<?> cls, Class<?> cls2, Object obj, int i, boolean z) throws UtilEvalError {
        if (cls == null || arrayElementType(cls) == arrayElementType(cls2)) {
            if (z) {
                return VALID_CAST;
            }
        } else {
            if (cls2 != null && cls2.isArray() && (i == 0 || Collection.class.isAssignableFrom(cls))) {
                return z ? VALID_CAST : BshArray.castArray(cls, cls2, obj);
            }
            boolean zIsPrimitive = cls.isPrimitive();
            Class<?> cls3 = Void.TYPE;
            if (zIsPrimitive) {
                if (cls2 != cls3 && cls2 != null && !cls2.isPrimitive()) {
                    if (((isNumeric(cls2) || String.valueOf(obj).matches("[-+0-9.]*")) && isNumeric(cls)) || cls == Boolean.TYPE) {
                        if (z) {
                            return VALID_CAST;
                        }
                        return Primitive.wrap(Primitive.castWrapper(cls, obj), cls);
                    }
                    if (z) {
                        return INVALID_CAST;
                    }
                    throw castError(cls, cls2, obj, i);
                }
                if (!Primitive.class.isInstance(obj)) {
                    obj = Primitive.wrap(obj, cls2);
                }
                return Primitive.castPrimitive(cls, cls2, (Primitive) obj, z, i);
            }
            if (cls2 != cls3 && cls2 != null && !cls2.isPrimitive() && cls != Boolean.class && (!String.valueOf(obj).matches("[-+0-9.]*") || !isNumeric(cls))) {
                if (isFunctionalInterface(cls) && (obj instanceof BshLambda)) {
                    return z ? VALID_CAST : ((BshLambda) obj).convertTo(cls);
                }
                if (cls.isAssignableFrom(cls2)) {
                    if (z) {
                        return VALID_CAST;
                    }
                    if (Reflect.isGeneratedClass(cls) && !Proxy.isProxyClass(cls2)) {
                        return Reflect.getClassInstanceThis(obj, cls.getSimpleName());
                    }
                } else {
                    if (!This.class.isInstance(obj) || ((This) obj).getNameSpace().classStatic != cls) {
                        if (cls.isInterface() && This.class.isAssignableFrom(cls2)) {
                            if (z) {
                                return VALID_CAST;
                            }
                            return ((This) obj).getInterface(cls);
                        }
                        if (Primitive.isWrapperType(cls) && Primitive.isWrapperType(cls2)) {
                            if (z) {
                                return VALID_CAST;
                            }
                            return Primitive.castWrapper(cls, obj);
                        }
                        if (z) {
                            return INVALID_CAST;
                        }
                        throw castError(cls, cls2, obj, i);
                    }
                    if (z) {
                        return VALID_CAST;
                    }
                }
            } else {
                if (Primitive.isWrapperType(cls) && cls2 != cls3 && cls2 != null) {
                    if (z) {
                        return VALID_CAST;
                    }
                    return Primitive.castWrapper(Primitive.unboxType(cls), obj);
                }
                if (cls != Object.class || cls2 == cls3 || cls2 == null) {
                    return Primitive.castPrimitive(cls, cls2, (Primitive) obj, z, i);
                }
                return z ? VALID_CAST : Primitive.unwrap(obj);
            }
        }
        return obj;
    }

    public static Class<?> getType(double d) {
        return Double.TYPE;
    }

    public static Class<?> getType(float f) {
        return Float.TYPE;
    }

    public static Class<?> getType(Object obj, boolean z) {
        if (obj == null || Primitive.NULL == obj) {
            return null;
        }
        if ((obj instanceof Primitive) && !z) {
            return ((Primitive) obj).getType();
        }
        if (obj instanceof BshLambda) {
            return ((BshLambda) obj).dummyType;
        }
        return Primitive.unwrap(obj).getClass();
    }
}
