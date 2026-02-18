package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ObjectReaderImplCharacter extends ObjectReaderPrimitive {
    static final ObjectReaderImplCharacter INSTANCE = new ObjectReaderImplCharacter();

    public ObjectReaderImplCharacter() {
        super(Character.class);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        if (jSONReader.nextIfNull()) {
            return null;
        }
        return Character.valueOf(jSONReader.readCharValue());
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        String string = jSONReader.readString();
        if (string == null) {
            return null;
        }
        return Character.valueOf(string.charAt(0));
    }
}
