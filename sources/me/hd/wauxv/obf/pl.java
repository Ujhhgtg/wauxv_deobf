package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pl extends p {
    public final pj h = new pj();

    public static boolean i(aph aphVar, int i) {
        CharSequence charSequence = aphVar.c;
        return aphVar.i < 4 && i < charSequence.length() && charSequence.charAt(i) == '>';
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        char cCharAt;
        int i = aphVar.g;
        if (!i(aphVar, i)) {
            return null;
        }
        int i2 = aphVar.e + aphVar.i;
        int i3 = i2 + 1;
        CharSequence charSequence = aphVar.c;
        int i4 = i + 1;
        if (i4 < charSequence.length() && ((cCharAt = charSequence.charAt(i4)) == '\t' || cCharAt == ' ')) {
            i3 = i2 + 2;
        }
        return new pf(-1, i3, false);
    }
}
