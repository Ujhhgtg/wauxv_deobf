package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessModifierEnum {
    public static final cbm a;
    public static final AccessModifierEnum PUBLIC;
    public static final AccessModifierEnum STATIC;
    public static final AccessModifierEnum FINAL;
    public static final AccessModifierEnum NATIVE;
    public static final /* synthetic */ AccessModifierEnum[] VALUES;
    public static final /* synthetic */ KotlinEnumEntriesImpl ENUM_ENTRIES;
    public final int mask;

    static {
        AccessModifierEnum accessModifierEnumVar = new AccessModifierEnum("PUBLIC", 0, 1);
        PUBLIC = accessModifierEnumVar;
        AccessModifierEnum accessModifierEnumVar2 = new AccessModifierEnum("PRIVATE", 1, 2);
        AccessModifierEnum accessModifierEnumVar3 = new AccessModifierEnum("PROTECTED", 2, 4);
        AccessModifierEnum accessModifierEnumVar4 = new AccessModifierEnum("STATIC", 3, 8);
        STATIC = accessModifierEnumVar4;
        AccessModifierEnum accessModifierEnumVar5 = new AccessModifierEnum("FINAL", 4, 16);
        FINAL = accessModifierEnumVar5;
        AccessModifierEnum accessModifierEnumVar6 = new AccessModifierEnum("SYNCHRONIZED", 5, 32);
        AccessModifierEnum accessModifierEnumVar7 = new AccessModifierEnum("VOLATILE", 6, 64);
        AccessModifierEnum accessModifierEnumVar8 = new AccessModifierEnum("TRANSIENT", 7, 128);
        AccessModifierEnum accessModifierEnumVar9 = new AccessModifierEnum("NATIVE", 8, 256);
        NATIVE = accessModifierEnumVar9;
        AccessModifierEnum[] accessModifierEnumVarArr = {accessModifierEnumVar, accessModifierEnumVar2, accessModifierEnumVar3, accessModifierEnumVar4, accessModifierEnumVar5, accessModifierEnumVar6, accessModifierEnumVar7, accessModifierEnumVar8, accessModifierEnumVar9, new AccessModifierEnum("INTERFACE", 9, 512), new AccessModifierEnum("ABSTRACT", 10, 1024), new AccessModifierEnum("STRICT", 11, 2048)};
        VALUES = accessModifierEnumVarArr;
        ENUM_ENTRIES = new KotlinEnumEntriesImpl(accessModifierEnumVarArr);
        a = new cbm(1);
    }

    public AccessModifierEnum(String str, int i, int i2) {
        this.mask = i2;
    }

    public static AccessModifierEnum valueOf(String str) {
        return (AccessModifierEnum) Enum.valueOf(AccessModifierEnum.class, str);
    }

    public static AccessModifierEnum[] values() {
        return (AccessModifierEnum[]) VALUES.clone();
    }
}
