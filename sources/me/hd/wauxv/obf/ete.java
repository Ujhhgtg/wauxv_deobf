package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ete extends doo implements bnm {
    public static final ete a = new ete(cnb.z(-589179318696746L));
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final epy j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c(cnb.z(-46699179408170L), cnb.z(-46677704571690L));
        c = cnb.z(-584991725583146L);
        h = cnb.z(-585008905452330L);
        i = cnb.z(-585459877018410L);
        j = new epy(2);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    public final List m() {
        return !z() ? avd.a : aba.ag(new bam(R.id.MenuItem_VideoNumber_CopyLink, cnb.z(-588483533994794L), R.drawable.ic_menu_copy_24dp, new dfq(13)), new bam(R.id.MenuItem_VideoNumber_Download, cnb.z(-588513598765866L), R.drawable.ic_menu_save_24dp, new dfq(14)));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
