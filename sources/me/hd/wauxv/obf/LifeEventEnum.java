package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class LifeEventEnum {
    private static final /* synthetic */ awm $ENTRIES;
    private static final /* synthetic */ LifeEventEnum[] $VALUES;
    public static final bue Companion;
    public static final LifeEventEnum ON_ANY;
    public static final LifeEventEnum ON_CREATE;
    public static final LifeEventEnum ON_DESTROY;
    public static final LifeEventEnum ON_PAUSE;
    public static final LifeEventEnum ON_RESUME;
    public static final LifeEventEnum ON_START;
    public static final LifeEventEnum ON_STOP;

    static {
        LifeEventEnum lifeEventEnumVar = new LifeEventEnum("ON_CREATE", 0);
        ON_CREATE = lifeEventEnumVar;
        LifeEventEnum lifeEventEnumVar2 = new LifeEventEnum("ON_START", 1);
        ON_START = lifeEventEnumVar2;
        LifeEventEnum lifeEventEnumVar3 = new LifeEventEnum("ON_RESUME", 2);
        ON_RESUME = lifeEventEnumVar3;
        LifeEventEnum lifeEventEnumVar4 = new LifeEventEnum("ON_PAUSE", 3);
        ON_PAUSE = lifeEventEnumVar4;
        LifeEventEnum lifeEventEnumVar5 = new LifeEventEnum("ON_STOP", 4);
        ON_STOP = lifeEventEnumVar5;
        LifeEventEnum lifeEventEnumVar6 = new LifeEventEnum("ON_DESTROY", 5);
        ON_DESTROY = lifeEventEnumVar6;
        LifeEventEnum lifeEventEnumVar7 = new LifeEventEnum("ON_ANY", 6);
        ON_ANY = lifeEventEnumVar7;
        LifeEventEnum[] lifeEventEnumVarArr = {lifeEventEnumVar, lifeEventEnumVar2, lifeEventEnumVar3, lifeEventEnumVar4, lifeEventEnumVar5, lifeEventEnumVar6, lifeEventEnumVar7};
        $VALUES = lifeEventEnumVarArr;
        $ENTRIES = new KotlinEnumEntriesImpl(lifeEventEnumVarArr);
        Companion = new bue();
    }

    public static LifeEventEnum valueOf(String str) {
        return (LifeEventEnum) Enum.valueOf(LifeEventEnum.class, str);
    }

    public static LifeEventEnum[] values() {
        return (LifeEventEnum[]) $VALUES.clone();
    }

    public final buh a() {
        switch (buf.a[ordinal()]) {
            case 1:
            case 2:
                return buh.c;
            case 3:
            case 4:
                return buh.d;
            case 5:
                return buh.e;
            case 6:
                return buh.a;
            case 7:
                throw new IllegalArgumentException(this + " has no target state");
            default:
                throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
    }
}
