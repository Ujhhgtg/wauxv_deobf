package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvq {
    public static final cvq a;
    public static final cvq b;
    public static final cvq c;
    public static final cvq d;
    public static final /* synthetic */ cvq[] e;

    static {
        cvq cvqVar = new cvq("IMMEDIATE", 0);
        a = cvqVar;
        cvq cvqVar2 = new cvq("HIGH", 1);
        b = cvqVar2;
        cvq cvqVar3 = new cvq("NORMAL", 2);
        c = cvqVar3;
        cvq cvqVar4 = new cvq("LOW", 3);
        d = cvqVar4;
        e = new cvq[]{cvqVar, cvqVar2, cvqVar3, cvqVar4};
    }

    public static cvq valueOf(String str) {
        return (cvq) Enum.valueOf(cvq.class, str);
    }

    public static cvq[] values() {
        return (cvq[]) e.clone();
    }
}
