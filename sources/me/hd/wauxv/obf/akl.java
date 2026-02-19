package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class akl {
    public static final als a;

    static {
        String property;
        Dispatcher2 dispatcher2Var;
        als alsVar;
        int i = dpg.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            alc alcVar = aou.a;
            dispatcher2Var = bza.a;
            Dispatcher2 dispatcher2Var2 = dispatcher2Var.l;
            if (dispatcher2Var == null) {
                alsVar = dispatcher2Var;
                alsVar = akk.f;
            }
        } else {
            alsVar = akk.f;
        }
        alsVar = dispatcher2Var;
        a = alsVar;
    }
}
