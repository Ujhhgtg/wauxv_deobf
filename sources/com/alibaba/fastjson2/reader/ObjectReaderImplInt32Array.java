package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.Fnv;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectReaderImplInt32Array extends ObjectReaderPrimitive {
    static final ObjectReaderImplInt32Array INSTANCE = new ObjectReaderImplInt32Array();
    public static final long HASH_TYPE = Fnv.hashCode64("[Integer");

    public ObjectReaderImplInt32Array() {
        super(Integer[].class);
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
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        if (jSONReader.nextIfMatch(JSONB.Constants.BC_TYPED_ANY)) {
            long typeHashCode = jSONReader.readTypeHashCode();
            if (typeHashCode != HASH_TYPE && typeHashCode != ObjectReaderImplInt32ValueArray.HASH_TYPE) {
                throw new JSONException(jSONReader.info("not support type " + jSONReader.getString()));
            }
        }
        int iStartArray = jSONReader.startArray();
        if (iStartArray == -1) {
            return null;
        }
        Integer[] numArr = new Integer[iStartArray];
        for (int i = 0; i < iStartArray; i++) {
            numArr[i] = jSONReader.readInt32();
        }
        return numArr;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        if (jSONReader.readIfNull()) {
            return null;
        }
        if (!jSONReader.nextIfArrayStart()) {
            if (!jSONReader.isString()) {
                if (jSONReader.isNumber()) {
                    return new Integer[]{jSONReader.readInt32()};
                }
                throw new JSONException(jSONReader.info("TODO"));
            }
            String string = jSONReader.readString();
            if (string.isEmpty()) {
                return null;
            }
            throw new JSONException(jSONReader.info("not support input ".concat(string)));
        }
        Integer[] numArr = new Integer[16];
        int i = 0;
        while (!jSONReader.nextIfArrayEnd()) {
            if (jSONReader.isEnd()) {
                throw new JSONException(jSONReader.info("input end"));
            }
            int i2 = i + 1;
            if (i2 - numArr.length > 0) {
                int length = numArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 < 0) {
                    i3 = i2;
                }
                numArr = (Integer[]) Arrays.copyOf(numArr, i3);
            }
            numArr[i] = jSONReader.readInt32();
            i = i2;
        }
        jSONReader.nextIfComma();
        return Arrays.copyOf(numArr, i);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(Collection collection, long j) {
        Integer numValueOf;
        Integer[] numArr = new Integer[collection.size()];
        int i = 0;
        for (Object obj : collection) {
            if (obj == null) {
                numValueOf = null;
            } else if (obj instanceof Number) {
                numValueOf = Integer.valueOf(((Number) obj).intValue());
            } else {
                Function typeConvert = JSONFactory.getDefaultObjectReaderProvider().getTypeConvert(obj.getClass(), Integer.class);
                if (typeConvert == null) {
                    throw new JSONException(bjs.m(obj, new StringBuilder("can not cast to Integer ")));
                }
                numValueOf = (Integer) typeConvert.apply(obj);
            }
            numArr[i] = numValueOf;
            i++;
        }
        return numArr;
    }
}
