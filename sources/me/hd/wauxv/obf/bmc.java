package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmc {
    public static final bmc a;
    public static final bmc b;
    public static final /* synthetic */ bmc[] c;

    static {
        bmc bmcVar = new bmc("ROVO89_XPOSED", 0);
        a = bmcVar;
        bmc bmcVar2 = new bmc("UNKNOWN", 1);
        b = bmcVar2;
        c = new bmc[]{bmcVar, bmcVar2};
    }

    public static bmc valueOf(String str) {
        return (bmc) Enum.valueOf(bmc.class, str);
    }

    public static bmc[] values() {
        return (bmc[]) c.clone();
    }
}
