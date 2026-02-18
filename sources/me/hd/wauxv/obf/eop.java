package me.hd.wauxv.obf;

import java.time.Duration;
import java.time.Instant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eop extends bws {
    public static final eop a = new eop();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i = drv.a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        eon eonVar = eon.a;
        long jL = eonVar.l();
        if (jL == 0) {
            eoo.a.r(1);
            eonVar.s(jCurrentTimeMillis);
        } else if (Duration.between(Instant.ofEpochMilli(jL), Instant.ofEpochMilli(jCurrentTimeMillis)).toDays() >= 1) {
            eoo eooVar = eoo.a;
            eooVar.r(eooVar.k() + 1);
            eonVar.s(jCurrentTimeMillis);
        }
    }
}
