package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agp extends bws implements IDexFind {
    public static final agp a = new agp();

    public static void b() throws IOException {
        Cursor cursorAc = arj.ac("SELECT username FROM rconversation WHERE unReadCount>0 OR unReadMuteCount>0" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 372266290379562L)
                                                                                                                */);
        while (cursorAc.moveToNext()) {
            try {
                String string = cursorAc.getString(0);
                a.getClass();
                Method methodBb = StaticHelpers7.toDexMethod(ago.a);
                dmu.a.getClass();
                methodBb.invoke(dmu.b(), string);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(cursorAc, th);
                    throw th2;
                }
            }
        }
        cursorAc.close();
    }

    public static void c(agp agpVar, Object obj, String str) {
        agpVar.getClass();
        int i = 0;
        dmu.a.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dmu.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = dal.getKClassFromClass(Integer.TYPE);
        agc.a.getClass();
        Class<?> declaringClass = StaticHelpers7.toDexMethod(agb.a).getDeclaringClass();
        KClass zcVarB = dal.getKClassFromClass(String.class);
        Class cls = Boolean.TYPE;
        Object objJ = ((MethodHookWrapper) StaticHelpers6.n(new Object[] { declaringClass, zcVarB, dal.getKClassFromClass(cls), dal.getKClassFromClass(cls) }, 4, methodResolverVarT)).j(obj,
                str, false, true);
        throwIfVar1IsNull(objJ);
        ((Number) objJ).intValue();
    }

    public static void d(String str, String[] strArr) {
        Method methodBb = StaticHelpers7.toDexMethod(agn.a);
        if (methodBb.getParameterCount() == 4) {
            dmu.a.getClass();
            methodBb.invoke(dmu.b(), strArr, str, Boolean.TRUE, Boolean.FALSE);
        } else {
            dmu.a.getClass();
            methodBb.invoke(dmu.b(), strArr, str);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(agl.a, dexKitBridge, new age(8));
        StaticHelpers7.resolveDexAndCache(ago.a, dexKitBridge, new age(9));
        StaticHelpers7.resolveDexAndCache(agn.a, dexKitBridge, new age(10));
        StaticHelpers7.resolveDexAndCache(agm.a, dexKitBridge, new age(11));
    }
}
