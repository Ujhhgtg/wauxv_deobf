package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import com.alibaba.fastjson2.writer.ObjectWriterBaseModule;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpk implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Annotation b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ cpk(ObjectReaderBaseModule.ReaderAnnotationProcessor readerAnnotationProcessor, Annotation annotation, FieldInfo fieldInfo) {
        this.a = 1;
        this.c = readerAnnotationProcessor;
        this.b = annotation;
        this.d = fieldInfo;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                ObjectReaderBaseModule.lambda$getBeanInfo1xJSONPOJOBuilder$4(this.b, (BeanInfo) this.c, (Class) this.d, (Method) obj);
                break;
            case 1:
                ((ObjectReaderBaseModule.ReaderAnnotationProcessor) this.c).lambda$processJacksonJsonDeserialize$10(this.b, (FieldInfo) this.d, (Method) obj);
                break;
            case 2:
                ((ObjectWriterBaseModule.WriterAnnotationProcessor) this.d).lambda$processJacksonJsonSerialize$2(this.b, (BeanInfo) this.c, (Method) obj);
                break;
            default:
                ObjectWriterBaseModule.WriterAnnotationProcessor.lambda$processJacksonJsonPropertyOrder$4(this.b, (BeanInfo) this.c, (AtomicBoolean) this.d, (Method) obj);
                break;
        }
    }

    public /* synthetic */ cpk(ObjectWriterBaseModule.WriterAnnotationProcessor writerAnnotationProcessor, Annotation annotation, BeanInfo beanInfo) {
        this.a = 2;
        this.d = writerAnnotationProcessor;
        this.b = annotation;
        this.c = beanInfo;
    }

    public /* synthetic */ cpk(Annotation annotation, BeanInfo beanInfo, Serializable serializable, int i) {
        this.a = i;
        this.b = annotation;
        this.c = beanInfo;
        this.d = serializable;
    }
}
