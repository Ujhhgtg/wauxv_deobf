package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.Fnv;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectReaderImplInt64ValueArray extends ObjectReaderPrimitive {
    final Function<long[], Object> builder;
    static final ObjectReaderImplInt64ValueArray INSTANCE = new ObjectReaderImplInt64ValueArray(long[].class, null);
    public static final long HASH_TYPE = Fnv.hashCode64("[J");

    public ObjectReaderImplInt64ValueArray(Class cls, Function<long[], Object> function) {
        super(cls);
        this.builder = function;
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
        Function<long[], Object> function;
        long[] int64ValueArray = jSONReader.readInt64ValueArray();
        return (int64ValueArray == null || (function = this.builder) == null) ? int64ValueArray : function.apply(int64ValueArray);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        Function<long[], Object> function;
        long[] int64ValueArray = jSONReader.readInt64ValueArray();
        return (int64ValueArray == null || (function = this.builder) == null) ? int64ValueArray : function.apply(int64ValueArray);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(Collection collection, long j) {
        long jLongValue;
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (Object obj : collection) {
            if (obj == null) {
                jLongValue = 0;
            } else if (obj instanceof Number) {
                jLongValue = ((Number) obj).longValue();
            } else {
                Function typeConvert = JSONFactory.getDefaultObjectReaderProvider().getTypeConvert(obj.getClass(), Long.TYPE);
                if (typeConvert == null) {
                    throw new JSONException(bjs.m(obj, new StringBuilder("can not cast to long ")));
                }
                jLongValue = ((Long) typeConvert.apply(obj)).longValue();
            }
            jArr[i] = jLongValue;
            i++;
        }
        Function<long[], Object> function = this.builder;
        return function != null ? function.apply(jArr) : jArr;
    }
}
