package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfr {
    public static final dfr a;
    public static final dfr b;
    public static final dfr c;
    public static final /* synthetic */ dfr[] d;

    static {
        dfr dfrVar = new dfr("LEFT_SELECTION", 0);
        a = dfrVar;
        dfr dfrVar2 = new dfr("RIGHT_SELECTION", 1);
        b = dfrVar2;
        dfr dfrVar3 = new dfr("SELECTION_ANCHOR", 2);
        c = dfrVar3;
        d = new dfr[]{dfrVar, dfrVar2, dfrVar3};
    }

    public static dfr valueOf(String str) {
        return (dfr) Enum.valueOf(dfr.class, str);
    }

    public static dfr[] values() {
        return (dfr[]) d.clone();
    }
}
