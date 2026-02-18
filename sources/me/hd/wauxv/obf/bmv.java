package me.hd.wauxv.obf;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmv implements cdv {
    public static final cru a = cru.f(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");
    public final bmu b;

    public bmv(bmu bmuVar) {
        this.b = bmuVar;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final /* bridge */ /* synthetic */ boolean d(Object obj) {
        return true;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        bid bidVar = (bid) obj;
        bmu bmuVar = this.b;
        if (bmuVar != null) {
            cds cdsVar = (cds) bmuVar.h;
            cdt cdtVarC = cdt.c(bidVar);
            Object objD = cdsVar.d(cdtVarC);
            ArrayDeque arrayDeque = cdt.a;
            synchronized (arrayDeque) {
                arrayDeque.offer(cdtVarC);
            }
            bid bidVar2 = (bid) objD;
            if (bidVar2 == null) {
                cdsVar.g(cdt.c(bidVar), bidVar);
            } else {
                bidVar = bidVar2;
            }
        }
        return new cdu(bidVar, new bmw(bidVar, ((Integer) crwVar.b(a)).intValue()));
    }
}
