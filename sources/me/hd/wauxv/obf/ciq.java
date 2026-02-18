package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ciq {
    public final cio a;
    public final cjg b;
    public final Bundle c;
    public buh d;
    public final ciy e;
    public final String f;
    public final Bundle g;
    public final but h;
    public boolean i;
    public final bur j;
    public buh k;

    public ciq(cio cioVar) {
        this.a = cioVar;
        this.b = cioVar.b;
        this.c = cioVar.c;
        this.d = cioVar.d;
        this.e = cioVar.e;
        this.f = cioVar.f;
        this.g = cioVar.g;
        this.h = new but(new deo(cioVar, new cfx(cioVar, 12)), 10);
        dov dovVar = new dov(new cfh(10));
        this.j = new bur(cioVar);
        this.k = buh.b;
        new dov(new cfh(11));
    }

    public final Bundle l() {
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundleR = bht.r((csm[]) Arrays.copyOf(new csm[0], 0));
        bundleR.putAll(bundle);
        return bundleR;
    }

    public final void m() {
        if (!this.i) {
            but butVar = this.h;
            ((deo) butVar.b).i();
            this.i = true;
            if (this.e != null) {
                aye.r(this.a);
            }
            butVar.aa(this.g);
        }
        int iOrdinal = this.d.ordinal();
        int iOrdinal2 = this.k.ordinal();
        bur burVar = this.j;
        if (iOrdinal < iOrdinal2) {
            burVar.p(this.d);
        } else {
            burVar.p(this.k);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dal.b(cio.class).d());
        sb.append("(" + this.f + ')');
        sb.append(" destination=");
        sb.append(this.b);
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }
}
