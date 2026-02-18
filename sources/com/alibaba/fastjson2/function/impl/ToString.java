package com.alibaba.fastjson2.function.impl;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ToString implements Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
