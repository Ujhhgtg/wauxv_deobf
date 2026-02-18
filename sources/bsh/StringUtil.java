package bsh;

import com.umeng.analytics.pro.bt;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.cpt;
import me.hd.wauxv.obf.cpv;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.rb;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class StringUtil {
    public static String classString(Class<?> cls) {
        if (Reflect.isGeneratedClass(cls)) {
            return generatedClassString(cls);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(cls.getModifiers()));
        sb.append(cls.isInterface() ? "" : " class");
        sb.append(" ");
        sb.append(getTypeName(cls));
        sb.append(getTypeExtends(cls));
        sb.append(getTypeImplements(cls));
        sb.append(" {");
        return sb.toString().trim();
    }

    private static String generatedClassString(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflect.getClassModifiers(cls).toString().substring(11));
        sb.append(cls.isInterface() ? " interface" : " class");
        sb.append(" ");
        sb.append(getTypeName(cls));
        sb.append(getTypeExtends(cls));
        sb.append(getTypeImplements(cls));
        sb.append(" {");
        return sb.toString().trim();
    }

    private static String getTypeExtends(Class<?> cls) {
        if (cls.isInterface()) {
            return "";
        }
        return " extends " + getTypeName(cls.getSuperclass());
    }

    private static String getTypeImplements(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        if (cls.getInterfaces().length > 0) {
            sb.append(cls.isInterface() ? " extends " : " implements ");
            sb.append(String.join(", ", getTypeNamesList(cls.getInterfaces())));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getTypeName(Class<?> cls) {
        return cls == null ? "Object" : cls.getSimpleName();
    }

    private static String[] getTypeNames(Class<?>[] clsArr) {
        return (String[]) getTypeNamesStream(clsArr).toArray(new rb(16));
    }

    private static List<String> getTypeNamesList(Class<?>[] clsArr) {
        return (List) getTypeNamesStream(clsArr).collect(Collectors.toList());
    }

    private static Stream<String> getTypeNamesStream(Class<?>[] clsArr) {
        return Stream.of((Object[]) clsArr).map(new cpv(26));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getTypeNames$0(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getTypeNames$1(Iterator it, String str) {
        StringBuilder sbR = bjs.r(str, " ");
        sbR.append((String) it.next());
        return sbR.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getTypeNames$2(int i) {
        return new String[i];
    }

    public static String maxCommonPrefix(String str, String str2) {
        int i = 0;
        while (str.regionMatches(0, str2, 0, i)) {
            i++;
        }
        return str.substring(0, i - 1);
    }

    public static String methodString(String str, Object[] objArr) {
        return methodString(str, Types.getTypes(objArr));
    }

    public static String typeString(Object obj) {
        return (obj == null || Primitive.NULL == obj) ? "null" : obj instanceof Primitive ? ((Primitive) obj).getType().getSimpleName() : typeString(Types.getType(obj));
    }

    public static String typeValueString(Object obj) {
        return valueString(obj) + " :" + typeString(obj);
    }

    public static String valueString(Object obj) {
        StringBuilder sb = new StringBuilder(dkz.r(obj, ""));
        if (obj != null && obj.getClass().isArray()) {
            StringBuilder sb2 = new StringBuilder("{");
            for (int i = 0; i < Array.getLength(obj); i++) {
                sb2.append(valueString(Array.get(obj, i)));
                sb2.append(", ");
            }
            if (sb2.reverse().charAt(0) == ' ') {
                sb2.delete(0, 2);
            }
            StringBuilder sbReverse = sb2.reverse();
            sbReverse.append("}");
            return sbReverse.toString();
        }
        if (obj instanceof Collection) {
            StringBuilder sb3 = new StringBuilder("[");
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                sb3.append(valueString(it.next()));
                sb3.append(", ");
            }
            if (sb3.reverse().charAt(0) == ' ') {
                sb3.delete(0, 2);
            }
            StringBuilder sbReverse2 = sb3.reverse();
            sbReverse2.append("]");
            return sbReverse2.toString();
        }
        if (obj instanceof Map) {
            StringBuilder sb4 = new StringBuilder("{");
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                sb4.append(valueString(entry.getKey()));
                sb4.append("=");
                sb4.append(valueString(entry.getValue()));
                sb4.append(", ");
            }
            if (sb4.reverse().charAt(0) == ' ') {
                sb4.delete(0, 2);
            }
            StringBuilder sbReverse3 = sb4.reverse();
            sbReverse3.append("}");
            return sbReverse3.toString();
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry2 = (Map.Entry) obj;
            return valueString(entry2.getKey()) + "=" + valueString(entry2.getValue());
        }
        if (obj instanceof String) {
            StringBuilder sbInsert = sb.insert(0, "\"");
            sbInsert.append("\"");
            return sbInsert.toString();
        }
        if (Primitive.unwrap(obj) instanceof Character) {
            StringBuilder sbInsert2 = sb.insert(0, "'");
            sbInsert2.append("'");
            return sbInsert2.toString();
        }
        if (Primitive.unwrap(obj) instanceof Number) {
            if (Primitive.unwrap(obj) instanceof Byte) {
                sb.append("o");
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof Short) {
                sb.append(bt.az);
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof Integer) {
                sb.append("I");
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof Long) {
                sb.append("L");
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof BigInteger) {
                sb.append("W");
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof Float) {
                sb.append("f");
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof Double) {
                sb.append("d");
                return sb.toString();
            }
            if (Primitive.unwrap(obj) instanceof BigDecimal) {
                sb.append("w");
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static String variableString(Variable variable) {
        return variable.getModifiers().toString().substring(11) + " " + getTypeName(variable.getType()) + " " + variable.getName() + ";";
    }

    private static String[] getTypeNames(Class<?>[] clsArr, String[] strArr) {
        return (String[]) getTypeNamesStream(clsArr).map(new cpt(Stream.of((Object[]) strArr).iterator(), 5)).toArray(new rb(15));
    }

    public static String methodString(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('(');
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(strArr[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Found duplicated region for block: B:4:0x0008 A[PHI: r0
      0x0008: PHI (r0v9 java.lang.Class<?>) = 
      (r0v0 java.lang.Class<?>)
      (r0v2 java.lang.Class<?>)
      (r0v3 java.lang.Class<?>)
      (r0v4 java.lang.Class<?>)
      (r0v1 java.lang.Class<?>)
     binds: [B:3:0x0006, B:11:0x0022, B:14:0x002b, B:17:0x0034, B:8:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
    public static String typeString(Class<?> cls) {
        Class<?> cls2 = Map.class;
        if (!cls2.isAssignableFrom(cls)) {
            cls2 = List.class;
            if (cls2.isAssignableFrom(cls)) {
                cls = Queue.class.isAssignableFrom(cls) ? Queue.class : cls2;
            } else {
                cls2 = Deque.class;
                if (!cls2.isAssignableFrom(cls)) {
                    cls2 = Set.class;
                    if (!cls2.isAssignableFrom(cls)) {
                        cls2 = Map.Entry.class;
                        if (cls2.isAssignableFrom(cls)) {
                        }
                    }
                }
            }
        }
        if (!cls.isArray()) {
            return cls.getName().startsWith("java") ? cls.getSimpleName() : cls.getName();
        }
        return typeString(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static String variableString(Field field) {
        return Modifier.toString(field.getModifiers()) + " " + getTypeName(field.getType()) + " " + field.getName() + ";";
    }

    public static String methodString(String str, Class<?>[] clsArr) {
        return methodString(str, getTypeNames(clsArr));
    }

    public static String methodString(String str, Class<?>[] clsArr, String[] strArr) {
        return methodString(str, getTypeNames(clsArr, strArr));
    }

    public static String methodString(Method method) {
        String string = Modifier.toString(method.getModifiers());
        StringBuilder sbR = bjs.r(string, " ");
        sbR.append(getTypeName(method.getReturnType()));
        sbR.append(" ");
        sbR.append(methodString(method.getName(), method.getParameterTypes()));
        sbR.append(string.contains("abstract") ? ";" : " {}");
        return sbR.toString();
    }

    public static String methodString(BshMethod bshMethod) {
        String strSubstring = bshMethod.getModifiers().toString().substring(11);
        StringBuilder sbR = bjs.r(strSubstring, " ");
        sbR.append(getTypeName(bshMethod.getReturnType()));
        sbR.append(" ");
        sbR.append(methodString(bshMethod.getName(), bshMethod.getParameterTypes(), bshMethod.getParameterNames()));
        sbR.append(strSubstring.contains("abstract") ? ";" : " {}");
        return sbR.toString();
    }
}
