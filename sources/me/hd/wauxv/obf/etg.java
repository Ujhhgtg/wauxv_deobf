package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etg extends doo implements bnl {
    public static final etg a = new etg(cnb.z(-610456586681130L));
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final epy j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c(cnb.z(-46699179408170L), cnb.z(-46677704571690L));
        c = cnb.z(-607372800162602L);
        h = cnb.z(-607321260555050L);
        i = cnb.z(-607308375653162L);
        j = new epy(3);
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
        return !z() ? avd.a : aba.ag(new bai(R.id.MenuItem_VideoNumber_CopyLink, cnb.z(-610332032629546L), R.drawable.ic_menu_copy_24dp, new dfq(15)), new bai(R.id.MenuItem_VideoNumber_Download, cnb.z(-610276198054698L), R.drawable.ic_menu_save_24dp, new dfq(16)));
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
