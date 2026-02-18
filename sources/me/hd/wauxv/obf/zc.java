package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zc implements bsv, yq {
    public static final Map b;
    public final Class c;

    static {
        List listAg = aba.ag(bfu.class, bgf.class, bgj.class, bgk.class, blv.class, bgl.class, bgm.class, aak.class, bgn.class, bgo.class, bfv.class, bfw.class, bfx.class, bfy.class, bfz.class, bga.class, bgb.class, bgc.class, bgd.class, bge.class, bgg.class, bgh.class, bgi.class);
        ArrayList arrayList = new ArrayList(abb.ak(listAg, 10));
        int i = 0;
        for (Object obj : listAg) {
            int i2 = i + 1;
            if (i < 0) {
                aba.aj();
                throw null;
            }
            arrayList.add(new csm((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = bzo.as(arrayList);
    }

    public zc(Class cls) {
        bzo.q(cls, "jClass");
        this.c = cls;
    }

    @Override // me.hd.wauxv.obf.yq
    public final Class a() {
        return this.c;
    }

    public final String d() {
        String strAq;
        Class cls = this.c;
        bzo.q(cls, "jClass");
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
            return dnj.au(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return dnj.at('$', simpleName, simpleName);
        }
        return dnj.au(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zc) && cnf.be(this).equals(cnf.be((bsv) obj));
    }

    public final int hashCode() {
        return cnf.be(this).hashCode();
    }

    public final String toString() {
        return this.c.toString() + " (Kotlin reflection is not available)";
    }
}
