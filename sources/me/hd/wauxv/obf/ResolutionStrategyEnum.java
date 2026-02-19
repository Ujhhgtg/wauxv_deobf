package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionStrategyEnum {
    public static final ResolutionStrategyEnum ENUM_LAZY_CLASSES;
    public static final ResolutionStrategyEnum ENUM_LAZY_MEMBERS;
    public static final ResolutionStrategyEnum ENUM_IMMEDIATE;
    public static final /* synthetic */ ResolutionStrategyEnum[] ENUM_VALUES;

    static {
        ResolutionStrategyEnum resolutionStrategyEnumVar = new ResolutionStrategyEnum("LAZY_CLASSES", 0);
        ENUM_LAZY_CLASSES = resolutionStrategyEnumVar;
        ResolutionStrategyEnum resolutionStrategyEnumVar2 = new ResolutionStrategyEnum("LAZY_MEMBERS", 1);
        ENUM_LAZY_MEMBERS = resolutionStrategyEnumVar2;
        ResolutionStrategyEnum resolutionStrategyEnumVar3 = new ResolutionStrategyEnum("IMMEDIATE", 2);
        ENUM_IMMEDIATE = resolutionStrategyEnumVar3;
        ENUM_VALUES = new ResolutionStrategyEnum[]{resolutionStrategyEnumVar, resolutionStrategyEnumVar2, resolutionStrategyEnumVar3};
    }

    public static ResolutionStrategyEnum valueOf(String str) {
        return (ResolutionStrategyEnum) Enum.valueOf(ResolutionStrategyEnum.class, str);
    }

    public static ResolutionStrategyEnum[] values() {
        return (ResolutionStrategyEnum[]) ENUM_VALUES.clone();
    }
}
