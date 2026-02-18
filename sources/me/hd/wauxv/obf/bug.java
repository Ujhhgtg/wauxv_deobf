package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bug {
    private static final /* synthetic */ awm $ENTRIES;
    private static final /* synthetic */ bug[] $VALUES;
    public static final bue Companion;
    public static final bug ON_ANY;
    public static final bug ON_CREATE;
    public static final bug ON_DESTROY;
    public static final bug ON_PAUSE;
    public static final bug ON_RESUME;
    public static final bug ON_START;
    public static final bug ON_STOP;

    static {
        bug bugVar = new bug("ON_CREATE", 0);
        ON_CREATE = bugVar;
        bug bugVar2 = new bug("ON_START", 1);
        ON_START = bugVar2;
        bug bugVar3 = new bug("ON_RESUME", 2);
        ON_RESUME = bugVar3;
        bug bugVar4 = new bug("ON_PAUSE", 3);
        ON_PAUSE = bugVar4;
        bug bugVar5 = new bug("ON_STOP", 4);
        ON_STOP = bugVar5;
        bug bugVar6 = new bug("ON_DESTROY", 5);
        ON_DESTROY = bugVar6;
        bug bugVar7 = new bug("ON_ANY", 6);
        ON_ANY = bugVar7;
        bug[] bugVarArr = {bugVar, bugVar2, bugVar3, bugVar4, bugVar5, bugVar6, bugVar7};
        $VALUES = bugVarArr;
        $ENTRIES = new awn(bugVarArr);
        Companion = new bue();
    }

    public static bug valueOf(String str) {
        return (bug) Enum.valueOf(bug.class, str);
    }

    public static bug[] values() {
        return (bug[]) $VALUES.clone();
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
                throw new abt();
        }
    }
}
