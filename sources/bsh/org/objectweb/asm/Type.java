package bsh.org.objectweb.asm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.pool.TypePool;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final int BYTE = 3;
    public static final int CHAR = 2;
    public static final int DOUBLE = 8;
    public static final int FLOAT = 6;
    public static final int INT = 5;
    private static final int INTERNAL = 12;
    public static final int LONG = 7;
    public static final int METHOD = 11;
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final int VOID = 0;
    private final int sort;
    private final int valueBegin;
    private final String valueBuffer;
    private final int valueEnd;
    private static final String PRIMITIVE_DESCRIPTORS = "VZCBSIFJD";
    public static final Type VOID_TYPE = new Type(0, PRIMITIVE_DESCRIPTORS, 0, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, PRIMITIVE_DESCRIPTORS, 1, 2);
    public static final Type CHAR_TYPE = new Type(2, PRIMITIVE_DESCRIPTORS, 2, 3);
    public static final Type BYTE_TYPE = new Type(3, PRIMITIVE_DESCRIPTORS, 3, 4);
    public static final Type SHORT_TYPE = new Type(4, PRIMITIVE_DESCRIPTORS, 4, 5);
    public static final Type INT_TYPE = new Type(5, PRIMITIVE_DESCRIPTORS, 5, 6);
    public static final Type FLOAT_TYPE = new Type(6, PRIMITIVE_DESCRIPTORS, 6, 7);
    public static final Type LONG_TYPE = new Type(7, PRIMITIVE_DESCRIPTORS, 7, 8);
    public static final Type DOUBLE_TYPE = new Type(8, PRIMITIVE_DESCRIPTORS, 8, 9);

    private Type(int i, String str, int i2, int i3) {
        this.sort = i;
        this.valueBuffer = str;
        this.valueBegin = i2;
        this.valueEnd = i3;
    }

    private void appendDescriptor(StringBuilder sb) {
        int i = this.sort;
        if (i == 10) {
            sb.append((CharSequence) this.valueBuffer, this.valueBegin - 1, this.valueEnd + 1);
        } else {
            if (i != 12) {
                sb.append((CharSequence) this.valueBuffer, this.valueBegin, this.valueEnd);
                return;
            }
            sb.append('L');
            sb.append((CharSequence) this.valueBuffer, this.valueBegin, this.valueEnd);
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        }
    }

    public static Type[] getArgumentTypes(String str) {
        int i;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        while (str.charAt(i5) != ')') {
            while (str.charAt(i5) == '[') {
                i5++;
            }
            int i6 = i5 + 1;
            if (str.charAt(i5) == 'L') {
                while (true) {
                    i5 = i6 + 1;
                    if (str.charAt(i6) != ';') {
                        i6 = i5;
                    }
                }
            } else {
                i5 = i6;
            }
            i4++;
        }
        Type[] typeArr = new Type[i4];
        while (str.charAt(i3) != ')') {
            int i7 = i3;
            while (str.charAt(i7) == '[') {
                i7++;
            }
            int i8 = i7 + 1;
            if (str.charAt(i7) == 'L') {
                while (true) {
                    i = i8 + 1;
                    if (str.charAt(i8) != ';') {
                        i8 = i;
                    }
                }
            } else {
                i = i8;
            }
            typeArr[i2] = getType(str, i3, i);
            i3 = i;
            i2++;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        char cCharAt = str.charAt(1);
        int i2 = 1;
        int i3 = 1;
        while (cCharAt != ')') {
            if (cCharAt == 'J' || cCharAt == 'D') {
                i2++;
                i3 += 2;
            } else {
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                int i4 = i2 + 1;
                if (str.charAt(i2) == 'L') {
                    while (true) {
                        i = i4 + 1;
                        if (str.charAt(i4) == ';') {
                            break;
                        }
                        i4 = i;
                    }
                    i4 = i;
                }
                i3++;
                i2 = i4;
            }
            cCharAt = str.charAt(i2);
        }
        char cCharAt2 = str.charAt(i2 + 1);
        if (cCharAt2 == 'V') {
            return i3 << 2;
        }
        return (i3 << 2) | ((cCharAt2 == 'J' || cCharAt2 == 'D') ? 2 : 1);
    }

    public static String getConstructorDescriptor(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : constructor.getParameterTypes()) {
            appendDescriptor(sb, cls);
        }
        sb.append(")V");
        return sb.toString();
    }

    public static String getMethodDescriptor(Type type, Type... typeArr) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Type type2 : typeArr) {
            type2.appendDescriptor(sb);
        }
        sb.append(')');
        type.appendDescriptor(sb);
        return sb.toString();
    }

    public static Type getMethodType(String str) {
        return new Type(11, str, 0, str.length());
    }

    public static Type getObjectType(String str) {
        return new Type(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    public static Type getReturnType(String str) {
        int i = 1;
        while (str.charAt(i) != ')') {
            while (str.charAt(i) == '[') {
                i++;
            }
            int i2 = i + 1;
            if (str.charAt(i) == 'L') {
                while (true) {
                    i = i2 + 1;
                    if (str.charAt(i2) != ';') {
                        i2 = i;
                    }
                }
            } else {
                i = i2;
            }
        }
        return getType(str, i + 1, str.length());
    }

    public static Type getType(String str) {
        return getType(str, 0, str.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        int i = this.sort;
        if (i == 12) {
            i = 10;
        }
        int i2 = type.sort;
        if (i != (i2 != 12 ? i2 : 10)) {
            return false;
        }
        int i3 = this.valueBegin;
        int i4 = this.valueEnd;
        int i5 = type.valueBegin;
        if (i4 - i3 != type.valueEnd - i5) {
            return false;
        }
        while (i3 < i4) {
            if (this.valueBuffer.charAt(i3) != type.valueBuffer.charAt(i5)) {
                return false;
            }
            i3++;
            i5++;
        }
        return true;
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(getElementType().getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return sb.toString();
            case 10:
            case 12:
                return this.valueBuffer.substring(this.valueBegin, this.valueEnd).replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            case 11:
            default:
                throw new AssertionError();
        }
    }

    public String getDescriptor() {
        int i = this.sort;
        if (i == 10) {
            return this.valueBuffer.substring(this.valueBegin - 1, this.valueEnd + 1);
        }
        if (i != 12) {
            return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
        }
        StringBuilder sb = new StringBuilder("L");
        sb.append((CharSequence) this.valueBuffer, this.valueBegin, this.valueEnd);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        return sb.toString();
    }

    public int getDimensions() {
        int i = 1;
        while (this.valueBuffer.charAt(this.valueBegin + i) == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return getType(this.valueBuffer, this.valueBegin + getDimensions(), this.valueEnd);
    }

    public String getInternalName() {
        return this.valueBuffer.substring(this.valueBegin, this.valueEnd);
    }

    public int getOpcode(int i) {
        if (i == 46 || i == 79) {
            switch (this.sort) {
                case 0:
                case 11:
                    throw new UnsupportedOperationException();
                case 1:
                case 3:
                    return i + 5;
                case 2:
                    return i + 6;
                case 4:
                    return i + 7;
                case 5:
                    return i;
                case 6:
                    return i + 2;
                case 7:
                    return i + 1;
                case 8:
                    return i + 3;
                case 9:
                case 10:
                case 12:
                    return i + 4;
                default:
                    throw new AssertionError();
            }
        }
        switch (this.sort) {
            case 0:
                if (i == 172) {
                    return 177;
                }
                throw new UnsupportedOperationException();
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return i;
            case 6:
                return i + 2;
            case 7:
                return i + 1;
            case 8:
                return i + 3;
            case 9:
            case 10:
            case 12:
                if (i == 21 || i == 54 || i == 172) {
                    return i + 4;
                }
                throw new UnsupportedOperationException();
            case 11:
                throw new UnsupportedOperationException();
            default:
                throw new AssertionError();
        }
    }

    public int getSize() {
        switch (this.sort) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 12:
                return 1;
            case 7:
            case 8:
                return 2;
            case 11:
            default:
                throw new AssertionError();
        }
    }

    public int getSort() {
        int i = this.sort;
        if (i == 12) {
            return 10;
        }
        return i;
    }

    public int hashCode() {
        int i = this.sort;
        int iCharAt = (i == 12 ? 10 : i) * 13;
        if (i >= 9) {
            int i2 = this.valueEnd;
            for (int i3 = this.valueBegin; i3 < i2; i3++) {
                iCharAt = (this.valueBuffer.charAt(i3) + iCharAt) * 17;
            }
        }
        return iCharAt;
    }

    public String toString() {
        return getDescriptor();
    }

    public static String getInternalName(Class<?> cls) {
        return cls.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
    }

    public static Type getMethodType(Type type, Type... typeArr) {
        return getType(getMethodDescriptor(type, typeArr));
    }

    public static Type getType(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return getType(getDescriptor(cls));
        }
        if (cls == Integer.TYPE) {
            return INT_TYPE;
        }
        if (cls == Void.TYPE) {
            return VOID_TYPE;
        }
        if (cls == Boolean.TYPE) {
            return BOOLEAN_TYPE;
        }
        if (cls == Byte.TYPE) {
            return BYTE_TYPE;
        }
        if (cls == Character.TYPE) {
            return CHAR_TYPE;
        }
        if (cls == Short.TYPE) {
            return SHORT_TYPE;
        }
        if (cls == Double.TYPE) {
            return DOUBLE_TYPE;
        }
        if (cls == Float.TYPE) {
            return FLOAT_TYPE;
        }
        if (cls == Long.TYPE) {
            return LONG_TYPE;
        }
        throw new AssertionError();
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    private static void appendDescriptor(StringBuilder sb, Class<?> cls) {
        char c;
        while (cls.isArray()) {
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                c = 'I';
            } else if (cls == Void.TYPE) {
                c = 'V';
            } else if (cls == Boolean.TYPE) {
                c = 'Z';
            } else if (cls == Byte.TYPE) {
                c = 'B';
            } else if (cls == Character.TYPE) {
                c = 'C';
            } else if (cls == Short.TYPE) {
                c = 'S';
            } else if (cls == Double.TYPE) {
                c = 'D';
            } else if (cls == Float.TYPE) {
                c = 'F';
            } else {
                if (cls != Long.TYPE) {
                    throw new AssertionError();
                }
                c = 'J';
            }
            sb.append(c);
            return;
        }
        sb.append('L');
        String name = cls.getName();
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = name.charAt(i);
            if (cCharAt == '.') {
                cCharAt = '/';
            }
            sb.append(cCharAt);
        }
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public static String getDescriptor(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        appendDescriptor(sb, cls);
        return sb.toString();
    }

    public static String getMethodDescriptor(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : method.getParameterTypes()) {
            appendDescriptor(sb, cls);
        }
        sb.append(')');
        appendDescriptor(sb, method.getReturnType());
        return sb.toString();
    }

    public static Type[] getArgumentTypes(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType(parameterTypes[length]);
        }
        return typeArr;
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public static Type getType(Constructor<?> constructor) {
        return getType(getConstructorDescriptor(constructor));
    }

    public static Type getType(Method method) {
        return getType(getMethodDescriptor(method));
    }

    private static Type getType(String str, int i, int i2) {
        char cCharAt = str.charAt(i);
        if (cCharAt == '(') {
            return new Type(11, str, i, i2);
        }
        if (cCharAt == 'F') {
            return FLOAT_TYPE;
        }
        if (cCharAt == 'L') {
            return new Type(10, str, i + 1, i2 - 1);
        }
        if (cCharAt == 'S') {
            return SHORT_TYPE;
        }
        if (cCharAt == 'V') {
            return VOID_TYPE;
        }
        if (cCharAt == 'I') {
            return INT_TYPE;
        }
        if (cCharAt == 'J') {
            return LONG_TYPE;
        }
        if (cCharAt == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (cCharAt != '[') {
            switch (cCharAt) {
                case 'B':
                    return BYTE_TYPE;
                case 'C':
                    return CHAR_TYPE;
                case 'D':
                    return DOUBLE_TYPE;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return new Type(9, str, i, i2);
    }
}
