package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewp {
    public static final ewp a;
    public static final /* synthetic */ ewp[] b;

    /* JADX INFO: Fake field, exist only in values array */
    ewp EF0;

    static {
        ewp ewpVar = new ewp("LOGD", 0);
        ewp ewpVar2 = new ewp("XPOSED_ENVIRONMENT", 1);
        ewp ewpVar3 = new ewp("SCOPE", 2);
        ewp ewpVar4 = new ewp("BOTH", 3);
        a = ewpVar4;
        b = new ewp[]{ewpVar, ewpVar2, ewpVar3, ewpVar4};
    }

    public static ewp valueOf(String str) {
        return (ewp) Enum.valueOf(ewp.class, str);
    }

    public static ewp[] values() {
        return (ewp[]) b.clone();
    }
}
