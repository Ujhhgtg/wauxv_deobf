package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahb {
    public static final ahb a;
    public static final ahb b;
    public static final /* synthetic */ ahb[] c;

    static {
        ahb ahbVar = new ahb("BULLET", 0);
        a = ahbVar;
        ahb ahbVar2 = new ahb("ORDERED", 1);
        b = ahbVar2;
        c = new ahb[]{ahbVar, ahbVar2};
    }

    public static ahb valueOf(String str) {
        return (ahb) Enum.valueOf(ahb.class, str);
    }

    public static ahb[] values() {
        return (ahb[]) c.clone();
    }
}
