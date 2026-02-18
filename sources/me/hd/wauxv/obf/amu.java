package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amu {
    public static final amu a;
    public static final /* synthetic */ amu[] b;

    /* JADX INFO: Fake field, exist only in values array */
    amu EF0;

    static {
        amu amuVar = new amu("NONE", 0);
        amu amuVar2 = new amu("LINE", 1);
        amu amuVar3 = new amu("DOUBLE_LINE", 2);
        amu amuVar4 = new amu("WAVY_LINE", 3);
        a = amuVar4;
        b = new amu[]{amuVar, amuVar2, amuVar3, amuVar4};
    }

    public static amu valueOf(String str) {
        return (amu) Enum.valueOf(amu.class, str);
    }

    public static amu[] values() {
        return (amu[]) b.clone();
    }
}
