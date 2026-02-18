package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahs {
    public static final ahs a;
    public static final /* synthetic */ ahs[] b;

    static {
        ahs ahsVar = new ahs("DEFAULT", 0);
        a = ahsVar;
        b = new ahs[]{ahsVar, new ahs("LAZY", 1), new ahs("ATOMIC", 2), new ahs("UNDISPATCHED", 3)};
    }

    public static ahs valueOf(String str) {
        return (ahs) Enum.valueOf(ahs.class, str);
    }

    public static ahs[] values() {
        return (ahs[]) b.clone();
    }
}
