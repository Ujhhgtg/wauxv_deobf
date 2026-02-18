package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axq {
    public static final axq a;
    public static final axq b;
    public static final /* synthetic */ axq[] c;

    static {
        axq axqVar = new axq("EXPAND_DIRECTION_HORIZONTAL", 0);
        a = axqVar;
        axq axqVar2 = new axq("EXPAND_DIRECTION_VERTICAL", 1);
        b = axqVar2;
        c = new axq[]{axqVar, axqVar2};
    }

    public static axq valueOf(String str) {
        return (axq) Enum.valueOf(axq.class, str);
    }

    public static axq[] values() {
        return (axq[]) c.clone();
    }
}
