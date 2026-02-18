package com.alibaba.fastjson2.function.impl;

import com.alibaba.fastjson2.JSONException;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ToLong implements Function {
    final Long defaultValue;

    public ToLong(Long l) {
        this.defaultValue = l;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return this.defaultValue;
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        throw new JSONException(bjs.m(obj, new StringBuilder("can not cast to Long ")));
    }
}
