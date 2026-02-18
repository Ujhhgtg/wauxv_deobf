package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bis {
    public static final bis a;
    public static final /* synthetic */ bis[] b;
    public static final /* synthetic */ awn c;
    public final String d;
    public final String e;

    static {
        bis bisVar = new bis(cnb.z(-568765339138858L), 0, cnb.z(-568782519008042L), cnb.z(-568786813975338L));
        a = bisVar;
        bis bisVar2 = new bis(cnb.z(-568730979400490L), 1, cnb.z(-568756749204266L), cnb.z(-592331824692010L));
        String strZ = cnb.z(-592516508285738L);
        String strZ2 = cnb.z(-592469263645482L);
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-592490738481962L));
        bis[] bisVarArr = {bisVar, bisVar2, new bis(strZ, 2, strZ2, yg.n(sb, biw.b, -593392681614122L)), new bis(cnb.z(-593268127562538L), 3, cnb.z(-593246652726058L), cnb.z(-593250947693354L))};
        b = bisVarArr;
        c = new awn(bisVarArr);
    }

    public bis(String str, int i, String str2, String str3) {
        this.d = str2;
        this.e = str3;
    }

    public static bis valueOf(String str) {
        return (bis) Enum.valueOf(bis.class, str);
    }

    public static bis[] values() {
        return (bis[]) b.clone();
    }
}
