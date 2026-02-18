package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cox {
    public static final /* synthetic */ cox[] a = {new cox("MIN", 0), new cox("LOW", 1), new cox("DEFAULT", 2), new cox("HIGH", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    cox EF5;

    public static cox valueOf(String str) {
        return (cox) Enum.valueOf(cox.class, str);
    }

    public static cox[] values() {
        return (cox[]) a.clone();
    }
}
