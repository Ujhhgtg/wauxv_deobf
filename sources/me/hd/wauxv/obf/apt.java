package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class apt implements elc {
    public final elc b;
    public final boolean c;

    public apt(elc elcVar, boolean z) {
        this.b = elcVar;
        this.c = z;
    }

    @Override // me.hd.wauxv.obf.elc
    public final dcg a(Context context, dcg dcgVar, int i, int i2) {
        oz ozVar = com.bumptech.glide.a.j(context).c;
        Drawable drawable = (Drawable) dcgVar.get();
        pa paVarO = cnh.o(ozVar, drawable, i, i2);
        if (paVarO != null) {
            dcg dcgVarA = this.b.a(context, paVarO, i, i2);
            if (!dcgVarA.equals(paVarO)) {
                return new pa(context.getResources(), dcgVarA);
            }
            dcgVarA.c();
            return dcgVar;
        }
        if (!this.c) {
            return dcgVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        this.b.d(messageDigest);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof apt) {
            return this.b.equals(((apt) obj).b);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return this.b.hashCode();
    }
}
