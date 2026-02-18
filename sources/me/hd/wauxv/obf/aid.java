package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aid {
    public static final aid a;
    public static final aid b;
    public static final aid c;
    public static final /* synthetic */ aid[] d;
    public static final /* synthetic */ awn e;
    public final int f;

    static {
        aid aidVar = new aid("SUB" /* cnb.z(-422560357415722L) */, 0, -1);
        a = aidVar;
        aid aidVar2 = new aid("DEFAULT" /* cnb.z(-422577537284906L) */, 1, 0);
        b = aidVar2;
        aid aidVar3 = new aid("ADD" /* cnb.z(-422543177546538L) */, 2, 1);
        c = aidVar3;
        aid[] aidVarArr = {aidVar, aidVar2, aidVar3};
        d = aidVarArr;
        e = new awn(aidVarArr);
    }

    public aid(String str, int i, int i2) {
        this.f = i2;
    }

    public static aid valueOf(String str) {
        return (aid) Enum.valueOf(aid.class, str);
    }

    public static aid[] values() {
        return (aid[]) d.clone();
    }
}
