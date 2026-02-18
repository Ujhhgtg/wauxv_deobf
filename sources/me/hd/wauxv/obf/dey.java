package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dey {
    public final int[] a;
    public final int[] b;
    public final int[][] c;
    public final int[][] d;
    public final int[][] e;

    public dey() {
        int[] iArr = new int[64];
        int[] iArr2 = new int[64];
        int[][] iArr3 = new int[32][];
        for (int i = 0; i < 32; i++) {
            iArr3[i] = new int[32];
        }
        int[][] iArr4 = new int[32][];
        for (int i2 = 0; i2 < 32; i2++) {
            iArr4[i2] = new int[32];
        }
        int[][] iArr5 = new int[32][];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr5[i3] = new int[32];
        }
        this.a = iArr;
        this.b = iArr2;
        this.c = iArr3;
        this.d = iArr4;
        this.e = iArr5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!dey.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        throwIfVar1IsNull(obj, "null cannot be cast to non-null type io.github.rosemoe.sora.lang.completion.Scratch");
        dey deyVar = (dey) obj;
        return Arrays.equals(this.a, deyVar.a) && Arrays.equals(this.b, deyVar.b) && la._ai(this.c, deyVar.c)
                && la._ai(this.d, deyVar.d) && la._ai(this.e, deyVar.e);
    }

    public final int hashCode() {
        return Arrays.deepHashCode(this.e) + ((Arrays.deepHashCode(this.d)
                + ((Arrays.deepHashCode(this.c) + ((Arrays.hashCode(this.b) + (Arrays.hashCode(this.a) * 31)) * 31))
                        * 31))
                * 31);
    }

    public final String toString() {
        String string = Arrays.toString(this.a);
        String string2 = Arrays.toString(this.b);
        String string3 = Arrays.toString(this.c);
        String string4 = Arrays.toString(this.d);
        String string5 = Arrays.toString(this.e);
        StringBuilder sb = new StringBuilder("Scratch(minWordMatchPosArray=");
        sb.append(string);
        sb.append(", maxWordMatchPosArray=");
        sb.append(string2);
        sb.append(", diag=");
        sb.append(string3);
        sb.append(", table=");
        sb.append(string4);
        sb.append(", arrows=");
        return yg.o(sb, string5, ")");
    }
}
