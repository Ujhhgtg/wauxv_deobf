package me.hd.wauxv.obf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF262' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:343)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class abu {
    public static final abu a;
    public static final abu b;
    public static final abu c;
    public static final /* synthetic */ abu[] d;
    public final int e;
    public final long f;
    public final String g;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF1;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF2;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF3;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF4;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF5;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF6;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF7;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF8;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF9;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF10;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF12;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF13;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF14;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF253;

    /* JADX INFO: Fake field, exist only in values array */
    abu EF262;

    static {
        abu abuVar = new abu(0, 0, 4289443517L, "Identifier");
        a = abuVar;
        abu abuVar2 = new abu(1, 0, 4289443517L, "Text");
        abu abuVar3 = new abu(2, 1, 4294226622L, "Method");
        abu abuVar4 = new abu(3, 2, 4294226622L, "Function");
        abu abuVar5 = new abu(4, 3, 4294226622L, "Constructor");
        abu abuVar6 = new abu(5, 4, 4294035587L, "Field");
        abu abuVar7 = new abu(6, 5, 4294035587L, "Variable");
        abu abuVar8 = new abu(7, 6, 4286958821L, "Class");
        abu abuVar9 = new abu(8, 7, 4288269191L, "Interface");
        abu abuVar10 = new abu(9, 8, 4286958821L, "Module");
        abu abuVar11 = new abu(10, 9, 4291738868L, "Property");
        abu abuVar12 = new abu("Unit", 11, 10);
        abu abuVar13 = new abu(12, 11, 4294035587L, "Value");
        abu abuVar14 = new abu(13, 12, 4286958821L, "Enum");
        abu abuVar15 = new abu(14, 13, 4291590194L, "Keyword");
        b = abuVar15;
        abu abuVar16 = new abu("Snippet", 15, 14);
        c = abuVar16;
        int i = 17;
        int i2 = 18;
        int i3 = 19;
        int i4 = 26;
        d = new abu[]{abuVar, abuVar2, abuVar3, abuVar4, abuVar5, abuVar6, abuVar7, abuVar8, abuVar9, abuVar10, abuVar11, abuVar12, abuVar13, abuVar14, abuVar15, abuVar16, new abu(16, 15, 4294226622L, "Color"), new abu("Reference", i, i), new abu("File", i2, 16), new abu("Folder", i3, i2), new abu("EnumMember", 20, i3), new abu(21, 20, 4294035587L, "Constant"), new abu(22, 21, 4291738868L, "Struct"), new abu("Event", 23, 22), new abu(24, 23, 4293569462L, "Operator"), new abu(25, 24, 4294035587L, "TypeParameter"), new abu("User", i4, 25), new abu("Issue", 27, i4)};
    }

    public abu(int i, int i2, long j, String str) {
        this.e = i2;
        this.f = j;
        this.g = String.valueOf(name().charAt(0));
    }

    public static abu valueOf(String str) {
        return (abu) Enum.valueOf(abu.class, str);
    }

    public static abu[] values() {
        return (abu[]) d.clone();
    }

    public /* synthetic */ abu(String str, int i, int i2) {
        this(i, i2, 0L, str);
    }
}
