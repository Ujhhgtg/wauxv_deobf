package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cuy {
    public static final cuy a;
    public static final cuy b;
    public static final cuy c;
    public static final cuy d;
    public static final cuy e;
    public static final /* synthetic */ cuy[] f;

    static {
        cuy cuyVar = new cuy("CENTER", 0);
        a = cuyVar;
        cuy cuyVar2 = new cuy("TOP_LEFT", 1);
        b = cuyVar2;
        cuy cuyVar3 = new cuy("TOP_RIGHT", 2);
        c = cuyVar3;
        cuy cuyVar4 = new cuy("BOTTOM_LEFT", 3);
        d = cuyVar4;
        cuy cuyVar5 = new cuy("BOTTOM_RIGHT", 4);
        e = cuyVar5;
        f = new cuy[]{cuyVar, cuyVar2, cuyVar3, cuyVar4, cuyVar5};
    }

    public static cuy valueOf(String str) {
        return (cuy) Enum.valueOf(cuy.class, str);
    }

    public static cuy[] values() {
        return (cuy[]) f.clone();
    }
}
