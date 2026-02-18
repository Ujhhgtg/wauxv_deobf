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
public final class aer {
    public static final aer a;
    public static final aer b;
    public static final /* synthetic */ aer[] c;
    public final String[] d;

    static {
        String strZ = cnb.z(-29661044144938L);
        cnb.z(-29626684406570L);
        aer aerVar = new aer(strZ, 0, new String[]{cnb.z(-29639569308458L), cnb.z(-29527900158762L), cnb.z(-29416231009066L), cnb.z(-28827820489514L), cnb.z(-28660316764970L)});
        a = aerVar;
        String strZ2 = cnb.z(-29132763167530L);
        cnb.z(-29102698396458L);
        aer aerVar2 = new aer(strZ2, 1, new String[]{cnb.z(-29046863821610L)});
        b = aerVar2;
        c = new aer[]{aerVar, aerVar2};
    }

    public aer(String str, int i, String[] strArr) {
        this.d = strArr;
    }

    public static aer valueOf(String str) {
        return (aer) Enum.valueOf(aer.class, str);
    }

    public static aer[] values() {
        return (aer[]) c.clone();
    }
}
