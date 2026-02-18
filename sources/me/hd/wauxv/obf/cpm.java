package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import com.alibaba.fastjson2.reader.ObjectReaderCreator;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpm implements Consumer {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Class b;
    public final /* synthetic */ String c;
    public final /* synthetic */ FieldInfo d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Serializable f;
    public final /* synthetic */ Object g;

    public /* synthetic */ cpm(ObjectReaderBaseModule.ReaderAnnotationProcessor readerAnnotationProcessor, String str, FieldInfo fieldInfo, Class cls, String str2, String str3) {
        this.e = readerAnnotationProcessor;
        this.c = str;
        this.d = fieldInfo;
        this.b = cls;
        this.f = str2;
        this.g = str3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                ((ObjectReaderBaseModule.ReaderAnnotationProcessor) this.e).lambda$getFieldInfo$9(this.c, this.d, this.b, (String) this.f, (String) this.g, (Field) obj);
                break;
            default:
                ObjectReaderCreator.lambda$createObjectReaderWithCreator$1(this.b, (ObjectReaderProvider) this.e, (Class) this.f, (BeanInfo) this.g, this.c, this.d, (Method) obj);
                break;
        }
    }

    public /* synthetic */ cpm(Class cls, ObjectReaderProvider objectReaderProvider, Class cls2, BeanInfo beanInfo, String str, FieldInfo fieldInfo) {
        this.b = cls;
        this.e = objectReaderProvider;
        this.f = cls2;
        this.g = beanInfo;
        this.c = str;
        this.d = fieldInfo;
    }
}
