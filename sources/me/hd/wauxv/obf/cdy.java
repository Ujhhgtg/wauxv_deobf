package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdy {
    public static final cbm a;
    public static final cdy b;
    public static final cdy c;
    public static final cdy d;
    public static final cdy e;
    public static final /* synthetic */ cdy[] f;
    public static final /* synthetic */ awn g;
    public final int h;

    static {
        cdy cdyVar = new cdy("PUBLIC", 0, 1);
        b = cdyVar;
        cdy cdyVar2 = new cdy("PRIVATE", 1, 2);
        cdy cdyVar3 = new cdy("PROTECTED", 2, 4);
        cdy cdyVar4 = new cdy("STATIC", 3, 8);
        c = cdyVar4;
        cdy cdyVar5 = new cdy("FINAL", 4, 16);
        d = cdyVar5;
        cdy cdyVar6 = new cdy("SYNCHRONIZED", 5, 32);
        cdy cdyVar7 = new cdy("VOLATILE", 6, 64);
        cdy cdyVar8 = new cdy("TRANSIENT", 7, 128);
        cdy cdyVar9 = new cdy("NATIVE", 8, 256);
        e = cdyVar9;
        cdy[] cdyVarArr = {cdyVar, cdyVar2, cdyVar3, cdyVar4, cdyVar5, cdyVar6, cdyVar7, cdyVar8, cdyVar9, new cdy("INTERFACE", 9, 512), new cdy("ABSTRACT", 10, 1024), new cdy("STRICT", 11, 2048)};
        f = cdyVarArr;
        g = new awn(cdyVarArr);
        a = new cbm(1);
    }

    public cdy(String str, int i, int i2) {
        this.h = i2;
    }

    public static cdy valueOf(String str) {
        return (cdy) Enum.valueOf(cdy.class, str);
    }

    public static cdy[] values() {
        return (cdy[]) f.clone();
    }
}
