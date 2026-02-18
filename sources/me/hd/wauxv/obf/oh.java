package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.writer.ObjectWriterBaseModule;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oh implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Annotation b;
    public final /* synthetic */ BeanInfo c;

    public /* synthetic */ oh(BeanInfo beanInfo, Annotation annotation, int i) {
        this.a = i;
        this.c = beanInfo;
        this.b = annotation;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BeanUtils.processJSONType1x(this.c, this.b, (Method) obj);
                break;
            case 1:
                BeanUtils.lambda$processJacksonJsonInclude$14(this.b, this.c, (Method) obj);
                break;
            case 2:
                BeanUtils.lambda$processJacksonJsonTypeName$17(this.b, this.c, (Method) obj);
                break;
            case 3:
                BeanUtils.lambda$processJacksonJsonFormat$13(this.b, this.c, (Method) obj);
                break;
            case 4:
                ObjectReaderBaseModule.lambda$getCreator$6(this.b, this.c, (Method) obj);
                break;
            case 5:
                ObjectReaderBaseModule.lambda$getCreator$7(this.b, this.c, (Method) obj);
                break;
            case 6:
                ObjectReaderBaseModule.lambda$getCreator$5(this.b, this.c, (Method) obj);
                break;
            case 7:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processJacksonJsonTypeInfo$6(this.b, this.c, (Method) obj);
                break;
            case 8:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processSeeAlsoAnnotation$8(this.b, this.c, (Method) obj);
                break;
            case 9:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processJacksonJsonSubTypes$4(this.b, this.c, (Method) obj);
                break;
            case 10:
                ObjectWriterBaseModule.WriterAnnotationProcessor.lambda$processJacksonJsonIgnoreProperties$7(this.b, this.c, (Method) obj);
                break;
            case 11:
                BeanUtils.processJSONType1x(this.c, this.b, (Method) obj);
                break;
            case 12:
                ObjectWriterBaseModule.WriterAnnotationProcessor.lambda$processJacksonJsonSubTypes$1(this.b, this.c, (Method) obj);
                break;
            default:
                ObjectWriterBaseModule.WriterAnnotationProcessor.lambda$processJacksonJsonTypeInfo$3(this.b, this.c, (Method) obj);
                break;
        }
    }

    public /* synthetic */ oh(Annotation annotation, BeanInfo beanInfo, int i) {
        this.a = i;
        this.b = annotation;
        this.c = beanInfo;
    }
}
