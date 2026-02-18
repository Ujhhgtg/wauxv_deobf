package me.hd.wauxv.obf;

import com.alibaba.fastjson2.util.JDKUtils;
import java.util.List;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bra implements ToIntFunction {
    public final /* synthetic */ int a;

    public /* synthetic */ bra(int i) {
        this.a = i;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.a) {
            case 0:
                return JDKUtils.lambda$static$0((String) obj);
            case 1:
                return ((List) obj).size();
            default:
                return ((StackTraceElement) obj).getLineNumber();
        }
    }
}
