package me.hd.wauxv.obf;

import bsh.classpath.BshClassPath;
import com.alibaba.fastjson2.reader.FieldReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.schema.ObjectSchema;
import com.alibaba.fastjson2.util.BeanUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oj implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ oj(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BeanUtils.lambda$setters$2((Annotation) this.b, (AtomicBoolean) this.c, (Method) obj);
                break;
            case 1:
                BeanUtils.lambda$getEnumAnnotationNames$6((Enum[]) this.b, (String[]) this.c, (Field) obj);
                break;
            case 2:
                BeanUtils.lambda$getSetter$1((String) this.b, (Method[]) this.c, (Method) obj);
                break;
            case 3:
                BeanUtils.lambda$processJacksonJsonFormat$12((Annotation) this.b, (String[]) this.c, (Method) obj);
                break;
            case 4:
                BeanUtils.lambda$getField$9((String) this.b, (Field[]) this.c, (Field) obj);
                break;
            case 5:
                ((BshClassPath) this.b).lambda$getAllNames$6((ArrayList) this.c, (String) obj);
                break;
            case 6:
                BshClassPath.lambda$getClassesForPackage$0((String) this.b, (HashSet) this.c, (BshClassPath) obj);
                break;
            default:
                JSONSchema.lambda$of$1((ObjectSchema) this.b, (JSONSchema) this.c, (FieldReader) obj);
                break;
        }
    }
}
