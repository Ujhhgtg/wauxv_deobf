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
public final /* synthetic */ class cpp implements Consumer {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ ObjectReaderCreator b;
    public final /* synthetic */ FieldInfo c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Class e;
    public final /* synthetic */ Type f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String[] h;
    public final /* synthetic */ LinkedHashMap i;
    public final /* synthetic */ ObjectReaderProvider j;
    public final /* synthetic */ Object k;

    public /* synthetic */ cpp(ObjectReaderCreator objectReaderCreator, FieldInfo fieldInfo, long j, Class cls, Type type, String str, String[] strArr, BeanInfo beanInfo, LinkedHashMap linkedHashMap, ObjectReaderProvider objectReaderProvider) {
        this.b = objectReaderCreator;
        this.c = fieldInfo;
        this.d = j;
        this.e = cls;
        this.f = type;
        this.g = str;
        this.h = strArr;
        this.k = beanInfo;
        this.i = linkedHashMap;
        this.j = objectReaderProvider;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                this.b.lambda$createFieldReaders$2(this.c, this.d, this.g, this.e, this.f, (String) this.k, this.h, this.i, this.j, (Field) obj);
                break;
            default:
                this.b.lambda$createFieldReaders$5(this.c, this.d, this.e, this.f, this.g, this.h, (BeanInfo) this.k, this.i, this.j, (Method) obj);
                break;
        }
    }

    public /* synthetic */ cpp(ObjectReaderCreator objectReaderCreator, FieldInfo fieldInfo, long j, String str, Class cls, Type type, String str2, String[] strArr, LinkedHashMap linkedHashMap, ObjectReaderProvider objectReaderProvider) {
        this.b = objectReaderCreator;
        this.c = fieldInfo;
        this.d = j;
        this.g = str;
        this.e = cls;
        this.f = type;
        this.k = str2;
        this.h = strArr;
        this.i = linkedHashMap;
        this.j = objectReaderProvider;
    }
}
