package me.hd.wauxv.obf;

import android.view.ViewGroup;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zr extends doo implements bnn {
    public static final zr a = new zr(cnb.z(-523535038544682L));
    public static final String b = cnb.z(-525411939253034L);
    public static final String c = cnb.z(-525416234220330L);
    public static final String d = cnb.z(-525377579514666L);
    public static final ws h = new ws(24);
    public static final boolean i = true;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i2 = bte.a;
        aki akiVarAd = ad((cdk) dkz.n(new Object[]{dal.b(Integer.TYPE), dal.b(ViewGroup.class)}, 2, dqc.bh(ajn.ag(cnb.z(-523419074427690L))).t()), exg.a);
        a.x(akiVarAd, new ws(25));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnn
    public final List j() {
        return (z() && zp.a.i()) ? dqc.bf(new bly(R.id.MenuItem_Home_ClearAllUnRead, cnb.z(-523805621484330L), R.drawable.ic_menu_clear_24dp, new h(25))) : avd.a;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return i;
    }
}
