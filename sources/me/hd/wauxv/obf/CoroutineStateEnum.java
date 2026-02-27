package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineStateEnum {
    public static final CoroutineStateEnum a;
    public static final /* synthetic */ CoroutineStateEnum[] b;

    static {
        CoroutineStateEnum ahqVar = new CoroutineStateEnum("COROUTINE_SUSPENDED", 0);
        a = ahqVar;
        b = new CoroutineStateEnum[]{ahqVar, new CoroutineStateEnum("UNDECIDED", 1), new CoroutineStateEnum("RESUMED", 2)};
    }

    public static CoroutineStateEnum valueOf(String str) {
        return (CoroutineStateEnum) Enum.valueOf(CoroutineStateEnum.class, str);
    }

    public static CoroutineStateEnum[] values() {
        return (CoroutineStateEnum[]) b.clone();
    }
}
