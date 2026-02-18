package me.hd.wauxv.obf;

import com.alibaba.fastjson2.reader.ObjectReaderCreator;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpq implements BiConsumer {
    public final /* synthetic */ int a;

    public /* synthetic */ cpq(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Throwable) obj).setStackTrace((StackTraceElement[]) obj2);
                break;
            default:
                ObjectReaderCreator.lambda$createFieldReaders$6(obj, obj2);
                break;
        }
    }
}
