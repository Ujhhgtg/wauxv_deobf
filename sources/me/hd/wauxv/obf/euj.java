package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euj extends bws {
    public static final euj a = new euj();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        if (cnb.ab(ewk.o) || cnb.ac(ewh.r)) {
            int i = 0;
            cde cdeVarT = yg.s(-57896159148842L).t();
            cdeVarT.ab = "onCreate" /* "onCreate" /* "onCreate" /* cnb.z(-58119497448234L)  */;
            aki akiVarAd = a.ad((MethodHookWrapper) dkz.n(new Object[] { dal.b(Bundle.class) }, 1, cdeVarT), exg.b);
            akiVarAd.m(new epy(15));
            akiVarAd.o();
        }
    }
}
