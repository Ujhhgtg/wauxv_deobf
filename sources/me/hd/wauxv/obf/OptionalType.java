package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class OptionalType {
    public static final OptionalType ENUM_NO;
    public static final OptionalType ENUM_NOTICE;
    public static final OptionalType ENUM_SILENT;
    public static final /* synthetic */ OptionalType[] d;

    static {
        OptionalType optionalTypeVar = new OptionalType("NO", 0);
        ENUM_NO = optionalTypeVar;
        OptionalType optionalTypeVar2 = new OptionalType("NOTICE", 1);
        ENUM_NOTICE = optionalTypeVar2;
        OptionalType optionalTypeVar3 = new OptionalType("SILENT", 2);
        ENUM_SILENT = optionalTypeVar3;
        d = new OptionalType[]{optionalTypeVar, optionalTypeVar2, optionalTypeVar3};
    }

    public static OptionalType valueOf(String str) {
        return (OptionalType) Enum.valueOf(OptionalType.class, str);
    }

    public static OptionalType[] values() {
        return (OptionalType[]) d.clone();
    }
}
