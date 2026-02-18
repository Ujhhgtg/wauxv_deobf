package me.hd.wauxv.obf;

import com.alibaba.fastjson2.reader.ObjectReaderCreatorASM;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpu implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Class b;

    public /* synthetic */ cpu(Class cls, int i) {
        this.a = i;
        this.b = cls;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ObjectReaderCreatorASM.lambda$createValueConsumer0$6(this.b, (String) obj);
            case 1:
                return ObjectReaderCreatorASM.lambda$jitObjectReader$1(this.b, (String) obj);
            default:
                return ObjectReaderCreatorASM.lambda$createNoneDefaultConstructorObjectReader$0(this.b, (String) obj);
        }
    }
}
