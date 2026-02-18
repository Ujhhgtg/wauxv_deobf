package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajo {
    public static final ajo a;
    public static final ajo b;
    public static final ajo c;
    public static final /* synthetic */ ajo[] d;

    static {
        ajo ajoVar = new ajo("PREFER_ARGB_8888", 0);
        a = ajoVar;
        ajo ajoVar2 = new ajo("PREFER_RGB_565", 1);
        b = ajoVar2;
        d = new ajo[]{ajoVar, ajoVar2};
        c = ajoVar;
    }

    public static ajo valueOf(String str) {
        return (ajo) Enum.valueOf(ajo.class, str);
    }

    public static ajo[] values() {
        return (ajo[]) d.clone();
    }
}
