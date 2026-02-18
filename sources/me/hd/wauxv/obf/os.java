package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class os {
    public static final byte[] a = new byte[1792];
    public final CharSequence b;
    public final int c;
    public int d;
    public char e;

    static {
        for (int i = 0; i < 1792; i++) {
            a[i] = Character.getDirectionality(i);
        }
    }

    public os(CharSequence charSequence) {
        this.b = charSequence;
        this.c = charSequence.length();
    }

    public final byte f() {
        int i = this.d - 1;
        CharSequence charSequence = this.b;
        char cCharAt = charSequence.charAt(i);
        this.e = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.d);
            this.d -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.d--;
        char c = this.e;
        return c < 1792 ? a[c] : Character.getDirectionality(c);
    }
}
