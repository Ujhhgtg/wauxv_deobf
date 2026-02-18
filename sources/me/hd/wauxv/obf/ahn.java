package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahn {
    public static final ahn a;
    public static final ahn b;
    public static final ahn c;
    public static final ahn d;
    public static final ahn e;
    public static final /* synthetic */ ahn[] f;

    static {
        ahn ahnVar = new ahn("CPU_ACQUIRED", 0);
        a = ahnVar;
        ahn ahnVar2 = new ahn("BLOCKING", 1);
        b = ahnVar2;
        ahn ahnVar3 = new ahn("PARKING", 2);
        c = ahnVar3;
        ahn ahnVar4 = new ahn("DORMANT", 3);
        d = ahnVar4;
        ahn ahnVar5 = new ahn("TERMINATED", 4);
        e = ahnVar5;
        f = new ahn[]{ahnVar, ahnVar2, ahnVar3, ahnVar4, ahnVar5};
    }

    public static ahn valueOf(String str) {
        return (ahn) Enum.valueOf(ahn.class, str);
    }

    public static ahn[] values() {
        return (ahn[]) f.clone();
    }
}
