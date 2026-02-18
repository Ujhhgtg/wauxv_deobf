package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exg {
    public static final exg a;
    public static final exg b;
    public static final exg c;
    public static final /* synthetic */ exg[] d;

    static {
        exg exgVar = new exg("DEFAULT", 0);
        a = exgVar;
        exg exgVar2 = new exg("LOWEST", 1);
        b = exgVar2;
        exg exgVar3 = new exg("HIGHEST", 2);
        c = exgVar3;
        d = new exg[]{exgVar, exgVar2, exgVar3};
    }

    public static exg valueOf(String str) {
        return (exg) Enum.valueOf(exg.class, str);
    }

    public static exg[] values() {
        return (exg[]) d.clone();
    }
}
