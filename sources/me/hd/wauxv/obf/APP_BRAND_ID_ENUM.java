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
public final class APP_BRAND_ID_ENUM {
    public static final APP_BRAND_ID_ENUM APP_BRAND_HOST_PKG_NAME;
    public static final APP_BRAND_ID_ENUM APP_BRAND_0;
    public static final APP_BRAND_ID_ENUM APP_BRAND_1;
    public static final APP_BRAND_ID_ENUM[] VALUES;
    public final String strValue;

    static {
        String strZ = "MAIN_PROCESS";
        APP_BRAND_ID_ENUM ewiVar = new APP_BRAND_ID_ENUM(strZ, 0, HostInfoRegistry.getPackageName());
        APP_BRAND_HOST_PKG_NAME = ewiVar;
        APP_BRAND_ID_ENUM ewiVar2 = new APP_BRAND_ID_ENUM("APP_BRAND_0" /* "APP_BRAND_0" /* "APP_BRAND_0" /* cnb.z(-18210661333802L)  */, 1, HostInfoRegistry.getPackageName().concat(":appbrand0" /* ":appbrand0" /* ":appbrand0" /* cnb.z(-18674517801770L)  */));
        APP_BRAND_0 = ewiVar2;
        APP_BRAND_ID_ENUM ewiVar3 = new APP_BRAND_ID_ENUM("APP_BRAND_1" /* "APP_BRAND_1" /* "APP_BRAND_1" /* cnb.z(-18644453030698L)  */, 2, HostInfoRegistry.getPackageName().concat(":appbrand1" /* ":appbrand1" /* ":appbrand1" /* cnb.z(-18558553684778L)  */));
        APP_BRAND_1 = ewiVar3;
        VALUES = new APP_BRAND_ID_ENUM[]{ewiVar, ewiVar2, ewiVar3, new APP_BRAND_ID_ENUM("APP_BRAND_2" /* "APP_BRAND_2" /* "APP_BRAND_2" /* cnb.z(-18545668782890L)  */, 3, HostInfoRegistry.getPackageName().concat(":appbrand2" /* ":appbrand2" /* ":appbrand2" /* cnb.z(-18459769436970L)  */)), new APP_BRAND_ID_ENUM("APP_BRAND_3" /* "APP_BRAND_3" /* "APP_BRAND_3" /* cnb.z(-18429704665898L)  */, 4, HostInfoRegistry.getPackageName().concat(":appbrand3" /* ":appbrand3" /* ":appbrand3" /* cnb.z(-17862768982826L)  */)), new APP_BRAND_ID_ENUM("APP_BRAND_4" /* "APP_BRAND_4" /* "APP_BRAND_4" /* cnb.z(-17781164604202L)  */, 5, HostInfoRegistry.getPackageName().concat(":appbrand4" /* ":appbrand4" /* ":appbrand4" /* cnb.z(-17763984735018L)  */))};
    }

    public APP_BRAND_ID_ENUM(String str, int i, String str2) {
        this.strValue = str2;
    }

    public static APP_BRAND_ID_ENUM valueOf(String str) {
        return (APP_BRAND_ID_ENUM) Enum.valueOf(APP_BRAND_ID_ENUM.class, str);
    }

    public static APP_BRAND_ID_ENUM[] values() {
        return (APP_BRAND_ID_ENUM[]) VALUES.clone();
    }
}
