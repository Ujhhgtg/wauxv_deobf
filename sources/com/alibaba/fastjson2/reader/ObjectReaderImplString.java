package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class ObjectReaderImplString extends ObjectReaderPrimitive {
    static final ObjectReaderImplString INSTANCE = new ObjectReaderImplString();

    public ObjectReaderImplString() {
        super(String.class);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(Map map, long j) {
        if (map == null) {
            return null;
        }
        return JSON.toJSONString(map);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        return jSONReader.readString();
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        return jSONReader.readString();
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(Collection collection, long j) {
        if (collection == null) {
            return null;
        }
        return JSON.toJSONString(collection);
    }
}
