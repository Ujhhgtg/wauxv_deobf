package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.GuavaSupport;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.JSONObject1O;
import com.alibaba.fastjson2.util.ReferenceKey;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.function.Supplier;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.cpv;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectReaderImplMap implements ObjectReader {
    static final Class CLASS_EMPTY_MAP;
    static final Class CLASS_EMPTY_NAVIGABLE_MAP;
    static final Class CLASS_EMPTY_SORTED_MAP;
    static final Class CLASS_UNMODIFIABLE_MAP;
    static final Class CLASS_UNMODIFIABLE_NAVIGABLE_MAP;
    static final Class CLASS_UNMODIFIABLE_SORTED_MAP;
    public static final ObjectReaderImplMap INSTANCE;
    public static final ObjectReaderImplMap INSTANCE_OBJECT;
    static Function UNSAFE_OBJECT_CREATOR;
    final Function builder;
    final long features;
    final Type fieldType;
    volatile boolean instanceError;
    final Class instanceType;
    Object mapSingleton;
    final Class mapType;
    final long mapTypeHash;
    static final Function ENUM_MAP_BUILDER = new cpv(11);
    static final Class CLASS_SINGLETON_MAP = Collections.singletonMap(1, 1).getClass();

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class ObjectCreatorUF implements Function {
        final Field map;
        final long mapOffset;
        final Class objectClass;

        public ObjectCreatorUF(Class cls) {
            this.objectClass = cls;
            try {
                Field declaredField = cls.getDeclaredField("map");
                this.map = declaredField;
                this.mapOffset = JDKUtils.UNSAFE.objectFieldOffset(declaredField);
            } catch (NoSuchFieldException e) {
                throw new JSONException("field map not found", e);
            }
        }

        @Override // java.util.function.Function
        public Object apply(Object obj) {
            if (obj == null) {
                obj = new HashMap();
            }
            try {
                Unsafe unsafe = JDKUtils.UNSAFE;
                Object objAllocateInstance = unsafe.allocateInstance(this.objectClass);
                unsafe.putObject(objAllocateInstance, this.mapOffset, obj);
                return objAllocateInstance;
            } catch (InstantiationException e) {
                throw new JSONException("create " + this.objectClass.getName() + " error", e);
            }
        }
    }

    static {
        Map map = Collections.EMPTY_MAP;
        CLASS_EMPTY_MAP = map.getClass();
        CLASS_EMPTY_SORTED_MAP = Collections.emptySortedMap().getClass();
        CLASS_EMPTY_NAVIGABLE_MAP = Collections.emptyNavigableMap().getClass();
        CLASS_UNMODIFIABLE_MAP = Collections.unmodifiableMap(map).getClass();
        CLASS_UNMODIFIABLE_SORTED_MAP = Collections.unmodifiableSortedMap(Collections.emptySortedMap()).getClass();
        CLASS_UNMODIFIABLE_NAVIGABLE_MAP = Collections.unmodifiableNavigableMap(Collections.emptyNavigableMap())
                .getClass();
        INSTANCE = new ObjectReaderImplMap(null, HashMap.class, HashMap.class, 0L, null);
        INSTANCE_OBJECT = new ObjectReaderImplMap(null, JSONObject.class, JSONObject.class, 0L, null);
    }

    public ObjectReaderImplMap(Class cls, long j, Object obj) {
        this(cls, cls, cls, j, null);
        this.mapSingleton = obj;
    }

    public static Function createObjectSupplier(Class cls) {
        Function function = UNSAFE_OBJECT_CREATOR;
        if (function != null) {
            return function;
        }
        ObjectCreatorUF objectCreatorUF = new ObjectCreatorUF(cls);
        UNSAFE_OBJECT_CREATOR = objectCreatorUF;
        return objectCreatorUF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$of$1(Map map) {
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$0(Object obj) {
        return new EnumMap((Map) obj);
    }

    /* JADX WARN: Found duplicated region for block: B:104:0x0167 */
    /* JADX WARN: Found duplicated region for block: B:106:0x0172 */
    /* JADX WARN: Found duplicated region for block: B:108:0x0176 */
    /* JADX WARN: Found duplicated region for block: B:110:0x0181 */
    /* JADX WARN: Found duplicated region for block: B:112:0x0185 */
    /* JADX WARN: Found duplicated region for block: B:113:0x018d */
    /* JADX WARN: Found duplicated region for block: B:115:0x0191 */
    /* JADX WARN: Found duplicated region for block: B:116:0x0199 */
    /* JADX WARN: Found duplicated region for block: B:118:0x019d */
    /* JADX WARN: Found duplicated region for block: B:119:0x01a5 */
    /* JADX WARN: Found duplicated region for block: B:121:0x01a9 */
    /* JADX WARN: Found duplicated region for block: B:122:0x01ac */
    /* JADX WARN: Found duplicated region for block: B:123:0x01b0 */
    /*
     * JADX WARN: Found duplicated region for block: B:127:0x01c4 A[Catch:
     * IllegalAccessException -> 0x01c8, NoSuchFieldException -> 0x01ca, TryCatch #2
     * {IllegalAccessException -> 0x01c8, NoSuchFieldException -> 0x01ca, blocks:
     * (B:125:0x01b8, B:127:0x01c4, B:132:0x01cc), top: B:144:0x01b8 }]
     */
    /* JADX WARN: Found duplicated region for block: B:137:0x01e2 */
    /* JADX WARN: Found duplicated region for block: B:138:0x01e7 */
    /* JADX WARN: Found duplicated region for block: B:140:0x01ef */
    /* JADX WARN: Found duplicated region for block: B:141:0x01f4 */
    /*
     * JADX WARN: Found duplicated region for block: B:144:0x01b8
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:56:0x00b9 */
    /* JADX WARN: Found duplicated region for block: B:58:0x00c3 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:80:0x010f */
    /* JADX WARN: Found duplicated region for block: B:82:0x0117 */
    /* JADX WARN: Found duplicated region for block: B:84:0x011f */
    /* JADX WARN: Found duplicated region for block: B:86:0x0127 */
    /* JADX WARN: Found duplicated region for block: B:88:0x012f */
    /* JADX WARN: Found duplicated region for block: B:90:0x0135 */
    /* JADX WARN: Found duplicated region for block: B:96:0x0148 */
    public static ObjectReader of(Type type, Class cls, long j) {
        Type genericSuperclass;
        Class superclass;
        Class cls2;
        Function cpvVar;
        Function function;
        Type type2;
        Class cls3;
        String name;
        Function functionSingletonBiMapConverter;
        Type type3;
        Function function2;
        Class cls4;
        Function functionCreateObjectSupplier;
        Field field;
        Type genericSuperclass2;
        Function functionCreateObjectSupplier2;
        Type[] actualTypeArguments;
        Type type4;
        Type type5;
        Type[] actualTypeArguments2;
        Type type6;
        Type type7;
        if (cls.getSimpleName().isEmpty()) {
            superclass = cls.getSuperclass();
            genericSuperclass = type == null ? cls.getGenericSuperclass() : type;
        } else {
            genericSuperclass = type;
            superclass = cls;
        }
        if (cls == Map.class || cls == AbstractMap.class || cls == CLASS_SINGLETON_MAP) {
            cls2 = HashMap.class;
        } else {
            if (cls != CLASS_UNMODIFIABLE_MAP) {
                cls2 = TreeMap.class;
                if (cls != SortedMap.class && cls != CLASS_UNMODIFIABLE_SORTED_MAP
                        && cls != CLASS_UNMODIFIABLE_NAVIGABLE_MAP) {
                    if (cls == ConcurrentMap.class) {
                        superclass = ConcurrentHashMap.class;
                    } else if (cls == ConcurrentNavigableMap.class) {
                        superclass = ConcurrentSkipListMap.class;
                    } else {
                        String typeName = cls.getTypeName();
                        typeName.getClass();
                        if (typeName.equals("java.util.Collections$SynchronizedSortedMap")) {
                            cpvVar = new cpv(6);
                        } else {
                            if (typeName.equals("com.google.common.collect.SingletonImmutableBiMap")) {
                                cpvVar = GuavaSupport.singletonBiMapConverter();
                            } else if (typeName.equals("java.util.Collections$SynchronizedMap")) {
                                cpvVar = new cpv(4);
                            } else if (typeName.equals("java.util.Collections$SynchronizedNavigableMap")) {
                                cpvVar = new cpv(5);
                            } else if (typeName.equals("com.google.common.collect.ImmutableMap")
                                    || typeName.equals("com.google.common.collect.RegularImmutableMap")) {
                                cpvVar = GuavaSupport.immutableMapConverter();
                            }
                            cls2 = HashMap.class;
                        }
                    }
                    cls2 = superclass;
                }
                if (genericSuperclass instanceof ParameterizedType) {
                    actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    if (actualTypeArguments2.length == 2) {
                        type6 = actualTypeArguments2[0];
                        type7 = actualTypeArguments2[1];
                        "org.springframework.util.LinkedMultiValueMap".equals(cls2.getName());
                        if (type6 != String.class && type7 == String.class && cpvVar == null) {
                            return new ObjectReaderImplMapString(cls, cls2, j);
                        }
                        return new ObjectReaderImplMapTyped(cls, cls2, type6, type7, 0L, cpvVar);
                    }
                }
                function = cpvVar;
                type2 = genericSuperclass;
                cls3 = cls2;
                if (type2 == null && j == 0) {
                    if (cls != HashMap.class && cls3 == HashMap.class) {
                        return INSTANCE;
                    }
                    if (cls == JSONObject.class && cls3 == JSONObject.class) {
                        return INSTANCE_OBJECT;
                    }
                }
                name = cls3.getName();
                if (!name.equals("com.google.common.collect.SingletonImmutableBiMap")) {
                    if (!name.equals("com.alibaba.fastjson.JSONObject")) {
                        functionCreateObjectSupplier = createObjectSupplier(cls3);
                    } else {
                        if (!name.equals("java.util.Collections$EmptyMap")) {
                            return new ObjectReaderImplMap(cls3, j, Collections.EMPTY_MAP);
                        }
                        if (!name.equals("com.google.common.collect.ArrayListMultimap")) {
                            if (!name.equals("me.hd.wauxv.obf.ave")) {
                                try {
                                    field = cls3.getField("INSTANCE");
                                    if (!field.isAccessible()) {
                                        field.setAccessible(true);
                                    }
                                    return new ObjectReaderImplMap(cls3, j, field.get(null));
                                } catch (IllegalAccessException e) {
                                    e = e;
                                    throw new IllegalStateException(concatVar2Var1(cls3, "Failed to get singleton of "),
                                            e);
                                } catch (NoSuchFieldException e2) {
                                    e = e2;
                                    throw new IllegalStateException(concatVar2Var1(cls3, "Failed to get singleton of "),
                                            e);
                                }
                            }
                            if (name.equals("com.google.common.collect.RegularImmutableMap")) {
                                functionSingletonBiMapConverter = GuavaSupport.immutableMapConverter();
                            } else {
                                genericSuperclass2 = cls3.getGenericSuperclass();
                                if (cls != JSONObject.class && (genericSuperclass2 instanceof ParameterizedType)) {
                                    actualTypeArguments = ((ParameterizedType) genericSuperclass2)
                                            .getActualTypeArguments();
                                    if (actualTypeArguments.length == 2) {
                                        type4 = actualTypeArguments[0];
                                        type5 = actualTypeArguments[1];
                                        if (!(type4 instanceof TypeVariable) && !(type5 instanceof TypeVariable)) {
                                            return new ObjectReaderImplMapTyped(cls, cls3, type4, type5, 0L, function);
                                        }
                                    }
                                }
                                if (cls3 == JSONObject1O.class) {
                                    functionCreateObjectSupplier2 = createObjectSupplier(
                                            TypeUtils.CLASS_JSON_OBJECT_1x);
                                } else if (cls == CLASS_UNMODIFIABLE_MAP) {
                                    functionCreateObjectSupplier = new cpv(7);
                                } else if (cls == CLASS_UNMODIFIABLE_SORTED_MAP) {
                                    functionCreateObjectSupplier = new cpv(8);
                                } else if (cls == CLASS_UNMODIFIABLE_NAVIGABLE_MAP) {
                                    functionCreateObjectSupplier = new cpv(9);
                                } else if (cls == CLASS_SINGLETON_MAP) {
                                    functionCreateObjectSupplier = new cpv(10);
                                } else if (cls == EnumMap.class) {
                                    functionCreateObjectSupplier2 = ENUM_MAP_BUILDER;
                                } else {
                                    type3 = type2;
                                    cls4 = cls3;
                                    function2 = function;
                                }
                                type3 = type2;
                                function2 = functionCreateObjectSupplier2;
                                cls4 = LinkedHashMap.class;
                            }
                            return new ObjectReaderImplMap(type3, cls, cls4, j, function2);
                        }
                        functionSingletonBiMapConverter = GuavaSupport.createConvertFunction(cls3);
                    }
                    type3 = type2;
                    function2 = functionCreateObjectSupplier;
                    cls4 = cls3;
                    return new ObjectReaderImplMap(type3, cls, cls4, j, function2);
                }
                functionSingletonBiMapConverter = GuavaSupport.singletonBiMapConverter();
                type3 = type2;
                function2 = functionSingletonBiMapConverter;
                cls4 = HashMap.class;
                return new ObjectReaderImplMap(type3, cls, cls4, j, function2);
            }
            cls2 = LinkedHashMap.class;
        }
        cpvVar = null;
        if (genericSuperclass instanceof ParameterizedType) {
            actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments2.length == 2) {
                type6 = actualTypeArguments2[0];
                type7 = actualTypeArguments2[1];
                "org.springframework.util.LinkedMultiValueMap".equals(cls2.getName());
                if (type6 != String.class) {
                }
                return new ObjectReaderImplMapTyped(cls, cls2, type6, type7, 0L, cpvVar);
            }
        }
        function = cpvVar;
        type2 = genericSuperclass;
        cls3 = cls2;
        if (type2 == null) {
            if (cls != HashMap.class) {
            }
            if (cls == JSONObject.class) {
                return INSTANCE_OBJECT;
            }
        }
        name = cls3.getName();
        if (!name.equals("com.google.common.collect.SingletonImmutableBiMap")) {
            if (!name.equals("com.alibaba.fastjson.JSONObject")) {
                functionCreateObjectSupplier = createObjectSupplier(cls3);
            } else {
                if (!name.equals("java.util.Collections$EmptyMap")) {
                    return new ObjectReaderImplMap(cls3, j, Collections.EMPTY_MAP);
                }
                if (!name.equals("com.google.common.collect.ArrayListMultimap")) {
                    if (!name.equals("me.hd.wauxv.obf.ave")) {
                        field = cls3.getField("INSTANCE");
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        return new ObjectReaderImplMap(cls3, j, field.get(null));
                    }
                    if (name.equals("com.google.common.collect.RegularImmutableMap")) {
                        genericSuperclass2 = cls3.getGenericSuperclass();
                        if (cls != JSONObject.class) {
                            actualTypeArguments = ((ParameterizedType) genericSuperclass2).getActualTypeArguments();
                            if (actualTypeArguments.length == 2) {
                                type4 = actualTypeArguments[0];
                                type5 = actualTypeArguments[1];
                                if (!(type4 instanceof TypeVariable)) {
                                    return new ObjectReaderImplMapTyped(cls, cls3, type4, type5, 0L, function);
                                }
                            }
                        }
                        if (cls3 == JSONObject1O.class) {
                            functionCreateObjectSupplier2 = createObjectSupplier(TypeUtils.CLASS_JSON_OBJECT_1x);
                        } else if (cls == CLASS_UNMODIFIABLE_MAP) {
                            functionCreateObjectSupplier = new cpv(7);
                        } else if (cls == CLASS_UNMODIFIABLE_SORTED_MAP) {
                            functionCreateObjectSupplier = new cpv(8);
                        } else if (cls == CLASS_UNMODIFIABLE_NAVIGABLE_MAP) {
                            functionCreateObjectSupplier = new cpv(9);
                        } else if (cls == CLASS_SINGLETON_MAP) {
                            functionCreateObjectSupplier = new cpv(10);
                        } else if (cls == EnumMap.class) {
                            functionCreateObjectSupplier2 = ENUM_MAP_BUILDER;
                        } else {
                            type3 = type2;
                            cls4 = cls3;
                            function2 = function;
                        }
                        type3 = type2;
                        function2 = functionCreateObjectSupplier2;
                        cls4 = LinkedHashMap.class;
                    } else {
                        functionSingletonBiMapConverter = GuavaSupport.immutableMapConverter();
                    }
                    return new ObjectReaderImplMap(type3, cls, cls4, j, function2);
                }
                functionSingletonBiMapConverter = GuavaSupport.createConvertFunction(cls3);
            }
            type3 = type2;
            function2 = functionCreateObjectSupplier;
            cls4 = cls3;
            return new ObjectReaderImplMap(type3, cls, cls4, j, function2);
        }
        functionSingletonBiMapConverter = GuavaSupport.singletonBiMapConverter();
        type3 = type2;
        function2 = functionSingletonBiMapConverter;
        cls4 = HashMap.class;
        return new ObjectReaderImplMap(type3, cls, cls4, j, function2);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(long j) {
        Class cls = this.instanceType;
        if (cls == HashMap.class) {
            return new HashMap();
        }
        if (cls == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (cls == JSONObject.class) {
            return new JSONObject();
        }
        Object obj = this.mapSingleton;
        if (obj != null) {
            return obj;
        }
        if (cls == CLASS_EMPTY_SORTED_MAP) {
            return Collections.emptySortedMap();
        }
        if (cls == CLASS_EMPTY_NAVIGABLE_MAP) {
            return Collections.emptyNavigableMap();
        }
        String name = cls.getName();
        if (name.equals("java.util.ImmutableCollections$Map1")) {
            return new HashMap();
        }
        if (name.equals("java.util.ImmutableCollections$MapN")) {
            return new LinkedHashMap();
        }
        if (name.equals("com.ali.com.google.common.collect.EmptyImmutableBiMap")) {
            try {
                return JDKUtils.UNSAFE.allocateInstance(this.instanceType);
            } catch (InstantiationException unused) {
                throw new JSONException("create map error : " + this.instanceType);
            }
        }
        try {
            return this.instanceType.newInstance();
        } catch (IllegalAccessException | InstantiationException unused2) {
            throw new JSONException("create map error : " + this.instanceType);
        }
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Function getBuildFunction() {
        return this.builder;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Class getObjectClass() {
        return this.mapType;
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x01d3 */
    /*
     * JADX WARN: Found duplicated region for block: B:108:0x00ed A[EDGE_INSN:
     * B:108:0x00ed->B:46:0x00ed BREAK A[LOOP:0: B:44:0x00e5->B:102:0x01d6],
     * SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:48:0x00f4 */
    /* JADX WARN: Found duplicated region for block: B:50:0x00f9 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:51:0x00fa */
    /* JADX WARN: Found duplicated region for block: B:53:0x0100 */
    /* JADX WARN: Found duplicated region for block: B:55:0x0106 */
    /* JADX WARN: Found duplicated region for block: B:57:0x010c */
    /* JADX WARN: Found duplicated region for block: B:58:0x011e */
    /* JADX WARN: Found duplicated region for block: B:61:0x012b */
    /* JADX WARN: Found duplicated region for block: B:63:0x0135 */
    /* JADX WARN: Found duplicated region for block: B:65:0x013b */
    /* JADX WARN: Found duplicated region for block: B:66:0x0146 */
    /* JADX WARN: Found duplicated region for block: B:68:0x014c */
    /* JADX WARN: Found duplicated region for block: B:71:0x0158 */
    /* JADX WARN: Found duplicated region for block: B:73:0x015c */
    /* JADX WARN: Found duplicated region for block: B:75:0x016a A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:77:0x0178 */
    /* JADX WARN: Found duplicated region for block: B:78:0x0180 */
    /* JADX WARN: Found duplicated region for block: B:80:0x0186 */
    /* JADX WARN: Found duplicated region for block: B:81:0x018c */
    /* JADX WARN: Found duplicated region for block: B:83:0x0190 */
    /* JADX WARN: Found duplicated region for block: B:84:0x0196 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:85:0x0198 */
    /* JADX WARN: Found duplicated region for block: B:87:0x01a2 */
    /* JADX WARN: Found duplicated region for block: B:88:0x01a4 */
    /* JADX WARN: Found duplicated region for block: B:89:0x01ad A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:90:0x01af */
    /* JADX WARN: Found duplicated region for block: B:91:0x01b4 */
    /* JADX WARN: Found duplicated region for block: B:93:0x01b8 */
    /* JADX WARN: Found duplicated region for block: B:96:0x01c1 */
    /* JADX WARN: Found duplicated region for block: B:98:0x01c7 */
    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        JSONException jSONException;
        Map map;
        Map map2;
        Map jSONObject;
        int i;
        byte type2;
        Object any;
        Object obj2;
        byte type3;
        JSONReader jSONReader2;
        Object obj3;
        Object object;
        String reference;
        ObjectReader objectReaderCheckAutoType;
        Object any2;
        String reference2;
        ObjectReader objectReaderCheckAutoType2 = jSONReader.checkAutoType(this.mapType, this.mapTypeHash,
                this.features | j);
        if (objectReaderCheckAutoType2 != null && objectReaderCheckAutoType2 != this) {
            return objectReaderCheckAutoType2.readJSONBObject(jSONReader, type, obj, j);
        }
        JSONReader jSONReader3 = jSONReader;
        long j2 = j;
        if (jSONReader3.nextIfNull()) {
            return null;
        }
        jSONReader3.nextIfMatch(JSONB.Constants.BC_OBJECT);
        Supplier<Map> objectSupplier = jSONReader3.getContext().getObjectSupplier();
        long jFeatures = j2 | jSONReader3.features(j2);
        if (this.mapType != null || objectSupplier == null) {
            Class cls = this.instanceType;
            if (cls == HashMap.class) {
                jSONObject = new HashMap();
            } else if (cls == LinkedHashMap.class) {
                jSONObject = new LinkedHashMap();
            } else {
                if (cls != JSONObject.class) {
                    if (cls == CLASS_EMPTY_MAP) {
                        jSONObject = Collections.EMPTY_MAP;
                    } else {
                        if (this.instanceError) {
                            jSONException = null;
                            map = null;
                        } else {
                            try {
                                map = (Map) this.instanceType.newInstance();
                                jSONException = null;
                            } catch (IllegalAccessException | InstantiationException unused) {
                                this.instanceError = true;
                                jSONException = new JSONException(
                                        jSONReader3.info("create map error " + this.instanceType));
                                map = null;
                            }
                        }
                        if (this.instanceError && Map.class.isAssignableFrom(this.instanceType.getSuperclass())) {
                            try {
                                map = (Map) this.instanceType.getSuperclass().newInstance();
                                jSONException = null;
                            } catch (IllegalAccessException | InstantiationException unused2) {
                                if (jSONException == null) {
                                    jSONException = new JSONException(
                                            jSONReader3.info("create map error " + this.instanceType));
                                }
                            }
                        }
                        if (jSONException != null) {
                            throw jSONException;
                        }
                        map2 = map;
                    }
                    i = 0;
                    while (true) {
                        type2 = jSONReader3.getType();
                        if (type2 == -91) {
                            break;
                        }
                        if (type2 >= 73) {
                            any = jSONReader3.readFieldName();
                        } else {
                            if (jSONReader3.nextIfMatch(JSONB.Constants.BC_REFERENCE)) {
                                String string = jSONReader3.readString();
                                ReferenceKey referenceKey = new ReferenceKey(i);
                                jSONReader3.addResolveTask(map2, referenceKey, JSONPath.of(string));
                                obj2 = referenceKey;
                            } else {
                                any = jSONReader3.readAny();
                            }
                            if (jSONReader3.isReference()) {
                                reference2 = jSONReader3.readReference();
                                if ("..".equals(reference2)) {
                                    map2.put(obj2, map2);
                                } else {
                                    jSONReader3.addResolveTask(map2, obj2, JSONPath.of(reference2));
                                    map2.put(obj2, null);
                                }
                                jSONReader2 = jSONReader3;
                            } else {
                                type3 = jSONReader3.getType();
                                if (type3 < 73 && type3 <= 125) {
                                    object = jSONReader3.readString();
                                    jSONReader2 = jSONReader3;
                                    obj3 = obj2;
                                } else if (type3 == -110) {
                                    objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L,
                                            this.features | j2);
                                    if (objectReaderCheckAutoType != null) {
                                        Object obj4 = obj2;
                                        any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj4, j2);
                                        obj3 = obj4;
                                        jSONReader2 = jSONReader;
                                    } else {
                                        jSONReader2 = jSONReader;
                                        obj3 = obj2;
                                        any2 = jSONReader2.readAny();
                                    }
                                    object = any2;
                                } else {
                                    jSONReader2 = jSONReader3;
                                    obj3 = obj2;
                                    if (type3 == -79) {
                                        object = Boolean.TRUE;
                                        jSONReader2.next();
                                    } else if (type3 == -80) {
                                        object = Boolean.FALSE;
                                        jSONReader2.next();
                                    } else if (type3 == -109) {
                                        reference = jSONReader2.readReference();
                                        if ("..".equals(reference)) {
                                            object = map2;
                                        } else {
                                            jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                                            object = null;
                                        }
                                    } else {
                                        object = type3 == -90 ? jSONReader2.readObject()
                                                : (type3 >= -108 || type3 > -92) ? jSONReader2.readAny()
                                                        : jSONReader2.readArray();
                                    }
                                }
                                if (object == null
                                        || (JSONReader.Feature.IgnoreNullPropertyValue.mask & jFeatures) == 0) {
                                    map2.put(obj3, object);
                                }
                            }
                            i++;
                            j2 = j;
                            jSONReader3 = jSONReader2;
                        }
                        obj2 = any;
                        if (jSONReader3.isReference()) {
                            reference2 = jSONReader3.readReference();
                            if ("..".equals(reference2)) {
                                map2.put(obj2, map2);
                            } else {
                                jSONReader3.addResolveTask(map2, obj2, JSONPath.of(reference2));
                                map2.put(obj2, null);
                            }
                            jSONReader2 = jSONReader3;
                        } else {
                            type3 = jSONReader3.getType();
                            if (type3 < 73) {
                                if (type3 == -110) {
                                    objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L,
                                            this.features | j2);
                                    if (objectReaderCheckAutoType != null) {
                                        Object obj42 = obj2;
                                        any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj42, j2);
                                        obj3 = obj42;
                                        jSONReader2 = jSONReader;
                                    } else {
                                        jSONReader2 = jSONReader;
                                        obj3 = obj2;
                                        any2 = jSONReader2.readAny();
                                    }
                                    object = any2;
                                } else {
                                    jSONReader2 = jSONReader3;
                                    obj3 = obj2;
                                    if (type3 == -79) {
                                        object = Boolean.TRUE;
                                        jSONReader2.next();
                                    } else if (type3 == -80) {
                                        object = Boolean.FALSE;
                                        jSONReader2.next();
                                    } else if (type3 == -109) {
                                        reference = jSONReader2.readReference();
                                        if ("..".equals(reference)) {
                                            object = map2;
                                        } else {
                                            jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                                            object = null;
                                        }
                                    } else if (type3 == -90) {
                                    }
                                }
                            } else if (type3 == -110) {
                                objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L,
                                        this.features | j2);
                                if (objectReaderCheckAutoType != null) {
                                    Object obj422 = obj2;
                                    any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj422, j2);
                                    obj3 = obj422;
                                    jSONReader2 = jSONReader;
                                } else {
                                    jSONReader2 = jSONReader;
                                    obj3 = obj2;
                                    any2 = jSONReader2.readAny();
                                }
                                object = any2;
                            } else {
                                jSONReader2 = jSONReader3;
                                obj3 = obj2;
                                if (type3 == -79) {
                                    object = Boolean.TRUE;
                                    jSONReader2.next();
                                } else if (type3 == -80) {
                                    object = Boolean.FALSE;
                                    jSONReader2.next();
                                } else if (type3 == -109) {
                                    reference = jSONReader2.readReference();
                                    if ("..".equals(reference)) {
                                        object = map2;
                                    } else {
                                        jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                                        object = null;
                                    }
                                } else if (type3 == -90) {
                                }
                            }
                            if (object == null) {
                                map2.put(obj3, object);
                            } else {
                                map2.put(obj3, object);
                            }
                        }
                        i++;
                        j2 = j;
                        jSONReader3 = jSONReader2;
                    }
                    jSONReader3.next();
                    Function function = this.builder;
                    return function != null ? function.apply(map2) : map2;
                }
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = objectSupplier.get();
        }
        map2 = jSONObject;
        i = 0;
        while (true) {
            type2 = jSONReader3.getType();
            if (type2 == -91) {
                break;
                break;
            }
            if (type2 >= 73) {
                any = jSONReader3.readFieldName();
            } else {
                if (jSONReader3.nextIfMatch(JSONB.Constants.BC_REFERENCE)) {
                    String string2 = jSONReader3.readString();
                    ReferenceKey referenceKey2 = new ReferenceKey(i);
                    jSONReader3.addResolveTask(map2, referenceKey2, JSONPath.of(string2));
                    obj2 = referenceKey2;
                } else {
                    any = jSONReader3.readAny();
                }
                if (jSONReader3.isReference()) {
                    reference2 = jSONReader3.readReference();
                    if ("..".equals(reference2)) {
                        map2.put(obj2, map2);
                    } else {
                        jSONReader3.addResolveTask(map2, obj2, JSONPath.of(reference2));
                        map2.put(obj2, null);
                    }
                    jSONReader2 = jSONReader3;
                } else {
                    type3 = jSONReader3.getType();
                    if (type3 < 73) {
                        if (type3 == -110) {
                            objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L, this.features | j2);
                            if (objectReaderCheckAutoType != null) {
                                Object obj4222 = obj2;
                                any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj4222, j2);
                                obj3 = obj4222;
                                jSONReader2 = jSONReader;
                            } else {
                                jSONReader2 = jSONReader;
                                obj3 = obj2;
                                any2 = jSONReader2.readAny();
                            }
                            object = any2;
                        } else {
                            jSONReader2 = jSONReader3;
                            obj3 = obj2;
                            if (type3 == -79) {
                                object = Boolean.TRUE;
                                jSONReader2.next();
                            } else if (type3 == -80) {
                                object = Boolean.FALSE;
                                jSONReader2.next();
                            } else if (type3 == -109) {
                                reference = jSONReader2.readReference();
                                if ("..".equals(reference)) {
                                    object = map2;
                                } else {
                                    jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                                    object = null;
                                }
                            } else if (type3 == -90) {
                            }
                        }
                    } else if (type3 == -110) {
                        objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L, this.features | j2);
                        if (objectReaderCheckAutoType != null) {
                            Object obj42222 = obj2;
                            any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj42222, j2);
                            obj3 = obj42222;
                            jSONReader2 = jSONReader;
                        } else {
                            jSONReader2 = jSONReader;
                            obj3 = obj2;
                            any2 = jSONReader2.readAny();
                        }
                        object = any2;
                    } else {
                        jSONReader2 = jSONReader3;
                        obj3 = obj2;
                        if (type3 == -79) {
                            object = Boolean.TRUE;
                            jSONReader2.next();
                        } else if (type3 == -80) {
                            object = Boolean.FALSE;
                            jSONReader2.next();
                        } else if (type3 == -109) {
                            reference = jSONReader2.readReference();
                            if ("..".equals(reference)) {
                                object = map2;
                            } else {
                                jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                                object = null;
                            }
                        } else if (type3 == -90) {
                        }
                    }
                    if (object == null) {
                        map2.put(obj3, object);
                    } else {
                        map2.put(obj3, object);
                    }
                }
                i++;
                j2 = j;
                jSONReader3 = jSONReader2;
            }
            obj2 = any;
            if (jSONReader3.isReference()) {
                reference2 = jSONReader3.readReference();
                if ("..".equals(reference2)) {
                    map2.put(obj2, map2);
                } else {
                    jSONReader3.addResolveTask(map2, obj2, JSONPath.of(reference2));
                    map2.put(obj2, null);
                }
                jSONReader2 = jSONReader3;
            } else {
                type3 = jSONReader3.getType();
                if (type3 < 73) {
                    if (type3 == -110) {
                        objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L, this.features | j2);
                        if (objectReaderCheckAutoType != null) {
                            Object obj422222 = obj2;
                            any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj422222, j2);
                            obj3 = obj422222;
                            jSONReader2 = jSONReader;
                        } else {
                            jSONReader2 = jSONReader;
                            obj3 = obj2;
                            any2 = jSONReader2.readAny();
                        }
                        object = any2;
                    } else {
                        jSONReader2 = jSONReader3;
                        obj3 = obj2;
                        if (type3 == -79) {
                            object = Boolean.TRUE;
                            jSONReader2.next();
                        } else if (type3 == -80) {
                            object = Boolean.FALSE;
                            jSONReader2.next();
                        } else if (type3 == -109) {
                            reference = jSONReader2.readReference();
                            if ("..".equals(reference)) {
                                object = map2;
                            } else {
                                jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                                object = null;
                            }
                        } else if (type3 == -90) {
                        }
                    }
                } else if (type3 == -110) {
                    objectReaderCheckAutoType = jSONReader3.checkAutoType(Object.class, 0L, this.features | j2);
                    if (objectReaderCheckAutoType != null) {
                        Object obj4222222 = obj2;
                        any2 = objectReaderCheckAutoType.readJSONBObject(jSONReader, null, obj4222222, j2);
                        obj3 = obj4222222;
                        jSONReader2 = jSONReader;
                    } else {
                        jSONReader2 = jSONReader;
                        obj3 = obj2;
                        any2 = jSONReader2.readAny();
                    }
                    object = any2;
                } else {
                    jSONReader2 = jSONReader3;
                    obj3 = obj2;
                    if (type3 == -79) {
                        object = Boolean.TRUE;
                        jSONReader2.next();
                    } else if (type3 == -80) {
                        object = Boolean.FALSE;
                        jSONReader2.next();
                    } else if (type3 == -109) {
                        reference = jSONReader2.readReference();
                        if ("..".equals(reference)) {
                            object = map2;
                        } else {
                            jSONReader2.addResolveTask(map2, obj3, JSONPath.of(reference));
                            object = null;
                        }
                    } else if (type3 == -90) {
                    }
                }
                if (object == null) {
                    map2.put(obj3, object);
                } else {
                    map2.put(obj3, object);
                }
            }
            i++;
            j2 = j;
            jSONReader3 = jSONReader2;
        }
        jSONReader3.next();
        Function function2 = this.builder;
        if (function2 != null) {
        }
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        Class cls;
        if (jSONReader.jsonb) {
            return readJSONBObject(jSONReader, type, obj, j);
        }
        if (jSONReader.nextIfNull()) {
            return null;
        }
        JSONReader.Context context = jSONReader.getContext();
        Supplier<Map> objectSupplier = jSONReader.getContext().getObjectSupplier();
        Map map = (objectSupplier == null || !((cls = this.mapType) == null || cls == JSONObject.class
                || "com.alibaba.fastjson.JSONObject".equals(cls.getName())))
                        ? (Map) createInstance(context.getFeatures() | j)
                        : objectSupplier.get();
        if (!jSONReader.isString() || jSONReader.isTypeRedirect()) {
            jSONReader.read(map, j);
        } else {
            String string = jSONReader.readString();
            if (!string.isEmpty()) {
                JSONReader jSONReaderOf = JSONReader.of(string, jSONReader.getContext());
                try {
                    jSONReaderOf.read(map, j);
                    jSONReaderOf.close();
                } catch (Throwable th) {
                    if (jSONReaderOf == null) {
                        throw th;
                    }
                    try {
                        jSONReaderOf.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
        }
        jSONReader.nextIfComma();
        Function function = this.builder;
        return function != null ? function.apply(map) : map;
    }

    public ObjectReaderImplMap(Type type, Class cls, Class cls2, long j, Function function) {
        this.fieldType = type;
        this.mapType = cls;
        this.mapTypeHash = Fnv.hashCode64(TypeUtils.getTypeName(cls));
        this.instanceType = cls2;
        this.features = j;
        this.builder = function;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(Map map, long j) {
        if (this.mapType.isInstance(map)) {
            return map;
        }
        if (this.mapType == JSONObject.class) {
            return new JSONObject(map);
        }
        Map map2 = (Map) createInstance(j);
        map2.putAll(map);
        Function function = this.builder;
        return function != null ? function.apply(map2) : map2;
    }
}
