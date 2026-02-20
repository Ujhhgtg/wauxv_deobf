package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class KClass implements IEmpty5, KClassContainer {
    public static final Map functionInterfaceMap;
    public final Class javaClass;

    static {
        List listAg = OtherStaticHelpers.argsToList(IFunction0.class, IInvokable.class, bgj.class, bgk.class, blv.class, bgl.class, bgm.class, aak.class,
                bgn.class, bgo.class, bfv.class, bfw.class, bfx.class, bfy.class, bfz.class, bga.class, bgb.class,
                bgc.class, bgd.class, bge.class, bgg.class, bgh.class, bgi.class);
        ArrayList arrayList = new ArrayList(StaticHelpers4.ak(listAg, 10));
        int i = 0;
        for (Object obj : listAg) {
            int i2 = i + 1;
            if (i < 0) {
                OtherStaticHelpers.aj();
                throw null;
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        functionInterfaceMap = KotlinHelpers.as(arrayList);
    }

    public KClass(Class cls) {
        throwIfVar1IsNull(cls, "jClass");
        this.javaClass = cls;
    }

    @Override // me.hd.wauxv.obf.yq
    public final Class getJClass() {
        return this.javaClass;
    }

    public final String getKotlinSimpleName() {
        String strAq;
        Class cls = this.javaClass;
        throwIfVar1IsNull(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strAq2 = cnb.aq(cls.getName());
                return strAq2 == null ? cls.getSimpleName() : strAq2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strAq = cnb.aq(componentType.getName())) != null) {
                strConcat = strAq.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return StringsKt.au(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return StringsKt.at('$', simpleName, simpleName);
        }
        return StringsKt.au(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof KClass) && HugeSyntheticPileOfHelpers.be(this).equals(HugeSyntheticPileOfHelpers.be((IEmpty5) obj));
    }

    public final int hashCode() {
        return HugeSyntheticPileOfHelpers.be(this).hashCode();
    }

    public final String toString() {
        return this.javaClass.toString() + " (Kotlin reflection is not available)";
    }
}
