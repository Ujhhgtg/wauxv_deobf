package me.hd.wauxv.obf;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aap {
    public static final SparseArray a = new SparseArray();
    public final String d;
    public int c = 0;
    public int b = 0;

    static {
        for (ekj ekjVar : ekj.values()) {
            char c = ekjVar.r;
            if (c != 0) {
                a.put(c, ekjVar);
            }
        }
    }

    public aap(String str) {
        this.d = str;
    }

    public static boolean e(char c) {
        if (c < 'a' || c > 'z') {
            return (c >= 'A' && c <= 'Z') || c == '_';
        }
        return true;
    }

    public final adh f() {
        ekj ekjVar;
        int i = this.b + this.c;
        this.b = i;
        this.c = 0;
        String str = this.d;
        if (i >= str.length()) {
            ekjVar = ekj.EOF;
        } else {
            char cCharAt = str.charAt(this.b);
            SparseArray sparseArray = a;
            ekj ekjVar2 = (ekj) sparseArray.get(cCharAt);
            if (ekjVar2 != null) {
                this.c = 1;
                ekjVar = ekjVar2;
            } else if (Character.isDigit(cCharAt)) {
                this.c = 1;
                while (this.b + this.c < str.length() && Character.isDigit(str.charAt(this.b + this.c))) {
                    this.c++;
                }
                ekjVar = ekj.Int;
            } else if (e(cCharAt)) {
                this.c = 1;
                while (this.b + this.c < str.length()) {
                    char cCharAt2 = str.charAt(this.b + this.c);
                    if (!e(cCharAt2) && !Character.isDigit(cCharAt2)) {
                        break;
                    }
                    this.c++;
                }
                ekjVar = ekj.VariableName;
            } else {
                while (this.b + this.c < str.length() && !Character.isDigit(cCharAt) && !e(cCharAt) && sparseArray.get(cCharAt) == null) {
                    int i2 = this.c + 1;
                    this.c = i2;
                    if (this.b + i2 < str.length()) {
                        cCharAt = str.charAt(this.b + this.c);
                    }
                }
                ekjVar = ekj.Format;
            }
        }
        int i3 = this.b;
        int i4 = this.c;
        adh adhVar = new adh();
        adhVar.b = i3;
        adhVar.c = i4;
        adhVar.d = ekjVar;
        return adhVar;
    }
}
