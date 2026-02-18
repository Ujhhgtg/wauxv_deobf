package me.hd.wauxv.obf;

import java.text.CharacterIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class uh implements CharacterIterator {
    public final CharSequence a;
    public int b;

    public uh(CharSequence charSequence) {
        this.a = charSequence;
    }

    @Override // java.text.CharacterIterator
    public final Object clone() {
        uh uhVar = new uh(this.a);
        uhVar.b = this.b;
        return uhVar;
    }

    @Override // java.text.CharacterIterator
    public final char current() {
        int i = this.b;
        CharSequence charSequence = this.a;
        if (i == charSequence.length()) {
            return (char) 65535;
        }
        return charSequence.charAt(this.b);
    }

    @Override // java.text.CharacterIterator
    public final char first() {
        this.b = 0;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final int getBeginIndex() {
        return 0;
    }

    @Override // java.text.CharacterIterator
    public final int getEndIndex() {
        return this.a.length();
    }

    @Override // java.text.CharacterIterator
    public final int getIndex() {
        return this.b;
    }

    @Override // java.text.CharacterIterator
    public final char last() {
        int length = this.a.length() - 1;
        this.b = length;
        if (length < 0) {
            this.b = 0;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char next() {
        this.b++;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char previous() {
        int i = this.b - 1;
        this.b = i;
        if (i < 0) {
            this.b = 0;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    public final char setIndex(int i) {
        this.b = i;
        return current();
    }
}
