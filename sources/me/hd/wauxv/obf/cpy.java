package me.hd.wauxv.obf;

import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpy implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ ClassLoader b;

    public /* synthetic */ cpy(ClassLoader classLoader, int i) {
        this.a = i;
        this.b = classLoader;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.a) {
            case 0:
                return ObjectReaderProvider.lambda$cleanup$0(this.b, (Map.Entry) obj);
            case 1:
                return ObjectReaderProvider.lambda$cleanup$1(this.b, (Map.Entry) obj);
            case 2:
                return ObjectReaderProvider.lambda$cleanup$2(this.b, (Map.Entry) obj);
            default:
                return ObjectWriterProvider.lambda$cleanup$0(this.b, (Map.Entry) obj);
        }
    }
}
