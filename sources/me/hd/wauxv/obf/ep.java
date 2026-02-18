package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ep extends cbm {
    public static final dov a = new dov(new h(6));

    @Override // me.hd.wauxv.obf.cbm
    public final List b(Class cls) {
        dov dovVar = eu.a;
        List listB = super.b(cls);
        if (!eu.b(28)) {
            return listB;
        }
        List listF = blb.f(cls);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF) {
            if (obj instanceof Constructor) {
                arrayList.add(obj);
            }
        }
        return aaz.z(arrayList);
    }

    @Override // me.hd.wauxv.obf.cbm
    public final List c(Class cls) {
        dov dovVar = eu.a;
        List listC = super.c(cls);
        if (!eu.b(28)) {
            return listC;
        }
        List listF = blb.f(cls);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF) {
            if (obj instanceof Method) {
                arrayList.add(obj);
            }
        }
        return aaz.z(arrayList);
    }
}
