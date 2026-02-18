package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhc implements elc {
    public final elc b;

    public bhc(elc elcVar) {
        cmz.n(elcVar, "Argument must not be null");
        this.b = elcVar;
    }

    @Override // me.hd.wauxv.obf.elc
    public final dcg a(Context context, dcg dcgVar, int i, int i2) {
        bha bhaVar = (bha) dcgVar.get();
        dcg paVar = new pa(((bhh) bhaVar.a.b).l, com.bumptech.glide.a.j(context).c);
        elc elcVar = this.b;
        dcg dcgVarA = elcVar.a(context, paVar, i, i2);
        if (!paVar.equals(dcgVarA)) {
            paVar.c();
        }
        ((bhh) bhaVar.a.b).s(elcVar, (Bitmap) dcgVarA.get());
        return dcgVar;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        this.b.d(messageDigest);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof bhc) {
            return this.b.equals(((bhc) obj).b);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        return this.b.hashCode();
    }
}
