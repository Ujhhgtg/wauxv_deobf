package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class LogDestination {
    public static final LogDestination a;
    public static final /* synthetic */ LogDestination[] b;

    /* JADX INFO: Fake field, exist only in values array */
    LogDestination EF0;

    static {
        LogDestination logDestinationVar = new LogDestination("LOGD", 0);
        LogDestination logDestinationVar2 = new LogDestination("XPOSED_ENVIRONMENT", 1);
        LogDestination logDestinationVar3 = new LogDestination("SCOPE", 2);
        LogDestination logDestinationVar4 = new LogDestination("BOTH", 3);
        a = logDestinationVar4;
        b = new LogDestination[]{logDestinationVar, logDestinationVar2, logDestinationVar3, logDestinationVar4};
    }

    public static LogDestination valueOf(String str) {
        return (LogDestination) Enum.valueOf(LogDestination.class, str);
    }

    public static LogDestination[] values() {
        return (LogDestination[]) b.clone();
    }
}
