package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwp {
    public static final cwp a;
    public static final cwp b;
    public static final cwp c;
    public static final cwp d;
    public static final cwp e;
    public static final /* synthetic */ cwp[] f;

    static {
        cwp cwpVar = new cwp("ACCEPTABLE", 0);
        a = cwpVar;
        cwp cwpVar2 = new cwp("OPTIONAL", 1);
        b = cwpVar2;
        cwp cwpVar3 = new cwp("COLLECTION", 2);
        c = cwpVar3;
        cwp cwpVar4 = new cwp("LIST_ELEMENT", 3);
        d = cwpVar4;
        cwp cwpVar5 = new cwp("NOT_NULL", 4);
        e = cwpVar5;
        f = new cwp[]{cwpVar, cwpVar2, cwpVar3, cwpVar4, cwpVar5};
    }

    public static cwp valueOf(String str) {
        return (cwp) Enum.valueOf(cwp.class, str);
    }

    public static cwp[] values() {
        return (cwp[]) f.clone();
    }
}
