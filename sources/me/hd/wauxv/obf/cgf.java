package me.hd.wauxv.obf;

import android.database.Cursor;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgf extends bws {
    public static final cgf a = new cgf();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = bte.a;
        cge.a.getClass();
        cde cdeVarT = dqc.bh(emn.az(cgd.a)).t();
        cdeVarT.ab = "convertFrom" /* cnb.z(-66662187399978L) */;
        cdeVarT.z(Arrays.copyOf(new Object[]{dal.b(Cursor.class)}, 1));
        cdeVarT.ah();
        aki akiVarAd = ad((cdk) aaz.e(cdeVarT.aj()), exg.a);
        akiVarAd.m(new bzk(22));
        akiVarAd.o();
    }
}
