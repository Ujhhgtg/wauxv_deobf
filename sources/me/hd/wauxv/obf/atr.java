package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class atr {
    public static final atr a;
    public static final atr b;
    public static final atr c;
    public static final atr d;
    public static final atr e;
    public static final atr f;
    public static final /* synthetic */ atr[] g;
    public static final /* synthetic */ KotlinEnumEntriesImpl h;
    public final int i;
    public final String j;

    static {
        atr atrVar = new atr("ONE" /* "ONE" /* "ONE" /* "ONE" /* cnb.z(-506612867398442L)   */, 0, 0, "一" /* "一" /* "一" /* "一" /* cnb.z(-506630047267626L)   */);
        a = atrVar;
        atr atrVar2 = new atr("TWO" /* "TWO" /* "TWO" /* "TWO" /* cnb.z(-506020161911594L)   */, 1, 1, "二" /* "二" /* "二" /* "二" /* cnb.z(-506037341780778L)   */);
        b = atrVar2;
        atr atrVar3 = new atr("THREE" /* "THREE" /* "THREE" /* "THREE" /* cnb.z(-506045931715370L)   */, 2, 2, "三" /* "三" /* "三" /* "三" /* cnb.z(-506002982042410L)   */);
        c = atrVar3;
        atr atrVar4 = new atr("FOUR" /* "FOUR" /* "FOUR" /* "FOUR" /* cnb.z(-506011571977002L)   */, 3, 3, "四" /* "四" /* "四" /* "四" /* cnb.z(-505972917271338L)   */);
        d = atrVar4;
        atr atrVar5 = new atr("FIVE" /* "FIVE" /* "FIVE" /* "FIVE" /* cnb.z(-505981507205930L)   */, 4, 4, "五" /* "五" /* "五" /* "五" /* cnb.z(-505925672631082L)   */);
        e = atrVar5;
        atr atrVar6 = new atr("SIX" /* "SIX" /* "SIX" /* "SIX" /* cnb.z(-505934262565674L)   */, 5, 5, "六" /* "六" /* "六" /* "六" /* cnb.z(-505882722958122L)   */);
        f = atrVar6;
        atr[] atrVarArr = {atrVar, atrVar2, atrVar3, atrVar4, atrVar5, atrVar6};
        g = atrVarArr;
        h = new KotlinEnumEntriesImpl(atrVarArr);
    }

    public atr(String str, int i, int i2, String str2) {
        this.i = i2;
        this.j = str2;
    }

    public static atr valueOf(String str) {
        return (atr) Enum.valueOf(atr.class, str);
    }

    public static atr[] values() {
        return (atr[]) g.clone();
    }
}
