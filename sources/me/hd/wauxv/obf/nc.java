package me.hd.wauxv.obf;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nc implements afw, ahr, Serializable {
    public final afw j;

    public nc(afw afwVar) {
        this.j = afwVar;
    }

    @Override // me.hd.wauxv.obf.afw
    public final void _bn(Object obj) {
        afw afwVar = this;
        while (true) {
            nc ncVar = (nc) afwVar;
            afw afwVar2 = ncVar.j;
            bzo.n(afwVar2);
            try {
                obj = ncVar.i(obj);
                if (obj == ahq.a) {
                    return;
                }
            } catch (Throwable th) {
                obj = bhu.x(th);
            }
            ncVar.l();
            if (!(afwVar2 instanceof nc)) {
                afwVar2._bn(obj);
                return;
            }
            afwVar = afwVar2;
        }
    }

    public afw h(Object obj, afw afwVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public abstract Object i(Object obj);

    @Override // me.hd.wauxv.obf.ahr
    public final ahr k() {
        afw afwVar = this.j;
        if (afwVar instanceof ahr) {
            return (ahr) afwVar;
        }
        return null;
    }

    public void l() {
    }

    public String toString() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        StringBuilder sb = new StringBuilder("Continuation at ");
        ajm ajmVar = (ajm) getClass().getAnnotation(ajm.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        name = null;
        if (ajmVar != null && ajmVar.v() >= 1) {
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i = iIntValue >= 0 ? ajmVar.l()[iIntValue] : -1;
            jx jxVar = cna.b;
            jx jxVar2 = cna.c;
            if (jxVar2 == null) {
                try {
                    jx jxVar3 = new jx(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null), 16);
                    cna.c = jxVar3;
                    jxVar2 = jxVar3;
                } catch (Exception unused2) {
                    cna.c = jxVar;
                    jxVar2 = jxVar;
                }
            }
            if (jxVar2 != jxVar && (method = (Method) jxVar2.e) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) jxVar2.f) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
                Method method3 = (Method) jxVar2.h;
                Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                if (objInvoke3 instanceof String) {
                    str = (String) objInvoke3;
                }
            }
            if (str == null) {
                strC = ajmVar.c();
            } else {
                strC = str + '/' + ajmVar.c();
            }
            name = new StackTraceElement(strC, ajmVar.m(), ajmVar.f(), i);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }
}
