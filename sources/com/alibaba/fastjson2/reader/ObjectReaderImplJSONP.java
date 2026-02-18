package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPObject;
import com.alibaba.fastjson2.JSONReader;
import java.lang.reflect.Type;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ObjectReaderImplJSONP implements ObjectReader {
    private final Class objectClass;

    public ObjectReaderImplJSONP(Class cls) {
        this.objectClass = cls;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        JSONPObject jSONPObject;
        String fieldNameUnquote = jSONReader.readFieldNameUnquote();
        if (jSONReader.nextIfMatch(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)) {
            fieldNameUnquote = fieldNameUnquote + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + jSONReader.readFieldNameUnquote();
        }
        char cCurrent = jSONReader.current();
        if (cCurrent == '/' && jSONReader.nextIfMatchIdent('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, '/')) {
            cCurrent = jSONReader.current();
        }
        if (cCurrent != '(') {
            throw new JSONException(jSONReader.info("illegal jsonp input"));
        }
        jSONReader.next();
        Class cls = this.objectClass;
        if (cls == JSONObject.class) {
            jSONPObject = new JSONPObject(fieldNameUnquote);
        } else {
            try {
                jSONPObject = (JSONPObject) cls.newInstance();
                jSONPObject.setFunction(fieldNameUnquote);
            } catch (IllegalAccessException | InstantiationException e) {
                throw new JSONException("create jsonp instance error", e);
            }
        }
        while (!jSONReader.isEnd()) {
            if (jSONReader.nextIfMatch(')')) {
                jSONReader.nextIfMatch(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                jSONReader.nextIfMatchIdent('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, '/');
                return jSONPObject;
            }
            jSONPObject.addParameter(jSONReader.readAny());
        }
        throw new JSONException(jSONReader.info("illegal jsonp input"));
    }
}
