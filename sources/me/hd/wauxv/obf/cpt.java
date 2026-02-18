package me.hd.wauxv.obf;

import bsh.NameSpace;
import bsh.Reflect;
import bsh.StringUtil;
import com.alibaba.fastjson2.reader.ObjectReaderCreator;
import com.alibaba.fastjson2.reader.ObjectReaderCreatorASM;
import com.alibaba.fastjson2.reader.ObjectReaderImplList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpt implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ cpt(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ObjectReaderCreator.lambda$createBuildFunction$7((Method) this.b, obj);
            case 1:
                return ObjectReaderCreatorASM.lambda$createValueConsumer0$7((Constructor) this.b, obj);
            case 2:
                return ObjectReaderImplList.lambda$of$0((Type) this.b, obj);
            case 3:
                return ((ObjectReaderImplList) this.b).lambda$readJSONBObject$12(obj);
            case 4:
                return Reflect.getVariable((NameSpace) this.b, (String) obj);
            default:
                return StringUtil.lambda$getTypeNames$1((Iterator) this.b, (String) obj);
        }
    }
}
