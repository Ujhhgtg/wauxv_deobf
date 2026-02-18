package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import java.lang.reflect.Method;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agp extends bws implements IRequiresDexLocate {
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
                Method methodBb = emn.bb(ago.a);
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
        int i = bte.a;
        dmu.a.getClass();
        cde cdeVarT = dqc.bi(dmu.b()).t();
        cdeVarT.a = dal.b(Integer.TYPE);
        agc.a.getClass();
        Class<?> declaringClass = emn.bb(agb.a).getDeclaringClass();
        zc zcVarB = dal.b(String.class);
        Class cls = Boolean.TYPE;
        Object objJ = ((cdk) dkz.n(new Object[] { declaringClass, zcVarB, dal.b(cls), dal.b(cls) }, 4, cdeVarT)).j(obj,
                str, false, true);
        throwIfVar1IsNull(objJ);
        ((Number) objJ).intValue();
    }

    public static void d(String str, String[] strArr) {
        Method methodBb = emn.bb(agn.a);
        if (methodBb.getParameterCount() == 4) {
            dmu.a.getClass();
            methodBb.invoke(dmu.b(), strArr, str, Boolean.TRUE, Boolean.FALSE);
        } else {
            dmu.a.getClass();
            methodBb.invoke(dmu.b(), strArr, str);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(agl.a, dexKitBridge, new age(8));
        emn.aj(ago.a, dexKitBridge, new age(9));
        emn.aj(agn.a, dexKitBridge, new age(10));
        emn.aj(agm.a, dexKitBridge, new age(11));
    }
}
