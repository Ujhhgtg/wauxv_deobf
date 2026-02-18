package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yy {
    public static final yy a;
    public static final yy b;
    public static final /* synthetic */ yy[] c;

    static {
        yy yyVar = new yy("NONE", 0);
        a = yyVar;
        yy yyVar2 = new yy("ALL_JSON_OBJECTS", 1);
        yy yyVar3 = new yy("POLYMORPHIC", 2);
        b = yyVar3;
        c = new yy[]{yyVar, yyVar2, yyVar3};
    }

    public static yy valueOf(String str) {
        return (yy) Enum.valueOf(yy.class, str);
    }

    public static yy[] values() {
        return (yy[]) c.clone();
    }
}
