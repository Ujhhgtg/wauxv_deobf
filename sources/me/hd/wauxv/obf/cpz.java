package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.writer.ObjectWriterBaseModule;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpz implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ ObjectWriterBaseModule.WriterAnnotationProcessor b;
    public final /* synthetic */ Annotation c;
    public final /* synthetic */ FieldInfo d;

    public /* synthetic */ cpz(ObjectWriterBaseModule.WriterAnnotationProcessor writerAnnotationProcessor, Annotation annotation, FieldInfo fieldInfo, int i) {
        this.a = i;
        this.b = writerAnnotationProcessor;
        this.c = annotation;
        this.d = fieldInfo;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                this.b.lambda$processJacksonJsonSerialize$5(this.c, this.d, (Method) obj);
                break;
            default:
                this.b.lambda$processJSONField1x$8(this.c, this.d, (Method) obj);
                break;
        }
    }
}
