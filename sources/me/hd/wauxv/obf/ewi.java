package me.hd.wauxv.obf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewi {
    public static final ewi a;
    public static final ewi b;
    public static final ewi c;
    public static final /* synthetic */ ewi[] d;
    public final String e;

    static {
        String strZ = cnb.z(-18214956301098L);
        bmo.a.getClass();
        ewi ewiVar = new ewi(strZ, 0, bmo.p());
        a = ewiVar;
        ewi ewiVar2 = new ewi(cnb.z(-18210661333802L), 1, bmo.p().concat(cnb.z(-18674517801770L)));
        b = ewiVar2;
        ewi ewiVar3 = new ewi(cnb.z(-18644453030698L), 2, bmo.p().concat(cnb.z(-18558553684778L)));
        c = ewiVar3;
        d = new ewi[]{ewiVar, ewiVar2, ewiVar3, new ewi(cnb.z(-18545668782890L), 3, bmo.p().concat(cnb.z(-18459769436970L))), new ewi(cnb.z(-18429704665898L), 4, bmo.p().concat(cnb.z(-17862768982826L))), new ewi(cnb.z(-17781164604202L), 5, bmo.p().concat(cnb.z(-17763984735018L)))};
    }

    public ewi(String str, int i, String str2) {
        this.e = str2;
    }

    public static ewi valueOf(String str) {
        return (ewi) Enum.valueOf(ewi.class, str);
    }

    public static ewi[] values() {
        return (ewi[]) d.clone();
    }
}
