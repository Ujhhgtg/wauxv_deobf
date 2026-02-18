package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsb implements btd {
    public static final bsb b = new bsb();
    public static final dfz d = dqc.aw("kotlinx.serialization.json.JsonElement", cuq.b, new dfx[0], new blx(24));

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        return cnb.n(ajtVar).bw();
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        brx brxVar = (brx) obj;
        throwIfVar1IsNull(brxVar, "value");
        cnb.l(avtVar);
        if (brxVar instanceof bsp) {
            avtVar.x(bsq.b, brxVar);
        } else if (brxVar instanceof bsl) {
            avtVar.x(bsn.b, brxVar);
        } else {
            if (!(brxVar instanceof brp)) {
                throw new QueryDidNotReturnUniqueResultRuntimeException();
            }
            avtVar.x(brr.b, brxVar);
        }
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
