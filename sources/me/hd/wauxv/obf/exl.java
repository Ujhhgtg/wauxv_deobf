package me.hd.wauxv.obf;

import java.time.ZoneId;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class exl {
    public static final boolean a;
    public static final long b;
    public static final String c;

    /* JADX WARN: Found duplicated region for block: B:13:0x002a  */
    static {
        boolean z;
        Object objX;
        Boolean bool;
        boolean z2 = exm.a;
        if (!exm.l()) {
            MethodHookWrapper methodHookWrapperVarAy = dqc.ay("__--");
            z = ((methodHookWrapperVarAy == null || (bool = (Boolean) methodHookWrapperVarAy.j(new Object[0])) == null) ? false : bool.booleanValue()) || KotlinHelpers2.az();
        }
        a = z;
        try {
            objX = 1771232894858L;
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        if (objX instanceof dcx) {
            objX = null;
        }
        Long l = (Long) objX;
        long jLongValue = l != null ? l.longValue() : 0L;
        b = jLongValue;
        c = cnh.ag(jLongValue, null, ZoneId.of("Asia/Shanghai" /* "Asia/Shanghai" /* "Asia/Shanghai" /* "Asia/Shanghai" /* cnb.z(-48137993452330L)   */), 1);
    }
}
