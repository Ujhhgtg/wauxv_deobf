package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.filter.Filter;
import com.alibaba.fastjson2.function.FieldSupplier;
import com.alibaba.fastjson2.function.FieldSupplierFunction;
import com.alibaba.fastjson2.function.ToByteFunction;
import com.alibaba.fastjson2.function.ToCharFunction;
import com.alibaba.fastjson2.function.ToFloatFunction;
import com.alibaba.fastjson2.function.ToShortFunction;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.ObjectWriterBaseModule;
import com.alibaba.fastjson2.writer.ObjectWriterCreator;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import me.hd.wauxv.obf.cqb;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ObjectWriterCreator {
    public static final ObjectWriterCreator INSTANCE = new ObjectWriterCreator();
    static final Map<Class, LambdaInfo> lambdaMapping;
    protected final AtomicInteger jitErrorCount = new AtomicInteger();
    protected volatile Throwable jitErrorLast;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class LambdaInfo {
        final Class fieldClass;
        final MethodType invokedType;
        final String methodName;
        final MethodType methodType;
        final MethodType samMethodType;
        final Class supplierClass;

        public LambdaInfo(Class cls, Class cls2, String str) {
            this.fieldClass = cls;
            this.supplierClass = cls2;
            this.methodName = str;
            this.methodType = MethodType.methodType(cls);
            this.invokedType = MethodType.methodType(cls2);
            this.samMethodType = MethodType.methodType((Class<?>) cls, (Class<?>) Object.class);
        }
    }

    static {
        HashMap map = new HashMap();
        lambdaMapping = map;
        Class cls = Boolean.TYPE;
        map.put(cls, new LambdaInfo(cls, Predicate.class, "test"));
        Class cls2 = Character.TYPE;
        map.put(cls2, new LambdaInfo(cls2, ToCharFunction.class, "applyAsChar"));
        Class cls3 = Byte.TYPE;
        map.put(cls3, new LambdaInfo(cls3, ToByteFunction.class, "applyAsByte"));
        Class cls4 = Short.TYPE;
        map.put(cls4, new LambdaInfo(cls4, ToShortFunction.class, "applyAsShort"));
        Class cls5 = Integer.TYPE;
        map.put(cls5, new LambdaInfo(cls5, ToIntFunction.class, "applyAsInt"));
        Class cls6 = Long.TYPE;
        map.put(cls6, new LambdaInfo(cls6, ToLongFunction.class, "applyAsLong"));
        Class cls7 = Float.TYPE;
        map.put(cls7, new LambdaInfo(cls7, ToFloatFunction.class, "applyAsFloat"));
        Class cls8 = Double.TYPE;
        map.put(cls8, new LambdaInfo(cls8, ToDoubleFunction.class, "applyAsDouble"));
    }

    public static void configSerializeFilters(BeanInfo beanInfo, ObjectWriterAdapter objectWriterAdapter) {
        for (Class<? extends Filter> cls : beanInfo.serializeFilters) {
            if (Filter.class.isAssignableFrom(cls)) {
                try {
                    objectWriterAdapter.setFilter(cls.newInstance());
                } catch (IllegalAccessException | InstantiationException unused) {
                }
            }
        }
    }

    public static String getFieldName(Class cls, ObjectWriterProvider objectWriterProvider, BeanInfo beanInfo, boolean z, FieldInfo fieldInfo, Method method) {
        char cCharAt;
        Field field;
        String str = fieldInfo.fieldName;
        if (str != null && !str.isEmpty()) {
            return fieldInfo.fieldName;
        }
        if (z) {
            return method.getName();
        }
        String str2 = BeanUtils.getterName(method, beanInfo.kotlin, beanInfo.namingStrategy);
        if ((objectWriterProvider.userDefineMask & 64) != 0 && (field = BeanUtils.getField(cls, method)) != null) {
            return field.getName();
        }
        int length = str2.length();
        char cCharAt2 = length > 0 ? str2.charAt(0) : (char) 0;
        if ((length == 1 && cCharAt2 >= 'a' && cCharAt2 <= 'z') || (length > 2 && cCharAt2 >= 'A' && cCharAt2 <= 'Z' && (cCharAt = str2.charAt(1)) >= 'A' && cCharAt <= 'Z')) {
            char[] charArray = str2.toCharArray();
            if (cCharAt2 >= 'a') {
                charArray[0] = (char) (charArray[0] - ' ');
            } else {
                charArray[0] = (char) (charArray[0] + ' ');
            }
            Field declaredField = BeanUtils.getDeclaredField(cls, new String(charArray));
            if (declaredField != null && (length == 1 || Modifier.isPublic(declaredField.getModifiers()))) {
                return declaredField.getName();
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createObjectWriter$0(FieldInfo fieldInfo, Class cls, long j, ObjectWriterProvider objectWriterProvider, BeanInfo beanInfo, Map map, Field field) {
        fieldInfo.init();
        FieldWriter fieldWriterCreateFieldWriter = createFieldWriter(cls, j, objectWriterProvider, beanInfo, fieldInfo, field);
        if (fieldWriterCreateFieldWriter != null) {
            if (fieldInfo.writeUsing != null && (fieldWriterCreateFieldWriter instanceof FieldWriterObject)) {
                ((FieldWriterObject) fieldWriterCreateFieldWriter).writeUsing = true;
            }
            map.put(fieldWriterCreateFieldWriter.fieldName, fieldWriterCreateFieldWriter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createObjectWriter$1(FieldInfo fieldInfo, Class cls, long j, ObjectWriterProvider objectWriterProvider, BeanInfo beanInfo, Map map, Field field) {
        fieldInfo.init();
        fieldInfo.ignore = (field.getModifiers() & 1) == 0;
        FieldWriter fieldWriterCreateFieldWriter = createFieldWriter(cls, j, objectWriterProvider, beanInfo, fieldInfo, field);
        if (fieldWriterCreateFieldWriter != null) {
            if (fieldInfo.writeUsing != null && (fieldWriterCreateFieldWriter instanceof FieldWriterObject)) {
                ((FieldWriterObject) fieldWriterCreateFieldWriter).writeUsing = true;
            }
            FieldWriter fieldWriter = (FieldWriter) map.putIfAbsent(fieldWriterCreateFieldWriter.fieldName, fieldWriterCreateFieldWriter);
            if (fieldWriter == null || fieldWriter.compareTo(fieldWriterCreateFieldWriter) <= 0) {
                return;
            }
            map.put(fieldWriterCreateFieldWriter.fieldName, fieldWriterCreateFieldWriter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Found duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:68:0x00ec A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:69:0x0106  */
    /* JADX WARN: Found duplicated region for block: B:81:0x012c  */
    /* JADX WARN: Found duplicated region for block: B:86:0x0150  */
    /* JADX WARN: Found duplicated region for block: B:88:0x0154  */
    /* JADX WARN: Found duplicated region for block: B:91:0x016f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r14v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.alibaba.fastjson2.writer.ObjectWriterCreator] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.alibaba.fastjson2.writer.ObjectWriterCreator] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.alibaba.fastjson2.writer.ObjectWriterCreator] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    public /* synthetic */ void lambda$createObjectWriter$2(FieldInfo fieldInfo, long j, BeanInfo beanInfo, ObjectWriterProvider objectWriterProvider, Class cls, boolean z, Map map, Method method) throws IllegalAccessException, NoSuchMethodException {
        ObjectWriter objectWriter;
        boolean z2;
        FieldWriter fieldWriter;
        ?? r1;
        FieldWriter fieldWriterCreateFieldWriterLambda;
        ?? r14;
        ?? r12;
        Method method2;
        FieldWriter fieldWriter2;
        char cCharAt;
        Object obj;
        FieldWriter fieldWriter3;
        boolean z3;
        ?? r13;
        String[] strArr;
        fieldInfo.init();
        fieldInfo.features = j;
        fieldInfo.format = beanInfo.format;
        objectWriterProvider.getFieldInfo(beanInfo, fieldInfo, cls, method);
        if (fieldInfo.ignore) {
            return;
        }
        ?? fieldName = getFieldName(cls, objectWriterProvider, beanInfo, z, fieldInfo, method);
        ?? r0 = beanInfo.includes;
        if (r0 != 0 && r0.length > 0) {
            for (?? r02 : r0) {
                if (!r02.equals(fieldName)) {
                }
            }
            return;
        }
        if ((beanInfo.writerFeatures & JSONWriter.Feature.WriteClassName.mask) == 0 || !fieldName.equals(beanInfo.typeKey)) {
            if (beanInfo.orders != null) {
                int i = 0;
                boolean z4 = false;
                while (true) {
                    strArr = beanInfo.orders;
                    if (i >= strArr.length) {
                        break;
                    }
                    if (fieldName.equals(strArr[i])) {
                        fieldInfo.ordinal = i;
                        z4 = true;
                    }
                    i++;
                }
                if (!z4 && fieldInfo.ordinal == 0) {
                    fieldInfo.ordinal = strArr.length;
                }
            }
            if (TypeUtils.isFunction(method.getReturnType())) {
                return;
            }
            Class<?> cls2 = fieldInfo.writeUsing;
            if (cls2 != null) {
                try {
                    Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    objectWriter = (ObjectWriter) declaredConstructor.newInstance(null);
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    throw new JSONException("create writeUsing Writer error", e);
                }
            } else {
                objectWriter = null;
            }
            if (objectWriter == null && fieldInfo.fieldClassMixIn) {
                objectWriter = ObjectWriterBaseModule.VoidObjectWriter.INSTANCE;
            }
            ObjectWriter objectWriter2 = objectWriter;
            if ((beanInfo.readerFeatures & FieldInfo.JIT) != 0) {
                try {
                    z2 = true;
                    fieldWriter = null;
                    r1 = this;
                    try {
                        fieldWriterCreateFieldWriterLambda = r1.createFieldWriterLambda(objectWriterProvider, cls, fieldName, fieldInfo.ordinal, fieldInfo.features, fieldInfo.format, fieldInfo.label, method, objectWriter2, fieldInfo.contentAs);
                        r12 = r1;
                        r14 = z2;
                    } catch (Throwable th) {
                        th = th;
                        r1.jitErrorCount.incrementAndGet();
                        r1.jitErrorLast = th;
                        r13 = r1;
                        z3 = z2;
                        fieldWriterCreateFieldWriterLambda = fieldWriter;
                        r12 = r13;
                        r14 = z3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = true;
                    fieldWriter = null;
                    r1 = this;
                }
                if (fieldWriterCreateFieldWriterLambda == null) {
                    fieldWriterCreateFieldWriterLambda = r12.createFieldWriter(objectWriterProvider, cls, fieldName, fieldInfo.ordinal, fieldInfo.features, fieldInfo.format, fieldInfo.locale, fieldInfo.label, method, objectWriter2, fieldInfo.contentAs);
                    method2 = method;
                } else {
                    method2 = method;
                }
                if (fieldInfo.writeUsing != null && (fieldWriterCreateFieldWriterLambda instanceof FieldWriterObject)) {
                    ((FieldWriterObject) fieldWriterCreateFieldWriterLambda).writeUsing = r14;
                }
                fieldWriter2 = (FieldWriter) map.putIfAbsent(fieldWriterCreateFieldWriterLambda.fieldName, fieldWriterCreateFieldWriterLambda);
                if (fieldWriter2 != null && fieldWriter2.compareTo(fieldWriterCreateFieldWriterLambda) > 0) {
                    map.put(fieldName, fieldWriterCreateFieldWriterLambda);
                }
                if (fieldWriter2 == null) {
                    cCharAt = fieldName.charAt(0);
                    if (cCharAt < 'A' && cCharAt <= 'Z') {
                        obj = ((char) (cCharAt + ' ')) + fieldName.substring(r14);
                    } else if (cCharAt < 'a' && cCharAt <= 'z') {
                        obj = ((char) (cCharAt - ' ')) + fieldName.substring(r14);
                    }
                    if (obj != null || (fieldWriter3 = (FieldWriter) map.get(obj)) == null) {
                    }
                    Method method3 = fieldWriter3.method;
                    if (method3 == null || method3.equals(method2)) {
                        map.remove(obj);
                        return;
                    }
                    return;
                }
            }
            z3 = true;
            fieldWriter = null;
            r13 = this;
            fieldWriterCreateFieldWriterLambda = fieldWriter;
            r12 = r13;
            r14 = z3;
            if (fieldWriterCreateFieldWriterLambda == null) {
                fieldWriterCreateFieldWriterLambda = r12.createFieldWriter(objectWriterProvider, cls, fieldName, fieldInfo.ordinal, fieldInfo.features, fieldInfo.format, fieldInfo.locale, fieldInfo.label, method, objectWriter2, fieldInfo.contentAs);
                method2 = method;
            } else {
                method2 = method;
            }
            if (fieldInfo.writeUsing != null) {
                ((FieldWriterObject) fieldWriterCreateFieldWriterLambda).writeUsing = r14;
            }
            fieldWriter2 = (FieldWriter) map.putIfAbsent(fieldWriterCreateFieldWriterLambda.fieldName, fieldWriterCreateFieldWriterLambda);
            if (fieldWriter2 != null) {
                map.put(fieldName, fieldWriterCreateFieldWriterLambda);
            }
            if (fieldWriter2 == null) {
                cCharAt = fieldName.charAt(0);
                if (cCharAt < 'A') {
                    obj = cCharAt < 'a' ? fieldWriter : fieldWriter;
                } else if (cCharAt < 'a') {
                }
                if (obj != null) {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.alibaba.fastjson2.writer.ObjectWriter] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.alibaba.fastjson2.writer.ObjectWriterCreator] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.alibaba.fastjson2.writer.ObjectWriterImplMap] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [com.alibaba.fastjson2.writer.ObjectWriterBaseModule$VoidObjectWriter] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public FieldWriter createFieldWriter(Class cls, long j, ObjectWriterProvider objectWriterProvider, BeanInfo beanInfo, FieldInfo fieldInfo, Field field) {
        String name;
        ?? Of;
        String str;
        Class<?> cls2;
        ObjectWriter objectWriter;
        String[] strArr;
        fieldInfo.features = j;
        objectWriterProvider.getFieldInfo(beanInfo, fieldInfo, cls, field);
        ObjectWriter objectWriter2 = null;
        if (fieldInfo.ignore || TypeUtils.isFunction(field.getType())) {
            return null;
        }
        String str2 = fieldInfo.fieldName;
        if (str2 == null || str2.isEmpty()) {
            name = field.getName();
            String str3 = beanInfo.namingStrategy;
            if (str3 != null) {
                name = BeanUtils.fieldName(name, str3);
            }
        } else {
            name = fieldInfo.fieldName;
        }
        if (beanInfo.orders != null) {
            int i = 0;
            boolean z = false;
            while (true) {
                strArr = beanInfo.orders;
                if (i >= strArr.length) {
                    break;
                }
                if (name.equals(strArr[i])) {
                    fieldInfo.ordinal = i;
                    z = true;
                }
                i++;
            }
            if (!z && fieldInfo.ordinal == 0) {
                fieldInfo.ordinal = strArr.length;
            }
        }
        if (fieldInfo.ordinal == 0 && name.equals(beanInfo.typeKey)) {
            fieldInfo.ordinal = -1;
        }
        String[] strArr2 = beanInfo.includes;
        if (strArr2 != null && strArr2.length > 0) {
            for (String str4 : strArr2) {
                if (!str4.equals(name)) {
                }
            }
            return null;
        }
        Class<?> cls3 = fieldInfo.writeUsing;
        if (cls3 != null) {
            try {
                Constructor<?> declaredConstructor = cls3.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                Of = (ObjectWriter) declaredConstructor.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                throw new JSONException("create writeUsing Writer error", e);
            }
        } else {
            Of = 0;
        }
        try {
            field.setAccessible(true);
        } catch (Throwable unused) {
        }
        if (Of == 0 && fieldInfo.fieldClassMixIn) {
            Of = ObjectWriterBaseModule.VoidObjectWriter.INSTANCE;
        }
        if (Of == 0) {
            Class<?> type = field.getType();
            if (type == Date.class) {
                ObjectWriter objectWriter3 = objectWriterProvider.cache.get(type);
                if (objectWriter3 != ObjectWriterImplDate.INSTANCE) {
                    Of = objectWriter3;
                }
            } else if (Map.class.isAssignableFrom(type) && ((cls2 = fieldInfo.keyUsing) != null || fieldInfo.valueUsing != null)) {
                if (cls2 != null) {
                    try {
                        Constructor<?> declaredConstructor2 = cls2.getDeclaredConstructor(null);
                        declaredConstructor2.setAccessible(true);
                        objectWriter = (ObjectWriter) declaredConstructor2.newInstance(null);
                    } catch (Exception unused2) {
                        objectWriter = null;
                    }
                } else {
                    objectWriter = null;
                }
                Class<?> cls4 = fieldInfo.valueUsing;
                if (cls4 != null) {
                    try {
                        Constructor<?> declaredConstructor3 = cls4.getDeclaredConstructor(null);
                        declaredConstructor3.setAccessible(true);
                        objectWriter2 = (ObjectWriter) declaredConstructor3.newInstance(null);
                    } catch (Exception unused3) {
                    }
                }
                if (objectWriter != null || objectWriter2 != null) {
                    Of = ObjectWriterImplMap.of(field.getType(), type);
                    Of.keyWriter = objectWriter;
                    Of.valueWriter = objectWriter2;
                }
            }
        }
        ?? r11 = Of;
        String str5 = fieldInfo.format;
        return createFieldWriter(objectWriterProvider, name, fieldInfo.ordinal, fieldInfo.features, (str5 != null || (str = beanInfo.format) == null) ? str5 : str, fieldInfo.locale, fieldInfo.label, field, r11, fieldInfo.contentAs);
    }

    public <T> FieldWriter<T> createFieldWriterLambda(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, String str3, Method method, ObjectWriter objectWriter, Class<?> cls2) throws IllegalAccessException, NoSuchMethodException {
        Class<?> returnType = method.getReturnType();
        Type genericReturnType = method.getGenericReturnType();
        if (((objectWriter != null || objectWriterProvider == null) ? objectWriter : getInitWriter(objectWriterProvider, returnType)) != null) {
            return null;
        }
        String name = cls.getName();
        if (name.indexOf(36) != -1 && name.contains("$$")) {
            return null;
        }
        Object objLambdaGetter = lambdaGetter(cls, returnType, method);
        Field field = BeanUtils.getField(cls, method);
        return returnType == Integer.TYPE ? new FieldWriterInt32ValFunc(str, i, j, str2, str3, null, method, (ToIntFunction) objLambdaGetter) : returnType == Long.TYPE ? (str2 == null || str2.isEmpty() || "string".equals(str2)) ? new FieldWriterInt64ValFunc(str, i, j, str2, str3, field, method, (ToLongFunction) objLambdaGetter) : new FieldWriterMillisFunc(str, i, j, str2, str3, field, method, (ToLongFunction) objLambdaGetter) : returnType == Boolean.TYPE ? new FieldWriterBoolValFunc(str, i, j, str2, str3, field, method, (Predicate) objLambdaGetter) : returnType == Boolean.class ? new FieldWriterBooleanFunc(str, i, j, str2, str3, field, method, (Function) objLambdaGetter) : returnType == Short.TYPE ? new FieldWriterInt16ValFunc(str, i, j, str2, str3, field, method, (ToShortFunction) objLambdaGetter) : returnType == Byte.TYPE ? new FieldWriterInt8ValFunc(str, i, j, str2, str3, field, method, (ToByteFunction) objLambdaGetter) : returnType == Float.TYPE ? new FieldWriterFloatValueFunc(str, i, j, str2, str3, field, method, (ToFloatFunction) objLambdaGetter) : returnType == Float.class ? new FieldWriterFloatFunc(str, i, j, str2, str3, field, method, (Function) objLambdaGetter) : returnType == Double.TYPE ? new FieldWriterDoubleValueFunc(str, i, j, str2, str3, field, method, (ToDoubleFunction) objLambdaGetter) : returnType == Double.class ? new FieldWriterDoubleFunc(str, i, j, str2, str3, field, method, (Function) objLambdaGetter) : returnType == Character.TYPE ? new FieldWriterCharValFunc(str, i, j, str2, str3, field, method, (ToCharFunction) objLambdaGetter) : createFieldWriter(objectWriterProvider, cls, str, i, j, str2, null, str3, genericReturnType, returnType, field, method, (Function) objLambdaGetter, cls2);
    }

    public ObjectWriter createObjectWriter(List<FieldWriter> list) {
        return new ObjectWriterAdapter(null, null, null, 0L, list);
    }

    public ObjectWriter getInitWriter(ObjectWriterProvider objectWriterProvider, Class cls) {
        ObjectWriter objectWriter;
        ObjectWriter objectWriter2;
        ObjectWriter objectWriter3;
        ObjectWriter objectWriter4;
        if (cls == Date.class) {
            if ((objectWriterProvider.userDefineMask & 16) == 0 || (objectWriter4 = objectWriterProvider.cache.get(cls)) == ObjectWriterImplDate.INSTANCE) {
                return null;
            }
            return objectWriter4;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            if ((objectWriterProvider.userDefineMask & 2) == 0 || (objectWriter = objectWriterProvider.cache.get(Integer.class)) == ObjectWriterImplInt32.INSTANCE) {
                return null;
            }
            return objectWriter;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            if ((objectWriterProvider.userDefineMask & 4) == 0 || (objectWriter2 = objectWriterProvider.cache.get(Long.class)) == ObjectWriterImplInt64.INSTANCE) {
                return null;
            }
            return objectWriter2;
        }
        if (cls == BigDecimal.class) {
            if ((objectWriterProvider.userDefineMask & 8) == 0 || (objectWriter3 = objectWriterProvider.cache.get(cls)) == ObjectWriterImplBigDecimal.INSTANCE) {
                return null;
            }
            return objectWriter3;
        }
        if (!Enum.class.isAssignableFrom(cls)) {
            return null;
        }
        ObjectWriter objectWriter5 = objectWriterProvider.cache.get(cls);
        if (objectWriter5 instanceof ObjectWriterImplEnum) {
            return null;
        }
        return objectWriter5;
    }

    public void handleIgnores(BeanInfo beanInfo, List<FieldWriter> list) {
        String[] strArr = beanInfo.ignores;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldWriter fieldWriter = list.get(size);
            for (String str : beanInfo.ignores) {
                if (str.equals(fieldWriter.fieldName)) {
                    list.remove(size);
                    break;
                }
            }
        }
    }

    public Object lambdaGetter(Class cls, Class cls2, Method method) throws IllegalAccessException, NoSuchMethodException {
        MethodType methodType;
        MethodType methodType2;
        MethodType methodType3;
        String str;
        MethodHandles.Lookup lookupTrustedLookup = JDKUtils.trustedLookup(cls);
        LambdaInfo lambdaInfo = lambdaMapping.get(cls2);
        if (lambdaInfo != null) {
            methodType = lambdaInfo.methodType;
            methodType2 = lambdaInfo.invokedType;
            str = lambdaInfo.methodName;
            methodType3 = lambdaInfo.samMethodType;
        } else {
            methodType = MethodType.methodType(cls2);
            methodType2 = TypeUtils.METHOD_TYPE_FUNCTION;
            methodType3 = TypeUtils.METHOD_TYPE_OBJECT_OBJECT;
            str = "apply";
        }
        String str2 = str;
        MethodType methodType4 = methodType3;
        try {
            MethodHandle methodHandleFindVirtual = lookupTrustedLookup.findVirtual(cls, method.getName(), methodType);
            return (Object) LambdaMetafactory.metafactory(lookupTrustedLookup, str2, methodType2, methodType4, methodHandleFindVirtual, methodHandleFindVirtual.type()).getTarget().invoke();
        } catch (Throwable th) {
            throw new JSONException("create fieldLambdaGetter error, method : " + method, th);
        }
    }

    public void setDefaultValue(List<FieldWriter> list, Class cls) {
        Object objNewInstance;
        Constructor defaultConstructor = BeanUtils.getDefaultConstructor(cls, true);
        if (defaultConstructor == null) {
            return;
        }
        int parameterCount = defaultConstructor.getParameterCount();
        try {
            defaultConstructor.setAccessible(true);
            if (parameterCount == 0) {
                objNewInstance = defaultConstructor.newInstance(null);
            } else if (parameterCount != 1) {
                return;
            } else {
                objNewInstance = defaultConstructor.newInstance(Boolean.TRUE);
            }
            Iterator<FieldWriter> it = list.iterator();
            while (it.hasNext()) {
                it.next().setDefaultValue(objNewInstance);
            }
        } catch (Exception unused) {
        }
    }

    public ObjectWriter createObjectWriter(FieldWriter... fieldWriterArr) {
        return createObjectWriter(Arrays.asList(fieldWriterArr));
    }

    public <T> ObjectWriter<T> createObjectWriter(String[] strArr, Type[] typeArr, FieldSupplier<T> fieldSupplier) {
        FieldWriter[] fieldWriterArr = new FieldWriter[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            Type type = typeArr[i];
            fieldWriterArr[i] = createFieldWriter(str, type, TypeUtils.getClass(type), new FieldSupplierFunction(fieldSupplier, i));
        }
        return createObjectWriter(fieldWriterArr);
    }

    public ObjectWriter createObjectWriter(Class cls) {
        return createObjectWriter(cls, 0L, JSONFactory.getDefaultObjectWriterProvider());
    }

    public ObjectWriter createObjectWriter(Class cls, FieldWriter... fieldWriterArr) {
        return createObjectWriter(cls, 0L, fieldWriterArr);
    }

    public ObjectWriter createObjectWriter(Class cls, long j, FieldWriter... fieldWriterArr) {
        if (fieldWriterArr.length == 0) {
            return createObjectWriter(cls, j, JSONFactory.getDefaultObjectWriterProvider());
        }
        if (cls != null) {
            String name = cls.getName();
            if ("com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList".equals(name) || "com.google.common.collect.AbstractMapBasedMultimap$WrappedSet".equals(name)) {
                return new ObjectWriterAdapter(cls, null, null, j, Arrays.asList(fieldWriterArr));
            }
        }
        switch (fieldWriterArr.length) {
            case 1:
                if ((fieldWriterArr[0].features & FieldInfo.VALUE_MASK) == 0) {
                    return new ObjectWriter1(cls, null, null, j, Arrays.asList(fieldWriterArr));
                }
                return new ObjectWriterAdapter(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 2:
                return new ObjectWriter2(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 3:
                return new ObjectWriter3(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 4:
                return new ObjectWriter4(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 5:
                return new ObjectWriter5(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 6:
                return new ObjectWriter6(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 7:
                return new ObjectWriter7(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 8:
                return new ObjectWriter8(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 9:
                return new ObjectWriter9(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 10:
                return new ObjectWriter10(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 11:
                return new ObjectWriter11(cls, null, null, j, Arrays.asList(fieldWriterArr));
            case 12:
                return new ObjectWriter12(cls, null, null, j, Arrays.asList(fieldWriterArr));
            default:
                return new ObjectWriterAdapter(cls, null, null, j, Arrays.asList(fieldWriterArr));
        }
    }

    public ObjectWriter createObjectWriter(Class cls, long j, List<ObjectWriterModule> list) {
        ObjectWriterProvider provider = null;
        for (ObjectWriterModule objectWriterModule : list) {
            if (provider == null) {
                provider = objectWriterModule.getProvider();
            }
        }
        return createObjectWriter(cls, j, provider);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Found duplicated region for block: B:52:0x010a  */
    /* JADX WARN: Found duplicated region for block: B:77:0x01e6  */
    /* JADX WARN: Found duplicated region for block: B:79:0x01e9 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:81:0x01ef A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:82:0x01fb A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:85:0x020c  */
    public ObjectWriter createObjectWriter(Class cls, long j, final ObjectWriterProvider objectWriterProvider) {
        final Class cls2;
        final ObjectWriterCreator objectWriterCreator;
        ArrayList arrayList;
        Class cls3;
        long j2;
        ObjectWriterCreator objectWriterCreator2;
        Class cls4;
        BeanInfo beanInfo;
        ArrayList arrayList2;
        long j3;
        String name;
        ObjectWriterAdapter objectWriterAdapter;
        ArrayList arrayList3;
        String str;
        final BeanInfo beanInfoCreateBeanInfo = objectWriterProvider.createBeanInfo();
        beanInfoCreateBeanInfo.readerFeatures |= FieldInfo.JIT;
        objectWriterProvider.getBeanInfo(beanInfoCreateBeanInfo, cls);
        Class cls5 = beanInfoCreateBeanInfo.serializer;
        if (cls5 != null && ObjectWriter.class.isAssignableFrom(cls5)) {
            try {
                return (ObjectWriter) beanInfoCreateBeanInfo.serializer.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                throw new JSONException("create serializer error", e);
            }
        }
        boolean zIsRecord = BeanUtils.isRecord(cls);
        long j4 = beanInfoCreateBeanInfo.writerFeatures;
        if (beanInfoCreateBeanInfo.seeAlso != null) {
            j4 &= ~JSONWriter.Feature.WriteClassName.mask;
        }
        final long j5 = j | j4;
        boolean z = (JSONWriter.Feature.FieldBased.mask & j5) != 0;
        boolean z2 = (z && (zIsRecord || cls.isInterface())) ? false : z;
        final FieldInfo fieldInfo = new FieldInfo();
        if (z2) {
            final TreeMap treeMap = new TreeMap();
            final int i = 0;
            cls2 = cls;
            objectWriterCreator = this;
            BeanUtils.declaredFields(cls2, new Consumer(objectWriterCreator) { // from class: me.hd.wauxv.obf.cqa
                public final /* synthetic */ ObjectWriterCreator b;

                {
                    this.b = objectWriterCreator;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i) {
                        case 0:
                            this.b.lambda$createObjectWriter$0(fieldInfo, cls2, j5, objectWriterProvider, beanInfoCreateBeanInfo, (TreeMap) treeMap, (Field) obj);
                            break;
                        default:
                            this.b.lambda$createObjectWriter$1(fieldInfo, cls2, j5, objectWriterProvider, beanInfoCreateBeanInfo, (LinkedHashMap) treeMap, (Field) obj);
                            break;
                    }
                }
            });
            arrayList = new ArrayList(treeMap.values());
        } else {
            cls2 = cls;
            objectWriterCreator = this;
            arrayList = new ArrayList();
            Iterator<ObjectWriterModule> it = objectWriterProvider.modules.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().createFieldWriters(objectWriterCreator, cls2, arrayList)) {
                    }
                } else {
                    final LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (zIsRecord) {
                        cls3 = cls2;
                    } else {
                        final int i2 = 1;
                        Consumer consumer = new Consumer(objectWriterCreator) { // from class: me.hd.wauxv.obf.cqa
                            public final /* synthetic */ ObjectWriterCreator b;

                            {
                                this.b = objectWriterCreator;
                            }

                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                switch (i2) {
                                    case 0:
                                        this.b.lambda$createObjectWriter$0(fieldInfo, cls2, j5, objectWriterProvider, beanInfoCreateBeanInfo, (TreeMap) linkedHashMap, (Field) obj);
                                        break;
                                    default:
                                        this.b.lambda$createObjectWriter$1(fieldInfo, cls2, j5, objectWriterProvider, beanInfoCreateBeanInfo, (LinkedHashMap) linkedHashMap, (Field) obj);
                                        break;
                                }
                            }
                        };
                        cls3 = cls2;
                        BeanUtils.declaredFields(cls3, consumer);
                    }
                    Class mixIn = objectWriterProvider.getMixIn(cls3);
                    boolean z3 = beanInfoCreateBeanInfo.kotlin;
                    j2 = 0;
                    Class cls6 = cls3;
                    cqb cqbVar = new cqb(this, fieldInfo, j5, beanInfoCreateBeanInfo, objectWriterProvider, cls6, zIsRecord, linkedHashMap, 0);
                    objectWriterCreator2 = this;
                    cls4 = cls6;
                    beanInfo = beanInfoCreateBeanInfo;
                    BeanUtils.getters(cls4, mixIn, z3, cqbVar);
                    arrayList2 = new ArrayList(linkedHashMap.values());
                    break;
                }
            }
            j3 = j | beanInfo.writerFeatures;
            if (z2 && Throwable.class.isAssignableFrom(cls4)) {
                return new ObjectWriterException(cls4, j3, arrayList2);
            }
            objectWriterCreator2.handleIgnores(beanInfo, arrayList2);
            if (beanInfo.alphabetic) {
                Collections.sort(arrayList2);
            }
            if (BeanUtils.isExtendedMap(cls4)) {
                arrayList2.add(ObjectWriters.fieldWriter(BeanUtils.SUPER, cls4.getGenericSuperclass(), cls4.getSuperclass(), Function.identity()));
            }
            objectWriterCreator2.setDefaultValue(arrayList2, cls4);
            name = cls4.getName();
            if ("com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList".equals(name) && !"com.google.common.collect.AbstractMapBasedMultimap$WrappedSet".equals(name) && beanInfo.rootName == null) {
                switch (arrayList2.size()) {
                    case 1:
                        if ((arrayList2.get(0).features & FieldInfo.VALUE_MASK) == j2) {
                            objectWriterAdapter = new ObjectWriter1(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        }
                        break;
                    case 2:
                        objectWriterAdapter = new ObjectWriter2(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 3:
                        objectWriterAdapter = new ObjectWriter3(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 4:
                        objectWriterAdapter = new ObjectWriter4(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 5:
                        objectWriterAdapter = new ObjectWriter5(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 6:
                        objectWriterAdapter = new ObjectWriter6(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 7:
                        objectWriterAdapter = new ObjectWriter7(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 8:
                        objectWriterAdapter = new ObjectWriter8(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 9:
                        objectWriterAdapter = new ObjectWriter9(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 10:
                        objectWriterAdapter = new ObjectWriter10(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 11:
                        objectWriterAdapter = new ObjectWriter11(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    case 12:
                        objectWriterAdapter = new ObjectWriter12(cls4, beanInfo.typeKey, beanInfo.typeName, j3, arrayList2);
                        break;
                    default:
                        break;
                }
            }
            if (objectWriterAdapter == null) {
                arrayList3 = arrayList2;
                str = beanInfo.rootName;
                if (str != null) {
                    objectWriterAdapter = new ObjectWriterRootName(cls, beanInfo.typeKey, beanInfo.typeName, str, j3, arrayList3);
                } else {
                    objectWriterAdapter = new ObjectWriterAdapter(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList3);
                }
            }
            if (beanInfo.serializeFilters != null) {
                configSerializeFilters(beanInfo, objectWriterAdapter);
            }
            return objectWriterAdapter;
        }
        arrayList2 = arrayList;
        objectWriterCreator2 = objectWriterCreator;
        cls4 = cls2;
        beanInfo = beanInfoCreateBeanInfo;
        j2 = 0;
        j3 = j | beanInfo.writerFeatures;
        if (z2) {
        }
        objectWriterCreator2.handleIgnores(beanInfo, arrayList2);
        if (beanInfo.alphabetic) {
            Collections.sort(arrayList2);
        }
        if (BeanUtils.isExtendedMap(cls4)) {
            arrayList2.add(ObjectWriters.fieldWriter(BeanUtils.SUPER, cls4.getGenericSuperclass(), cls4.getSuperclass(), Function.identity()));
        }
        objectWriterCreator2.setDefaultValue(arrayList2, cls4);
        name = cls4.getName();
        objectWriterAdapter = "com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList".equals(name) ? null : null;
        if (objectWriterAdapter == null) {
            arrayList3 = arrayList2;
            str = beanInfo.rootName;
            if (str != null) {
                objectWriterAdapter = new ObjectWriterRootName(cls, beanInfo.typeKey, beanInfo.typeName, str, j3, arrayList3);
            } else {
                objectWriterAdapter = new ObjectWriterAdapter(cls, beanInfo.typeKey, beanInfo.typeName, j3, arrayList3);
            }
        }
        if (beanInfo.serializeFilters != null) {
            configSerializeFilters(beanInfo, objectWriterAdapter);
        }
        return objectWriterAdapter;
    }

    public <T> FieldWriter<T> createFieldWriter(String str, String str2, Field field) {
        return createFieldWriter(JSONFactory.getDefaultObjectWriterProvider(), str, 0, 0L, str2, null, field, null);
    }

    public <T> FieldWriter<T> createFieldWriter(String str, int i, long j, String str2, Field field) {
        return createFieldWriter(JSONFactory.getDefaultObjectWriterProvider(), str, i, j, str2, null, field, null);
    }

    public <T> FieldWriter<T> createFieldWriter(String str, int i, long j, String str2, String str3, Field field, ObjectWriter objectWriter) {
        return createFieldWriter(JSONFactory.getDefaultObjectWriterProvider(), str, i, j, str2, str3, field, objectWriter);
    }

    public final <T> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, String str, int i, long j, String str2, String str3, Field field, ObjectWriter objectWriter) {
        return createFieldWriter(objectWriterProvider, str, i, j, str2, (Locale) null, str3, field, objectWriter);
    }

    public <T> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, String str, int i, long j, String str2, Locale locale, String str3, Field field, ObjectWriter objectWriter) {
        return createFieldWriter(objectWriterProvider, str, i, j, str2, locale, str3, field, objectWriter, (Class<?>) null);
    }

    public <T> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, String str, int i, long j, String str2, Locale locale, String str3, Field field, ObjectWriter objectWriter, Class<?> cls) {
        ObjectWriter objectWriter2;
        Method method = (field.getDeclaringClass() == Throwable.class && "stackTrace".equals(field.getName())) ? BeanUtils.getMethod(Throwable.class, "getStackTrace") : null;
        if (method != null) {
            return createFieldWriter(objectWriterProvider, Throwable.class, str, i, j, str2, str3, method, objectWriter);
        }
        Class<?> type = field.getType();
        Type genericType = field.getGenericType();
        if (objectWriter != null) {
            FieldWriterObject fieldWriterObject = new FieldWriterObject(str, i, j, str2, null, str3, genericType, type, field, null);
            fieldWriterObject.initValueClass = type;
            if (objectWriter != ObjectWriterBaseModule.VoidObjectWriter.INSTANCE) {
                fieldWriterObject.initObjectWriter = objectWriter;
            }
            return fieldWriterObject;
        }
        if (type == Boolean.TYPE) {
            return new FieldWriterBoolValField(str, i, j, str2, str3, field, type);
        }
        if (type == Byte.TYPE) {
            return new FieldWriterInt8ValField(str, i, j, str2, str3, field);
        }
        if (type == Short.TYPE) {
            return new FieldWriterInt16ValField(str, i, j, str2, str3, field);
        }
        if (type == Integer.TYPE) {
            return new FieldWriterInt32Val(str, i, j, str2, str3, field);
        }
        if (type == Long.TYPE) {
            if (str2 != null && !str2.isEmpty() && !"string".equals(str2)) {
                return new FieldWriterMillisField(str, i, j, str2, str3, field);
            }
            return new FieldWriterInt64ValField(str, i, j, str2, str3, field);
        }
        if (type == Float.TYPE) {
            return new FieldWriterFloatValField(str, i, j, str2, str3, field);
        }
        if (type == Float.class) {
            return new FieldWriterFloatField(str, i, j, str2, str3, field);
        }
        if (type == Double.TYPE) {
            return new FieldWriterDoubleValField(str, i, str2, str3, field);
        }
        if (type == Double.class) {
            return new FieldWriterDoubleField(str, i, j, str2, str3, field);
        }
        if (type == Character.TYPE) {
            return new FieldWriterCharValField(str, i, j, str2, str3, field);
        }
        if (type == BigInteger.class) {
            return new FieldWriterBigIntField(str, i, j, str2, str3, field);
        }
        if (type == BigDecimal.class) {
            return new FieldWriterBigDecimalField(str, i, j, str2, str3, field);
        }
        if (type == Date.class) {
            return new FieldWriterDateField(str, i, j, str2, str3, field);
        }
        if (type == String.class) {
            return new FieldWriterStringField(str, i, j, str2, str3, field);
        }
        if (type.isEnum()) {
            BeanInfo beanInfoCreateBeanInfo = objectWriterProvider.createBeanInfo();
            objectWriterProvider.getBeanInfo(beanInfoCreateBeanInfo, type);
            boolean z = beanInfoCreateBeanInfo.writeEnumAsJavaBean;
            if (!z && (objectWriter2 = objectWriterProvider.cache.get(type)) != null && !(objectWriter2 instanceof ObjectWriterImplEnum)) {
                z = true;
            }
            if (BeanUtils.getEnumValueField(type, objectWriterProvider) == null && !z && BeanUtils.getEnumAnnotationNames(type) == null) {
                return new FieldWriterEnum(str, i, j, str2, str3, genericType, type, field, null);
            }
        }
        if (type != List.class && type != ArrayList.class) {
            if (Map.class.isAssignableFrom(type)) {
                return new FieldWriterMapField(str, i, j, str2, locale, str3, field.getGenericType(), type, field, null, cls);
            }
            if (type.isArray() && !type.getComponentType().isPrimitive()) {
                Class<?> componentType = type.getComponentType();
                return new FieldWriterObjectArrayField(str, componentType, i, j, str2, str3, componentType, type, field);
            }
            return new FieldWriterObject(str, i, j, str2, locale, str3, field.getGenericType(), type, field, null);
        }
        return new FieldWriterListField(str, genericType instanceof ParameterizedType ? ((ParameterizedType) genericType).getActualTypeArguments()[0] : null, i, j, str2, str3, genericType, type, field, cls);
    }

    public <T> FieldWriter<T> createFieldWriter(Class<T> cls, String str, String str2, Method method) {
        return createFieldWriter(cls, str, 0, 0L, str2, method);
    }

    public <T> FieldWriter<T> createFieldWriter(Class<T> cls, String str, int i, long j, String str2, Method method) {
        return createFieldWriter((ObjectWriterProvider) null, cls, str, i, j, str2, (String) null, method, (ObjectWriter) null);
    }

    public <T> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, String str3, Method method, ObjectWriter objectWriter) {
        return createFieldWriter(objectWriterProvider, cls, str, i, j, str2, (Locale) null, str3, method, objectWriter);
    }

    public <T> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, Locale locale, String str3, Method method, ObjectWriter objectWriter) {
        return createFieldWriter(objectWriterProvider, cls, str, i, j, str2, locale, str3, method, objectWriter, (Class<?>) null);
    }

    public <T> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, Locale locale, String str3, Method method, ObjectWriter objectWriter, Class<?> cls2) {
        Type type;
        String str4;
        method.setAccessible(true);
        Class<?> returnType = method.getReturnType();
        Type genericReturnType = method.getGenericReturnType();
        ObjectWriter initWriter = (objectWriter != null || objectWriterProvider == null) ? objectWriter : getInitWriter(objectWriterProvider, returnType);
        if (initWriter != null) {
            FieldWriterObjectMethod fieldWriterObjectMethod = new FieldWriterObjectMethod(str, i, j, str2, locale, str3, genericReturnType, returnType, null, method);
            fieldWriterObjectMethod.initValueClass = returnType;
            if (initWriter != ObjectWriterBaseModule.VoidObjectWriter.INSTANCE) {
                fieldWriterObjectMethod.initObjectWriter = initWriter;
            }
            return fieldWriterObjectMethod;
        }
        String str5 = str == null ? BeanUtils.getterName(method, false, null) : str;
        Field field = (j & FieldInfo.RECORD) != 0 ? null : BeanUtils.getField(cls, method);
        if (returnType != Boolean.TYPE && returnType != Boolean.class) {
            if (returnType != Integer.TYPE && returnType != Integer.class) {
                if (returnType != Float.TYPE && returnType != Float.class) {
                    if (returnType != Double.TYPE && returnType != Double.class) {
                        if (returnType != Long.TYPE && returnType != Long.class) {
                            if (returnType != Short.TYPE && returnType != Short.class) {
                                if (returnType != Byte.TYPE && returnType != Byte.class) {
                                    if (returnType != Character.TYPE && returnType != Character.class) {
                                        if (returnType == BigDecimal.class) {
                                            return new FieldWriterBigDecimalMethod(str5, i, j, str2, str3, field, method);
                                        }
                                        String str6 = str5;
                                        if (returnType.isEnum() && BeanUtils.getEnumValueField(returnType, objectWriterProvider) == null && !BeanUtils.isWriteEnumAsJavaBean(returnType) && BeanUtils.getEnumAnnotationNames(returnType) == null) {
                                            return new FieldWriterEnumMethod(str6, i, j, str2, str3, returnType, field, method);
                                        }
                                        if (returnType == Date.class) {
                                            if (str2 != null) {
                                                String strTrim = str2.trim();
                                                str4 = strTrim.isEmpty() ? null : strTrim;
                                            } else {
                                                str4 = str2;
                                            }
                                            return new FieldWriterDateMethod(str6, i, j, str4, str3, returnType, field, method);
                                        }
                                        if (returnType == String.class) {
                                            return new FieldWriterStringMethod(str6, i, str2, str3, j, field, method);
                                        }
                                        if (returnType != List.class && returnType != Iterable.class) {
                                            if (Map.class.isAssignableFrom(returnType)) {
                                                return new FieldWriterMapMethod(str6, i, j, str2, locale, str3, genericReturnType, returnType, null, method, cls2);
                                            }
                                            if (returnType != Float[].class && returnType != Double[].class && returnType != BigDecimal[].class) {
                                                return new FieldWriterObjectMethod(str6, i, j, str2, locale, str3, genericReturnType, returnType, null, method);
                                            }
                                            return new FieldWriterObjectArrayMethod(str6, returnType.getComponentType(), i, j, str2, str3, genericReturnType, returnType, field, method);
                                        }
                                        if (genericReturnType instanceof ParameterizedType) {
                                            type = ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
                                        } else {
                                            type = Object.class;
                                        }
                                        return new FieldWriterListMethod(str6, type, i, j, str2, str3, null, method, genericReturnType, returnType, cls2);
                                    }
                                    return new FieldWriterCharMethod(str5, i, j, str2, str3, field, method, returnType);
                                }
                                return new FieldWriterInt8Method(str5, i, j, str2, str3, field, method, returnType);
                            }
                            return new FieldWriterInt16Method(str5, i, j, str2, str3, field, method, returnType);
                        }
                        String str7 = str5;
                        if (str2 != null && !str2.isEmpty() && !"string".equals(str2)) {
                            return new FieldWriterMillisMethod(str7, i, j, str2, str3, returnType, field, method);
                        }
                        return new FieldWriterInt64Method(str7, i, j, str2, str3, field, method, returnType);
                    }
                    return new FieldWriterDoubleMethod(str5, i, j, str2, str3, returnType, returnType, field, method);
                }
                return new FieldWriterFloatMethod(str5, i, j, str2, str3, returnType, returnType, field, method);
            }
            return new FieldWriterInt32Method(str5, i, j, str2, str3, field, method, returnType);
        }
        return new FieldWriterBoolMethod(str5, i, j, str2, str3, field, method, returnType);
    }

    public <T> FieldWriter createFieldWriter(String str, ToLongFunction<T> toLongFunction) {
        return new FieldWriterInt64ValFunc(str, 0, 0L, null, null, null, null, toLongFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, ToIntFunction<T> toIntFunction) {
        return new FieldWriterInt32ValFunc(str, 0, 0L, null, null, null, null, toIntFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, Field field, Method method, ToIntFunction<T> toIntFunction) {
        return new FieldWriterInt32ValFunc(str, 0, 0L, null, null, field, method, toIntFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, ToShortFunction<T> toShortFunction) {
        return new FieldWriterInt16ValFunc(str, 0, 0L, null, null, null, null, toShortFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, ToByteFunction<T> toByteFunction) {
        return new FieldWriterInt8ValFunc(str, 0, 0L, null, null, null, null, toByteFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, ToFloatFunction<T> toFloatFunction) {
        return new FieldWriterFloatValueFunc(str, 0, 0L, null, null, null, null, toFloatFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, ToDoubleFunction<T> toDoubleFunction) {
        return new FieldWriterDoubleValueFunc(str, 0, 0L, null, null, null, null, toDoubleFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, ToCharFunction<T> toCharFunction) {
        return new FieldWriterCharValFunc(str, 0, 0L, null, null, null, null, toCharFunction);
    }

    public <T> FieldWriter createFieldWriter(String str, Predicate<T> predicate) {
        return new FieldWriterBoolValFunc(str, 0, 0L, null, null, null, null, predicate);
    }

    public <T, V> FieldWriter createFieldWriter(String str, Class cls, Function<T, V> function) {
        return createFieldWriter((ObjectWriterProvider) null, (Class) null, str, 0, 0L, (String) null, (String) null, cls, cls, (Method) null, function);
    }

    public <T, V> FieldWriter createFieldWriter(String str, Class cls, Field field, Method method, Function<T, V> function) {
        return createFieldWriter(null, null, str, 0, 0L, null, null, cls, cls, field, method, function);
    }

    public <T, V> FieldWriter createFieldWriter(String str, Type type, Class cls, Function<T, V> function) {
        return createFieldWriter((ObjectWriterProvider) null, (Class) null, str, 0, 0L, (String) null, (String) null, type, cls, (Method) null, function);
    }

    public <T, V> FieldWriter createFieldWriter(String str, long j, String str2, Class cls, Function<T, V> function) {
        return createFieldWriter((ObjectWriterProvider) null, (Class) null, str, 0, j, str2, (String) null, cls, cls, (Method) null, function);
    }

    public <T, V> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, String str3, Type type, Class<V> cls2, Method method, Function<T, V> function) {
        return createFieldWriter(objectWriterProvider, cls, str, i, j, str2, null, str3, type, cls2, null, method, function);
    }

    public <T, V> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, String str3, Type type, Class<V> cls2, Field field, Method method, Function<T, V> function) {
        return createFieldWriter(objectWriterProvider, cls, str, i, j, str2, null, str3, type, cls2, field, method, function);
    }

    public <T, V> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, Locale locale, String str3, Type type, Class<V> cls2, Field field, Method method, Function<T, V> function) {
        return createFieldWriter(objectWriterProvider, cls, str, i, j, str2, locale, str3, type, cls2, field, method, function, null);
    }

    public <T, V> FieldWriter<T> createFieldWriter(ObjectWriterProvider objectWriterProvider, Class<T> cls, String str, int i, long j, String str2, Locale locale, String str3, Type type, Class<V> cls2, Field field, Method method, Function<T, V> function, Class<?> cls3) {
        ObjectWriter objectWriter;
        if (cls2 == Byte.class) {
            return new FieldWriterInt8Func(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == Short.class) {
            return new FieldWriterInt16Func(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == Integer.class) {
            return new FieldWriterInt32Func(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == Long.class) {
            return new FieldWriterInt64Func(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == BigInteger.class) {
            return new FieldWriterBigIntFunc(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == BigDecimal.class) {
            return new FieldWriterBigDecimalFunc(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == String.class) {
            return new FieldWriterStringFunc(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == Date.class) {
            return new FieldWriterDateFunc(str, i, j, str2, str3, field, method, function);
        }
        if (cls2 == LocalDate.class) {
            return new FieldWriterLocalDateFunc(str, i, j, str2, str3, type, cls2, field, method, function);
        }
        if (cls2 == OffsetDateTime.class) {
            return new FieldWriterOffsetDateTimeFunc(str, i, j, str2, str3, type, cls2, field, method, function);
        }
        if (cls2 == UUID.class) {
            return new FieldWriterUUIDFunc(str, i, j, str2, str3, type, cls2, field, method, function);
        }
        if (Calendar.class.isAssignableFrom(cls2)) {
            return new FieldWriterCalendarFunc(str, i, j, str2, str3, field, method, function);
        }
        if (cls2.isEnum()) {
            if (objectWriterProvider == null) {
                objectWriterProvider = JSONFactory.getDefaultObjectWriterProvider();
            }
            BeanInfo beanInfoCreateBeanInfo = objectWriterProvider.createBeanInfo();
            objectWriterProvider.getBeanInfo(beanInfoCreateBeanInfo, cls2);
            boolean z = beanInfoCreateBeanInfo.writeEnumAsJavaBean;
            if (!z && (objectWriter = objectWriterProvider.cache.get(cls2)) != null && !(objectWriter instanceof ObjectWriterImplEnum)) {
                z = true;
            }
            if (!z && BeanUtils.getEnumValueField(cls2, objectWriterProvider) == null && BeanUtils.getEnumAnnotationNames(cls2) == null) {
                return new FieldWriterEnumFunc(str, i, j, str2, str3, type, cls2, field, method, function);
            }
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if ((rawType == List.class || rawType == ArrayList.class) && actualTypeArguments.length == 1) {
                Type type2 = actualTypeArguments[0];
                if (type2 == String.class) {
                    return new FieldWriterListStrFunc(str, i, j, str2, str3, field, method, function, type, cls2);
                }
                return new FieldWriterListFunc(str, i, j, str2, str3, type2, field, method, function, type, cls2, cls3);
            }
            if ((rawType instanceof Class) && Map.class.isAssignableFrom((Class) rawType)) {
                return new FieldWriterMapFunction(str, i, j, str2, locale, str3, type, cls2, field, method, function, cls3);
            }
        }
        if (Modifier.isFinal(cls2.getModifiers())) {
            return new FieldWriterObjectFuncFinal(str, i, j, str2, str3, type, cls2, field, method, function);
        }
        return new FieldWriterObjectFunc(str, i, j, str2, locale, str3, type, cls2, field, method, function);
    }
}
