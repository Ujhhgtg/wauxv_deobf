package com.alibaba.fastjson2.function.impl;

import com.alibaba.fastjson2.JSONException;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ToBoolean implements Function {
    final Boolean defaultValue;

    public ToBoolean(Boolean bool) {
        this.defaultValue = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return this.defaultValue;
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            switch ((String) obj) {
                case "F":
                case "N":
                case "NO":
                case "No":
                case "no":
                case "FALSE":
                case "False":
                case "false":
                    return Boolean.FALSE;
                case "T":
                case "Y":
                case "YES":
                case "Yes":
                case "yes":
                case "TRUE":
                case "True":
                case "true":
                    return Boolean.TRUE;
                case "null":
                    return this.defaultValue;
            }
        }
        throw new JSONException(bjs.m(obj, new StringBuilder("can not cast to Byte ")));
    }
}
