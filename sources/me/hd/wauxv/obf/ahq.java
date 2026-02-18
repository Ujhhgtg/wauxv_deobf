package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahq {
    public static final ahq a;
    public static final /* synthetic */ ahq[] b;

    static {
        ahq ahqVar = new ahq("COROUTINE_SUSPENDED", 0);
        a = ahqVar;
        b = new ahq[]{ahqVar, new ahq("UNDECIDED", 1), new ahq("RESUMED", 2)};
    }

    public static ahq valueOf(String str) {
        return (ahq) Enum.valueOf(ahq.class, str);
    }

    public static ahq[] values() {
        return (ahq[]) b.clone();
    }
}
