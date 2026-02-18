package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkz {
    public static final bkz a = new bkz();
    public final boolean b = true;
    public final boolean c = true;

    public bkz() {
        if (aye.i("")) {
            return;
        }
        aye.i("");
    }

    public final void d(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("prefix = \"");
        sb.append("");
        sb.append("\",");
        sb.append('\n');
        sb.append(str);
        sb.append("suffix = \"");
        sb.append("");
        sb.append("\",");
        sb.append('\n');
        sb.append(str);
        sb.append("removeLeadingZeros = ");
        sb.append(false);
        sb.append(',');
        sb.append('\n');
        sb.append(str);
        sb.append("minLength = ");
        sb.append(1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NumberHexFormat(\n");
        d(sb, "    ");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
