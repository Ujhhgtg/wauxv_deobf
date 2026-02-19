package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HookPriorityEnum {
    public static final HookPriorityEnum ENUM_DEFAULT;
    public static final HookPriorityEnum ENUM_LOWEST;
    public static final HookPriorityEnum ENUM_HIGHEST;
    public static final /* synthetic */ HookPriorityEnum[] ENUM_VALUES;

    static {
        HookPriorityEnum hookPriorityEnumVar = new HookPriorityEnum("DEFAULT", 0);
        ENUM_DEFAULT = hookPriorityEnumVar;
        HookPriorityEnum hookPriorityEnumVar2 = new HookPriorityEnum("LOWEST", 1);
        ENUM_LOWEST = hookPriorityEnumVar2;
        HookPriorityEnum hookPriorityEnumVar3 = new HookPriorityEnum("HIGHEST", 2);
        ENUM_HIGHEST = hookPriorityEnumVar3;
        ENUM_VALUES = new HookPriorityEnum[]{hookPriorityEnumVar, hookPriorityEnumVar2, hookPriorityEnumVar3};
    }

    public static HookPriorityEnum valueOf(String str) {
        return (HookPriorityEnum) Enum.valueOf(HookPriorityEnum.class, str);
    }

    public static HookPriorityEnum[] values() {
        return (HookPriorityEnum[]) ENUM_VALUES.clone();
    }
}
