package me.hd.wauxv.obf;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aah {
    public static final za a = new za(1);
    public static final za b = new za(2);
    public int c;
    public int d;
    public int e;
    public int f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aah.class == obj.getClass()) {
            aah aahVar = (aah) obj;
            if (this.c == aahVar.c && this.d == aahVar.d && this.e == aahVar.e && this.f == aahVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Boolean.FALSE);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BlockLine{startLine=");
        sb.append(this.c);
        sb.append(", startColumn=");
        sb.append(this.d);
        sb.append(", endLine=");
        sb.append(this.e);
        sb.append(", endColumn=");
        return yg.m(sb, ", toBottomOfEndLine=false}", this.f);
    }
}
