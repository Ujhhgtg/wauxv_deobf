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
public final class eom {
    public static final eom a;
    public static final eom b;
    public static final eom c;
    public static final eom d;
    public static final /* synthetic */ eom[] e;
    public final int f;

    static {
        String strZ = cnb.z(-115749368625962L);
        cnb.z(-121740848003882L);
        eom eomVar = new eom(strZ, 0, 2);
        a = eomVar;
        String strZ2 = cnb.z(-121770912774954L);
        cnb.z(-121715078200106L);
        eom eomVar2 = new eom(strZ2, 1, 4);
        b = eomVar2;
        String strZ3 = cnb.z(-121736553036586L);
        cnb.z(-121693603363626L);
        eom eomVar3 = new eom(strZ3, 2, 5);
        String strZ4 = cnb.z(-121697898330922L);
        cnb.z(-121654948657962L);
        eom eomVar4 = new eom(strZ4, 3, 6);
        String strZ5 = cnb.z(-121607704017706L);
        cnb.z(-121611998985002L);
        eom eomVar5 = new eom(strZ5, 4, 9);
        String strZ6 = cnb.z(-121633473821482L);
        cnb.z(-121590524148522L);
        eom eomVar6 = new eom(strZ6, 5, 42);
        c = eomVar6;
        String strZ7 = cnb.z(-121538984540970L);
        cnb.z(-121556164410154L);
        eom eomVar7 = new eom(strZ7, 6, 12290);
        String strZ8 = cnb.z(-121560459377450L);
        cnb.z(-121521804671786L);
        eom eomVar8 = new eom(strZ8, 7, 12291);
        d = eomVar8;
        String strZ9 = cnb.z(-121526099639082L);
        cnb.z(-122037200747306L);
        eom eomVar9 = new eom(strZ9, 8, 12292);
        String strZ10 = cnb.z(-122041495714602L);
        cnb.z(-121951301401386L);
        e = new eom[]{eomVar, eomVar2, eomVar3, eomVar4, eomVar5, eomVar6, eomVar7, eomVar8, eomVar9, new eom(strZ10, 9, 12293)};
    }

    public eom(String str, int i, int i2) {
        this.f = i2;
    }

    public static eom valueOf(String str) {
        return (eom) Enum.valueOf(eom.class, str);
    }

    public static eom[] values() {
        return (eom[]) e.clone();
    }
}
