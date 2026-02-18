package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsq implements btd {
    public static final bsq b = new bsq();
    public static final dfz d = dqc.ax("kotlinx.serialization.json.JsonPrimitive", cvm.s, new dfx[0]);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        brx brxVarBw = cnb.n(ajtVar).bw();
        if (brxVarBw instanceof bsp) {
            return (bsp) brxVarBw;
        }
        throw cnd.ak(-1, "Unexpected JSON element, expected JsonPrimitive, had " + dal.b(brxVarBw.getClass()),
                brxVarBw.toString());
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bsp bspVar = (bsp) obj;
        throwIfVar1IsNull(bspVar, "value");
        cnb.l(avtVar);
        if (bspVar instanceof bsi) {
            avtVar.x(bsj.b, bsi.INSTANCE);
        } else {
            avtVar.x(bsg.b, (bsf) bspVar);
        }
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
