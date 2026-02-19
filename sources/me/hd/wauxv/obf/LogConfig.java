package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class LogConfig {
    public static final Kotlin$Lazy isDevelopmentMode = new Kotlin$Lazy(new amd(26));
    public static final Kotlin$Lazy isVerboseLogging;
    public static LogBackend logBackend;
    public static LogLevelEnum logLevelEnum;

    static {
        Kotlin$Lazy kotlin$LazyVar = new Kotlin$Lazy(new amd(27));
        isVerboseLogging = kotlin$LazyVar;
        logBackend = new SyntheticClass(21);
        LogLevelEnum logLevelEnumVar = LogLevelEnum.WARN;
        logLevelEnum = logLevelEnumVar;
        if (!(Boolean) kotlin$LazyVar.getValue()) {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
        }
        logLevelEnum = logLevelEnumVar;
    }

    public static void logE(String str, Throwable th) {
        if (logLevelEnum.ordinal() <= 2) {
            logBackend.logException(str, th);
        }
    }
}
