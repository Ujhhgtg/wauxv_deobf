package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdn {
    public static final cdn a;
    public static final cdn b;
    public static final cdn c;
    public static final /* synthetic */ cdn[] d;
    public static final /* synthetic */ awn e;
    public final int f;
    public final int g;

    static {
        cdn cdnVar = new cdn(cnb.z(-517371760474922L), 0, 0, 4);
        a = cdnVar;
        cdn cdnVar2 = new cdn(cnb.z(-517354580605738L), 1, 1, 34);
        b = cdnVar2;
        cdn cdnVar3 = new cdn(cnb.z(-517805552171818L), 2, 4, 37);
        c = cdnVar3;
        cdn[] cdnVarArr = {cdnVar, cdnVar2, cdnVar3};
        d = cdnVarArr;
        e = new awn(cdnVarArr);
    }

    public cdn(String str, int i, int i2, int i3) {
        this.f = i2;
        this.g = i3;
    }

    public static cdn valueOf(String str) {
        return (cdn) Enum.valueOf(cdn.class, str);
    }

    public static cdn[] values() {
        return (cdn[]) d.clone();
    }
}
