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
public final class dfs {
    public static final dfs a;
    public static final dfs b;
    public static final dfs c;
    public static final dfs d;
    public static final dfs e;
    public static final dfs f;
    public static final dfs g;
    public static final dfs h;
    public static final dfs i;
    public static final dfs j;
    public static final dfs k;
    public static final dfs l;
    public static final dfs m;
    public static final dfs n;
    public static final dfs o;
    public static final dfs p;
    public static final /* synthetic */ dfs[] q;
    public final bgj r;
    public final dfr s;

    static {
        cbk cbkVar = new cbk(22);
        dfr dfrVar = dfr.a;
        dfs dfsVar = new dfs("UP", 0, cbkVar, dfrVar);
        a = dfsVar;
        dfq dfqVar = new dfq(5);
        dfr dfrVar2 = dfr.b;
        dfs dfsVar2 = new dfs("DOWN", 1, dfqVar, dfrVar2);
        b = dfsVar2;
        dfs dfsVar3 = new dfs("LEFT", 2, new dfq(6), dfrVar);
        c = dfsVar3;
        dfs dfsVar4 = new dfs("RIGHT", 3, new dfq(7), dfrVar2);
        d = dfsVar4;
        dfs dfsVar5 = new dfs(4, "PREVIOUS_WORD_BOUNDARY", new cbk(23));
        e = dfsVar5;
        dfs dfsVar6 = new dfs(5, "NEXT_WORD_BOUNDARY", new cbk(24));
        f = dfsVar6;
        dfs dfsVar7 = new dfs(6, "PAGE_UP", new cbk(25));
        g = dfsVar7;
        dfs dfsVar8 = new dfs(7, "PAGE_DOWN", new cbk(26));
        h = dfsVar8;
        dfs dfsVar9 = new dfs(8, "PAGE_TOP", new cbk(27));
        i = dfsVar9;
        dfs dfsVar10 = new dfs(9, "PAGE_BOTTOM", new cbk(28));
        j = dfsVar10;
        dfs dfsVar11 = new dfs(10, "LINE_START", new cbk(29));
        k = dfsVar11;
        dfs dfsVar12 = new dfs(11, "LINE_END", new dfq(0));
        l = dfsVar12;
        dfs dfsVar13 = new dfs(12, "TEXT_START", new dfq(1));
        m = dfsVar13;
        dfs dfsVar14 = new dfs(13, "TEXT_END", new dfq(2));
        n = dfsVar14;
        dfs dfsVar15 = new dfs(14, "ROW_START", new dfq(3));
        o = dfsVar15;
        dfs dfsVar16 = new dfs(15, "ROW_END", new dfq(4));
        p = dfsVar16;
        q = new dfs[]{dfsVar, dfsVar2, dfsVar3, dfsVar4, dfsVar5, dfsVar6, dfsVar7, dfsVar8, dfsVar9, dfsVar10, dfsVar11, dfsVar12, dfsVar13, dfsVar14, dfsVar15, dfsVar16};
    }

    public dfs(String str, int i2, bgj bgjVar, dfr dfrVar) {
        this.r = bgjVar;
        this.s = dfrVar;
    }

    public static dfs valueOf(String str) {
        return (dfs) Enum.valueOf(dfs.class, str);
    }

    public static dfs[] values() {
        return (dfs[]) q.clone();
    }

    public /* synthetic */ dfs(int i2, String str, bgj bgjVar) {
        this(str, i2, bgjVar, dfr.c);
    }
}
