package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exi {
    public static final exi a;
    public static final exi b;
    public static final exi c;
    public static final /* synthetic */ exi[] d;

    static {
        exi exiVar = new exi("LAZY_CLASSES", 0);
        a = exiVar;
        exi exiVar2 = new exi("LAZY_MEMBERS", 1);
        b = exiVar2;
        exi exiVar3 = new exi("IMMEDIATE", 2);
        c = exiVar3;
        d = new exi[]{exiVar, exiVar2, exiVar3};
    }

    public static exi valueOf(String str) {
        return (exi) Enum.valueOf(exi.class, str);
    }

    public static exi[] values() {
        return (exi[]) d.clone();
    }
}
