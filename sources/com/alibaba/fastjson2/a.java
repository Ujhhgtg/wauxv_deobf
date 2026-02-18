package com.alibaba.fastjson2;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {
    public final /* synthetic */ int a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return Boolean.valueOf(((JSONPathFilter) obj).isAnd());
            case 1:
                return JSONPathFunction.type(obj);
            case 2:
                return JSONPathFunction.first(obj);
            case 3:
                return JSONPathFunction.last(obj);
            case 4:
                return JSONPathFunction.floor(obj);
            case 5:
                return JSONPathFunction.ceil(obj);
            case 6:
                return JSONPathFunction.abs(obj);
            case 7:
                return JSONPathFunction.negative(obj);
            case 8:
                return JSONPathFunction.exists(obj);
            case 9:
                return JSONPathFunction.lower(obj);
            case 10:
                return JSONPathFunction.upper(obj);
            default:
                return JSONPathFunction.trim(obj);
        }
    }
}
