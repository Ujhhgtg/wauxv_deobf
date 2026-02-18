package bsh;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Primitive implements Serializable {
    public static final Primitive FALSE;
    private static final BigInteger INTEGER_MAX;
    private static final BigInteger INTEGER_MIN;
    static final BigInteger LONG_MAX;
    static final BigInteger LONG_MIN;
    public static final Primitive NULL;
    public static final Primitive TRUE;
    public static final Primitive VOID;
    public static final Primitive ZERO_BIG_DECIMAL;
    public static final Primitive ZERO_BIG_INTEGER;
    public static final Primitive ZERO_BYTE;
    public static final Primitive ZERO_CHAR;
    public static final Primitive ZERO_DOUBLE;
    public static final Primitive ZERO_FLOAT;
    public static final Primitive ZERO_INT;
    public static final Primitive ZERO_LONG;
    public static final Primitive ZERO_SHORT;
    private static final long serialVersionUID = 1;
    static final Map<Class<?>, Class<?>> wrapperMap;
    private Object value;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public enum Special {
        NULL_VALUE,
        VOID_TYPE
    }

    static {
        HashMap map = new HashMap();
        wrapperMap = map;
        Class cls = Boolean.TYPE;
        map.put(cls, Boolean.class);
        Class cls2 = Byte.TYPE;
        map.put(cls2, Byte.class);
        Class cls3 = Short.TYPE;
        map.put(cls3, Short.class);
        Class cls4 = Character.TYPE;
        map.put(cls4, Character.class);
        Class cls5 = Integer.TYPE;
        map.put(cls5, Integer.class);
        Class cls6 = Long.TYPE;
        map.put(cls6, Long.class);
        Class cls7 = Float.TYPE;
        map.put(cls7, Float.class);
        Class cls8 = Double.TYPE;
        map.put(cls8, Double.class);
        map.put(Boolean.class, cls);
        map.put(Byte.class, cls2);
        map.put(Short.class, cls3);
        map.put(Character.class, cls4);
        map.put(Integer.class, cls5);
        map.put(Long.class, cls6);
        map.put(Float.class, cls7);
        map.put(Double.class, cls8);
        map.put(BigInteger.class, BigInteger.class);
        map.put(BigDecimal.class, BigDecimal.class);
        TRUE = new Primitive(true);
        FALSE = new Primitive(false);
        ZERO_CHAR = new Primitive((char) 0);
        ZERO_BYTE = new Primitive((byte) 0);
        ZERO_SHORT = new Primitive((short) 0);
        ZERO_INT = new Primitive(0);
        ZERO_LONG = new Primitive(0L);
        ZERO_FLOAT = new Primitive(0.0f);
        ZERO_DOUBLE = new Primitive(0.0d);
        ZERO_BIG_INTEGER = new Primitive(BigInteger.ZERO);
        ZERO_BIG_DECIMAL = new Primitive(BigDecimal.ZERO);
        NULL = new Primitive(Special.NULL_VALUE);
        VOID = new Primitive(Special.VOID_TYPE);
        INTEGER_MAX = BigInteger.valueOf(2147483647L);
        INTEGER_MIN = BigInteger.valueOf(-2147483648L);
        LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
        LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    }

    private Primitive(Object obj) {
        if (obj == null) {
            throw new InterpreterError("Use Primitve.NULL instead of Primitive(null)");
        }
        this.value = obj;
    }

    public static Class<?> boxType(Class<?> cls) {
        Class<?> cls2 = wrapperMap.get(cls);
        if (cls2 == null || cls2.isPrimitive()) {
            throw new InterpreterError(concatVar2Var1(cls, "Not a primitive type: "));
        }
        return cls2;
    }

    public static Object castNumber(Class<?> cls, Number number) {
        if (cls.isInstance(number) || cls == unboxType(number.getClass())) {
            return number;
        }
        if ((cls == Byte.class || cls == Byte.TYPE) && number.shortValue() <= 255 && number.shortValue() >= -128) {
            return Byte.valueOf(number.byteValue());
        }
        if ((cls == Short.class || cls == Short.TYPE) && number.intValue() <= 32767 && number.intValue() >= -32768) {
            return Short.valueOf(number.shortValue());
        }
        if ((cls == Character.class || cls == Character.TYPE) && number.intValue() <= 65535 && number.intValue() >= 0) {
            return Character.valueOf((char) number.intValue());
        }
        if ((cls == Integer.class || cls == Integer.TYPE) && number.longValue() <= 2147483647L
                && number.longValue() >= -2147483648L) {
            return number instanceof Byte ? Integer.valueOf(Byte.toUnsignedInt(number.byteValue()))
                    : Integer.valueOf(number.intValue());
        }
        if ((cls == Float.class || cls == Float.TYPE) && !Float.isInfinite(number.floatValue())) {
            return Float.valueOf(number.floatValue());
        }
        if ((cls == Double.class || cls == Double.TYPE) && !Double.isInfinite(number.doubleValue())) {
            return Double.valueOf(number.doubleValue());
        }
        double dDoubleValue = number.doubleValue();
        Class<?> cls2 = Long.TYPE;
        if (dDoubleValue == 0.0d) {
            if (cls == Long.class || cls == cls2) {
                return 0L;
            }
            if (cls == BigInteger.class) {
                return BigInteger.ZERO;
            }
            if (cls == BigDecimal.class) {
                return BigDecimal.ZERO.setScale(1);
            }
        } else if (number.doubleValue() == 1.0d) {
            if (cls == Long.class || cls == cls2) {
                return Long.valueOf(serialVersionUID);
            }
            if (cls == BigInteger.class) {
                return BigInteger.ONE;
            }
            if (cls == BigDecimal.class) {
                return BigDecimal.ONE.setScale(1);
            }
        } else {
            if (cls == BigDecimal.class) {
                return number instanceof BigInteger ? new BigDecimal((BigInteger) number).setScale(1)
                        : Types.isFloatingpoint(number) ? BigDecimal.valueOf(number.doubleValue())
                                : new BigDecimal(number.longValue()).setScale(1);
            }
            BigInteger bigInteger = number instanceof BigInteger ? (BigInteger) number
                    : number instanceof BigDecimal ? ((BigDecimal) number).toBigInteger()
                            : Types.isFloatingpoint(number) ? BigDecimal.valueOf(number.doubleValue()).toBigInteger()
                                    : BigInteger.valueOf(number.longValue());
            if ((cls == Long.class || cls == cls2) && bigInteger.compareTo(LONG_MIN) >= 0
                    && bigInteger.compareTo(LONG_MAX) <= 0) {
                return Long.valueOf(number.longValue());
            }
            if (cls == BigInteger.class) {
                return bigInteger;
            }
        }
        throw new InterpreterError("cannot assign number " + number + " to type " + cls.getSimpleName());
    }

    public static Object castNumberStrictJava(Class<?> cls, Number number) {
        return (cls == Byte.class || cls == Byte.TYPE) ? Byte.valueOf(number.byteValue())
                : (cls == Short.class || cls == Short.TYPE) ? Short.valueOf(number.shortValue())
                        : (cls == Character.class || cls == Character.TYPE)
                                ? Character.valueOf((char) number.intValue())
                                : (cls == Integer.class || cls == Integer.TYPE) ? Integer.valueOf(number.intValue())
                                        : (cls == Long.class || cls == Long.TYPE) ? Long.valueOf(number.longValue())
                                                : (cls == Float.class || cls == Float.TYPE)
                                                        ? Float.valueOf(number.floatValue())
                                                        : (cls == Double.class || cls == Double.TYPE)
                                                                ? Double.valueOf(number.doubleValue())
                                                                : castNumber(cls, number);
    }

    public static Primitive castPrimitive(Class<?> cls, Class<?> cls2, Primitive primitive, boolean z, int i)
            throws UtilEvalError {
        if (cls2 == Void.TYPE) {
            if (z) {
                return Types.INVALID_CAST;
            }
            throw Types.castError(StringUtil.typeString(cls), "void value", i);
        }
        if (!z && primitive.isNumber() && Types.isNumeric(cls)) {
            return new Primitive(castNumber(cls, primitive.numberValue()));
        }
        if (cls.isPrimitive()) {
            if (cls2 == null && !VOID.equals(primitive)) {
                return z ? Types.VALID_CAST : getDefaultValue(cls);
            }
            Class<?> cls3 = Boolean.TYPE;
            return cls == cls3 ? z ? Types.VALID_CAST : new Primitive(castWrapper(cls, primitive))
                    : (z && cls2 == cls3) ? cls != cls3 ? Types.INVALID_CAST : Types.VALID_CAST
                            : (i == 1 && !Types.isJavaAssignable(cls, cls2) && z) ? Types.INVALID_CAST
                                    : z ? Types.VALID_CAST : new Primitive(castWrapper(cls, primitive));
        }
        if (cls2 == null) {
            return z ? Types.VALID_CAST : NULL;
        }
        if (z) {
            return Types.INVALID_CAST;
        }
        throw Types.castError("object type ".concat(cls.getName()), "primitive value", i);
    }

    public static Object castWrapper(Class<?> cls, Object obj) {
        if (VOID.equals(obj)) {
            return obj;
        }
        Object objUnwrap = unwrap(obj);
        if (!isWrapperType(cls) && !cls.isPrimitive()) {
            throw new InterpreterError(concatVar2Var1(cls, "invalid type in castWrapper: "));
        }
        if (objUnwrap instanceof Character) {
            objUnwrap = Integer.valueOf(((Character) objUnwrap).charValue());
        }
        if (cls == Boolean.TYPE) {
            if (objUnwrap instanceof Boolean) {
                return objUnwrap;
            }
            if (objUnwrap instanceof String) {
                return Boolean.valueOf(!"".equals(String.valueOf(objUnwrap)));
            }
            if (objUnwrap instanceof Number) {
                return Boolean.valueOf(((Number) objUnwrap).intValue() != 0);
            }
            return Boolean.valueOf(objUnwrap != null);
        }
        if (objUnwrap == null && cls.isPrimitive()) {
            objUnwrap = unwrap(getDefaultValue(cls));
        }
        if (objUnwrap instanceof String) {
            try {
                objUnwrap = Double.valueOf(Double.parseDouble(String.valueOf(objUnwrap)));
            } catch (NumberFormatException e) {
                throw new InterpreterError("cannot cast string \"" + objUnwrap + "\" to number", e);
            }
        }
        if (objUnwrap instanceof Boolean) {
            objUnwrap = Integer.valueOf(((Boolean) objUnwrap).booleanValue() ? 1 : 0);
        }
        if (objUnwrap instanceof Number) {
            return castNumber(cls, (Number) objUnwrap);
        }
        throw new InterpreterError("bad type in cast " + StringUtil.typeValueString(objUnwrap));
    }

    public static Primitive getDefaultValue(Class<?> cls) {
        return cls == null ? NULL
                : (Boolean.TYPE == cls || Boolean.class == cls) ? FALSE
                        : (Character.TYPE == cls || Character.class == cls) ? ZERO_CHAR
                                : (Byte.TYPE == cls || Byte.class == cls) ? ZERO_BYTE
                                        : (Short.TYPE == cls || Short.class == cls) ? ZERO_SHORT
                                                : (Integer.TYPE == cls || Integer.class == cls) ? ZERO_INT
                                                        : (Long.TYPE == cls || Long.class == cls) ? ZERO_LONG
                                                                : (Float.TYPE == cls || Float.class == cls) ? ZERO_FLOAT
                                                                        : (Double.TYPE == cls || Double.class == cls)
                                                                                ? ZERO_DOUBLE
                                                                                : BigInteger.class == cls
                                                                                        ? ZERO_BIG_INTEGER
                                                                                        : BigDecimal.class == cls
                                                                                                ? ZERO_BIG_DECIMAL
                                                                                                : NULL;
    }

    public static boolean isWrapperType(Class<?> cls) {
        return (cls == null || !wrapperMap.containsKey(cls) || cls.isPrimitive()) ? false : true;
    }

    private Object readResolve() {
        return this.value == Special.NULL_VALUE ? NULL : this;
    }

    public static Primitive shrinkWrap(Object obj) {
        if (!(obj instanceof Number)) {
            throw new InterpreterError("Can only shrink wrap Number types");
        }
        Number number = (Number) obj;
        if (Types.isFloatingpoint(obj)) {
            return obj instanceof Float ? new Primitive(number.floatValue())
                    : !Double.isInfinite(number.doubleValue()) ? new Primitive(number.doubleValue())
                            : new Primitive((BigDecimal) obj);
        }
        BigInteger bigIntegerValueOf = obj instanceof BigInteger ? (BigInteger) obj
                : BigInteger.valueOf(number.longValue());
        return (bigIntegerValueOf.compareTo(INTEGER_MIN) < 0 || bigIntegerValueOf.compareTo(INTEGER_MAX) > 0)
                ? (bigIntegerValueOf.compareTo(LONG_MIN) < 0 || bigIntegerValueOf.compareTo(LONG_MAX) > 0)
                        ? new Primitive(bigIntegerValueOf)
                        : new Primitive(bigIntegerValueOf.longValue())
                : new Primitive(bigIntegerValueOf.intValue());
    }

    public static Class<?> unboxType(Class<?> cls) {
        Class<?> cls2 = wrapperMap.get(cls);
        if (cls2 == null || !(cls2.isPrimitive() || cls2 == cls)) {
            throw new InterpreterError(concatVar2Var1(cls, "Not a primitive wrapper type: "));
        }
        return cls2;
    }

    public static Object unwrap(Object obj) {
        if (obj == VOID) {
            return null;
        }
        return obj instanceof Primitive ? ((Primitive) obj).getValue() : obj;
    }

    public static Object[] wrap(Object[] objArr, Class<?>[] clsArr) {
        if (objArr == null) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = wrap(objArr[i], clsArr[i]);
        }
        return objArr2;
    }

    public Primitive castToType(Class<?> cls, int i) {
        return castPrimitive(cls, getType(), this, false, i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Primitive)) {
            if (!wrapperMap.containsKey(obj.getClass())) {
                return false;
            }
            obj = new Primitive(obj);
        }
        Primitive primitive = (Primitive) obj;
        return (primitive.isNumber() && isNumber()) ? getType() == BigDecimal.class
                ? this.value.equals(castNumber(BigDecimal.class, primitive.numberValue()))
                : primitive.getType() == BigDecimal.class
                        ? primitive.value.equals(castNumber(BigDecimal.class, numberValue()))
                        : (Types.isFloatingpoint(this.value) || Types.isFloatingpoint(primitive.value))
                                ? numberValue().doubleValue() == primitive.numberValue().doubleValue()
                                : getType() == BigInteger.class
                                        ? this.value.equals(castNumber(BigInteger.class, primitive.numberValue()))
                                        : primitive.getType() == BigInteger.class
                                                ? primitive.value.equals(castNumber(BigInteger.class, numberValue()))
                                                : numberValue().longValue() == primitive.numberValue().longValue()
                : this.value.equals(primitive.value);
    }

    public Class<?> getType() {
        if (this == VOID) {
            return Void.TYPE;
        }
        if (this == NULL) {
            return null;
        }
        return unboxType(this.value.getClass());
    }

    public Object getValue() {
        Object obj = this.value;
        if (obj == Special.NULL_VALUE) {
            return null;
        }
        if (obj != Special.VOID_TYPE) {
            return obj;
        }
        throw new InterpreterError("attempt to unwrap void type");
    }

    public int hashCode() {
        return this.value.hashCode() * 21;
    }

    public boolean isNumber() {
        Object obj = this.value;
        return ((obj instanceof Boolean) || this == NULL || this == VOID || !Types.isNumeric(obj)) ? false : true;
    }

    public Number numberValue() {
        Object obj = this.value;
        boolean z = obj instanceof Character;
        Object objValueOf = obj;
        if (z) {
            objValueOf = Integer.valueOf(((Character) obj).charValue());
        }
        if (objValueOf instanceof Number) {
            return (Number) objValueOf;
        }
        if (objValueOf instanceof Boolean) {
            return Integer.valueOf(((Boolean) objValueOf).booleanValue() ? 1 : 0);
        }
        throw new InterpreterError("Primitive not a number");
    }

    public String toString() {
        Object obj = this.value;
        return obj == Special.NULL_VALUE ? "null" : obj == Special.VOID_TYPE ? "void" : obj.toString();
    }

    public Primitive(boolean z) {
        this(z ? Boolean.TRUE : Boolean.FALSE);
    }

    public static Object[] unwrap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = unwrap(objArr[i]);
        }
        return objArr2;
    }

    public static Object wrap(Object obj, Class<?> cls) {
        if (cls == Void.TYPE) {
            return VOID;
        }
        if (obj == null) {
            return NULL;
        }
        if (Types.isPrimitive(cls)) {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? TRUE : FALSE;
            }
            if (isWrapperType(obj.getClass())) {
                return new Primitive(obj);
            }
        }
        return obj;
    }

    public Primitive(byte b) {
        this(Byte.valueOf(b));
    }

    public Primitive(short s) {
        this(Short.valueOf(s));
    }

    public Primitive(char c) {
        this(Character.valueOf(c));
    }

    public Primitive(int i) {
        this(Integer.valueOf(i));
    }

    public Primitive(long j) {
        this(Long.valueOf(j));
    }

    public Primitive(float f) {
        this(Float.valueOf(f));
    }

    public Primitive(double d) {
        this(Double.valueOf(d));
    }

    public Primitive(BigInteger bigInteger) {
        this((Object) bigInteger);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Primitive(BigDecimal bigDecimal) {
        if (bigDecimal != null && bigDecimal.scale() == 0) {
            bigDecimal = bigDecimal.setScale(1);
        }
        this((Object) bigDecimal);
    }
}
