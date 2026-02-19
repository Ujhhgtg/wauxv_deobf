package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstructorHookWrapper extends cbq {
    public final Constructor a;

    public ConstructorHookWrapper(Constructor constructor) {
        this.a = constructor;
    }

    @Override // me.hd.wauxv.obf.cbq
    public final Member b() {
        return this.a;
    }

    public final Object c(Object... objArr) {
        Object objX;
        try {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Constructor constructor = this.a;
            Constructor constructor2 = constructor != null ? constructor : null;
            if (constructor2 != null && !constructor2.isAccessible()) {
                constructor2.setAccessible(true);
            }
            objX = constructor.newInstance(Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (objX instanceof dcx) {
            return null;
        }
        return objX;
    }
}
