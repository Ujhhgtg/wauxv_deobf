package com.alibaba.fastjson2;

import java.util.function.Consumer;
import me.hd.wauxv.obf.IInvokable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class JSONKt$sam$i$java_util_function_Consumer$0 implements Consumer {
    private final /* synthetic */ IInvokable function;

    public JSONKt$sam$i$java_util_function_Consumer$0(IInvokable bgfVar) {
        throwIfVar1IsNull(bgfVar, "function");
        this.function = bgfVar;
    }

    @Override // java.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        this.function.invoke(obj);
    }
}
