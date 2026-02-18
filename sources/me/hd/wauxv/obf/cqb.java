package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.writer.ObjectWriterCreator;
import com.alibaba.fastjson2.writer.ObjectWriterCreatorASM;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cqb implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ FieldInfo b;
    public final /* synthetic */ long c;
    public final /* synthetic */ BeanInfo d;
    public final /* synthetic */ ObjectWriterProvider e;
    public final /* synthetic */ Class f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ LinkedHashMap h;
    public final /* synthetic */ ObjectWriterCreator i;

    public /* synthetic */ cqb(ObjectWriterCreator objectWriterCreator, FieldInfo fieldInfo, long j, BeanInfo beanInfo, ObjectWriterProvider objectWriterProvider, Class cls, boolean z, LinkedHashMap linkedHashMap, int i) {
        this.a = i;
        this.i = objectWriterCreator;
        this.b = fieldInfo;
        this.c = j;
        this.d = beanInfo;
        this.e = objectWriterProvider;
        this.f = cls;
        this.g = z;
        this.h = linkedHashMap;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws IllegalAccessException, NoSuchMethodException {
        switch (this.a) {
            case 0:
                this.i.lambda$createObjectWriter$2(this.b, this.c, this.d, this.e, this.f, this.g, this.h, (Method) obj);
                break;
            default:
                ((ObjectWriterCreatorASM) this.i).lambda$createObjectWriter$1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, (Method) obj);
                break;
        }
    }
}
