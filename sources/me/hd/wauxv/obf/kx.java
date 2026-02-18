package me.hd.wauxv.obf;

import bsh.Reflect;
import com.alibaba.fastjson2.schema.ArraySchema;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kx implements IntFunction {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ kx(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.a) {
            case 0:
                return ArraySchema.lambda$validate$0((Object[]) this.b, i);
            case 1:
                return Array.get(this.b, i);
            case 2:
                return ArraySchema.lambda$validate$2((Iterator) this.b, i);
            default:
                return Reflect.lambda$getEnumConstants$8((Class) this.b, i);
        }
    }
}
