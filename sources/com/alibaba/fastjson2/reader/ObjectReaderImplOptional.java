package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ObjectReaderImplOptional extends ObjectReaderPrimitive {
    static final ObjectReaderImplOptional INSTANCE = new ObjectReaderImplOptional(null, null, null);
    final String format;
    final Class itemClass;
    ObjectReader itemObjectReader;
    final Type itemType;
    final Locale locale;

    /* JADX WARN: Found duplicated region for block: B:7:0x0017  */
    public ObjectReaderImplOptional(Type type, String str, Locale locale) {
        Type type2;
        super(Optional.class);
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            type2 = actualTypeArguments.length == 1 ? actualTypeArguments[0] : null;
        }
        this.itemType = type2;
        this.itemClass = TypeUtils.getClass(type2);
        this.format = str;
        this.locale = locale;
    }

    public static ObjectReaderImplOptional of(Type type, String str, Locale locale) {
        return type == null ? INSTANCE : new ObjectReaderImplOptional(type, str, locale);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        Object jSONBObject;
        Type type2 = this.itemType;
        if (type2 == null) {
            jSONBObject = jSONReader.readAny();
        } else {
            if (this.itemObjectReader == null) {
                String str = this.format;
                ObjectReader objectReaderCreateFormattedObjectReader = str != null ? FieldReader.createFormattedObjectReader(type2, this.itemClass, str, this.locale) : null;
                if (objectReaderCreateFormattedObjectReader == null) {
                    this.itemObjectReader = jSONReader.getObjectReader(this.itemType);
                } else {
                    this.itemObjectReader = objectReaderCreateFormattedObjectReader;
                }
            }
            jSONBObject = this.itemObjectReader.readJSONBObject(jSONReader, this.itemType, obj, 0L);
        }
        return jSONBObject == null ? Optional.empty() : Optional.of(jSONBObject);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        Object object;
        Type type2 = this.itemType;
        if (type2 == null) {
            object = jSONReader.readAny();
        } else {
            if (this.itemObjectReader == null) {
                String str = this.format;
                ObjectReader objectReaderCreateFormattedObjectReader = str != null ? FieldReader.createFormattedObjectReader(type2, this.itemClass, str, this.locale) : null;
                if (objectReaderCreateFormattedObjectReader == null) {
                    this.itemObjectReader = jSONReader.getObjectReader(this.itemType);
                } else {
                    this.itemObjectReader = objectReaderCreateFormattedObjectReader;
                }
            }
            object = this.itemObjectReader.readObject(jSONReader, this.itemType, obj, 0L);
        }
        return object == null ? Optional.empty() : Optional.of(object);
    }
}
