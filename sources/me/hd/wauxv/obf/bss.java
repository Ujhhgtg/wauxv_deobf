package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bss extends dcw implements bgk {
    public int a;
    public /* synthetic */ ajx d;
    public final /* synthetic */ ek e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bss(ek ekVar, afw afwVar) {
        super(3, afwVar);
        this.e = ekVar;
    }

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        bss bssVar = new bss(this.e, (afw) obj3);
        bssVar.d = (ajx) obj;
        return bssVar.i(ens.a);
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        ek ekVar = this.e;
        yi yiVar = (yi) ekVar.d;
        ajx ajxVar = this.d;
        int i = this.a;
        if (i == 0) {
            bhu.bd(obj);
            byte bAe = yiVar.ae();
            if (bAe == 1) {
                return ekVar.o(true);
            }
            if (bAe == 0) {
                return ekVar.o(false);
            }
            if (bAe != 6) {
                if (bAe == 8) {
                    return ekVar.n();
                }
                yi.g(yiVar, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.d = null;
            this.a = 1;
            obj = ek.e(ekVar, ajxVar, this);
            ahq ahqVar = ahq.a;
            if (obj == ahqVar) {
                return ahqVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bhu.bd(obj);
        }
        return (brx) obj;
    }
}
