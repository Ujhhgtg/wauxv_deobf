package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class so {
    public static final /* synthetic */ so[] a = {new so("READ", 0), new so("WRITE", 1), new so("READ_THEN_REQUEST", 2), new so("REQUEST_THEN_READ", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    so EF5;

    public static so valueOf(String str) {
        return (so) Enum.valueOf(so.class, str);
    }

    public static so[] values() {
        return (so[]) a.clone();
    }
}
