package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HookScopeEnum {
    public static final HookScopeEnum ZYGOTE;
    public static final HookScopeEnum PACKAGE;
    public static final HookScopeEnum RESOURCES;
    public static final /* synthetic */ HookScopeEnum[] VALUES;

    static {
        HookScopeEnum hookScopeEnumVar = new HookScopeEnum("ZYGOTE", 0);
        ZYGOTE = hookScopeEnumVar;
        HookScopeEnum hookScopeEnumVar2 = new HookScopeEnum("PACKAGE", 1);
        PACKAGE = hookScopeEnumVar2;
        HookScopeEnum hookScopeEnumVar3 = new HookScopeEnum("RESOURCES", 2);
        RESOURCES = hookScopeEnumVar3;
        VALUES = new HookScopeEnum[]{hookScopeEnumVar, hookScopeEnumVar2, hookScopeEnumVar3};
    }

    public static HookScopeEnum valueOf(String str) {
        return (HookScopeEnum) Enum.valueOf(HookScopeEnum.class, str);
    }

    public static HookScopeEnum[] values() {
        return (HookScopeEnum[]) VALUES.clone();
    }
}
