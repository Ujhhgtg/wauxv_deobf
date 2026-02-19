package com.highcapable.yukihookapi.hook.xposed.parasitic.activity.delegate;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.bmy;
import me.hd.wauxv.obf.cea;
import me.hd.wauxv.obf.HugeSyntheticPileOfHelpers;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.Failure;
import me.hd.wauxv.obf.ki;
import me.hd.wauxv.obf.ReflectionWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class IActivityManagerProxy_me_hd_wauxv implements InvocationHandler {
    private final Object baseInstance;

    public IActivityManagerProxy_me_hd_wauxv(Object obj) {
        this.baseInstance = obj;
    }

    /* JADX WARN: Found duplicated region for block: B:60:0x00f1 */
    /* JADX WARN: Found duplicated region for block: B:68:0x0101 */
    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        ComponentName component;
        ClassLoader classLoader;
        String strX;
        String str;
        Object objX;
        ClassLoader classLoader2;
        Object obj2 = this.baseInstance;
        Class<cea> cls = cea.class;
        if (nullSafeIsEqual(method != null ? method.getName() : null, "startActivity") && objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                if (objArr[i] instanceof Intent) {
                    break;
                }
                i++;
            }
            Object obj3 = objArr[i];
            Intent intent = obj3 instanceof Intent ? (Intent) obj3 : null;
            if (intent != null && (component = intent.getComponent()) != null) {
                String packageName = component.getPackageName();
                ki.a.getClass();
                if (nullSafeIsEqual(packageName, ki.i()) && (classLoader = bmy.class.getClassLoader()) != null
                        && ReflectionWrapper.g(classLoader, component.getClassName())) {
                    Intent intent2 = new Intent();
                    String packageName2 = component.getPackageName();
                    Class<?> clsF = ReflectionWrapper.f(component.getClassName(), 3, null);
                    if (clsF != null) {
                        try {
                            if (HugeSyntheticPileOfHelpers.getJavaClass(dal.getKClassFromClass(cls)).isAssignableFrom(clsF)) {
                                try {
                                    Object[] objArrCopyOf = Arrays.copyOf(new Object[0], 0);
                                    Object objC = ReflectionWrapper.createInstanceWithArgs(clsF,
                                            Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                                    if (!(objC instanceof cea)) {
                                        objC = null;
                                    }
                                    objX = (cea) objC;
                                    if (objX == null) {
                                        Class<cea> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                                        if (clsBf != null) {
                                            cls = clsBf;
                                        }
                                        throw new IllegalStateException(
                                                (clsF + "'s instance cannot be cast to type " + cls + ".").toString());
                                    }
                                } catch (Throwable th) {
                                    objX = FastKV.getFailureFromException(th);
                                }
                                if (objX instanceof Failure) {
                                    objX = null;
                                }
                                if (((cea) objX) != null) {
                                    ki.a.getClass();
                                    Application application = ki.f;
                                    strX = (application == null || (classLoader2 = application.getClassLoader()) == null
                                            || !ReflectionWrapper.g(classLoader2, "")) ? null : "";
                                }
                            }
                        } catch (Throwable th2) {
                            strX = FastKV.getFailureFromException(th2);
                        }
                        if (strX instanceof Failure) {
                            strX = null;
                        }
                        str = (String) strX;
                        if (str == null) {
                            str = "";
                        }
                    } else {
                        str = "";
                    }
                    intent2.setClassName(packageName2, str);
                    intent2.putExtra("", intent);
                    objArr[i] = intent2;
                }
            }
        }
        if (method == null) {
            return null;
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        return method.invoke(obj2, Arrays.copyOf(objArr, objArr.length));
    }
}
