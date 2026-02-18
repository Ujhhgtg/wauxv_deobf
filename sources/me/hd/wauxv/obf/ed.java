package me.hd.wauxv.obf;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ed implements ahe {
    public final ahe a;
    public final float c;

    public ed(float f, ahe aheVar) {
        while (aheVar instanceof ed) {
            aheVar = ((ed) aheVar).a;
            f += ((ed) aheVar).c;
        }
        this.a = aheVar;
        this.c = f;
    }

    @Override // me.hd.wauxv.obf.ahe
    public final float b(RectF rectF) {
        return Math.max(0.0f, this.a.b(rectF) + this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        return this.a.equals(edVar.a) && this.c == edVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.c)});
    }
}
