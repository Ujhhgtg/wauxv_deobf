package me.hd.wauxv.obf;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dqt implements CharSequence {
    public final CharSequence b;
    public final int c;
    public final int d;
    public arn e;

    public dqt(int i, int i2, CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        this.b = charSequence;
        this.c = i;
        this.d = i2;
        if (i > i2) {
            throw new IllegalArgumentException("start > end");
        }
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 > charSequence.length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        f();
        return this.b.charAt(this.c + i);
    }

    public final void f() {
        arn arnVar = this.e;
        if (arnVar != null) {
            if (arnVar.g.c != arnVar.e || arnVar.f) {
                throw new abs();
            }
        }
    }

    @Override // java.lang.CharSequence
    public final int length() {
        f();
        return this.d - this.c;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 >= length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        f();
        int i3 = this.c;
        dqt dqtVar = new dqt(i + i3, i3 + i2, this.b);
        dqtVar.e = this.e;
        return dqtVar;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.b.subSequence(this.c, this.d).toString();
    }
}
