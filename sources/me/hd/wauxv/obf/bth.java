package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bth {
    public static final Kotlin$Lazy a = new Kotlin$Lazy(new amd(26));
    public static final Kotlin$Lazy b;
    public static btg c;
    public static LogLevelEnum d;

    static {
        Kotlin$Lazy kotlin$LazyVar = new Kotlin$Lazy(new amd(27));
        b = kotlin$LazyVar;
        c = new GifEncoder(21);
        LogLevelEnum logLevelEnumVar = LogLevelEnum.WARN;
        d = logLevelEnumVar;
        if (!((Boolean) kotlin$LazyVar.getValue()).booleanValue()) {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
        }
        d = logLevelEnumVar;
    }

    public static void e(String str, Throwable th) {
        if (d.ordinal() <= 2) {
            c.e(str, th);
        }
    }
}
