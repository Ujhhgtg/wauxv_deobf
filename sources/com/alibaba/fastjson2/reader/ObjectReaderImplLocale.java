package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONReader;
import java.lang.reflect.Type;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ObjectReaderImplLocale extends ObjectReaderPrimitive {
    static final ObjectReaderImplLocale INSTANCE = new ObjectReaderImplLocale();

    public ObjectReaderImplLocale() {
        super(Locale.class);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderPrimitive, com.alibaba.fastjson2.reader.ObjectReader
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        String string = jSONReader.readString();
        if (string == null || string.isEmpty()) {
            return null;
        }
        String[] strArrSplit = string.split(JavaConstant.Dynamic.DEFAULT_NAME);
        return strArrSplit.length == 1 ? new Locale(strArrSplit[0]) : strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        String string = jSONReader.readString();
        if (string == null || string.isEmpty()) {
            return null;
        }
        String[] strArrSplit = string.split(JavaConstant.Dynamic.DEFAULT_NAME);
        return strArrSplit.length == 1 ? new Locale(strArrSplit[0]) : strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }
}
