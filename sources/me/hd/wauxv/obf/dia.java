package me.hd.wauxv.obf;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dia implements cut {
    public final byf a;
    public int b;
    public Bitmap.Config c;

    public dia(byf byfVar) {
        this.a = byfVar;
    }

    @Override // me.hd.wauxv.obf.cut
    public final void d() {
        this.a.i(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof dia) {
            dia diaVar = (dia) obj;
            if (this.b == diaVar.b && eot.e(this.c, diaVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b * 31;
        Bitmap.Config config = this.c;
        return i + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return dib.i(this.b, this.c);
    }
}
