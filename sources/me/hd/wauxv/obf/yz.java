package me.hd.wauxv.obf;

import bsh.ClassGeneratorUtil;
import bsh.Reflect;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yz implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ GenericDeclaration b;

    public /* synthetic */ yz(GenericDeclaration genericDeclaration, int i) {
        this.a = i;
        this.b = genericDeclaration;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.a) {
            case 0:
                return ClassGeneratorUtil.lambda$checkAbstractMethodImplementation$1((Method) this.b, (Method) obj);
            default:
                return Reflect.lambda$getEnumConstants$6((Class) this.b, (Field) obj);
        }
    }
}
