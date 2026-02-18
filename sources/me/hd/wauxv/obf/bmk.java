package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmk {
    public static final bmk a;
    public static final bmk b;
    public static final bmk c;
    public static final /* synthetic */ bmk[] d;

    static {
        bmk bmkVar = new bmk("ZYGOTE", 0);
        a = bmkVar;
        bmk bmkVar2 = new bmk("PACKAGE", 1);
        b = bmkVar2;
        bmk bmkVar3 = new bmk("RESOURCES", 2);
        c = bmkVar3;
        d = new bmk[]{bmkVar, bmkVar2, bmkVar3};
    }

    public static bmk valueOf(String str) {
        return (bmk) Enum.valueOf(bmk.class, str);
    }

    public static bmk[] values() {
        return (bmk[]) d.clone();
    }
}
