package me.hd.wauxv.obf;

import bsh.ClassGeneratorUtil;
import com.alibaba.fastjson2.util.BeanUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ok implements Consumer {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Class c;

    public /* synthetic */ ok(Class cls, ArrayList arrayList) {
        this.c = cls;
        this.b = arrayList;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BeanUtils.lambda$isExtendedMap$20(this.c, this.b, (Field) obj);
                break;
            default:
                ClassGeneratorUtil.lambda$checkAbstractMethodImplementation$4(this.b, this.c, (Method) obj);
                break;
        }
    }

    public /* synthetic */ ok(ArrayList arrayList, Class cls) {
        this.b = arrayList;
        this.c = cls;
    }
}
