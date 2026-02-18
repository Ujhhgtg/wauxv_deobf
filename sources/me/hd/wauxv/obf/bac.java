package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bac {
    public static final bac a;
    public static final /* synthetic */ bac[] b;

    static {
        bac bacVar = new bac("TOP_DOWN", 0);
        a = bacVar;
        b = new bac[]{bacVar, new bac("BOTTOM_UP", 1)};
    }

    public static bac valueOf(String str) {
        return (bac) Enum.valueOf(bac.class, str);
    }

    public static bac[] values() {
        return (bac[]) b.clone();
    }
}
