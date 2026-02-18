package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.reader.ObjectReaderCreator;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpr implements Consumer {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ ObjectReaderCreator b;
    public final /* synthetic */ FieldInfo c;
    public final /* synthetic */ long d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Class f;
    public final /* synthetic */ Type g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String[] i;
    public final /* synthetic */ BeanInfo j;
    public final /* synthetic */ LinkedHashMap k;
    public final /* synthetic */ ObjectReaderProvider l;

    public /* synthetic */ cpr(ObjectReaderCreator objectReaderCreator, FieldInfo fieldInfo, long j, String str, Class cls, Type type, String str2, String[] strArr, BeanInfo beanInfo, LinkedHashMap linkedHashMap, ObjectReaderProvider objectReaderProvider) {
        this.b = objectReaderCreator;
        this.c = fieldInfo;
        this.d = j;
        this.e = str;
        this.f = cls;
        this.g = type;
        this.h = str2;
        this.i = strArr;
        this.j = beanInfo;
        this.k = linkedHashMap;
        this.l = objectReaderProvider;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                this.b.lambda$createFieldReaders$3(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.k, this.l, this.j, (Field) obj);
                break;
            default:
                this.b.lambda$createFieldReaders$4(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, (Method) obj);
                break;
        }
    }

    public /* synthetic */ cpr(ObjectReaderCreator objectReaderCreator, FieldInfo fieldInfo, long j, String str, Class cls, Type type, String str2, String[] strArr, LinkedHashMap linkedHashMap, ObjectReaderProvider objectReaderProvider, BeanInfo beanInfo) {
        this.b = objectReaderCreator;
        this.c = fieldInfo;
        this.d = j;
        this.e = str;
        this.f = cls;
        this.g = type;
        this.h = str2;
        this.i = strArr;
        this.k = linkedHashMap;
        this.l = objectReaderProvider;
        this.j = beanInfo;
    }
}
