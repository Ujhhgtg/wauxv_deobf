package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpn implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ ObjectReaderBaseModule.ReaderAnnotationProcessor b;
    public final /* synthetic */ Annotation c;
    public final /* synthetic */ BeanInfo d;

    public /* synthetic */ cpn(ObjectReaderBaseModule.ReaderAnnotationProcessor readerAnnotationProcessor, Annotation annotation, BeanInfo beanInfo, int i) {
        this.a = i;
        this.b = readerAnnotationProcessor;
        this.c = annotation;
        this.d = beanInfo;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                this.b.lambda$processJacksonJsonDeserializer$5(this.c, this.d, (Method) obj);
                break;
            default:
                this.b.lambda$getBeanInfo1x$7(this.c, this.d, (Method) obj);
                break;
        }
    }
}
