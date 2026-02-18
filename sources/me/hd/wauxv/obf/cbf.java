package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbf {
    public static final cbf a;
    public static final cbf b;
    public static final cbf c;
    public static final /* synthetic */ cbf[] d;

    static {
        cbf cbfVar = new cbf("NO", 0);
        a = cbfVar;
        cbf cbfVar2 = new cbf("NOTICE", 1);
        b = cbfVar2;
        cbf cbfVar3 = new cbf("SILENT", 2);
        c = cbfVar3;
        d = new cbf[]{cbfVar, cbfVar2, cbfVar3};
    }

    public static cbf valueOf(String str) {
        return (cbf) Enum.valueOf(cbf.class, str);
    }

    public static cbf[] values() {
        return (cbf[]) d.clone();
    }
}
