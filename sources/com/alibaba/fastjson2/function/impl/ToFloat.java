package com.alibaba.fastjson2.function.impl;

import com.alibaba.fastjson2.JSONException;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ToFloat implements Function {
    final Float defaultValue;

    public ToFloat(Float f) {
        this.defaultValue = f;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return this.defaultValue;
        }
        if (obj instanceof Boolean) {
            return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        throw new JSONException(concatVar1GetClass(obj, new StringBuilder("can not cast to Float ")));
    }
}
