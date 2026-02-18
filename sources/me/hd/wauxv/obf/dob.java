package me.hd.wauxv.obf;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dob extends brm {
    public final boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dob() {
        super(true);
        boolean z = true;
        ae(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = brm.s;
        ye yeVar = (ye) atomicReferenceFieldUpdater.get(this);
        yf yfVar = yeVar instanceof yf ? (yf) yeVar : null;
        if (yfVar == null) {
            z = false;
            break;
        }
        brm brmVarH = yfVar.h();
        while (!brmVarH.ab()) {
            ye yeVar2 = (ye) atomicReferenceFieldUpdater.get(brmVarH);
            yf yfVar2 = yeVar2 instanceof yf ? (yf) yeVar2 : null;
            if (yfVar2 == null) {
                z = false;
                break;
            }
            brmVarH = yfVar2.h();
        }
        this.a = z;
    }

    @Override // me.hd.wauxv.obf.brm
    public final boolean ab() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.brm
    public final boolean x(Throwable th) {
        return false;
    }
}
