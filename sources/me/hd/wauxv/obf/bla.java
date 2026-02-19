package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bla {
    public static final bla a;
    public final boolean b;
    public final bky c;
    public final bkz d;

    static {
        bky bkyVar = bky.a;
        bkz bkzVar = bkz.a;
        a = new bla(false, bkyVar, bkzVar);
        new bla(true, bkyVar, bkzVar);
    }

    public bla(boolean z, bky bkyVar, bkz bkzVar) {
        throwIfVar1IsNull(bkyVar, "bytes");
        throwIfVar1IsNull(bkzVar, "number");
        this.b = z;
        this.c = bkyVar;
        this.d = bkzVar;
    }

    public final String toString() {
        StringBuilder sbY = StaticHelpers6.toSb("HexFormat(\n    upperCase = ");
        sbY.append(this.b);
        sbY.append(",\n    bytes = BytesHexFormat(\n");
        this.c.b(sbY, "        ");
        sbY.append('\n');
        sbY.append("    ),");
        sbY.append('\n');
        sbY.append("    number = NumberHexFormat(");
        sbY.append('\n');
        this.d.d(sbY, "        ");
        sbY.append('\n');
        sbY.append("    )");
        sbY.append('\n');
        sbY.append(")");
        return sbY.toString();
    }
}
