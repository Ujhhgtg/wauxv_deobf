package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dal {
    public static final dam a;

    static {
        dam damVar = null;
        try {
            damVar = (dam) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (damVar == null) {
            damVar = new dam();
        }
        a = damVar;
    }

    public static KClass getKClassFromClass(Class cls) {
        return new KClass(cls);
    }

    public static eme c(Class cls) {
        KClass zcVarB = getKClassFromClass(cls);
        List list = Collections.EMPTY_LIST;
        return new eme(zcVarB, false);
    }
}
