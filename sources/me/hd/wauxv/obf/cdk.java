package me.hd.wauxv.obf;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdk extends bpu {
    public final Method a;

    public cdk(Method method) {
        this.a = method;
    }

    @Override // me.hd.wauxv.obf.cbq
    public final Member b() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.bpu
    public final bpu c(Object obj) {
        h(obj);
        return this;
    }

    public final cdk d() {
        return new cdk(this.a);
    }

    public final Object e(Object... objArr) {
        Method method = this.a;
        Method method2 = method != null ? method : null;
        if (method2 != null && !method2.isAccessible()) {
            method2.setAccessible(true);
        }
        return method.invoke(this.g, Arrays.copyOf(objArr, objArr.length));
    }

    public final Object f(Object... objArr) {
        Object objX;
        try {
            objX = e(Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (objX instanceof dcx) {
            return null;
        }
        return objX;
    }

    public final Object i(Object... objArr) {
        Object objX;
        try {
            objX = j(Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (objX instanceof dcx) {
            return null;
        }
        return objX;
    }

    public final Object j(Object... objArr) {
        Method method = this.a;
        Method method2 = method != null ? method : null;
        if (method2 != null && !method2.isAccessible()) {
            method2.setAccessible(true);
        }
        Object objInvoke = method.invoke(this.g, Arrays.copyOf(objArr, objArr.length));
        if (objInvoke == null) {
            return null;
        }
        return objInvoke;
    }
}
