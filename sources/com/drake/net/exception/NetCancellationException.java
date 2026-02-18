package com.drake.net.exception;

import java.util.concurrent.CancellationException;
import me.hd.wauxv.obf.ahp;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class NetCancellationException extends CancellationException {
    public /* synthetic */ NetCancellationException(ahp ahpVar, String str, int i, akd akdVar) {
        this(ahpVar, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetCancellationException(ahp ahpVar, String str) {
        super(str);
        bzo.q(ahpVar, "coroutineScope");
        cnf.ao(ahpVar.e()._w(arj.b));
    }
}
