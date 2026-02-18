package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class btx {
    public static final btx a;
    public static final btx b;
    public static final /* synthetic */ btx[] c;

    /* JADX INFO: Fake field, exist only in values array */
    btx EF0;

    static {
        btx btxVar = new btx("SYNCHRONIZED", 0);
        btx btxVar2 = new btx("PUBLICATION", 1);
        a = btxVar2;
        btx btxVar3 = new btx("NONE", 2);
        b = btxVar3;
        c = new btx[]{btxVar, btxVar2, btxVar3};
    }

    public static btx valueOf(String str) {
        return (btx) Enum.valueOf(btx.class, str);
    }

    public static btx[] values() {
        return (btx[]) c.clone();
    }
}
