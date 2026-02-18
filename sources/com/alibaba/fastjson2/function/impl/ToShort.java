package com.alibaba.fastjson2.function.impl;

import com.alibaba.fastjson2.JSONException;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ToShort implements Function {
    final Short defaultValue;

    public ToShort(Short sh) {
        this.defaultValue = sh;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return this.defaultValue;
        }
        if (obj instanceof Boolean) {
            return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        throw new JSONException(bjs.m(obj, new StringBuilder("can not cast to Short ")));
    }
}
