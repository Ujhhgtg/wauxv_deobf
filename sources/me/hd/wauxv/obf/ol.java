package me.hd.wauxv.obf;

import bsh.GeneratedClass;
import bsh.This;
import bsh.classpath.BshClassPath;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.reader.FieldReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.BeanUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ol implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ol(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BeanUtils.lambda$getDeclaredField$0((HashMap) this.b, (Field) obj);
                break;
            case 1:
                BshClassPath.lambda$getPackagesSet$9((HashSet) this.b, (BshClassPath) obj);
                break;
            case 2:
                JSONSchema.lambda$of$0((JSONArray) this.b, (FieldReader) obj);
                break;
            case 3:
                ((Predicate) this.b).test((JSONSchema) obj);
                break;
            default:
                This.initClassInstanceThis((GeneratedClass) this.b, (String) obj);
                break;
        }
    }
}
