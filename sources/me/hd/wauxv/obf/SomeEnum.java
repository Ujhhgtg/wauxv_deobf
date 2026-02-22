package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class SomeEnum {
    public static final SomeEnum DEFAULT;
    public static final /* synthetic */ SomeEnum[] VALUES;

    static {
        SomeEnum ahsVar = new SomeEnum("DEFAULT", 0);
        DEFAULT = ahsVar;
        VALUES = new SomeEnum[]{ahsVar, new SomeEnum("LAZY", 1), new SomeEnum("ATOMIC", 2), new SomeEnum("UNDISPATCHED", 3)};
    }

    public static SomeEnum valueOf(String str) {
        return (SomeEnum) Enum.valueOf(SomeEnum.class, str);
    }

    public static SomeEnum[] values() {
        return (SomeEnum[]) VALUES.clone();
    }
}
