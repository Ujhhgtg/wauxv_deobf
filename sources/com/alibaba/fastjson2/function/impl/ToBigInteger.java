package com.alibaba.fastjson2.function.impl;

import com.alibaba.fastjson2.JSONException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ToBigInteger implements Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null || (obj instanceof BigInteger)) {
            return obj;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? BigInteger.ONE : BigInteger.ZERO;
        }
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof AtomicInteger) || (obj instanceof AtomicLong) || (obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).toBigInteger();
        }
        throw new JSONException(bjs.m(obj, new StringBuilder("can not cast to BigInteger ")));
    }
}
