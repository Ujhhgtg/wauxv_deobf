package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.PropertyNamingStrategy;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class FieldReaderMapMethod<T> extends FieldReaderObject<T> {
    protected final BiConsumer arrayToMapDuplicateHandler;
    protected final String arrayToMapKey;
    protected final PropertyNamingStrategy namingStrategy;
    protected final Type valueType;

    public FieldReaderMapMethod(String str, Type type, Class cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Method method, Field field, BiConsumer biConsumer, String str3, BiConsumer biConsumer2) {
        super(str, type, cls, i, j, str2, locale, obj, jSONSchema, method, field, biConsumer);
        this.valueType = TypeUtils.getMapValueType(type);
        this.arrayToMapKey = str3;
        this.namingStrategy = PropertyNamingStrategy.of(str2);
        this.arrayToMapDuplicateHandler = biConsumer2;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void acceptAny(T t, Object obj, long j) {
        if (this.arrayToMapKey == null || !(obj instanceof Collection)) {
            super.acceptAny(t, obj, j);
            return;
        }
        Map map = (Map) getObjectReader(JSONFactory.createReadContext()).createInstance(j);
        FieldReaderObject.arrayToMap(map, (Collection) obj, this.arrayToMapKey, this.namingStrategy, JSONFactory.getObjectReader(this.valueType, j | this.features), this.arrayToMapDuplicateHandler);
        accept(t, map);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderObject, com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) {
        if (this.arrayToMapKey == null || !jSONReader.isArray()) {
            super.readFieldValue(jSONReader, t);
            return;
        }
        Map map = (Map) getObjectReader(jSONReader).createInstance(this.features);
        FieldReaderObject.arrayToMap(map, jSONReader.readArray(this.valueType), this.arrayToMapKey, this.namingStrategy, JSONFactory.getObjectReader(this.valueType, this.features), this.arrayToMapDuplicateHandler);
        accept(t, map);
    }
}
