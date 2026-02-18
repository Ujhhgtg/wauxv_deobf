package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bth {
    public static final dov a = new dov(new amd(26));
    public static final dov b;
    public static btg c;
    public static btf d;

    static {
        dov dovVar = new dov(new amd(27));
        b = dovVar;
        c = new awp(21);
        btf btfVar = btf.WARN;
        d = btfVar;
        if (!((Boolean) dovVar.getValue()).booleanValue()) {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
        }
        d = btfVar;
    }

    public static void e(String str, Throwable th) {
        if (d.ordinal() <= 2) {
            c.e(str, th);
        }
    }
}
