package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONSchemaValidException;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.PropertyNamingStrategy;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class FieldReaderObject<T> extends FieldReader<T> {
    protected final BiConsumer function;
    protected ObjectReader initReader;

    public FieldReaderObject(String str, Type type, Class cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Method method, Field field, BiConsumer biConsumer) {
        super(str, type, cls, i, j, str2, locale, obj, jSONSchema, method, field);
        this.function = biConsumer;
    }

    public static void arrayToMap(final Map map, Collection collection, final String str, final PropertyNamingStrategy propertyNamingStrategy, final ObjectReader objectReader, final BiConsumer biConsumer) {
        collection.forEach(new Consumer() { // from class: me.hd.wauxv.obf.azj
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FieldReaderObject.lambda$arrayToMap$0(str, propertyNamingStrategy, objectReader, map, biConsumer, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$arrayToMap$0(String str, PropertyNamingStrategy propertyNamingStrategy, ObjectReader objectReader, Map map, BiConsumer biConsumer, Object obj) {
        Object fieldValue;
        boolean z = obj instanceof Map;
        if (z) {
            fieldValue = ((Map) obj).get(str);
        } else {
            if (obj == null) {
                throw new JSONException(yg.concat("key not found ", str));
            }
            fieldValue = JSONFactory.getObjectWriter(obj.getClass(), 0L).getFieldValue(obj, str);
        }
        if (propertyNamingStrategy != null && (fieldValue instanceof String)) {
            fieldValue = propertyNamingStrategy.fieldName((String) fieldValue);
        }
        if (!objectReader.getObjectClass().isInstance(obj)) {
            if (!z) {
                throw new JSONException("can not accept " + JSON.toJSONString(obj, JSONWriter.Feature.ReferenceDetection));
            }
            obj = objectReader.createInstance((Map) obj, new JSONReader.Feature[0]);
        }
        Object objPutIfAbsent = map.putIfAbsent(fieldValue, obj);
        if ((objPutIfAbsent != null) && (biConsumer != 0)) {
            biConsumer.accept(objPutIfAbsent, obj);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, boolean z) {
        accept(t, Boolean.valueOf(z));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public BiConsumer getFunction() {
        return this.function;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public ObjectReader getInitReader() {
        return this.initReader;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public ObjectReader getObjectReader(JSONReader jSONReader) {
        ObjectReader objectReader = this.initReader;
        if (objectReader != null) {
            return objectReader;
        }
        if (this.reader != null) {
            return this.reader;
        }
        ObjectReader objectReaderCreateFormattedObjectReader = FieldReader.createFormattedObjectReader(this.fieldType, this.fieldClass, this.format, this.locale);
        if (objectReaderCreateFormattedObjectReader != null) {
            this.reader = objectReaderCreateFormattedObjectReader;
            return objectReaderCreateFormattedObjectReader;
        }
        Class cls = this.fieldClass;
        if (cls != null && Map.class.isAssignableFrom(cls)) {
            ObjectReader objectReaderOf = ObjectReaderImplMap.of(this.fieldType, this.fieldClass, this.features);
            this.reader = objectReaderOf;
            return objectReaderOf;
        }
        Class cls2 = this.fieldClass;
        if (cls2 == null || !Collection.class.isAssignableFrom(cls2)) {
            ObjectReader objectReader2 = jSONReader.getObjectReader(this.fieldType);
            this.reader = objectReader2;
            return objectReader2;
        }
        ObjectReader objectReaderOf2 = ObjectReaderImplList.of(this.fieldType, this.fieldClass, this.features);
        this.reader = objectReaderOf2;
        return objectReaderOf2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void processExtra(JSONReader jSONReader, Object obj) {
        if (this.initReader == null) {
            this.initReader = getObjectReader(jSONReader);
        }
        if ((this.initReader instanceof ObjectReaderBean) && this.field != null) {
            FieldReader fieldReader = this.initReader.getFieldReader(jSONReader.getFieldName());
            if (fieldReader != 0) {
                try {
                    Object objCreateInstance = this.field.get(obj);
                    if (objCreateInstance == null) {
                        objCreateInstance = this.initReader.createInstance(this.features);
                        accept(obj, objCreateInstance);
                    }
                    fieldReader.readFieldValue(jSONReader, objCreateInstance);
                    return;
                } catch (Exception e) {
                    throw new JSONException("read unwrapped field error", e);
                }
            }
        }
        jSONReader.skipValue();
    }

    /* JADX WARN: Found duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Found duplicated region for block: B:73:0x0109  */
    /* JADX WARN: Found duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Found duplicated region for block: B:76:0x0130  */
    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        Member member;
        String strO;
        char cCurrent;
        Object object;
        if (!this.fieldClassSerializable) {
            long features = jSONReader.getContext().getFeatures();
            if ((JSONReader.Feature.IgnoreNoneSerializable.mask & features) != 0) {
                jSONReader.skipValue();
                return;
            } else if ((features & JSONReader.Feature.ErrorOnNoneSerializable.mask) != 0) {
                throw new JSONException("not support none-Serializable");
            }
        }
        ObjectReader objectReaderCreateFormattedObjectReader = this.initReader;
        if (objectReaderCreateFormattedObjectReader == null) {
            objectReaderCreateFormattedObjectReader = FieldReader.createFormattedObjectReader(this.fieldType, this.fieldClass, this.format, this.locale);
            if (objectReaderCreateFormattedObjectReader != null) {
                this.initReader = objectReaderCreateFormattedObjectReader;
            } else {
                objectReaderCreateFormattedObjectReader = jSONReader.getContext().getObjectReader(this.fieldType);
                this.initReader = objectReaderCreateFormattedObjectReader;
            }
        }
        ObjectReader objectReader = objectReaderCreateFormattedObjectReader;
        if (jSONReader.isReference()) {
            String reference = jSONReader.readReference();
            if ("..".equals(reference)) {
                accept(t, t);
                return;
            } else {
                addResolveTask(jSONReader, t, reference);
                return;
            }
        }
        Object obj = null;
        try {
            cCurrent = jSONReader.current();
            obj = object;
        } catch (JSONSchemaValidException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            if ((this.features & JSONReader.Feature.NullOnError.mask) == 0) {
                member = this.field;
                if (member == null) {
                    member = this.method;
                }
                if (member != null) {
                    strO = "read field '" + member.getDeclaringClass().getName() + "." + member.getName();
                } else {
                    strO = yg.concatToVar1(new StringBuilder("read field "), this.fieldName, " error");
                }
                throw new JSONException(jSONReader.info(strO), e);
            }
        } catch (IllegalAccessError e3) {
            e = e3;
            if ((this.features & JSONReader.Feature.NullOnError.mask) == 0) {
                member = this.field;
                if (member == null) {
                    member = this.method;
                }
                if (member != null) {
                    strO = "read field '" + member.getDeclaringClass().getName() + "." + member.getName();
                } else {
                    strO = yg.concatToVar1(new StringBuilder("read field "), this.fieldName, " error");
                }
                throw new JSONException(jSONReader.info(strO), e);
            }
        }
        if (jSONReader.nextIfNullOrEmptyString()) {
            Object obj2 = this.defaultValue;
            if (obj2 != null) {
                obj = obj2;
            } else {
                Class cls = this.fieldClass;
                if (cls == OptionalInt.class) {
                    object = OptionalInt.empty();
                } else if (cls == OptionalLong.class) {
                    object = OptionalLong.empty();
                } else if (cls == OptionalDouble.class) {
                    object = OptionalDouble.empty();
                } else if (cls == Optional.class) {
                    object = Optional.empty();
                } else if (cCurrent != 'n') {
                    obj = "";
                }
            }
            accept(t, obj);
            if (this.noneStaticMemberClass || obj == null) {
            }
            BeanUtils.setNoneStaticMemberClassParent(obj, t);
            return;
        }
        if (!jSONReader.jsonb) {
            object = objectReader.readObject(jSONReader, this.fieldType, this.fieldName, this.features);
        } else if (this.fieldClass == Object.class) {
            ObjectReader objectReaderCheckAutoType = jSONReader.checkAutoType(Object.class, 0L, this.features);
            object = objectReaderCheckAutoType != null ? objectReaderCheckAutoType.readJSONBObject(jSONReader, this.fieldType, this.fieldName, this.features) : jSONReader.readAny();
        } else {
            object = objectReader.readJSONBObject(jSONReader, this.fieldType, this.fieldName, this.features);
        }
        accept(t, obj);
        if (this.noneStaticMemberClass) {
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValueJSONB(JSONReader jSONReader, T t) {
        if (!this.fieldClassSerializable && jSONReader.getType() != -110) {
            long features = jSONReader.getContext().getFeatures();
            if ((JSONReader.Feature.IgnoreNoneSerializable.mask & features) != 0) {
                jSONReader.skipValue();
                return;
            } else if ((features & JSONReader.Feature.ErrorOnNoneSerializable.mask) != 0 && (this.fieldClass != Object.class || jSONReader.isObject() || jSONReader.getType() == -110)) {
                throw new JSONException("not support none-Serializable");
            }
        }
        if (this.initReader == null) {
            this.initReader = jSONReader.getContext().getObjectReader(this.fieldType);
        }
        if (jSONReader.isReference()) {
            String reference = jSONReader.readReference();
            if ("..".equals(reference)) {
                accept(t, t);
                return;
            } else {
                addResolveTask(jSONReader, t, reference);
                return;
            }
        }
        Object jSONBObject = this.initReader.readJSONBObject(jSONReader, this.fieldType, this.fieldName, this.features);
        if (jSONBObject == null && (jSONReader.features(this.features) & JSONReader.Feature.ErrorOnNullForPrimitives.mask) != 0 && this.fieldClass.isPrimitive()) {
            throw new JSONException(jSONReader.info("primitive value not support input null"));
        }
        accept(t, jSONBObject);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, byte b) {
        accept(t, Byte.valueOf(b));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, short s) {
        accept(t, Short.valueOf(s));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, int i) {
        accept(t, Integer.valueOf(i));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        accept(t, Long.valueOf(j));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, float f) {
        accept(t, Float.valueOf(f));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, double d) {
        accept(t, Double.valueOf(d));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, char c) {
        accept(t, Character.valueOf(c));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, Object obj) {
        JSONSchema jSONSchema = this.schema;
        if (jSONSchema != null) {
            jSONSchema.assertValidate(obj);
        }
        if (obj != null || (this.features & JSONReader.Feature.IgnoreSetNullValue.mask) == 0) {
            if (this.fieldClass == Character.TYPE && (obj instanceof String)) {
                String str = (String) obj;
                if (str.length() > 0) {
                    obj = Character.valueOf(str.charAt(0));
                } else {
                    obj = (char) 0;
                }
            }
            if (obj != null && !this.fieldClass.isInstance(obj)) {
                obj = TypeUtils.cast(obj, this.fieldType);
            }
            try {
                BiConsumer biConsumer = this.function;
                if (biConsumer != null) {
                    biConsumer.accept(t, obj);
                    return;
                }
                Method method = this.method;
                if (method != null) {
                    method.invoke(t, obj);
                } else {
                    JDKUtils.UNSAFE.putObject(t, this.fieldOffset, obj);
                }
            } catch (Exception e) {
                throw new JSONException(yg.concatToVar1(new StringBuilder("set "), this.function != null ? super.toString() : this.fieldName, " error"), e);
            }
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public ObjectReader getObjectReader(JSONReader.Context context) {
        if (this.reader != null) {
            return this.reader;
        }
        ObjectReader objectReaderCreateFormattedObjectReader = FieldReader.createFormattedObjectReader(this.fieldType, this.fieldClass, this.format, this.locale);
        if (objectReaderCreateFormattedObjectReader != null) {
            this.reader = objectReaderCreateFormattedObjectReader;
            return objectReaderCreateFormattedObjectReader;
        }
        if (Map.class.isAssignableFrom(this.fieldClass)) {
            ObjectReader objectReaderOf = ObjectReaderImplMap.of(this.fieldType, this.fieldClass, this.features);
            this.reader = objectReaderOf;
            return objectReaderOf;
        }
        if (Collection.class.isAssignableFrom(this.fieldClass)) {
            ObjectReader objectReaderOf2 = ObjectReaderImplList.of(this.fieldType, this.fieldClass, this.features);
            this.reader = objectReaderOf2;
            return objectReaderOf2;
        }
        ObjectReader objectReader = context.getObjectReader(this.fieldType);
        this.reader = objectReader;
        return objectReader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson2.reader.FieldReader
    public Object readFieldValue(JSONReader jSONReader) {
        Object object;
        if (this.initReader == null) {
            this.initReader = getObjectReader(jSONReader);
        }
        if (jSONReader.jsonb) {
            object = this.initReader.readJSONBObject(jSONReader, this.fieldType, this.fieldName, this.features);
        } else {
            object = this.initReader.readObject(jSONReader, this.fieldType, this.fieldName, this.features);
        }
        Function buildFunction = this.initReader.getBuildFunction();
        return buildFunction != 0 ? buildFunction.apply(object) : object;
    }
}
