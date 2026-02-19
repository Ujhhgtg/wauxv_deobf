package bsh;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import me.hd.wauxv.obf.cpv;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class Operators implements ParserConstants {
    private static final List<Integer> OVERFLOW_OPS = Arrays.asList(104, 105, 106, 116);
    private static final List<Integer> COMPARABLE_OPS = Arrays.asList(88, 89, 86, 87, 92, 93, 94, 95, 96, 97);

    private Operators() {
    }

    public static Object arbitraryObjectsBinaryOperation(Object obj, Object obj2, int i) throws UtilEvalError {
        if (i == 92) {
            return obj == obj2 ? Primitive.TRUE : Primitive.FALSE;
        }
        if (i == 97) {
            return obj != obj2 ? Primitive.TRUE : Primitive.FALSE;
        }
        Primitive primitive = Primitive.VOID;
        if (obj == primitive || obj2 == primitive) {
            throw new UtilEvalError("illegal use of undefined variable, class, or 'void' literal");
        }
        int i2 = 0;
        Class cls = Integer.TYPE;
        if (i == 145) {
            int iCompare = ((obj instanceof Comparable) || (obj2 instanceof Comparable)) ? Comparator.nullsFirst(Comparator.naturalOrder()).compare((Comparable) Primitive.unwrap(obj), (Comparable) Primitive.unwrap(obj2)) : Comparator.nullsFirst(Comparator.comparing(new cpv(24))).compare(Primitive.unwrap(obj), Primitive.unwrap(obj2));
            if (iCompare < 0) {
                i2 = -1;
            } else if (iCompare > 0) {
                i2 = 1;
            }
            return Primitive.wrap(Integer.valueOf(i2), (Class<?>) cls);
        }
        if (i == 104) {
            if ((obj instanceof String) || (obj2 instanceof String)) {
                return BSHLiteral.internStrings ? String.valueOf(obj).concat(String.valueOf(obj2)).intern() : String.valueOf(obj).concat(String.valueOf(obj2));
            }
            if (obj.getClass().isArray() && (obj2 instanceof List)) {
                obj2 = ((List) obj2).toArray();
            }
            if (obj.getClass().isArray() && obj2.getClass().isArray()) {
                return BshArray.concat(obj, obj2);
            }
            boolean z = obj instanceof List;
            if (z && obj2.getClass().isArray()) {
                obj2 = Types.castObject(obj2, List.class, 0);
            }
            if (z && (obj2 instanceof List)) {
                return BshArray.concat((List<?>) obj, (List<?>) obj2);
            }
        }
        if (i == 106) {
            if (obj.getClass().isArray()) {
                return BshArray.repeat(obj, ((Integer) Primitive.castWrapper(cls, obj2)).intValue());
            }
            if (obj2.getClass().isArray()) {
                return BshArray.repeat(obj2, ((Integer) Primitive.castWrapper(cls, obj)).intValue());
            }
            if (obj instanceof List) {
                return BshArray.repeat((List<Object>) obj, ((Integer) Primitive.castWrapper(cls, obj2)).intValue());
            }
            if (obj2 instanceof List) {
                return BshArray.repeat((List<Object>) obj2, ((Integer) Primitive.castWrapper(cls, obj)).intValue());
            }
            try {
                if (obj instanceof String) {
                    return BSHLiteral.internStrings ? new String(new char[((Integer) Primitive.castWrapper(cls, obj2)).intValue()]).replace("\u0000", String.valueOf(obj)).intern() : new String(new char[((Integer) Primitive.castWrapper(cls, obj2)).intValue()]).replace("\u0000", String.valueOf(obj));
                }
                if (obj2 instanceof String) {
                    return BSHLiteral.internStrings ? new String(new char[((Integer) Primitive.castWrapper(cls, obj)).intValue()]).replace("\u0000", String.valueOf(obj2)).intern() : new String(new char[((Integer) Primitive.castWrapper(cls, obj)).intValue()]).replace("\u0000", String.valueOf(obj2));
                }
            } catch (NegativeArraySizeException e) {
                throw new UtilEvalError("Negative repeat operand: " + e.getMessage(), e);
            }
        }
        if ((obj instanceof String) || (obj2 instanceof String)) {
            throw new UtilEvalError("Use of non + operator with String");
        }
        if (obj.getClass().isArray() || obj2.getClass().isArray() || (obj instanceof List) || (obj2 instanceof List)) {
            throw new UtilEvalError(yg.concatToVar1(new StringBuilder("Use of invalid operator "), ParserConstants.tokenImage[i], " with array or List type"));
        }
        Primitive primitive2 = Primitive.NULL;
        if (obj == primitive2 || obj2 == primitive2) {
            throw new UtilEvalError("illegal use of null value or 'null' literal");
        }
        throw new UtilEvalError(yg.concatToVar1(new StringBuilder("Operator: "), ParserConstants.tokenImage[i], " inappropriate for objects"));
    }

    public static Object bigDecimalBinaryOperation(BigDecimal bigDecimal, BigDecimal bigDecimal2, int i) throws UtilEvalError {
        switch (i) {
            case 104:
                return bigDecimal.add(bigDecimal2);
            case 105:
                return bigDecimal.subtract(bigDecimal2);
            case 106:
                return bigDecimal.multiply(bigDecimal2);
            case 107:
                return bigDecimal.divide(bigDecimal2);
            default:
                switch (i) {
                    case 114:
                    case 115:
                        return bigDecimal.remainder(bigDecimal2);
                    case 116:
                    case 117:
                        return bigDecimal.pow(bigDecimal2.intValue());
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                        throw new UtilEvalError("Can't shift floatingpoint values");
                    default:
                        throw new InterpreterError("Unimplemented binary float operator");
                }
        }
    }

    public static BigDecimal bigDecimalUnaryOperation(BigDecimal bigDecimal, int i) {
        if (i == 91) {
            return bigDecimal.signum() == 1 ? bigDecimal.negate() : bigDecimal;
        }
        switch (i) {
            case 102:
                return bigDecimal.add(BigDecimal.ONE);
            case 103:
                return bigDecimal.subtract(BigDecimal.ONE);
            case 104:
                return bigDecimal;
            case 105:
                return bigDecimal.negate();
            default:
                throw new InterpreterError("bad big decimal unaryOperation");
        }
    }

    public static Object bigIntegerBinaryOperation(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        switch (i) {
            case 104:
                return bigInteger.add(bigInteger2);
            case 105:
                return bigInteger.subtract(bigInteger2);
            case 106:
                return bigInteger.multiply(bigInteger2);
            case 107:
                return bigInteger.divide(bigInteger2);
            case 108:
            case 109:
                return bigInteger.and(bigInteger2);
            case 110:
            case 111:
                return bigInteger.or(bigInteger2);
            case 112:
            case 113:
                return bigInteger.xor(bigInteger2);
            case 114:
            case 115:
                return bigInteger.mod(bigInteger2);
            case 116:
            case 117:
                return bigInteger.pow(bigInteger2.intValue());
            case 118:
            case 119:
                return bigInteger.shiftLeft(bigInteger2.intValue());
            case 120:
            case 121:
                return bigInteger.shiftRight(bigInteger2.intValue());
            case 122:
            case 123:
                if (bigInteger.signum() >= 0) {
                    return bigInteger.shiftRight(bigInteger2.intValue());
                }
                BigInteger bigInteger3 = BigInteger.ONE;
                BigInteger bigIntegerShiftLeft = bigInteger3.shiftLeft(bigInteger.toString(2).length() + 1);
                BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftLeft);
                return bigIntegerSubtract.shiftRight(bigInteger2.intValue()).and(bigIntegerShiftLeft.subtract(bigInteger3).shiftRight(bigInteger2.intValue() + 1));
            default:
                throw new InterpreterError("Unimplemented binary integer operator");
        }
    }

    public static BigInteger bigIntegerUnaryOperation(BigInteger bigInteger, int i) {
        if (i == 91) {
            return bigInteger.not();
        }
        switch (i) {
            case 102:
                return bigInteger.add(BigInteger.ONE);
            case 103:
                return bigInteger.subtract(BigInteger.ONE);
            case 104:
                return bigInteger;
            case 105:
                return bigInteger.negate();
            default:
                throw new InterpreterError("bad big integer unaryOperation");
        }
    }

    public static Object binaryOperation(Object obj, Object obj2, int i) throws UtilEvalError {
        Object objUnwrap = Primitive.unwrap(obj);
        Object objUnwrap2 = Primitive.unwrap(obj2);
        if (Types.isNumeric(objUnwrap) && Types.isNumeric(objUnwrap2)) {
            Object[] objArrPromotePrimitives = promotePrimitives(objUnwrap, objUnwrap2);
            Object obj3 = objArrPromotePrimitives[0];
            objUnwrap2 = objArrPromotePrimitives[1];
            objUnwrap = obj3;
        }
        if (objUnwrap.getClass() == objUnwrap2.getClass()) {
            try {
                Object objBinaryOperationImpl = binaryOperationImpl(objUnwrap, objUnwrap2, i);
                return objBinaryOperationImpl instanceof Boolean ? ((Boolean) objBinaryOperationImpl).booleanValue() ? Primitive.TRUE : Primitive.FALSE : ((obj instanceof Primitive) && (obj2 instanceof Primitive)) ? (Types.isFloatingpoint(objBinaryOperationImpl) && objUnwrap.getClass() == BigDecimal.class) ? Primitive.wrap(objBinaryOperationImpl, objBinaryOperationImpl.getClass()) : Primitive.shrinkWrap(objBinaryOperationImpl) : Primitive.shrinkWrap(objBinaryOperationImpl).getValue();
            } catch (ArithmeticException e) {
                throw new UtilTargetError("Arithemetic Exception in binary op", e);
            }
        }
        throw new UtilEvalError("Type mismatch in operator.  " + objUnwrap.getClass() + " cannot be used with " + objUnwrap2.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Object binaryOperationImpl(T t, T t2, int i) throws UtilEvalError {
        if (i == 145) {
            return Integer.valueOf(((Comparable) t).compareTo(t2));
        }
        if (t instanceof Boolean) {
            return booleanBinaryOperation((Boolean) t, (Boolean) t2, i);
        }
        if (COMPARABLE_OPS.contains(Integer.valueOf(i))) {
            return comparableBinaryBooleanOperations((Comparable) t, t2, i);
        }
        if (t instanceof BigInteger) {
            return bigIntegerBinaryOperation((BigInteger) t, (BigInteger) t2, i);
        }
        if (t instanceof BigDecimal) {
            return bigDecimalBinaryOperation((BigDecimal) t, (BigDecimal) t2, i);
        }
        if (Types.isFloatingpoint(t)) {
            return t instanceof Float ? floatBinaryOperation(((Float) t).floatValue(), ((Float) t2).floatValue(), i) : doubleBinaryOperation(((Double) t).doubleValue(), ((Double) t2).doubleValue(), i);
        }
        if (t instanceof Number) {
            return longBinaryOperation(((Long) t).longValue(), ((Long) t2).longValue(), i);
        }
        throw new UtilEvalError("Invalid types in binary operator");
    }

    public static Boolean booleanBinaryOperation(Boolean bool, Boolean bool2, int i) {
        boolean zBooleanValue = bool.booleanValue();
        boolean zBooleanValue2 = bool2.booleanValue();
        if (i == 92) {
            return Boolean.valueOf(zBooleanValue == zBooleanValue2);
        }
        switch (i) {
            case 97:
                return Boolean.valueOf(zBooleanValue != zBooleanValue2);
            case 98:
            case 99:
            case 100:
            case 101:
                return bool2;
            default:
                switch (i) {
                    case 108:
                    case 109:
                        return Boolean.valueOf(zBooleanValue & zBooleanValue2);
                    case 110:
                    case 111:
                        return Boolean.valueOf(zBooleanValue | zBooleanValue2);
                    case 112:
                    case 113:
                        return Boolean.valueOf(zBooleanValue ^ zBooleanValue2);
                    default:
                        throw new InterpreterError("unimplemented binary operator");
                }
        }
    }

    public static boolean booleanUnaryOperation(Boolean bool, int i) throws UtilEvalError {
        boolean zBooleanValue = bool.booleanValue();
        if (i == 90) {
            return !zBooleanValue;
        }
        throw new UtilEvalError("Operator inappropriate for boolean");
    }

    public static <T> Boolean comparableBinaryBooleanOperations(Comparable<T> comparable, T t, int i) {
        switch (i) {
            case 86:
            case 87:
                return Boolean.valueOf(comparable.compareTo(t) > 0);
            case 88:
            case 89:
                return Boolean.valueOf(comparable.compareTo(t) < 0);
            case 90:
            case 91:
            case 92:
            default:
                return Boolean.valueOf(comparable.compareTo(t) == 0);
            case 93:
            case 94:
                return Boolean.valueOf(comparable.compareTo(t) <= 0);
            case 95:
            case 96:
                return Boolean.valueOf(comparable.compareTo(t) >= 0);
            case 97:
                return Boolean.valueOf(comparable.compareTo(t) != 0);
        }
    }

    public static Object doubleBinaryOperation(double d, double d2, int i) throws UtilEvalError {
        switch (i) {
            case 104:
                if (d <= 0.0d || Double.MAX_VALUE - d >= d2) {
                    return Double.valueOf(d + d2);
                }
                break;
            case 105:
                if (d >= 0.0d || (-1.7976931348623157E308d) - d <= (-d2)) {
                    return Double.valueOf(d - d2);
                }
                break;
            case 106:
                if (d == 0.0d || Double.MAX_VALUE / d >= d2) {
                    return Double.valueOf(d * d2);
                }
                break;
            case 107:
                return Double.valueOf(d / d2);
            default:
                switch (i) {
                    case 114:
                    case 115:
                        return Double.valueOf(d % d2);
                    case 116:
                    case 117:
                        double dPow = Math.pow(d, d2);
                        if (!Double.isInfinite(dPow)) {
                            return Double.valueOf(dPow);
                        }
                        break;
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                        throw new UtilEvalError("Can't shift floatingpoint values");
                }
                break;
        }
        if (OVERFLOW_OPS.contains(Integer.valueOf(i))) {
            return bigDecimalBinaryOperation(BigDecimal.valueOf(d), BigDecimal.valueOf(d2), i);
        }
        throw new InterpreterError("Unimplemented binary double operator");
    }

    public static double doubleUnaryOperation(Double d, int i) {
        double dDoubleValue = d.doubleValue();
        switch (i) {
            case 102:
                return dDoubleValue + 1.0d;
            case 103:
                return dDoubleValue - 1.0d;
            case 104:
                return dDoubleValue;
            case 105:
                return -dDoubleValue;
            default:
                throw new InterpreterError("bad double unaryOperation");
        }
    }

    public static Object floatBinaryOperation(float f, float f2, int i) throws UtilEvalError {
        switch (i) {
            case 104:
                if (f <= 0.0d || Float.MAX_VALUE - f >= f2) {
                    return Float.valueOf(f + f2);
                }
                break;
            case 105:
                if (f >= 0.0d || (-3.4028235E38f) - f <= (-f2)) {
                    return Float.valueOf(f - f2);
                }
                break;
            case 106:
                if (f == 0.0f || Float.MAX_VALUE / f >= f2) {
                    return Float.valueOf(f * f2);
                }
                break;
            case 107:
                return Float.valueOf(f / f2);
            default:
                switch (i) {
                    case 114:
                    case 115:
                        return Float.valueOf(f % f2);
                    case 116:
                    case 117:
                        double dPow = Math.pow(f, f2);
                        if (!Double.isInfinite(dPow)) {
                            return Double.valueOf(dPow);
                        }
                        break;
                    case 118:
                    case 119:
                    case 120:
                    case 121:
                    case 122:
                    case 123:
                        throw new UtilEvalError("Can't shift floatingpoint values");
                }
                break;
        }
        if (OVERFLOW_OPS.contains(Integer.valueOf(i))) {
            return bigDecimalBinaryOperation(BigDecimal.valueOf(f), BigDecimal.valueOf(f2), i);
        }
        throw new InterpreterError("Unimplemented binary double operator");
    }

    public static float floatUnaryOperation(Float f, int i) {
        float fFloatValue = f.floatValue();
        switch (i) {
            case 102:
                return fFloatValue + 1.0f;
            case 103:
                return fFloatValue - 1.0f;
            case 104:
                return fFloatValue;
            case 105:
                return -fFloatValue;
            default:
                throw new InterpreterError("bad float unaryOperation");
        }
    }

    public static int intUnaryOperation(Integer num, int i) {
        int iIntValue = num.intValue();
        if (i == 91) {
            return ~iIntValue;
        }
        switch (i) {
            case 102:
                return iIntValue + 1;
            case 103:
                return iIntValue - 1;
            case 104:
                return iIntValue;
            case 105:
                return -iIntValue;
            default:
                throw new InterpreterError("bad integer unaryOperation");
        }
    }

    public static Object longBinaryOperation(long j, long j2, int i) {
        switch (i) {
            case 104:
                if (j <= 0 || Long.MAX_VALUE - j >= j2) {
                    return Long.valueOf(j + j2);
                }
                break;
            case 105:
                if (j >= 0 || Long.MIN_VALUE - j <= (-j2)) {
                    return Long.valueOf(j - j2);
                }
                break;
            case 106:
                if (j == 0 || Long.MAX_VALUE / j >= j2) {
                    return Long.valueOf(j * j2);
                }
                break;
            case 107:
                return Long.valueOf(j / j2);
            case 108:
            case 109:
                return Long.valueOf(j & j2);
            case 110:
            case 111:
                return Long.valueOf(j | j2);
            case 112:
            case 113:
                return Long.valueOf(j ^ j2);
            case 114:
            case 115:
                return Long.valueOf(j % j2);
            case 116:
            case 117:
                double dPow = Math.pow(j, j2);
                BigInteger bigInteger = BigDecimal.valueOf(dPow).toBigInteger();
                if (bigInteger.compareTo(Primitive.LONG_MIN) >= 0 && bigInteger.compareTo(Primitive.LONG_MAX) <= 0) {
                    return Long.valueOf((long) dPow);
                }
                break;
            case 118:
            case 119:
                return Long.valueOf(j << ((int) j2));
            case 120:
            case 121:
                return Long.valueOf(j >> ((int) j2));
            case 122:
            case 123:
                return Long.valueOf(j >>> ((int) j2));
        }
        if (OVERFLOW_OPS.contains(Integer.valueOf(i))) {
            return bigIntegerBinaryOperation(BigInteger.valueOf(j), BigInteger.valueOf(j2), i);
        }
        throw new InterpreterError("Unimplemented binary long operator");
    }

    public static long longUnaryOperation(Long l, int i) {
        long jLongValue = l.longValue();
        if (i == 91) {
            return ~jLongValue;
        }
        switch (i) {
            case 102:
                return jLongValue + 1;
            case 103:
                return jLongValue - 1;
            case 104:
                return jLongValue;
            case 105:
                return -jLongValue;
            default:
                throw new InterpreterError("bad long unaryOperation");
        }
    }

    public static Object[] promotePrimitives(Object obj, Object obj2) {
        Number numberPromoteToInteger = promoteToInteger(obj);
        Number numberPromoteToInteger2 = promoteToInteger(obj2);
        if (obj instanceof BigDecimal) {
            if (!(obj2 instanceof BigDecimal)) {
                obj2 = Primitive.castNumber(BigDecimal.class, numberPromoteToInteger2);
            }
        } else if (obj2 instanceof BigDecimal) {
            obj = Primitive.castNumber(BigDecimal.class, numberPromoteToInteger);
        } else if (Types.isFloatingpoint(obj) || Types.isFloatingpoint(obj2)) {
            if (!(obj instanceof Float) || !(obj2 instanceof Float)) {
                if (!(obj instanceof Double)) {
                    obj = Double.valueOf(numberPromoteToInteger.doubleValue());
                }
                if (!(obj2 instanceof Double)) {
                    obj2 = Double.valueOf(numberPromoteToInteger2.doubleValue());
                }
            }
        } else if (obj instanceof BigInteger) {
            if (!(obj2 instanceof BigInteger)) {
                obj2 = Primitive.castNumber(BigInteger.class, numberPromoteToInteger2);
            }
        } else if (obj2 instanceof BigInteger) {
            obj = Primitive.castNumber(BigInteger.class, numberPromoteToInteger);
        } else {
            if (!(obj instanceof Long)) {
                obj = Long.valueOf(numberPromoteToInteger.longValue());
            }
            if (!(obj2 instanceof Long)) {
                obj2 = Long.valueOf(numberPromoteToInteger2.longValue());
            }
        }
        return new Object[]{obj, obj2};
    }

    public static Number promoteToInteger(Object obj) {
        return obj instanceof Character ? Integer.valueOf(((Character) obj).charValue()) : ((obj instanceof Byte) || (obj instanceof Short)) ? Integer.valueOf(((Number) obj).intValue()) : (Number) obj;
    }

    public static Primitive unaryOperation(Primitive primitive, int i) throws UtilEvalError {
        if (primitive == Primitive.NULL) {
            throw new UtilEvalError("illegal use of null object or 'null' literal");
        }
        if (primitive == Primitive.VOID) {
            throw new UtilEvalError("illegal use of undefined object or 'void' literal");
        }
        Class<?> type = primitive.getType();
        if (type == Boolean.TYPE) {
            return booleanUnaryOperation((Boolean) primitive.getValue(), i) ? Primitive.TRUE : Primitive.FALSE;
        }
        Number numberPromoteToInteger = promoteToInteger(primitive.getValue());
        if (numberPromoteToInteger instanceof Integer) {
            int iIntUnaryOperation = intUnaryOperation((Integer) numberPromoteToInteger, i);
            if (i == 102 || i == 103) {
                if (type == Byte.TYPE) {
                    return new Primitive((byte) iIntUnaryOperation);
                }
                if (type == Short.TYPE) {
                    return new Primitive((short) iIntUnaryOperation);
                }
                if (type == Character.TYPE) {
                    return new Primitive((char) iIntUnaryOperation);
                }
            }
            return new Primitive(iIntUnaryOperation);
        }
        if (numberPromoteToInteger instanceof Long) {
            return new Primitive(longUnaryOperation(Long.valueOf(numberPromoteToInteger.longValue()), i));
        }
        if (numberPromoteToInteger instanceof Float) {
            return new Primitive(floatUnaryOperation(Float.valueOf(numberPromoteToInteger.floatValue()), i));
        }
        if (numberPromoteToInteger instanceof Double) {
            return new Primitive(doubleUnaryOperation(Double.valueOf(numberPromoteToInteger.doubleValue()), i));
        }
        if (numberPromoteToInteger instanceof BigInteger) {
            return new Primitive(bigIntegerUnaryOperation((BigInteger) numberPromoteToInteger, i));
        }
        if (numberPromoteToInteger instanceof BigDecimal) {
            return new Primitive(bigDecimalUnaryOperation((BigDecimal) numberPromoteToInteger, i));
        }
        throw new InterpreterError("An error occurred.  Please call technical support.");
    }
}
