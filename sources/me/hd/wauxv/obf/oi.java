package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.writer.ObjectWriterBaseModule;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oi implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Annotation b;
    public final /* synthetic */ FieldInfo c;

    public /* synthetic */ oi(Annotation annotation, FieldInfo fieldInfo, int i) {
        this.a = i;
        this.b = annotation;
        this.c = fieldInfo;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BeanUtils.lambda$processJacksonJsonIgnore$11(this.b, this.c, (Method) obj);
                break;
            case 1:
                BeanUtils.lambda$processGsonSerializedName$19(this.b, this.c, (Method) obj);
                break;
            case 2:
                BeanUtils.lambda$processJacksonJsonUnwrapped$16(this.b, this.c, (Method) obj);
                break;
            case 3:
                BeanUtils.lambda$processJacksonJsonInclude$15(this.b, this.c, (Method) obj);
                break;
            case 4:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processJacksonJsonAlias$13(this.b, this.c, (Method) obj);
                break;
            case 5:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processJacksonJsonSetter$12(this.b, this.c, (Method) obj);
                break;
            case 6:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processJSONField1x$14(this.b, this.c, (Method) obj);
                break;
            case 7:
                ObjectReaderBaseModule.ReaderAnnotationProcessor.lambda$processJacksonJsonProperty$11(this.b, this.c, (Method) obj);
                break;
            default:
                ObjectWriterBaseModule.WriterAnnotationProcessor.lambda$processJacksonJsonProperty$6(this.b, this.c, (Method) obj);
                break;
        }
    }
}
