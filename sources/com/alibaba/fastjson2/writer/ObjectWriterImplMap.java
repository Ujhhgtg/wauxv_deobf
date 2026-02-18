package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.AfterFilter;
import com.alibaba.fastjson2.filter.BeforeFilter;
import com.alibaba.fastjson2.filter.NameFilter;
import com.alibaba.fastjson2.filter.PropertyFilter;
import com.alibaba.fastjson2.filter.PropertyPreFilter;
import com.alibaba.fastjson2.filter.ValueFilter;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectWriterImplMap extends ObjectWriterPrimitiveImpl {
    static final ObjectWriterImplMap INSTANCE_1x;
    final boolean contentAs;
    final long features;
    final String format;
    final boolean jsonObject1;
    final Field jsonObject1InnerMap;
    final long jsonObject1InnerMapOffset;
    final byte[] jsonbTypeInfo;
    final Type keyType;
    volatile ObjectWriter keyWriter;
    final Class objectClass;
    final Type objectType;
    final char[] typeInfoUTF16;
    final byte[] typeInfoUTF8;
    final long typeNameHash;
    final Type valueType;
    final boolean valueTypeRefDetect;
    volatile ObjectWriter valueWriter;
    static final byte[] TYPE_NAME_JSONObject1O = JSONB.toBytes("JO10");
    static final long TYPE_HASH_JSONObject1O = Fnv.hashCode64("JO10");
    static final ObjectWriterImplMap INSTANCE = new ObjectWriterImplMap(String.class, Object.class, JSONObject.class, JSONObject.class, 0);

    static {
        Class cls = TypeUtils.CLASS_JSON_OBJECT_1x;
        if (cls == null) {
            INSTANCE_1x = null;
        } else {
            INSTANCE_1x = new ObjectWriterImplMap(String.class, Object.class, cls, cls, 0L);
        }
    }

    public ObjectWriterImplMap(Class cls, long j) {
        this(null, null, cls, cls, j);
    }

    public static boolean isWriteAsString(Object obj, long j) {
        return ((j & (JSONWriter.Feature.WriteNonStringKeyAsString.mask | JSONWriter.Feature.BrowserCompatible.mask)) == 0 || !ObjectWriterProvider.isPrimitiveOrEnum(obj.getClass()) || (obj instanceof Temporal) || (obj instanceof Date)) ? false : true;
    }

    public static ObjectWriterImplMap of(Class cls) {
        return cls == JSONObject.class ? INSTANCE : cls == TypeUtils.CLASS_JSON_OBJECT_1x ? INSTANCE_1x : new ObjectWriterImplMap(null, null, cls, cls, 0L);
    }

    public String mapKeyToString(Object obj, JSONWriter jSONWriter, long j) {
        int length;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Integer) || (obj instanceof Long)) {
            return obj.toString();
        }
        if (isWriteAsString(obj, j)) {
            return obj.toString();
        }
        String jSONString = JSON.toJSONString(obj, jSONWriter.getContext());
        if (jSONString == null || (length = jSONString.length()) <= 1) {
            return jSONString;
        }
        char c = jSONWriter.useSingleQuote ? '\'' : '\"';
        if (jSONString.charAt(0) != c) {
            return jSONString;
        }
        int i = length - 1;
        return jSONString.charAt(i) == c ? jSONString.substring(1, i) : jSONString;
    }

    /* JADX WARN: Found duplicated region for block: B:121:0x01f1  */
    /* JADX WARN: Found duplicated region for block: B:123:0x01fa  */
    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        ObjectWriterProvider objectWriterProvider;
        Object obj3;
        DecimalFormat decimalFormat;
        Object obj4;
        String strWriteMapKey;
        boolean zIsPrimitiveOrEnum;
        ObjectWriter objectWriter;
        if (jSONWriter.jsonb) {
            writeJSONB(jSONWriter, obj, obj2, type, j);
            return;
        }
        if (hasFilter(jSONWriter)) {
            writeWithFilter(jSONWriter, obj, obj2, type, j);
            return;
        }
        Map treeMap = (Map) obj;
        boolean zIsRefDetect = jSONWriter.isRefDetect();
        boolean z = (type == this.objectType && jSONWriter.isWriteMapTypeInfo(obj, this.objectClass, j)) || jSONWriter.isWriteTypeInfo(obj, type, j);
        if (!z && treeMap.isEmpty()) {
            jSONWriter.writeRaw('{', '}');
            return;
        }
        jSONWriter.startObject();
        if (z) {
            writeTypeInfo(jSONWriter);
        }
        long features = j | jSONWriter.getFeatures();
        long j2 = JSONWriter.Feature.MapSortField.mask;
        JSONWriter.Feature feature = JSONWriter.Feature.SortMapEntriesByKeys;
        if (((j2 | feature.mask) & features) != 0 && !(treeMap instanceof SortedMap) && (treeMap.getClass() != LinkedHashMap.class || (feature.mask & features) != 0)) {
            treeMap = new TreeMap(treeMap);
        }
        ObjectWriterProvider objectWriterProvider2 = jSONWriter.context.provider;
        for (Map.Entry entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (value != null) {
                if ((JSONWriter.Feature.NotWriteEmptyArray.mask & features) != 0) {
                    if (!(value instanceof Collection) || !((Collection) value).isEmpty()) {
                        if (!value.getClass().isArray() || Array.getLength(value) != 0) {
                        }
                    }
                }
                if (this.keyWriter != null) {
                    obj3 = value;
                    objectWriterProvider = objectWriterProvider2;
                    decimalFormat = null;
                    this.keyWriter.write(jSONWriter, key, null, null, 0L);
                    obj4 = key;
                    strWriteMapKey = null;
                } else {
                    objectWriterProvider = objectWriterProvider2;
                    obj3 = value;
                    decimalFormat = null;
                    obj4 = key;
                    strWriteMapKey = writeMapKey(obj4, jSONWriter, features);
                }
                jSONWriter.writeColon();
                Class<?> cls = this.contentAs ? (Class) this.valueType : obj3.getClass();
                if (cls == String.class) {
                    jSONWriter.writeString((String) obj3);
                } else if (cls == Integer.class) {
                    jSONWriter.writeInt32((Integer) obj3);
                } else if (cls != Long.class) {
                    Object obj5 = obj3;
                    if (cls == Boolean.class) {
                        jSONWriter.writeBool(((Boolean) obj5).booleanValue());
                    } else if (cls != BigDecimal.class) {
                        if (cls == this.valueType) {
                            if (this.valueWriter != null) {
                                objectWriter = this.valueWriter;
                            } else {
                                String str = this.format;
                                objectWriter = str != null ? jSONWriter.getObjectWriter(cls, str) : jSONWriter.getObjectWriter(cls);
                                this.valueWriter = objectWriter;
                            }
                            zIsPrimitiveOrEnum = ObjectWriterProvider.isPrimitiveOrEnum(obj5.getClass());
                        } else {
                            if (cls == JSONObject.class) {
                                objectWriter = INSTANCE;
                            } else if (cls == TypeUtils.CLASS_JSON_OBJECT_1x) {
                                objectWriter = INSTANCE_1x;
                            } else if (cls == JSONArray.class || cls == TypeUtils.CLASS_JSON_ARRAY_1x) {
                                objectWriter = ObjectWriterImplList.INSTANCE;
                            } else {
                                ObjectWriter objectWriter2 = jSONWriter.getObjectWriter(cls);
                                zIsPrimitiveOrEnum = ObjectWriterProvider.isPrimitiveOrEnum(cls);
                                objectWriter = objectWriter2;
                            }
                            zIsPrimitiveOrEnum = false;
                        }
                        boolean z2 = (!zIsRefDetect || strWriteMapKey == null || zIsPrimitiveOrEnum) ? false : true;
                        if (!z2) {
                            objectWriter.write(jSONWriter, obj5, obj4, this.valueType, this.features);
                            if (z2) {
                                jSONWriter.popPath(obj5);
                            }
                        } else if (obj5 == obj) {
                            jSONWriter.writeReference("..");
                        } else {
                            String path = jSONWriter.setPath(strWriteMapKey, obj5);
                            if (path != null) {
                                jSONWriter.writeReference(path);
                                jSONWriter.popPath(obj5);
                            } else {
                                objectWriter.write(jSONWriter, obj5, obj4, this.valueType, this.features);
                                if (z2) {
                                    jSONWriter.popPath(obj5);
                                }
                            }
                        }
                    } else if ((objectWriterProvider.userDefineMask & 8) == 0) {
                        jSONWriter.writeDecimal((BigDecimal) obj5, features, decimalFormat);
                    } else {
                        jSONWriter.getObjectWriter(cls).write(jSONWriter, obj5, obj4, this.valueType, this.features);
                    }
                } else if ((objectWriterProvider.userDefineMask & 4) == 0) {
                    jSONWriter.writeInt64((Long) obj3);
                } else {
                    jSONWriter.getObjectWriter(cls).write(jSONWriter, obj3, strWriteMapKey, Long.class, features);
                }
                objectWriterProvider2 = objectWriterProvider;
            } else if ((JSONWriter.Feature.WriteNulls.mask & features) != 0) {
                writeMapKey(key, jSONWriter, features);
                jSONWriter.writeColon();
                jSONWriter.writeNull();
            }
        }
        jSONWriter.endObject();
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriterPrimitiveImpl, com.alibaba.fastjson2.writer.ObjectWriter
    public void writeArrayMappingJSONB(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        JSONWriter jSONWriter2;
        jSONWriter.startObject();
        boolean zIsWriteNulls = jSONWriter.isWriteNulls();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                jSONWriter.writeString(str);
                Class<?> cls = value.getClass();
                if (cls == String.class) {
                    jSONWriter.writeString((String) value);
                    jSONWriter2 = jSONWriter;
                } else {
                    jSONWriter2 = jSONWriter;
                    jSONWriter.getObjectWriter(cls).writeJSONB(jSONWriter2, value, str, this.valueType, this.features);
                }
                jSONWriter = jSONWriter2;
            } else if (zIsWriteNulls) {
                jSONWriter.writeString(str);
                jSONWriter.writeNull();
            }
        }
        jSONWriter.endObject();
    }

    /* JADX WARN: Found duplicated region for block: B:129:0x024d  */
    /* JADX WARN: Found duplicated region for block: B:161:0x02b1  */
    /* JADX WARN: Found duplicated region for block: B:162:0x02b8  */
    /* JADX WARN: Found duplicated region for block: B:164:0x02bb  */
    /* JADX WARN: Found duplicated region for block: B:175:0x02be A[SYNTHETIC] */
    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void writeJSONB(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        boolean z;
        int i;
        Class<?> cls;
        boolean z2;
        Type type2;
        ObjectWriterProvider objectWriterProvider;
        int i2;
        boolean z3;
        boolean z4;
        ObjectWriter objectWriter;
        int i3;
        Type type3;
        boolean z5;
        String path;
        String path2;
        String path3;
        Object obj3;
        boolean z6;
        Object obj4;
        ObjectWriterProvider objectWriterProvider2;
        boolean z7;
        if ((type == this.objectType && jSONWriter.isWriteMapTypeInfo(obj, this.objectClass, j)) || jSONWriter.isWriteTypeInfo(obj, type, j)) {
            Field field = this.jsonObject1InnerMap;
            if (field != null) {
                long j2 = this.jsonObject1InnerMapOffset;
                if (j2 != -1) {
                    z7 = JDKUtils.UNSAFE.getObject(obj, j2) instanceof LinkedHashMap;
                } else {
                    try {
                        z7 = field.get(obj) instanceof LinkedHashMap;
                    } catch (IllegalAccessException unused) {
                        z7 = false;
                    }
                }
            } else {
                z7 = false;
            }
            if (z7) {
                jSONWriter.writeTypeName(TYPE_NAME_JSONObject1O, TYPE_HASH_JSONObject1O);
            } else {
                jSONWriter.writeTypeName(this.jsonbTypeInfo, this.typeNameHash);
            }
        }
        Map map = (Map) obj;
        JSONWriter.Context context = jSONWriter.context;
        jSONWriter.startObject();
        Type type4 = this.valueType;
        boolean z8 = true;
        if (type != this.objectType && (type instanceof ParameterizedType)) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 2) {
                type4 = actualTypeArguments[1];
            }
        }
        Type type5 = type4;
        long features = context.getFeatures();
        long j3 = 0;
        boolean z9 = ((JSONWriter.Feature.WriteNulls.mask | JSONWriter.Feature.NullAsDefaultValue.mask) & features) != 0;
        boolean z10 = (JSONWriter.Feature.FieldBased.mask & features) != 0;
        ObjectWriterProvider objectWriterProvider3 = context.provider;
        boolean z11 = (JSONWriter.Feature.ReferenceDetection.mask & features) != 0;
        Class<?> cls2 = null;
        ObjectWriter objectWriter2 = null;
        int i4 = 0;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            long j4 = j3;
            Object value = entry.getValue();
            if (value == null) {
                if (z9) {
                    if (key instanceof String) {
                        jSONWriter.writeString((String) key);
                        z6 = z10;
                        objectWriterProvider2 = objectWriterProvider3;
                        i = i4;
                        cls = cls2;
                    } else {
                        Class<?> cls3 = key.getClass();
                        boolean z12 = (!z11 || ObjectWriterProvider.isNotReferenceDetect(cls3)) ? false : z8;
                        if (z12) {
                            jSONWriter.setPath(i4, entry);
                            path3 = jSONWriter.setPath("key", key);
                        } else {
                            path3 = null;
                        }
                        if (path3 != null) {
                            jSONWriter.writeReference(path3);
                            z6 = z10;
                            objectWriterProvider2 = objectWriterProvider3;
                            i = i4;
                            cls = cls2;
                            obj4 = entry;
                            obj3 = key;
                        } else {
                            ObjectWriter objectWriter3 = objectWriterProvider3.getObjectWriter(cls3, cls3, z10);
                            ObjectWriterProvider objectWriterProvider4 = objectWriterProvider3;
                            obj3 = key;
                            z6 = z10;
                            cls = cls2;
                            obj4 = entry;
                            objectWriterProvider2 = objectWriterProvider4;
                            i = i4;
                            objectWriter3.writeJSONB(jSONWriter, obj3, null, null, 0L);
                        }
                        if (z12) {
                            jSONWriter.popPath(obj4);
                            jSONWriter.popPath(obj3);
                        }
                    }
                    jSONWriter.writeNull();
                    type2 = type5;
                    z = z6;
                    objectWriterProvider = objectWriterProvider2;
                    i2 = i;
                    z3 = false;
                } else {
                    cls = cls2;
                    z = z10;
                    i2 = i4;
                    type2 = type5;
                    z3 = false;
                    objectWriterProvider = objectWriterProvider3;
                }
                type3 = type2;
                i3 = i2;
                z5 = true;
            } else {
                z = z10;
                ObjectWriterProvider objectWriterProvider5 = objectWriterProvider3;
                i = i4;
                cls = cls2;
                boolean z13 = key instanceof String;
                if (z13 || (JSONWriter.Feature.WriteClassName.mask & features) == j4) {
                    z2 = z13;
                    type2 = type5;
                    objectWriterProvider = objectWriterProvider5;
                    String string = z2 ? (String) key : key.toString();
                    if (jSONWriter.symbolTable != null) {
                        jSONWriter.writeSymbol(string);
                        if (value instanceof String) {
                            jSONWriter.writeSymbol((String) value);
                        }
                        i2 = i;
                        z3 = false;
                        type3 = type2;
                        i3 = i2;
                        z5 = true;
                    } else {
                        jSONWriter.writeString(string);
                    }
                } else if (key == null) {
                    jSONWriter.writeNull();
                    z2 = z13;
                    type2 = type5;
                    objectWriterProvider = objectWriterProvider5;
                } else {
                    if (z11) {
                        jSONWriter.config(JSONWriter.Feature.ReferenceDetection, false);
                    }
                    Class<?> cls4 = key.getClass();
                    z2 = z13;
                    type2 = type5;
                    objectWriterProvider = objectWriterProvider5;
                    objectWriterProvider5.getObjectWriter(cls4, cls4, z).writeJSONB(jSONWriter, key, null, null, 0L);
                    if (z11) {
                        jSONWriter.config(JSONWriter.Feature.ReferenceDetection, true);
                    }
                }
                Class<?> cls5 = this.contentAs ? (Class) this.valueType : value.getClass();
                if (cls5 == String.class) {
                    jSONWriter.writeString((String) value);
                } else if (cls5 == Integer.class) {
                    jSONWriter.writeInt32((Integer) value);
                } else if (cls5 == Long.class) {
                    jSONWriter.writeInt64((Long) value);
                } else {
                    boolean z14 = cls5 != this.valueType ? !(!z11 || ObjectWriterProvider.isNotReferenceDetect(cls5)) : z11 && this.valueTypeRefDetect;
                    if (z14) {
                        if (value == obj) {
                            jSONWriter.writeReference("..");
                        } else {
                            if (z2) {
                                path2 = jSONWriter.setPath((String) key, value);
                            } else {
                                if (ObjectWriterProvider.isPrimitiveOrEnum(key.getClass())) {
                                    path2 = jSONWriter.setPath(key.toString(), value);
                                } else if (map.size() == 1 || (map instanceof SortedMap) || (map instanceof LinkedHashMap)) {
                                    z3 = false;
                                    i2 = i;
                                    path = jSONWriter.setPath(i2, value);
                                    z4 = false;
                                } else {
                                    z3 = false;
                                    jSONWriter.config(JSONWriter.Feature.ReferenceDetection, false);
                                    z14 = false;
                                    path = null;
                                    i2 = i;
                                    z4 = true;
                                }
                                if (path != null) {
                                    jSONWriter.writeReference(path);
                                    jSONWriter.popPath(value);
                                }
                            }
                            path = path2;
                            i2 = i;
                            z3 = false;
                            z4 = false;
                            if (path != null) {
                                jSONWriter.writeReference(path);
                                jSONWriter.popPath(value);
                            }
                        }
                        type3 = type2;
                        i3 = i2;
                        z5 = true;
                    } else {
                        i2 = i;
                        z3 = false;
                        z4 = false;
                    }
                    boolean z15 = z14;
                    if (cls5 != this.valueType || this.valueWriter == null) {
                        if (cls == cls5) {
                            i3 = i2;
                            objectWriter = objectWriter2;
                        } else {
                            objectWriter = cls5 == JSONObject.class ? INSTANCE : cls5 == TypeUtils.CLASS_JSON_OBJECT_1x ? INSTANCE_1x : (cls5 == JSONArray.class || cls5 == TypeUtils.CLASS_JSON_ARRAY_1x) ? ObjectWriterImplList.INSTANCE : objectWriterProvider.getObjectWriter(cls5, cls5, z);
                            if (objectWriter2 == null) {
                                objectWriter2 = objectWriter;
                                cls = cls5;
                            }
                            if (cls5 == this.valueType) {
                                this.valueWriter = objectWriter;
                            }
                        }
                        type3 = type2;
                        objectWriter.writeJSONB(jSONWriter, value, key, type3, this.features);
                        if (z4) {
                            z5 = true;
                            jSONWriter.config(JSONWriter.Feature.ReferenceDetection, true);
                        } else {
                            z5 = true;
                            if (z15) {
                                jSONWriter.popPath(value);
                            }
                        }
                    } else {
                        objectWriter = this.valueWriter;
                    }
                    i3 = i2;
                    type3 = type2;
                    objectWriter.writeJSONB(jSONWriter, value, key, type3, this.features);
                    if (z4) {
                        z5 = true;
                        jSONWriter.config(JSONWriter.Feature.ReferenceDetection, true);
                    } else {
                        z5 = true;
                        if (z15) {
                            jSONWriter.popPath(value);
                        }
                    }
                }
                i2 = i;
                z3 = false;
                type3 = type2;
                i3 = i2;
                z5 = true;
            }
            j3 = j4;
            objectWriterProvider3 = objectWriterProvider;
            type5 = type3;
            cls2 = cls;
            z8 = z5;
            i4 = i3 + 1;
            z10 = z;
        }
        jSONWriter.endObject();
    }

    public String writeMapKey(Object obj, JSONWriter jSONWriter, long j) {
        if (obj == null) {
            jSONWriter.writeName("null");
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            jSONWriter.writeName(str);
            return str;
        }
        if (isWriteAsString(obj, j)) {
            String string = obj.toString();
            jSONWriter.writeName(string);
            return string;
        }
        if (obj instanceof Integer) {
            jSONWriter.writeName(((Integer) obj).intValue());
            return null;
        }
        if (obj instanceof Long) {
            jSONWriter.writeName(((Long) obj).longValue());
            return null;
        }
        jSONWriter.writeNameAny(obj);
        return null;
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public boolean writeTypeInfo(JSONWriter jSONWriter) {
        if (jSONWriter.utf8) {
            jSONWriter.writeNameRaw(this.typeInfoUTF8);
            return true;
        }
        jSONWriter.writeNameRaw(this.typeInfoUTF16);
        return true;
    }

    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void writeWithFilter(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        long j2;
        PropertyFilter propertyFilter;
        AfterFilter afterFilter;
        String path;
        if (obj == null) {
            jSONWriter.writeNull();
            return;
        }
        jSONWriter.startObject();
        Map treeMap = (Map) obj;
        long features = j | jSONWriter.getFeatures();
        long j3 = JSONWriter.Feature.MapSortField.mask;
        JSONWriter.Feature feature = JSONWriter.Feature.SortMapEntriesByKeys;
        long j4 = 0;
        if (((j3 | feature.mask) & features) != 0 && !(treeMap instanceof SortedMap) && (treeMap.getClass() != LinkedHashMap.class || (feature.mask & features) != 0)) {
            treeMap = new TreeMap(treeMap);
        }
        JSONWriter.Context context = jSONWriter.context;
        BeforeFilter beforeFilter = context.getBeforeFilter();
        if (beforeFilter != null) {
            beforeFilter.writeBefore(jSONWriter, obj);
        }
        PropertyPreFilter propertyPreFilter = context.getPropertyPreFilter();
        NameFilter nameFilter = context.getNameFilter();
        ValueFilter valueFilter = context.getValueFilter();
        PropertyFilter propertyFilter2 = context.getPropertyFilter();
        AfterFilter afterFilter2 = context.getAfterFilter();
        boolean zIsEnabled = context.isEnabled(JSONWriter.Feature.WriteNulls.mask);
        boolean zIsEnabled2 = context.isEnabled(JSONWriter.Feature.ReferenceDetection.mask);
        for (Map.Entry entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            if (value != null || zIsEnabled) {
                String strMapKeyToString = mapKeyToString(entry.getKey(), jSONWriter, features);
                if (!zIsEnabled2 || (path = jSONWriter.setPath(strMapKeyToString, value)) == null) {
                    if (propertyPreFilter != null) {
                        try {
                            if (!propertyPreFilter.process(jSONWriter, obj, strMapKeyToString)) {
                                if (zIsEnabled2) {
                                    jSONWriter.popPath(value);
                                }
                            }
                        } catch (Throwable th) {
                            if (zIsEnabled2) {
                                jSONWriter.popPath(value);
                            }
                            throw th;
                        }
                    }
                    if (nameFilter != null) {
                        strMapKeyToString = nameFilter.process(obj, strMapKeyToString, value);
                    }
                    if (propertyFilter2 == null || propertyFilter2.apply(obj, strMapKeyToString, value)) {
                        if (valueFilter != null) {
                            value = valueFilter.apply(obj, strMapKeyToString, value);
                        }
                        if (value == null) {
                            j2 = j4;
                            if ((jSONWriter.getFeatures(features) & JSONWriter.Feature.WriteNulls.mask) == j2) {
                                if (zIsEnabled2) {
                                    jSONWriter.popPath(value);
                                }
                            }
                            j4 = j2;
                        } else {
                            j2 = j4;
                        }
                        jSONWriter.writeName(strMapKeyToString);
                        jSONWriter.writeColon();
                        if (value == null) {
                            jSONWriter.writeNull();
                            propertyFilter = propertyFilter2;
                            afterFilter = afterFilter2;
                        } else {
                            propertyFilter = propertyFilter2;
                            afterFilter = afterFilter2;
                            jSONWriter.getObjectWriter(this.contentAs ? (Class) this.valueType : value.getClass()).write(jSONWriter, value, obj2, type, this.features);
                        }
                        if (zIsEnabled2) {
                            jSONWriter.popPath(value);
                        }
                        propertyFilter2 = propertyFilter;
                        afterFilter2 = afterFilter;
                        j4 = j2;
                    } else if (zIsEnabled2) {
                        jSONWriter.popPath(value);
                    }
                } else {
                    jSONWriter.writeName(strMapKeyToString);
                    jSONWriter.writeColon();
                    jSONWriter.writeReference(path);
                    jSONWriter.popPath(value);
                }
            }
        }
        AfterFilter afterFilter3 = afterFilter2;
        if (afterFilter3 != null) {
            afterFilter3.writeAfter(jSONWriter, obj);
        }
        jSONWriter.endObject();
    }

    public ObjectWriterImplMap(Type type, Type type2, Class cls, Type type3, long j) {
        this(type, type2, null, cls, type3, j);
    }

    public ObjectWriterImplMap(Type type, Type type2, String str, Class cls, Type type3, long j) {
        long jObjectFieldOffset;
        this.keyType = type;
        this.valueType = type2;
        this.format = str;
        this.objectClass = cls;
        this.objectType = type3;
        this.features = j;
        if (type2 == null) {
            this.valueTypeRefDetect = true;
        } else {
            this.valueTypeRefDetect = !ObjectWriterProvider.isNotReferenceDetect(TypeUtils.getClass(type2));
        }
        this.contentAs = (Long.MIN_VALUE & j) != 0;
        String typeName = TypeUtils.getTypeName(cls);
        String str2 = "\"@type\":\"" + cls.getName() + "\"";
        this.typeInfoUTF16 = str2.toCharArray();
        this.typeInfoUTF8 = str2.getBytes(StandardCharsets.UTF_8);
        boolean zEquals = "JO1".equals(typeName);
        this.jsonObject1 = zEquals;
        this.jsonbTypeInfo = JSONB.toBytes(typeName);
        this.typeNameHash = Fnv.hashCode64(typeName);
        if (zEquals) {
            Field declaredField = BeanUtils.getDeclaredField(cls, "map");
            this.jsonObject1InnerMap = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
                jObjectFieldOffset = JDKUtils.UNSAFE.objectFieldOffset(declaredField);
            }
            this.jsonObject1InnerMapOffset = jObjectFieldOffset;
        }
        this.jsonObject1InnerMap = null;
        jObjectFieldOffset = -1;
        this.jsonObject1InnerMapOffset = jObjectFieldOffset;
    }

    public static ObjectWriterImplMap of(Type type) {
        return new ObjectWriterImplMap(TypeUtils.getClass(type), 0L);
    }

    public static ObjectWriterImplMap of(Type type, Class cls) {
        return of(type, null, cls);
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x001b  */
    public static ObjectWriterImplMap of(Type type, String str, Class cls) {
        Type type2;
        Type type3;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == 2) {
                Type type4 = actualTypeArguments[0];
                type3 = actualTypeArguments[1];
                type2 = type4;
            } else {
                type2 = null;
                type3 = null;
            }
        } else {
            type2 = null;
            type3 = null;
        }
        return new ObjectWriterImplMap(type2, type3, str, cls, type, 0L);
    }
}
