package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdu {
    public final btj a;
    public final List b;
    public final ajb c;

    public cdu(btj btjVar, ajb ajbVar) {
        List list = Collections.EMPTY_LIST;
        cmz.n(btjVar, "Argument must not be null");
        this.a = btjVar;
        cmz.n(list, "Argument must not be null");
        this.b = list;
        cmz.n(ajbVar, "Argument must not be null");
        this.c = ajbVar;
    }
}
