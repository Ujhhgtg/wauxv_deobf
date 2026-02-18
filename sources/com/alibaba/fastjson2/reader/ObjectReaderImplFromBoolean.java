package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import java.lang.reflect.Type;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectReaderImplFromBoolean<T> extends ObjectReaderPrimitive<T> {
    final Function<Boolean, T> creator;

    public ObjectReaderImplFromBoolean(Class<T> cls, Function<Boolean, T> function) {
        super(cls);
        this.creator = function;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public /* bridge */ /* synthetic */ Object createInstance(long j) {
        return super.createInstance(j);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public /* bridge */ /* synthetic */ Class getObjectClass() {
        return super.getObjectClass();
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public T readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        if (jSONReader.nextIfNull()) {
            return null;
        }
        return this.creator.apply(Boolean.valueOf(jSONReader.readBoolValue()));
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public T readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        if (jSONReader.nextIfNull()) {
            return null;
        }
        return this.creator.apply(Boolean.valueOf(jSONReader.readBoolValue()));
    }
}
