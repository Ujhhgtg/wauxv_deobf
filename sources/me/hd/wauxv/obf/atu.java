package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class atu {
    public static final atu a;
    public static final atu b;
    public static final atu c;
    public static final /* synthetic */ atu[] d;
    public static final /* synthetic */ awn e;
    public final int f;
    public final String g;

    static {
        atu atuVar = new atu("SCISSORS" /* cnb.z(-506209140472618L) */, 0, 0, "剪刀" /* cnb.z(-506187665636138L) */);
        a = atuVar;
        atu atuVar2 = new atu("STONE" /* cnb.z(-506123241126698L) */, 1, 1, "石头" /* cnb.z(-506149010930474L) */);
        b = atuVar2;
        atu atuVar3 = new atu("PAPER" /* cnb.z(-506101766290218L) */, 2, 2, "布" /* cnb.z(-506058816617258L) */);
        c = atuVar3;
        atu[] atuVarArr = {atuVar, atuVar2, atuVar3};
        d = atuVarArr;
        e = new awn(atuVarArr);
    }

    public atu(String str, int i, int i2, String str2) {
        this.f = i2;
        this.g = str2;
    }

    public static atu valueOf(String str) {
        return (atu) Enum.valueOf(atu.class, str);
    }

    public static atu[] values() {
        return (atu[]) d.clone();
    }
}
